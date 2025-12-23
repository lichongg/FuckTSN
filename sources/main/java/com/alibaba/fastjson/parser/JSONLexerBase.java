package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    public abstract String addSymbol(int i6, int i7, int i8, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i6, char[] cArr, int i7, int i8);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i6);

    protected abstract void copyTo(int i6, int i7, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z5) {
        char charAt = charAt((this.np + this.sp) - 1);
        try {
            return charAt == 'F' ? Float.valueOf(Float.parseFloat(numberString())) : charAt == 'D' ? Double.valueOf(Double.parseDouble(numberString())) : z5 ? decimalValue() : Double.valueOf(doubleValue());
        } catch (NumberFormatException e6) {
            throw new JSONException(e6.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public abstract int indexOf(char c6, int i6);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i6 = 0;
        while (true) {
            char charAt = charAt(i6);
            if (charAt == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(charAt)) {
                return false;
            }
            i6++;
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    protected void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c6 = this.ch;
            if (c6 == '/') {
                skipComment();
            } else {
                if (c6 == '\"') {
                    scanString();
                    return;
                }
                if (c6 == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c6 >= '0' && c6 <= '9') {
                    scanNumber();
                    return;
                }
                if (c6 == '-') {
                    scanNumber();
                    return;
                }
                switch (c6) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        scanStringSingleQuote();
                        return;
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.token = 20;
                            int i6 = this.eofPos;
                            this.bp = i6;
                            this.pos = i6;
                            return;
                        }
                        char c7 = this.ch;
                        if (c7 > 31 && c7 != 127) {
                            lexError("illegal.char", String.valueOf((int) c7));
                            next();
                            return;
                        } else {
                            next();
                            break;
                        }
                }
            }
        }
    }

    public final void nextTokenWithChar(char c6) {
        this.sp = 0;
        while (true) {
            char c7 = this.ch;
            if (c7 == c6) {
                next();
                nextToken();
                return;
            }
            if (c7 != ' ' && c7 != '\n' && c7 != '\r' && c7 != '\t' && c7 != '\f' && c7 != '\b') {
                throw new JSONException("not match " + c6 + " - " + this.ch + ", info : " + info());
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c6) {
        boolean z5 = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        int i6 = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) != 'r' || charAt(this.bp + 2) != 'u' || charAt(this.bp + 3) != 'e') {
                this.matchStat = -1;
                return false;
            }
            charAt = charAt(this.bp + 4);
            z5 = true;
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z5 = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i6 = 1;
            }
            i6 = 2;
        } else {
            if (charAt(this.bp + 1) != 'a' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 's' || charAt(this.bp + 4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            charAt = charAt(this.bp + 5);
            i6 = 6;
        }
        while (charAt != c6) {
            if (!isWhitespace(charAt)) {
                this.matchStat = -1;
                return z5;
            }
            charAt = charAt(this.bp + i6);
            i6++;
        }
        int i7 = this.bp + i6;
        this.bp = i7;
        this.ch = charAt(i7);
        this.matchStat = 3;
        return z5;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final double scanDouble(char c6) {
        int i6;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i7 = 1;
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i7 = i6;
        }
        if (charAt == '.') {
            int i8 = i7 + 2;
            char charAt3 = charAt(this.bp + i6);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    i6 = i8 + 1;
                    charAt = charAt(this.bp + i8);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i8 = i6;
                }
            } else {
                this.matchStat = -1;
                return 0.0d;
            }
        }
        int i9 = this.bp;
        double parseDouble = Double.parseDouble(subString(i9, ((i9 + i6) - i9) - 1));
        if (charAt != c6) {
            this.matchStat = -1;
            return parseDouble;
        }
        int i10 = this.bp + i6;
        this.bp = i10;
        this.ch = charAt(i10);
        this.matchStat = 3;
        this.token = 16;
        return parseDouble;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i6;
        boolean z5;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i7 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i8 = length + 2;
            if (charAt(this.bp + i7) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i9 = length + 3;
            if (charAt(this.bp + i8) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i6 = length + 4;
            if (charAt(this.bp + i9) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z5 = true;
        } else {
            if (charAt != 'f') {
                this.matchStat = -1;
                return false;
            }
            int i10 = length + 2;
            if (charAt(this.bp + i7) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i11 = length + 3;
            if (charAt(this.bp + i10) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i12 = length + 4;
            if (charAt(this.bp + i11) != 's') {
                this.matchStat = -1;
                return false;
            }
            i6 = length + 5;
            if (charAt(this.bp + i12) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z5 = false;
        }
        int i13 = i6 + 1;
        char charAt2 = charAt(this.bp + i6);
        if (charAt2 == ',') {
            int i14 = this.bp + i13;
            this.bp = i14;
            this.ch = charAt(i14);
            this.matchStat = 3;
            this.token = 16;
            return z5;
        }
        if (charAt2 != '}') {
            this.matchStat = -1;
            return false;
        }
        int i15 = i6 + 2;
        char charAt3 = charAt(this.bp + i13);
        if (charAt3 == ',') {
            this.token = 16;
            int i16 = this.bp + i15;
            this.bp = i16;
            this.ch = charAt(i16);
        } else if (charAt3 == ']') {
            this.token = 15;
            int i17 = this.bp + i15;
            this.bp = i17;
            this.ch = charAt(i17);
        } else if (charAt3 == '}') {
            this.token = 13;
            int i18 = this.bp + i15;
            this.bp = i18;
            this.ch = charAt(i18);
        } else {
            if (charAt3 != 26) {
                this.matchStat = -1;
                return false;
            }
            this.token = 20;
            this.bp += i6 + 1;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x007b A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x007d -> B:56:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(char[] r11) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    public final float scanFieldFloat(char[] cArr) {
        int i6;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i7 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i7 = i6;
        }
        if (charAt == '.') {
            int i8 = i7 + 2;
            char charAt3 = charAt(this.bp + i6);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    i6 = i8 + 1;
                    charAt = charAt(this.bp + i8);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i8 = i6;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        float parseFloat = Float.parseFloat(subString(cArr.length + this.bp, ((r3 + i6) - r9) - 1));
        if (charAt == ',') {
            int i9 = this.bp + i6;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        }
        if (charAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i10 = i6 + 1;
        char charAt4 = charAt(this.bp + i6);
        if (charAt4 == ',') {
            this.token = 16;
            int i11 = this.bp + i10;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i12 = this.bp + i10;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i13 = this.bp + i10;
            this.bp = i13;
            this.ch = charAt(i13);
        } else {
            if (charAt4 != 26) {
                this.matchStat = -1;
                return 0.0f;
            }
            this.bp += i6;
            this.token = 20;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return parseFloat;
    }

    public int scanFieldInt(char[] cArr) {
        int i6;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i7 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z5 = charAt2 == '-';
        if (z5) {
            charAt2 = charAt(this.bp + i7);
            i7 = length + 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i8 = charAt2 - '0';
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i8 = (i8 * 10) + (charAt - '0');
            i7 = i6;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if ((i8 < 0 || i6 > cArr.length + 14) && !(i8 == Integer.MIN_VALUE && i6 == 17 && z5)) {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == ',') {
            int i9 = this.bp + i6;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            this.token = 16;
            if (z5) {
                return -i8;
            }
        } else {
            if (charAt != '}') {
                this.matchStat = -1;
                return 0;
            }
            int i10 = i7 + 2;
            char charAt3 = charAt(this.bp + i6);
            if (charAt3 == ',') {
                this.token = 16;
                int i11 = this.bp + i10;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i12 = this.bp + i10;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i13 = this.bp + i10;
                this.bp = i13;
                this.ch = charAt(i13);
            } else {
                if (charAt3 != 26) {
                    this.matchStat = -1;
                    return 0;
                }
                this.token = 20;
                this.bp += i7 + 1;
                this.ch = JSONLexer.EOI;
            }
            this.matchStat = 4;
            if (z5) {
                return -i8;
            }
        }
        return i8;
    }

    public long scanFieldLong(char[] cArr) {
        int i6;
        char charAt;
        boolean z5 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i7 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i7);
            i7 = length + 2;
            z5 = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j6 = charAt2 - '0';
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j6 = (j6 * 10) + (charAt - '0');
            i7 = i6;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (j6 < 0 || i6 > 21) {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == ',') {
            int i8 = this.bp + i6;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            this.token = 16;
            if (z5) {
                return -j6;
            }
        } else {
            if (charAt != '}') {
                this.matchStat = -1;
                return 0L;
            }
            int i9 = i7 + 2;
            char charAt3 = charAt(this.bp + i6);
            if (charAt3 == ',') {
                this.token = 16;
                int i10 = this.bp + i9;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i11 = this.bp + i9;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i12 = this.bp + i9;
                this.bp = i12;
                this.ch = charAt(i12);
            } else {
                if (charAt3 != 26) {
                    this.matchStat = -1;
                    return 0L;
                }
                this.token = 20;
                this.bp += i7 + 1;
                this.ch = JSONLexer.EOI;
            }
            this.matchStat = 4;
            if (z5) {
                return -j6;
            }
        }
        return j6;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i6 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.bp + cArr.length + 1;
        String subString = subString(length2, indexOf - length2);
        if (subString.indexOf(92) != -1) {
            while (true) {
                int i7 = 0;
                for (int i8 = indexOf - 1; i8 >= 0 && charAt(i8) == '\\'; i8--) {
                    i7++;
                }
                if (i7 % 2 == 0) {
                    break;
                }
                indexOf = indexOf('\"', indexOf + 1);
            }
            int i9 = this.bp;
            int length3 = indexOf - ((cArr.length + i9) + 1);
            subString = readString(sub_chars(i9 + cArr.length + 1, length3), length3);
        }
        int i10 = this.bp;
        int length4 = i6 + (indexOf - ((cArr.length + i10) + 1)) + 1;
        int i11 = length4 + 1;
        char charAt = charAt(i10 + length4);
        if (charAt == ',') {
            int i12 = this.bp + i11;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            return subString;
        }
        if (charAt != '}') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int i13 = length4 + 2;
        char charAt2 = charAt(this.bp + i11);
        if (charAt2 == ',') {
            this.token = 16;
            int i14 = this.bp + i13;
            this.bp = i14;
            this.ch = charAt(i14);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i15 = this.bp + i13;
            this.bp = i15;
            this.ch = charAt(i15);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i16 = this.bp + i13;
            this.bp = i16;
            this.ch = charAt(i16);
        } else {
            if (charAt2 != 26) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
            this.bp += length4 + 1;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return subString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fc, code lost:
    
        if (r13 != ',') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
    
        r13 = r12.bp + r0;
        r12.bp = r13;
        r12.ch = charAt(r13);
        r12.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010c, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010f, code lost:
    
        if (r13 != '}') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0111, code lost:
    
        r6 = r0 + 1;
        r13 = charAt(r12.bp + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x011a, code lost:
    
        if (r13 != ',') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011c, code lost:
    
        r12.token = 16;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x015f, code lost:
    
        r12.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0162, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012c, code lost:
    
        if (r13 != ']') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012e, code lost:
    
        r12.token = 15;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013e, code lost:
    
        if (r13 != '}') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0140, code lost:
    
        r12.token = 13;
        r13 = r12.bp + r6;
        r12.bp = r13;
        r12.ch = charAt(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0152, code lost:
    
        if (r13 != 26) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0154, code lost:
    
        r12.bp += r0;
        r12.token = 20;
        r12.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0163, code lost:
    
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0165, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0166, code lost:
    
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f0, code lost:
    
        if (r14.size() != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f2, code lost:
    
        r1 = r13 + 1;
        r13 = charAt(r12.bp + r13);
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0170, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r13, java.lang.Class<?> r14) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i6 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j6 = -2128831035;
        while (true) {
            int i7 = i6 + 1;
            char charAt = charAt(this.bp + i6);
            if (charAt == '\"') {
                int i8 = i6 + 2;
                char charAt2 = charAt(this.bp + i7);
                if (charAt2 == ',') {
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 3;
                    return j6;
                }
                if (charAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i10 = i6 + 3;
                char charAt3 = charAt(this.bp + i8);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i12 = this.bp + i10;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i13 = this.bp + i10;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else {
                    if (charAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.bp += i6 + 2;
                    this.ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return j6;
            }
            j6 = (j6 ^ charAt) * 16777619;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i6 = i7;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char c6) {
        int i6;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i7 = 1;
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i7 = i6;
        }
        if (charAt == '.') {
            int i8 = i7 + 2;
            char charAt3 = charAt(this.bp + i6);
            if (charAt3 >= '0' && charAt3 <= '9') {
                while (true) {
                    i6 = i8 + 1;
                    charAt = charAt(this.bp + i8);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i8 = i6;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        int i9 = this.bp;
        float parseFloat = Float.parseFloat(subString(i9, ((i9 + i6) - i9) - 1));
        if (charAt != c6) {
            this.matchStat = -1;
            return parseFloat;
        }
        int i10 = this.bp + i6;
        this.bp = i10;
        this.ch = charAt(i10);
        this.matchStat = 3;
        this.token = 16;
        return parseFloat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c6) {
        int i6;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        int i7 = 1;
        boolean z5 = charAt2 == '-';
        if (z5) {
            charAt2 = charAt(this.bp + 1);
            i7 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i8 = charAt2 - '0';
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i8 = (i8 * 10) + (charAt - '0');
            i7 = i6;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i8 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (true) {
            if (charAt == c6) {
                int i9 = this.bp + i6;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                if (z5) {
                    return -i8;
                }
            } else if (isWhitespace(charAt)) {
                char charAt3 = charAt(this.bp + i6);
                i6++;
                charAt = charAt3;
            } else {
                this.matchStat = -1;
                if (z5) {
                    return -i8;
                }
            }
        }
        return i8;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c6) {
        int i6;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp);
        int i7 = 1;
        boolean z5 = charAt2 == '-';
        if (z5) {
            charAt2 = charAt(this.bp + 1);
            i7 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j6 = charAt2 - '0';
        while (true) {
            i6 = i7 + 1;
            charAt = charAt(this.bp + i7);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j6 = (j6 * 10) + (charAt - '0');
            i7 = i6;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (j6 < 0) {
            this.matchStat = -1;
            return 0L;
        }
        while (charAt != c6) {
            if (!isWhitespace(charAt)) {
                this.matchStat = -1;
                return j6;
            }
            charAt = charAt(this.bp + i6);
            i6++;
        }
        int i8 = this.bp + i6;
        this.bp = i8;
        this.ch = charAt(i8);
        this.matchStat = 3;
        this.token = 16;
        return z5 ? -j6 : j6;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed string : " + next);
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i6 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i6 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i6 <= length) {
                            i6 = length;
                        }
                        char[] cArr2 = new char[i6];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar(StringUtil.CARRIAGE_RETURN);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i7 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i7 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i7 + 1;
                    cArr3[i7] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c6 = this.ch;
        if (c6 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c6 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c6 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c6 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c6 == 26) {
            this.token = 20;
            return null;
        }
        if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c6) {
        int i6 = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.bp + 4) != c6) {
                this.matchStat = -1;
                return null;
            }
            int i7 = this.bp + 5;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            return null;
        }
        if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i8 = 1;
        while (true) {
            int i9 = i8 + 1;
            char charAt2 = charAt(this.bp + i8);
            if (charAt2 == '\"') {
                int i10 = this.bp;
                int i11 = i10 + 1;
                String addSymbol = addSymbol(i11, ((i10 + i9) - i11) - 1, i6, symbolTable);
                int i12 = i8 + 2;
                char charAt3 = charAt(this.bp + i9);
                while (charAt3 != c6) {
                    if (!isWhitespace(charAt3)) {
                        this.matchStat = -1;
                        return addSymbol;
                    }
                    charAt3 = charAt(this.bp + i12);
                    i12++;
                }
                int i13 = this.bp + i12;
                this.bp = i13;
                this.ch = charAt(i13);
                this.matchStat = 3;
                return addSymbol;
            }
            i6 = (i6 * 31) + charAt2;
            if (charAt2 == '\\') {
                this.matchStat = -1;
                return null;
            }
            i8 = i9;
        }
    }

    public final int scanType(String str) {
        int i6;
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i7 = 0; i7 < length2; i7++) {
            if (str.charAt(i7) != charAt(length + i7)) {
                return -1;
            }
        }
        int i8 = length + length2;
        if (charAt(i8) != '\"') {
            return -1;
        }
        int i9 = i8 + 1;
        char charAt = charAt(i9);
        this.ch = charAt;
        if (charAt == ',') {
            int i10 = i8 + 2;
            this.ch = charAt(i10);
            this.bp = i10;
            this.token = 16;
            return 3;
        }
        if (charAt == '}') {
            i9 = i8 + 2;
            char charAt2 = charAt(i9);
            this.ch = charAt2;
            if (charAt2 == ',') {
                this.token = 16;
                i6 = i8 + 3;
                this.ch = charAt(i6);
            } else if (charAt2 == ']') {
                this.token = 15;
                i6 = i8 + 3;
                this.ch = charAt(i6);
            } else if (charAt2 == '}') {
                this.token = 13;
                i6 = i8 + 3;
                this.ch = charAt(i6);
            } else {
                if (charAt2 != 26) {
                    return -1;
                }
                this.token = 20;
                this.matchStat = 4;
            }
            i9 = i6;
            this.matchStat = 4;
        }
        this.bp = i9;
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i6, int i7);

    protected abstract char[] sub_chars(int i6, int i7);

    static {
        for (int i6 = 48; i6 <= 57; i6++) {
            digits[i6] = i6 - 48;
        }
        for (int i7 = 97; i7 <= 102; i7++) {
            digits[i7] = i7 - 87;
        }
        for (int i8 = 65; i8 <= 70; i8++) {
            digits[i8] = i8 - 55;
        }
    }

    public static boolean isWhitespace(char c6) {
        if (c6 <= ' ') {
            return c6 == ' ' || c6 == '\n' || c6 == '\r' || c6 == '\t' || c6 == '\f' || c6 == '\b';
        }
        return false;
    }

    public static String readString(char[] cArr, int i6) {
        int i7;
        int i8;
        char[] cArr2 = new char[i6];
        int i9 = 0;
        int i10 = 0;
        while (i9 < i6) {
            char c6 = cArr[i9];
            if (c6 != '\\') {
                cArr2[i10] = c6;
                i10++;
            } else {
                int i11 = i9 + 1;
                char c7 = cArr[i11];
                if (c7 == '\"') {
                    i7 = i10 + 1;
                    cArr2[i10] = '\"';
                } else if (c7 != '\'') {
                    if (c7 != 'F') {
                        if (c7 == '\\') {
                            i7 = i10 + 1;
                            cArr2[i10] = '\\';
                        } else if (c7 == 'b') {
                            i7 = i10 + 1;
                            cArr2[i10] = '\b';
                        } else if (c7 != 'f') {
                            if (c7 == 'n') {
                                i7 = i10 + 1;
                                cArr2[i10] = '\n';
                            } else if (c7 != 'r') {
                                if (c7 != 'x') {
                                    switch (c7) {
                                        case '/':
                                            i7 = i10 + 1;
                                            cArr2[i10] = '/';
                                            break;
                                        case '0':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 0;
                                            break;
                                        case '1':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 1;
                                            break;
                                        case '2':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 2;
                                            break;
                                        case '3':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 3;
                                            break;
                                        case '4':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 4;
                                            break;
                                        case '5':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 5;
                                            break;
                                        case '6':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 6;
                                            break;
                                        case '7':
                                            i7 = i10 + 1;
                                            cArr2[i10] = 7;
                                            break;
                                        default:
                                            switch (c7) {
                                                case 't':
                                                    i7 = i10 + 1;
                                                    cArr2[i10] = '\t';
                                                    break;
                                                case 'u':
                                                    i8 = i10 + 1;
                                                    char c8 = cArr[i9 + 2];
                                                    char c9 = cArr[i9 + 3];
                                                    char c10 = cArr[i9 + 4];
                                                    i9 += 5;
                                                    cArr2[i10] = (char) Integer.parseInt(new String(new char[]{c8, c9, c10, cArr[i9]}), 16);
                                                    break;
                                                case 'v':
                                                    i7 = i10 + 1;
                                                    cArr2[i10] = 11;
                                                    break;
                                                default:
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    i8 = i10 + 1;
                                    int[] iArr = digits;
                                    int i12 = iArr[cArr[i9 + 2]] * 16;
                                    i9 += 3;
                                    cArr2[i10] = (char) (i12 + iArr[cArr[i9]]);
                                }
                                i10 = i8;
                            } else {
                                i7 = i10 + 1;
                                cArr2[i10] = StringUtil.CARRIAGE_RETURN;
                            }
                        }
                    }
                    i7 = i10 + 1;
                    cArr2[i10] = '\f';
                } else {
                    i7 = i10 + 1;
                    cArr2[i10] = '\'';
                }
                i10 = i7;
                i9 = i11;
            }
            i9++;
        }
        return new String(cArr2, 0, i10);
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed single-quote string");
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i6 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i6 > cArr.length) {
                        char[] cArr2 = new char[i6 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar(StringUtil.CARRIAGE_RETURN);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                int[] iArr = digits;
                                putChar((char) ((iArr[next()] * 16) + iArr[next()]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i7 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i7 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i7 + 1;
                    cArr3[i7] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z5) {
        int config = Feature.config(this.features, feature, z5);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i6;
        boolean z5;
        int i7 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i8 = this.np;
        int i9 = this.sp + i8;
        if (charAt(i8) == '-') {
            i8++;
            i6 = Integer.MIN_VALUE;
            z5 = true;
        } else {
            i6 = -2147483647;
            z5 = false;
        }
        if (i8 < i9) {
            i7 = -(charAt(i8) - '0');
            i8++;
        }
        while (i8 < i9) {
            int i10 = i8 + 1;
            char charAt = charAt(i8);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i8 = i10;
                break;
            }
            int i11 = charAt - '0';
            if (i7 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i12 = i7 * 10;
            if (i12 < i6 + i11) {
                throw new NumberFormatException(numberString());
            }
            i7 = i12 - i11;
            i8 = i10;
        }
        if (!z5) {
            return -i7;
        }
        if (i8 > this.np + 1) {
            return i7;
        }
        throw new NumberFormatException(numberString());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008a -> B:14:0x0054). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Number integerValue() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.integerValue():java.lang.Number");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i6) {
        return (i6 & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005d -> B:9:0x002e). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L8
            r13.np = r2
        L8:
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r3 = r13.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = 1
            goto L22
        L1d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L22:
            if (r0 >= r1) goto L30
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L2e:
            r0 = r6
            goto L32
        L30:
            r7 = 0
        L32:
            if (r0 >= r1) goto L74
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            r9 = 76
            if (r0 == r9) goto L73
            r9 = 83
            if (r0 == r9) goto L73
            r9 = 66
            if (r0 != r9) goto L47
            goto L73
        L47:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L69
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5f
            long r7 = r7 - r9
            goto L2e
        L5f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L73:
            r0 = r6
        L74:
            if (r2 == 0) goto L86
            int r1 = r13.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L7c
            return r7
        L7c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L86:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e6) {
            throw new JSONException(e6.getMessage(), e6);
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c6 = this.ch;
        if (c6 == '_' || Character.isLetter(c6)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i6) {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    protected final void putChar(char c6) {
        int i6 = this.sp;
        char[] cArr = this.sbuf;
        if (i6 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i7 = this.sp;
        this.sp = i7 + 1;
        cArr3[i7] = c6;
    }

    public final void scanFalse() {
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c6 = this.ch;
        if (c6 != ' ' && c6 != ',' && c6 != '}' && c6 != ']' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != 26 && c6 != '\f' && c6 != '\b' && c6 != ':' && c6 != '/') {
            throw new JSONException("scan false error");
        }
        this.token = 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00a2, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a4, code lost:
    
        return r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(char[] r21) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b0, code lost:
    
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00b2, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0219, code lost:
    
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x021c, code lost:
    
        return r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z5;
        int[] iArr;
        int i6;
        char charAt;
        int i7;
        char charAt2;
        int i8;
        this.matchStat = 0;
        int[] iArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i9 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i10 = length + 2;
        char charAt3 = charAt(this.bp + i9);
        int[] iArr3 = new int[16];
        if (charAt3 != ']') {
            int i11 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.bp + i10);
                    i10++;
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i12 = charAt3 - '0';
                iArr = iArr2;
                while (true) {
                    i6 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i12 = (i12 * 10) + (charAt - '0');
                    i10 = i6;
                }
                if (i11 >= iArr3.length) {
                    int[] iArr4 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr4, 0, i11);
                    iArr3 = iArr4;
                }
                i7 = i11 + 1;
                if (z5) {
                    i12 = -i12;
                }
                iArr3[i11] = i12;
                if (charAt == ',') {
                    i10 += 2;
                    charAt3 = charAt(this.bp + i6);
                } else {
                    if (charAt == ']') {
                        charAt2 = charAt(this.bp + i6);
                        i8 = i10 + 2;
                        break;
                    }
                    charAt3 = charAt;
                    i10 = i6;
                }
                i11 = i7;
                iArr2 = iArr;
            }
            int[] iArr5 = iArr2;
            this.matchStat = -1;
            return iArr5;
        }
        i8 = length + 3;
        charAt2 = charAt(this.bp + i10);
        iArr = null;
        i7 = 0;
        if (i7 != iArr3.length) {
            int[] iArr6 = new int[i7];
            System.arraycopy(iArr3, 0, iArr6, 0, i7);
            iArr3 = iArr6;
        }
        if (charAt2 == ',') {
            this.bp += i8 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        }
        if (charAt2 != '}') {
            this.matchStat = -1;
            return iArr;
        }
        char charAt4 = charAt(this.bp + i8);
        if (charAt4 == ',') {
            this.token = 16;
            this.bp += i8;
            next();
        } else if (charAt4 == ']') {
            this.token = 15;
            this.bp += i8;
            next();
        } else if (charAt4 == '}') {
            this.token = 13;
            this.bp += i8;
            next();
        } else {
            if (charAt4 != 26) {
                this.matchStat = -1;
                return iArr;
            }
            this.bp += i8;
            this.token = 20;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return iArr3;
    }

    public final void scanHex() {
        char next;
        if (this.ch != 'x') {
            throw new JSONException("illegal state. " + this.ch);
        }
        next();
        if (this.ch != '\'') {
            throw new JSONException("illegal state. " + this.ch);
        }
        this.np = this.bp;
        next();
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.sp++;
            }
        }
        if (next == '\'') {
            this.sp++;
            next();
            this.token = 26;
        } else {
            throw new JSONException("illegal state. " + next);
        }
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
            return;
        }
        if ("new".equals(stringVal)) {
            this.token = 9;
            return;
        }
        if ("true".equals(stringVal)) {
            this.token = 6;
            return;
        }
        if ("false".equals(stringVal)) {
            this.token = 7;
            return;
        }
        if ("undefined".equals(stringVal)) {
            this.token = 23;
            return;
        }
        if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    public final void scanNullOrNew() {
        if (this.ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c6 = this.ch;
        if (c6 != 'u') {
            if (c6 != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c7 = this.ch;
            if (c7 != ' ' && c7 != ',' && c7 != '}' && c7 != ']' && c7 != '\n' && c7 != '\r' && c7 != '\t' && c7 != 26 && c7 != '\f' && c7 != '\b') {
                throw new JSONException("scan new error");
            }
            this.token = 9;
            return;
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c8 = this.ch;
        if (c8 != ' ' && c8 != ',' && c8 != '}' && c8 != ']' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != 26 && c8 != '\f' && c8 != '\b') {
            throw new JSONException("scan null error");
        }
        this.token = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanNumber() {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0127, code lost:
    
        if (r1 != r18) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0129, code lost:
    
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0136, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0137, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0139, code lost:
    
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scanStringArray(java.util.Collection<java.lang.String> r17, char r18) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringArray(java.util.Collection, char):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i6 = this.ch;
        if (i6 < zArr.length && !zArr[i6]) {
            throw new JSONException("illegal identifier : " + this.ch + info());
        }
        boolean[] zArr2 = IOUtils.identifierFlags;
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i6 = (i6 * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && i6 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
            return null;
        }
        return symbolTable == null ? subString(this.np, this.sp) : addSymbol(this.np, this.sp, i6, symbolTable);
    }

    public final void scanTrue() {
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c6 = this.ch;
        if (c6 != ' ' && c6 != ',' && c6 != '}' && c6 != ']' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != 26 && c6 != '\f' && c6 != '\b' && c6 != ':' && c6 != '/') {
            throw new JSONException("scan true error");
        }
        this.token = 6;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i6) {
        this.token = i6;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c6 = this.ch;
            if (c6 > '/') {
                return;
            }
            if (c6 == ' ' || c6 == '\r' || c6 == '\n' || c6 == '\t' || c6 == '\f' || c6 == '\b') {
                next();
            } else if (c6 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    public JSONLexerBase(int i6) {
        this.stringDefaultValue = null;
        this.features = i6;
        if ((i6 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) && (charAt = numberString.charAt(0)) > '0' && charAt <= '9') {
            throw new JSONException("float overflow : " + numberString);
        }
        return parseFloat;
    }

    public final boolean isEnabled(int i6, int i7) {
        return ((this.features & i7) == 0 && (i6 & i7) == 0) ? false : true;
    }

    public final boolean matchField(char[] cArr) {
        if (!charArrayCompare(cArr)) {
            return false;
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i6 = this.bp + 3;
            this.bp = i6;
            this.ch = charAt(i6);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c6) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c6);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    protected void skipComment() {
        char c6;
        next();
        char c7 = this.ch;
        if (c7 == '/') {
            do {
                next();
                c6 = this.ch;
                if (c6 == '\n') {
                    next();
                    return;
                }
            } while (c6 != 26);
            return;
        }
        if (c7 == '*') {
            next();
            while (true) {
                char c8 = this.ch;
                if (c8 != 26) {
                    if (c8 == '*') {
                        next();
                        if (this.ch == '/') {
                            next();
                            return;
                        }
                    } else {
                        next();
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c6) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            char next = next();
            if (next == c6) {
                this.token = 4;
                if (!z5) {
                    int i7 = this.np;
                    addSymbol = addSymbol(i7 == -1 ? 0 : i7 + 1, this.sp, i6, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i6);
                }
                this.sp = 0;
                next();
                return addSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z5) {
                    int i8 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i8 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i8 <= length) {
                            i8 = length;
                        }
                        char[] cArr2 = new char[i8];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z5 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i6 = (i6 * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i6 = (i6 * 31) + 92;
                            putChar('\\');
                        } else if (next2 == 'b') {
                            i6 = (i6 * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i6 = (i6 * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i6 = (i6 * 31) + 13;
                                putChar(StringUtil.CARRIAGE_RETURN);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i6 = (i6 * 31) + 47;
                                        putChar('/');
                                        break;
                                    case '0':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i6 = (i6 * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i6 = (i6 * 31) + parseInt;
                                                putChar((char) parseInt);
                                                break;
                                            case 'v':
                                                i6 = (i6 * 31) + 11;
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.ch = next3;
                                char next4 = next();
                                this.ch = next4;
                                int[] iArr = digits;
                                char c7 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i6 = (i6 * 31) + c7;
                                putChar(c7);
                            }
                        }
                    }
                    i6 = (i6 * 31) + 12;
                    putChar('\f');
                } else {
                    i6 = (i6 * 31) + 39;
                    putChar('\'');
                }
            } else {
                i6 = (i6 * 31) + next;
                if (!z5) {
                    this.sp++;
                } else {
                    int i9 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i9 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i9 + 1;
                        cArr3[i9] = next;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i6) {
        this.sp = 0;
        while (true) {
            if (i6 == 2) {
                char c6 = this.ch;
                if (c6 >= '0' && c6 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c6 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c6 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c6 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i6 == 4) {
                char c7 = this.ch;
                if (c7 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                }
                if (c7 >= '0' && c7 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c7 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c7 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i6 == 12) {
                char c8 = this.ch;
                if (c8 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c8 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i6 != 18) {
                if (i6 != 20) {
                    switch (i6) {
                        case 14:
                            char c9 = this.ch;
                            if (c9 != '[') {
                                if (c9 == '{') {
                                    this.token = 12;
                                    next();
                                    break;
                                }
                            } else {
                                this.token = 14;
                                next();
                                break;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                break;
                            }
                            break;
                        case 16:
                            char c10 = this.ch;
                            if (c10 != ',') {
                                if (c10 != '}') {
                                    if (c10 != ']') {
                                        if (c10 == 26) {
                                            this.token = 20;
                                            break;
                                        }
                                    } else {
                                        this.token = 15;
                                        next();
                                        break;
                                    }
                                } else {
                                    this.token = 13;
                                    next();
                                    break;
                                }
                            } else {
                                this.token = 16;
                                next();
                                break;
                            }
                            break;
                    }
                    return;
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c11 = this.ch;
            if (c11 != ' ' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c6) {
        this.matchStat = 0;
        char charAt = charAt(this.bp);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                if (charAt(this.bp + 4) == c6) {
                    int i6 = this.bp + 5;
                    this.bp = i6;
                    this.ch = charAt(i6);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int i7 = this.bp + 1;
        int indexOf = indexOf('\"', i7);
        if (indexOf != -1) {
            String subString = subString(this.bp + 1, indexOf - i7);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i8 = 0;
                    for (int i9 = indexOf - 1; i9 >= 0 && charAt(i9) == '\\'; i9--) {
                        i8++;
                    }
                    if (i8 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i10 = indexOf - i7;
                subString = readString(sub_chars(this.bp + 1, i10), i10);
            }
            int i11 = this.bp;
            int i12 = indexOf - (i11 + 1);
            int i13 = i12 + 2;
            int i14 = i12 + 3;
            if (charAt(i11 + i13) == c6) {
                int i15 = this.bp + i14;
                this.bp = i15;
                this.ch = charAt(i15);
                this.matchStat = 3;
                return subString;
            }
            this.matchStat = -1;
            return subString;
        }
        throw new JSONException("unclosed str");
    }
}
