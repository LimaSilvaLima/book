package com.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import com.book.entities.Author;
import com.book.service.AuthorService;

import jakarta.validation.Valid;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ModelAndView getList() {
        List<Author> authorList = authorService.getAllAuthors();
        
        /*for (Author author : authorList){
            System.out.println((author.getId()));
            System.out.println(author.getName());
            System.out.println(author.getEmail());
        }
        */
        ModelAndView mv = new ModelAndView("authors");
        mv.addObject("authorlist", authorList);
        return mv;
    }

    @GetMapping("/author/form/add")
    public ModelAndView getFormAdd() {
        ModelAndView mv = new ModelAndView("authorform");
        //mv.addObject("author", new Author());
        return mv;
    }

    @PostMapping("/author/form/save")
    public String save(@Valid Author author, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.author", result);
            redirectAttributes.addFlashAttribute("author", author);
            return "authorform"; // Return to the form if validation fails
        }
        this.authorService.save(author);
        return "redirect:/authors"; // Redirect to the list of authors after saving
    }

    @GetMapping("/authorEdit/{id}")
    public ModelAndView getFormEdit(@PathVariable("id") Long id) {
        Author author = this.authorService.findById(id);
        ModelAndView mv = new ModelAndView("authorform");
        mv.addObject("author", author);
        return mv;
    }


    @GetMapping("/authorDelete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.authorService.deleteById(id);
        return "redirect:/authors"; // Redirect to the list of authors after deletion
    }




}