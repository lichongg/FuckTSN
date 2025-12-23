package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.utils.w;
import com.snail.antifake.deviceid.e;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements Closeable {
    static final Pattern aCC = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aCR = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i6) {
        }
    };
    private final File aCD;
    private final File aCE;
    private final File aCF;
    private final File aCG;
    private final int aCH;
    private int aCI;
    private final int aCJ;
    private Writer aCL;
    private int aCN;
    private long maxSize;
    private long size = 0;
    private int aCK = 0;
    private final LinkedHashMap<String, b> aCM = new LinkedHashMap<>(0, 0.75f, true);
    private long aCO = 0;
    final ThreadPoolExecutor aCP = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aCQ = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: GF, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.aCL == null) {
                        return null;
                    }
                    a.this.trimToSize();
                    a.this.GL();
                    if (a.this.GK()) {
                        a.this.GI();
                        a.a(a.this, 0);
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    public final class C0678a {
        private final b aCT;
        private final boolean[] aCU;
        private boolean aCV;
        private boolean aCW;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        class C0679a extends FilterOutputStream {
            /* synthetic */ C0679a(C0678a c0678a, OutputStream outputStream, byte b6) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i6) {
                try {
                    ((FilterOutputStream) this).out.write(i6);
                } catch (IOException unused) {
                    C0678a.b(C0678a.this, true);
                }
            }

            private C0679a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0678a.b(C0678a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0678a.b(C0678a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i6, int i7) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i6, i7);
                } catch (IOException unused) {
                    C0678a.b(C0678a.this, true);
                }
            }
        }

        /* synthetic */ C0678a(a aVar, b bVar, byte b6) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0678a c0678a, boolean z5) {
            c0678a.aCV = true;
            return true;
        }

        private C0678a(b bVar) {
            this.aCT = bVar;
            this.aCU = bVar.aCZ ? null : new boolean[a.this.aCJ];
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aCV) {
                a.this.a(this, false);
                a.this.remove(this.aCT.key);
            } else {
                a.this.a(this, true);
            }
            this.aCW = true;
        }

        public final OutputStream ds(int i6) {
            FileOutputStream fileOutputStream;
            C0679a c0679a;
            synchronized (a.this) {
                try {
                    if (this.aCT.aDa != this) {
                        throw new IllegalStateException();
                    }
                    byte b6 = 0;
                    if (!this.aCT.aCZ) {
                        this.aCU[0] = true;
                    }
                    File du = this.aCT.du(0);
                    try {
                        fileOutputStream = new FileOutputStream(du);
                    } catch (FileNotFoundException unused) {
                        a.this.aCD.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(du);
                        } catch (FileNotFoundException unused2) {
                            return a.aCR;
                        }
                    }
                    c0679a = new C0679a(this, fileOutputStream, b6);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0679a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b {
        private final long[] aCY;
        private boolean aCZ;
        private C0678a aDa;
        private long aDb;
        private final String key;

        /* synthetic */ b(a aVar, String str, byte b6) {
            this(str);
        }

        private b(String str) {
            this.key = str;
            this.aCY = new long[a.this.aCJ];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length != a.this.aCJ) {
                throw c(strArr);
            }
            for (int i6 = 0; i6 < strArr.length; i6++) {
                try {
                    this.aCY[i6] = Long.parseLong(strArr[i6]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final String GN() {
            StringBuilder sb = new StringBuilder();
            for (long j6 : this.aCY) {
                sb.append(' ');
                sb.append(j6);
            }
            return sb.toString();
        }

        public final File dt(int i6) {
            return new File(a.this.aCD, this.key + i6);
        }

        public final File du(int i6) {
            return new File(a.this.aCD, this.key + i6 + ".tmp");
        }

        static /* synthetic */ boolean a(b bVar, boolean z5) {
            bVar.aCZ = true;
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class c implements Closeable {
        private final long[] aCY;
        private final long aDb;
        private File[] aDc;
        private final InputStream[] aDd;
        private final String key;

        /* synthetic */ c(a aVar, String str, long j6, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b6) {
            this(str, j6, fileArr, inputStreamArr, jArr);
        }

        private c(String str, long j6, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aDb = j6;
            this.aDc = fileArr;
            this.aDd = inputStreamArr;
            this.aCY = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aDd) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dv(int i6) {
            return this.aDc[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void GI() {
        try {
            Writer writer = this.aCL;
            if (writer != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aCF), com.kwad.sdk.crash.utils.a.US_ASCII));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write("1");
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write(Integer.toString(this.aCH));
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write(Integer.toString(this.aCJ));
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write(e.f37542d);
                for (b bVar : this.aCM.values()) {
                    if (bVar.aDa != null) {
                        bufferedWriter.write("DIRTY " + bVar.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.key + bVar.GN() + '\n');
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                if (this.aCE.exists()) {
                    a(this.aCE, this.aCG, true);
                }
                a(this.aCF, this.aCE, false);
                this.aCG.delete();
                this.aCL = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aCE, true), com.kwad.sdk.crash.utils.a.US_ASCII));
            } catch (Throwable th) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    static /* synthetic */ int a(a aVar, int i6) {
        aVar.aCN = 0;
        return 0;
    }

    public final synchronized int GJ() {
        return this.aCI;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.aCL == null) {
                return;
            }
            Iterator it = new ArrayList(this.aCM.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.aDa != null) {
                    bVar.aDa.abort();
                }
            }
            trimToSize();
            GL();
            com.kwad.sdk.crash.utils.b.closeQuietly(this.aCL);
            this.aCL = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:22|23|24)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
    
        r13 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.kwad.sdk.core.diskcache.a.a.c dD(java.lang.String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.io.Writer r0 = r12.aCL     // Catch: java.lang.Throwable -> L81
            r1 = 0
            if (r0 != 0) goto L8
            monitor-exit(r12)
            return r1
        L8:
            dF(r13)     // Catch: java.lang.Throwable -> L81
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r0 = r12.aCM     // Catch: java.lang.Throwable -> L81
            java.lang.Object r0 = r0.get(r13)     // Catch: java.lang.Throwable -> L81
            com.kwad.sdk.core.diskcache.a.a$b r0 = (com.kwad.sdk.core.diskcache.a.a.b) r0     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L17
            monitor-exit(r12)
            return r1
        L17:
            boolean r2 = com.kwad.sdk.core.diskcache.a.a.b.d(r0)     // Catch: java.lang.Throwable -> L81
            if (r2 != 0) goto L1f
            monitor-exit(r12)
            return r1
        L1f:
            int r2 = r12.aCJ     // Catch: java.lang.Throwable -> L81
            java.io.File[] r8 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L81
            java.io.InputStream[] r9 = new java.io.InputStream[r2]     // Catch: java.lang.Throwable -> L81
            r2 = 0
            r3 = 0
        L27:
            int r4 = r12.aCJ     // Catch: java.io.FileNotFoundException -> L3f java.lang.Throwable -> L81
            if (r3 >= r4) goto L41
            java.io.File r4 = r0.dt(r3)     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r8[r3] = r4     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            r9[r3] = r5     // Catch: java.lang.Throwable -> L3b java.io.FileNotFoundException -> L3f
            int r3 = r3 + 1
            goto L27
        L3b:
            r0 = move-exception
            r13 = r0
            r4 = r12
            goto L94
        L3f:
            r4 = r12
            goto L84
        L41:
            int r1 = r12.aCN     // Catch: java.lang.Throwable -> L81
            int r1 = r1 + 1
            r12.aCN = r1     // Catch: java.lang.Throwable -> L81
            java.io.Writer r1 = r12.aCL     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L81
            r2.append(r13)     // Catch: java.lang.Throwable -> L81
            r3 = 10
            r2.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L81
            r1.append(r2)     // Catch: java.lang.Throwable -> L81
            boolean r1 = r12.GK()     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L6c
            java.util.concurrent.ThreadPoolExecutor r1 = r12.aCP     // Catch: java.lang.Throwable -> L3b
            java.util.concurrent.Callable<java.lang.Void> r2 = r12.aCQ     // Catch: java.lang.Throwable -> L3b
            r1.submit(r2)     // Catch: java.lang.Throwable -> L3b
        L6c:
            com.kwad.sdk.core.diskcache.a.a$c r3 = new com.kwad.sdk.core.diskcache.a.a$c     // Catch: java.lang.Throwable -> L81
            long r6 = com.kwad.sdk.core.diskcache.a.a.b.e(r0)     // Catch: java.lang.Throwable -> L81
            long[] r10 = com.kwad.sdk.core.diskcache.a.a.b.b(r0)     // Catch: java.lang.Throwable -> L81
            r11 = 0
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r12)
            return r3
        L7e:
            r0 = move-exception
        L7f:
            r13 = r0
            goto L94
        L81:
            r0 = move-exception
            r4 = r12
            goto L7f
        L84:
            int r13 = r4.aCJ     // Catch: java.lang.Throwable -> L7e
            if (r2 >= r13) goto L92
            r13 = r9[r2]     // Catch: java.lang.Throwable -> L7e
            if (r13 == 0) goto L92
            com.kwad.sdk.crash.utils.b.closeQuietly(r13)     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 + 1
            goto L84
        L92:
            monitor-exit(r12)
            return r1
        L94:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L7e
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.a.a.dD(java.lang.String):com.kwad.sdk.core.diskcache.a.a$c");
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        GL();
        this.aCL.flush();
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        try {
            checkNotClosed();
            dF(str);
            b bVar = this.aCM.get(str);
            if (bVar != null && bVar.aDa == null) {
                for (int i6 = 0; i6 < this.aCJ; i6++) {
                    File dt = bVar.dt(i6);
                    if (dt.exists() && !dt.delete()) {
                        throw new IOException("failed to delete " + dt);
                    }
                    this.size -= bVar.aCY[i6];
                    this.aCK--;
                    bVar.aCY[i6] = 0;
                }
                this.aCN++;
                this.aCL.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aCM.remove(str);
                if (GK()) {
                    this.aCP.submit(this.aCQ);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    private a(File file, int i6, int i7, long j6, int i8) {
        this.aCD = file;
        this.aCH = i6;
        this.aCE = new File(file, "journal");
        this.aCF = new File(file, "journal.tmp");
        this.aCG = new File(file, "journal.bkp");
        this.aCJ = i7;
        this.maxSize = j6;
        this.aCI = i8;
    }

    private void GG() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.aCE), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aCH).equals(readLine3) || !Integer.toString(this.aCJ).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i6 = 0;
            while (true) {
                try {
                    dC(bVar.readLine());
                    i6++;
                } catch (EOFException unused) {
                    this.aCN = i6 - this.aCM.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void GH() {
        p(this.aCF);
        Iterator<b> it = this.aCM.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i6 = 0;
            if (next.aDa == null) {
                while (i6 < this.aCJ) {
                    this.size += next.aCY[i6];
                    this.aCK++;
                    i6++;
                }
            } else {
                next.aDa = null;
                while (i6 < this.aCJ) {
                    p(next.dt(i6));
                    p(next.du(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GK() {
        int i6 = this.aCN;
        return i6 >= 2000 && i6 >= this.aCM.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GL() {
        while (this.aCK > this.aCI) {
            remove(this.aCM.entrySet().iterator().next().getKey());
        }
    }

    private void checkNotClosed() {
        if (this.aCL == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void dC(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i6 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i6);
        if (indexOf2 == -1) {
            substring = str.substring(i6);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.aCM.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i6, indexOf2);
        }
        b bVar = this.aCM.get(substring);
        byte b6 = 0;
        if (bVar == null) {
            bVar = new b(this, substring, b6);
            this.aCM.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aDa = null;
            bVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.aDa = new C0678a(this, bVar, b6);
        } else {
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void dF(String str) {
        if (aCC.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private synchronized C0678a e(String str, long j6) {
        try {
            checkNotClosed();
            dF(str);
            b bVar = this.aCM.get(str);
            byte b6 = 0;
            if (bVar == null) {
                bVar = new b(this, str, b6);
                this.aCM.put(str, bVar);
            } else if (bVar.aDa != null) {
                return null;
            }
            C0678a c0678a = new C0678a(this, bVar, b6);
            bVar.aDa = c0678a;
            this.aCL.write("DIRTY " + str + '\n');
            this.aCL.flush();
            return c0678a;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aCM.entrySet().iterator().next().getKey());
        }
    }

    public final C0678a dE(String str) {
        return e(str, -1L);
    }

    public final File getDirectory() {
        return this.aCD;
    }

    private static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final void delete() {
        close();
        w.deleteContents(this.aCD);
    }

    public static a a(File file, int i6, int i7, long j6) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i6, int i7, long j6, int i8) {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i8 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i7 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i6, i7, j6, i8);
            if (aVar.aCE.exists()) {
                try {
                    aVar.GG();
                    aVar.GH();
                    aVar.aCL = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aCE, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e6) {
                    PrintStream printStream = System.out;
                    Objects.toString(file);
                    e6.getMessage();
                    printStream.getClass();
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i6, i7, j6, i8);
            aVar2.GI();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z5) {
        if (z5) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0678a c0678a, boolean z5) {
        b bVar = c0678a.aCT;
        if (bVar.aDa == c0678a) {
            if (z5 && !bVar.aCZ) {
                for (int i6 = 0; i6 < this.aCJ; i6++) {
                    if (c0678a.aCU[i6]) {
                        if (!bVar.du(i6).exists()) {
                            c0678a.abort();
                            return;
                        }
                    } else {
                        c0678a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i6);
                    }
                }
            }
            for (int i7 = 0; i7 < this.aCJ; i7++) {
                File du = bVar.du(i7);
                if (z5) {
                    if (du.exists()) {
                        File dt = bVar.dt(i7);
                        du.renameTo(dt);
                        long j6 = bVar.aCY[i7];
                        long length = dt.length();
                        bVar.aCY[i7] = length;
                        this.size = (this.size - j6) + length;
                        this.aCK++;
                    }
                } else {
                    p(du);
                }
            }
            this.aCN++;
            bVar.aDa = null;
            if (!(bVar.aCZ | z5)) {
                this.aCM.remove(bVar.key);
                this.aCL.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.aCL.write("CLEAN " + bVar.key + bVar.GN() + '\n');
                if (z5) {
                    long j7 = this.aCO;
                    this.aCO = 1 + j7;
                    bVar.aDb = j7;
                }
            }
            this.aCL.flush();
            if (this.size > this.maxSize || this.aCK > this.aCI || GK()) {
                this.aCP.submit(this.aCQ);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
