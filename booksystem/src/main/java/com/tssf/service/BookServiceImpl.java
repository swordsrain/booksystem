package com.tssf.service;

import com.tssf.dao.BookMapper;
import com.tssf.pojo.Books;


import java.util.List;


public class BookServiceImpl implements BookService{

    //service调dao层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBooks(Books books) {
        return bookMapper.addBooks(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBooks(Books books) {
        return bookMapper.updateBooks(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
