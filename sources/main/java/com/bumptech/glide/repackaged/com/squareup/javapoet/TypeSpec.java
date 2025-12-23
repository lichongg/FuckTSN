package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class TypeSpec {

    /* renamed from: q, reason: collision with root package name */
    static final /* synthetic */ boolean f15972q = false;

    /* renamed from: a, reason: collision with root package name */
    public final Kind f15973a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15974b;

    /* renamed from: c, reason: collision with root package name */
    public final d f15975c;

    /* renamed from: d, reason: collision with root package name */
    public final d f15976d;

    /* renamed from: e, reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f15977e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Modifier> f15978f;

    /* renamed from: g, reason: collision with root package name */
    public final List<m> f15979g;

    /* renamed from: h, reason: collision with root package name */
    public final l f15980h;

    /* renamed from: i, reason: collision with root package name */
    public final List<l> f15981i;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, TypeSpec> f15982j;

    /* renamed from: k, reason: collision with root package name */
    public final List<f> f15983k;

    /* renamed from: l, reason: collision with root package name */
    public final d f15984l;

    /* renamed from: m, reason: collision with root package name */
    public final d f15985m;

    /* renamed from: n, reason: collision with root package name */
    public final List<i> f15986n;

    /* renamed from: o, reason: collision with root package name */
    public final List<TypeSpec> f15987o;

    /* renamed from: p, reason: collision with root package name */
    public final List<Element> f15988p;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CLASS' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Kind {
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind ANNOTATION;
        public static final Kind CLASS;
        public static final Kind ENUM;
        public static final Kind INTERFACE;
        private final Set<Modifier> asMemberModifiers;
        private final Set<Modifier> implicitFieldModifiers;
        private final Set<Modifier> implicitMethodModifiers;
        private final Set<Modifier> implicitTypeModifiers;

        static {
            Set set = Collections.EMPTY_SET;
            Kind kind = new Kind("CLASS", 0, set, set, set, set);
            CLASS = kind;
            Kind kind2 = new Kind("INTERFACE", 1, n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), n.i(Arrays.asList(Modifier.STATIC)));
            INTERFACE = kind2;
            Kind kind3 = new Kind("ENUM", 2, set, set, set, Collections.singleton(Modifier.STATIC));
            ENUM = kind3;
            Kind kind4 = new Kind("ANNOTATION", 3, n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), n.i(Arrays.asList(Modifier.STATIC)));
            ANNOTATION = kind4;
            $VALUES = new Kind[]{kind, kind2, kind3, kind4};
        }

        private Kind(String str, int i6, Set set, Set set2, Set set3, Set set4) {
            this.implicitFieldModifiers = set;
            this.implicitMethodModifiers = set2;
            this.implicitTypeModifiers = set3;
            this.asMemberModifiers = set4;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Kind f15989a;

        /* renamed from: b, reason: collision with root package name */
        private final String f15990b;

        /* renamed from: c, reason: collision with root package name */
        private final d f15991c;

        /* renamed from: d, reason: collision with root package name */
        private final d.b f15992d;

        /* renamed from: e, reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f15993e;

        /* renamed from: f, reason: collision with root package name */
        private final List<Modifier> f15994f;

        /* renamed from: g, reason: collision with root package name */
        private final List<m> f15995g;

        /* renamed from: h, reason: collision with root package name */
        private l f15996h;

        /* renamed from: i, reason: collision with root package name */
        private final List<l> f15997i;

        /* renamed from: j, reason: collision with root package name */
        private final Map<String, TypeSpec> f15998j;

        /* renamed from: k, reason: collision with root package name */
        private final List<f> f15999k;

        /* renamed from: l, reason: collision with root package name */
        private final d.b f16000l;

        /* renamed from: m, reason: collision with root package name */
        private final d.b f16001m;

        /* renamed from: n, reason: collision with root package name */
        private final List<i> f16002n;

        /* renamed from: o, reason: collision with root package name */
        private final List<TypeSpec> f16003o;

        /* renamed from: p, reason: collision with root package name */
        private final List<Element> f16004p;

        /* synthetic */ b(Kind kind, String str, d dVar, a aVar) {
            this(kind, str, dVar);
        }

        public b w(Iterable<i> iterable) {
            n.b(iterable != null, "methodSpecs == null", new Object[0]);
            Iterator<i> it = iterable.iterator();
            while (it.hasNext()) {
                v(it.next());
            }
            return this;
        }

        public b y(l lVar) {
            n.b(lVar != null, "superinterface == null", new Object[0]);
            this.f15997i.add(lVar);
            return this;
        }

        private b(Kind kind, String str, d dVar) {
            this.f15992d = d.a();
            this.f15993e = new ArrayList();
            this.f15994f = new ArrayList();
            this.f15995g = new ArrayList();
            this.f15996h = c.f16011y;
            this.f15997i = new ArrayList();
            this.f15998j = new LinkedHashMap();
            this.f15999k = new ArrayList();
            this.f16000l = d.a();
            this.f16001m = d.a();
            this.f16002n = new ArrayList();
            this.f16003o = new ArrayList();
            this.f16004p = new ArrayList();
            n.b(str == null || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f15989a = kind;
            this.f15990b = str;
            this.f15991c = dVar;
        }

        public b A(m mVar) {
            n.d(this.f15991c == null, "forbidden on anonymous types.", new Object[0]);
            this.f15995g.add(mVar);
            return this;
        }

        public TypeSpec B() {
            boolean z5 = true;
            n.b((this.f15989a == Kind.ENUM && this.f15998j.isEmpty()) ? false : true, "at least one enum constant is required for %s", this.f15990b);
            boolean z6 = this.f15994f.contains(Modifier.ABSTRACT) || this.f15989a != Kind.CLASS;
            for (i iVar : this.f16002n) {
                n.b(z6 || !iVar.c(Modifier.ABSTRACT), "non-abstract type %s cannot declare abstract method %s", this.f15990b, iVar.f16067a);
            }
            int size = (!this.f15996h.equals(c.f16011y) ? 1 : 0) + this.f15997i.size();
            if (this.f15991c != null && size > 1) {
                z5 = false;
            }
            n.b(z5, "anonymous type has too many supertypes", new Object[0]);
            return new TypeSpec(this, null);
        }

        public b C(l lVar) {
            n.d(this.f15989a == Kind.CLASS, "only classes have super classes, not " + this.f15989a, new Object[0]);
            n.d(this.f15996h == c.f16011y, "superclass already set to " + this.f15996h, new Object[0]);
            n.b(lVar.p() ^ true, "superclass may not be a primitive", new Object[0]);
            this.f15996h = lVar;
            return this;
        }

        public b q(com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar) {
            this.f15993e.add(aVar);
            return this;
        }

        public b r(f fVar) {
            Kind kind = this.f15989a;
            if (kind == Kind.INTERFACE || kind == Kind.ANNOTATION) {
                n.k(fVar.f16039e, Modifier.PUBLIC, Modifier.PRIVATE);
                EnumSet of = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
                n.d(fVar.f16039e.containsAll(of), "%s %s.%s requires modifiers %s", this.f15989a, this.f15990b, fVar.f16036b, of);
            }
            this.f15999k.add(fVar);
            return this;
        }

        public b t(d dVar) {
            this.f15992d.a(dVar);
            return this;
        }

        public b u(String str, Object... objArr) {
            this.f15992d.b(str, objArr);
            return this;
        }

        public b v(i iVar) {
            Kind kind = this.f15989a;
            Kind kind2 = Kind.INTERFACE;
            if (kind == kind2) {
                n.k(iVar.f16070d, Modifier.ABSTRACT, Modifier.STATIC, n.f16126a);
                n.k(iVar.f16070d, Modifier.PUBLIC, Modifier.PRIVATE);
            } else if (kind == Kind.ANNOTATION) {
                boolean equals = iVar.f16070d.equals(kind.implicitMethodModifiers);
                Kind kind3 = this.f15989a;
                n.d(equals, "%s %s.%s requires modifiers %s", kind3, this.f15990b, iVar.f16067a, kind3.implicitMethodModifiers);
            }
            Kind kind4 = this.f15989a;
            if (kind4 != Kind.ANNOTATION) {
                n.d(iVar.f16077k == null, "%s %s.%s cannot have a default value", kind4, this.f15990b, iVar.f16067a);
            }
            if (this.f15989a != kind2) {
                n.d(!n.e(iVar.f16070d), "%s %s.%s cannot be default", this.f15989a, this.f15990b, iVar.f16067a);
            }
            this.f16002n.add(iVar);
            return this;
        }

        public b x(Modifier... modifierArr) {
            n.d(this.f15991c == null, "forbidden on anonymous types.", new Object[0]);
            int length = modifierArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                Modifier modifier = modifierArr[i6];
                n.b(modifier != null, "modifiers contain null", new Object[0]);
                this.f15994f.add(modifier);
            }
            return this;
        }

        public b s(l lVar, String str, Modifier... modifierArr) {
            return r(f.a(lVar, str, modifierArr).h());
        }

        public b z(Type type) {
            return y(l.j(type));
        }
    }

    /* synthetic */ TypeSpec(b bVar, a aVar) {
        this(bVar);
    }

    private TypeSpec(b bVar) {
        this.f15973a = bVar.f15989a;
        this.f15974b = bVar.f15990b;
        this.f15975c = bVar.f15991c;
        this.f15976d = bVar.f15992d.j();
        this.f15977e = n.f(bVar.f15993e);
        this.f15978f = n.i(bVar.f15994f);
        this.f15979g = n.f(bVar.f15995g);
        this.f15980h = bVar.f15996h;
        this.f15981i = n.f(bVar.f15997i);
        this.f15982j = n.g(bVar.f15998j);
        this.f15983k = n.f(bVar.f15999k);
        this.f15984l = bVar.f16000l.j();
        this.f15985m = bVar.f16001m.j();
        this.f15986n = n.f(bVar.f16002n);
        this.f15987o = n.f(bVar.f16003o);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(bVar.f16004p);
        Iterator it = bVar.f16003o.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((TypeSpec) it.next()).f15988p);
        }
        this.f15988p = n.f(arrayList);
    }

    public static b a(String str) {
        return new b(Kind.CLASS, (String) n.c(str, "name == null", new Object[0]), null, 0 == true ? 1 : 0);
    }

    void b(e eVar, String str, Set<Modifier> set) throws IOException {
        List<l> singletonList;
        List<l> list;
        int i6 = eVar.f16034n;
        eVar.f16034n = -1;
        boolean z5 = true;
        try {
            if (str != null) {
                eVar.h(this.f15976d);
                eVar.e(this.f15977e, false);
                eVar.c("$L", str);
                if (!this.f15975c.f16016a.isEmpty()) {
                    eVar.b("(");
                    eVar.a(this.f15975c);
                    eVar.b(")");
                }
                if (this.f15983k.isEmpty() && this.f15986n.isEmpty() && this.f15987o.isEmpty()) {
                    eVar.f16034n = i6;
                    return;
                }
                eVar.b(" {\n");
            } else if (this.f15975c != null) {
                eVar.c("new $T(", !this.f15981i.isEmpty() ? this.f15981i.get(0) : this.f15980h);
                eVar.a(this.f15975c);
                eVar.b(") {\n");
            } else {
                eVar.x(new TypeSpec(this));
                eVar.h(this.f15976d);
                eVar.e(this.f15977e, false);
                eVar.k(this.f15978f, n.m(set, this.f15973a.asMemberModifiers));
                Kind kind = this.f15973a;
                if (kind == Kind.ANNOTATION) {
                    eVar.c("$L $L", "@interface", this.f15974b);
                } else {
                    eVar.c("$L $L", kind.name().toLowerCase(Locale.US), this.f15974b);
                }
                eVar.m(this.f15979g);
                if (this.f15973a == Kind.INTERFACE) {
                    singletonList = this.f15981i;
                    list = Collections.EMPTY_LIST;
                } else {
                    singletonList = this.f15980h.equals(c.f16011y) ? Collections.EMPTY_LIST : Collections.singletonList(this.f15980h);
                    list = this.f15981i;
                }
                if (!singletonList.isEmpty()) {
                    eVar.b(" extends");
                    boolean z6 = true;
                    for (l lVar : singletonList) {
                        if (!z6) {
                            eVar.b(",");
                        }
                        eVar.c(" $T", lVar);
                        z6 = false;
                    }
                }
                if (!list.isEmpty()) {
                    eVar.b(" implements");
                    boolean z7 = true;
                    for (l lVar2 : list) {
                        if (!z7) {
                            eVar.b(",");
                        }
                        eVar.c(" $T", lVar2);
                        z7 = false;
                    }
                }
                eVar.v();
                eVar.b(" {\n");
            }
            eVar.x(this);
            eVar.r();
            Iterator<Map.Entry<String, TypeSpec>> it = this.f15982j.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, TypeSpec> next = it.next();
                if (!z5) {
                    eVar.b(com.snail.antifake.deviceid.e.f37542d);
                }
                next.getValue().b(eVar, next.getKey(), Collections.EMPTY_SET);
                if (it.hasNext()) {
                    eVar.b(",\n");
                } else {
                    if (this.f15983k.isEmpty() && this.f15986n.isEmpty() && this.f15987o.isEmpty()) {
                        eVar.b(com.snail.antifake.deviceid.e.f37542d);
                    }
                    eVar.b(";\n");
                }
                z5 = false;
            }
            for (f fVar : this.f15983k) {
                if (fVar.c(Modifier.STATIC)) {
                    if (!z5) {
                        eVar.b(com.snail.antifake.deviceid.e.f37542d);
                    }
                    fVar.b(eVar, this.f15973a.implicitFieldModifiers);
                    z5 = false;
                }
            }
            if (!this.f15984l.b()) {
                if (!z5) {
                    eVar.b(com.snail.antifake.deviceid.e.f37542d);
                }
                eVar.a(this.f15984l);
                z5 = false;
            }
            for (f fVar2 : this.f15983k) {
                if (!fVar2.c(Modifier.STATIC)) {
                    if (!z5) {
                        eVar.b(com.snail.antifake.deviceid.e.f37542d);
                    }
                    fVar2.b(eVar, this.f15973a.implicitFieldModifiers);
                    z5 = false;
                }
            }
            if (!this.f15985m.b()) {
                if (!z5) {
                    eVar.b(com.snail.antifake.deviceid.e.f37542d);
                }
                eVar.a(this.f15985m);
                z5 = false;
            }
            for (i iVar : this.f15986n) {
                if (iVar.d()) {
                    if (!z5) {
                        eVar.b(com.snail.antifake.deviceid.e.f37542d);
                    }
                    iVar.b(eVar, this.f15974b, this.f15973a.implicitMethodModifiers);
                    z5 = false;
                }
            }
            for (i iVar2 : this.f15986n) {
                if (!iVar2.d()) {
                    if (!z5) {
                        eVar.b(com.snail.antifake.deviceid.e.f37542d);
                    }
                    iVar2.b(eVar, this.f15974b, this.f15973a.implicitMethodModifiers);
                    z5 = false;
                }
            }
            for (TypeSpec typeSpec : this.f15987o) {
                if (!z5) {
                    eVar.b(com.snail.antifake.deviceid.e.f37542d);
                }
                typeSpec.b(eVar, null, this.f15973a.implicitTypeModifiers);
                z5 = false;
            }
            eVar.B();
            eVar.v();
            eVar.b("}");
            if (str == null && this.f15975c == null) {
                eVar.b(com.snail.antifake.deviceid.e.f37542d);
            }
            eVar.f16034n = i6;
        } catch (Throwable th) {
            eVar.f16034n = i6;
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TypeSpec.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            b(new e(stringWriter), null, Collections.EMPTY_SET);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    private TypeSpec(TypeSpec typeSpec) {
        this.f15973a = typeSpec.f15973a;
        this.f15974b = typeSpec.f15974b;
        this.f15975c = null;
        this.f15976d = typeSpec.f15976d;
        List<Element> list = Collections.EMPTY_LIST;
        this.f15977e = list;
        this.f15978f = Collections.EMPTY_SET;
        this.f15979g = list;
        this.f15980h = null;
        this.f15981i = list;
        this.f15982j = Collections.EMPTY_MAP;
        this.f15983k = list;
        this.f15984l = typeSpec.f15984l;
        this.f15985m = typeSpec.f15985m;
        this.f15986n = list;
        this.f15987o = list;
        this.f15988p = list;
    }
}
