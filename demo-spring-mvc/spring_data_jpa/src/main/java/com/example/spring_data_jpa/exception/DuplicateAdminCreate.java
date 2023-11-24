package com.example.spring_data_jpa.exception;

public class DuplicateAdminCreate extends Exception{
    public DuplicateAdminCreate(String message) {
        super(message);
    }
}
