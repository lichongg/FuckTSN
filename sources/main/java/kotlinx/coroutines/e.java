package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n314#2,9:128\n323#2,2:141\n13#3:137\n19#3:140\n13579#4,2:138\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n71#1:128,9\n71#1:141,2\n78#1:137\n90#1:140\n83#1:138,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class e<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f48554b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final x0<T>[] f48555a;

    @Volatile
    private volatile int notCompletedCount;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n11335#2:128\n11670#2,3:129\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n121#1:128\n121#1:129,3\n*E\n"})
    private final class a extends k2 {

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private static final AtomicReferenceFieldUpdater f48556h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");

        @Volatile
        @Nullable
        private volatile Object _disposer;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final p<List<? extends T>> f48557e;

        /* renamed from: f, reason: collision with root package name */
        public j1 f48558f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull p<? super List<? extends T>> pVar) {
            this.f48557e = pVar;
        }

        @Nullable
        public final e<T>.b C() {
            return (b) f48556h.get(this);
        }

        @NotNull
        public final j1 D() {
            j1 j1Var = this.f48558f;
            if (j1Var != null) {
                return j1Var;
            }
            kotlin.jvm.internal.g0.S("handle");
            return null;
        }

        public final void E(@Nullable e<T>.b bVar) {
            f48556h.set(this, bVar);
        }

        public final void F(@NotNull j1 j1Var) {
            this.f48558f = j1Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
            z(th);
            return kotlin.n1.f44123a;
        }

        @Override // kotlinx.coroutines.f0
        public void z(@Nullable Throwable th) {
            if (th != null) {
                Object J = this.f48557e.J(th);
                if (J != null) {
                    this.f48557e.B(J);
                    e<T>.b C = C();
                    if (C != null) {
                        C.m();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.f48554b.decrementAndGet(e.this) == 0) {
                p<List<? extends T>> pVar = this.f48557e;
                x0[] x0VarArr = ((e) e.this).f48555a;
                ArrayList arrayList = new ArrayList(x0VarArr.length);
                for (x0 x0Var : x0VarArr) {
                    arrayList.add(x0Var.d());
                }
                Result.a aVar = Result.Companion;
                pVar.resumeWith(Result.m130constructorimpl(arrayList));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n13579#2,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n96#1:128,2\n*E\n"})
    private final class b extends n {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final e<T>.a[] f48560a;

        public b(@NotNull e<T>.a[] aVarArr) {
            this.f48560a = aVarArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
            l(th);
            return kotlin.n1.f44123a;
        }

        public final void m() {
            for (e<T>.a aVar : this.f48560a) {
                aVar.D().dispose();
            }
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f48560a + ']';
        }

        @Override // kotlinx.coroutines.o
        public void l(@Nullable Throwable th) {
            m();
        }
    }

    @Nullable
    public final Object c(@NotNull kotlin.coroutines.e<? super List<? extends T>> eVar) {
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        int length = this.f48555a.length;
        a[] aVarArr = new a[length];
        for (int i6 = 0; i6 < length; i6++) {
            x0 x0Var = this.f48555a[i6];
            x0Var.start();
            a aVar = new a(qVar);
            aVar.F(x0Var.k(aVar));
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            aVarArr[i6] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i7 = 0; i7 < length; i7++) {
            aVarArr[i7].E(bVar);
        }
        if (qVar.isCompleted()) {
            bVar.m();
        } else {
            qVar.I(bVar);
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull x0<? extends T>[] x0VarArr) {
        this.f48555a = x0VarArr;
        this.notCompletedCount = x0VarArr.length;
    }
}
