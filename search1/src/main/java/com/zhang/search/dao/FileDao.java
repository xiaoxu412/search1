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
    @Insert({"insert into files (filename,localpath,projectcode,createtime,updatetime) values (#{filename},#{localpath},#{projectCode},now(),now())"})
    public int insertFileInfo(@Param("filename")String filename,@Param("localpath")String localpath,@Param("projectCode")String projectCode);

    //查询
    @Select("select id,filename,localpath,projectCode,createtime,updatetime from files")
    List<FileInfo> selectFile();
}
