package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum ws {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);


    /* renamed from: r, reason: collision with root package name */
    private final int f23944r;

    public int j() {
        return this.f23944r;
    }

    public static ws j(int i6) {
        if (i6 == 0) {
            return NO_WRAP;
        }
        if (i6 == 1) {
            return WRAP;
        }
        if (i6 == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i6)));
    }

    ws(int i6) {
        this.f23944r = i6;
    }

    public static ws j(String str) {
        str.getClass();
        switch (str) {
            case "nowrap":
                return NO_WRAP;
            case "wrap":
                return WRAP;
            case "wrap_reverse":
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
