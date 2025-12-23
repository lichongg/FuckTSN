package com.bytedance.embedapplog;

/* loaded from: D:\Downloads\app\classes3.dex */
abstract class wf<T> {

    /* renamed from: j, reason: collision with root package name */
    private volatile T f24088j;

    protected abstract T j(Object... objArr);

    public final T xt(Object... objArr) {
        if (this.f24088j == null) {
            synchronized (this) {
                try {
                    if (this.f24088j == null) {
                        this.f24088j = j(objArr);
                    }
                } finally {
                }
            }
        }
        return this.f24088j;
    }

    wf() {
    }
}
