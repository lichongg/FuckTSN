package com.amap.api.col.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class z3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    a f8784a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void a(z3 z3Var);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (!Thread.interrupted()) {
                a();
                if (!Thread.interrupted() && (aVar = this.f8784a) != null) {
                    aVar.a(this);
                }
            }
        } catch (Throwable th) {
            g2.o(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
