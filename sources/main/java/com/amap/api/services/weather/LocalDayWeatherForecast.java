package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new Parcelable.Creator<LocalDayWeatherForecast>() { // from class: com.amap.api.services.weather.LocalDayWeatherForecast.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i6) {
            return null;
        }

        private static LocalDayWeatherForecast a(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9858a;

    /* renamed from: b, reason: collision with root package name */
    private String f9859b;

    /* renamed from: c, reason: collision with root package name */
    private String f9860c;

    /* renamed from: d, reason: collision with root package name */
    private String f9861d;

    /* renamed from: e, reason: collision with root package name */
    private String f9862e;

    /* renamed from: f, reason: collision with root package name */
    private String f9863f;

    /* renamed from: g, reason: collision with root package name */
    private String f9864g;

    /* renamed from: h, reason: collision with root package name */
    private String f9865h;

    /* renamed from: i, reason: collision with root package name */
    private String f9866i;

    /* renamed from: j, reason: collision with root package name */
    private String f9867j;

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f9858a = parcel.readString();
        this.f9859b = parcel.readString();
        this.f9860c = parcel.readString();
        this.f9861d = parcel.readString();
        this.f9862e = parcel.readString();
        this.f9863f = parcel.readString();
        this.f9864g = parcel.readString();
        this.f9865h = parcel.readString();
        this.f9866i = parcel.readString();
        this.f9867j = parcel.readString();
    }

    public String getDate() {
        return this.f9858a;
    }

    public String getDayTemp() {
        return this.f9862e;
    }

    public String getDayWeather() {
        return this.f9860c;
    }

    public String getDayWindDirection() {
        return this.f9864g;
    }

    public String getDayWindPower() {
        return this.f9866i;
    }

    public String getNightTemp() {
        return this.f9863f;
    }

    public String getNightWeather() {
        return this.f9861d;
    }

    public String getNightWindDirection() {
        return this.f9865h;
    }

    public String getNightWindPower() {
        return this.f9867j;
    }

    public String getWeek() {
        return this.f9859b;
    }

    public void setDate(String str) {
        this.f9858a = str;
    }

    public void setDayTemp(String str) {
        this.f9862e = str;
    }

    public void setDayWeather(String str) {
        this.f9860c = str;
    }

    public void setDayWindDirection(String str) {
        this.f9864g = str;
    }

    public void setDayWindPower(String str) {
        this.f9866i = str;
    }

    public void setNightTemp(String str) {
        this.f9863f = str;
    }

    public void setNightWeather(String str) {
        this.f9861d = str;
    }

    public void setNightWindDirection(String str) {
        this.f9865h = str;
    }

    public void setNightWindPower(String str) {
        this.f9867j = str;
    }

    public void setWeek(String str) {
        this.f9859b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9858a);
        parcel.writeString(this.f9859b);
        parcel.writeString(this.f9860c);
        parcel.writeString(this.f9861d);
        parcel.writeString(this.f9862e);
        parcel.writeString(this.f9863f);
        parcel.writeString(this.f9864g);
        parcel.writeString(this.f9865h);
        parcel.writeString(this.f9866i);
        parcel.writeString(this.f9867j);
    }
}
