package PolynomialCalculator;

import PolynomialCalculator.Controller.CalculatorController;
import PolynomialCalculator.ModelAndOperations.CalculatorOperations;
import PolynomialCalculator.View.CalculatorView;

public class Main {

    public static void main(String[] args) {
        CalculatorView view=new CalculatorView();
        CalculatorOperations operations=new CalculatorOperations();
        CalculatorController controller=new CalculatorController(view,operations);
        view.setVisible(true);

    }
}
