package com.tssf.dao;

import com.tssf.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加
    int addBooks(Books books);

    //删除
    int deleteBookById(@Param("bookId") int id);

    //更新
    int updateBooks(Books books);

    //查询
    Books queryBookById(@Param("bookId")int id);

    //查询全部的书
    List<Books> queryAllBook();



    Books queryBookByName(@Param("bookName")String bookName);



}
