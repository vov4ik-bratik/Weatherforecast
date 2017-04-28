package lessons.vs.petersonapps.weatherforecast.ui;

import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;

import lessons.vs.petersonapps.weatherforecast.R;
import lessons.vs.petersonapps.weatherforecast.api.model.WeatherData;


public class MainActivity extends AppCompatActivity implements WeatherContract.View, OnMapReadyCallback {

    private WeatherContract.Presenter presenter;

    private TextInputLayout searchCity;
    private ImageButton searchButton;
    private TextView cityName;
    private TextView temperature;
    private ImageView weatherCondition;
    private TextView weather;
    private TextView clouds;
    private TextView wind;
    private SupportMapFragment mapFragment;
    private GoogleMap myMap;
    private Marker marker;

    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);
        res = getResources();

        //TODO add all views to array, and use "for" cycle to inigtialize it with "bind" method

        searchCity = (TextInputLayout) findViewById(R.id.city_search_et);
        ((TextInputEditText) findViewById(R.id.test)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty() && searchCity.isErrorEnabled())
                    searchCity.setErrorEnabled(false);
            }
        });

        searchButton = bind(R.id.city_search_btn);
        cityName = (TextView) findViewById(R.id.city_tv);
        temperature = (TextView) findViewById(R.id.temperature_tv);
        weatherCondition = bind(R.id.weather_icon);
        weather = (TextView) findViewById(R.id.weather_tv);
        clouds = (TextView) findViewById(R.id.clouds_percent_tv);
        wind = (TextView) findViewById(R.id.wind_speed_tv);

        searchButton.setOnClickListener(searchButtonClickListener);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.main_activity_map_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        LatLng london = new LatLng(51.514383, -0.079661);
        marker = myMap.addMarker(new MarkerOptions().position(london).title("London"));
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(london, 10), 2000, null);
    }

    private View.OnClickListener searchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.go(searchCity.getEditText().getText().toString());
        }
    };


    @Override
    public void setEmptyCityNameMessage(@StringRes int resId) {
        searchCity.setError(getString(resId));
    }

    @Override
    public void setWeatherData(WeatherData data) {

        searchCity.setErrorEnabled(false);
        cityName.setText(data.getCityName());

        temperature.setText(res.getString(R.string.celsium, String.valueOf(data.getTemperature())));

        weather.setText(data.getweatherDescription());

        clouds.setText(res.getString(R.string.percent, String.valueOf(data.getCoud()), "%"));

        wind.setText(res.getString(R.string.wind_speed, String.valueOf(data.getWind())));

        setWeatherIcon(data);

    }

    private void setWeatherIcon(WeatherData data) {
        switch (data.getIcon()) {

            case "01d": {
                weatherCondition.setImageResource(R.drawable.clear_sky);
                break;
            }
            case "01n": {
                weatherCondition.setImageResource(R.drawable.clear_sky);
                break;
            }

            case "02d": {
                weatherCondition.setImageResource(R.drawable.few_clouds);
                break;
            }
            case "02n": {
                weatherCondition.setImageResource(R.drawable.few_clouds);
                break;
            }

            case "03d": {
                weatherCondition.setImageResource(R.drawable.scattered_clouds);
                break;
            }
            case "03n": {
                weatherCondition.setImageResource(R.drawable.scattered_clouds);
                break;
            }

            case "04d": {
                weatherCondition.setImageResource(R.drawable.broken_clouds);
                break;
            }
            case "04n": {
                weatherCondition.setImageResource(R.drawable.broken_clouds);
                break;
            }

            case "09d": {
                weatherCondition.setImageResource(R.drawable.shower_rain);
                break;
            }
            case "09n": {
                weatherCondition.setImageResource(R.drawable.shower_rain);
                break;
            }

            case "10d": {
                weatherCondition.setImageResource(R.drawable.rain);
                break;
            }
            case "10n": {
                weatherCondition.setImageResource(R.drawable.rain);
                break;
            }

            case "11d": {
                weatherCondition.setImageResource(R.drawable.thunderstorm);
                break;
            }
            case "11n": {
                weatherCondition.setImageResource(R.drawable.thunderstorm);
                break;
            }

            case "13d": {
                weatherCondition.setImageResource(R.drawable.snow);
                break;
            }
            case "13n": {
                weatherCondition.setImageResource(R.drawable.snow);
                break;
            }

            case "50d": {
                weatherCondition.setImageResource(R.drawable.mist);
                break;
            }
            case "50n": {
                weatherCondition.setImageResource(R.drawable.mist);
                break;
            }
        }
    }

    @Override
    public void setMapPoint(WeatherData body) {

        LatLng cityCoordinate = new LatLng(body.getCoordinate().getLat(), body.getCoordinate().getLon());

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(cityCoordinate)
                .zoom(10)
                .build();
        changeCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        myMap.clear();
        marker = myMap.addMarker(new MarkerOptions().title(body.getCityName()).position(cityCoordinate));
        
    }

    private void changeCamera(CameraUpdate cameraUpdate) {
        changeCamera(cameraUpdate, null);
    }

    private void changeCamera(CameraUpdate update, CancelableCallback callback){
        myMap.animateCamera(update, 2000, callback);
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T bind(@IdRes int resId, View view) {
        return ((T) view.findViewById(resId));
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T bind(@IdRes int resId) {
        return ((T) findViewById(resId));
    }

}
