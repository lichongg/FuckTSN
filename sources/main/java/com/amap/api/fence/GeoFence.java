package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() { // from class: com.amap.api.fence.GeoFence.1
        private static GeoFence a(Parcel parcel) {
            return new GeoFence(parcel);
        }

        private static GeoFence[] a(int i6) {
            return new GeoFence[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence[] newArray(int i6) {
            return a(i6);
        }
    };
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f8789a;

    /* renamed from: b, reason: collision with root package name */
    private String f8790b;

    /* renamed from: c, reason: collision with root package name */
    private String f8791c;

    /* renamed from: d, reason: collision with root package name */
    private PendingIntent f8792d;

    /* renamed from: e, reason: collision with root package name */
    private int f8793e;

    /* renamed from: f, reason: collision with root package name */
    private PoiItem f8794f;

    /* renamed from: g, reason: collision with root package name */
    private List<DistrictItem> f8795g;

    /* renamed from: h, reason: collision with root package name */
    private List<List<DPoint>> f8796h;

    /* renamed from: i, reason: collision with root package name */
    private float f8797i;

    /* renamed from: j, reason: collision with root package name */
    private long f8798j;

    /* renamed from: k, reason: collision with root package name */
    private int f8799k;

    /* renamed from: l, reason: collision with root package name */
    private float f8800l;

    /* renamed from: m, reason: collision with root package name */
    private float f8801m;

    /* renamed from: n, reason: collision with root package name */
    private DPoint f8802n;

    /* renamed from: o, reason: collision with root package name */
    private int f8803o;

    /* renamed from: p, reason: collision with root package name */
    private long f8804p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8805q;

    /* renamed from: r, reason: collision with root package name */
    private AMapLocation f8806r;

    public GeoFence() {
        this.f8792d = null;
        this.f8793e = 0;
        this.f8794f = null;
        this.f8795g = null;
        this.f8797i = 0.0f;
        this.f8798j = -1L;
        this.f8799k = 1;
        this.f8800l = 0.0f;
        this.f8801m = 0.0f;
        this.f8802n = null;
        this.f8803o = 0;
        this.f8804p = -1L;
        this.f8805q = true;
        this.f8806r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.f8790b)) {
            if (!TextUtils.isEmpty(geoFence.f8790b)) {
                return false;
            }
        } else if (!this.f8790b.equals(geoFence.f8790b)) {
            return false;
        }
        DPoint dPoint = this.f8802n;
        if (dPoint == null) {
            if (geoFence.f8802n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.f8802n)) {
            return false;
        }
        if (this.f8797i != geoFence.f8797i) {
            return false;
        }
        List<List<DPoint>> list = this.f8796h;
        return list == null ? geoFence.f8796h == null : list.equals(geoFence.f8796h);
    }

    public int getActivatesAction() {
        return this.f8799k;
    }

    public DPoint getCenter() {
        return this.f8802n;
    }

    public AMapLocation getCurrentLocation() {
        return this.f8806r;
    }

    public String getCustomId() {
        return this.f8790b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.f8795g;
    }

    public long getEnterTime() {
        return this.f8804p;
    }

    public long getExpiration() {
        return this.f8798j;
    }

    public String getFenceId() {
        return this.f8789a;
    }

    public float getMaxDis2Center() {
        return this.f8801m;
    }

    public float getMinDis2Center() {
        return this.f8800l;
    }

    public PendingIntent getPendingIntent() {
        return this.f8792d;
    }

    public String getPendingIntentAction() {
        return this.f8791c;
    }

    public PoiItem getPoiItem() {
        return this.f8794f;
    }

    public List<List<DPoint>> getPointList() {
        return this.f8796h;
    }

    public float getRadius() {
        return this.f8797i;
    }

    public int getStatus() {
        return this.f8803o;
    }

    public int getType() {
        return this.f8793e;
    }

    public int hashCode() {
        return this.f8790b.hashCode() + this.f8796h.hashCode() + this.f8802n.hashCode() + ((int) (this.f8797i * 100.0f));
    }

    public boolean isAble() {
        return this.f8805q;
    }

    public void setAble(boolean z5) {
        this.f8805q = z5;
    }

    public void setActivatesAction(int i6) {
        this.f8799k = i6;
    }

    public void setCenter(DPoint dPoint) {
        this.f8802n = dPoint;
    }

    public void setCustomId(String str) {
        this.f8790b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.f8795g = list;
    }

    public void setEnterTime(long j6) {
        this.f8804p = j6;
    }

    public void setExpiration(long j6) {
        if (j6 < 0) {
            this.f8798j = -1L;
        } else {
            this.f8798j = j6 + j.b();
        }
    }

    public void setFenceId(String str) {
        this.f8789a = str;
    }

    public void setMaxDis2Center(float f6) {
        this.f8801m = f6;
    }

    public void setMinDis2Center(float f6) {
        this.f8800l = f6;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.f8792d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.f8791c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f8794f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.f8796h = list;
    }

    public void setRadius(float f6) {
        this.f8797i = f6;
    }

    public void setStatus(int i6) {
        this.f8803o = i6;
    }

    public void setType(int i6) {
        this.f8793e = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f8789a);
        parcel.writeString(this.f8790b);
        parcel.writeString(this.f8791c);
        parcel.writeParcelable(this.f8792d, i6);
        parcel.writeInt(this.f8793e);
        parcel.writeParcelable(this.f8794f, i6);
        parcel.writeTypedList(this.f8795g);
        parcel.writeFloat(this.f8797i);
        parcel.writeLong(this.f8798j);
        parcel.writeInt(this.f8799k);
        parcel.writeFloat(this.f8800l);
        parcel.writeFloat(this.f8801m);
        parcel.writeParcelable(this.f8802n, i6);
        parcel.writeInt(this.f8803o);
        parcel.writeLong(this.f8804p);
        List<List<DPoint>> list = this.f8796h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.f8796h.size());
            Iterator<List<DPoint>> it = this.f8796h.iterator();
            while (it.hasNext()) {
                parcel.writeTypedList(it.next());
            }
        }
        parcel.writeByte(this.f8805q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f8806r, i6);
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.f8806r = aMapLocation.m45clone();
    }

    protected GeoFence(Parcel parcel) {
        this.f8792d = null;
        this.f8793e = 0;
        this.f8794f = null;
        this.f8795g = null;
        this.f8797i = 0.0f;
        this.f8798j = -1L;
        this.f8799k = 1;
        this.f8800l = 0.0f;
        this.f8801m = 0.0f;
        this.f8802n = null;
        this.f8803o = 0;
        this.f8804p = -1L;
        this.f8805q = true;
        this.f8806r = null;
        this.f8789a = parcel.readString();
        this.f8790b = parcel.readString();
        this.f8791c = parcel.readString();
        this.f8792d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f8793e = parcel.readInt();
        this.f8794f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.f8795g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.f8797i = parcel.readFloat();
        this.f8798j = parcel.readLong();
        this.f8799k = parcel.readInt();
        this.f8800l = parcel.readFloat();
        this.f8801m = parcel.readFloat();
        this.f8802n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.f8803o = parcel.readInt();
        this.f8804p = parcel.readLong();
        int readInt = parcel.readInt();
        if (readInt != 0) {
            this.f8796h = new ArrayList();
            for (int i6 = 0; i6 < readInt; i6++) {
                this.f8796h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.f8805q = parcel.readByte() != 0;
        this.f8806r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}
