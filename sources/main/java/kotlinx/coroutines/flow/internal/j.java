package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1855#2,2:101\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n*L\n95#1:101,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j<T> extends d<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Iterable<kotlinx.coroutines.flow.i<T>> f48956d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48957a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T> f48958b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ u<T> f48959c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.i<? extends T> iVar, u<T> uVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48958b = iVar;
            this.f48959c = uVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f48958b, this.f48959c, eVar);
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
            int i6 = this.f48957a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                kotlinx.coroutines.flow.i<T> iVar = this.f48958b;
                u<T> uVar = this.f48959c;
                this.f48957a = 1;
                if (iVar.collect(uVar, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    public /* synthetic */ j(Iterable iterable, kotlin.coroutines.i iVar, int i6, BufferOverflow bufferOverflow, int i7, kotlin.jvm.internal.v vVar) {
        this(iterable, (i7 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : iVar, (i7 & 4) != 0 ? -2 : i6, (i7 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @Nullable
    protected Object h(@NotNull z<? super T> zVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        u uVar = new u(zVar);
        Iterator<kotlinx.coroutines.flow.i<T>> it = this.f48956d.iterator();
        while (it.hasNext()) {
            kotlinx.coroutines.k.f(zVar, null, null, new a(it.next(), uVar, null), 3, null);
        }
        return n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new j(this.f48956d, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public b0<T> m(@NotNull r0 r0Var) {
        return kotlinx.coroutines.channels.x.c(r0Var, this.f48908a, this.f48909b, k());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull Iterable<? extends kotlinx.coroutines.flow.i<? extends T>> iterable, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(iVar, i6, bufferOverflow);
        this.f48956d = iterable;
    }
}
