Acts as a command-line-based primality test, and compares a naive primality test to an implementation of the Miller-Rabin primality test.

Uses JAVA 20, and JUnit for testing.

To compile, enter the src directory and in the command line, enter the command 'javac PrimeChecker.java'.
Then use the command 'java PrimeChecker 17' to check an integer of your choice [Replace 17 with whatever integer you please].

The code contains the divergent code smell, since the PrimeChecker class handles input, output, the timing mechanism, 
and does so for all (both) of the primality tests (so if we wanted to add more it would make things difficult).
