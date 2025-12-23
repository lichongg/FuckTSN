package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new Parcelable.Creator<RideStep>() { // from class: com.amap.api.services.route.RideStep.1
        private static RideStep a(Parcel parcel) {
            return new RideStep(parcel);
        }

        private static RideStep[] a(int i6) {
            return new RideStep[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9613a;

    /* renamed from: b, reason: collision with root package name */
    private String f9614b;

    /* renamed from: c, reason: collision with root package name */
    private String f9615c;

    /* renamed from: d, reason: collision with root package name */
    private float f9616d;

    /* renamed from: e, reason: collision with root package name */
    private float f9617e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f9618f;

    /* renamed from: g, reason: collision with root package name */
    private String f9619g;

    /* renamed from: h, reason: collision with root package name */
    private String f9620h;

    /* renamed from: i, reason: collision with root package name */
    private int f9621i;

    public RideStep() {
        this.f9618f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f9619g;
    }

    public String getAssistantAction() {
        return this.f9620h;
    }

    public float getDistance() {
        return this.f9616d;
    }

    public float getDuration() {
        return this.f9617e;
    }

    public String getInstruction() {
        return this.f9613a;
    }

    public String getOrientation() {
        return this.f9614b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9618f;
    }

    public String getRoad() {
        return this.f9615c;
    }

    public int getRoadType() {
        return this.f9621i;
    }

    public void setAction(String str) {
        this.f9619g = str;
    }

    public void setAssistantAction(String str) {
        this.f9620h = str;
    }

    public void setDistance(float f6) {
        this.f9616d = f6;
    }

    public void setDuration(float f6) {
        this.f9617e = f6;
    }

    public void setInstruction(String str) {
        this.f9613a = str;
    }

    public void setOrientation(String str) {
        this.f9614b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9618f = list;
    }

    public void setRoad(String str) {
        this.f9615c = str;
    }

    public void setRoadType(int i6) {
        this.f9621i = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9613a);
        parcel.writeString(this.f9614b);
        parcel.writeString(this.f9615c);
        parcel.writeFloat(this.f9616d);
        parcel.writeFloat(this.f9617e);
        parcel.writeTypedList(this.f9618f);
        parcel.writeString(this.f9619g);
        parcel.writeString(this.f9620h);
    }

    protected RideStep(Parcel parcel) {
        this.f9618f = new ArrayList();
        this.f9613a = parcel.readString();
        this.f9614b = parcel.readString();
        this.f9615c = parcel.readString();
        this.f9616d = parcel.readFloat();
        this.f9617e = parcel.readFloat();
        this.f9618f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9619g = parcel.readString();
        this.f9620h = parcel.readString();
    }
}
