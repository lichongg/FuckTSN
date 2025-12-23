package com.kwad.sdk.core.webview.b.c;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.aa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static final Map<String, JSONObject> aNC = new HashMap();
    public static boolean aND = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i6) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.aRp).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i6).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Mu())));
    }

    private static void af(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void ag(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        aa.putValue(fd(str), "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        aa.putValue(fd(str), "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    private static JSONObject fd(String str) {
        Map<String, JSONObject> map = aNC;
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        map.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void fe(String str) {
        aNC.remove(str);
    }

    public static void ae(String str, String str2) {
        aa.putValue(fd(str), "c_" + str2, System.currentTimeMillis());
    }

    public static void ff(String str) {
        long currentTimeMillis;
        int i6;
        JSONObject fd = fd(str);
        long tg = com.kwad.sdk.core.webview.b.a.KT().tg();
        if (tg <= 0) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - tg;
        }
        aa.putValue(fd, "c_loadUrl", System.currentTimeMillis());
        aa.putValue(fd, "c_init_interval", currentTimeMillis);
        if (aND) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        aa.putValue(fd, "c_init_state", i6);
        aND = false;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i6, int i7, String str) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.aRp).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i7).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Mu())).setFailReason(str));
    }

    public static void a(String str, String str2, int i6, String str3, long j6) {
        String str4;
        if (i6 == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        if (j6 > 60000 || j6 < 0) {
            j6 = -1;
        }
        com.kwad.sdk.commercial.b.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i6).setInterval(String.valueOf(j6)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject fd = fd(str2);
        aa.putValue(fd, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                    String optString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "");
                    String optString2 = jSONObject.optString("webViewCostParams", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            fd.put(next, jSONObject2.opt(next));
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (optInt == 1) {
                            af(str, str2);
                        } else {
                            ag(str, optString);
                        }
                    }
                    fe(str2);
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                    fe(str2);
                }
            } catch (Throwable th) {
                fe(str2);
                throw th;
            }
        }
    }

    private static void a(String str, String str2, int i6, String str3) {
        long currentTimeMillis;
        String str4;
        JSONObject jSONObject = aNC.get(str2);
        if (jSONObject == null) {
            currentTimeMillis = -3;
        } else {
            long optLong = jSONObject.optLong("c_loadUrl");
            if (optLong <= 0) {
                currentTimeMillis = -2;
            } else {
                currentTimeMillis = System.currentTimeMillis() - optLong;
                if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                    currentTimeMillis = -1;
                }
            }
        }
        if (i6 == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b.a(str4, new WebViewLoadMsg().setUrl(str).setState(i6).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        fe(str2);
    }
}
