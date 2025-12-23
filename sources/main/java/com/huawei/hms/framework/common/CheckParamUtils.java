package com.huawei.hms.framework.common;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class CheckParamUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33270a = "CheckParamUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33271b = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";

    /* renamed from: c, reason: collision with root package name */
    private static Pattern f33272c = Pattern.compile(f33271b);

    public static int checkNumParam(int i6, int i7, int i8, int i9, String str) {
        if (i6 > i8 || i6 < i7) {
            return i9;
        }
        Logger.d(f33270a, str);
        return i6;
    }

    public static boolean isIpV4(String str) {
        if (str == null || str.isEmpty() || str.length() > 15 || !str.replace(".", "").matches("[0-9]+")) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String str2 : split) {
            if (str2.length() > 4 || Integer.parseInt(str2) > 255) {
                return false;
            }
        }
        return true;
    }

    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static long checkNumParam(long j6, long j7, long j8, long j9, String str) {
        if (j6 > j8 || j6 < j7) {
            return j9;
        }
        Logger.d(f33270a, str);
        return j6;
    }

    public static void checkOffsetAndCount(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean isIpV6(String str) {
        if (str == null || str.isEmpty() || str.length() < 2 || str.length() > 39) {
            return false;
        }
        return f33272c.matcher(str).matches();
    }
}
