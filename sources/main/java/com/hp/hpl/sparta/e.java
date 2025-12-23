package com.hp.hpl.sparta;

import com.hp.hpl.sparta.q;
import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e extends i {

    /* renamed from: l, reason: collision with root package name */
    private static final boolean f32788l = false;

    /* renamed from: m, reason: collision with root package name */
    private static final Integer f32789m = new Integer(1);

    /* renamed from: n, reason: collision with root package name */
    static final Enumeration f32790n = new h();

    /* renamed from: g, reason: collision with root package name */
    private g f32791g;

    /* renamed from: h, reason: collision with root package name */
    private String f32792h;

    /* renamed from: i, reason: collision with root package name */
    private q.c f32793i;

    /* renamed from: j, reason: collision with root package name */
    private Vector f32794j;

    /* renamed from: k, reason: collision with root package name */
    private final Hashtable f32795k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private transient q.c f32796a = null;

        /* renamed from: b, reason: collision with root package name */
        private final c0 f32797b;

        /* renamed from: c, reason: collision with root package name */
        private final String f32798c;

        public synchronized Enumeration a(String str) throws ParseException {
            Vector vector;
            try {
                if (this.f32796a == null) {
                    b();
                }
                vector = (Vector) this.f32796a.get(str);
            } catch (Throwable th) {
                throw th;
            }
            return vector == null ? e.f32790n : vector.elements();
        }

        public synchronized int c() throws ParseException {
            try {
                if (this.f32796a == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f32796a.size();
        }

        @Override // com.hp.hpl.sparta.e.b
        public synchronized void update(e eVar) {
            this.f32796a = null;
        }

        a(c0 c0Var) throws XPathException {
            this.f32798c = c0Var.d();
            this.f32797b = c0Var;
            e.this.x(this);
        }

        private void b() throws ParseException {
            try {
                this.f32796a = q.b();
                Enumeration w5 = e.this.E(this.f32797b, false).w();
                while (w5.hasMoreElements()) {
                    g gVar = (g) w5.nextElement();
                    String D = gVar.D(this.f32798c);
                    Vector vector = (Vector) this.f32796a.get(D);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.f32796a.put(D, vector);
                    }
                    vector.addElement(gVar);
                }
            } catch (XPathException e6) {
                throw new ParseException("XPath problem", e6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void update(e eVar);
    }

    e(String str) {
        this.f32791g = null;
        this.f32793i = q.b();
        this.f32794j = new Vector();
        this.f32795k = null;
        this.f32792h = str;
    }

    private s F(String str, boolean z5) throws XPathException {
        if (str.charAt(0) != '/') {
            str = "/" + str;
        }
        return E(c0.b(str), z5);
    }

    @Override // com.hp.hpl.sparta.i
    public g s(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            c0 b6 = c0.b(str);
            B(b6);
            return E(b6, false).u();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration t(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            c0 b6 = c0.b(str);
            B(b6);
            return E(b6, false).w();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public String u(String str) throws ParseException {
        try {
            return F(str, true).v();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration v(String str) throws ParseException {
        try {
            return F(str, true).w();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    public String A() {
        return this.f32792h;
    }

    public void C(g gVar) {
        this.f32791g = gVar;
        gVar.n(this);
        j();
    }

    public void D(String str) {
        this.f32792h = str;
        j();
    }

    public a H(String str) throws ParseException {
        try {
            a aVar = (a) this.f32793i.get(str);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a(c0.b(str));
            this.f32793i.put(str, aVar2);
            return aVar2;
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    public boolean I(String str) {
        return this.f32793i.get(str) != null;
    }

    @Override // com.hp.hpl.sparta.i
    protected int a() {
        return this.f32791g.hashCode();
    }

    @Override // com.hp.hpl.sparta.i
    public Object clone() {
        e eVar = new e(this.f32792h);
        eVar.f32791g = (g) this.f32791g.clone();
        return eVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f32791g.equals(((e) obj).f32791g);
        }
        return false;
    }

    @Override // com.hp.hpl.sparta.i
    void j() {
        Enumeration elements = this.f32794j.elements();
        while (elements.hasMoreElements()) {
            ((b) elements.nextElement()).update(this);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public void p(Writer writer) throws IOException {
        this.f32791g.p(writer);
    }

    @Override // com.hp.hpl.sparta.i
    public void r(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.f32791g.r(writer);
    }

    @Override // com.hp.hpl.sparta.i
    public String toString() {
        return this.f32792h;
    }

    public void x(b bVar) {
        this.f32794j.addElement(bVar);
    }

    public void y(b bVar) {
        this.f32794j.removeElement(bVar);
    }

    public g z() {
        return this.f32791g;
    }

    s E(c0 c0Var, boolean z5) throws XPathException {
        String str;
        if (c0Var.h() != z5) {
            if (z5) {
                str = "evaluates to element not string";
            } else {
                str = "evaluates to string not element";
            }
            throw new XPathException(c0Var, "\"" + c0Var + "\" evaluates to " + str);
        }
        return new s(this, c0Var);
    }

    public boolean G(String str) throws ParseException {
        try {
            if (s(str) != null) {
                return false;
            }
            c0 b6 = c0.b(str);
            Enumeration f6 = b6.f();
            int i6 = 0;
            while (f6.hasMoreElements()) {
                f6.nextElement();
                i6++;
            }
            Enumeration f7 = b6.f();
            t tVar = (t) f7.nextElement();
            int i7 = i6 - 1;
            t[] tVarArr = new t[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                tVarArr[i8] = (t) f7.nextElement();
            }
            if (this.f32791g == null) {
                C(i(null, tVar, str));
            } else {
                if (s("/" + tVar) == null) {
                    throw new ParseException("Existing root element <" + this.f32791g.H() + "...> does not match first step \"" + tVar + "\" of \"" + str);
                }
            }
            if (i7 == 0) {
                return true;
            }
            return this.f32791g.R(c0.c(false, tVarArr).toString());
        } catch (XPathException e6) {
            throw new ParseException(str, e6);
        }
    }

    public e() {
        this.f32791g = null;
        this.f32793i = q.b();
        this.f32794j = new Vector();
        this.f32795k = null;
        this.f32792h = "MEMORY";
    }

    void B(c0 c0Var) throws XPathException {
    }
}
