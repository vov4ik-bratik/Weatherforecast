package lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component;

import com.google.gson.annotations.SerializedName;

public class MainData {

    @SerializedName("temp")
    public double temperature;

    @SerializedName("pressure")
    public double pressure;

    @SerializedName("humidity")
    public double humidity;

    public MainData() {
    }

    public double getTemperature() {
        return Math.round((temperature - 273.15) * 10d)/10d;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
