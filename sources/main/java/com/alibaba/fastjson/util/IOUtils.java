package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import ms.bz.bd.c.Pgl.pblu;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    static final char[] digits;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public static final Properties DEFAULT_PROPERTIES = new Properties();
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (flush.isUnderflow()) {
                return;
            }
            flush.throwException();
        } catch (CharacterCodingException e6) {
            throw new JSONException("utf8 decode error, " + e6.getMessage(), e6);
        }
    }

    public static byte[] decodeBase64(char[] cArr, int i6, int i7) {
        int i8;
        int i9 = 0;
        if (i7 == 0) {
            return new byte[0];
        }
        int i10 = (i6 + i7) - 1;
        int i11 = i6;
        while (i11 < i10 && IA[cArr[i11]] < 0) {
            i11++;
        }
        while (i10 > 0 && IA[cArr[i10]] < 0) {
            i10--;
        }
        int i12 = cArr[i10] == '=' ? cArr[i10 + (-1)] == '=' ? 2 : 1 : 0;
        int i13 = (i10 - i11) + 1;
        if (i7 > 76) {
            i8 = (cArr[76] == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i8 = 0;
        }
        int i14 = (((i13 - i8) * 6) >> 3) - i12;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        loop2: while (true) {
            int i17 = 0;
            while (i16 < i15) {
                int[] iArr = IA;
                int i18 = i11 + 4;
                int i19 = iArr[cArr[i11 + 3]] | (iArr[cArr[i11 + 1]] << 12) | (iArr[cArr[i11]] << 18) | (iArr[cArr[i11 + 2]] << 6);
                bArr[i16] = (byte) (i19 >> 16);
                int i20 = i16 + 2;
                bArr[i16 + 1] = (byte) (i19 >> 8);
                i16 += 3;
                bArr[i20] = (byte) i19;
                if (i8 <= 0 || (i17 = i17 + 1) != 19) {
                    i11 = i18;
                }
            }
            i11 += 6;
        }
        if (i16 < i14) {
            int i21 = 0;
            while (i11 <= i10 - i12) {
                i9 |= IA[cArr[i11]] << (18 - (i21 * 6));
                i21++;
                i11++;
            }
            int i22 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i9 >> i22);
                i22 -= 8;
                i16++;
            }
        }
        return bArr;
    }

    public static void getChars(long j6, int i6, char[] cArr) {
        char c6;
        if (j6 < 0) {
            j6 = -j6;
            c6 = '-';
        } else {
            c6 = 0;
        }
        while (j6 > 2147483647L) {
            long j7 = j6 / 100;
            int i7 = (int) (j6 - (((j7 << 6) + (j7 << 5)) + (j7 << 2)));
            cArr[i6 - 1] = DigitOnes[i7];
            i6 -= 2;
            cArr[i6] = DigitTens[i7];
            j6 = j7;
        }
        int i8 = (int) j6;
        while (i8 >= 65536) {
            int i9 = i8 / 100;
            int i10 = i8 - (((i9 << 6) + (i9 << 5)) + (i9 << 2));
            cArr[i6 - 1] = DigitOnes[i10];
            i6 -= 2;
            cArr[i6] = DigitTens[i10];
            i8 = i9;
        }
        while (true) {
            int i11 = (52429 * i8) >>> 19;
            int i12 = i6 - 1;
            cArr[i12] = digits[i8 - ((i11 << 3) + (i11 << 1))];
            if (i11 == 0) {
                break;
            }
            i8 = i11;
            i6 = i12;
        }
        if (c6 != 0) {
            cArr[i6 - 2] = c6;
        }
    }

    public static int stringSize(long j6) {
        long j7 = 10;
        for (int i6 = 1; i6 < 19; i6++) {
            if (j6 < j7) {
                return i6;
            }
            j7 *= 10;
        }
        return 19;
    }

    static {
        char c6 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c6 >= zArr.length) {
                break;
            }
            if (c6 >= 'A' && c6 <= 'Z') {
                zArr[c6] = true;
            } else if (c6 >= 'a' && c6 <= 'z') {
                zArr[c6] = true;
            } else if (c6 == '_') {
                zArr[c6] = true;
            }
            c6 = (char) (c6 + 1);
        }
        identifierFlags = new boolean[256];
        char c7 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c7 < zArr2.length) {
                if (c7 >= 'A' && c7 <= 'Z') {
                    zArr2[c7] = true;
                } else if (c7 >= 'a' && c7 <= 'z') {
                    zArr2[c7] = true;
                } else if (c7 == '_') {
                    zArr2[c7] = true;
                } else if (c7 >= '0' && c7 <= '9') {
                    zArr2[c7] = true;
                }
                c7 = (char) (c7 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        loadPropertiesFromFile();
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i6 = 14; i6 <= 31; i6++) {
            specicalFlags_doubleQuotes[i6] = 4;
            specicalFlags_singleQuotes[i6] = 4;
        }
        for (int i7 = 127; i7 < 160; i7++) {
            specicalFlags_doubleQuotes[i7] = 4;
            specicalFlags_singleQuotes[i7] = 4;
        }
        for (int i8 = 0; i8 < 161; i8++) {
            specicalFlags_doubleQuotesFlags[i8] = specicalFlags_doubleQuotes[i8] != 0;
            specicalFlags_singleQuotesFlags[i8] = specicalFlags_singleQuotes[i8] != 0;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, AVMDLDataLoader.KeyIsEnableEventInfo, pblu.f50357u, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i9 = 0; i9 < length; i9++) {
            IA[CA[i9]] = i9;
        }
        IA[61] = 0;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static int decodeUTF8(byte[] bArr, int i6, int i7, char[] cArr) {
        int i8 = i6 + i7;
        int min = Math.min(i7, cArr.length);
        int i9 = 0;
        while (i9 < min) {
            byte b6 = bArr[i6];
            if (b6 < 0) {
                break;
            }
            i6++;
            cArr[i9] = (char) b6;
            i9++;
        }
        while (i6 < i8) {
            int i10 = i6 + 1;
            byte b7 = bArr[i6];
            if (b7 >= 0) {
                cArr[i9] = (char) b7;
                i9++;
                i6 = i10;
            } else {
                if ((b7 >> 5) != -2 || (b7 & 30) == 0) {
                    if ((b7 >> 4) == -2) {
                        int i11 = i6 + 2;
                        if (i11 < i8) {
                            byte b8 = bArr[i10];
                            i6 += 3;
                            byte b9 = bArr[i11];
                            if ((b7 != -32 || (b8 & 224) != 128) && (b8 & 192) == 128 && (b9 & 192) == 128) {
                                char c6 = (char) (((b8 << 6) ^ (b7 << 12)) ^ ((-123008) ^ b9));
                                if (c6 >= 55296 && c6 < 57344) {
                                    return -1;
                                }
                                cArr[i9] = c6;
                                i9++;
                            }
                        }
                        return -1;
                    }
                    if ((b7 >> 3) == -2 && i6 + 3 < i8) {
                        byte b10 = bArr[i10];
                        int i12 = i6 + 3;
                        byte b11 = bArr[i6 + 2];
                        i6 += 4;
                        byte b12 = bArr[i12];
                        int i13 = (((b7 << 18) ^ (b10 << 12)) ^ (b11 << 6)) ^ (3678080 ^ b12);
                        if ((b10 & 192) == 128 && (b11 & 192) == 128 && (b12 & 192) == 128 && Character.isSupplementaryCodePoint(i13)) {
                            int i14 = i9 + 1;
                            cArr[i9] = (char) ((i13 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                            i9 += 2;
                            cArr[i14] = (char) ((i13 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        }
                    }
                    return -1;
                }
                if (i10 >= i8) {
                    return -1;
                }
                i6 += 2;
                byte b13 = bArr[i10];
                if ((b13 & 192) != 128) {
                    return -1;
                }
                cArr[i9] = (char) ((b13 ^ (b7 << 6)) ^ Utf8.MASK_2BYTES);
                i9++;
            }
        }
        return i9;
    }

    public static int encodeUTF8(char[] cArr, int i6, int i7, byte[] bArr) {
        int i8;
        int i9;
        char c6;
        int i10 = i6 + i7;
        int min = Math.min(i7, bArr.length);
        int i11 = 0;
        while (i11 < min && (c6 = cArr[i6]) < 128) {
            i6++;
            bArr[i11] = (byte) c6;
            i11++;
        }
        while (i6 < i10) {
            int i12 = i6 + 1;
            char c7 = cArr[i6];
            if (c7 < 128) {
                i9 = i11 + 1;
                bArr[i11] = (byte) c7;
            } else {
                if (c7 < 2048) {
                    int i13 = i11 + 1;
                    bArr[i11] = (byte) ((c7 >> 6) | 192);
                    i11 += 2;
                    bArr[i13] = (byte) ((c7 & '?') | 128);
                } else if (c7 < 55296 || c7 >= 57344) {
                    bArr[i11] = (byte) ((c7 >> '\f') | 224);
                    int i14 = i11 + 2;
                    bArr[i11 + 1] = (byte) ((63 & (c7 >> 6)) | 128);
                    i11 += 3;
                    bArr[i14] = (byte) ((c7 & '?') | 128);
                } else {
                    if (!Character.isHighSurrogate(c7)) {
                        boolean isLowSurrogate = Character.isLowSurrogate(c7);
                        i8 = c7;
                        if (isLowSurrogate) {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                    } else if (i10 - i6 < 2) {
                        i8 = -1;
                    } else {
                        char c8 = cArr[i6 + 1];
                        if (!Character.isLowSurrogate(c8)) {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                        i8 = Character.toCodePoint(c7, c8);
                    }
                    if (i8 < 0) {
                        i9 = i11 + 1;
                        bArr[i11] = Utf8.REPLACEMENT_BYTE;
                    } else {
                        bArr[i11] = (byte) ((i8 >> 18) | 240);
                        bArr[i11 + 1] = (byte) (((i8 >> 12) & 63) | 128);
                        bArr[i11 + 2] = (byte) ((63 & (i8 >> 6)) | 128);
                        bArr[i11 + 3] = (byte) ((i8 & 63) | 128);
                        i12 = i6 + 2;
                        i9 = i11 + 4;
                    }
                }
                i6 = i12;
            }
            i11 = i9;
            i6 = i12;
        }
        return i11;
    }

    public static boolean firstIdentifier(char c6) {
        boolean[] zArr = firstIdentifierFlags;
        return c6 < zArr.length && zArr[c6];
    }

    public static boolean isIdent(char c6) {
        boolean[] zArr = identifierFlags;
        return c6 < zArr.length && zArr[c6];
    }

    public static void loadPropertiesFromFile() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.alibaba.fastjson.util.IOUtils.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                return contextClassLoader != null ? contextClassLoader.getResourceAsStream(IOUtils.FASTJSON_PROPERTIES) : ClassLoader.getSystemResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
            }
        });
        if (inputStream != null) {
            try {
                DEFAULT_PROPERTIES.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e6) {
            throw new JSONException("read string from reader error", e6);
        }
    }

    public static int stringSize(int i6) {
        int i7 = 0;
        while (i6 > sizeTable[i7]) {
            i7++;
        }
        return i7 + 1;
    }

    public static String getStringProperty(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            return DEFAULT_PROPERTIES.getProperty(str);
        }
        return str2;
    }

    public static void getChars(int i6, int i7, char[] cArr) {
        char c6;
        if (i6 < 0) {
            i6 = -i6;
            c6 = '-';
        } else {
            c6 = 0;
        }
        while (i6 >= 65536) {
            int i8 = i6 / 100;
            int i9 = i6 - (((i8 << 6) + (i8 << 5)) + (i8 << 2));
            cArr[i7 - 1] = DigitOnes[i9];
            i7 -= 2;
            cArr[i7] = DigitTens[i9];
            i6 = i8;
        }
        while (true) {
            int i10 = (52429 * i6) >>> 19;
            int i11 = i7 - 1;
            cArr[i11] = digits[i6 - ((i10 << 3) + (i10 << 1))];
            if (i10 == 0) {
                break;
            }
            i6 = i10;
            i7 = i11;
        }
        if (c6 != 0) {
            cArr[i7 - 2] = c6;
        }
    }

    public static byte[] decodeBase64(String str, int i6, int i7) {
        int i8;
        if (i7 == 0) {
            return new byte[0];
        }
        int i9 = (i6 + i7) - 1;
        int i10 = i6;
        while (i10 < i9 && IA[str.charAt(i10)] < 0) {
            i10++;
        }
        while (i9 > 0 && IA[str.charAt(i9)] < 0) {
            i9--;
        }
        int i11 = str.charAt(i9) == '=' ? str.charAt(i9 + (-1)) == '=' ? 2 : 1 : 0;
        int i12 = (i9 - i10) + 1;
        if (i7 > 76) {
            i8 = (str.charAt(76) == '\r' ? i12 / 78 : 0) << 1;
        } else {
            i8 = 0;
        }
        int i13 = (((i12 - i8) * 6) >> 3) - i11;
        byte[] bArr = new byte[i13];
        int i14 = (i13 / 3) * 3;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int[] iArr = IA;
            int i17 = i10 + 4;
            int i18 = iArr[str.charAt(i10 + 3)] | (iArr[str.charAt(i10 + 1)] << 12) | (iArr[str.charAt(i10)] << 18) | (iArr[str.charAt(i10 + 2)] << 6);
            bArr[i15] = (byte) (i18 >> 16);
            int i19 = i15 + 2;
            bArr[i15 + 1] = (byte) (i18 >> 8);
            i15 += 3;
            bArr[i19] = (byte) i18;
            if (i8 <= 0 || (i16 = i16 + 1) != 19) {
                i10 = i17;
            } else {
                i10 += 6;
                i16 = 0;
            }
        }
        if (i15 < i13) {
            int i20 = 0;
            int i21 = 0;
            while (i10 <= i9 - i11) {
                i20 |= IA[str.charAt(i10)] << (18 - (i21 * 6));
                i21++;
                i10++;
            }
            int i22 = 16;
            while (i15 < i13) {
                bArr[i15] = (byte) (i20 >> i22);
                i22 -= 8;
                i15++;
            }
        }
        return bArr;
    }

    public static void getChars(byte b6, int i6, char[] cArr) {
        char c6;
        int i7;
        if (b6 < 0) {
            c6 = '-';
            i7 = -b6;
        } else {
            c6 = 0;
            i7 = b6;
        }
        while (true) {
            int i8 = (52429 * i7) >>> 19;
            int i9 = i6 - 1;
            cArr[i9] = digits[i7 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            }
            i7 = i8;
            i6 = i9;
        }
        if (c6 != 0) {
            cArr[i6 - 2] = c6;
        }
    }

    public static byte[] decodeBase64(String str) {
        int i6;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < i7 && IA[str.charAt(i8) & 255] < 0) {
            i8++;
        }
        while (i7 > 0 && IA[str.charAt(i7) & 255] < 0) {
            i7--;
        }
        int i9 = str.charAt(i7) == '=' ? str.charAt(i7 + (-1)) == '=' ? 2 : 1 : 0;
        int i10 = (i7 - i8) + 1;
        if (length > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i8 + 4;
            int i16 = iArr[str.charAt(i8 + 3)] | (iArr[str.charAt(i8 + 1)] << 12) | (iArr[str.charAt(i8)] << 18) | (iArr[str.charAt(i8 + 2)] << 6);
            bArr[i13] = (byte) (i16 >> 16);
            int i17 = i13 + 2;
            bArr[i13 + 1] = (byte) (i16 >> 8);
            i13 += 3;
            bArr[i17] = (byte) i16;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i8 = i15;
            } else {
                i8 += 6;
                i14 = 0;
            }
        }
        if (i13 < i11) {
            int i18 = 0;
            int i19 = 0;
            while (i8 <= i7 - i9) {
                i18 |= IA[str.charAt(i8)] << (18 - (i19 * 6));
                i19++;
                i8++;
            }
            int i20 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i18 >> i20);
                i20 -= 8;
                i13++;
            }
        }
        return bArr;
    }
}
