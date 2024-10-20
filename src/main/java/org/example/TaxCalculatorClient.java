package org.example;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class TaxCalculatorClient {
    public static void main(String[] args) throws Exception {
        // 创建服务的URL和QName
        URL url = new URL("http://localhost:8080/TaxCalculator?wsdl");
        QName qname = new QName("http://example.org/", "TaxCalculatorImplService");
        Service service = Service.create(url, qname);
        TaxCalculator calculator = service.getPort(TaxCalculator.class);

        // 创建Scanner以获取用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入收入: ");
        double income = scanner.nextDouble(); // 从控制台读取收入
        double tax = calculator.calculateTax(income); // 调用Web服务计算税额

        // 输出计算结果
        System.out.println("计算得出的税额为: " + tax);
    }
}
