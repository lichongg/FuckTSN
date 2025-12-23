package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    a f5730f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void a(b8 b8Var);

        void b(b8 b8Var);
    }

    public abstract void runTask();

    public final void cancelTask() {
        try {
            a aVar = this.f5730f;
            if (aVar != null) {
                aVar.a(this);
            }
        } catch (Throwable th) {
            v5.p(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (!Thread.interrupted()) {
                runTask();
                if (!Thread.interrupted() && (aVar = this.f5730f) != null) {
                    aVar.b(this);
                }
            }
        } catch (Throwable th) {
            v5.p(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
