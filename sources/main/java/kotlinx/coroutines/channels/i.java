package kotlinx.coroutines.channels;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.n1;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.internal.x0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    @NotNull
    private static final s0 A;
    private static final int B = 0;
    private static final int C = 1;
    private static final int D = 2;
    private static final int E = 3;
    private static final int F = 60;
    private static final long G = 1152921504606846975L;
    private static final long H = 4611686018427387904L;
    private static final long I = 4611686018427387903L;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final o<Object> f48195a = new o<>(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public static final int f48196b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f48197c;

    /* renamed from: d, reason: collision with root package name */
    private static final long f48198d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static final long f48199e = Long.MAX_VALUE;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final s0 f48200f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final s0 f48201g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final s0 f48202h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final s0 f48203i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final s0 f48204j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final s0 f48205k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final s0 f48206l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final s0 f48207m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final s0 f48208n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final s0 f48209o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final s0 f48210p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final s0 f48211q;

    /* renamed from: r, reason: collision with root package name */
    private static final int f48212r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static final int f48213s = 1;

    /* renamed from: t, reason: collision with root package name */
    private static final int f48214t = 2;

    /* renamed from: u, reason: collision with root package name */
    private static final int f48215u = 3;

    /* renamed from: v, reason: collision with root package name */
    private static final int f48216v = 4;

    /* renamed from: w, reason: collision with root package name */
    private static final int f48217w = 5;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private static final s0 f48218x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private static final s0 f48219y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private static final s0 f48220z;

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class a<E> extends FunctionReferenceImpl implements Function2<Long, o<E>, o<E>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f48221a = new a();

        a() {
            super(2, i.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long l6, Object obj) {
            return c(l6.longValue(), (o) obj);
        }

        @NotNull
        public final o<E> c(long j6, @NotNull o<E> oVar) {
            return i.x(j6, oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean F(kotlinx.coroutines.p<? super T> pVar, T t5, Function1<? super Throwable, n1> function1) {
        Object O = pVar.O(t5, null, function1);
        if (O == null) {
            return false;
        }
        pVar.B(O);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j6, int i6) {
        return (i6 << 60) + j6;
    }

    static {
        int e6;
        int e7;
        e6 = x0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f48196b = e6;
        e7 = x0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f48197c = e7;
        f48200f = new s0("BUFFERED");
        f48201g = new s0("SHOULD_BUFFER");
        f48202h = new s0("S_RESUMING_BY_RCV");
        f48203i = new s0("RESUMING_BY_EB");
        f48204j = new s0("POISONED");
        f48205k = new s0("DONE_RCV");
        f48206l = new s0("INTERRUPTED_SEND");
        f48207m = new s0("INTERRUPTED_RCV");
        f48208n = new s0("CHANNEL_CLOSED");
        f48209o = new s0("SUSPEND");
        f48210p = new s0("SUSPEND_NO_WAITER");
        f48211q = new s0("FAILED");
        f48218x = new s0("NO_RECEIVE_RESULT");
        f48219y = new s0("CLOSE_HANDLER_CLOSED");
        f48220z = new s0("CLOSE_HANDLER_INVOKED");
        A = new s0("NO_CLOSE_CAUSE");
    }

    private static final boolean B(long j6) {
        return (j6 & 4611686018427387904L) != 0;
    }

    private static final int C(long j6) {
        return (int) (j6 >> 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long E(int i6) {
        if (i6 == 0) {
            return 0L;
        }
        if (i6 != Integer.MAX_VALUE) {
            return i6;
        }
        return Long.MAX_VALUE;
    }

    static /* synthetic */ boolean G(kotlinx.coroutines.p pVar, Object obj, Function1 function1, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            function1 = null;
        }
        return F(pVar, obj, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j6, boolean z5) {
        return (z5 ? 4611686018427387904L : 0L) + j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> o<E> x(long j6, o<E> oVar) {
        return new o<>(j6, oVar, oVar.w(), 0);
    }

    @NotNull
    public static final <E> kotlin.reflect.i<o<E>> y() {
        return a.f48221a;
    }

    @NotNull
    public static final s0 z() {
        return f48208n;
    }

    private static final long A(long j6) {
        return j6 & 4611686018427387903L;
    }

    private static final long D(long j6) {
        return j6 & G;
    }
}
