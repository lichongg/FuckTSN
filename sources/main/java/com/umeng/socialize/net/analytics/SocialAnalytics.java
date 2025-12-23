package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.base.SocializeClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.net.verify.VerifyReqeust;
import com.umeng.socialize.net.verify.VerifyResponse;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SocialAnalytics {

    /* renamed from: a, reason: collision with root package name */
    private static SocializeClient f42427a = new SocializeClient();

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f42428b = Executors.newCachedThreadPool();

    private static void a(Context context, String str, Map<String, String> map) {
        if ("weixin".equals(str) || "sina".equals(str) || "qq".equals(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                String appkey = SocializeUtils.getAppkey(context);
                if (!TextUtils.isEmpty(appkey)) {
                    jSONObject.put("appkey", appkey);
                }
                String upperCase = Build.MODEL.replaceAll("\\s", "-").toUpperCase();
                if (!TextUtils.isEmpty(upperCase)) {
                    jSONObject.put("device_model", upperCase);
                }
                jSONObject.put("os", FaceEnvironment.OS);
                String osVersion = DeviceConfig.getOsVersion();
                if (!TextUtils.isEmpty(osVersion)) {
                    jSONObject.put("os_version", osVersion);
                }
                jSONObject.put("sdk_version", "7.3.2");
                String uMId = UMUtils.getUMId(context);
                if (!TextUtils.isEmpty(uMId)) {
                    jSONObject.put("umid", uMId);
                }
                String str2 = DeviceConfig.getNetworkAccessMode(context)[0];
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(bi.Q, str2);
                }
                String str3 = DeviceConfig.getNetworkAccessMode(context)[1];
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put(bi.R, str3);
                }
                jSONObject.put(bi.P, "");
                String deviceId = DeviceConfig.getDeviceId(context);
                if (!TextUtils.isEmpty(deviceId)) {
                    jSONObject.put("device_id_type", "0");
                    jSONObject.put("device_id", deviceId);
                } else if (TextUtils.isEmpty("")) {
                    String androidID = DeviceConfig.getAndroidID(context);
                    if (!TextUtils.isEmpty(androidID)) {
                        jSONObject.put("device_id_type", "2");
                        jSONObject.put("device_id", androidID);
                    }
                } else {
                    jSONObject.put("device_id_type", "1");
                    jSONObject.put("device_id", "");
                }
                if ("weixin".equals(str)) {
                    jSONObject.put(SocialConstants.PARAM_SOURCE, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
                } else if ("sina".equals(str)) {
                    jSONObject.put(SocialConstants.PARAM_SOURCE, "weibo");
                } else {
                    jSONObject.put(SocialConstants.PARAM_SOURCE, str);
                }
                HashMap hashMap = new HashMap();
                String str4 = map.get(CommonNetImpl.AID);
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("appId", str4);
                }
                String str5 = map.get("openid");
                if (TextUtils.isEmpty(str5)) {
                    str5 = map.get("uid");
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashMap.put("openId", str5);
                }
                String str6 = map.get("unionid");
                if (!TextUtils.isEmpty(str6)) {
                    str5 = str6;
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashMap.put("unionId", str5);
                }
                String str7 = map.get(CommonNetImpl.NAME);
                if (!TextUtils.isEmpty(str7)) {
                    hashMap.put("nickName", str7);
                }
                String str8 = map.get("gender");
                if (!TextUtils.isEmpty(str8)) {
                    if ("男".equals(str8)) {
                        hashMap.put("sex", "0");
                    } else if ("女".equals(str8)) {
                        hashMap.put("sex", "1");
                    } else {
                        hashMap.put("sex", str8);
                    }
                }
                jSONObject.put("info", new JSONObject(hashMap.toString()));
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                Set<String> stringSet = context.getSharedPreferences("umeng_verify", 0).getStringSet("verify_log", null);
                HashSet hashSet = new HashSet();
                if (stringSet != null && !stringSet.isEmpty()) {
                    Iterator<String> it = stringSet.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next());
                    }
                }
                hashSet.add(jSONObject.toString());
                SharedPreferences.Editor edit = context.getSharedPreferences("umeng_verify", 0).edit();
                edit.putStringSet("verify_log", hashSet);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static void log(final Context context, final String str, final String str2, final UMediaObject uMediaObject) {
        a(new Runnable() { // from class: com.umeng.socialize.net.analytics.SocialAnalytics.1
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsReqeust analyticsReqeust = new AnalyticsReqeust(context, str, str2);
                analyticsReqeust.setMedia(uMediaObject);
                analyticsReqeust.setReqType(1);
                AnalyticsResponse analyticsResponse = (AnalyticsResponse) SocialAnalytics.f42427a.execute(analyticsReqeust);
                if (analyticsResponse == null || !analyticsResponse.isOk()) {
                    SLog.debug(UmengText.NET.SHARESELFFAIL);
                } else {
                    SLog.debug(UmengText.NET.SHARESELFOK);
                }
            }
        });
    }

    public static void verifyStats(final Context context) {
        Set<String> stringSet = context.getSharedPreferences("umeng_verify", 0).getStringSet("verify_log", null);
        if (stringSet == null || stringSet.isEmpty()) {
            return;
        }
        a(new Runnable() { // from class: com.umeng.socialize.net.analytics.SocialAnalytics.2
            @Override // java.lang.Runnable
            public void run() {
                VerifyResponse verifyResponse = (VerifyResponse) SocialAnalytics.f42427a.execute(new VerifyReqeust(context, "https://ai.login.umeng.com/api/umed/event", VerifyResponse.class, URequest.RequestMethod.POST));
                if (verifyResponse == null || !verifyResponse.isOk()) {
                    SLog.debug("VerifyReqeust Fail");
                    return;
                }
                SLog.debug("VerifyReqeust Success");
                SharedPreferences.Editor edit = context.getSharedPreferences("umeng_verify", 0).edit();
                edit.remove("verify_log");
                edit.commit();
            }
        });
    }

    public static void authendt(Context context, SHARE_MEDIA share_media, String str, boolean z5, String str2, String str3, Map<String, String> map) {
        DplusApi.uploadAuthend(context, share_media, str3, str, str2);
        if (map != null) {
            DplusApi.uploadAuth(context, map, z5, share_media, str3);
        }
        if (map != null) {
            a(context, share_media.toString().toLowerCase(), map);
        }
        verifyStats(context);
    }

    public static void authstart(Context context, SHARE_MEDIA share_media, String str, boolean z5, String str2) {
        DplusApi.uploadAuthStart(context, z5, share_media, str2);
    }

    public static void dauStats(Context context, boolean z5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Bundle shareAndAuth = UMLog.getShareAndAuth();
        if (shareAndAuth.getBoolean("share")) {
            i6 = 536870912;
        } else {
            i6 = 0;
        }
        if (shareAndAuth.getBoolean("auth")) {
            i7 = 268435456;
        } else {
            i7 = 0;
        }
        if (UMLog.isOpenShareEdit()) {
            i8 = 16777216;
        } else {
            i8 = 0;
        }
        if (shareAndAuth.getBoolean("isjump")) {
            i9 = CommonNetImpl.FLAG_SHARE_JUMP;
        } else {
            i9 = 0;
        }
        int i10 = i9 | i6 | i7 | i8;
        String shareBoardConfig = SocializeSpUtils.getShareBoardConfig(context);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(shareBoardConfig)) {
            String[] split = shareBoardConfig.split(";");
            if (split.length == 2) {
                String str = split[0];
                String str2 = split[1];
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    hashMap.put("position", split[1]);
                    hashMap.put(CommonNetImpl.MENUBG, split[0]);
                    DplusApi.uploadStatsDAU(context, hashMap, i10);
                    return;
                }
                return;
            }
            return;
        }
        DplusApi.uploadStatsDAU(context, null, i10);
    }

    public static void getInfoendt(Context context, SHARE_MEDIA share_media, String str, String str2, String str3, Map<String, String> map) {
        DplusApi.uploadInfoend(context, share_media, str3, str, str2);
        if (map != null) {
            DplusApi.uploadUserInfo(context, map, share_media, str3);
        }
        if (map != null) {
            a(context, share_media.toString().toLowerCase(), map);
        }
        verifyStats(context);
    }

    public static void getInfostart(Context context, SHARE_MEDIA share_media, String str) {
        DplusApi.uploadInfoStart(context, share_media, str);
    }

    public static void shareend(Context context, SHARE_MEDIA share_media, String str, String str2, String str3) {
        DplusApi.uploadStatsShareEnd(context, share_media, str3, str, str2);
    }

    private static void a(Runnable runnable) {
        ExecutorService executorService = f42428b;
        if (executorService == null || runnable == null) {
            return;
        }
        executorService.execute(runnable);
    }
}
