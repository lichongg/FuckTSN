package kotlinx.coroutines.channels;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        long f48155a;

        /* renamed from: b, reason: collision with root package name */
        Object f48156b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48157c;

        /* renamed from: d, reason: collision with root package name */
        int f48158d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48157c = obj;
            this.f48158d |= Integer.MIN_VALUE;
            return d0.c(0L, 0L, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        long f48159a;

        /* renamed from: b, reason: collision with root package name */
        long f48160b;

        /* renamed from: c, reason: collision with root package name */
        Object f48161c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48162d;

        /* renamed from: e, reason: collision with root package name */
        int f48163e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48162d = obj;
            this.f48163e |= Integer.MIN_VALUE;
            return d0.d(0L, 0L, null, this);
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<z<? super n1>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48164a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48165b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TickerMode f48166c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f48167d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f48168e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f48169a;

            static {
                int[] iArr = new int[TickerMode.values().length];
                try {
                    iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f48169a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TickerMode tickerMode, long j6, long j7, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f48166c = tickerMode;
            this.f48167d = j6;
            this.f48168e = j7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            c cVar = new c(this.f48166c, this.f48167d, this.f48168e, eVar);
            cVar.f48165b = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull z<? super n1> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        
            if (kotlinx.coroutines.channels.d0.c(r4, r6, r8, r10) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        
            if (kotlinx.coroutines.channels.d0.d(r1, r3, r11, r10) == r0) goto L19;
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
                int r1 = r10.f48164a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.g0.n(r11)
                r6 = r10
                goto L5c
            L13:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1b:
                kotlin.g0.n(r11)
                goto L5c
            L1f:
                kotlin.g0.n(r11)
                java.lang.Object r11 = r10.f48165b
                kotlinx.coroutines.channels.z r11 = (kotlinx.coroutines.channels.z) r11
                kotlinx.coroutines.channels.TickerMode r1 = r10.f48166c
                int[] r4 = kotlinx.coroutines.channels.d0.c.a.f48169a
                int r1 = r1.ordinal()
                r1 = r4[r1]
                if (r1 == r3) goto L48
                if (r1 == r2) goto L35
                goto L5c
            L35:
                long r4 = r10.f48167d
                long r6 = r10.f48168e
                kotlinx.coroutines.channels.c0 r8 = r11.getChannel()
                r10.f48164a = r2
                r9 = r10
                java.lang.Object r11 = kotlinx.coroutines.channels.d0.a(r4, r6, r8, r9)
                r6 = r9
                if (r11 != r0) goto L5c
                goto L5b
            L48:
                r6 = r10
                long r1 = r6.f48167d
                r5 = 1
                long r3 = r6.f48168e
                kotlinx.coroutines.channels.c0 r11 = r11.getChannel()
                r6.f48164a = r5
                r5 = r11
                java.lang.Object r11 = kotlinx.coroutines.channels.d0.b(r1, r3, r5, r6)
                if (r11 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.n1 r11 = kotlin.n1.f44123a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.d0.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:
    
        if (kotlinx.coroutines.a1.b(r6, r0) != r1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (kotlinx.coroutines.a1.b(r8, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007d -> B:12:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(long r6, long r8, kotlinx.coroutines.channels.c0<? super kotlin.n1> r10, kotlin.coroutines.e<? super kotlin.n1> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.d0.a
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.channels.d0$a r0 = (kotlinx.coroutines.channels.d0.a) r0
            int r1 = r0.f48158d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48158d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.d0$a r0 = new kotlinx.coroutines.channels.d0$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f48157c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48158d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L48
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            long r6 = r0.f48155a
            java.lang.Object r8 = r0.f48156b
            kotlinx.coroutines.channels.c0 r8 = (kotlinx.coroutines.channels.c0) r8
            kotlin.g0.n(r11)
        L34:
            r10 = r8
            goto L63
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            long r6 = r0.f48155a
            java.lang.Object r8 = r0.f48156b
            kotlinx.coroutines.channels.c0 r8 = (kotlinx.coroutines.channels.c0) r8
            kotlin.g0.n(r11)
            goto L73
        L48:
            long r6 = r0.f48155a
            java.lang.Object r8 = r0.f48156b
            r10 = r8
            kotlinx.coroutines.channels.c0 r10 = (kotlinx.coroutines.channels.c0) r10
            kotlin.g0.n(r11)
            goto L63
        L53:
            kotlin.g0.n(r11)
            r0.f48156b = r10
            r0.f48155a = r6
            r0.f48158d = r5
            java.lang.Object r8 = kotlinx.coroutines.a1.b(r8, r0)
            if (r8 != r1) goto L63
            goto L7f
        L63:
            kotlin.n1 r8 = kotlin.n1.f44123a
            r0.f48156b = r10
            r0.f48155a = r6
            r0.f48158d = r4
            java.lang.Object r8 = r10.T(r8, r0)
            if (r8 != r1) goto L72
            goto L7f
        L72:
            r8 = r10
        L73:
            r0.f48156b = r8
            r0.f48155a = r6
            r0.f48158d = r3
            java.lang.Object r9 = kotlinx.coroutines.a1.b(r6, r0)
            if (r9 != r1) goto L34
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.d0.c(long, long, kotlinx.coroutines.channels.c0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f4, code lost:
    
        if (kotlinx.coroutines.a1.b(r4, r1) == r2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010d, code lost:
    
        if (kotlinx.coroutines.a1.b(r4, r1) != r2) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f4 -> B:13:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x010d -> B:13:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(long r18, long r20, kotlinx.coroutines.channels.c0<? super kotlin.n1> r22, kotlin.coroutines.e<? super kotlin.n1> r23) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.d0.d(long, long, kotlinx.coroutines.channels.c0, kotlin.coroutines.e):java.lang.Object");
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final b0<n1> e(long j6, long j7, @NotNull kotlin.coroutines.i iVar, @NotNull TickerMode tickerMode) {
        if (j6 < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j6 + " ms").toString());
        }
        if (j7 >= 0) {
            return x.c(w1.f49676a, g1.g().plus(iVar), 0, new c(tickerMode, j6, j7, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j7 + " ms").toString());
    }

    public static /* synthetic */ b0 f(long j6, long j7, kotlin.coroutines.i iVar, TickerMode tickerMode, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j7 = j6;
        }
        if ((i6 & 4) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return e(j6, j7, iVar, tickerMode);
    }
}
