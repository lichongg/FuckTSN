package com.bytedance.adsdk.ugeno.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j implements Parcelable {
    private final Parcelable xt;

    /* renamed from: j, reason: collision with root package name */
    public static final j f23803j = new j() { // from class: com.bytedance.adsdk.ugeno.viewpager.j.1
    };
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.ClassLoaderCreator<j>() { // from class: com.bytedance.adsdk.ugeno.viewpager.j.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return j.f23803j;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i6) {
            return new j[i6];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private j() {
        this.xt = null;
    }

    public final Parcelable j() {
        return this.xt;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.xt, i6);
    }

    protected j(Parcelable parcelable) {
        if (parcelable != null) {
            this.xt = parcelable == f23803j ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected j(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.xt = readParcelable == null ? f23803j : readParcelable;
    }
}
