package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i6);
            }
        }
        return str;
    }

    public PercentEscaper(String str, boolean z5) {
        Preconditions.checkNotNull(str);
        if (!str.matches(".*[0-9A-Za-z].*")) {
            String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            if (z5 && str2.contains(" ")) {
                throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
            }
            this.plusForSpace = z5;
            this.safeOctets = createSafeOctets(str2);
            return;
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int i6 = -1;
        for (char c6 : charArray) {
            i6 = Math.max((int) c6, i6);
        }
        boolean[] zArr = new boolean[i6 + 1];
        for (char c7 : charArray) {
            zArr[c7] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected int nextEscapeIndex(CharSequence charSequence, int i6, int i7) {
        Preconditions.checkNotNull(charSequence);
        while (i6 < i7) {
            char charAt = charSequence.charAt(i6);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i6++;
        }
        return i6;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected char[] escape(int i6) {
        boolean[] zArr = this.safeOctets;
        if (i6 < zArr.length && zArr[i6]) {
            return null;
        }
        if (i6 == 32 && this.plusForSpace) {
            return PLUS_SIGN;
        }
        if (i6 <= 127) {
            char[] cArr = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr[i6 >>> 4], cArr[i6 & 15]};
        }
        if (i6 <= 2047) {
            char[] cArr2 = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr2[(i6 >>> 10) | 12], cArr2[(i6 >>> 6) & 15], '%', cArr2[((i6 >>> 4) & 3) | 8], cArr2[i6 & 15]};
        }
        if (i6 <= 65535) {
            char[] cArr3 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'E', cArr3[i6 >>> 12], '%', cArr3[((i6 >>> 10) & 3) | 8], cArr3[(i6 >>> 6) & 15], '%', cArr3[((i6 >>> 4) & 3) | 8], cArr3[i6 & 15]};
        }
        if (i6 <= 1114111) {
            char[] cArr4 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'F', cArr4[(i6 >>> 18) & 7], '%', cArr4[((i6 >>> 16) & 3) | 8], cArr4[(i6 >>> 12) & 15], '%', cArr4[((i6 >>> 10) & 3) | 8], cArr4[(i6 >>> 6) & 15], '%', cArr4[((i6 >>> 4) & 3) | 8], cArr4[i6 & 15]};
        }
        throw new IllegalArgumentException("Invalid unicode character value " + i6);
    }
}
