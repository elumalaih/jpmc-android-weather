package com.elumalai.weather.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.elumalai.weather.R;
import com.elumalai.weather.component.parser.JSONWeatherParser;
import com.elumalai.weather.component.service.WeatherHttpClient;
import com.elumalai.weather.helpers.CustomSharedPreference;
import com.elumalai.weather.model.Weather;

import org.json.JSONException;

/**
 * Display the current weather report in the application UI of user entered city. And also store user last searched city
 * in local shared preference
 * The report contains following information
 * i)Location name and country (Ex : Columbus, US)
 * ii)Current Weather Condition (Ex :  Sky is Clear)
 * iii)Current Temperature (Ex : 26'6 C)
 * iV) Current Humidity (Ex: 96%)
 * V)Current Pressure (Ex: 1019 hpa)
 * vi)Current Wind speed (Ex: 3.16mps)
 */
public class WeatherActivity extends Activity {


    private TextView cityText;
    private TextView condDescr;
    private TextView temp;
    private TextView press;
    private TextView windSpeed;
    private TextView windDeg;
    private TextView hum;
    private ImageView imgView;
    EditText cityName;
    private CustomSharedPreference sharedPreference;
    private String appId;

    // This method would be called when What's the weather button would be pressed
    public void findtheweather(View view) {

        //Assigning the value which user entered to city
        String cityValue = cityName.getText().toString();
        //Getting registered appId

        //Setting preference - storing city name in shared preference
        sharedPreference.setLocationInPreference(cityValue);

        //Run the weather AsyncTask to fetch weather report response data from weather service call
        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{cityValue,appId});

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityText = (TextView) findViewById(R.id.cityText);
        condDescr = (TextView) findViewById(R.id.condDescr);
        temp = (TextView) findViewById(R.id.temp);
        hum = (TextView) findViewById(R.id.hum);
        press = (TextView) findViewById(R.id.press);
        windSpeed = (TextView) findViewById(R.id.windSpeed);
        windDeg = (TextView) findViewById(R.id.windDeg);
        imgView = (ImageView) findViewById(R.id.condIcon);
        cityName = (EditText) findViewById(R.id.cityname);

        //Custom shared preference
        sharedPreference = new CustomSharedPreference(getApplicationContext());
        //Retrieve stored city from shared preference
        String cityPreference = sharedPreference.getLocationInPreference();
        //Assigning user registered weather appId
        appId = getString(R.string.app_id);
        if (!cityPreference.isEmpty()) {
            JSONWeatherTask task = new JSONWeatherTask();
            task.execute(new String[]{cityPreference,appId});
        }

    }


    /**
     * Run the AsyncTask to get current weather data of entered city & registered appId for weather and set it in UI
     * Pass the Location name(user entered city) as parameter in weather service client to fetch weather data object
     * Once data retrieved from service pass it JSONParser to set weather and location model
     * And also fetch current weather icon bytes
     */
    private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();
            String data = ((new WeatherHttpClient()).getWeatherData(params[0],params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);

                // Let's retrieve the icon , Pass the retrieved icon string code to getImage service client method to retrive image bytes
                weather.iconData = ((new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;

        }


        /**
         * In the Post Execute part , Set all retrieved weather & location model data into corresponding UI
         * CityText view contains the information of user enter city name and country
         * CondDescrText view contain information of current weather condition
         * HumText view  contains current humitity
         * PressText view conrains current weather pressure
         * WindSpeed text view contains current wind speed in form of mps
         *
         * Todo - Have to create text view for sunrise and sunset display in UI
         *
         * @param weather
         */
        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            if (weather.iconData != null && weather.iconData.length > 0) {
                Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
                imgView.setImageBitmap(img);
            }

            cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
            condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
            temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "°C");
            hum.setText("" + weather.currentCondition.getHumidity() + "%");
            press.setText("" + weather.currentCondition.getPressure() + " hPa");
            windSpeed.setText("" + weather.wind.getSpeed() + " mps");
            windDeg.setText("" + weather.wind.getDeg() + "°");

        }


    }
}
