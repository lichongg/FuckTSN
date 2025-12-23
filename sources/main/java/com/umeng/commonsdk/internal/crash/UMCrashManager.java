package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMCrashManager {
    private static final String CM_VERSION = "2.0";
    private static boolean isReportCrash;
    private static Object mObject = new Object();

    public static void buildEnvelope(Context context, Object obj) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMCrashManager.buildEnvelope enter.");
        try {
            synchronized (mObject) {
                try {
                    if (context == null || obj == null) {
                        return;
                    }
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = context.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f41846f;
                        File file = new File(str2);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        d.a(context, str2, "c", 10);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(bi.aR, CM_VERSION);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("content", str);
                            jSONObject2.put("ts", System.currentTimeMillis());
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("crash", jSONObject2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, jSONObject3);
                            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject4, UMServerURL.PATH_INNER_CRASH, "c", CM_VERSION);
                        } catch (JSONException unused) {
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void reportCrash(Context context, Throwable th) {
        synchronized (mObject) {
            try {
                if (!isReportCrash) {
                    isReportCrash = true;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f41767u, b.a(context).a(), a.a(th));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
