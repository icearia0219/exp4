package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TaxCalculator {
    @WebMethod
    double calculateTax(double income);
}
