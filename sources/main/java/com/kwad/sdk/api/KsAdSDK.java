package com.kwad.sdk.api;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.aa;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.q;
import com.kwad.sdk.api.loader.r;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAdSDK {
    private static final int INIT_ERROR_IKSADSDK_NULL_CODE = -1;
    private static final String INIT_ERROR_IKSADSDK_NULL_MSG = "IKsAdSDK对象创建异常";
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);

    @Keep
    private static IKsAdSDK sSdk;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    @KsAdSdkApi
    @Keep
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static synchronized KsLoadManager getLoadManager() {
        synchronized (KsAdSDK.class) {
            if (sSdk == null || !sHasInit.get()) {
                return new b();
            }
            return sSdk.getAdManager();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion(int i6) {
        return i6 != 1 ? "" : BuildConfig.VERSION_NAME;
    }

    public static boolean haseInit() {
        return sHasInit.get();
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        long elapsedRealtime;
        Context context2;
        Throwable th;
        synchronized (KsAdSDK.class) {
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (context == null || sdkConfig == null) {
                throw new RuntimeException("init context or config is null");
            }
            mOriginalAppContext = context;
            try {
                context2 = e.aV(context);
                if (context2 == null) {
                    throw new RuntimeException("init wrapperApp Exception");
                }
                try {
                    q Dp = r.Dp();
                    if (Dp != null) {
                        Dp.holdSdkConfig(sdkConfig);
                    }
                    IKsAdSDK init = Loader.get().init(context2, KsAdSDK.class.getClassLoader());
                    sSdk = init;
                    if (init == null) {
                        notifyInitFail(sdkConfig, -1, INIT_ERROR_IKSADSDK_NULL_MSG);
                    }
                    sSdk.setApiVersion(BuildConfig.VERSION_NAME);
                    sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                    sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                    Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(context2);
                    if (wrapContextIfNeed == null) {
                        throw new RuntimeException("init wrapContextIfNeed Exception");
                    }
                    try {
                        sSdk.setInitStartTime(elapsedRealtime);
                    } catch (Throwable th3) {
                        c.m(th3);
                    }
                    sSdk.init(wrapContextIfNeed, sdkConfig);
                    sSdk.setAppTag(sAppTag);
                    aa.a(context2, sSdk);
                    com.kwad.sdk.api.loader.b.a(context2, sdkConfig);
                    c.ow();
                    sHasInit.set(sSdk != null);
                    return sHasInit.get();
                } catch (Throwable th4) {
                    th = th4;
                    revertDynamic(th, context2, sdkConfig);
                    return false;
                }
            } catch (Throwable th5) {
                context2 = context;
                th = th5;
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    private static void notifyInitFail(SdkConfig sdkConfig, int i6, String str) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    ksInitCallback.onFail(i6, str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    private static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        AtomicBoolean atomicBoolean = sHasRest;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        aa.be(context);
        Loader.get().rest();
        String str = sdkConfig.appId;
        init(context, sdkConfig);
        c.m(th);
    }

    @KsAdSdkApi
    @Keep
    public static void setAdxEnable(boolean z5) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z5);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    public static void setLoadingLottieAnimation(boolean z5, @RawRes int i6) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z5, i6);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z5, @ColorInt int i6) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z5, i6);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z5) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z5);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setProgrammaticRecommend(boolean z5) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z5);
        }
    }

    public static void setThemeMode(int i6) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i6);
        }
    }

    @KsAdSdkApi
    @Keep
    public static synchronized void start() {
        synchronized (KsAdSDK.class) {
            try {
                sSdk.start();
            } catch (Throwable th) {
                c.m(th);
            }
        }
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }
}
