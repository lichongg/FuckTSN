package com.amap.api.services.weather;

import com.amap.api.col.s.j4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f9887a;

    /* renamed from: b, reason: collision with root package name */
    private int f9888b;

    public WeatherSearchQuery(String str, int i6) {
        this.f9887a = str;
        this.f9888b = i6;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WeatherSearchQuery m84clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e6) {
            j4.i(e6, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f9887a, this.f9888b);
    }

    public String getCity() {
        return this.f9887a;
    }

    public int getType() {
        return this.f9888b;
    }

    public WeatherSearchQuery() {
        this.f9888b = 1;
    }
}
