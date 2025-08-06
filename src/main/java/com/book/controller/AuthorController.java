package com.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.book.entities.Author;
import com.book.service.AuthorService;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ModelAndView getList() {
        List<Author> authorList = authorService.getAllAuthors();
        for (Author author : authorList){
            System.out.println((author.getId()));
            System.out.println(author.getName());
            System.out.println(author.getEmail());
        }
        ModelAndView mv = new ModelAndView("authors");
        mv.addObject("authorlist", authorList);
        return mv;
    }

}