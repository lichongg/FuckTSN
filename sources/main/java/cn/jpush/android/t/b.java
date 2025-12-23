package cn.jpush.android.t;

import cn.jpush.android.helper.Logger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f3829a;

    /* renamed from: b, reason: collision with root package name */
    public String f3830b;

    /* renamed from: c, reason: collision with root package name */
    public long f3831c;

    public static b a(String str, String str2, long j6) {
        b bVar = new b();
        bVar.f3829a = str;
        bVar.f3830b = str2;
        bVar.f3831c = j6;
        return bVar;
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f3829a = jSONObject.optString("tpl_id");
        bVar.f3830b = jSONObject.optString("tpl_file_name");
        bVar.f3831c = jSONObject.optLong("tpl_recent_use_time");
        return bVar;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tpl_id", this.f3829a);
            jSONObject.put("tpl_file_name", this.f3830b);
            jSONObject.put("tpl_recent_use_time", this.f3831c);
            return jSONObject;
        } catch (Throwable th) {
            Logger.w("InAppTemplate", "notify inapp toJSON failed. " + th.getMessage());
            return null;
        }
    }
}
