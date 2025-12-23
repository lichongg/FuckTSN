package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,224:1\n107#2:225\n107#2:227\n1#3:226\n163#4:228\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n58#1:225\n132#1:227\n221#1:228\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__ErrorsKt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0}, l = {156}, m = "catchImpl", n = {"fromDownstream"}, s = {"L$0"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48621a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48622b;

        /* renamed from: c, reason: collision with root package name */
        int f48623c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48622b = obj;
            this.f48623c |= Integer.MIN_VALUE;
            return k.v(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f48624a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Throwable> f48625b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", i = {0}, l = {158}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48626a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f48627b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ b<T> f48628c;

            /* renamed from: d, reason: collision with root package name */
            int f48629d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48628c = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48627b = obj;
                this.f48629d |= Integer.MIN_VALUE;
                return this.f48628c.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(j<? super T> jVar, Ref.ObjectRef<Throwable> objectRef) {
            this.f48624a = jVar;
            this.f48625b = objectRef;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
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
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.b.a
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$b$a r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.b.a) r0
                int r1 = r0.f48629d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48629d = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$b$a r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$b$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f48627b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48629d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f48626a
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$b r5 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.b) r5
                kotlin.g0.n(r6)     // Catch: java.lang.Throwable -> L2d
                goto L47
            L2d:
                r6 = move-exception
                goto L4c
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L37:
                kotlin.g0.n(r6)
                kotlinx.coroutines.flow.j<T> r6 = r4.f48624a     // Catch: java.lang.Throwable -> L4a
                r0.f48626a = r4     // Catch: java.lang.Throwable -> L4a
                r0.f48629d = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                kotlin.n1 r5 = kotlin.n1.f44123a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Throwable> r5 = r5.f48625b
                r5.element = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.b.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<Throwable, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48630a;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull Throwable th, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
            return ((c) create(th, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f48630a == 0) {
                kotlin.g0.n(obj);
                return kotlin.coroutines.jvm.internal.a.a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class d<T> extends SuspendLambda implements Function4<j<? super T>, Throwable, Long, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48631a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48632b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ long f48633c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f48634d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Throwable, kotlin.coroutines.e<? super Boolean>, Object> f48635e;

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Long l6, kotlin.coroutines.e<? super Boolean> eVar) {
            return f((j) obj, th, l6.longValue(), eVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(long j6, Function2<? super Throwable, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, kotlin.coroutines.e<? super d> eVar) {
            super(4, eVar);
            this.f48634d = j6;
            this.f48635e = function2;
        }

        @Nullable
        public final Object f(@NotNull j<? super T> jVar, @NotNull Throwable th, long j6, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
            d dVar = new d(this.f48634d, this.f48635e, eVar);
            dVar.f48632b = th;
            dVar.f48633c = j6;
            return dVar.invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
        
            if (((java.lang.Boolean) r8).booleanValue() != false) goto L17;
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
                int r1 = r7.f48631a
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.g0.n(r8)
                goto L31
            Lf:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L17:
                kotlin.g0.n(r8)
                java.lang.Object r8 = r7.f48632b
                java.lang.Throwable r8 = (java.lang.Throwable) r8
                long r3 = r7.f48633c
                long r5 = r7.f48634d
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L3a
                kotlin.jvm.functions.Function2<java.lang.Throwable, kotlin.coroutines.e<? super java.lang.Boolean>, java.lang.Object> r1 = r7.f48635e
                r7.f48631a = r2
                java.lang.Object r8 = r1.invoke(r8, r7)
                if (r8 != r0) goto L31
                return r0
            L31:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L3a
                goto L3b
            L3a:
                r2 = 0
            L3b:
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.a.a(r2)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @NotNull
    public static final <T> i<T> a(@NotNull i<? extends T> iVar, @NotNull Function3<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(iVar, function3);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.lang.Throwable> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$a r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.a) r0
            int r1 = r0.f48623c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48623c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$a r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48622b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48623c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f48621a
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.g0.n(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.g0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$b r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$b     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.f48621a = r6     // Catch: java.lang.Throwable -> L51
            r0.f48623c = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            T r4 = r4.element
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            kotlin.coroutines.i r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            kotlin.l.a(r4, r5)
            throw r4
        L72:
            kotlin.l.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.b(kotlinx.coroutines.flow.i, kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }

    private static final boolean c(Throwable th, kotlin.coroutines.i iVar) {
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var == null || !e2Var.isCancelled()) {
            return false;
        }
        return d(th, e2Var.H());
    }

    private static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && kotlin.jvm.internal.g0.g(th2, th);
    }

    @NotNull
    public static final <T> i<T> e(@NotNull i<? extends T> iVar, long j6, @NotNull Function2<? super Throwable, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        if (j6 > 0) {
            return k.y1(iVar, new d(j6, function2, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j6).toString());
    }

    public static /* synthetic */ i f(i iVar, long j6, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = Long.MAX_VALUE;
        }
        if ((i6 & 2) != 0) {
            function2 = new c(null);
        }
        return k.w1(iVar, j6, function2);
    }

    @NotNull
    public static final <T> i<T> g(@NotNull i<? extends T> iVar, @NotNull Function4<? super j<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(iVar, function4);
    }
}
