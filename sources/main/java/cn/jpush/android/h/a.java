package cn.jpush.android.h;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.e.c;
import cn.jpush.android.f.f;
import cn.jpush.android.i.b;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {
    public static void a(Context context, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            b.g("PushPlatformManager", "appId is empty");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(f.f3659b, "", "appId is empty"));
                return;
            }
            return;
        }
        if (str.length() != 24) {
            b.g("PushPlatformManager", "Invalid appId : " + str + ", Please check your appId again!");
            if (cVar != null) {
                cVar.a(new cn.jpush.android.e.b(f.f3659b, "", "Invalid appId"));
                return;
            }
            return;
        }
        try {
            cn.jpush.android.f.c.f3646b = str;
            b.b("PushPlatformManager", "register: appId - " + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("JPUSH_APPKEY", str);
            jSONObject.put("FIRST_REQUESTA", cn.jpush.android.a.b.c(context));
            cn.jpush.android.a.b.d(context);
            long a6 = cn.jpush.android.f.c.a();
            cn.jpush.android.f.a.a(new cn.jpush.android.f.b("ups.register", a6), cVar);
            cn.jpush.android.f.c.a(context, "ups.register", a6, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
