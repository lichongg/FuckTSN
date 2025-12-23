package cn.jiguang.ar;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import cn.jiguang.bb.f;
import cn.jpush.android.api.InAppSlotParams;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    private static JSONObject a(String str, boolean z5) {
        if (z5) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "1_0");
            jSONObject.put("s_type", str);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0030, code lost:
    
        if (r8 != r1) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        if (r1 == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = cn.jiguang.m.b.d(r9)
            boolean r1 = cn.jiguang.m.b.c(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "OFF"
            java.lang.String r4 = "ON"
            java.lang.String r5 = "JWakeLocalState"
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L1a
            if (r1 != 0) goto L39
        L18:
            r7 = 1
            goto L39
        L1a:
            boolean r2 = android.text.TextUtils.equals(r4, r0)
            if (r2 == 0) goto L23
            r2 = 0
        L21:
            r8 = 1
            goto L2e
        L23:
            boolean r2 = android.text.TextUtils.equals(r3, r0)
            if (r2 == 0) goto L2c
            r2 = 0
            r8 = 0
            goto L2e
        L2c:
            r2 = 1
            goto L21
        L2e:
            if (r2 != 0) goto L33
            if (r8 == r1) goto L39
            goto L18
        L33:
            java.lang.String r7 = "local wake state do not changed"
            cn.jiguang.bb.f.c(r5, r7)
            r7 = r2
        L39:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "lastCacheWakeState:"
            r2.append(r8)
            r2.append(r0)
            java.lang.String r0 = ",userWakeupEnable:"
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ",isNeedReport:"
            r2.append(r0)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            cn.jiguang.bb.f.c(r5, r0)
            if (r7 == 0) goto L93
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L79
            r0.<init>()     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = "status"
            if (r1 == 0) goto L69
            goto L6a
        L69:
            r6 = 2
        L6a:
            r0.put(r2, r6)     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = "aals"
            cn.jiguang.be.b.a(r9, r0, r2)     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L75
            r3 = r4
        L75:
            cn.jiguang.m.b.o(r9, r3)     // Catch: java.lang.Throwable -> L79
            return
        L79:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "report local wake state failed, error:"
            r0.append(r1)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            cn.jiguang.bb.f.i(r5, r9)
            return
        L93:
            java.lang.String r9 = "do not need report local wake state"
            cn.jiguang.bb.f.c(r5, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ar.c.a(android.content.Context):void");
    }

    private static HashMap<String, Boolean> b(Context context) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName(packageName, "cn.jpush.android.service.DActivity");
        Intent intent2 = new Intent();
        intent2.setClassName(packageName, "cn.jpush.android.service.BActivity");
        boolean z5 = false;
        boolean a6 = cn.jiguang.au.a.a(context, packageName, intent, false) | cn.jiguang.au.a.a(context, packageName, intent2, false);
        hashMap.put(TTDownloadField.TT_ACTIVITY, Boolean.valueOf(a6));
        PackageManager packageManager = context.getPackageManager();
        Intent intent3 = new Intent();
        intent3.setPackage(packageName);
        intent3.setAction("cn.jpush.android.intent.DaemonService");
        ResolveInfo resolveService = packageManager.resolveService(intent3, 512);
        boolean z6 = resolveService != null && resolveService.serviceInfo.exported;
        hashMap.put("service", Boolean.valueOf(z6));
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(packageName + ".DownloadProvider", 512);
        if (resolveContentProvider != null && resolveContentProvider.exported) {
            z5 = true;
        }
        hashMap.put(com.umeng.analytics.pro.d.M, Boolean.valueOf(z5));
        f.c("JWakeLocalState", "check w component status, activity[" + a6 + "]-service[" + z6 + "]-provider[" + z5 + "]");
        return hashMap;
    }

    public static void a(Context context, long j6) {
        try {
            if (System.currentTimeMillis() - cn.jiguang.m.b.i(context, "reportWake") < j6) {
                f.c("JWakeLocalState", "not report component status business time, interval: " + j6);
                return;
            }
            HashMap<String, Boolean> b6 = b(context);
            JSONArray jSONArray = new JSONArray();
            JSONObject a6 = a(TTDownloadField.TT_ACTIVITY, b6.get(TTDownloadField.TT_ACTIVITY).booleanValue());
            if (a6 != null) {
                jSONArray = jSONArray.put(a6);
            }
            JSONObject a7 = a("service", b6.get("service").booleanValue());
            if (a7 != null) {
                jSONArray = jSONArray.put(a7);
            }
            JSONObject a8 = a(com.umeng.analytics.pro.d.M, b6.get(com.umeng.analytics.pro.d.M).booleanValue());
            if (a8 != null) {
                jSONArray = jSONArray.put(a8);
            }
            if (jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                long currentTimeMillis = System.currentTimeMillis();
                jSONArray3.put(currentTimeMillis / 1000);
                jSONArray3.put((currentTimeMillis / 1000) + 1);
                jSONObject.put("duration", jSONArray3);
                jSONObject.put("statistics", jSONArray);
                jSONObject.put("c_type", "aacs");
                jSONArray2.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("slice_index", 1);
                jSONObject2.put("slice_count", 1);
                jSONObject2.put("data", jSONArray2);
                jSONObject2.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                cn.jiguang.be.b.a(context, jSONObject2, "collect_statistic");
                cn.jiguang.m.b.h(context, "reportWake");
            }
        } catch (Throwable th) {
            f.i("JWakeLocalState", "reportWakeComponentsState failed, " + th.getMessage());
        }
    }
}
