package cn.jiguang.t;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f3246a;

    /* renamed from: b, reason: collision with root package name */
    public String f3247b;

    /* renamed from: c, reason: collision with root package name */
    public String f3248c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "";
            if (cn.jiguang.g.a.a().e(1024)) {
                jSONObject.put("imei", TextUtils.isEmpty(this.f3246a) ? "" : this.f3246a);
            }
            cn.jiguang.g.a.a().e(1023);
            if (cn.jiguang.g.a.a().e(1025)) {
                if (!TextUtils.isEmpty(this.f3247b)) {
                    str = this.f3247b;
                }
                jSONObject.put("imsi", str);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b() {
        return TextUtils.isEmpty(this.f3246a) && TextUtils.isEmpty(this.f3247b);
    }

    public String toString() {
        return "JDeviceSimInfo{imei='" + this.f3246a + "', imsi='" + this.f3247b + "'}";
    }
}
