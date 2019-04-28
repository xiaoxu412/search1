package com.zhang.search.service.impl;

import com.zhang.search.model.FileInfo;
import com.zhang.search.service.FileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceImplTest {


    @Autowired
    private FileService fileService;
    @Test
    public void selectFile() {

        List<FileInfo> fileInfoList = fileService.selectFile();
        for (FileInfo fileInfo:fileInfoList){
            System.out.println(fileInfo.getId()+";"+fileInfo.getUrl());
        }

    }

}