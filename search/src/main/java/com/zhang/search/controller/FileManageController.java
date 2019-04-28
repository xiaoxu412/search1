package com.zhang.search.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.zhang.search.model.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.zhang.search.service.impl.FileServiceImpl;


@Controller
public class FileManageController {

	@Autowired
    private FileServiceImpl fileService;
    private String  url;
    
    @Value("${upload.filePath}")
    private String filePath;
    
	/**
     **文件管理
     * @return
     */
    @RequestMapping("/fileManage")
    public ModelAndView fileManage(){
        ModelAndView mav = new ModelAndView("fileManage");
        List<FileInfo> list = fileService.selectFile();
        mav.getModelMap().addAttribute("files",list);
        return mav;
    }
    /**
     **初始化上传文件页面
     * @return
     */
    @RequestMapping("/initUploadFile")
    public ModelAndView initUploadFile(){
        ModelAndView mav = new ModelAndView("uploadFile");
        return mav;
    }
    @RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String uploadFile(@RequestParam("fileName") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) { return "上传文件不可为空"; }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" +  fileName.substring(fileName.lastIndexOf("\\")+1, fileName.length());
        //加个时间戳，尽量避免文件名称重复
        String path = filePath +fileName;
        //创建文件路径
        File dest = new File(path);
        //判断文件是否已经存在
        if (dest.exists()) { return "文件已经存在"; }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) { dest.getParentFile().mkdir(); }
        try {
            //上传文件
            file.transferTo(dest); //保存文件
            url="http://localhost:8080/files/"+fileName;
            int result= fileService.insertUrl(fileName,path,url);
        } catch (IOException e) {
        	e.printStackTrace();
            return "上传失败";
        }
        return "上传成功,文件url=="+url;

    }

}
