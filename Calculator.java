package com.junit;
public class Calculator {

    // Method to perform addition
    public int add(int i, int j) {
        return i + j;
    }

    // Method to perform subtraction
    public int subtract(int i, int j) {
        return i - j;
    }

    // Method to perform multiplication
    public int multiply(int i, int j) {
        return i * j;
    }

    // Method to perform division
    public double divide(int i, int j) {
        if (j == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) i / j;
    }

    // Method to perform modulo operation
    public int modulo(int i, int j) {
        return i % j;
    }
}





	