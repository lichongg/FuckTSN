package com.ss.android.downloadlib.j.j;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt implements Parcelable {
    public static final Parcelable.Creator<xt> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f38188a;

    /* renamed from: b, reason: collision with root package name */
    public int f38189b;

    /* renamed from: c, reason: collision with root package name */
    public String f38190c;

    /* renamed from: d, reason: collision with root package name */
    public int f38191d;

    /* renamed from: e, reason: collision with root package name */
    public String f38192e;

    /* renamed from: f, reason: collision with root package name */
    public String f38193f;

    static class a implements Parcelable.Creator<xt> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public xt createFromParcel(Parcel parcel) {
            return new xt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public xt[] newArray(int i6) {
            return new xt[i6];
        }

        a() {
        }
    }

    public xt() {
        this.f38190c = "";
        this.f38192e = "";
        this.f38193f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            xt xtVar = (xt) obj;
            if (this.f38188a == xtVar.f38188a && this.f38189b == xtVar.f38189b) {
                String str = this.f38190c;
                if (str != null) {
                    return str.equals(xtVar.f38190c);
                }
                if (xtVar.f38190c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i6 = ((this.f38188a * 31) + this.f38189b) * 31;
        String str = this.f38190c;
        return i6 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f38188a);
        parcel.writeInt(this.f38189b);
        parcel.writeString(this.f38190c);
        parcel.writeString(this.f38192e);
        parcel.writeString(this.f38193f);
        parcel.writeInt(this.f38191d);
    }

    protected xt(Parcel parcel) {
        this.f38190c = "";
        this.f38192e = "";
        this.f38193f = "";
        this.f38188a = parcel.readInt();
        this.f38189b = parcel.readInt();
        this.f38190c = parcel.readString();
        this.f38192e = parcel.readString();
        this.f38193f = parcel.readString();
        this.f38191d = parcel.readInt();
    }
}
