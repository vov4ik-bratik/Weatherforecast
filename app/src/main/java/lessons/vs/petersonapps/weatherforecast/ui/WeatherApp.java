package lessons.vs.petersonapps.weatherforecast.ui;

import android.app.Application;

import lessons.vs.petersonapps.weatherforecast.api.RestClient;
import lessons.vs.petersonapps.weatherforecast.api.service.ServiceGenerator;

/**
 * Created by vs on 24.04.2017.
 */

public class WeatherApp extends Application {

    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
        restClient = new ServiceGenerator();
    }

    public static RestClient getRestClient() {
        return restClient;
    }
}
