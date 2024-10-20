package org.example;

import javax.xml.ws.Endpoint;

public class TaxCalculatorPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/TaxCalculator", new TaxCalculatorImpl());
        System.out.println("Web Service is running...");
    }
}
