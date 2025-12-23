package com.bumptech.glide.annotation.compiler;

import com.acse.ottn.l3;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.bumptech.glide.repackaged.com.google.common.collect.u;
import com.bumptech.glide.repackaged.com.google.common.collect.w;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    private int f14663a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14664b = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("com.bumptech.glide.request", "RequestOptions", new String[0]);

    /* renamed from: c, reason: collision with root package name */
    private final TypeElement f14665c;

    /* renamed from: d, reason: collision with root package name */
    private final i f14666d;

    /* renamed from: e, reason: collision with root package name */
    private final o f14667e;

    /* renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f14668f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.i, e> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return new e(iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, e> {
        b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e apply(ExecutableElement executableElement) {
            return n.this.f(executableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements com.bumptech.glide.repackaged.com.google.common.base.e<ExecutableElement> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(ExecutableElement executableElement) {
            return !n.n(executableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements com.bumptech.glide.repackaged.com.google.common.base.a<e, f> {
        d() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f apply(e eVar) {
            return new f(eVar.f14673a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class e {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.squareup.javapoet.i f14673a;

        /* renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.squareup.javapoet.f f14674b;

        e(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            this(iVar, null);
        }

        e(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar, com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar) {
            this.f14673a = iVar;
            this.f14674b = fVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class f {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.repackaged.com.squareup.javapoet.l f14675a;

        /* renamed from: b, reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.l> f14676b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f14677c;

        /* renamed from: d, reason: collision with root package name */
        private final String f14678d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, com.bumptech.glide.repackaged.com.squareup.javapoet.l> {
            a() {
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.bumptech.glide.repackaged.com.squareup.javapoet.l apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
                return jVar.f16092d;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (this.f14678d.equals(fVar.f14678d) && this.f14675a.equals(fVar.f14675a) && this.f14676b.equals(fVar.f14676b) && this.f14677c == fVar.f14677c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return com.bumptech.glide.repackaged.com.google.common.base.c.b(this.f14678d, this.f14675a, this.f14676b, Boolean.valueOf(this.f14677c));
        }

        f(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            this.f14678d = iVar.f16067a;
            this.f14677c = iVar.f16070d.contains(Modifier.STATIC);
            this.f14675a = iVar.f16072f;
            this.f14676b = w.i(iVar.f16073g, new a());
        }
    }

    TypeSpec d(String str, Set<String> set) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c x5 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, "GlideOptions", new String[0]);
        this.f14668f = x5;
        m mVar = new m(x5, this.f14666d);
        ImmutableList g6 = com.bumptech.glide.repackaged.com.google.common.collect.j.e(mVar.a(set)).m(new a()).g();
        ImmutableList g7 = com.bumptech.glide.repackaged.com.google.common.collect.j.e(mVar.c(set)).d(new c()).m(new b()).g();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(g6);
        arrayList.addAll(g7);
        ImmutableSet copyOf = ImmutableSet.copyOf(u.f(arrayList, new d()));
        List<e> h6 = h();
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> b6 = this.f14667e.b(this.f14668f);
        ArrayList<e> arrayList2 = new ArrayList();
        for (e eVar : h6) {
            if (!copyOf.contains(new f(eVar.f14673a))) {
                arrayList2.add(eVar);
            }
        }
        for (com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar : b6) {
            if (!copyOf.contains(new f(iVar))) {
                arrayList2.add(new e(iVar));
            }
        }
        arrayList2.addAll(arrayList);
        TypeSpec.b C = TypeSpec.a("GlideOptions").q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "deprecation").f()).t(e(set)).x(Modifier.FINAL).x(Modifier.PUBLIC).z(Cloneable.class).C(this.f14664b);
        for (e eVar2 : arrayList2) {
            com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar2 = eVar2.f14673a;
            if (iVar2 != null) {
                C.v(iVar2);
            }
            com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar = eVar2.f14674b;
            if (fVar != null) {
                C.r(fVar);
            }
        }
        return C.B();
    }

    private StringBuilder c(boolean z5, i.b bVar, String str, List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> list) {
        StringBuilder sb = new StringBuilder(str);
        if (!list.isEmpty()) {
            bVar.x(list);
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : list) {
                sb.append(jVar.f16089a);
                if (z5 && k(jVar)) {
                    sb.append(".getApplicationContext()");
                }
                sb.append(", ");
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")");
        return sb;
    }

    private List<e> h() {
        i iVar = this.f14666d;
        TypeElement typeElement = this.f14665c;
        List<ExecutableElement> n6 = iVar.n(typeElement, typeElement);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : n6) {
            if (executableElement.getAnnotation(Deprecated.class) == null) {
                arrayList.add(g(executableElement));
            }
        }
        return arrayList;
    }

    private static String i(String str) {
        if ("bitmapTransform".equals(str)) {
            return "transform";
        }
        if ("decodeTypeOf".equals(str)) {
            return "decode";
        }
        if (str.endsWith("Transform")) {
            return str.substring(0, str.length() - 9);
        }
        if (str.endsWith("Of")) {
            return str.substring(0, str.length() - 2);
        }
        if ("noTransformation".equals(str)) {
            return "dontTransform";
        }
        if ("noAnimation".equals(str)) {
            return "dontAnimate";
        }
        if (str.equals("option")) {
            return l3.f4738h;
        }
        throw new IllegalArgumentException("Unrecognized static method name: " + str);
    }

    private static String j(ExecutableElement executableElement) {
        GlideOption glideOption = (GlideOption) executableElement.getAnnotation(GlideOption.class);
        return com.bumptech.glide.repackaged.com.google.common.base.g.a(glideOption != null ? glideOption.staticMethodName() : null);
    }

    private boolean k(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
        return jVar.f16092d.toString().equals("android.content.Context");
    }

    private static boolean l(ExecutableElement executableElement) {
        GlideOption glideOption = (GlideOption) executableElement.getAnnotation(GlideOption.class);
        return glideOption != null && glideOption.memoizeStaticMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(ExecutableElement executableElement) {
        GlideOption glideOption = (GlideOption) executableElement.getAnnotation(GlideOption.class);
        return glideOption != null && glideOption.skipStaticMethod();
    }

    n(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14666d = iVar;
        this.f14665c = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
        this.f14667e = new o(processingEnvironment, iVar);
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.d e(Set<String> set) {
        d.b b6 = com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("Automatically generated from {@link $T} annotated classes.\n", GlideExtension.class).b(com.snail.antifake.deviceid.e.f37542d, new Object[0]).b("@see $T\n", this.f14664b);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            b6.b("@see $T\n", com.bumptech.glide.repackaged.com.squareup.javapoet.c.t(it.next()));
        }
        return b6.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e f(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar;
        String j6 = j(executableElement);
        String obj = executableElement.getSimpleName().toString();
        if (com.bumptech.glide.repackaged.com.google.common.base.g.b(j6)) {
            if (obj.startsWith("dont")) {
                j6 = "no" + obj.replace("dont", "");
            } else {
                j6 = obj + "Of";
            }
        }
        boolean l6 = l(executableElement);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(j6);
        i.b F = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(j6).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f14666d.r(executableElement)).H(executableElement.isVarArgs()).F(this.f14668f);
        List parameters = executableElement.getParameters();
        if (!parameters.isEmpty()) {
            StringBuilder c6 = c(l6, F, "new $T().$L(", this.f14666d.z(parameters.subList(1, parameters.size())));
            if (l6) {
                StringBuilder sb = new StringBuilder();
                sb.append(j6);
                int i6 = this.f14663a;
                this.f14663a = i6 + 1;
                sb.append(i6);
                String sb2 = sb.toString();
                fVar = com.bumptech.glide.repackaged.com.squareup.javapoet.f.a(this.f14668f, sb2, new Modifier[0]).g(Modifier.PRIVATE, Modifier.STATIC).h();
                Object obj2 = this.f14668f;
                F.B("if ($T.$N == null)", this.f14668f, sb2).y("$T.$N =\n" + ((Object) c6) + ".$N", obj2, sb2, obj2, obj, "autoClone()").D().y("return $T.$N", this.f14668f, sb2);
            } else {
                F.y("return " + ((Object) c6), this.f14668f, obj);
                fVar = null;
            }
            Iterator it = executableElement.getTypeParameters().iterator();
            while (it.hasNext()) {
                F.z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.t(((TypeParameterElement) it.next()).getSimpleName().toString()));
            }
            F.m(this.f14666d.d());
            return new e(F.C(), fVar);
        }
        throw new IllegalArgumentException("Expected non-empty parameters for: " + executableElement);
    }

    private e g(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar;
        boolean m6 = m(executableElement);
        String obj = executableElement.getSimpleName().toString();
        Object i6 = i(obj);
        i.b F = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(obj).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f14666d.r(executableElement)).F(this.f14668f);
        StringBuilder c6 = c(m6, F, "new $T().$N(", this.f14666d.A(executableElement));
        if (m6) {
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            int i7 = this.f14663a;
            this.f14663a = i7 + 1;
            sb.append(i7);
            String sb2 = sb.toString();
            fVar = com.bumptech.glide.repackaged.com.squareup.javapoet.f.a(this.f14668f, sb2, new Modifier[0]).g(Modifier.PRIVATE, Modifier.STATIC).h();
            Object obj2 = this.f14668f;
            F.B("if ($T.$N == null)", this.f14668f, sb2).y("$T.$N =\n" + ((Object) c6) + ".$N", obj2, sb2, obj2, i6, "autoClone()").D().y("return $T.$N", this.f14668f, sb2);
        } else {
            F.y("return " + ((Object) c6), this.f14668f, i6);
            fVar = null;
        }
        Iterator it = executableElement.getTypeParameters().iterator();
        while (it.hasNext()) {
            F.z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.t(((TypeParameterElement) it.next()).getSimpleName().toString()));
        }
        F.m(this.f14666d.d()).m(this.f14666d.J());
        return new e(F.C(), fVar);
    }

    private static boolean m(ExecutableElement executableElement) {
        if (executableElement.getParameters().isEmpty() || (executableElement.getParameters().size() == 1 && ((VariableElement) executableElement.getParameters().get(0)).getSimpleName().toString().equals("android.content.Context"))) {
            return true;
        }
        return false;
    }
}
