package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i6) {
            return new UserInfoBean[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f39585a;

    /* renamed from: b, reason: collision with root package name */
    public int f39586b;

    /* renamed from: c, reason: collision with root package name */
    public String f39587c;

    /* renamed from: d, reason: collision with root package name */
    public String f39588d;

    /* renamed from: e, reason: collision with root package name */
    public long f39589e;

    /* renamed from: f, reason: collision with root package name */
    public long f39590f;

    /* renamed from: g, reason: collision with root package name */
    public long f39591g;

    /* renamed from: h, reason: collision with root package name */
    public long f39592h;

    /* renamed from: i, reason: collision with root package name */
    public long f39593i;

    /* renamed from: j, reason: collision with root package name */
    public String f39594j;

    /* renamed from: k, reason: collision with root package name */
    public long f39595k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39596l;

    /* renamed from: m, reason: collision with root package name */
    public String f39597m;

    /* renamed from: n, reason: collision with root package name */
    public String f39598n;

    /* renamed from: o, reason: collision with root package name */
    public int f39599o;

    /* renamed from: p, reason: collision with root package name */
    public int f39600p;

    /* renamed from: q, reason: collision with root package name */
    public int f39601q;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f39602r;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f39603s;

    public UserInfoBean() {
        this.f39595k = 0L;
        this.f39596l = false;
        this.f39597m = "unknown";
        this.f39600p = -1;
        this.f39601q = -1;
        this.f39602r = null;
        this.f39603s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f39586b);
        parcel.writeString(this.f39587c);
        parcel.writeString(this.f39588d);
        parcel.writeLong(this.f39589e);
        parcel.writeLong(this.f39590f);
        parcel.writeLong(this.f39591g);
        parcel.writeLong(this.f39592h);
        parcel.writeLong(this.f39593i);
        parcel.writeString(this.f39594j);
        parcel.writeLong(this.f39595k);
        parcel.writeByte(this.f39596l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39597m);
        parcel.writeInt(this.f39600p);
        parcel.writeInt(this.f39601q);
        ap.b(parcel, this.f39602r);
        ap.b(parcel, this.f39603s);
        parcel.writeString(this.f39598n);
        parcel.writeInt(this.f39599o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f39595k = 0L;
        this.f39596l = false;
        this.f39597m = "unknown";
        this.f39600p = -1;
        this.f39601q = -1;
        this.f39602r = null;
        this.f39603s = null;
        this.f39586b = parcel.readInt();
        this.f39587c = parcel.readString();
        this.f39588d = parcel.readString();
        this.f39589e = parcel.readLong();
        this.f39590f = parcel.readLong();
        this.f39591g = parcel.readLong();
        this.f39592h = parcel.readLong();
        this.f39593i = parcel.readLong();
        this.f39594j = parcel.readString();
        this.f39595k = parcel.readLong();
        this.f39596l = parcel.readByte() == 1;
        this.f39597m = parcel.readString();
        this.f39600p = parcel.readInt();
        this.f39601q = parcel.readInt();
        this.f39602r = ap.b(parcel);
        this.f39603s = ap.b(parcel);
        this.f39598n = parcel.readString();
        this.f39599o = parcel.readInt();
    }
}
