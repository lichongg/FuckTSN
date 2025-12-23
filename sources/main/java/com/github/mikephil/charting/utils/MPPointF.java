package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> CREATOR;
    private static ObjectPool<MPPointF> pool;

    /* renamed from: x, reason: collision with root package name */
    public float f32565x;

    /* renamed from: y, reason: collision with root package name */
    public float f32566y;

    public MPPointF() {
    }

    public static MPPointF getInstance(float f6, float f7) {
        MPPointF mPPointF = pool.get();
        mPPointF.f32565x = f6;
        mPPointF.f32566y = f7;
        return mPPointF;
    }

    static {
        ObjectPool<MPPointF> create = ObjectPool.create(32, new MPPointF(0.0f, 0.0f));
        pool = create;
        create.setReplenishPercentage(0.5f);
        CREATOR = new Parcelable.Creator<MPPointF>() { // from class: com.github.mikephil.charting.utils.MPPointF.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MPPointF createFromParcel(Parcel parcel) {
                MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
                mPPointF.my_readFromParcel(parcel);
                return mPPointF;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MPPointF[] newArray(int i6) {
                return new MPPointF[i6];
            }
        };
    }

    public MPPointF(float f6, float f7) {
        this.f32565x = f6;
        this.f32566y = f7;
    }

    public static void recycleInstance(MPPointF mPPointF) {
        pool.recycle((ObjectPool<MPPointF>) mPPointF);
    }

    public static void recycleInstances(List<MPPointF> list) {
        pool.recycle(list);
    }

    public float getX() {
        return this.f32565x;
    }

    public float getY() {
        return this.f32566y;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointF(0.0f, 0.0f);
    }

    public void my_readFromParcel(Parcel parcel) {
        this.f32565x = parcel.readFloat();
        this.f32566y = parcel.readFloat();
    }

    public static MPPointF getInstance() {
        return pool.get();
    }

    public static MPPointF getInstance(MPPointF mPPointF) {
        MPPointF mPPointF2 = pool.get();
        mPPointF2.f32565x = mPPointF.f32565x;
        mPPointF2.f32566y = mPPointF.f32566y;
        return mPPointF2;
    }
}
