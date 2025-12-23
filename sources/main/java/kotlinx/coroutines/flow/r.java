package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class r {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, org.apache.commons.net.ftp.l.f50687n}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49148a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0 f49149b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T> f49150c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s<T> f49151d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ T f49152e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.r$a$a, reason: collision with other inner class name */
        static final class C0953a extends SuspendLambda implements Function2<Integer, kotlin.coroutines.e<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49153a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ int f49154b;

            C0953a(kotlin.coroutines.e<? super C0953a> eVar) {
                super(2, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                C0953a c0953a = new C0953a(eVar);
                c0953a.f49154b = ((Number) obj).intValue();
                return c0953a;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Integer num, kotlin.coroutines.e<? super Boolean> eVar) {
                return f(num.intValue(), eVar);
            }

            @Nullable
            public final Object f(int i6, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
                return ((C0953a) create(Integer.valueOf(i6), eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                boolean z5;
                kotlin.coroutines.intrinsics.a.l();
                if (this.f49153a == 0) {
                    kotlin.g0.n(obj);
                    if (this.f49154b > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    return kotlin.coroutines.jvm.internal.a.a(z5);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {org.apache.commons.net.ftp.l.f50689p}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<SharingCommand, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f49155a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f49156b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T> f49157c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ s<T> f49158d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ T f49159e;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: kotlinx.coroutines.flow.r$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0954a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f49160a;

                static {
                    int[] iArr = new int[SharingCommand.values().length];
                    try {
                        iArr[SharingCommand.START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SharingCommand.STOP.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f49160a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(i<? extends T> iVar, s<T> sVar, T t5, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f49157c = iVar;
                this.f49158d = sVar;
                this.f49159e = t5;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                b bVar = new b(this.f49157c, this.f49158d, this.f49159e, eVar);
                bVar.f49156b = obj;
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull SharingCommand sharingCommand, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(sharingCommand, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f49155a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    int i7 = C0954a.f49160a[((SharingCommand) this.f49156b).ordinal()];
                    if (i7 != 1) {
                        if (i7 == 3) {
                            T t5 = this.f49159e;
                            if (t5 == z.f49193a) {
                                this.f49158d.b();
                            } else {
                                this.f49158d.c(t5);
                            }
                        }
                    } else {
                        i<T> iVar = this.f49157c;
                        j jVar = this.f49158d;
                        this.f49155a = 1;
                        if (iVar.collect(jVar, this) == l6) {
                            return l6;
                        }
                    }
                }
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(c0 c0Var, i<? extends T> iVar, s<T> sVar, T t5, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f49149b = c0Var;
            this.f49150c = iVar;
            this.f49151d = sVar;
            this.f49152e = t5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f49149b, this.f49150c, this.f49151d, this.f49152e, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
        
            if (r8.collect(r1, r7) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        
            if (r8.collect(r1, r7) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        
            if (kotlinx.coroutines.flow.k.v0(r8, r1, r7) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
        
            if (kotlinx.coroutines.flow.k.A(r8, r1, r7) == r0) goto L28;
         */
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
                int r1 = r7.f49148a
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L25
                if (r1 == r5) goto L21
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L21
                if (r1 != r2) goto L15
                goto L21
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                kotlin.g0.n(r8)
                goto L5c
            L21:
                kotlin.g0.n(r8)
                goto L8d
            L25:
                kotlin.g0.n(r8)
                kotlinx.coroutines.flow.c0 r8 = r7.f49149b
                kotlinx.coroutines.flow.c0$a r1 = kotlinx.coroutines.flow.c0.f48851a
                kotlinx.coroutines.flow.c0 r6 = r1.c()
                if (r8 != r6) goto L3f
                kotlinx.coroutines.flow.i<T> r8 = r7.f49150c
                kotlinx.coroutines.flow.s<T> r1 = r7.f49151d
                r7.f49148a = r5
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L8d
                goto L8c
            L3f:
                kotlinx.coroutines.flow.c0 r8 = r7.f49149b
                kotlinx.coroutines.flow.c0 r1 = r1.d()
                r5 = 0
                if (r8 != r1) goto L69
                kotlinx.coroutines.flow.s<T> r8 = r7.f49151d
                kotlinx.coroutines.flow.h0 r8 = r8.d()
                kotlinx.coroutines.flow.r$a$a r1 = new kotlinx.coroutines.flow.r$a$a
                r1.<init>(r5)
                r7.f49148a = r4
                java.lang.Object r8 = kotlinx.coroutines.flow.k.v0(r8, r1, r7)
                if (r8 != r0) goto L5c
                goto L8c
            L5c:
                kotlinx.coroutines.flow.i<T> r8 = r7.f49150c
                kotlinx.coroutines.flow.s<T> r1 = r7.f49151d
                r7.f49148a = r3
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L8d
                goto L8c
            L69:
                kotlinx.coroutines.flow.c0 r8 = r7.f49149b
                kotlinx.coroutines.flow.s<T> r1 = r7.f49151d
                kotlinx.coroutines.flow.h0 r1 = r1.d()
                kotlinx.coroutines.flow.i r8 = r8.a(r1)
                kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.g0(r8)
                kotlinx.coroutines.flow.r$a$b r1 = new kotlinx.coroutines.flow.r$a$b
                kotlinx.coroutines.flow.i<T> r3 = r7.f49150c
                kotlinx.coroutines.flow.s<T> r4 = r7.f49151d
                T r6 = r7.f49152e
                r1.<init>(r3, r4, r6, r5)
                r7.f49148a = r2
                java.lang.Object r8 = kotlinx.coroutines.flow.k.A(r8, r1, r7)
                if (r8 != r0) goto L8d
            L8c:
                return r0
            L8d:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.r.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49161a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f49162b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T> f49163c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.y<h0<T>> f49164d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
        static final class a<T> implements j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<t<T>> f49165a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ r0 f49166b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.y<h0<T>> f49167c;

            a(Ref.ObjectRef<t<T>> objectRef, r0 r0Var, kotlinx.coroutines.y<h0<T>> yVar) {
                this.f49165a = objectRef;
                this.f49166b = r0Var;
                this.f49167c = yVar;
            }

            /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.h0, kotlinx.coroutines.flow.t] */
            @Override // kotlinx.coroutines.flow.j
            @Nullable
            public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
                n1 n1Var;
                t<T> tVar = this.f49165a.element;
                if (tVar != null) {
                    tVar.setValue(t5);
                    n1Var = n1.f44123a;
                } else {
                    n1Var = null;
                }
                if (n1Var == null) {
                    r0 r0Var = this.f49166b;
                    Ref.ObjectRef<t<T>> objectRef = this.f49165a;
                    kotlinx.coroutines.y<h0<T>> yVar = this.f49167c;
                    ?? r42 = (T) j0.a(t5);
                    yVar.p(new v(r42, h2.B(r0Var.getCoroutineContext())));
                    objectRef.element = r42;
                }
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(i<? extends T> iVar, kotlinx.coroutines.y<h0<T>> yVar, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f49163c = iVar;
            this.f49164d = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            b bVar = new b(this.f49163c, this.f49164d, eVar);
            bVar.f49162b = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f49161a;
            try {
                if (i6 != 0) {
                    if (i6 == 1) {
                        kotlin.g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    kotlin.g0.n(obj);
                    r0 r0Var = (r0) this.f49162b;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    i<T> iVar = this.f49163c;
                    a aVar = new a(objectRef, r0Var, this.f49164d);
                    this.f49161a = 1;
                    if (iVar.collect(aVar, this) == l6) {
                        return l6;
                    }
                }
                return n1.f44123a;
            } catch (Throwable th) {
                this.f49164d.c(th);
                throw th;
            }
        }
    }

    @Nullable
    public static final <T> Object i(@NotNull i<? extends T> iVar, @NotNull r0 r0Var, @NotNull kotlin.coroutines.e<? super h0<? extends T>> eVar) {
        b0 c6 = c(iVar, 1);
        kotlinx.coroutines.y c7 = kotlinx.coroutines.a0.c(null, 1, null);
        e(r0Var, c6.f48850d, c6.f48847a, c7);
        return c7.f(eVar);
    }

    @NotNull
    public static final <T> h0<T> j(@NotNull i<? extends T> iVar, @NotNull r0 r0Var, @NotNull c0 c0Var, T t5) {
        b0 c6 = c(iVar, 1);
        t a6 = j0.a(t5);
        return new v(a6, d(r0Var, c6.f48850d, c6.f48847a, a6, c0Var, t5));
    }

    @NotNull
    public static final <T> x<T> a(@NotNull s<T> sVar) {
        return new u(sVar, null);
    }

    @NotNull
    public static final <T> h0<T> b(@NotNull t<T> tVar) {
        return new v(tVar, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r3 == 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> kotlinx.coroutines.flow.b0<T> c(kotlinx.coroutines.flow.i<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.j$b r0 = kotlinx.coroutines.channels.j.f48222t0
            int r0 = r0.a()
            int r0 = kotlin.ranges.t.u(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.d
            if (r1 == 0) goto L3c
            r1 = r7
            kotlinx.coroutines.flow.internal.d r1 = (kotlinx.coroutines.flow.internal.d) r1
            kotlinx.coroutines.flow.i r2 = r1.j()
            if (r2 == 0) goto L3c
            kotlinx.coroutines.flow.b0 r7 = new kotlinx.coroutines.flow.b0
            int r3 = r1.f48909b
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f48910c
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = 0
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f48910c
            kotlin.coroutines.i r1 = r1.f48908a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            kotlinx.coroutines.flow.b0 r8 = new kotlinx.coroutines.flow.b0
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.r.c(kotlinx.coroutines.flow.i, int):kotlinx.coroutines.flow.b0");
    }

    private static final <T> e2 d(r0 r0Var, kotlin.coroutines.i iVar, i<? extends T> iVar2, s<T> sVar, c0 c0Var, T t5) {
        return kotlinx.coroutines.i.d(r0Var, iVar, kotlin.jvm.internal.g0.g(c0Var, c0.f48851a.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new a(c0Var, iVar2, sVar, t5, null));
    }

    private static final <T> void e(r0 r0Var, kotlin.coroutines.i iVar, i<? extends T> iVar2, kotlinx.coroutines.y<h0<T>> yVar) {
        kotlinx.coroutines.k.f(r0Var, iVar, null, new b(iVar2, yVar, null), 2, null);
    }

    @NotNull
    public static final <T> x<T> f(@NotNull x<? extends T> xVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new m0(xVar, function2);
    }

    public static /* synthetic */ x h(i iVar, r0 r0Var, c0 c0Var, int i6, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return k.G1(iVar, r0Var, c0Var, i6);
    }

    @NotNull
    public static final <T> x<T> g(@NotNull i<? extends T> iVar, @NotNull r0 r0Var, @NotNull c0 c0Var, int i6) {
        b0 c6 = c(iVar, i6);
        s a6 = z.a(i6, c6.f48848b, c6.f48849c);
        return new u(a6, d(r0Var, c6.f48850d, c6.f48847a, a6, c0Var, z.f49193a));
    }
}
