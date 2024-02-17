package com.promineotech;

import java.util.Random;

public class TestDemo {

	/*
	 * Method is taking 2 parameters 'a' and 'b' and is checking if either 'a' or 'b' is less than or equal to zero. 
	 * It will throw the illegalargumentexception if either of them are not positive with the below message. If both are positive then the 
	 * method will proceed to add them. 
	 */
	 public int addPositive(int a, int b) {
	        if (a > 0 && b > 0) {
	            // Both parameters are positive, return the sum
	            return a + b;
	        } else {
	            // Either parameter is zero or negative, throw an exception
	            throw new IllegalArgumentException("Both parameters must be positive!");
	        }
	}
		/* Method to check if a number is prime
		 The isPrime method is taking an integer parameter "number" and returning it as "true" if the number is prime, and 
		 "false otherwise."*/
	    public boolean isPrime(int number) {
	        if (number <= 1) {
	            return false;
	        }
	        //Iterating from 2 to the square root of the number, checking for divisibility by each number. If the number is 
	        //divisible by any number other than 1 and itself, it returns "false", otherwise "true".
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	    /*\
	     * This method is generating a random integer between 1 and 10(inclusive) using the random class from the java.util package.
	     * random.nextInt(10) generates a random integer between 0(inclusive) and 10(exclusive). The +1 is ensuring the result is between 1 and 10.
	     */
	    int getRandomInt() {
			Random random = new Random();
			return random.nextInt(10) + 1;
		}
	    /*
	     * calling the getRandomInt method to obtain a random integer between 1-10(inclusive)
	     * Then it squares this random integer (randomInt * randomInt) and returns the result.
	     */
		public int randomNumberSquared() {
			int randomInt = getRandomInt();
			return randomInt * randomInt;
		}
}

	
