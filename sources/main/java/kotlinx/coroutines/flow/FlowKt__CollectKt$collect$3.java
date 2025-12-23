package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n*L\n1#1,118:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__CollectKt$collect$3<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function2<T, kotlin.coroutines.e<? super n1>, Object> f48594a;

    @Nullable
    public Object a(T t5, @NotNull final kotlin.coroutines.e<? super n1> eVar) {
        kotlin.jvm.internal.d0.e(4);
        new ContinuationImpl(eVar) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__CollectKt$collect$3.this.emit(null, this);
            }
        };
        kotlin.jvm.internal.d0.e(5);
        this.f48594a.invoke(t5, eVar);
        return n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collect$3(Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        this.f48594a = function2;
    }

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object invoke = this.f48594a.invoke(t5, eVar);
        return invoke == kotlin.coroutines.intrinsics.a.l() ? invoke : n1.f44123a;
    }
}
