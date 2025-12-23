package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n1#2:429\n314#3,11:430\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n298#1:430,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class k0 extends kotlinx.coroutines.flow.internal.c<i0<?>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49046a = AtomicReferenceFieldUpdater.newUpdater(k0.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull i0<?> i0Var) {
        s0 s0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49046a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        s0Var = j0.f49043a;
        atomicReferenceFieldUpdater.set(this, s0Var);
        return true;
    }

    @Nullable
    public final Object e(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        s0 s0Var;
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49046a;
        s0Var = j0.f49043a;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, s0Var, qVar)) {
            Result.a aVar = Result.Companion;
            qVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.e<n1>[] b(@NotNull i0<?> i0Var) {
        f49046a.set(this, null);
        return kotlinx.coroutines.flow.internal.b.f48907a;
    }

    public final void h() {
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        s0 s0Var4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49046a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return;
            }
            s0Var = j0.f49044b;
            if (obj == s0Var) {
                return;
            }
            s0Var2 = j0.f49043a;
            if (obj == s0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f49046a;
                s0Var3 = j0.f49044b;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, obj, s0Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f49046a;
                s0Var4 = j0.f49043a;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater3, this, obj, s0Var4)) {
                    Result.a aVar = Result.Companion;
                    ((kotlinx.coroutines.q) obj).resumeWith(Result.m130constructorimpl(n1.f44123a));
                    return;
                }
            }
        }
    }

    public final boolean i() {
        s0 s0Var;
        s0 s0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49046a;
        s0Var = j0.f49043a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, s0Var);
        kotlin.jvm.internal.g0.m(andSet);
        s0Var2 = j0.f49044b;
        return andSet == s0Var2;
    }

    private final void g(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }
}
