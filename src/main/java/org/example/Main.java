package org.example;

public class Main {
    public static void main(String[] args) {
        int n = 6,
            digits = 987654,
            a = 68,
            b = 27;

        long factorialRecursionResult = Factorial.recursion(n),
            factorialCycleResult = Factorial.cycle(n),
            fibonacciRecursionResult = Fibonacci.recursion(n),
            fibonacciCycleResult = Fibonacci.cycle(n);

        int sumOfDigitsResult = SumOfDigitsRecursion.execute(digits),
            sumWithoutOperatorResult = SumWithoutOperator.execute(a, b);

        assert factorialRecursionResult == factorialCycleResult : "Different values factorial";
        System.out.println("Fibonacci(" + n + ") -> " + factorialRecursionResult);

        assert fibonacciRecursionResult == fibonacciCycleResult : "Different values fibonacci";
        System.out.println("Fibonacci(" + n + ") -> " + fibonacciRecursionResult);


        System.out.println("SumOfDigits(" + digits + ") -> " + sumOfDigitsResult);
        assert sumWithoutOperatorResult == a + b : "Different values sum";
        System.out.println("SumWithoutOperator(" + a + ", "+ b + ") -> " + sumWithoutOperatorResult);


    }
}

class SumWithoutOperator {
    public static int execute(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
            return execute(a, b);
        }
    }
}

class SumOfDigitsRecursion {
    public static int execute(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + execute(n / 10);
        }
    }
}