package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f16067a;

    /* renamed from: b, reason: collision with root package name */
    public final d f16068b;

    /* renamed from: c, reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16069c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<Modifier> f16070d;

    /* renamed from: e, reason: collision with root package name */
    public final List<m> f16071e;

    /* renamed from: f, reason: collision with root package name */
    public final l f16072f;

    /* renamed from: g, reason: collision with root package name */
    public final List<j> f16073g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16074h;

    /* renamed from: i, reason: collision with root package name */
    public final List<l> f16075i;

    /* renamed from: j, reason: collision with root package name */
    public final d f16076j;

    /* renamed from: k, reason: collision with root package name */
    public final d f16077k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f16078a;

        /* renamed from: b, reason: collision with root package name */
        private final d.b f16079b;

        /* renamed from: c, reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16080c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Modifier> f16081d;

        /* renamed from: e, reason: collision with root package name */
        private List<m> f16082e;

        /* renamed from: f, reason: collision with root package name */
        private l f16083f;

        /* renamed from: g, reason: collision with root package name */
        private final List<j> f16084g;

        /* renamed from: h, reason: collision with root package name */
        private final Set<l> f16085h;

        /* renamed from: i, reason: collision with root package name */
        private final d.b f16086i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f16087j;

        /* renamed from: k, reason: collision with root package name */
        private d f16088k;

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        public b A(Iterable<m> iterable) {
            n.b(iterable != null, "typeVariables == null", new Object[0]);
            Iterator<m> it = iterable.iterator();
            while (it.hasNext()) {
                this.f16082e.add(it.next());
            }
            return this;
        }

        public b o(Iterable<com.bumptech.glide.repackaged.com.squareup.javapoet.a> iterable) {
            n.b(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<com.bumptech.glide.repackaged.com.squareup.javapoet.a> it = iterable.iterator();
            while (it.hasNext()) {
                this.f16080c.add(it.next());
            }
            return this;
        }

        public b t(Iterable<Modifier> iterable) {
            n.c(iterable, "modifiers == null", new Object[0]);
            Iterator<Modifier> it = iterable.iterator();
            while (it.hasNext()) {
                this.f16081d.add(it.next());
            }
            return this;
        }

        public b u(Modifier... modifierArr) {
            n.c(modifierArr, "modifiers == null", new Object[0]);
            Collections.addAll(this.f16081d, modifierArr);
            return this;
        }

        public b x(Iterable<j> iterable) {
            n.b(iterable != null, "parameterSpecs == null", new Object[0]);
            Iterator<j> it = iterable.iterator();
            while (it.hasNext()) {
                this.f16084g.add(it.next());
            }
            return this;
        }

        private b(String str) {
            this.f16079b = d.a();
            this.f16080c = new ArrayList();
            this.f16081d = new ArrayList();
            this.f16082e = new ArrayList();
            this.f16084g = new ArrayList();
            this.f16085h = new LinkedHashSet();
            this.f16086i = d.a();
            n.c(str, "name == null", new Object[0]);
            n.b(str.equals("<init>") || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f16078a = str;
            this.f16083f = str.equals("<init>") ? null : l.f16100d;
        }

        public b B(String str, Object... objArr) {
            this.f16086i.i(str, objArr);
            return this;
        }

        public i C() {
            return new i(this, null);
        }

        public b D() {
            this.f16086i.k();
            return this;
        }

        public b E(String str, Object... objArr) {
            this.f16086i.n(str, objArr);
            return this;
        }

        public b F(l lVar) {
            n.d(!this.f16078a.equals("<init>"), "constructor cannot have return type.", new Object[0]);
            this.f16083f = lVar;
            return this;
        }

        public b H(boolean z5) {
            this.f16087j = z5;
            return this;
        }

        public b l(com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar) {
            this.f16080c.add(aVar);
            return this;
        }

        public b m(c cVar) {
            this.f16080c.add(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b p(d dVar) {
            this.f16086i.a(dVar);
            return this;
        }

        public b q(String str, Object... objArr) {
            this.f16086i.b(str, objArr);
            return this;
        }

        public b r(l lVar) {
            this.f16085h.add(lVar);
            return this;
        }

        public b s(d dVar) {
            this.f16079b.a(dVar);
            return this;
        }

        public b v(j jVar) {
            this.f16084g.add(jVar);
            return this;
        }

        public b y(String str, Object... objArr) {
            this.f16086i.d(str, objArr);
            return this;
        }

        public b z(m mVar) {
            this.f16082e.add(mVar);
            return this;
        }

        public b G(Type type) {
            return F(l.j(type));
        }

        public b n(Class<?> cls) {
            return m(c.w(cls));
        }

        public b w(l lVar, String str, Modifier... modifierArr) {
            return v(j.a(lVar, str, modifierArr).i());
        }
    }

    /* synthetic */ i(b bVar, a aVar) {
        this(bVar);
    }

    private i(b bVar) {
        d j6 = bVar.f16086i.j();
        n.b(j6.b() || !bVar.f16081d.contains(Modifier.ABSTRACT), "abstract method %s cannot have code", bVar.f16078a);
        n.b(!bVar.f16087j || e(bVar.f16084g), "last parameter of varargs method %s must be an array", bVar.f16078a);
        this.f16067a = (String) n.c(bVar.f16078a, "name == null", new Object[0]);
        this.f16068b = bVar.f16079b.j();
        this.f16069c = n.f(bVar.f16080c);
        this.f16070d = n.i(bVar.f16081d);
        this.f16071e = n.f(bVar.f16082e);
        this.f16072f = bVar.f16083f;
        this.f16073g = n.f(bVar.f16084g);
        this.f16074h = bVar.f16087j;
        this.f16075i = n.f(bVar.f16085h);
        this.f16077k = bVar.f16088k;
        this.f16076j = j6;
    }

    public static b a() {
        return new b("<init>", null);
    }

    public static b f(String str) {
        return new b(str, null);
    }

    void b(e eVar, String str, Set<Modifier> set) throws IOException {
        eVar.h(this.f16068b);
        eVar.e(this.f16069c, false);
        eVar.k(this.f16070d, set);
        if (!this.f16071e.isEmpty()) {
            eVar.m(this.f16071e);
            eVar.b(" ");
        }
        if (d()) {
            eVar.c("$L(", str);
        } else {
            eVar.c("$T $L(", this.f16072f, this.f16067a);
        }
        Iterator<j> it = this.f16073g.iterator();
        boolean z5 = true;
        while (it.hasNext()) {
            j next = it.next();
            if (!z5) {
                eVar.b(",").n();
            }
            next.b(eVar, !it.hasNext() && this.f16074h);
            z5 = false;
        }
        eVar.b(")");
        d dVar = this.f16077k;
        if (dVar != null && !dVar.b()) {
            eVar.b(" default ");
            eVar.a(this.f16077k);
        }
        if (!this.f16075i.isEmpty()) {
            eVar.n().b("throws");
            boolean z6 = true;
            for (l lVar : this.f16075i) {
                if (!z6) {
                    eVar.b(",");
                }
                eVar.n().c("$T", lVar);
                z6 = false;
            }
        }
        if (c(Modifier.ABSTRACT)) {
            eVar.b(";\n");
            return;
        }
        if (c(Modifier.NATIVE)) {
            eVar.a(this.f16076j);
            eVar.b(";\n");
            return;
        }
        eVar.b(" {\n");
        eVar.r();
        eVar.a(this.f16076j);
        eVar.B();
        eVar.b("}\n");
    }

    public boolean c(Modifier modifier) {
        return this.f16070d.contains(modifier);
    }

    public boolean d() {
        return this.f16067a.equals("<init>");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            b(new e(stringWriter), "Constructor", Collections.EMPTY_SET);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private boolean e(List<j> list) {
        if (!list.isEmpty() && l.c(list.get(list.size() - 1).f16092d) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
