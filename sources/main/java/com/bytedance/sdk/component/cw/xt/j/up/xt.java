package com.bytedance.sdk.component.cw.xt.j.up;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum xt {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int ae;

    xt(int i6) {
        this.ae = i6;
    }

    public static xt j(int i6) {
        try {
            for (xt xtVar : values()) {
                if (xtVar.ae == i6) {
                    return xtVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
