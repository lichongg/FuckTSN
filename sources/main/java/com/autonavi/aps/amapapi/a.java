package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.autonavi.aps.amapapi.a.1
        private static a a(Parcel parcel) {
            a aVar = new a();
            aVar.c(parcel.readString());
            aVar.d(parcel.readString());
            aVar.e(parcel.readString());
            aVar.f(parcel.readString());
            aVar.b(parcel.readString());
            aVar.c(parcel.readLong());
            aVar.d(parcel.readLong());
            aVar.a(parcel.readLong());
            aVar.b(parcel.readLong());
            aVar.a(parcel.readString());
            return aVar;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a[] newArray(int i6) {
            return a(i6);
        }

        private static a[] a(int i6) {
            return new a[i6];
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private String f9911e;

    /* renamed from: f, reason: collision with root package name */
    private String f9912f;

    /* renamed from: a, reason: collision with root package name */
    private long f9907a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f9908b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f9909c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f9910d = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f9913g = "first";

    /* renamed from: h, reason: collision with root package name */
    private String f9914h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f9915i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f9916j = null;

    public final long a() {
        long j6 = this.f9910d;
        long j7 = this.f9909c;
        if (j6 - j7 <= 0) {
            return 0L;
        }
        return j6 - j7;
    }

    public final String b() {
        return this.f9915i;
    }

    public final void c(long j6) {
        this.f9907a = j6;
    }

    public final void d(long j6) {
        this.f9908b = j6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f9912f;
    }

    public final String f() {
        return this.f9913g;
    }

    public final void a(String str) {
        this.f9915i = str;
    }

    public final void b(long j6) {
        this.f9910d = j6;
    }

    public final String c() {
        return this.f9916j;
    }

    public final String d() {
        return this.f9911e;
    }

    public final void e(String str) {
        this.f9913g = str;
    }

    public final void f(String str) {
        this.f9914h = str;
    }

    public final String g() {
        return this.f9914h;
    }

    public final long h() {
        long j6 = this.f9908b;
        long j7 = this.f9907a;
        if (j6 <= j7) {
            return 0L;
        }
        return j6 - j7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        try {
            parcel.writeString(this.f9911e);
            parcel.writeString(this.f9912f);
            parcel.writeString(this.f9913g);
            parcel.writeString(this.f9914h);
            parcel.writeString(this.f9916j);
            parcel.writeLong(this.f9907a);
            parcel.writeLong(this.f9908b);
            parcel.writeLong(this.f9909c);
            parcel.writeLong(this.f9910d);
            parcel.writeString(this.f9915i);
        } catch (Throwable unused) {
        }
    }

    public final void a(long j6) {
        this.f9909c = j6;
    }

    public final void b(String str) {
        this.f9916j = str;
    }

    public final void c(String str) {
        this.f9911e = str;
    }

    public final void d(String str) {
        this.f9912f = str;
    }
}
