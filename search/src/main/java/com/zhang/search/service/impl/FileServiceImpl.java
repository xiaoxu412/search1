package com.zhang.search.service.impl;

import com.zhang.search.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.zhang.search.dao.FileDao;
import com.zhang.search.model.FileInfo;

import java.util.List;
@Service
@Component
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    //插入
    @Override
    public int insertUrl(String filename,String localpath,String url){
        System.out.print("开始插入=filename=="+filename+"\n");
        System.out.print("开始插入=localpath=="+localpath+"\n");
        System.out.print("开始插入=url=="+url+"\n");
        int result= fileDao.insertUrl(filename,localpath,url);
        System.out.print("插入结果==="+result+"\n");
        return result;
    }
    //查询
    @Override
    public List<FileInfo> selectFile(){
            return fileDao.selectFile();
    }
}
