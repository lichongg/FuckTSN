package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.Excludes;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final ProcessingEnvironment f14565a;

    /* renamed from: b, reason: collision with root package name */
    private final i f14566b;

    private boolean a(com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar) {
        for (ExecutableElement executableElement : this.f14565a.getElementUtils().getTypeElement(cVar.F()).getEnclosedElements()) {
            if (executableElement.getKind() == ElementKind.CONSTRUCTOR) {
                List parameters = executableElement.getParameters();
                if (parameters.isEmpty()) {
                    return false;
                }
                if (parameters.size() > 1) {
                    throw new IllegalStateException("Constructor for " + cVar + " accepts too many parameters, it should accept no parameters, or a single Context");
                }
                TypeMirror asType = ((VariableElement) parameters.get(0)).asType();
                if (this.f14565a.getTypeUtils().isSameType(asType, this.f14565a.getElementUtils().getTypeElement("android.content.Context").asType())) {
                    return true;
                }
                throw new IllegalStateException("Unrecognized type: " + asType);
            }
        }
        return false;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i d(Collection<String> collection) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t5 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(Class.class), com.bumptech.glide.repackaged.com.squareup.javapoet.o.w(Object.class));
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t6 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(Set.class), t5);
        com.bumptech.glide.repackaged.com.squareup.javapoet.k t7 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.t(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(HashSet.class), t5);
        i.b F = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("getExcludedModuleClasses").u(Modifier.PUBLIC).n(Override.class).m(this.f14566b.J()).F(t6);
        if (collection.isEmpty()) {
            F.y("return $T.emptySet()", Collections.class);
        } else {
            F.y("$T excludedClasses = new $T()", t6, t7);
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                F.y("excludedClasses.add($L.class)", it.next());
            }
            F.y("return excludedClasses", new Object[0]);
        }
        return F.C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i e(Collection<String> collection, Collection<String> collection2) {
        i.b v5 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("registerComponents").u(Modifier.PUBLIC).n(Override.class).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.content", "Context", new String[0]), com.umeng.analytics.pro.d.X, new Modifier[0]).e(this.f14566b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "Glide", new String[0]), "glide", new Modifier[0]).e(this.f14566b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "Registry", new String[0]), "registry", new Modifier[0]).e(this.f14566b.J()).i());
        for (String str : collection) {
            if (!collection2.contains(str)) {
                v5.y("new $T().registerComponents(context, glide, registry)", com.bumptech.glide.repackaged.com.squareup.javapoet.c.t(str));
            }
        }
        v5.y("appGlideModule.registerComponents(context, glide, registry)", new Object[0]);
        return v5.C();
    }

    private List<String> f(TypeElement typeElement) {
        ArrayList arrayList = new ArrayList(this.f14566b.j(typeElement, Excludes.class));
        Collections.sort(arrayList);
        return arrayList;
    }

    a(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14565a = processingEnvironment;
        this.f14566b = iVar;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i c(com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar, Collection<String> collection, Collection<String> collection2) {
        i.b v5 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().u(Modifier.PUBLIC).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.content", "Context", new String[0]), com.umeng.analytics.pro.d.X, new Modifier[0]).i());
        if (a(cVar)) {
            v5.y("appGlideModule = new $T(context)", cVar);
        } else {
            v5.y("appGlideModule = new $T()", cVar);
        }
        com.bumptech.glide.repackaged.com.squareup.javapoet.c x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.util", "Log", new String[0]);
        v5.B("if ($T.isLoggable($S, $T.DEBUG))", x5, "Glide", x5);
        v5.y("$T.d($S, $S)", x5, "Glide", "Discovered AppGlideModule from annotation: " + cVar);
        for (String str : collection) {
            if (collection2.contains(str)) {
                v5.y("$T.d($S, $S)", x5, "Glide", "AppGlideModule excludes LibraryGlideModule from annotation: " + str);
            } else {
                v5.y("$T.d($S, $S)", x5, "Glide", "Discovered LibraryGlideModule from annotation: " + str);
            }
        }
        v5.D();
        return v5.C();
    }

    TypeSpec b(TypeElement typeElement, Set<String> set) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c y5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(typeElement);
        List<String> f6 = f(typeElement);
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        com.bumptech.glide.repackaged.com.squareup.javapoet.i c6 = c(y5, arrayList, f6);
        TypeSpec.b v5 = TypeSpec.a("GeneratedAppGlideModuleImpl").x(Modifier.FINAL).q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "deprecation").f()).C(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "GeneratedAppGlideModule", new String[0])).s(y5, "appGlideModule", Modifier.PRIVATE, Modifier.FINAL).v(c6).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("applyOptions").u(Modifier.PUBLIC).n(Override.class).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.content", "Context", new String[0]), com.umeng.analytics.pro.d.X, new Modifier[0]).e(this.f14566b.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "GlideBuilder", new String[0]), "builder", new Modifier[0]).e(this.f14566b.J()).i()).y("appGlideModule.applyOptions(context, builder)", typeElement).C()).v(e(arrayList, f6)).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("isManifestParsingEnabled").u(Modifier.PUBLIC).n(Override.class).G(Boolean.TYPE).y("return appGlideModule.isManifestParsingEnabled()", typeElement).C()).v(d(f6));
        com.bumptech.glide.repackaged.com.squareup.javapoet.c x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide", "GeneratedRequestManagerFactory", new String[0]);
        v5.v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("getRequestManagerFactory").n(Override.class).m(this.f14566b.J()).F(x5).y("return new $T()", x5).C());
        return v5.B();
    }
}
