package lessons.vs.petersonapps.weatherforecast.ui;

import lessons.vs.petersonapps.weatherforecast.R;
import lessons.vs.petersonapps.weatherforecast.api.model.WeatherData;
import lessons.vs.petersonapps.weatherforecast.api.service.WeatherClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class Presenter implements WeatherContract.Presenter{

    private final WeatherContract.View view;
    private WeatherClient client;

    Presenter(WeatherContract.View view) {
        this.view = view;
        this.client = WeatherApp.getRestClient()
                .createService(WeatherClient.class);
    }

    @Override
    public void go(String cityName) {
        if (cityName.isEmpty()) {
            view.setEmptyCityNameMessage(R.string.empty_city_name_message);
        } else {
            Call<WeatherData> call = client.currentWeather(cityName, "d9d574e8ecfc255ec548a95388f7a9be");
            call.enqueue(new Callback<WeatherData>() {
                @Override
                public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                    view.setWeatherData(response.body());
                    view.setMapPoint(response.body());
                }

                @Override
                public void onFailure(Call<WeatherData> call, Throwable t) {

                }
            });
        }
    }
}
