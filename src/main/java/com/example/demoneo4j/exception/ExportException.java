package com.example.demoneo4j.exception;

public class ExportException extends RuntimeException {

    public ExportException(String msg){
        super(msg);
    }

    public ExportException(String msg, Throwable throwable){
        super(msg, throwable);
    }

}
