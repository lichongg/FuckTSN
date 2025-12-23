package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m1 extends r1 {

    /* renamed from: n, reason: collision with root package name */
    public String f8242n;

    /* renamed from: o, reason: collision with root package name */
    public String f8243o;

    /* renamed from: p, reason: collision with root package name */
    public String f8244p;

    /* renamed from: q, reason: collision with root package name */
    public String f8245q;

    /* renamed from: r, reason: collision with root package name */
    public String f8246r;

    /* renamed from: s, reason: collision with root package name */
    public String f8247s;

    /* renamed from: t, reason: collision with root package name */
    public String f8248t;

    /* renamed from: u, reason: collision with root package name */
    public String f8249u;

    /* renamed from: v, reason: collision with root package name */
    public String f8250v;

    /* renamed from: w, reason: collision with root package name */
    protected byte[] f8251w;

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        byte[] bArr = this.f8251w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put(bi.f40972o, x0.f(this.f8378m));
            jSONObject.put(bn.f10753i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String a6 = n1.a();
            this.f8242n = a6;
            jSONObject.put("t1", a6);
            String e6 = n1.e();
            this.f8243o = e6;
            jSONObject.put("t2", e6);
            String h6 = n1.h();
            this.f8244p = h6;
            jSONObject.put("t3", h6);
            String i6 = n1.i();
            this.f8245q = i6;
            jSONObject.put("s1", i6);
            String j6 = n1.j();
            this.f8246r = j6;
            jSONObject.put("s2", j6);
            String k6 = n1.k();
            this.f8247s = k6;
            jSONObject.put("s3", k6);
            String l6 = n1.l();
            this.f8248t = l6;
            jSONObject.put("s4", l6);
            jSONObject.put("uuid", n1.b(this.f8378m));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, c1.z());
            jSONObject.put("hostname", n1.m());
            String Q = c1.Q(this.f8378m);
            this.f8249u = Q;
            jSONObject.put("gaid", Q);
            String w5 = c1.w(this.f8378m);
            this.f8250v = w5;
            jSONObject.put("oaid", w5);
            this.f8251w = n1.d(j1.y(jSONObject.toString().getBytes("utf-8")), j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f8251w;
    }

    public m1(Context context) {
        super(context);
    }
}
