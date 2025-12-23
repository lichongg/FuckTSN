package cn.jiguang.bn;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.h;
import cn.jiguang.bz.j;
import cn.jiguang.bz.v;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f2392a;

    /* renamed from: b, reason: collision with root package name */
    private int f2393b;

    /* renamed from: c, reason: collision with root package name */
    private String f2394c;

    /* renamed from: d, reason: collision with root package name */
    private String f2395d;

    /* renamed from: e, reason: collision with root package name */
    private String f2396e;

    /* renamed from: f, reason: collision with root package name */
    private long f2397f;

    /* renamed from: g, reason: collision with root package name */
    private String f2398g;

    public c a(int i6) {
        this.f2393b = i6;
        return this;
    }

    public c b(String str) {
        this.f2394c = str;
        return this;
    }

    public c c(String str) {
        this.f2395d = str;
        return this;
    }

    public c a(long j6) {
        this.f2397f = j6;
        return this;
    }

    public void b(Context context) {
        String str;
        try {
            String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.c());
            if (TextUtils.isEmpty(str2)) {
                str = "no sp cid info";
            } else {
                String str3 = cn.jiguang.a.a.f1451i;
                String b6 = v.b(str2, str3);
                a(h.f2740a);
                JSONObject jSONObject = new JSONObject(b6);
                jSONObject.put("deviceIdFromType", this.f2393b);
                jSONObject.put("newImei", this.f2398g);
                String a6 = v.a(jSONObject.toString(), str3);
                if (!TextUtils.isEmpty(a6)) {
                    j.a("r_key_info", a6);
                }
                str = "save reg key info: " + jSONObject;
            }
            f.c("RegKeyInfo", str);
        } catch (Throwable unused) {
        }
    }

    public String c(Context context) {
        String e6 = j.e("r_key_info");
        if (TextUtils.isEmpty(e6)) {
            f.c("RegKeyInfo", "no reg info in cache");
            return "";
        }
        String b6 = v.b(e6, cn.jiguang.a.a.f1451i);
        f.c("RegKeyInfo", "get reg key info: " + b6);
        return !TextUtils.isEmpty(b6) ? b6 : "";
    }

    public c d(String str) {
        this.f2396e = str;
        return this;
    }

    public c e(String str) {
        this.f2398g = str;
        return this;
    }

    public String toString() {
        return "RegKeyInfo{deviceId='" + this.f2392a + "', deviceIdFromType=" + this.f2393b + ", imei='" + this.f2394c + "', androidId='" + this.f2395d + "', uuid='" + this.f2396e + "', genIdTimeStamp=" + this.f2397f + ", newImei='" + this.f2398g + "'}";
    }

    public c a(String str) {
        this.f2392a = str;
        return this;
    }

    public void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", this.f2392a);
            jSONObject.put("imei", this.f2394c);
            jSONObject.put("androidId", this.f2395d);
            jSONObject.put("uuid", this.f2396e);
            jSONObject.put("genIdTimeStamp", this.f2397f);
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.c().a((cn.jiguang.e.a<String>) v.a(jSONObject.toString(), cn.jiguang.a.a.f1451i))});
        } catch (Throwable unused) {
        }
    }
}
