package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1<R> implements i<R> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f48603a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function3 f48604b;

    @Nullable
    public Object f(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.d0.e(4);
        new ContinuationImpl(eVar) { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.this.collect(null, this);
            }
        };
        kotlin.jvm.internal.d0.e(5);
        i iVar = this.f48603a;
        FlowKt__EmittersKt$unsafeTransform$1$1 flowKt__EmittersKt$unsafeTransform$1$1 = new FlowKt__EmittersKt$unsafeTransform$1$1(this.f48604b, jVar);
        kotlin.jvm.internal.d0.e(0);
        iVar.collect(flowKt__EmittersKt$unsafeTransform$1$1, eVar);
        kotlin.jvm.internal.d0.e(1);
        return n1.f44123a;
    }

    public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(i iVar, Function3 function3) {
        this.f48603a = iVar;
        this.f48604b = function3;
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super R> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object collect = this.f48603a.collect(new FlowKt__EmittersKt$unsafeTransform$1$1(this.f48604b, jVar), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }
}
