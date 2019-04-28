package com.zhang.search.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zhang.search.dao.FileDao;
import com.zhang.search.model.FileInfo;

import java.util.List;
@Service
@Component
public class FileServiceImpl {

    @Autowired
    private FileDao fileDao;

    //插入
    public int insertUrl(String filename,String localpath,String projectCode){
        int result= fileDao.insertFileInfo(filename,localpath,projectCode);
        return result;
    }
    //查询
    public List<FileInfo> selectFile(){
        List<FileInfo> fileObjects = fileDao.selectFile();
        return fileObjects;
    }
}
