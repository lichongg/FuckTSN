package org.apache.commons.net.imap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.net.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IMAP extends g {
    public static final int B = 143;
    protected static final String C = "ISO-8859-1";
    public static final b D = new a();
    private final char[] A = {'A', 'A', 'A', 'A'};

    /* renamed from: u, reason: collision with root package name */
    private IMAPState f50814u;

    /* renamed from: v, reason: collision with root package name */
    protected BufferedWriter f50815v;

    /* renamed from: w, reason: collision with root package name */
    protected BufferedReader f50816w;

    /* renamed from: x, reason: collision with root package name */
    private int f50817x;

    /* renamed from: y, reason: collision with root package name */
    private final List<String> f50818y;

    /* renamed from: z, reason: collision with root package name */
    private volatile b f50819z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum IMAPState {
        DISCONNECTED_STATE,
        NOT_AUTH_STATE,
        AUTH_STATE,
        LOGOUT_STATE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        boolean a(IMAP imap);
    }

    private void Z() throws IOException {
        a0(true);
    }

    public int h0(String str) throws IOException {
        return i0(str, null);
    }

    public int j0(IMAPCommand iMAPCommand) throws IOException {
        return k0(iMAPCommand, null);
    }

    public int m0(String str) throws IOException {
        return l0(null, str, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements b {
        @Override // org.apache.commons.net.imap.IMAP.b
        public boolean a(IMAP imap) {
            return true;
        }

        a() {
        }
    }

    private void a0(boolean z5) throws IOException {
        b bVar;
        this.f50818y.clear();
        String readLine = this.f50816w.readLine();
        if (readLine == null) {
            throw new EOFException("Connection closed without indication.");
        }
        this.f50818y.add(readLine);
        if (z5) {
            while (org.apache.commons.net.imap.a.g(readLine)) {
                int h6 = org.apache.commons.net.imap.a.h(readLine);
                boolean z6 = h6 >= 0;
                while (h6 >= 0) {
                    String readLine2 = this.f50816w.readLine();
                    if (readLine2 == null) {
                        throw new EOFException("Connection closed without indication.");
                    }
                    this.f50818y.add(readLine2);
                    h6 -= readLine2.length() + 2;
                }
                if (z6 && (bVar = this.f50819z) != null && bVar.a(this)) {
                    p(3, e0());
                    this.f50818y.clear();
                }
                readLine = this.f50816w.readLine();
                if (readLine == null) {
                    throw new EOFException("Connection closed without indication.");
                }
                this.f50818y.add(readLine);
            }
            this.f50817x = org.apache.commons.net.imap.a.a(readLine);
        } else {
            this.f50817x = org.apache.commons.net.imap.a.c(readLine);
        }
        p(this.f50817x, e0());
    }

    private int l0(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(str2);
        if (str3 != null) {
            sb.append(' ');
            sb.append(str3);
        }
        sb.append(g.f50795q);
        String sb2 = sb.toString();
        this.f50815v.write(sb2);
        this.f50815v.flush();
        o(str2, sb2);
        Z();
        return this.f50817x;
    }

    protected String d0() {
        String str = new String(this.A);
        boolean z5 = true;
        for (int length = this.A.length - 1; z5 && length >= 0; length--) {
            char[] cArr = this.A;
            char c6 = cArr[length];
            if (c6 == 'Z') {
                cArr[length] = 'A';
            } else {
                cArr[length] = (char) (c6 + 1);
                z5 = false;
            }
        }
        return str;
    }

    public String e0() {
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it = this.f50818y.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(g.f50795q);
        }
        return sb.toString();
    }

    public String[] f0() {
        List<String> list = this.f50818y;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public IMAPState g0() {
        return this.f50814u;
    }

    public void n0(b bVar) {
        this.f50819z = bVar;
    }

    protected void o0(IMAPState iMAPState) {
        this.f50814u = iMAPState;
    }

    public IMAP() {
        N(143);
        this.f50814u = IMAPState.DISCONNECTED_STATE;
        this.f50816w = null;
        this.f50815v = null;
        this.f50818y = new ArrayList();
        m();
    }

    @Override // org.apache.commons.net.g
    protected void b() throws IOException {
        super.b();
        this.f50816w = new org.apache.commons.net.io.a(new InputStreamReader(this.f50804h, "ISO-8859-1"));
        this.f50815v = new BufferedWriter(new OutputStreamWriter(this.f50805i, "ISO-8859-1"));
        int G = G();
        if (G <= 0) {
            V(this.f50808l);
        }
        a0(false);
        if (G <= 0) {
            V(G);
        }
        o0(IMAPState.NOT_AUTH_STATE);
    }

    public boolean b0(IMAPCommand iMAPCommand) throws IOException {
        return org.apache.commons.net.imap.a.f(j0(iMAPCommand));
    }

    public boolean c0(IMAPCommand iMAPCommand, String str) throws IOException {
        return org.apache.commons.net.imap.a.f(k0(iMAPCommand, str));
    }

    public int i0(String str, String str2) throws IOException {
        return l0(d0(), str, str2);
    }

    public int k0(IMAPCommand iMAPCommand, String str) throws IOException {
        return i0(iMAPCommand.getIMAPCommand(), str);
    }

    @Override // org.apache.commons.net.g
    public void n() throws IOException {
        super.n();
        this.f50816w = null;
        this.f50815v = null;
        this.f50818y.clear();
        o0(IMAPState.DISCONNECTED_STATE);
    }

    @Override // org.apache.commons.net.g
    protected void p(int i6, String str) {
        if (s().getListenerCount() > 0) {
            s().fireReplyReceived(i6, e0());
        }
    }
}
