package com.ss.android.socialbase.downloader.up;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j extends Exception implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() { // from class: com.ss.android.socialbase.downloader.up.j.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i6) {
            return new j[i6];
        }
    };
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f38982j;
    private String xt;

    public j() {
        this.cw = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void j(String str) {
        this.xt = str;
    }

    public String xt() {
        return this.xt;
    }

    public String cw() {
        return this.cw;
    }

    public void j(Parcel parcel) {
        this.f38982j = parcel.readInt();
        this.xt = parcel.readString();
        this.cw = parcel.readString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.f38982j + ", errorMsg='" + this.xt + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f38982j);
        parcel.writeString(this.xt);
        parcel.writeString(this.cw);
    }

    public void xt(String str) {
        this.cw = str;
    }

    public j(int i6, String str) {
        super("[d-ex]:".concat(String.valueOf(str)));
        this.cw = "";
        this.xt = "[d-ex]:".concat(String.valueOf(str));
        this.f38982j = i6;
    }

    public int j() {
        return this.f38982j;
    }

    public j(int i6, Throwable th) {
        this(i6, com.ss.android.socialbase.downloader.az.m.oq(th));
    }

    protected j(Parcel parcel) {
        this.cw = "";
        j(parcel);
    }
}
