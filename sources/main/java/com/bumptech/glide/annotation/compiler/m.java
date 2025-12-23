package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.l f14661a;

    /* renamed from: b, reason: collision with root package name */
    private i f14662b;

    List<ExecutableElement> c(Set<String> set) {
        return this.f14662b.h(set, GlideOption.class);
    }

    m(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, i iVar) {
        this.f14661a = lVar;
        this.f14662b = iVar;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i b(ExecutableElement executableElement) {
        String str;
        if (executableElement.getReturnType().getKind() != TypeKind.VOID) {
            int x5 = this.f14662b.x(executableElement);
            String obj = executableElement.getSimpleName().toString();
            i.b l6 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(obj).u(Modifier.PUBLIC).s(this.f14662b.r(executableElement)).H(executableElement.isVarArgs()).F(this.f14661a).l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "unchecked").f());
            List<? extends VariableElement> subList = executableElement.getParameters().subList(1, executableElement.getParameters().size());
            List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> z5 = this.f14662b.z(subList);
            l6.x(z5);
            if (x5 == 1) {
                l6.s(this.f14662b.q(this.f14661a, obj, subList)).n(Override.class);
                ArrayList arrayList = new ArrayList();
                arrayList.add(executableElement.getSimpleName().toString());
                StringBuilder sb = new StringBuilder();
                if (!z5.isEmpty()) {
                    for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : z5) {
                        sb.append("$L, ");
                        arrayList.add(jVar.f16089a);
                    }
                    sb = new StringBuilder(sb.substring(0, sb.length() - 2));
                }
                str = com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("super.$N(" + ((Object) sb) + ")", arrayList.toArray(new Object[0])).j().toString();
            } else {
                str = "this";
            }
            ArrayList arrayList2 = new ArrayList();
            StringBuilder sb2 = new StringBuilder("return ($T) $T.$L($L, ");
            arrayList2.add(this.f14661a);
            arrayList2.add(com.bumptech.glide.repackaged.com.squareup.javapoet.l.l(executableElement.getEnclosingElement().asType()));
            arrayList2.add(executableElement.getSimpleName().toString());
            arrayList2.add(str);
            if (!z5.isEmpty()) {
                for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar2 : z5) {
                    sb2.append("$L, ");
                    arrayList2.add(jVar2.f16089a);
                }
            }
            l6.y(sb2.substring(0, sb2.length() - 2) + ")", arrayList2.toArray(new Object[0]));
            l6.m(this.f14662b.d()).m(this.f14662b.J());
            return l6.C();
        }
        throw new IllegalArgumentException("The " + executableElement.getSimpleName() + " method annotated with @GlideOption in the " + executableElement.getEnclosingElement().getSimpleName() + " @GlideExtension is using a legacy format that is no longer supported. Please change your method definition so that your @GlideModule annotated methods return BaseRequestOptions<?> objects instead of null.");
    }

    List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> a(Set<String> set) {
        List<ExecutableElement> c6 = c(set);
        ArrayList arrayList = new ArrayList(c6.size());
        Iterator<ExecutableElement> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(b(it.next()));
        }
        return arrayList;
    }
}
