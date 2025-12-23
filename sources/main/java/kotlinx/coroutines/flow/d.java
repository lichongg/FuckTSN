package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class d<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final i<T> f48855a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Context.kt\nkotlinx/coroutines/flow/CancellableFlowImpl$collect$2\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,285:1\n329#2:286\n*S KotlinDebug\n*F\n+ 1 Context.kt\nkotlinx/coroutines/flow/CancellableFlowImpl$collect$2\n*L\n274#1:286\n*E\n"})
    static final class a<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f48856a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME}, m = "emit", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.d$a$a, reason: collision with other inner class name */
        static final class C0936a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48857a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a<T> f48858b;

            /* renamed from: c, reason: collision with root package name */
            int f48859c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0936a(a<? super T> aVar, kotlin.coroutines.e<? super C0936a> eVar) {
                super(eVar);
                this.f48858b = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48857a = obj;
                this.f48859c |= Integer.MIN_VALUE;
                return this.f48858b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(j<? super T> jVar) {
            this.f48856a = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.d.a.C0936a
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.d$a$a r0 = (kotlinx.coroutines.flow.d.a.C0936a) r0
                int r1 = r0.f48859c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48859c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.d$a$a r0 = new kotlinx.coroutines.flow.d$a$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f48857a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48859c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r6)
                goto L46
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.g0.n(r6)
                kotlin.coroutines.i r6 = r0.getContext()
                kotlinx.coroutines.h2.z(r6)
                kotlinx.coroutines.flow.j<T> r6 = r4.f48856a
                r0.f48859c = r3
                java.lang.Object r5 = r6.emit(r5, r0)
                if (r5 != r1) goto L46
                return r1
            L46:
                kotlin.n1 r5 = kotlin.n1.f44123a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.d.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object collect = this.f48855a.collect(new a(jVar), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull i<? extends T> iVar) {
        this.f48855a = iVar;
    }
}
