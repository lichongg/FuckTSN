package com.bytedance.sdk.component.cw.xt.j.g;

import javax.security.auth.x500.X500Principal;

/* loaded from: D:\Downloads\app\classes4.dex */
final class r {
    private char[] ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f26182j;

    /* renamed from: m, reason: collision with root package name */
    private int f26183m;

    /* renamed from: r, reason: collision with root package name */
    private int f26184r;
    private int up;
    private final int xt;

    private String j() {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        char c6;
        int i11;
        int i12;
        char c7;
        char c8;
        while (true) {
            i6 = this.cw;
            i7 = this.xt;
            if (i6 >= i7 || this.ae[i6] != ' ') {
                break;
            }
            this.cw = i6 + 1;
        }
        if (i6 == i7) {
            return null;
        }
        this.f26184r = i6;
        this.cw = i6 + 1;
        while (true) {
            i8 = this.cw;
            i9 = this.xt;
            if (i8 >= i9 || (c8 = this.ae[i8]) == '=' || c8 == ' ') {
                break;
            }
            this.cw = i8 + 1;
        }
        if (i8 >= i9) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f26182j);
        }
        this.up = i8;
        if (this.ae[i8] == ' ') {
            while (true) {
                i11 = this.cw;
                i12 = this.xt;
                if (i11 >= i12 || (c7 = this.ae[i11]) == '=' || c7 != ' ') {
                    break;
                }
                this.cw = i11 + 1;
            }
            if (this.ae[i11] != '=' || i11 == i12) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f26182j);
            }
        }
        do {
            i10 = this.cw + 1;
            this.cw = i10;
            if (i10 >= this.xt) {
                break;
            }
        } while (this.ae[i10] == ' ');
        int i13 = this.up;
        int i14 = this.f26184r;
        if (i13 - i14 > 4) {
            char[] cArr = this.ae;
            if (cArr[i14 + 3] == '.' && (((c6 = cArr[i14]) == 'O' || c6 == 'o') && ((cArr[i14 + 1] == 'I' || cArr[i14 + 1] == 'i') && (cArr[i14 + 2] == 'D' || cArr[i14 + 2] == 'd')))) {
                this.f26184r = i14 + 4;
            }
        }
        char[] cArr2 = this.ae;
        int i15 = this.f26184r;
        return new String(cArr2, i15, i13 - i15);
    }

    private String cw() {
        int i6;
        char[] cArr;
        char c6;
        int i7 = this.cw;
        if (i7 + 4 >= this.xt) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f26182j);
        }
        this.f26184r = i7;
        this.cw = i7 + 1;
        while (true) {
            i6 = this.cw;
            if (i6 == this.xt || (c6 = (cArr = this.ae)[i6]) == '+' || c6 == ',' || c6 == ';') {
                break;
            }
            if (c6 == ' ') {
                this.up = i6;
                this.cw = i6 + 1;
                while (true) {
                    int i8 = this.cw;
                    if (i8 >= this.xt || this.ae[i8] != ' ') {
                        break;
                    }
                    this.cw = i8 + 1;
                }
            } else {
                if (c6 >= 'A' && c6 <= 'F') {
                    cArr[i6] = (char) (c6 + ' ');
                }
                this.cw = i6 + 1;
            }
        }
        this.up = i6;
        int i9 = this.up;
        int i10 = this.f26184r;
        int i11 = i9 - i10;
        if (i11 < 5 || (i11 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f26182j);
        }
        int i12 = i11 / 2;
        byte[] bArr = new byte[i12];
        int i13 = i10 + 1;
        for (int i14 = 0; i14 < i12; i14++) {
            bArr[i14] = (byte) j(i13);
            i13 += 2;
        }
        return new String(this.ae, this.f26184r, i11);
    }

    private char m() {
        int i6;
        int i7;
        int j6 = j(this.cw);
        this.cw++;
        if (j6 < 128) {
            return (char) j6;
        }
        if (j6 < 192 || j6 > 247) {
            return '?';
        }
        if (j6 <= 223) {
            i6 = j6 & 31;
            i7 = 1;
        } else if (j6 <= 239) {
            i6 = j6 & 15;
            i7 = 2;
        } else {
            i6 = j6 & 7;
            i7 = 3;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = this.cw;
            int i10 = i9 + 1;
            this.cw = i10;
            if (i10 == this.xt || this.ae[i10] != '\\') {
                return '?';
            }
            int i11 = i9 + 2;
            this.cw = i11;
            int j7 = j(i11);
            this.cw++;
            if ((j7 & 192) != 128) {
                return '?';
            }
            i6 = (i6 << 6) + (j7 & 63);
        }
        return (char) i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f26183m - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String r() {
        /*
            r8 = this;
            int r0 = r8.cw
            r8.f26184r = r0
            r8.up = r0
        L6:
            int r0 = r8.cw
            int r1 = r8.xt
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.ae
            int r2 = r8.f26184r
            int r3 = r8.up
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.ae
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.up
            int r4 = r3 + 1
            r8.up = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.cw = r0
            goto L6
        L3e:
            int r0 = r8.up
            int r2 = r0 + 1
            r8.up = r2
            char r2 = r8.up()
            r1[r0] = r2
            int r0 = r8.cw
            int r0 = r0 + 1
            r8.cw = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f26184r
            int r3 = r8.up
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.up
            r8.f26183m = r2
            int r0 = r0 + 1
            r8.cw = r0
            int r0 = r2 + 1
            r8.up = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.cw
            int r1 = r8.xt
            if (r0 >= r1) goto L83
            char[] r2 = r8.ae
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.up
            int r7 = r1 + 1
            r8.up = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.cw = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.ae
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.ae
            int r2 = r8.f26184r
            int r3 = r8.f26183m
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.cw.xt.j.g.r.r():java.lang.String");
    }

    private char up() {
        int i6 = this.cw + 1;
        this.cw = i6;
        if (i6 == this.xt) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f26182j);
        }
        char c6 = this.ae[i6];
        if (c6 == ' ' || c6 == '%' || c6 == '\\' || c6 == '_' || c6 == '\"' || c6 == '#') {
            return c6;
        }
        switch (c6) {
            case '*':
            case '+':
            case ',':
                return c6;
            default:
                switch (c6) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c6;
                    default:
                        return m();
                }
        }
    }

    private String xt() {
        int i6 = this.cw + 1;
        this.cw = i6;
        this.f26184r = i6;
        this.up = i6;
        while (true) {
            int i7 = this.cw;
            if (i7 == this.xt) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f26182j);
            }
            char[] cArr = this.ae;
            char c6 = cArr[i7];
            if (c6 == '\"') {
                this.cw = i7 + 1;
                while (true) {
                    int i8 = this.cw;
                    if (i8 >= this.xt || this.ae[i8] != ' ') {
                        break;
                    }
                    this.cw = i8 + 1;
                }
                char[] cArr2 = this.ae;
                int i9 = this.f26184r;
                return new String(cArr2, i9, this.up - i9);
            }
            if (c6 == '\\') {
                cArr[this.up] = up();
            } else {
                cArr[this.up] = c6;
            }
            this.cw++;
            this.up++;
        }
    }

    r(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f26182j = name;
        this.xt = name.length();
    }

    private int j(int i6) {
        int i7;
        int i8;
        int i9 = i6 + 1;
        if (i9 < this.xt) {
            char[] cArr = this.ae;
            char c6 = cArr[i6];
            if (c6 >= '0' && c6 <= '9') {
                i7 = c6 - '0';
            } else if (c6 >= 'a' && c6 <= 'f') {
                i7 = c6 - 'W';
            } else {
                if (c6 < 'A' || c6 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f26182j);
                }
                i7 = c6 - '7';
            }
            char c7 = cArr[i9];
            if (c7 >= '0' && c7 <= '9') {
                i8 = c7 - '0';
            } else if (c7 >= 'a' && c7 <= 'f') {
                i8 = c7 - 'W';
            } else {
                if (c7 < 'A' || c7 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f26182j);
                }
                i8 = c7 - '7';
            }
            return (i7 << 4) + i8;
        }
        throw new IllegalStateException("Malformed DN: " + this.f26182j);
    }

    public String j(String str) {
        String xt;
        this.cw = 0;
        this.f26184r = 0;
        this.up = 0;
        this.f26183m = 0;
        this.ae = this.f26182j.toCharArray();
        String j6 = j();
        if (j6 == null) {
            return null;
        }
        do {
            int i6 = this.cw;
            if (i6 == this.xt) {
                return null;
            }
            char c6 = this.ae[i6];
            if (c6 == '\"') {
                xt = xt();
            } else if (c6 == '#') {
                xt = cw();
            } else if (c6 != '+' && c6 != ',' && c6 != ';') {
                xt = r();
            } else {
                xt = "";
            }
            if (str.equalsIgnoreCase(j6)) {
                return xt;
            }
            int i7 = this.cw;
            if (i7 >= this.xt) {
                return null;
            }
            char c7 = this.ae[i7];
            if (c7 != ',' && c7 != ';' && c7 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f26182j);
            }
            this.cw = i7 + 1;
            j6 = j();
        } while (j6 != null);
        throw new IllegalStateException("Malformed DN: " + this.f26182j);
    }
}
