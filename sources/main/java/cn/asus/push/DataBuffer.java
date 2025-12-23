package cn.asus.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes2.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public String f1075a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f1076b;

    protected DataBuffer(Parcel parcel) {
        this.f1075a = parcel.readString();
        this.f1076b = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataBuffer(String str, Bundle bundle) {
        this.f1075a = str;
        this.f1076b = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f1075a);
        parcel.writeBundle(this.f1076b);
    }
}
