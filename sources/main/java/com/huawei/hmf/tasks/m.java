package com.huawei.hmf.tasks;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class m {

    /* renamed from: d, reason: collision with root package name */
    private static final m f33092d = new m();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f33094b = com.huawei.hmf.tasks.a.a.a();

    /* renamed from: a, reason: collision with root package name */
    private final Executor f33093a = new a();

    /* renamed from: c, reason: collision with root package name */
    private final Executor f33095c = com.huawei.hmf.tasks.a.a.b();

    static final class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    static ExecutorService a() {
        return f33092d.f33094b;
    }

    public static Executor b() {
        return f33092d.f33093a;
    }

    public static Executor c() {
        return f33092d.f33095c;
    }

    private m() {
    }
}
