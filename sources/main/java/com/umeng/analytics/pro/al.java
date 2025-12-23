package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class al {
    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            ak akVar = new ak();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            akVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            akVar.b(appkey);
            akVar.c(UMUtils.getAppVersionName(context));
            akVar.d("9.6.5");
            akVar.e(UMUtils.getChannel(context));
            akVar.f(Build.VERSION.SDK_INT + "");
            akVar.g(Build.BRAND);
            akVar.h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            akVar.i(localeInfo[1]);
            akVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            akVar.b(Integer.valueOf(resolutionArray[1]));
            akVar.a(Integer.valueOf(resolutionArray[0]));
            akVar.k(ap.a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ak.f40839a, akVar.a());
                    jSONObject2.put(ak.f40841c, akVar.c());
                    jSONObject2.put(ak.f40840b, akVar.b());
                    jSONObject2.put(ak.f40842d, akVar.d());
                    jSONObject2.put(ak.f40843e, akVar.e());
                    jSONObject2.put(ak.f40844f, akVar.f());
                    jSONObject2.put(ak.f40845g, akVar.g());
                    jSONObject2.put(ak.f40846h, akVar.h());
                    jSONObject2.put(ak.f40849k, akVar.k());
                    jSONObject2.put(ak.f40848j, akVar.j());
                    jSONObject2.put(ak.f40850l, akVar.l());
                    jSONObject2.put(ak.f40847i, akVar.i());
                    jSONObject2.put(ak.f40851m, akVar.m());
                    jSONObject2.put(bi.al, UMUtils.getZid(context));
                    jSONObject2.put("platform", FaceEnvironment.OS);
                    jSONObject2.put("optional", new JSONObject(ap.a()));
                    String[] split = str.split("@");
                    if (split.length == 4) {
                        try {
                            long parseLong = Long.parseLong(split[0]);
                            String str2 = split[1];
                            jSONObject2.put("s1", parseLong);
                            jSONObject2.put("s2", str2);
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        String str3 = Build.BRAND;
                        String a6 = aq.a(str3);
                        String b6 = aq.b(str3);
                        if (TextUtils.isEmpty(a6) || TextUtils.isEmpty(b6)) {
                            jSONObject2.put(ak.f40852n, "Android");
                            jSONObject2.put(ak.f40853o, Build.VERSION.RELEASE);
                        } else {
                            jSONObject2.put(ak.f40852n, a6);
                            jSONObject2.put(ak.f40853o, b6);
                        }
                    } catch (Throwable unused2) {
                    }
                    return jSONObject2;
                } catch (JSONException e6) {
                    e = e6;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject;
                }
            } catch (JSONException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject a(Context context, int i6, JSONArray jSONArray, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put("atoken", zid);
                    String deviceToken = UMUtils.getDeviceToken(context);
                    if (!TextUtils.isEmpty(deviceToken)) {
                        jSONObject.put("device_token", deviceToken);
                    }
                    jSONObject.put(com.baidu.mobads.sdk.internal.bn.f10753i, Build.MODEL);
                    jSONObject.put("os", FaceEnvironment.OS);
                    jSONObject.put("os_version", Build.VERSION.RELEASE);
                    jSONObject.put(com.umeng.ccg.a.f41539o, str);
                    jSONObject.put("sdk", jSONArray);
                    jSONObject.put("e", i6);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
