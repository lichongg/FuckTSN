package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class b {

    /* renamed from: j, reason: collision with root package name */
    private static final String f14567j = d.class.getPackage().getName();

    /* renamed from: a, reason: collision with root package name */
    private final ProcessingEnvironment f14568a;

    /* renamed from: b, reason: collision with root package name */
    private final i f14569b;

    /* renamed from: c, reason: collision with root package name */
    private final List<TypeElement> f14570c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final n f14571d;

    /* renamed from: e, reason: collision with root package name */
    private final l f14572e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.annotation.compiler.a f14573f;

    /* renamed from: g, reason: collision with root package name */
    private final j f14574g;

    /* renamed from: h, reason: collision with root package name */
    private final k f14575h;

    /* renamed from: i, reason: collision with root package name */
    private final f f14576i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.annotation.compiler.b$b, reason: collision with other inner class name */
    private static final class C0147b {

        /* renamed from: a, reason: collision with root package name */
        private final Set<String> f14577a;

        /* renamed from: b, reason: collision with root package name */
        private final Set<String> f14578b;

        /* synthetic */ C0147b(Set set, Set set2, a aVar) {
            this(set, set2);
        }

        private C0147b(Set<String> set, Set<String> set2) {
            this.f14577a = set;
            this.f14578b = set2;
        }
    }

    private String a(TypeElement typeElement) {
        return ((GlideModule) typeElement.getAnnotation(GlideModule.class)).glideName();
    }

    private C0147b b(PackageElement packageElement) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = packageElement.getEnclosedElements().iterator();
        while (it.hasNext()) {
            Index index = (Index) ((Element) it.next()).getAnnotation(Index.class);
            if (index != null) {
                Collections.addAll(hashSet, index.modules());
                Collections.addAll(hashSet2, index.extensions());
            }
        }
        this.f14569b.f("Found GlideModules: " + hashSet);
        return new C0147b(hashSet, hashSet2, null);
    }

    private void e(TypeSpec typeSpec) {
        this.f14569b.O("com.bumptech.glide", typeSpec);
    }

    private void f(String str, TypeSpec typeSpec) {
        this.f14569b.O(str, typeSpec);
    }

    private void g(String str, TypeSpec typeSpec) {
        this.f14569b.O(str, typeSpec);
    }

    private void h(String str, TypeSpec typeSpec) {
        this.f14569b.O(str, typeSpec);
    }

    private void i(TypeSpec typeSpec) {
        this.f14569b.O("com.bumptech.glide", typeSpec);
    }

    private void j(String str, TypeSpec typeSpec) {
        this.f14569b.O(str, typeSpec);
    }

    boolean c() {
        if (this.f14570c.isEmpty()) {
            return false;
        }
        TypeElement typeElement = this.f14570c.get(0);
        this.f14569b.f("Processing app module: " + typeElement);
        C0147b b6 = b(this.f14568a.getElementUtils().getPackageElement(f14567j));
        String obj = typeElement.getEnclosingElement().toString();
        TypeSpec d6 = this.f14571d.d(obj, b6.f14578b);
        j(obj, d6);
        TypeSpec e6 = this.f14574g.e(obj, b6.f14578b, d6);
        g(obj, e6);
        TypeSpec d7 = this.f14572e.d(obj, d6, e6, b6.f14578b);
        h(obj, d7);
        i(this.f14575h.a(obj, d7));
        f(obj, this.f14576i.f(obj, a(typeElement), d7));
        e(this.f14573f.b(typeElement, b6.f14577a));
        this.f14569b.C("Wrote GeneratedAppGlideModule with: " + b6.f14577a);
        return true;
    }

    void d(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement typeElement : this.f14569b.u(GlideModule.class, roundEnvironment)) {
            if (this.f14569b.D(typeElement)) {
                this.f14570c.add(typeElement);
            }
        }
        this.f14569b.f("got app modules: " + this.f14570c);
        if (this.f14570c.size() <= 1) {
            return;
        }
        throw new IllegalStateException("You cannot have more than one AppGlideModule, found: " + this.f14570c);
    }

    b(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14568a = processingEnvironment;
        this.f14569b = iVar;
        this.f14573f = new com.bumptech.glide.annotation.compiler.a(processingEnvironment, iVar);
        this.f14571d = new n(processingEnvironment, iVar);
        this.f14572e = new l(processingEnvironment, iVar);
        this.f14575h = new k(processingEnvironment, iVar);
        this.f14576i = new f(processingEnvironment, iVar);
        this.f14574g = new j(processingEnvironment, iVar);
    }
}
