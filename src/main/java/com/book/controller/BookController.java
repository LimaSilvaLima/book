package com.book.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;

import com.book.entities.Book;
import com.book.service.AuthorService;
import com.book.service.BookService;

import jakarta.validation.Valid;



@Controller
public class BookController {
    
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    
    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd() {
        ModelAndView mv = new ModelAndView("bookform");
        mv.addObject("authors", authorService.getAllAuthors());
        //mv.addObject("book", new Book());
        return mv;
    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
            return "redirect:/book/form/add"; // Redirect back to the form if there are errors
        }
        this.bookService.save(book);
        return "redirect:/"; // Redirect to the form after saving
    }


    

}
