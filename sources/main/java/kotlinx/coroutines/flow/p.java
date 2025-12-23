package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends Lambda implements Function1<T, Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f49084a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j6) {
            super(1);
            this.f49084a = j6;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke(T t5) {
            return Long.valueOf(this.f49084a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends Lambda implements Function1<T, Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<T, kotlin.time.h> f49085a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super T, kotlin.time.h> function1) {
            super(1);
            this.f49085a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke(T t5) {
            return Long.valueOf(a1.e(this.f49085a.invoke(t5).o0()));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, org.apache.commons.net.ftp.l.f50699z}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n18#2:416\n18#2:418\n1#3:417\n55#4,8:419\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n218#1:416\n221#1:418\n228#1:419,8\n*E\n"})
    static final class c<T> extends SuspendLambda implements Function3<r0, j<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f49086a;

        /* renamed from: b, reason: collision with root package name */
        Object f49087b;

        /* renamed from: c, reason: collision with root package name */
        int f49088c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f49089d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f49090e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<T, Long> f49091f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ i<T> f49092g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n18#2:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n*L\n232#1:416\n*E\n"})
        static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49093a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ j<T> f49094b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Object> f49095c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(j<? super T> jVar, Ref.ObjectRef<Object> objectRef, kotlin.coroutines.e<? super a> eVar) {
                super(1, eVar);
                this.f49094b = jVar;
                this.f49095c = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@NotNull kotlin.coroutines.e<?> eVar) {
                return new a(this.f49094b, this.f49095c, eVar);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49093a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    j<T> jVar = this.f49094b;
                    s0 s0Var = kotlinx.coroutines.flow.internal.s.f49029a;
                    T t5 = this.f49095c.element;
                    if (t5 == s0Var) {
                        t5 = null;
                    }
                    this.f49093a = 1;
                    if (jVar.emit(t5, this) == l6) {
                        return l6;
                    }
                }
                this.f49095c.element = null;
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
        @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:428\n1#3:426\n18#4:427\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n238#1:416,6\n239#1:422,4\n239#1:428\n242#1:427\n*E\n"})
        static final class b extends SuspendLambda implements Function2<kotlinx.coroutines.channels.n<? extends Object>, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            Object f49096a;

            /* renamed from: b, reason: collision with root package name */
            int f49097b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f49098c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Object> f49099d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ j<T> f49100e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(Ref.ObjectRef<Object> objectRef, j<? super T> jVar, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f49099d = objectRef;
                this.f49100e = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                b bVar = new b(this.f49099d, this.f49100e, eVar);
                bVar.f49098c = obj;
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.n<? extends Object> nVar, kotlin.coroutines.e<? super n1> eVar) {
                return f(nVar.o(), eVar);
            }

            @Nullable
            public final Object f(@NotNull Object obj, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(kotlinx.coroutines.channels.n.b(obj), eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Ref.ObjectRef<Object> objectRef;
                Ref.ObjectRef<Object> objectRef2;
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49097b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        objectRef2 = (Ref.ObjectRef) this.f49096a;
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    T t5 = (T) ((kotlinx.coroutines.channels.n) this.f49098c).o();
                    objectRef = this.f49099d;
                    boolean z5 = t5 instanceof n.c;
                    if (!z5) {
                        objectRef.element = t5;
                    }
                    j<T> jVar = this.f49100e;
                    if (z5) {
                        Throwable f6 = kotlinx.coroutines.channels.n.f(t5);
                        if (f6 == null) {
                            Object obj2 = objectRef.element;
                            if (obj2 != null) {
                                if (obj2 == kotlinx.coroutines.flow.internal.s.f49029a) {
                                    obj2 = null;
                                }
                                this.f49098c = t5;
                                this.f49096a = objectRef;
                                this.f49097b = 1;
                                if (jVar.emit(obj2, this) == l6) {
                                    return l6;
                                }
                                objectRef2 = objectRef;
                            }
                            objectRef.element = (T) kotlinx.coroutines.flow.internal.s.f49031c;
                        } else {
                            throw f6;
                        }
                    }
                    return n1.f44123a;
                }
                objectRef = objectRef2;
                objectRef.element = (T) kotlinx.coroutines.flow.internal.s.f49031c;
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.p$c$c, reason: collision with other inner class name */
        static final class C0950c extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super Object>, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49101a;

            /* renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f49102b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T> f49103c;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: kotlinx.coroutines.flow.p$c$c$a */
            static final class a<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.z<Object> f49104a;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1", f = "Delay.kt", i = {}, l = {210}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.p$c$c$a$a, reason: collision with other inner class name */
                static final class C0951a extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f49105a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ a<T> f49106b;

                    /* renamed from: c, reason: collision with root package name */
                    int f49107c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0951a(a<? super T> aVar, kotlin.coroutines.e<? super C0951a> eVar) {
                        super(eVar);
                        this.f49106b = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f49105a = obj;
                        this.f49107c |= Integer.MIN_VALUE;
                        return this.f49106b.emit(null, this);
                    }
                }

                a(kotlinx.coroutines.channels.z<Object> zVar) {
                    this.f49104a = zVar;
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
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.p.c.C0950c.a.C0951a
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.p$c$c$a$a r0 = (kotlinx.coroutines.flow.p.c.C0950c.a.C0951a) r0
                        int r1 = r0.f49107c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f49107c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.p$c$c$a$a r0 = new kotlinx.coroutines.flow.p$c$c$a$a
                        r0.<init>(r4, r6)
                    L18:
                        java.lang.Object r6 = r0.f49105a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.f49107c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.g0.n(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.g0.n(r6)
                        kotlinx.coroutines.channels.z<java.lang.Object> r6 = r4.f49104a
                        if (r5 != 0) goto L3a
                        kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
                    L3a:
                        r0.f49107c = r3
                        java.lang.Object r5 = r6.T(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.n1 r5 = kotlin.n1.f44123a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.p.c.C0950c.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.z<? super Object> zVar, kotlin.coroutines.e<? super n1> eVar) {
                return invoke2((kotlinx.coroutines.channels.z<Object>) zVar, eVar);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0950c(i<? extends T> iVar, kotlin.coroutines.e<? super C0950c> eVar) {
                super(2, eVar);
                this.f49103c = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                C0950c c0950c = new C0950c(this.f49103c, eVar);
                c0950c.f49102b = obj;
                return c0950c;
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((C0950c) create(zVar, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49101a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    kotlinx.coroutines.channels.z zVar = (kotlinx.coroutines.channels.z) this.f49102b;
                    i<T> iVar = this.f49103c;
                    a aVar = new a(zVar);
                    this.f49101a = 1;
                    if (iVar.collect(aVar, this) == l6) {
                        return l6;
                    }
                }
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super T, Long> function1, i<? extends T> iVar, kotlin.coroutines.e<? super c> eVar) {
            super(3, eVar);
            this.f49091f = function1;
            this.f49092g = iVar;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull r0 r0Var, @NotNull j<? super T> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            c cVar = new c(this.f49091f, this.f49092g, eVar);
            cVar.f49089d = r0Var;
            cVar.f49090e = jVar;
            return cVar.invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x009f, code lost:
        
            if (r7.emit(r15, r14) == r0) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00e4, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00e2, code lost:
        
            if (r7.y(r14) != r0) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e2 -> B:6:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 232
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.p.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class d extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super n1>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49108a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f49109b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f49110c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f49111d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j6, long j7, kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
            this.f49110c = j6;
            this.f49111d = j7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            d dVar = new d(this.f49110c, this.f49111d, eVar);
            dVar.f49109b = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super n1> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
        
            if (kotlinx.coroutines.a1.b(r4, r7) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        
            if (r8.T(r4, r7) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        
            if (kotlinx.coroutines.a1.b(r5, r7) == r0) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005a -> B:12:0x003f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r7.f49108a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L22
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                java.lang.Object r1 = r7.f49109b
                kotlinx.coroutines.channels.z r1 = (kotlinx.coroutines.channels.z) r1
                kotlin.g0.n(r8)
                goto L50
            L22:
                java.lang.Object r1 = r7.f49109b
                kotlinx.coroutines.channels.z r1 = (kotlinx.coroutines.channels.z) r1
                kotlin.g0.n(r8)
                goto L3f
            L2a:
                kotlin.g0.n(r8)
                java.lang.Object r8 = r7.f49109b
                r1 = r8
                kotlinx.coroutines.channels.z r1 = (kotlinx.coroutines.channels.z) r1
                long r5 = r7.f49110c
                r7.f49109b = r1
                r7.f49108a = r4
                java.lang.Object r8 = kotlinx.coroutines.a1.b(r5, r7)
                if (r8 != r0) goto L3f
                goto L5c
            L3f:
                kotlinx.coroutines.channels.c0 r8 = r1.getChannel()
                kotlin.n1 r4 = kotlin.n1.f44123a
                r7.f49109b = r1
                r7.f49108a = r3
                java.lang.Object r8 = r8.T(r4, r7)
                if (r8 != r0) goto L50
                goto L5c
            L50:
                long r4 = r7.f49111d
                r7.f49109b = r1
                r7.f49108a = r2
                java.lang.Object r8 = kotlinx.coroutines.a1.b(r4, r7)
                if (r8 != r0) goto L3f
            L5c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.p.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {org.apache.commons.net.nntp.h.f50927z}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
    @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n55#2,8:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n284#1:416,8\n*E\n"})
    static final class e<T> extends SuspendLambda implements Function3<r0, j<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f49112a;

        /* renamed from: b, reason: collision with root package name */
        Object f49113b;

        /* renamed from: c, reason: collision with root package name */
        int f49114c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f49115d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f49116e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f49117f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ i<T> f49118g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:427\n1#3:426\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n287#1:416,6\n288#1:422,4\n288#1:427\n*E\n"})
        static final class a extends SuspendLambda implements Function2<kotlinx.coroutines.channels.n<? extends Object>, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49119a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f49120b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Object> f49121c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.b0<n1> f49122d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Ref.ObjectRef<Object> objectRef, kotlinx.coroutines.channels.b0<n1> b0Var, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f49121c = objectRef;
                this.f49122d = b0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                a aVar = new a(this.f49121c, this.f49122d, eVar);
                aVar.f49120b = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.n<? extends Object> nVar, kotlin.coroutines.e<? super n1> eVar) {
                return f(nVar.o(), eVar);
            }

            @Nullable
            public final Object f(@NotNull Object obj, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(kotlinx.coroutines.channels.n.b(obj), eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f49119a == 0) {
                    kotlin.g0.n(obj);
                    T t5 = (T) ((kotlinx.coroutines.channels.n) this.f49120b).o();
                    Ref.ObjectRef<Object> objectRef = this.f49121c;
                    boolean z5 = t5 instanceof n.c;
                    if (!z5) {
                        objectRef.element = t5;
                    }
                    kotlinx.coroutines.channels.b0<n1> b0Var = this.f49122d;
                    if (z5) {
                        Throwable f6 = kotlinx.coroutines.channels.n.f(t5);
                        if (f6 == null) {
                            b0Var.b(new ChildCancelledException());
                            objectRef.element = (T) kotlinx.coroutines.flow.internal.s.f49031c;
                        } else {
                            throw f6;
                        }
                    }
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME}, m = "invokeSuspend", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n18#2:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n*L\n299#1:416\n*E\n"})
        static final class b extends SuspendLambda implements Function2<n1, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49123a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<Object> f49124b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j<T> f49125c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(Ref.ObjectRef<Object> objectRef, j<? super T> jVar, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f49124b = objectRef;
                this.f49125c = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                return new b(this.f49124b, this.f49125c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull n1 n1Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(n1Var, eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49123a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    Ref.ObjectRef<Object> objectRef = this.f49124b;
                    Object obj2 = objectRef.element;
                    if (obj2 == null) {
                        return n1.f44123a;
                    }
                    objectRef.element = null;
                    j<T> jVar = this.f49125c;
                    if (obj2 == kotlinx.coroutines.flow.internal.s.f49029a) {
                        obj2 = null;
                    }
                    this.f49123a = 1;
                    if (jVar.emit(obj2, this) == l6) {
                        return l6;
                    }
                }
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS}, m = "invokeSuspend", n = {}, s = {})
        static final class c extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super Object>, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49126a;

            /* renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f49127b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T> f49128c;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            static final class a<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.z<Object> f49129a;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1", f = "Delay.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.p$e$c$a$a, reason: collision with other inner class name */
                static final class C0952a extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f49130a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ a<T> f49131b;

                    /* renamed from: c, reason: collision with root package name */
                    int f49132c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0952a(a<? super T> aVar, kotlin.coroutines.e<? super C0952a> eVar) {
                        super(eVar);
                        this.f49131b = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f49130a = obj;
                        this.f49132c |= Integer.MIN_VALUE;
                        return this.f49131b.emit(null, this);
                    }
                }

                a(kotlinx.coroutines.channels.z<Object> zVar) {
                    this.f49129a = zVar;
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
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.p.e.c.a.C0952a
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.p$e$c$a$a r0 = (kotlinx.coroutines.flow.p.e.c.a.C0952a) r0
                        int r1 = r0.f49132c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f49132c = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.p$e$c$a$a r0 = new kotlinx.coroutines.flow.p$e$c$a$a
                        r0.<init>(r4, r6)
                    L18:
                        java.lang.Object r6 = r0.f49130a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.f49132c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.g0.n(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.g0.n(r6)
                        kotlinx.coroutines.channels.z<java.lang.Object> r6 = r4.f49129a
                        if (r5 != 0) goto L3a
                        kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
                    L3a:
                        r0.f49132c = r3
                        java.lang.Object r5 = r6.T(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.n1 r5 = kotlin.n1.f44123a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.p.e.c.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.z<? super Object> zVar, kotlin.coroutines.e<? super n1> eVar) {
                return invoke2((kotlinx.coroutines.channels.z<Object>) zVar, eVar);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(i<? extends T> iVar, kotlin.coroutines.e<? super c> eVar) {
                super(2, eVar);
                this.f49128c = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                c cVar = new c(this.f49128c, eVar);
                cVar.f49127b = obj;
                return cVar;
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((c) create(zVar, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49126a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    kotlinx.coroutines.channels.z zVar = (kotlinx.coroutines.channels.z) this.f49127b;
                    i<T> iVar = this.f49128c;
                    a aVar = new a(zVar);
                    this.f49126a = 1;
                    if (iVar.collect(aVar, this) == l6) {
                        return l6;
                    }
                }
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(long j6, i<? extends T> iVar, kotlin.coroutines.e<? super e> eVar) {
            super(3, eVar);
            this.f49117f = j6;
            this.f49118g = iVar;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull r0 r0Var, @NotNull j<? super T> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            e eVar2 = new e(this.f49117f, this.f49118g, eVar);
            eVar2.f49115d = r0Var;
            eVar2.f49116e = jVar;
            return eVar2.invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            j jVar;
            kotlinx.coroutines.channels.b0 b0Var;
            kotlinx.coroutines.channels.b0 g6;
            Ref.ObjectRef objectRef;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f49114c;
            if (i6 != 0) {
                if (i6 == 1) {
                    g6 = (kotlinx.coroutines.channels.b0) this.f49113b;
                    objectRef = (Ref.ObjectRef) this.f49112a;
                    b0Var = (kotlinx.coroutines.channels.b0) this.f49116e;
                    jVar = (j) this.f49115d;
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                r0 r0Var = (r0) this.f49115d;
                j jVar2 = (j) this.f49116e;
                kotlinx.coroutines.channels.b0 f6 = kotlinx.coroutines.channels.x.f(r0Var, null, -1, new c(this.f49118g, null), 1, null);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                jVar = jVar2;
                b0Var = f6;
                g6 = p.g(r0Var, this.f49117f, 0L, 2, null);
                objectRef = objectRef2;
            }
            while (objectRef.element != kotlinx.coroutines.flow.internal.s.f49031c) {
                kotlinx.coroutines.selects.l lVar = new kotlinx.coroutines.selects.l(getContext());
                lVar.k(b0Var.t(), new a(objectRef, g6, null));
                lVar.k(g6.N(), new b(objectRef, jVar, null));
                this.f49115d = jVar;
                this.f49116e = b0Var;
                this.f49112a = objectRef;
                this.f49113b = g6;
                this.f49114c = 1;
                if (lVar.y(this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {424}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n31#2:416\n32#2:425\n55#3,8:417\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n401#1:416\n401#1:425\n401#1:417,8\n*E\n"})
    static final class f<T> extends SuspendLambda implements Function3<r0, j<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        long f49133a;

        /* renamed from: b, reason: collision with root package name */
        int f49134b;

        /* renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f49135c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f49136d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f49137e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i<T> f49138f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {404}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
        @SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,415:1\n514#2,6:416\n548#2,5:422\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n403#1:416,6\n405#1:422,5\n*E\n"})
        static final class a extends SuspendLambda implements Function2<kotlinx.coroutines.channels.n<? extends T>, kotlin.coroutines.e<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49139a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f49140b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ j<T> f49141c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(j<? super T> jVar, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f49141c = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                a aVar = new a(this.f49141c, eVar);
                aVar.f49140b = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, kotlin.coroutines.e<? super Boolean> eVar) {
                return f(((kotlinx.coroutines.channels.n) obj).o(), eVar);
            }

            @Nullable
            public final Object f(@NotNull Object obj, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
                return ((a) create(kotlinx.coroutines.channels.n.b(obj), eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                    int r1 = r4.f49139a
                    r2 = 1
                    if (r1 == 0) goto L19
                    if (r1 != r2) goto L11
                    java.lang.Object r0 = r4.f49140b
                    kotlin.g0.n(r5)
                    goto L36
                L11:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L19:
                    kotlin.g0.n(r5)
                    java.lang.Object r5 = r4.f49140b
                    kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
                    java.lang.Object r5 = r5.o()
                    kotlinx.coroutines.flow.j<T> r1 = r4.f49141c
                    boolean r3 = r5 instanceof kotlinx.coroutines.channels.n.c
                    if (r3 != 0) goto L37
                    r4.f49140b = r5
                    r4.f49139a = r2
                    java.lang.Object r1 = r1.emit(r5, r4)
                    if (r1 != r0) goto L35
                    return r0
                L35:
                    r0 = r5
                L36:
                    r5 = r0
                L37:
                    boolean r0 = r5 instanceof kotlinx.coroutines.channels.n.a
                    if (r0 == 0) goto L45
                    kotlinx.coroutines.channels.n.f(r5)
                    r5 = 0
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
                    return r5
                L45:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r2)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.p.f.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<?>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49142a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f49143b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(long j6, kotlin.coroutines.e<? super b> eVar) {
                super(1, eVar);
                this.f49143b = j6;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@NotNull kotlin.coroutines.e<?> eVar) {
                return new b(this.f49143b, eVar);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Object invoke(@Nullable kotlin.coroutines.e<?> eVar) {
                return ((b) create(eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f49142a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.g0.n(obj);
                throw new TimeoutCancellationException("Timed out waiting for " + ((Object) kotlin.time.h.j0(this.f49143b)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(long j6, i<? extends T> iVar, kotlin.coroutines.e<? super f> eVar) {
            super(3, eVar);
            this.f49137e = j6;
            this.f49138f = iVar;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull r0 r0Var, @NotNull j<? super T> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            f fVar = new f(this.f49137e, this.f49138f, eVar);
            fVar.f49135c = r0Var;
            fVar.f49136d = jVar;
            return fVar.invokeSuspend(n1.f44123a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0076 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0074 -> B:5:0x0077). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r9.f49134b
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L22
                if (r1 != r2) goto L1a
                long r4 = r9.f49133a
                java.lang.Object r1 = r9.f49136d
                kotlinx.coroutines.channels.b0 r1 = (kotlinx.coroutines.channels.b0) r1
                java.lang.Object r6 = r9.f49135c
                kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) r6
                kotlin.g0.n(r10)
                goto L77
            L1a:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L22:
                kotlin.g0.n(r10)
                java.lang.Object r10 = r9.f49135c
                kotlinx.coroutines.r0 r10 = (kotlinx.coroutines.r0) r10
                java.lang.Object r1 = r9.f49136d
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                long r4 = r9.f49137e
                kotlin.time.h$a r6 = kotlin.time.h.f48019b
                long r6 = r6.T()
                int r4 = kotlin.time.h.k(r4, r6)
                if (r4 <= 0) goto L82
                kotlinx.coroutines.flow.i<T> r4 = r9.f49138f
                r5 = 0
                r6 = 2
                kotlinx.coroutines.flow.i r4 = kotlinx.coroutines.flow.k.q(r4, r5, r3, r6, r3)
                kotlinx.coroutines.channels.b0 r10 = kotlinx.coroutines.flow.k.o1(r4, r10)
                long r4 = r9.f49137e
                r6 = r1
                r1 = r10
            L4b:
                kotlinx.coroutines.selects.l r10 = new kotlinx.coroutines.selects.l
                kotlin.coroutines.i r7 = r9.getContext()
                r10.<init>(r7)
                kotlinx.coroutines.selects.g r7 = r1.t()
                kotlinx.coroutines.flow.p$f$a r8 = new kotlinx.coroutines.flow.p$f$a
                r8.<init>(r6, r3)
                r10.k(r7, r8)
                kotlinx.coroutines.flow.p$f$b r7 = new kotlinx.coroutines.flow.p$f$b
                r7.<init>(r4, r3)
                kotlinx.coroutines.selects.b.b(r10, r4, r7)
                r9.f49135c = r6
                r9.f49136d = r1
                r9.f49133a = r4
                r9.f49134b = r2
                java.lang.Object r10 = r10.y(r9)
                if (r10 != r0) goto L77
                return r0
            L77:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 != 0) goto L4b
                kotlin.n1 r10 = kotlin.n1.f44123a
                return r10
            L82:
                kotlinx.coroutines.TimeoutCancellationException r10 = new kotlinx.coroutines.TimeoutCancellationException
                java.lang.String r0 = "Timed out immediately"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.p.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    @NotNull
    public static final <T> i<T> a(@NotNull i<? extends T> iVar, long j6) {
        if (j6 >= 0) {
            return j6 == 0 ? iVar : e(iVar, new a(j6));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T> i<T> d(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, kotlin.time.h> function1) {
        return e(iVar, new b(function1));
    }

    private static final <T> i<T> e(i<? extends T> iVar, Function1<? super T, Long> function1) {
        return kotlinx.coroutines.flow.internal.n.b(new c(function1, iVar, null));
    }

    @NotNull
    public static final kotlinx.coroutines.channels.b0<n1> f(@NotNull r0 r0Var, long j6, long j7) {
        if (j6 < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j6 + " ms").toString());
        }
        if (j7 >= 0) {
            return kotlinx.coroutines.channels.x.f(r0Var, null, 0, new d(j7, j6, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j7 + " ms").toString());
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 g(r0 r0Var, long j6, long j7, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j7 = j6;
        }
        return k.y0(r0Var, j6, j7);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> h(@NotNull i<? extends T> iVar, long j6) {
        if (j6 > 0) {
            return kotlinx.coroutines.flow.internal.n.b(new e(j6, iVar, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    private static final <T> i<T> k(i<? extends T> iVar, long j6) {
        return kotlinx.coroutines.flow.internal.n.b(new f(j6, iVar, null));
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> i<T> b(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, Long> function1) {
        return e(iVar, function1);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> c(@NotNull i<? extends T> iVar, long j6) {
        return k.a0(iVar, a1.e(j6));
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> i(@NotNull i<? extends T> iVar, long j6) {
        return k.B1(iVar, a1.e(j6));
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> j(@NotNull i<? extends T> iVar, long j6) {
        return k(iVar, j6);
    }
}
