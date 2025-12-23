package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.b3;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a, reason: collision with root package name */
    int f8960a;

    /* renamed from: b, reason: collision with root package name */
    int f8961b;

    @JBindingInclude
    protected Object mBitmap;

    @JBindingInclude
    private String mId;

    BitmapDescriptor(Bitmap bitmap, String str) {
        this.f8960a = 0;
        this.f8961b = 0;
        if (bitmap != null) {
            try {
                this.f8960a = bitmap.getWidth();
                this.f8961b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.mBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.mBitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th) {
                b3.D(th);
                return;
            }
        }
        this.mId = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final BitmapDescriptor m49clone() {
        try {
            Object obj = this.mBitmap;
            return new BitmapDescriptor(((Bitmap) obj).copy(((Bitmap) obj).getConfig(), true), this.f8960a, this.f8961b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
            return null;
        }
    }

    public final boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Object obj2;
        Object obj3 = this.mBitmap;
        if (obj3 == null || ((Bitmap) obj3).isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (BitmapDescriptor.class == obj.getClass() && (obj2 = (bitmapDescriptor = (BitmapDescriptor) obj).mBitmap) != null && !((Bitmap) obj2).isRecycled() && this.f8960a == bitmapDescriptor.getWidth() && this.f8961b == bitmapDescriptor.getHeight()) {
            try {
                return ((Bitmap) this.mBitmap).sameAs((Bitmap) bitmapDescriptor.mBitmap);
            } catch (Throwable th) {
                b3.D(th);
            }
        }
        return false;
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public final int getHeight() {
        return this.f8961b;
    }

    public final String getId() {
        return this.mId;
    }

    public final int getWidth() {
        return this.f8960a;
    }

    public final void recycle() {
        try {
            b3.B((Bitmap) this.mBitmap);
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((Bitmap) this.mBitmap, i6);
        parcel.writeInt(this.f8960a);
        parcel.writeInt(this.f8961b);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    private BitmapDescriptor(Bitmap bitmap, int i6, int i7, String str) {
        this.f8960a = i6;
        this.f8961b = i7;
        this.mBitmap = bitmap;
        this.mId = str;
    }
}
