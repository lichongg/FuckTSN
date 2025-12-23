package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (escape(str.charAt(i6)) != null) {
                return escapeSlow(str, i6);
            }
        }
        return str;
    }

    protected abstract char[] escape(char c6);

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

    protected CharEscaper() {
    }

    protected final String escapeSlow(String str, int i6) {
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int length2 = charBufferFromThreadLocal.length;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            char[] escape = escape(str.charAt(i6));
            if (escape != null) {
                int length3 = escape.length;
                int i9 = i6 - i7;
                int i10 = i8 + i9;
                int i11 = i10 + length3;
                if (length2 < i11) {
                    length2 = ((length - i6) * 2) + i11;
                    charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i8, length2);
                }
                if (i9 > 0) {
                    str.getChars(i7, i6, charBufferFromThreadLocal, i8);
                    i8 = i10;
                }
                if (length3 > 0) {
                    System.arraycopy(escape, 0, charBufferFromThreadLocal, i8, length3);
                    i8 += length3;
                }
                i7 = i6 + 1;
            }
            i6++;
        }
        int i12 = length - i7;
        if (i12 > 0) {
            int i13 = i12 + i8;
            if (length2 < i13) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i8, i13);
            }
            str.getChars(i7, length, charBufferFromThreadLocal, i8);
            i8 = i13;
        }
        return new String(charBufferFromThreadLocal, 0, i8);
    }
}
