package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,176:1\n107#2:177\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n153#1:177\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n1#1,113:1\n154#2,2:114\n*E\n"})
    public static final class a<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.d f49047a;

        public a(kotlinx.coroutines.channels.d dVar) {
            this.f49047a = dVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object l02 = k.l0(jVar, this.f49047a.m(), eVar);
            return l02 == kotlin.coroutines.intrinsics.a.l() ? l02 : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0, 1, 1, 1}, l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", "channel", "consume", "$this$emitAllImpl", "channel", "consume"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
    static final class b<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49048a;

        /* renamed from: b, reason: collision with root package name */
        Object f49049b;

        /* renamed from: c, reason: collision with root package name */
        Object f49050c;

        /* renamed from: d, reason: collision with root package name */
        boolean f49051d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f49052e;

        /* renamed from: f, reason: collision with root package name */
        int f49053f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49052e = obj;
            this.f49053f |= Integer.MIN_VALUE;
            return l.e(null, null, false, this);
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }
    }

    @Nullable
    public static final <T> Object d(@NotNull j<? super T> jVar, @NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object e6 = e(jVar, b0Var, true, eVar);
        return e6 == kotlin.coroutines.intrinsics.a.l() ? e6 : n1.f44123a;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @NotNull
    public static final <T> i<T> b(@NotNull kotlinx.coroutines.channels.d<T> dVar) {
        return new a(dVar);
    }

    @NotNull
    public static final <T> i<T> c(@NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var) {
        return new e(b0Var, true, null, 0, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        if (r9 == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:12:0x0036, B:14:0x0062, B:20:0x0077, B:22:0x007f, B:32:0x0054, B:34:0x005e), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0091 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object e(kotlinx.coroutines.flow.j<? super T> r6, kotlinx.coroutines.channels.b0<? extends T> r7, boolean r8, kotlin.coroutines.e<? super kotlin.n1> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.l.b
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.l$b r0 = (kotlinx.coroutines.flow.l.b) r0
            int r1 = r0.f49053f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49053f = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.l$b r0 = new kotlinx.coroutines.flow.l$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f49052e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49053f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.f49051d
            java.lang.Object r6 = r0.f49050c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f49049b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f49048a
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) r2
            kotlin.g0.n(r9)     // Catch: java.lang.Throwable -> L3c
        L39:
            r9 = r6
            r6 = r2
            goto L62
        L3c:
            r6 = move-exception
            goto L9d
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            boolean r8 = r0.f49051d
            java.lang.Object r6 = r0.f49050c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f49049b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f49048a
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) r2
            kotlin.g0.n(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            kotlin.g0.n(r9)
            kotlinx.coroutines.flow.k.o0(r6)
            kotlinx.coroutines.channels.l r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.f49048a = r6     // Catch: java.lang.Throwable -> L3c
            r0.f49049b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f49050c = r9     // Catch: java.lang.Throwable -> L3c
            r0.f49051d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f49053f = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.c(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            goto L93
        L73:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L77:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L94
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3c
            r0.f49048a = r2     // Catch: java.lang.Throwable -> L3c
            r0.f49049b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f49050c = r6     // Catch: java.lang.Throwable -> L3c
            r0.f49051d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f49053f = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
        L93:
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            kotlinx.coroutines.channels.p.b(r7, r6)
        L9a:
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            kotlinx.coroutines.channels.p.b(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.l.e(kotlinx.coroutines.flow.j, kotlinx.coroutines.channels.b0, boolean, kotlin.coroutines.e):java.lang.Object");
    }

    @NotNull
    public static final <T> i<T> g(@NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var) {
        return new e(b0Var, false, null, 0, null, 28, null);
    }

    @NotNull
    public static final <T> kotlinx.coroutines.channels.b0<T> f(@NotNull i<? extends T> iVar, @NotNull r0 r0Var) {
        return kotlinx.coroutines.flow.internal.e.b(iVar).m(r0Var);
    }
}
