package org.example;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.TaxCalculator")
public class TaxCalculatorImpl implements TaxCalculator {
    @Override
    public double calculateTax(double income) {
        return income * 0.2;
    }
}
