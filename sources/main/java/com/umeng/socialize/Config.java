package com.umeng.socialize;

import com.kwad.sdk.core.imageloader.KSImageLoader;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Config {
    public static String Descriptor = null;
    public static String EntityKey = "-1";
    public static String EntityName = "share";
    public static final boolean Google = false;

    @Deprecated
    public static int KaKaoLoginType = 0;

    @Deprecated
    public static int LinkedInProfileScope = 0;

    @Deprecated
    public static int LinkedInShareCode = 0;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    public static String MORE_TITLE = null;

    @Deprecated
    public static boolean OpenEditor = true;

    @Deprecated
    public static String QQAPPNAME;

    @Deprecated
    public static int QQWITHQZONE;
    public static String SessionId;

    /* renamed from: a, reason: collision with root package name */
    private static int f42154a;

    @Deprecated
    public static String appName;
    public static int connectionTimeOut;
    public static boolean isFacebookRead;
    public static boolean isJumptoAppStore;

    @Deprecated
    public static boolean isNeedAuth;
    public static Boolean isUmengDY;
    public static Boolean isUmengQQ;
    public static Boolean isUmengSina;
    public static Boolean isUmengWx;
    public static final boolean mEncrypt = false;
    public static int readSocketTimeOut;
    public static String shareType;

    public static void setMini() {
        f42154a = 0;
    }

    public static void setMiniPreView() {
        f42154a = 2;
    }

    public static void setMiniTest() {
        f42154a = 1;
    }

    static {
        Boolean bool = Boolean.TRUE;
        isUmengSina = bool;
        isUmengWx = bool;
        isUmengQQ = bool;
        isUmengDY = bool;
        Descriptor = "com.umeng.share";
        SessionId = null;
        QQWITHQZONE = 2;
        QQAPPNAME = "";
        shareType = AMPSConstants.AdType.AD_TYPE_NATIVE;
        KaKaoLoginType = 0;
        MORE_TITLE = "分享";
        LinkedInProfileScope = 0;
        LinkedInShareCode = 0;
        connectionTimeOut = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        readSocketTimeOut = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        isNeedAuth = false;
        isJumptoAppStore = false;
        isFacebookRead = false;
        f42154a = 0;
    }

    public static int getMINITYPE() {
        return f42154a;
    }
}
