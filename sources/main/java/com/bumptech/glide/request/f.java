package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.util.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f<R> implements d<R>, g<R> {

    /* renamed from: k, reason: collision with root package name */
    private static final a f16161k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f16162a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16163b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16164c;

    /* renamed from: d, reason: collision with root package name */
    private final a f16165d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private R f16166e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private e f16167f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f16168g;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f16169h;

    /* renamed from: i, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f16170i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private GlideException f16171j;

    public f(int i6, int i7) {
        this(i6, i7, true, f16161k);
    }

    private synchronized R e(Long l6) throws ExecutionException, InterruptedException, TimeoutException {
        try {
            if (this.f16164c && !isDone()) {
                l.a();
            }
            if (this.f16168g) {
                throw new CancellationException();
            }
            if (this.f16170i) {
                throw new ExecutionException(this.f16171j);
            }
            if (this.f16169h) {
                return this.f16166e;
            }
            if (l6 == null) {
                this.f16165d.b(this, 0L);
            } else if (l6.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l6.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.f16165d.b(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.f16170i) {
                throw new ExecutionException(this.f16171j);
            }
            if (this.f16168g) {
                throw new CancellationException();
            }
            if (!this.f16169h) {
                throw new TimeoutException();
            }
            return this.f16166e;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean a(@Nullable GlideException glideException, Object obj, p<R> pVar, boolean z5) {
        this.f16170i = true;
        this.f16171j = glideException;
        this.f16165d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean c(R r5, Object obj, p<R> pVar, DataSource dataSource, boolean z5) {
        this.f16169h = true;
        this.f16166e = r5;
        this.f16165d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f16168g = true;
                this.f16165d.a(this);
                e eVar = null;
                if (z5) {
                    e eVar2 = this.f16167f;
                    this.f16167f = null;
                    eVar = eVar2;
                }
                if (eVar != null) {
                    eVar.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public synchronized e d() {
        return this.f16167f;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return e(null);
        } catch (TimeoutException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // com.bumptech.glide.request.target.p
    public synchronized void h(@NonNull R r5, @Nullable com.bumptech.glide.request.transition.f<? super R> fVar) {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f16168g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z5;
        if (!this.f16168g && !this.f16169h) {
            z5 = this.f16170i;
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.target.p
    public synchronized void n(@Nullable e eVar) {
        this.f16167f = eVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public synchronized void o(@Nullable Drawable drawable) {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j6) throws InterruptedException {
            obj.wait(j6);
        }
    }

    f(int i6, int i7, boolean z5, a aVar) {
        this.f16162a = i6;
        this.f16163b = i7;
        this.f16164c = z5;
        this.f16165d = aVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public void q(@NonNull o oVar) {
        oVar.d(this.f16162a, this.f16163b);
    }

    @Override // java.util.concurrent.Future
    public R get(long j6, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return e(Long.valueOf(timeUnit.toMillis(j6)));
    }

    @Override // com.bumptech.glide.request.target.p
    public void b(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.request.target.p
    public void g(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    public void j(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }
}
