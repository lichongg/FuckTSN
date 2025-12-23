package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    protected abstract char[] escape(int i6);

    private static char[] growBuffer(char[] cArr, int i6, int i7) {
        if (i7 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i7];
        if (i6 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i6);
        }
        return cArr2;
    }

    protected int nextEscapeIndex(CharSequence charSequence, int i6, int i7) {
        while (i6 < i7) {
            int codePointAt = codePointAt(charSequence, i6, i7);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            i6 += Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1;
        }
        return i6;
    }

    protected UnicodeEscaper() {
    }

    protected static int codePointAt(CharSequence charSequence, int i6, int i7) {
        Preconditions.checkNotNull(charSequence);
        if (i6 < i7) {
            int i8 = i6 + 1;
            char charAt = charSequence.charAt(i6);
            if (charAt >= 55296 && charAt <= 57343) {
                if (charAt <= 56319) {
                    if (i8 == i7) {
                        return -charAt;
                    }
                    char charAt2 = charSequence.charAt(i8);
                    if (Character.isLowSurrogate(charAt2)) {
                        return Character.toCodePoint(charAt, charAt2);
                    }
                    throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i8 + " in '" + ((Object) charSequence) + "'");
                }
                throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + ((int) charAt) + " at index " + i6 + " in '" + ((Object) charSequence) + "'");
            }
            return charAt;
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    protected final String escapeSlow(String str, int i6) {
        int i7;
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i8 = 0;
        int i9 = 0;
        while (i6 < length) {
            int codePointAt = codePointAt(str, i6, length);
            if (codePointAt >= 0) {
                char[] escape = escape(codePointAt);
                if (Character.isSupplementaryCodePoint(codePointAt)) {
                    i7 = 2;
                } else {
                    i7 = 1;
                }
                int i10 = i7 + i6;
                if (escape != null) {
                    int i11 = i6 - i8;
                    int i12 = i9 + i11;
                    int length2 = escape.length + i12;
                    if (charBufferFromThreadLocal.length < length2) {
                        charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i9, length2 + (length - i6) + 32);
                    }
                    if (i11 > 0) {
                        str.getChars(i8, i6, charBufferFromThreadLocal, i9);
                        i9 = i12;
                    }
                    if (escape.length > 0) {
                        System.arraycopy(escape, 0, charBufferFromThreadLocal, i9, escape.length);
                        i9 += escape.length;
                    }
                    i8 = i10;
                }
                i6 = nextEscapeIndex(str, i10, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i13 = length - i8;
        if (i13 > 0) {
            int i14 = i13 + i9;
            if (charBufferFromThreadLocal.length < i14) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i9, i14);
            }
            str.getChars(i8, length, charBufferFromThreadLocal, i9);
            i9 = i14;
        }
        return new String(charBufferFromThreadLocal, 0, i9);
    }
}
