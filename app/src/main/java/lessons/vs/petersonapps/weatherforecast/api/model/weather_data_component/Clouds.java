package lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component;

import com.google.gson.annotations.SerializedName;


public class Clouds {

    @SerializedName("all")
    public int clouds;

    public Clouds() {
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }
}
