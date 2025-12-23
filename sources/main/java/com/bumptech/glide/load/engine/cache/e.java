package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.b;
import com.bumptech.glide.load.engine.cache.a;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e implements a {

    /* renamed from: f, reason: collision with root package name */
    private static final String f15088f = "DiskLruCacheWrapper";

    /* renamed from: g, reason: collision with root package name */
    private static final int f15089g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f15090h = 1;

    /* renamed from: i, reason: collision with root package name */
    private static e f15091i;

    /* renamed from: b, reason: collision with root package name */
    private final File f15093b;

    /* renamed from: c, reason: collision with root package name */
    private final long f15094c;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.disklrucache.b f15096e;

    /* renamed from: d, reason: collision with root package name */
    private final c f15095d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final m f15092a = new m();

    private synchronized com.bumptech.glide.disklrucache.b e() throws IOException {
        try {
            if (this.f15096e == null) {
                this.f15096e = com.bumptech.glide.disklrucache.b.w(this.f15093b, 1, 1, this.f15094c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15096e;
    }

    private synchronized void f() {
        this.f15096e = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public synchronized void clear() {
        try {
            try {
                e().delete();
            } catch (IOException unused) {
                Log.isLoggable(f15088f, 5);
            }
        } finally {
            f();
        }
    }

    public static a c(File file, long j6) {
        return new e(file, j6);
    }

    @Deprecated
    public static synchronized a d(File file, long j6) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f15091i == null) {
                    f15091i = new e(file, j6);
                }
                eVar = f15091i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void a(com.bumptech.glide.load.c cVar, a.b bVar) {
        String b6 = this.f15092a.b(cVar);
        this.f15095d.a(b6);
        try {
            if (Log.isLoggable(f15088f, 2)) {
                Objects.toString(cVar);
            }
            try {
                com.bumptech.glide.disklrucache.b e6 = e();
                if (e6.r(b6) == null) {
                    b.c o5 = e6.o(b6);
                    if (o5 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + b6);
                    }
                    try {
                        if (bVar.a(o5.f(0))) {
                            o5.e();
                        }
                        o5.b();
                    } catch (Throwable th) {
                        o5.b();
                        throw th;
                    }
                }
            } catch (IOException unused) {
                Log.isLoggable(f15088f, 5);
            }
        } finally {
            this.f15095d.b(b6);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public File b(com.bumptech.glide.load.c cVar) {
        String b6 = this.f15092a.b(cVar);
        if (Log.isLoggable(f15088f, 2)) {
            Objects.toString(cVar);
        }
        try {
            b.e r5 = e().r(b6);
            if (r5 != null) {
                return r5.b(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable(f15088f, 5);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void delete(com.bumptech.glide.load.c cVar) {
        try {
            e().B(this.f15092a.b(cVar));
        } catch (IOException unused) {
            Log.isLoggable(f15088f, 5);
        }
    }

    @Deprecated
    protected e(File file, long j6) {
        this.f15093b = file;
        this.f15094c = j6;
    }
}
