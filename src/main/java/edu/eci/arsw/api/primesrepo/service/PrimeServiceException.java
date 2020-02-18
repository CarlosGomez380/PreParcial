package edu.eci.arsw.api.primesrepo.service;

public class PrimeServiceException extends Exception {

    public PrimeServiceException(String message){
        super(message);
    }

    public PrimeServiceException(String message,Throwable cause){
        super(message,cause);
    }
}
