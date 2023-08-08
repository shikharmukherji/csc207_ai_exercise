/**
 * The MillerRabinPrimalityTester implements the PrimalityTester interface
 * and tests for primality by performing the Miller-Rabin primality test.
 * It is probabilistic, but fails with very low probability.
 */
public class MillerRabinPrimalityTester implements PrimalityTester {

    /**
     * Checks for primality with the Miller-Rabin test.
     * @param num The number to check for primality.
     * @return Whether num is prime or not, probabilistically.
     */
    @Override
    public boolean isPrime(int num) {
        // Miller-Rabin primality test implementation
        if (num <= 1) {
            return false;
        }

        if (num <= 3) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        int d = num - 1;
        int r = 0;
        while (d % 2 == 0) {
            d /= 2;
            r++;
        }

        int[] witnesses;
        if (num < 2047) {
            witnesses = new int[]{2};
        } else if (num < 1373653) {
            witnesses = new int[]{2, 3};
        } else if (num < 9080191) {
            witnesses = new int[]{31, 73};
        } else if (num < 25326001) {
            witnesses = new int[]{2, 3, 5};
        } else if (num < 3215031751L) {
            witnesses = new int[]{2, 3, 5, 7};
        } else {
            witnesses = new int[]{2, 3, 5, 7, 11};
        }

        for (int a : witnesses) {
            if (!millerRabinTest(num, d, r, a)) {
                return false;
            }
        }

        return true;
    }

    /**
     * A helper method for the Miller-Rabin test.
     * @param num The number to check for primality.
     * @param d The exponent.
     * @param r The number of iterations.
     * @param a The base.
     * @return A boolean relevant to the Miller-Rabin test.
     */
    private static boolean millerRabinTest(int num, int d, int r, int a) {
        int x = powerMod(a, d, num);

        if (x == 1 || x == num - 1) {
            return true;
        }

        for (int i = 0; i < r - 1; i++) {
            x = (x * x) % num;

            if (x == num - 1) {
                return true;
            }
        }

        return false;
    }


    /**
     * A helper method for the Miller-Rabin test.
     * @param base The base.
     * @param exponent The exponent.
     * @param modulus The modulus.
     * @return The base raised to the exponent, modulo the integer modulus.
     */
    private static int powerMod(int base, int exponent, int modulus) {
        int result = 1;
        base = base % modulus;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }

        return result;
    }

}