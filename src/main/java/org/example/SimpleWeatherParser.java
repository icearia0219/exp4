package org.example;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.StringReader;

public class SimpleWeatherParser {
    public static void parseWeatherResponse(String xmlResponse) throws Exception {
        // 解析SOAP响应
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // 确保支持命名空间
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlResponse)));

        // 提取天气信息
        NodeList nodeList = document.getElementsByTagName("string");

        // 简单提取主要天气信息
        String city = nodeList.item(1).getTextContent(); // 城市名称
        String dateTime = nodeList.item(4).getTextContent(); // 日期时间
        String temperature = nodeList.item(5).getTextContent(); // 温度
        String weatherCondition = nodeList.item(6).getTextContent(); // 天气状况
        String wind = nodeList.item(7).getTextContent(); // 风力情况

        System.out.println("城市: " + city);
        System.out.println("时间: " + dateTime);
        System.out.println("温度: " + temperature);
        System.out.println("天气: " + weatherCondition);
        System.out.println("风力: " + wind);
    }
}
