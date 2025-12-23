package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final i f14579a;

    /* renamed from: b, reason: collision with root package name */
    private final g f14580b;

    /* renamed from: c, reason: collision with root package name */
    private final e f14581c;

    Set<String> a() {
        return Collections.singleton(GlideExtension.class.getName());
    }

    boolean b(RoundEnvironment roundEnvironment) {
        List<TypeElement> u5 = this.f14579a.u(GlideExtension.class, roundEnvironment);
        this.f14579a.f("Processing types : " + u5);
        for (TypeElement typeElement : u5) {
            this.f14581c.k(typeElement);
            this.f14579a.f("Processing elements: " + typeElement.getEnclosedElements());
        }
        if (u5.isEmpty()) {
            return false;
        }
        this.f14579a.P(this.f14580b.a(u5));
        return true;
    }

    c(ProcessingEnvironment processingEnvironment, i iVar, g gVar) {
        this.f14579a = iVar;
        this.f14580b = gVar;
        this.f14581c = new e(processingEnvironment, iVar);
    }
}
