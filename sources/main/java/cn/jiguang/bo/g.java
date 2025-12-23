package cn.jiguang.bo;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private volatile cn.jiguang.bp.i f2418a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f2419b = new Object();

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final cn.jiguang.bp.i f2420a;

        /* renamed from: b, reason: collision with root package name */
        private final cn.jiguang.bp.i f2421b;

        public a(cn.jiguang.bp.i iVar, cn.jiguang.bp.i iVar2) {
            this.f2421b = iVar;
            this.f2420a = iVar2;
        }
    }

    public cn.jiguang.bp.i a() {
        cn.jiguang.bp.i clone;
        synchronized (this.f2419b) {
            try {
                clone = this.f2418a != null ? this.f2418a.clone() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return clone;
    }

    public a b() {
        a aVar;
        synchronized (this.f2419b) {
            try {
                if (this.f2418a != null) {
                    this.f2418a.i();
                }
                cn.jiguang.bp.i iVar = this.f2418a;
                this.f2418a = new cn.jiguang.bp.i();
                aVar = new a(this.f2418a.clone(), iVar != null ? iVar.clone() : null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }
}
