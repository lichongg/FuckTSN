package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.k;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class f<TResult> implements com.huawei.hmf.tasks.e<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.hmf.tasks.h f33050a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f33051b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f33052c = new Object();

    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f33053a;

        a(k kVar) {
            this.f33053a = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (f.this.f33052c) {
                try {
                    if (f.this.f33050a != null) {
                        f.this.f33050a.onFailure(this.f33053a.q());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.huawei.hmf.tasks.e
    public final void cancel() {
        synchronized (this.f33052c) {
            this.f33050a = null;
        }
    }

    f(Executor executor, com.huawei.hmf.tasks.h hVar) {
        this.f33050a = hVar;
        this.f33051b = executor;
    }

    @Override // com.huawei.hmf.tasks.e
    public final void a(k<TResult> kVar) {
        if (!kVar.v() && !kVar.t()) {
            this.f33051b.execute(new a(kVar));
        }
    }
}
