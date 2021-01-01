package de.telran.weather.service;

import de.telran.weather.WeatherForecastApp;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WeatherForecastAppTest {
    InputOutputService inputOutputService = mock (InputOutputService.class);
    WeatherService service = mock(WeatherService.class);

    @Test
    public void TestExecute() throws Exception {
        when(inputOutputService.readValue()).thenReturn("berlin");
        when(service.getWeatherByCityName(anyString())).thenReturn("0.33");
        doNothing().when(inputOutputService).print("0.33");

        WeatherForecastApp weatherForecastApp = new WeatherForecastApp(inputOutputService, service);
        weatherForecastApp.execute();

        verify(inputOutputService, times(1)).readValue();
        verify(service, times(1)).getWeatherByCityName(anyString());
        verify(inputOutputService, times(1)).print(anyString());
    }
}
