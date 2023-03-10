package PolynomialCalculator.ModelAndOperations;

public class CalculatorMonomial {
    private float coefficient;
    private int power;

    public CalculatorMonomial(float coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

