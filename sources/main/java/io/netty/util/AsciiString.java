package io.netty.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    public static final int INDEX_NOT_FOUND = -1;
    private static final char MAX_CHAR_VALUE = 255;
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;
    public static final AsciiString EMPTY_STRING = cached("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEquals(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface CharEqualityComparator {
        boolean equals(char c6, char c7);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DefaultCharEqualityComparator implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c6, char c7) {
            return c6 == c7;
        }

        private DefaultCharEqualityComparator() {
        }
    }

    public AsciiString(byte[] bArr) {
        this(bArr, true);
    }

    private static byte c2b0(char c6) {
        return (byte) c6;
    }

    private static boolean equalsIgnoreCase(byte b6, byte b7) {
        return b6 == b7 || toLowerCase(b6) == toLowerCase(b7);
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i6) {
        if (charSequence != null && charSequence2 != null) {
            if (i6 < 0) {
                i6 = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i6 > length2) {
                return -1;
            }
            if (length == 0) {
                return i6;
            }
            int i7 = i6;
            while (i7 < length2) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (regionMatches(charSequence3, true, i7, charSequence4, 0, length)) {
                    return i7;
                }
                i7++;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence charSequence, CharSequence charSequence2, int i6) {
        if (charSequence != null && charSequence2 != null) {
            if (i6 < 0) {
                i6 = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i6 > length2) {
                return -1;
            }
            if (length == 0) {
                return i6;
            }
            int i7 = i6;
            while (i7 < length2) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (regionMatchesAscii(charSequence3, true, i7, charSequence4, 0, length)) {
                    return i7;
                }
                i7++;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return -1;
    }

    public static boolean isUpperCase(byte b6) {
        return b6 >= 65 && b6 <= 90;
    }

    private static boolean regionMatchesCharSequences(CharSequence charSequence, int i6, CharSequence charSequence2, int i7, int i8, CharEqualityComparator charEqualityComparator) {
        if (i6 < 0 || i8 > charSequence.length() - i6 || i7 < 0 || i8 > charSequence2.length() - i7) {
            return false;
        }
        int i9 = i8 + i6;
        while (i6 < i9) {
            int i10 = i6 + 1;
            int i11 = i7 + 1;
            if (!charEqualityComparator.equals(charSequence.charAt(i6), charSequence2.charAt(i7))) {
                return false;
            }
            i6 = i10;
            i7 = i11;
        }
        return true;
    }

    private static AsciiString[] toAsciiStringArray(String[] strArr) {
        AsciiString[] asciiStringArr = new AsciiString[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            asciiStringArr[i6] = new AsciiString(strArr[i6]);
        }
        return asciiStringArr;
    }

    public static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).trim();
        }
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length() - 1;
        int i6 = 0;
        while (i6 <= length && charSequence.charAt(i6) <= ' ') {
            i6++;
        }
        int i7 = length;
        while (i7 >= i6 && charSequence.charAt(i7) <= ' ') {
            i7--;
        }
        return (i6 == 0 && i7 == length) ? charSequence : charSequence.subSequence(i6, i7);
    }

    public void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public boolean contains(CharSequence charSequence) {
        return indexOf(charSequence) >= 0;
    }

    public boolean contentEquals(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            return equals(charSequence);
        }
        int arrayOffset = arrayOffset();
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (b2c(this.value[arrayOffset]) != charSequence.charAt(i6)) {
                return false;
            }
            arrayOffset++;
        }
        return true;
    }

    public boolean contentEqualsIgnoreCase(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (!(charSequence instanceof AsciiString)) {
            int arrayOffset = arrayOffset();
            int i6 = 0;
            while (arrayOffset < length()) {
                if (!equalsIgnoreCase(b2c(this.value[arrayOffset]), charSequence.charAt(i6))) {
                    return false;
                }
                arrayOffset++;
                i6++;
            }
            return true;
        }
        AsciiString asciiString = (AsciiString) charSequence;
        int arrayOffset2 = arrayOffset();
        int arrayOffset3 = asciiString.arrayOffset();
        while (arrayOffset2 < length()) {
            if (!equalsIgnoreCase(this.value[arrayOffset2], asciiString.value[arrayOffset3])) {
                return false;
            }
            arrayOffset2++;
            arrayOffset3++;
        }
        return true;
    }

    public void copy(int i6, byte[] bArr, int i7, int i8) {
        if (!MathUtil.isOutOfBounds(i6, i8, length())) {
            System.arraycopy(this.value, i6 + this.offset, ObjectUtil.checkNotNull(bArr, "dst"), i7, i8);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i6 + ") <= srcIdx + length(" + i8 + ") <= srcLen(" + length() + ')');
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == AsciiString.class) {
            if (this == obj) {
                return true;
            }
            AsciiString asciiString = (AsciiString) obj;
            if (length() == asciiString.length() && hashCode() == asciiString.hashCode() && PlatformDependent.equals(array(), arrayOffset(), asciiString.array(), asciiString.arrayOffset(), length())) {
                return true;
            }
        }
        return false;
    }

    public int forEachByte(ByteProcessor byteProcessor) throws Exception {
        return forEachByte0(0, length(), byteProcessor);
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) throws Exception {
        return forEachByteDesc0(0, length(), byteProcessor);
    }

    public int hashCode() {
        int i6 = this.hash;
        if (i6 != 0) {
            return i6;
        }
        int hashCodeAscii = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
        this.hash = hashCodeAscii;
        return hashCodeAscii;
    }

    public int indexOf(CharSequence charSequence) {
        return indexOf(charSequence, 0);
    }

    public int lastIndexOf(CharSequence charSequence) {
        return lastIndexOf(charSequence, this.length);
    }

    public char parseChar() {
        return parseChar(0);
    }

    public double parseDouble() {
        return parseDouble(0, length());
    }

    public float parseFloat() {
        return parseFloat(0, length());
    }

    public int parseInt() {
        return parseInt(0, length(), 10);
    }

    public long parseLong() {
        return parseLong(0, length(), 10);
    }

    public short parseShort() {
        return parseShort(0, length(), 10);
    }

    public boolean regionMatches(int i6, CharSequence charSequence, int i7, int i8) {
        if (charSequence == null) {
            throw new NullPointerException(ResIdentify.RES_TYPE_STRING);
        }
        if (i7 >= 0 && charSequence.length() - i7 >= i8) {
            int length = length();
            if (i6 >= 0 && length - i6 >= i8) {
                if (i8 <= 0) {
                    return true;
                }
                int i9 = i8 + i7;
                int arrayOffset = i6 + arrayOffset();
                while (i7 < i9) {
                    if (b2c(this.value[arrayOffset]) != charSequence.charAt(i7)) {
                        return false;
                    }
                    i7++;
                    arrayOffset++;
                }
                return true;
            }
        }
        return false;
    }

    public AsciiString[] split(String str, int i6) {
        return toAsciiStringArray(Pattern.compile(str).split(this, i6));
    }

    public boolean startsWith(CharSequence charSequence) {
        return startsWith(charSequence, 0);
    }

    public byte[] toByteArray() {
        return toByteArray(0, length());
    }

    public char[] toCharArray() {
        return toCharArray(0, length());
    }

    public AsciiString toLowerCase() {
        int length = length() + arrayOffset();
        for (int arrayOffset = arrayOffset(); arrayOffset < length; arrayOffset++) {
            byte b6 = this.value[arrayOffset];
            if (b6 >= 65 && b6 <= 90) {
                byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                int arrayOffset2 = arrayOffset();
                int i6 = 0;
                while (i6 < allocateUninitializedArray.length) {
                    allocateUninitializedArray[i6] = toLowerCase(this.value[arrayOffset2]);
                    i6++;
                    arrayOffset2++;
                }
                return new AsciiString(allocateUninitializedArray, false);
            }
        }
        return this;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.string;
        if (str != null) {
            return str;
        }
        String asciiString = toString(0);
        this.string = asciiString;
        return asciiString;
    }

    public AsciiString toUpperCase() {
        int length = length() + arrayOffset();
        for (int arrayOffset = arrayOffset(); arrayOffset < length; arrayOffset++) {
            byte b6 = this.value[arrayOffset];
            if (b6 >= 97 && b6 <= 122) {
                byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                int arrayOffset2 = arrayOffset();
                int i6 = 0;
                while (i6 < allocateUninitializedArray.length) {
                    allocateUninitializedArray[i6] = toUpperCase(this.value[arrayOffset2]);
                    i6++;
                    arrayOffset2++;
                }
                return new AsciiString(allocateUninitializedArray, false);
            }
        }
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c6, char c7) {
            return AsciiString.equalsIgnoreCase(c6, c7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class GeneralCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();

        private GeneralCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c6, char c7) {
            if (Character.toUpperCase(c6) != Character.toUpperCase(c7) && Character.toLowerCase(c6) != Character.toLowerCase(c7)) {
                return false;
            }
            return true;
        }
    }

    public AsciiString(byte[] bArr, boolean z5) {
        this(bArr, 0, bArr.length, z5);
    }

    public static char b2c(byte b6) {
        return (char) (b6 & 255);
    }

    public static byte c2b(char c6) {
        if (c6 > 255) {
            c6 = '?';
        }
        return (byte) c6;
    }

    public static AsciiString cached(String str) {
        AsciiString asciiString = new AsciiString(str);
        asciiString.string = str;
        return asciiString;
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsIgnoreCase(char c6, char c7) {
        return c6 == c7 || toLowerCase(c6) == toLowerCase(c7);
    }

    private int forEachByte0(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        int i8 = this.offset;
        int i9 = i8 + i6 + i7;
        for (int i10 = i8 + i6; i10 < i9; i10++) {
            if (!byteProcessor.process(this.value[i10])) {
                return i10 - this.offset;
            }
        }
        return -1;
    }

    private int forEachByteDesc0(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        int i8 = this.offset;
        int i9 = i8 + i6;
        for (int i10 = ((i8 + i6) + i7) - 1; i10 >= i9; i10--) {
            if (!byteProcessor.process(this.value[i10])) {
                return i10 - this.offset;
            }
        }
        return -1;
    }

    private static boolean isLowerCase(byte b6) {
        return b6 >= 97 && b6 <= 122;
    }

    public static boolean isUpperCase(char c6) {
        return c6 >= 'A' && c6 <= 'Z';
    }

    public static AsciiString of(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? (AsciiString) charSequence : new AsciiString(charSequence);
    }

    public static boolean regionMatchesAscii(CharSequence charSequence, boolean z5, int i6, CharSequence charSequence2, int i7, int i8) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if (!z5 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(false, i6, (String) charSequence2, i7, i8);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z5, i6, charSequence2, i7, i8);
        }
        return regionMatchesCharSequences(charSequence, i6, charSequence2, i7, i8, z5 ? AsciiCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public byte[] array() {
        return this.value;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public byte byteAt(int i6) {
        if (i6 >= 0 && i6 < this.length) {
            return PlatformDependent.hasUnsafe() ? PlatformDependent.getByte(this.value, i6 + this.offset) : this.value[i6 + this.offset];
        }
        throw new IndexOutOfBoundsException("index: " + i6 + " must be in the range [0," + this.length + ")");
    }

    @Override // java.lang.Comparable
    public int compareTo(CharSequence charSequence) {
        int i6 = 0;
        if (this == charSequence) {
            return 0;
        }
        int length = length();
        int length2 = charSequence.length();
        int min = Math.min(length, length2);
        int arrayOffset = arrayOffset();
        while (i6 < min) {
            int b2c = b2c(this.value[arrayOffset]) - charSequence.charAt(i6);
            if (b2c != 0) {
                return b2c;
            }
            i6++;
            arrayOffset++;
        }
        return length - length2;
    }

    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        if (!MathUtil.isOutOfBounds(i6, i7, length())) {
            return forEachByte0(i6, i7, byteProcessor);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= index(" + i6 + ") <= start + length(" + i7 + ") <= length(" + length() + ')');
    }

    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        if (!MathUtil.isOutOfBounds(i6, i7, length())) {
            return forEachByteDesc0(i6, i7, byteProcessor);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= index(" + i6 + ") <= start + length(" + i7 + ") <= length(" + length() + ')');
    }

    public int indexOf(CharSequence charSequence, int i6) {
        char charAt;
        int length = charSequence.length();
        if (i6 < 0) {
            i6 = 0;
        }
        if (length <= 0) {
            int i7 = this.length;
            return i6 < i7 ? i6 : i7;
        }
        if (length > this.length - i6 || (charAt = charSequence.charAt(0)) > 255) {
            return -1;
        }
        byte c2b0 = c2b0(charAt);
        int i8 = this.offset;
        int i9 = (this.length + i8) - length;
        for (int i10 = i6 + i8; i10 <= i9; i10++) {
            if (this.value[i10] == c2b0) {
                int i11 = i10;
                int i12 = 0;
                do {
                    i12++;
                    if (i12 >= length) {
                        break;
                    }
                    i11++;
                } while (b2c(this.value[i11]) == charSequence.charAt(i12));
                if (i12 == length) {
                    return i10 - this.offset;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    public int lastIndexOf(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int min = Math.min(i6, this.length - length);
        if (min < 0) {
            return -1;
        }
        if (length == 0) {
            return min;
        }
        char charAt = charSequence.charAt(0);
        if (charAt > 255) {
            return -1;
        }
        byte c2b0 = c2b0(charAt);
        for (int i7 = this.offset + min; i7 >= 0; i7--) {
            if (this.value[i7] == c2b0) {
                int i8 = i7;
                int i9 = 0;
                do {
                    i9++;
                    if (i9 >= length) {
                        break;
                    }
                    i8++;
                } while (b2c(this.value[i8]) == charSequence.charAt(i9));
                if (i9 == length) {
                    return i7 - this.offset;
                }
            }
        }
        return -1;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    public boolean parseBoolean() {
        return this.length >= 1 && this.value[this.offset] != 0;
    }

    public char parseChar(int i6) {
        if (i6 + 1 < length()) {
            int i7 = i6 + this.offset;
            return (char) (b2c(this.value[i7 + 1]) | (b2c(this.value[i7]) << '\b'));
        }
        throw new IndexOutOfBoundsException("2 bytes required to convert to character. index " + i6 + " would go out of bounds.");
    }

    public double parseDouble(int i6, int i7) {
        return Double.parseDouble(toString(i6, i7));
    }

    public float parseFloat(int i6, int i7) {
        return Float.parseFloat(toString(i6, i7));
    }

    public int parseInt(int i6) {
        return parseInt(0, length(), i6);
    }

    public long parseLong(int i6) {
        return parseLong(0, length(), i6);
    }

    public short parseShort(int i6) {
        return parseShort(0, length(), i6);
    }

    public AsciiString replace(char c6, char c7) {
        if (c6 <= 255) {
            byte c2b0 = c2b0(c6);
            byte c2b = c2b(c7);
            int i6 = this.offset;
            int i7 = this.length + i6;
            while (i6 < i7) {
                if (this.value[i6] == c2b0) {
                    byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                    byte[] bArr = this.value;
                    int i8 = this.offset;
                    System.arraycopy(bArr, i8, allocateUninitializedArray, 0, i6 - i8);
                    allocateUninitializedArray[i6 - this.offset] = c2b;
                    while (true) {
                        i6++;
                        if (i6 >= i7) {
                            return new AsciiString(allocateUninitializedArray, false);
                        }
                        byte b6 = this.value[i6];
                        int i9 = i6 - this.offset;
                        if (b6 == c2b0) {
                            b6 = c2b;
                        }
                        allocateUninitializedArray[i9] = b6;
                    }
                } else {
                    i6++;
                }
            }
        }
        return this;
    }

    public AsciiString[] split(char c6) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList();
        int length = length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (charAt(i7) == c6) {
                if (i6 == i7) {
                    arrayList.add(EMPTY_STRING);
                } else {
                    arrayList.add(new AsciiString(this.value, arrayOffset() + i6, i7 - i6, false));
                }
                i6 = i7 + 1;
            }
        }
        if (i6 == 0) {
            arrayList.add(this);
        } else if (i6 != length) {
            arrayList.add(new AsciiString(this.value, arrayOffset() + i6, length - i6, false));
        } else {
            for (int size = arrayList.size() - 1; size >= 0 && ((AsciiString) arrayList.get(size)).isEmpty(); size--) {
                arrayList.remove(size);
            }
        }
        return (AsciiString[]) arrayList.toArray(new AsciiString[0]);
    }

    public boolean startsWith(CharSequence charSequence, int i6) {
        return regionMatches(i6, charSequence, 0, charSequence.length());
    }

    public AsciiString subSequence(int i6) {
        return subSequence(i6, length());
    }

    public byte[] toByteArray(int i6, int i7) {
        byte[] bArr = this.value;
        int i8 = this.offset;
        return Arrays.copyOfRange(bArr, i6 + i8, i7 + i8);
    }

    public char[] toCharArray(int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if (!MathUtil.isOutOfBounds(i6, i8, length())) {
            char[] cArr = new char[i8];
            int arrayOffset = i6 + arrayOffset();
            int i9 = 0;
            while (i9 < i8) {
                cArr[i9] = b2c(this.value[arrayOffset]);
                i9++;
                arrayOffset++;
            }
            return cArr;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= srcIdx + length(" + i8 + ") <= srcLen(" + length() + ')');
    }

    public AsciiString(byte[] bArr, int i6, int i7, boolean z5) {
        if (z5) {
            this.value = Arrays.copyOfRange(bArr, i6, i6 + i7);
            this.offset = 0;
        } else if (!MathUtil.isOutOfBounds(i6, i7, bArr.length)) {
            this.value = bArr;
            this.offset = i6;
        } else {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= start + length(" + i7 + ") <= value.length(" + bArr.length + ')');
        }
        this.length = i7;
    }

    private static boolean contains(CharSequence charSequence, CharSequence charSequence2, CharEqualityComparator charEqualityComparator) {
        if (charSequence != null && charSequence2 != null && charSequence.length() >= charSequence2.length()) {
            if (charSequence2.length() == 0) {
                return true;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < charSequence.length(); i7++) {
                if (charEqualityComparator.equals(charSequence2.charAt(i6), charSequence.charAt(i7))) {
                    i6++;
                    if (i6 == charSequence2.length()) {
                        return true;
                    }
                } else {
                    if (charSequence.length() - i7 < charSequence2.length()) {
                        return false;
                    }
                    i6 = 0;
                }
            }
        }
        return false;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> collection, Collection<CharSequence> collection2) {
        Iterator<CharSequence> it = collection2.iterator();
        while (it.hasNext()) {
            if (!containsContentEqualsIgnoreCase(collection, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> collection, CharSequence charSequence) {
        Iterator<CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            if (contentEqualsIgnoreCase(charSequence, it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i6) {
        return b2c(byteAt(i6));
    }

    public AsciiString concat(CharSequence charSequence) {
        int length = length();
        int length2 = charSequence.length();
        if (length2 == 0) {
            return this;
        }
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            if (isEmpty()) {
                return asciiString;
            }
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length + length2);
            System.arraycopy(this.value, arrayOffset(), allocateUninitializedArray, 0, length);
            System.arraycopy(asciiString.value, asciiString.arrayOffset(), allocateUninitializedArray, length, length2);
            return new AsciiString(allocateUninitializedArray, false);
        }
        if (isEmpty()) {
            return new AsciiString(charSequence);
        }
        byte[] allocateUninitializedArray2 = PlatformDependent.allocateUninitializedArray(length2 + length);
        System.arraycopy(this.value, arrayOffset(), allocateUninitializedArray2, 0, length);
        int i6 = 0;
        while (length < allocateUninitializedArray2.length) {
            allocateUninitializedArray2[length] = c2b(charSequence.charAt(i6));
            length++;
            i6++;
        }
        return new AsciiString(allocateUninitializedArray2, false);
    }

    public boolean endsWith(CharSequence charSequence) {
        int length = charSequence.length();
        return regionMatches(length() - length, charSequence, 0, length);
    }

    public boolean matches(String str) {
        return Pattern.matches(str, this);
    }

    public int parseInt(int i6, int i7) {
        return parseInt(i6, i7, 10);
    }

    public long parseLong(int i6, int i7) {
        return parseLong(i6, i7, 10);
    }

    public short parseShort(int i6, int i7) {
        return parseShort(i6, i7, 10);
    }

    @Override // java.lang.CharSequence
    public AsciiString subSequence(int i6, int i7) {
        return subSequence(i6, i7, true);
    }

    public static int hashCode(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        if (charSequence instanceof AsciiString) {
            return charSequence.hashCode();
        }
        return PlatformDependent.hashCodeAscii(charSequence);
    }

    public int parseInt(int i6, int i7, int i8) {
        if (i8 < 2 || i8 > 36) {
            throw new NumberFormatException();
        }
        if (i6 != i7) {
            boolean z5 = byteAt(i6) == 45;
            if (z5) {
                int i9 = i6 + 1;
                if (i9 == i7) {
                    throw new NumberFormatException(subSequence(i6, i7, false).toString());
                }
                i6 = i9;
            }
            return parseInt(i6, i7, i8, z5);
        }
        throw new NumberFormatException();
    }

    public long parseLong(int i6, int i7, int i8) {
        if (i8 < 2 || i8 > 36) {
            throw new NumberFormatException();
        }
        if (i6 != i7) {
            boolean z5 = byteAt(i6) == 45;
            if (z5) {
                int i9 = i6 + 1;
                if (i9 == i7) {
                    throw new NumberFormatException(subSequence(i6, i7, false).toString());
                }
                i6 = i9;
            }
            return parseLong(i6, i7, i8, z5);
        }
        throw new NumberFormatException();
    }

    public short parseShort(int i6, int i7, int i8) {
        int parseInt = parseInt(i6, i7, i8);
        short s5 = (short) parseInt;
        if (s5 == parseInt) {
            return s5;
        }
        throw new NumberFormatException(subSequence(i6, i7, false).toString());
    }

    public AsciiString subSequence(int i6, int i7, boolean z5) {
        int i8 = i7 - i6;
        if (!MathUtil.isOutOfBounds(i6, i8, length())) {
            if (i6 == 0 && i7 == length()) {
                return this;
            }
            if (i7 == i6) {
                return EMPTY_STRING;
            }
            return new AsciiString(this.value, i6 + this.offset, i8, z5);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= end (" + i7 + ") <= length(" + length() + ')');
    }

    public String toString(int i6) {
        return toString(i6, length());
    }

    public void copy(int i6, char[] cArr, int i7, int i8) {
        if (cArr != null) {
            if (!MathUtil.isOutOfBounds(i6, i8, length())) {
                int i9 = i8 + i7;
                int arrayOffset = i6 + arrayOffset();
                while (i7 < i9) {
                    cArr[i7] = b2c(this.value[arrayOffset]);
                    i7++;
                    arrayOffset++;
                }
                return;
            }
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i6 + ") <= srcIdx + length(" + i8 + ") <= srcLen(" + length() + ')');
        }
        throw new NullPointerException("dst");
    }

    public String toString(int i6, int i7) {
        int i8 = i7 - i6;
        if (i8 == 0) {
            return "";
        }
        if (!MathUtil.isOutOfBounds(i6, i8, length())) {
            return new String(this.value, 0, i6 + this.offset, i8);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= srcIdx + length(" + i8 + ") <= srcLen(" + length() + ')');
    }

    public static boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEquals(charSequence2);
        }
        if (charSequence2 instanceof AsciiString) {
            return ((AsciiString) charSequence2).contentEquals(charSequence);
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (charSequence.charAt(i6) != charSequence2.charAt(i6)) {
                return false;
            }
        }
        return true;
    }

    public boolean regionMatches(boolean z5, int i6, CharSequence charSequence, int i7, int i8) {
        if (!z5) {
            return regionMatches(i6, charSequence, i7, i8);
        }
        if (charSequence != null) {
            int length = length();
            if (i6 < 0 || i8 > length - i6 || i7 < 0 || i8 > charSequence.length() - i7) {
                return false;
            }
            int arrayOffset = i6 + arrayOffset();
            int i9 = i8 + arrayOffset;
            while (arrayOffset < i9) {
                int i10 = arrayOffset + 1;
                char b2c = b2c(this.value[arrayOffset]);
                int i11 = i7 + 1;
                if (!equalsIgnoreCase(b2c, charSequence.charAt(i7))) {
                    return false;
                }
                i7 = i11;
                arrayOffset = i10;
            }
            return true;
        }
        throw new NullPointerException(ResIdentify.RES_TYPE_STRING);
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEqualsIgnoreCase(charSequence2);
        }
        if (charSequence2 instanceof AsciiString) {
            return ((AsciiString) charSequence2).contentEqualsIgnoreCase(charSequence);
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (!equalsIgnoreCase(charSequence.charAt(i6), charSequence2.charAt(i6))) {
                return false;
            }
        }
        return true;
    }

    private static byte toLowerCase(byte b6) {
        return isUpperCase(b6) ? (byte) (b6 + 32) : b6;
    }

    private static byte toUpperCase(byte b6) {
        return isLowerCase(b6) ? (byte) (b6 - 32) : b6;
    }

    private int parseInt(int i6, int i7, int i8, boolean z5) {
        int i9 = Integer.MIN_VALUE / i8;
        int i10 = i6;
        int i11 = 0;
        while (i10 < i7) {
            int i12 = i10 + 1;
            int digit = Character.digit((char) (this.value[i10 + this.offset] & 255), i8);
            if (digit == -1) {
                throw new NumberFormatException(subSequence(i6, i7, false).toString());
            }
            if (i9 > i11) {
                throw new NumberFormatException(subSequence(i6, i7, false).toString());
            }
            int i13 = (i11 * i8) - digit;
            if (i13 > i11) {
                throw new NumberFormatException(subSequence(i6, i7, false).toString());
            }
            i11 = i13;
            i10 = i12;
        }
        if (z5) {
            return i11;
        }
        int i14 = -i11;
        if (i14 >= 0) {
            return i14;
        }
        throw new NumberFormatException(subSequence(i6, i7, false).toString());
    }

    private long parseLong(int i6, int i7, int i8, boolean z5) {
        long j6 = i8;
        long j7 = Long.MIN_VALUE / j6;
        int i9 = i6;
        long j8 = 0;
        while (i9 < i7) {
            int i10 = i9 + 1;
            int digit = Character.digit((char) (this.value[i9 + this.offset] & 255), i8);
            if (digit == -1) {
                throw new NumberFormatException(subSequence(i6, i7, false).toString());
            }
            if (j7 > j8) {
                throw new NumberFormatException(subSequence(i6, i7, false).toString());
            }
            long j9 = (j8 * j6) - digit;
            if (j9 > j8) {
                throw new NumberFormatException(subSequence(i6, i7, false).toString());
            }
            j8 = j9;
            i9 = i10;
        }
        if (z5) {
            return j8;
        }
        long j10 = -j8;
        if (j10 >= 0) {
            return j10;
        }
        throw new NumberFormatException(subSequence(i6, i7, false).toString());
    }

    public static char toLowerCase(char c6) {
        return isUpperCase(c6) ? (char) (c6 + ' ') : c6;
    }

    public AsciiString trim() {
        int arrayOffset = arrayOffset();
        int arrayOffset2 = (arrayOffset() + length()) - 1;
        while (arrayOffset <= arrayOffset2 && this.value[arrayOffset] <= 32) {
            arrayOffset++;
        }
        int i6 = arrayOffset2;
        while (i6 >= arrayOffset && this.value[i6] <= 32) {
            i6--;
        }
        return (arrayOffset == 0 && i6 == arrayOffset2) ? this : new AsciiString(this.value, arrayOffset, (i6 - arrayOffset) + 1, false);
    }

    public AsciiString(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    public int indexOf(char c6, int i6) {
        if (c6 > 255) {
            return -1;
        }
        if (i6 < 0) {
            i6 = 0;
        }
        byte c2b0 = c2b0(c6);
        int i7 = this.offset;
        int i8 = this.length + i7;
        for (int i9 = i6 + i7; i9 < i8; i9++) {
            if (this.value[i9] == c2b0) {
                return i9 - this.offset;
            }
        }
        return -1;
    }

    public AsciiString(ByteBuffer byteBuffer, boolean z5) {
        this(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), z5);
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z5, int i6, CharSequence charSequence2, int i7, int i8) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z5, i6, (String) charSequence2, i7, i8);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z5, i6, charSequence2, i7, i8);
        }
        return regionMatchesCharSequences(charSequence, i6, charSequence2, i7, i8, z5 ? GeneralCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public AsciiString(ByteBuffer byteBuffer, int i6, int i7, boolean z5) {
        if (!MathUtil.isOutOfBounds(i6, i7, byteBuffer.capacity())) {
            if (!byteBuffer.hasArray()) {
                byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i7);
                this.value = allocateUninitializedArray;
                int position = byteBuffer.position();
                byteBuffer.get(allocateUninitializedArray, 0, i7);
                byteBuffer.position(position);
                this.offset = 0;
            } else if (z5) {
                int arrayOffset = byteBuffer.arrayOffset() + i6;
                this.value = Arrays.copyOfRange(byteBuffer.array(), arrayOffset, arrayOffset + i7);
                this.offset = 0;
            } else {
                this.value = byteBuffer.array();
                this.offset = i6;
            }
            this.length = i7;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= start + length(" + i7 + ") <= value.capacity(" + byteBuffer.capacity() + ')');
    }

    public static int indexOf(CharSequence charSequence, char c6, int i6) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c6, i6);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).indexOf(c6, i6);
        }
        if (charSequence == null) {
            return -1;
        }
        int length = charSequence.length();
        if (i6 < 0) {
            i6 = 0;
        }
        while (i6 < length) {
            if (charSequence.charAt(i6) == c6) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public AsciiString(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public AsciiString(char[] cArr, int i6, int i7) {
        if (!MathUtil.isOutOfBounds(i6, i7, cArr.length)) {
            this.value = PlatformDependent.allocateUninitializedArray(i7);
            int i8 = 0;
            while (i8 < i7) {
                this.value[i8] = c2b(cArr[i6]);
                i8++;
                i6++;
            }
            this.offset = 0;
            this.length = i7;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= start + length(" + i7 + ") <= value.length(" + cArr.length + ')');
    }

    public AsciiString(char[] cArr, Charset charset) {
        this(cArr, charset, 0, cArr.length);
    }

    public AsciiString(char[] cArr, Charset charset, int i6, int i7) {
        CharBuffer wrap = CharBuffer.wrap(cArr, i6, i7);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer allocate = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * i7));
        encoder.encode(wrap, allocate, true);
        int arrayOffset = allocate.arrayOffset();
        byte[] copyOfRange = Arrays.copyOfRange(allocate.array(), arrayOffset, allocate.position() + arrayOffset);
        this.value = copyOfRange;
        this.offset = 0;
        this.length = copyOfRange.length;
    }

    public AsciiString(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, int i6, int i7) {
        if (!MathUtil.isOutOfBounds(i6, i7, charSequence.length())) {
            this.value = PlatformDependent.allocateUninitializedArray(i7);
            int i8 = 0;
            while (i8 < i7) {
                this.value[i8] = c2b(charSequence.charAt(i6));
                i8++;
                i6++;
            }
            this.offset = 0;
            this.length = i7;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i6 + ") <= start + length(" + i7 + ") <= value.length(" + charSequence.length() + ')');
    }

    public AsciiString(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, Charset charset, int i6, int i7) {
        CharBuffer wrap = CharBuffer.wrap(charSequence, i6, i6 + i7);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer allocate = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * i7));
        encoder.encode(wrap, allocate, true);
        int arrayOffset = allocate.arrayOffset();
        byte[] copyOfRange = Arrays.copyOfRange(allocate.array(), arrayOffset, allocate.position() + arrayOffset);
        this.value = copyOfRange;
        this.offset = 0;
        this.length = copyOfRange.length;
    }
}
