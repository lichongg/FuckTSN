package com.huawei.hmf.tasks.a;

import java.util.concurrent.ExecutionException;

/* loaded from: D:\Downloads\app\classes5.dex */
final class e<TResult> implements com.huawei.hmf.tasks.f, com.huawei.hmf.tasks.h, com.huawei.hmf.tasks.i<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f33044a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f33045b;

    /* renamed from: c, reason: collision with root package name */
    private final i<Void> f33046c;

    /* renamed from: d, reason: collision with root package name */
    private int f33047d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f33048e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33049f;

    private void a() {
        if (this.f33047d >= this.f33045b) {
            if (this.f33048e != null) {
                this.f33046c.z(new ExecutionException("a task failed", this.f33048e));
            } else if (this.f33049f) {
                this.f33046c.B();
            } else {
                this.f33046c.A(null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.f
    public final void onCanceled() {
        synchronized (this.f33044a) {
            this.f33047d++;
            this.f33049f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.h
    public final void onFailure(Exception exc) {
        synchronized (this.f33044a) {
            this.f33047d++;
            this.f33048e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.i
    public final void onSuccess(TResult tresult) {
        synchronized (this.f33044a) {
            this.f33047d++;
            a();
        }
    }

    e(int i6, i<Void> iVar) {
        this.f33045b = i6;
        this.f33046c = iVar;
    }
}
