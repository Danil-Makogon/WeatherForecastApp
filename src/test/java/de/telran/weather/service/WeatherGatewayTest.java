package de.telran.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.weather.entity.Forecast;
import de.telran.weather.entity.SearchResult;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeatherGatewayTest {

    @Test
    public void testFindCityByName () throws Exception{
        WeatherGateway gateway = new WeatherGateway(new ObjectMapper());

        SearchResult[] berlins = gateway.findCityByName("Berlin");

        assertTrue(berlins.length == 1);
    }

    @Test
    public void testGetWeatherByWoeid() throws Exception{
        WeatherGateway gateway = new WeatherGateway(new ObjectMapper());
        Forecast weatherByWoeid = gateway.getWeatherByWoeid("638242");
    }
}
