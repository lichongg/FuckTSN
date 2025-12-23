package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaToKotlinClassMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaToKotlinClassMap.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n50#1,2:234\n50#1,2:236\n50#1,2:238\n50#1,2:240\n50#1,2:242\n50#1,2:244\n50#1,2:246\n50#1,2:248\n1634#2,3:230\n1#3:233\n*S KotlinDebug\n*F\n+ 1 JavaToKotlinClassMap.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMap\n*L\n55#1:234,2\n56#1:236,2\n57#1:238,2\n58#1:240,2\n59#1:242,2\n60#1:244,2\n61#1:246,2\n62#1:248,2\n218#1:230,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f44463a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f44464b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f44465c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f44466d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f44467e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44468f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f44469g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44470h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44471i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44472j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.b> f44473k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.b> f44474l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.c> f44475m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.c> f44476n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f44477o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f44478p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final List<a> f44479q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f44480a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f44481b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f44482c;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return g0.g(this.f44480a, aVar.f44480a) && g0.g(this.f44481b, aVar.f44481b) && g0.g(this.f44482c, aVar.f44482c);
        }

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b javaClass, @NotNull kotlin.reflect.jvm.internal.impl.name.b kotlinReadOnly, @NotNull kotlin.reflect.jvm.internal.impl.name.b kotlinMutable) {
            g0.p(javaClass, "javaClass");
            g0.p(kotlinReadOnly, "kotlinReadOnly");
            g0.p(kotlinMutable, "kotlinMutable");
            this.f44480a = javaClass;
            this.f44481b = kotlinReadOnly;
            this.f44482c = kotlinMutable;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return this.f44480a;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b b() {
            return this.f44481b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b c() {
            return this.f44482c;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b d() {
            return this.f44480a;
        }

        public int hashCode() {
            return (((this.f44480a.hashCode() * 31) + this.f44481b.hashCode()) * 31) + this.f44482c.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f44480a + ", kotlinReadOnly=" + this.f44481b + ", kotlinMutable=" + this.f44482c + ')';
        }
    }

    static {
        c cVar = new c();
        f44463a = cVar;
        StringBuilder sb = new StringBuilder();
        e.a aVar = e.a.f44424f;
        sb.append(aVar.b());
        sb.append('.');
        sb.append(aVar.a());
        f44464b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        e.b bVar = e.b.f44425f;
        sb2.append(bVar.b());
        sb2.append('.');
        sb2.append(bVar.a());
        f44465c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        e.d dVar = e.d.f44427f;
        sb3.append(dVar.b());
        sb3.append('.');
        sb3.append(dVar.a());
        f44466d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        e.c cVar2 = e.c.f44426f;
        sb4.append(cVar2.b());
        sb4.append('.');
        sb4.append(cVar2.a());
        f44467e = sb4.toString();
        b.a aVar2 = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        kotlin.reflect.jvm.internal.impl.name.b c6 = aVar2.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.functions.FunctionN"));
        f44468f = c6;
        f44469g = c6.a();
        kotlin.reflect.jvm.internal.impl.name.i iVar = kotlin.reflect.jvm.internal.impl.name.i.f46374a;
        f44470h = iVar.l();
        f44471i = iVar.k();
        f44472j = cVar.g(Class.class);
        f44473k = new HashMap<>();
        f44474l = new HashMap<>();
        f44475m = new HashMap<>();
        f44476n = new HashMap<>();
        f44477o = new HashMap<>();
        f44478p = new HashMap<>();
        kotlin.reflect.jvm.internal.impl.name.b c7 = aVar2.c(o.a.W);
        a aVar3 = new a(cVar.g(Iterable.class), c7, new kotlin.reflect.jvm.internal.impl.name.b(c7.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44592e0, c7.f()), false));
        kotlin.reflect.jvm.internal.impl.name.b c8 = aVar2.c(o.a.V);
        a aVar4 = new a(cVar.g(Iterator.class), c8, new kotlin.reflect.jvm.internal.impl.name.b(c8.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44590d0, c8.f()), false));
        kotlin.reflect.jvm.internal.impl.name.b c9 = aVar2.c(o.a.X);
        a aVar5 = new a(cVar.g(Collection.class), c9, new kotlin.reflect.jvm.internal.impl.name.b(c9.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44594f0, c9.f()), false));
        kotlin.reflect.jvm.internal.impl.name.b c10 = aVar2.c(o.a.Y);
        a aVar6 = new a(cVar.g(List.class), c10, new kotlin.reflect.jvm.internal.impl.name.b(c10.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44596g0, c10.f()), false));
        kotlin.reflect.jvm.internal.impl.name.b c11 = aVar2.c(o.a.f44584a0);
        a aVar7 = new a(cVar.g(Set.class), c11, new kotlin.reflect.jvm.internal.impl.name.b(c11.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44600i0, c11.f()), false));
        kotlin.reflect.jvm.internal.impl.name.b c12 = aVar2.c(o.a.Z);
        a aVar8 = new a(cVar.g(ListIterator.class), c12, new kotlin.reflect.jvm.internal.impl.name.b(c12.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44598h0, c12.f()), false));
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = o.a.f44586b0;
        kotlin.reflect.jvm.internal.impl.name.b c13 = aVar2.c(cVar3);
        a aVar9 = new a(cVar.g(Map.class), c13, new kotlin.reflect.jvm.internal.impl.name.b(c13.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44602j0, c13.f()), false));
        kotlin.reflect.jvm.internal.impl.name.b d6 = aVar2.c(cVar3).d(o.a.f44588c0.f());
        List<a> Q = f0.Q(aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, new a(cVar.g(Map.Entry.class), d6, new kotlin.reflect.jvm.internal.impl.name.b(d6.f(), kotlin.reflect.jvm.internal.impl.name.e.g(o.a.f44604k0, d6.f()), false)));
        f44479q = Q;
        cVar.f(Object.class, o.a.f44585b);
        cVar.f(String.class, o.a.f44597h);
        cVar.f(CharSequence.class, o.a.f44595g);
        cVar.e(Throwable.class, o.a.f44623u);
        cVar.f(Cloneable.class, o.a.f44589d);
        cVar.f(Number.class, o.a.f44617r);
        cVar.e(Comparable.class, o.a.f44625v);
        cVar.f(Enum.class, o.a.f44619s);
        cVar.e(Annotation.class, o.a.G);
        Iterator<a> it = Q.iterator();
        while (it.hasNext()) {
            f44463a.d(it.next());
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            c cVar4 = f44463a;
            b.a aVar10 = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
            kotlin.reflect.jvm.internal.impl.name.c wrapperFqName = jvmPrimitiveType.getWrapperFqName();
            g0.o(wrapperFqName, "getWrapperFqName(...)");
            kotlin.reflect.jvm.internal.impl.name.b c14 = aVar10.c(wrapperFqName);
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            g0.o(primitiveType, "getPrimitiveType(...)");
            cVar4.a(c14, aVar10.c(kotlin.reflect.jvm.internal.impl.builtins.o.c(primitiveType)));
        }
        for (kotlin.reflect.jvm.internal.impl.name.b bVar2 : kotlin.reflect.jvm.internal.impl.builtins.d.f44402a.a()) {
            f44463a.a(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal." + bVar2.h().b() + "CompanionObject")), bVar2.d(kotlin.reflect.jvm.internal.impl.name.h.f46358d));
        }
        for (int i6 = 0; i6 < 23; i6++) {
            c cVar5 = f44463a;
            cVar5.a(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.functions.Function" + i6)), kotlin.reflect.jvm.internal.impl.builtins.o.a(i6));
            cVar5.c(new kotlin.reflect.jvm.internal.impl.name.c(f44465c + i6), f44470h);
        }
        for (int i7 = 0; i7 < 22; i7++) {
            e.c cVar6 = e.c.f44426f;
            f44463a.c(new kotlin.reflect.jvm.internal.impl.name.c((cVar6.b() + '.' + cVar6.a()) + i7), f44470h);
        }
        c cVar7 = f44463a;
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicInt"), cVar7.g(AtomicInteger.class));
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicLong"), cVar7.g(AtomicLong.class));
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicBoolean"), cVar7.g(AtomicBoolean.class));
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicReference"), cVar7.g(AtomicReference.class));
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicIntArray"), cVar7.g(AtomicIntegerArray.class));
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicLongArray"), cVar7.g(AtomicLongArray.class));
        cVar7.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.concurrent.atomics.AtomicArray"), cVar7.g(AtomicReferenceArray.class));
        cVar7.c(o.a.f44587c.m(), cVar7.g(Void.class));
    }

    private final void b(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.name.b bVar2) {
        f44473k.put(bVar.a().i(), bVar2);
    }

    private final void c(kotlin.reflect.jvm.internal.impl.name.c cVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        f44474l.put(cVar.i(), bVar);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c h() {
        return f44469g;
    }

    @NotNull
    public final List<a> i() {
        return f44479q;
    }

    public final boolean k(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f44475m.containsKey(dVar);
    }

    public final boolean l(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f44476n.containsKey(dVar);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.b m(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        return f44473k.get(fqName.i());
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.b n(@NotNull kotlin.reflect.jvm.internal.impl.name.d kotlinFqName) {
        g0.p(kotlinFqName, "kotlinFqName");
        return j(kotlinFqName, f44464b) ? f44468f : j(kotlinFqName, f44466d) ? f44468f : j(kotlinFqName, f44465c) ? f44470h : j(kotlinFqName, f44467e) ? f44470h : f44474l.get(kotlinFqName);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.c o(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f44475m.get(dVar);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.c p(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f44476n.get(dVar);
    }

    private c() {
    }

    private final void a(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.name.b bVar2) {
        b(bVar, bVar2);
        c(bVar2.a(), bVar);
    }

    private final void d(a aVar) {
        kotlin.reflect.jvm.internal.impl.name.b a6 = aVar.a();
        kotlin.reflect.jvm.internal.impl.name.b b6 = aVar.b();
        kotlin.reflect.jvm.internal.impl.name.b c6 = aVar.c();
        a(a6, b6);
        c(c6.a(), a6);
        f44477o.put(c6, b6);
        f44478p.put(b6, c6);
        kotlin.reflect.jvm.internal.impl.name.c a7 = b6.a();
        kotlin.reflect.jvm.internal.impl.name.c a8 = c6.a();
        f44475m.put(c6.a().i(), a7);
        f44476n.put(a7.i(), a8);
    }

    private final void e(Class<?> cls, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        a(g(cls), kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(cVar));
    }

    private final void f(Class<?> cls, kotlin.reflect.jvm.internal.impl.name.d dVar) {
        e(cls, dVar.m());
    }

    private final kotlin.reflect.jvm.internal.impl.name.b g(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
            String canonicalName = cls.getCanonicalName();
            g0.o(canonicalName, "getCanonicalName(...)");
            return aVar.c(new kotlin.reflect.jvm.internal.impl.name.c(canonicalName));
        }
        kotlin.reflect.jvm.internal.impl.name.b g6 = g(declaringClass);
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(cls.getSimpleName());
        g0.o(h6, "identifier(...)");
        return g6.d(h6);
    }

    private final boolean j(kotlin.reflect.jvm.internal.impl.name.d dVar, String str) {
        Integer n12;
        String a6 = dVar.a();
        if (!kotlin.text.u.H2(a6, str, false, 2, null)) {
            return false;
        }
        String substring = a6.substring(str.length());
        g0.o(substring, "substring(...)");
        if (kotlin.text.u.y5(substring, '0', false, 2, null) || (n12 = kotlin.text.u.n1(substring)) == null || n12.intValue() < 23) {
            return false;
        }
        return true;
    }
}
