package com.hp.hpl.sparta;

import com.huawei.hms.framework.common.ContainerUtils;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class l implements o {
    private static final char[] A;
    private static final char[] B;
    private static final char[] C;
    private static final char[] D;
    private static final char[] E;
    private static final char[] F;
    private static final char[] G;
    private static final char[] H;
    private static final char[] I;
    private static final char[] J;
    private static final char[] K;
    private static final char[] L;
    private static final char[] M;
    private static final char[] N;
    private static final char[] O;
    private static final char[] P;
    private static final char[] Q;
    private static final char[] R;
    private static final int S = 255;
    public static final int T = 100;

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f32830u = true;

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f32831v = false;

    /* renamed from: x, reason: collision with root package name */
    private static final int f32833x = 128;

    /* renamed from: z, reason: collision with root package name */
    private static final char[] f32835z;

    /* renamed from: c, reason: collision with root package name */
    private String f32836c;

    /* renamed from: d, reason: collision with root package name */
    private String f32837d;

    /* renamed from: e, reason: collision with root package name */
    private final Reader f32838e;

    /* renamed from: f, reason: collision with root package name */
    private final Hashtable f32839f;

    /* renamed from: g, reason: collision with root package name */
    private final Hashtable f32840g;

    /* renamed from: h, reason: collision with root package name */
    private final n f32841h;

    /* renamed from: i, reason: collision with root package name */
    private final String f32842i;

    /* renamed from: j, reason: collision with root package name */
    private int f32843j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f32844k;

    /* renamed from: l, reason: collision with root package name */
    private final int f32845l;

    /* renamed from: m, reason: collision with root package name */
    private final char[] f32846m;

    /* renamed from: n, reason: collision with root package name */
    private int f32847n;

    /* renamed from: o, reason: collision with root package name */
    private int f32848o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f32849p;

    /* renamed from: q, reason: collision with root package name */
    private final char[] f32850q;

    /* renamed from: r, reason: collision with root package name */
    private int f32851r;

    /* renamed from: s, reason: collision with root package name */
    private final b f32852s;

    /* renamed from: t, reason: collision with root package name */
    private final m f32853t;

    /* renamed from: w, reason: collision with root package name */
    private static final char[] f32832w = {'.', '-', '_', ':'};

    /* renamed from: y, reason: collision with root package name */
    private static final boolean[] f32834y = new boolean[128];

    static {
        for (char c6 = 0; c6 < 128; c6 = (char) (c6 + 1)) {
            f32834y[c6] = x(c6);
        }
        f32835z = "<!--".toCharArray();
        A = "-->".toCharArray();
        B = "<?".toCharArray();
        C = "?>".toCharArray();
        D = "<!DOCTYPE".toCharArray();
        E = "<?xml".toCharArray();
        F = "encoding".toCharArray();
        G = "version".toCharArray();
        H = new char[]{'_', '.', ':', '-'};
        I = "<!".toCharArray();
        J = "&#".toCharArray();
        K = "<!ENTITY".toCharArray();
        L = "NDATA".toCharArray();
        M = "SYSTEM".toCharArray();
        N = "PUBLIC".toCharArray();
        O = "<![CDATA[".toCharArray();
        P = "]]>".toCharArray();
        Q = "/>".toCharArray();
        R = "</".toCharArray();
    }

    public l(String str, char[] cArr, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        this(str, null, cArr, nVar, str2, mVar);
    }

    private final boolean C(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f32848o - this.f32847n < length && c(length) <= 0) {
            this.f32843j = -1;
            return false;
        }
        char[] cArr2 = this.f32846m;
        int i6 = this.f32848o;
        this.f32843j = cArr2[i6 - 1];
        if (i6 - this.f32847n < length) {
            return false;
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (this.f32846m[this.f32847n + i7] != cArr[i7]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r4.f32853t.characters(r4.f32850q, 0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h0() throws com.hp.hpl.sparta.ParseException, java.io.IOException {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r2 = 60
            boolean r2 = r4.h(r2)
            if (r2 != 0) goto L48
            r2 = 38
            boolean r2 = r4.h(r2)
            if (r2 != 0) goto L48
            char[] r2 = com.hp.hpl.sparta.l.P
            boolean r2 = r4.C(r2)
            if (r2 != 0) goto L48
            char[] r2 = r4.f32850q
            char r3 = r4.J()
            r2[r1] = r3
            char[] r2 = r4.f32850q
            char r2 = r2[r1]
            r3 = 13
            if (r2 != r3) goto L3a
            char r2 = r4.F()
            r3 = 10
            if (r2 != r3) goto L3a
            char[] r2 = r4.f32850q
            char r3 = r4.J()
            r2[r1] = r3
        L3a:
            int r1 = r1 + 1
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L2
            com.hp.hpl.sparta.m r1 = r4.f32853t
            char[] r3 = r4.f32850q
            r1.characters(r3, r0, r2)
            goto L1
        L48:
            if (r1 <= 0) goto L51
            com.hp.hpl.sparta.m r2 = r4.f32853t
            char[] r3 = r4.f32850q
            r2.characters(r3, r0, r1)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.l.h0():void");
    }

    private final void m0(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f32848o - this.f32847n < length && c(length) <= 0) {
            this.f32843j = -1;
            throw new ParseException(this, "end of XML file", cArr);
        }
        char[] cArr2 = this.f32846m;
        int i6 = this.f32848o;
        this.f32843j = cArr2[i6 - 1];
        if (i6 - this.f32847n < length) {
            throw new ParseException(this, "end of XML file", cArr);
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (this.f32846m[this.f32847n + i7] != cArr[i7]) {
                throw new ParseException(this, new String(this.f32846m, this.f32847n, length), cArr);
            }
        }
        this.f32847n += length;
    }

    private static final boolean t(char c6, char[] cArr) {
        for (char c7 : cArr) {
            if (c6 == c7) {
                return true;
            }
        }
        return false;
    }

    public l(String str, Reader reader, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, null, nVar, str2, mVar);
    }

    private final boolean A() throws ParseException, IOException {
        return h(v0.f47960d);
    }

    private final boolean B() throws ParseException, IOException {
        return j(' ', '\t', StringUtil.CARRIAGE_RETURN, '\n');
    }

    private boolean E() throws ParseException, IOException {
        return C(E);
    }

    private final char F() throws ParseException, IOException {
        if (this.f32847n < this.f32848o || a() != -1) {
            return this.f32846m[this.f32847n];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private String G() throws ParseException, IOException {
        char K2 = K('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!h(K2)) {
            if (A()) {
                stringBuffer.append(k0());
            } else {
                stringBuffer.append(J());
            }
        }
        M(K2);
        return stringBuffer.toString();
    }

    private void I() throws ParseException, IOException {
        char[] cArr;
        m0(O);
        StringBuffer stringBuffer = null;
        int i6 = 0;
        while (true) {
            cArr = P;
            if (C(cArr)) {
                break;
            }
            if (i6 >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i6);
                    stringBuffer.append(this.f32850q, 0, i6);
                } else {
                    stringBuffer.append(this.f32850q, 0, i6);
                }
                i6 = 0;
            }
            this.f32850q[i6] = J();
            i6++;
        }
        m0(cArr);
        if (stringBuffer == null) {
            this.f32853t.characters(this.f32850q, 0, i6);
            return;
        }
        stringBuffer.append(this.f32850q, 0, i6);
        char[] charArray = stringBuffer.toString().toCharArray();
        this.f32853t.characters(charArray, 0, charArray.length);
    }

    private final char J() throws ParseException, IOException {
        if (this.f32847n >= this.f32848o && a() == -1) {
            throw new ParseException(this, "unexpected end of expression.");
        }
        char[] cArr = this.f32846m;
        int i6 = this.f32847n;
        char c6 = cArr[i6];
        if (c6 == '\n') {
            this.f32851r++;
        }
        this.f32847n = i6 + 1;
        return c6;
    }

    private char N() throws ParseException, IOException {
        int i6;
        m0(J);
        if (h('x')) {
            J();
            i6 = 16;
        } else {
            i6 = 10;
        }
        int i7 = 0;
        while (!h(';')) {
            int i8 = i7 + 1;
            this.f32850q[i7] = J();
            if (i8 >= 255) {
                this.f32841h.b("Tmp buffer overflow on readCharRef", this.f32836c, getLineNumber());
                return ' ';
            }
            i7 = i8;
        }
        M(';');
        String str = new String(this.f32850q, 0, i7);
        try {
            return (char) Integer.parseInt(str, i6);
        } catch (NumberFormatException unused) {
            n nVar = this.f32841h;
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(str);
            sb.append("\" is not a valid ");
            sb.append(i6 == 16 ? "hexadecimal" : "decimal");
            sb.append(" number");
            nVar.b(sb.toString(), this.f32836c, getLineNumber());
            return ' ';
        }
    }

    private final void O() throws ParseException, IOException {
        m0(f32835z);
        while (true) {
            char[] cArr = A;
            if (C(cArr)) {
                m0(cArr);
                return;
            }
            J();
        }
    }

    private void R() throws ParseException, IOException {
        m0(D);
        l0();
        this.f32837d = d0();
        if (B()) {
            l0();
            if (!h(v0.f47962f) && !h('[')) {
                this.f32844k = true;
                a0();
                if (B()) {
                    l0();
                }
            }
        }
        if (h('[')) {
            J();
            while (!h(']')) {
                if (l()) {
                    Q();
                } else {
                    b0();
                }
            }
            M(']');
            if (B()) {
                l0();
            }
        }
        M(v0.f47962f);
    }

    private void S(g gVar) throws ParseException, IOException {
        m0(R);
        String d02 = d0();
        if (!d02.equals(gVar.H())) {
            this.f32841h.b("end tag (" + d02 + ") does not match begin tag (" + gVar.H() + ")", this.f32836c, getLineNumber());
        }
        if (B()) {
            l0();
        }
        M(v0.f47962f);
    }

    private final g T() throws ParseException, IOException {
        g gVar = new g();
        boolean U = U(gVar);
        this.f32853t.e(gVar);
        if (U) {
            P();
            S(gVar);
        }
        this.f32853t.a(gVar);
        return gVar;
    }

    private boolean U(g gVar) throws ParseException, IOException {
        M(v0.f47961e);
        gVar.P(d0());
        while (B()) {
            l0();
            if (!i('/', v0.f47962f)) {
                H(gVar);
            }
        }
        if (B()) {
            l0();
        }
        boolean h6 = h(v0.f47962f);
        if (h6) {
            M(v0.f47962f);
            return h6;
        }
        m0(Q);
        return h6;
    }

    private String V() throws ParseException, IOException {
        m0(F);
        Z();
        char K2 = K('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!h(K2)) {
            stringBuffer.append(J());
        }
        M(K2);
        return stringBuffer.toString();
    }

    private void W() throws ParseException, IOException {
        String a02;
        m0(K);
        l0();
        if (h('%')) {
            M('%');
            l0();
            String d02 = d0();
            l0();
            this.f32840g.put(d02, q() ? Y() : a0());
        } else {
            String d03 = d0();
            l0();
            if (q()) {
                a02 = Y();
            } else {
                if (!s()) {
                    throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
                }
                a02 = a0();
                if (B()) {
                    l0();
                }
                char[] cArr = L;
                if (C(cArr)) {
                    m0(cArr);
                    l0();
                    d0();
                }
            }
            this.f32839f.put(d03, a02);
        }
        if (B()) {
            l0();
        }
        M(v0.f47962f);
    }

    private String X() throws ParseException, IOException {
        M(v0.f47960d);
        String d02 = d0();
        String str = (String) this.f32839f.get(d02);
        if (str == null) {
            if (this.f32844k) {
                this.f32841h.b(ContainerUtils.FIELD_DELIMITER + d02 + "; not found -- possibly defined in external DTD)", this.f32836c, getLineNumber());
            } else {
                this.f32841h.b("No declaration of &" + d02 + ";", this.f32836c, getLineNumber());
            }
            str = "";
        }
        M(';');
        return str;
    }

    private final String Y() throws ParseException, IOException {
        char K2 = K('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!h(K2)) {
            if (y()) {
                stringBuffer.append(f0());
            } else if (A()) {
                stringBuffer.append(k0());
            } else {
                stringBuffer.append(J());
            }
        }
        M(K2);
        return stringBuffer.toString();
    }

    private int a() throws IOException {
        if (this.f32849p) {
            return -1;
        }
        int i6 = this.f32848o;
        char[] cArr = this.f32846m;
        if (i6 == cArr.length) {
            this.f32848o = 0;
            this.f32847n = 0;
        }
        Reader reader = this.f32838e;
        int i7 = this.f32848o;
        int read = reader.read(cArr, i7, cArr.length - i7);
        if (read <= 0) {
            this.f32849p = true;
            return -1;
        }
        this.f32848o += read;
        return read;
    }

    private String a0() throws ParseException, IOException {
        char[] cArr = M;
        if (C(cArr)) {
            m0(cArr);
        } else {
            char[] cArr2 = N;
            if (!C(cArr2)) {
                throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            }
            m0(cArr2);
            l0();
            j0();
        }
        l0();
        n0();
        return "(WARNING: external ID not read)";
    }

    private int c(int i6) throws IOException {
        int i7;
        int i8;
        if (this.f32849p) {
            return -1;
        }
        int i9 = 0;
        if (this.f32846m.length - this.f32847n < i6) {
            int i10 = 0;
            while (true) {
                i7 = this.f32847n;
                int i11 = i7 + i10;
                i8 = this.f32848o;
                if (i11 >= i8) {
                    break;
                }
                char[] cArr = this.f32846m;
                cArr[i10] = cArr[i7 + i10];
                i10++;
            }
            int i12 = i8 - i7;
            this.f32848o = i12;
            this.f32847n = 0;
            i9 = i12;
        }
        int a6 = a();
        if (a6 != -1) {
            return i9 + a6;
        }
        if (i9 == 0) {
            return -1;
        }
        return i9;
    }

    private final String d0() throws ParseException, IOException {
        this.f32850q[0] = e0();
        StringBuffer stringBuffer = null;
        int i6 = 1;
        while (w()) {
            if (i6 >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i6);
                    stringBuffer.append(this.f32850q, 0, i6);
                } else {
                    stringBuffer.append(this.f32850q, 0, i6);
                }
                i6 = 0;
            }
            this.f32850q[i6] = J();
            i6++;
        }
        if (stringBuffer == null) {
            return q.a(new String(this.f32850q, 0, i6));
        }
        stringBuffer.append(this.f32850q, 0, i6);
        return stringBuffer.toString();
    }

    private String f0() throws ParseException, IOException {
        M('%');
        String d02 = d0();
        String str = (String) this.f32840g.get(d02);
        if (str == null) {
            this.f32841h.b("No declaration of %" + d02 + ";", this.f32836c, getLineNumber());
            str = "";
        }
        M(';');
        return str;
    }

    private boolean g() throws ParseException, IOException {
        return C(O);
    }

    private final void g0() throws ParseException, IOException {
        m0(B);
        while (true) {
            char[] cArr = C;
            if (C(cArr)) {
                m0(cArr);
                return;
            }
            J();
        }
    }

    private final boolean h(char c6) throws ParseException, IOException {
        if (this.f32847n < this.f32848o || a() != -1) {
            return this.f32846m[this.f32847n] == c6;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private final boolean i(char c6, char c7) throws ParseException, IOException {
        if (this.f32847n >= this.f32848o && a() == -1) {
            return false;
        }
        char c8 = this.f32846m[this.f32847n];
        return c8 == c6 || c8 == c7;
    }

    private final boolean j(char c6, char c7, char c8, char c9) throws ParseException, IOException {
        if (this.f32847n >= this.f32848o && a() == -1) {
            return false;
        }
        char c10 = this.f32846m[this.f32847n];
        return c10 == c6 || c10 == c7 || c10 == c8 || c10 == c9;
    }

    private final boolean k() throws ParseException, IOException {
        return C(f32835z);
    }

    private final char[] k0() throws ParseException, IOException {
        return C(J) ? new char[]{N()} : X().toCharArray();
    }

    private final void l0() throws ParseException, IOException {
        L(' ', '\t', StringUtil.CARRIAGE_RETURN, '\n');
        while (j(' ', '\t', StringUtil.CARRIAGE_RETURN, '\n')) {
            J();
        }
    }

    private boolean m() throws ParseException, IOException {
        return C(D);
    }

    private boolean n() throws ParseException, IOException {
        return C(R);
    }

    private boolean o() throws ParseException, IOException {
        return C(F);
    }

    private boolean p() throws ParseException, IOException {
        return C(K);
    }

    private final boolean q() throws ParseException, IOException {
        return i('\'', '\"');
    }

    private void q0() throws ParseException, EncodingMismatchException, IOException {
        m0(E);
        o0();
        if (B()) {
            l0();
        }
        if (o()) {
            String V = V();
            if (this.f32842i != null && !V.toLowerCase().equals(this.f32842i)) {
                throw new EncodingMismatchException(this.f32836c, V, this.f32842i);
            }
        }
        while (true) {
            char[] cArr = C;
            if (C(cArr)) {
                m0(cArr);
                return;
            }
            J();
        }
    }

    private static boolean r(char c6) {
        if (c6 == 183 || c6 == 903 || c6 == 1600 || c6 == 3654 || c6 == 3782 || c6 == 12293 || c6 == 720 || c6 == 721 || c6 == 12445 || c6 == 12446) {
            return true;
        }
        switch (c6) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c6) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private boolean s() throws ParseException, IOException {
        return C(M) || C(N);
    }

    private static boolean u(char c6) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c6)) != -1;
    }

    private boolean y() throws ParseException, IOException {
        return h('%');
    }

    private final boolean z() throws ParseException, IOException {
        return C(B);
    }

    final String d() {
        return "";
    }

    int e() {
        return this.f32843j;
    }

    n f() {
        return this.f32841h;
    }

    @Override // com.hp.hpl.sparta.o
    public int getLineNumber() {
        return this.f32851r;
    }

    @Override // com.hp.hpl.sparta.o
    public String getSystemId() {
        return this.f32836c;
    }

    @Override // com.hp.hpl.sparta.o
    public String toString() {
        return this.f32836c;
    }

    public l(String str, Reader reader, char[] cArr, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        this.f32837d = null;
        Hashtable hashtable = new Hashtable();
        this.f32839f = hashtable;
        this.f32840g = new Hashtable();
        this.f32843j = -2;
        this.f32844k = false;
        this.f32845l = 1024;
        this.f32847n = 0;
        this.f32848o = 0;
        this.f32849p = false;
        this.f32850q = new char[255];
        this.f32851r = 1;
        this.f32852s = null;
        nVar = nVar == null ? o.f32854a : nVar;
        this.f32841h = nVar;
        this.f32842i = str2 == null ? null : str2.toLowerCase();
        hashtable.put("lt", "<");
        hashtable.put("gt", ">");
        hashtable.put("amp", ContainerUtils.FIELD_DELIMITER);
        hashtable.put("apos", "'");
        hashtable.put("quot", "\"");
        if (cArr != null) {
            this.f32846m = cArr;
            this.f32847n = 0;
            this.f32848o = cArr.length;
            this.f32849p = true;
            this.f32838e = null;
        } else {
            this.f32838e = reader;
            this.f32846m = new char[1024];
            a();
        }
        this.f32836c = str;
        this.f32853t = mVar;
        mVar.c(this);
        i0();
        mVar.startDocument();
        g T2 = T();
        String str3 = this.f32837d;
        if (str3 != null && !str3.equals(T2.H())) {
            nVar.b("DOCTYPE name \"" + this.f32837d + "\" not same as tag name, \"" + T2.H() + "\" of root element", this.f32836c, getLineNumber());
        }
        while (v()) {
            c0();
        }
        Reader reader2 = this.f32838e;
        if (reader2 != null) {
            reader2.close();
        }
        this.f32853t.endDocument();
    }

    private boolean D() throws ParseException, IOException {
        char F2 = F();
        if (!Character.isDigit(F2)) {
            if ('a' > F2 || F2 > 'z') {
                if (('Z' > F2 || F2 > 'Z') && !t(F2, H)) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void H(g gVar) throws ParseException, IOException {
        String d02 = d0();
        Z();
        String G2 = G();
        if (gVar.D(d02) != null) {
            this.f32841h.b("Element " + this + " contains attribute " + d02 + "more than once", this.f32836c, getLineNumber());
        }
        gVar.O(d02, G2);
    }

    private final char K(char c6, char c7) throws ParseException, IOException {
        char J2 = J();
        if (J2 != c6 && J2 != c7) {
            throw new ParseException(this, J2, new char[]{c6, c7});
        }
        return J2;
    }

    private final char L(char c6, char c7, char c8, char c9) throws ParseException, IOException {
        char J2 = J();
        if (J2 != c6 && J2 != c7 && J2 != c8 && J2 != c9) {
            throw new ParseException(this, J2, new char[]{c6, c7, c8, c9});
        }
        return J2;
    }

    private final void M(char c6) throws ParseException, IOException {
        char J2 = J();
        if (J2 == c6) {
        } else {
            throw new ParseException(this, J2, c6);
        }
    }

    private void P() throws ParseException, IOException {
        h0();
        boolean z5 = true;
        while (z5) {
            if (!n()) {
                if (A()) {
                    char[] k02 = k0();
                    this.f32853t.characters(k02, 0, k02.length);
                } else if (g()) {
                    I();
                } else if (z()) {
                    g0();
                } else if (k()) {
                    O();
                } else if (h(v0.f47961e)) {
                    T();
                }
                h0();
            }
            z5 = false;
            h0();
        }
    }

    private void Q() throws ParseException, IOException {
        if (y()) {
            f0();
        } else {
            l0();
        }
    }

    private final void Z() throws ParseException, IOException {
        if (B()) {
            l0();
        }
        M('=');
        if (B()) {
            l0();
        }
    }

    private void b0() throws ParseException, IOException {
        if (z()) {
            g0();
            return;
        }
        if (k()) {
            O();
            return;
        }
        if (p()) {
            W();
            return;
        }
        if (C(I)) {
            while (!h(v0.f47962f)) {
                if (i('\'', '\"')) {
                    char J2 = J();
                    while (!h(J2)) {
                        J();
                    }
                    M(J2);
                } else {
                    J();
                }
            }
            M(v0.f47962f);
            return;
        }
        throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
    }

    private void c0() throws ParseException, IOException {
        if (k()) {
            O();
        } else if (z()) {
            g0();
        } else {
            if (B()) {
                l0();
                return;
            }
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    private char e0() throws ParseException, IOException {
        char J2 = J();
        if (!u(J2) && J2 != '_' && J2 != ':') {
            throw new ParseException(this, J2, "letter, underscore, colon");
        }
        return J2;
    }

    private void i0() throws ParseException, EncodingMismatchException, IOException {
        if (E()) {
            q0();
        }
        while (v()) {
            c0();
        }
        if (m()) {
            R();
            while (v()) {
                c0();
            }
        }
    }

    private final void j0() throws ParseException, IOException {
        n0();
    }

    private boolean l() throws ParseException, IOException {
        if (!y() && !B()) {
            return false;
        }
        return true;
    }

    private final void n0() throws ParseException, IOException {
        char J2 = J();
        while (F() != J2) {
            J();
        }
        M(J2);
    }

    private void o0() throws ParseException, IOException {
        l0();
        m0(G);
        Z();
        char K2 = K('\'', '\"');
        p0();
        M(K2);
    }

    private void p0() throws ParseException, IOException {
        J();
        while (D()) {
            J();
        }
    }

    private boolean v() throws ParseException, IOException {
        if (!k() && !z() && !B()) {
            return false;
        }
        return true;
    }

    private boolean w() throws ParseException, IOException {
        char F2 = F();
        if (F2 < 128) {
            return f32834y[F2];
        }
        return x(F2);
    }

    private static boolean x(char c6) {
        if (!Character.isDigit(c6) && !u(c6) && !t(c6, f32832w) && !r(c6)) {
            return false;
        }
        return true;
    }
}
