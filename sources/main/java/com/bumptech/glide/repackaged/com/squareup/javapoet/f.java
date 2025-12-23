package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final l f16035a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16036b;

    /* renamed from: c, reason: collision with root package name */
    public final d f16037c;

    /* renamed from: d, reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16038d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<Modifier> f16039e;

    /* renamed from: f, reason: collision with root package name */
    public final d f16040f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final l f16041a;

        /* renamed from: b, reason: collision with root package name */
        private final String f16042b;

        /* renamed from: c, reason: collision with root package name */
        private final d.b f16043c;

        /* renamed from: d, reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16044d;

        /* renamed from: e, reason: collision with root package name */
        private final List<Modifier> f16045e;

        /* renamed from: f, reason: collision with root package name */
        private d f16046f;

        /* synthetic */ b(l lVar, String str, a aVar) {
            this(lVar, str);
        }

        private b(l lVar, String str) {
            this.f16043c = d.a();
            this.f16044d = new ArrayList();
            this.f16045e = new ArrayList();
            this.f16046f = null;
            this.f16041a = lVar;
            this.f16042b = str;
        }

        public b g(Modifier... modifierArr) {
            Collections.addAll(this.f16045e, modifierArr);
            return this;
        }

        public f h() {
            return new f(this, null);
        }
    }

    /* synthetic */ f(b bVar, a aVar) {
        this(bVar);
    }

    public static b a(l lVar, String str, Modifier... modifierArr) {
        n.c(lVar, "type == null", new Object[0]);
        n.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(lVar, str, null).g(modifierArr);
    }

    private f(b bVar) {
        this.f16035a = (l) n.c(bVar.f16041a, "type == null", new Object[0]);
        this.f16036b = (String) n.c(bVar.f16042b, "name == null", new Object[0]);
        this.f16037c = bVar.f16043c.j();
        this.f16038d = n.f(bVar.f16044d);
        this.f16039e = n.i(bVar.f16045e);
        this.f16040f = bVar.f16046f == null ? d.a().j() : bVar.f16046f;
    }

    void b(e eVar, Set<Modifier> set) throws IOException {
        eVar.h(this.f16037c);
        eVar.e(this.f16038d, false);
        eVar.k(this.f16039e, set);
        eVar.c("$T $L", this.f16035a, this.f16036b);
        if (!this.f16040f.b()) {
            eVar.b(" = ");
            eVar.a(this.f16040f);
        }
        eVar.b(";\n");
    }

    public boolean c(Modifier modifier) {
        return this.f16039e.contains(modifier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            b(new e(stringWriter), Collections.EMPTY_SET);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
