package com.huawei.hms.framework.common;

import com.huawei.android.os.BuildEx;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class EmuiUtil {
    public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
    public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";

    /* renamed from: a, reason: collision with root package name */
    private static final String f33283a = "com.huawei.android.os.BuildEx";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33284b = "KPMS_Util_Emui";

    /* renamed from: c, reason: collision with root package name */
    private static final int f33285c = 7;

    /* renamed from: d, reason: collision with root package name */
    private static final int f33286d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f33287e = 9;

    /* renamed from: f, reason: collision with root package name */
    private static final int f33288f = 10;

    /* renamed from: g, reason: collision with root package name */
    private static final int f33289g = 11;

    /* renamed from: h, reason: collision with root package name */
    private static final int f33290h = 14;

    /* renamed from: i, reason: collision with root package name */
    private static final int f33291i = 15;

    /* renamed from: j, reason: collision with root package name */
    private static final int f33292j = 17;

    /* renamed from: k, reason: collision with root package name */
    private static final int f33293k = -1;

    /* renamed from: l, reason: collision with root package name */
    private static final int f33294l = 30;

    /* renamed from: m, reason: collision with root package name */
    private static final int f33295m = 31;

    /* renamed from: n, reason: collision with root package name */
    private static final int f33296n = 40;

    /* renamed from: o, reason: collision with root package name */
    private static final int f33297o = 41;

    /* renamed from: p, reason: collision with root package name */
    private static final int f33298p = 50;

    /* renamed from: q, reason: collision with root package name */
    private static final int f33299q = 60;

    /* renamed from: r, reason: collision with root package name */
    private static final int f33300r = 81;

    /* renamed from: s, reason: collision with root package name */
    private static final int f33301s = 90;

    /* renamed from: t, reason: collision with root package name */
    private static int f33302t = -1;

    public static boolean isEMUI() {
        return -1 != f33302t;
    }

    public static int getEMUIVersionCode() {
        int intValue;
        Object staticFieldObj = ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
        if (staticFieldObj != null) {
            try {
                intValue = ((Integer) staticFieldObj).intValue();
            } catch (ClassCastException e6) {
                Logger.e(f33284b, "getEMUIVersionCode ClassCastException:", e6);
            }
            Logger.d(f33284b, "the emui version code is::" + intValue);
            return intValue;
        }
        intValue = 0;
        Logger.d(f33284b, "the emui version code is::" + intValue);
        return intValue;
    }

    public static boolean isUpPVersion() {
        try {
            if (ReflectionUtils.checkCompatible(f33283a) && ReflectionUtils.checkCompatible(BUILDEX_VERSION)) {
                return BuildEx.VERSION.EMUI_SDK_INT >= 17;
            }
        } catch (NoSuchMethodError unused) {
            Logger.d(f33284b, "no such method for com.huawei.android.os.BuildEx.VERSION");
        } catch (Throwable unused2) {
            Logger.d(f33284b, "com.huawei.android.os.BuildEx.VERSION has other exception");
        }
        Logger.d(f33284b, "com.huawei.android.os.BuildEx : false");
        return false;
    }

    static {
        a();
    }

    private static void a() {
        int eMUIVersionCode = getEMUIVersionCode();
        Logger.d(f33284b, "getEmuiType emuiVersionCode=" + eMUIVersionCode);
        if (eMUIVersionCode >= 17) {
            f33302t = 90;
        } else if (eMUIVersionCode >= 15) {
            f33302t = 81;
        } else if (eMUIVersionCode >= 14) {
            f33302t = 60;
        } else if (eMUIVersionCode >= 11) {
            f33302t = 50;
        } else if (eMUIVersionCode >= 10) {
            f33302t = 41;
        } else if (eMUIVersionCode >= 9) {
            f33302t = 40;
        } else if (eMUIVersionCode >= 8) {
            f33302t = 31;
        } else if (eMUIVersionCode >= 7) {
            f33302t = 30;
        }
        if (f33302t == -1) {
            Logger.i(f33284b, "emuiType is unkown");
        }
    }
}
