package lessons.vs.petersonapps.weatherforecast.api;


public interface RestClient {
    <S> S createService(Class<S> serviceClass);
}
