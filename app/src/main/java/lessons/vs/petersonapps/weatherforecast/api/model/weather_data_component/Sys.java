package lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vs on 20.04.2017.
 */

public class Sys {

    @SerializedName("type")
    public int type;

    @SerializedName("id")
    public int id;

    @SerializedName("message")
    public double message;

    @SerializedName("country")
    public String country;

    @SerializedName("sunrise")
    public int sunrice;

    @SerializedName("sunset")
    public int sunset;

    public Sys() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrice() {
        return sunrice;
    }

    public void setSunrice(int sunrice) {
        this.sunrice = sunrice;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
