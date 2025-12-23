package com.hp.hpl.sparta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class a implements f, m {

    /* renamed from: c, reason: collision with root package name */
    private final n f32779c;

    /* renamed from: d, reason: collision with root package name */
    private g f32780d;

    /* renamed from: e, reason: collision with root package name */
    private final e f32781e;

    /* renamed from: f, reason: collision with root package name */
    private o f32782f;

    public a() {
        this(null);
    }

    public a(n nVar) {
        this.f32780d = null;
        this.f32781e = new e();
        this.f32782f = null;
        this.f32779c = nVar == null ? o.f32854a : nVar;
    }

    @Override // com.hp.hpl.sparta.m
    public void a(g gVar) {
        this.f32780d = this.f32780d.e();
    }

    @Override // com.hp.hpl.sparta.f
    public e b() {
        return this.f32781e;
    }

    @Override // com.hp.hpl.sparta.m
    public void c(o oVar) {
        this.f32782f = oVar;
        this.f32781e.D(oVar.toString());
    }

    @Override // com.hp.hpl.sparta.m
    public void characters(char[] cArr, int i6, int i7) {
        g gVar = this.f32780d;
        if (gVar.G() instanceof r) {
            ((r) gVar.G()).z(cArr, i6, i7);
        } else {
            gVar.y(new r(new String(cArr, i6, i7)));
        }
    }

    @Override // com.hp.hpl.sparta.m
    public o d() {
        return this.f32782f;
    }

    @Override // com.hp.hpl.sparta.m
    public void e(g gVar) {
        g gVar2 = this.f32780d;
        if (gVar2 == null) {
            this.f32781e.C(gVar);
        } else {
            gVar2.x(gVar);
        }
        this.f32780d = gVar;
    }

    @Override // com.hp.hpl.sparta.o
    public int getLineNumber() {
        o oVar = this.f32782f;
        if (oVar != null) {
            return oVar.getLineNumber();
        }
        return -1;
    }

    @Override // com.hp.hpl.sparta.o
    public String getSystemId() {
        o oVar = this.f32782f;
        if (oVar != null) {
            return oVar.getSystemId();
        }
        return null;
    }

    @Override // com.hp.hpl.sparta.o
    public String toString() {
        if (this.f32782f == null) {
            return null;
        }
        return "BuildDoc: " + this.f32782f.toString();
    }

    @Override // com.hp.hpl.sparta.m
    public void endDocument() {
    }

    @Override // com.hp.hpl.sparta.m
    public void startDocument() {
    }
}
