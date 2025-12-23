package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1563#2:226\n1634#2,3:227\n*S KotlinDebug\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes\n*L\n94#1:226\n94#1:227,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final k0 f44546a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final s f44547b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final a f44548c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final a f44549d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final a f44550e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final a f44551f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final a f44552g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final a f44553h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final a f44554i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final a f44555j;

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44545l = {o0.u(new PropertyReference1Impl(n.class, "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), o0.u(new PropertyReference1Impl(n.class, "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0))};

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final b f44544k = new b(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f44556a;

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull n types, @NotNull kotlin.reflect.n<?> property) {
            g0.p(types, "types");
            g0.p(property, "property");
            return types.c(f4.a.a(property.getName()), this.f44556a);
        }

        public a(int i6) {
            this.f44556a = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nReflectionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1761#2,3:226\n*S KotlinDebug\n*F\n+ 1 ReflectionTypes.kt\norg/jetbrains/kotlin/builtins/ReflectionTypes$Companion\n*L\n122#1:226,3\n*E\n"})
    public static final class b {
        public /* synthetic */ b(v vVar) {
            this();
        }

        private b() {
        }

        @Nullable
        public final t0 a(@NotNull f0 module) {
            g0.p(module, "module");
            kotlin.reflect.jvm.internal.impl.descriptors.d b6 = x.b(module, o.a.f44628w0);
            if (b6 == null) {
                return null;
            }
            t1 k6 = t1.f47332b.k();
            List<j1> parameters = b6.o().getParameters();
            g0.o(parameters, "getParameters(...)");
            Object m52 = kotlin.collections.f0.m5(parameters);
            g0.o(m52, "single(...)");
            return w0.h(k6, b6, kotlin.collections.f0.l(new l1((j1) m52)));
        }
    }

    public n(@NotNull f0 module, @NotNull k0 notFoundClasses) {
        g0.p(module, "module");
        g0.p(notFoundClasses, "notFoundClasses");
        this.f44546a = notFoundClasses;
        this.f44547b = t.b(LazyThreadSafetyMode.PUBLICATION, new m(module));
        this.f44548c = new a(1);
        this.f44549d = new a(1);
        this.f44550e = new a(1);
        this.f44551f = new a(2);
        this.f44552g = new a(3);
        this.f44553h = new a(1);
        this.f44554i = new a(2);
        this.f44555j = new a(3);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k e() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.k) this.f44547b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f(f0 f0Var) {
        return f0Var.M(o.f44581y).r();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d d() {
        return this.f44548c.a(this, f44545l[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d c(String str, int i6) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar;
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
        g0.o(h6, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.f g6 = e().g(h6, NoLookupLocation.FROM_REFLECTION);
        if (g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) g6;
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return this.f44546a.d(new kotlin.reflect.jvm.internal.impl.name.b(o.f44581y, h6), kotlin.collections.f0.l(Integer.valueOf(i6)));
        }
        return dVar;
    }
}
