package PolynomTest;

import PolynomialCalculator.ModelAndOperations.CalculatorOperations;
import PolynomialCalculator.ModelAndOperations.CalculatorPolynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorOperationsTest {
    CalculatorOperations operations=new CalculatorOperations();
    CalculatorPolynomial polynom1=operations.createPolynom("+3*X^2 +2*X^1 +6"),polynom2=operations.createPolynom("+3*X^1 +7");
    @Test
    void add() {
        assertEquals(" +3*X^2 +5*X^1 +13*X^0",operations.displayPolynomView(operations.add(polynom1,polynom2)));
    }

    @Test
    void subtract() {
        assertEquals(" +3*X^2 -1*X^1 -1*X^0",operations.displayPolynomView(operations.subtract(polynom1,polynom2)));
    }

    @Test
    void multiply() {
        assertEquals(" +9*X^3 +27*X^2 +32*X^1 +42*X^0",operations.displayPolynomView(operations.multiply(polynom1,polynom2)));
    }

    @Test
    void differentiate() {
        assertEquals(" +6*X^1 +2*X^0",operations.displayPolynomView(operations.differentiate(polynom1)));
    }

    @Test
    void integrate() {
        assertEquals(" +1.5*X^3 +2.0*X^2 +6.0*X^1+C",operations.displayIntegratePolynomView(operations.integrate(polynom1)));
    }
}