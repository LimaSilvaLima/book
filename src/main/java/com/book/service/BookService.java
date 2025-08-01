package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entities.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        this.bookRepository.save(book);
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public Object findById(Long id) {
        //return this.bookRepository.findById(id).orElse(null);
        return this.bookRepository.findById(id).get();
    }

}
