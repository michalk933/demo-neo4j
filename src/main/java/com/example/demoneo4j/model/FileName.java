package com.example.demoneo4j.model;

public enum FileName {

    USER_FILE_NAME("user.csv"),
    BOOK_FIEL_NAME("book.csv"),
    CATEGORY_FILE_NAME("category.csv");

    private String value;

    FileName(String value){
        this.value = value;
    }


}
