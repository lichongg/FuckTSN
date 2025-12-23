package com.uyumao;

import android.content.Context;
import com.umeng.analytics.pro.au;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f42562a;

    /* renamed from: b, reason: collision with root package name */
    public static h f42563b;

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r9, com.uyumao.i r10, org.json.JSONArray r11) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.c.a(android.content.Context, com.uyumao.i, org.json.JSONArray):org.json.JSONObject");
    }

    public static void a(Context context, JSONObject jSONObject, boolean z5) {
        if (jSONObject == null) {
            return;
        }
        String a6 = k.a(context, "https://yumao.puata.info/anti_logs", jSONObject.toString());
        jSONObject.toString();
        if (a6 == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(a6);
            if (jSONObject2.has(au.f40898c)) {
                context.getSharedPreferences("uyumao_info", 0).edit().putString(au.f40898c, jSONObject2.optString(au.f40898c)).apply();
            }
            if (z5) {
                if (jSONObject2.has("resp_code") && jSONObject2.optInt("resp_code") == 0) {
                    context.getSharedPreferences("uyumao_info", 0).edit().putBoolean(new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()), true).apply();
                }
                e.a(new File(context.getCacheDir() + File.separator + "net_change"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
