package cn.jiguang.bp;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class a extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final Thread f2448a;

    public Thread a() {
        return this.f2448a;
    }

    public a(String str, Thread thread) {
        super(str);
        this.f2448a = thread;
        setStackTrace(thread.getStackTrace());
    }
}
