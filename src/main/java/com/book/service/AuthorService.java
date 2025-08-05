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

    public void save(Author author) {
        this.authorRepository.save(author);
    }
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

    public List<Author> getAuthorList() {
        return this.authorRepository.findAll();
    }


}
