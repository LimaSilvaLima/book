package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.book.entities.Author;
import com.book.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {

        Iterable <Author> authors = authorRepository.findAll();
        return Streamable.of(authors).toList();

    }
}


/*  public List<Author> getAllAuthors() {
        // Logic to retrieve all authors
        return List.of(); // Placeholder for actual implementation
    }
*/

/*
 Streamable.of(authors).forEach(author -> {
            // You can add any additional processing for each author here if needed
});
 */