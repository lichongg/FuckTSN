package cn.jiguang.f;

import android.content.Context;
import cn.jiguang.bb.f;
import cn.jiguang.bi.b;
import com.kwad.library.solder.lib.ext.PluginError;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f2940a;

    public static void a(Context context, int i6) {
        f.c("JAnalytics", "sendStartAPP:" + i6);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f2940a < 2000) {
            f.c("JAnalytics", "sendStartAPP return:" + i6);
            return;
        }
        f2940a = currentTimeMillis;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i6);
        } catch (Throwable unused) {
        }
        a(context, 2021, "Start the APP", jSONObject);
    }

    public static void a(Context context, int i6, String str, JSONObject jSONObject) {
        b(context, i6, str, jSONObject);
    }

    public static void b(Context context, int i6, String str, JSONObject jSONObject) {
        if (context == null) {
            f.l("JAnalytics", "reportPushAnylysis NULL context");
            return;
        }
        try {
            if (cn.jiguang.a.a.a()) {
                b.a().a(context, PluginError.ERROR_UPD_NO_DOWNLOADER, i6, "");
            } else {
                b.a().a(context, PluginError.ERROR_UPD_FILE_NOT_FOUND, i6, "");
            }
        } catch (Throwable unused) {
        }
    }
}
