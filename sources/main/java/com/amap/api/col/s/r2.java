package com.amap.api.col.s;

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
public final class r2 implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    static final Pattern f8379o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p, reason: collision with root package name */
    public static final Charset f8380p = Charset.forName("US-ASCII");

    /* renamed from: q, reason: collision with root package name */
    static final Charset f8381q = Charset.forName("UTF-8");

    /* renamed from: r, reason: collision with root package name */
    private static final ThreadFactory f8382r;

    /* renamed from: s, reason: collision with root package name */
    static ThreadPoolExecutor f8383s;

    /* renamed from: t, reason: collision with root package name */
    private static final OutputStream f8384t;

    /* renamed from: a, reason: collision with root package name */
    private final File f8385a;

    /* renamed from: b, reason: collision with root package name */
    private final File f8386b;

    /* renamed from: c, reason: collision with root package name */
    private final File f8387c;

    /* renamed from: d, reason: collision with root package name */
    private final File f8388d;

    /* renamed from: f, reason: collision with root package name */
    private long f8390f;

    /* renamed from: i, reason: collision with root package name */
    private Writer f8393i;

    /* renamed from: l, reason: collision with root package name */
    private int f8396l;

    /* renamed from: h, reason: collision with root package name */
    private long f8392h = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f8394j = 1000;

    /* renamed from: k, reason: collision with root package name */
    private final LinkedHashMap<String, f> f8395k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m, reason: collision with root package name */
    private long f8397m = 0;

    /* renamed from: n, reason: collision with root package name */
    private final Callable<Void> f8398n = new b();

    /* renamed from: e, reason: collision with root package name */
    private final int f8389e = 1;

    /* renamed from: g, reason: collision with root package name */
    private final int f8391g = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f8399a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f8399a.getAndIncrement());
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
            synchronized (r2.this) {
                try {
                    if (r2.this.f8393i == null) {
                        return null;
                    }
                    r2.this.E();
                    if (r2.this.C()) {
                        r2.this.B();
                        r2.u(r2.this);
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
        private final f f8401a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f8402b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8403c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8404d;

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

        /* synthetic */ d(r2 r2Var, f fVar, byte b6) {
            this(fVar);
        }

        static /* synthetic */ boolean f(d dVar) {
            dVar.f8403c = true;
            return true;
        }

        private d(f fVar) {
            this.f8401a = fVar;
            this.f8402b = fVar.f8414c ? null : new boolean[r2.this.f8391g];
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (r2.this.f8391g <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + r2.this.f8391g);
            }
            synchronized (r2.this) {
                try {
                    if (this.f8401a.f8415d != this) {
                        throw new IllegalStateException();
                    }
                    byte b6 = 0;
                    if (!this.f8401a.f8414c) {
                        this.f8402b[0] = true;
                    }
                    File i6 = this.f8401a.i(0);
                    try {
                        fileOutputStream = new FileOutputStream(i6);
                    } catch (FileNotFoundException unused) {
                        r2.this.f8385a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(i6);
                        } catch (FileNotFoundException unused2) {
                            return r2.f8384t;
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
            if (this.f8403c) {
                r2.this.f(this, false);
                r2.this.q(this.f8401a.f8412a);
            } else {
                r2.this.f(this, true);
            }
            this.f8404d = true;
        }

        public final void e() throws IOException {
            r2.this.f(this, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class e implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final String f8407a;

        /* renamed from: b, reason: collision with root package name */
        private final long f8408b;

        /* renamed from: c, reason: collision with root package name */
        private final InputStream[] f8409c;

        /* renamed from: d, reason: collision with root package name */
        private final long[] f8410d;

        /* synthetic */ e(r2 r2Var, String str, long j6, InputStream[] inputStreamArr, long[] jArr, byte b6) {
            this(str, j6, inputStreamArr, jArr);
        }

        private e(String str, long j6, InputStream[] inputStreamArr, long[] jArr) {
            this.f8407a = str;
            this.f8408b = j6;
            this.f8409c = inputStreamArr;
            this.f8410d = jArr;
        }

        public final InputStream a() {
            return this.f8409c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f8409c) {
                r2.h(inputStream);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class f {

        /* renamed from: a, reason: collision with root package name */
        private final String f8412a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f8413b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8414c;

        /* renamed from: d, reason: collision with root package name */
        private d f8415d;

        /* renamed from: e, reason: collision with root package name */
        private long f8416e;

        /* synthetic */ f(r2 r2Var, String str, byte b6) {
            this(str);
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length != r2.this.f8391g) {
                throw d(strArr);
            }
            for (int i6 = 0; i6 < strArr.length; i6++) {
                try {
                    fVar.f8413b[i6] = Long.parseLong(strArr[i6]);
                } catch (NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }

        static /* synthetic */ boolean g(f fVar) {
            fVar.f8414c = true;
            return true;
        }

        private f(String str) {
            this.f8412a = str;
            this.f8413b = new long[r2.this.f8391g];
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File c(int i6) {
            return new File(r2.this.f8385a, this.f8412a + "." + i6);
        }

        public final String e() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j6 : this.f8413b) {
                sb.append(' ');
                sb.append(j6);
            }
            return sb.toString();
        }

        public final File i(int i6) {
            return new File(r2.this.f8385a, this.f8412a + "." + i6 + ".tmp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void B() throws IOException {
        try {
            Writer writer = this.f8393i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8387c), f8380p));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write("1");
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f8389e));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f8391g));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                for (f fVar : this.f8395k.values()) {
                    if (fVar.f8415d != null) {
                        bufferedWriter.write("DIRTY " + fVar.f8412a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + fVar.f8412a + fVar.e() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f8386b.exists()) {
                    j(this.f8386b, this.f8388d, true);
                }
                j(this.f8387c, this.f8386b, false);
                this.f8388d.delete();
                this.f8393i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8386b, true), f8380p));
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
        f fVar = dVar.f8401a;
        if (fVar.f8415d != dVar) {
            throw new IllegalStateException();
        }
        if (z5 && !fVar.f8414c) {
            for (int i6 = 0; i6 < this.f8391g; i6++) {
                if (!dVar.f8402b[i6]) {
                    dVar.e();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i6)));
                }
                if (!fVar.i(i6).exists()) {
                    dVar.e();
                    return;
                }
            }
        }
        for (int i7 = 0; i7 < this.f8391g; i7++) {
            File i8 = fVar.i(i7);
            if (!z5) {
                i(i8);
            } else if (i8.exists()) {
                File c6 = fVar.c(i7);
                i8.renameTo(c6);
                long j6 = fVar.f8413b[i7];
                long length = c6.length();
                fVar.f8413b[i7] = length;
                this.f8392h = (this.f8392h - j6) + length;
            }
        }
        this.f8396l++;
        fVar.f8415d = null;
        if (fVar.f8414c || z5) {
            f.g(fVar);
            this.f8393i.write("CLEAN " + fVar.f8412a + fVar.e() + '\n');
            if (z5) {
                long j7 = this.f8397m;
                this.f8397m = 1 + j7;
                fVar.f8416e = j7;
            }
        } else {
            this.f8395k.remove(fVar.f8412a);
            this.f8393i.write("REMOVE " + fVar.f8412a + '\n');
        }
        this.f8393i.flush();
        if (this.f8392h > this.f8390f || C()) {
            v().submit(this.f8398n);
        }
    }

    private synchronized d r(String str) throws IOException {
        try {
            D();
            w(str);
            f fVar = this.f8395k.get(str);
            byte b6 = 0;
            if (fVar == null) {
                fVar = new f(this, str, b6);
                this.f8395k.put(str, fVar);
            } else if (fVar.f8415d != null) {
                return null;
            }
            d dVar = new d(this, fVar, b6);
            fVar.f8415d = dVar;
            this.f8393i.write("DIRTY " + str + '\n');
            this.f8393i.flush();
            return dVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    static /* synthetic */ int u(r2 r2Var) {
        r2Var.f8396l = 0;
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
    public final synchronized com.amap.api.col.s.r2.e a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.D()     // Catch: java.lang.Throwable -> L7c
            w(r12)     // Catch: java.lang.Throwable -> L7c
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.s.r2$f> r0 = r11.f8395k     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L7c
            com.amap.api.col.s.r2$f r0 = (com.amap.api.col.s.r2.f) r0     // Catch: java.lang.Throwable -> L7c
            r1 = 0
            if (r0 != 0) goto L14
            monitor-exit(r11)
            return r1
        L14:
            boolean r2 = com.amap.api.col.s.r2.f.l(r0)     // Catch: java.lang.Throwable -> L7c
            if (r2 != 0) goto L1c
            monitor-exit(r11)
            return r1
        L1c:
            int r2 = r11.f8391g     // Catch: java.lang.Throwable -> L7c
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch: java.lang.Throwable -> L7c
            r2 = 0
            r3 = 0
        L22:
            int r4 = r11.f8391g     // Catch: java.io.FileNotFoundException -> L38 java.lang.Throwable -> L7c
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
            int r1 = r11.f8396l     // Catch: java.lang.Throwable -> L7c
            int r1 = r1 + 1
            r11.f8396l = r1     // Catch: java.lang.Throwable -> L7c
            java.io.Writer r1 = r11.f8393i     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7c
            r2.append(r12)     // Catch: java.lang.Throwable -> L7c
            r3 = 10
            r2.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7c
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            boolean r1 = r11.C()     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L67
            java.util.concurrent.ThreadPoolExecutor r1 = v()     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f8398n     // Catch: java.lang.Throwable -> L34
            r1.submit(r2)     // Catch: java.lang.Throwable -> L34
        L67:
            com.amap.api.col.s.r2$e r3 = new com.amap.api.col.s.r2$e     // Catch: java.lang.Throwable -> L7c
            long r6 = com.amap.api.col.s.r2.f.m(r0)     // Catch: java.lang.Throwable -> L7c
            long[] r9 = com.amap.api.col.s.r2.f.j(r0)     // Catch: java.lang.Throwable -> L7c
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
            int r12 = r4.f8391g     // Catch: java.lang.Throwable -> L79
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r2.a(java.lang.String):com.amap.api.col.s.r2$e");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        try {
            if (this.f8393i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f8395k.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.f8415d != null) {
                    fVar.f8415d.e();
                }
            }
            E();
            this.f8393i.close();
            this.f8393i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void l() throws IOException {
        D();
        E();
        this.f8393i.flush();
    }

    public final synchronized boolean q(String str) throws IOException {
        try {
            D();
            w(str);
            f fVar = this.f8395k.get(str);
            if (fVar != null && fVar.f8415d == null) {
                for (int i6 = 0; i6 < this.f8391g; i6++) {
                    File c6 = fVar.c(i6);
                    if (c6.exists() && !c6.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(c6)));
                    }
                    this.f8392h -= fVar.f8413b[i6];
                    fVar.f8413b[i6] = 0;
                }
                this.f8396l++;
                this.f8393i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f8395k.remove(str);
                if (C()) {
                    v().submit(this.f8398n);
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
        f8382r = aVar;
        f8383s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f8384t = new c();
    }

    private void A() throws IOException {
        i(this.f8387c);
        Iterator<f> it = this.f8395k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i6 = 0;
            if (next.f8415d == null) {
                while (i6 < this.f8391g) {
                    this.f8392h += next.f8413b[i6];
                    i6++;
                }
            } else {
                next.f8415d = null;
                while (i6 < this.f8391g) {
                    i(next.c(i6));
                    i(next.i(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        int i6 = this.f8396l;
        return i6 >= 2000 && i6 >= this.f8395k.size();
    }

    private void D() {
        if (this.f8393i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() throws IOException {
        while (true) {
            if (this.f8392h <= this.f8390f && this.f8395k.size() <= this.f8394j) {
                return;
            } else {
                q(this.f8395k.entrySet().iterator().next().getKey());
            }
        }
    }

    public static r2 b(File file, long j6) throws IOException {
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
        r2 r2Var = new r2(file, j6);
        if (r2Var.f8386b.exists()) {
            try {
                r2Var.y();
                r2Var.A();
                r2Var.f8393i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r2Var.f8386b, true), f8380p));
                return r2Var;
            } catch (Throwable unused) {
                r2Var.o();
            }
        }
        file.mkdirs();
        r2 r2Var2 = new r2(file, j6);
        r2Var2.B();
        return r2Var2;
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

    private static void j(File file, File file2, boolean z5) throws IOException {
        if (z5) {
            i(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static ThreadPoolExecutor v() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f8383s;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f8383s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f8382r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f8383s;
    }

    private static void w(String str) {
        if (f8379o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void y() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r2.y():void");
    }

    public final File c() {
        return this.f8385a;
    }

    public final void e(int i6) {
        if (i6 < 10) {
            i6 = 10;
        } else if (i6 > 10000) {
            i6 = 10000;
        }
        this.f8394j = i6;
    }

    private r2(File file, long j6) {
        this.f8385a = file;
        this.f8386b = new File(file, "journal");
        this.f8387c = new File(file, "journal.tmp");
        this.f8388d = new File(file, "journal.bkp");
        this.f8390f = j6;
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

    public final void o() throws IOException {
        close();
        n(this.f8385a);
    }
}
