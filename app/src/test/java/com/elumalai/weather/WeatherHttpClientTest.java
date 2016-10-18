package com.elumalai.weather;

import com.elumalai.weather.component.service.WeatherHttpClient;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Weather Http Client Test
 */
public class WeatherHttpClientTest {

    /**
     * Test weather data is not null while passing city name as input parameter
     */
    @Test
    public void testWeatherDataNotNull(){
        String city = "Columbus";
        String actualWeatherData = ( (new WeatherHttpClient()).getWeatherData(city));
        assertNotNull("Weather data is not null",actualWeatherData);

    }

    /**
     * Test weather data while passing city name as input parameter
     */
    @Test
    public void testWeatherData(){
        String city = "Columbus";
        String expectedWeatherData ="{\"coord\":{\"lon\":-83,\"lat\":39.96},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":294.473,\"pressure\":986.84,\"humidity\":63,\"temp_min\":294.473,\"temp_max\":294.473,\"sea_level\":1022.57,\"grnd_level\":986.84},\"wind\":{\"speed\":7.76,\"deg\":220.004},\"clouds\":{\"all\":0},\"dt\":1476782057,\"sys\":{\"message\":0.1653,\"country\":\"US\",\"sunrise\":1476791192,\"sunset\":1476830805},\"id\":4509177,\"name\":\"Columbus\",\"cod\":200}\n";
        String actualWeatherData = ( (new WeatherHttpClient()).getWeatherData(city));
        System.out.println(actualWeatherData);
        assertEquals(expectedWeatherData, actualWeatherData);
    }

}
