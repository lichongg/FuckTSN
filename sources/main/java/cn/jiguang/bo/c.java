package cn.jiguang.bo;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class c extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final cn.jiguang.bp.c f2412a;

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f2413b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread f2414c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2415d;

    public c(cn.jiguang.bp.c cVar, Throwable th, Thread thread) {
        this(cVar, th, thread, false);
    }

    public c(cn.jiguang.bp.c cVar, Throwable th, Thread thread, boolean z5) {
        this.f2412a = cVar;
        this.f2413b = th;
        this.f2414c = thread;
        this.f2415d = z5;
    }

    public cn.jiguang.bp.c a() {
        return this.f2412a;
    }

    public Throwable b() {
        return this.f2413b;
    }

    public Thread c() {
        return this.f2414c;
    }

    public boolean d() {
        return this.f2415d;
    }
}
