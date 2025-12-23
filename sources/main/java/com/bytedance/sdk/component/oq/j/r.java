package com.bytedance.sdk.component.oq.j;

import com.bytedance.sdk.component.oq.oq;
import com.bytedance.sdk.component.oq.qv;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements ThreadFactory {

    /* renamed from: j, reason: collision with root package name */
    private final ThreadFactory f26629j;
    private final int xt;

    public final String j() {
        return this.f26629j.getClass().getName();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f26629j.newThread(runnable);
        return xt() ? new ae(newThread) : newThread;
    }

    protected boolean xt() {
        return qv.xt.xt(this.xt);
    }

    public r(ThreadFactory threadFactory, int i6) {
        if (threadFactory == null) {
            this.f26629j = new oq("default");
        } else {
            this.f26629j = threadFactory;
        }
        this.xt = i6;
    }
}
