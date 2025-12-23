package org.apache.commons.net.smtp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends org.apache.commons.net.g {
    public static final int C = 25;
    private static final String D = "ISO-8859-1";
    private boolean A;
    private String B;

    /* renamed from: u, reason: collision with root package name */
    protected final String f51020u;

    /* renamed from: v, reason: collision with root package name */
    protected ProtocolCommandSupport f51021v;

    /* renamed from: w, reason: collision with root package name */
    BufferedReader f51022w;

    /* renamed from: x, reason: collision with root package name */
    BufferedWriter f51023x;

    /* renamed from: y, reason: collision with root package name */
    private int f51024y;

    /* renamed from: z, reason: collision with root package name */
    private final ArrayList<String> f51025z;

    public b() {
        this("ISO-8859-1");
    }

    private void Z() throws IOException {
        this.A = true;
        this.f51025z.clear();
        String readLine = this.f51022w.readLine();
        if (readLine == null) {
            throw new SMTPConnectionClosedException("Connection closed without indication.");
        }
        int length = readLine.length();
        if (length < 3) {
            throw new MalformedServerReplyException("Truncated server reply: " + readLine);
        }
        try {
            this.f51024y = Integer.parseInt(readLine.substring(0, 3));
            this.f51025z.add(readLine);
            if (length > 3 && readLine.charAt(3) == '-') {
                while (true) {
                    String readLine2 = this.f51022w.readLine();
                    if (readLine2 == null) {
                        throw new SMTPConnectionClosedException("Connection closed without indication.");
                    }
                    this.f51025z.add(readLine2);
                    if (readLine2.length() >= 4 && readLine2.charAt(3) != '-' && Character.isDigit(readLine2.charAt(0))) {
                        break;
                    }
                }
            }
            p(this.f51024y, g0());
            if (this.f51024y == 421) {
                throw new SMTPConnectionClosedException("SMTP response 421 received.  Server closed connection.");
            }
        } catch (NumberFormatException unused) {
            throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + readLine);
        }
    }

    public int c0() throws IOException {
        return t0(3);
    }

    public int i0(String str) throws IOException {
        return u0(0, str);
    }

    public int l0(String str) throws IOException {
        return a0(1, str, false);
    }

    public int o0(String str) throws IOException {
        return a0(2, str, false);
    }

    public int q0() throws IOException {
        return t0(7);
    }

    public int r0(String str) throws IOException {
        return u0(6, str);
    }

    public int s0(String str) throws IOException {
        return u0(4, str);
    }

    public int t0(int i6) throws IOException {
        return u0(i6, null);
    }

    public int v0(String str) throws IOException {
        return w0(str, null);
    }

    public int w0(String str, String str2) throws IOException {
        return b0(str, str2, true);
    }

    public int x0(String str) throws IOException {
        return u0(5, str);
    }

    public b(String str) {
        N(25);
        this.f51025z = new ArrayList<>();
        this.A = false;
        this.B = null;
        this.f51021v = new ProtocolCommandSupport(this);
        this.f51020u = str;
    }

    private int b0(String str, String str2, boolean z5) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            if (z5) {
                sb.append(' ');
            }
            sb.append(str2);
        }
        sb.append(org.apache.commons.net.g.f50795q);
        BufferedWriter bufferedWriter = this.f51023x;
        String sb2 = sb.toString();
        bufferedWriter.write(sb2);
        this.f51023x.flush();
        o(str, sb2);
        Z();
        return this.f51024y;
    }

    public int d0(String str) throws IOException {
        return u0(9, str);
    }

    public int f0() {
        return this.f51024y;
    }

    public String g0() {
        if (!this.A) {
            return this.B;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f51025z.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(org.apache.commons.net.g.f50795q);
        }
        this.A = false;
        String sb2 = sb.toString();
        this.B = sb2;
        return sb2;
    }

    public String[] h0() {
        ArrayList<String> arrayList = this.f51025z;
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public int j0() throws IOException {
        return t0(10);
    }

    public int k0(String str) throws IOException {
        return u0(10, str);
    }

    public int m0() throws IOException {
        return t0(11);
    }

    public int n0() throws IOException {
        return t0(13);
    }

    @Override // org.apache.commons.net.g
    protected ProtocolCommandSupport s() {
        return this.f51021v;
    }

    public int y0() throws IOException {
        return t0(12);
    }

    public int z0(String str) throws IOException {
        return u0(8, str);
    }

    private int a0(int i6, String str, boolean z5) throws IOException {
        return b0(d.a(i6), str, z5);
    }

    @Override // org.apache.commons.net.g
    protected void b() throws IOException {
        super.b();
        this.f51022w = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, this.f51020u));
        this.f51023x = new BufferedWriter(new OutputStreamWriter(this.f50805i, this.f51020u));
        Z();
    }

    public int e0() throws IOException {
        Z();
        return this.f51024y;
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        this.f51022w = null;
        this.f51023x = null;
        this.B = null;
        this.f51025z.clear();
        this.A = false;
    }

    public void p0(org.apache.commons.net.f fVar) {
        K(fVar);
    }

    public int u0(int i6, String str) throws IOException {
        return w0(d.a(i6), str);
    }
}
