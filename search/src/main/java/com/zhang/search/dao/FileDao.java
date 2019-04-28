package com.zhang.search.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.zhang.search.model.FileInfo;

@Mapper
@Component
public interface FileDao {

    //插入
    @Insert({"insert into files (filename,localpath,url,createtime,updatetime) values (#{filename},#{localpath},#{url},now(),now())"})
    public int insertUrl(@Param("filename")String filename,@Param("localpath")String localpath,@Param("url")String url);

    //查询
    @Select("select id,filename,localpath,url,createtime,updatetime from files")
    List<FileInfo> selectFile();
}
