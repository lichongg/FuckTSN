package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new Parcelable.Creator<LocalWeatherLive>() { // from class: com.amap.api.services.weather.LocalWeatherLive.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i6) {
            return null;
        }

        private static LocalWeatherLive a(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherLive createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9875a;

    /* renamed from: b, reason: collision with root package name */
    private String f9876b;

    /* renamed from: c, reason: collision with root package name */
    private String f9877c;

    /* renamed from: d, reason: collision with root package name */
    private String f9878d;

    /* renamed from: e, reason: collision with root package name */
    private String f9879e;

    /* renamed from: f, reason: collision with root package name */
    private String f9880f;

    /* renamed from: g, reason: collision with root package name */
    private String f9881g;

    /* renamed from: h, reason: collision with root package name */
    private String f9882h;

    /* renamed from: i, reason: collision with root package name */
    private String f9883i;

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f9875a = parcel.readString();
        this.f9876b = parcel.readString();
        this.f9877c = parcel.readString();
        this.f9878d = parcel.readString();
        this.f9879e = parcel.readString();
        this.f9880f = parcel.readString();
        this.f9881g = parcel.readString();
        this.f9882h = parcel.readString();
        this.f9883i = parcel.readString();
    }

    public String getAdCode() {
        return this.f9877c;
    }

    public String getCity() {
        return this.f9876b;
    }

    public String getHumidity() {
        return this.f9882h;
    }

    public String getProvince() {
        return this.f9875a;
    }

    public String getReportTime() {
        return this.f9883i;
    }

    public String getTemperature() {
        return this.f9879e;
    }

    public String getWeather() {
        return this.f9878d;
    }

    public String getWindDirection() {
        return this.f9880f;
    }

    public String getWindPower() {
        return this.f9881g;
    }

    public void setAdCode(String str) {
        this.f9877c = str;
    }

    public void setCity(String str) {
        this.f9876b = str;
    }

    public void setHumidity(String str) {
        this.f9882h = str;
    }

    public void setProvince(String str) {
        this.f9875a = str;
    }

    public void setReportTime(String str) {
        this.f9883i = str;
    }

    public void setTemperature(String str) {
        this.f9879e = str;
    }

    public void setWeather(String str) {
        this.f9878d = str;
    }

    public void setWindDirection(String str) {
        this.f9880f = str;
    }

    public void setWindPower(String str) {
        this.f9881g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9875a);
        parcel.writeString(this.f9876b);
        parcel.writeString(this.f9877c);
        parcel.writeString(this.f9878d);
        parcel.writeString(this.f9879e);
        parcel.writeString(this.f9880f);
        parcel.writeString(this.f9881g);
        parcel.writeString(this.f9882h);
        parcel.writeString(this.f9883i);
    }
}
