package com.jhenriquedsm.parcerias_serpro.exceptions;

public class ParceriaAlreadyExistsException extends RuntimeException{
    public ParceriaAlreadyExistsException(String message) {
        super(message);
    }
}
