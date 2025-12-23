package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 1;

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i6 = this.pos - 1;
        this.pos = i6;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i6 + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            return;
        }
        int i7 = 0;
        while (true) {
            char[] cArr2 = NON_EXECUTE_PREFIX;
            if (i7 >= cArr2.length) {
                this.pos += cArr2.length;
                return;
            } else if (this.buffer[this.pos + i7] != cArr2[i7]) {
                return;
            } else {
                i7++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        checkLenient();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L4e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.checkLenient()
            goto L5c
        L4e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r0.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.pos
            int r2 = r2 + r1
            r6.pos = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L51
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.checkLenient()
        L4b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L51:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i6 = 0;
        do {
            int i7 = this.peeked;
            if (i7 == 0) {
                i7 = doPeek();
            }
            if (i7 == 3) {
                push(1);
            } else if (i7 == 1) {
                push(3);
            } else {
                if (i7 == 4) {
                    this.stackSize--;
                } else if (i7 == 2) {
                    this.stackSize--;
                } else {
                    if (i7 == 14 || i7 == 10) {
                        skipUnquotedValue();
                    } else if (i7 == 8 || i7 == 12) {
                        skipQuotedValue('\'');
                    } else if (i7 == 9 || i7 == 13) {
                        skipQuotedValue('\"');
                    } else if (i7 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                i6--;
                this.peeked = 0;
            }
            i6++;
            this.peeked = 0;
        } while (i6 != 0);
        int[] iArr = this.pathIndices;
        int i8 = this.stackSize;
        int i9 = i8 - 1;
        iArr[i9] = iArr[i9] + 1;
        this.pathNames[i8 - 1] = "null";
    }

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i6 = jsonReader.peeked;
                if (i6 == 0) {
                    i6 = jsonReader.doPeek();
                }
                if (i6 == 13) {
                    jsonReader.peeked = 9;
                    return;
                }
                if (i6 == 12) {
                    jsonReader.peeked = 8;
                    return;
                }
                if (i6 == 14) {
                    jsonReader.peeked = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
            }
        };
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private boolean fillBuffer(int i6) throws IOException {
        int i7;
        int i8;
        char[] cArr = this.buffer;
        int i9 = this.lineStart;
        int i10 = this.pos;
        this.lineStart = i9 - i10;
        int i11 = this.limit;
        if (i11 != i10) {
            int i12 = i11 - i10;
            this.limit = i12;
            System.arraycopy(cArr, i10, cArr, 0, i12);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i13 = this.limit;
            int read = reader.read(cArr, i13, cArr.length - i13);
            if (read == -1) {
                return false;
            }
            i7 = this.limit + read;
            this.limit = i7;
            if (this.lineNumber == 0 && (i8 = this.lineStart) == 0 && i7 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i8 + 1;
                i6++;
            }
        } while (i7 < i6);
        return true;
    }

    private boolean isLiteral(char c6) throws IOException {
        if (c6 == '\t' || c6 == '\n' || c6 == '\f' || c6 == '\r' || c6 == ' ') {
            return false;
        }
        if (c6 != '#') {
            if (c6 == ',') {
                return false;
            }
            if (c6 != '/' && c6 != '=') {
                if (c6 == '{' || c6 == '}' || c6 == ':') {
                    return false;
                }
                if (c6 != ';') {
                    switch (c6) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z5) throws IOException {
        char c6;
        char[] cArr = this.buffer;
        int i6 = this.pos;
        int i7 = this.limit;
        while (true) {
            if (i6 == i7) {
                this.pos = i6;
                if (!fillBuffer(1)) {
                    if (!z5) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i6 = this.pos;
                i7 = this.limit;
            }
            int i8 = i6 + 1;
            c6 = cArr[i6];
            if (c6 == '\n') {
                this.lineNumber++;
                this.lineStart = i8;
            } else if (c6 != ' ' && c6 != '\r' && c6 != '\t') {
                if (c6 == '/') {
                    this.pos = i8;
                    if (i8 == i7) {
                        this.pos = i6;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            break;
                        }
                    }
                    checkLenient();
                    int i9 = this.pos;
                    char c7 = cArr[i9];
                    if (c7 == '*') {
                        this.pos = i9 + 1;
                        if (!skipTo("*/")) {
                            throw syntaxError("Unterminated comment");
                        }
                        i6 = this.pos + 2;
                        i7 = this.limit;
                    } else {
                        if (c7 != '/') {
                            break;
                        }
                        this.pos = i9 + 1;
                        skipToEndOfLine();
                        i6 = this.pos;
                        i7 = this.limit;
                    }
                } else {
                    if (c6 != '#') {
                        this.pos = i8;
                        return c6;
                    }
                    this.pos = i8;
                    checkLenient();
                    skipToEndOfLine();
                    i6 = this.pos;
                    i7 = this.limit;
                }
            }
            i6 = i8;
        }
        return c6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String nextQuotedValue(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.buffer
            r1 = 0
        L3:
            int r2 = r9.pos
            int r3 = r9.limit
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.pos = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.readEscapeCharacter()
            r1.append(r2)
            int r2 = r9.pos
            int r3 = r9.limit
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.lineNumber
            int r2 = r2 + r6
            r9.lineNumber = r2
            r9.lineStart = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.pos = r2
            boolean r2 = r9.fillBuffer(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.syntaxError(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i6;
        char c6 = this.buffer[this.pos];
        if (c6 == 't' || c6 == 'T') {
            str = "true";
            str2 = "TRUE";
            i6 = 5;
        } else if (c6 == 'f' || c6 == 'F') {
            str = "false";
            str2 = "FALSE";
            i6 = 6;
        } else {
            if (c6 != 'n' && c6 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i6 = 7;
        }
        int length = str.length();
        for (int i7 = 1; i7 < length; i7++) {
            if (this.pos + i7 >= this.limit && !fillBuffer(i7 + 1)) {
                return 0;
            }
            char c7 = this.buffer[this.pos + i7];
            if (c7 != str.charAt(i7) && c7 != str2.charAt(i7)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i6;
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0094, code lost:
    
        if (r9 != 2) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0096, code lost:
    
        if (r10 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009c, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009e, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a2, code lost:
    
        if (r11 != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a4, code lost:
    
        if (r13 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a6, code lost:
    
        if (r13 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a9, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00aa, code lost:
    
        r19.peekedLong = r11;
        r19.pos += r8;
        r19.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b6, code lost:
    
        if (r9 == 2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b9, code lost:
    
        if (r9 == 4) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        if (r9 != 7) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bf, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
    
        r19.peekedNumberLength = r8;
        r19.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c6, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0092, code lost:
    
        if (isLiteral(r14) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00c7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int peekNumber() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.peekNumber():int");
    }

    private void push(int i6) {
        int i7 = this.stackSize;
        int[] iArr = this.stack;
        if (i7 == iArr.length) {
            int[] iArr2 = new int[i7 * 2];
            int[] iArr3 = new int[i7 * 2];
            String[] strArr = new String[i7 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr2;
            this.pathIndices = iArr3;
            this.pathNames = strArr;
        }
        int[] iArr4 = this.stack;
        int i8 = this.stackSize;
        this.stackSize = i8 + 1;
        iArr4[i8] = i6;
    }

    private char readEscapeCharacter() throws IOException {
        int i6;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i7 = this.pos;
        int i8 = i7 + 1;
        this.pos = i8;
        char c6 = cArr[i7];
        if (c6 == '\n') {
            this.lineNumber++;
            this.lineStart = i8;
            return c6;
        }
        if (c6 == '\"' || c6 == '\'' || c6 == '/' || c6 == '\\') {
            return c6;
        }
        if (c6 == 'b') {
            return '\b';
        }
        if (c6 == 'f') {
            return '\f';
        }
        if (c6 == 'n') {
            return '\n';
        }
        if (c6 == 'r') {
            return StringUtil.CARRIAGE_RETURN;
        }
        if (c6 == 't') {
            return '\t';
        }
        if (c6 != 'u') {
            throw syntaxError("Invalid escape sequence");
        }
        if (i7 + 5 > this.limit && !fillBuffer(4)) {
            throw syntaxError("Unterminated escape sequence");
        }
        int i9 = this.pos;
        int i10 = i9 + 4;
        char c7 = 0;
        while (i9 < i10) {
            char c8 = this.buffer[i9];
            char c9 = (char) (c7 << 4);
            if (c8 >= '0' && c8 <= '9') {
                i6 = c8 - '0';
            } else if (c8 >= 'a' && c8 <= 'f') {
                i6 = c8 - 'W';
            } else {
                if (c8 < 'A' || c8 > 'F') {
                    throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                }
                i6 = c8 - '7';
            }
            c7 = (char) (c9 + i6);
            i9++;
        }
        this.pos += 4;
        return c7;
    }

    private void skipQuotedValue(char c6) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i6 = this.pos;
            int i7 = this.limit;
            while (i6 < i7) {
                int i8 = i6 + 1;
                char c7 = cArr[i6];
                if (c7 == c6) {
                    this.pos = i8;
                    return;
                }
                if (c7 == '\\') {
                    this.pos = i8;
                    readEscapeCharacter();
                    i6 = this.pos;
                    i7 = this.limit;
                } else {
                    if (c7 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i8;
                    }
                    i6 = i8;
                }
            }
            this.pos = i6;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private void skipToEndOfLine() throws IOException {
        char c6;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i6 = this.pos;
            int i7 = i6 + 1;
            this.pos = i7;
            c6 = cArr[i6];
            if (c6 == '\n') {
                this.lineNumber++;
                this.lineStart = i7;
                return;
            }
        } while (c6 != '\r');
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 1) {
            push(3);
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i6 = this.stackSize;
        int i7 = iArr[i6 - 1];
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 != 59) {
                    if (nextNonWhitespace2 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (nextNonWhitespace != 59) {
                        if (nextNonWhitespace != 125) {
                            throw syntaxError("Unterminated object");
                        }
                        this.peeked = 2;
                        return 2;
                    }
                    checkLenient();
                }
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 == 34) {
                    this.peeked = 13;
                    return 13;
                }
                if (nextNonWhitespace3 == 39) {
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                }
                if (nextNonWhitespace3 == 125) {
                    if (i7 == 5) {
                        throw syntaxError("Expected name");
                    }
                    this.peeked = 2;
                    return 2;
                }
                checkLenient();
                this.pos--;
                if (!isLiteral((char) nextNonWhitespace3)) {
                    throw syntaxError("Expected name");
                }
                this.peeked = 14;
                return 14;
            }
            if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int nextNonWhitespace4 = nextNonWhitespace(true);
                if (nextNonWhitespace4 != 58) {
                    if (nextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i8 = this.pos;
                        if (cArr[i8] == '>') {
                            this.pos = i8 + 1;
                        }
                    }
                }
            } else if (i7 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i7 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i7 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        }
        if (nextNonWhitespace5 == 39) {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
        if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
            if (nextNonWhitespace5 == 91) {
                this.peeked = 3;
                return 3;
            }
            if (nextNonWhitespace5 != 93) {
                if (nextNonWhitespace5 == 123) {
                    this.peeked = 1;
                    return 1;
                }
                this.pos--;
                int peekKeyword = peekKeyword();
                if (peekKeyword != 0) {
                    return peekKeyword;
                }
                int peekNumber = peekNumber();
                if (peekNumber != 0) {
                    return peekNumber;
                }
                if (!isLiteral(this.buffer[this.pos])) {
                    throw syntaxError("Expected value");
                }
                checkLenient();
                this.peeked = 10;
                return 10;
            }
            if (i7 == 1) {
                this.peeked = 4;
                return 4;
            }
        }
        if (i7 != 1 && i7 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    }

    public void endArray() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
        int i7 = this.stackSize;
        this.stackSize = i7 - 1;
        int[] iArr = this.pathIndices;
        int i8 = i7 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.peeked = 0;
    }

    public void endObject() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
        int i7 = this.stackSize;
        int i8 = i7 - 1;
        this.stackSize = i8;
        this.pathNames[i8] = null;
        int[] iArr = this.pathIndices;
        int i9 = i7 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.peeked = 0;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(v0.f47959c);
        int i6 = this.stackSize;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = this.stack[i7];
            if (i8 == 1 || i8 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i7]);
                sb.append(']');
            } else if (i8 == 3 || i8 == 4 || i8 == 5) {
                sb.append('.');
                String str = this.pathNames[i7];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        return (i6 == 2 || i6 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (i6 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i8 = this.stackSize - 1;
            iArr2[i8] = iArr2[i8] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.peekedLong;
        }
        if (i6 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i6 == 8 || i6 == 9) {
            this.peekedString = nextQuotedValue(i6 == 8 ? '\'' : '\"');
        } else if (i6 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i6 != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i8 = this.stackSize - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 15) {
            long j6 = this.peekedLong;
            int i7 = (int) j6;
            if (j6 == i7) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i8 = this.stackSize - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i6 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i6 != 8 && i6 != 9 && i6 != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            }
            if (i6 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i6 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i9 = this.stackSize - 1;
                iArr2[i9] = iArr2[i9] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i10 = (int) parseDouble;
        if (i10 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr3[i11] = iArr3[i11] + 1;
        return i10;
    }

    public long nextLong() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.peekedLong;
        }
        if (i6 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i6 != 8 && i6 != 9 && i6 != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            }
            if (i6 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i6 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i8 = this.stackSize - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j6 = (long) parseDouble;
        if (j6 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j6;
    }

    public String nextName() throws IOException {
        String nextQuotedValue;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else if (i6 == 12) {
            nextQuotedValue = nextQuotedValue('\'');
        } else {
            if (i6 != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            nextQuotedValue = nextQuotedValue('\"');
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr[i7] = iArr[i7] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        if (i6 == 10) {
            str = nextUnquotedValue();
        } else if (i6 == 8) {
            str = nextQuotedValue('\'');
        } else if (i6 == 9) {
            str = nextQuotedValue('\"');
        } else if (i6 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i6 == 15) {
            str = Long.toString(this.peekedLong);
        } else {
            if (i6 != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i7 = this.stackSize - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i6 = this.peeked;
        if (i6 == 0) {
            i6 = doPeek();
        }
        switch (i6) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z5) {
        this.lenient = z5;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i6 = this.pos;
            if (cArr[i6] == '\n') {
                this.lineNumber++;
                this.lineStart = i6 + 1;
            } else {
                for (int i7 = 0; i7 < length; i7++) {
                    if (this.buffer[this.pos + i7] != str.charAt(i7)) {
                        break;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }
}
