package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() { // from class: com.amap.api.services.route.TimeInfosElement.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i6) {
            return null;
        }

        private static TimeInfosElement a(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    int f9784a;

    /* renamed from: b, reason: collision with root package name */
    float f9785b;

    /* renamed from: c, reason: collision with root package name */
    float f9786c;

    /* renamed from: d, reason: collision with root package name */
    int f9787d;

    /* renamed from: e, reason: collision with root package name */
    private List<TMC> f9788e;

    public TimeInfosElement(Parcel parcel) {
        this.f9788e = new ArrayList();
        this.f9784a = parcel.readInt();
        this.f9785b = parcel.readFloat();
        this.f9786c = parcel.readFloat();
        this.f9787d = parcel.readInt();
        this.f9788e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.f9785b;
    }

    public int getPathindex() {
        return this.f9784a;
    }

    public int getRestriction() {
        return this.f9787d;
    }

    public List<TMC> getTMCs() {
        return this.f9788e;
    }

    public float getTolls() {
        return this.f9786c;
    }

    public void setDuration(float f6) {
        this.f9785b = f6;
    }

    public void setPathindex(int i6) {
        this.f9784a = i6;
    }

    public void setRestriction(int i6) {
        this.f9787d = i6;
    }

    public void setTMCs(List<TMC> list) {
        this.f9788e = list;
    }

    public void setTolls(float f6) {
        this.f9786c = f6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f9784a);
        parcel.writeFloat(this.f9785b);
        parcel.writeFloat(this.f9786c);
        parcel.writeInt(this.f9787d);
        parcel.writeTypedList(this.f9788e);
    }

    public TimeInfosElement() {
        this.f9788e = new ArrayList();
    }
}
