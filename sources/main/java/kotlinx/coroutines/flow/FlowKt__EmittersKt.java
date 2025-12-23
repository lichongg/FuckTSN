package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.BuilderInference;
import kotlin.PublishedApi;
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
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n107#2:223\n107#2:224\n107#2:225\n107#2:226\n75#3:227\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n50#1:223\n76#1:224\n146#1:225\n181#1:226\n218#1:227\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__EmittersKt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF}, m = "invokeSafely$FlowKt__EmittersKt", n = {"cause"}, s = {"L$0"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48605a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48606b;

        /* renamed from: c, reason: collision with root package name */
        int f48607c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48606b = obj;
            this.f48607c |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt.c(null, null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f48608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<T> f48609b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1", f = "Emitters.kt", i = {}, l = {185}, m = "emit", n = {}, s = {})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48610a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b<T> f48611b;

            /* renamed from: c, reason: collision with root package name */
            int f48612c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f48611b = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48610a = obj;
                this.f48612c |= Integer.MIN_VALUE;
                return this.f48611b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.BooleanRef booleanRef, j<? super T> jVar) {
            this.f48608a = booleanRef;
            this.f48609b = jVar;
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
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt.b.a
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__EmittersKt$b$a r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.b.a) r0
                int r1 = r0.f48612c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48612c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__EmittersKt$b$a r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$b$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f48610a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48612c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r6)
                goto L44
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.g0.n(r6)
                kotlin.jvm.internal.Ref$BooleanRef r6 = r4.f48608a
                r2 = 0
                r6.element = r2
                kotlinx.coroutines.flow.j<T> r6 = r4.f48609b
                r0.f48612c = r3
                java.lang.Object r5 = r6.emit(r5, r0)
                if (r5 != r1) goto L44
                return r1
            L44:
                kotlin.n1 r5 = kotlin.n1.f44123a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.b.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    public static final void b(@NotNull j<?> jVar) {
        if (jVar instanceof n0) {
            throw ((n0) jVar).f49070a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.j<? super T> r4, kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.j<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.e<? super kotlin.n1>, ? extends java.lang.Object> r5, java.lang.Throwable r6, kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$a r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.a) r0
            int r1 = r0.f48607c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48607c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$a r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48606b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48607c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.f48605a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L2e
            goto L46
        L2e:
            r4 = move-exception
            goto L49
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.g0.n(r7)
            r0.f48605a = r6     // Catch: java.lang.Throwable -> L2e
            r0.f48607c = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            kotlin.l.a(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.c(kotlinx.coroutines.flow.j, kotlin.jvm.functions.Function3, java.lang.Throwable, kotlin.coroutines.e):java.lang.Object");
    }

    @NotNull
    public static final <T> i<T> d(@NotNull i<? extends T> iVar, @NotNull Function3<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(iVar, function3);
    }

    @NotNull
    public static final <T> i<T> e(@NotNull i<? extends T> iVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> f(@NotNull i<? extends T> iVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(function2, iVar);
    }

    @NotNull
    public static final <T, R> i<R> g(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return k.J0(new FlowKt__EmittersKt$transform$1(iVar, function3, null));
    }

    @PublishedApi
    @NotNull
    public static final <T, R> i<R> h(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(iVar, function3);
    }
}
