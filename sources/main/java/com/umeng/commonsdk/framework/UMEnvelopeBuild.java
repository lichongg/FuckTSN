package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, jSONObject.has("st") ? bi.aL : jSONObject2.has(bi.ax) ? "i" : "a", "9.6.5");
    }

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        i a6 = i.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(bm.f41040e, str2);
        contentValues.put(bm.f41041f, a6.c(jSONObject.toString()));
        contentValues.put(bm.f41042g, a6.c(jSONObject2.toString()));
        contentValues.put(bm.f41043h, String.valueOf(currentTimeMillis));
        contentValues.put(bm.f41044i, randomUUID.toString());
        contentValues.put(bm.f41045j, str);
        contentValues.put(bm.f41046k, str3);
        bk.a(context).a(bm.f41038c, contentValues);
        if ("i".equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if ("s".equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException unused) {
            }
        } else if (!"p".equalsIgnoreCase(str2)) {
            try {
                if (bi.aL.equalsIgnoreCase(str2)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(b.a("header"), new JSONObject());
                    jSONObject4.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(b.a("header"), new JSONObject());
                jSONObject5.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            } catch (JSONException unused2) {
                return jSONObject2;
            }
        }
        return new JSONObject();
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z5;
        synchronized (UMEnvelopeBuild.class) {
            z5 = transmissionSendFlag;
        }
        return z5;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(StubApp.getOrigApplicationContext(context.getApplicationContext())).c().a(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRet(android.content.Context r5, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r6, boolean r7) {
        /*
            if (r5 == 0) goto L47
            android.content.Context r0 = r5.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            boolean r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0)
            int r2 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r0)
            if (r1 == 0) goto L40
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r7 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            r3 = 1
            r4 = 0
            if (r6 != r7) goto L24
            boolean r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r5 == 0) goto L22
        L20:
            r7 = 0
            goto L40
        L22:
            r7 = 1
            goto L40
        L24:
            boolean r7 = com.umeng.commonsdk.framework.a.a()
            if (r7 == 0) goto L33
            int r5 = com.umeng.commonsdk.framework.a.b()
            long r5 = (long) r5
            com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(r5)
            goto L20
        L33:
            boolean r6 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r6 != 0) goto L20
            boolean r5 = com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5)
            if (r5 == 0) goto L22
            goto L20
        L40:
            if (r1 == 0) goto L47
            if (r2 <= 0) goto L47
            com.umeng.commonsdk.framework.a.d()
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static synchronized void setTransmissionSendFlag(boolean z5) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z5;
        }
    }

    public static JSONObject buildSilentEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 120);
                    return jSONObject3;
                } catch (JSONException unused) {
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
                return null;
            }
        }
        return new b().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 120);
                    return jSONObject3;
                } catch (JSONException unused) {
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
                return null;
            }
        }
        return new b().b(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str);
    }

    public static boolean isOnline(Context context) {
        boolean needSendZcfgEnv = UMConfigure.needSendZcfgEnv(context);
        if (UMFrUtils.isOnline(context) && !needSendZcfgEnv) {
            return true;
        }
        return false;
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        a.a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (!getTransmissionSendFlag()) {
            return false;
        }
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildStateless() {
        if (!getTransmissionSendFlag()) {
            return false;
        }
        return true;
    }

    public static void registerNetReceiver(Context context) {
        a.b(context);
    }

    public static void sendProcessNextMsgOnce() {
        a.d();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 121);
                    return jSONObject3;
                } catch (JSONException unused) {
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
                return null;
            }
        }
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 120);
                    return jSONObject4;
                } catch (JSONException unused3) {
                    return jSONObject4;
                }
            } catch (JSONException unused4) {
                return null;
            }
        }
        if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
        if (bk.a(context).c()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
            return new b().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
        JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        if (!UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.f41766t)) {
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f41766t, com.umeng.commonsdk.internal.b.a(context).a(), null);
        }
        return add2CacheTable;
    }
}
