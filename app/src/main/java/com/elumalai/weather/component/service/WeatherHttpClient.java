
package com.elumalai.weather.component.service;

import com.elumalai.weather.R;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Weather Http service client component part contains below service call invoking par
 * i)Make openweathermap webservice api call to retrieve weather data ,Here we are passing location(cityname) parameter
 * ii)Make openweathermap image webservice call to retrieve weather icon bytes , Here we passing weather icon code parameter
 *
 * This is a reusable framework component, Applcation can call this service component to get current weather data and weather icon
 * Todo : Have to create this as a separate android library module and import into app(adding dependency in build.gradle) and start using this service
 * Todo : While creating library module  have to include resources for language localization(to support user device local language)
 *
 */
public class WeatherHttpClient {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static String IMG_URL = "http://openweathermap.org/img/w/";
    private static String IMAGE_FORMAT = ".png";


    /**
     * Get Current weather data based on location and registered app id parameter
     * Make weather api service call and pass location name(city name)and registered app id
     *
     * @param location
     * @param appId
     * @return weather data
     */
    public String getWeatherData(String location, String appId) {
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            con = (HttpURLConnection) (new URL(BASE_URL + location + "&appid=" + appId)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null)
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }

        return null;

    }

    /**
     * Get current weather icon image while passing weather icon string code parameter
     * Make weather image service call and pass weather icon code string as a parameter
     *
     * @param code
     * @return
     */
    public byte[] getImage(String code) {
        HttpURLConnection con = null;
        InputStream is = null;
        try {
            con = (HttpURLConnection) (new URL(IMG_URL + code + IMAGE_FORMAT)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            //con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while (is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }

        return null;

    }
}
