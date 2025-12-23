package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class SerializeWriter extends Writer {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeautres = ((((((((SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserSecure.mask) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask;
    protected boolean beanToArray;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        return toBytes((str == null || "UTF-8".equals(str)) ? UTF8 : Charset.forName(str));
    }

    @Override // java.io.Writer
    public void write(int i6) {
        int i7 = 1;
        int i8 = this.count + 1;
        if (i8 > this.buf.length) {
            if (this.writer != null) {
                flush();
                this.buf[this.count] = (char) i6;
                this.count = i7;
            }
            expandCapacity(i8);
        }
        i7 = i8;
        this.buf[this.count] = (char) i6;
        this.count = i7;
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldValue(char c6, String str, char c7) {
        write(c6);
        writeFieldName(str);
        if (c7 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c7));
        }
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c6) {
        if (!this.useSingleQuotes) {
            writeStringWithDoubleQuote(str, c6);
        } else {
            writeStringWithSingleQuote(str);
            write(c6);
        }
    }

    protected void writeStringWithSingleQuote(String str) {
        int i6 = 0;
        if (str == null) {
            int i7 = this.count + 4;
            if (i7 > this.buf.length) {
                expandCapacity(i7);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i7;
            return;
        }
        int length = str.length();
        int i8 = this.count + length + 2;
        if (i8 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i6 < str.length()) {
                    char charAt = str.charAt(i6);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
                    } else {
                        write(charAt);
                    }
                    i6++;
                }
                write(39);
                return;
            }
            expandCapacity(i8);
        }
        int i9 = this.count;
        int i10 = i9 + 1;
        int i11 = i10 + length;
        char[] cArr = this.buf;
        cArr[i9] = '\'';
        str.getChars(0, length, cArr, i10);
        this.count = i8;
        char c6 = 0;
        int i12 = -1;
        for (int i13 = i10; i13 < i11; i13++) {
            char c7 = this.buf[i13];
            if (c7 <= '\r' || c7 == '\\' || c7 == '\'' || (c7 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i6++;
                i12 = i13;
                c6 = c7;
            }
        }
        int i14 = i8 + i6;
        if (i14 > this.buf.length) {
            expandCapacity(i14);
        }
        this.count = i14;
        if (i6 == 1) {
            char[] cArr2 = this.buf;
            int i15 = i12 + 1;
            System.arraycopy(cArr2, i15, cArr2, i12 + 2, (i11 - i12) - 1);
            char[] cArr3 = this.buf;
            cArr3[i12] = '\\';
            cArr3[i15] = IOUtils.replaceChars[c6];
        } else if (i6 > 1) {
            char[] cArr4 = this.buf;
            int i16 = i12 + 1;
            System.arraycopy(cArr4, i16, cArr4, i12 + 2, (i11 - i12) - 1);
            char[] cArr5 = this.buf;
            cArr5[i12] = '\\';
            cArr5[i16] = IOUtils.replaceChars[c6];
            int i17 = i11 + 1;
            for (int i18 = i12 - 1; i18 >= i10; i18--) {
                char c8 = this.buf[i18];
                if (c8 <= '\r' || c8 == '\\' || c8 == '\'' || (c8 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i19 = i18 + 1;
                    System.arraycopy(cArr6, i19, cArr6, i18 + 2, (i17 - i18) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i18] = '\\';
                    cArr7[i19] = IOUtils.replaceChars[c8];
                    i17++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i6 = (int) (this.count * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i6) {
            bArr = new byte[i6];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i6 = (int) (this.count * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i6) {
            bArr = new byte[i6];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[encodeUTF8];
        System.arraycopy(bArr, 0, bArr2, 0, encodeUTF8);
        return bArr2;
    }

    static boolean isSpecial(char c6, int i6) {
        if (c6 == ' ') {
            return false;
        }
        if (c6 == '/') {
            return (SerializerFeature.WriteSlashAsSpecial.mask & i6) != 0;
        }
        if (c6 <= '#' || c6 == '\\') {
            return c6 <= 31 || c6 == '\\' || c6 == '\"';
        }
        return false;
    }

    private void writeEnumFieldValue(char c6, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c6, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c6, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        int i6 = 1;
        int i7 = this.count + length + 1;
        if (i7 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        i6 = 0;
                        break;
                    }
                    char charAt = str.charAt(i8);
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i6 != 0) {
                    write(39);
                }
                for (int i9 = 0; i9 < length; i9++) {
                    char charAt2 = str.charAt(i9);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[charAt2]);
                    }
                }
                if (i6 != 0) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i7);
        }
        if (length == 0) {
            int i10 = this.count;
            if (i10 + 3 > this.buf.length) {
                expandCapacity(i10 + 3);
            }
            char[] cArr = this.buf;
            int i11 = this.count;
            int i12 = i11 + 1;
            this.count = i12;
            cArr[i11] = '\'';
            int i13 = i11 + 2;
            this.count = i13;
            cArr[i12] = '\'';
            this.count = i11 + 3;
            cArr[i13] = ':';
            return;
        }
        int i14 = this.count;
        int i15 = i14 + length;
        str.getChars(0, length, this.buf, i14);
        this.count = i7;
        int i16 = i14;
        boolean z5 = false;
        while (i16 < i15) {
            char[] cArr2 = this.buf;
            char c6 = cArr2[i16];
            if (c6 < bArr.length && bArr[c6] != 0) {
                if (z5) {
                    i7++;
                    if (i7 > cArr2.length) {
                        expandCapacity(i7);
                    }
                    this.count = i7;
                    char[] cArr3 = this.buf;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr3, i17, cArr3, i16 + 2, i15 - i16);
                    char[] cArr4 = this.buf;
                    cArr4[i16] = '\\';
                    cArr4[i17] = IOUtils.replaceChars[c6];
                    i15++;
                    i16 = i17;
                    i16++;
                    i6 = 1;
                } else {
                    i7 += 3;
                    if (i7 > cArr2.length) {
                        expandCapacity(i7);
                    }
                    this.count = i7;
                    char[] cArr5 = this.buf;
                    int i18 = i16 + 1;
                    System.arraycopy(cArr5, i18, cArr5, i16 + 3, (i15 - i16) - i6);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, i6, i16);
                    char[] cArr7 = this.buf;
                    cArr7[i14] = '\'';
                    cArr7[i18] = '\\';
                    i16 += 2;
                    cArr7[i16] = IOUtils.replaceChars[c6];
                    i15 += 2;
                    cArr7[this.count - 2] = '\'';
                    z5 = true;
                }
            }
            i16++;
            i6 = 1;
        }
        this.buf[i7 - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    protected void computeFeatures() {
        int i6 = this.features;
        boolean z5 = false;
        boolean z6 = (SerializerFeature.QuoteFieldNames.mask & i6) != 0;
        this.quoteFieldNames = z6;
        boolean z7 = (SerializerFeature.UseSingleQuotes.mask & i6) != 0;
        this.useSingleQuotes = z7;
        this.sortField = (SerializerFeature.SortField.mask & i6) != 0;
        this.disableCircularReferenceDetect = (SerializerFeature.DisableCircularReferenceDetect.mask & i6) != 0;
        boolean z8 = (SerializerFeature.BeanToArray.mask & i6) != 0;
        this.beanToArray = z8;
        this.writeNonStringValueAsString = (SerializerFeature.WriteNonStringValueAsString.mask & i6) != 0;
        this.notWriteDefaultValue = (SerializerFeature.NotWriteDefaultValue.mask & i6) != 0;
        boolean z9 = (SerializerFeature.WriteEnumUsingName.mask & i6) != 0;
        this.writeEnumUsingName = z9;
        this.writeEnumUsingToString = (SerializerFeature.WriteEnumUsingToString.mask & i6) != 0;
        if (z6 && (i6 & nonDirectFeautres) == 0 && (z8 || z9)) {
            z5 = true;
        }
        this.writeDirect = z5;
        this.keySeperator = z7 ? '\'' : '\"';
    }

    public void config(SerializerFeature serializerFeature, boolean z5) {
        if (z5) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i6) {
        int i7 = this.maxBufSize;
        if (i7 != -1 && i6 >= i7) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i6);
        }
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i6) {
            i6 = length;
        }
        char[] cArr2 = new char[i6];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e6) {
            throw new JSONException(e6.getMessage(), e6);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(int i6) {
        return (i6 & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void setMaxBufSize(int i6) {
        if (i6 >= this.buf.length) {
            this.maxBufSize = i6;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int size() {
        return this.count;
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i6 = this.count;
        char[] cArr = new char[i6];
        System.arraycopy(this.buf, 0, cArr, 0, i6);
        return cArr;
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i6 = this.count;
        char[] cArr = new char[i6 - 2];
        System.arraycopy(this.buf, 1, cArr, 0, i6 - 2);
        return cArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        boolean z5 = this.useSingleQuotes;
        char c6 = z5 ? '\'' : '\"';
        if (length == 0) {
            write(z5 ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i6 = (length / 3) * 3;
        int i7 = length - 1;
        int i8 = this.count;
        int i9 = (((i7 / 3) + 1) << 2) + i8;
        int i10 = i9 + 2;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                write(c6);
                int i11 = 0;
                while (i11 < i6) {
                    int i12 = i11 + 2;
                    int i13 = ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11] & 255) << 16);
                    i11 += 3;
                    int i14 = i13 | (bArr[i12] & 255);
                    write(cArr[(i14 >>> 18) & 63]);
                    write(cArr[(i14 >>> 12) & 63]);
                    write(cArr[(i14 >>> 6) & 63]);
                    write(cArr[i14 & 63]);
                }
                int i15 = length - i6;
                if (i15 > 0) {
                    int i16 = ((bArr[i6] & 255) << 10) | (i15 == 2 ? (bArr[i7] & 255) << 2 : 0);
                    write(cArr[i16 >> 12]);
                    write(cArr[(i16 >>> 6) & 63]);
                    write(i15 == 2 ? cArr[i16 & 63] : '=');
                    write(61);
                }
                write(c6);
                return;
            }
            expandCapacity(i10);
        }
        this.count = i10;
        int i17 = i8 + 1;
        this.buf[i8] = c6;
        int i18 = 0;
        while (i18 < i6) {
            int i19 = i18 + 2;
            int i20 = ((bArr[i18 + 1] & 255) << 8) | ((bArr[i18] & 255) << 16);
            i18 += 3;
            int i21 = i20 | (bArr[i19] & 255);
            char[] cArr2 = this.buf;
            cArr2[i17] = cArr[(i21 >>> 18) & 63];
            cArr2[i17 + 1] = cArr[(i21 >>> 12) & 63];
            int i22 = i17 + 3;
            cArr2[i17 + 2] = cArr[(i21 >>> 6) & 63];
            i17 += 4;
            cArr2[i22] = cArr[i21 & 63];
        }
        int i23 = length - i6;
        if (i23 > 0) {
            int i24 = ((bArr[i6] & 255) << 10) | (i23 == 2 ? (bArr[i7] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i9 - 3] = cArr[i24 >> 12];
            cArr3[i9 - 2] = cArr[(i24 >>> 6) & 63];
            cArr3[i9 - 1] = i23 == 2 ? cArr[i24 & 63] : '=';
            cArr3[i9] = '=';
        }
        this.buf[i9 + 1] = c6;
    }

    public void writeEnum(Enum<?> r22) {
        if (r22 == null) {
            writeNull();
            return;
        }
        String str = (!this.writeEnumUsingName || this.writeEnumUsingToString) ? this.writeEnumUsingToString ? r22.toString() : null : r22.name();
        if (str == null) {
            writeInt(r22.ordinal());
            return;
        }
        int i6 = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i6);
        write(str);
        write(i6);
    }

    public void writeFieldName(String str, boolean z5) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.useSingleQuotes) {
            if (!this.quoteFieldNames) {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            } else {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
        }
        if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
            return;
        }
        boolean z6 = true;
        boolean z7 = str.length() == 0;
        int i6 = 0;
        while (true) {
            if (i6 >= str.length()) {
                z6 = z7;
                break;
            } else if (isSpecial(str.charAt(i6), 0)) {
                break;
            } else {
                i6++;
            }
        }
        if (z6) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            write(str);
            write(58);
        }
    }

    public void writeFieldValueStringWithDoubleQuoteCheck(char c6, String str, String str2) {
        int length;
        int i6;
        int length2 = str.length();
        int i7 = this.count;
        if (str2 == null) {
            i6 = i7 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i6 = i7 + length2 + length + 6;
        }
        int i8 = 0;
        if (i6 > this.buf.length) {
            if (this.writer != null) {
                write(c6);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i6);
        }
        char[] cArr = this.buf;
        int i9 = this.count;
        cArr[i9] = c6;
        int i10 = i9 + 2;
        int i11 = i10 + length2;
        cArr[i9 + 1] = '\"';
        str.getChars(0, length2, cArr, i10);
        this.count = i6;
        char[] cArr2 = this.buf;
        cArr2[i11] = '\"';
        int i12 = i11 + 2;
        cArr2[i11 + 1] = ':';
        if (str2 == null) {
            cArr2[i12] = 'n';
            cArr2[i11 + 3] = 'u';
            cArr2[i11 + 4] = 'l';
            cArr2[i11 + 5] = 'l';
            return;
        }
        int i13 = i11 + 3;
        cArr2[i12] = '\"';
        int i14 = i13 + length;
        str2.getChars(0, length, cArr2, i13);
        char c7 = 0;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = i13; i17 < i14; i17++) {
            char c8 = this.buf[i17];
            if (c8 >= ']') {
                if (c8 >= 127 && (c8 == 8232 || c8 == 8233 || c8 < 160)) {
                    if (i15 == -1) {
                        i15 = i17;
                    }
                    i8++;
                    i6 += 4;
                    i16 = i17;
                }
            } else if (isSpecial(c8, this.features)) {
                i8++;
                byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                if (c8 < bArr.length && bArr[c8] == 4) {
                    i6 += 4;
                }
                if (i15 == -1) {
                    i15 = i17;
                    i16 = i15;
                }
                i16 = i17;
            }
            c7 = c8;
        }
        if (i8 > 0) {
            int i18 = i6 + i8;
            if (i18 > this.buf.length) {
                expandCapacity(i18);
            }
            this.count = i18;
            if (i8 == 1) {
                if (c7 == 8232) {
                    int i19 = i16 + 1;
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i19, cArr3, i16 + 6, (i14 - i16) - 1);
                    char[] cArr4 = this.buf;
                    cArr4[i16] = '\\';
                    cArr4[i19] = 'u';
                    cArr4[i16 + 2] = '2';
                    cArr4[i16 + 3] = '0';
                    cArr4[i16 + 4] = '2';
                    cArr4[i16 + 5] = '8';
                } else if (c7 == 8233) {
                    int i20 = i16 + 1;
                    char[] cArr5 = this.buf;
                    System.arraycopy(cArr5, i20, cArr5, i16 + 6, (i14 - i16) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i16] = '\\';
                    cArr6[i20] = 'u';
                    cArr6[i16 + 2] = '2';
                    cArr6[i16 + 3] = '0';
                    cArr6[i16 + 4] = '2';
                    cArr6[i16 + 5] = '9';
                } else {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c7 >= bArr2.length || bArr2[c7] != 4) {
                        int i21 = i16 + 1;
                        char[] cArr7 = this.buf;
                        System.arraycopy(cArr7, i21, cArr7, i16 + 2, (i14 - i16) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i16] = '\\';
                        cArr8[i21] = IOUtils.replaceChars[c7];
                    } else {
                        int i22 = i16 + 1;
                        char[] cArr9 = this.buf;
                        System.arraycopy(cArr9, i22, cArr9, i16 + 6, (i14 - i16) - 1);
                        char[] cArr10 = this.buf;
                        cArr10[i16] = '\\';
                        cArr10[i22] = 'u';
                        char[] cArr11 = IOUtils.DIGITS;
                        cArr10[i16 + 2] = cArr11[(c7 >>> '\f') & 15];
                        cArr10[i16 + 3] = cArr11[(c7 >>> '\b') & 15];
                        cArr10[i16 + 4] = cArr11[(c7 >>> 4) & 15];
                        cArr10[i16 + 5] = cArr11[c7 & 15];
                    }
                }
            } else if (i8 > 1) {
                for (int i23 = i15 - i13; i23 < str2.length(); i23++) {
                    char charAt = str2.charAt(i23);
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if ((charAt < bArr3.length && bArr3[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr12 = this.buf;
                        int i24 = i15 + 1;
                        cArr12[i15] = '\\';
                        if (bArr3[charAt] == 4) {
                            cArr12[i24] = 'u';
                            char[] cArr13 = IOUtils.DIGITS;
                            cArr12[i15 + 2] = cArr13[(charAt >>> '\f') & 15];
                            cArr12[i15 + 3] = cArr13[(charAt >>> '\b') & 15];
                            int i25 = i15 + 5;
                            cArr12[i15 + 4] = cArr13[(charAt >>> 4) & 15];
                            i15 += 6;
                            cArr12[i25] = cArr13[charAt & 15];
                        } else {
                            i15 += 2;
                            cArr12[i24] = IOUtils.replaceChars[charAt];
                        }
                    } else if (charAt == 8232 || charAt == 8233) {
                        char[] cArr14 = this.buf;
                        cArr14[i15] = '\\';
                        cArr14[i15 + 1] = 'u';
                        char[] cArr15 = IOUtils.DIGITS;
                        cArr14[i15 + 2] = cArr15[(charAt >>> '\f') & 15];
                        cArr14[i15 + 3] = cArr15[(charAt >>> '\b') & 15];
                        int i26 = i15 + 5;
                        cArr14[i15 + 4] = cArr15[(charAt >>> 4) & 15];
                        i15 += 6;
                        cArr14[i26] = cArr15[charAt & 15];
                    } else {
                        this.buf[i15] = charAt;
                        i15++;
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeHex(byte[] bArr) {
        int i6 = 2;
        int length = this.count + (bArr.length * 2) + 3;
        int i7 = 0;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[bArr.length + 3];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i7 < bArr.length) {
                    byte b6 = bArr[i7];
                    int i8 = (b6 & 255) >> 4;
                    int i9 = b6 & 15;
                    int i10 = i6 + 1;
                    cArr[i6] = (char) (i8 + (i8 < 10 ? 48 : 55));
                    i6 += 2;
                    cArr[i10] = (char) (i9 + (i9 < 10 ? 48 : 55));
                    i7++;
                }
                cArr[i6] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e6) {
                    throw new JSONException("writeBytes error.", e6);
                }
            }
            expandCapacity(length);
        }
        char[] cArr2 = this.buf;
        int i11 = this.count;
        int i12 = i11 + 1;
        this.count = i12;
        cArr2[i11] = 'x';
        this.count = i11 + 2;
        cArr2[i12] = '\'';
        while (i7 < bArr.length) {
            byte b7 = bArr[i7];
            int i13 = (b7 & 255) >> 4;
            int i14 = b7 & 15;
            char[] cArr3 = this.buf;
            int i15 = this.count;
            int i16 = i15 + 1;
            this.count = i16;
            cArr3[i15] = (char) (i13 + (i13 < 10 ? 48 : 55));
            this.count = i15 + 2;
            cArr3[i16] = (char) (i14 + (i14 < 10 ? 48 : 55));
            i7++;
        }
        char[] cArr4 = this.buf;
        int i17 = this.count;
        this.count = i17 + 1;
        cArr4[i17] = '\'';
    }

    public void writeInt(int i6) {
        if (i6 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i6 < 0 ? IOUtils.stringSize(-i6) + 1 : IOUtils.stringSize(i6);
        int i7 = this.count + stringSize;
        if (i7 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i6, stringSize, cArr);
                write(cArr, 0, stringSize);
                return;
            }
            expandCapacity(i7);
        }
        IOUtils.getChars(i6, i7, this.buf);
        this.count = i7;
    }

    public void writeLong(long j6) {
        boolean z5 = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j6 > 9007199254740991L || j6 < -9007199254740991L);
        if (j6 == Long.MIN_VALUE) {
            if (z5) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int stringSize = j6 < 0 ? IOUtils.stringSize(-j6) + 1 : IOUtils.stringSize(j6);
        int i6 = this.count + stringSize;
        if (z5) {
            i6 += 2;
        }
        if (i6 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(j6, stringSize, cArr);
                if (!z5) {
                    write(cArr, 0, stringSize);
                    return;
                }
                write(34);
                write(cArr, 0, stringSize);
                write(34);
                return;
            }
            expandCapacity(i6);
        }
        if (z5) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i7 = i6 - 1;
            IOUtils.getChars(j6, i7, cArr2);
            this.buf[i7] = '\"';
        } else {
            IOUtils.getChars(j6, i6, this.buf);
        }
        this.count = i6;
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    /* JADX WARN: Code restructure failed: missing block: B:244:0x03ae, code lost:
    
        if (r7 == (-1)) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x03b0, code lost:
    
        r7 = r6;
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x03b7, code lost:
    
        if (r7 == (-1)) goto L217;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r21, char r22) {
        /*
            Method dump skipped, instructions count: 1367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == UTF8) {
            return encodeToUTF8(outputStream);
        }
        byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeDouble(double d6, boolean z5) {
        if (!Double.isNaN(d6) && !Double.isInfinite(d6)) {
            String d7 = Double.toString(d6);
            if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && d7.endsWith(".0")) {
                d7 = d7.substring(0, d7.length() - 2);
            }
            write(d7);
            if (z5 && isEnabled(SerializerFeature.WriteClassName)) {
                write(68);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i6 = this.count + length;
        int i7 = i6 + 3;
        if (i7 > this.buf.length) {
            expandCapacity(i7);
        }
        int i8 = this.count;
        char[] cArr = this.buf;
        cArr[i8] = '\"';
        str.getChars(0, length, cArr, i8 + 1);
        this.count = i7;
        char[] cArr2 = this.buf;
        cArr2[i6 + 1] = '\"';
        cArr2[i6 + 2] = ':';
    }

    public void writeFieldValueStringWithDoubleQuote(char c6, String str, String str2) {
        int length = str.length();
        int i6 = this.count;
        int length2 = str2.length();
        int i7 = i6 + length + length2 + 6;
        if (i7 > this.buf.length) {
            if (this.writer != null) {
                write(c6);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i7);
        }
        char[] cArr = this.buf;
        int i8 = this.count;
        cArr[i8] = c6;
        int i9 = i8 + 2;
        int i10 = i9 + length;
        cArr[i8 + 1] = '\"';
        str.getChars(0, length, cArr, i9);
        this.count = i7;
        char[] cArr2 = this.buf;
        cArr2[i10] = '\"';
        cArr2[i10 + 1] = ':';
        cArr2[i10 + 2] = '\"';
        str2.getChars(0, length2, cArr2, i10 + 3);
        this.buf[this.count - 1] = '\"';
    }

    public void writeFloat(float f6, boolean z5) {
        if (!Float.isNaN(f6) && !Float.isInfinite(f6)) {
            String f7 = Float.toString(f6);
            if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && f7.endsWith(".0")) {
                f7 = f7.substring(0, f7.length() - 2);
            }
            write(f7);
            if (z5 && isEnabled(SerializerFeature.WriteClassName)) {
                write(70);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeNull(int i6, int i7) {
        if ((i6 & i7) == 0 && (this.features & i7) == 0) {
            writeNull();
            return;
        }
        if (i7 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
            return;
        }
        if (i7 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
            return;
        }
        if (i7 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i7 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i6, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i6 |= serializerFeature.getMask();
        }
        this.features = i6;
        computeFeatures();
    }

    public void writeFieldValue(char c6, String str, boolean z5) {
        if (!this.quoteFieldNames) {
            write(c6);
            writeFieldName(str);
            write(z5);
            return;
        }
        int i6 = z5 ? 4 : 5;
        int length = str.length();
        int i7 = this.count + length + 4 + i6;
        if (i7 > this.buf.length) {
            if (this.writer != null) {
                write(c6);
                writeString(str);
                write(58);
                write(z5);
                return;
            }
            expandCapacity(i7);
        }
        int i8 = this.count;
        this.count = i7;
        char[] cArr = this.buf;
        cArr[i8] = c6;
        int i9 = i8 + length;
        cArr[i8 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i8 + 2);
        this.buf[i9 + 2] = this.keySeperator;
        if (z5) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i9 + 3, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i9 + 3, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i6, int i7) {
        int i8;
        if (i6 < 0 || i6 > cArr.length || i7 < 0 || (i8 = i6 + i7) > cArr.length || i8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i7 == 0) {
            return;
        }
        int i9 = this.count + i7;
        if (i9 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i9);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i10 = this.count;
                    int i11 = length - i10;
                    System.arraycopy(cArr, i6, cArr2, i10, i11);
                    this.count = this.buf.length;
                    flush();
                    i7 -= i11;
                    i6 += i11;
                } while (i7 > this.buf.length);
                i9 = i7;
            }
        }
        System.arraycopy(cArr, i6, this.buf, this.count, i7);
        this.count = i9;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i6, int i7) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i6, i7).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c6) {
        write(c6);
        return this;
    }

    public SerializeWriter(int i6) {
        this((Writer) null, i6);
    }

    public SerializeWriter(Writer writer, int i6) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i6 > 0) {
            this.buf = new char[i6];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i6);
    }

    @Override // java.io.Writer
    public void write(String str, int i6, int i7) {
        int i8;
        int i9 = this.count + i7;
        if (i9 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i9);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i10 = this.count;
                    int i11 = length - i10;
                    i8 = i6 + i11;
                    str.getChars(i6, i8, cArr, i10);
                    this.count = this.buf.length;
                    flush();
                    i7 -= i11;
                    if (i7 <= this.buf.length) {
                        break;
                    } else {
                        i6 = i8;
                    }
                }
                i9 = i7;
                i6 = i8;
            }
        }
        str.getChars(i6, i7 + i6, this.buf, this.count);
        this.count = i9;
    }

    public void writeFieldValue(char c6, String str, int i6) {
        if (i6 != Integer.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = i6 < 0 ? IOUtils.stringSize(-i6) + 1 : IOUtils.stringSize(i6);
            int length = str.length();
            int i7 = this.count + length + 4 + stringSize;
            if (i7 > this.buf.length) {
                if (this.writer != null) {
                    write(c6);
                    writeFieldName(str);
                    writeInt(i6);
                    return;
                }
                expandCapacity(i7);
            }
            int i8 = this.count;
            this.count = i7;
            char[] cArr = this.buf;
            cArr[i8] = c6;
            int i9 = i8 + length;
            cArr[i8 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i8 + 2);
            char[] cArr2 = this.buf;
            cArr2[i9 + 2] = this.keySeperator;
            cArr2[i9 + 3] = ':';
            IOUtils.getChars(i6, this.count, cArr2);
            return;
        }
        write(c6);
        writeFieldName(str);
        writeInt(i6);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        boolean z5;
        int i6;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i7 = this.count;
        int size = list.size();
        int i8 = i7;
        int i9 = 0;
        while (i9 < size) {
            String str = list.get(i9);
            if (str == null) {
                z5 = true;
            } else {
                int length = str.length();
                z5 = false;
                for (int i10 = 0; i10 < length; i10++) {
                    char charAt = str.charAt(i10);
                    z5 = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z5) {
                        break;
                    }
                }
            }
            if (z5) {
                this.count = i7;
                write(91);
                for (int i11 = 0; i11 < list.size(); i11++) {
                    String str2 = list.get(i11);
                    if (i11 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i8;
            int i12 = length2 + 3;
            if (i9 == list.size() - 1) {
                i12 = length2 + 4;
            }
            if (i12 > this.buf.length) {
                this.count = i8;
                expandCapacity(i12);
            }
            if (i9 == 0) {
                i6 = i8 + 1;
                this.buf[i8] = '[';
            } else {
                i6 = i8 + 1;
                this.buf[i8] = StringUtil.COMMA;
            }
            int i13 = i6 + 1;
            this.buf[i6] = '\"';
            str.getChars(0, str.length(), this.buf, i13);
            int length3 = i13 + str.length();
            this.buf[length3] = '\"';
            i9++;
            i8 = length3 + 1;
        }
        this.buf[i8] = ']';
        this.count = i8 + 1;
    }

    public void writeFieldValue(char c6, String str, long j6) {
        if (j6 != Long.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = j6 < 0 ? IOUtils.stringSize(-j6) + 1 : IOUtils.stringSize(j6);
            int length = str.length();
            int i6 = this.count + length + 4 + stringSize;
            if (i6 > this.buf.length) {
                if (this.writer != null) {
                    write(c6);
                    writeFieldName(str);
                    writeLong(j6);
                    return;
                }
                expandCapacity(i6);
            }
            int i7 = this.count;
            this.count = i6;
            char[] cArr = this.buf;
            cArr[i7] = c6;
            int i8 = i7 + length;
            cArr[i7 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i7 + 2);
            char[] cArr2 = this.buf;
            cArr2[i8 + 2] = this.keySeperator;
            cArr2[i8 + 3] = ':';
            IOUtils.getChars(j6, this.count, cArr2);
            return;
        }
        write(c6);
        writeFieldName(str);
        writeLong(j6);
    }

    public void write(boolean z5) {
        if (z5) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c6, String str, float f6) {
        write(c6);
        writeFieldName(str);
        writeFloat(f6, false);
    }

    public void writeFieldValue(char c6, String str, double d6) {
        write(c6);
        writeFieldName(str);
        writeDouble(d6, false);
    }

    public void writeFieldValue(char c6, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c6);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserSecure)) {
                write(c6);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            } else {
                if (isEnabled(SerializerFeature.BrowserCompatible)) {
                    write(c6);
                    writeStringWithDoubleQuote(str, ':');
                    writeStringWithDoubleQuote(str2, (char) 0);
                    return;
                }
                writeFieldValueStringWithDoubleQuoteCheck(c6, str, str2);
                return;
            }
        }
        write(c6);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c6, String str, Enum<?> r42) {
        if (r42 == null) {
            write(c6);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c6, str, r42.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c6, str, r42.toString());
        } else {
            writeFieldValue(c6, str, r42.ordinal());
        }
    }

    public void writeFieldValue(char c6, String str, BigDecimal bigDecimal) {
        write(c6);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }
}
