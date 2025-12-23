package com.bytedance.adsdk.ugeno.j;

import com.baidu.mobads.sdk.api.IAdInterListener;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum up {
    TRANSLATE("translate", "translation", "point"),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", "rotation", "float"),
    SCALE("scale", "scale", "point"),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA("opacity", "alpha", "float"),
    BACKGROUND_COLOR("backgroundColor", "backgroundColor", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    private final String av;
    private final String az;

    /* renamed from: i, reason: collision with root package name */
    private final String f23702i;

    public String j() {
        return this.az;
    }

    public static up j(String str) {
        str.getClass();
        switch (str) {
            case "translateX":
                return TRANSLATE_X;
            case "translateY":
                return TRANSLATE_Y;
            case "opacity":
                return ALPHA;
            case "ripple":
                return RIPPLE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "scale":
                return SCALE;
            case "translate":
                return TRANSLATE;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }

    public String cw() {
        return this.f23702i;
    }

    public String xt() {
        return this.av;
    }

    up(String str, String str2, String str3) {
        this.az = str;
        this.av = str2;
        this.f23702i = str3;
    }
}
