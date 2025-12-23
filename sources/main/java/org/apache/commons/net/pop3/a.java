package org.apache.commons.net.pop3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandSupport;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends g {
    public static final int B = 110;
    public static final int C = -1;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    static final String G = "+OK";
    static final String H = "+ ";
    static final String I = "-ERR";
    static final String J = "ISO-8859-1";
    protected ProtocolCommandSupport A;

    /* renamed from: u, reason: collision with root package name */
    private int f50990u;

    /* renamed from: v, reason: collision with root package name */
    BufferedWriter f50991v;

    /* renamed from: w, reason: collision with root package name */
    BufferedReader f50992w;

    /* renamed from: x, reason: collision with root package name */
    int f50993x;

    /* renamed from: y, reason: collision with root package name */
    String f50994y;

    /* renamed from: z, reason: collision with root package name */
    List<String> f50995z;

    public int h0(String str) throws IOException {
        return i0(str, null);
    }

    private void Z() throws IOException {
        this.f50995z.clear();
        String readLine = this.f50992w.readLine();
        if (readLine == null) {
            throw new EOFException("Connection closed without indication.");
        }
        if (readLine.startsWith(G)) {
            this.f50993x = 0;
        } else if (readLine.startsWith(I)) {
            this.f50993x = 1;
        } else {
            if (!readLine.startsWith(H)) {
                throw new MalformedServerReplyException("Received invalid POP3 protocol response from server." + readLine);
            }
            this.f50993x = 2;
        }
        this.f50995z.add(readLine);
        this.f50994y = readLine;
        p(this.f50993x, b0());
    }

    public void a0() throws IOException {
        String readLine = this.f50992w.readLine();
        while (readLine != null) {
            this.f50995z.add(readLine);
            if (readLine.equals(".")) {
                return;
            } else {
                readLine = this.f50992w.readLine();
            }
        }
    }

    public String b0() {
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it = this.f50995z.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(g.f50795q);
        }
        return sb.toString();
    }

    public String[] c0() {
        List<String> list = this.f50995z;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public int d0() {
        return this.f50990u;
    }

    public int f0(int i6) throws IOException {
        return i0(c.f51011p[i6], null);
    }

    public int g0(int i6, String str) throws IOException {
        return i0(c.f51011p[i6], str);
    }

    public int i0(String str, String str2) throws IOException {
        if (this.f50991v == null) {
            throw new IllegalStateException("Socket is not connected");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        sb.append(g.f50795q);
        String sb2 = sb.toString();
        this.f50991v.write(sb2);
        this.f50991v.flush();
        o(str, sb2);
        Z();
        return this.f50993x;
    }

    public void j0(int i6) {
        this.f50990u = i6;
    }

    @Override // org.apache.commons.net.g
    protected ProtocolCommandSupport s() {
        return this.A;
    }

    public a() {
        N(110);
        this.f50990u = -1;
        this.f50992w = null;
        this.f50991v = null;
        this.f50995z = new ArrayList();
        this.A = new ProtocolCommandSupport(this);
    }

    @Override // org.apache.commons.net.g
    protected void b() throws IOException {
        super.b();
        this.f50992w = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, "ISO-8859-1"));
        this.f50991v = new BufferedWriter(new OutputStreamWriter(this.f50805i, "ISO-8859-1"));
        Z();
        j0(0);
    }

    public void e0(org.apache.commons.net.f fVar) {
        K(fVar);
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        this.f50992w = null;
        this.f50991v = null;
        this.f50994y = null;
        this.f50995z.clear();
        j0(-1);
    }
}
