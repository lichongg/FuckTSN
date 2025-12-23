package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private final TypeElement f14680a;

    /* renamed from: b, reason: collision with root package name */
    private i f14681b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.squareup.javapoet.l f14682a;

        a(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar) {
            this.f14682a = lVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return o.this.d(this.f14682a, executableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.e<ExecutableElement> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f14684a;

        b(Set set) {
            this.f14684a = set;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(ExecutableElement executableElement) {
            return !this.f14684a.contains(executableElement.getSimpleName().toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f16089a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i d(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, ExecutableElement executableElement) {
        i.b F = this.f14681b.L(executableElement).F(lVar);
        F.p(com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("return ($T) super.$N(", lVar, executableElement.getSimpleName()).b(com.bumptech.glide.repackaged.com.google.common.collect.j.e(F.C().f16073g).m(new c()).f(com.bumptech.glide.repackaged.com.google.common.base.b.g(", ")), new Object[0]).b(");\n", new Object[0]).j());
        if (executableElement.getSimpleName().toString().contains("transform") && executableElement.isVarArgs()) {
            F.u(Modifier.FINAL).n(SafeVarargs.class).l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "varargs").f());
        }
        Iterator it = executableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            F.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e((AnnotationMirror) it.next()));
        }
        return F.C();
    }

    List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> b(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar) {
        return c(lVar, Collections.EMPTY_SET);
    }

    List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> c(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, Set<String> set) {
        i iVar = this.f14681b;
        TypeElement typeElement = this.f14680a;
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(iVar.k(typeElement, typeElement)).d(new b(set)).m(new a(lVar)).g();
    }

    o(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14681b = iVar;
        this.f14680a = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.BaseRequestOptions");
    }
}
