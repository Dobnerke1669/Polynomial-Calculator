package PolynomialCalculator.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JLabel polynomial_1=new JLabel();
    private JLabel polynomial_2=new JLabel();
    private JTextField polynomInput_1=new JTextField(40);
    private JTextField polynomInput_2=new JTextField(40);
    private JButton add=new JButton();
    private JButton subtract=new JButton();
    private JButton multiply=new JButton();
    private JButton divide=new JButton();
    private JButton integrate=new JButton();
    private JButton differentiate=new JButton();
    private JLabel result=new JLabel();
    private JLabel howToInput=new JLabel();
    private JLabel instructionsInput=new JLabel();
    private JLabel resultOutput;
    private JPanel inputPart;
    private JPanel content;
    private JPanel resultPart;

    public CalculatorView()
    {
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.content=new JPanel(new GridLayout(2,2));
        this.inputPart();
        this.resultPart();
        this.setContentPane(content);
    }
    private void inputPart()
    {
        this.inputPart= new JPanel();
        this.inputPart.setLayout(new GridLayout(5,2));
        this.polynomial_1=new JLabel("Polynom 1",JLabel.CENTER);
        this.inputPart.add(polynomial_1);
        this.polynomInput_1=new JTextField();
        this.inputPart.add(polynomInput_1);
        this.polynomial_2=new JLabel("Polynom 2",JLabel.CENTER);
        this.inputPart.add(polynomial_2);
        this.polynomInput_2=new JTextField();
        this.inputPart.add(polynomInput_2);
        this.add=new JButton("Add");
        this.inputPart.add(add);
        this.subtract=new JButton("Subtract");
        this.inputPart.add(subtract);
        this.multiply=new JButton("Multiply");
        this.inputPart.add(multiply);
        this.divide=new JButton("Divide");
        this.inputPart.add(divide);
        this.differentiate=new JButton("Differentiate");
        this.inputPart.add(differentiate);
        this.integrate=new JButton("Integrate");
        this.inputPart.add(integrate);
        this.content.add(this.inputPart);
    }

    private void resultPart()
    {
        this.resultPart=new JPanel();
        this.resultPart.setLayout(new GridLayout(2,1));
        this.result=new JLabel("Result",JLabel.CENTER);
        this.resultOutput=new JLabel("",JLabel.CENTER);
        this.resultPart.add(result);
        this.resultPart.add(resultOutput);
        this.howToInput=new JLabel("How to input:+3*X^2_+8*X^1 +3");
        this.instructionsInput=new JLabel("(_ means space, only integer nr allowed)");
        this.resultPart.add(howToInput);
        this.resultPart.add(instructionsInput);
        this.content.add(resultPart);
    }

    public void addAdditionListener(ActionListener mal)  { add.addActionListener(mal);}

    public void addMultiplyListener(ActionListener mal) {
        multiply.addActionListener(mal);
    }

    public void addDivideListener(ActionListener mal) {divide.addActionListener(mal);}

    public void addSubtractListener(ActionListener mal) {
        subtract.addActionListener(mal);
    }

    public void addDifferentiateListener(ActionListener mal) {
        differentiate.addActionListener(mal);
    }

    public void addIntegrateListener(ActionListener mal) {
        integrate.addActionListener(mal);
    }

    public String getpolynomInput_1() {return polynomInput_1.getText().toString();}

    public String getpolynomInput_2() {return polynomInput_2.getText().toString();}

    public void setResult(String results) { resultOutput.setText(results);}
}

