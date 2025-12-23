package com.alibaba.fastjson.serializer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;

    public static final SerializerFeature[] EMPTY;
    public static final int WRITE_MAP_NULL_FEATURES;
    public final int mask = 1 << ordinal();

    public static boolean isEnabled(int i6, SerializerFeature serializerFeature) {
        return (i6 & serializerFeature.mask) != 0;
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i6 = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i6 |= serializerFeature.mask;
        }
        return i6;
    }

    static {
        SerializerFeature serializerFeature = WriteMapNullValue;
        SerializerFeature serializerFeature2 = WriteNullListAsEmpty;
        SerializerFeature serializerFeature3 = WriteNullStringAsEmpty;
        SerializerFeature serializerFeature4 = WriteNullNumberAsZero;
        SerializerFeature serializerFeature5 = WriteNullBooleanAsFalse;
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature.getMask() | serializerFeature5.getMask() | serializerFeature2.getMask() | serializerFeature4.getMask() | serializerFeature3.getMask();
    }

    public static int config(int i6, SerializerFeature serializerFeature, boolean z5) {
        return z5 ? i6 | serializerFeature.mask : i6 & (~serializerFeature.mask);
    }

    public static boolean isEnabled(int i6, int i7, SerializerFeature serializerFeature) {
        int i8 = serializerFeature.mask;
        return ((i6 & i8) == 0 && (i7 & i8) == 0) ? false : true;
    }

    public final int getMask() {
        return this.mask;
    }

    SerializerFeature() {
    }
}
