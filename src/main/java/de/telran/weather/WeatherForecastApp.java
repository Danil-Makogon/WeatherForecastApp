package de.telran.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import de.telran.weather.service.InputOutputService;
import de.telran.weather.service.WeatherGateway;
import de.telran.weather.service.WeatherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WeatherForecastApp {
    private InputOutputService inputOutputService;
    private WeatherService service;

    protected static final Logger log = LogManager.getLogger(WeatherForecastApp.class);

    public WeatherForecastApp(InputOutputService inputOutputService, WeatherService service) {
        this.inputOutputService = inputOutputService;
        this.service = service;
    }

    public void execute() throws Exception {
        log.info("The program is start");
        String s = inputOutputService.readValue();
        String result = service.getWeatherByCityName(s);
        inputOutputService.print(result);
        log.info("The program is finished");
    }

    public static void main(String[] args) throws Exception {
        InputOutputService inputOutputService = new InputOutputService();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        WeatherGateway weatherGateway = new WeatherGateway(mapper);
        WeatherService service = new WeatherService(weatherGateway);
        WeatherForecastApp weatherForecastApp = new WeatherForecastApp(inputOutputService, service);
        weatherForecastApp.execute();
    }
}

