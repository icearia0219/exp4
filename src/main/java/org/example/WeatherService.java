package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    // 请求天气信息的SOAP请求体
    private static final String SOAP_REQUEST_TEMPLATE =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <getWeatherbyCityName xmlns=\"http://WebXml.com.cn/\">\n" +
                    "      <theCityName>%s</theCityName>\n" +
                    "    </getWeatherbyCityName>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>";

    // Web服务的URL
    private static final String WEATHER_SERVICE_URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";

    // 获取天气信息的方法
    public String getWeather(String cityName) throws Exception {
        // 构造SOAP请求
        String soapRequest = String.format(SOAP_REQUEST_TEMPLATE, cityName);

        // 创建URL对象
        URL url = new URL(WEATHER_SERVICE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置HTTP请求属性
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setRequestProperty("SOAPAction", "http://WebXml.com.cn/getWeatherbyCityName");
        connection.setDoOutput(true);

        // 发送SOAP请求
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(soapRequest.getBytes("UTF-8"));
        }

        // 读取响应
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // 返回响应内容
        return response.toString();
    }
}
