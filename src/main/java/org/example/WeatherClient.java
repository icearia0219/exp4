package org.example;

import java.util.Scanner;

public class WeatherClient {
    public static void main(String[] args) {
        try {
            WeatherService weatherService = new WeatherService();
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入城市名称：");
            String cityName = scanner.nextLine();
            String response = weatherService.getWeather(cityName);
            SimpleWeatherParser.parseWeatherResponse(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

