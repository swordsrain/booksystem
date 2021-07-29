package com.tssf.controller;

import com.tssf.pojo.Books;
import com.tssf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    //查询全部书籍，名返回到一个书记展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);

        return "allBook";
    }

    @RequestMapping("/toAddBook")
    //跳转到增加书籍页面
    public String toAddPaper() {
        return "addBook";
    }


    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook->"+books);
        bookService.addBooks(books);
        return "redirect:/book/allBook";
    }


    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books books=bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        int i=bookService.updateBooks(books);
        if (i>0){
            System.out.println("添加books成功"+books);
        }
        List<Books> books1=bookService.queryAllBook();
        return "redirect:/book/allBook";
    }

    //删除数据
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";

    }
    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list=new ArrayList<Books>();
        list.add(books);

        if (books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到");

        }

        model.addAttribute("list", list);
        return "allBook";

    }


}