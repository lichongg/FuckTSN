package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    static boolean charArrayCompare(String str, int i6, char[] cArr) {
        int length = cArr.length;
        if (length + i6 > str.length()) {
            return false;
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (cArr[i7] != str.charAt(i6 + i7)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] cArr) {
        char charAt;
        boolean z5;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == 't') {
            int i7 = length + 2;
            if (charAt(i6) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i8 = length + 3;
            if (charAt(i7) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i9 = length + 4;
            if (charAt(i8) != 'e') {
                this.matchStat = -1;
                return false;
            }
            this.bp = i9;
            charAt = charAt(i9);
            z5 = true;
        } else {
            if (charAt2 != 'f') {
                this.matchStat = -1;
                return false;
            }
            int i10 = length + 2;
            if (charAt(i6) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i11 = length + 3;
            if (charAt(i10) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i12 = length + 4;
            if (charAt(i11) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i13 = length + 5;
            if (charAt(i12) != 'e') {
                this.matchStat = -1;
                return false;
            }
            this.bp = i13;
            charAt = charAt(i13);
            z5 = false;
        }
        while (charAt != ',') {
            if (charAt == '}') {
                int i14 = this.bp + 1;
                this.bp = i14;
                char charAt3 = charAt(i14);
                while (true) {
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i15 = this.bp + 1;
                        this.bp = i15;
                        this.ch = charAt(i15);
                        break;
                    }
                    if (charAt3 == ']') {
                        this.token = 15;
                        int i16 = this.bp + 1;
                        this.bp = i16;
                        this.ch = charAt(i16);
                        break;
                    }
                    if (charAt3 == '}') {
                        this.token = 13;
                        int i17 = this.bp + 1;
                        this.bp = i17;
                        this.ch = charAt(i17);
                        break;
                    }
                    if (charAt3 == 26) {
                        this.token = 20;
                        break;
                    }
                    if (!JSONLexerBase.isWhitespace(charAt3)) {
                        this.matchStat = -1;
                        return false;
                    }
                    int i18 = this.bp + 1;
                    this.bp = i18;
                    charAt3 = charAt(i18);
                }
                this.matchStat = 4;
                return z5;
            }
            if (!JSONLexerBase.isWhitespace(charAt)) {
                this.matchStat = -1;
                return false;
            }
            int i19 = this.bp + 1;
            this.bp = i19;
            charAt = charAt(i19);
        }
        int i20 = this.bp + 1;
        this.bp = i20;
        this.ch = charAt(i20);
        this.matchStat = 3;
        this.token = 16;
        return z5;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        boolean z5;
        int i6;
        char charAt;
        this.matchStat = 0;
        int i7 = this.bp;
        char c6 = this.ch;
        if (!charArrayCompare(this.text, i7, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i8 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '-') {
            charAt2 = charAt(i8);
            i8 = length + 2;
            z5 = true;
        } else {
            z5 = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i9 = charAt2 - '0';
        while (true) {
            i6 = i8 + 1;
            charAt = charAt(i8);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i9 = (i9 * 10) + (charAt - '0');
            i8 = i6;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i9 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (charAt != ',' && charAt != '}') {
            if (!JSONLexerBase.isWhitespace(charAt)) {
                this.matchStat = -1;
                return 0;
            }
            char charAt3 = charAt(i6);
            i6++;
            charAt = charAt3;
        }
        this.bp = i6 - 1;
        if (charAt == ',') {
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            if (z5) {
                return -i9;
            }
        } else {
            if (charAt == '}') {
                this.bp = i6;
                char charAt4 = charAt(i6);
                while (true) {
                    if (charAt4 == ',') {
                        this.token = 16;
                        int i10 = this.bp + 1;
                        this.bp = i10;
                        this.ch = charAt(i10);
                        break;
                    }
                    if (charAt4 == ']') {
                        this.token = 15;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        this.ch = charAt(i11);
                        break;
                    }
                    if (charAt4 == '}') {
                        this.token = 13;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        this.ch = charAt(i12);
                        break;
                    }
                    if (charAt4 == 26) {
                        this.token = 20;
                        break;
                    }
                    if (!JSONLexerBase.isWhitespace(charAt4)) {
                        this.bp = i7;
                        this.ch = c6;
                        this.matchStat = -1;
                        return 0;
                    }
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    charAt4 = charAt(i13);
                }
                this.matchStat = 4;
            }
            if (z5) {
                return -i9;
            }
        }
        return i9;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i6 = this.bp;
        char c6 = this.ch;
        if (!charArrayCompare(this.text, i6, cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = this.bp + cArr.length;
        int i7 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i7);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String subString = subString(i7, indexOf - i7);
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
            int i10 = this.bp;
            int length2 = indexOf - ((cArr.length + i10) + 1);
            subString = JSONLexerBase.readString(sub_chars(i10 + cArr.length + 1, length2), length2);
        }
        char charAt = charAt(indexOf + 1);
        while (charAt != ',' && charAt != '}') {
            if (!JSONLexerBase.isWhitespace(charAt)) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            char charAt2 = charAt(indexOf + 2);
            indexOf++;
            charAt = charAt2;
        }
        this.bp = indexOf + 1;
        this.ch = charAt;
        if (charAt == ',') {
            int i11 = indexOf + 2;
            this.bp = i11;
            this.ch = charAt(i11);
            this.matchStat = 3;
            return subString;
        }
        int i12 = indexOf + 2;
        this.bp = i12;
        char charAt3 = charAt(i12);
        if (charAt3 == ',') {
            this.token = 16;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = charAt(i13);
        } else if (charAt3 == ']') {
            this.token = 15;
            int i14 = this.bp + 1;
            this.bp = i14;
            this.ch = charAt(i14);
        } else if (charAt3 == '}') {
            this.token = 13;
            int i15 = this.bp + 1;
            this.bp = i15;
            this.ch = charAt(i15);
        } else {
            if (charAt3 != 26) {
                this.bp = i6;
                this.ch = c6;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return subString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00c1, code lost:
    
        if (r14 != ']') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c7, code lost:
    
        if (r15.size() != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c9, code lost:
    
        r14 = r1 + 1;
        r1 = charAt(r1);
        r1 = r14;
        r14 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00d3, code lost:
    
        r13.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00d5, code lost:
    
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r14, java.lang.Class<?> r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j6 = -2128831035;
        while (true) {
            int i7 = i6 + 1;
            char charAt = charAt(i6);
            if (charAt == '\"') {
                this.bp = i7;
                char charAt2 = charAt(i7);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            this.ch = charAt(i8);
                        } else if (current == ']') {
                            this.token = 15;
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            this.ch = charAt(i9);
                        } else if (current == '}') {
                            this.token = 13;
                            int i10 = this.bp + 1;
                            this.bp = i10;
                            this.ch = charAt(i10);
                        } else {
                            if (current != 26) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            this.token = 20;
                        }
                        this.matchStat = 4;
                        return j6;
                    }
                    if (!JSONLexerBase.isWhitespace(charAt2)) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i11 = this.bp + 1;
                    this.bp = i11;
                    charAt2 = charAt(i11);
                }
                int i12 = this.bp + 1;
                this.bp = i12;
                this.ch = charAt(i12);
                this.matchStat = 3;
                return j6;
            }
            if (i7 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j6 = (j6 ^ charAt) * 16777619;
            i6 = i7;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c6) {
        int i6;
        char charAt;
        this.matchStat = 0;
        int i7 = this.bp;
        int i8 = i7 + 1;
        char charAt2 = charAt(i7);
        boolean z5 = charAt2 == '-';
        if (z5) {
            charAt2 = charAt(i8);
            i8 = i7 + 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i9 = charAt2 - '0';
        while (true) {
            i6 = i8 + 1;
            charAt = charAt(i8);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i9 = (i9 * 10) + (charAt - '0');
            i8 = i6;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i9 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (true) {
            if (charAt == c6) {
                this.bp = i6;
                this.ch = charAt(i6);
                this.matchStat = 3;
                this.token = 16;
                if (z5) {
                    return -i9;
                }
            } else if (JSONLexerBase.isWhitespace(charAt)) {
                charAt = charAt(i6);
                i6++;
            } else {
                this.matchStat = -1;
                if (z5) {
                    return -i9;
                }
            }
        }
        return i9;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c6) {
        int i6;
        char charAt;
        this.matchStat = 0;
        int i7 = this.bp;
        int i8 = i7 + 1;
        char charAt2 = charAt(i7);
        boolean z5 = charAt2 == '-';
        if (z5) {
            charAt2 = charAt(i8);
            i8 = i7 + 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j6 = charAt2 - '0';
        while (true) {
            i6 = i8 + 1;
            charAt = charAt(i8);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j6 = (j6 * 10) + (charAt - '0');
            i8 = i6;
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
            if (!JSONLexerBase.isWhitespace(charAt)) {
                this.matchStat = -1;
                return j6;
            }
            int i9 = i6 + 1;
            char charAt3 = charAt(i6);
            i6 = i9;
            charAt = charAt3;
        }
        this.bp = i6;
        this.ch = charAt(i6);
        this.matchStat = 3;
        this.token = 16;
        return z5 ? -j6 : j6;
    }

    public JSONScanner(String str, int i6) {
        super(i6);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    static boolean checkDate(char c6, char c7, char c8, char c9, char c10, char c11, int i6, int i7) {
        if ((c6 == '1' || c6 == '2') && c7 >= '0' && c7 <= '9' && c8 >= '0' && c8 <= '9' && c9 >= '0' && c9 <= '9') {
            if (c10 == '0') {
                if (c11 < '1' || c11 > '9') {
                    return false;
                }
            } else if (c10 != '1' || (c11 != '0' && c11 != '1' && c11 != '2')) {
                return false;
            }
            if (i6 == 48) {
                return i7 >= 49 && i7 <= 57;
            }
            if (i6 != 49 && i6 != 50) {
                return i6 == 51 && (i7 == 48 || i7 == 49);
            }
            if (i7 >= 48 && i7 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
    
        if (r6 <= '4') goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 54
            r6 = 53
            if (r7 < r2) goto L2d
            if (r7 > r6) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r5) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r6) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r5) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    private void setCalendar(char c6, char c7, char c8, char c9, char c10, char c11, char c12, char c13) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0'));
        this.calendar.set(2, (((c10 - '0') * 10) + (c11 - '0')) - 1);
        this.calendar.set(5, ((c12 - '0') * 10) + (c13 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i6, int i7, int i8, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i6, i7, i8);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i6, char[] cArr, int i7, int i8) {
        this.text.getChars(i6, i8 + i6, cArr, i7);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        }
        int i6 = this.np + 1;
        int i7 = this.sp;
        if (i7 % 2 != 0) {
            throw new JSONException("illegal state. " + i7);
        }
        int i8 = i7 / 2;
        byte[] bArr = new byte[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = (i9 * 2) + i6;
            char charAt = this.text.charAt(i10);
            char charAt2 = this.text.charAt(i10 + 1);
            char c6 = '7';
            int i11 = charAt - (charAt <= '9' ? '0' : '7');
            if (charAt2 <= '9') {
                c6 = '0';
            }
            bArr[i9] = (byte) ((i11 << 4) | (charAt2 - c6));
        }
        return bArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i6) {
        return i6 >= this.len ? JSONLexer.EOI : this.text.charAt(i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i6, int i7, char[] cArr) {
        this.text.getChars(i6, i7 + i6, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i6 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i6--;
        }
        int i7 = this.np;
        char[] cArr = this.sbuf;
        if (i6 < cArr.length) {
            this.text.getChars(i7, i7 + i6, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i6);
        }
        char[] cArr2 = new char[i6];
        this.text.getChars(i7, i6 + i7, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c6, int i6) {
        return this.text.indexOf(c6, i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i6 = this.bp;
        int i7 = this.len;
        return i6 == i7 || (this.ch == 26 && i6 + 1 == i7);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i6 = this.bp + 1;
        this.bp = i6;
        char charAt = i6 >= this.len ? JSONLexer.EOI : this.text.charAt(i6);
        this.ch = charAt;
        return charAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i6 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i6--;
        }
        return subString(this.np, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d3, code lost:
    
        return r12;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long scanFieldLong(char[] r18) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldLong(char[]):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0249 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanISO8601DateIfMatch(boolean r38) {
        /*
            Method dump skipped, instructions count: 1528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean):boolean");
    }

    protected void setTime(char c6, char c7, char c8, char c9, char c10, char c11) {
        this.calendar.set(11, ((c6 - '0') * 10) + (c7 - '0'));
        this.calendar.set(12, ((c8 - '0') * 10) + (c9 - '0'));
        this.calendar.set(13, ((c10 - '0') * 10) + (c11 - '0'));
    }

    protected void setTimeZone(char c6, char c7, char c8) {
        int i6 = (((c7 - '0') * 10) + (c8 - '0')) * 3600000;
        if (c6 == '-') {
            i6 = -i6;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i6) {
            String[] availableIDs = TimeZone.getAvailableIDs(i6);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i6, int i7) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i6, i7 + i6);
        }
        char[] cArr = this.sbuf;
        if (i7 < cArr.length) {
            this.text.getChars(i6, i6 + i7, cArr, 0);
            return new String(this.sbuf, 0, i7);
        }
        char[] cArr2 = new char[i7];
        this.text.getChars(i6, i7 + i6, cArr2, 0);
        return new String(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i6, int i7) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i7 < cArr.length) {
                this.text.getChars(i6, i7 + i6, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i7];
        this.text.getChars(i6, i7 + i6, cArr2, 0);
        return cArr2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i6) {
        this(cArr, i6, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i6, int i7) {
        this(new String(cArr, 0, i6), i7);
    }
}
