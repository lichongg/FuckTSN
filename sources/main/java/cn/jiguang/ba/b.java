package cn.jiguang.ba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f1885a;

    /* renamed from: b, reason: collision with root package name */
    private static String f1886b;

    public static Object a(Context context) {
        String str;
        JSONObject a6;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f1885a)) {
                try {
                    return new JSONObject(f1885a);
                } catch (Throwable unused) {
                }
            }
            cn.jiguang.bn.a a7 = cn.jiguang.bn.a.a(context);
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, a7.f2377i);
            jSONObject.put("manufacturer", a7.f2380l);
            jSONObject.put(bn.f10753i, a7.f2371c);
            Object a8 = cn.jiguang.v.a.a(context, "deviceinfo", null);
            if (a8 instanceof JSONObject) {
                cn.jiguang.bb.f.c("JAppListProbeHelper", "transfer dev info succeed");
                JSONArray jSONArray = ((JSONObject) a8).getJSONArray("sim_slots");
                String str2 = "";
                String str3 = str2;
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                    if (jSONObject2 != null) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str2)) {
                                jSONObject.put("imei1", str2);
                            }
                        } else {
                            str3 = jSONObject2.optString("imei", "");
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("imei2", str3);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                    jSONObject.put("imei1", a7.f2384p);
                }
                jSONObject.put("os_version", ((JSONObject) a8).optString("os_version", ""));
                jSONObject.put("language", ((JSONObject) a8).optString("language", ""));
                try {
                    str = jSONObject.getJSONObject("ids").optString("joad", "");
                    try {
                        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(f1886b)) {
                            str = f1886b;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    str = "";
                }
                if (TextUtils.isEmpty(str) && (a6 = cn.jiguang.x.a.a(context)) != null) {
                    str = a6.optString("joad", "");
                    f1886b = str;
                    cn.jiguang.bb.f.c("JAppListProbeHelper", "transfer ids single, ids: " + str);
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("joad", str);
                }
            }
            f1885a = jSONObject.toString().equals("{}") ? null : jSONObject.toString();
            cn.jiguang.bb.f.c("JAppListProbeHelper", "force dev info " + jSONObject.toString());
        } catch (Throwable unused4) {
        }
        return jSONObject;
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            cn.jiguang.bb.f.i("JAppListProbeHelper", "unexpected error, context: " + context + ", contentJson: " + jSONObject);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("use_config");
        context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("can_req_config", optBoolean).apply();
        cn.jiguang.bb.f.f("JAppListProbeHelper", "handle probe switch cmd, use_config: " + optBoolean);
    }
}
