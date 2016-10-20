package com.elumalai.weather;

import com.elumalai.weather.component.service.WeatherHttpClient;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Weather Http Client Test - To test weather service calls
 */
public class WeatherHttpClientTest {
    private static String city = "Columbus";
    private static String appId = "ca99507cff77f98e603a4b6a9b528b13";
    private static String iconCode = "01d";

    /**
     * Test getWeatherData method , Validate returning weatherData is not null while passing city name and register appID as input parameter
     */
    @Test
    public void testWeatherDataNotNull(){

        String actualWeatherData = ( (new WeatherHttpClient()).getWeatherData(city,appId));
        assertNotNull("Weather data is not null",actualWeatherData);

    }

    /**
     * Test getWeatherData method , Validate returning weatherData with expected weather data while passing city name as input parameter
     */
    @Test
    public void testWeatherData(){
        String expectedWeatherData ="{\"coord\":{\"lon\":-83,\"lat\":39.96},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":294.473,\"pressure\":986.84,\"humidity\":63,\"temp_min\":294.473,\"temp_max\":294.473,\"sea_level\":1022.57,\"grnd_level\":986.84},\"wind\":{\"speed\":7.76,\"deg\":220.004},\"clouds\":{\"all\":0},\"dt\":1476782057,\"sys\":{\"message\":0.1653,\"country\":\"US\",\"sunrise\":1476791192,\"sunset\":1476830805},\"id\":4509177,\"name\":\"Columbus\",\"cod\":200}\n";
        String actualWeatherData = ( (new WeatherHttpClient()).getWeatherData(city,appId));
        assertEquals(expectedWeatherData, actualWeatherData);
    }

    /**
     * Test weather image method , Validate returning weatherImage byte is not null while passing weather icon code
     */
    @Test
    public void testWeatherImageNotNull(){

        byte[] actualWeatherImageByte = ( (new WeatherHttpClient()).getImage(iconCode));
        assertNotNull("Weather image byte is not null", actualWeatherImageByte);
    }

    /**
     * Test weather image method , Validate returning weatherImage byte with exxpected weatherImage byte while passing weather icon code
     */
    @Test
    public void testtestWeatherImage(){
        byte[] expectedResult = new byte[] { (byte)0xe0, 0x4f, (byte)0xd0,
                0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
                0x30, 0x30, (byte)0x9d };;
        byte[] actualWeatherImageByte = ( (new WeatherHttpClient()).getImage(iconCode));
        assertEquals(expectedResult, actualWeatherImageByte);
    }

}
