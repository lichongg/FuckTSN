package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new Parcelable.Creator<LocalWeatherForecast>() { // from class: com.amap.api.services.weather.LocalWeatherForecast.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i6) {
            return null;
        }

        private static LocalWeatherForecast a(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9868a;

    /* renamed from: b, reason: collision with root package name */
    private String f9869b;

    /* renamed from: c, reason: collision with root package name */
    private String f9870c;

    /* renamed from: d, reason: collision with root package name */
    private String f9871d;

    /* renamed from: e, reason: collision with root package name */
    private List<LocalDayWeatherForecast> f9872e;

    public LocalWeatherForecast() {
        this.f9872e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f9870c;
    }

    public String getCity() {
        return this.f9869b;
    }

    public String getProvince() {
        return this.f9868a;
    }

    public String getReportTime() {
        return this.f9871d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.f9872e;
    }

    public void setAdCode(String str) {
        this.f9870c = str;
    }

    public void setCity(String str) {
        this.f9869b = str;
    }

    public void setProvince(String str) {
        this.f9868a = str;
    }

    public void setReportTime(String str) {
        this.f9871d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.f9872e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9868a);
        parcel.writeString(this.f9869b);
        parcel.writeString(this.f9870c);
        parcel.writeString(this.f9871d);
        parcel.writeList(this.f9872e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.f9872e = new ArrayList();
        this.f9868a = parcel.readString();
        this.f9869b = parcel.readString();
        this.f9870c = parcel.readString();
        this.f9871d = parcel.readString();
        this.f9872e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
