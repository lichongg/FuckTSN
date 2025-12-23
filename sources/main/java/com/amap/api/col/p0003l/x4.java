package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x4 extends z4 {
    public String A;
    protected byte[] B;

    /* renamed from: s, reason: collision with root package name */
    public String f7659s;

    /* renamed from: t, reason: collision with root package name */
    public String f7660t;

    /* renamed from: u, reason: collision with root package name */
    public String f7661u;

    /* renamed from: v, reason: collision with root package name */
    public String f7662v;

    /* renamed from: w, reason: collision with root package name */
    public String f7663w;

    /* renamed from: x, reason: collision with root package name */
    public String f7664x;

    /* renamed from: y, reason: collision with root package name */
    public String f7665y;

    /* renamed from: z, reason: collision with root package name */
    public String f7666z;

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        byte[] bArr = this.B;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put(bi.f40972o, f4.g(this.f7798r));
            jSONObject.put(bn.f10753i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.11");
            String a6 = v4.a();
            this.f7659s = a6;
            jSONObject.put("t1", a6);
            jSONObject.put("old_t1", r4.n(this.f7798r));
            String e6 = v4.e();
            this.f7660t = e6;
            jSONObject.put("t2", e6);
            jSONObject.put("old_t2", r4.p(this.f7798r));
            String h6 = v4.h();
            this.f7661u = h6;
            jSONObject.put("t3", h6);
            jSONObject.put("old_t3", r4.r(this.f7798r));
            String i6 = v4.i();
            this.f7662v = i6;
            jSONObject.put("s1", i6);
            jSONObject.put("old_s1", r4.t(this.f7798r));
            String j6 = v4.j();
            this.f7663w = j6;
            jSONObject.put("s2", j6);
            jSONObject.put("old_s2", r4.v(this.f7798r));
            String k6 = v4.k();
            this.f7664x = k6;
            jSONObject.put("s3", k6);
            jSONObject.put("old_s3", r4.x(this.f7798r));
            String l6 = v4.l();
            this.f7665y = l6;
            jSONObject.put("s4", l6);
            jSONObject.put("old_s4", r4.z(this.f7798r));
            jSONObject.put("uuid", v4.b(this.f7798r));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, i4.G());
            jSONObject.put("hostname", v4.m());
            String f02 = i4.f0(this.f7798r);
            this.f7666z = f02;
            jSONObject.put("gaid", f02);
            jSONObject.put("old_gaid", r4.B(this.f7798r));
            String D = i4.D(this.f7798r);
            this.A = D;
            jSONObject.put("oaid", D);
            jSONObject.put("old_oaid", r4.d(this.f7798r));
            jSONObject.put("aaid", r4.f(this.f7798r));
            jSONObject.put("resetToken", r4.l(this.f7798r));
            jSONObject.put("uabc", r4.j(this.f7798r));
            this.B = v4.d(q4.z(jSONObject.toString().getBytes("utf-8")), q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.B;
    }

    public x4(Context context) {
        super(context);
    }
}
