package com.huawei.hmf.tasks;

import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.hmf.tasks.a.c f33089a = new com.huawei.hmf.tasks.a.c();

    public void a() {
        com.huawei.hmf.tasks.a.c cVar = this.f33089a;
        if (cVar.f33038c) {
            return;
        }
        synchronized (cVar.f33037b) {
            try {
                cVar.f33038c = true;
                Iterator<Runnable> it = cVar.f33036a.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b b() {
        return this.f33089a;
    }
}
