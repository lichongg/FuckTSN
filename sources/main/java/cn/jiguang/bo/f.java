package cn.jiguang.bo;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\Downloads\app\classes2.dex */
final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2417a;

    f() {
        this(Looper.getMainLooper());
    }

    @Override // cn.jiguang.bo.e
    public Thread a() {
        return this.f2417a.getLooper().getThread();
    }

    f(Looper looper) {
        this.f2417a = new Handler(looper);
    }

    @Override // cn.jiguang.bo.e
    public void a(Runnable runnable) {
        this.f2417a.post(runnable);
    }
}
