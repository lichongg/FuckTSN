package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,202:1\n48#2,4:203\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n51#1:203,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0<E> f48190a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(b0<? extends E> b0Var) {
            super(1);
            this.f48190a = b0Var;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            p.b(this.f48190a, th);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {56, 57}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
    static final class c<E> extends SuspendLambda implements Function2<z<? super E>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48191a;

        /* renamed from: b, reason: collision with root package name */
        int f48192b;

        /* renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f48193c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b0<E> f48194d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(b0<? extends E> b0Var, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f48194d = b0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            c cVar = new c(this.f48194d, eVar);
            cVar.f48193c = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull z<? super E> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
        
            if (r4.T(r7, r6) == r0) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0062 -> B:6:0x0019). Please report as a decompilation issue!!! */
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
                int r1 = r6.f48192b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r6.f48191a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r4 = r6.f48193c
                kotlinx.coroutines.channels.z r4 = (kotlinx.coroutines.channels.z) r4
                kotlin.g0.n(r7)
            L19:
                r7 = r4
                goto L3c
            L1b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L23:
                java.lang.Object r1 = r6.f48191a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r4 = r6.f48193c
                kotlinx.coroutines.channels.z r4 = (kotlinx.coroutines.channels.z) r4
                kotlin.g0.n(r7)
                goto L4c
            L2f:
                kotlin.g0.n(r7)
                java.lang.Object r7 = r6.f48193c
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlinx.coroutines.channels.b0<E> r1 = r6.f48194d
                kotlinx.coroutines.channels.l r1 = r1.iterator()
            L3c:
                r6.f48193c = r7
                r6.f48191a = r1
                r6.f48192b = r3
                java.lang.Object r4 = r1.c(r6)
                if (r4 != r0) goto L49
                goto L64
            L49:
                r5 = r4
                r4 = r7
                r7 = r5
            L4c:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L65
                java.lang.Object r7 = r1.next()
                r6.f48193c = r4
                r6.f48191a = r1
                r6.f48192b = r2
                java.lang.Object r7 = r4.T(r7, r6)
                if (r7 != r0) goto L19
            L64:
                return r0
            L65:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.h.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n1#1,110:1\n51#2:111\n*E\n"})
    public static final class a extends kotlin.coroutines.a implements n0 {
        public a(n0.b bVar) {
            super(bVar);
        }

        @Override // kotlinx.coroutines.n0
        public void s(@NotNull kotlin.coroutines.i iVar, @NotNull Throwable th) {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> d<E> b(@NotNull b0<? extends E> b0Var, int i6, @NotNull CoroutineStart coroutineStart) {
        return c(s0.m(s0.m(w1.f49676a, g1.g()), new a(n0.f49394r0)), null, i6, coroutineStart, new b(b0Var), new c(b0Var, null), 1, null);
    }

    public static /* synthetic */ d c(r0 r0Var, kotlin.coroutines.i iVar, int i6, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i7 & 2) != 0) {
            i6 = 1;
        }
        if ((i7 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        if ((i7 & 8) != 0) {
            function1 = null;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        return a(r0Var, iVar, i6, coroutineStart2, function1, function2);
    }

    public static /* synthetic */ d d(b0 b0Var, int i6, CoroutineStart coroutineStart, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 1;
        }
        if ((i7 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return b(b0Var, i6, coroutineStart);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> d<E> a(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, n1> function1, @BuilderInference @NotNull Function2<? super z<? super E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        g gVar;
        kotlin.coroutines.i e6 = l0.e(r0Var, iVar);
        d a6 = f.a(i6);
        if (coroutineStart.isLazy()) {
            gVar = new w(e6, a6, function2);
        } else {
            gVar = new g(e6, a6, true);
        }
        if (function1 != null) {
            ((l2) gVar).k(function1);
        }
        ((kotlinx.coroutines.a) gVar).z1(coroutineStart, gVar, function2);
        return (d<E>) gVar;
    }
}
