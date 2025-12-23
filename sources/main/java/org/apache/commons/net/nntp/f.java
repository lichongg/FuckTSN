package org.apache.commons.net.nntp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.net.MalformedServerReplyException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends e {
    private BufferedReader V0(int i6, String str, b bVar) throws IOException {
        if (str != null) {
            if (!h.d(E0(i6, str))) {
                return null;
            }
        } else if (!h.d(D0(i6))) {
            return null;
        }
        if (bVar != null) {
            Q0(m0(), bVar);
        }
        return new org.apache.commons.net.io.d(this.f50880x);
    }

    public BufferedReader A1(long j6, b bVar) throws IOException {
        return U0(1, j6, bVar);
    }

    public BufferedReader B1(String str, b bVar) throws IOException {
        return V0(1, str, bVar);
    }

    public Reader C1() throws IOException {
        return F1(null);
    }

    @Deprecated
    public Reader D1(int i6) throws IOException {
        return z1(i6);
    }

    public Reader F1(String str) throws IOException {
        return B1(str, null);
    }

    public BufferedReader H1(long j6) throws IOException {
        return I1(j6, null);
    }

    public BufferedReader I1(long j6, b bVar) throws IOException {
        return U0(3, j6, bVar);
    }

    public BufferedReader J1(String str, b bVar) throws IOException {
        return V0(3, str, bVar);
    }

    public Reader K1() throws IOException {
        return N1(null);
    }

    @Deprecated
    public Reader L1(int i6) throws IOException {
        return H1(i6);
    }

    public Reader N1(String str) throws IOException {
        return J1(str, null);
    }

    @Deprecated
    public Reader R1(int i6) throws IOException {
        return P1(i6);
    }

    @Deprecated
    public Reader S1(int i6, int i7) throws IOException {
        return Q1(i6, i7);
    }

    @Deprecated
    public Reader V1(String str, int i6) throws IOException {
        return T1(str, i6);
    }

    @Deprecated
    public Reader W1(String str, int i6, int i7) throws IOException {
        return U1(str, i6, i7);
    }

    @Deprecated
    public boolean X1(int i6) throws IOException {
        return Z1(i6);
    }

    public boolean Z1(long j6) throws IOException {
        return a2(j6, null);
    }

    public boolean b2(String str) throws IOException {
        return c2(str, null);
    }

    public boolean c2(String str, b bVar) throws IOException {
        if (str != null) {
            if (!h.d(K0(str))) {
                return false;
            }
        } else if (!h.d(H0())) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        Q0(m0(), bVar);
        return true;
    }

    public boolean e2(b bVar) throws IOException {
        return c2(null, bVar);
    }

    public boolean g2(String str) throws IOException {
        return h2(str, null);
    }

    public boolean i2() throws IOException {
        return j2(null);
    }

    public boolean l2() throws IOException {
        return m2(null);
    }

    public BufferedReader r1(long j6) throws IOException {
        return s1(j6, null);
    }

    public BufferedReader s1(long j6, b bVar) throws IOException {
        return U0(0, j6, bVar);
    }

    public BufferedReader t1(String str, b bVar) throws IOException {
        return V0(0, str, bVar);
    }

    public Reader u1() throws IOException {
        return x1(null);
    }

    @Deprecated
    public Reader v1(int i6) throws IOException {
        return r1(i6);
    }

    public Reader x1(String str) throws IOException {
        return t1(str, null);
    }

    public BufferedReader z1(long j6) throws IOException {
        return A1(j6, null);
    }

    private void N0(b bVar, d dVar) {
        if (dVar != null) {
            dVar.f50876b = bVar.f50872a;
            dVar.f50875a = (int) bVar.f50873b;
        }
    }

    private b O0(d dVar) {
        if (dVar == null) {
            return null;
        }
        return new b();
    }

    static a P0(String str) {
        a aVar = new a();
        aVar.B(str);
        String[] split = str.split("\t");
        if (split.length > 6) {
            try {
                aVar.y(Long.parseLong(split[0]));
                aVar.B(split[1]);
                aVar.A(split[2]);
                aVar.z(split[3]);
                aVar.w(split[4]);
                aVar.j(split[5]);
            } catch (NumberFormatException unused) {
            }
        }
        return aVar;
    }

    private void Q0(String str, b bVar) throws MalformedServerReplyException {
        String[] split = str.split(" ");
        if (split.length >= 3) {
            try {
                bVar.f50873b = Long.parseLong(split[1]);
                bVar.f50872a = split[2];
                return;
            } catch (NumberFormatException unused) {
            }
        }
        throw new MalformedServerReplyException("Could not parse article pointer.\nServer reply: " + str);
    }

    private static void R0(String str, j jVar) throws MalformedServerReplyException {
        String[] split = str.split(" ");
        if (split.length >= 5) {
            try {
                jVar.a(Long.parseLong(split[1]));
                jVar.b(Long.parseLong(split[2]));
                jVar.c(Long.parseLong(split[3]));
                jVar.d(split[4]);
                jVar.e(0);
                return;
            } catch (NumberFormatException unused) {
            }
        }
        throw new MalformedServerReplyException("Could not parse newsgroup info.\nServer reply: " + str);
    }

    static j S0(String str) {
        String[] split = str.split(" ");
        if (split.length < 4) {
            return null;
        }
        j jVar = new j();
        jVar.d(split[0]);
        try {
            long parseLong = Long.parseLong(split[1]);
            long parseLong2 = Long.parseLong(split[2]);
            jVar.b(parseLong2);
            jVar.c(parseLong);
            if (parseLong2 == 0 && parseLong == 0) {
                jVar.a(0L);
            } else {
                jVar.a((parseLong - parseLong2) + 1);
            }
            char charAt = split[3].charAt(0);
            if (charAt != 'M') {
                if (charAt != 'N') {
                    if (charAt == 'Y' || charAt == 'y') {
                        jVar.e(2);
                        return jVar;
                    }
                    if (charAt != 'm') {
                        if (charAt != 'n') {
                            jVar.e(0);
                            return jVar;
                        }
                    }
                }
                jVar.e(3);
                return jVar;
            }
            jVar.e(1);
            return jVar;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private j[] T0() throws IOException {
        org.apache.commons.net.io.d dVar = new org.apache.commons.net.io.d(this.f50880x);
        Vector vector = new Vector(2048);
        while (true) {
            try {
                String readLine = dVar.readLine();
                if (readLine == null) {
                    dVar.close();
                    int size = vector.size();
                    if (size < 1) {
                        return new j[0];
                    }
                    j[] jVarArr = new j[size];
                    vector.copyInto(jVarArr);
                    return jVarArr;
                }
                j S0 = S0(readLine);
                if (S0 == null) {
                    throw new MalformedServerReplyException(readLine);
                }
                vector.addElement(S0);
            } catch (Throwable th) {
                dVar.close();
                throw th;
            }
        }
    }

    public BufferedReader Q1(long j6, long j7) throws IOException {
        return W0(j6 + "-" + j7);
    }

    public BufferedReader U1(String str, long j6, long j7) throws IOException {
        return X0(str, j6 + "-" + j7);
    }

    public Iterable<j> e1(i iVar) throws IOException {
        return new k(d1(iVar));
    }

    public Iterable<j> h1() throws IOException {
        return new k(f1());
    }

    public Iterable<j> i1(String str) throws IOException {
        return new k(g1(str));
    }

    public String[] o1() throws IOException {
        if (!h.d(G0("LIST", "OVERVIEW.FMT"))) {
            return null;
        }
        org.apache.commons.net.io.d dVar = new org.apache.commons.net.io.d(this.f50880x);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = dVar.readLine();
            if (readLine == null) {
                dVar.close();
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            arrayList.add(readLine);
        }
    }

    private BufferedReader U0(int i6, long j6, b bVar) throws IOException {
        if (!h.d(E0(i6, Long.toString(j6)))) {
            return null;
        }
        if (bVar != null) {
            Q0(m0(), bVar);
        }
        return new org.apache.commons.net.io.d(this.f50880x);
    }

    private BufferedReader W0(String str) throws IOException {
        if (!h.d(M0(str))) {
            return null;
        }
        return new org.apache.commons.net.io.d(this.f50880x);
    }

    private BufferedReader X0(String str, String str2) throws IOException {
        if (!h.d(L0(str, str2))) {
            return null;
        }
        return new org.apache.commons.net.io.d(this.f50880x);
    }

    @Deprecated
    public Reader E1(int i6, d dVar) throws IOException {
        b O0 = O0(dVar);
        BufferedReader A1 = A1(i6, O0);
        N0(O0, dVar);
        return A1;
    }

    @Deprecated
    public Reader G1(String str, d dVar) throws IOException {
        b O0 = O0(dVar);
        BufferedReader B1 = B1(str, O0);
        N0(O0, dVar);
        return B1;
    }

    @Deprecated
    public Reader M1(int i6, d dVar) throws IOException {
        b O0 = O0(dVar);
        BufferedReader I1 = I1(i6, O0);
        N0(O0, dVar);
        return I1;
    }

    @Deprecated
    public Reader O1(String str, d dVar) throws IOException {
        b O0 = O0(dVar);
        BufferedReader J1 = J1(str, O0);
        N0(O0, dVar);
        return J1;
    }

    public BufferedReader P1(long j6) throws IOException {
        return W0(Long.toString(j6));
    }

    public BufferedReader T1(String str, long j6) throws IOException {
        return X0(str, Long.toString(j6));
    }

    public boolean Y0(String str, String str2) throws IOException {
        if (f0(str) == 381 && e0(str2) == 281) {
            this.f50877u = true;
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean Y1(int i6, d dVar) throws IOException {
        b O0 = O0(dVar);
        boolean a22 = a2(i6, O0);
        N0(O0, dVar);
        return a22;
    }

    public boolean Z0() throws IOException {
        return h.d(k0());
    }

    public Writer a1(String str) throws IOException {
        if (!h.e(t0(str))) {
            return null;
        }
        return new org.apache.commons.net.io.e(this.f50881y);
    }

    public boolean a2(long j6, b bVar) throws IOException {
        if (!h.d(J0(j6))) {
            return false;
        }
        if (bVar != null) {
            Q0(m0(), bVar);
            return true;
        }
        return true;
    }

    public Iterable<a> b1(long j6, long j7) throws IOException {
        BufferedReader Q1 = Q1(j6, j7);
        if (Q1 != null) {
            return new c(new l(Q1, false));
        }
        throw new IOException("XOVER command failed: " + m0());
    }

    public Iterable<String> c1(i iVar) throws IOException {
        if (h.d(z0(iVar.e(), iVar.c(), iVar.f(), iVar.g(), iVar.d()))) {
            return new l(this.f50880x);
        }
        throw new IOException("NEWNEWS command failed: " + m0());
    }

    public Iterable<String> d1(i iVar) throws IOException {
        if (h.d(y0(iVar.c(), iVar.f(), iVar.g(), iVar.d()))) {
            return new l(this.f50880x);
        }
        throw new IOException("NEWGROUPS command failed: " + m0());
    }

    @Deprecated
    public boolean d2(String str, d dVar) throws IOException {
        b O0 = O0(dVar);
        boolean c22 = c2(str, O0);
        N0(O0, dVar);
        return c22;
    }

    public Iterable<String> f1() throws IOException {
        if (h.d(w0())) {
            return new l(this.f50880x);
        }
        throw new IOException("LIST command failed: " + m0());
    }

    @Deprecated
    public boolean f2(d dVar) throws IOException {
        b O0 = O0(dVar);
        boolean e22 = e2(O0);
        N0(O0, dVar);
        return e22;
    }

    public Iterable<String> g1(String str) throws IOException {
        if (h.d(x0(str))) {
            return new l(this.f50880x);
        }
        throw new IOException("LIST ACTIVE " + str + " command failed: " + m0());
    }

    public boolean h2(String str, j jVar) throws IOException {
        if (!h.d(n0(str))) {
            return false;
        }
        if (jVar != null) {
            R0(m0(), jVar);
            return true;
        }
        return true;
    }

    public String j1() throws IOException {
        if (!h.a(s0())) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        org.apache.commons.net.io.d dVar = new org.apache.commons.net.io.d(this.f50880x);
        org.apache.commons.net.io.l.c(dVar, stringWriter);
        dVar.close();
        stringWriter.close();
        return stringWriter.toString();
    }

    public boolean j2(b bVar) throws IOException {
        if (!h.d(A0())) {
            return false;
        }
        if (bVar != null) {
            Q0(m0(), bVar);
            return true;
        }
        return true;
    }

    /* JADX WARN: Finally extract failed */
    public String[] k1(i iVar) throws IOException {
        if (!h.d(z0(iVar.e(), iVar.c(), iVar.f(), iVar.g(), iVar.d()))) {
            return null;
        }
        Vector vector = new Vector();
        org.apache.commons.net.io.d dVar = new org.apache.commons.net.io.d(this.f50880x);
        while (true) {
            try {
                String readLine = dVar.readLine();
                if (readLine == null) {
                    break;
                }
                vector.addElement(readLine);
            } catch (Throwable th) {
                dVar.close();
                throw th;
            }
        }
        dVar.close();
        int size = vector.size();
        if (size < 1) {
            return new String[0];
        }
        String[] strArr = new String[size];
        vector.copyInto(strArr);
        return strArr;
    }

    @Deprecated
    public boolean k2(d dVar) throws IOException {
        b O0 = O0(dVar);
        boolean j22 = j2(O0);
        N0(O0, dVar);
        return j22;
    }

    public j[] l1(i iVar) throws IOException {
        if (!h.d(y0(iVar.c(), iVar.f(), iVar.g(), iVar.d()))) {
            return null;
        }
        return T0();
    }

    public j[] m1() throws IOException {
        if (!h.d(w0())) {
            return null;
        }
        return T0();
    }

    public boolean m2(b bVar) throws IOException {
        if (!h.d(v0())) {
            return false;
        }
        if (bVar != null) {
            Q0(m0(), bVar);
            return true;
        }
        return true;
    }

    public j[] n1(String str) throws IOException {
        if (!h.d(x0(str))) {
            return null;
        }
        return T0();
    }

    @Deprecated
    public boolean n2(d dVar) throws IOException {
        b O0 = O0(dVar);
        boolean m22 = m2(O0);
        N0(O0, dVar);
        return m22;
    }

    public boolean p1() throws IOException {
        return h.d(C0());
    }

    public Writer q1() throws IOException {
        if (!h.e(B0())) {
            return null;
        }
        return new org.apache.commons.net.io.e(this.f50881y);
    }

    @Deprecated
    public Reader w1(int i6, d dVar) throws IOException {
        b O0 = O0(dVar);
        BufferedReader s12 = s1(i6, O0);
        N0(O0, dVar);
        return s12;
    }

    @Deprecated
    public Reader y1(String str, d dVar) throws IOException {
        b O0 = O0(dVar);
        BufferedReader t12 = t1(str, O0);
        N0(O0, dVar);
        return t12;
    }
}
