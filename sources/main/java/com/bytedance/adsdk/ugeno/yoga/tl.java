package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum tl {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);


    /* renamed from: r, reason: collision with root package name */
    private final int f23919r;

    public static tl j(int i6) {
        if (i6 == 0) {
            return UNDEFINED;
        }
        if (i6 == 1) {
            return EXACTLY;
        }
        if (i6 == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i6)));
    }

    tl(int i6) {
        this.f23919r = i6;
    }
}
