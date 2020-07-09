package com.luisfelipesdn12.primes.rest;

import com.luisfelipesdn12.primes.exceptions.PrimePositionZeroOrNegativeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PrimeControllerAdvice {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PrimePositionZeroOrNegativeException.class)
    public void InvalidPrimePosition() {
        
    }
}