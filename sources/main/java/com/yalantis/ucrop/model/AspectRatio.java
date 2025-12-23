package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f42737a;

    /* renamed from: b, reason: collision with root package name */
    private final float f42738b;

    /* renamed from: c, reason: collision with root package name */
    private final float f42739c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Parcelable.Creator<AspectRatio> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AspectRatio[] newArray(int i6) {
            return new AspectRatio[i6];
        }

        a() {
        }
    }

    public AspectRatio(@Nullable String str, float f6, float f7) {
        this.f42737a = str;
        this.f42738b = f6;
        this.f42739c = f7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String a() {
        return this.f42737a;
    }

    public float b() {
        return this.f42738b;
    }

    public float c() {
        return this.f42739c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f42737a);
        parcel.writeFloat(this.f42738b);
        parcel.writeFloat(this.f42739c);
    }

    protected AspectRatio(Parcel parcel) {
        this.f42737a = parcel.readString();
        this.f42738b = parcel.readFloat();
        this.f42739c = parcel.readFloat();
    }
}
