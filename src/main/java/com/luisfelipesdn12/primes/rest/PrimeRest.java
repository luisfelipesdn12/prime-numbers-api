package com.luisfelipesdn12.primes.rest;

import java.util.List;

import com.luisfelipesdn12.primes.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeRest {

    @Autowired
    private PrimeService service;

    /** HOME **/
    @GetMapping("/")
    public String home() {
        return "<h2>The Prime Numbers API</h2> <h4>This API can return:</h4> <li>A list of all primes \'till n number (/allprimestill). <li>The nth prime number (/nthprime). <li>If a number is prime or not (/isprime).";
    }

    
    /** "/isprime" **/
    @GetMapping("/isprime")
    public String isPrimeHome() {
        return "<h4> Returns a true if a number is prime and false otherwise.</h4> <li><b>Use</b>: /isprime/{n} <br> <li><b>n</b>: The number to be tested.";
    } 

    @GetMapping("/isprime/{n}")
    public boolean isPrime(@PathVariable("n") final long n) {
        return service.isPrime(n);
    }

    /** "/allprimestill" **/
    @GetMapping("/allprimestill")
    public String allPrimesTillHome() {
        return "<h4>Returns a list with all the prime numbers \'till `n` number.</h4> <li><b>Use:</b> /allprimestill/{n}. <li><b>n:</b> The limit number of the list of prime numbers.";
    }

    @GetMapping("/allprimestill/{n}")
    public List<Long> allPrimesTill(@PathVariable("n") final long n) {
        return service.primesTill(n);
    }

    /** "/nthprime" **/
    @GetMapping("/nthprime")
    public String nthPrimeHome() {
        return "<h4>Return the nth prime number.</h4> <li><b>Use:</b> /nthprime/{nth}. <li><b>nth:</b> The position.";
    }

    @GetMapping("/nthprime/{nth}")
    public long nthPrime(@PathVariable("nth") final long nth) {
        return service.nthPrime(nth);
    }
}