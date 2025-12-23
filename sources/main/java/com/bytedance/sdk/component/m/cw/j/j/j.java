package com.bytedance.sdk.component.m.cw.j.j;

import com.bytedance.sdk.component.utils.vl;
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
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements Closeable {
    private final File ae;

    /* renamed from: g, reason: collision with root package name */
    private long f26554g;

    /* renamed from: m, reason: collision with root package name */
    private final File f26556m;
    private final int oq;

    /* renamed from: r, reason: collision with root package name */
    private final File f26557r;
    private final int tl;
    private final File up;
    private Writer vl;
    private int ws;
    final ExecutorService xt;

    /* renamed from: j, reason: collision with root package name */
    static final Pattern f26553j = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream cw = new OutputStream() { // from class: com.bytedance.sdk.component.m.cw.j.j.j.2
        @Override // java.io.OutputStream
        public void write(int i6) throws IOException {
        }
    };
    private long qv = 0;
    private final LinkedHashMap<String, xt> jy = new LinkedHashMap<>(0, 0.75f, true);
    private long az = -1;
    private long av = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Callable<Void> f26555i = new Callable<Void>() { // from class: com.bytedance.sdk.component.m.cw.j.j.j.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (j.this) {
                try {
                    if (j.this.vl == null) {
                        return null;
                    }
                    j.this.ae();
                    if (j.this.up()) {
                        j.this.r();
                        j.this.ws = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public final class cw implements Closeable {
        private final long cw;

        /* renamed from: r, reason: collision with root package name */
        private final InputStream[] f26560r;
        private final long[] up;
        private final String xt;

        private cw(String str, long j6, InputStream[] inputStreamArr, long[] jArr) {
            this.xt = str;
            this.cw = j6;
            this.f26560r = inputStreamArr;
            this.up = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f26560r) {
                com.bytedance.sdk.component.m.cw.cw.xt.j(inputStream);
            }
        }

        public InputStream j(int i6) {
            return this.f26560r[i6];
        }
    }

    /* renamed from: com.bytedance.sdk.component.m.cw.j.j.j$j, reason: collision with other inner class name */
    public final class C0412j {
        private final boolean[] cw;

        /* renamed from: r, reason: collision with root package name */
        private boolean f26562r;
        private boolean up;
        private final xt xt;

        /* renamed from: com.bytedance.sdk.component.m.cw.j.j.j$j$j, reason: collision with other inner class name */
        private class C0413j extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i6) {
                try {
                    ((FilterOutputStream) this).out.write(i6);
                } catch (IOException unused) {
                    C0412j.this.f26562r = true;
                }
            }

            private C0413j(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0412j.this.f26562r = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0412j.this.f26562r = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i6, int i7) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i6, i7);
                } catch (IOException unused) {
                    C0412j.this.f26562r = true;
                }
            }
        }

        private C0412j(xt xtVar) {
            this.xt = xtVar;
            this.cw = xtVar.f26566r ? null : new boolean[j.this.oq];
        }

        public void xt() throws IOException {
            j.this.j(this, false);
        }

        public OutputStream j(int i6) throws IOException {
            FileOutputStream fileOutputStream;
            C0413j c0413j;
            if (i6 < 0 || i6 >= j.this.oq) {
                throw new IllegalArgumentException("Expected index " + i6 + " to be greater than 0 and less than the maximum value count of " + j.this.oq);
            }
            synchronized (j.this) {
                try {
                    if (this.xt.up == this) {
                        if (!this.xt.f26566r) {
                            this.cw[i6] = true;
                        }
                        File xt = this.xt.xt(i6);
                        try {
                            fileOutputStream = new FileOutputStream(xt);
                        } catch (FileNotFoundException unused) {
                            j.this.f26557r.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(xt);
                            } catch (FileNotFoundException unused2) {
                                return j.cw;
                            }
                        }
                        c0413j = new C0413j(fileOutputStream);
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0413j;
        }

        public void j() throws IOException {
            if (this.f26562r) {
                j.this.j(this, false);
                j.this.cw(this.xt.xt);
            } else {
                j.this.j(this, true);
            }
            this.up = true;
        }
    }

    private final class xt {
        private final long[] cw;

        /* renamed from: m, reason: collision with root package name */
        private long f26565m;

        /* renamed from: r, reason: collision with root package name */
        private boolean f26566r;
        private C0412j up;
        private final String xt;

        private xt(String str) {
            this.xt = str;
            this.cw = new long[j.this.oq];
        }

        private IOException xt(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File xt(int i6) {
            return new File(j.this.f26557r, this.xt + "." + i6 + ".tmp");
        }

        public String j() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j6 : this.cw) {
                sb.append(' ');
                sb.append(j6);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(String[] strArr) throws IOException {
            if (strArr.length == j.this.oq) {
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    try {
                        this.cw[i6] = Long.parseLong(strArr[i6]);
                    } catch (NumberFormatException unused) {
                        throw xt(strArr);
                    }
                }
                return;
            }
            throw xt(strArr);
        }

        public File j(int i6) {
            return new File(j.this.f26557r, this.xt + "." + i6);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.vl == null) {
                return;
            }
            Iterator it = new ArrayList(this.jy.values()).iterator();
            while (it.hasNext()) {
                xt xtVar = (xt) it.next();
                if (xtVar.up != null) {
                    xtVar.up.xt();
                }
            }
            ae();
            this.vl.close();
            this.vl = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() throws IOException {
        long j6 = this.f26554g;
        long j7 = this.az;
        if (j7 >= 0) {
            j6 = j7;
        }
        while (this.qv > j6) {
            cw(this.jy.entrySet().iterator().next().getKey());
        }
        this.az = -1L;
    }

    private void cw() throws IOException {
        j(this.f26556m);
        Iterator<xt> it = this.jy.values().iterator();
        while (it.hasNext()) {
            xt next = it.next();
            int i6 = 0;
            if (next.up == null) {
                while (i6 < this.oq) {
                    this.qv += next.cw[i6];
                    i6++;
                }
            } else {
                next.up = null;
                while (i6 < this.oq) {
                    j(next.j(i6));
                    j(next.xt(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    private void m() {
        if (this.vl == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void r(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i6 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i6);
        if (indexOf2 == -1) {
            substring = str.substring(i6);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.jy.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i6, indexOf2);
        }
        xt xtVar = this.jy.get(substring);
        if (xtVar == null) {
            xtVar = new xt(substring);
            this.jy.put(substring, xtVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            xtVar.f26566r = true;
            xtVar.up = null;
            xtVar.j(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            xtVar.up = new C0412j(xtVar);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean up() {
        int i6 = this.ws;
        return i6 >= 2000 && i6 >= this.jy.size();
    }

    private void xt() throws IOException {
        com.bytedance.sdk.component.m.cw.j.j.cw cwVar = new com.bytedance.sdk.component.m.cw.j.j.cw(new FileInputStream(this.up), r.f26567j);
        try {
            String j6 = cwVar.j();
            String j7 = cwVar.j();
            String j8 = cwVar.j();
            String j9 = cwVar.j();
            String j10 = cwVar.j();
            if (!"libcore.io.DiskLruCache".equals(j6) || !"1".equals(j7) || !Integer.toString(this.tl).equals(j8) || !Integer.toString(this.oq).equals(j9) || !"".equals(j10)) {
                throw new IOException("unexpected journal header: [" + j6 + ", " + j7 + ", " + j9 + ", " + j10 + "]");
            }
            int i6 = 0;
            while (true) {
                try {
                    r(cwVar.j());
                    i6++;
                } catch (EOFException unused) {
                    this.ws = i6 - this.jy.size();
                    if (cwVar.xt()) {
                        r();
                    } else {
                        this.vl = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.up, true), r.f26567j));
                    }
                    com.bytedance.sdk.component.m.cw.cw.xt.j(cwVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.m.cw.cw.xt.j(cwVar);
            throw th;
        }
    }

    private j(File file, int i6, int i7, long j6, ExecutorService executorService) {
        this.f26557r = file;
        this.tl = i6;
        this.up = new File(file, "journal");
        this.f26556m = new File(file, "journal.tmp");
        this.ae = new File(file, "journal.bkp");
        this.oq = i7;
        this.f26554g = j6;
        this.xt = executorService;
    }

    public void delete() throws IOException {
        close();
        r.j(this.f26557r);
    }

    public static j j(File file, int i6, int i7, long j6, ExecutorService executorService) throws IOException {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i7 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    j(file2, file3, false);
                }
            }
            j jVar = new j(file, i6, i7, j6, executorService);
            if (jVar.up.exists()) {
                try {
                    jVar.xt();
                    jVar.cw();
                    return jVar;
                } catch (IOException e6) {
                    vl.xt("DiskLruCache ", file + " is corrupt: " + e6.getMessage() + ", removing");
                    jVar.delete();
                }
            }
            file.mkdirs();
            j jVar2 = new j(file, i6, i7, j6, executorService);
            jVar2.r();
            return jVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void up(String str) {
        if (f26553j.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized boolean cw(String str) throws IOException {
        try {
            m();
            up(str);
            xt xtVar = this.jy.get(str);
            if (xtVar != null && xtVar.up == null) {
                for (int i6 = 0; i6 < this.oq; i6++) {
                    File j6 = xtVar.j(i6);
                    if (j6.exists() && !j6.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(j6)));
                    }
                    this.qv -= xtVar.cw[i6];
                    xtVar.cw[i6] = 0;
                }
                this.ws++;
                this.vl.append((CharSequence) ("REMOVE " + str + '\n'));
                this.jy.remove(str);
                if (up()) {
                    this.xt.submit(this.f26555i);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public C0412j xt(String str) throws IOException {
        return j(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() throws IOException {
        try {
            Writer writer = this.vl;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f26556m), r.f26567j));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write("1");
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write(Integer.toString(this.tl));
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write(Integer.toString(this.oq));
                bufferedWriter.write(e.f37542d);
                bufferedWriter.write(e.f37542d);
                for (xt xtVar : this.jy.values()) {
                    if (xtVar.up != null) {
                        bufferedWriter.write("DIRTY " + xtVar.xt + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + xtVar.xt + xtVar.j() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.up.exists()) {
                    j(this.up, this.ae, true);
                }
                j(this.f26556m, this.up, false);
                this.ae.delete();
                this.vl = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.up, true), r.f26567j));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void j(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void j(File file, File file2, boolean z5) throws IOException {
        if (z5) {
            j(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:18|19|20)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        r12 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.bytedance.sdk.component.m.cw.j.j.j.cw j(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.m()     // Catch: java.lang.Throwable -> L7a
            r11.up(r12)     // Catch: java.lang.Throwable -> L7a
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.m.cw.j.j.j$xt> r0 = r11.jy     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r0 = r0.get(r12)     // Catch: java.lang.Throwable -> L7a
            com.bytedance.sdk.component.m.cw.j.j.j$xt r0 = (com.bytedance.sdk.component.m.cw.j.j.j.xt) r0     // Catch: java.lang.Throwable -> L7a
            r1 = 0
            if (r0 != 0) goto L14
            monitor-exit(r11)
            return r1
        L14:
            boolean r2 = com.bytedance.sdk.component.m.cw.j.j.j.xt.r(r0)     // Catch: java.lang.Throwable -> L7a
            if (r2 != 0) goto L1c
            monitor-exit(r11)
            return r1
        L1c:
            int r2 = r11.oq     // Catch: java.lang.Throwable -> L7a
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch: java.lang.Throwable -> L7a
            r2 = 0
            r3 = 0
        L22:
            int r4 = r11.oq     // Catch: java.io.FileNotFoundException -> L38 java.lang.Throwable -> L7a
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
            goto L8d
        L38:
            r4 = r11
            goto L7d
        L3a:
            int r1 = r11.ws     // Catch: java.lang.Throwable -> L7a
            int r1 = r1 + 1
            r11.ws = r1     // Catch: java.lang.Throwable -> L7a
            java.io.Writer r1 = r11.vl     // Catch: java.lang.Throwable -> L7a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7a
            r2.append(r12)     // Catch: java.lang.Throwable -> L7a
            r3 = 10
            r2.append(r3)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7a
            r1.append(r2)     // Catch: java.lang.Throwable -> L7a
            boolean r1 = r11.up()     // Catch: java.lang.Throwable -> L7a
            if (r1 == 0) goto L65
            java.util.concurrent.ExecutorService r1 = r11.xt     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f26555i     // Catch: java.lang.Throwable -> L34
            r1.submit(r2)     // Catch: java.lang.Throwable -> L34
        L65:
            com.bytedance.sdk.component.m.cw.j.j.j$cw r3 = new com.bytedance.sdk.component.m.cw.j.j.j$cw     // Catch: java.lang.Throwable -> L7a
            long r6 = com.bytedance.sdk.component.m.cw.j.j.j.xt.up(r0)     // Catch: java.lang.Throwable -> L7a
            long[] r9 = com.bytedance.sdk.component.m.cw.j.j.j.xt.xt(r0)     // Catch: java.lang.Throwable -> L7a
            r10 = 0
            r4 = r11
            r5 = r12
            r3.<init>(r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r11)
            return r3
        L77:
            r0 = move-exception
        L78:
            r12 = r0
            goto L8d
        L7a:
            r0 = move-exception
            r4 = r11
            goto L78
        L7d:
            int r12 = r4.oq     // Catch: java.lang.Throwable -> L77
            if (r2 >= r12) goto L8b
            r12 = r8[r2]     // Catch: java.lang.Throwable -> L77
            if (r12 == 0) goto L8b
            com.bytedance.sdk.component.m.cw.cw.xt.j(r12)     // Catch: java.lang.Throwable -> L77
            int r2 = r2 + 1
            goto L7d
        L8b:
            monitor-exit(r11)
            return r1
        L8d:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L77
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.m.cw.j.j.j.j(java.lang.String):com.bytedance.sdk.component.m.cw.j.j.j$cw");
    }

    private synchronized C0412j j(String str, long j6) throws IOException {
        m();
        up(str);
        xt xtVar = this.jy.get(str);
        if (j6 != -1 && (xtVar == null || xtVar.f26565m != j6)) {
            return null;
        }
        if (xtVar != null) {
            if (xtVar.up != null) {
                return null;
            }
        } else {
            xtVar = new xt(str);
            this.jy.put(str, xtVar);
        }
        C0412j c0412j = new C0412j(xtVar);
        xtVar.up = c0412j;
        this.vl.write("DIRTY " + str + '\n');
        this.vl.flush();
        return c0412j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(C0412j c0412j, boolean z5) throws IOException {
        xt xtVar = c0412j.xt;
        if (xtVar.up == c0412j) {
            if (z5 && !xtVar.f26566r) {
                for (int i6 = 0; i6 < this.oq; i6++) {
                    if (c0412j.cw[i6]) {
                        if (!xtVar.xt(i6).exists()) {
                            c0412j.xt();
                            return;
                        }
                    } else {
                        c0412j.xt();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i6)));
                    }
                }
            }
            for (int i7 = 0; i7 < this.oq; i7++) {
                File xt2 = xtVar.xt(i7);
                if (z5) {
                    if (xt2.exists()) {
                        File j6 = xtVar.j(i7);
                        xt2.renameTo(j6);
                        long j7 = xtVar.cw[i7];
                        long length = j6.length();
                        xtVar.cw[i7] = length;
                        this.qv = (this.qv - j7) + length;
                    }
                } else {
                    j(xt2);
                }
            }
            this.ws++;
            xtVar.up = null;
            if (!(xtVar.f26566r | z5)) {
                this.jy.remove(xtVar.xt);
                this.vl.write("REMOVE " + xtVar.xt + '\n');
            } else {
                xtVar.f26566r = true;
                this.vl.write("CLEAN " + xtVar.xt + xtVar.j() + '\n');
                if (z5) {
                    long j8 = this.av;
                    this.av = 1 + j8;
                    xtVar.f26565m = j8;
                }
            }
            this.vl.flush();
            if (this.qv > this.f26554g || up()) {
                this.xt.submit(this.f26555i);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void j() throws IOException {
        m();
        ae();
        this.vl.flush();
    }

    public void j(long j6) {
        this.az = j6;
        this.xt.submit(this.f26555i);
    }
}
