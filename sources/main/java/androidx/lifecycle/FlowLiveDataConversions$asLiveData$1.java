package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class FlowLiveDataConversions$asLiveData$1<T> extends SuspendLambda implements Function2<LiveDataScope<T>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.i<T> $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull LiveDataScope<T> liveDataScope, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((FlowLiveDataConversions$asLiveData$1) create(liveDataScope, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowLiveDataConversions$asLiveData$1(kotlinx.coroutines.flow.i<? extends T> iVar, kotlin.coroutines.e<? super FlowLiveDataConversions$asLiveData$1> eVar) {
        super(2, eVar);
        this.$this_asLiveData = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, eVar);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            kotlinx.coroutines.flow.i<T> iVar = this.$this_asLiveData;
            kotlinx.coroutines.flow.j<? super T> jVar = new kotlinx.coroutines.flow.j() { // from class: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1.1
                @Override // kotlinx.coroutines.flow.j
                @Nullable
                public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
                    Object emit = liveDataScope.emit(t5, eVar);
                    return emit == kotlin.coroutines.intrinsics.a.l() ? emit : n1.f44123a;
                }
            };
            this.label = 1;
            if (iVar.collect(jVar, this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
