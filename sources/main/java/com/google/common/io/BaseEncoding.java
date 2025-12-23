package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Alphabet {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        private boolean hasLowerCase() {
            for (char c6 : this.chars) {
                if (Ascii.isLowerCase(c6)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c6 : this.chars) {
                if (Ascii.isUpperCase(c6)) {
                    return true;
                }
            }
            return false;
        }

        boolean canDecode(char c6) {
            return c6 <= 127 && this.decodabet[c6] != -1;
        }

        int decode(char c6) throws DecodingException {
            if (c6 > 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c6));
            }
            byte b6 = this.decodabet[c6];
            if (b6 != -1) {
                return b6;
            }
            if (c6 <= ' ' || c6 == 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c6));
            }
            throw new DecodingException("Unrecognized character: " + c6);
        }

        char encode(int i6) {
            return this.chars[i6];
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        boolean isValidPaddingStartPosition(int i6) {
            return this.validPadding[i6 % this.charsPerChunk];
        }

        public boolean matches(char c6) {
            byte[] bArr = this.decodabet;
            return c6 < bArr.length && bArr[c6] != -1;
        }

        public String toString() {
            return this.name;
        }

        Alphabet(String str, char[] cArr) {
            boolean z5;
            boolean z6;
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = log2;
                int min = Math.min(8, Integer.lowestOneBit(log2));
                try {
                    this.charsPerChunk = 8 / min;
                    this.bytesPerChunk = log2 / min;
                    this.mask = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i6 = 0; i6 < cArr.length; i6++) {
                        char c6 = cArr[i6];
                        if (c6 < 128) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        Preconditions.checkArgument(z5, "Non-ASCII character: %s", c6);
                        if (bArr[c6] == -1) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        Preconditions.checkArgument(z6, "Duplicate character: %s", c6);
                        bArr[c6] = (byte) i6;
                    }
                    this.decodabet = bArr;
                    boolean[] zArr = new boolean[this.charsPerChunk];
                    for (int i7 = 0; i7 < this.bytesPerChunk; i7++) {
                        zArr[IntMath.divide(i7 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                    }
                    this.validPadding = zArr;
                } catch (ArithmeticException e6) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e6);
                }
            } catch (ArithmeticException e7) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e7);
            }
        }

        Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i6 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i6 < cArr2.length) {
                    cArr[i6] = Ascii.toLowerCase(cArr2[i6]);
                    i6++;
                } else {
                    return new Alphabet(this.name + ".lowerCase()", cArr);
                }
            }
        }

        Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i6 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i6 < cArr2.length) {
                    cArr[i6] = Ascii.toUpperCase(cArr2[i6]);
                    i6++;
                } else {
                    return new Alphabet(this.name + ".upperCase()", cArr);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] encoding;

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.encoding = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i6 = 0; i6 < 256; i6++) {
                this.encoding[i6] = alphabet.encode(i6 >>> 4);
                this.encoding[i6 | 256] = alphabet.encode(i6 & 15);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch) {
            return new Base16Encoding(alphabet);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 != 1) {
                int i6 = 0;
                int i7 = 0;
                while (i6 < charSequence.length()) {
                    bArr[i7] = (byte) ((this.alphabet.decode(charSequence.charAt(i6)) << 4) | this.alphabet.decode(charSequence.charAt(i6 + 1)));
                    i6 += 2;
                    i7++;
                }
                return i7;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i6, int i7) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = bArr[i6 + i8] & 255;
                appendable.append(this.encoding[i9]);
                appendable.append(this.encoding[i9 | 256]);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String str, String str2, @NullableDecl Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        private Base64Encoding(Alphabet alphabet, @NullableDecl Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                int i6 = 0;
                int i7 = 0;
                while (i6 < trimTrailingPadding.length()) {
                    int i8 = i6 + 2;
                    int decode = (this.alphabet.decode(trimTrailingPadding.charAt(i6)) << 18) | (this.alphabet.decode(trimTrailingPadding.charAt(i6 + 1)) << 12);
                    int i9 = i7 + 1;
                    bArr[i7] = (byte) (decode >>> 16);
                    if (i8 < trimTrailingPadding.length()) {
                        int i10 = i6 + 3;
                        int decode2 = decode | (this.alphabet.decode(trimTrailingPadding.charAt(i8)) << 6);
                        int i11 = i7 + 2;
                        bArr[i9] = (byte) ((decode2 >>> 8) & 255);
                        if (i10 < trimTrailingPadding.length()) {
                            i6 += 4;
                            i7 += 3;
                            bArr[i11] = (byte) ((decode2 | this.alphabet.decode(trimTrailingPadding.charAt(i10))) & 255);
                        } else {
                            i7 = i11;
                            i6 = i10;
                        }
                    } else {
                        i7 = i9;
                        i6 = i8;
                    }
                }
                return i7;
            }
            throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i6, int i7) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i8 = i6 + i7;
            Preconditions.checkPositionIndexes(i6, i8, bArr.length);
            while (i7 >= 3) {
                int i9 = i6 + 2;
                int i10 = ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6] & 255) << 16);
                i6 += 3;
                int i11 = i10 | (bArr[i9] & 255);
                appendable.append(this.alphabet.encode(i11 >>> 18));
                appendable.append(this.alphabet.encode((i11 >>> 12) & 63));
                appendable.append(this.alphabet.encode((i11 >>> 6) & 63));
                appendable.append(this.alphabet.encode(i11 & 63));
                i7 -= 3;
            }
            if (i6 < i8) {
                encodeChunkTo(appendable, bArr, i6, i8 - i6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            super(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < charSequence.length(); i6++) {
                char charAt = charSequence.charAt(i6);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i6 = 0; i6 < charSequence.length(); i6++) {
                char charAt = charSequence.charAt(i6);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(BaseEncoding.ignoringReader(reader, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i6, int i7) throws IOException {
            this.delegate.encodeTo(BaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i6, i7);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(BaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int i6) {
            return this.delegate.maxDecodedSize(i6);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int i6) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i6);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c6) {
            return this.delegate.withPadChar(c6).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i6) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i6) {
            boolean z5;
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i6;
            if (i6 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "Cannot add a separator after every %s chars", i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet alphabet;

        @MonotonicNonNullDecl
        private transient BaseEncoding lowerCase;

        @NullableDecl
        final Character paddingChar;

        @MonotonicNonNullDecl
        private transient BaseEncoding upperCase;

        StandardBaseEncoding(String str, String str2, @NullableDecl Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i6) {
            for (int i7 = 0; i7 < str.length(); i7++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i7)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.paddingChar;
            if (ch != null) {
                Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i6);
        }

        StandardBaseEncoding(Alphabet alphabet, @NullableDecl Character ch) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch == null || !alphabet.matches(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.paddingChar = ch;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof StandardBaseEncoding) {
                StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
                if (this.alphabet.equals(standardBaseEncoding.alphabet) && Objects.equal(this.paddingChar, standardBaseEncoding.paddingChar)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet lowerCase = this.alphabet.lowerCase();
                baseEncoding = lowerCase == this.alphabet ? this : newInstance(lowerCase, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int i6) {
            return (int) (((this.alphabet.bitsPerChar * i6) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int i6) {
            Alphabet alphabet = this.alphabet;
            return alphabet.charsPerChunk * IntMath.divide(i6, alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        BaseEncoding newInstance(Alphabet alphabet, @NullableDecl Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.paddingChar);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet upperCase = this.alphabet.upperCase();
                baseEncoding = upperCase == this.alphabet ? this : newInstance(upperCase, this.paddingChar);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c6) {
            Character ch;
            return (8 % this.alphabet.bitsPerChar == 0 || ((ch = this.paddingChar) != null && ch.charValue() == c6)) ? this : newInstance(this.alphabet, Character.valueOf(c6));
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                return false;
            }
            for (int i6 = 0; i6 < trimTrailingPadding.length(); i6++) {
                if (!this.alphabet.canDecode(trimTrailingPadding.charAt(i6))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet;
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                int i6 = 0;
                int i7 = 0;
                while (i6 < trimTrailingPadding.length()) {
                    long j6 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        alphabet = this.alphabet;
                        if (i8 >= alphabet.charsPerChunk) {
                            break;
                        }
                        j6 <<= alphabet.bitsPerChar;
                        if (i6 + i8 < trimTrailingPadding.length()) {
                            j6 |= this.alphabet.decode(trimTrailingPadding.charAt(i9 + i6));
                            i9++;
                        }
                        i8++;
                    }
                    int i10 = alphabet.bytesPerChunk;
                    int i11 = (i10 * 8) - (i9 * alphabet.bitsPerChar);
                    int i12 = (i10 - 1) * 8;
                    while (i12 >= i11) {
                        bArr[i7] = (byte) ((j6 >>> i12) & 255);
                        i12 -= 8;
                        i7++;
                    }
                    i6 += this.alphabet.charsPerChunk;
                }
                return i7;
            }
            throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int readChars = 0;
                boolean hitPadding = false;

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    reader.close();
                }

                /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
                
                    throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.readChars);
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public int read() throws java.io.IOException {
                    /*
                        r4 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r4.hitPadding
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.alphabet
                        int r2 = r4.readChars
                        boolean r0 = r0.isValidPaddingStartPosition(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Invalid input length "
                        r1.append(r2)
                        int r2 = r4.readChars
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L33:
                        return r1
                    L34:
                        int r1 = r4.readChars
                        r2 = 1
                        int r1 = r1 + r2
                        r4.readChars = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.paddingChar
                        if (r1 == 0) goto L78
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L78
                        boolean r0 = r4.hitPadding
                        if (r0 != 0) goto L75
                        int r0 = r4.readChars
                        if (r0 == r2) goto L5c
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.alphabet
                        int r0 = r0 + (-1)
                        boolean r0 = r1.isValidPaddingStartPosition(r0)
                        if (r0 == 0) goto L5c
                        goto L75
                    L5c:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Padding cannot start at index "
                        r1.append(r2)
                        int r2 = r4.readChars
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L75:
                        r4.hitPadding = r2
                        goto L0
                    L78:
                        boolean r1 = r4.hitPadding
                        if (r1 != 0) goto La4
                        int r1 = r4.bitBuffer
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r3 = r2.bitsPerChar
                        int r1 = r1 << r3
                        r4.bitBuffer = r1
                        int r0 = r2.decode(r0)
                        r0 = r0 | r1
                        r4.bitBuffer = r0
                        int r1 = r4.bitBufferLength
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r2 = r2.bitsPerChar
                        int r1 = r1 + r2
                        r4.bitBufferLength = r1
                        r2 = 8
                        if (r1 < r2) goto L0
                        int r1 = r1 - r2
                        r4.bitBufferLength = r1
                        int r0 = r0 >> r1
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    La4:
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Expected padding character but found '"
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = "' at index "
                        r2.append(r0)
                        int r0 = r4.readChars
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        r1.<init>(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }
            };
        }

        void encodeChunkTo(Appendable appendable, byte[] bArr, int i6, int i7) throws IOException {
            boolean z5;
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
            int i8 = 0;
            if (i7 <= this.alphabet.bytesPerChunk) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            long j6 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                j6 = (j6 | (bArr[i6 + i9] & 255)) << 8;
            }
            int i10 = ((i7 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i8 < i7 * 8) {
                Alphabet alphabet = this.alphabet;
                appendable.append(alphabet.encode(((int) (j6 >>> (i10 - i8))) & alphabet.mask));
                i8 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i8 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i8 += this.alphabet.bitsPerChar;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i6, int i7) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
            int i8 = 0;
            while (i8 < i7) {
                encodeChunkTo(appendable, bArr, i6 + i8, Math.min(this.alphabet.bytesPerChunk, i7 - i8));
                i8 += this.alphabet.bytesPerChunk;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    int i6 = this.bitBufferLength;
                    if (i6 > 0) {
                        int i7 = this.bitBuffer;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        writer.write(alphabet.encode((i7 << (alphabet.bitsPerChar - i6)) & alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (true) {
                                int i8 = this.writtenChars;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i8 % standardBaseEncoding.alphabet.charsPerChunk == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override // java.io.OutputStream
                public void write(int i6) throws IOException {
                    this.bitBuffer = (i6 & 255) | (this.bitBuffer << 8);
                    this.bitBufferLength += 8;
                    while (true) {
                        int i7 = this.bitBufferLength;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        int i8 = alphabet.bitsPerChar;
                        if (i7 < i8) {
                            return;
                        }
                        writer.write(alphabet.encode((this.bitBuffer >> (i7 - i8)) & alphabet.mask));
                        this.writtenChars++;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }
            };
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.paddingChar;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }
    }

    private static byte[] extract(byte[] bArr, int i6) {
        if (i6 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        return bArr2;
    }

    public abstract boolean canDecode(CharSequence charSequence);

    abstract int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    abstract void encodeTo(Appendable appendable, byte[] bArr, int i6, int i7) throws IOException;

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int i6);

    abstract int maxEncodedSize(int i6);

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c6);

    public abstract BaseEncoding withSeparator(String str, int i6);

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public final String encode(byte[] bArr, int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
        StringBuilder sb = new StringBuilder(maxEncodedSize(i7));
        try {
            encodeTo(sb, bArr, i6, i7);
            return sb.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    BaseEncoding() {
    }

    @GwtIncompatible
    static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader
            public int read() throws IOException {
                int read;
                do {
                    read = reader.read();
                    if (read == -1) {
                        break;
                    }
                } while (str.indexOf((char) read) >= 0);
                return read;
            }

            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                reader.close();
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i6, int i7) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Appendable separatingAppendable(Appendable appendable, String str, int i6) {
        boolean z5;
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        if (i6 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        return new Appendable(i6, appendable, str) { // from class: com.google.common.io.BaseEncoding.4
            int charsUntilSeparator;
            final /* synthetic */ int val$afterEveryChars;
            final /* synthetic */ Appendable val$delegate;
            final /* synthetic */ String val$separator;

            @Override // java.lang.Appendable
            public Appendable append(char c6) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    this.val$delegate.append(this.val$separator);
                    this.charsUntilSeparator = this.val$afterEveryChars;
                }
                this.val$delegate.append(c6);
                this.charsUntilSeparator--;
                return this;
            }

            {
                this.val$afterEveryChars = i6;
                this.val$delegate = appendable;
                this.val$separator = str;
                this.charsUntilSeparator = i6;
            }

            @Override // java.lang.Appendable
            public Appendable append(@NullableDecl CharSequence charSequence, int i7, int i8) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(@NullableDecl CharSequence charSequence) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    @GwtIncompatible
    static Writer separatingWriter(final Writer writer, String str, int i6) {
        final Appendable separatingAppendable = separatingAppendable(writer, str, i6);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            @Override // java.io.Writer
            public void write(int i7) throws IOException {
                separatingAppendable.append((char) i7);
            }

            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                writer.close();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                writer.flush();
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i7, int i8) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(trimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, trimTrailingPadding));
    }

    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            @Override // com.google.common.io.ByteSink
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }
}
