package lessons.vs.petersonapps.weatherforecast.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.Clouds;
import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.Coordinate;
import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.MainData;
import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.Rain;
import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.Sys;
import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.Weather;
import lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component.Wind;


public class WeatherData {

    @SerializedName("coord")
    public Coordinate coordinate;

    @SerializedName("weather")
    public List<Weather> weather;

    @SerializedName("base")
    public String base;

    @SerializedName("main")
    public MainData mainData;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("rain")
    public Rain rain;

    public int dt;

    @SerializedName("sys")
    public Sys sys;

    @SerializedName("id")
    public int cityId;

    @SerializedName("name")
    public String cityName;

    @SerializedName("cod")
    public int cod;


    public WeatherData() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature(){
        return mainData.getTemperature();
    }

    public String getIcon (){
        return weather.get(0).getIcon();
    }

    public String getweatherDescription(){
        return weather.get(0).getDescription();
    }

    public int getCoud(){
        return clouds.getClouds();
    }

    public double getWind(){
        return wind.getWindSpeed();
    }

}
