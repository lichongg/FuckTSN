package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.bumptech.glide.repackaged.com.google.common.collect.w;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.a;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class j {

    /* renamed from: i, reason: collision with root package name */
    private static final ImmutableSet<String> f14620i = ImmutableSet.of("clone", "apply");

    /* renamed from: a, reason: collision with root package name */
    private final ProcessingEnvironment f14621a;

    /* renamed from: b, reason: collision with root package name */
    private final i f14622b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.m f14623c = com.bumptech.glide.repackaged.com.squareup.javapoet.m.t("TranscodeType");

    /* renamed from: d, reason: collision with root package name */
    private final TypeElement f14624d;

    /* renamed from: e, reason: collision with root package name */
    private final TypeElement f14625e;

    /* renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f14626f;

    /* renamed from: g, reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f14627g;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.k f14628h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.i, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return j.this.h(iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.e<com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f14630a;

        b(List list) {
            this.f14630a = list;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return j.this.m(this.f14630a, iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements com.bumptech.glide.repackaged.com.google.common.base.e<com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.squareup.javapoet.i f14632a;

        c(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            this.f14632a = iVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return iVar.f16067a.equals(this.f14632a.f16067a) && iVar.f16073g.equals(this.f14632a.f16073g);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        d() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f16089a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements com.bumptech.glide.repackaged.com.google.common.base.e<com.bumptech.glide.repackaged.com.squareup.javapoet.a> {
        e() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar) {
            return (aVar.f16005a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(Override.class)) || aVar.f16005a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(SafeVarargs.class)) || aVar.f16005a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(SuppressWarnings.class))) ? false : true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.d, String> {
        f() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.d dVar) {
            return dVar.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        g() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return j.this.j(executableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        h() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f16089a;
        }
    }

    TypeSpec e(String str, Set<String> set, TypeSpec typeSpec) {
        if (typeSpec != null) {
            this.f14627g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, typeSpec.f15974b, new String[0]);
        } else {
            this.f14627g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide.request", "BaseRequestOptions", new String[0]);
        }
        com.bumptech.glide.repackaged.com.squareup.javapoet.c x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, "GlideRequest", new String[0]);
        this.f14626f = x5;
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(x5, this.f14623c);
        this.f14628h = t5;
        m mVar = new m(t5, this.f14622b);
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t6 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "RequestBuilder", new String[0]), this.f14623c);
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> a6 = mVar.a(set);
        return TypeSpec.a("GlideRequest").u("Contains all public methods from {@link $T}, all options from\n", this.f14625e).u("{@link $T} and all generated options from\n", this.f14624d).u("{@link $T} in annotated methods in\n", GlideOption.class).u("{@link $T} annotated classes.\n", GlideExtension.class).u(com.snail.antifake.deviceid.e.f37542d, new Object[0]).u("<p>Generated code, do not modify.\n", new Object[0]).u(com.snail.antifake.deviceid.e.f37542d, new Object[0]).u("@see $T\n", this.f14625e).u("@see $T\n", this.f14624d).q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "unused").d("value", "$S", "deprecation").f()).x(Modifier.PUBLIC).A(this.f14623c).C(t6).z(Cloneable.class).w(f()).v(g()).w(i(a6, typeSpec)).w(k()).w(a6).B();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.a d(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        HashSet hashSet = new HashSet();
        if (iVar.f16069c.contains(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).f())) {
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar : iVar.f16069c) {
                if (aVar.f16005a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(SuppressWarnings.class))) {
                    hashSet.addAll(com.bumptech.glide.repackaged.com.google.common.collect.j.e(aVar.f16006b.get("value")).m(new f()).j());
                }
            }
        }
        if (iVar.f16069c.contains(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SafeVarargs.class).f())) {
            hashSet.add("unchecked");
            hashSet.add("varargs");
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        a.b b6 = com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b6.d("value", "$S", (String) it.next());
        }
        return b6.f();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> f() {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(Class.class), this.f14623c);
        return ImmutableList.of(com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(t5, "transcodeClass", new Modifier[0]).e(this.f14622b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14625e), com.bumptech.glide.repackaged.com.squareup.javapoet.o.w(Object.class)), "other", new Modifier[0]).e(this.f14622b.J()).i()).y("super($N, $N)", "transcodeClass", "other").C(), com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "Glide", new String[0]), "glide", new Modifier[0]).e(this.f14622b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "RequestManager", new String[0]), "requestManager", new Modifier[0]).e(this.f14622b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(t5, "transcodeClass", new Modifier[0]).e(this.f14622b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.content", "Context", new String[0]), com.umeng.analytics.pro.d.X, new Modifier[0]).e(this.f14622b.J()).i()).y("super($N, $N ,$N, $N)", "glide", "requestManager", "transcodeClass", com.umeng.analytics.pro.d.X).C());
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i g() {
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("getDownloadOnlyRequest").n(Override.class).m(this.f14622b.d()).m(this.f14622b.J()).F(com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(this.f14626f, com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(File.class))).u(Modifier.PROTECTED).y("return new $T<>($T.class, $N).apply($N)", this.f14626f, File.class, "this", "DOWNLOAD_ONLY_OPTIONS").C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> i(List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> list, TypeSpec typeSpec) {
        return typeSpec == null ? Collections.EMPTY_LIST : com.bumptech.glide.repackaged.com.google.common.collect.j.e(typeSpec.f15986n).d(new b(list)).m(new a()).g();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> k() {
        return w.i(this.f14622b.l(this.f14625e, this.f14621a.getTypeUtils().erasure(this.f14625e.asType())), new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> list, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return (f14620i.contains(iVar.f16067a) || !iVar.c(Modifier.PUBLIC) || iVar.c(Modifier.STATIC) || !iVar.f16072f.toString().equals(this.f14627g.toString()) || l(list, iVar)) ? false : true;
    }

    j(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14621a = processingEnvironment;
        this.f14622b = iVar;
        this.f14625e = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.RequestBuilder");
        this.f14624d = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i h(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        i.b p5 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(iVar.f16067a).s(this.f14622b.p(this.f14627g, iVar)).u(Modifier.PUBLIC).H(iVar.f16074h).o(com.bumptech.glide.repackaged.com.google.common.collect.j.e(iVar.f16069c).d(new e()).g()).A(iVar.f16071e).x(iVar.f16073g).F(this.f14628h).q("return ($T) super", this.f14628h).p(com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b(".$N(", iVar.f16067a).b(com.bumptech.glide.repackaged.com.google.common.collect.j.e(iVar.f16073g).m(new d()).f(com.bumptech.glide.repackaged.com.google.common.base.b.g(", ")), new Object[0]).b(");\n", new Object[0]).j());
        com.bumptech.glide.repackaged.com.squareup.javapoet.a d6 = d(iVar);
        if (d6 != null) {
            p5.l(d6);
        }
        return p5.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i j(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(this.f14626f, com.bumptech.glide.repackaged.com.squareup.javapoet.l.l((TypeMirror) executableElement.getReturnType().getTypeArguments().get(0)));
        i.b F = this.f14622b.L(executableElement).F(t5);
        F.p(com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("return ($T) super.$N(", t5, executableElement.getSimpleName()).b(com.bumptech.glide.repackaged.com.google.common.collect.j.e(F.C().f16073g).m(new h()).f(com.bumptech.glide.repackaged.com.google.common.base.b.g(", ")), new Object[0]).b(");\n", new Object[0]).j());
        Iterator it = executableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            F = F.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e((AnnotationMirror) it.next()));
        }
        if (executableElement.isVarArgs()) {
            F = F.u(Modifier.FINAL).n(SafeVarargs.class).l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "varargs").f());
        }
        return F.C();
    }

    private boolean l(List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> list, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(list).a(new c(iVar));
    }
}
