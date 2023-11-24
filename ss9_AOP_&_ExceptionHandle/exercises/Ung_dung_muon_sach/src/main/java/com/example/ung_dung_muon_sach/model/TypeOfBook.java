package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class TypeOfBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeOfBookId;
    @NotNull
    private String typeOfBook;
    @OneToMany(mappedBy = "typeOfBook")
    @NotNull
    private List<Book> books;

    public TypeOfBook() {
    }

    public int getTypeOfBookId() {
        return typeOfBookId;
    }

    public void setTypeOfBookId(int typeOfBookId) {
        this.typeOfBookId = typeOfBookId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }
}
