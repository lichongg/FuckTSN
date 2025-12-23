package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f implements o<g>, master.flame.danmaku.danmaku.model.objectpool.c<f> {

    /* renamed from: c, reason: collision with root package name */
    private f f50032c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f50033d;

    /* renamed from: b, reason: collision with root package name */
    private int f50031b = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f50034e = 0;

    /* renamed from: a, reason: collision with root package name */
    private final g f50030a = new g();

    @Override // master.flame.danmaku.danmaku.model.o
    public synchronized void c() {
        this.f50034e--;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public synchronized boolean hasReferences() {
        return this.f50034e > 0;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public synchronized void j() {
        this.f50034e++;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public int a() {
        return this.f50030a.f50040f;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public void d(int i6, int i7, int i8, boolean z5, int i9) {
        this.f50030a.a(i6, i7, i8, z5, i9);
        this.f50031b = this.f50030a.f50036b.getRowBytes() * this.f50030a.f50036b.getHeight();
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public void destroy() {
        g gVar = this.f50030a;
        if (gVar != null) {
            gVar.f();
        }
        this.f50031b = 0;
        this.f50034e = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public int e() {
        return this.f50030a.f50039e;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public void f() {
        this.f50030a.c();
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    public void h(boolean z5) {
        this.f50033d = z5;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    public boolean i() {
        return this.f50033d;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public g get() {
        g gVar = this.f50030a;
        if (gVar.f50036b == null) {
            return null;
        }
        return gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f b() {
        return this.f50032c;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.c
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void g(f fVar) {
        this.f50032c = fVar;
    }

    @Override // master.flame.danmaku.danmaku.model.o
    public int size() {
        return this.f50031b;
    }
}
