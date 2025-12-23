package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,118:1\n32#2,4:119\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n*L\n62#1:119,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    private int f48595a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function3<Integer, T, kotlin.coroutines.e<? super n1>, Object> f48596b;

    @Nullable
    public Object a(T t5, @NotNull final kotlin.coroutines.e<? super n1> eVar) {
        kotlin.jvm.internal.d0.e(4);
        new ContinuationImpl(eVar) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__CollectKt$collectIndexed$2.this.emit(null, this);
            }
        };
        kotlin.jvm.internal.d0.e(5);
        Function3<Integer, T, kotlin.coroutines.e<? super n1>, Object> function3 = this.f48596b;
        int i6 = this.f48595a;
        this.f48595a = i6 + 1;
        if (i6 < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        function3.invoke(Integer.valueOf(i6), t5, eVar);
        return n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collectIndexed$2(Function3<? super Integer, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        this.f48596b = function3;
    }

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Function3<Integer, T, kotlin.coroutines.e<? super n1>, Object> function3 = this.f48596b;
        int i6 = this.f48595a;
        this.f48595a = i6 + 1;
        if (i6 < 0) {
            throw new ArithmeticException("Index overflow has happened");
        }
        Object invoke = function3.invoke(kotlin.coroutines.jvm.internal.a.f(i6), t5, eVar);
        return invoke == kotlin.coroutines.intrinsics.a.l() ? invoke : n1.f44123a;
    }
}
