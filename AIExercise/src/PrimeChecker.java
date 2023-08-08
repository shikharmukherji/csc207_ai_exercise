/**
 * The PrimeChecker class takes in input, runs both primality tests, and outputs their results.
 */
public class PrimeChecker {

    /**
     * Takes in the integer and provides text-output in the command line relating to
     * the primality of the integer, and the differences in the two tests used.
     * @param args The integer provided by the user in the Command Line.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PrimeChecker <number>");
            return;
        }

        try {
            int number = Integer.parseInt(args[0]); // Obtained from Command Line

            // Obtains different primality testers
            PrimalityTester naiveTester = new NaivePrimalityTester();
            PrimalityTester millerRabinTester = new MillerRabinPrimalityTester();

            long startTimeNaive = System.nanoTime();
            boolean isNaivePrime = naiveTester.isPrime(number);
            long endTimeNaive = System.nanoTime();
            long timeTakenNaive = endTimeNaive - startTimeNaive;

            long startTimeMillerRabin = System.nanoTime();
            boolean isMillerRabinPrime = millerRabinTester.isPrime(number);
            long endTimeMillerRabin = System.nanoTime();
            long timeTakenMillerRabin = endTimeMillerRabin - startTimeMillerRabin;

            System.out.println("Naive Prime Test Result: " + (isNaivePrime ? "Prime" : "Composite"));
            System.out.println("Time taken by Naive Prime Test: " + timeTakenNaive + " ns");

            System.out.println("Miller-Rabin Prime Test Result: " + (isMillerRabinPrime ? "Likely Prime" : "Composite"));
            System.out.println("Time taken by Miller-Rabin Prime Test: " + timeTakenMillerRabin + " ns");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide a valid integer.");
        }
    }
}
