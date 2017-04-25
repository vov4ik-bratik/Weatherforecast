package lessons.vs.petersonapps.weatherforecast.api.model.weather_data_component;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vs on 20.04.2017.
 */

public class Rain {

    @SerializedName("3h")
    public double rainVolume;

    public Rain() {
    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }
}
