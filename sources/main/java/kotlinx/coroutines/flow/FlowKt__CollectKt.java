package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.n1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__CollectKt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48592a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i<T> f48593b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i<? extends T> iVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48593b = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f48593b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48592a;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                i<T> iVar = this.f48593b;
                this.f48592a = 1;
                if (k.x(iVar, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    @Nullable
    public static final Object a(@NotNull i<?> iVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object collect = iVar.collect(kotlinx.coroutines.flow.internal.r.f49028a, eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object b(i<? extends T> iVar, Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, kotlin.coroutines.e<? super n1> eVar) {
        Object collect = iVar.collect(new FlowKt__CollectKt$collect$3(function2), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    private static final /* synthetic */ <T> Object c(i<? extends T> iVar, Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, kotlin.coroutines.e<? super n1> eVar) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(function2);
        kotlin.jvm.internal.d0.e(0);
        iVar.collect(flowKt__CollectKt$collect$3, eVar);
        kotlin.jvm.internal.d0.e(1);
        return n1.f44123a;
    }

    @Nullable
    public static final <T> Object d(@NotNull i<? extends T> iVar, @NotNull Function3<? super Integer, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object collect = iVar.collect(new FlowKt__CollectKt$collectIndexed$2(function3), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    private static final <T> Object e(i<? extends T> iVar, Function3<? super Integer, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, kotlin.coroutines.e<? super n1> eVar) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(function3);
        kotlin.jvm.internal.d0.e(0);
        iVar.collect(flowKt__CollectKt$collectIndexed$2, eVar);
        kotlin.jvm.internal.d0.e(1);
        return n1.f44123a;
    }

    @NotNull
    public static final <T> e2 h(@NotNull i<? extends T> iVar, @NotNull r0 r0Var) {
        e2 f6;
        f6 = kotlinx.coroutines.k.f(r0Var, null, null, new a(iVar, null), 3, null);
        return f6;
    }

    @Nullable
    public static final <T> Object f(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object x5 = k.x(n.d(k.X0(iVar, function2), 0, null, 2, null), eVar);
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            return x5;
        }
        return n1.f44123a;
    }

    @Nullable
    public static final <T> Object g(@NotNull j<? super T> jVar, @NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        k.o0(jVar);
        Object collect = iVar.collect(jVar, eVar);
        if (collect == kotlin.coroutines.intrinsics.a.l()) {
            return collect;
        }
        return n1.f44123a;
    }
}
