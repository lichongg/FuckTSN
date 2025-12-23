package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ap;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i6) {
            return new CrashDetailBean[i6];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public long Q;
    public boolean R;
    public Map<String, String> S;
    public Map<String, String> T;
    public int U;
    public int V;
    public Map<String, String> W;
    public Map<String, String> X;
    public byte[] Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public long f39630a;
    public String aa;

    /* renamed from: b, reason: collision with root package name */
    public int f39631b;

    /* renamed from: c, reason: collision with root package name */
    public String f39632c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39633d;

    /* renamed from: e, reason: collision with root package name */
    public String f39634e;

    /* renamed from: f, reason: collision with root package name */
    public String f39635f;

    /* renamed from: g, reason: collision with root package name */
    public String f39636g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f39637h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f39638i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39639j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39640k;

    /* renamed from: l, reason: collision with root package name */
    public int f39641l;

    /* renamed from: m, reason: collision with root package name */
    public String f39642m;

    /* renamed from: n, reason: collision with root package name */
    public String f39643n;

    /* renamed from: o, reason: collision with root package name */
    public String f39644o;

    /* renamed from: p, reason: collision with root package name */
    public String f39645p;

    /* renamed from: q, reason: collision with root package name */
    public String f39646q;

    /* renamed from: r, reason: collision with root package name */
    public long f39647r;

    /* renamed from: s, reason: collision with root package name */
    public String f39648s;

    /* renamed from: t, reason: collision with root package name */
    public int f39649t;

    /* renamed from: u, reason: collision with root package name */
    public String f39650u;

    /* renamed from: v, reason: collision with root package name */
    public String f39651v;

    /* renamed from: w, reason: collision with root package name */
    public String f39652w;

    /* renamed from: x, reason: collision with root package name */
    public String f39653x;

    /* renamed from: y, reason: collision with root package name */
    public byte[] f39654y;

    /* renamed from: z, reason: collision with root package name */
    public Map<String, String> f39655z;

    public CrashDetailBean() {
        this.f39630a = -1L;
        this.f39631b = 0;
        this.f39632c = UUID.randomUUID().toString();
        this.f39633d = false;
        this.f39634e = "";
        this.f39635f = "";
        this.f39636g = "";
        this.f39637h = null;
        this.f39638i = null;
        this.f39639j = false;
        this.f39640k = false;
        this.f39641l = 0;
        this.f39642m = "";
        this.f39643n = "";
        this.f39644o = "";
        this.f39645p = "";
        this.f39646q = "";
        this.f39647r = -1L;
        this.f39648s = null;
        this.f39649t = 0;
        this.f39650u = "";
        this.f39651v = "";
        this.f39652w = null;
        this.f39653x = null;
        this.f39654y = null;
        this.f39655z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j6 = this.f39647r - crashDetailBean2.f39647r;
        if (j6 <= 0) {
            return j6 < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f39631b);
        parcel.writeString(this.f39632c);
        parcel.writeByte(this.f39633d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39634e);
        parcel.writeString(this.f39635f);
        parcel.writeString(this.f39636g);
        parcel.writeByte(this.f39639j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39640k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f39641l);
        parcel.writeString(this.f39642m);
        parcel.writeString(this.f39643n);
        parcel.writeString(this.f39644o);
        parcel.writeString(this.f39645p);
        parcel.writeString(this.f39646q);
        parcel.writeLong(this.f39647r);
        parcel.writeString(this.f39648s);
        parcel.writeInt(this.f39649t);
        parcel.writeString(this.f39650u);
        parcel.writeString(this.f39651v);
        parcel.writeString(this.f39652w);
        ap.b(parcel, this.f39655z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        ap.b(parcel, this.S);
        ap.a(parcel, this.f39637h);
        ap.a(parcel, this.f39638i);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        ap.b(parcel, this.W);
        ap.b(parcel, this.X);
        parcel.writeByteArray(this.Y);
        parcel.writeByteArray(this.f39654y);
        parcel.writeString(this.Z);
        parcel.writeString(this.aa);
        parcel.writeString(this.f39653x);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f39630a = -1L;
        this.f39631b = 0;
        this.f39632c = UUID.randomUUID().toString();
        this.f39633d = false;
        this.f39634e = "";
        this.f39635f = "";
        this.f39636g = "";
        this.f39637h = null;
        this.f39638i = null;
        this.f39639j = false;
        this.f39640k = false;
        this.f39641l = 0;
        this.f39642m = "";
        this.f39643n = "";
        this.f39644o = "";
        this.f39645p = "";
        this.f39646q = "";
        this.f39647r = -1L;
        this.f39648s = null;
        this.f39649t = 0;
        this.f39650u = "";
        this.f39651v = "";
        this.f39652w = null;
        this.f39653x = null;
        this.f39654y = null;
        this.f39655z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.f39631b = parcel.readInt();
        this.f39632c = parcel.readString();
        this.f39633d = parcel.readByte() == 1;
        this.f39634e = parcel.readString();
        this.f39635f = parcel.readString();
        this.f39636g = parcel.readString();
        this.f39639j = parcel.readByte() == 1;
        this.f39640k = parcel.readByte() == 1;
        this.f39641l = parcel.readInt();
        this.f39642m = parcel.readString();
        this.f39643n = parcel.readString();
        this.f39644o = parcel.readString();
        this.f39645p = parcel.readString();
        this.f39646q = parcel.readString();
        this.f39647r = parcel.readLong();
        this.f39648s = parcel.readString();
        this.f39649t = parcel.readInt();
        this.f39650u = parcel.readString();
        this.f39651v = parcel.readString();
        this.f39652w = parcel.readString();
        this.f39655z = ap.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readByte() == 1;
        this.S = ap.b(parcel);
        this.f39637h = ap.a(parcel);
        this.f39638i = ap.a(parcel);
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = ap.b(parcel);
        this.X = ap.b(parcel);
        this.Y = parcel.createByteArray();
        this.f39654y = parcel.createByteArray();
        this.Z = parcel.readString();
        this.aa = parcel.readString();
        this.f39653x = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
    }
}
