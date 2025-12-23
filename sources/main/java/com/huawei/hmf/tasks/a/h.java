package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.k;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class h<TResult> implements com.huawei.hmf.tasks.e<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.hmf.tasks.i<TResult> f33057a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f33058b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f33059c = new Object();

    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f33060a;

        a(k kVar) {
            this.f33060a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (h.this.f33059c) {
                try {
                    if (h.this.f33057a != null) {
                        h.this.f33057a.onSuccess(this.f33060a.r());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.huawei.hmf.tasks.e
    public final void cancel() {
        synchronized (this.f33059c) {
            this.f33057a = null;
        }
    }

    h(Executor executor, com.huawei.hmf.tasks.i<TResult> iVar) {
        this.f33057a = iVar;
        this.f33058b = executor;
    }

    @Override // com.huawei.hmf.tasks.e
    public final void a(k<TResult> kVar) {
        if (kVar.v() && !kVar.t()) {
            this.f33058b.execute(new a(kVar));
        }
    }
}
