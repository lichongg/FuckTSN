package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1563#2:291\n1634#2,3:292\n*S KotlinDebug\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedTypeConstructor\n*L\n271#1:291\n271#1:292,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n implements kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final c2 f47183a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private Function0<? extends List<? extends m2>> f47184b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final n f47185c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final j1 f47186d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.s f47187e;

    public n(@NotNull c2 projection, @Nullable Function0<? extends List<? extends m2>> function0, @Nullable n nVar, @Nullable j1 j1Var) {
        g0.p(projection, "projection");
        this.f47183a = projection;
        this.f47184b = function0;
        this.f47185c = nVar;
        this.f47186d = j1Var;
        this.f47187e = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new j(this));
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

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g0.g(n.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        g0.n(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        n nVar = (n) obj;
        n nVar2 = this.f47185c;
        if (nVar2 == null) {
            nVar2 = this;
        }
        n nVar3 = nVar.f47185c;
        if (nVar3 != null) {
            obj = nVar3;
        }
        return nVar2 == obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(n nVar) {
        Function0<? extends List<? extends m2>> function0 = nVar.f47184b;
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }

    private final List<m2> m() {
        return (List) this.f47187e.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b
    @NotNull
    public c2 getProjection() {
        return this.f47183a;
    }

    public int hashCode() {
        n nVar = this.f47185c;
        return nVar != null ? nVar.hashCode() : super.hashCode();
    }

    public final void n(@NotNull List<? extends m2> supertypes) {
        g0.p(supertypes, "supertypes");
        this.f47184b = new l(supertypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public n a(@NotNull g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        c2 a6 = getProjection().a(kotlinTypeRefiner);
        g0.o(a6, "refine(...)");
        m mVar = this.f47184b != null ? new m(this, kotlinTypeRefiner) : null;
        n nVar = this.f47185c;
        if (nVar == null) {
            nVar = this;
        }
        return new n(a6, mVar, nVar, this.f47186d);
    }

    @NotNull
    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r(n nVar, g gVar) {
        List<m2> i6 = nVar.i();
        ArrayList arrayList = new ArrayList(f0.d0(i6, 10));
        Iterator<T> it = i6.iterator();
        while (it.hasNext()) {
            arrayList.add(((m2) it.next()).N0(gVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public List<j1> getParameters() {
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public List<m2> i() {
        List<m2> m6 = m();
        if (m6 == null) {
            return f0.J();
        }
        return m6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        t0 type = getProjection().getType();
        g0.o(type, "getType(...)");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(type);
    }

    public /* synthetic */ n(c2 c2Var, Function0 function0, n nVar, j1 j1Var, int i6, kotlin.jvm.internal.v vVar) {
        this(c2Var, (i6 & 2) != 0 ? null : function0, (i6 & 4) != 0 ? null : nVar, (i6 & 8) != 0 ? null : j1Var);
    }

    public /* synthetic */ n(c2 c2Var, List list, n nVar, int i6, kotlin.jvm.internal.v vVar) {
        this(c2Var, list, (i6 & 4) != 0 ? null : nVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(@NotNull c2 projection, @NotNull List<? extends m2> supertypes, @Nullable n nVar) {
        this(projection, new k(supertypes), nVar, null, 8, null);
        g0.p(projection, "projection");
        g0.p(supertypes, "supertypes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List o(List list) {
        return list;
    }
}
