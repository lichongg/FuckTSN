package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Strings {
    @VisibleForTesting
    static boolean validSurrogatePairAt(CharSequence charSequence, int i6) {
        return i6 >= 0 && i6 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i6)) && Character.isLowSurrogate(charSequence.charAt(i6 + 1));
    }

    private Strings() {
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i6 = 0;
        while (i6 < min && charSequence.charAt(i6) == charSequence2.charAt(i6)) {
            i6++;
        }
        int i7 = i6 - 1;
        if (validSurrogatePairAt(charSequence, i7) || validSurrogatePairAt(charSequence2, i7)) {
            i6--;
        }
        return charSequence.subSequence(0, i6).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i6 = 0;
        while (i6 < min && charSequence.charAt((charSequence.length() - i6) - 1) == charSequence2.charAt((charSequence2.length() - i6) - 1)) {
            i6++;
        }
        if (validSurrogatePairAt(charSequence, (charSequence.length() - i6) - 1) || validSurrogatePairAt(charSequence2, (charSequence2.length() - i6) - 1)) {
            i6--;
        }
        return charSequence.subSequence(charSequence.length() - i6, charSequence.length()).toString();
    }

    @NullableDecl
    public static String emptyToNull(@NullableDecl String str) {
        return Platform.emptyToNull(str);
    }

    public static boolean isNullOrEmpty(@NullableDecl String str) {
        return Platform.stringIsNullOrEmpty(str);
    }

    public static String lenientFormat(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i6 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i7 = 0; i7 < objArr.length; i7++) {
                objArr[i7] = lenientToString(objArr[i7]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i8 = 0;
        while (i6 < objArr.length && (indexOf = valueOf.indexOf("%s", i8)) != -1) {
            sb.append((CharSequence) valueOf, i8, indexOf);
            sb.append(objArr[i6]);
            i8 = indexOf + 2;
            i6++;
        }
        sb.append((CharSequence) valueOf, i8, valueOf.length());
        if (i6 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i9 = i6 + 1; i9 < objArr.length; i9++) {
                sb.append(", ");
                sb.append(objArr[i9]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String lenientToString(@NullableDecl Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e6) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e6);
            return "<" + str + " threw " + e6.getClass().getName() + ">";
        }
    }

    public static String nullToEmpty(@NullableDecl String str) {
        return Platform.nullToEmpty(str);
    }

    public static String padEnd(String str, int i6, char c6) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i6) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i6);
        sb.append(str);
        for (int length = str.length(); length < i6; length++) {
            sb.append(c6);
        }
        return sb.toString();
    }

    public static String padStart(String str, int i6, char c6) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i6) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i6);
        for (int length = str.length(); length < i6; length++) {
            sb.append(c6);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String repeat(String str, int i6) {
        Preconditions.checkNotNull(str);
        boolean z5 = false;
        if (i6 <= 1) {
            if (i6 >= 0) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "invalid count: %s", i6);
            if (i6 == 0) {
                return "";
            }
            return str;
        }
        int length = str.length();
        long j6 = length * i6;
        int i7 = (int) j6;
        if (i7 == j6) {
            char[] cArr = new char[i7];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i8 = i7 - length;
                if (length < i8) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i8);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j6);
        }
    }
}
