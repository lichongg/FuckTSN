package com.bytedance.msdk.xt;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.explore.model.ExploreConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {
    public static String j(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase(MediationConstant.ADN_GDT) ? MediationConstant.ADN_GDT : str.equalsIgnoreCase(MediationConstant.ADN_ADMOB) ? MediationConstant.ADN_ADMOB : str.equalsIgnoreCase(MediationConstant.ADN_PANGLE) ? MediationConstant.ADN_PANGLE : str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL) ? MediationConstant.ADN_MINTEGRAL : str.equalsIgnoreCase(MediationConstant.ADN_UNITY) ? MediationConstant.ADN_UNITY : str.equalsIgnoreCase("baidu") ? "baidu" : str.equalsIgnoreCase(MediationConstant.ADN_KS) ? MediationConstant.ADN_KS : str.equalsIgnoreCase(MediationConstant.ADN_SIGMOB) ? MediationConstant.ADN_SIGMOB : str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN) ? MediationConstant.ADN_KLEVIN : str.equalsIgnoreCase("xiaomi") ? "xiaomi" : str;
    }

    public static int xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith(MediationConstant.ADN_GDT)) {
            return 3;
        }
        if (str.startsWith(MediationConstant.ADN_ADMOB)) {
            return 2;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_PANGLE)) {
            return 1;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL)) {
            return 4;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_UNITY)) {
            return 5;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return 6;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KS)) {
            return 7;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_SIGMOB)) {
            return 8;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN)) {
            return 9;
        }
        return str.equalsIgnoreCase("xiaomi") ? 10 : -1;
    }

    public static String j(int i6) {
        if (i6 == 3) {
            return MediationConstant.ADN_GDT;
        }
        if (i6 == 2) {
            return MediationConstant.ADN_ADMOB;
        }
        if (i6 == 1) {
            return MediationConstant.ADN_PANGLE;
        }
        if (i6 == 4) {
            return MediationConstant.ADN_MINTEGRAL;
        }
        if (i6 == 5) {
            return MediationConstant.ADN_UNITY;
        }
        if (i6 == 6) {
            return "baidu";
        }
        if (i6 == 7) {
            return MediationConstant.ADN_KS;
        }
        if (i6 == 8) {
            return MediationConstant.ADN_SIGMOB;
        }
        if (i6 == 9) {
            return MediationConstant.ADN_KLEVIN;
        }
        if (i6 == 10) {
            return "xiaomi";
        }
        if (i6 == -1) {
            return "custom";
        }
        return "";
    }

    public static String xt(int i6) {
        switch (i6) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                return "Native";
            case 6:
            default:
                return "UnKnow";
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                return "InterstitialFull";
        }
    }

    public static String j(int i6, int i7) {
        switch (i6) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                if (i7 == 4) {
                    return "Native";
                }
                if (i7 == 5) {
                    return "Draw";
                }
                if (i7 == 3) {
                    return "Banner";
                }
                return "Native";
            case 6:
            default:
                return null;
            case 7:
                return (i7 != 6 && i7 == 7) ? "FullVideo" : "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                if (i7 == 1) {
                    return ExploreConstants.SCENE_INTERSTITIAL;
                }
                if (i7 == 2) {
                    return "FullVideo";
                }
                return null;
        }
    }

    public static String j(int i6, int i7, oq oqVar) {
        switch (i6) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                if (i7 == 4) {
                    if (oqVar == null || oqVar.oq() != 1) {
                        return "Native-自渲染";
                    }
                    return "Native-模板渲染";
                }
                if (i7 == 5) {
                    return "NativeDraw";
                }
                if (i7 == 3) {
                    return "Banner";
                }
                return "Native-自渲染";
            case 6:
            default:
                return null;
            case 7:
                if (i7 == 6 || i7 != 7) {
                    return "Reward_RewardVideo";
                }
                return "Reward_FullVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
            case 10:
                if (i7 == 1) {
                    return "InterstitialFull—Interstitial";
                }
                if (i7 == 2) {
                    return "InterstitialFull—FullVideo";
                }
                return null;
        }
    }
}
