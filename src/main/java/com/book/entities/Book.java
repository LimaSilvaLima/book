package com.book.entities;



import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "book")
@Table(name = "book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Column(name = "name")
    private String name;
    private String isbn;
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    
    public Book(String name, String isbn, String description, Author author) {
        this.name = name;
        this.isbn = isbn;
        this.description = description;
        this.author = author;
    }   

}
