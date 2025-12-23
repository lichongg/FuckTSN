package master.flame.danmaku.danmaku.model.objectpool;

import master.flame.danmaku.danmaku.model.objectpool.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class f<T extends c<T>> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f50112a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f50113b;

    public f(b<T> bVar) {
        this.f50112a = bVar;
        this.f50113b = this;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public void a(T t5) {
        synchronized (this.f50113b) {
            this.f50112a.a(t5);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public T acquire() {
        T acquire;
        synchronized (this.f50113b) {
            acquire = this.f50112a.acquire();
        }
        return acquire;
    }

    public f(b<T> bVar, Object obj) {
        this.f50112a = bVar;
        this.f50113b = obj;
    }
}
