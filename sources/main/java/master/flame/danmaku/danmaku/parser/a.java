package master.flame.danmaku.danmaku.parser;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected b<?> f50144a;

    /* renamed from: b, reason: collision with root package name */
    protected f f50145b;

    /* renamed from: c, reason: collision with root package name */
    protected int f50146c;

    /* renamed from: d, reason: collision with root package name */
    protected int f50147d;

    /* renamed from: e, reason: collision with root package name */
    protected float f50148e;

    /* renamed from: f, reason: collision with root package name */
    protected float f50149f;

    /* renamed from: g, reason: collision with root package name */
    private m f50150g;

    /* renamed from: h, reason: collision with root package name */
    protected n f50151h;

    /* renamed from: i, reason: collision with root package name */
    protected DanmakuContext f50152i;

    /* renamed from: j, reason: collision with root package name */
    protected InterfaceC0972a f50153j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.danmaku.parser.a$a, reason: collision with other inner class name */
    public interface InterfaceC0972a {
        void b(d dVar);
    }

    protected abstract m f();

    public m a() {
        m mVar = this.f50150g;
        if (mVar != null) {
            return mVar;
        }
        this.f50152i.D.k();
        this.f50150g = f();
        h();
        this.f50152i.D.m();
        return this.f50150g;
    }

    public n b() {
        return this.f50151h;
    }

    public f c() {
        return this.f50145b;
    }

    protected float d() {
        return 1.0f / (this.f50148e - 0.6f);
    }

    public a e(b<?> bVar) {
        this.f50144a = bVar;
        return this;
    }

    protected void h() {
        b<?> bVar = this.f50144a;
        if (bVar != null) {
            bVar.release();
        }
        this.f50144a = null;
    }

    public a i(DanmakuContext danmakuContext) {
        DanmakuContext danmakuContext2 = this.f50152i;
        if (danmakuContext2 != null && danmakuContext2 != danmakuContext) {
            this.f50150g = null;
        }
        this.f50152i = danmakuContext;
        return this;
    }

    public a j(n nVar) {
        this.f50151h = nVar;
        this.f50146c = nVar.getWidth();
        this.f50147d = nVar.getHeight();
        this.f50148e = nVar.getDensity();
        this.f50149f = nVar.d();
        this.f50152i.D.p(this.f50146c, this.f50147d, d());
        this.f50152i.D.m();
        return this;
    }

    public a k(InterfaceC0972a interfaceC0972a) {
        this.f50153j = interfaceC0972a;
        return this;
    }

    public a l(f fVar) {
        this.f50145b = fVar;
        return this;
    }

    public void g() {
        h();
    }
}
