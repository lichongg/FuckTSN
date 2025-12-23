package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.a0;
import com.hp.hpl.sparta.xpath.b0;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import com.hp.hpl.sparta.xpath.v;
import com.hp.hpl.sparta.xpath.w;
import com.hp.hpl.sparta.xpath.x;
import com.hp.hpl.sparta.xpath.y;
import com.hp.hpl.sparta.xpath.z;
import java.util.Enumeration;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class s implements b0 {

    /* renamed from: i, reason: collision with root package name */
    private static final Boolean f32860i = new Boolean(true);

    /* renamed from: j, reason: collision with root package name */
    private static final Boolean f32861j = new Boolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final j f32862a;

    /* renamed from: b, reason: collision with root package name */
    private Vector f32863b;

    /* renamed from: c, reason: collision with root package name */
    private Enumeration f32864c;

    /* renamed from: d, reason: collision with root package name */
    private Object f32865d;

    /* renamed from: e, reason: collision with root package name */
    private final b f32866e;

    /* renamed from: f, reason: collision with root package name */
    private i f32867f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32868g;

    /* renamed from: h, reason: collision with root package name */
    private c0 f32869h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private a f32870a;

        private b() {
            this.f32870a = null;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class a {

            /* renamed from: a, reason: collision with root package name */
            final Boolean f32871a;

            /* renamed from: b, reason: collision with root package name */
            final a f32872b;

            a(Boolean bool, a aVar) {
                this.f32871a = bool;
                this.f32872b = aVar;
            }
        }

        Boolean a() {
            a aVar = this.f32870a;
            Boolean bool = aVar.f32871a;
            this.f32870a = aVar.f32872b;
            return bool;
        }

        void b(Boolean bool) {
            this.f32870a = new a(bool, this.f32870a);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    private s(c0 c0Var, i iVar) throws XPathException {
        this.f32862a = new j();
        this.f32863b = new Vector();
        this.f32864c = null;
        this.f32865d = null;
        this.f32866e = new b(null);
        this.f32869h = c0Var;
        this.f32867f = iVar;
        Vector vector = new Vector(1);
        this.f32863b = vector;
        vector.addElement(this.f32867f);
        Enumeration f6 = c0Var.f();
        while (f6.hasMoreElements()) {
            t tVar = (t) f6.nextElement();
            this.f32868g = tVar.c();
            this.f32864c = null;
            tVar.a().a(this);
            this.f32864c = this.f32862a.d();
            this.f32863b.removeAllElements();
            com.hp.hpl.sparta.xpath.k b6 = tVar.b();
            while (this.f32864c.hasMoreElements()) {
                this.f32865d = this.f32864c.nextElement();
                b6.a(this);
                if (this.f32866e.a().booleanValue()) {
                    this.f32863b.addElement(this.f32865d);
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void a(com.hp.hpl.sparta.xpath.j jVar) {
        String D;
        Vector vector = this.f32863b;
        this.f32862a.f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            i iVar = (i) elements.nextElement();
            if ((iVar instanceof g) && (D = ((g) iVar).D(jVar.c())) != null) {
                this.f32862a.b(D);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void b(x xVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        for (i F = ((g) obj).F(); F != null; F = F.c()) {
            if ((F instanceof r) && !((r) F).A().equals(xVar.b())) {
                this.f32866e.b(f32860i);
                return;
            }
        }
        this.f32866e.b(f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void c(com.hp.hpl.sparta.xpath.h hVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        this.f32866e.b(!hVar.c().equals(((g) obj).D(hVar.b())) ? f32860i : f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void d(com.hp.hpl.sparta.xpath.a aVar) {
        Vector vector = this.f32863b;
        this.f32862a.f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof g) {
                r((g) nextElement);
            } else if (nextElement instanceof e) {
                q((e) nextElement);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void e(y yVar) {
        Vector vector = this.f32863b;
        this.f32862a.f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof g) {
                for (i F = ((g) nextElement).F(); F != null; F = F.c()) {
                    if (F instanceof r) {
                        this.f32862a.b(((r) F).A());
                    }
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void f(com.hp.hpl.sparta.xpath.q qVar) throws XPathException {
        this.f32862a.f();
        g e6 = this.f32867f.e();
        if (e6 == null) {
            throw new XPathException(this.f32869h, "Illegal attempt to apply \"..\" to node with no parent.");
        }
        this.f32862a.a(e6, 1);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void g(v vVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        for (i F = ((g) obj).F(); F != null; F = F.c()) {
            if ((F instanceof r) && ((r) F).A().equals(vVar.b())) {
                this.f32866e.b(f32860i);
                return;
            }
        }
        this.f32866e.b(f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void h(a0 a0Var) {
        this.f32866e.b(f32860i);
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void i(z zVar) {
        this.f32862a.f();
        this.f32862a.a(this.f32867f, 1);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void j(com.hp.hpl.sparta.xpath.r rVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test position of document");
        }
        this.f32866e.b(this.f32862a.e((g) obj) == rVar.b() ? f32860i : f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void k(w wVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        for (i F = ((g) obj).F(); F != null; F = F.c()) {
            if (F instanceof r) {
                this.f32866e.b(f32860i);
                return;
            }
        }
        this.f32866e.b(f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void m(com.hp.hpl.sparta.xpath.f fVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        this.f32866e.b((((double) Long.parseLong(((g) obj).D(fVar.b()))) > fVar.c() ? 1 : (((double) Long.parseLong(((g) obj).D(fVar.b()))) == fVar.c() ? 0 : -1)) > 0 ? f32860i : f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void n(com.hp.hpl.sparta.xpath.c cVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        this.f32866e.b(cVar.c().equals(((g) obj).D(cVar.b())) ? f32860i : f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void o(com.hp.hpl.sparta.xpath.g gVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        this.f32866e.b((((double) Long.parseLong(((g) obj).D(gVar.b()))) > gVar.c() ? 1 : (((double) Long.parseLong(((g) obj).D(gVar.b()))) == gVar.c() ? 0 : -1)) < 0 ? f32860i : f32861j);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void p(com.hp.hpl.sparta.xpath.d dVar) throws XPathException {
        Object obj = this.f32865d;
        if (!(obj instanceof g)) {
            throw new XPathException(this.f32869h, "Cannot test attribute of document");
        }
        String D = ((g) obj).D(dVar.b());
        this.f32866e.b(D != null && D.length() > 0 ? f32860i : f32861j);
    }

    public g u() {
        if (this.f32863b.size() == 0) {
            return null;
        }
        return (g) this.f32863b.elementAt(0);
    }

    public String v() {
        if (this.f32863b.size() == 0) {
            return null;
        }
        return this.f32863b.elementAt(0).toString();
    }

    public Enumeration w() {
        return this.f32863b.elements();
    }

    private void q(e eVar) {
        g z5 = eVar.z();
        this.f32862a.a(z5, 1);
        if (this.f32868g) {
            r(z5);
        }
    }

    private void r(g gVar) {
        int i6 = 0;
        for (i F = gVar.F(); F != null; F = F.c()) {
            if (F instanceof g) {
                i6++;
                this.f32862a.a(F, i6);
                if (this.f32868g) {
                    r((g) F);
                }
            }
        }
    }

    private void s(e eVar, String str) {
        g z5 = eVar.z();
        if (z5 != null) {
            if (z5.H() == str) {
                this.f32862a.a(z5, 1);
            }
            if (this.f32868g) {
                t(z5, str);
            }
        }
    }

    private void t(g gVar, String str) {
        int i6 = 0;
        for (i F = gVar.F(); F != null; F = F.c()) {
            if (F instanceof g) {
                g gVar2 = (g) F;
                if (gVar2.H() == str) {
                    i6++;
                    this.f32862a.a(gVar2, i6);
                }
                if (this.f32868g) {
                    t(gVar2, str);
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void l(com.hp.hpl.sparta.xpath.m mVar) {
        String c6 = mVar.c();
        Vector vector = this.f32863b;
        int size = vector.size();
        this.f32862a.f();
        for (int i6 = 0; i6 < size; i6++) {
            Object elementAt = vector.elementAt(i6);
            if (elementAt instanceof g) {
                t((g) elementAt, c6);
            } else if (elementAt instanceof e) {
                s((e) elementAt, c6);
            }
        }
    }

    public s(g gVar, c0 c0Var) throws XPathException {
        this(c0Var, gVar);
        if (c0Var.g()) {
            throw new XPathException(c0Var, "Cannot use element as context node for absolute xpath");
        }
    }

    public s(e eVar, c0 c0Var) throws XPathException {
        this(c0Var, eVar);
    }
}
