package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.b3;
import com.autonavi.base.ae.gmap.maploader.Pools;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
    private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool<>(18);

    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;

    @JBindingInclude
    public final byte[] data;

    @JBindingInclude
    public final int height;

    @JBindingInclude
    private final boolean isBitmap;

    @JBindingInclude
    private final int mVersionCode;

    @JBindingInclude
    public final int width;

    Tile(int i6, int i7, int i8, byte[] bArr, boolean z5) {
        this.mVersionCode = i6;
        this.width = i7;
        this.height = i8;
        this.data = bArr;
        if (bArr != null) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                b3.B(decodeByteArray);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.isBitmap = z5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static Tile obtain(int i6, int i7, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i6, i7, bArr);
    }

    public final void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }

    public Tile(int i6, int i7, byte[] bArr) {
        this(1, i6, i7, bArr, true);
    }

    public Tile(int i6, int i7, byte[] bArr, boolean z5) {
        this(1, i6, i7, bArr, z5);
    }
}
