package com.beizi.fusion.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.beizi.fusion.a.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AppEventId {
    private static volatile AppEventId eventIdInstance;
    private String appBannerRequest;
    private String appFullScreenVideoRequest;
    private String appNativeRequest;
    private String appRewardedVideoRequest;
    private String appSdkInit;
    private String appSplashRequest;
    private String appStart;
    private Context mContext;
    String SP_KEY_APP_START = "AppStart";
    String SP_KEY_APP_SDK_INIT = "AppSdkInit";
    String SP_KEY_APP_SPLASH_REQUEST_PREFIX = "AppSplashRequest";
    String SP_KEY_APP_NATIVE_REQUEST_PREFIX = "AppNativeRequest";
    String SP_KEY_APP_REWARDED_VIDEO_REQUEST_PREFIX = "AppRewardedVideoRequest";
    String SP_KEY_APP_FULL_SCREEN_VIDEO_REQUEST_PREFIX = "AppFullScreenVideoRequest";
    String SP_KEY_APP_BANNER_REQUEST_PREFIX = "AppBannerRequest";

    private static String getCacheEventId(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("fusion_report", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, "");
    }

    public static AppEventId getInstance(Context context) {
        if (eventIdInstance == null) {
            synchronized (b.class) {
                try {
                    if (eventIdInstance == null) {
                        eventIdInstance = new AppEventId(context);
                    }
                } finally {
                }
            }
        }
        return eventIdInstance;
    }

    public String getAppBannerRequest() {
        return this.appBannerRequest;
    }

    public String getAppFullScreenVideoRequest() {
        return this.appFullScreenVideoRequest;
    }

    public String getAppNativeRequest() {
        return this.appNativeRequest;
    }

    public String getAppRewardedVideoRequest() {
        return this.appRewardedVideoRequest;
    }

    public String getAppSdkInit() {
        return this.appSdkInit;
    }

    public String getAppSplashRequest() {
        return this.appSplashRequest;
    }

    public String getAppStart() {
        return this.appStart;
    }

    public void setAppBannerRequest(String str) {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_BANNER_REQUEST_PREFIX + str);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appBannerRequest = cacheEventId;
        }
    }

    public void setAppFullScreenVideoRequest(String str) {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_FULL_SCREEN_VIDEO_REQUEST_PREFIX + str);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appFullScreenVideoRequest = cacheEventId;
        }
    }

    public void setAppNativeRequest(String str) {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_NATIVE_REQUEST_PREFIX + str);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appNativeRequest = cacheEventId;
        }
    }

    public void setAppRewardedVideoRequest(String str) {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_REWARDED_VIDEO_REQUEST_PREFIX + str);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appRewardedVideoRequest = cacheEventId;
        }
    }

    public void setAppSdkInit() {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_SDK_INIT);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appSdkInit = cacheEventId;
        }
    }

    public void setAppSplashRequest(String str) {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_SPLASH_REQUEST_PREFIX + str);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appSplashRequest = cacheEventId;
        }
    }

    public void setAppStart() {
        Context context = this.mContext;
        if (context != null) {
            String cacheEventId = getCacheEventId(context, this.SP_KEY_APP_START);
            if (TextUtils.isEmpty(cacheEventId)) {
                return;
            }
            this.appStart = cacheEventId;
        }
    }

    private AppEventId(Context context) {
        this.mContext = context;
    }
}
