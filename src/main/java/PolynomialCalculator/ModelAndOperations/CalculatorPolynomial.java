package PolynomialCalculator.ModelAndOperations;

import java.util.*;

public class CalculatorPolynomial {
    private ArrayList<CalculatorMonomial> polynom=new ArrayList<>();

    public CalculatorPolynomial() {}
    public ArrayList<CalculatorMonomial> getPolynom() {
        return polynom;
    }

    public void setPolynom(ArrayList<CalculatorMonomial> polynom) {
        this.polynom = polynom;
    }

    public CalculatorPolynomial polynomeCopy(CalculatorPolynomial p1)
    {
        CalculatorPolynomial copiedPoly=new CalculatorPolynomial();
        Iterator<CalculatorMonomial>it = p1.getPolynom().iterator();
        while (it.hasNext())
        {
            CalculatorMonomial monome=it.next();
            int power=monome.getPower();
            float coeff=monome.getCoefficient();
            CalculatorMonomial copiedMonome=new CalculatorMonomial(coeff,power);
            copiedPoly.getPolynom().add(copiedMonome);
        }
        return copiedPoly;
    }
    public int getHighestPower()
    {
        return polynom.get(0).getPower();
    }
    public CalculatorMonomial findPower(int power)
    {
        CalculatorMonomial result=new CalculatorMonomial(0,0);
        Iterator<CalculatorMonomial> it=this.getPolynom().iterator();
        while(it.hasNext())
        {
            CalculatorMonomial monome=it.next();
            if (monome.getPower()==power)
            {
                result=monome;
            }
        }
        return result;
    }
    public CalculatorPolynomial polynomeInvertCopy(CalculatorPolynomial p1)
    {
        CalculatorPolynomial copiedPoly=new CalculatorPolynomial();
        Iterator<CalculatorMonomial>it = p1.getPolynom().iterator();
        while (it.hasNext())
        {
            CalculatorMonomial monome=it.next();
            int power=monome.getPower();
            float coeff=monome.getCoefficient();
            CalculatorMonomial copiedMonome=new CalculatorMonomial(-coeff,power);
            copiedPoly.getPolynom().add(copiedMonome);
        }
        return copiedPoly;
    }
    public void sortPolynomial()
    {
        Collections.sort(polynom, new Comparator<CalculatorMonomial>() {
            @Override
            public int compare(CalculatorMonomial o1, CalculatorMonomial o2) {
                if (o1.getPower()>o2.getPower())
                {
                    return -1;
                }
                else if (o1.getPower()==o2.getPower())
                {
                    return 0;
                }
                else return 1;
            }
        });
    }
}


