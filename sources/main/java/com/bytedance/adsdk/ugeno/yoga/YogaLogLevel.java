package com.bytedance.adsdk.ugeno.yoga;

@com.bytedance.adsdk.ugeno.yoga.j.j
/* loaded from: D:\Downloads\app\classes3.dex */
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);

    private final int ae;

    @com.bytedance.adsdk.ugeno.yoga.j.j
    public static YogaLogLevel fromInt(int i6) {
        if (i6 == 0) {
            return ERROR;
        }
        if (i6 == 1) {
            return WARN;
        }
        if (i6 == 2) {
            return INFO;
        }
        if (i6 == 3) {
            return DEBUG;
        }
        if (i6 == 4) {
            return VERBOSE;
        }
        if (i6 == 5) {
            return FATAL;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i6)));
    }

    YogaLogLevel(int i6) {
        this.ae = i6;
    }
}
