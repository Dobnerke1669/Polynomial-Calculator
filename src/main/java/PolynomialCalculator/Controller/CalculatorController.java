package PolynomialCalculator.Controller;

import PolynomialCalculator.ModelAndOperations.CalculatorOperations;
import PolynomialCalculator.ModelAndOperations.CalculatorPolynomial;
import PolynomialCalculator.View.CalculatorView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorOperations operations;

    public CalculatorController(CalculatorView view, CalculatorOperations operations)
    {
        this.view=view;
        this.operations=operations;
        view.addAdditionListener(new AdditionListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addSubtractListener(new SubtractListener());
        view.addDivideListener(new DivisionListener());
        view.addDifferentiateListener(new DifferentiateListener());
        view.addIntegrateListener(new IntegrateListener());
    }

    public class AdditionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalculatorPolynomial polynom_1=operations.createPolynom(view.getpolynomInput_1());
            CalculatorPolynomial polynom_2=operations.createPolynom(view.getpolynomInput_2());
            CalculatorPolynomial sumPolynom=operations.add(polynom_1,polynom_2);
            view.setResult(operations.displayPolynomView(sumPolynom));
        }
    }
    public class SubtractListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalculatorPolynomial polynom_1=operations.createPolynom(view.getpolynomInput_1());
            CalculatorPolynomial polynom_2=operations.createPolynom(view.getpolynomInput_2());
            CalculatorPolynomial subPolynom=operations.subtract(polynom_1,polynom_2);
            view.setResult(operations.displayPolynomView(subPolynom));
        }
    }
    public class MultiplyListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalculatorPolynomial polynom_1=operations.createPolynom(view.getpolynomInput_1());
            CalculatorPolynomial polynom_2=operations.createPolynom(view.getpolynomInput_2());
            CalculatorPolynomial multiplyPolynom=operations.multiply(polynom_1,polynom_2);
            view.setResult(operations.displayPolynomView(multiplyPolynom));
        }
    }
    public class DivisionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class DifferentiateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalculatorPolynomial polynom_1=operations.createPolynom(view.getpolynomInput_1());
            CalculatorPolynomial differentiatePolynom=operations.differentiate(polynom_1);
            view.setResult(operations.displayPolynomView(differentiatePolynom));
        }
    }
    public class IntegrateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalculatorPolynomial polynom_1=operations.createPolynom(view.getpolynomInput_1());
            CalculatorPolynomial integratePolynom=operations.integrate(polynom_1);
            view.setResult(operations.displayIntegratePolynomView(integratePolynom));
        }
    }
}

