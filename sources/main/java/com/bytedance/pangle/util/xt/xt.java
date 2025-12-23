package com.bytedance.pangle.util.xt;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.r.xt;
import com.bytedance.sdk.openadsdk.api.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static boolean j(String str, boolean z5, boolean z6, String str2, int i6, int i7) {
        Throwable th;
        int i8;
        int i9;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            new j(new com.bytedance.pangle.util.xt.j.j().j(str)).j(z5, z6);
            if (i7 != 0) {
                if (i7 == 1) {
                    i9 = xt.j.f25461j;
                } else if (i7 == 2) {
                    i9 = xt.j.xt;
                } else {
                    i8 = 0;
                    String str3 = "rmSo:" + z6 + " rmDex:" + z5;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                    j(i8, str2, i6, System.currentTimeMillis() - currentTimeMillis, (Throwable) null, str3);
                }
                i8 = i9;
                String str32 = "rmSo:" + z6 + " rmDex:" + z5;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str32)));
                j(i8, str2, i6, System.currentTimeMillis() - currentTimeMillis, (Throwable) null, str32);
            }
            return true;
        } catch (Throwable th2) {
            try {
            } catch (Throwable th3) {
                th = th3;
                th = th2;
            }
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z5 + " rmSO:" + z6, th2);
                if (i7 != 0) {
                    int i10 = i7 == 1 ? xt.j.cw : i7 == 2 ? xt.j.f25465r : 0;
                    String str4 = "rmSo:" + z6 + " rmDex:" + z5;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
                    j(i10, str2, i6, System.currentTimeMillis() - currentTimeMillis, th2, str4);
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                th = th2;
                Throwable th5 = th;
                if (i7 == 0) {
                    throw th5;
                }
                int i11 = i7 != 1 ? i7 == 2 ? xt.j.f25465r : 0 : xt.j.cw;
                String str5 = "rmSo:" + z6 + " rmDex:" + z5;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str5)));
                j(i11, str2, i6, System.currentTimeMillis() - currentTimeMillis, th, str5);
                throw th5;
            }
        }
    }

    private static void j(int i6, String str, int i7, long j6, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.xt.j(Integer.valueOf(i6)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.xt.j(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.xt.j(Integer.valueOf(i7)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.xt.xt(Long.valueOf(j6))));
            jSONObject2.putOpt(CrashHianalyticsData.MESSAGE, str2 + com.bytedance.pangle.log.xt.j(th));
        } catch (JSONException e6) {
            m.j(e6);
        }
        com.bytedance.pangle.r.xt.j().j(com.bytedance.pangle.r.xt.oq, jSONObject, jSONObject3, jSONObject2);
    }
}
