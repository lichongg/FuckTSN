package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    public static void handleEvent(Context context, b bVar) {
        Context context2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(bi.aS, "1.0.0");
                Map<String, String> map = customHeader;
                if (map != null && map.size() > 0) {
                    for (String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
            jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", bVar.d());
            context2 = context;
        } catch (Throwable th) {
            th = th;
            context2 = context;
        }
        try {
            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context2, jSONObject, jSONObject2, a.f42140c, "v", "1.0.0");
        } catch (Throwable th2) {
            th = th2;
            UMCrashManager.reportCrash(context2, th);
        }
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
            return;
        }
        if (map == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
            return;
        }
        if (!UMFrUtils.isOnline(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
            return;
        }
        if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
            return;
        }
        b bVar = new b(context);
        bVar.a(str);
        bVar.a(System.currentTimeMillis());
        bVar.a(map);
        try {
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f41761o, com.umeng.commonsdk.internal.b.a(context).a(), bVar);
        } catch (Throwable unused) {
        }
        lastTriggerTime = System.currentTimeMillis();
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
