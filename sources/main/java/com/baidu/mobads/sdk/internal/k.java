package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11051a = "竞价参数格式错误，请检查参数是否为空";

    /* renamed from: b, reason: collision with root package name */
    private static final String f11052b = "ecpm格式错误，请检查是否满足以下条件：ecpm需大于0，单位：分，无小数点";

    /* renamed from: c, reason: collision with root package name */
    private static final String f11053c = "adn格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: d, reason: collision with root package name */
    private static final String f11054d = "ad_t格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: e, reason: collision with root package name */
    private static final String f11055e = "ad_time格式错误，请检查是否满足以下条件：秒级时间戳（10位数字）、无特殊符号";

    /* renamed from: f, reason: collision with root package name */
    private static final String f11056f = "bid_t格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: g, reason: collision with root package name */
    private static final String f11057g = "reason格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: h, reason: collision with root package name */
    private static final String f11058h = "is_s格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    /* renamed from: i, reason: collision with root package name */
    private static final String f11059i = "is_c格式错误，请检查是否满足以下条件：整型，不支持小数，需在枚举值范围内";

    public static boolean a(boolean z5, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (linkedHashMap != null) {
            try {
                if (linkedHashMap.containsKey("ecpm")) {
                    String valueOf = String.valueOf(linkedHashMap.get("ecpm"));
                    if (!TextUtils.isEmpty(valueOf)) {
                        if (!valueOf.contains(".")) {
                            if (Integer.parseInt(valueOf) <= 0) {
                            }
                        }
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f11052b, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey(SplashAd.KEY_BIDFAIL_ADN)) {
                    String valueOf2 = String.valueOf(linkedHashMap.get(SplashAd.KEY_BIDFAIL_ADN));
                    if (!TextUtils.isEmpty(valueOf2) && (valueOf2.contains(".") || Integer.parseInt(valueOf2) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f11053c, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("ad_t")) {
                    String valueOf3 = String.valueOf(linkedHashMap.get("ad_t"));
                    if (TextUtils.isEmpty(valueOf3) && (valueOf3.contains(".") || Integer.parseInt(valueOf3) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f11054d, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("ad_time")) {
                    String valueOf4 = String.valueOf(linkedHashMap.get("ad_time"));
                    if (valueOf4.length() == 13) {
                        linkedHashMap.put("ad_time", valueOf4.substring(0, 10));
                    }
                    if (TextUtils.isEmpty(valueOf4) && (valueOf4.contains(".") || Double.parseDouble(valueOf4) < 1.0E9d)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f11055e, null);
                        }
                        return false;
                    }
                }
                if (linkedHashMap.containsKey("bid_t")) {
                    String valueOf5 = String.valueOf(linkedHashMap.get("bid_t"));
                    if (TextUtils.isEmpty(valueOf5) && (valueOf5.contains(".") || Integer.parseInt(valueOf5) < 0)) {
                        if (biddingListener != null) {
                            biddingListener.onBiddingResult(false, f11056f, null);
                        }
                        return false;
                    }
                }
                if (!z5) {
                    if (linkedHashMap.containsKey(MediationConstant.KEY_REASON)) {
                        String valueOf6 = String.valueOf(linkedHashMap.get(MediationConstant.KEY_REASON));
                        if (TextUtils.isEmpty(valueOf6) && (valueOf6.contains(".") || Integer.parseInt(valueOf6) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, f11057g, null);
                            }
                            return false;
                        }
                    }
                    if (linkedHashMap.containsKey("is_s")) {
                        String valueOf7 = String.valueOf(linkedHashMap.get("is_s"));
                        if (TextUtils.isEmpty(valueOf7) && (valueOf7.contains(".") || Integer.parseInt(valueOf7) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, f11058h, null);
                            }
                            return false;
                        }
                    }
                    if (linkedHashMap.containsKey("is_c")) {
                        String valueOf8 = String.valueOf(linkedHashMap.get("is_c"));
                        if (TextUtils.isEmpty(valueOf8) && (valueOf8.contains(".") || Integer.parseInt(valueOf8) < 0)) {
                            if (biddingListener != null) {
                                biddingListener.onBiddingResult(false, f11059i, null);
                            }
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                if (biddingListener != null) {
                    biddingListener.onBiddingResult(false, f11051a, null);
                }
                th.printStackTrace();
                return false;
            }
        }
        if (biddingListener != null) {
            biddingListener.onBiddingResult(true, "success", null);
        }
        return true;
    }
}
