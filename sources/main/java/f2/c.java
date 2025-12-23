package f2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f43008a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43009b;

    /* renamed from: c, reason: collision with root package name */
    private int f43010c;

    /* renamed from: d, reason: collision with root package name */
    private int f43011d;

    /* renamed from: e, reason: collision with root package name */
    private int f43012e;

    /* renamed from: f, reason: collision with root package name */
    private int f43013f;

    /* renamed from: g, reason: collision with root package name */
    private char[] f43014g;

    public String c(String str) {
        this.f43010c = 0;
        this.f43011d = 0;
        this.f43012e = 0;
        this.f43013f = 0;
        this.f43014g = this.f43008a.toCharArray();
        String h6 = h();
        if (h6 == null) {
            return null;
        }
        do {
            int i6 = this.f43010c;
            if (i6 == this.f43009b) {
                return null;
            }
            char c6 = this.f43014g[i6];
            String b6 = c6 != '\"' ? c6 != '#' ? (c6 == '+' || c6 == ',' || c6 == ';') ? "" : b() : g() : i();
            if (str.equalsIgnoreCase(h6)) {
                return b6;
            }
            int i7 = this.f43010c;
            if (i7 >= this.f43009b) {
                return null;
            }
            char c7 = this.f43014g[i7];
            if (c7 != ',' && c7 != ';' && c7 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f43008a);
            }
            this.f43010c = i7 + 1;
            h6 = h();
        } while (h6 != null);
        throw new IllegalStateException("Malformed DN: " + this.f43008a);
    }

    public List<String> e(String str) {
        this.f43010c = 0;
        this.f43011d = 0;
        this.f43012e = 0;
        this.f43013f = 0;
        this.f43014g = this.f43008a.toCharArray();
        List<String> list = Collections.EMPTY_LIST;
        String h6 = h();
        if (h6 == null) {
            return list;
        }
        do {
            int i6 = this.f43010c;
            if (i6 >= this.f43009b) {
                return list;
            }
            char c6 = this.f43014g[i6];
            String b6 = c6 != '\"' ? c6 != '#' ? (c6 == '+' || c6 == ',' || c6 == ';') ? "" : b() : g() : i();
            if (str.equalsIgnoreCase(h6)) {
                if (list.isEmpty()) {
                    list = new ArrayList<>();
                }
                list.add(b6);
            }
            int i7 = this.f43010c;
            if (i7 >= this.f43009b) {
                return list;
            }
            char c7 = this.f43014g[i7];
            if (c7 != ',' && c7 != ';' && c7 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f43008a);
            }
            this.f43010c = i7 + 1;
            h6 = h();
        } while (h6 != null);
        throw new IllegalStateException("Malformed DN: " + this.f43008a);
    }

    private int a(int i6) {
        int i7;
        int i8;
        int i9 = i6 + 1;
        if (i9 >= this.f43009b) {
            throw new IllegalStateException("Malformed DN: " + this.f43008a);
        }
        char[] cArr = this.f43014g;
        char c6 = cArr[i6];
        if (c6 >= '0' && c6 <= '9') {
            i7 = c6 - '0';
        } else if (c6 >= 'a' && c6 <= 'f') {
            i7 = c6 - 'W';
        } else {
            if (c6 < 'A' || c6 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f43008a);
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
                throw new IllegalStateException("Malformed DN: " + this.f43008a);
            }
            i8 = c7 - '7';
        }
        return (i7 << 4) + i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f43013f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b() {
        /*
            r8 = this;
            int r0 = r8.f43010c
            r8.f43011d = r0
            r8.f43012e = r0
        L6:
            int r0 = r8.f43010c
            int r1 = r8.f43009b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f43014g
            int r2 = r8.f43011d
            int r3 = r8.f43012e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f43014g
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
            int r3 = r8.f43012e
            int r4 = r3 + 1
            r8.f43012e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f43010c = r0
            goto L6
        L3e:
            int r0 = r8.f43012e
            int r2 = r0 + 1
            r8.f43012e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f43010c
            int r0 = r0 + 1
            r8.f43010c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f43011d
            int r3 = r8.f43012e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f43012e
            r8.f43013f = r2
            int r0 = r0 + 1
            r8.f43010c = r0
            int r0 = r2 + 1
            r8.f43012e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f43010c
            int r1 = r8.f43009b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f43014g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f43012e
            int r7 = r1 + 1
            r8.f43012e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f43010c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f43014g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f43014g
            int r2 = r8.f43011d
            int r3 = r8.f43013f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.b():java.lang.String");
    }

    private char d() {
        int i6 = this.f43010c + 1;
        this.f43010c = i6;
        if (i6 == this.f43009b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f43008a);
        }
        char c6 = this.f43014g[i6];
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
                        return f();
                }
        }
    }

    private char f() {
        int i6;
        int i7;
        int a6 = a(this.f43010c);
        this.f43010c++;
        if (a6 < 128) {
            return (char) a6;
        }
        if (a6 < 192 || a6 > 247) {
            return '?';
        }
        if (a6 <= 223) {
            i6 = a6 & 31;
            i7 = 1;
        } else if (a6 <= 239) {
            i6 = a6 & 15;
            i7 = 2;
        } else {
            i6 = a6 & 7;
            i7 = 3;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = this.f43010c;
            int i10 = i9 + 1;
            this.f43010c = i10;
            if (i10 == this.f43009b || this.f43014g[i10] != '\\') {
                return '?';
            }
            int i11 = i9 + 2;
            this.f43010c = i11;
            int a7 = a(i11);
            this.f43010c++;
            if ((a7 & 192) != 128) {
                return '?';
            }
            i6 = (i6 << 6) + (a7 & 63);
        }
        return (char) i6;
    }

    private String g() {
        int i6;
        char[] cArr;
        char c6;
        int i7 = this.f43010c;
        if (i7 + 4 >= this.f43009b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f43008a);
        }
        this.f43011d = i7;
        this.f43010c = i7 + 1;
        while (true) {
            i6 = this.f43010c;
            if (i6 == this.f43009b || (c6 = (cArr = this.f43014g)[i6]) == '+' || c6 == ',' || c6 == ';') {
                break;
            }
            if (c6 == ' ') {
                this.f43012e = i6;
                this.f43010c = i6 + 1;
                while (true) {
                    int i8 = this.f43010c;
                    if (i8 >= this.f43009b || this.f43014g[i8] != ' ') {
                        break;
                    }
                    this.f43010c = i8 + 1;
                }
            } else {
                if (c6 >= 'A' && c6 <= 'F') {
                    cArr[i6] = (char) (c6 + ' ');
                }
                this.f43010c = i6 + 1;
            }
        }
        this.f43012e = i6;
        int i9 = this.f43012e;
        int i10 = this.f43011d;
        int i11 = i9 - i10;
        if (i11 < 5 || (i11 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f43008a);
        }
        int i12 = i11 / 2;
        byte[] bArr = new byte[i12];
        int i13 = i10 + 1;
        for (int i14 = 0; i14 < i12; i14++) {
            bArr[i14] = (byte) a(i13);
            i13 += 2;
        }
        return new String(this.f43014g, this.f43011d, i11);
    }

    private String h() {
        int i6;
        int i7;
        int i8;
        int i9;
        char c6;
        char c7;
        char c8;
        int i10;
        int i11;
        char c9;
        char c10;
        while (true) {
            i6 = this.f43010c;
            i7 = this.f43009b;
            if (i6 >= i7 || this.f43014g[i6] != ' ') {
                break;
            }
            this.f43010c = i6 + 1;
        }
        if (i6 == i7) {
            return null;
        }
        this.f43011d = i6;
        this.f43010c = i6 + 1;
        while (true) {
            i8 = this.f43010c;
            i9 = this.f43009b;
            if (i8 >= i9 || (c10 = this.f43014g[i8]) == '=' || c10 == ' ') {
                break;
            }
            this.f43010c = i8 + 1;
        }
        if (i8 >= i9) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f43008a);
        }
        this.f43012e = i8;
        if (this.f43014g[i8] == ' ') {
            while (true) {
                i10 = this.f43010c;
                i11 = this.f43009b;
                if (i10 >= i11 || (c9 = this.f43014g[i10]) == '=' || c9 != ' ') {
                    break;
                }
                this.f43010c = i10 + 1;
            }
            if (this.f43014g[i10] != '=' || i10 == i11) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f43008a);
            }
        }
        this.f43010c++;
        while (true) {
            int i12 = this.f43010c;
            if (i12 >= this.f43009b || this.f43014g[i12] != ' ') {
                break;
            }
            this.f43010c = i12 + 1;
        }
        int i13 = this.f43012e;
        int i14 = this.f43011d;
        if (i13 - i14 > 4) {
            char[] cArr = this.f43014g;
            if (cArr[i14 + 3] == '.' && (((c6 = cArr[i14]) == 'O' || c6 == 'o') && (((c7 = cArr[i14 + 1]) == 'I' || c7 == 'i') && ((c8 = cArr[i14 + 2]) == 'D' || c8 == 'd')))) {
                this.f43011d = i14 + 4;
            }
        }
        char[] cArr2 = this.f43014g;
        int i15 = this.f43011d;
        return new String(cArr2, i15, i13 - i15);
    }

    private String i() {
        int i6 = this.f43010c + 1;
        this.f43010c = i6;
        this.f43011d = i6;
        this.f43012e = i6;
        while (true) {
            int i7 = this.f43010c;
            if (i7 == this.f43009b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f43008a);
            }
            char[] cArr = this.f43014g;
            char c6 = cArr[i7];
            if (c6 == '\"') {
                this.f43010c = i7 + 1;
                while (true) {
                    int i8 = this.f43010c;
                    if (i8 >= this.f43009b || this.f43014g[i8] != ' ') {
                        break;
                    }
                    this.f43010c = i8 + 1;
                }
                char[] cArr2 = this.f43014g;
                int i9 = this.f43011d;
                return new String(cArr2, i9, this.f43012e - i9);
            }
            if (c6 == '\\') {
                cArr[this.f43012e] = d();
            } else {
                cArr[this.f43012e] = c6;
            }
            this.f43010c++;
            this.f43012e++;
        }
    }

    public c(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f43008a = name;
        this.f43009b = name.length();
    }
}
