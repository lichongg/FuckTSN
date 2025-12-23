package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i6) {
            return new StrategyBean[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static String f39607a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b, reason: collision with root package name */
    public static String f39608b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public static String f39609c;

    /* renamed from: d, reason: collision with root package name */
    public long f39610d;

    /* renamed from: e, reason: collision with root package name */
    public long f39611e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39612f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39613g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39614h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39615i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39616j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39617k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39618l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f39619m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f39620n;

    /* renamed from: o, reason: collision with root package name */
    public long f39621o;

    /* renamed from: p, reason: collision with root package name */
    public long f39622p;

    /* renamed from: q, reason: collision with root package name */
    public String f39623q;

    /* renamed from: r, reason: collision with root package name */
    public String f39624r;

    /* renamed from: s, reason: collision with root package name */
    public String f39625s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, String> f39626t;

    /* renamed from: u, reason: collision with root package name */
    public int f39627u;

    /* renamed from: v, reason: collision with root package name */
    public long f39628v;

    /* renamed from: w, reason: collision with root package name */
    public long f39629w;

    public StrategyBean() {
        this.f39610d = -1L;
        this.f39611e = -1L;
        this.f39612f = true;
        this.f39613g = true;
        this.f39614h = true;
        this.f39615i = true;
        this.f39616j = false;
        this.f39617k = true;
        this.f39618l = true;
        this.f39619m = true;
        this.f39620n = true;
        this.f39622p = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f39623q = f39607a;
        this.f39624r = f39608b;
        this.f39627u = 10;
        this.f39628v = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.f39629w = -1L;
        this.f39611e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        f39609c = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.f39625s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f39611e);
        parcel.writeByte(this.f39612f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39613g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39614h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39623q);
        parcel.writeString(this.f39624r);
        parcel.writeString(this.f39625s);
        ap.b(parcel, this.f39626t);
        parcel.writeByte(this.f39615i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39616j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39619m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39620n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f39622p);
        parcel.writeByte(this.f39617k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39618l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f39621o);
        parcel.writeInt(this.f39627u);
        parcel.writeLong(this.f39628v);
        parcel.writeLong(this.f39629w);
    }

    public StrategyBean(Parcel parcel) {
        this.f39610d = -1L;
        this.f39611e = -1L;
        boolean z5 = true;
        this.f39612f = true;
        this.f39613g = true;
        this.f39614h = true;
        this.f39615i = true;
        this.f39616j = false;
        this.f39617k = true;
        this.f39618l = true;
        this.f39619m = true;
        this.f39620n = true;
        this.f39622p = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f39623q = f39607a;
        this.f39624r = f39608b;
        this.f39627u = 10;
        this.f39628v = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.f39629w = -1L;
        try {
            f39609c = "S(@L@L@)";
            this.f39611e = parcel.readLong();
            this.f39612f = parcel.readByte() == 1;
            this.f39613g = parcel.readByte() == 1;
            this.f39614h = parcel.readByte() == 1;
            this.f39623q = parcel.readString();
            this.f39624r = parcel.readString();
            this.f39625s = parcel.readString();
            this.f39626t = ap.b(parcel);
            this.f39615i = parcel.readByte() == 1;
            this.f39616j = parcel.readByte() == 1;
            this.f39619m = parcel.readByte() == 1;
            this.f39620n = parcel.readByte() == 1;
            this.f39622p = parcel.readLong();
            this.f39617k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z5 = false;
            }
            this.f39618l = z5;
            this.f39621o = parcel.readLong();
            this.f39627u = parcel.readInt();
            this.f39628v = parcel.readLong();
            this.f39629w = parcel.readLong();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
