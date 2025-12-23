package com.amap.api.services.weather;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LocalWeatherForecastResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f9873a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherForecast f9874b;

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.f9874b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f9873a;
    }

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f9873a = weatherSearchQuery;
        this.f9874b = localWeatherForecast;
    }
}
