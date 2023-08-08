/**
 * The NaivePrimalityTester implements the PrimalityTester interface
 * and tests for primality by performing trial division on all integers
 * upto the square root of the provided number. It is deterministic.
 */
public class NaivePrimalityTester implements PrimalityTester {

    /**
     * Checks for primality naively.
     * @param num The integer to check for primality.
     * @return Whether num is prime or not.
     */
    @Override
    public boolean isPrime(int num) {
        // Naive trial division implementation
        if (num <= 1) {
            return false;
        }

        // Checks if any integers upto its square root divide evenly into num
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}