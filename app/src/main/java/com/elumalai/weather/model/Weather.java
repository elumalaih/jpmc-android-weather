
package com.elumalai.weather.model;

/*
 * Weather model data
 */
public class Weather {

    public Location location;
    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    ;

    public byte[] iconData;

    /**
     * Current weather condition
     */
    public class CurrentCondition {
        private int weatherId;
        private String condition;
        private String descr;
        private String icon;
        private float pressure;
        private float humidity;

        /**
         * Get weather id
         *
         * @return
         */
        public int getWeatherId() {
            return weatherId;
        }

        /**
         * Set weather id
         *
         * @param weatherId
         */
        public void setWeatherId(int weatherId) {
            this.weatherId = weatherId;
        }

        /**
         * Get weather condition
         *
         * @return
         */
        public String getCondition() {
            return condition;
        }

        /**
         * set weather condition
         *
         * @param condition
         */
        public void setCondition(String condition) {
            this.condition = condition;
        }

        /**
         * Get Descr
         *
         * @return
         */
        public String getDescr() {
            return descr;
        }

        /**
         * Get Descr
         *
         * @param descr
         */
        public void setDescr(String descr) {
            this.descr = descr;
        }

        /**
         * Get weather icon
         *
         * @return
         */
        public String getIcon() {
            return icon;
        }

        /**
         * Set weather icon
         *
         * @param icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        /**
         * Get weather pressure
         *
         * @return
         */
        public float getPressure() {
            return pressure;
        }

        /**
         * Set weather pressure
         *
         * @param pressure
         */
        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        /**
         * get humidity
         *
         * @return
         */
        public float getHumidity() {
            return humidity;
        }

        /**
         * set humididty
         *
         * @param humidity
         */
        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }


    }

    /**
     * Temperature
     */
    public class Temperature {
        private float temp;
        private float minTemp;
        private float maxTemp;

        /**
         * Get temperature
         *
         * @return
         */
        public float getTemp() {
            return temp;
        }

        /**
         * set temperature
         *
         * @param temp
         */
        public void setTemp(float temp) {
            this.temp = temp;
        }

    }

    /**
     * Wind
     */
    public class Wind {
        private float speed;
        private float deg;

        /**
         * Get wind speed
         *
         * @return
         */
        public float getSpeed() {
            return speed;
        }

        /**
         * set wind speed
         *
         * @param speed
         */
        public void setSpeed(float speed) {
            this.speed = speed;
        }

        /**
         * get wind Deg
         *
         * @return
         */
        public float getDeg() {
            return deg;
        }

        /**
         * Set wind Deg
         *
         * @param deg
         */
        public void setDeg(float deg) {
            this.deg = deg;
        }


    }

}
