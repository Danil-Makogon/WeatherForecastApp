package de.telran.weather;

import de.telran.weather.service.InputOutputService;
import de.telran.weather.service.WeatherForecastConfig;
import de.telran.weather.service.WeatherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WeatherForecastApp {

    private InputOutputService inputOutputService;
    private WeatherService weatherService;
    protected static final Logger log = LogManager.getLogger(WeatherForecastApp.class);

    public WeatherForecastApp(InputOutputService inputOutputService, WeatherService weatherService) {
        this.inputOutputService = inputOutputService;
        this.weatherService = weatherService;
    }

    public void execute() throws Exception {
        log.info("The program is start");
        String s = inputOutputService.readValue();
        String result = weatherService.getWeatherByCityName(s);
        inputOutputService.print(result);
        log.info("The program is finished");
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WeatherForecastConfig.class);
        WeatherForecastApp app = (WeatherForecastApp) context.getBean("app");
        app.execute();
    }
}

