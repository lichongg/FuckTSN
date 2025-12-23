package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SystemPropertyUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SystemPropertyUtil.class);

    public static String get(String str) {
        return get(str, null);
    }

    public static String get(final String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }
        try {
            str = System.getSecurityManager() == null ? System.getProperty(str) : (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.SystemPropertyUtil.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty(str);
                }
            });
        } catch (SecurityException e6) {
            logger.warn("Unable to retrieve a system property '{}'; default values will be used.", str, e6);
            str = null;
        }
        return str == null ? str2 : str;
    }

    private SystemPropertyUtil() {
    }

    public static boolean contains(String str) {
        if (get(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean getBoolean(String str, boolean z5) {
        String str2 = get(str);
        if (str2 != null) {
            String lowerCase = str2.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                if ("true".equals(lowerCase) || "yes".equals(lowerCase) || "1".equals(lowerCase)) {
                    return true;
                }
                if ("false".equals(lowerCase) || "no".equals(lowerCase) || "0".equals(lowerCase)) {
                    return false;
                }
                logger.warn("Unable to parse the boolean system property '{}':{} - using the default value: {}", str, lowerCase, Boolean.valueOf(z5));
                return z5;
            }
        }
        return z5;
    }

    public static int getInt(String str, int i6) {
        String str2 = get(str);
        if (str2 == null) {
            return i6;
        }
        String trim = str2.trim();
        try {
            return Integer.parseInt(trim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the integer system property '{}':{} - using the default value: {}", str, trim, Integer.valueOf(i6));
            return i6;
        }
    }

    public static long getLong(String str, long j6) {
        String str2 = get(str);
        if (str2 == null) {
            return j6;
        }
        String trim = str2.trim();
        try {
            return Long.parseLong(trim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the long integer system property '{}':{} - using the default value: {}", str, trim, Long.valueOf(j6));
            return j6;
        }
    }
}
