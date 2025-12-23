package com.bytedance.msdk.m;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.api.r.oq;
import com.bytedance.msdk.core.j.j.up;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static void j() {
        try {
            if (com.bytedance.msdk.j.up.cw.xt() && oq.j()) {
                xt();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean r(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i6 = 0; i6 < split.length; i6++) {
            if (split[i6].length() == split[i6].length() && split[i6].compareTo(split2[i6]) != 0) {
                return false;
            }
        }
        return true;
    }

    private static synchronized void xt() {
        synchronized (j.class) {
            if (com.bytedance.msdk.core.xt.getContext() == null) {
                return;
            }
            com.bytedance.msdk.ae.j.xt.j().r();
        }
    }

    private static int cw(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i6 = 0; i6 < min; i6++) {
            if (split[i6].length() == split2[i6].length()) {
                int compareTo = split[i6].compareTo(split2[i6]);
                if (compareTo != 0) {
                    return compareTo;
                }
            } else {
                if (split[i6].length() <= split2[i6].length()) {
                    return -1;
                }
                return 1;
            }
        }
        if (split.length == split2.length) {
            return 0;
        }
        if (split.length <= split2.length) {
            return -1;
        }
        return 1;
    }

    public static boolean j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("baidu") && !str.equals(MediationConstant.ADN_ADMOB) && !str.equals(MediationConstant.ADN_PANGLE)) {
            switch (str) {
                case "klevin":
                    if (cw(str2, "2.11.0.3") != 0) {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "klevin版本不符合, 要求版本等于2.11.0.3，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "klevin版本正常, 要求版本等于2.11.0.3，当前是" + str2);
                    break;
                case "sigmob":
                    if (cw(str2, "4.22.2") != 0) {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于4.22.2，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于4.22.2，当前是" + str2);
                    return true;
                case "xiaomi":
                    if (cw(str2, "2.11.0.3.31") != 0) {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "xiaomi版本不符合, 要求版本等于2.11.0.3.31，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "xiaomi版本正常, 要求版本等于2.11.0.3.31，当前是" + str2);
                    return true;
                case "ks":
                    if (cw(str2, "3.3.76.5") != 0) {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于3.3.76.5，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于3.3.76.5，当前是" + str2);
                    return true;
                case "gdt":
                    if (cw(str2, "4.640.1510") != 0) {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.640.1510，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.640.1510，当前是" + str2);
                    return true;
                case "unity":
                    if (cw(str2, "4.3.0") != 0) {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "unity版本不符合，要求等于4.3.0，当前是" + str2);
                        return false;
                    }
                    com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "unity版本正常，要求等于4.3.0，当前是" + str2);
                    return true;
                case "mintegral":
                    if (!TextUtils.isEmpty(str2) && str2.contains("16.6.57")) {
                        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", "Mintegral版本正常, 要求版本等于16.6.57，当前是" + str2);
                        return true;
                    }
                    com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "Mintegral版本不符合, 要求版本等于16.6.57，当前是" + str2);
                    return false;
                default:
                    return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean xt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(MediationConstant.ADN_PANGLE)) {
                return true;
            }
            switch (str) {
                case "klevin":
                    if (r("2.11.0.3", str2)) {
                        j("klevinAdapter", "2.11.0.3", str2);
                        break;
                    } else {
                        xt("klevinAdapter", "2.11.0.3", str2);
                        break;
                    }
                case "sigmob":
                    if (r("4.22.2", str2)) {
                        j("sigmobAdapter", "4.22.2", str2);
                        break;
                    } else {
                        xt("sigmobAdapter", "4.22.2", str2);
                        break;
                    }
                case "xiaomi":
                    if (r("2.11.0.3.31", str2)) {
                        j("xiaomiAdapter", "2.11.0.3.31", str2);
                        break;
                    } else {
                        xt("xiaomiAdapter", "2.11.0.3.31", str2);
                        break;
                    }
                case "ks":
                    if (up.cw(MediationConstant.ADN_KS) == null) {
                        if (r("3.3.76.5", str2)) {
                            j("ksAdapter", "3.3.76.5", str2);
                            break;
                        } else {
                            xt("ksAdapter", "3.3.76.5", str2);
                            break;
                        }
                    }
                    break;
                case "gdt":
                    if (up.cw(MediationConstant.ADN_GDT) == null) {
                        if (r("4.640.1510", str2)) {
                            j("gdtAdapter", "4.640.1510", str2);
                            break;
                        } else {
                            xt("gdtAdapter", "4.640.1510", str2);
                            break;
                        }
                    }
                    break;
                case "admob":
                    if (r("17.2.0", str2)) {
                        j("admobAdapter", "17.2.0", str2);
                        break;
                    } else {
                        xt("admobAdapter", "17.2.0", str2);
                        break;
                    }
                case "baidu":
                    if (r("9.3905", str2)) {
                        j("baiduAdapter", "9.3905", str2);
                        break;
                    } else {
                        xt("baiduAdapter", "9.3905", str2);
                        break;
                    }
                case "unity":
                    if (r("4.3.0", str2)) {
                        j("unityAdapter", "4.3.0", str2);
                        break;
                    } else {
                        xt("unityAdapter", "4.3.0", str2);
                        break;
                    }
                case "mintegral":
                    if (r("16.6.57", str2)) {
                        j("mtgAdapter", "16.6.57", str2);
                        break;
                    } else {
                        xt("mtgAdapter", "16.6.57", str2);
                        break;
                    }
            }
            return true;
        }
        return false;
    }

    private static void j(String str, String str2, String str3) {
        com.bytedance.msdk.j.up.cw.j("TTMediationSDK_InitChecker", str + "接入版本正常, 要求版为：" + str2 + "，当前版本为：" + str3);
    }

    private static void xt(String str, String str2, String str3) {
        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", str + "接入版本不符合, 要求版为：" + str2 + ".x，当前版本为：" + str3);
    }
}
