package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.k;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class d<TResult> implements com.huawei.hmf.tasks.e<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.hmf.tasks.g<TResult> f33039a;

    /* renamed from: b, reason: collision with root package name */
    Executor f33040b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f33041c = new Object();

    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f33042a;

        a(k kVar) {
            this.f33042a = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.this.f33041c) {
                try {
                    if (d.this.f33039a != null) {
                        d.this.f33039a.a(this.f33042a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.huawei.hmf.tasks.e
    public final void a(k<TResult> kVar) {
        this.f33040b.execute(new a(kVar));
    }

    @Override // com.huawei.hmf.tasks.e
    public final void cancel() {
        synchronized (this.f33041c) {
            this.f33039a = null;
        }
    }

    d(Executor executor, com.huawei.hmf.tasks.g<TResult> gVar) {
        this.f33039a = gVar;
        this.f33040b = executor;
    }
}
