package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f16089a;

    /* renamed from: b, reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16090b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Modifier> f16091c;

    /* renamed from: d, reason: collision with root package name */
    public final l f16092d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final l f16093a;

        /* renamed from: b, reason: collision with root package name */
        private final String f16094b;

        /* renamed from: c, reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16095c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Modifier> f16096d;

        /* synthetic */ b(l lVar, String str, a aVar) {
            this(lVar, str);
        }

        public b f(Iterable<com.bumptech.glide.repackaged.com.squareup.javapoet.a> iterable) {
            n.b(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<com.bumptech.glide.repackaged.com.squareup.javapoet.a> it = iterable.iterator();
            while (it.hasNext()) {
                this.f16095c.add(it.next());
            }
            return this;
        }

        public b g(Iterable<Modifier> iterable) {
            n.c(iterable, "modifiers == null", new Object[0]);
            Iterator<Modifier> it = iterable.iterator();
            while (it.hasNext()) {
                this.f16096d.add(it.next());
            }
            return this;
        }

        private b(l lVar, String str) {
            this.f16095c = new ArrayList();
            this.f16096d = new ArrayList();
            this.f16093a = lVar;
            this.f16094b = str;
        }

        public b e(c cVar) {
            this.f16095c.add(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b h(Modifier... modifierArr) {
            Collections.addAll(this.f16096d, modifierArr);
            return this;
        }

        public j i() {
            return new j(this, null);
        }
    }

    /* synthetic */ j(b bVar, a aVar) {
        this(bVar);
    }

    public static b a(l lVar, String str, Modifier... modifierArr) {
        n.c(lVar, "type == null", new Object[0]);
        n.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(lVar, str, null).h(modifierArr);
    }

    private j(b bVar) {
        this.f16089a = (String) n.c(bVar.f16094b, "name == null", new Object[0]);
        this.f16090b = n.f(bVar.f16095c);
        this.f16091c = n.i(bVar.f16096d);
        this.f16092d = (l) n.c(bVar.f16093a, "type == null", new Object[0]);
    }

    void b(e eVar, boolean z5) throws IOException {
        eVar.e(this.f16090b, true);
        eVar.j(this.f16091c);
        if (z5) {
            eVar.c("$T... $L", l.c(this.f16092d), this.f16089a);
        } else {
            eVar.c("$T $L", this.f16092d, this.f16089a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            b(new e(stringWriter), false);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
