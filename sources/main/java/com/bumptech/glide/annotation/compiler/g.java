package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.a;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final i f14597a;

    private TypeSpec b(List<TypeElement> list, Class<? extends Annotation> cls) {
        a.b b6 = com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(Index.class);
        String c6 = c(cls);
        Iterator<TypeElement> it = list.iterator();
        while (it.hasNext()) {
            b6.d(c6, "$S", com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(it.next()).toString());
        }
        StringBuilder sb = new StringBuilder("GlideIndexer_" + cls.getSimpleName() + "_");
        Iterator<TypeElement> it2 = list.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().getQualifiedName().toString().replace(".", "_"));
            sb.append("_");
        }
        String sb2 = new StringBuilder(sb.substring(0, sb.length() - 1)).toString();
        if (sb2.length() >= 242) {
            sb2 = "GlideIndexer_" + UUID.nameUUIDFromBytes(sb2.getBytes()).toString().replace("-", "_");
        }
        return TypeSpec.a(sb2).q(b6.f()).x(Modifier.PUBLIC).B();
    }

    private static String c(Class<? extends Annotation> cls) {
        if (cls == GlideModule.class) {
            return "modules";
        }
        if (cls == GlideExtension.class) {
            return "extensions";
        }
        throw new IllegalArgumentException("Unrecognized annotation: " + cls);
    }

    TypeSpec a(List<TypeElement> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TypeElement typeElement : list) {
            if (this.f14597a.E(typeElement)) {
                arrayList2.add(typeElement);
            } else {
                if (!this.f14597a.F(typeElement)) {
                    throw new IllegalArgumentException("Unrecognized type: " + typeElement);
                }
                arrayList.add(typeElement);
            }
        }
        if (arrayList.isEmpty() || arrayList2.isEmpty()) {
            return !arrayList.isEmpty() ? b(list, GlideModule.class) : b(list, GlideExtension.class);
        }
        throw new IllegalArgumentException("Given both modules and extensions, expected one or the other. Modules: " + arrayList + " Extensions: " + arrayList2);
    }

    g(i iVar) {
        this.f14597a = iVar;
    }
}
