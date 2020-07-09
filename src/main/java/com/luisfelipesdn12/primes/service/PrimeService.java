package com.luisfelipesdn12.primes.service;

import java.util.ArrayList;
import java.util.List;

import com.luisfelipesdn12.primes.exceptions.PrimePositionZeroOrNegativeException;

import org.springframework.stereotype.Service;

@Service
public class PrimeService {

    public boolean isPrime(long n) {
        List<Long> primesTillN = primesTill(n);
        return primesTillN.contains(n);
    }

    public List<Long> primesTill(long limit) {
        List<Long> primos = new ArrayList<>();

        for (long n = 2; n <= limit; n++) {
            boolean add = true;

            for (long p: primos) {
                if (n % p == 0) {
                    add = false;
                    break;
                } 
            }

            if (add == true) {
                primos.add(n);
            }
        }

        return primos;
    }

    public List<Long> listOfNPrimes(long limit) {
        List<Long> primos = new ArrayList<>();

        for (long n = 2; primos.size() != limit; n++) {
            boolean add = true;

            for (long p: primos) {
                if (n % p == 0) {
                    add = false;
                    break;
                } 
            }

            if (add == true) {
                primos.add(n);
            }
        }

        return primos;
    }

	public long nthPrime(long nth) {
        if (nth > 0) {
            return listOfNPrimes(nth).get((int)nth-1);
        } else {
            throw new PrimePositionZeroOrNegativeException();
        }
	}
}