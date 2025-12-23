package com.bytedance.sdk.component.cw.xt.j.j;

import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.j.vl;
import com.bytedance.sdk.component.cw.j.w;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r implements Closeable, Flushable {

    /* renamed from: j, reason: collision with root package name */
    static final Pattern f26196j = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean jy = true;
    int ae;
    private final File av;
    private final File az;
    final File cw;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f26197f;

    /* renamed from: g, reason: collision with root package name */
    boolean f26198g;

    /* renamed from: i, reason: collision with root package name */
    private final int f26199i;
    private long kt;

    /* renamed from: m, reason: collision with root package name */
    final LinkedHashMap<String, xt> f26200m;
    private long mi;
    boolean oq;
    boolean qv;

    /* renamed from: r, reason: collision with root package name */
    final int f26201r;
    private final Executor tj;
    boolean tl;
    com.bytedance.sdk.component.cw.j.r up;
    boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private long f26202w;
    private final File ws;
    final com.bytedance.sdk.component.cw.xt.j.m.j xt;

    public final class cw implements Closeable {
        private final long cw;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ r f26204j;

        /* renamed from: r, reason: collision with root package name */
        private final mi[] f26205r;
        private final String xt;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (mi miVar : this.f26205r) {
                com.bytedance.sdk.component.cw.xt.j.cw.j(miVar);
            }
        }

        public j j() throws IOException {
            return this.f26204j.j(this.xt, this.cw);
        }
    }

    public final class j {

        /* renamed from: j, reason: collision with root package name */
        final xt f26206j;

        /* renamed from: r, reason: collision with root package name */
        private boolean f26207r;
        final boolean[] xt;

        void j() {
            if (this.f26206j.f26210m != this) {
                return;
            }
            int i6 = 0;
            while (true) {
                r rVar = r.this;
                if (i6 >= rVar.f26201r) {
                    this.f26206j.f26210m = null;
                    return;
                } else {
                    try {
                        rVar.xt.delete(this.f26206j.f26211r[i6]);
                    } catch (IOException unused) {
                    }
                    i6++;
                }
            }
        }

        j(xt xtVar) {
            this.f26206j = xtVar;
            this.xt = xtVar.up ? null : new boolean[r.this.f26201r];
        }

        public void cw() throws IOException {
            synchronized (r.this) {
                try {
                    if (this.f26207r) {
                        throw new IllegalStateException();
                    }
                    if (this.f26206j.f26210m == this) {
                        r.this.j(this, false);
                    }
                    this.f26207r = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void xt() throws IOException {
            synchronized (r.this) {
                try {
                    if (this.f26207r) {
                        throw new IllegalStateException();
                    }
                    if (this.f26206j.f26210m == this) {
                        r.this.j(this, true);
                    }
                    this.f26207r = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public w j(int i6) {
            synchronized (r.this) {
                try {
                    if (!this.f26207r) {
                        xt xtVar = this.f26206j;
                        if (xtVar.f26210m != this) {
                            return vl.j();
                        }
                        if (!xtVar.up) {
                            this.xt[i6] = true;
                        }
                        try {
                            return new up(r.this.xt.xt(xtVar.f26211r[i6])) { // from class: com.bytedance.sdk.component.cw.xt.j.j.r.j.1
                                @Override // com.bytedance.sdk.component.cw.xt.j.j.up
                                protected void j(IOException iOException) {
                                    synchronized (r.this) {
                                        j.this.j();
                                    }
                                }
                            };
                        } catch (FileNotFoundException unused) {
                            return vl.j();
                        }
                    }
                    throw new IllegalStateException();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final class xt {
        long ae;
        final File[] cw;

        /* renamed from: j, reason: collision with root package name */
        final String f26209j;

        /* renamed from: m, reason: collision with root package name */
        j f26210m;

        /* renamed from: r, reason: collision with root package name */
        final File[] f26211r;
        boolean up;
        final long[] xt;

        void j(String[] strArr) throws IOException {
            if (strArr.length != r.this.f26201r) {
                throw xt(strArr);
            }
            for (int i6 = 0; i6 < strArr.length; i6++) {
                try {
                    this.xt[i6] = Long.parseLong(strArr[i6]);
                } catch (NumberFormatException unused) {
                    throw xt(strArr);
                }
            }
        }

        xt(String str) {
            this.f26209j = str;
            int i6 = r.this.f26201r;
            this.xt = new long[i6];
            this.cw = new File[i6];
            this.f26211r = new File[i6];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i7 = 0; i7 < r.this.f26201r; i7++) {
                sb.append(i7);
                this.cw[i7] = new File(r.this.cw, sb.toString());
                sb.append(".tmp");
                this.f26211r[i7] = new File(r.this.cw, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException xt(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        void j(com.bytedance.sdk.component.cw.j.r rVar) throws IOException {
            for (long j6 : this.xt) {
                rVar.g(32).vl(j6);
            }
        }
    }

    private synchronized void g() {
        if (r()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f26198g && !this.oq) {
                for (xt xtVar : (xt[]) this.f26200m.values().toArray(new xt[this.f26200m.size()])) {
                    j jVar = xtVar.f26210m;
                    if (jVar != null) {
                        jVar.cw();
                    }
                }
                up();
                this.up.close();
                this.up = null;
                this.oq = true;
                return;
            }
            this.oq = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f26198g) {
            g();
            up();
            this.up.flush();
        }
    }

    public synchronized void j() throws IOException {
        try {
            if (!jy && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (this.f26198g) {
                return;
            }
            if (this.xt.r(this.av)) {
                if (this.xt.r(this.ws)) {
                    this.xt.delete(this.av);
                } else {
                    this.xt.j(this.av, this.ws);
                }
            }
            if (this.xt.r(this.ws)) {
                try {
                    m();
                    tl();
                    this.f26198g = true;
                    return;
                } catch (IOException e6) {
                    com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(5, "DiskLruCache " + this.cw + " is corrupt: " + e6.getMessage() + ", removing", e6);
                    try {
                        delete();
                        this.oq = false;
                    } catch (Throwable th) {
                        this.oq = false;
                        throw th;
                    }
                }
            }
            xt();
            this.f26198g = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean r() {
        return this.oq;
    }

    synchronized void xt() throws IOException {
        try {
            com.bytedance.sdk.component.cw.j.r rVar = this.up;
            if (rVar != null) {
                rVar.close();
            }
            com.bytedance.sdk.component.cw.j.r j6 = vl.j(this.xt.xt(this.az));
            try {
                j6.xt("libcore.io.DiskLruCache").g(10);
                j6.xt("1").g(10);
                j6.vl(this.f26199i).g(10);
                j6.vl(this.f26201r).g(10);
                j6.g(10);
                for (xt xtVar : this.f26200m.values()) {
                    if (xtVar.f26210m != null) {
                        j6.xt("DIRTY").g(32);
                        j6.xt(xtVar.f26209j);
                        j6.g(10);
                    } else {
                        j6.xt("CLEAN").g(32);
                        j6.xt(xtVar.f26209j);
                        xtVar.j(j6);
                        j6.g(10);
                    }
                }
                j6.close();
                if (this.xt.r(this.ws)) {
                    this.xt.j(this.ws, this.av);
                }
                this.xt.j(this.az, this.ws);
                this.xt.delete(this.av);
                this.up = ae();
                this.tl = false;
                this.vl = false;
            } catch (Throwable th) {
                j6.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private com.bytedance.sdk.component.cw.j.r ae() throws FileNotFoundException {
        return vl.j(new up(this.xt.cw(this.ws)) { // from class: com.bytedance.sdk.component.cw.xt.j.j.r.1

            /* renamed from: j, reason: collision with root package name */
            static final /* synthetic */ boolean f26203j = true;

            @Override // com.bytedance.sdk.component.cw.xt.j.j.up
            protected void j(IOException iOException) {
                if (!f26203j && !Thread.holdsLock(r.this)) {
                    throw new AssertionError();
                }
                r.this.tl = true;
            }
        });
    }

    private void m() throws IOException {
        com.bytedance.sdk.component.cw.j.up j6 = vl.j(this.xt.j(this.ws));
        try {
            String av = j6.av();
            String av2 = j6.av();
            String av3 = j6.av();
            String av4 = j6.av();
            String av5 = j6.av();
            if (!"libcore.io.DiskLruCache".equals(av) || !"1".equals(av2) || !Integer.toString(this.f26199i).equals(av3) || !Integer.toString(this.f26201r).equals(av4) || !"".equals(av5)) {
                throw new IOException("unexpected journal header: [" + av + ", " + av2 + ", " + av4 + ", " + av5 + "]");
            }
            int i6 = 0;
            while (true) {
                try {
                    j(j6.av());
                    i6++;
                } catch (EOFException unused) {
                    this.ae = i6 - this.f26200m.size();
                    if (j6.up()) {
                        this.up = ae();
                    } else {
                        xt();
                    }
                    com.bytedance.sdk.component.cw.xt.j.cw.j(j6);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.cw.xt.j.cw.j(j6);
            throw th;
        }
    }

    private void tl() throws IOException {
        this.xt.delete(this.az);
        Iterator<xt> it = this.f26200m.values().iterator();
        while (it.hasNext()) {
            xt next = it.next();
            int i6 = 0;
            if (next.f26210m == null) {
                while (i6 < this.f26201r) {
                    this.mi += next.xt[i6];
                    i6++;
                }
            } else {
                next.f26210m = null;
                while (i6 < this.f26201r) {
                    this.xt.delete(next.cw[i6]);
                    this.xt.delete(next.f26211r[i6]);
                    i6++;
                }
                it.remove();
            }
        }
    }

    boolean cw() {
        int i6 = this.ae;
        return i6 >= 2000 && i6 >= this.f26200m.size();
    }

    void up() throws IOException {
        while (this.mi > this.f26202w) {
            j(this.f26200m.values().iterator().next());
        }
        this.qv = false;
    }

    public void delete() throws IOException {
        close();
        this.xt.m(this.cw);
    }

    private void j(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i6 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i6);
            if (indexOf2 == -1) {
                substring = str.substring(i6);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f26200m.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i6, indexOf2);
            }
            xt xtVar = this.f26200m.get(substring);
            if (xtVar == null) {
                xtVar = new xt(substring);
                this.f26200m.put(substring, xtVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                xtVar.up = true;
                xtVar.f26210m = null;
                xtVar.j(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                xtVar.f26210m = new j(xtVar);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private void xt(String str) {
        if (f26196j.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    synchronized j j(String str, long j6) throws IOException {
        j();
        g();
        xt(str);
        xt xtVar = this.f26200m.get(str);
        if (j6 != -1 && (xtVar == null || xtVar.ae != j6)) {
            return null;
        }
        if (xtVar != null && xtVar.f26210m != null) {
            return null;
        }
        if (!this.qv && !this.vl) {
            this.up.xt("DIRTY").g(32).xt(str).g(10);
            this.up.flush();
            if (this.tl) {
                return null;
            }
            if (xtVar == null) {
                xtVar = new xt(str);
                this.f26200m.put(str, xtVar);
            }
            j jVar = new j(xtVar);
            xtVar.f26210m = jVar;
            return jVar;
        }
        this.tj.execute(this.f26197f);
        return null;
    }

    synchronized void j(j jVar, boolean z5) throws IOException {
        xt xtVar = jVar.f26206j;
        if (xtVar.f26210m == jVar) {
            if (z5 && !xtVar.up) {
                for (int i6 = 0; i6 < this.f26201r; i6++) {
                    if (jVar.xt[i6]) {
                        if (!this.xt.r(xtVar.f26211r[i6])) {
                            jVar.cw();
                            return;
                        }
                    } else {
                        jVar.cw();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i6)));
                    }
                }
            }
            for (int i7 = 0; i7 < this.f26201r; i7++) {
                File file = xtVar.f26211r[i7];
                if (z5) {
                    if (this.xt.r(file)) {
                        File file2 = xtVar.cw[i7];
                        this.xt.j(file, file2);
                        long j6 = xtVar.xt[i7];
                        long up = this.xt.up(file2);
                        xtVar.xt[i7] = up;
                        this.mi = (this.mi - j6) + up;
                    }
                } else {
                    this.xt.delete(file);
                }
            }
            this.ae++;
            xtVar.f26210m = null;
            if (xtVar.up | z5) {
                xtVar.up = true;
                this.up.xt("CLEAN").g(32);
                this.up.xt(xtVar.f26209j);
                xtVar.j(this.up);
                this.up.g(10);
                if (z5) {
                    long j7 = this.kt;
                    this.kt = 1 + j7;
                    xtVar.ae = j7;
                }
            } else {
                this.f26200m.remove(xtVar.f26209j);
                this.up.xt("REMOVE").g(32);
                this.up.xt(xtVar.f26209j);
                this.up.g(10);
            }
            this.up.flush();
            if (this.mi > this.f26202w || cw()) {
                this.tj.execute(this.f26197f);
            }
            return;
        }
        throw new IllegalStateException();
    }

    boolean j(xt xtVar) throws IOException {
        j jVar = xtVar.f26210m;
        if (jVar != null) {
            jVar.j();
        }
        for (int i6 = 0; i6 < this.f26201r; i6++) {
            this.xt.delete(xtVar.cw[i6]);
            long j6 = this.mi;
            long[] jArr = xtVar.xt;
            this.mi = j6 - jArr[i6];
            jArr[i6] = 0;
        }
        this.ae++;
        this.up.xt("REMOVE").g(32).xt(xtVar.f26209j).g(10);
        this.f26200m.remove(xtVar.f26209j);
        if (cw()) {
            this.tj.execute(this.f26197f);
        }
        return true;
    }
}
