package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @NotNull
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "type_of_book_id", referencedColumnName = "typeOfBookId")
    private TypeOfBook typeOfBook;
    @NotNull
    private int numberOfBooks;
    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public TypeOfBook getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(TypeOfBook typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
