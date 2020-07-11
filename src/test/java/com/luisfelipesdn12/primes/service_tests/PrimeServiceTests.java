package com.luisfelipesdn12.primes.service_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import com.luisfelipesdn12.primes.exceptions.PrimePositionZeroOrNegativeException;
import com.luisfelipesdn12.primes.service.PrimeService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrimeServiceTests {

    PrimeService service = new PrimeService();

    @Test
    public void testIsPrime() {
        boolean twoIsPrime = service.isPrime(2);
        assertTrue(twoIsPrime);

        boolean tenIsPrime = service.isPrime(10);
        assertFalse(tenIsPrime);
    }

    @Test
    public void testNthPrime() {
        long FirstPrimeNumber = service.nthPrime(1);
        assertEquals(2, FirstPrimeNumber);
    }

    @Test
    public void testNthPrimeException() {
        try {
            long negativeNth = service.nthPrime(-1);
            fail("An exception were expected and don\'t was throwed");
        } catch (PrimePositionZeroOrNegativeException e) {
            assertEquals(
                PrimePositionZeroOrNegativeException.class, 
                e.getClass()
                );
        }
    }

    @Test
    public void testPrimesTill() {
        List<Long> primesTillTen = service.primesTill(10);
        List<Long> expectedPrimesTillTen = List.of(2L, 3L, 5L, 7L);
        assertEquals(expectedPrimesTillTen, primesTillTen);

        List<Long> primesTillNegativeTen = service
                            .primesTill(-10);
        assertTrue(primesTillNegativeTen.isEmpty());
    }
}