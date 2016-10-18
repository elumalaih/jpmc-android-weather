package com.elumalai.weather.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Custom shared preference to store and retrieve data
 */

public class CustomSharedPreference {

    private SharedPreferences sharedPref;

    /**
     * Custom shared preference initialization
     *
     * @param context
     */
    public CustomSharedPreference(Context context) {
        sharedPref = context.getSharedPreferences(Helper.PREFS_TAG, Context.MODE_PRIVATE);
    }

    /**
     * set city name(location)
     *
     * @param cityName
     */
    public void setLocationInPreference(String cityName) {
        sharedPref.edit().putString(Helper.LOCATION_PREFS, cityName).apply();
    }

    /**
     * Get city name(location
     *
     * @return
     */
    public String getLocationInPreference() {
        return sharedPref.getString(Helper.LOCATION_PREFS, "");
    }
}

