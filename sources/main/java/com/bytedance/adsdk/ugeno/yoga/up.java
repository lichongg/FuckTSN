package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum up {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);

    private final int up;

    public int j() {
        return this.up;
    }

    public static up j(int i6) {
        if (i6 == 0) {
            return COLUMN;
        }
        if (i6 == 1) {
            return COLUMN_REVERSE;
        }
        if (i6 == 2) {
            return ROW;
        }
        if (i6 == 3) {
            return ROW_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i6)));
    }

    up(int i6) {
        this.up = i6;
    }

    public static up j(String str) {
        str.getClass();
        switch (str) {
            case "column_reverse":
                return COLUMN_REVERSE;
            case "column":
                return COLUMN;
            case "row_reverse":
                return ROW_REVERSE;
            case "row":
                return ROW;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }
}
