package com.baidu.liantian.core;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.baidu.liantian.core.c.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ c[] newArray(int i6) {
            return new c[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f10397a;

    /* renamed from: b, reason: collision with root package name */
    public int f10398b;

    /* renamed from: c, reason: collision with root package name */
    public String f10399c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f10400d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f10401e;

    /* renamed from: f, reason: collision with root package name */
    public Object f10402f;

    public c() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected c(Parcel parcel) {
        this.f10397a = parcel.readInt();
        this.f10398b = parcel.readInt();
        this.f10399c = parcel.readString();
        this.f10401e = parcel.readArray(c.class.getClassLoader());
        this.f10400d = parcel.readArray(c.class.getClassLoader());
        this.f10402f = parcel.readValue(c.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f10397a);
        parcel.writeInt(this.f10398b);
        parcel.writeString(this.f10399c);
        parcel.writeArray(this.f10401e);
        parcel.writeArray(this.f10400d);
        parcel.writeValue(this.f10402f);
    }
}
