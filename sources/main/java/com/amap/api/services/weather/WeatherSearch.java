package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.s.w0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private IWeatherSearch f9886a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i6);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i6);
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.f9886a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.f9886a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.f9886a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.f9886a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }

    public WeatherSearch(Context context) throws AMapException {
        this.f9886a = null;
        try {
            this.f9886a = new w0(context);
        } catch (Exception e6) {
            e6.printStackTrace();
            if (!(e6 instanceof AMapException)) {
            } else {
                throw ((AMapException) e6);
            }
        }
    }
}
