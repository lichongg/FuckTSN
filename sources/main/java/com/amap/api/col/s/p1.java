package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p1 extends r1 {

    /* renamed from: n, reason: collision with root package name */
    public String f8316n;

    /* renamed from: o, reason: collision with root package name */
    public String f8317o;

    /* renamed from: p, reason: collision with root package name */
    public String f8318p;

    /* renamed from: q, reason: collision with root package name */
    public String f8319q;

    /* renamed from: r, reason: collision with root package name */
    public String f8320r;

    /* renamed from: s, reason: collision with root package name */
    public String f8321s;

    /* renamed from: t, reason: collision with root package name */
    public String f8322t;

    /* renamed from: u, reason: collision with root package name */
    public String f8323u;

    /* renamed from: v, reason: collision with root package name */
    public String f8324v;

    /* renamed from: w, reason: collision with root package name */
    protected byte[] f8325w;

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        byte[] bArr = this.f8325w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put(bi.f40972o, x0.f(this.f8378m));
            jSONObject.put(bn.f10753i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String a6 = n1.a();
            this.f8316n = a6;
            jSONObject.put("t1", a6);
            jSONObject.put("old_t1", k1.n(this.f8378m));
            String e6 = n1.e();
            this.f8317o = e6;
            jSONObject.put("t2", e6);
            jSONObject.put("old_t2", k1.p(this.f8378m));
            String h6 = n1.h();
            this.f8318p = h6;
            jSONObject.put("t3", h6);
            jSONObject.put("old_t3", k1.r(this.f8378m));
            String i6 = n1.i();
            this.f8319q = i6;
            jSONObject.put("s1", i6);
            jSONObject.put("old_s1", k1.t(this.f8378m));
            String j6 = n1.j();
            this.f8320r = j6;
            jSONObject.put("s2", j6);
            jSONObject.put("old_s2", k1.v(this.f8378m));
            String k6 = n1.k();
            this.f8321s = k6;
            jSONObject.put("s3", k6);
            jSONObject.put("old_s3", k1.x(this.f8378m));
            String l6 = n1.l();
            this.f8322t = l6;
            jSONObject.put("s4", l6);
            jSONObject.put("old_s4", k1.z(this.f8378m));
            jSONObject.put("uuid", n1.b(this.f8378m));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, c1.z());
            jSONObject.put("hostname", n1.m());
            String Q = c1.Q(this.f8378m);
            this.f8323u = Q;
            jSONObject.put("gaid", Q);
            jSONObject.put("old_gaid", k1.B(this.f8378m));
            String w5 = c1.w(this.f8378m);
            this.f8324v = w5;
            jSONObject.put("oaid", w5);
            jSONObject.put("old_oaid", k1.d(this.f8378m));
            jSONObject.put("aaid", k1.f(this.f8378m));
            jSONObject.put("resetToken", k1.l(this.f8378m));
            jSONObject.put("uabc", k1.j(this.f8378m));
            this.f8325w = n1.d(j1.y(jSONObject.toString().getBytes("utf-8")), j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f8325w;
    }

    public p1(Context context) {
        super(context);
    }
}
