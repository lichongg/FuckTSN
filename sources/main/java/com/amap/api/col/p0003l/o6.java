package com.amap.api.col.p0003l;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o6 implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    static final Pattern f6838o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p, reason: collision with root package name */
    public static final Charset f6839p = Charset.forName("US-ASCII");

    /* renamed from: q, reason: collision with root package name */
    static final Charset f6840q = Charset.forName("UTF-8");

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadFactory f6841r;

    /* renamed from: s, reason: collision with root package name */
    static ThreadPoolExecutor f6842s;

    /* renamed from: t, reason: collision with root package name */
    private static final OutputStream f6843t;

    /* renamed from: a, reason: collision with root package name */
    private final File f6844a;

    /* renamed from: b, reason: collision with root package name */
    private final File f6845b;

    /* renamed from: c, reason: collision with root package name */
    private final File f6846c;

    /* renamed from: d, reason: collision with root package name */
    private final File f6847d;

    /* renamed from: f, reason: collision with root package name */
    private long f6849f;

    /* renamed from: i, reason: collision with root package name */
    private Writer f6852i;

    /* renamed from: l, reason: collision with root package name */
    private int f6855l;

    /* renamed from: h, reason: collision with root package name */
    private long f6851h = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f6853j = 1000;

    /* renamed from: k, reason: collision with root package name */
    private final LinkedHashMap<String, f> f6854k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m, reason: collision with root package name */
    private long f6856m = 0;

    /* renamed from: n, reason: collision with root package name */
    private final Callable<Void> f6857n = new b();

    /* renamed from: e, reason: collision with root package name */
    private final int f6848e = 1;

    /* renamed from: g, reason: collision with root package name */
    private final int f6850g = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f6858a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f6858a.getAndIncrement());
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Callable<Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (o6.this) {
                try {
                    if (o6.this.f6852i == null) {
                        return null;
                    }
                    o6.this.E();
                    if (o6.this.j()) {
                        o6.this.C();
                        o6.u(o6.this);
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final f f6860a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f6861b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6862c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6863d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class a extends FilterOutputStream {
            /* synthetic */ a(d dVar, OutputStream outputStream, byte b6) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i6) {
                try {
                    ((FilterOutputStream) this).out.write(i6);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i6, int i7) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i6, i7);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }
        }

        /* synthetic */ d(o6 o6Var, f fVar, byte b6) {
            this(fVar);
        }

        static /* synthetic */ boolean f(d dVar) {
            dVar.f6862c = true;
            return true;
        }

        private d(f fVar) {
            this.f6860a = fVar;
            this.f6861b = fVar.f6873c ? null : new boolean[o6.this.f6850g];
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (o6.this.f6850g <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + o6.this.f6850g);
            }
            synchronized (o6.this) {
                try {
                    if (this.f6860a.f6874d != this) {
                        throw new IllegalStateException();
                    }
                    byte b6 = 0;
                    if (!this.f6860a.f6873c) {
                        this.f6861b[0] = true;
                    }
                    File i6 = this.f6860a.i(0);
                    try {
                        fileOutputStream = new FileOutputStream(i6);
                    } catch (FileNotFoundException unused) {
                        o6.this.f6844a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(i6);
                        } catch (FileNotFoundException unused2) {
                            return o6.f6843t;
                        }
                    }
                    aVar = new a(this, fileOutputStream, b6);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }

        public final void c() throws IOException {
            if (this.f6862c) {
                o6.this.f(this, false);
                o6.this.q(this.f6860a.f6871a);
            } else {
                o6.this.f(this, true);
            }
            this.f6863d = true;
        }

        public final void e() throws IOException {
            o6.this.f(this, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class e implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final String f6866a;

        /* renamed from: b, reason: collision with root package name */
        private final long f6867b;

        /* renamed from: c, reason: collision with root package name */
        private final InputStream[] f6868c;

        /* renamed from: d, reason: collision with root package name */
        private final long[] f6869d;

        /* synthetic */ e(o6 o6Var, String str, long j6, InputStream[] inputStreamArr, long[] jArr, byte b6) {
            this(str, j6, inputStreamArr, jArr);
        }

        private e(String str, long j6, InputStream[] inputStreamArr, long[] jArr) {
            this.f6866a = str;
            this.f6867b = j6;
            this.f6868c = inputStreamArr;
            this.f6869d = jArr;
        }

        public final InputStream a() {
            return this.f6868c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f6868c) {
                o6.h(inputStream);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class f {

        /* renamed from: a, reason: collision with root package name */
        private final String f6871a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f6872b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6873c;

        /* renamed from: d, reason: collision with root package name */
        private d f6874d;

        /* renamed from: e, reason: collision with root package name */
        private long f6875e;

        /* synthetic */ f(o6 o6Var, String str, byte b6) {
            this(str);
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length != o6.this.f6850g) {
                throw d(strArr);
            }
            for (int i6 = 0; i6 < strArr.length; i6++) {
                try {
                    fVar.f6872b[i6] = Long.parseLong(strArr[i6]);
                } catch (NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }

        static /* synthetic */ boolean g(f fVar) {
            fVar.f6873c = true;
            return true;
        }

        private f(String str) {
            this.f6871a = str;
            this.f6872b = new long[o6.this.f6850g];
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File c(int i6) {
            return new File(o6.this.f6844a, this.f6871a + "." + i6);
        }

        public final String e() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j6 : this.f6872b) {
                sb.append(' ');
                sb.append(j6);
            }
            return sb.toString();
        }

        public final File i(int i6) {
            return new File(o6.this.f6844a, this.f6871a + "." + i6 + ".tmp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void C() throws IOException {
        try {
            Writer writer = this.f6852i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6846c), f6839p));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write("1");
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f6848e));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f6850g));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                for (f fVar : this.f6854k.values()) {
                    if (fVar.f6874d != null) {
                        bufferedWriter.write("DIRTY " + fVar.f6871a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + fVar.f6871a + fVar.e() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f6845b.exists()) {
                    j(this.f6845b, this.f6847d, true);
                }
                j(this.f6846c, this.f6845b, false);
                this.f6847d.delete();
                this.f6852i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6845b, true), f6839p));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f(d dVar, boolean z5) throws IOException {
        f fVar = dVar.f6860a;
        if (fVar.f6874d != dVar) {
            throw new IllegalStateException();
        }
        if (z5 && !fVar.f6873c) {
            for (int i6 = 0; i6 < this.f6850g; i6++) {
                if (!dVar.f6861b[i6]) {
                    dVar.e();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i6)));
                }
                if (!fVar.i(i6).exists()) {
                    dVar.e();
                    return;
                }
            }
        }
        for (int i7 = 0; i7 < this.f6850g; i7++) {
            File i8 = fVar.i(i7);
            if (!z5) {
                i(i8);
            } else if (i8.exists()) {
                File c6 = fVar.c(i7);
                i8.renameTo(c6);
                long j6 = fVar.f6872b[i7];
                long length = c6.length();
                fVar.f6872b[i7] = length;
                this.f6851h = (this.f6851h - j6) + length;
            }
        }
        this.f6855l++;
        fVar.f6874d = null;
        if (fVar.f6873c || z5) {
            f.g(fVar);
            this.f6852i.write("CLEAN " + fVar.f6871a + fVar.e() + '\n');
            if (z5) {
                long j7 = this.f6856m;
                this.f6856m = 1 + j7;
                fVar.f6875e = j7;
            }
        } else {
            this.f6854k.remove(fVar.f6871a);
            this.f6852i.write("REMOVE " + fVar.f6871a + '\n');
        }
        this.f6852i.flush();
        if (this.f6851h > this.f6849f || j()) {
            y().submit(this.f6857n);
        }
    }

    private static void j(File file, File file2, boolean z5) throws IOException {
        if (z5) {
            i(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized d r(String str) throws IOException {
        try {
            D();
            w(str);
            f fVar = this.f6854k.get(str);
            byte b6 = 0;
            if (fVar == null) {
                fVar = new f(this, str, b6);
                this.f6854k.put(str, fVar);
            } else if (fVar.f6874d != null) {
                return null;
            }
            d dVar = new d(this, fVar, b6);
            fVar.f6874d = dVar;
            this.f6852i.write("DIRTY " + str + '\n');
            this.f6852i.flush();
            return dVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    static /* synthetic */ int u(o6 o6Var) {
        o6Var.f6855l = 0;
        return 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:18|19|20)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007a, code lost:
    
        r12 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.amap.api.col.3l.o6.e a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.D()     // Catch: java.lang.Throwable -> L7c
            w(r12)     // Catch: java.lang.Throwable -> L7c
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.3l.o6$f> r0 = r11.f6854k     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L7c
            com.amap.api.col.3l.o6$f r0 = (com.amap.api.col.3l.o6.f) r0     // Catch: java.lang.Throwable -> L7c
            r1 = 0
            if (r0 != 0) goto L14
            monitor-exit(r11)
            return r1
        L14:
            boolean r2 = com.amap.api.col.3l.o6.f.l(r0)     // Catch: java.lang.Throwable -> L7c
            if (r2 != 0) goto L1c
            monitor-exit(r11)
            return r1
        L1c:
            int r2 = r11.f6850g     // Catch: java.lang.Throwable -> L7c
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch: java.lang.Throwable -> L7c
            r2 = 0
            r3 = 0
        L22:
            int r4 = r11.f6850g     // Catch: java.io.FileNotFoundException -> L38 java.lang.Throwable -> L7c
            if (r3 >= r4) goto L3a
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            java.io.File r5 = r0.c(r3)     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            r8[r3] = r4     // Catch: java.lang.Throwable -> L34 java.io.FileNotFoundException -> L38
            int r3 = r3 + 1
            goto L22
        L34:
            r0 = move-exception
            r12 = r0
            r4 = r11
            goto L8f
        L38:
            r4 = r11
            goto L7f
        L3a:
            int r1 = r11.f6855l     // Catch: java.lang.Throwable -> L7c
            int r1 = r1 + 1
            r11.f6855l = r1     // Catch: java.lang.Throwable -> L7c
            java.io.Writer r1 = r11.f6852i     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7c
            r2.append(r12)     // Catch: java.lang.Throwable -> L7c
            r3 = 10
            r2.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7c
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            boolean r1 = r11.j()     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L67
            java.util.concurrent.ThreadPoolExecutor r1 = y()     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f6857n     // Catch: java.lang.Throwable -> L34
            r1.submit(r2)     // Catch: java.lang.Throwable -> L34
        L67:
            com.amap.api.col.3l.o6$e r3 = new com.amap.api.col.3l.o6$e     // Catch: java.lang.Throwable -> L7c
            long r6 = com.amap.api.col.3l.o6.f.m(r0)     // Catch: java.lang.Throwable -> L7c
            long[] r9 = com.amap.api.col.3l.o6.f.j(r0)     // Catch: java.lang.Throwable -> L7c
            r10 = 0
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch: java.lang.Throwable -> L79
            monitor-exit(r11)
            return r3
        L79:
            r0 = move-exception
        L7a:
            r12 = r0
            goto L8f
        L7c:
            r0 = move-exception
            r4 = r11
            goto L7a
        L7f:
            int r12 = r4.f6850g     // Catch: java.lang.Throwable -> L79
            if (r2 >= r12) goto L8d
            r12 = r8[r2]     // Catch: java.lang.Throwable -> L79
            if (r12 == 0) goto L8d
            h(r12)     // Catch: java.lang.Throwable -> L79
            int r2 = r2 + 1
            goto L7f
        L8d:
            monitor-exit(r11)
            return r1
        L8f:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L79
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.o6.a(java.lang.String):com.amap.api.col.3l.o6$e");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        try {
            if (this.f6852i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f6854k.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.f6874d != null) {
                    fVar.f6874d.e();
                }
            }
            E();
            this.f6852i.close();
            this.f6852i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void o() throws IOException {
        D();
        E();
        this.f6852i.flush();
    }

    public final synchronized boolean q(String str) throws IOException {
        try {
            D();
            w(str);
            f fVar = this.f6854k.get(str);
            if (fVar != null && fVar.f6874d == null) {
                for (int i6 = 0; i6 < this.f6850g; i6++) {
                    File c6 = fVar.c(i6);
                    if (c6.exists() && !c6.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(c6)));
                    }
                    this.f6851h -= fVar.f6872b[i6];
                    fVar.f6872b[i6] = 0;
                }
                this.f6855l++;
                this.f6852i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f6854k.remove(str);
                if (j()) {
                    y().submit(this.f6857n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i6) throws IOException {
        }
    }

    static {
        a aVar = new a();
        f6841r = aVar;
        f6842s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f6843t = new c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.o6.A():void");
    }

    private void B() throws IOException {
        i(this.f6846c);
        Iterator<f> it = this.f6854k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i6 = 0;
            if (next.f6874d == null) {
                while (i6 < this.f6850g) {
                    this.f6851h += next.f6872b[i6];
                    i6++;
                }
            } else {
                next.f6874d = null;
                while (i6 < this.f6850g) {
                    i(next.c(i6));
                    i(next.i(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    private void D() {
        if (this.f6852i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() throws IOException {
        while (true) {
            if (this.f6851h <= this.f6849f && this.f6854k.size() <= this.f6853j) {
                return;
            } else {
                q(this.f6854k.entrySet().iterator().next().getKey());
            }
        }
    }

    public static o6 b(File file, long j6) throws IOException {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                j(file2, file3, false);
            }
        }
        o6 o6Var = new o6(file, j6);
        if (o6Var.f6845b.exists()) {
            try {
                o6Var.A();
                o6Var.B();
                o6Var.f6852i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(o6Var.f6845b, true), f6839p));
                return o6Var;
            } catch (Throwable unused) {
                o6Var.s();
            }
        }
        file.mkdirs();
        o6 o6Var2 = new o6(file, j6);
        o6Var2.C();
        return o6Var2;
    }

    public static void d() {
        ThreadPoolExecutor threadPoolExecutor = f6842s;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        f6842s.shutdown();
    }

    public static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    private static void w(String str) {
        if (f6838o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static ThreadPoolExecutor y() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f6842s;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f6842s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f6841r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f6842s;
    }

    public final void e(int i6) {
        if (i6 < 10) {
            i6 = 10;
        } else if (i6 > 10000) {
            i6 = 10000;
        }
        this.f6853j = i6;
    }

    public final File l() {
        return this.f6844a;
    }

    private o6(File file, long j6) {
        this.f6844a = file;
        this.f6845b = new File(file, "journal");
        this.f6846c = new File(file, "journal.tmp");
        this.f6847d = new File(file, "journal.bkp");
        this.f6849f = j6;
    }

    private static void i(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void n(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    n(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    public final d k(String str) throws IOException {
        return r(str);
    }

    public final void s() throws IOException {
        close();
        n(this.f6844a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        int i6 = this.f6855l;
        return i6 >= 2000 && i6 >= this.f6854k.size();
    }
}
