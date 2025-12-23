package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: g, reason: collision with root package name */
    private static final Appendable f16047g = new a();

    /* renamed from: a, reason: collision with root package name */
    public final d f16048a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16049b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeSpec f16050c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16051d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<String> f16052e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16053f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Appendable {
        @Override // java.lang.Appendable
        public Appendable append(char c6) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return this;
        }

        a() {
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i6, int i7) {
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f16054a;

        /* renamed from: b, reason: collision with root package name */
        private final TypeSpec f16055b;

        /* renamed from: c, reason: collision with root package name */
        private final d.b f16056c;

        /* renamed from: d, reason: collision with root package name */
        private final Set<String> f16057d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f16058e;

        /* renamed from: f, reason: collision with root package name */
        private String f16059f;

        /* synthetic */ b(String str, TypeSpec typeSpec, a aVar) {
            this(str, typeSpec);
        }

        private b(String str, TypeSpec typeSpec) {
            this.f16056c = d.a();
            this.f16057d = new TreeSet();
            this.f16059f = "  ";
            this.f16054a = str;
            this.f16055b = typeSpec;
        }

        public g g() {
            return new g(this, null);
        }

        public b h(boolean z5) {
            this.f16058e = z5;
            return this;
        }
    }

    /* synthetic */ g(b bVar, a aVar) {
        this(bVar);
    }

    public static b a(String str, TypeSpec typeSpec) {
        n.c(str, "packageName == null", new Object[0]);
        n.c(typeSpec, "typeSpec == null", new Object[0]);
        return new b(str, typeSpec, null);
    }

    private g(b bVar) {
        this.f16048a = bVar.f16056c.j();
        this.f16049b = bVar.f16054a;
        this.f16050c = bVar.f16055b;
        this.f16051d = bVar.f16058e;
        this.f16052e = n.i(bVar.f16057d);
        this.f16053f = bVar.f16059f;
    }

    private void b(e eVar) throws IOException {
        eVar.w(this.f16049b);
        if (!this.f16048a.b()) {
            eVar.f(this.f16048a);
        }
        if (!this.f16049b.isEmpty()) {
            eVar.c("package $L;\n", this.f16049b);
            eVar.b(com.snail.antifake.deviceid.e.f37542d);
        }
        if (!this.f16052e.isEmpty()) {
            Iterator<String> it = this.f16052e.iterator();
            while (it.hasNext()) {
                eVar.c("import static $L;\n", (String) it.next());
            }
            eVar.b(com.snail.antifake.deviceid.e.f37542d);
        }
        Iterator it2 = new TreeSet(eVar.q().values()).iterator();
        int i6 = 0;
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            if (!this.f16051d || !cVar.E().equals("java.lang")) {
                eVar.c("import $L;\n", cVar);
                i6++;
            }
        }
        if (i6 > 0) {
            eVar.b(com.snail.antifake.deviceid.e.f37542d);
        }
        this.f16050c.b(eVar, null, Collections.EMPTY_SET);
        eVar.u();
    }

    public void c(Appendable appendable) throws IOException {
        e eVar = new e(f16047g, this.f16053f, this.f16052e);
        b(eVar);
        b(new e(appendable, this.f16053f, eVar.A(), this.f16052e));
    }

    public void d(Filer filer) throws IOException {
        String str;
        if (this.f16049b.isEmpty()) {
            str = this.f16050c.f15974b;
        } else {
            str = this.f16049b + "." + this.f16050c.f15974b;
        }
        List<Element> list = this.f16050c.f15988p;
        JavaFileObject createSourceFile = filer.createSourceFile(str, (Element[]) list.toArray(new Element[list.size()]));
        try {
            Writer openWriter = createSourceFile.openWriter();
            try {
                c(openWriter);
                if (openWriter != null) {
                    openWriter.close();
                }
            } finally {
            }
        } catch (Exception e6) {
            try {
                createSourceFile.delete();
            } catch (Exception unused) {
            }
            throw e6;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            c(sb);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
