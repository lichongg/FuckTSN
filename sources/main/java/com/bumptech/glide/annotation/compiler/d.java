package com.bumptech.glide.annotation.compiler;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d extends AbstractProcessor {

    /* renamed from: a, reason: collision with root package name */
    private i f14582a;

    /* renamed from: b, reason: collision with root package name */
    private h f14583b;

    /* renamed from: c, reason: collision with root package name */
    private b f14584c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14585d;

    /* renamed from: e, reason: collision with root package name */
    private c f14586e;

    public synchronized void c(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        i iVar = new i(processingEnvironment);
        this.f14582a = iVar;
        g gVar = new g(iVar);
        this.f14583b = new h(this.f14582a, gVar);
        this.f14584c = new b(processingEnvironment, this.f14582a);
        this.f14586e = new c(processingEnvironment, this.f14582a, gVar);
    }

    public Set<String> a() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f14583b.a());
        hashSet.addAll(this.f14586e.a());
        return hashSet;
    }

    public boolean d(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        this.f14582a.M();
        boolean b6 = this.f14583b.b(roundEnvironment);
        boolean b7 = this.f14586e.b(roundEnvironment);
        this.f14584c.d(set, roundEnvironment);
        if (b7 || b6) {
            if (this.f14585d) {
                throw new IllegalStateException("Cannot process annotations after writing AppGlideModule");
            }
            return false;
        }
        if (!this.f14585d) {
            this.f14585d = this.f14584c.c();
        }
        return false;
    }

    public SourceVersion b() {
        return SourceVersion.latestSupported();
    }
}
