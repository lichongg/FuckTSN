package kotlinx.coroutines.flow.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g<S, T> extends d<T> {

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    protected final kotlinx.coroutines.flow.i<S> f48933d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<kotlinx.coroutines.flow.j<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48934a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48935b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g<S, T> f48936c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g<S, T> gVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48936c = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f48936c, eVar);
            aVar.f48935b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(jVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48934a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                kotlinx.coroutines.flow.j<? super T> jVar = (kotlinx.coroutines.flow.j) this.f48935b;
                g<S, T> gVar = this.f48936c;
                this.f48934a = 1;
                if (gVar.r(jVar, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    @Nullable
    protected abstract Object r(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar);

    static /* synthetic */ <S, T> Object o(g<S, T> gVar, kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.e<? super n1> eVar) {
        if (gVar.f48909b == -3) {
            kotlin.coroutines.i context = eVar.getContext();
            kotlin.coroutines.i d6 = l0.d(context, gVar.f48908a);
            if (kotlin.jvm.internal.g0.g(d6, context)) {
                Object r5 = gVar.r(jVar, eVar);
                return r5 == kotlin.coroutines.intrinsics.a.l() ? r5 : n1.f44123a;
            }
            f.b bVar = kotlin.coroutines.f.f43765o0;
            if (kotlin.jvm.internal.g0.g(d6.get(bVar), context.get(bVar))) {
                Object q5 = gVar.q(jVar, d6, eVar);
                return q5 == kotlin.coroutines.intrinsics.a.l() ? q5 : n1.f44123a;
            }
        }
        Object collect = super.collect(jVar, eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    static /* synthetic */ <S, T> Object p(g<S, T> gVar, z<? super T> zVar, kotlin.coroutines.e<? super n1> eVar) {
        Object r5 = gVar.r(new u(zVar), eVar);
        return r5 == kotlin.coroutines.intrinsics.a.l() ? r5 : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public String toString() {
        return this.f48933d + " -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull kotlinx.coroutines.flow.i<? extends S> iVar, @NotNull kotlin.coroutines.i iVar2, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(iVar2, i6, bufferOverflow);
        this.f48933d = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.i iVar, kotlin.coroutines.e<? super n1> eVar) {
        kotlinx.coroutines.flow.j e6;
        e6 = e.e(jVar, eVar.getContext());
        Object d6 = e.d(iVar, e6, null, new a(this, null), eVar, 4, null);
        if (d6 == kotlin.coroutines.intrinsics.a.l()) {
            return d6;
        }
        return n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return o(this, jVar, eVar);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @Nullable
    protected Object h(@NotNull z<? super T> zVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return p(this, zVar, eVar);
    }
}
