package com.amap.api.col.p0003l;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public final class eo extends BaseOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<eo> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    private float f6147b;

    /* renamed from: c, reason: collision with root package name */
    private float f6148c;

    /* renamed from: d, reason: collision with root package name */
    private float f6149d;

    /* renamed from: e, reason: collision with root package name */
    private float f6150e;

    /* renamed from: f, reason: collision with root package name */
    private float f6151f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6152g;

    /* renamed from: h, reason: collision with root package name */
    private int f6153h;

    /* renamed from: i, reason: collision with root package name */
    private double f6154i;

    /* renamed from: j, reason: collision with root package name */
    private List<l3> f6155j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Parcelable.Creator<eo> {
        private static eo a(Parcel parcel) {
            return new eo(parcel);
        }

        private static eo[] b(int i6) {
            return new eo[i6];
        }

        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eo[] newArray(int i6) {
            return b(i6);
        }
    }

    public eo() {
        this.f6147b = 3.0f;
        this.f6148c = 20.0f;
        this.f6149d = Float.MIN_VALUE;
        this.f6150e = Float.MAX_VALUE;
        this.f6151f = 200.0f;
        this.f6152g = true;
        this.f6153h = -3355444;
        this.f6154i = 3.0d;
        this.f6155j = new ArrayList();
        this.type = "ContourLineOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f6147b);
        parcel.writeFloat(this.f6148c);
        parcel.writeFloat(this.f6149d);
        parcel.writeFloat(this.f6150e);
        parcel.writeFloat(this.f6151f);
        parcel.writeBooleanArray(new boolean[]{this.f6152g});
        parcel.writeInt(this.f6153h);
        parcel.writeDouble(this.f6154i);
        parcel.writeList(this.f6155j);
    }

    @JBindingExclude
    protected eo(Parcel parcel) {
        this.f6147b = 3.0f;
        this.f6148c = 20.0f;
        this.f6149d = Float.MIN_VALUE;
        this.f6150e = Float.MAX_VALUE;
        this.f6151f = 200.0f;
        this.f6152g = true;
        this.f6153h = -3355444;
        this.f6154i = 3.0d;
        this.f6155j = new ArrayList();
        this.f6147b = parcel.readFloat();
        this.f6148c = parcel.readFloat();
        this.f6149d = parcel.readFloat();
        this.f6150e = parcel.readFloat();
        this.f6151f = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f6152g = zArr[0];
        this.f6153h = parcel.readInt();
        this.f6154i = parcel.readDouble();
        this.f6155j = parcel.readArrayList(l3.class.getClassLoader());
    }
}
