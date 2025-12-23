package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k implements RequestCoordinator, e {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final RequestCoordinator f16208a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f16209b;

    /* renamed from: c, reason: collision with root package name */
    private volatile e f16210c;

    /* renamed from: d, reason: collision with root package name */
    private volatile e f16211d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f16212e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f16213f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f16214g;

    @GuardedBy("requestLock")
    private boolean j() {
        RequestCoordinator requestCoordinator = this.f16208a;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.f16208a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f16208a;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.e
    public boolean a() {
        boolean z5;
        synchronized (this.f16209b) {
            try {
                z5 = this.f16211d.a() || this.f16210c.a();
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void b(e eVar) {
        synchronized (this.f16209b) {
            try {
                if (eVar.equals(this.f16211d)) {
                    this.f16213f = RequestCoordinator.RequestState.SUCCESS;
                    return;
                }
                this.f16212e = RequestCoordinator.RequestState.SUCCESS;
                RequestCoordinator requestCoordinator = this.f16208a;
                if (requestCoordinator != null) {
                    requestCoordinator.b(this);
                }
                if (!this.f16213f.isComplete()) {
                    this.f16211d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z5;
        synchronized (this.f16209b) {
            try {
                z5 = k() && eVar.equals(this.f16210c) && !a();
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.f16209b) {
            this.f16214g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f16212e = requestState;
            this.f16213f = requestState;
            this.f16211d.clear();
            this.f16210c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(e eVar) {
        boolean z5;
        synchronized (this.f16209b) {
            try {
                z5 = l() && (eVar.equals(this.f16210c) || this.f16212e != RequestCoordinator.RequestState.SUCCESS);
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean e() {
        boolean z5;
        synchronized (this.f16209b) {
            z5 = this.f16212e == RequestCoordinator.RequestState.CLEARED;
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean f(e eVar) {
        if (eVar instanceof k) {
            k kVar = (k) eVar;
            if (this.f16210c != null ? this.f16210c.f(kVar.f16210c) : kVar.f16210c == null) {
                if (this.f16211d == null) {
                    if (kVar.f16211d == null) {
                        return true;
                    }
                } else if (this.f16211d.f(kVar.f16211d)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(e eVar) {
        synchronized (this.f16209b) {
            try {
                if (!eVar.equals(this.f16210c)) {
                    this.f16213f = RequestCoordinator.RequestState.FAILED;
                    return;
                }
                this.f16212e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f16208a;
                if (requestCoordinator != null) {
                    requestCoordinator.g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.f16209b) {
            try {
                RequestCoordinator requestCoordinator = this.f16208a;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // com.bumptech.glide.request.e
    public void h() {
        synchronized (this.f16209b) {
            try {
                this.f16214g = true;
                try {
                    if (this.f16212e != RequestCoordinator.RequestState.SUCCESS) {
                        RequestCoordinator.RequestState requestState = this.f16213f;
                        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState != requestState2) {
                            this.f16213f = requestState2;
                            this.f16211d.h();
                        }
                    }
                    if (this.f16214g) {
                        RequestCoordinator.RequestState requestState3 = this.f16212e;
                        RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState3 != requestState4) {
                            this.f16212e = requestState4;
                            this.f16210c.h();
                        }
                    }
                    this.f16214g = false;
                } catch (Throwable th) {
                    this.f16214g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(e eVar) {
        boolean z5;
        synchronized (this.f16209b) {
            try {
                z5 = j() && eVar.equals(this.f16210c) && this.f16212e != RequestCoordinator.RequestState.PAUSED;
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z5;
        synchronized (this.f16209b) {
            z5 = this.f16212e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z5;
        synchronized (this.f16209b) {
            z5 = this.f16212e == RequestCoordinator.RequestState.RUNNING;
        }
        return z5;
    }

    public void m(e eVar, e eVar2) {
        this.f16210c = eVar;
        this.f16211d = eVar2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f16209b) {
            try {
                if (!this.f16213f.isComplete()) {
                    this.f16213f = RequestCoordinator.RequestState.PAUSED;
                    this.f16211d.pause();
                }
                if (!this.f16212e.isComplete()) {
                    this.f16212e = RequestCoordinator.RequestState.PAUSED;
                    this.f16210c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public k(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f16212e = requestState;
        this.f16213f = requestState;
        this.f16209b = obj;
        this.f16208a = requestCoordinator;
    }
}
