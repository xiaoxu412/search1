package com.zhang.search.service;

import java.util.List;

import com.zhang.search.model.FileInfo;

public interface FileService {

    //插入
    public int insertUrl(String filename,String localpath,String url);
    public List<FileInfo> selectFile();
}
