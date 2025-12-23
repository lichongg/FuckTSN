package kotlinx.coroutines.flow.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.PublishedApi;
import kotlin.collections.a1;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.c0;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.internal.y0;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,143:1\n107#2:144\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n86#1:144\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, 76, 79}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48960a;

        /* renamed from: b, reason: collision with root package name */
        Object f48961b;

        /* renamed from: c, reason: collision with root package name */
        int f48962c;

        /* renamed from: d, reason: collision with root package name */
        int f48963d;

        /* renamed from: e, reason: collision with root package name */
        int f48964e;

        /* renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f48965f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f48966g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<T[]> f48967h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function3<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.e<? super n1>, Object> f48968i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f48969j;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.internal.k$a$a, reason: collision with other inner class name */
        static final class C0943a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f48970a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f48971b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f48972c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f48973d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.j<a1<Object>> f48974e;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: kotlinx.coroutines.flow.internal.k$a$a$a, reason: collision with other inner class name */
            static final class C0944a<T> implements kotlinx.coroutines.flow.j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.j<a1<Object>> f48975a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ int f48976b;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", i = {}, l = {32, 33}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.internal.k$a$a$a$a, reason: collision with other inner class name */
                static final class C0945a extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f48977a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ C0944a<T> f48978b;

                    /* renamed from: c, reason: collision with root package name */
                    int f48979c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0945a(C0944a<? super T> c0944a, kotlin.coroutines.e<? super C0945a> eVar) {
                        super(eVar);
                        this.f48978b = c0944a;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f48977a = obj;
                        this.f48979c |= Integer.MIN_VALUE;
                        return this.f48978b.emit(null, this);
                    }
                }

                C0944a(kotlinx.coroutines.channels.j<a1<Object>> jVar, int i6) {
                    this.f48975a = jVar;
                    this.f48976b = i6;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
                
                    if (kotlinx.coroutines.t3.a(r0) != r1) goto L22;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
                
                    return r1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
                
                    if (r8.T(r2, r0) == r1) goto L21;
                 */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.k.a.C0943a.C0944a.C0945a
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.internal.k$a$a$a$a r0 = (kotlinx.coroutines.flow.internal.k.a.C0943a.C0944a.C0945a) r0
                        int r1 = r0.f48979c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f48979c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.internal.k$a$a$a$a r0 = new kotlinx.coroutines.flow.internal.k$a$a$a$a
                        r0.<init>(r6, r8)
                    L18:
                        java.lang.Object r8 = r0.f48977a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.f48979c
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L38
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.g0.n(r8)
                        goto L56
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        kotlin.g0.n(r8)
                        goto L4d
                    L38:
                        kotlin.g0.n(r8)
                        kotlinx.coroutines.channels.j<kotlin.collections.a1<java.lang.Object>> r8 = r6.f48975a
                        kotlin.collections.a1 r2 = new kotlin.collections.a1
                        int r5 = r6.f48976b
                        r2.<init>(r5, r7)
                        r0.f48979c = r4
                        java.lang.Object r7 = r8.T(r2, r0)
                        if (r7 != r1) goto L4d
                        goto L55
                    L4d:
                        r0.f48979c = r3
                        java.lang.Object r7 = kotlinx.coroutines.t3.a(r0)
                        if (r7 != r1) goto L56
                    L55:
                        return r1
                    L56:
                        kotlin.n1 r7 = kotlin.n1.f44123a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.k.a.C0943a.C0944a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0943a(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, int i6, AtomicInteger atomicInteger, kotlinx.coroutines.channels.j<a1<Object>> jVar, kotlin.coroutines.e<? super C0943a> eVar) {
                super(2, eVar);
                this.f48971b = iVarArr;
                this.f48972c = i6;
                this.f48973d = atomicInteger;
                this.f48974e = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                return new C0943a(this.f48971b, this.f48972c, this.f48973d, this.f48974e, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((C0943a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                AtomicInteger atomicInteger;
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f48970a;
                try {
                    if (i6 != 0) {
                        if (i6 == 1) {
                            g0.n(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        g0.n(obj);
                        kotlinx.coroutines.flow.i[] iVarArr = this.f48971b;
                        int i7 = this.f48972c;
                        kotlinx.coroutines.flow.i iVar = iVarArr[i7];
                        C0944a c0944a = new C0944a(this.f48974e, i7);
                        this.f48970a = 1;
                        if (iVar.collect(c0944a, this) == l6) {
                            return l6;
                        }
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        c0.a.a(this.f48974e, null, 1, null);
                    }
                    return n1.f44123a;
                } finally {
                    if (this.f48973d.decrementAndGet() == 0) {
                        c0.a.a(this.f48974e, null, 1, null);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, Function0<T[]> function0, Function3<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, kotlinx.coroutines.flow.j<? super R> jVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48966g = iVarArr;
            this.f48967h = function0;
            this.f48968i = function3;
            this.f48969j = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f48966g, this.f48967h, this.f48968i, this.f48969j, eVar);
            aVar.f48965f = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0105, code lost:
        
            if (r10.invoke(r11, r9, r21) == r1) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0125, code lost:
        
            if (r11.invoke(r12, r10, r21) == r1) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0128, code lost:
        
            if (r6 != 0) goto L44;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00c0 A[LOOP:0: B:18:0x00c0->B:33:?, LOOP_START, PHI: r6 r10
  0x00c0: PHI (r6v4 int) = (r6v3 int), (r6v5 int) binds: [B:15:0x00bb, B:33:?] A[DONT_GENERATE, DONT_INLINE]
  0x00c0: PHI (r10v5 kotlin.collections.a1) = (r10v4 kotlin.collections.a1), (r10v12 kotlin.collections.a1) binds: [B:15:0x00bb, B:33:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0105 -> B:10:0x0128). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0125 -> B:10:0x0128). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.k.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n1#1,113:1\n87#2:114\n142#2:115\n*E\n"})
    public static final class b<R> implements kotlinx.coroutines.flow.i<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f48980a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f48981b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function3 f48982c;

        public b(kotlinx.coroutines.flow.i iVar, kotlinx.coroutines.flow.i iVar2, Function3 function3) {
            this.f48980a = iVar;
            this.f48981b = iVar2;
            this.f48982c = function3;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull kotlinx.coroutines.flow.j<? super R> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object g6 = s0.g(new c(jVar, this.f48980a, this.f48981b, this.f48982c, null), eVar);
            return g6 == kotlin.coroutines.intrinsics.a.l() ? g6 : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48983a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48984b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f48985c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T2> f48986d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T1> f48987e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function3<T1, T2, kotlin.coroutines.e<? super R>, Object> f48988f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a extends Lambda implements Function1<Throwable, n1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b0 f48989a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j<R> f48990b;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b0 b0Var, kotlinx.coroutines.flow.j<? super R> jVar) {
                super(1);
                this.f48989a = b0Var;
                this.f48990b = jVar;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                if (this.f48989a.isActive()) {
                    this.f48989a.b(new AbortFlowException(this.f48990b));
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<n1, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f48991a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T1> f48992b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlin.coroutines.i f48993c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Object f48994d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48995e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j<R> f48996f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Function3<T1, T2, kotlin.coroutines.e<? super R>, Object> f48997g;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static final class a<T> implements kotlinx.coroutines.flow.j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlin.coroutines.i f48998a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Object f48999b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f49000c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j<R> f49001d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Function3<T1, T2, kotlin.coroutines.e<? super R>, Object> f49002e;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {129, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA}, m = "invokeSuspend", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,143:1\n501#2,5:144\n18#3:149\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n129#1:144,5\n132#1:149\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.internal.k$c$b$a$a, reason: collision with other inner class name */
                static final class C0946a extends SuspendLambda implements Function2<n1, kotlin.coroutines.e<? super n1>, Object> {

                    /* renamed from: a, reason: collision with root package name */
                    Object f49003a;

                    /* renamed from: b, reason: collision with root package name */
                    int f49004b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f49005c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ kotlinx.coroutines.flow.j<R> f49006d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Function3<T1, T2, kotlin.coroutines.e<? super R>, Object> f49007e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ T1 f49008f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0946a(kotlinx.coroutines.channels.b0<? extends Object> b0Var, kotlinx.coroutines.flow.j<? super R> jVar, Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, T1 t12, kotlin.coroutines.e<? super C0946a> eVar) {
                        super(2, eVar);
                        this.f49005c = b0Var;
                        this.f49006d = jVar;
                        this.f49007e = function3;
                        this.f49008f = t12;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                        return new C0946a(this.f49005c, this.f49006d, this.f49007e, this.f49008f, eVar);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    /* renamed from: f, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(@NotNull n1 n1Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                        return ((C0946a) create(n1Var, eVar)).invokeSuspend(n1.f44123a);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:14:0x006c, code lost:
                    
                        if (r1.emit(r9, r8) == r0) goto L29;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
                    
                        return r0;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
                    
                        if (r9 == r0) goto L29;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:30:0x003b, code lost:
                    
                        if (r9 == r0) goto L29;
                     */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
                        /*
                            r8 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                            int r1 = r8.f49004b
                            r2 = 0
                            r3 = 3
                            r4 = 2
                            r5 = 1
                            if (r1 == 0) goto L30
                            if (r1 == r5) goto L26
                            if (r1 == r4) goto L1e
                            if (r1 != r3) goto L16
                            kotlin.g0.n(r9)
                            goto L6f
                        L16:
                            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r9.<init>(r0)
                            throw r9
                        L1e:
                            java.lang.Object r1 = r8.f49003a
                            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                            kotlin.g0.n(r9)
                            goto L64
                        L26:
                            kotlin.g0.n(r9)
                            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
                            java.lang.Object r9 = r9.o()
                            goto L3e
                        L30:
                            kotlin.g0.n(r9)
                            kotlinx.coroutines.channels.b0<java.lang.Object> r9 = r8.f49005c
                            r8.f49004b = r5
                            java.lang.Object r9 = r9.x(r8)
                            if (r9 != r0) goto L3e
                            goto L6e
                        L3e:
                            kotlinx.coroutines.flow.j<R> r1 = r8.f49006d
                            boolean r5 = r9 instanceof kotlinx.coroutines.channels.n.c
                            if (r5 == 0) goto L50
                            java.lang.Throwable r9 = kotlinx.coroutines.channels.n.f(r9)
                            if (r9 != 0) goto L4f
                            kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                            r9.<init>(r1)
                        L4f:
                            throw r9
                        L50:
                            kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.e<? super R>, java.lang.Object> r5 = r8.f49007e
                            T1 r6 = r8.f49008f
                            kotlinx.coroutines.internal.s0 r7 = kotlinx.coroutines.flow.internal.s.f49029a
                            if (r9 != r7) goto L59
                            r9 = r2
                        L59:
                            r8.f49003a = r1
                            r8.f49004b = r4
                            java.lang.Object r9 = r5.invoke(r6, r9, r8)
                            if (r9 != r0) goto L64
                            goto L6e
                        L64:
                            r8.f49003a = r2
                            r8.f49004b = r3
                            java.lang.Object r9 = r1.emit(r9, r8)
                            if (r9 != r0) goto L6f
                        L6e:
                            return r0
                        L6f:
                            kotlin.n1 r9 = kotlin.n1.f44123a
                            return r9
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.k.c.b.a.C0946a.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1", f = "Combine.kt", i = {}, l = {128}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.internal.k$c$b$a$b, reason: collision with other inner class name */
                static final class C0947b extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f49009a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ a<T> f49010b;

                    /* renamed from: c, reason: collision with root package name */
                    int f49011c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0947b(a<? super T> aVar, kotlin.coroutines.e<? super C0947b> eVar) {
                        super(eVar);
                        this.f49010b = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f49009a = obj;
                        this.f49011c |= Integer.MIN_VALUE;
                        return this.f49010b.emit(null, this);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                a(kotlin.coroutines.i iVar, Object obj, kotlinx.coroutines.channels.b0<? extends Object> b0Var, kotlinx.coroutines.flow.j<? super R> jVar, Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
                    this.f48998a = iVar;
                    this.f48999b = obj;
                    this.f49000c = b0Var;
                    this.f49001d = jVar;
                    this.f49002e = function3;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(T1 r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r13) {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof kotlinx.coroutines.flow.internal.k.c.b.a.C0947b
                        if (r0 == 0) goto L13
                        r0 = r13
                        kotlinx.coroutines.flow.internal.k$c$b$a$b r0 = (kotlinx.coroutines.flow.internal.k.c.b.a.C0947b) r0
                        int r1 = r0.f49011c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f49011c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.internal.k$c$b$a$b r0 = new kotlinx.coroutines.flow.internal.k$c$b$a$b
                        r0.<init>(r11, r13)
                    L18:
                        java.lang.Object r13 = r0.f49009a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.f49011c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.g0.n(r13)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L31:
                        kotlin.g0.n(r13)
                        kotlin.coroutines.i r13 = r11.f48998a
                        kotlin.n1 r2 = kotlin.n1.f44123a
                        java.lang.Object r4 = r11.f48999b
                        kotlinx.coroutines.flow.internal.k$c$b$a$a r5 = new kotlinx.coroutines.flow.internal.k$c$b$a$a
                        kotlinx.coroutines.channels.b0<java.lang.Object> r6 = r11.f49000c
                        kotlinx.coroutines.flow.j<R> r7 = r11.f49001d
                        kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.e<? super R>, java.lang.Object> r8 = r11.f49002e
                        r10 = 0
                        r9 = r12
                        r5.<init>(r6, r7, r8, r9, r10)
                        r0.f49011c = r3
                        java.lang.Object r12 = kotlinx.coroutines.flow.internal.e.c(r13, r2, r4, r5, r0)
                        if (r12 != r1) goto L50
                        return r1
                    L50:
                        kotlin.n1 r12 = kotlin.n1.f44123a
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.k.c.b.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(kotlinx.coroutines.flow.i<? extends T1> iVar, kotlin.coroutines.i iVar2, Object obj, kotlinx.coroutines.channels.b0<? extends Object> b0Var, kotlinx.coroutines.flow.j<? super R> jVar, Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f48992b = iVar;
                this.f48993c = iVar2;
                this.f48994d = obj;
                this.f48995e = b0Var;
                this.f48996f = jVar;
                this.f48997g = function3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                return new b(this.f48992b, this.f48993c, this.f48994d, this.f48995e, this.f48996f, this.f48997g, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull n1 n1Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(n1Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f48991a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    kotlinx.coroutines.flow.i<T1> iVar = this.f48992b;
                    a aVar = new a(this.f48993c, this.f48994d, this.f48995e, this.f48996f, this.f48997g);
                    this.f48991a = 1;
                    if (iVar.collect(aVar, this) == l6) {
                        return l6;
                    }
                }
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.internal.k$c$c, reason: collision with other inner class name */
        static final class C0948c extends SuspendLambda implements Function2<z<? super Object>, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49012a;

            /* renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f49013b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T2> f49014c;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: kotlinx.coroutines.flow.internal.k$c$c$a */
            static final class a<T> implements kotlinx.coroutines.flow.j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ z<Object> f49015a;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", f = "Combine.kt", i = {}, l = {90}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.internal.k$c$c$a$a, reason: collision with other inner class name */
                static final class C0949a extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f49016a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ a<T> f49017b;

                    /* renamed from: c, reason: collision with root package name */
                    int f49018c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0949a(a<? super T> aVar, kotlin.coroutines.e<? super C0949a> eVar) {
                        super(eVar);
                        this.f49017b = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f49016a = obj;
                        this.f49018c |= Integer.MIN_VALUE;
                        return this.f49017b.emit(null, this);
                    }
                }

                a(z<Object> zVar) {
                    this.f49015a = zVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(T2 r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.k.c.C0948c.a.C0949a
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.internal.k$c$c$a$a r0 = (kotlinx.coroutines.flow.internal.k.c.C0948c.a.C0949a) r0
                        int r1 = r0.f49018c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f49018c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.internal.k$c$c$a$a r0 = new kotlinx.coroutines.flow.internal.k$c$c$a$a
                        r0.<init>(r4, r6)
                    L18:
                        java.lang.Object r6 = r0.f49016a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.f49018c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.g0.n(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.g0.n(r6)
                        kotlinx.coroutines.channels.z<java.lang.Object> r6 = r4.f49015a
                        kotlinx.coroutines.channels.c0 r6 = r6.getChannel()
                        if (r5 != 0) goto L3e
                        kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
                    L3e:
                        r0.f49018c = r3
                        java.lang.Object r5 = r6.T(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.n1 r5 = kotlin.n1.f44123a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.k.c.C0948c.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(z<? super Object> zVar, kotlin.coroutines.e<? super n1> eVar) {
                return invoke2((z<Object>) zVar, eVar);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0948c(kotlinx.coroutines.flow.i<? extends T2> iVar, kotlin.coroutines.e<? super C0948c> eVar) {
                super(2, eVar);
                this.f49014c = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                C0948c c0948c = new C0948c(this.f49014c, eVar);
                c0948c.f49013b = obj;
                return c0948c;
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((C0948c) create(zVar, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49012a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    z zVar = (z) this.f49013b;
                    kotlinx.coroutines.flow.i<T2> iVar = this.f49014c;
                    a aVar = new a(zVar);
                    this.f49012a = 1;
                    if (iVar.collect(aVar, this) == l6) {
                        return l6;
                    }
                }
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(kotlinx.coroutines.flow.j<? super R> jVar, kotlinx.coroutines.flow.i<? extends T2> iVar, kotlinx.coroutines.flow.i<? extends T1> iVar2, Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f48985c = jVar;
            this.f48986d = iVar;
            this.f48987e = iVar2;
            this.f48988f = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            c cVar = new c(this.f48985c, this.f48986d, this.f48987e, this.f48988f, eVar);
            cVar.f48984b = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlinx.coroutines.channels.b0 b0Var;
            b0 c6;
            kotlin.coroutines.i plus;
            kotlinx.coroutines.channels.b0 b0Var2;
            n1 n1Var;
            b bVar;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48983a;
            try {
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b0Var = (kotlinx.coroutines.channels.b0) this.f48984b;
                    try {
                        g0.n(obj);
                    } catch (AbortFlowException e6) {
                        e = e6;
                    }
                    b0.a.b(b0Var, null, 1, null);
                    return n1.f44123a;
                }
                g0.n(obj);
                r0 r0Var = (r0) this.f48984b;
                b0Var = kotlinx.coroutines.channels.x.f(r0Var, null, 0, new C0948c(this.f48986d, null), 3, null);
                c6 = j2.c(null, 1, null);
                kotlin.jvm.internal.g0.n(b0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                ((c0) b0Var).q(new a(c6, this.f48985c));
                try {
                    kotlin.coroutines.i coroutineContext = r0Var.getCoroutineContext();
                    Object b6 = y0.b(coroutineContext);
                    plus = r0Var.getCoroutineContext().plus(c6);
                    try {
                        n1Var = n1.f44123a;
                        bVar = new b(this.f48987e, coroutineContext, b6, b0Var, this.f48985c, this.f48988f, null);
                        b0Var2 = b0Var;
                    } catch (AbortFlowException e7) {
                        e = e7;
                        b0Var2 = b0Var;
                    } catch (Throwable th) {
                        th = th;
                        b0Var2 = b0Var;
                    }
                } catch (AbortFlowException e8) {
                    e = e8;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    this.f48984b = b0Var2;
                    this.f48983a = 1;
                } catch (AbortFlowException e9) {
                    e = e9;
                    b0Var = b0Var2;
                    o.b(e, this.f48985c);
                    b0.a.b(b0Var, null, 1, null);
                    return n1.f44123a;
                } catch (Throwable th3) {
                    th = th3;
                    b0Var = b0Var2;
                    b0.a.b(b0Var, null, 1, null);
                    throw th;
                }
                if (e.d(plus, n1Var, null, bVar, this, 4, null) == l6) {
                    return l6;
                }
                b0Var = b0Var2;
                b0.a.b(b0Var, null, 1, null);
                return n1.f44123a;
                o.b(e, this.f48985c);
                b0.a.b(b0Var, null, 1, null);
                return n1.f44123a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    @PublishedApi
    @Nullable
    public static final <R, T> Object a(@NotNull kotlinx.coroutines.flow.j<? super R> jVar, @NotNull kotlinx.coroutines.flow.i<? extends T>[] iVarArr, @NotNull Function0<T[]> function0, @NotNull Function3<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object a6 = n.a(new a(iVarArr, function0, function3, jVar, null), eVar);
        return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
    }

    @NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> b(@NotNull kotlinx.coroutines.flow.i<? extends T1> iVar, @NotNull kotlinx.coroutines.flow.i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return new b(iVar2, iVar, function3);
    }
}
