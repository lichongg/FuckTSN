package com.bytedance.j.xt;

import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum cw {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE(AMPSConstants.AdType.AD_TYPE_NATIVE),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");

    private String oq;

    public String j() {
        return this.oq;
    }

    cw(String str) {
        this.oq = str;
    }
}
