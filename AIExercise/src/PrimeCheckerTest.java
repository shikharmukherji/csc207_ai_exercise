import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeCheckerTest {

    @Test
    public void testNaivePrimalityTester() {
        PrimalityTester tester = new NaivePrimalityTester();

        assertTrue(tester.isPrime(2));
        assertTrue(tester.isPrime(3));
        assertTrue(tester.isPrime(17));
        assertTrue(tester.isPrime(101));

        assertFalse(tester.isPrime(-2));
        assertFalse(tester.isPrime(9));
        assertFalse(tester.isPrime(49));
        assertFalse(tester.isPrime(100));
    }

    @Test
    public void testMillerRabinPrimalityTester() {
        PrimalityTester tester = new MillerRabinPrimalityTester();

        assertTrue(tester.isPrime(2));
        assertTrue(tester.isPrime(3));
        assertTrue(tester.isPrime(17));
        assertTrue(tester.isPrime(101));

        assertFalse(tester.isPrime(-2));
        assertFalse(tester.isPrime(9));
        assertFalse(tester.isPrime(49));
        assertFalse(tester.isPrime(100));
    }

    @Test
    public void testLargePrimesAndComposites() {
        PrimalityTester tester = new MillerRabinPrimalityTester();

        assertTrue(tester.isPrime(7919));  // Prime
        assertTrue(tester.isPrime(8191));  // Prime
        assertTrue(tester.isPrime(10007)); // Prime

        assertFalse(tester.isPrime(10000)); // Composite
        assertFalse(tester.isPrime(12345)); // Composite
    }
}
