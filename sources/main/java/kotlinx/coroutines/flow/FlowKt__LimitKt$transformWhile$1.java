package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n126#2,15:142\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n119#1:142,15\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class FlowKt__LimitKt$transformWhile$1<R> extends SuspendLambda implements Function2<j<? super R>, kotlin.coroutines.e<? super n1>, Object> {

    /* renamed from: a, reason: collision with root package name */
    int f48675a;

    /* renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f48676b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ i<T> f48677c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3<j<? super R>, T, kotlin.coroutines.e<? super Boolean>, Object> f48678d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$transformWhile$1(i<? extends T> iVar, Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function3, kotlin.coroutines.e<? super FlowKt__LimitKt$transformWhile$1> eVar) {
        super(2, eVar);
        this.f48677c = iVar;
        this.f48678d = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.f48677c, this.f48678d, eVar);
        flowKt__LimitKt$transformWhile$1.f48676b = obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<? super R> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((FlowKt__LimitKt$transformWhile$1) create(jVar, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.f48675a;
        if (i6 != 0) {
            if (i6 == 1) {
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.f48676b;
                try {
                    kotlin.g0.n(obj);
                } catch (AbortFlowException e6) {
                    e = e6;
                    kotlinx.coroutines.flow.internal.o.b(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                    return n1.f44123a;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.g0.n(obj);
            j jVar = (j) this.f48676b;
            i<T> iVar = this.f48677c;
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.f48678d, jVar);
            try {
                this.f48676b = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                this.f48675a = 1;
                if (iVar.collect(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12, this) == l6) {
                    return l6;
                }
            } catch (AbortFlowException e7) {
                e = e7;
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$12;
                kotlinx.coroutines.flow.internal.o.b(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                return n1.f44123a;
            }
        }
        return n1.f44123a;
    }
}
