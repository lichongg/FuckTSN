package cn.jiguang.bb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static String a(Context context) {
        if (!cn.jiguang.e.c.a(context)) {
            f.i("LogExternalManage", "readLogs: log is not enabled");
            return "";
        }
        String a6 = b.a(context, cn.jiguang.e.c.b(context));
        StringBuilder sb = new StringBuilder();
        sb.append("readLogs: logs len: ");
        sb.append(TextUtils.isEmpty(a6) ? 0 : a6.length());
        f.c("LogExternalManage", sb.toString());
        return a6;
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        boolean z5 = bundle.getBoolean("enable", false);
        boolean z6 = bundle.getBoolean("upload", false);
        f.c("LogExternalManage", "enableSDKLocalLog: enable=" + z5 + ", upload=" + z6);
        if (z5) {
            a(context, z6);
        } else {
            b(context);
        }
    }

    private static void b(Context context) {
        try {
            boolean a6 = cn.jiguang.e.c.a(context);
            f.c("LogExternalManage", "isExternalLogEnabled: " + a6);
            if (a6) {
                d.b(context);
                cn.jiguang.e.c.a(context, false);
                if (d.c(context)) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("log_enable", 0);
                    jSONObject2.put("log_print", 0);
                    jSONObject2.put("local_upload_enable", 0);
                    jSONObject.put("content", jSONObject2);
                    cn.jiguang.d.a.a(context, jSONObject);
                }
            }
        } catch (Throwable th) {
            f.l("LogExternalManage", "disableSDKLocalLog failed: " + th.getMessage());
        }
    }

    private static void a(Context context, boolean z5) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("log_enable", 1);
            jSONObject2.put("log_print", 1);
            jSONObject2.put("local_upload_enable", z5 ? 1 : 0);
            jSONObject2.put("expire", 7);
            jSONObject.put("content", jSONObject2);
            d.a(context);
            cn.jiguang.d.a.a(context, jSONObject);
            cn.jiguang.e.c.a(context, true);
            cn.jiguang.e.c.b(context, z5);
            f.c("LogExternalManage", "enableSDKLocalLog: " + jSONObject.toString() + ", isUpload=" + z5 + ", spLogEnable: " + cn.jiguang.e.c.a(context));
        } catch (Throwable th) {
            f.l("LogExternalManage", "enableSDKLocalLog failed: " + th.getMessage());
        }
    }
}
