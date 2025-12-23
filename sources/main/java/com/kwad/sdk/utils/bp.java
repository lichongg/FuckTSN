package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bp {
    private static final SimpleDateFormat baJ;
    private static final SimpleDateFormat baK;
    private static final SimpleDateFormat baL;
    private static final SimpleDateFormat baM;
    private static final SimpleDateFormat baN;
    private static final SimpleDateFormat baO;
    private static final SimpleDateFormat baP;

    static {
        Locale locale = Locale.US;
        baJ = new SimpleDateFormat("MM/dd", locale);
        baK = new SimpleDateFormat("yyyy/MM/dd", locale);
        baL = new SimpleDateFormat("MM月dd日", locale);
        baM = new SimpleDateFormat("yyyy年MM月dd日", locale);
        baN = new SimpleDateFormat("HH:mm", locale);
        baO = new SimpleDateFormat("MM-dd", locale);
        baP = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean hp(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches(".*\\.kpg.*");
        }
        return false;
    }

    public static boolean isEquals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isNullString(String str) {
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
