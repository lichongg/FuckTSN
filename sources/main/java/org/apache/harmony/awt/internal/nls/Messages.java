package org.apache.harmony.awt.internal.nls;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Messages {
    private static ResourceBundle bundle;

    public static String getString(String str) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }

    public static ResourceBundle setLocale(final Locale locale, final String str) {
        final ClassLoader classLoader = null;
        try {
            return (ResourceBundle) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.apache.harmony.awt.internal.nls.Messages.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    String str2 = str;
                    Locale locale2 = locale;
                    ClassLoader classLoader2 = classLoader;
                    if (classLoader2 == null) {
                        classLoader2 = ClassLoader.getSystemClassLoader();
                    }
                    return ResourceBundle.getBundle(str2, locale2, classLoader2);
                }
            });
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static String format(String str, Object[] objArr) {
        int length;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 20));
        int length2 = objArr.length;
        String[] strArr = new String[length2];
        int i6 = 0;
        for (int i7 = 0; i7 < objArr.length; i7++) {
            Object obj = objArr[i7];
            if (obj == null) {
                strArr[i7] = "<null>";
            } else {
                strArr[i7] = obj.toString();
            }
        }
        while (true) {
            int indexOf = str.indexOf(123, i6);
            if (indexOf < 0) {
                break;
            }
            if (indexOf != 0) {
                int i8 = indexOf - 1;
                if (str.charAt(i8) == '\\') {
                    if (indexOf != 1) {
                        sb.append(str.substring(i6, i8));
                    }
                    sb.append('{');
                    length = indexOf + 1;
                    i6 = length;
                }
            }
            if (indexOf > str.length() - 3) {
                sb.append(str.substring(i6, str.length()));
                length = str.length();
            } else {
                int i9 = indexOf + 1;
                byte digit = (byte) Character.digit(str.charAt(i9), 10);
                if (digit < 0 || str.charAt(indexOf + 2) != '}') {
                    sb.append(str.substring(i6, i9));
                    i6 = i9;
                } else {
                    sb.append(str.substring(i6, indexOf));
                    if (digit >= length2) {
                        sb.append("<missing argument>");
                    } else {
                        sb.append(strArr[digit]);
                    }
                    length = indexOf + 3;
                }
            }
            i6 = length;
        }
        if (i6 < str.length()) {
            sb.append(str.substring(i6, str.length()));
        }
        return sb.toString();
    }

    static {
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.harmony.awt.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getString(String str, Object obj) {
        return getString(str, new Object[]{obj});
    }

    public static String getString(String str, int i6) {
        return getString(str, new Object[]{Integer.toString(i6)});
    }

    public static String getString(String str, char c6) {
        return getString(str, new Object[]{String.valueOf(c6)});
    }

    public static String getString(String str, Object obj, Object obj2) {
        return getString(str, new Object[]{obj, obj2});
    }

    public static String getString(String str, Object[] objArr) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return format(str, objArr);
    }
}
