package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum jy {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);


    /* renamed from: r, reason: collision with root package name */
    private final int f23910r;

    public int j() {
        return this.f23910r;
    }

    public static jy j(int i6) {
        if (i6 == 0) {
            return STATIC;
        }
        if (i6 == 1) {
            return RELATIVE;
        }
        if (i6 == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i6)));
    }

    jy(int i6) {
        this.f23910r = i6;
    }

    public static jy j(String str) {
        str.getClass();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
