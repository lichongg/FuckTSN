package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.repackaged.com.google.common.collect.w;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final ProcessingEnvironment f14590a;

    /* renamed from: b, reason: collision with root package name */
    private final i f14591b;

    /* renamed from: c, reason: collision with root package name */
    private final TypeElement f14592c;

    /* renamed from: d, reason: collision with root package name */
    private final TypeElement f14593d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14594a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TypeSpec f14595b;

        a(String str, TypeSpec typeSpec) {
            this.f14594a = str;
            this.f14595b = typeSpec;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return f.this.h(executableElement) ? f.this.j(this.f14594a, this.f14595b, executableElement) : f.this.i(executableElement);
        }
    }

    private i.b d(i.b bVar, ExecutableElement executableElement) {
        String obj = this.f14590a.getElementUtils().getTypeElement(this.f14591b.N().F()).toString();
        for (AnnotationMirror annotationMirror : executableElement.getAnnotationMirrors()) {
            bVar.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror));
            if (annotationMirror.getAnnotationType().toString().equals(obj)) {
                bVar.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.annotation", "SuppressLint", new String[0])).d("value", "$S", "VisibleForTests").f());
            }
        }
        return bVar;
    }

    private List<ExecutableElement> e() {
        return this.f14591b.m(this.f14592c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(ExecutableElement executableElement) {
        return this.f14591b.G(executableElement, this.f14593d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i i(ExecutableElement executableElement) {
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> A = this.f14591b.A(executableElement);
        TypeElement asElement = this.f14590a.getTypeUtils().asElement(executableElement.getReturnType());
        i.b x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f14591b.r(executableElement)).x(A);
        d(x5, executableElement);
        boolean z5 = asElement != null;
        if (z5) {
            x5.F(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(asElement));
        }
        StringBuilder sb = new StringBuilder(z5 ? "return " : "");
        sb.append("$T.$N(");
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14592c));
        arrayList.add(executableElement.getSimpleName());
        if (!A.isEmpty()) {
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : A) {
                sb.append("$L, ");
                arrayList.add(jVar.f16089a);
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")");
        x5.y(sb.toString(), arrayList.toArray(new Object[0]));
        return x5.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i j(String str, TypeSpec typeSpec, ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, typeSpec.f15974b, new String[0]);
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> A = this.f14591b.A(executableElement);
        com.bumptech.glide.repackaged.com.google.common.base.d.f(A.size() == 1, "Expected size of 1, but got %s", executableElement);
        return d(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f14591b.r(executableElement)).x(A).F(x5).y("return ($T) $T.$N($L)", x5, this.f14592c, executableElement.getSimpleName().toString(), A.iterator().next().f16089a), executableElement).C();
    }

    f(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14590a = processingEnvironment;
        this.f14591b = iVar;
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.f14593d = elementUtils.getTypeElement("com.bumptech.glide.RequestManager");
        this.f14592c = elementUtils.getTypeElement("com.bumptech.glide.Glide");
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> g(String str, TypeSpec typeSpec) {
        return w.i(e(), new a(str, typeSpec));
    }

    TypeSpec f(String str, String str2, TypeSpec typeSpec) {
        return TypeSpec.a(str2).u("The entry point for interacting with Glide for Applications\n\n<p>Includes all generated APIs from all\n{@link $T}s in source and dependent libraries.\n\n<p>This class is generated and should not be modified\n@see $T\n", GlideExtension.class, this.f14592c).x(Modifier.PUBLIC, Modifier.FINAL).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().u(Modifier.PRIVATE).C()).w(g(str, typeSpec)).B();
    }
}
