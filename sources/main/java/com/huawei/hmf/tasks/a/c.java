package com.huawei.hmf.tasks.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class c extends com.huawei.hmf.tasks.b {

    /* renamed from: a, reason: collision with root package name */
    public final List<Runnable> f33036a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Object f33037b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f33038c = false;

    @Override // com.huawei.hmf.tasks.b
    public final boolean a() {
        return this.f33038c;
    }

    @Override // com.huawei.hmf.tasks.b
    public final com.huawei.hmf.tasks.b b(Runnable runnable) {
        synchronized (this.f33037b) {
            try {
                if (this.f33038c) {
                    runnable.run();
                } else {
                    this.f33036a.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }
}
