package javax.mail.internet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class MailDateParser {
    int index = 0;
    char[] orig;

    int getIndex() {
        return this.index;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int parseAlphaTimeZone() throws java.text.ParseException {
        /*
            r9 = this;
            java.lang.String r0 = "Bad Alpha TimeZone"
            char[] r1 = r9.orig     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            int r2 = r9.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            int r3 = r2 + 1
            r9.index = r3     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            char r4 = r1[r2]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            r5 = 116(0x74, float:1.63E-43)
            r6 = 84
            r7 = 1
            r8 = 0
            switch(r4) {
                case 67: goto L5c;
                case 69: goto L59;
                case 71: goto L38;
                case 77: goto L35;
                case 80: goto L32;
                case 85: goto L1d;
                case 99: goto L5c;
                case 101: goto L59;
                case 103: goto L38;
                case 109: goto L35;
                case 112: goto L32;
                case 117: goto L1d;
                default: goto L15;
            }     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
        L15:
            java.text.ParseException r1 = new java.text.ParseException     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            int r2 = r9.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            r1.<init>(r0, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            throw r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
        L1d:
            int r2 = r2 + 2
            r9.index = r2     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            char r2 = r1[r3]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            if (r2 == r6) goto L30
            if (r2 != r5) goto L28
            goto L30
        L28:
            java.text.ParseException r1 = new java.text.ParseException     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            int r2 = r9.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            r1.<init>(r0, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            throw r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
        L30:
            r7 = 0
            goto L5e
        L32:
            r8 = 480(0x1e0, float:6.73E-43)
            goto L5e
        L35:
            r8 = 420(0x1a4, float:5.89E-43)
            goto L5e
        L38:
            int r4 = r2 + 2
            r9.index = r4     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            char r3 = r1[r3]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            r7 = 77
            if (r3 == r7) goto L46
            r7 = 109(0x6d, float:1.53E-43)
            if (r3 != r7) goto L51
        L46:
            int r2 = r2 + 3
            r9.index = r2     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            char r2 = r1[r4]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            if (r2 == r6) goto L30
            if (r2 != r5) goto L51
            goto L30
        L51:
            java.text.ParseException r1 = new java.text.ParseException     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            int r2 = r9.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            r1.<init>(r0, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
            throw r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> La3
        L59:
            r8 = 300(0x12c, float:4.2E-43)
            goto L5e
        L5c:
            r8 = 360(0x168, float:5.04E-43)
        L5e:
            if (r7 == 0) goto La2
            int r2 = r9.index
            int r3 = r2 + 1
            r9.index = r3
            char r4 = r1[r2]
            r7 = 83
            if (r4 == r7) goto L8f
            r7 = 115(0x73, float:1.61E-43)
            if (r4 != r7) goto L71
            goto L8f
        L71:
            r7 = 68
            if (r4 == r7) goto L79
            r7 = 100
            if (r4 != r7) goto La2
        L79:
            int r2 = r2 + 2
            r9.index = r2
            char r1 = r1[r3]
            if (r1 == r6) goto L8c
            if (r1 == r5) goto L84
            goto L8c
        L84:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r9.index
            r1.<init>(r0, r2)
            throw r1
        L8c:
            int r8 = r8 + (-60)
            return r8
        L8f:
            int r2 = r2 + 2
            r9.index = r2
            char r1 = r1[r3]
            if (r1 == r6) goto La2
            if (r1 != r5) goto L9a
            goto La2
        L9a:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r9.index
            r1.<init>(r0, r2)
            throw r1
        La2:
            return r8
        La3:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r9.index
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseAlphaTimeZone():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x00d4, code lost:
    
        if (r3 == 'u') goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e A[Catch: ArrayIndexOutOfBoundsException -> 0x015a, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x015a, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:30:0x004e, B:33:0x0058, B:39:0x0069, B:43:0x0077, B:49:0x0088, B:52:0x0092, B:64:0x012c, B:72:0x013f, B:78:0x014f, B:82:0x00a9, B:85:0x00b3, B:90:0x00c0, B:97:0x00d6, B:109:0x00ed, B:114:0x00f9, B:117:0x0103, B:123:0x0113, B:126:0x011d), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069 A[Catch: ArrayIndexOutOfBoundsException -> 0x015a, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x015a, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:30:0x004e, B:33:0x0058, B:39:0x0069, B:43:0x0077, B:49:0x0088, B:52:0x0092, B:64:0x012c, B:72:0x013f, B:78:0x014f, B:82:0x00a9, B:85:0x00b3, B:90:0x00c0, B:97:0x00d6, B:109:0x00ed, B:114:0x00f9, B:117:0x0103, B:123:0x0113, B:126:0x011d), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088 A[Catch: ArrayIndexOutOfBoundsException -> 0x015a, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x015a, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:30:0x004e, B:33:0x0058, B:39:0x0069, B:43:0x0077, B:49:0x0088, B:52:0x0092, B:64:0x012c, B:72:0x013f, B:78:0x014f, B:82:0x00a9, B:85:0x00b3, B:90:0x00c0, B:97:0x00d6, B:109:0x00ed, B:114:0x00f9, B:117:0x0103, B:123:0x0113, B:126:0x011d), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int parseMonth() throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseMonth():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0020, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int parseNumber() throws java.text.ParseException {
        /*
            r7 = this;
            char[] r0 = r7.orig
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L5:
            int r3 = r7.index
            java.lang.String r4 = "No Number found"
            if (r3 < r0) goto L16
            if (r1 == 0) goto Le
            goto L20
        Le:
            java.text.ParseException r0 = new java.text.ParseException
            int r1 = r7.index
            r0.<init>(r4, r1)
            throw r0
        L16:
            char[] r5 = r7.orig
            char r5 = r5[r3]
            r6 = 1
            switch(r5) {
                case 48: goto L55;
                case 49: goto L51;
                case 50: goto L4c;
                case 51: goto L47;
                case 52: goto L42;
                case 53: goto L3d;
                case 54: goto L38;
                case 55: goto L33;
                case 56: goto L2e;
                case 57: goto L29;
                default: goto L1e;
            }
        L1e:
            if (r1 == 0) goto L21
        L20:
            return r2
        L21:
            java.text.ParseException r0 = new java.text.ParseException
            int r1 = r7.index
            r0.<init>(r4, r1)
            throw r0
        L29:
            int r2 = r2 * 10
            int r2 = r2 + 9
            goto L57
        L2e:
            int r2 = r2 * 10
            int r2 = r2 + 8
            goto L57
        L33:
            int r2 = r2 * 10
            int r2 = r2 + 7
            goto L57
        L38:
            int r2 = r2 * 10
            int r2 = r2 + 6
            goto L57
        L3d:
            int r2 = r2 * 10
            int r2 = r2 + 5
            goto L57
        L42:
            int r2 = r2 * 10
            int r2 = r2 + 4
            goto L57
        L47:
            int r2 = r2 * 10
            int r2 = r2 + 3
            goto L57
        L4c:
            int r2 = r2 * 10
            int r2 = r2 + 2
            goto L57
        L51:
            int r2 = r2 * 10
            int r2 = r2 + r6
            goto L57
        L55:
            int r2 = r2 * 10
        L57:
            int r3 = r3 + 1
            r7.index = r3
            r1 = 1
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseNumber():int");
    }

    public int parseNumericTimeZone() throws java.text.ParseException {
        boolean z5;
        char[] cArr = this.orig;
        int i6 = this.index;
        this.index = i6 + 1;
        char c6 = cArr[i6];
        if (c6 == '+') {
            z5 = true;
        } else {
            if (c6 != '-') {
                throw new java.text.ParseException("Bad Numeric TimeZone", this.index);
            }
            z5 = false;
        }
        int parseNumber = parseNumber();
        int i7 = ((parseNumber / 100) * 60) + (parseNumber % 100);
        return z5 ? -i7 : i7;
    }

    public int parseTimeZone() throws java.text.ParseException {
        int i6 = this.index;
        char[] cArr = this.orig;
        if (i6 >= cArr.length) {
            throw new java.text.ParseException("No more characters", this.index);
        }
        char c6 = cArr[i6];
        return (c6 == '+' || c6 == '-') ? parseNumericTimeZone() : parseAlphaTimeZone();
    }

    public int peekChar() throws java.text.ParseException {
        int i6 = this.index;
        char[] cArr = this.orig;
        if (i6 < cArr.length) {
            return cArr[i6];
        }
        throw new java.text.ParseException("No more characters", this.index);
    }

    public void skipChar(char c6) throws java.text.ParseException {
        int i6 = this.index;
        char[] cArr = this.orig;
        if (i6 >= cArr.length) {
            throw new java.text.ParseException("No more characters", this.index);
        }
        if (cArr[i6] != c6) {
            throw new java.text.ParseException("Wrong char", this.index);
        }
        this.index = i6 + 1;
    }

    public boolean skipIfChar(char c6) throws java.text.ParseException {
        int i6 = this.index;
        char[] cArr = this.orig;
        if (i6 >= cArr.length) {
            throw new java.text.ParseException("No more characters", this.index);
        }
        if (cArr[i6] != c6) {
            return false;
        }
        this.index = i6 + 1;
        return true;
    }

    public void skipUntilNumber() throws java.text.ParseException {
        while (true) {
            try {
                char[] cArr = this.orig;
                int i6 = this.index;
                switch (cArr[i6]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return;
                    default:
                        this.index = i6 + 1;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new java.text.ParseException("No Number Found", this.index);
            }
            throw new java.text.ParseException("No Number Found", this.index);
        }
    }

    public void skipWhiteSpace() {
        int length = this.orig.length;
        while (true) {
            int i6 = this.index;
            if (i6 >= length) {
                return;
            }
            char c6 = this.orig[i6];
            if (c6 != '\t' && c6 != '\n' && c6 != '\r' && c6 != ' ') {
                return;
            } else {
                this.index = i6 + 1;
            }
        }
    }

    public MailDateParser(char[] cArr) {
        this.orig = cArr;
    }
}
