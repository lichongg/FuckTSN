package com.amap.api.services.interfaces;

import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IWeatherSearch {
    WeatherSearchQuery getQuery();

    void searchWeatherAsyn();

    void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener);

    void setQuery(WeatherSearchQuery weatherSearchQuery);
}
