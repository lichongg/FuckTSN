package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum m {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);

    private final int ae;

    public int j() {
        return this.ae;
    }

    public static m j(int i6) {
        if (i6 == 0) {
            return FLEX_START;
        }
        if (i6 == 1) {
            return CENTER;
        }
        if (i6 == 2) {
            return FLEX_END;
        }
        if (i6 == 3) {
            return SPACE_BETWEEN;
        }
        if (i6 == 4) {
            return SPACE_AROUND;
        }
        if (i6 == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i6)));
    }

    m(int i6) {
        this.ae = i6;
    }

    public static m j(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return CENTER;
            case "space_around":
                return SPACE_AROUND;
            case "space_evenly":
                return SPACE_EVENLY;
            case "flex_start":
                return FLEX_START;
            case "space_between":
                return SPACE_BETWEEN;
            case "flex_end":
                return FLEX_END;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
