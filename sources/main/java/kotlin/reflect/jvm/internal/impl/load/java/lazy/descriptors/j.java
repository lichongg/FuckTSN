package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaAnnotationDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaAnnotationDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaAnnotationDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1563#2:125\n1634#2,3:126\n1617#2,9:130\n1869#2:139\n1870#2:141\n1626#2:142\n1#3:129\n1#3:140\n*S KotlinDebug\n*F\n+ 1 LazyJavaAnnotationDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaAnnotationDescriptor\n*L\n94#1:125\n94#1:126,3\n62#1:130,9\n62#1:139\n62#1:141\n62#1:142\n62#1:140\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.g {

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45577i = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(j.class, "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(j.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(j.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45578a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final y3.a f45579b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j f45580c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45581d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final x3.a f45582e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45583f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f45584g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f45585h;

    public j(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull y3.a javaAnnotation, boolean z5) {
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(javaAnnotation, "javaAnnotation");
        this.f45578a = c6;
        this.f45579b = javaAnnotation;
        this.f45580c = c6.e().g(new g(this));
        this.f45581d = c6.e().e(new h(this));
        this.f45582e = c6.a().t().a(javaAnnotation);
        this.f45583f = c6.e().e(new i(this));
        this.f45584g = javaAnnotation.e();
        this.f45585h = javaAnnotation.u() || z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map g(j jVar) {
        Collection<y3.b> arguments = jVar.f45579b.getArguments();
        ArrayList arrayList = new ArrayList();
        for (y3.b bVar : arguments) {
            kotlin.reflect.jvm.internal.impl.name.f name = bVar.getName();
            if (name == null) {
                name = kotlin.reflect.jvm.internal.impl.load.java.i0.f45448c;
            }
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> l6 = jVar.l(bVar);
            Pair a6 = l6 != null ? kotlin.o0.a(name, l6) : null;
            if (a6 != null) {
                arrayList.add(a6);
            }
        }
        return i1.B0(arrayList);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d h(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.x.d(this.f45578a.d(), kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(cVar), this.f45578a.a().b().f().r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.c i(j jVar) {
        kotlin.reflect.jvm.internal.impl.name.b c6 = jVar.f45579b.c();
        if (c6 != null) {
            return c6.a();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> l(y3.b bVar) {
        if (bVar instanceof y3.o) {
            return kotlin.reflect.jvm.internal.impl.resolve.constants.i.f(kotlin.reflect.jvm.internal.impl.resolve.constants.i.f46667a, ((y3.o) bVar).getValue(), null, 2, null);
        }
        if (bVar instanceof y3.m) {
            y3.m mVar = (y3.m) bVar;
            return o(mVar.c(), mVar.d());
        }
        if (!(bVar instanceof y3.e)) {
            if (bVar instanceof y3.c) {
                return m(((y3.c) bVar).a());
            }
            if (bVar instanceof y3.h) {
                return p(((y3.h) bVar).b());
            }
            return null;
        }
        y3.e eVar = (y3.e) bVar;
        kotlin.reflect.jvm.internal.impl.name.f name = eVar.getName();
        if (name == null) {
            name = kotlin.reflect.jvm.internal.impl.load.java.i0.f45448c;
        }
        kotlin.jvm.internal.g0.m(name);
        return n(name, eVar.getElements());
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> m(y3.a aVar) {
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.a(new j(this.f45578a, aVar, false, 4, null));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> o(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.k(bVar, fVar);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> p(y3.x xVar) {
        return kotlin.reflect.jvm.internal.impl.resolve.constants.t.f46688b.a(this.f45578a.g().p(xVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, false, false, null, 7, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45583f, this, f45577i[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return (kotlin.reflect.jvm.internal.impl.name.c) kotlin.reflect.jvm.internal.impl.storage.m.b(this.f45580c, this, f45577i[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.g
    public boolean e() {
        return this.f45584g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public e1 getType() {
        return (e1) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45581d, this, f45577i[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public x3.a getSource() {
        return this.f45582e;
    }

    public final boolean k() {
        return this.f45585h;
    }

    @NotNull
    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.m.P(kotlin.reflect.jvm.internal.impl.renderer.m.f46581h, this, null, 2, null);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> n(kotlin.reflect.jvm.internal.impl.name.f fVar, List<? extends y3.b> list) {
        kotlin.reflect.jvm.internal.impl.types.t0 m6;
        if (kotlin.reflect.jvm.internal.impl.types.x0.a(getType())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d l6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.l(this);
        kotlin.jvm.internal.g0.m(l6);
        q1 b6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, l6);
        if (b6 == null || (m6 = b6.getType()) == null) {
            m6 = this.f45578a.a().m().p().m(Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
            kotlin.jvm.internal.g0.o(m6, "getArrayType(...)");
        }
        List<? extends y3.b> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> l7 = l((y3.b) it.next());
            if (l7 == null) {
                l7 = new kotlin.reflect.jvm.internal.impl.resolve.constants.v();
            }
            arrayList.add(l7);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.i.f46667a.c(arrayList, m6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 q(j jVar) {
        kotlin.reflect.jvm.internal.impl.name.c d6 = jVar.d();
        if (d6 == null) {
            return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, jVar.f45579b.toString());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d f6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f(kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f44483a, d6, jVar.f45578a.d().p(), null, 4, null);
        if (f6 == null) {
            y3.g D = jVar.f45579b.D();
            if (D != null) {
                f6 = jVar.f45578a.a().n().a(D);
            } else {
                f6 = null;
            }
            if (f6 == null) {
                f6 = jVar.h(d6);
            }
        }
        return f6.s();
    }

    public /* synthetic */ j(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, y3.a aVar, boolean z5, int i6, kotlin.jvm.internal.v vVar) {
        this(kVar, aVar, (i6 & 4) != 0 ? false : z5);
    }
}
