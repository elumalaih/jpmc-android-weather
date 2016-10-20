
package com.elumalai.weather.model;

import java.io.Serializable;

/*
 * Location model serialization
 */
public class Location implements Serializable {

    private float longitude;
    private float latitude;
    private long sunset;
    private long sunrise;
    private String country;
    private String city;

    /**
     * Get location Longitude value
     *
     * @return
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Set location Longitude value
     *
     * @param longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Get location Latitude value
     *
     * @return
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Set location latitude value
     *
     * @param latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Set sun set value
     *
     * @return
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * Get sunset value
     *
     * @param sunset
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    /**
     * Get sunrise value
     *
     * @return
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * Set sunrise value
     *
     * @param sunrise
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * Get country name
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set country name
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get city name
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Set city name
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

}
