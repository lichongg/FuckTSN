package cn.jiguang.bh;

/* loaded from: D:\Downloads\app\classes2.dex */
public class m extends i {

    /* renamed from: e, reason: collision with root package name */
    private int f2210e;

    /* renamed from: f, reason: collision with root package name */
    private int f2211f;

    /* renamed from: g, reason: collision with root package name */
    private int f2212g;

    /* renamed from: h, reason: collision with root package name */
    private g f2213h;

    @Override // cn.jiguang.bh.i
    void a(b bVar) {
        this.f2210e = bVar.g();
        this.f2211f = bVar.g();
        this.f2212g = bVar.g();
        this.f2213h = new g(bVar);
    }

    @Override // cn.jiguang.bh.i
    void a(c cVar, a aVar, boolean z5) {
        cVar.c(this.f2210e);
        cVar.c(this.f2211f);
        cVar.c(this.f2212g);
        this.f2213h.a(cVar, (a) null, z5);
    }

    @Override // cn.jiguang.bh.i
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f2210e + " ");
        stringBuffer.append(this.f2211f + " ");
        stringBuffer.append(this.f2212g + " ");
        stringBuffer.append(this.f2213h);
        return stringBuffer.toString();
    }

    public int j() {
        return this.f2212g;
    }

    public g k() {
        return this.f2213h;
    }

    m() {
    }
}
