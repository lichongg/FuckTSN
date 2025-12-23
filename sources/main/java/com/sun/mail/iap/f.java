package com.sun.mail.iap;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: p, reason: collision with root package name */
    private static final byte[] f39180p = {13, 10};

    /* renamed from: a, reason: collision with root package name */
    protected String f39181a;

    /* renamed from: b, reason: collision with root package name */
    private Socket f39182b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f39183c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f39184d;

    /* renamed from: e, reason: collision with root package name */
    protected PrintStream f39185e;

    /* renamed from: f, reason: collision with root package name */
    protected Properties f39186f;

    /* renamed from: g, reason: collision with root package name */
    protected String f39187g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f39188h;

    /* renamed from: i, reason: collision with root package name */
    private TraceInputStream f39189i;

    /* renamed from: j, reason: collision with root package name */
    private volatile i f39190j;

    /* renamed from: k, reason: collision with root package name */
    private TraceOutputStream f39191k;

    /* renamed from: l, reason: collision with root package name */
    private volatile DataOutputStream f39192l;

    /* renamed from: m, reason: collision with root package name */
    private int f39193m;

    /* renamed from: n, reason: collision with root package name */
    private volatile Vector f39194n;

    /* renamed from: o, reason: collision with root package name */
    private volatile long f39195o;

    public f(String str, int i6, boolean z5, PrintStream printStream, Properties properties, String str2, boolean z6) throws IOException, ProtocolException {
        boolean z7 = false;
        this.f39188h = false;
        this.f39193m = 0;
        this.f39194n = null;
        try {
            this.f39181a = str;
            this.f39183c = z5;
            this.f39185e = printStream;
            this.f39186f = properties;
            this.f39187g = str2;
            this.f39182b = SocketFetcher.getSocket(str, i6, properties, str2, z6);
            String property = properties.getProperty("mail.debug.quote");
            if (property != null && property.equalsIgnoreCase("true")) {
                z7 = true;
            }
            this.f39184d = z7;
            i(printStream);
            k(l());
            this.f39195o = System.currentTimeMillis();
            this.f39188h = true;
        } catch (Throwable th) {
            if (!this.f39188h) {
                c();
            }
            throw th;
        }
    }

    public synchronized void a(h hVar) {
        try {
            if (this.f39194n == null) {
                this.f39194n = new Vector();
            }
            this.f39194n.addElement(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0018 -> B:8:0x0023). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.sun.mail.iap.g[] b(java.lang.String r5, com.sun.mail.iap.b r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Vector r0 = new java.util.Vector     // Catch: java.lang.Throwable -> Le
            r0.<init>()     // Catch: java.lang.Throwable -> Le
            r1 = 1
            r2 = 0
            java.lang.String r2 = r4.q(r5, r6)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L10 com.sun.mail.iap.LiteralException -> L1a
            r5 = 0
            goto L23
        Le:
            r5 = move-exception
            goto L5d
        L10:
            r5 = move-exception
            com.sun.mail.iap.g r5 = com.sun.mail.iap.g.a(r5)     // Catch: java.lang.Throwable -> Le
            r0.addElement(r5)     // Catch: java.lang.Throwable -> Le
        L18:
            r5 = 1
            goto L23
        L1a:
            r5 = move-exception
            com.sun.mail.iap.g r5 = r5.getResponse()     // Catch: java.lang.Throwable -> Le
            r0.addElement(r5)     // Catch: java.lang.Throwable -> Le
            goto L18
        L23:
            if (r5 == 0) goto L36
            int r5 = r0.size()     // Catch: java.lang.Throwable -> Le
            com.sun.mail.iap.g[] r5 = new com.sun.mail.iap.g[r5]     // Catch: java.lang.Throwable -> Le
            r0.copyInto(r5)     // Catch: java.lang.Throwable -> Le
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Le
            r4.f39195o = r0     // Catch: java.lang.Throwable -> Le
            monitor-exit(r4)
            return r5
        L36:
            com.sun.mail.iap.g r6 = r4.l()     // Catch: java.lang.Throwable -> Le com.sun.mail.iap.ProtocolException -> L3b java.io.IOException -> L3d
            goto L42
        L3b:
            goto L23
        L3d:
            r6 = move-exception
            com.sun.mail.iap.g r6 = com.sun.mail.iap.g.a(r6)     // Catch: java.lang.Throwable -> Le
        L42:
            r0.addElement(r6)     // Catch: java.lang.Throwable -> Le
            boolean r3 = r6.e()     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L4c
            r5 = 1
        L4c:
            boolean r3 = r6.j()     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L23
            java.lang.String r6 = r6.c()     // Catch: java.lang.Throwable -> Le
            boolean r6 = r6.equals(r2)     // Catch: java.lang.Throwable -> Le
            if (r6 == 0) goto L23
            goto L18
        L5d:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Le
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.f.b(java.lang.String, com.sun.mail.iap.b):com.sun.mail.iap.g[]");
    }

    protected synchronized void c() {
        Socket socket = this.f39182b;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            this.f39182b = null;
        }
    }

    protected d f() {
        return null;
    }

    public synchronized void m(h hVar) {
        if (this.f39194n != null) {
            this.f39194n.removeElement(hVar);
        }
    }

    public synchronized void o(String str) throws IOException, ProtocolException {
        n(str, null);
        this.f39182b = SocketFetcher.startTLS(this.f39182b, this.f39186f, this.f39187g);
        i(this.f39185e);
    }

    protected synchronized boolean p() {
        return false;
    }

    private void i(PrintStream printStream) throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.f39182b.getInputStream(), printStream);
        this.f39189i = traceInputStream;
        traceInputStream.setTrace(this.f39183c);
        this.f39189i.setQuote(this.f39184d);
        this.f39190j = new i(this.f39189i);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.f39182b.getOutputStream(), printStream);
        this.f39191k = traceOutputStream;
        traceOutputStream.setTrace(this.f39183c);
        this.f39191k.setQuote(this.f39184d);
        this.f39192l = new DataOutputStream(new BufferedOutputStream(this.f39191k));
    }

    protected i d() {
        return this.f39190j;
    }

    protected OutputStream e() {
        return this.f39192l;
    }

    public long g() {
        return this.f39195o;
    }

    public void j(g[] gVarArr) {
        if (this.f39194n == null) {
            return;
        }
        for (g gVar : gVarArr) {
            if (gVar != null) {
                int size = this.f39194n.size();
                if (size == 0) {
                    return;
                }
                Object[] objArr = new Object[size];
                this.f39194n.copyInto(objArr);
                for (int i6 = 0; i6 < size; i6++) {
                    ((h) objArr[i6]).a(gVar);
                }
            }
        }
    }

    public g l() throws IOException, ProtocolException {
        return new g(this);
    }

    public String q(String str, b bVar) throws IOException, ProtocolException {
        StringBuilder sb = new StringBuilder(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        int i6 = this.f39193m;
        this.f39193m = i6 + 1;
        sb.append(Integer.toString(i6, 10));
        String sb2 = sb.toString();
        this.f39192l.writeBytes(String.valueOf(sb2) + " " + str);
        if (bVar != null) {
            this.f39192l.write(32);
            bVar.g(this);
        }
        this.f39192l.write(f39180p);
        this.f39192l.flush();
        return sb2;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        c();
    }

    public void h(g gVar) throws ProtocolException {
        if (!gVar.h()) {
            if (!gVar.g()) {
                if (!gVar.d()) {
                    if (!gVar.e()) {
                        return;
                    }
                    c();
                    throw new ConnectionException(this, gVar);
                }
                throw new BadCommandException(gVar);
            }
            throw new CommandFailedException(gVar);
        }
    }

    protected void k(g gVar) throws ProtocolException {
        if (!gVar.e()) {
        } else {
            throw new ConnectionException(this, gVar);
        }
    }

    public void n(String str, b bVar) throws ProtocolException {
        g[] b6 = b(str, bVar);
        j(b6);
        h(b6[b6.length - 1]);
    }

    public f(InputStream inputStream, OutputStream outputStream, boolean z5) throws IOException {
        this.f39188h = false;
        this.f39193m = 0;
        this.f39194n = null;
        this.f39181a = "localhost";
        this.f39183c = z5;
        this.f39184d = false;
        this.f39185e = System.out;
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, System.out);
        this.f39189i = traceInputStream;
        traceInputStream.setTrace(z5);
        this.f39189i.setQuote(this.f39184d);
        this.f39190j = new i(this.f39189i);
        TraceOutputStream traceOutputStream = new TraceOutputStream(outputStream, System.out);
        this.f39191k = traceOutputStream;
        traceOutputStream.setTrace(z5);
        this.f39191k.setQuote(this.f39184d);
        this.f39192l = new DataOutputStream(new BufferedOutputStream(this.f39191k));
        this.f39195o = System.currentTimeMillis();
    }
}
