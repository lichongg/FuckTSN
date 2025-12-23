package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final i f14598a;

    /* renamed from: b, reason: collision with root package name */
    private final g f14599b;

    Set<String> a() {
        return Collections.singleton(GlideModule.class.getName());
    }

    boolean b(RoundEnvironment roundEnvironment) {
        ArrayList arrayList = new ArrayList();
        for (TypeElement typeElement : this.f14598a.u(GlideModule.class, roundEnvironment)) {
            if (!this.f14598a.D(typeElement)) {
                if (!this.f14598a.F(typeElement)) {
                    throw new IllegalStateException("@GlideModule can only be applied to LibraryGlideModule and AppGlideModule implementations, not: " + typeElement);
                }
                arrayList.add(typeElement);
            }
        }
        this.f14598a.f("got child modules: " + arrayList);
        if (arrayList.isEmpty()) {
            return false;
        }
        this.f14598a.P(this.f14599b.a(arrayList));
        this.f14598a.f("Wrote an Indexer this round, skipping the app module to ensure all indexers are found");
        return true;
    }

    h(i iVar, g gVar) {
        this.f14598a = iVar;
        this.f14599b = gVar;
    }
}
