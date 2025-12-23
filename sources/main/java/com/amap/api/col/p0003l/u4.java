package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u4 extends z4 {
    public String A;
    protected byte[] B;

    /* renamed from: s, reason: collision with root package name */
    public String f7358s;

    /* renamed from: t, reason: collision with root package name */
    public String f7359t;

    /* renamed from: u, reason: collision with root package name */
    public String f7360u;

    /* renamed from: v, reason: collision with root package name */
    public String f7361v;

    /* renamed from: w, reason: collision with root package name */
    public String f7362w;

    /* renamed from: x, reason: collision with root package name */
    public String f7363x;

    /* renamed from: y, reason: collision with root package name */
    public String f7364y;

    /* renamed from: z, reason: collision with root package name */
    public String f7365z;

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        byte[] bArr = this.B;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put(bi.f40972o, f4.g(this.f7798r));
            jSONObject.put(bn.f10753i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.11");
            String a6 = v4.a();
            this.f7358s = a6;
            jSONObject.put("t1", a6);
            String e6 = v4.e();
            this.f7359t = e6;
            jSONObject.put("t2", e6);
            String h6 = v4.h();
            this.f7360u = h6;
            jSONObject.put("t3", h6);
            String i6 = v4.i();
            this.f7361v = i6;
            jSONObject.put("s1", i6);
            String j6 = v4.j();
            this.f7362w = j6;
            jSONObject.put("s2", j6);
            String k6 = v4.k();
            this.f7363x = k6;
            jSONObject.put("s3", k6);
            String l6 = v4.l();
            this.f7364y = l6;
            jSONObject.put("s4", l6);
            jSONObject.put("uuid", v4.b(this.f7798r));
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, i4.G());
            jSONObject.put("hostname", v4.m());
            String f02 = i4.f0(this.f7798r);
            this.f7365z = f02;
            jSONObject.put("gaid", f02);
            String D = i4.D(this.f7798r);
            this.A = D;
            jSONObject.put("oaid", D);
            this.B = v4.d(q4.z(jSONObject.toString().getBytes("utf-8")), q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.B;
    }

    public u4(Context context) {
        super(context);
    }
}
