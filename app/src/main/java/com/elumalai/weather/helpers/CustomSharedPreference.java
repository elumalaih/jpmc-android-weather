package com.elumalai.weather.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Custom shared preference helper helps application to store and retrieve data.
 * Here we storing user last searched location(city name)
 *
 */

public class CustomSharedPreference {

    private SharedPreferences sharedPref;

    /**
     * Custom shared preference initialization
     * initialization with preference tag and creation mode parameters
     *
     * @param context
     */
    public CustomSharedPreference(Context context) {
        sharedPref = context.getSharedPreferences(Helper.PREFS_TAG, Context.MODE_PRIVATE);
    }

    /**
     * set city name(location) in custom shared preference
     * while passing key->Value pair (Here we are passing location_prefs as key and location(city name) as value
     *
     * @param cityName
     */
    public void setLocationInPreference(String cityName) {
        sharedPref.edit().putString(Helper.LOCATION_PREFS, cityName).apply();
    }

    /**
     * Get city name(location) while passing location_prefs key
     *
     * @return
     */
    public String getLocationInPreference() {
        return sharedPref.getString(Helper.LOCATION_PREFS, "");
    }
}

