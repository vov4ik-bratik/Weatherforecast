package lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vs on 20.04.2017.
 */

public class Wind {

    @SerializedName("speed")
    public double windSpeed;

    @SerializedName("deg")
    public double windDegree;

    public Wind() {
    }

    public double getWindSpeed() {
        return Math.round(windSpeed * 10d)/10d;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }
}
