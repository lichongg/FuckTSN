package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nProduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,151:1\n1#2:152\n314#3,11:153\n*S KotlinDebug\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n*L\n48#1:153,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {153}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48468a;

        /* renamed from: b, reason: collision with root package name */
        Object f48469b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48470c;

        /* renamed from: d, reason: collision with root package name */
        int f48471d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48470c = obj;
            this.f48471d |= Integer.MIN_VALUE;
            return x.a(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function0<n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f48472a = new b();

        b() {
            super(0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ n1 invoke() {
            invoke2();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.p<n1> f48473a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(kotlinx.coroutines.p<? super n1> pVar) {
            super(1);
            this.f48473a = pVar;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            kotlinx.coroutines.p<n1> pVar = this.f48473a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
        }
    }

    @NotNull
    public static final <E> b0<E> e(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, n1> function1, @BuilderInference @NotNull Function2<? super z<? super E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        y yVar = new y(l0.e(r0Var, iVar), m.d(i6, bufferOverflow, null, 4, null));
        if (function1 != null) {
            yVar.k(function1);
        }
        yVar.z1(coroutineStart, yVar, function2);
        return yVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.z<?> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.n1> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.x.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.x$a r0 = (kotlinx.coroutines.channels.x.a) r0
            int r1 = r0.f48471d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48471d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.x$a r0 = new kotlinx.coroutines.channels.x$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48470c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48471d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f48469b
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.f48468a
            kotlinx.coroutines.channels.z r4 = (kotlinx.coroutines.channels.z) r4
            kotlin.g0.n(r6)     // Catch: java.lang.Throwable -> L32
            goto L75
        L32:
            r4 = move-exception
            goto L7b
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.g0.n(r6)
            kotlin.coroutines.i r6 = r0.getContext()
            kotlinx.coroutines.e2$b r2 = kotlinx.coroutines.e2.f48569s0
            kotlin.coroutines.i$b r6 = r6.get(r2)
            if (r6 != r4) goto L7f
            r0.f48468a = r4     // Catch: java.lang.Throwable -> L32
            r0.f48469b = r5     // Catch: java.lang.Throwable -> L32
            r0.f48471d = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.q r6 = new kotlinx.coroutines.q     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.e r2 = kotlin.coroutines.intrinsics.a.e(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.Q()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.x$c r2 = new kotlinx.coroutines.channels.x$c     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.q(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.x()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.coroutines.intrinsics.a.l()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L72
            kotlin.coroutines.jvm.internal.e.c(r0)     // Catch: java.lang.Throwable -> L32
        L72:
            if (r4 != r1) goto L75
            return r1
        L75:
            r5.invoke()
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        L7b:
            r5.invoke()
            throw r4
        L7f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.x.a(kotlinx.coroutines.channels.z, kotlin.jvm.functions.Function0, kotlin.coroutines.e):java.lang.Object");
    }

    public static /* synthetic */ Object b(z zVar, Function0 function0, kotlin.coroutines.e eVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function0 = b.f48472a;
        }
        return a(zVar, function0, eVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> b0<E> c(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, int i6, @BuilderInference @NotNull Function2<? super z<? super E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return e(r0Var, iVar, i6, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, function2);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final <E> b0<E> d(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, n1> function1, @BuilderInference @NotNull Function2<? super z<? super E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return e(r0Var, iVar, i6, BufferOverflow.SUSPEND, coroutineStart, function1, function2);
    }

    public static /* synthetic */ b0 f(r0 r0Var, kotlin.coroutines.i iVar, int i6, Function2 function2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return c(r0Var, iVar, i6, function2);
    }

    public static /* synthetic */ b0 g(r0 r0Var, kotlin.coroutines.i iVar, int i6, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i7 & 8) != 0) {
            function1 = null;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        return d(r0Var, iVar, i6, coroutineStart2, function1, function2);
    }

    public static /* synthetic */ b0 h(r0 r0Var, kotlin.coroutines.i iVar, int i6, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i7 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i7 & 16) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        return e(r0Var, iVar, i6, bufferOverflow, coroutineStart, function12, function2);
    }
}
