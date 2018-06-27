package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dao.TableDao;
import com.example.springbootmybatis.exception.AossRestException;
import com.example.springbootmybatis.model.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Service
public class MyCodeMakerService {

    @Autowired
    private TableDao tableDao;

    public boolean codeMake(String databaseName) throws Exception {
        List<String> tableNameList = tableDao.getTableName(databaseName);
        if(tableNameList == null || tableNameList.size() == 0){
            throw new AossRestException("数据库中没有找到表");
        }
        for(String tableName : tableNameList){
            writeXmlValue(tableName,databaseName);
            writeJavaValue(tableName,databaseName);
        }
        return false;
    }

    //写xml
    private void writeXmlValue(String tableName,String databaseName) throws Exception{
        File file = new File("C:\\Coding\\"+tableName+".xml");
        List<TableModel> tableModelList = tableDao.getTableDetail(databaseName,tableName);
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        bw.newLine();
        bw.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
        bw.newLine();
        bw.write("<mapper namespace=\""+tableName+"\">");
        bw.newLine();
        bw.write("    <resultMap id=\"detailMap\" type=\""+tableName+"\">");
        bw.newLine();
        String javaName = "";
        int flag = 0;
        for(TableModel tableModel : tableModelList){//字段名格式为_打底
            flag = 0;
            javaName = "";
            for(String test : tableModel.getFieldName().split("_")){
                if(flag == 0){
                    javaName += test;
                }else {
                    javaName += captureName(test);
                }
                flag++;
            }
            bw.write("        <result column=\""+tableModel.getFieldName()+"\" property=\""+javaName+"\"/>");
            bw.newLine();
        }
        bw.write("    </resultMap>");
        bw.newLine();
        bw.write("    <select id=\"findAll\" resultMap=\"detailMap\" >");
        bw.newLine();
        bw.write("        select * from "+tableName);
        bw.newLine();
        bw.write("    </select>");

        bw.newLine();
        bw.write("</mapper>");
        bw.flush();
        bw.close();
        fw.close();
    }

    //写java
    private void writeJavaValue(String tableName,String databaseName) throws Exception{
        File file = new File("C:\\Coding\\"+tableName+".java");
        List<TableModel> tableModelList = tableDao.getTableDetail(databaseName,tableName);
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);

        String javaName = "";
        int flag = 0;
        String type = "";
        for(TableModel tableModel : tableModelList){//字段名格式为_打底
            flag = 0;
            javaName = "";
            for(String test : tableModel.getFieldName().split("_")){
                if(flag == 0){
                    javaName += test;
                }else {
                    javaName += captureName(test);
                }
                flag++;
            }
            type = tableModel.getFieldType();
            if(type.equals("varchar") || type.equals("char") || type.equals("text")){
                bw.write("private String "+javaName);
            }else if (type.equals("int") || type.equals("integer") ){
                bw.write("private int "+javaName);
            }else if (type.equals("float") ){
                bw.write("private float "+javaName);
            }else if (type.equals("double") ){
                bw.write("private double "+javaName);
            }else if (type.equals("date") || type.equals("datetime") ){
                bw.write("private Date "+javaName);
            }else{
                bw.write("private XXXXXXXX "+javaName);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();
    }
    //首字母大写
    public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

}
