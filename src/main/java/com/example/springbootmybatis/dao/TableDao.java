package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.model.TableModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TableDao {
    List<String> getTableName(@Param("databaseName") String databaseName);

    List<TableModel> getTableDetail(@Param("databaseName")String databaseName , @Param("tableName") String tableName);
}
