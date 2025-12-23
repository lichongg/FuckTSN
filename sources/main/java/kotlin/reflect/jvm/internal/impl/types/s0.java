package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntersectionTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 5 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt$transformComponents$1\n*L\n1#1,120:1\n1#2:121\n1056#3:122\n1563#3:129\n1634#3,2:130\n1636#3:139\n98#4,6:123\n104#4:132\n105#4,5:134\n112#4,7:140\n99#5:133\n*S KotlinDebug\n*F\n+ 1 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructor\n*L\n66#1:122\n89#1:129\n89#1:130,2\n89#1:139\n89#1:123,6\n89#1:132\n89#1:134,5\n89#1:140,7\n89#1:133\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0 implements w1, e4.f {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private t0 f47326a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final LinkedHashSet<t0> f47327b;

    /* renamed from: c, reason: collision with root package name */
    private final int f47328c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructor\n*L\n1#1,328:1\n66#2:329\n*E\n"})
    public static final class a<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f47329a;

        public a(Function1 function1) {
            this.f47329a = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            t0 t0Var = (t0) t5;
            Function1 function1 = this.f47329a;
            kotlin.jvm.internal.g0.m(t0Var);
            String obj = function1.invoke(t0Var).toString();
            t0 t0Var2 = (t0) t6;
            Function1 function12 = this.f47329a;
            kotlin.jvm.internal.g0.m(t0Var2);
            return kotlin.comparisons.a.l(obj, function12.invoke(t0Var2).toString());
        }
    }

    public s0(@NotNull Collection<? extends t0> typesToIntersect) {
        kotlin.jvm.internal.g0.p(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<t0> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.f47327b = linkedHashSet;
        this.f47328c = linkedHashSet.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f c() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    public boolean d() {
        return false;
    }

    @NotNull
    public String toString() {
        return n(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 k(s0 s0Var, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return s0Var.a(kotlinTypeRefiner).j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String n(s0 s0Var, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function1 = q0.f47323a;
        }
        return s0Var.m(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String o(t0 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s0) {
            return kotlin.jvm.internal.g0.g(this.f47327b, ((s0) obj).f47327b);
        }
        return false;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k h() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.x.f46808d.a("member scope for intersection type", this.f47327b);
    }

    public int hashCode() {
        return this.f47328c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public Collection<t0> i() {
        return this.f47327b;
    }

    @NotNull
    public final e1 j() {
        return w0.p(t1.f47332b.k(), this, kotlin.collections.f0.J(), false, h(), new r0(this));
    }

    @Nullable
    public final t0 l() {
        return this.f47326a;
    }

    @NotNull
    public final String m(@NotNull Function1<? super t0, ? extends Object> getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.g0.p(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return kotlin.collections.f0.r3(kotlin.collections.f0.z5(this.f47327b, new a(getProperTypeRelatedToStringify)), " & ", "{", "}", 0, null, new p0(getProperTypeRelatedToStringify), 24, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        kotlin.reflect.jvm.internal.impl.builtins.j p5 = this.f47327b.iterator().next().I0().p();
        kotlin.jvm.internal.g0.o(p5, "getBuiltIns(...)");
        return p5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public s0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<t0> i6 = i();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(i6, 10));
        Iterator<T> it = i6.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            arrayList.add(((t0) it.next()).S0(kotlinTypeRefiner));
            z5 = true;
        }
        s0 s0Var = null;
        if (z5) {
            t0 l6 = l();
            s0Var = new s0(arrayList).s(l6 != null ? l6.S0(kotlinTypeRefiner) : null);
        }
        return s0Var == null ? this : s0Var;
    }

    @NotNull
    public final s0 s(@Nullable t0 t0Var) {
        return new s0(this.f47327b, t0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence q(Function1 function1, t0 t0Var) {
        kotlin.jvm.internal.g0.m(t0Var);
        return function1.invoke(t0Var).toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.j1> getParameters() {
        return kotlin.collections.f0.J();
    }

    private s0(Collection<? extends t0> collection, t0 t0Var) {
        this(collection);
        this.f47326a = t0Var;
    }
}
