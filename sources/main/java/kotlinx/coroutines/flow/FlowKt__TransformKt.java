package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.BuilderInference;
import kotlin.collections.a1;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,136:1\n21#1:143\n23#1:147\n21#1:148\n23#1:152\n50#2:137\n55#2:139\n50#2:140\n55#2:142\n50#2:144\n55#2:146\n50#2:149\n55#2:151\n50#2:153\n55#2:155\n50#2:156\n55#2:158\n50#2:159\n55#2:161\n50#2:163\n55#2:165\n107#3:138\n107#3:141\n107#3:145\n107#3:150\n107#3:154\n107#3:157\n107#3:160\n107#3:162\n107#3:164\n107#3:166\n107#3:167\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n36#1:143\n36#1:147\n41#1:148\n41#1:152\n21#1:137\n21#1:139\n28#1:140\n28#1:142\n36#1:144\n36#1:146\n41#1:149\n41#1:151\n46#1:153\n46#1:155\n53#1:156\n53#1:158\n60#1:159\n60#1:161\n78#1:163\n78#1:165\n21#1:138\n28#1:141\n36#1:145\n41#1:150\n46#1:154\n53#1:157\n60#1:160\n68#1:162\n78#1:164\n105#1:166\n125#1:167\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__TransformKt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<R> f48792a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<R, T, kotlin.coroutines.e<? super R>, Object> f48793b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<R> f48794c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", i = {0}, l = {109, 110}, m = "emit", n = {"this"}, s = {"L$0"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$a$a, reason: collision with other inner class name */
        static final class C0934a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48795a;

            /* renamed from: b, reason: collision with root package name */
            Object f48796b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f48797c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a<T> f48798d;

            /* renamed from: e, reason: collision with root package name */
            int f48799e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0934a(a<? super T> aVar, kotlin.coroutines.e<? super C0934a> eVar) {
                super(eVar);
                this.f48798d = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48797c = obj;
                this.f48799e |= Integer.MIN_VALUE;
                return this.f48798d.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, j<? super R> jVar) {
            this.f48792a = objectRef;
            this.f48793b = function3;
            this.f48794c = jVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
        
            if (r7.emit(r8, r0) != r1) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
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
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt.a.C0934a
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.FlowKt__TransformKt$a$a r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt.a.C0934a) r0
                int r1 = r0.f48799e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48799e = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$a$a r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$a$a
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f48797c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48799e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.g0.n(r8)
                goto L70
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f48796b
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                java.lang.Object r2 = r0.f48795a
                kotlinx.coroutines.flow.FlowKt__TransformKt$a r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt.a) r2
                kotlin.g0.n(r8)
                goto L5a
            L40:
                kotlin.g0.n(r8)
                kotlin.jvm.internal.Ref$ObjectRef<R> r8 = r6.f48792a
                kotlin.jvm.functions.Function3<R, T, kotlin.coroutines.e<? super R>, java.lang.Object> r2 = r6.f48793b
                T r5 = r8.element
                r0.f48795a = r6
                r0.f48796b = r8
                r0.f48799e = r4
                java.lang.Object r7 = r2.invoke(r5, r7, r0)
                if (r7 != r1) goto L56
                goto L6f
            L56:
                r2 = r8
                r8 = r7
                r7 = r2
                r2 = r6
            L5a:
                r7.element = r8
                kotlinx.coroutines.flow.j<R> r7 = r2.f48794c
                kotlin.jvm.internal.Ref$ObjectRef<R> r8 = r2.f48792a
                T r8 = r8.element
                r2 = 0
                r0.f48795a = r2
                r0.f48796b = r2
                r0.f48799e = r3
                java.lang.Object r7 = r7.emit(r8, r0)
                if (r7 != r1) goto L70
            L6f:
                return r1
            L70:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n126#2,10:114\n*E\n"})
    public static final class b<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f48800a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f48801b;

        public b(i iVar, Function3 function3) {
            this.f48800a = iVar;
            this.f48801b = function3;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) kotlinx.coroutines.flow.internal.s.f49029a;
            Object collect = this.f48800a.collect(new c(objectRef, this.f48801b, jVar), eVar);
            return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f48802a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<T, T, kotlin.coroutines.e<? super T>, Object> f48803b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f48804c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", f = "Transform.kt", i = {0}, l = {131, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48805a;

            /* renamed from: b, reason: collision with root package name */
            Object f48806b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f48807c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c<T> f48808d;

            /* renamed from: e, reason: collision with root package name */
            int f48809e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48808d = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48807c = obj;
                this.f48809e |= Integer.MIN_VALUE;
                return this.f48808d.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super kotlin.coroutines.e<? super T>, ? extends Object> function3, j<? super T> jVar) {
            this.f48802a = objectRef;
            this.f48803b = function3;
            this.f48804c = jVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
        
            if (r8.emit(r9, r0) == r1) goto L26;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt.c.a
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.FlowKt__TransformKt$c$a r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt.c.a) r0
                int r1 = r0.f48809e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48809e = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$c$a r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$c$a
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f48807c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48809e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.g0.n(r9)
                goto L79
            L2c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L34:
                java.lang.Object r8 = r0.f48806b
                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
                java.lang.Object r2 = r0.f48805a
                kotlinx.coroutines.flow.FlowKt__TransformKt$c r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt.c) r2
                kotlin.g0.n(r9)
                goto L60
            L40:
                kotlin.g0.n(r9)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r7.f48802a
                T r2 = r9.element
                kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
                if (r2 != r5) goto L4d
                r2 = r7
                goto L63
            L4d:
                kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.e<? super T>, java.lang.Object> r5 = r7.f48803b
                r0.f48805a = r7
                r0.f48806b = r9
                r0.f48809e = r4
                java.lang.Object r8 = r5.invoke(r2, r8, r0)
                if (r8 != r1) goto L5c
                goto L78
            L5c:
                r2 = r9
                r9 = r8
                r8 = r2
                r2 = r7
            L60:
                r6 = r9
                r9 = r8
                r8 = r6
            L63:
                r9.element = r8
                kotlinx.coroutines.flow.j<T> r8 = r2.f48804c
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r2.f48802a
                T r9 = r9.element
                r2 = 0
                r0.f48805a = r2
                r0.f48806b = r2
                r0.f48809e = r3
                java.lang.Object r8 = r8.emit(r9, r0)
                if (r8 != r1) goto L79
            L78:
                return r1
            L79:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt.c.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n69#2,5:114\n*E\n"})
    public static final class d<T> implements i<a1<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f48810a;

        public d(i iVar) {
            this.f48810a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super a1<? extends T>> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object collect = this.f48810a.collect(new e(jVar, new Ref.IntRef()), eVar);
            return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$1$1\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,136:1\n32#2,4:137\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$1$1\n*L\n71#1:137,4\n*E\n"})
    static final class e<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<a1<? extends T>> f48811a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f48812b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1", f = "Transform.kt", i = {}, l = {71}, m = "emit", n = {}, s = {})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48813a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ e<T> f48814b;

            /* renamed from: c, reason: collision with root package name */
            int f48815c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(e<? super T> eVar, kotlin.coroutines.e<? super a> eVar2) {
                super(eVar2);
                this.f48814b = eVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48813a = obj;
                this.f48815c |= Integer.MIN_VALUE;
                return this.f48814b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(j<? super a1<? extends T>> jVar, Ref.IntRef intRef) {
            this.f48811a = jVar;
            this.f48812b = intRef;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt.e.a
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.FlowKt__TransformKt$e$a r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt.e.a) r0
                int r1 = r0.f48815c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48815c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$e$a r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$e$a
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f48813a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48815c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r9)
                goto L4e
            L29:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L31:
                kotlin.g0.n(r9)
                kotlinx.coroutines.flow.j<kotlin.collections.a1<? extends T>> r9 = r7.f48811a
                kotlin.collections.a1 r2 = new kotlin.collections.a1
                kotlin.jvm.internal.Ref$IntRef r4 = r7.f48812b
                int r5 = r4.element
                int r6 = r5 + 1
                r4.element = r6
                if (r5 < 0) goto L51
                r2.<init>(r5, r8)
                r0.f48815c = r3
                java.lang.Object r8 = r9.emit(r2, r0)
                if (r8 != r1) goto L4e
                return r1
            L4e:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            L51:
                java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
                java.lang.String r9 = "Index overflow has happened"
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt.e.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    @NotNull
    public static final <T> i<T> a(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(iVar, function2);
    }

    @NotNull
    public static final <R> i<R> c(@NotNull final i<?> iVar, @NotNull final kotlin.reflect.d<R> dVar) {
        return (i<R>) new i<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n41#2:224\n23#2:225\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ j f48769a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ kotlin.reflect.d f48770b;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(j jVar, kotlin.reflect.d dVar) {
                    this.f48769a = jVar;
                    this.f48770b = dVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
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
                        kotlinx.coroutines.flow.j r6 = r4.f48769a
                        kotlin.reflect.d r2 = r4.f48770b
                        boolean r2 = r2.C(r5)
                        if (r2 == 0) goto L47
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.n1 r5 = kotlin.n1.f44123a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j<? super Object> jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = i.this.collect(new AnonymousClass2(jVar, dVar), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        };
    }

    @NotNull
    public static final <T> i<T> d(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> e(@NotNull final i<? extends T> iVar) {
        return new i<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n47#2,2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ j f48776a;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(j jVar) {
                    this.f48776a = jVar;
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
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.g0.n(r6)
                        goto L41
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.g0.n(r6)
                        kotlinx.coroutines.flow.j r6 = r4.f48776a
                        if (r5 == 0) goto L41
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L41
                        return r1
                    L41:
                        kotlin.n1 r5 = kotlin.n1.f44123a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = i.this.collect(new AnonymousClass2(jVar), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        };
    }

    @NotNull
    public static final <T, R> i<R> f(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(iVar, function2);
    }

    @NotNull
    public static final <T, R> i<R> g(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> h(@NotNull final i<? extends T> iVar, @NotNull final Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new i<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n79#2,2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ j f48787a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function2 f48788b;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 224}, m = "emit", n = {"value", "$this$onEach_u24lambda_u248"}, s = {"L$0", "L$1"})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.e eVar) {
                        super(eVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(j jVar, Function2 function2) {
                    this.f48787a = jVar;
                    this.f48788b = function2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
                
                    if (r6.emit(r2, r0) != r1) goto L23;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
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
                        boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3e
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.g0.n(r7)
                        goto L6a
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        java.lang.Object r6 = r0.L$1
                        kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) r6
                        java.lang.Object r2 = r0.L$0
                        kotlin.g0.n(r7)
                        goto L5c
                    L3e:
                        kotlin.g0.n(r7)
                        kotlinx.coroutines.flow.j r7 = r5.f48787a
                        kotlin.jvm.functions.Function2 r2 = r5.f48788b
                        r0.L$0 = r6
                        r0.L$1 = r7
                        r0.label = r4
                        r4 = 6
                        kotlin.jvm.internal.d0.e(r4)
                        java.lang.Object r2 = r2.invoke(r6, r0)
                        r4 = 7
                        kotlin.jvm.internal.d0.e(r4)
                        if (r2 != r1) goto L5a
                        goto L69
                    L5a:
                        r2 = r6
                        r6 = r7
                    L5c:
                        r7 = 0
                        r0.L$0 = r7
                        r0.L$1 = r7
                        r0.label = r3
                        java.lang.Object r6 = r6.emit(r2, r0)
                        if (r6 != r1) goto L6a
                    L69:
                        return r1
                    L6a:
                        kotlin.n1 r6 = kotlin.n1.f44123a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = i.this.collect(new AnonymousClass2(jVar, function2), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        };
    }

    @NotNull
    public static final <T, R> i<R> i(@NotNull i<? extends T> iVar, R r5, @BuilderInference @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(r5, iVar, function3);
    }

    @NotNull
    public static final <T> i<T> j(@NotNull i<? extends T> iVar, @NotNull Function3<? super T, ? super T, ? super kotlin.coroutines.e<? super T>, ? extends Object> function3) {
        return new b(iVar, function3);
    }

    @NotNull
    public static final <T> i<a1<T>> l(@NotNull i<? extends T> iVar) {
        return new d(iVar);
    }

    public static final /* synthetic */ <R> i<R> b(i<?> iVar) {
        kotlin.jvm.internal.g0.w();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(iVar);
    }

    @NotNull
    public static final <T, R> i<R> k(@NotNull i<? extends T> iVar, R r5, @BuilderInference @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return k.z1(iVar, r5, function3);
    }
}
