package kotlinx.coroutines.channels;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,141:1\n82#1,11:142\n105#1:153\n82#1,6:154\n106#1,2:160\n92#1:162\n88#1,3:163\n33#1,5:166\n*S KotlinDebug\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n105#1:142,11\n116#1:153\n116#1:154,6\n116#1:160,2\n116#1:162\n116#1:163,3\n129#1:166,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class r {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {106}, m = "consumeEach", n = {com.umeng.ccg.a.f41544t, "$this$consume$iv"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$consumeEach$1\n*L\n1#1,141:1\n*E\n"})
    static final class a<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48255a;

        /* renamed from: b, reason: collision with root package name */
        Object f48256b;

        /* renamed from: c, reason: collision with root package name */
        Object f48257c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48258d;

        /* renamed from: e, reason: collision with root package name */
        int f48259e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48258d = obj;
            this.f48259e |= Integer.MIN_VALUE;
            return r.e(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE}, m = "consumeEach", n = {com.umeng.ccg.a.f41544t, "channel$iv"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$consumeEach$3\n*L\n1#1,141:1\n*E\n"})
    static final class b<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48260a;

        /* renamed from: b, reason: collision with root package name */
        Object f48261b;

        /* renamed from: c, reason: collision with root package name */
        Object f48262c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48263d;

        /* renamed from: e, reason: collision with root package name */
        int f48264e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48263d = obj;
            this.f48264e |= Integer.MIN_VALUE;
            return r.d(null, null, this);
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {Opcodes.FCMPL}, m = "toList", n = {"$this$toList_u24lambda_u243", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
    static final class c<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48265a;

        /* renamed from: b, reason: collision with root package name */
        Object f48266b;

        /* renamed from: c, reason: collision with root package name */
        Object f48267c;

        /* renamed from: d, reason: collision with root package name */
        Object f48268d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48269e;

        /* renamed from: f, reason: collision with root package name */
        int f48270f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48269e = obj;
            this.f48270f |= Integer.MIN_VALUE;
            return p.g0(null, this);
        }

        c(kotlin.coroutines.e<? super c> eVar) {
            super(eVar);
        }
    }

    @PublishedApi
    public static final void a(@NotNull b0<?> b0Var, @Nullable Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = s1.a("Channel was consumed, consumer had failed", th);
            }
        }
        b0Var.b(r0);
    }

    public static final <E, R> R c(@NotNull b0<? extends E> b0Var, @NotNull Function1<? super b0<? extends E>, ? extends R> function1) {
        try {
            R invoke = function1.invoke(b0Var);
            kotlin.jvm.internal.d0.d(1);
            p.b(b0Var, null);
            kotlin.jvm.internal.d0.c(1);
            return invoke;
        } finally {
        }
    }

    private static final <E> Object g(b0<? extends E> b0Var, Function1<? super E, n1> function1, kotlin.coroutines.e<? super n1> eVar) {
        try {
            l<? extends E> it = b0Var.iterator();
            while (true) {
                kotlin.jvm.internal.d0.e(3);
                kotlin.jvm.internal.d0.e(0);
                Object c6 = it.c(null);
                kotlin.jvm.internal.d0.e(1);
                if (!((Boolean) c6).booleanValue()) {
                    n1 n1Var = n1.f44123a;
                    kotlin.jvm.internal.d0.d(1);
                    p.b(b0Var, null);
                    kotlin.jvm.internal.d0.c(1);
                    return n1Var;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: all -> 0x0077, TryCatch #1 {all -> 0x0077, blocks: (B:15:0x0065, B:17:0x006d, B:29:0x007a), top: B:14:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #1 {all -> 0x0077, blocks: (B:15:0x0065, B:17:0x006d, B:29:0x007a), top: B:14:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0061 -> B:13:0x0038). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E> java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.d<E> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.n1> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.r.b
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.r$b r0 = (kotlinx.coroutines.channels.r.b) r0
            int r1 = r0.f48264e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48264e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.r$b r0 = new kotlinx.coroutines.channels.r$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48263d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48264e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r6 = r0.f48262c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f48261b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f48260a
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L3a
            r5 = r0
            r0 = r7
            r7 = r2
        L38:
            r2 = r5
            goto L65
        L3a:
            r6 = move-exception
            goto L8d
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.g0.n(r8)
            kotlinx.coroutines.channels.b0 r6 = r6.m()
            kotlinx.coroutines.channels.l r8 = r6.iterator()     // Catch: java.lang.Throwable -> L89
            r5 = r8
            r8 = r6
            r6 = r5
        L52:
            r0.f48260a = r7     // Catch: java.lang.Throwable -> L86
            r0.f48261b = r8     // Catch: java.lang.Throwable -> L86
            r0.f48262c = r6     // Catch: java.lang.Throwable -> L86
            r0.f48264e = r4     // Catch: java.lang.Throwable -> L86
            java.lang.Object r2 = r6.c(r0)     // Catch: java.lang.Throwable -> L86
            if (r2 != r1) goto L61
            return r1
        L61:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L38
        L65:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L77
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L77
            if (r8 == 0) goto L7a
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L77
            r7.invoke(r8)     // Catch: java.lang.Throwable -> L77
            r8 = r0
            r0 = r2
            goto L52
        L77:
            r6 = move-exception
            r7 = r0
            goto L8d
        L7a:
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L77
            kotlin.jvm.internal.d0.d(r4)
            kotlinx.coroutines.channels.b0.a.b(r0, r3, r4, r3)
            kotlin.jvm.internal.d0.c(r4)
            return r6
        L86:
            r6 = move-exception
            r7 = r8
            goto L8d
        L89:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L8d:
            kotlin.jvm.internal.d0.d(r4)
            kotlinx.coroutines.channels.b0.a.b(r7, r3, r4, r3)
            kotlin.jvm.internal.d0.c(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.r.d(kotlinx.coroutines.channels.d, kotlin.jvm.functions.Function1, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x006d), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x006d), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<? extends E> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.n1> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.r.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.r$a r0 = (kotlinx.coroutines.channels.r.a) r0
            int r1 = r0.f48259e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48259e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.r$a r0 = new kotlinx.coroutines.channels.r$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48258d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48259e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f48257c
            kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
            java.lang.Object r6 = r0.f48256b
            kotlinx.coroutines.channels.b0 r6 = (kotlinx.coroutines.channels.b0) r6
            java.lang.Object r2 = r0.f48255a
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r5 = move-exception
            goto L7e
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.g0.n(r7)
            kotlinx.coroutines.channels.l r7 = r5.iterator()     // Catch: java.lang.Throwable -> L7a
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L4a:
            r0.f48255a = r7     // Catch: java.lang.Throwable -> L35
            r0.f48256b = r6     // Catch: java.lang.Throwable -> L35
            r0.f48257c = r5     // Catch: java.lang.Throwable -> L35
            r0.f48259e = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r5.c(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L35
            r2.invoke(r7)     // Catch: java.lang.Throwable -> L35
            r7 = r2
            goto L4a
        L6d:
            kotlin.n1 r5 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.d0.d(r3)
            r7 = 0
            kotlinx.coroutines.channels.p.b(r6, r7)
            kotlin.jvm.internal.d0.c(r3)
            return r5
        L7a:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L7e:
            throw r5     // Catch: java.lang.Throwable -> L7f
        L7f:
            r7 = move-exception
            kotlin.jvm.internal.d0.d(r3)
            kotlinx.coroutines.channels.p.b(r6, r5)
            kotlin.jvm.internal.d0.c(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.r.e(kotlinx.coroutines.channels.b0, kotlin.jvm.functions.Function1, kotlin.coroutines.e):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ kotlinx.coroutines.selects.g h(b0 b0Var) {
        g0.n(b0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return b0Var.u();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public static final /* synthetic */ Object i(b0 b0Var, kotlin.coroutines.e eVar) {
        g0.n(b0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return b0Var.w(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[Catch: all -> 0x0039, TryCatch #2 {all -> 0x0039, blocks: (B:11:0x0035, B:12:0x0067, B:14:0x006f, B:29:0x0078), top: B:10:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:11:0x0035, B:12:0x0067, B:14:0x006f, B:29:0x0078), top: B:10:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0064 -> B:12:0x0067). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E> java.lang.Object j(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<? extends E> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.util.List<? extends E>> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.r.c
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.r$c r0 = (kotlinx.coroutines.channels.r.c) r0
            int r1 = r0.f48270f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48270f = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.r$c r0 = new kotlinx.coroutines.channels.r$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48269e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48270f
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.f48268d
            kotlinx.coroutines.channels.l r7 = (kotlinx.coroutines.channels.l) r7
            java.lang.Object r2 = r0.f48267c
            kotlinx.coroutines.channels.b0 r2 = (kotlinx.coroutines.channels.b0) r2
            java.lang.Object r4 = r0.f48266b
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.f48265a
            java.util.List r5 = (java.util.List) r5
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L39
            goto L67
        L39:
            r7 = move-exception
            r8 = r2
            goto L89
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            kotlin.g0.n(r8)
            java.util.List r8 = kotlin.collections.f0.j()
            kotlinx.coroutines.channels.l r2 = r7.iterator()     // Catch: java.lang.Throwable -> L85
            r4 = r8
            r5 = r4
            r8 = r7
            r7 = r2
        L53:
            r0.f48265a = r5     // Catch: java.lang.Throwable -> L83
            r0.f48266b = r4     // Catch: java.lang.Throwable -> L83
            r0.f48267c = r8     // Catch: java.lang.Throwable -> L83
            r0.f48268d = r7     // Catch: java.lang.Throwable -> L83
            r0.f48270f = r3     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r7.c(r0)     // Catch: java.lang.Throwable -> L83
            if (r2 != r1) goto L64
            return r1
        L64:
            r6 = r2
            r2 = r8
            r8 = r6
        L67:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L39
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r8 == 0) goto L78
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L39
            r4.add(r8)     // Catch: java.lang.Throwable -> L39
            r8 = r2
            goto L53
        L78:
            kotlin.n1 r7 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L39
            r7 = 0
            kotlinx.coroutines.channels.p.b(r2, r7)
            java.util.List r7 = kotlin.collections.f0.b(r5)
            return r7
        L83:
            r7 = move-exception
            goto L89
        L85:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L89:
            throw r7     // Catch: java.lang.Throwable -> L8a
        L8a:
            r0 = move-exception
            kotlinx.coroutines.channels.p.b(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.r.j(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    public static final <E, R> R b(@NotNull d<E> dVar, @NotNull Function1<? super b0<? extends E>, ? extends R> function1) {
        b0<E> m6 = dVar.m();
        try {
            return function1.invoke(m6);
        } finally {
            kotlin.jvm.internal.d0.d(1);
            b0.a.b(m6, null, 1, null);
            kotlin.jvm.internal.d0.c(1);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object f(d<E> dVar, Function1<? super E, n1> function1, kotlin.coroutines.e<? super n1> eVar) {
        b0<E> m6 = dVar.m();
        try {
            l<E> it = m6.iterator();
            while (true) {
                kotlin.jvm.internal.d0.e(3);
                kotlin.jvm.internal.d0.e(0);
                Object c6 = it.c(null);
                kotlin.jvm.internal.d0.e(1);
                if (((Boolean) c6).booleanValue()) {
                    function1.invoke(it.next());
                } else {
                    n1 n1Var = n1.f44123a;
                    kotlin.jvm.internal.d0.d(1);
                    b0.a.b(m6, null, 1, null);
                    kotlin.jvm.internal.d0.c(1);
                    return n1Var;
                }
            }
        } catch (Throwable th) {
            kotlin.jvm.internal.d0.d(1);
            b0.a.b(m6, null, 1, null);
            kotlin.jvm.internal.d0.c(1);
            throw th;
        }
    }
}
