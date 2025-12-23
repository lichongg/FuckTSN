package com.huawei.hms.framework.common.grs;

import com.huawei.hms.framework.common.StringUtils;
import java.util.Locale;
import org.slf4j.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class GrsUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final int f33358a = 3;

    /* renamed from: b, reason: collision with root package name */
    private static final int f33359b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f33360c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f33361d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final String f33362e = "/";

    /* renamed from: f, reason: collision with root package name */
    private static final String f33363f = "grs://";

    public static String fixResult(String[] strArr, String str) {
        if (strArr.length <= 2) {
            return str;
        }
        if (str.endsWith(f33362e)) {
            return str + strArr[2];
        }
        return str + f33362e + strArr[2];
    }

    public static boolean isGRSSchema(String str) {
        return str != null && str.startsWith(f33363f);
    }

    public static String[] parseGRSSchema(String str) {
        String[] split = StringUtils.substring(str, str.toLowerCase(Locale.ENGLISH).indexOf(f33363f) + 6).split(f33362e, 3);
        return split.length == 1 ? new String[]{split[0], c.E0} : split;
    }

    public static String[] parseParams(String str) {
        if (str.endsWith(f33362e)) {
            str = StringUtils.substring(str, str.indexOf(f33363f), str.length() - 1);
        }
        return parseGRSSchema(str);
    }
}
