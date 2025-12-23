package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class by implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10823a = "MD5";

    /* renamed from: b, reason: collision with root package name */
    public static final Parcelable.Creator<by> f10824b = new bz();

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f10825c;

    /* renamed from: d, reason: collision with root package name */
    private double f10826d;

    /* renamed from: e, reason: collision with root package name */
    private String f10827e;

    /* renamed from: f, reason: collision with root package name */
    private String f10828f;

    /* renamed from: g, reason: collision with root package name */
    private String f10829g;

    /* renamed from: h, reason: collision with root package name */
    private int f10830h;

    /* renamed from: i, reason: collision with root package name */
    private int f10831i;

    /* synthetic */ by(Parcel parcel, bz bzVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public by(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f10825c = jSONObject;
            this.f10826d = jSONObject.getDouble("version");
            this.f10827e = this.f10825c.getString("url");
            this.f10828f = this.f10825c.getString("sign");
            this.f10831i = 1;
            this.f10829g = "";
            this.f10830h = 0;
        } catch (JSONException unused) {
            this.f10831i = 0;
        }
        this.f10831i = c() == null ? 0 : 1;
    }

    public Boolean a() {
        return Boolean.valueOf(this.f10831i == 1);
    }

    public double b() {
        return this.f10826d;
    }

    public String d() {
        return this.f10828f;
    }

    public String e() {
        return this.f10829g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f10830h == 1);
    }

    public String toString() {
        return this.f10825c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f10828f);
        parcel.writeInt(this.f10831i);
        parcel.writeString(this.f10827e);
        parcel.writeDouble(this.f10826d);
        parcel.writeString(this.f10829g);
        parcel.writeInt(this.f10830h);
    }

    public String c() {
        return cr.a().c(this.f10827e);
    }

    public by(by byVar, String str, Boolean bool) {
        this.f10826d = byVar.b();
        this.f10827e = byVar.c();
        this.f10828f = byVar.d();
        this.f10831i = byVar.a().booleanValue() ? 1 : 0;
        this.f10829g = str;
        this.f10830h = bool.booleanValue() ? 1 : 0;
    }

    private by(Parcel parcel) {
        this.f10828f = parcel.readString();
        this.f10831i = parcel.readInt();
        this.f10827e = parcel.readString();
        this.f10826d = parcel.readDouble();
        this.f10829g = parcel.readString();
        this.f10830h = parcel.readInt();
    }
}
