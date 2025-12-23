package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    static final String f14735o = "journal";

    /* renamed from: p, reason: collision with root package name */
    static final String f14736p = "journal.tmp";

    /* renamed from: q, reason: collision with root package name */
    static final String f14737q = "journal.bkp";

    /* renamed from: r, reason: collision with root package name */
    static final String f14738r = "libcore.io.DiskLruCache";

    /* renamed from: s, reason: collision with root package name */
    static final String f14739s = "1";

    /* renamed from: t, reason: collision with root package name */
    static final long f14740t = -1;

    /* renamed from: u, reason: collision with root package name */
    private static final String f14741u = "CLEAN";

    /* renamed from: v, reason: collision with root package name */
    private static final String f14742v = "DIRTY";

    /* renamed from: w, reason: collision with root package name */
    private static final String f14743w = "REMOVE";

    /* renamed from: x, reason: collision with root package name */
    private static final String f14744x = "READ";

    /* renamed from: a, reason: collision with root package name */
    private final File f14745a;

    /* renamed from: b, reason: collision with root package name */
    private final File f14746b;

    /* renamed from: c, reason: collision with root package name */
    private final File f14747c;

    /* renamed from: d, reason: collision with root package name */
    private final File f14748d;

    /* renamed from: e, reason: collision with root package name */
    private final int f14749e;

    /* renamed from: f, reason: collision with root package name */
    private long f14750f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14751g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f14753i;

    /* renamed from: k, reason: collision with root package name */
    private int f14755k;

    /* renamed from: h, reason: collision with root package name */
    private long f14752h = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f14754j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    private long f14756l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f14757m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0149b(null));

    /* renamed from: n, reason: collision with root package name */
    private final Callable<Void> f14758n = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (b.this) {
                try {
                    if (b.this.f14753i == null) {
                        return null;
                    }
                    b.this.E();
                    if (b.this.v()) {
                        b.this.A();
                        b.this.f14755k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.disklrucache.b$b, reason: collision with other inner class name */
    private static final class ThreadFactoryC0149b implements ThreadFactory {
        private ThreadFactoryC0149b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ ThreadFactoryC0149b(a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f14760a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f14761b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f14762c;

        /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }

        public void i(int i6, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(f(i6)), com.bumptech.glide.disklrucache.d.f14786b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                com.bumptech.glide.disklrucache.d.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                com.bumptech.glide.disklrucache.d.a(outputStreamWriter2);
                throw th;
            }
        }

        private c(d dVar) {
            this.f14760a = dVar;
            this.f14761b = dVar.f14768e ? null : new boolean[b.this.f14751g];
        }

        private InputStream h(int i6) throws IOException {
            synchronized (b.this) {
                if (this.f14760a.f14769f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f14760a.f14768e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f14760a.j(i6));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public void a() throws IOException {
            b.this.m(this, false);
        }

        public void b() {
            if (this.f14762c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            b.this.m(this, true);
            this.f14762c = true;
        }

        public File f(int i6) throws IOException {
            File k6;
            synchronized (b.this) {
                try {
                    if (this.f14760a.f14769f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f14760a.f14768e) {
                        this.f14761b[i6] = true;
                    }
                    k6 = this.f14760a.k(i6);
                    b.this.f14745a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return k6;
        }

        public String g(int i6) throws IOException {
            InputStream h6 = h(i6);
            if (h6 != null) {
                return b.u(h6);
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f14764a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f14765b;

        /* renamed from: c, reason: collision with root package name */
        File[] f14766c;

        /* renamed from: d, reason: collision with root package name */
        File[] f14767d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f14768e;

        /* renamed from: f, reason: collision with root package name */
        private c f14769f;

        /* renamed from: g, reason: collision with root package name */
        private long f14770g;

        /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != b.this.f14751g) {
                throw m(strArr);
            }
            for (int i6 = 0; i6 < strArr.length; i6++) {
                try {
                    this.f14765b[i6] = Long.parseLong(strArr[i6]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        private d(String str) {
            this.f14764a = str;
            this.f14765b = new long[b.this.f14751g];
            this.f14766c = new File[b.this.f14751g];
            this.f14767d = new File[b.this.f14751g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i6 = 0; i6 < b.this.f14751g; i6++) {
                sb.append(i6);
                this.f14766c[i6] = new File(b.this.f14745a, sb.toString());
                sb.append(".tmp");
                this.f14767d[i6] = new File(b.this.f14745a, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File j(int i6) {
            return this.f14766c[i6];
        }

        public File k(int i6) {
            return this.f14767d[i6];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j6 : this.f14765b) {
                sb.append(' ');
                sb.append(j6);
            }
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f14772a;

        /* renamed from: b, reason: collision with root package name */
        private final long f14773b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f14774c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f14775d;

        /* synthetic */ e(b bVar, String str, long j6, File[] fileArr, long[] jArr, a aVar) {
            this(str, j6, fileArr, jArr);
        }

        private e(String str, long j6, File[] fileArr, long[] jArr) {
            this.f14772a = str;
            this.f14773b = j6;
            this.f14775d = fileArr;
            this.f14774c = jArr;
        }

        public c a() throws IOException {
            return b.this.p(this.f14772a, this.f14773b);
        }

        public File b(int i6) {
            return this.f14775d[i6];
        }

        public long c(int i6) {
            return this.f14774c[i6];
        }

        public String d(int i6) throws IOException {
            return b.u(new FileInputStream(this.f14775d[i6]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A() throws IOException {
        try {
            Writer writer = this.f14753i;
            if (writer != null) {
                l(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14747c), com.bumptech.glide.disklrucache.d.f14785a));
            try {
                bufferedWriter.write(f14738r);
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write("1");
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f14749e));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(Integer.toString(this.f14751g));
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                bufferedWriter.write(com.snail.antifake.deviceid.e.f37542d);
                for (d dVar : this.f14754j.values()) {
                    if (dVar.f14769f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f14764a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f14764a + dVar.l() + '\n');
                    }
                }
                l(bufferedWriter);
                if (this.f14746b.exists()) {
                    C(this.f14746b, this.f14748d, true);
                }
                C(this.f14747c, this.f14746b, false);
                this.f14748d.delete();
                this.f14753i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14746b, true), com.bumptech.glide.disklrucache.d.f14785a));
            } catch (Throwable th) {
                l(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(c cVar, boolean z5) throws IOException {
        d dVar = cVar.f14760a;
        if (dVar.f14769f != cVar) {
            throw new IllegalStateException();
        }
        if (z5 && !dVar.f14768e) {
            for (int i6 = 0; i6 < this.f14751g; i6++) {
                if (!cVar.f14761b[i6]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i6);
                }
                if (!dVar.k(i6).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i7 = 0; i7 < this.f14751g; i7++) {
            File k6 = dVar.k(i7);
            if (!z5) {
                n(k6);
            } else if (k6.exists()) {
                File j6 = dVar.j(i7);
                k6.renameTo(j6);
                long j7 = dVar.f14765b[i7];
                long length = j6.length();
                dVar.f14765b[i7] = length;
                this.f14752h = (this.f14752h - j7) + length;
            }
        }
        this.f14755k++;
        dVar.f14769f = null;
        if (dVar.f14768e || z5) {
            dVar.f14768e = true;
            this.f14753i.append((CharSequence) f14741u);
            this.f14753i.append(' ');
            this.f14753i.append((CharSequence) dVar.f14764a);
            this.f14753i.append((CharSequence) dVar.l());
            this.f14753i.append('\n');
            if (z5) {
                long j8 = this.f14756l;
                this.f14756l = 1 + j8;
                dVar.f14770g = j8;
            }
        } else {
            this.f14754j.remove(dVar.f14764a);
            this.f14753i.append((CharSequence) f14743w);
            this.f14753i.append(' ');
            this.f14753i.append((CharSequence) dVar.f14764a);
            this.f14753i.append('\n');
        }
        q(this.f14753i);
        if (this.f14752h > this.f14750f || v()) {
            this.f14757m.submit(this.f14758n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c p(String str, long j6) throws IOException {
        k();
        d dVar = this.f14754j.get(str);
        a aVar = null;
        if (j6 != -1 && (dVar == null || dVar.f14770g != j6)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f14754j.put(str, dVar);
        } else if (dVar.f14769f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f14769f = cVar;
        this.f14753i.append((CharSequence) f14742v);
        this.f14753i.append(' ');
        this.f14753i.append((CharSequence) str);
        this.f14753i.append('\n');
        q(this.f14753i);
        return cVar;
    }

    public synchronized boolean B(String str) throws IOException {
        try {
            k();
            d dVar = this.f14754j.get(str);
            if (dVar != null && dVar.f14769f == null) {
                for (int i6 = 0; i6 < this.f14751g; i6++) {
                    File j6 = dVar.j(i6);
                    if (j6.exists() && !j6.delete()) {
                        throw new IOException("failed to delete " + j6);
                    }
                    this.f14752h -= dVar.f14765b[i6];
                    dVar.f14765b[i6] = 0;
                }
                this.f14755k++;
                this.f14753i.append((CharSequence) f14743w);
                this.f14753i.append(' ');
                this.f14753i.append((CharSequence) str);
                this.f14753i.append('\n');
                this.f14754j.remove(str);
                if (v()) {
                    this.f14757m.submit(this.f14758n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public synchronized void D(long j6) {
        this.f14750f = j6;
        this.f14757m.submit(this.f14758n);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f14753i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f14754j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f14769f != null) {
                    dVar.f14769f.a();
                }
            }
            E();
            l(this.f14753i);
            this.f14753i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() throws IOException {
        k();
        E();
        q(this.f14753i);
    }

    public synchronized boolean isClosed() {
        return this.f14753i == null;
    }

    public synchronized e r(String str) throws IOException {
        Throwable th;
        try {
            try {
                k();
                d dVar = this.f14754j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.f14768e) {
                    return null;
                }
                for (File file : dVar.f14766c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                this.f14755k++;
                this.f14753i.append((CharSequence) f14744x);
                this.f14753i.append(' ');
                this.f14753i.append((CharSequence) str);
                this.f14753i.append('\n');
                if (v()) {
                    this.f14757m.submit(this.f14758n);
                }
                return new e(this, str, dVar.f14770g, dVar.f14766c, dVar.f14765b, null);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public synchronized long size() {
        return this.f14752h;
    }

    public synchronized long t() {
        return this.f14750f;
    }

    private b(File file, int i6, int i7, long j6) {
        this.f14745a = file;
        this.f14749e = i6;
        this.f14746b = new File(file, f14735o);
        this.f14747c = new File(file, f14736p);
        this.f14748d = new File(file, f14737q);
        this.f14751g = i7;
        this.f14750f = j6;
    }

    private static void C(File file, File file2, boolean z5) throws IOException {
        if (z5) {
            n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() throws IOException {
        while (this.f14752h > this.f14750f) {
            B(this.f14754j.entrySet().iterator().next().getKey());
        }
    }

    private void k() {
        if (this.f14753i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void l(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @TargetApi(26)
    private static void q(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(InputStream inputStream) throws IOException {
        return com.bumptech.glide.disklrucache.d.c(new InputStreamReader(inputStream, com.bumptech.glide.disklrucache.d.f14786b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        int i6 = this.f14755k;
        return i6 >= 2000 && i6 >= this.f14754j.size();
    }

    public static b w(File file, int i6, int i7, long j6) throws IOException {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i7 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f14737q);
        if (file2.exists()) {
            File file3 = new File(file, f14735o);
            if (file3.exists()) {
                file2.delete();
            } else {
                C(file2, file3, false);
            }
        }
        b bVar = new b(file, i6, i7, j6);
        if (bVar.f14746b.exists()) {
            try {
                bVar.y();
                bVar.x();
                return bVar;
            } catch (IOException e6) {
                PrintStream printStream = System.out;
                Objects.toString(file);
                e6.getMessage();
                printStream.getClass();
                bVar.delete();
            }
        }
        file.mkdirs();
        b bVar2 = new b(file, i6, i7, j6);
        bVar2.A();
        return bVar2;
    }

    private void x() throws IOException {
        n(this.f14747c);
        Iterator<d> it = this.f14754j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i6 = 0;
            if (next.f14769f == null) {
                while (i6 < this.f14751g) {
                    this.f14752h += next.f14765b[i6];
                    i6++;
                }
            } else {
                next.f14769f = null;
                while (i6 < this.f14751g) {
                    n(next.j(i6));
                    n(next.k(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    private void y() throws IOException {
        com.bumptech.glide.disklrucache.c cVar = new com.bumptech.glide.disklrucache.c(new FileInputStream(this.f14746b), com.bumptech.glide.disklrucache.d.f14785a);
        try {
            String d6 = cVar.d();
            String d7 = cVar.d();
            String d8 = cVar.d();
            String d9 = cVar.d();
            String d10 = cVar.d();
            if (!f14738r.equals(d6) || !"1".equals(d7) || !Integer.toString(this.f14749e).equals(d8) || !Integer.toString(this.f14751g).equals(d9) || !"".equals(d10)) {
                throw new IOException("unexpected journal header: [" + d6 + ", " + d7 + ", " + d9 + ", " + d10 + "]");
            }
            int i6 = 0;
            while (true) {
                try {
                    z(cVar.d());
                    i6++;
                } catch (EOFException unused) {
                    this.f14755k = i6 - this.f14754j.size();
                    if (cVar.c()) {
                        A();
                    } else {
                        this.f14753i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14746b, true), com.bumptech.glide.disklrucache.d.f14785a));
                    }
                    com.bumptech.glide.disklrucache.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.disklrucache.d.a(cVar);
            throw th;
        }
    }

    private void z(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i6 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i6);
        if (indexOf2 == -1) {
            substring = str.substring(i6);
            if (indexOf == 6 && str.startsWith(f14743w)) {
                this.f14754j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i6, indexOf2);
        }
        d dVar = this.f14754j.get(substring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, substring, aVar);
            this.f14754j.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(f14741u)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            dVar.f14768e = true;
            dVar.f14769f = null;
            dVar.n(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(f14742v)) {
            dVar.f14769f = new c(this, dVar, aVar);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(f14744x)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public c o(String str) throws IOException {
        return p(str, -1L);
    }

    public File s() {
        return this.f14745a;
    }

    private static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public void delete() throws IOException {
        close();
        com.bumptech.glide.disklrucache.d.b(this.f14745a);
    }
}
