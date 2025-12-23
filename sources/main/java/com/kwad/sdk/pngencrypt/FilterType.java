package com.kwad.sdk.pngencrypt;

import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum FilterType {
    FILTER_NONE(0),
    FILTER_SUB(1),
    FILTER_UP(2),
    FILTER_AVERAGE(3),
    FILTER_PAETH(4),
    FILTER_DEFAULT(-1),
    FILTER_AGGRESSIVE(-2),
    FILTER_VERYAGGRESSIVE(-4),
    FILTER_ADAPTIVE_FULL(-4),
    FILTER_ADAPTIVE_MEDIUM(-3),
    FILTER_ADAPTIVE_FAST(-2),
    FILTER_SUPER_ADAPTIVE(-10),
    FILTER_PRESERVE(-40),
    FILTER_CYCLIC(-50),
    FILTER_UNKNOWN(-100);

    private static HashMap<Integer, FilterType> byVal = new HashMap<>();
    public final int val;

    public static FilterType[] getAllStandard() {
        return new FilterType[]{FILTER_NONE, FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardExceptNone() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    static FilterType[] getAllStandardForFirstRow() {
        return new FilterType[]{FILTER_SUB, FILTER_NONE};
    }

    public static FilterType[] getAllStandardNoneLast() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH, FILTER_NONE};
    }

    public static boolean isValidStandard(int i6) {
        return i6 >= 0 && i6 <= 4;
    }

    static {
        for (FilterType filterType : values()) {
            byVal.put(Integer.valueOf(filterType.val), filterType);
        }
    }

    public static FilterType getByVal(int i6) {
        return byVal.get(Integer.valueOf(i6));
    }

    public static boolean isAdaptive(FilterType filterType) {
        int i6 = filterType.val;
        return i6 <= -2 && i6 >= -4;
    }

    public static boolean isValidStandard(FilterType filterType) {
        return filterType != null && isValidStandard(filterType.val);
    }

    FilterType(int i6) {
        this.val = i6;
    }
}
