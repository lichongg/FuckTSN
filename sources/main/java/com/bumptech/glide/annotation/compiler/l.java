package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.repackaged.com.google.common.collect.w;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class l {

    /* renamed from: j, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14646j = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.content", "Context", new String[0]);

    /* renamed from: a, reason: collision with root package name */
    private ProcessingEnvironment f14647a;

    /* renamed from: b, reason: collision with root package name */
    private final i f14648b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14649c;

    /* renamed from: d, reason: collision with root package name */
    private final TypeElement f14650d;

    /* renamed from: e, reason: collision with root package name */
    private final TypeElement f14651e;

    /* renamed from: f, reason: collision with root package name */
    private final TypeElement f14652f;

    /* renamed from: g, reason: collision with root package name */
    private final TypeElement f14653g;

    /* renamed from: h, reason: collision with root package name */
    private final TypeElement f14654h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f14655i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14656a;

        a(String str) {
            this.f14656a = str;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return l.this.n(this.f14656a, executableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return l.this.l(executableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements com.bumptech.glide.repackaged.com.google.common.base.e<ExecutableElement> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(ExecutableElement executableElement) {
            return !executableElement.getSimpleName().toString().equals(CommonNetImpl.AS);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        d() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return l.this.e(executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i n(String str, ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, "GlideRequests", new String[0]);
        i.b F = this.f14648b.L(executableElement).m(this.f14648b.J()).F(x5);
        return F.p(i.o(x5, F.C())).C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i f(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.t(this.f14648b.j(executableElement, GlideType.class).iterator().next());
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t6 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(this.f14655i, t5);
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC).F(t6).s(this.f14648b.r(executableElement)).m(this.f14648b.J()).m(this.f14648b.d()).y("$T requestBuilder = this.as($T.class)", t6, t5).y("$T.$N(requestBuilder)", executableElement.getEnclosingElement(), executableElement.getSimpleName()).y("return requestBuilder", new Object[0]).C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i g(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.t(this.f14648b.j(executableElement, GlideType.class).iterator().next());
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t6 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(this.f14655i, t5);
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC).F(t6).s(this.f14648b.r(executableElement)).m(this.f14648b.J()).m(this.f14648b.d()).y("return ($T) $T.$N(this.as($T.class))", t6, executableElement.getEnclosingElement(), executableElement.getSimpleName(), t5).C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i h(String str, TypeSpec typeSpec) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.m t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.m.t("ResourceType");
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(CommonNetImpl.AS).u(Modifier.PUBLIC).n(Override.class).m(this.f14648b.d()).m(this.f14648b.J()).z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.t("ResourceType")).F(com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, typeSpec.f15974b, new String[0]), t5)).w(com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(Class.class), t5).b(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(this.f14648b.J()).f()), "resourceClass", new Modifier[0]).y("return new $T<>(glide, this, resourceClass, context)", this.f14655i).C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> j(Set<String> set) {
        return w.i(this.f14648b.h(set, GlideType.class), new d());
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i k(String str, TypeSpec typeSpec) {
        if (typeSpec == null) {
            return null;
        }
        TypeElement typeElement = this.f14647a.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
        String str2 = str + "." + typeSpec.f15974b;
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("setRequestOptions").n(Override.class).u(Modifier.PROTECTED).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(typeElement), "toSet", new Modifier[0]).e(this.f14648b.J()).i()).B("if ($N instanceof $L)", "toSet", str2).y("super.$N($N)", "setRequestOptions", "toSet").E("else", new Object[0]).y("super.setRequestOptions(new $L().apply($N))", str2, "toSet").D().C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> m() {
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(this.f14648b.l(this.f14653g, this.f14647a.getTypeUtils().erasure(this.f14654h.asType()))).d(new c()).m(new b()).g();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> o(String str) {
        i iVar = this.f14648b;
        TypeElement typeElement = this.f14653g;
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(iVar.k(typeElement, typeElement)).m(new a(str)).g();
    }

    TypeSpec d(String str, TypeSpec typeSpec, TypeSpec typeSpec2, Set<String> set) {
        this.f14655i = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, typeSpec2.f15974b, new String[0]);
        return TypeSpec.a("GlideRequests").C(this.f14649c).u("Includes all additions from methods in {@link $T}s\nannotated with {@link $T}\n\n<p>Generated code, do not modify\n", GlideExtension.class, GlideType.class).q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "deprecation").f()).x(Modifier.PUBLIC).v(h(str, typeSpec2)).v(i()).w(j(set)).w(o(str)).w(m()).w(com.bumptech.glide.repackaged.com.google.common.collect.j.e(Collections.singletonList(k(str, typeSpec))).d(com.bumptech.glide.repackaged.com.google.common.base.f.c())).B();
    }

    l(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14647a = processingEnvironment;
        this.f14648b = iVar;
        Elements elementUtils = processingEnvironment.getElementUtils();
        TypeElement typeElement = elementUtils.getTypeElement("com.bumptech.glide.RequestManager");
        this.f14653g = typeElement;
        this.f14649c = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(typeElement);
        this.f14650d = elementUtils.getTypeElement("com.bumptech.glide.manager.Lifecycle");
        this.f14651e = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerTreeNode");
        this.f14654h = elementUtils.getTypeElement("com.bumptech.glide.RequestBuilder");
        this.f14652f = elementUtils.getTypeElement("com.bumptech.glide.Glide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i e(ExecutableElement executableElement) {
        if (executableElement.getReturnType().getKind() == TypeKind.VOID) {
            return f(executableElement);
        }
        return g(executableElement);
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i i() {
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().u(Modifier.PUBLIC).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14652f), "glide", new Modifier[0]).e(this.f14648b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14650d), "lifecycle", new Modifier[0]).e(this.f14648b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14651e), "treeNode", new Modifier[0]).e(this.f14648b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(f14646j, com.umeng.analytics.pro.d.X, new Modifier[0]).e(this.f14648b.J()).i()).y("super(glide, lifecycle, treeNode, context)", new Object[0]).C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i l(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(this.f14655i, com.bumptech.glide.repackaged.com.squareup.javapoet.l.l((TypeMirror) executableElement.getReturnType().getTypeArguments().get(0)));
        i.b F = this.f14648b.L(executableElement).F(t5);
        F.p(i.o(t5, F.C()));
        Iterator it = executableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            F.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e((AnnotationMirror) it.next()));
        }
        return F.C();
    }
}
