package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.k;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class b<TResult> implements com.huawei.hmf.tasks.e<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.hmf.tasks.f f33032a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f33033b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f33034c = new Object();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this.f33034c) {
                try {
                    if (b.this.f33032a != null) {
                        b.this.f33032a.onCanceled();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.huawei.hmf.tasks.e
    public final void cancel() {
        synchronized (this.f33034c) {
            this.f33032a = null;
        }
    }

    b(Executor executor, com.huawei.hmf.tasks.f fVar) {
        this.f33032a = fVar;
        this.f33033b = executor;
    }

    @Override // com.huawei.hmf.tasks.e
    public final void a(k<TResult> kVar) {
        if (kVar.t()) {
            this.f33033b.execute(new a());
        }
    }
}
