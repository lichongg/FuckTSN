package com.bytedance.pangle.servermanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() { // from class: com.bytedance.pangle.servermanager.j.1
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

    /* renamed from: j, reason: collision with root package name */
    private final IBinder f25491j;

    j(Parcel parcel) {
        this.f25491j = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder j() {
        return this.f25491j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeStrongBinder(this.f25491j);
    }

    j(IBinder iBinder) {
        this.f25491j = iBinder;
    }
}
