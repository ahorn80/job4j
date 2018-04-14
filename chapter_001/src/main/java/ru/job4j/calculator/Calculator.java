package ru.job4j.calculator;

/**
 * Class Calculator
 * @author Andreas Horn
 */
public class Calculator {

    private double result;

    /**
     * method returns result value.
     * @return result of last calculation.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * method add calculates first + second.
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * method sub calculates first - second.
     * @param first
     * @param second
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }

    /**
     * method mult calculates first * second.
     * @param first
     * @param second
     */
    public void mult(double first, double second) {
        this.result = first * second;
    }

    /**
     * method div calculates first/second
     * @param first
     * @param second
     */
    public void div(double first, double second) {
            this.result = first / second;
    }
}
