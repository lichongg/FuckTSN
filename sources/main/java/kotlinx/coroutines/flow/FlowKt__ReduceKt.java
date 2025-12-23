package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,172:1\n126#2,15:173\n126#2,15:188\n126#2,15:203\n126#2,15:218\n126#2,15:233\n*S KotlinDebug\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n72#1:173,15\n92#1:188,15\n106#1:203,15\n124#1:218,15\n137#1:233,15\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n93#2,2:142\n*E\n"})
    public static final class a<T> implements kotlinx.coroutines.flow.j<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f48711a;

        public a(Ref.ObjectRef objectRef) {
            this.f48711a = objectRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f48711a.element = t5;
            throw new AbortFlowException(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "first", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class b<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48712a;

        /* renamed from: b, reason: collision with root package name */
        Object f48713b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48714c;

        /* renamed from: d, reason: collision with root package name */
        int f48715d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48714c = obj;
            this.f48715d |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.u0(null, this);
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {183}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class c<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48716a;

        /* renamed from: b, reason: collision with root package name */
        Object f48717b;

        /* renamed from: c, reason: collision with root package name */
        Object f48718c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48719d;

        /* renamed from: e, reason: collision with root package name */
        int f48720e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48719d = obj;
            this.f48720e |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.v0(null, null, this);
        }

        c(kotlin.coroutines.e<? super c> eVar) {
            super(eVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n125#2,2:142\n*E\n"})
    public static final class d<T> implements kotlinx.coroutines.flow.j<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f48721a;

        public d(Ref.ObjectRef objectRef) {
            this.f48721a = objectRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f48721a.element = t5;
            throw new AbortFlowException(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class e<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48722a;

        /* renamed from: b, reason: collision with root package name */
        Object f48723b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48724c;

        /* renamed from: d, reason: collision with root package name */
        int f48725d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48724c = obj;
            this.f48725d |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.w0(null, this);
        }

        e(kotlin.coroutines.e<? super e> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class f<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48726a;

        /* renamed from: b, reason: collision with root package name */
        Object f48727b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48728c;

        /* renamed from: d, reason: collision with root package name */
        int f48729d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48728c = obj;
            this.f48729d |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.x0(null, null, this);
        }

        f(kotlin.coroutines.e<? super f> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = "fold", n = {"accumulator"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$1\n*L\n1#1,172:1\n*E\n"})
    static final class g<T, R> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48732a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48733b;

        /* renamed from: c, reason: collision with root package name */
        int f48734c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48733b = obj;
            this.f48734c |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.e(null, null, null, this);
        }

        g(kotlin.coroutines.e<? super g> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {155}, m = "last", n = {"result"}, s = {"L$0"})
    static final class h<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48735a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48736b;

        /* renamed from: c, reason: collision with root package name */
        int f48737c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48736b = obj;
            this.f48737c |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.T0(null, this);
        }

        h(kotlin.coroutines.e<? super h> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i<T> implements kotlinx.coroutines.flow.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f48738a;

        i(Ref.ObjectRef<Object> objectRef) {
            this.f48738a = objectRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f48738a.element = t5;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {167}, m = "lastOrNull", n = {"result"}, s = {"L$0"})
    static final class j<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48739a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48740b;

        /* renamed from: c, reason: collision with root package name */
        int f48741c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48740b = obj;
            this.f48741c |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.U0(null, this);
        }

        j(kotlin.coroutines.e<? super j> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class k<T> implements kotlinx.coroutines.flow.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<T> f48742a;

        k(Ref.ObjectRef<T> objectRef) {
            this.f48742a = objectRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f48742a.element = t5;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
    static final class l<S, T extends S> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48743a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48744b;

        /* renamed from: c, reason: collision with root package name */
        int f48745c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48744b = obj;
            this.f48745c |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.t1(null, null, this);
        }

        l(kotlin.coroutines.e<? super l> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class m<T> implements kotlinx.coroutines.flow.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f48746a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<S, T, kotlin.coroutines.e<? super S>, Object> f48747b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2", f = "Reduce.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48748a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f48749b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ m<T> f48750c;

            /* renamed from: d, reason: collision with root package name */
            int f48751d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(m<? super T> mVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48750c = mVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48749b = obj;
                this.f48751d |= Integer.MIN_VALUE;
                return this.f48750c.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        m(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super kotlin.coroutines.e<? super S>, ? extends Object> function3) {
            this.f48746a = objectRef;
            this.f48747b = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.m.a
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.FlowKt__ReduceKt$m$a r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.m.a) r0
                int r1 = r0.f48751d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48751d = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__ReduceKt$m$a r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$m$a
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f48749b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48751d
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r7 = r0.f48748a
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                kotlin.g0.n(r8)
                goto L50
            L2d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L35:
                kotlin.g0.n(r8)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r8 = r6.f48746a
                T r2 = r8.element
                kotlinx.coroutines.internal.s0 r4 = kotlinx.coroutines.flow.internal.s.f49029a
                if (r2 == r4) goto L53
                kotlin.jvm.functions.Function3<S, T, kotlin.coroutines.e<? super S>, java.lang.Object> r4 = r6.f48747b
                r0.f48748a = r8
                r0.f48751d = r3
                java.lang.Object r7 = r4.invoke(r2, r7, r0)
                if (r7 != r1) goto L4d
                return r1
            L4d:
                r5 = r8
                r8 = r7
                r7 = r5
            L50:
                r5 = r8
                r8 = r7
                r7 = r5
            L53:
                r8.element = r7
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.m.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {57}, m = "single", n = {"result"}, s = {"L$0"})
    static final class n<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48752a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48753b;

        /* renamed from: c, reason: collision with root package name */
        int f48754c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48753b = obj;
            this.f48754c |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.I1(null, this);
        }

        n(kotlin.coroutines.e<? super n> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$single$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
    static final class o<T> implements kotlinx.coroutines.flow.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f48755a;

        o(Ref.ObjectRef<Object> objectRef) {
            this.f48755a = objectRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Ref.ObjectRef<Object> objectRef = this.f48755a;
            if (objectRef.element != kotlinx.coroutines.flow.internal.s.f49029a) {
                throw new IllegalArgumentException("Flow has more than one element");
            }
            objectRef.element = t5;
            return n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n74#2,7:142\n*E\n"})
    public static final class p<T> implements kotlinx.coroutines.flow.j<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f48756a;

        public p(Ref.ObjectRef objectRef) {
            this.f48756a = objectRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Ref.ObjectRef objectRef = this.f48756a;
            T t6 = objectRef.element;
            T t7 = (T) kotlinx.coroutines.flow.internal.s.f49029a;
            if (t6 == t7) {
                objectRef.element = t5;
                return n1.f44123a;
            }
            objectRef.element = t7;
            throw new AbortFlowException(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class q<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48757a;

        /* renamed from: b, reason: collision with root package name */
        Object f48758b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48759c;

        /* renamed from: d, reason: collision with root package name */
        int f48760d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48759c = obj;
            this.f48760d |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.J1(null, this);
        }

        q(kotlin.coroutines.e<? super q> eVar) {
            super(eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.b) r0
            int r1 = r0.f48715d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48715d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$b r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48714c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48715d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f48713b
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.a) r4
            java.lang.Object r0 = r0.f48712a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.g0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.flow.internal.s.f49029a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r5)
            r0.f48712a = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.f48713b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.f48715d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            kotlinx.coroutines.flow.internal.o.b(r5, r4)
        L62:
            T r4 = r0.element
            kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.e<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.c
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.c) r0
            int r1 = r0.f48720e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48720e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$c r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48719d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48720e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.f48718c
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.f48717b
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r0 = r0.f48716a
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlin.g0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L35
            goto L6a
        L35:
            r6 = move-exception
            goto L67
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.g0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.flow.internal.s.f49029a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f48716a = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L62
            r0.f48717b = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L62
            r0.f48718c = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L62
            r0.f48720e = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L62
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L62
            if (r4 != r1) goto L5f
            return r1
        L5f:
            r0 = r5
            r5 = r6
            goto L6a
        L62:
            r4 = move-exception
            r0 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L67:
            kotlinx.coroutines.flow.internal.o.b(r6, r4)
        L6a:
            T r4 = r5.element
            kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
            if (r4 == r5) goto L71
            return r4
        L71:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(kotlinx.coroutines.flow.i, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.e
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.e) r0
            int r1 = r0.f48725d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48725d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$e r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48724c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48725d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f48723b
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.d) r4
            java.lang.Object r0 = r0.f48722a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.g0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L31
            goto L5e
        L31:
            r5 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$d r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$d
            r2.<init>(r5)
            r0.f48722a = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            r0.f48723b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            r0.f48725d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r0 = r5
            goto L5e
        L57:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5b:
            kotlinx.coroutines.flow.internal.o.b(r5, r4)
        L5e:
            T r4 = r0.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.c(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.e<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.f
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.f) r0
            int r1 = r0.f48729d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48729d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$f r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48728c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48729d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f48727b
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r4
            java.lang.Object r5 = r0.f48726a
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            kotlin.g0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L31
            goto L5e
        L31:
            r6 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.g0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2
            r2.<init>(r5, r6)
            r0.f48726a = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            r0.f48727b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            r0.f48729d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r5 = r6
            goto L5e
        L57:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L5b:
            kotlinx.coroutines.flow.internal.o.b(r6, r4)
        L5e:
            T r4 = r5.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.d(kotlinx.coroutines.flow.i, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, R> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, R r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.g
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$g r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.g) r0
            int r1 = r0.f48734c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48734c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$g r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48733b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48734c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f48732a
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.g0.n(r7)
            goto L50
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2 r5 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2
            r5.<init>(r7, r6)
            r0.f48732a = r7
            r0.f48734c = r3
            java.lang.Object r4 = r4.collect(r5, r0)
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = r7
        L50:
            T r4 = r4.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.e(kotlinx.coroutines.flow.i, java.lang.Object, kotlin.jvm.functions.Function3, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object f(kotlinx.coroutines.flow.i<? extends T> iVar, R r5, Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, kotlin.coroutines.e<? super R> eVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = r5;
        FlowKt__ReduceKt$fold$2 flowKt__ReduceKt$fold$2 = new FlowKt__ReduceKt$fold$2(objectRef, function3);
        kotlin.jvm.internal.d0.e(0);
        iVar.collect(flowKt__ReduceKt$fold$2, eVar);
        kotlin.jvm.internal.d0.e(1);
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.h
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$h r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.h) r0
            int r1 = r0.f48737c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48737c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$h r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48736b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48737c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f48735a
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.g0.n(r5)
            goto L52
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.flow.internal.s.f49029a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$i r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$i
            r2.<init>(r5)
            r0.f48735a = r5
            r0.f48737c = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L51
            return r1
        L51:
            r4 = r5
        L52:
            T r4 = r4.element
            kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
            if (r4 == r5) goto L59
            return r4
        L59:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.g(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.j
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$j r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.j) r0
            int r1 = r0.f48741c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48741c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$j r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$j
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48740b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48741c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f48739a
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.g0.n(r5)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.flow.FlowKt__ReduceKt$k r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$k
            r2.<init>(r5)
            r0.f48739a = r5
            r0.f48741c = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r5
        L4e:
            T r4 = r4.element
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.h(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.s0] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S, T extends S> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super S, ? super T, ? super kotlin.coroutines.e<? super S>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super S> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.l
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ReduceKt$l r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.l) r0
            int r1 = r0.f48745c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48745c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$l r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$l
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48744b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48745c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f48743a
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.g0.n(r6)
            goto L52
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.flow.internal.s.f49029a
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$m r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$m
            r2.<init>(r6, r5)
            r0.f48743a = r6
            r0.f48745c = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L51
            return r1
        L51:
            r4 = r6
        L52:
            T r4 = r4.element
            kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
            if (r4 == r5) goto L59
            return r4
        L59:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Empty flow can't be reduced"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.i(kotlinx.coroutines.flow.i, kotlin.jvm.functions.Function3, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object j(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.n
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$n r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.n) r0
            int r1 = r0.f48754c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48754c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$n r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$n
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48753b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48754c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f48752a
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.g0.n(r5)
            goto L52
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.flow.internal.s.f49029a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$o r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$o
            r2.<init>(r5)
            r0.f48752a = r5
            r0.f48754c = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L51
            return r1
        L51:
            r4 = r5
        L52:
            T r4 = r4.element
            kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
            if (r4 == r5) goto L59
            return r4
        L59:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Flow is empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.j(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object k(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.q
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$q r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.q) r0
            int r1 = r0.f48760d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48760d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$q r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$q
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48759c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48760d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f48758b
            kotlinx.coroutines.flow.FlowKt__ReduceKt$p r4 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.p) r4
            java.lang.Object r0 = r0.f48757a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.g0.n(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.flow.internal.s.f49029a
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$p r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$p
            r2.<init>(r5)
            r0.f48757a = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.f48758b = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            r0.f48760d = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            kotlinx.coroutines.flow.internal.o.b(r5, r4)
        L62:
            T r4 = r0.element
            kotlinx.coroutines.internal.s0 r5 = kotlinx.coroutines.flow.internal.s.f49029a
            if (r4 != r5) goto L69
            r4 = 0
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.k(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }
}
