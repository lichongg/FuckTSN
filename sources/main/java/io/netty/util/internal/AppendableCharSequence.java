package io.netty.util.internal;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i6) {
        if (i6 >= 1) {
            this.chars = new char[i6];
            return;
        }
        throw new IllegalArgumentException("length: " + i6 + " (length: >= 1)");
    }

    private static char[] expand(char[] cArr, int i6, int i7) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i6 > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i7);
        return cArr2;
    }

    public void reset() {
        this.pos = 0;
    }

    public String substring(int i6, int i7) {
        int i8 = i7 - i6;
        int i9 = this.pos;
        if (i6 > i9 || i8 > i9) {
            throw new IndexOutOfBoundsException();
        }
        return new String(this.chars, i6, i8);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i6) {
        if (i6 <= this.pos) {
            return this.chars[i6];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i6) {
        return this.chars[i6];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i6, int i7) {
        return i6 == i7 ? new AppendableCharSequence(Math.min(16, this.chars.length)) : new AppendableCharSequence(Arrays.copyOfRange(this.chars, i6, i7));
    }

    public String subStringUnsafe(int i6, int i7) {
        return new String(this.chars, i6, i7 - i6);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    private AppendableCharSequence(char[] cArr) {
        if (cArr.length >= 1) {
            this.chars = cArr;
            this.pos = cArr.length;
        } else {
            throw new IllegalArgumentException("length: " + cArr.length + " (length: >= 1)");
        }
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c6) {
        int i6 = this.pos;
        char[] cArr = this.chars;
        if (i6 == cArr.length) {
            char[] cArr2 = new char[cArr.length << 1];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i7 = this.pos;
        this.pos = i7 + 1;
        cArr3[i7] = c6;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i6, int i7) {
        if (charSequence.length() >= i7) {
            int i8 = i7 - i6;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i9 = this.pos;
            if (i8 > length - i9) {
                this.chars = expand(cArr, i9 + i8, i9);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i6, this.chars, this.pos, i8);
                this.pos += i8;
                return this;
            }
            while (i6 < i7) {
                char[] cArr2 = this.chars;
                int i10 = this.pos;
                this.pos = i10 + 1;
                cArr2[i10] = charSequence.charAt(i6);
                i6++;
            }
            return this;
        }
        throw new IndexOutOfBoundsException();
    }
}
