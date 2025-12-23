package com.amap.api.services.weather;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LocalWeatherLiveResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f9884a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherLive f9885b;

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.f9885b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f9884a;
    }

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f9884a = weatherSearchQuery;
        this.f9885b = localWeatherLive;
    }
}
