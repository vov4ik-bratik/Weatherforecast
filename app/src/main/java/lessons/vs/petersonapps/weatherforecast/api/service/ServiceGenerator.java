package lessons.vs.petersonapps.weatherforecast.api.service;

import android.util.Log;

import java.io.IOException;

import lessons.vs.petersonapps.weatherforecast.BuildConfig;
import lessons.vs.petersonapps.weatherforecast.api.RestClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class ServiceGenerator implements RestClient {

    private Retrofit retrofit;
    private static final String API_KEY = "d9d574e8ecfc255ec548a95388f7a9be";

    public ServiceGenerator() {
        init();
    }

    private void init() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.LOG_MODE)
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        else interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new MyIntceptor())
                .build();

        this.retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    class MyIntceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            //check if token is valid
            //do smth
            Log.d("myTag", "intercept: ");
            Request request = chain.request().newBuilder().addHeader("Content-Type", "application/json").build();
            return chain.proceed(request);
        }
    }
}
