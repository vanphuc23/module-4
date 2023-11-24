package com.example.picture_of_day_aop.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteException {
    private static final String FILE = "D:\\Codegym\\Codegym module 4\\ss9_AOP_&_ExceptionHandle\\exercises\\picture_of_day_aop\\src\\main\\java\\com\\example\\picture_of_day_aop\\data\\Exception.csv";
    public static void  writeException(String pictureException) {
        File file = new File(FILE);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write(pictureException);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
