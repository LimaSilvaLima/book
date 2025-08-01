package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Additional query methods can be defined here if needed

    //Converter o List de fiindAll para Iterable<Book>
    /*@Override
    Iterable<Book> findAll();
    */
}
