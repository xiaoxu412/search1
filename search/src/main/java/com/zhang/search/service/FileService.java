package com.zhang.search.service;

import java.util.List;
import com.zhang.search.model.FileInfo;

public interface FileService {

    //插入
     int insertUrl(String filename,String localpath,String url);

    //查询
     List<FileInfo> selectFile();


}
