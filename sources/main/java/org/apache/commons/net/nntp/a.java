package org.apache.commons.net.nntp;

import java.io.PrintStream;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements o {

    /* renamed from: b, reason: collision with root package name */
    private String f50863b;

    /* renamed from: c, reason: collision with root package name */
    private String f50864c;

    /* renamed from: d, reason: collision with root package name */
    private String f50865d;

    /* renamed from: e, reason: collision with root package name */
    private String f50866e;

    /* renamed from: f, reason: collision with root package name */
    private String f50867f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<String> f50868g;

    /* renamed from: i, reason: collision with root package name */
    public a f50870i;

    /* renamed from: j, reason: collision with root package name */
    public a f50871j;

    /* renamed from: h, reason: collision with root package name */
    private boolean f50869h = false;

    /* renamed from: a, reason: collision with root package name */
    private long f50862a = -1;

    private void k() {
        this.f50866e = null;
    }

    public static void s(a aVar) {
        u(aVar, 0, System.out);
    }

    public static void u(a aVar, int i6, PrintStream printStream) {
        for (int i7 = 0; i7 < i6; i7++) {
            printStream.getClass();
        }
        aVar.r();
        aVar.p();
        aVar.l();
        printStream.getClass();
        a aVar2 = aVar.f50870i;
        if (aVar2 != null) {
            t(aVar2, i6 + 1);
        }
        a aVar3 = aVar.f50871j;
        if (aVar3 != null) {
            t(aVar3, i6);
        }
    }

    public static void v(a aVar, PrintStream printStream) {
        u(aVar, 0, printStream);
    }

    @Deprecated
    public void x(int i6) {
        this.f50862a = i6;
    }

    public static void t(a aVar, int i6) {
        u(aVar, i6, System.out);
    }

    public void A(String str) {
        this.f50867f = str;
    }

    public void B(String str) {
        this.f50863b = str;
    }

    @Override // org.apache.commons.net.nntp.o
    public String a() {
        return this.f50865d;
    }

    @Override // org.apache.commons.net.nntp.o
    public o b() {
        return new a();
    }

    @Override // org.apache.commons.net.nntp.o
    public void c(o oVar) {
        this.f50871j = (a) oVar;
        k();
    }

    @Override // org.apache.commons.net.nntp.o
    public String d() {
        if (this.f50866e == null) {
            C();
        }
        return this.f50866e;
    }

    @Override // org.apache.commons.net.nntp.o
    public boolean e() {
        return this.f50869h;
    }

    @Override // org.apache.commons.net.nntp.o
    public boolean f() {
        return this.f50862a == -1;
    }

    @Override // org.apache.commons.net.nntp.o
    public void h(o oVar) {
        this.f50870i = (a) oVar;
        k();
    }

    public void j(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (this.f50868g == null) {
            this.f50868g = new ArrayList<>();
        }
        this.f50869h = true;
        for (String str2 : str.split(" ")) {
            this.f50868g.add(str2);
        }
    }

    public String l() {
        return this.f50865d;
    }

    @Deprecated
    public int m() {
        return (int) this.f50862a;
    }

    public long n() {
        return this.f50862a;
    }

    public String o() {
        return this.f50864c;
    }

    public String p() {
        return this.f50867f;
    }

    public String[] q() {
        ArrayList<String> arrayList = this.f50868g;
        return arrayList == null ? new String[0] : (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String r() {
        return this.f50863b;
    }

    public String toString() {
        return this.f50862a + " " + this.f50865d + " " + this.f50863b;
    }

    public void w(String str) {
        this.f50865d = str;
    }

    public void y(long j6) {
        this.f50862a = j6;
    }

    public void z(String str) {
        this.f50864c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void C() {
        /*
            r9 = this;
            java.lang.String r0 = r9.r()
            int r1 = r0.length()
            r2 = 0
            r3 = 0
            r4 = 0
        Lb:
            if (r3 != 0) goto Lc4
        Ld:
            r3 = 32
            if (r4 >= r1) goto L1a
            char r5 = r0.charAt(r4)
            if (r5 != r3) goto L1a
            int r4 = r4 + 1
            goto Ld
        L1a:
            int r5 = r1 + (-2)
            if (r4 >= r5) goto L97
            char r6 = r0.charAt(r4)
            r7 = 114(0x72, float:1.6E-43)
            if (r6 == r7) goto L2e
            char r6 = r0.charAt(r4)
            r7 = 82
            if (r6 != r7) goto L97
        L2e:
            int r6 = r4 + 1
            char r7 = r0.charAt(r6)
            r8 = 101(0x65, float:1.42E-43)
            if (r7 == r8) goto L40
            char r6 = r0.charAt(r6)
            r7 = 69
            if (r6 != r7) goto L97
        L40:
            int r6 = r4 + 2
            char r7 = r0.charAt(r6)
            r8 = 58
            if (r7 != r8) goto L4e
            int r4 = r4 + 3
        L4c:
            r5 = 0
            goto L98
        L4e:
            if (r4 >= r5) goto L97
            char r5 = r0.charAt(r6)
            r7 = 91
            if (r5 == r7) goto L60
            char r5 = r0.charAt(r6)
            r6 = 40
            if (r5 != r6) goto L97
        L60:
            int r5 = r4 + 3
        L62:
            if (r5 >= r1) goto L77
            char r6 = r0.charAt(r5)
            r7 = 48
            if (r6 < r7) goto L77
            char r6 = r0.charAt(r5)
            r7 = 57
            if (r6 > r7) goto L77
            int r5 = r5 + 1
            goto L62
        L77:
            int r6 = r1 + (-1)
            if (r5 >= r6) goto L97
            char r6 = r0.charAt(r5)
            r7 = 93
            if (r6 == r7) goto L8b
            char r6 = r0.charAt(r5)
            r7 = 41
            if (r6 != r7) goto L97
        L8b:
            int r6 = r5 + 1
            char r6 = r0.charAt(r6)
            if (r6 != r8) goto L97
            int r5 = r5 + 2
            r4 = r5
            goto L4c
        L97:
            r5 = 1
        L98:
            java.lang.String r6 = "(no subject)"
            java.lang.String r7 = r9.f50866e
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto La6
            java.lang.String r6 = ""
            r9.f50866e = r6
        La6:
            r6 = r1
        La7:
            if (r6 <= r4) goto Lb4
            int r7 = r6 + (-1)
            char r7 = r0.charAt(r7)
            if (r7 >= r3) goto Lb4
            int r6 = r6 + (-1)
            goto La7
        Lb4:
            if (r4 != 0) goto Lbb
            if (r6 != r1) goto Lbb
            r9.f50866e = r0
            goto Lc1
        Lbb:
            java.lang.String r3 = r0.substring(r4, r6)
            r9.f50866e = r3
        Lc1:
            r3 = r5
            goto Lb
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.nntp.a.C():void");
    }

    @Override // org.apache.commons.net.nntp.o
    public String[] g() {
        return q();
    }

    @Deprecated
    public void i(String str, String str2) {
    }
}
