package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b implements RequestCoordinator, e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f16155a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final RequestCoordinator f16156b;

    /* renamed from: c, reason: collision with root package name */
    private volatile e f16157c;

    /* renamed from: d, reason: collision with root package name */
    private volatile e f16158d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f16159e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f16160f;

    @GuardedBy("requestLock")
    private boolean j(e eVar) {
        if (eVar.equals(this.f16157c)) {
            return true;
        }
        return this.f16159e == RequestCoordinator.RequestState.FAILED && eVar.equals(this.f16158d);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.f16156b;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f16156b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        RequestCoordinator requestCoordinator = this.f16156b;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.e
    public boolean a() {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                z5 = this.f16157c.a() || this.f16158d.a();
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void b(e eVar) {
        synchronized (this.f16155a) {
            try {
                if (eVar.equals(this.f16157c)) {
                    this.f16159e = RequestCoordinator.RequestState.SUCCESS;
                } else if (eVar.equals(this.f16158d)) {
                    this.f16160f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.f16156b;
                if (requestCoordinator != null) {
                    requestCoordinator.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                z5 = l() && j(eVar);
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.f16155a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.f16159e = requestState;
                this.f16157c.clear();
                if (this.f16160f != requestState) {
                    this.f16160f = requestState;
                    this.f16158d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(e eVar) {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                z5 = m() && j(eVar);
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean e() {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                RequestCoordinator.RequestState requestState = this.f16159e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z5 = requestState == requestState2 && this.f16160f == requestState2;
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean f(e eVar) {
        if (eVar instanceof b) {
            b bVar = (b) eVar;
            if (this.f16157c.f(bVar.f16157c) && this.f16158d.f(bVar.f16158d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(e eVar) {
        synchronized (this.f16155a) {
            try {
                if (eVar.equals(this.f16158d)) {
                    this.f16160f = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator requestCoordinator = this.f16156b;
                    if (requestCoordinator != null) {
                        requestCoordinator.g(this);
                    }
                    return;
                }
                this.f16159e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f16160f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f16160f = requestState2;
                    this.f16158d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f16155a) {
            try {
                RequestCoordinator requestCoordinator = this.f16156b;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // com.bumptech.glide.request.e
    public void h() {
        synchronized (this.f16155a) {
            try {
                RequestCoordinator.RequestState requestState = this.f16159e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f16159e = requestState2;
                    this.f16157c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(e eVar) {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                z5 = k() && j(eVar);
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                RequestCoordinator.RequestState requestState = this.f16159e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                z5 = requestState == requestState2 || this.f16160f == requestState2;
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z5;
        synchronized (this.f16155a) {
            try {
                RequestCoordinator.RequestState requestState = this.f16159e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                z5 = requestState == requestState2 || this.f16160f == requestState2;
            } finally {
            }
        }
        return z5;
    }

    public void n(e eVar, e eVar2) {
        this.f16157c = eVar;
        this.f16158d = eVar2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f16155a) {
            try {
                RequestCoordinator.RequestState requestState = this.f16159e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.f16159e = RequestCoordinator.RequestState.PAUSED;
                    this.f16157c.pause();
                }
                if (this.f16160f == requestState2) {
                    this.f16160f = RequestCoordinator.RequestState.PAUSED;
                    this.f16158d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f16159e = requestState;
        this.f16160f = requestState;
        this.f16155a = obj;
        this.f16156b = requestCoordinator;
    }
}
