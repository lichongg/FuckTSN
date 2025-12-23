package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() { // from class: com.amap.api.services.route.RailwayStationItem.1
        private static RailwayStationItem a(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        private static RailwayStationItem[] a(int i6) {
            return new RailwayStationItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9600a;

    /* renamed from: b, reason: collision with root package name */
    private String f9601b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9602c;

    /* renamed from: d, reason: collision with root package name */
    private String f9603d;

    /* renamed from: e, reason: collision with root package name */
    private String f9604e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9605f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9606g;

    /* renamed from: h, reason: collision with root package name */
    private float f9607h;

    public RailwayStationItem() {
        this.f9605f = false;
        this.f9606g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f9603d;
    }

    public String getID() {
        return this.f9600a;
    }

    public LatLonPoint getLocation() {
        return this.f9602c;
    }

    public String getName() {
        return this.f9601b;
    }

    public String getTime() {
        return this.f9604e;
    }

    public float getWait() {
        return this.f9607h;
    }

    public boolean isEnd() {
        return this.f9606g;
    }

    public boolean isStart() {
        return this.f9605f;
    }

    public void setAdcode(String str) {
        this.f9603d = str;
    }

    public void setID(String str) {
        this.f9600a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f9602c = latLonPoint;
    }

    public void setName(String str) {
        this.f9601b = str;
    }

    public void setTime(String str) {
        this.f9604e = str;
    }

    public void setWait(float f6) {
        this.f9607h = f6;
    }

    public void setisEnd(boolean z5) {
        this.f9606g = z5;
    }

    public void setisStart(boolean z5) {
        this.f9605f = z5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9600a);
        parcel.writeString(this.f9601b);
        parcel.writeParcelable(this.f9602c, i6);
        parcel.writeString(this.f9603d);
        parcel.writeString(this.f9604e);
        parcel.writeBooleanArray(new boolean[]{this.f9605f, this.f9606g});
        parcel.writeFloat(this.f9607h);
    }

    protected RailwayStationItem(Parcel parcel) {
        this.f9605f = false;
        this.f9606g = false;
        this.f9600a = parcel.readString();
        this.f9601b = parcel.readString();
        this.f9602c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9603d = parcel.readString();
        this.f9604e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f9605f = zArr[0];
        this.f9606g = zArr[1];
        this.f9607h = parcel.readFloat();
    }
}
