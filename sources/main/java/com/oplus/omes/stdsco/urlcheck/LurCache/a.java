package com.oplus.omes.stdsco.urlcheck.LurCache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    static final String f36402o = "journal";

    /* renamed from: p, reason: collision with root package name */
    static final String f36403p = "journal.tmp";

    /* renamed from: q, reason: collision with root package name */
    static final String f36404q = "journal.bkp";

    /* renamed from: r, reason: collision with root package name */
    static final String f36405r = "libcore.io.DiskLruCache";

    /* renamed from: s, reason: collision with root package name */
    static final String f36406s = "1";

    /* renamed from: t, reason: collision with root package name */
    static final long f36407t = -1;

    /* renamed from: w, reason: collision with root package name */
    private static final String f36410w = "CLEAN";

    /* renamed from: x, reason: collision with root package name */
    private static final String f36411x = "DIRTY";

    /* renamed from: y, reason: collision with root package name */
    private static final String f36412y = "REMOVE";

    /* renamed from: z, reason: collision with root package name */
    private static final String f36413z = "READ";

    /* renamed from: a, reason: collision with root package name */
    private final File f36414a;

    /* renamed from: b, reason: collision with root package name */
    private final File f36415b;

    /* renamed from: c, reason: collision with root package name */
    private final File f36416c;

    /* renamed from: d, reason: collision with root package name */
    private final File f36417d;

    /* renamed from: e, reason: collision with root package name */
    private final int f36418e;

    /* renamed from: f, reason: collision with root package name */
    private long f36419f;

    /* renamed from: g, reason: collision with root package name */
    private final int f36420g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f36422i;

    /* renamed from: k, reason: collision with root package name */
    private int f36424k;

    /* renamed from: u, reason: collision with root package name */
    static final String f36408u = "[a-z0-9_-]{1,120}";

    /* renamed from: v, reason: collision with root package name */
    static final Pattern f36409v = Pattern.compile(f36408u);
    private static final OutputStream A = new b();

    /* renamed from: h, reason: collision with root package name */
    private long f36421h = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f36423j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    private long f36425l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f36426m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: n, reason: collision with root package name */
    private final Callable<Void> f36427n = new CallableC0716a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.oplus.omes.stdsco.urlcheck.LurCache.a$a, reason: collision with other inner class name */
    class CallableC0716a implements Callable<Void> {
        CallableC0716a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                try {
                    if (a.this.f36422i == null) {
                        return null;
                    }
                    a.this.E();
                    if (a.this.v()) {
                        a.this.A();
                        a.this.f36424k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f36429a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f36430b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f36431c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f36432d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.oplus.omes.stdsco.urlcheck.LurCache.a$c$a, reason: collision with other inner class name */
        private class C0717a extends FilterOutputStream {
            /* synthetic */ C0717a(c cVar, OutputStream outputStream, CallableC0716a callableC0716a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int oneByte) {
                try {
                    ((FilterOutputStream) this).out.write(oneByte);
                } catch (IOException unused) {
                    c.this.f36431c = true;
                }
            }

            private C0717a(OutputStream out) {
                super(out);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f36431c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f36431c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] buffer, int offset, int length) {
                try {
                    ((FilterOutputStream) this).out.write(buffer, offset, length);
                } catch (IOException unused) {
                    c.this.f36431c = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0716a callableC0716a) {
            this(dVar);
        }

        public void j(int index, String value) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(i(index), com.oplus.omes.stdsco.urlcheck.LurCache.c.f36455b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(value);
                com.oplus.omes.stdsco.urlcheck.LurCache.c.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                com.oplus.omes.stdsco.urlcheck.LurCache.c.a(outputStreamWriter2);
                throw th;
            }
        }

        private c(d entry) {
            this.f36429a = entry;
            this.f36430b = entry.f36437c ? null : new boolean[a.this.f36420g];
        }

        public void a() throws IOException {
            a.this.m(this, false);
        }

        public void b() {
            if (this.f36432d) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void f() throws IOException {
            if (this.f36431c) {
                a.this.m(this, false);
                a.this.B(this.f36429a.f36435a);
            } else {
                a.this.m(this, true);
            }
            this.f36432d = true;
        }

        public InputStream h(int index) throws IOException {
            synchronized (a.this) {
                if (this.f36429a.f36438d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f36429a.f36437c) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f36429a.j(index));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public OutputStream i(int index) throws IOException {
            FileOutputStream fileOutputStream;
            C0717a c0717a;
            if (index < 0 || index >= a.this.f36420g) {
                throw new IllegalArgumentException("Expected index " + index + " to be greater than 0 and less than the maximum value count of " + a.this.f36420g);
            }
            synchronized (a.this) {
                try {
                    if (this.f36429a.f36438d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f36429a.f36437c) {
                        this.f36430b[index] = true;
                    }
                    File k6 = this.f36429a.k(index);
                    try {
                        fileOutputStream = new FileOutputStream(k6);
                    } catch (FileNotFoundException unused) {
                        a.this.f36414a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(k6);
                        } catch (FileNotFoundException unused2) {
                            return a.A;
                        }
                    }
                    c0717a = new C0717a(this, fileOutputStream, null);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0717a;
        }

        public String g(int index) throws IOException {
            InputStream h6 = h(index);
            if (h6 != null) {
                return a.u(h6);
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f36435a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f36436b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f36437c;

        /* renamed from: d, reason: collision with root package name */
        private c f36438d;

        /* renamed from: e, reason: collision with root package name */
        private long f36439e;

        /* synthetic */ d(a aVar, String str, CallableC0716a callableC0716a) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strings) throws IOException {
            if (strings.length != a.this.f36420g) {
                throw m(strings);
            }
            for (int i6 = 0; i6 < strings.length; i6++) {
                try {
                    this.f36436b[i6] = Long.parseLong(strings[i6]);
                } catch (NumberFormatException unused) {
                    throw m(strings);
                }
            }
        }

        private d(String key) {
            this.f36435a = key;
            this.f36436b = new long[a.this.f36420g];
        }

        private IOException m(String[] strings) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        public File j(int i6) {
            return new File(a.this.f36414a, this.f36435a + "." + i6);
        }

        public File k(int i6) {
            return new File(a.this.f36414a, this.f36435a + "." + i6 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j6 : this.f36436b) {
                sb.append(' ');
                sb.append(j6);
            }
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class e implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final String f36441a;

        /* renamed from: b, reason: collision with root package name */
        private final long f36442b;

        /* renamed from: c, reason: collision with root package name */
        private final InputStream[] f36443c;

        /* renamed from: d, reason: collision with root package name */
        private final long[] f36444d;

        /* synthetic */ e(a aVar, String str, long j6, InputStream[] inputStreamArr, long[] jArr, CallableC0716a callableC0716a) {
            this(str, j6, inputStreamArr, jArr);
        }

        private e(String key, long sequenceNumber, InputStream[] ins, long[] lengths) {
            this.f36441a = key;
            this.f36442b = sequenceNumber;
            this.f36443c = ins;
            this.f36444d = lengths;
        }

        public c a() throws IOException {
            return a.this.p(this.f36441a, this.f36442b);
        }

        public InputStream b(int index) {
            return this.f36443c[index];
        }

        public long c(int index) {
            return this.f36444d[index];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f36443c) {
                com.oplus.omes.stdsco.urlcheck.LurCache.c.a(inputStream);
            }
        }

        public String getString(int index) throws IOException {
            return a.u(b(index));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A() throws IOException {
        try {
            Writer writer = this.f36422i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f36416c), com.oplus.omes.stdsco.urlcheck.LurCache.c.f36454a));
            try {
                bufferedWriter.write(f36405r);
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write("1");
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f36418e));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f36420g));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                for (d dVar : this.f36423j.values()) {
                    if (dVar.f36438d != null) {
                        bufferedWriter.write("DIRTY " + dVar.f36435a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f36435a + dVar.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f36415b.exists()) {
                    C(this.f36415b, this.f36417d, true);
                }
                C(this.f36416c, this.f36415b, false);
                this.f36417d.delete();
                this.f36422i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f36415b, true), com.oplus.omes.stdsco.urlcheck.LurCache.c.f36454a));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(c editor, boolean success) throws IOException {
        d dVar = editor.f36429a;
        if (dVar.f36438d != editor) {
            throw new IllegalStateException();
        }
        if (success && !dVar.f36437c) {
            for (int i6 = 0; i6 < this.f36420g; i6++) {
                if (!editor.f36430b[i6]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i6);
                }
                if (!dVar.k(i6).exists()) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i7 = 0; i7 < this.f36420g; i7++) {
            File k6 = dVar.k(i7);
            if (!success) {
                n(k6);
            } else if (k6.exists()) {
                File j6 = dVar.j(i7);
                k6.renameTo(j6);
                long j7 = dVar.f36436b[i7];
                long length = j6.length();
                dVar.f36436b[i7] = length;
                this.f36421h = (this.f36421h - j7) + length;
            }
        }
        this.f36424k++;
        dVar.f36438d = null;
        if (dVar.f36437c || success) {
            dVar.f36437c = true;
            this.f36422i.write("CLEAN " + dVar.f36435a + dVar.l() + '\n');
            if (success) {
                long j8 = this.f36425l;
                this.f36425l = 1 + j8;
                dVar.f36439e = j8;
            }
        } else {
            this.f36423j.remove(dVar.f36435a);
            this.f36422i.write("REMOVE " + dVar.f36435a + '\n');
        }
        this.f36422i.flush();
        if (this.f36421h > this.f36419f || v()) {
            this.f36426m.submit(this.f36427n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c p(String key, long expectedSequenceNumber) throws IOException {
        l();
        F(key);
        d dVar = this.f36423j.get(key);
        CallableC0716a callableC0716a = null;
        if (expectedSequenceNumber != -1 && (dVar == null || dVar.f36439e != expectedSequenceNumber)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, key, callableC0716a);
            this.f36423j.put(key, dVar);
        } else if (dVar.f36438d != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0716a);
        dVar.f36438d = cVar;
        this.f36422i.write("DIRTY " + key + '\n');
        this.f36422i.flush();
        return cVar;
    }

    public synchronized boolean B(String key) throws IOException {
        try {
            l();
            F(key);
            d dVar = this.f36423j.get(key);
            if (dVar != null && dVar.f36438d == null) {
                for (int i6 = 0; i6 < this.f36420g; i6++) {
                    File j6 = dVar.j(i6);
                    if (j6.exists() && !j6.delete()) {
                        throw new IOException("failed to delete " + j6);
                    }
                    this.f36421h -= dVar.f36436b[i6];
                    dVar.f36436b[i6] = 0;
                }
                this.f36424k++;
                this.f36422i.append((CharSequence) ("REMOVE " + key + '\n'));
                this.f36423j.remove(key);
                if (v()) {
                    this.f36426m.submit(this.f36427n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public synchronized void D(long maxSize) {
        this.f36419f = maxSize;
        this.f36426m.submit(this.f36427n);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f36422i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f36423j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f36438d != null) {
                    dVar.f36438d.a();
                }
            }
            E();
            this.f36422i.close();
            this.f36422i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() throws IOException {
        l();
        E();
        this.f36422i.flush();
    }

    public synchronized boolean isClosed() {
        return this.f36422i == null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:18|19|20)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007b, code lost:
    
        r12 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.oplus.omes.stdsco.urlcheck.LurCache.a.e q(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.l()     // Catch: java.lang.Throwable -> L7d
            r11.F(r12)     // Catch: java.lang.Throwable -> L7d
            java.util.LinkedHashMap<java.lang.String, com.oplus.omes.stdsco.urlcheck.LurCache.a$d> r0 = r11.f36423j     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L7d
            com.oplus.omes.stdsco.urlcheck.LurCache.a$d r0 = (com.oplus.omes.stdsco.urlcheck.LurCache.a.d) r0     // Catch: java.lang.Throwable -> L7d
            r1 = 0
            if (r0 != 0) goto L14
            monitor-exit(r11)
            return r1
        L14:
            boolean r2 = com.oplus.omes.stdsco.urlcheck.LurCache.a.d.e(r0)     // Catch: java.lang.Throwable -> L7d
            if (r2 != 0) goto L1c
            monitor-exit(r11)
            return r1
        L1c:
            int r2 = r11.f36420g     // Catch: java.lang.Throwable -> L7d
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch: java.lang.Throwable -> L7d
            r2 = 0
            r3 = 0
        L22:
            int r4 = r11.f36420g     // Catch: java.io.FileNotFoundException -> L38 java.lang.Throwable -> L7d
            if (r3 >= r4) goto L3a
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            java.io.File r5 = r0.j(r3)     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            r8[r3] = r4     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            int r3 = r3 + 1
            goto L22
        L34:
            r0 = move-exception
            r12 = r0
            r4 = r11
            goto L90
        L38:
            r4 = r11
            goto L80
        L3a:
            int r1 = r11.f36424k     // Catch: java.lang.Throwable -> L7d
            int r1 = r1 + 1
            r11.f36424k = r1     // Catch: java.lang.Throwable -> L7d
            java.io.Writer r1 = r11.f36422i     // Catch: java.lang.Throwable -> L7d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d
            r2.<init>()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch: java.lang.Throwable -> L7d
            r2.append(r12)     // Catch: java.lang.Throwable -> L7d
            r3 = 10
            r2.append(r3)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7d
            r1.append(r2)     // Catch: java.lang.Throwable -> L7d
            boolean r1 = r11.v()     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L68
            java.util.concurrent.ThreadPoolExecutor r1 = r11.f36426m     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f36427n     // Catch: java.lang.Throwable -> L34
            r1.submit(r2)     // Catch: java.lang.Throwable -> L34
        L68:
            com.oplus.omes.stdsco.urlcheck.LurCache.a$e r3 = new com.oplus.omes.stdsco.urlcheck.LurCache.a$e     // Catch: java.lang.Throwable -> L7d
            long r6 = com.oplus.omes.stdsco.urlcheck.LurCache.a.d.c(r0)     // Catch: java.lang.Throwable -> L7d
            long[] r9 = com.oplus.omes.stdsco.urlcheck.LurCache.a.d.a(r0)     // Catch: java.lang.Throwable -> L7d
            r10 = 0
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r11)
            return r3
        L7a:
            r0 = move-exception
        L7b:
            r12 = r0
            goto L90
        L7d:
            r0 = move-exception
            r4 = r11
            goto L7b
        L80:
            int r12 = r4.f36420g     // Catch: java.lang.Throwable -> L7a
            if (r2 >= r12) goto L8e
            r12 = r8[r2]     // Catch: java.lang.Throwable -> L7a
            if (r12 == 0) goto L8e
            com.oplus.omes.stdsco.urlcheck.LurCache.c.a(r12)     // Catch: java.lang.Throwable -> L7a
            int r2 = r2 + 1
            goto L80
        L8e:
            monitor-exit(r11)
            return r1
        L90:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L7a
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.omes.stdsco.urlcheck.LurCache.a.q(java.lang.String):com.oplus.omes.stdsco.urlcheck.LurCache.a$e");
    }

    public synchronized long size() {
        return this.f36421h;
    }

    public synchronized long t() {
        return this.f36419f;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int b6) throws IOException {
        }
    }

    private static void C(File from, File to, boolean deleteDestination) throws IOException {
        if (deleteDestination) {
            n(to);
        }
        if (!from.renameTo(to)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() throws IOException {
        while (this.f36421h > this.f36419f) {
            B(this.f36423j.entrySet().iterator().next().getKey());
        }
    }

    private void F(String key) {
        if (f36409v.matcher(key).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + key + "\"");
    }

    private void l() {
        if (this.f36422i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(InputStream in) throws IOException {
        return com.oplus.omes.stdsco.urlcheck.LurCache.c.c(new InputStreamReader(in, com.oplus.omes.stdsco.urlcheck.LurCache.c.f36455b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        int i6 = this.f36424k;
        return i6 >= 2000 && i6 >= this.f36423j.size();
    }

    public static a w(File directory, int appVersion, int valueCount, long maxSize) throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (valueCount <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file = new File(directory, f36404q);
        if (file.exists()) {
            File file2 = new File(directory, f36402o);
            if (file2.exists()) {
                file.delete();
            } else {
                C(file, file2, false);
            }
        }
        a aVar = new a(directory, appVersion, valueCount, maxSize);
        if (aVar.f36415b.exists()) {
            try {
                aVar.y();
                aVar.x();
                return aVar;
            } catch (IOException e6) {
                PrintStream printStream = System.out;
                Objects.toString(directory);
                e6.getMessage();
                printStream.getClass();
                aVar.delete();
            }
        }
        directory.mkdirs();
        a aVar2 = new a(directory, appVersion, valueCount, maxSize);
        aVar2.A();
        return aVar2;
    }

    private void x() throws IOException {
        n(this.f36416c);
        Iterator<d> it = this.f36423j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i6 = 0;
            if (next.f36438d == null) {
                while (i6 < this.f36420g) {
                    this.f36421h += next.f36436b[i6];
                    i6++;
                }
            } else {
                next.f36438d = null;
                while (i6 < this.f36420g) {
                    n(next.j(i6));
                    n(next.k(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    private void y() throws IOException {
        com.oplus.omes.stdsco.urlcheck.LurCache.b bVar = new com.oplus.omes.stdsco.urlcheck.LurCache.b(new FileInputStream(this.f36415b), com.oplus.omes.stdsco.urlcheck.LurCache.c.f36454a);
        try {
            String d6 = bVar.d();
            String d7 = bVar.d();
            String d8 = bVar.d();
            String d9 = bVar.d();
            String d10 = bVar.d();
            if (!f36405r.equals(d6) || !"1".equals(d7) || !Integer.toString(this.f36418e).equals(d8) || !Integer.toString(this.f36420g).equals(d9) || !"".equals(d10)) {
                throw new IOException("unexpected journal header: [" + d6 + ", " + d7 + ", " + d9 + ", " + d10 + "]");
            }
            int i6 = 0;
            while (true) {
                try {
                    z(bVar.d());
                    i6++;
                } catch (EOFException unused) {
                    this.f36424k = i6 - this.f36423j.size();
                    if (bVar.c()) {
                        A();
                    } else {
                        this.f36422i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f36415b, true), com.oplus.omes.stdsco.urlcheck.LurCache.c.f36454a));
                    }
                    com.oplus.omes.stdsco.urlcheck.LurCache.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.oplus.omes.stdsco.urlcheck.LurCache.c.a(bVar);
            throw th;
        }
    }

    private void z(String line) throws IOException {
        String substring;
        int indexOf = line.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + line);
        }
        int i6 = indexOf + 1;
        int indexOf2 = line.indexOf(32, i6);
        if (indexOf2 == -1) {
            substring = line.substring(i6);
            if (indexOf == 6 && line.startsWith(f36412y)) {
                this.f36423j.remove(substring);
                return;
            }
        } else {
            substring = line.substring(i6, indexOf2);
        }
        d dVar = this.f36423j.get(substring);
        CallableC0716a callableC0716a = null;
        if (dVar == null) {
            dVar = new d(this, substring, callableC0716a);
            this.f36423j.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && line.startsWith(f36410w)) {
            String[] split = line.substring(indexOf2 + 1).split(" ");
            dVar.f36437c = true;
            dVar.f36438d = null;
            dVar.n(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && line.startsWith(f36411x)) {
            dVar.f36438d = new c(this, dVar, callableC0716a);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && line.startsWith(f36413z)) {
            return;
        }
        throw new IOException("unexpected journal line: " + line);
    }

    public c o(String key) throws IOException {
        return p(key, -1L);
    }

    public File s() {
        return this.f36414a;
    }

    private a(File directory, int appVersion, int valueCount, long maxSize) {
        this.f36414a = directory;
        this.f36418e = appVersion;
        this.f36415b = new File(directory, f36402o);
        this.f36416c = new File(directory, f36403p);
        this.f36417d = new File(directory, f36404q);
        this.f36420g = valueCount;
        this.f36419f = maxSize;
    }

    private static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public void delete() throws IOException {
        close();
        com.oplus.omes.stdsco.urlcheck.LurCache.c.b(this.f36414a);
    }
}
