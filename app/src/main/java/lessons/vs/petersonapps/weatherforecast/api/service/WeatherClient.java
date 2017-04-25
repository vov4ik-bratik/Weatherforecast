package lessons.vs.petersonapps.weatherforecast.api.service;

import lessons.vs.petersonapps.weatherforecast.api.model.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherClient {

    @GET("weather")
    Call<WeatherData> currentWeather(@Query("q") String cityName, @Query("APPID") String appId);
}
