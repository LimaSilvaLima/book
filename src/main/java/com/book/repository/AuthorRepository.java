package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Additional query methods can be defined here if needed

}
