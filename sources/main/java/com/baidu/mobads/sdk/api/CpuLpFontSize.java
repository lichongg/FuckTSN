package com.baidu.mobads.sdk.api;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR("reg"),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");

    String mValue;

    public String getValue() {
        return this.mValue;
    }

    CpuLpFontSize(String str) {
        this.mValue = str;
    }
}
