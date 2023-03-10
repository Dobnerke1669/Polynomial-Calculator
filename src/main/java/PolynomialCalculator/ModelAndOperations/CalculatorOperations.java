package PolynomialCalculator.ModelAndOperations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
public class CalculatorOperations {
    public CalculatorPolynomial add(CalculatorPolynomial p1, CalculatorPolynomial p2){
        CalculatorPolynomial sumPolynom=new CalculatorPolynomial();
        Iterator<CalculatorMonomial> it1=p1.getPolynom().iterator();
        Iterator<CalculatorMonomial> it2=p2.getPolynom().iterator();
        int highestPower;
        int polynom1Power,polynom2Power;
        polynom1Power=p1.getHighestPower();
        polynom2Power=p2.getHighestPower();
        if (polynom1Power>polynom2Power) {
            highestPower=polynom1Power;
        }
        else {
            highestPower=polynom2Power;
        }
        for(int i=0;i<=highestPower;i++) {
            CalculatorMonomial monom=new CalculatorMonomial(0,i);
            sumPolynom.getPolynom().add(monom);
        }
        ArrayList<CalculatorMonomial> monomials1=p1.getPolynom();
        for(CalculatorMonomial it: monomials1)
        {
            sumPolynom.getPolynom().set(it.getPower(),it);
        }
        ArrayList<CalculatorMonomial> monomials2=p2.getPolynom();
        for (CalculatorMonomial it: monomials2)
        {
            sumPolynom.getPolynom().get(it.getPower()).setCoefficient(it.getCoefficient()+sumPolynom.getPolynom().get(it.getPower()).getCoefficient());
        }
        sumPolynom.sortPolynomial();
        return sumPolynom;
    }
    public CalculatorPolynomial subtract(CalculatorPolynomial p1, CalculatorPolynomial p2) {
        CalculatorPolynomial subPolynom=new CalculatorPolynomial();
        Iterator<CalculatorMonomial> it1=p1.getPolynom().iterator();
        Iterator<CalculatorMonomial> it2=p2.getPolynom().iterator();
        int highestPower;
        int polynom1Power,polynom2Power;
        polynom1Power=p1.getHighestPower();
        polynom2Power=p2.getHighestPower();
        if (polynom1Power>polynom2Power) {
            highestPower=polynom1Power;
        }
        else {
            highestPower=polynom2Power;
        }
        for(int i=0;i<=highestPower;i++) {
            CalculatorMonomial monom=new CalculatorMonomial(0,i);
            subPolynom.getPolynom().add(monom);
        }
        ArrayList<CalculatorMonomial> monomials1=p1.getPolynom();
        for(CalculatorMonomial it: monomials1)
        {
            subPolynom.getPolynom().set(it.getPower(),it);
        }
        ArrayList<CalculatorMonomial> monomials2=p2.getPolynom();
        for (CalculatorMonomial it: monomials2)
        {
            subPolynom.getPolynom().get(it.getPower()).setCoefficient(-it.getCoefficient()+subPolynom.getPolynom().get(it.getPower()).getCoefficient());
        }
        subPolynom.sortPolynomial();
        return subPolynom;
    }
    public CalculatorPolynomial multiply(CalculatorPolynomial p1,CalculatorPolynomial p2) {
        CalculatorPolynomial firstCopy=new CalculatorPolynomial();
        CalculatorPolynomial secondCopy=new CalculatorPolynomial();
        CalculatorPolynomial multiplyPolynomial=new CalculatorPolynomial();
        firstCopy=p1.polynomeCopy(p1);
        secondCopy=p2.polynomeCopy(p2);
        Iterator<CalculatorMonomial> it1=firstCopy.getPolynom().iterator();
        Iterator<CalculatorMonomial> it2=secondCopy.getPolynom().iterator();
        int power1=it1.next().getPower();
        int power2=it2.next().getPower();
        for(int i=0;i<=power1+power2;i++) {
            CalculatorMonomial monom=new CalculatorMonomial(0,0);
            multiplyPolynomial.getPolynom().add(monom);
        }
        it1=firstCopy.getPolynom().iterator();
        while(it1.hasNext()) {
            CalculatorMonomial monom1=it1.next();
            int powerMonom1=monom1.getPower();
            float coeff1=monom1.getCoefficient();
            it2=secondCopy.getPolynom().iterator();
            while(it2.hasNext()) {
                CalculatorMonomial monom2=it2.next();
                int powerMonom2=monom2.getPower();
                float coeff2=monom2.getCoefficient();
                if (multiplyPolynomial.getPolynom().get(powerMonom1+powerMonom2)!=null) {
                    CalculatorMonomial oldMonom=multiplyPolynomial.getPolynom().get(powerMonom1+powerMonom2);
                    float oldCoeff=oldMonom.getCoefficient();
                    CalculatorMonomial newMonom=new CalculatorMonomial(oldCoeff+coeff1*coeff2,powerMonom1+powerMonom2);
                    multiplyPolynomial.getPolynom().set(powerMonom1+powerMonom2,newMonom);
                }
                else {
                    CalculatorMonomial newMonom=new CalculatorMonomial(coeff1*coeff2,powerMonom1+powerMonom2);
                    multiplyPolynomial.getPolynom().set(powerMonom1+powerMonom2,newMonom);
                }
            }
        }
        multiplyPolynomial.sortPolynomial();
        return multiplyPolynomial;
    }
    public CalculatorPolynomial divide(CalculatorPolynomial p1, CalculatorPolynomial p2) {
        CalculatorPolynomial dividePolynom=new CalculatorPolynomial();
        return dividePolynom;
    }
    public CalculatorPolynomial differentiate(CalculatorPolynomial p) {
        CalculatorPolynomial differentiatePolynom=new CalculatorPolynomial();
        Iterator<CalculatorMonomial> it=p.getPolynom().iterator();
        while(it.hasNext()){
            CalculatorMonomial monome=it.next();
            int power=monome.getPower();
            if (power>0) {
                float coeff=monome.getCoefficient();
                monome.setPower(power-1);
                monome.setCoefficient(power*coeff);
                differentiatePolynom.getPolynom().add(monome);
            }
        }
        return differentiatePolynom;
    }
    public CalculatorPolynomial integrate(CalculatorPolynomial p)
    {
        CalculatorPolynomial integratePolynom=new CalculatorPolynomial();
        Iterator<CalculatorMonomial> it=p.getPolynom().iterator();
        while(it.hasNext()){
            CalculatorMonomial monome=it.next();
            int power=monome.getPower();
            if (power>0) {
                float coeff=monome.getCoefficient();
                monome.setPower(power+1);
                monome.setCoefficient(coeff/(power+1));
                integratePolynom.getPolynom().add(monome);
            }
            else {
                float coeff=monome.getCoefficient();
                monome.setPower(power+1);
                monome.setCoefficient(coeff);
                integratePolynom.getPolynom().add(monome);
            }
        }
        return integratePolynom;
    }
    public CalculatorPolynomial createPolynom(String polynom)
    {
        CalculatorPolynomial createdPolynom=new CalculatorPolynomial();
        String inputString=polynom;
        for (String it:inputString.split("\\s+")) {
            float coefficient=0;
            int power=0;
            int positionMultiplication=it.indexOf("*");
            int positionPower=it.indexOf("^");
            if (positionPower==-1&&positionPower==-1) {
                coefficient=Integer.parseInt(it);
                CalculatorMonomial newMonomial=new CalculatorMonomial(coefficient,0);
                createdPolynom.getPolynom().add(newMonomial);
            }
            else {
                if (it.charAt(0)=='-') {
                    coefficient=Integer.parseInt(it.substring(1,positionMultiplication))*(-1);
                }
                else if (it.charAt(0)=='+') {
                    coefficient=Integer.parseInt(it.substring(1,positionMultiplication));
                }
                power=Integer.parseInt(it.substring(positionPower+1));
                if (coefficient!=0) {
                    CalculatorMonomial newMonomial=new CalculatorMonomial(coefficient,power);
                    createdPolynom.getPolynom().add(newMonomial);
                }
            }
        }
        return createdPolynom;
    }
    public void outputPolynom(CalculatorPolynomial polynome)
    {
        Iterator<CalculatorMonomial> it=polynome.getPolynom().iterator();
        while(it.hasNext()) {
            CalculatorMonomial monom=it.next();
            if (monom.getCoefficient()>0) System.out.print("+"+(int) monom.getCoefficient()+"X^"+monom.getPower());
            else if (monom.getCoefficient()<0)
                System.out.print(((int) monom.getCoefficient())+"X^"+monom.getPower());
        }
        System.out.println();
    }
    public String displayPolynomView(CalculatorPolynomial polynome)
    {
        StringBuilder output=new StringBuilder();
        Iterator<CalculatorMonomial> it=polynome.getPolynom().iterator();
        while(it.hasNext()) {
            CalculatorMonomial monomial = it.next();
            if (monomial.getCoefficient()>0) {
                output.append(" +");
                int castVariable=(int) monomial.getCoefficient();
                output.append(castVariable);
                output.append("*X^");
                output.append(monomial.getPower());
            }
            else if (monomial.getCoefficient()<0) {
                int castVariable=(int) monomial.getCoefficient();
                output.append(" ");
                output.append(castVariable);
                output.append("*X^");
                output.append(monomial.getPower());
            }
        }
        if (output.isEmpty())
        {
            output.append("0");
        }
        return output.toString();
    }
    public String displayIntegratePolynomView(CalculatorPolynomial polynome)
    {
        StringBuilder output=new StringBuilder();
        Iterator<CalculatorMonomial> it=polynome.getPolynom().iterator();
        while(it.hasNext()) {
            CalculatorMonomial monomial = it.next();
            if (monomial.getCoefficient()>0) {
                output.append(" +");
                float castVariable=monomial.getCoefficient();
                output.append(castVariable);
                output.append("*X^");
                output.append(monomial.getPower());
            }
            else if (monomial.getCoefficient()<0) {
                float castVariable=monomial.getCoefficient();
                output.append(" ");
                output.append(castVariable);
                output.append("*X^");
                output.append(monomial.getPower());
            }
        }
        if (output.isEmpty())
        {
            output.append("0");
        }
        output.append("+C");
        return output.toString();
    }
}

