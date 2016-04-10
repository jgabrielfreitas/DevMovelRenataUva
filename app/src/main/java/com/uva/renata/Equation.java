package com.uva.renata;

/**
 * Created by RenataRibeiro on 09/04/16.
 */
public class Equation {

    double aValue;
    double bValue;
    double cValue;

    public Equation() {
    }

    public void setaValue(double aValue) {
        this.aValue = aValue;
    }

    public void setbValue(double bValue) {
        this.bValue = bValue;
    }

    public void setcValue(double cValue) {
        this.cValue = cValue;
    }

    // delta = ((b*b)-(4*a*c));
    public double getDelta() {
        return ((bValue * bValue) - (4 * aValue * cValue));
    }

    // x1 = (-b + Math.sqrt (delta)) / ( 2*a );
    public double getX1() {
        return (-bValue + Math.sqrt(getDelta())) / (2 * aValue);
    }

    // x2 = (-b - Math.sqrt (delta)) / ( 2*a ) ;
    public double getX2() {
        return (-bValue - Math.sqrt(getDelta())) / (2 * aValue);
    }

    public String result() {

        if (getDelta() >= 0)
            return String.format("Delta: %f\nx1: %f\nx2: %f", getDelta(), getX1(), getX2());
        else
            return "Não há soluções que possam ser expressas com o conjunto dos números reais ";
    }
}
