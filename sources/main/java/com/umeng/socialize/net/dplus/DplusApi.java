package com.umeng.socialize.net.dplus;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.work.Data;
import com.amap.api.services.district.DistrictSearchQuery;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UMAuthUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DplusApi {
    private static final String FULL = "false";
    private static final String SIMPLE = "true";
    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    private static JSONObject constructBaseContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String share_media2 = share_media.toString();
        jSONObject.put("pf", share_media.getName());
        if ((share_media2.equals(SHARE_MEDIA.QQ.toString()) || share_media2.equals(SHARE_MEDIA.QZONE.toString())) && Config.isUmengQQ.booleanValue()) {
            jSONObject.put(CommonNetImpl.SDKT, SIMPLE);
        } else if ((share_media2.equals(SHARE_MEDIA.WEIXIN.toString()) || share_media2.equals(SHARE_MEDIA.WEIXIN_CIRCLE.toString()) || share_media2.equals(SHARE_MEDIA.WEIXIN_FAVORITE.toString())) && Config.isUmengWx.booleanValue()) {
            jSONObject.put(CommonNetImpl.SDKT, SIMPLE);
        } else {
            jSONObject.put(CommonNetImpl.SDKT, FULL);
        }
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put(CommonNetImpl.TAG, str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructDauContent() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put(CommonNetImpl.SHARETYPE, Config.shareType);
        return jSONObject;
    }

    private static JSONObject constructStatsDauContent(Map<String, String> map, int i6) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CommonNetImpl.NAME, CommonNetImpl.S_DAU);
        jSONObject.put(CommonNetImpl.A_B, i6);
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(map.get("position")) && !TextUtils.isEmpty(map.get(CommonNetImpl.MENUBG))) {
                jSONObject2.put("position", map.get("position"));
                jSONObject2.put(CommonNetImpl.MENUBG, map.get(CommonNetImpl.MENUBG));
                jSONObject.put(CommonNetImpl.S_I, jSONObject2);
            }
        }
        return jSONObject;
    }

    public static JSONObject getFakeData() throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(SHARE_MEDIA.SINA, "test");
        constructBaseContent.put(CommonNetImpl.NAME, "testetstttttttttttttttttttttttttttttttt");
        constructBaseContent.put(CommonNetImpl.U_C, true);
        constructBaseContent.put(CommonNetImpl.SM, "sso");
        constructBaseContent.put(CommonNetImpl.STYPE, 0);
        return constructBaseContent;
    }

    public static void uploadAuth(final Context context, final Map<String, String> map, final boolean z5, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructAuthContent = DplusApi.constructAuthContent(map, z5, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.AUTH_EVENT, CommonNetImpl.get(context2), constructAuthContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadAuthStart(final Context context, final boolean z5, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsAuthStartContent = DplusApi.constructStatsAuthStartContent(z5, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context2), constructStatsAuthStartContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadAuthend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsAuthEndContent = DplusApi.constructStatsAuthEndContent(SHARE_MEDIA.this, str, str2, str3);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context2), constructStatsAuthEndContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadDAU(final Context context) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructDauContent = DplusApi.constructDauContent();
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.DAU_EVENT, CommonNetImpl.get(context2), constructDauContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadInfoStart(final Context context, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsInfoStartContent = DplusApi.constructStatsInfoStartContent(SHARE_MEDIA.this, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context2), constructStatsInfoStartContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadInfoend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsInfoEndContent = DplusApi.constructStatsInfoEndContent(SHARE_MEDIA.this, str, str2, str3);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context2), constructStatsInfoEndContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadShare(final Context context, final ShareContent shareContent, final boolean z5, final SHARE_MEDIA share_media, final String str, final boolean z6) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructShareContent = DplusApi.constructShareContent(ShareContent.this, z5, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SHARE_EVENT, CommonNetImpl.get(context2), constructShareContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsShareContent = DplusApi.constructStatsShareContent(ShareContent.this, z5, share_media, z6, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context2), constructStatsShareContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadStatsShareEnd(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructStatsShareEndContent = DplusApi.constructStatsShareEndContent(SHARE_MEDIA.this, str, str2, str3);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context2), constructStatsShareEndContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    public static void uploadUserInfo(final Context context, final Map<String, String> map, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject constructUserInfoContent = DplusApi.constructUserInfoContent(map, share_media, str);
                    Context context2 = context;
                    UMWorkDispatch.sendEvent(context2, SocializeConstants.GET_EVENT, CommonNetImpl.get(context2), constructUserInfoContent);
                } catch (JSONException e6) {
                    SLog.error(e6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructAuthContent(Map<String, String> map, boolean z5, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            constructBaseContent.put(CommonNetImpl.AM, share_media.getsharestyle(z5));
            if (share_media.toString().equals("WEIXIN")) {
                constructBaseContent.put("uid", map.get("openid"));
            } else {
                constructBaseContent.put("uid", map.get("uid"));
            }
            constructBaseContent.put("unionid", map.get("unionid"));
            constructBaseContent.put(CommonNetImpl.AID, map.get(CommonNetImpl.AID));
            constructBaseContent.put(CommonNetImpl.AS, map.get(CommonNetImpl.AS));
            if (TextUtils.isEmpty(map.get("access_token"))) {
                constructBaseContent.put("at", map.get("accessToken"));
                return constructBaseContent;
            }
            constructBaseContent.put("at", map.get("access_token"));
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructShareContent(ShareContent shareContent, boolean z5, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        String str2 = shareContent.mText;
        constructBaseContent.put(CommonNetImpl.STYPE, shareContent.getShareType());
        constructBaseContent.put(CommonNetImpl.SM, share_media.getsharestyle(z5));
        if (!TextUtils.isEmpty(str2) && str2.length() > 10240) {
            str2 = str2.substring(0, Data.MAX_DATA_BYTES);
        }
        if (shareContent.getShareType() != 2 && shareContent.getShareType() != 3) {
            if (shareContent.getShareType() == 1) {
                constructBaseContent.put("ct", str2);
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 8) {
                UMVideo uMVideo = (UMVideo) shareContent.mMedia;
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMVideo.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMVideo.getThumbImage().toByte())));
                    }
                }
                if (share_media == SHARE_MEDIA.SINA) {
                    constructBaseContent.put("ct", str2);
                } else {
                    constructBaseContent.put("ct", uMVideo.getDescription());
                }
                constructBaseContent.put("title", uMVideo.getTitle());
                constructBaseContent.put("url", uMVideo.toUrl());
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 4) {
                UMusic uMusic = (UMusic) shareContent.mMedia;
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMusic.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMusic.getThumbImage().toByte())));
                    }
                }
                if (share_media == SHARE_MEDIA.SINA) {
                    constructBaseContent.put("ct", str2);
                } else {
                    constructBaseContent.put("ct", uMusic.getDescription());
                }
                constructBaseContent.put("title", uMusic.getTitle());
                constructBaseContent.put(CommonNetImpl.DURL, uMusic.toUrl());
                constructBaseContent.put("url", uMusic.getmTargetUrl());
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 32) {
                constructBaseContent.put("ct", str2);
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 64) {
                UMEmoji uMEmoji = (UMEmoji) shareContent.mMedia;
                if (uMEmoji != null) {
                    if (uMEmoji.isUrlMedia()) {
                        constructBaseContent.put("picurl", uMEmoji.asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.md5(uMEmoji.toByte()));
                    }
                }
                constructBaseContent.put("ct", str2);
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 128) {
                UMMin uMMin = (UMMin) shareContent.mMedia;
                if (uMMin.getThumbImage() != null) {
                    if (uMMin.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMMin.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMMin.getThumbImage().toByte())));
                    }
                }
                constructBaseContent.put("ct", uMMin.getDescription());
                constructBaseContent.put("title", uMMin.getTitle());
                constructBaseContent.put("url", uMMin.toUrl());
                constructBaseContent.put(CommonNetImpl.M_P, uMMin.getPath());
                constructBaseContent.put(CommonNetImpl.M_U, uMMin.getUserName());
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 256) {
                UMQQMini uMQQMini = (UMQQMini) shareContent.mMedia;
                if (uMQQMini.getThumbImage() != null) {
                    if (uMQQMini.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMQQMini.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMQQMini.getThumbImage().toByte())));
                    }
                }
                constructBaseContent.put("ct", uMQQMini.getDescription());
                constructBaseContent.put("title", uMQQMini.getTitle());
                constructBaseContent.put("url", uMQQMini.toUrl());
                constructBaseContent.put(CommonNetImpl.M_P, uMQQMini.getPath());
                constructBaseContent.put(CommonNetImpl.M_U, uMQQMini.getMiniAppId());
                return constructBaseContent;
            }
            if (shareContent.getShareType() == 16) {
                UMWeb uMWeb = (UMWeb) shareContent.mMedia;
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        constructBaseContent.put("picurl", uMWeb.getThumbImage().asUrlImage());
                    } else {
                        constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMWeb.getThumbImage().toByte())));
                    }
                }
                if (share_media == SHARE_MEDIA.SINA) {
                    constructBaseContent.put("ct", str2);
                } else {
                    constructBaseContent.put("ct", uMWeb.getDescription());
                }
                constructBaseContent.put("title", uMWeb.getTitle());
                constructBaseContent.put("url", uMWeb.toUrl());
            }
            return constructBaseContent;
        }
        UMImage uMImage = (UMImage) shareContent.mMedia;
        if (uMImage != null) {
            if (uMImage.isUrlMedia()) {
                constructBaseContent.put("picurl", uMImage.asUrlImage());
            } else {
                constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMImage.toByte())));
            }
        }
        constructBaseContent.put("ct", str2);
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_A_E);
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthStartContent(boolean z5, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_A_S);
        constructBaseContent.put(CommonNetImpl.AM, share_media.getsharestyle(z5));
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_I_E);
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoStartContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_I_S);
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareContent(ShareContent shareContent, boolean z5, SHARE_MEDIA share_media, boolean z6, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_S_S);
        constructBaseContent.put(CommonNetImpl.U_C, z6 + "");
        constructBaseContent.put(CommonNetImpl.SM, share_media.getsharestyle(z5));
        constructBaseContent.put(CommonNetImpl.STYPE, shareContent.getShareType());
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_S_E);
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructUserInfoContent(Map<String, String> map, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            constructBaseContent.put(CommonNetImpl.UN, map.get(CommonNetImpl.NAME));
            constructBaseContent.put("up", map.get("iconurl"));
            constructBaseContent.put("sex", map.get("gender"));
            if (TextUtils.isEmpty(map.get(SocializeConstants.KEY_LOCATION))) {
                constructBaseContent.put(CommonNetImpl.REGION, map.get(DistrictSearchQuery.KEYWORDS_CITY));
            } else {
                constructBaseContent.put(CommonNetImpl.REGION, map.get(SocializeConstants.KEY_LOCATION));
            }
            if (share_media.toString().equals("WEIXIN")) {
                constructBaseContent.put("uid", map.get("openid"));
            } else {
                constructBaseContent.put("uid", map.get("uid"));
            }
            SHARE_MEDIA share_media2 = SHARE_MEDIA.BYTEDANCE;
            if (share_media2 == share_media) {
                String str2 = map.get("encrypt_mobile");
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        constructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str2, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(share_media2)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } else {
                SHARE_MEDIA share_media3 = SHARE_MEDIA.HONOR;
                if (share_media3 == share_media) {
                    String str3 = map.get("mobileNumber");
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            constructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str3, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(share_media3)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
            constructBaseContent.put("unionid", map.get("unionid"));
            constructBaseContent.put("ts", System.currentTimeMillis());
        }
        return constructBaseContent;
    }

    public static void uploadStatsDAU(Context context, Map<String, String> map, int i6) {
    }
}
