package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.BuilderInference;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,332:1\n272#1,3:334\n272#1,3:337\n261#1:340\n263#1:342\n272#1,3:343\n261#1:346\n263#1:348\n272#1,3:349\n261#1:352\n263#1:354\n272#1,3:355\n107#2:333\n107#2:341\n107#2:347\n107#2:353\n107#2:358\n107#2:359\n107#2:362\n37#3,2:360\n37#3,2:363\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n75#1:334,3\n103#1:337,3\n119#1:340\n119#1:342\n138#1:343,3\n156#1:346\n156#1:348\n177#1:349,3\n197#1:352\n197#1:354\n220#1:355,3\n32#1:333\n119#1:341\n156#1:347\n197#1:353\n237#1:358\n261#1:359\n288#1:362\n287#1:360,2\n306#1:363,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__ZipKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n33#2,2:114\n*E\n"})
    public static final class a<R> implements i<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f48828a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f48829b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function3 f48830c;

        public a(i iVar, i iVar2, Function3 function3) {
            this.f48828a = iVar;
            this.f48829b = iVar2;
            this.f48830c = function3;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super R> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object a6 = kotlinx.coroutines.flow.internal.k.a(jVar, new i[]{this.f48828a, this.f48829b}, FlowKt__ZipKt.r(), new b(this.f48830c, null), eVar);
            return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
    static final class b<R> extends SuspendLambda implements Function3<j<? super R>, Object[], kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48831a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48832b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48833c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<T1, T2, kotlin.coroutines.e<? super R>, Object> f48834d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, kotlin.coroutines.e<? super b> eVar) {
            super(3, eVar);
            this.f48834d = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull j<? super R> jVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            b bVar = new b(this.f48834d, eVar);
            bVar.f48832b = jVar;
            bVar.f48833c = objArr;
            return bVar.invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
        
            if (r1.emit(r7, r6) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        
            if (r7 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r6.f48831a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.g0.n(r7)
                goto L4c
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                java.lang.Object r1 = r6.f48832b
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.g0.n(r7)
                goto L40
            L22:
                kotlin.g0.n(r7)
                java.lang.Object r7 = r6.f48832b
                r1 = r7
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                java.lang.Object r7 = r6.f48833c
                java.lang.Object[] r7 = (java.lang.Object[]) r7
                kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.e<? super R>, java.lang.Object> r4 = r6.f48834d
                r5 = 0
                r5 = r7[r5]
                r7 = r7[r3]
                r6.f48832b = r1
                r6.f48831a = r3
                java.lang.Object r7 = r4.invoke(r5, r7, r6)
                if (r7 != r0) goto L40
                goto L4b
            L40:
                r3 = 0
                r6.f48832b = r3
                r6.f48831a = r2
                java.lang.Object r7 = r1.emit(r7, r6)
                if (r7 != r0) goto L4c
            L4b:
                return r0
            L4c:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f48835a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    @NotNull
    public static final <T1, T2, T3, R> i<R> d(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @BuilderInference @NotNull final Function4<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.e<? super R>, ? extends Object> function4) {
        final i[] iVarArr = {iVar, iVar2, iVar3};
        return new i<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {}, l = {333, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n120#2,4:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<j<? super R>, Object[], kotlin.coroutines.e<? super n1>, Object> {
                final /* synthetic */ Function4 $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.e eVar, Function4 function4) {
                    super(3, eVar);
                    this.$transform$inlined = function4;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull j<? super R> jVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar, this.$transform$inlined);
                    anonymousClass2.L$0 = jVar;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(n1.f44123a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
                
                    if (r1.emit(r8, r7) == r0) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
                
                    if (r8 == r0) goto L15;
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
                        int r1 = r7.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L22
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.g0.n(r8)
                        goto L56
                    L12:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r0)
                        throw r8
                    L1a:
                        java.lang.Object r1 = r7.L$0
                        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                        kotlin.g0.n(r8)
                        goto L4a
                    L22:
                        kotlin.g0.n(r8)
                        java.lang.Object r8 = r7.L$0
                        r1 = r8
                        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                        java.lang.Object r8 = r7.L$1
                        java.lang.Object[] r8 = (java.lang.Object[]) r8
                        kotlin.jvm.functions.Function4 r4 = r7.$transform$inlined
                        r5 = 0
                        r5 = r8[r5]
                        r6 = r8[r3]
                        r8 = r8[r2]
                        r7.L$0 = r1
                        r7.label = r3
                        r3 = 6
                        kotlin.jvm.internal.d0.e(r3)
                        java.lang.Object r8 = r4.invoke(r5, r6, r8, r7)
                        r3 = 7
                        kotlin.jvm.internal.d0.e(r3)
                        if (r8 != r0) goto L4a
                        goto L55
                    L4a:
                        r3 = 0
                        r7.L$0 = r3
                        r7.label = r2
                        java.lang.Object r8 = r1.emit(r8, r7)
                        if (r8 != r0) goto L56
                    L55:
                        return r0
                    L56:
                        kotlin.n1 r8 = kotlin.n1.f44123a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object a6 = kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, FlowKt__ZipKt.r(), new AnonymousClass2(null, function4), eVar);
                return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> i<R> e(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.e<? super R>, ? extends Object> function5) {
        final i[] iVarArr = {iVar, iVar2, iVar3, iVar4};
        return new i<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n157#2,5:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<j<? super R>, Object[], kotlin.coroutines.e<? super n1>, Object> {
                final /* synthetic */ Function5 $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.e eVar, Function5 function5) {
                    super(3, eVar);
                    this.$transform$inlined = function5;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull j<? super R> jVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar, this.$transform$inlined);
                    anonymousClass2.L$0 = jVar;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(n1.f44123a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
                
                    if (r1.emit(r11, r10) == r0) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
                
                    if (r11 == r0) goto L15;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L24
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L13
                        kotlin.g0.n(r11)
                        r9 = r10
                        goto L5c
                    L13:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L1b:
                        java.lang.Object r1 = r10.L$0
                        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                        kotlin.g0.n(r11)
                        r9 = r10
                        goto L50
                    L24:
                        kotlin.g0.n(r11)
                        java.lang.Object r11 = r10.L$0
                        r1 = r11
                        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                        java.lang.Object r11 = r10.L$1
                        java.lang.Object[] r11 = (java.lang.Object[]) r11
                        kotlin.jvm.functions.Function5 r4 = r10.$transform$inlined
                        r5 = 0
                        r5 = r11[r5]
                        r6 = r11[r3]
                        r7 = r11[r2]
                        r8 = 3
                        r8 = r11[r8]
                        r10.L$0 = r1
                        r10.label = r3
                        r11 = 6
                        kotlin.jvm.internal.d0.e(r11)
                        r9 = r10
                        java.lang.Object r11 = r4.invoke(r5, r6, r7, r8, r9)
                        r3 = 7
                        kotlin.jvm.internal.d0.e(r3)
                        if (r11 != r0) goto L50
                        goto L5b
                    L50:
                        r3 = 0
                        r9.L$0 = r3
                        r9.label = r2
                        java.lang.Object r11 = r1.emit(r11, r10)
                        if (r11 != r0) goto L5c
                    L5b:
                        return r0
                    L5c:
                        kotlin.n1 r11 = kotlin.n1.f44123a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object a6 = kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, FlowKt__ZipKt.r(), new AnonymousClass2(null, function5), eVar);
                return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> i<R> f(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull i<? extends T5> iVar5, @NotNull final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.e<? super R>, ? extends Object> function6) {
        final i[] iVarArr = {iVar, iVar2, iVar3, iVar4, iVar5};
        return new i<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", i = {}, l = {333, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n198#2,6:333\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<j<? super R>, Object[], kotlin.coroutines.e<? super n1>, Object> {
                final /* synthetic */ Function6 $transform$inlined;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(kotlin.coroutines.e eVar, Function6 function6) {
                    super(3, eVar);
                    this.$transform$inlined = function6;
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull j<? super R> jVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar, this.$transform$inlined);
                    anonymousClass2.L$0 = jVar;
                    anonymousClass2.L$1 = objArr;
                    return anonymousClass2.invokeSuspend(n1.f44123a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
                
                    if (r1.emit(r12, r11) == r0) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
                
                    if (r12 == r0) goto L15;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
                    /*
                        r11 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                        int r1 = r11.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L24
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L13
                        kotlin.g0.n(r12)
                        r10 = r11
                        goto L5f
                    L13:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    L1b:
                        java.lang.Object r1 = r11.L$0
                        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                        kotlin.g0.n(r12)
                        r10 = r11
                        goto L53
                    L24:
                        kotlin.g0.n(r12)
                        java.lang.Object r12 = r11.L$0
                        r1 = r12
                        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                        java.lang.Object r12 = r11.L$1
                        java.lang.Object[] r12 = (java.lang.Object[]) r12
                        kotlin.jvm.functions.Function6 r4 = r11.$transform$inlined
                        r5 = 0
                        r5 = r12[r5]
                        r6 = r12[r3]
                        r7 = r12[r2]
                        r8 = 3
                        r8 = r12[r8]
                        r9 = 4
                        r9 = r12[r9]
                        r11.L$0 = r1
                        r11.label = r3
                        r12 = 6
                        kotlin.jvm.internal.d0.e(r12)
                        r10 = r11
                        java.lang.Object r12 = r4.invoke(r5, r6, r7, r8, r9, r10)
                        r3 = 7
                        kotlin.jvm.internal.d0.e(r3)
                        if (r12 != r0) goto L53
                        goto L5e
                    L53:
                        r3 = 0
                        r10.L$0 = r3
                        r10.label = r2
                        java.lang.Object r12 = r1.emit(r12, r11)
                        if (r12 != r0) goto L5f
                    L5e:
                        return r0
                    L5f:
                        kotlin.n1 r12 = kotlin.n1.f44123a
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object collect(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
                Object a6 = kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, FlowKt__ZipKt.r(), new AnonymousClass2(null, function6), eVar);
                return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
            }
        };
    }

    @NotNull
    public static final <T1, T2, R> i<R> i(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @BuilderInference @NotNull Function4<? super j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function4) {
        return k.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2(new i[]{iVar, iVar2}, null, function4));
    }

    @NotNull
    public static final <T1, T2, T3, R> i<R> j(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @BuilderInference @NotNull Function5<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function5) {
        return k.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new i[]{iVar, iVar2, iVar3}, null, function5));
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> i<R> k(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @BuilderInference @NotNull Function6<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function6) {
        return k.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(new i[]{iVar, iVar2, iVar3, iVar4}, null, function6));
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> i<R> l(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull i<? extends T5> iVar5, @BuilderInference @NotNull Function7<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function7) {
        return k.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(new i[]{iVar, iVar2, iVar3, iVar4, iVar5}, null, function7));
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> i<R> q(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @BuilderInference @NotNull Function4<? super j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function4) {
        return k.J0(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1(new i[]{iVar, iVar2}, null, function4));
    }

    @JvmName(name = "flowCombine")
    @NotNull
    public static final <T1, T2, R> i<R> p(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return new a(iVar, iVar2, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function0<T[]> r() {
        return c.f48835a;
    }

    public static final /* synthetic */ <T, R> i<R> b(Iterable<? extends i<? extends T>> iterable, Function2<? super T[], ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        i[] iVarArr = (i[]) kotlin.collections.f0.a6(iterable).toArray(new i[0]);
        kotlin.jvm.internal.g0.w();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(iVarArr, function2);
    }

    @NotNull
    public static final <T1, T2, R> i<R> c(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return k.K0(iVar, iVar2, function3);
    }

    public static final /* synthetic */ <T, R> i<R> g(i<? extends T>[] iVarArr, Function2<? super T[], ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        kotlin.jvm.internal.g0.w();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(iVarArr, function2);
    }

    public static final /* synthetic */ <T, R> i<R> h(Iterable<? extends i<? extends T>> iterable, @BuilderInference Function3<? super j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        i[] iVarArr = (i[]) kotlin.collections.f0.a6(iterable).toArray(new i[0]);
        kotlin.jvm.internal.g0.w();
        return k.J0(new FlowKt__ZipKt$combineTransform$7(iVarArr, function3, null));
    }

    public static final /* synthetic */ <T, R> i<R> m(i<? extends T>[] iVarArr, @BuilderInference Function3<? super j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        kotlin.jvm.internal.g0.w();
        return k.J0(new FlowKt__ZipKt$combineTransform$6(iVarArr, function3, null));
    }

    private static final /* synthetic */ <T, R> i<R> n(i<? extends T>[] iVarArr, @BuilderInference Function3<? super j<? super R>, ? super T[], ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        kotlin.jvm.internal.g0.w();
        return k.J0(new FlowKt__ZipKt$combineTransformUnsafe$1(iVarArr, function3, null));
    }

    private static final /* synthetic */ <T, R> i<R> o(i<? extends T>[] iVarArr, Function2<? super T[], ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        kotlin.jvm.internal.g0.w();
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(iVarArr, function2);
    }

    @NotNull
    public static final <T1, T2, R> i<R> s(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return kotlinx.coroutines.flow.internal.k.b(iVar, iVar2, function3);
    }
}
