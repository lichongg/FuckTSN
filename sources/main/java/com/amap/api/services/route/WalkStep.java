package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new Parcelable.Creator<WalkStep>() { // from class: com.amap.api.services.route.WalkStep.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkStep[] newArray(int i6) {
            return null;
        }

        private static WalkStep a(Parcel parcel) {
            return new WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9819a;

    /* renamed from: b, reason: collision with root package name */
    private String f9820b;

    /* renamed from: c, reason: collision with root package name */
    private String f9821c;

    /* renamed from: d, reason: collision with root package name */
    private float f9822d;

    /* renamed from: e, reason: collision with root package name */
    private float f9823e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f9824f;

    /* renamed from: g, reason: collision with root package name */
    private String f9825g;

    /* renamed from: h, reason: collision with root package name */
    private String f9826h;

    /* renamed from: i, reason: collision with root package name */
    private int f9827i;

    public WalkStep(Parcel parcel) {
        this.f9824f = new ArrayList();
        this.f9819a = parcel.readString();
        this.f9820b = parcel.readString();
        this.f9821c = parcel.readString();
        this.f9822d = parcel.readFloat();
        this.f9823e = parcel.readFloat();
        this.f9824f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9825g = parcel.readString();
        this.f9826h = parcel.readString();
        this.f9827i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f9825g;
    }

    public String getAssistantAction() {
        return this.f9826h;
    }

    public float getDistance() {
        return this.f9822d;
    }

    public float getDuration() {
        return this.f9823e;
    }

    public String getInstruction() {
        return this.f9819a;
    }

    public String getOrientation() {
        return this.f9820b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9824f;
    }

    public String getRoad() {
        return this.f9821c;
    }

    public int getRoadType() {
        return this.f9827i;
    }

    public void setAction(String str) {
        this.f9825g = str;
    }

    public void setAssistantAction(String str) {
        this.f9826h = str;
    }

    public void setDistance(float f6) {
        this.f9822d = f6;
    }

    public void setDuration(float f6) {
        this.f9823e = f6;
    }

    public void setInstruction(String str) {
        this.f9819a = str;
    }

    public void setOrientation(String str) {
        this.f9820b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9824f = list;
    }

    public void setRoad(String str) {
        this.f9821c = str;
    }

    public void setRoadType(int i6) {
        this.f9827i = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9819a);
        parcel.writeString(this.f9820b);
        parcel.writeString(this.f9821c);
        parcel.writeFloat(this.f9822d);
        parcel.writeFloat(this.f9823e);
        parcel.writeTypedList(this.f9824f);
        parcel.writeString(this.f9825g);
        parcel.writeString(this.f9826h);
        parcel.writeInt(this.f9827i);
    }

    public WalkStep() {
        this.f9824f = new ArrayList();
    }
}
