package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.entities.Book;
import com.book.service.BookService;

@Controller
public class IndexController {
   @Autowired
   private BookService bookService;
   
    @GetMapping("/")
    public ModelAndView getList() {
        List<Book> bookList = this.bookService.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("bookList", bookList);
        return mv;
    }

}


//npm i bootstrap@5.3.7
//copiar links do bootstrap no index.html<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
//<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
//Incluir tables bootstrap no index.html


