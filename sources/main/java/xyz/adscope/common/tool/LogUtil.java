package xyz.adscope.common.tool;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LogUtil {
    public static String generateTag(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        try {
            if (TextUtils.isEmpty(className)) {
                return "%s.%s(Line:%d)";
            }
            return String.format(Locale.ENGLISH, "%s.%s(Line:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        } catch (Exception unused) {
            return "LogUtil";
        }
    }

    public static StackTraceElement getStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    public static void d(String str, String str2) {
    }

    public static void dd(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void i(String str, String str2) {
    }
}
