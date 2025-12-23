package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.internal.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n53#2:219\n55#2:223\n53#2:224\n55#2:228\n50#3:220\n55#3:222\n50#3:225\n55#3:227\n107#4:221\n107#4:226\n107#4:229\n1#5:230\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n47#1:219\n47#1:223\n74#1:224\n74#1:228\n47#1:220\n47#1:222\n74#1:225\n74#1:227\n47#1:221\n74#1:226\n82#1:229\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a, reason: collision with root package name */
    private static final int f48679a = v0.b(k.f49045a, 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,113:1\n83#2,2:114\n*E\n"})
    public static final class a<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f48688a;

        public a(i iVar) {
            this.f48688a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object collect = this.f48688a.collect(new b(jVar), eVar);
            return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f48689a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$1$1", f = "Merge.kt", i = {}, l = {83}, m = "emit", n = {}, s = {})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48690a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b<T> f48691b;

            /* renamed from: c, reason: collision with root package name */
            int f48692c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48691b = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48690a = obj;
                this.f48692c |= Integer.MIN_VALUE;
                return this.f48691b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(j<? super T> jVar) {
            this.f48689a = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt.b.a
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__MergeKt$b$a r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt.b.a) r0
                int r1 = r0.f48692c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48692c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__MergeKt$b$a r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$b$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f48690a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48692c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r6)
                goto L3f
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.g0.n(r6)
                kotlinx.coroutines.flow.j<T> r6 = r4.f48689a
                r0.f48692c = r3
                java.lang.Object r5 = kotlinx.coroutines.flow.k.m0(r6, r5, r0)
                if (r5 != r1) goto L3f
                return r1
            L3f:
                kotlin.n1 r5 = kotlin.n1.f44123a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt.b.emit(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {}, l = {217, 217}, m = "invokeSuspend", n = {}, s = {})
    static final class c<R, T> extends SuspendLambda implements Function3<j<? super R>, T, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48693a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48694b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48695c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<T, kotlin.coroutines.e<? super R>, Object> f48696d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, kotlin.coroutines.e<? super n1> eVar) {
            return invoke((j) obj, (j<? super R>) obj2, eVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, kotlin.coroutines.e<? super c> eVar) {
            super(3, eVar);
            this.f48696d = function2;
        }

        @Nullable
        public final Object invoke(@NotNull j<? super R> jVar, T t5, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            c cVar = new c(this.f48696d, eVar);
            cVar.f48694b = jVar;
            cVar.f48695c = t5;
            return cVar.invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            if (r1.emit(r6, r5) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        
            if (r6 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r5.f48693a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.g0.n(r6)
                goto L45
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.f48694b
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.g0.n(r6)
                goto L39
            L22:
                kotlin.g0.n(r6)
                java.lang.Object r6 = r5.f48694b
                r1 = r6
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                java.lang.Object r6 = r5.f48695c
                kotlin.jvm.functions.Function2<T, kotlin.coroutines.e<? super R>, java.lang.Object> r4 = r5.f48696d
                r5.f48694b = r1
                r5.f48693a = r3
                java.lang.Object r6 = r4.invoke(r6, r5)
                if (r6 != r0) goto L39
                goto L44
            L39:
                r3 = 0
                r5.f48694b = r3
                r5.f48693a = r2
                java.lang.Object r6 = r1.emit(r6, r5)
                if (r6 != r0) goto L45
            L44:
                return r0
            L45:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> a(@NotNull final i<? extends T> iVar, @NotNull final Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return k.G0(new i<i<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ j f48682a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function2 f48683b;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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
                    this.f48682a = jVar;
                    this.f48683b = function2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
                
                    if (r7.emit(r8, r0) != r1) goto L23;
                 */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.g0.n(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) r7
                        kotlin.g0.n(r8)
                        goto L51
                    L3c:
                        kotlin.g0.n(r8)
                        kotlinx.coroutines.flow.j r8 = r6.f48682a
                        kotlin.jvm.functions.Function2 r2 = r6.f48683b
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r2.invoke(r7, r0)
                        if (r7 != r1) goto L4e
                        goto L5c
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5d
                    L5c:
                        return r1
                    L5d:
                        kotlin.n1 r7 = kotlin.n1.f44123a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = i.this.collect(new AnonymousClass2(jVar, function2), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> b(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return k.d2(iVar, new FlowKt__MergeKt$flatMapLatest$1(function2, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> c(@NotNull final i<? extends T> iVar, int i6, @NotNull final Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return k.H0(new i<i<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements j {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ j f48686a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function2 f48687b;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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
                    this.f48686a = jVar;
                    this.f48687b = function2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
                
                    if (r7.emit(r8, r0) != r1) goto L23;
                 */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.j
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.g0.n(r8)
                        goto L5d
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        java.lang.Object r7 = r0.L$0
                        kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) r7
                        kotlin.g0.n(r8)
                        goto L51
                    L3c:
                        kotlin.g0.n(r8)
                        kotlinx.coroutines.flow.j r8 = r6.f48686a
                        kotlin.jvm.functions.Function2 r2 = r6.f48687b
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r7 = r2.invoke(r7, r0)
                        if (r7 != r1) goto L4e
                        goto L5c
                    L4e:
                        r5 = r8
                        r8 = r7
                        r7 = r5
                    L51:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5d
                    L5c:
                        return r1
                    L5d:
                        kotlin.n1 r7 = kotlin.n1.f44123a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object collect = i.this.collect(new AnonymousClass2(jVar, function2), eVar);
                return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
            }
        }, i6);
    }

    public static /* synthetic */ i d(i iVar, int i6, Function2 function2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = f48679a;
        }
        return k.D0(iVar, i6, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> i<T> e(@NotNull i<? extends i<? extends T>> iVar) {
        return new a(iVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> i<T> f(@NotNull i<? extends i<? extends T>> iVar, int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i6).toString());
        }
        if (i6 == 1) {
            return k.G0(iVar);
        }
        return new kotlinx.coroutines.flow.internal.f(iVar, i6, null, 0, null, 28, null);
    }

    public static /* synthetic */ i g(i iVar, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = f48679a;
        }
        return k.H0(iVar, i6);
    }

    public static final int h() {
        return f48679a;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> k(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return k.d2(iVar, new c(function2, null));
    }

    @NotNull
    public static final <T> i<T> l(@NotNull Iterable<? extends i<? extends T>> iterable) {
        return new kotlinx.coroutines.flow.internal.j(iterable, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> n(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return new kotlinx.coroutines.flow.internal.i(function3, iVar, null, 0, null, 28, null);
    }

    @NotNull
    public static final <T> i<T> m(@NotNull i<? extends T>... iVarArr) {
        return k.Z0(kotlin.collections.n.K5(iVarArr));
    }

    @FlowPreview
    public static /* synthetic */ void i() {
    }

    @FlowPreview
    public static /* synthetic */ void j() {
    }
}
