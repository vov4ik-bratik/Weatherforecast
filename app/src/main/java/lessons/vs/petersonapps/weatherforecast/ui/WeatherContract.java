package lessons.vs.petersonapps.weatherforecast.ui;

import android.support.annotation.StringRes;

import lessons.vs.petersonapps.weatherforecast.api.model.WeatherData;

/**
 * Created by vs on 20.04.2017.
 */

public class WeatherContract {

    public interface View{
        void setEmptyCityNameMessage(@StringRes int resId);
        void setWeatherData(WeatherData data);

        void setMapPoint(WeatherData body);
    }

    interface Presenter{
        void go(String cityName);
    }
}
