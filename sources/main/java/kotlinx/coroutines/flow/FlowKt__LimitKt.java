package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.BuilderInference;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n107#3:143\n107#3:144\n107#3:145\n107#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n22#1:143\n33#1:144\n52#1:145\n83#1:146\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__LimitKt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$1\n*L\n1#1,141:1\n*E\n"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48644a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48645b;

        /* renamed from: c, reason: collision with root package name */
        int f48646c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48645b = obj;
            this.f48646c |= Integer.MIN_VALUE;
            return FlowKt__LimitKt.b(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n23#2,5:114\n*E\n"})
    public static final class b<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f48647a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f48648b;

        public b(i iVar, int i6) {
            this.f48647a = iVar;
            this.f48648b = i6;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object collect = this.f48647a.collect(new c(new Ref.IntRef(), this.f48648b, jVar), eVar);
            return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f48649a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f48650b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f48651c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", f = "Limit.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48652a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c<T> f48653b;

            /* renamed from: c, reason: collision with root package name */
            int f48654c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48653b = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48652a = obj;
                this.f48654c |= Integer.MIN_VALUE;
                return this.f48653b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(Ref.IntRef intRef, int i6, j<? super T> jVar) {
            this.f48649a = intRef;
            this.f48650b = i6;
            this.f48651c = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.c.a
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__LimitKt$c$a r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt.c.a) r0
                int r1 = r0.f48654c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48654c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__LimitKt$c$a r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$c$a
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f48652a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48654c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r7)
                goto L47
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                kotlin.g0.n(r7)
                kotlin.jvm.internal.Ref$IntRef r7 = r5.f48649a
                int r2 = r7.element
                int r4 = r5.f48650b
                if (r2 < r4) goto L4a
                kotlinx.coroutines.flow.j<T> r7 = r5.f48651c
                r0.f48654c = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L47
                return r1
            L47:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            L4a:
                int r2 = r2 + r3
                r7.element = r2
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.c.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n34#2,10:114\n*E\n"})
    public static final class d<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f48656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f48657b;

        public d(i iVar, Function2 function2) {
            this.f48656a = iVar;
            this.f48657b = function2;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object collect = this.f48656a.collect(new e(new Ref.BooleanRef(), jVar, this.f48657b), eVar);
            return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f48658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<T> f48659b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<T, kotlin.coroutines.e<? super Boolean>, Object> f48660c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", i = {1, 1}, l = {37, 38, 40}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48661a;

            /* renamed from: b, reason: collision with root package name */
            Object f48662b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f48663c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e<T> f48664d;

            /* renamed from: e, reason: collision with root package name */
            int f48665e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(e<? super T> eVar, kotlin.coroutines.e<? super a> eVar2) {
                super(eVar2);
                this.f48664d = eVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48663c = obj;
                this.f48665e |= Integer.MIN_VALUE;
                return this.f48664d.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(Ref.BooleanRef booleanRef, j<? super T> jVar, Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
            this.f48658a = booleanRef;
            this.f48659b = jVar;
            this.f48660c = function2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        
            if (r8.emit(r7, r0) == r1) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        
            if (r8.emit(r7, r0) == r1) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.e.a
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.FlowKt__LimitKt$e$a r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt.e.a) r0
                int r1 = r0.f48665e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48665e = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__LimitKt$e$a r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$e$a
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f48663c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48665e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                kotlin.g0.n(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.f48662b
                java.lang.Object r2 = r0.f48661a
                kotlinx.coroutines.flow.FlowKt__LimitKt$e r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt.e) r2
                kotlin.g0.n(r8)
                goto L6c
            L41:
                kotlin.g0.n(r8)
                goto L59
            L45:
                kotlin.g0.n(r8)
                kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f48658a
                boolean r8 = r8.element
                if (r8 == 0) goto L5c
                kotlinx.coroutines.flow.j<T> r8 = r6.f48659b
                r0.f48665e = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L59
                goto L87
            L59:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            L5c:
                kotlin.jvm.functions.Function2<T, kotlin.coroutines.e<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f48660c
                r0.f48661a = r6
                r0.f48662b = r7
                r0.f48665e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                goto L87
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f48658a
                r8.element = r5
                kotlinx.coroutines.flow.j<T> r8 = r2.f48659b
                r2 = 0
                r0.f48661a = r2
                r0.f48662b = r2
                r0.f48665e = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L88
            L87:
                return r1
            L88:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            L8b:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.e.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {73}, m = "emitAbort$FlowKt__LimitKt", n = {"$this$emitAbort"}, s = {"L$0"})
    static final class f<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48666a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48667b;

        /* renamed from: c, reason: collision with root package name */
        int f48668c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48667b = obj;
            this.f48668c |= Integer.MIN_VALUE;
            return FlowKt__LimitKt.f(null, null, this);
        }

        f(kotlin.coroutines.e<? super f> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f48669a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f48670b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f48671c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", i = {}, l = {61, 63}, m = "emit", n = {}, s = {})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48672a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ g<T> f48673b;

            /* renamed from: c, reason: collision with root package name */
            int f48674c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(g<? super T> gVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48673b = gVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48672a = obj;
                this.f48674c |= Integer.MIN_VALUE;
                return this.f48673b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        g(Ref.IntRef intRef, int i6, j<? super T> jVar) {
            this.f48669a = intRef;
            this.f48670b = i6;
            this.f48671c = jVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        
            if (r7.emit(r6, r0) == r1) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt__LimitKt.f(r7, r6, r0) == r1) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.g.a
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__LimitKt$g$a r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt.g.a) r0
                int r1 = r0.f48674c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48674c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__LimitKt$g$a r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$g$a
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f48672a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48674c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L38
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.g0.n(r7)
                goto L5f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                kotlin.g0.n(r7)
                goto L51
            L38:
                kotlin.g0.n(r7)
                kotlin.jvm.internal.Ref$IntRef r7 = r5.f48669a
                int r2 = r7.element
                int r2 = r2 + r4
                r7.element = r2
                int r7 = r5.f48670b
                if (r2 >= r7) goto L54
                kotlinx.coroutines.flow.j<T> r7 = r5.f48671c
                r0.f48674c = r4
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L51
                goto L5e
            L51:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            L54:
                kotlinx.coroutines.flow.j<T> r7 = r5.f48671c
                r0.f48674c = r3
                java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt__LimitKt.a(r7, r6, r0)
                if (r6 != r1) goto L5f
            L5e:
                return r1
            L5f:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.g.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.e<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$a r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt.a) r0
            int r1 = r0.f48646c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48646c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$a r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48645b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48646c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f48644a
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r4 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r4
            kotlin.g0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L4c
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.g0.n(r6)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r6 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r6.<init>(r5)
            r0.f48644a = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            r0.f48646c = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            java.lang.Object r4 = r4.collect(r6, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4a
            if (r4 != r1) goto L4f
            return r1
        L4a:
            r5 = move-exception
            r4 = r6
        L4c:
            kotlinx.coroutines.flow.internal.o.b(r5, r4)
        L4f:
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.b(kotlinx.coroutines.flow.i, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    private static final <T> Object c(i<? extends T> iVar, Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, kotlin.coroutines.e<? super n1> eVar) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(function2);
        try {
            kotlin.jvm.internal.d0.e(0);
            iVar.collect(flowKt__LimitKt$collectWhile$collector$1, eVar);
            kotlin.jvm.internal.d0.e(1);
        } catch (AbortFlowException e6) {
            kotlinx.coroutines.flow.internal.o.b(e6, flowKt__LimitKt$collectWhile$collector$1);
        }
        return n1.f44123a;
    }

    @NotNull
    public static final <T> i<T> d(@NotNull i<? extends T> iVar, int i6) {
        if (i6 >= 0) {
            return new b(iVar, i6);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i6).toString());
    }

    @NotNull
    public static final <T> i<T> e(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return new d(iVar, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object f(kotlinx.coroutines.flow.j<? super T> r4, T r5, kotlin.coroutines.e<? super kotlin.n1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.f
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$f r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt.f) r0
            int r1 = r0.f48668c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48668c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$f r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48667b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48668c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f48666a
            kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) r4
            kotlin.g0.n(r6)
            goto L43
        L35:
            kotlin.g0.n(r6)
            r0.f48666a = r4
            r0.f48668c = r3
            java.lang.Object r5 = r4.emit(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.f(kotlinx.coroutines.flow.j, java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }

    @NotNull
    public static final <T> i<T> g(@NotNull i<? extends T> iVar, int i6) {
        if (i6 > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(iVar, i6);
        }
        throw new IllegalArgumentException(("Requested element count " + i6 + " should be positive").toString());
    }

    @NotNull
    public static final <T> i<T> h(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(iVar, function2);
    }

    @NotNull
    public static final <T, R> i<R> i(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function3) {
        return k.J0(new FlowKt__LimitKt$transformWhile$1(iVar, function3, null));
    }
}
