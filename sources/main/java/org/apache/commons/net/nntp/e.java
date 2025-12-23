package org.apache.commons.net.nntp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import kotlin.text.v0;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends org.apache.commons.net.g {
    public static final int A = 119;
    private static final String B = "ISO-8859-1";

    /* renamed from: u, reason: collision with root package name */
    boolean f50877u;

    /* renamed from: v, reason: collision with root package name */
    int f50878v;

    /* renamed from: w, reason: collision with root package name */
    String f50879w;

    /* renamed from: x, reason: collision with root package name */
    protected BufferedReader f50880x;

    /* renamed from: y, reason: collision with root package name */
    protected BufferedWriter f50881y;

    /* renamed from: z, reason: collision with root package name */
    protected ProtocolCommandSupport f50882z;

    public int D0(int i6) throws IOException {
        return E0(i6, null);
    }

    public int F0(String str) throws IOException {
        return G0(str, null);
    }

    @Deprecated
    public int I0(int i6) throws IOException {
        return J0(i6);
    }

    public int a0() throws IOException {
        return D0(0);
    }

    @Deprecated
    public int b0(int i6) throws IOException {
        return c0(i6);
    }

    public int c0(long j6) throws IOException {
        return E0(0, Long.toString(j6));
    }

    public int d0(String str) throws IOException {
        return E0(0, str);
    }

    public int g0() throws IOException {
        return D0(1);
    }

    @Deprecated
    public int h0(int i6) throws IOException {
        return i0(i6);
    }

    public int i0(long j6) throws IOException {
        return E0(1, Long.toString(j6));
    }

    public int j0(String str) throws IOException {
        return E0(1, str);
    }

    public int n0(String str) throws IOException {
        return E0(2, str);
    }

    public int o0() throws IOException {
        return D0(3);
    }

    @Deprecated
    public int p0(int i6) throws IOException {
        return q0(i6);
    }

    public int q0(long j6) throws IOException {
        return E0(3, Long.toString(j6));
    }

    public int r0(String str) throws IOException {
        return E0(3, str);
    }

    public int s0() throws IOException {
        return D0(4);
    }

    public int t0(String str) throws IOException {
        return E0(5, str);
    }

    public int v0() throws IOException {
        return D0(6);
    }

    public int w0() throws IOException {
        return D0(7);
    }

    private void Z() throws IOException {
        String readLine = this.f50880x.readLine();
        this.f50879w = readLine;
        if (readLine == null) {
            throw new NNTPConnectionClosedException("Connection closed without indication.");
        }
        if (readLine.length() < 3) {
            throw new MalformedServerReplyException("Truncated server reply: " + this.f50879w);
        }
        try {
            int parseInt = Integer.parseInt(this.f50879w.substring(0, 3));
            this.f50878v = parseInt;
            p(parseInt, this.f50879w + org.apache.commons.net.g.f50795q);
            if (this.f50878v == 400) {
                throw new NNTPConnectionClosedException("NNTP response 400 received.  Server closed connection.");
            }
        } catch (NumberFormatException unused) {
            throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + this.f50879w);
        }
    }

    public int A0() throws IOException {
        return D0(10);
    }

    public int B0() throws IOException {
        return D0(11);
    }

    public int C0() throws IOException {
        return D0(12);
    }

    public int G0(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        sb.append(org.apache.commons.net.g.f50795q);
        BufferedWriter bufferedWriter = this.f50881y;
        String sb2 = sb.toString();
        bufferedWriter.write(sb2);
        this.f50881y.flush();
        o(str, sb2);
        Z();
        return this.f50878v;
    }

    public int H0() throws IOException {
        return D0(14);
    }

    public int J0(long j6) throws IOException {
        return E0(14, Long.toString(j6));
    }

    public int K0(String str) throws IOException {
        return E0(14, str);
    }

    public int L0(String str, String str2) throws IOException {
        return E0(17, str + " " + str2);
    }

    public int M0(String str) throws IOException {
        return E0(16, str);
    }

    public int e0(String str) throws IOException {
        return E0(15, "PASS " + str);
    }

    public int f0(String str) throws IOException {
        return E0(15, "USER " + str);
    }

    public int l0() {
        return this.f50878v;
    }

    public String m0() {
        return this.f50879w;
    }

    @Override // org.apache.commons.net.g
    protected ProtocolCommandSupport s() {
        return this.f50882z;
    }

    public boolean u0() {
        return this.f50877u;
    }

    public int x0(String str) throws IOException {
        return E0(7, "ACTIVE " + str);
    }

    public int y0(String str, String str2, boolean z5, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        sb.append(str2);
        if (z5) {
            sb.append(' ');
            sb.append("GMT");
        }
        if (str3 != null) {
            sb.append(" <");
            sb.append(str3);
            sb.append(v0.f47962f);
        }
        return E0(8, sb.toString());
    }

    public int z0(String str, String str2, String str3, boolean z5, String str4) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        sb.append(str3);
        if (z5) {
            sb.append(' ');
            sb.append("GMT");
        }
        if (str4 != null) {
            sb.append(" <");
            sb.append(str4);
            sb.append(v0.f47962f);
        }
        return E0(9, sb.toString());
    }

    public e() {
        N(119);
        this.f50879w = null;
        this.f50880x = null;
        this.f50881y = null;
        this.f50877u = false;
        this.f50882z = new ProtocolCommandSupport(this);
    }

    public int E0(int i6, String str) throws IOException {
        return G0(g.a(i6), str);
    }

    @Override // org.apache.commons.net.g
    protected void b() throws IOException {
        boolean z5;
        super.b();
        this.f50880x = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, "ISO-8859-1"));
        this.f50881y = new BufferedWriter(new OutputStreamWriter(this.f50805i, "ISO-8859-1"));
        Z();
        if (this.f50878v == 200) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f50877u = z5;
    }

    public int k0() throws IOException {
        Z();
        return this.f50878v;
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        this.f50880x = null;
        this.f50881y = null;
        this.f50879w = null;
        this.f50877u = false;
    }
}
