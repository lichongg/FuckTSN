package com.alibaba.fastjson.parser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch;

    public final int mask = 1 << ordinal();

    public static int of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i6 = 0;
        for (Feature feature : featureArr) {
            i6 |= feature.mask;
        }
        return i6;
    }

    public static int config(int i6, Feature feature, boolean z5) {
        return z5 ? i6 | feature.mask : i6 & (~feature.mask);
    }

    public static boolean isEnabled(int i6, Feature feature) {
        return (i6 & feature.mask) != 0;
    }

    public final int getMask() {
        return this.mask;
    }

    Feature() {
    }
}
