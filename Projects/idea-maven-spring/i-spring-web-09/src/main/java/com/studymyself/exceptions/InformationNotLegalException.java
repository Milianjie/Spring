package com.studymyself.exceptions;

public class InformationNotLegalException extends RuntimeException{

    public InformationNotLegalException() {
        super();
    }

    public InformationNotLegalException(String message) {
        super(message);
    }
}
