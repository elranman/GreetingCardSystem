package com.example.springboot.Elrandemo.exceptions;

public class GreetCardFileFormatNotSupportedException extends Exception{
    public GreetCardFileFormatNotSupportedException() {
        super();
    }

    public GreetCardFileFormatNotSupportedException(String message) {
        super(message);
    }

    public GreetCardFileFormatNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
