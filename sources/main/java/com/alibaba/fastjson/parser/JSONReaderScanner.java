package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i6 = 0; i6 < cArr.length; i6++) {
            if (charAt(this.bp + i6) != cArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i6 = 0;
        while (true) {
            char c6 = this.buf[i6];
            if (c6 == 26) {
                this.token = 20;
                return true;
            }
            if (!JSONLexerBase.isWhitespace(c6)) {
                return false;
            }
            i6++;
        }
    }

    public JSONReaderScanner(String str, int i6) {
        this(new StringReader(str), i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i6, int i7, int i8, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i6, i7, i8);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i6, char[] cArr, int i7, int i8) {
        System.arraycopy(this.buf, i6, cArr, i7, i8);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
        }
        throw new JSONException("TODO");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i6) {
        int i7 = this.bufLength;
        if (i6 >= i7) {
            if (i7 == -1) {
                return i6 < this.sp ? this.buf[i6] : JSONLexer.EOI;
            }
            int i8 = this.bp;
            if (i8 == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i8, cArr2, 0, i7);
                int i9 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i9, length - i9);
                    this.buf = cArr2;
                } catch (IOException e6) {
                    throw new JSONException(e6.getMessage(), e6);
                }
            } else {
                int i10 = i7 - i8;
                if (i10 > 0) {
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i8, cArr3, 0, i10);
                }
                try {
                    Reader reader = this.reader;
                    char[] cArr4 = this.buf;
                    int read = reader.read(cArr4, i10, cArr4.length - i10);
                    this.bufLength = read;
                    if (read == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (read == -1) {
                        return JSONLexer.EOI;
                    }
                    this.bufLength = read + i10;
                    int i11 = this.bp;
                    i6 -= i11;
                    this.np -= i11;
                    this.bp = 0;
                } catch (IOException e7) {
                    throw new JSONException(e7.getMessage(), e7);
                }
            }
        }
        return this.buf[i6];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i6, int i7, char[] cArr) {
        System.arraycopy(this.buf, i6, cArr, 0, i7);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int i6 = this.np;
        if (i6 == -1) {
            i6 = 0;
        }
        char charAt = charAt((this.sp + i6) - 1);
        int i7 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i7--;
        }
        return new BigDecimal(this.buf, i6, i7);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c6, int i6) {
        int i7 = i6 - this.bp;
        while (true) {
            char charAt = charAt(this.bp + i7);
            if (c6 == charAt) {
                return i7 + this.bp;
            }
            if (charAt == 26) {
                return -1;
            }
            i7++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bufLength != -1) {
            int i6 = this.bp;
            char[] cArr = this.buf;
            if (i6 != cArr.length && (this.ch != 26 || i6 + 1 != cArr.length)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i6 = this.bp + 1;
        this.bp = i6;
        int i7 = this.bufLength;
        if (i6 >= i7) {
            if (i7 == -1) {
                return JSONLexer.EOI;
            }
            int i8 = this.sp;
            if (i8 > 0) {
                int i9 = i7 - i8;
                if (this.ch == '\"' && i9 > 0) {
                    i9--;
                }
                char[] cArr = this.buf;
                System.arraycopy(cArr, i9, cArr, 0, i8);
            }
            this.np = -1;
            int i10 = this.sp;
            this.bp = i10;
            try {
                char[] cArr2 = this.buf;
                int length = cArr2.length - i10;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.buf = cArr3;
                    length = cArr3.length - i10;
                }
                int read = this.reader.read(this.buf, this.bp, length);
                this.bufLength = read;
                if (read == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (read == -1) {
                    this.ch = JSONLexer.EOI;
                    return JSONLexer.EOI;
                }
                this.bufLength = read + this.bp;
                i6 = i10;
            } catch (IOException e6) {
                throw new JSONException(e6.getMessage(), e6);
            }
        }
        char c6 = this.buf[i6];
        this.ch = c6;
        return c6;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int i6 = this.np;
        if (i6 == -1) {
            i6 = 0;
        }
        char charAt = charAt((this.sp + i6) - 1);
        int i7 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i7--;
        }
        return new String(this.buf, i6, i7);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (this.hasSpecial) {
            return new String(this.sbuf, 0, this.sp);
        }
        int i6 = this.np + 1;
        if (i6 < 0) {
            throw new IllegalStateException();
        }
        char[] cArr = this.buf;
        int length = cArr.length;
        int i7 = this.sp;
        if (i6 <= length - i7) {
            return new String(cArr, i6, i7);
        }
        throw new IllegalStateException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i6, int i7) {
        if (i7 >= 0) {
            return new String(this.buf, i6, i7);
        }
        throw new StringIndexOutOfBoundsException(i7);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i6, int i7) {
        if (i7 < 0) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        if (i6 == 0) {
            return this.buf;
        }
        char[] cArr = new char[i7];
        System.arraycopy(this.buf, i6, cArr, 0, i7);
        return cArr;
    }

    public JSONReaderScanner(char[] cArr, int i6) {
        this(cArr, i6, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            BUF_LOCAL.set(cArr);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i6) {
        super(i6);
        this.reader = reader;
        ThreadLocal<char[]> threadLocal = BUF_LOCAL;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (IOException e6) {
            throw new JSONException(e6.getMessage(), e6);
        }
    }

    public JSONReaderScanner(char[] cArr, int i6, int i7) {
        this(new CharArrayReader(cArr, 0, i6), i7);
    }
}
