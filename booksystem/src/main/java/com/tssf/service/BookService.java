package com.tssf.service;

import com.tssf.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //增加
    int addBooks(Books books);

    //删除
    int deleteBookById(int id);

    //更新
    int updateBooks(Books books);

    //查询
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();


    Books queryBookByName(String bookName);




}
