package kotlinx.coroutines.channels;

import com.google.common.primitives.Longs;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.j;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.internal.q0;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.r3;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class BufferedChannel<E> implements kotlinx.coroutines.channels.j<E> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f48113d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f48114e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f48115f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f48116g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48117h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48118i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48119j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48120k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48121l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    @Volatile
    @Nullable
    private volatile Object _closeCause;

    /* renamed from: a, reason: collision with root package name */
    private final int f48122a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Function1<E, n1> f48123b;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final Function3<kotlinx.coroutines.selects.m<?>, Object, Object, Function1<Throwable, n1>> f48124c;

    @Volatile
    @Nullable
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;

    @Volatile
    @Nullable
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    @Nullable
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    private final class a implements kotlinx.coroutines.channels.l<E>, r3 {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private Object f48125a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private kotlinx.coroutines.q<? super Boolean> f48126b;

        public a() {
            s0 s0Var;
            s0Var = kotlinx.coroutines.channels.i.f48218x;
            this.f48125a = s0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object h(o<E> oVar, int i6, long j6, kotlin.coroutines.e<? super Boolean> eVar) {
            s0 s0Var;
            s0 s0Var2;
            Boolean a6;
            Function1<E, n1> function1;
            kotlin.coroutines.i context;
            o oVar2;
            s0 s0Var3;
            s0 s0Var4;
            s0 s0Var5;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            kotlinx.coroutines.q b6 = kotlinx.coroutines.s.b(kotlin.coroutines.intrinsics.a.e(eVar));
            try {
                this.f48126b = b6;
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object A1 = bufferedChannel.A1(oVar, i6, j6, this);
                s0Var = kotlinx.coroutines.channels.i.f48209o;
                if (A1 == s0Var) {
                    bufferedChannel.S0(this, oVar, i6);
                } else {
                    s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                    Function1<Throwable, n1> function12 = null;
                    if (A1 == s0Var2) {
                        if (j6 < bufferedChannel.o0()) {
                            oVar.b();
                        }
                        o oVar3 = (o) BufferedChannel.f48118i.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.D()) {
                                j();
                                break;
                            }
                            long andIncrement = BufferedChannel.f48114e.getAndIncrement(bufferedChannel);
                            int i7 = kotlinx.coroutines.channels.i.f48196b;
                            long j7 = andIncrement / i7;
                            int i8 = (int) (andIncrement % i7);
                            if (oVar3.f49297c != j7) {
                                oVar2 = bufferedChannel.b0(j7, oVar3);
                                if (oVar2 == null) {
                                }
                            } else {
                                oVar2 = oVar3;
                            }
                            A1 = bufferedChannel.A1(oVar2, i8, andIncrement, this);
                            s0Var3 = kotlinx.coroutines.channels.i.f48209o;
                            if (A1 == s0Var3) {
                                bufferedChannel.S0(this, oVar2, i8);
                                break;
                            }
                            s0Var4 = kotlinx.coroutines.channels.i.f48211q;
                            if (A1 == s0Var4) {
                                if (andIncrement < bufferedChannel.o0()) {
                                    oVar2.b();
                                }
                                oVar3 = oVar2;
                            } else {
                                s0Var5 = kotlinx.coroutines.channels.i.f48210p;
                                if (A1 == s0Var5) {
                                    throw new IllegalStateException("unexpected");
                                }
                                oVar2.b();
                                this.f48125a = A1;
                                this.f48126b = null;
                                a6 = kotlin.coroutines.jvm.internal.a.a(true);
                                function1 = bufferedChannel.f48123b;
                                if (function1 != null) {
                                    context = b6.getContext();
                                }
                            }
                        }
                    } else {
                        oVar.b();
                        this.f48125a = A1;
                        this.f48126b = null;
                        a6 = kotlin.coroutines.jvm.internal.a.a(true);
                        function1 = bufferedChannel.f48123b;
                        if (function1 != null) {
                            context = b6.getContext();
                            function12 = j0.a(function1, A1, context);
                        }
                        b6.o(a6, function12);
                    }
                }
                Object x5 = b6.x();
                if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                    kotlin.coroutines.jvm.internal.e.c(eVar);
                }
                return x5;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                b6.N();
                throw th3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j() {
            kotlinx.coroutines.q<? super Boolean> qVar = this.f48126b;
            g0.m(qVar);
            this.f48126b = null;
            this.f48125a = kotlinx.coroutines.channels.i.z();
            Throwable f02 = BufferedChannel.this.f0();
            if (f02 == null) {
                Result.a aVar = Result.Companion;
                qVar.resumeWith(Result.m130constructorimpl(Boolean.FALSE));
            } else {
                Result.a aVar2 = Result.Companion;
                qVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(f02)));
            }
        }

        @Override // kotlinx.coroutines.r3
        public void b(@NotNull p0<?> p0Var, int i6) {
            kotlinx.coroutines.q<? super Boolean> qVar = this.f48126b;
            if (qVar != null) {
                qVar.b(p0Var, i6);
            }
        }

        @Override // kotlinx.coroutines.channels.l
        @Nullable
        public Object c(@NotNull kotlin.coroutines.e<? super Boolean> eVar) {
            s0 s0Var;
            s0 s0Var2;
            s0 s0Var3;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            o<E> oVar = (o) BufferedChannel.f48118i.get(bufferedChannel);
            while (!bufferedChannel.D()) {
                long andIncrement = BufferedChannel.f48114e.getAndIncrement(bufferedChannel);
                int i6 = kotlinx.coroutines.channels.i.f48196b;
                long j6 = andIncrement / i6;
                int i7 = (int) (andIncrement % i6);
                if (oVar.f49297c != j6) {
                    o<E> b02 = bufferedChannel.b0(j6, oVar);
                    if (b02 == null) {
                        continue;
                    } else {
                        oVar = b02;
                    }
                }
                Object A1 = bufferedChannel.A1(oVar, i7, andIncrement, null);
                s0Var = kotlinx.coroutines.channels.i.f48209o;
                if (A1 == s0Var) {
                    throw new IllegalStateException("unreachable");
                }
                s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                if (A1 != s0Var2) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                    if (A1 == s0Var3) {
                        return h(oVar, i7, andIncrement, eVar);
                    }
                    oVar.b();
                    this.f48125a = A1;
                    return kotlin.coroutines.jvm.internal.a.a(true);
                }
                if (andIncrement < bufferedChannel.o0()) {
                    oVar.b();
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(i());
        }

        public final boolean k(E e6) {
            boolean F;
            kotlinx.coroutines.q<? super Boolean> qVar = this.f48126b;
            g0.m(qVar);
            this.f48126b = null;
            this.f48125a = e6;
            Boolean bool = Boolean.TRUE;
            Function1<E, n1> function1 = BufferedChannel.this.f48123b;
            F = kotlinx.coroutines.channels.i.F(qVar, bool, function1 != null ? j0.a(function1, e6, qVar.getContext()) : null);
            return F;
        }

        public final void l() {
            kotlinx.coroutines.q<? super Boolean> qVar = this.f48126b;
            g0.m(qVar);
            this.f48126b = null;
            this.f48125a = kotlinx.coroutines.channels.i.z();
            Throwable f02 = BufferedChannel.this.f0();
            if (f02 == null) {
                Result.a aVar = Result.Companion;
                qVar.resumeWith(Result.m130constructorimpl(Boolean.FALSE));
            } else {
                Result.a aVar2 = Result.Companion;
                qVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(f02)));
            }
        }

        @Override // kotlinx.coroutines.channels.l
        public E next() {
            s0 s0Var;
            s0 s0Var2;
            E e6 = (E) this.f48125a;
            s0Var = kotlinx.coroutines.channels.i.f48218x;
            if (e6 == s0Var) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            s0Var2 = kotlinx.coroutines.channels.i.f48218x;
            this.f48125a = s0Var2;
            if (e6 != kotlinx.coroutines.channels.i.z()) {
                return e6;
            }
            throw r0.o(BufferedChannel.this.l0());
        }

        private final boolean i() {
            this.f48125a = kotlinx.coroutines.channels.i.z();
            Throwable f02 = BufferedChannel.this.f0();
            if (f02 == null) {
                return false;
            }
            throw r0.o(f02);
        }

        @Override // kotlinx.coroutines.channels.l
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object a(kotlin.coroutines.e eVar) {
            return l.a.a(this, eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements r3 {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlinx.coroutines.p<Boolean> f48128a;

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ kotlinx.coroutines.q<Boolean> f48129b;

        @NotNull
        public final kotlinx.coroutines.p<Boolean> a() {
            return this.f48128a;
        }

        @Override // kotlinx.coroutines.r3
        public void b(@NotNull p0<?> p0Var, int i6) {
            this.f48129b.b(p0Var, i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull kotlinx.coroutines.p<? super Boolean> pVar) {
            this.f48128a = pVar;
            g0.n(pVar, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f48129b = (kotlinx.coroutines.q) pVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class c extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, kotlinx.coroutines.selects.m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f48130a = new c();

        c() {
            super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(bufferedChannel, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull BufferedChannel<?> bufferedChannel, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            bufferedChannel.f1(mVar, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class d extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f48131a = new d();

        d() {
            super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull BufferedChannel<?> bufferedChannel, @Nullable Object obj, @Nullable Object obj2) {
            return bufferedChannel.U0(obj, obj2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class e extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, kotlinx.coroutines.selects.m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f48132a = new e();

        e() {
            super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(bufferedChannel, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull BufferedChannel<?> bufferedChannel, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            bufferedChannel.f1(mVar, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class f extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f48133a = new f();

        f() {
            super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull BufferedChannel<?> bufferedChannel, @Nullable Object obj, @Nullable Object obj2) {
            return bufferedChannel.V0(obj, obj2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class g extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, kotlinx.coroutines.selects.m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f48134a = new g();

        g() {
            super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(bufferedChannel, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull BufferedChannel<?> bufferedChannel, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            bufferedChannel.f1(mVar, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class h extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final h f48135a = new h();

        h() {
            super(3, BufferedChannel.class, "processResultSelectReceiveOrNull", "processResultSelectReceiveOrNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull BufferedChannel<?> bufferedChannel, @Nullable Object obj, @Nullable Object obj2) {
            return bufferedChannel.W0(obj, obj2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class i extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, kotlinx.coroutines.selects.m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final i f48136a = new i();

        i() {
            super(3, BufferedChannel.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(bufferedChannel, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull BufferedChannel<?> bufferedChannel, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            bufferedChannel.g1(mVar, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class j extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final j f48137a = new j();

        j() {
            super(3, BufferedChannel.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull BufferedChannel<?> bufferedChannel, @Nullable Object obj, @Nullable Object obj2) {
            return bufferedChannel.X0(obj, obj2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class k extends Lambda implements Function3<kotlinx.coroutines.selects.m<?>, Object, Object, Function1<? super Throwable, ? extends n1>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BufferedChannel<E> f48138a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a extends Lambda implements Function1<Throwable, n1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f48139a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ BufferedChannel<E> f48140b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.selects.m<?> f48141c;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, BufferedChannel<E> bufferedChannel, kotlinx.coroutines.selects.m<?> mVar) {
                super(1);
                this.f48139a = obj;
                this.f48140b = bufferedChannel;
                this.f48141c = mVar;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                if (this.f48139a != kotlinx.coroutines.channels.i.z()) {
                    j0.b(this.f48140b.f48123b, this.f48139a, this.f48141c.getContext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(BufferedChannel<E> bufferedChannel) {
            super(3);
            this.f48138a = bufferedChannel;
        }

        @Override // kotlin.jvm.functions.Function3
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function1<Throwable, n1> invoke(@NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj, @Nullable Object obj2) {
            return new a(obj2, this.f48138a, mVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {}, l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl", n = {}, s = {})
    static final class l<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f48142a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BufferedChannel<E> f48143b;

        /* renamed from: c, reason: collision with root package name */
        int f48144c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(BufferedChannel<E> bufferedChannel, kotlin.coroutines.e<? super l> eVar) {
            super(eVar);
            this.f48143b = bufferedChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48142a = obj;
            this.f48144c |= Integer.MIN_VALUE;
            Object Z0 = BufferedChannel.Z0(this.f48143b, this);
            return Z0 == kotlin.coroutines.intrinsics.a.l() ? Z0 : n.b(Z0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", i = {0, 0, 0, 0}, l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", n = {"this", "segment", "index", com.kuaishou.weapon.p0.t.f36150k}, s = {"L$0", "L$1", "I$0", "J$0"})
    static final class m extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48145a;

        /* renamed from: b, reason: collision with root package name */
        Object f48146b;

        /* renamed from: c, reason: collision with root package name */
        int f48147c;

        /* renamed from: d, reason: collision with root package name */
        long f48148d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48149e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ BufferedChannel<E> f48150f;

        /* renamed from: g, reason: collision with root package name */
        int f48151g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(BufferedChannel<E> bufferedChannel, kotlin.coroutines.e<? super m> eVar) {
            super(eVar);
            this.f48150f = bufferedChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48149e = obj;
            this.f48151g |= Integer.MIN_VALUE;
            Object a12 = this.f48150f.a1(null, 0, 0L, this);
            return a12 == kotlin.coroutines.intrinsics.a.l() ? a12 : n.b(a12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i6, @Nullable Function1<? super E, n1> function1) {
        long E;
        s0 s0Var;
        this.f48122a = i6;
        this.f48123b = function1;
        if (i6 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i6 + ", should be >=0").toString());
        }
        E = kotlinx.coroutines.channels.i.E(i6);
        this.bufferEnd = E;
        this.completedExpandBuffersAndPauseFlag = e0();
        o oVar = new o(0L, null, this, 3);
        this.sendSegment = oVar;
        this.receiveSegment = oVar;
        if (B0()) {
            oVar = kotlinx.coroutines.channels.i.f48195a;
            g0.n(oVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = oVar;
        this.f48124c = function1 != 0 ? new k(this) : null;
        s0Var = kotlinx.coroutines.channels.i.A;
        this._closeCause = s0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(o<E> oVar, long j6) {
        s0 s0Var;
        Object c6 = kotlinx.coroutines.internal.q.c(null, 1, null);
        loop0: while (oVar != null) {
            for (int i6 = kotlinx.coroutines.channels.i.f48196b - 1; -1 < i6; i6--) {
                if ((oVar.f49297c * kotlinx.coroutines.channels.i.f48196b) + i6 < j6) {
                    break loop0;
                }
                while (true) {
                    Object y5 = oVar.y(i6);
                    if (y5 != null) {
                        s0Var = kotlinx.coroutines.channels.i.f48201g;
                        if (y5 != s0Var) {
                            if (!(y5 instanceof e0)) {
                                if (!(y5 instanceof r3)) {
                                    break;
                                }
                                if (oVar.t(i6, y5, kotlinx.coroutines.channels.i.z())) {
                                    c6 = kotlinx.coroutines.internal.q.h(c6, y5);
                                    oVar.z(i6, true);
                                    break;
                                }
                            } else {
                                if (oVar.t(i6, y5, kotlinx.coroutines.channels.i.z())) {
                                    c6 = kotlinx.coroutines.internal.q.h(c6, ((e0) y5).f48187a);
                                    oVar.z(i6, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (oVar.t(i6, y5, kotlinx.coroutines.channels.i.z())) {
                        oVar.r();
                        break;
                    }
                }
            }
            oVar = (o) oVar.g();
        }
        if (c6 != null) {
            if (!(c6 instanceof ArrayList)) {
                i1((r3) c6);
                return;
            }
            g0.n(c6, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) c6;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                i1((r3) arrayList.get(size));
            }
        }
    }

    private final o<E> a0(long j6, o<E> oVar, long j7) {
        Object g6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48119j;
        Function2 function2 = (Function2) kotlinx.coroutines.channels.i.y();
        loop0: while (true) {
            g6 = kotlinx.coroutines.internal.f.g(oVar, j6, function2);
            if (!q0.h(g6)) {
                p0 f6 = q0.f(g6);
                while (true) {
                    p0 p0Var = (p0) atomicReferenceFieldUpdater.get(this);
                    if (p0Var.f49297c >= f6.f49297c) {
                        break loop0;
                    }
                    if (!f6.s()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, p0Var, f6)) {
                        if (p0Var.o()) {
                            p0Var.l();
                        }
                    } else if (f6.o()) {
                        f6.l();
                    }
                }
            } else {
                break;
            }
        }
        if (q0.h(g6)) {
            X();
            I0(j6, oVar);
            r0(this, 0L, 1, null);
            return null;
        }
        o<E> oVar2 = (o) q0.f(g6);
        long j8 = oVar2.f49297c;
        if (j8 <= j6) {
            return oVar2;
        }
        int i6 = kotlinx.coroutines.channels.i.f48196b;
        if (f48115f.compareAndSet(this, j7 + 1, j8 * i6)) {
            q0((oVar2.f49297c * i6) - j7);
        } else {
            r0(this, 0L, 1, null);
        }
        return null;
    }

    private final void i1(r3 r3Var) {
        k1(r3Var, true);
    }

    private final void j1(r3 r3Var) {
        k1(r3Var, false);
    }

    private final void q1(o<E> oVar, int i6, E e6, long j6, r3 r3Var, Function0<n1> function0, Function0<n1> function02) {
        BufferedChannel<E> bufferedChannel;
        E e7;
        r3 r3Var2;
        int C1 = C1(oVar, i6, e6, j6, r3Var, false);
        if (C1 == 0) {
            oVar.b();
            function0.invoke();
            return;
        }
        if (C1 == 1) {
            function0.invoke();
            return;
        }
        if (C1 == 2) {
            T0(r3Var, oVar, i6);
            return;
        }
        if (C1 == 4) {
            if (j6 < m0()) {
                oVar.b();
            }
            function02.invoke();
            return;
        }
        String str = "unexpected";
        if (C1 != 5) {
            throw new IllegalStateException("unexpected");
        }
        oVar.b();
        o oVar2 = (o) f48117h.get(this);
        while (true) {
            long andIncrement = f48113d.getAndIncrement(this);
            long j7 = 1152921504606846975L & andIncrement;
            boolean y02 = y0(andIncrement);
            int i7 = kotlinx.coroutines.channels.i.f48196b;
            long j8 = j7 / i7;
            int i8 = (int) (j7 % i7);
            String str2 = str;
            if (oVar2.f49297c != j8) {
                o c02 = c0(j8, oVar2);
                if (c02 != null) {
                    oVar2 = c02;
                    bufferedChannel = this;
                    r3Var2 = r3Var;
                    e7 = e6;
                } else {
                    if (y02) {
                        function02.invoke();
                        return;
                    }
                    str = str2;
                }
            } else {
                bufferedChannel = this;
                e7 = e6;
                r3Var2 = r3Var;
            }
            int C12 = bufferedChannel.C1(oVar2, i8, e7, j7, r3Var2, y02);
            if (C12 == 0) {
                oVar2.b();
                function0.invoke();
                return;
            }
            if (C12 == 1) {
                function0.invoke();
                return;
            }
            if (C12 == 2) {
                if (y02) {
                    oVar2.r();
                    function02.invoke();
                    return;
                } else {
                    r3 r3Var3 = androidx.activity.k.a(r3Var) ? r3Var : null;
                    if (r3Var3 != null) {
                        T0(r3Var3, oVar2, i8);
                    }
                    n1 n1Var = n1.f44123a;
                    return;
                }
            }
            if (C12 == 3) {
                throw new IllegalStateException(str2);
            }
            if (C12 == 4) {
                if (j7 < m0()) {
                    oVar2.b();
                }
                function02.invoke();
                return;
            } else {
                if (C12 == 5) {
                    oVar2.b();
                }
                str = str2;
            }
        }
    }

    private final boolean w0(long j6) {
        return u0(j6, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y0(long j6) {
        return u0(j6, false);
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean S(@Nullable Throwable th) {
        return U(th, false);
    }

    @Override // kotlinx.coroutines.channels.b0
    public final void cancel() {
        M(null);
    }

    protected boolean z0() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r9 = (kotlinx.coroutines.channels.o) r9.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long E0(kotlinx.coroutines.channels.o<E> r9) {
        /*
            r8 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.i.f48196b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3d
            long r3 = r9.f49297c
            int r5 = kotlinx.coroutines.channels.i.f48196b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r8.m0()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L1b
            return r1
        L1b:
            java.lang.Object r1 = r9.y(r0)
            if (r1 == 0) goto L2d
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.k()
            if (r1 != r2) goto L28
            goto L2d
        L28:
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.f48200f
            if (r1 != r2) goto L3a
            return r3
        L2d:
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.z()
            boolean r1 = r9.t(r0, r1, r2)
            if (r1 == 0) goto L1b
            r9.r()
        L3a:
            int r0 = r0 + (-1)
            goto L4
        L3d:
            kotlinx.coroutines.internal.g r9 = r9.g()
            kotlinx.coroutines.channels.o r9 = (kotlinx.coroutines.channels.o) r9
            if (r9 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.E0(kotlinx.coroutines.channels.o):long");
    }

    private final void E1(long j6) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f48114e;
        while (true) {
            long j7 = atomicLongFieldUpdater.get(this);
            if (j7 >= j6) {
                return;
            }
            long j8 = j6;
            if (f48114e.compareAndSet(this, j7, j8)) {
                return;
            } else {
                j6 = j8;
            }
        }
    }

    private final void F0() {
        long j6;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f48113d;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if (((int) (j6 >> 60)) != 0) {
                return;
            } else {
                w5 = kotlinx.coroutines.channels.i.w(1152921504606846975L & j6, 1);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, w5));
    }

    private final void F1(long j6) {
        long j7;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f48113d;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            long j8 = 1152921504606846975L & j7;
            if (j8 >= j6) {
                return;
            } else {
                w5 = kotlinx.coroutines.channels.i.w(j8, (int) (j7 >> 60));
            }
        } while (!f48113d.compareAndSet(this, j7, w5));
    }

    private final void G0() {
        long j6;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f48113d;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            w5 = kotlinx.coroutines.channels.i.w(1152921504606846975L & j6, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, w5));
    }

    private final void H0() {
        long j6;
        long w5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f48113d;
        do {
            j6 = atomicLongFieldUpdater.get(this);
            int i6 = (int) (j6 >> 60);
            if (i6 == 0) {
                w5 = kotlinx.coroutines.channels.i.w(1152921504606846975L & j6, 2);
            } else if (i6 != 1) {
                return;
            } else {
                w5 = kotlinx.coroutines.channels.i.w(1152921504606846975L & j6, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, w5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void I0(long r6, kotlinx.coroutines.channels.o<E> r8) {
        /*
            r5 = this;
        L0:
            long r0 = r8.f49297c
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L11
            kotlinx.coroutines.internal.g r0 = r8.e()
            kotlinx.coroutines.channels.o r0 = (kotlinx.coroutines.channels.o) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r8 = r0
            goto L0
        L11:
            boolean r6 = r8.h()
            if (r6 == 0) goto L22
            kotlinx.coroutines.internal.g r6 = r8.e()
            kotlinx.coroutines.channels.o r6 = (kotlinx.coroutines.channels.o) r6
            if (r6 != 0) goto L20
            goto L22
        L20:
            r8 = r6
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.channels.BufferedChannel.f48119j
        L24:
            java.lang.Object r7 = r6.get(r5)
            kotlinx.coroutines.internal.p0 r7 = (kotlinx.coroutines.internal.p0) r7
            long r0 = r7.f49297c
            long r2 = r8.f49297c
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L33
            return
        L33:
            boolean r0 = r8.s()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = androidx.concurrent.futures.a.a(r6, r5, r7, r8)
            if (r0 == 0) goto L4a
            boolean r6 = r7.o()
            if (r6 == 0) goto L49
            r7.l()
        L49:
            return
        L4a:
            boolean r7 = r8.o()
            if (r7 == 0) goto L24
            r8.l()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.I0(long, kotlinx.coroutines.channels.o):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(kotlinx.coroutines.p<? super n<? extends E>> pVar) {
        Result.a aVar = Result.Companion;
        pVar.resumeWith(Result.m130constructorimpl(n.b(n.f48241b.a(f0()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(kotlinx.coroutines.p<? super E> pVar) {
        Result.a aVar = Result.Companion;
        pVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(l0())));
    }

    private final void N0(E e6, kotlinx.coroutines.selects.m<?> mVar) {
        Function1<E, n1> function1 = this.f48123b;
        if (function1 != null) {
            j0.b(function1, e6, mVar.getContext());
        }
        mVar.f(kotlinx.coroutines.channels.i.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object O0(E e6, kotlin.coroutines.e<? super n1> eVar) {
        UndeliveredElementException d6;
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        Function1<E, n1> function1 = this.f48123b;
        if (function1 == null || (d6 = j0.d(function1, e6, null, 2, null)) == null) {
            Throwable n02 = n0();
            Result.a aVar = Result.Companion;
            qVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(n02)));
        } else {
            kotlin.l.a(d6, n0());
            Result.a aVar2 = Result.Companion;
            qVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(d6)));
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(E e6, kotlinx.coroutines.p<? super n1> pVar) {
        Function1<E, n1> function1 = this.f48123b;
        if (function1 != null) {
            j0.b(function1, e6, pVar.getContext());
        }
        Throwable n02 = n0();
        Result.a aVar = Result.Companion;
        pVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(n02)));
    }

    private final o<E> Q() {
        Object obj = f48119j.get(this);
        o oVar = (o) f48117h.get(this);
        if (oVar.f49297c > ((o) obj).f49297c) {
            obj = oVar;
        }
        o oVar2 = (o) f48118i.get(this);
        if (oVar2.f49297c > ((o) obj).f49297c) {
            obj = oVar2;
        }
        return (o) kotlinx.coroutines.internal.f.d((kotlinx.coroutines.internal.g) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(r3 r3Var, o<E> oVar, int i6) {
        r3Var.b(oVar, i6 + kotlinx.coroutines.channels.i.f48196b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r14v12, types: [kotlinx.coroutines.channels.n$b] */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ <E> java.lang.Object Z0(kotlinx.coroutines.channels.BufferedChannel<E> r13, kotlin.coroutines.e<? super kotlinx.coroutines.channels.n<? extends E>> r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel.l
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$l r0 = (kotlinx.coroutines.channels.BufferedChannel.l) r0
            int r1 = r0.f48144c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f48144c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$l r0 = new kotlinx.coroutines.channels.BufferedChannel$l
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f48142a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r6.f48144c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            kotlin.g0.n(r14)
            kotlinx.coroutines.channels.n r14 = (kotlinx.coroutines.channels.n) r14
            java.lang.Object r13 = r14.o()
            return r13
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            kotlin.g0.n(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = f()
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.o r14 = (kotlinx.coroutines.channels.o) r14
        L46:
            boolean r1 = r13.D()
            if (r1 == 0) goto L57
            kotlinx.coroutines.channels.n$b r14 = kotlinx.coroutines.channels.n.f48241b
            java.lang.Throwable r13 = r13.f0()
            java.lang.Object r13 = r14.a(r13)
            return r13
        L57:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = g()
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.i.f48196b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f49297c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L77
            kotlinx.coroutines.channels.o r1 = c(r13, r7, r14)
            if (r1 != 0) goto L75
            goto L46
        L75:
            r8 = r1
            goto L78
        L77:
            r8 = r14
        L78:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = J(r7, r8, r9, r10, r12)
            r1 = r7
            kotlinx.coroutines.internal.s0 r14 = kotlinx.coroutines.channels.i.r()
            if (r13 == r14) goto Lb6
            kotlinx.coroutines.internal.s0 r14 = kotlinx.coroutines.channels.i.h()
            if (r13 != r14) goto L9b
            long r13 = r1.o0()
            int r3 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r3 >= 0) goto L98
            r8.b()
        L98:
            r13 = r1
            r14 = r8
            goto L46
        L9b:
            kotlinx.coroutines.internal.s0 r14 = kotlinx.coroutines.channels.i.s()
            if (r13 != r14) goto Lac
            r6.f48144c = r2
            r2 = r8
            java.lang.Object r13 = r1.a1(r2, r3, r4, r6)
            if (r13 != r0) goto Lab
            return r0
        Lab:
            return r13
        Lac:
            r8.b()
            kotlinx.coroutines.channels.n$b r14 = kotlinx.coroutines.channels.n.f48241b
            java.lang.Object r13 = r14.c(r13)
            return r13
        Lb6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.Z0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a1(kotlinx.coroutines.channels.o<E> r11, int r12, long r13, kotlin.coroutines.e<? super kotlinx.coroutines.channels.n<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.a1(kotlinx.coroutines.channels.o, int, long, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o<E> b0(long j6, o<E> oVar) {
        Object g6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48118i;
        Function2 function2 = (Function2) kotlinx.coroutines.channels.i.y();
        loop0: while (true) {
            g6 = kotlinx.coroutines.internal.f.g(oVar, j6, function2);
            if (!q0.h(g6)) {
                p0 f6 = q0.f(g6);
                while (true) {
                    p0 p0Var = (p0) atomicReferenceFieldUpdater.get(this);
                    if (p0Var.f49297c >= f6.f49297c) {
                        break loop0;
                    }
                    if (!f6.s()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, p0Var, f6)) {
                        if (p0Var.o()) {
                            p0Var.l();
                        }
                    } else if (f6.o()) {
                        f6.l();
                    }
                }
            } else {
                break;
            }
        }
        if (q0.h(g6)) {
            X();
            if (oVar.f49297c * kotlinx.coroutines.channels.i.f48196b < o0()) {
                oVar.b();
            }
            return null;
        }
        o<E> oVar2 = (o) q0.f(g6);
        if (!B0() && j6 <= e0() / kotlinx.coroutines.channels.i.f48196b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f48119j;
            while (true) {
                p0 p0Var2 = (p0) atomicReferenceFieldUpdater2.get(this);
                if (p0Var2.f49297c >= oVar2.f49297c || !oVar2.s()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, p0Var2, oVar2)) {
                    if (p0Var2.o()) {
                        p0Var2.l();
                    }
                } else if (oVar2.o()) {
                    oVar2.l();
                }
            }
        }
        long j7 = oVar2.f49297c;
        if (j7 <= j6) {
            return oVar2;
        }
        int i6 = kotlinx.coroutines.channels.i.f48196b;
        E1(j7 * i6);
        if (oVar2.f49297c * i6 < o0()) {
            oVar2.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o<E> c0(long j6, o<E> oVar) {
        Object g6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48117h;
        Function2 function2 = (Function2) kotlinx.coroutines.channels.i.y();
        loop0: while (true) {
            g6 = kotlinx.coroutines.internal.f.g(oVar, j6, function2);
            if (!q0.h(g6)) {
                p0 f6 = q0.f(g6);
                while (true) {
                    p0 p0Var = (p0) atomicReferenceFieldUpdater.get(this);
                    if (p0Var.f49297c >= f6.f49297c) {
                        break loop0;
                    }
                    if (!f6.s()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, p0Var, f6)) {
                        if (p0Var.o()) {
                            p0Var.l();
                        }
                    } else if (f6.o()) {
                        f6.l();
                    }
                }
            } else {
                break;
            }
        }
        if (q0.h(g6)) {
            X();
            if (oVar.f49297c * kotlinx.coroutines.channels.i.f48196b < m0()) {
                oVar.b();
            }
            return null;
        }
        o<E> oVar2 = (o) q0.f(g6);
        long j7 = oVar2.f49297c;
        if (j7 <= j6) {
            return oVar2;
        }
        int i6 = kotlinx.coroutines.channels.i.f48196b;
        F1(j7 * i6);
        if (oVar2.f49297c * i6 < m0()) {
            oVar2.b();
        }
        return null;
    }

    static /* synthetic */ Object c1(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i6, Object obj2) {
        o oVar;
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        if ((i6 & 16) != 0) {
            function32 = new Function3() { // from class: kotlinx.coroutines.channels.BufferedChannel$receiveImpl$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5) {
                    return invoke((o) obj3, ((Number) obj4).intValue(), ((Number) obj5).longValue());
                }

                @NotNull
                public final Void invoke(@NotNull o<E> oVar2, int i7, long j6) {
                    throw new IllegalStateException("unexpected");
                }
            };
        }
        o oVar2 = (o) f48118i.get(bufferedChannel);
        while (!bufferedChannel.D()) {
            long andIncrement = f48114e.getAndIncrement(bufferedChannel);
            int i7 = kotlinx.coroutines.channels.i.f48196b;
            long j6 = andIncrement / i7;
            int i8 = (int) (andIncrement % i7);
            if (oVar2.f49297c != j6) {
                o b02 = bufferedChannel.b0(j6, oVar2);
                if (b02 == null) {
                    continue;
                } else {
                    oVar = b02;
                }
            } else {
                oVar = oVar2;
            }
            BufferedChannel bufferedChannel2 = bufferedChannel;
            Object obj3 = obj;
            Object A1 = bufferedChannel2.A1(oVar, i8, andIncrement, obj3);
            oVar2 = oVar;
            s0Var = kotlinx.coroutines.channels.i.f48209o;
            if (A1 == s0Var) {
                r3 r3Var = obj3 instanceof r3 ? (r3) obj3 : null;
                if (r3Var != null) {
                    bufferedChannel2.S0(r3Var, oVar2, i8);
                }
                return function3.invoke(oVar2, Integer.valueOf(i8), Long.valueOf(andIncrement));
            }
            s0Var2 = kotlinx.coroutines.channels.i.f48211q;
            if (A1 != s0Var2) {
                s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                if (A1 == s0Var3) {
                    return function32.invoke(oVar2, Integer.valueOf(i8), Long.valueOf(andIncrement));
                }
                oVar2.b();
                return function1.invoke(A1);
            }
            if (andIncrement < bufferedChannel2.o0()) {
                oVar2.b();
            }
            bufferedChannel = bufferedChannel2;
            obj = obj3;
        }
        return function0.invoke();
    }

    private final long e0() {
        return f48115f.get(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b4, code lost:
    
        r13 = (kotlinx.coroutines.channels.o) r13.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void h1(kotlinx.coroutines.channels.o<E> r13) {
        /*
            r12 = this;
            kotlin.jvm.functions.Function1<E, kotlin.n1> r0 = r12.f48123b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.q.c(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.i.f48196b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb4
            long r6 = r13.f49297c
            int r8 = kotlinx.coroutines.channels.i.f48196b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L17:
            java.lang.Object r8 = r13.y(r4)
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.f()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.f48200f
            if (r8 != r9) goto L49
            long r9 = r12.m0()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.z()
            boolean r8 = r13.t(r4, r8, r9)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L41
            java.lang.Object r5 = r13.x(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.j0.c(r0, r5, r1)
        L41:
            r13.u(r4)
            r13.r()
            goto Lb0
        L49:
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.k()
            if (r8 == r9) goto La3
            if (r8 != 0) goto L52
            goto La3
        L52:
            boolean r9 = r8 instanceof kotlinx.coroutines.r3
            if (r9 != 0) goto L6f
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.e0
            if (r9 == 0) goto L5b
            goto L6f
        L5b:
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.p()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.q()
            if (r8 != r9) goto L68
            goto Lbc
        L68:
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.p()
            if (r8 == r9) goto L17
            goto Lb0
        L6f:
            long r9 = r12.m0()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.e0
            if (r9 == 0) goto L81
            r9 = r8
            kotlinx.coroutines.channels.e0 r9 = (kotlinx.coroutines.channels.e0) r9
            kotlinx.coroutines.r3 r9 = r9.f48187a
            goto L84
        L81:
            r9 = r8
            kotlinx.coroutines.r3 r9 = (kotlinx.coroutines.r3) r9
        L84:
            kotlinx.coroutines.internal.s0 r10 = kotlinx.coroutines.channels.i.z()
            boolean r8 = r13.t(r4, r8, r10)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L98
            java.lang.Object r5 = r13.x(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.j0.c(r0, r5, r1)
        L98:
            java.lang.Object r3 = kotlinx.coroutines.internal.q.h(r3, r9)
            r13.u(r4)
            r13.r()
            goto Lb0
        La3:
            kotlinx.coroutines.internal.s0 r9 = kotlinx.coroutines.channels.i.z()
            boolean r8 = r13.t(r4, r8, r9)
            if (r8 == 0) goto L17
            r13.r()
        Lb0:
            int r4 = r4 + (-1)
            goto Lb
        Lb4:
            kotlinx.coroutines.internal.g r13 = r13.g()
            kotlinx.coroutines.channels.o r13 = (kotlinx.coroutines.channels.o) r13
            if (r13 != 0) goto L8
        Lbc:
            if (r3 == 0) goto Le2
            boolean r13 = r3 instanceof java.util.ArrayList
            if (r13 != 0) goto Lc8
            kotlinx.coroutines.r3 r3 = (kotlinx.coroutines.r3) r3
            r12.j1(r3)
            goto Le2
        Lc8:
            java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.g0.n(r3, r13)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r13 = r3.size()
            int r13 = r13 - r2
        Ld4:
            if (r5 >= r13) goto Le2
            java.lang.Object r0 = r3.get(r13)
            kotlinx.coroutines.r3 r0 = (kotlinx.coroutines.r3) r0
            r12.j1(r0)
            int r13 = r13 + (-1)
            goto Ld4
        Le2:
            if (r1 != 0) goto Le5
            return
        Le5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.h1(kotlinx.coroutines.channels.o):void");
    }

    private final void k1(r3 r3Var, boolean z5) {
        if (r3Var instanceof b) {
            kotlinx.coroutines.p<Boolean> a6 = ((b) r3Var).a();
            Result.a aVar = Result.Companion;
            a6.resumeWith(Result.m130constructorimpl(Boolean.FALSE));
            return;
        }
        if (r3Var instanceof kotlinx.coroutines.p) {
            kotlin.coroutines.e eVar = (kotlin.coroutines.e) r3Var;
            Result.a aVar2 = Result.Companion;
            eVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(z5 ? l0() : n0())));
        } else if (r3Var instanceof a0) {
            kotlinx.coroutines.q<n<? extends E>> qVar = ((a0) r3Var).f48152a;
            Result.a aVar3 = Result.Companion;
            qVar.resumeWith(Result.m130constructorimpl(n.b(n.f48241b.a(f0()))));
        } else if (r3Var instanceof a) {
            ((a) r3Var).l();
        } else {
            if (r3Var instanceof kotlinx.coroutines.selects.m) {
                ((kotlinx.coroutines.selects.m) r3Var).j(this, kotlinx.coroutines.channels.i.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + r3Var).toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
    
        r14 = kotlin.Result.Companion;
        r0.resumeWith(kotlin.Result.m130constructorimpl(kotlin.coroutines.jvm.internal.a.a(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ <E> java.lang.Object n1(kotlinx.coroutines.channels.BufferedChannel<E> r14, E r15, kotlin.coroutines.e<? super java.lang.Boolean> r16) {
        /*
            kotlinx.coroutines.q r0 = new kotlinx.coroutines.q
            kotlin.coroutines.e r1 = kotlin.coroutines.intrinsics.a.e(r16)
            r2 = 1
            r0.<init>(r1, r2)
            r0.Q()
            kotlin.jvm.functions.Function1<E, kotlin.n1> r1 = r14.f48123b
            if (r1 != 0) goto Lb7
            kotlinx.coroutines.channels.BufferedChannel$b r9 = new kotlinx.coroutines.channels.BufferedChannel$b
            r9.<init>(r0)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = h()
            java.lang.Object r1 = r1.get(r14)
            kotlinx.coroutines.channels.o r1 = (kotlinx.coroutines.channels.o) r1
        L20:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = j()
            long r3 = r3.getAndIncrement(r14)
            r5 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r7 = r3 & r5
            boolean r10 = k(r14, r3)
            int r3 = kotlinx.coroutines.channels.i.f48196b
            long r4 = (long) r3
            long r4 = r7 / r4
            long r11 = (long) r3
            long r11 = r7 % r11
            int r3 = (int) r11
            long r11 = r1.f49297c
            r13 = 0
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L5d
            kotlinx.coroutines.channels.o r4 = d(r14, r4, r1)
            if (r4 != 0) goto L59
            if (r10 == 0) goto L20
        L4b:
            kotlin.Result$a r14 = kotlin.Result.Companion
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.a.a(r13)
            java.lang.Object r14 = kotlin.Result.m130constructorimpl(r14)
            r0.resumeWith(r14)
            goto La9
        L59:
            r6 = r15
            r5 = r3
            r3 = r14
            goto L5f
        L5d:
            r4 = r1
            goto L59
        L5f:
            int r1 = K(r3, r4, r5, r6, r7, r9, r10)
            if (r1 == 0) goto La5
            if (r1 == r2) goto L97
            r6 = 2
            if (r1 == r6) goto L8d
            r5 = 3
            if (r1 == r5) goto L85
            r5 = 4
            if (r1 == r5) goto L79
            r5 = 5
            if (r1 == r5) goto L74
            goto L77
        L74:
            r4.b()
        L77:
            r1 = r4
            goto L20
        L79:
            long r1 = r14.m0()
            int r14 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r14 >= 0) goto L4b
            r4.b()
            goto L4b
        L85:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            r14.<init>(r0)
            throw r14
        L8d:
            if (r10 == 0) goto L93
            r4.r()
            goto L4b
        L93:
            y(r14, r9, r4, r5)
            goto La9
        L97:
            kotlin.Result$a r14 = kotlin.Result.Companion
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.a.a(r2)
            java.lang.Object r14 = kotlin.Result.m130constructorimpl(r14)
            r0.resumeWith(r14)
            goto La9
        La5:
            r4.b()
            goto L97
        La9:
            java.lang.Object r14 = r0.x()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            if (r14 != r0) goto Lb6
            kotlin.coroutines.jvm.internal.e.c(r16)
        Lb6:
            return r14
        Lb7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.n1(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }

    public static /* synthetic */ Object p1(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i6, Object obj3) {
        BufferedChannel bufferedChannel2;
        Object obj4;
        Object obj5;
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        Function4 function42 = (i6 & 32) != 0 ? new Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel$sendImpl$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) {
                return invoke((o<int>) obj6, ((Number) obj7).intValue(), (int) obj8, ((Number) obj9).longValue());
            }

            @NotNull
            public final Void invoke(@NotNull o<E> oVar, int i7, E e6, long j6) {
                throw new IllegalStateException("unexpected");
            }
        } : function4;
        o oVar = (o) f48117h.get(bufferedChannel);
        while (true) {
            long andIncrement = f48113d.getAndIncrement(bufferedChannel);
            long j6 = 1152921504606846975L & andIncrement;
            boolean y02 = bufferedChannel.y0(andIncrement);
            int i7 = kotlinx.coroutines.channels.i.f48196b;
            long j7 = j6 / i7;
            int i8 = (int) (j6 % i7);
            if (oVar.f49297c != j7) {
                o c02 = bufferedChannel.c0(j7, oVar);
                if (c02 != null) {
                    oVar = c02;
                    bufferedChannel2 = bufferedChannel;
                    obj5 = obj2;
                    obj4 = obj;
                } else if (y02) {
                    return function02.invoke();
                }
            } else {
                bufferedChannel2 = bufferedChannel;
                obj4 = obj;
                obj5 = obj2;
            }
            int C1 = bufferedChannel2.C1(oVar, i8, obj4, j6, obj5, y02);
            if (C1 == 0) {
                oVar.b();
                return function0.invoke();
            }
            if (C1 == 1) {
                return function0.invoke();
            }
            if (C1 == 2) {
                if (y02) {
                    oVar.r();
                    return function02.invoke();
                }
                r3 r3Var = obj2 instanceof r3 ? (r3) obj2 : null;
                if (r3Var != null) {
                    bufferedChannel.T0(r3Var, oVar, i8);
                }
                return function2.invoke(oVar, Integer.valueOf(i8));
            }
            if (C1 == 3) {
                return function42.invoke(oVar, Integer.valueOf(i8), obj, Long.valueOf(j6));
            }
            if (C1 == 4) {
                if (j6 < bufferedChannel.m0()) {
                    oVar.b();
                }
                return function02.invoke();
            }
            if (C1 == 5) {
                oVar.b();
            }
        }
    }

    private final void q0(long j6) {
        if ((f48116g.addAndGet(this, j6) & Longs.MAX_POWER_OF_TWO) != 0) {
            while ((f48116g.get(this) & Longs.MAX_POWER_OF_TWO) != 0) {
            }
        }
    }

    static /* synthetic */ void r0(BufferedChannel bufferedChannel, long j6, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i6 & 1) != 0) {
            j6 = 1;
        }
        bufferedChannel.q0(j6);
    }

    private final void s0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48121l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? kotlinx.coroutines.channels.i.f48219y : kotlinx.coroutines.channels.i.f48220z));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(f0());
    }

    private final boolean u0(long j6, boolean z5) {
        int i6 = (int) (j6 >> 60);
        if (i6 == 0 || i6 == 1) {
            return false;
        }
        if (i6 == 2) {
            W(j6 & 1152921504606846975L);
            return (z5 && p0()) ? false : true;
        }
        if (i6 == 3) {
            V(j6 & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i6).toString());
    }

    private final boolean v1(Object obj, E e6) {
        boolean F;
        boolean F2;
        if (obj instanceof kotlinx.coroutines.selects.m) {
            return ((kotlinx.coroutines.selects.m) obj).j(this, e6);
        }
        if (obj instanceof a0) {
            g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            a0 a0Var = (a0) obj;
            kotlinx.coroutines.q<n<? extends E>> qVar = a0Var.f48152a;
            n b6 = n.b(n.f48241b.c(e6));
            Function1<E, n1> function1 = this.f48123b;
            F2 = kotlinx.coroutines.channels.i.F(qVar, b6, function1 != null ? j0.a(function1, e6, a0Var.f48152a.getContext()) : null);
            return F2;
        }
        if (obj instanceof a) {
            g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).k(e6);
        }
        if (!(obj instanceof kotlinx.coroutines.p)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.p pVar = (kotlinx.coroutines.p) obj;
        Function1<E, n1> function12 = this.f48123b;
        F = kotlinx.coroutines.channels.i.F(pVar, e6, function12 != null ? j0.a(function12, e6, pVar.getContext()) : null);
        return F;
    }

    private final boolean w1(Object obj, o<E> oVar, int i6) {
        if (obj instanceof kotlinx.coroutines.p) {
            g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return kotlinx.coroutines.channels.i.G((kotlinx.coroutines.p) obj, n1.f44123a, null, 2, null);
        }
        if (obj instanceof kotlinx.coroutines.selects.m) {
            g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult K = ((kotlinx.coroutines.selects.l) obj).K(this, n1.f44123a);
            if (K == TrySelectDetailedResult.REREGISTER) {
                oVar.u(i6);
            }
            return K == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof b) {
            return kotlinx.coroutines.channels.i.G(((b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    @Override // kotlinx.coroutines.channels.b0
    public boolean D() {
        return w0(f48113d.get(this));
    }

    public final void G1(long j6) {
        int i6;
        long v5;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long v6;
        long v7;
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.B0()) {
            return;
        }
        while (bufferedChannel.e0() <= j6) {
            bufferedChannel = this;
        }
        i6 = kotlinx.coroutines.channels.i.f48197c;
        for (int i7 = 0; i7 < i6; i7++) {
            long e02 = bufferedChannel.e0();
            if (e02 == (kotlin.time.j.f48028c & f48116g.get(bufferedChannel)) && e02 == bufferedChannel.e0()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f48116g;
        while (true) {
            long j7 = atomicLongFieldUpdater2.get(bufferedChannel);
            v5 = kotlinx.coroutines.channels.i.v(j7 & kotlin.time.j.f48028c, true);
            if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j7, v5)) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        while (true) {
            long e03 = bufferedChannel.e0();
            atomicLongFieldUpdater = f48116g;
            long j8 = atomicLongFieldUpdater.get(bufferedChannel);
            long j9 = j8 & kotlin.time.j.f48028c;
            boolean z5 = (Longs.MAX_POWER_OF_TWO & j8) != 0;
            if (e03 == j9 && e03 == bufferedChannel.e0()) {
                break;
            }
            if (z5) {
                bufferedChannel = this;
            } else {
                v6 = kotlinx.coroutines.channels.i.v(j9, true);
                bufferedChannel = this;
                atomicLongFieldUpdater.compareAndSet(bufferedChannel, j8, v6);
            }
        }
        while (true) {
            long j10 = atomicLongFieldUpdater.get(bufferedChannel);
            v7 = kotlinx.coroutines.channels.i.v(j10 & kotlin.time.j.f48028c, false);
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, v7)) {
                return;
            } else {
                bufferedChannel = this;
            }
        }
    }

    public boolean M(@Nullable Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return U(th, true);
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.selects.g<E> N() {
        c cVar = c.f48130a;
        g0.n(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) u0.q(cVar, 3);
        d dVar = d.f48131a;
        g0.n(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, function3, (Function3) u0.q(dVar, 3), this.f48124c);
    }

    protected boolean U(@Nullable Throwable th, boolean z5) {
        s0 s0Var;
        if (z5) {
            F0();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48120k;
        s0Var = kotlinx.coroutines.channels.i.A;
        boolean a6 = androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, s0Var, th);
        if (z5) {
            G0();
        } else {
            H0();
        }
        X();
        J0();
        if (a6) {
            s0();
        }
        return a6;
    }

    protected final void Y(long j6) {
        s0 s0Var;
        UndeliveredElementException d6;
        o<E> oVar = (o) f48118i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f48114e;
            long j7 = atomicLongFieldUpdater.get(this);
            if (j6 < Math.max(this.f48122a + j7, e0())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j7, 1 + j7)) {
                int i6 = kotlinx.coroutines.channels.i.f48196b;
                long j8 = j7 / i6;
                int i7 = (int) (j7 % i6);
                if (oVar.f49297c != j8) {
                    o<E> b02 = b0(j8, oVar);
                    if (b02 == null) {
                        continue;
                    } else {
                        oVar = b02;
                    }
                }
                o<E> oVar2 = oVar;
                Object A1 = A1(oVar2, i7, j7, null);
                s0Var = kotlinx.coroutines.channels.i.f48211q;
                if (A1 != s0Var) {
                    oVar2.b();
                    Function1<E, n1> function1 = this.f48123b;
                    if (function1 != null && (d6 = j0.d(function1, A1, null, 2, null)) != null) {
                        throw d6;
                    }
                } else if (j7 < o0()) {
                    oVar2.b();
                }
                oVar = oVar2;
            }
        }
    }

    @Nullable
    protected final Throwable f0() {
        return (Throwable) f48120k.get(this);
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public kotlinx.coroutines.selects.i<E, BufferedChannel<E>> i() {
        i iVar = i.f48136a;
        g0.n(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) u0.q(iVar, 3);
        j jVar = j.f48137a;
        g0.n(jVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.j(this, function3, (Function3) u0.q(jVar, 3), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.channels.l<E> iterator() {
        return new a();
    }

    public final long m0() {
        return f48114e.get(this);
    }

    public final long o0() {
        return f48113d.get(this) & 1152921504606846975L;
    }

    public final boolean p0() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48118i;
            o<E> oVar = (o) atomicReferenceFieldUpdater.get(this);
            long m02 = m0();
            if (o0() <= m02) {
                return false;
            }
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j6 = m02 / i6;
            if (oVar.f49297c == j6 || (oVar = b0(j6, oVar)) != null) {
                oVar.b();
                if (t0(oVar, (int) (m02 % i6), m02)) {
                    return true;
                }
                f48114e.compareAndSet(this, m02, m02 + 1);
            } else if (((o) atomicReferenceFieldUpdater.get(this)).f49297c < j6) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.c0
    public void q(@NotNull Function1<? super Throwable, n1> function1) {
        s0 s0Var;
        s0 s0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        s0 s0Var3;
        s0 s0Var4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f48121l;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, null, function1)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            s0Var = kotlinx.coroutines.channels.i.f48219y;
            if (obj != s0Var) {
                s0Var2 = kotlinx.coroutines.channels.i.f48220z;
                if (obj == s0Var2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = f48121l;
            s0Var3 = kotlinx.coroutines.channels.i.f48219y;
            s0Var4 = kotlinx.coroutines.channels.i.f48220z;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, s0Var3, s0Var4));
        function1.invoke(f0());
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        Object obj;
        o oVar;
        long j6;
        BufferedChannel<E> bufferedChannel;
        if (s1(f48113d.get(this))) {
            return n.f48241b.b();
        }
        obj = kotlinx.coroutines.channels.i.f48206l;
        o oVar2 = (o) f48117h.get(this);
        while (true) {
            long andIncrement = f48113d.getAndIncrement(this);
            long j7 = 1152921504606846975L & andIncrement;
            boolean y02 = y0(andIncrement);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j8 = j7 / i6;
            int i7 = (int) (j7 % i6);
            if (oVar2.f49297c != j8) {
                oVar = c0(j8, oVar2);
                if (oVar != null) {
                    bufferedChannel = this;
                    j6 = j7;
                } else if (y02) {
                    return n.f48241b.a(n0());
                }
            } else {
                oVar = oVar2;
                j6 = j7;
                bufferedChannel = this;
            }
            E e7 = e6;
            int C1 = bufferedChannel.C1(oVar, i7, e7, j6, obj, y02);
            oVar2 = oVar;
            if (C1 == 0) {
                oVar2.b();
                return n.f48241b.c(n1.f44123a);
            }
            if (C1 == 1) {
                return n.f48241b.c(n1.f44123a);
            }
            if (C1 == 2) {
                if (y02) {
                    oVar2.r();
                    return n.f48241b.a(n0());
                }
                r3 r3Var = obj instanceof r3 ? (r3) obj : null;
                if (r3Var != null) {
                    T0(r3Var, oVar2, i7);
                }
                oVar2.r();
                return n.f48241b.b();
            }
            if (C1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (C1 == 4) {
                if (j6 < m0()) {
                    oVar2.b();
                }
                return n.f48241b.a(n0());
            }
            if (C1 == 5) {
                oVar2.b();
            }
            e6 = e7;
        }
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.selects.g<n<E>> t() {
        e eVar = e.f48132a;
        g0.n(eVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) u0.q(eVar, 3);
        f fVar = f.f48133a;
        g0.n(fVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, function3, (Function3) u0.q(fVar, 3), this.f48124c);
    }

    public boolean t1() {
        return s1(f48113d.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e4, code lost:
    
        r3 = (kotlinx.coroutines.channels.o) r3.e();
     */
    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.selects.g<E> u() {
        g gVar = g.f48134a;
        g0.n(gVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) u0.q(gVar, 3);
        h hVar = h.f48135a;
        g0.n(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, function3, (Function3) u0.q(hVar, 3), this.f48124c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String u1() {
        String valueOf;
        o oVar;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S=");
        sb2.append(o0());
        sb2.append(",R=");
        sb2.append(m0());
        sb2.append(",B=");
        sb2.append(e0());
        sb2.append(",B'=");
        sb2.append(f48116g.get(this));
        sb2.append(",C=");
        AtomicLongFieldUpdater atomicLongFieldUpdater = f48113d;
        sb2.append((int) (atomicLongFieldUpdater.get(this) >> 60));
        sb2.append(StringUtil.COMMA);
        sb.append(sb2.toString());
        int i6 = (int) (atomicLongFieldUpdater.get(this) >> 60);
        if (i6 == 1) {
            sb.append("CANCELLATION_STARTED,");
        } else if (i6 == 2) {
            sb.append("CLOSED,");
        } else if (i6 == 3) {
            sb.append("CANCELLED,");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SEND_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48117h;
        sb3.append(kotlinx.coroutines.u0.b(atomicReferenceFieldUpdater.get(this)));
        sb3.append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f48118i;
        sb3.append(kotlinx.coroutines.u0.b(atomicReferenceFieldUpdater2.get(this)));
        sb.append(sb3.toString());
        if (!B0()) {
            sb.append(",EB_SEGM=" + kotlinx.coroutines.u0.b(f48119j.get(this)));
        }
        sb.append("  ");
        List Q = f0.Q(atomicReferenceFieldUpdater2.get(this), atomicReferenceFieldUpdater.get(this), f48119j.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : Q) {
            o oVar2 = (o) obj;
            oVar = kotlinx.coroutines.channels.i.f48195a;
            if (oVar2 != oVar) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j6 = ((o) next).f49297c;
            do {
                Object next2 = it.next();
                long j7 = ((o) next2).f49297c;
                if (j6 > j7) {
                    next = next2;
                    j6 = j7;
                }
            } while (it.hasNext());
        }
        o oVar3 = (o) next;
        do {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(kotlinx.coroutines.u0.b(oVar3));
            sb4.append("=[");
            sb4.append(oVar3.h() ? "*" : "");
            sb4.append(oVar3.f49297c);
            sb4.append(",prev=");
            o oVar4 = (o) oVar3.g();
            sb4.append(oVar4 != null ? kotlinx.coroutines.u0.b(oVar4) : null);
            sb4.append(StringUtil.COMMA);
            sb.append(sb4.toString());
            int i7 = kotlinx.coroutines.channels.i.f48196b;
            for (int i8 = 0; i8 < i7; i8++) {
                Object y5 = oVar3.y(i8);
                Object x5 = oVar3.x(i8);
                if (y5 instanceof kotlinx.coroutines.p) {
                    valueOf = "cont";
                } else if (y5 instanceof kotlinx.coroutines.selects.m) {
                    valueOf = "select";
                } else if (y5 instanceof a0) {
                    valueOf = "receiveCatching";
                } else if (y5 instanceof b) {
                    valueOf = "send(broadcast)";
                } else if (y5 instanceof e0) {
                    valueOf = "EB(" + y5 + ')';
                } else {
                    valueOf = String.valueOf(y5);
                }
                sb.append('[' + i8 + "]=(" + valueOf + StringUtil.COMMA + x5 + "),");
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("next=");
            o oVar5 = (o) oVar3.e();
            sb5.append(oVar5 != null ? kotlinx.coroutines.u0.b(oVar5) : null);
            sb5.append("]  ");
            sb.append(sb5.toString());
            oVar3 = (o) oVar3.e();
        } while (oVar3 != null);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public Object v() {
        Object obj;
        o oVar;
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        long j6 = f48114e.get(this);
        long j7 = f48113d.get(this);
        if (w0(j7)) {
            return n.f48241b.a(f0());
        }
        if (j6 >= (j7 & 1152921504606846975L)) {
            return n.f48241b.b();
        }
        obj = kotlinx.coroutines.channels.i.f48207m;
        o oVar2 = (o) f48118i.get(this);
        while (!D()) {
            long andIncrement = f48114e.getAndIncrement(this);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j8 = andIncrement / i6;
            int i7 = (int) (andIncrement % i6);
            if (oVar2.f49297c != j8) {
                oVar = b0(j8, oVar2);
                if (oVar == null) {
                    continue;
                }
            } else {
                oVar = oVar2;
            }
            Object A1 = A1(oVar, i7, andIncrement, obj);
            s0Var = kotlinx.coroutines.channels.i.f48209o;
            if (A1 == s0Var) {
                r3 r3Var = obj instanceof r3 ? (r3) obj : null;
                if (r3Var != null) {
                    S0(r3Var, oVar, i7);
                }
                G1(andIncrement);
                oVar.r();
                return n.f48241b.b();
            }
            s0Var2 = kotlinx.coroutines.channels.i.f48211q;
            if (A1 != s0Var2) {
                s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                if (A1 == s0Var3) {
                    throw new IllegalStateException("unexpected");
                }
                oVar.b();
                return n.f48241b.c(A1);
            }
            if (andIncrement < o0()) {
                oVar.b();
            }
            oVar2 = oVar;
        }
        return n.f48241b.a(f0());
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean z() {
        return y0(f48113d.get(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A1(o<E> oVar, int i6, long j6, Object obj) {
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        Object y5 = oVar.y(i6);
        if (y5 == null) {
            if (j6 >= (f48113d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                    return s0Var3;
                }
                if (oVar.t(i6, y5, obj)) {
                    Z();
                    s0Var2 = kotlinx.coroutines.channels.i.f48209o;
                    return s0Var2;
                }
            }
        } else if (y5 == kotlinx.coroutines.channels.i.f48200f) {
            s0Var = kotlinx.coroutines.channels.i.f48205k;
            if (oVar.t(i6, y5, s0Var)) {
                Z();
                return oVar.A(i6);
            }
        }
        return B1(oVar, i6, j6, obj);
    }

    private final boolean B0() {
        long e02 = e0();
        if (e02 != 0 && e02 != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    private final Object B1(o<E> oVar, int i6, long j6, Object obj) {
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        s0 s0Var4;
        s0 s0Var5;
        s0 s0Var6;
        s0 s0Var7;
        s0 s0Var8;
        s0 s0Var9;
        s0 s0Var10;
        s0 s0Var11;
        s0 s0Var12;
        s0 s0Var13;
        s0 s0Var14;
        s0 s0Var15;
        s0 s0Var16;
        while (true) {
            Object y5 = oVar.y(i6);
            if (y5 != null) {
                s0Var5 = kotlinx.coroutines.channels.i.f48201g;
                if (y5 != s0Var5) {
                    if (y5 == kotlinx.coroutines.channels.i.f48200f) {
                        s0Var6 = kotlinx.coroutines.channels.i.f48205k;
                        if (oVar.t(i6, y5, s0Var6)) {
                            Z();
                            return oVar.A(i6);
                        }
                    } else {
                        s0Var7 = kotlinx.coroutines.channels.i.f48206l;
                        if (y5 == s0Var7) {
                            s0Var8 = kotlinx.coroutines.channels.i.f48211q;
                            return s0Var8;
                        }
                        s0Var9 = kotlinx.coroutines.channels.i.f48204j;
                        if (y5 == s0Var9) {
                            s0Var10 = kotlinx.coroutines.channels.i.f48211q;
                            return s0Var10;
                        }
                        if (y5 != kotlinx.coroutines.channels.i.z()) {
                            s0Var12 = kotlinx.coroutines.channels.i.f48203i;
                            if (y5 != s0Var12) {
                                s0Var13 = kotlinx.coroutines.channels.i.f48202h;
                                if (oVar.t(i6, y5, s0Var13)) {
                                    boolean z5 = y5 instanceof e0;
                                    if (z5) {
                                        y5 = ((e0) y5).f48187a;
                                    }
                                    if (w1(y5, oVar, i6)) {
                                        s0Var16 = kotlinx.coroutines.channels.i.f48205k;
                                        oVar.C(i6, s0Var16);
                                        Z();
                                        return oVar.A(i6);
                                    }
                                    s0Var14 = kotlinx.coroutines.channels.i.f48206l;
                                    oVar.C(i6, s0Var14);
                                    oVar.z(i6, false);
                                    if (z5) {
                                        Z();
                                    }
                                    s0Var15 = kotlinx.coroutines.channels.i.f48211q;
                                    return s0Var15;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            Z();
                            s0Var11 = kotlinx.coroutines.channels.i.f48211q;
                            return s0Var11;
                        }
                    }
                }
            }
            if (j6 < (f48113d.get(this) & 1152921504606846975L)) {
                s0Var = kotlinx.coroutines.channels.i.f48204j;
                if (oVar.t(i6, y5, s0Var)) {
                    Z();
                    s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                    return s0Var2;
                }
            } else {
                if (obj == null) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                    return s0Var3;
                }
                if (oVar.t(i6, y5, obj)) {
                    Z();
                    s0Var4 = kotlinx.coroutines.channels.i.f48209o;
                    return s0Var4;
                }
            }
        }
    }

    private final void C0(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, n1> function1, Object obj) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C1(o<E> oVar, int i6, E e6, long j6, Object obj, boolean z5) {
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        oVar.D(i6, e6);
        if (z5) {
            return D1(oVar, i6, e6, j6, obj, z5);
        }
        Object y5 = oVar.y(i6);
        if (y5 == null) {
            if (L(j6)) {
                if (oVar.t(i6, null, kotlinx.coroutines.channels.i.f48200f)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (oVar.t(i6, null, obj)) {
                    return 2;
                }
            }
        } else if (y5 instanceof r3) {
            oVar.u(i6);
            if (v1(y5, e6)) {
                s0Var3 = kotlinx.coroutines.channels.i.f48205k;
                oVar.C(i6, s0Var3);
                Q0();
                return 0;
            }
            s0Var = kotlinx.coroutines.channels.i.f48207m;
            Object v5 = oVar.v(i6, s0Var);
            s0Var2 = kotlinx.coroutines.channels.i.f48207m;
            if (v5 != s0Var2) {
                oVar.z(i6, true);
                return 5;
            }
            return 5;
        }
        return D1(oVar, i6, e6, j6, obj, z5);
    }

    private final void D0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final int D1(o<E> oVar, int i6, E e6, long j6, Object obj, boolean z5) {
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        s0 s0Var4;
        s0 s0Var5;
        s0 s0Var6;
        s0 s0Var7;
        while (true) {
            Object y5 = oVar.y(i6);
            if (y5 != null) {
                s0Var2 = kotlinx.coroutines.channels.i.f48201g;
                if (y5 != s0Var2) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48207m;
                    if (y5 != s0Var3) {
                        s0Var4 = kotlinx.coroutines.channels.i.f48204j;
                        if (y5 == s0Var4) {
                            oVar.u(i6);
                            return 5;
                        }
                        if (y5 == kotlinx.coroutines.channels.i.z()) {
                            oVar.u(i6);
                            X();
                            return 4;
                        }
                        oVar.u(i6);
                        if (y5 instanceof e0) {
                            y5 = ((e0) y5).f48187a;
                        }
                        if (v1(y5, e6)) {
                            s0Var7 = kotlinx.coroutines.channels.i.f48205k;
                            oVar.C(i6, s0Var7);
                            Q0();
                            return 0;
                        }
                        s0Var5 = kotlinx.coroutines.channels.i.f48207m;
                        Object v5 = oVar.v(i6, s0Var5);
                        s0Var6 = kotlinx.coroutines.channels.i.f48207m;
                        if (v5 != s0Var6) {
                            oVar.z(i6, true);
                        }
                        return 5;
                    }
                    oVar.u(i6);
                    return 5;
                }
                if (oVar.t(i6, y5, kotlinx.coroutines.channels.i.f48200f)) {
                    return 1;
                }
            } else if (L(j6) && !z5) {
                if (oVar.t(i6, null, kotlinx.coroutines.channels.i.f48200f)) {
                    return 1;
                }
            } else if (z5) {
                s0Var = kotlinx.coroutines.channels.i.f48206l;
                if (oVar.t(i6, null, s0Var)) {
                    oVar.z(i6, false);
                    return 4;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (oVar.t(i6, null, obj)) {
                    return 2;
                }
            }
        }
    }

    private final boolean L(long j6) {
        if (j6 >= e0() && j6 >= m0() + this.f48122a) {
            return false;
        }
        return true;
    }

    private final void M0(kotlinx.coroutines.selects.m<?> mVar) {
        mVar.f(kotlinx.coroutines.channels.i.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(r3 r3Var, o<E> oVar, int i6) {
        R0();
        r3Var.b(oVar, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object U0(Object obj, Object obj2) {
        if (obj2 != kotlinx.coroutines.channels.i.z()) {
            return obj2;
        }
        throw l0();
    }

    private final void V(long j6) {
        h1(W(j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object V0(Object obj, Object obj2) {
        Object c6;
        if (obj2 == kotlinx.coroutines.channels.i.z()) {
            c6 = n.f48241b.a(f0());
        } else {
            c6 = n.f48241b.c(obj2);
        }
        return n.b(c6);
    }

    private final o<E> W(long j6) {
        o<E> Q = Q();
        if (z0()) {
            long E0 = E0(Q);
            if (E0 != -1) {
                Y(E0);
            }
        }
        O(Q, j6);
        return Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object W0(Object obj, Object obj2) {
        if (obj2 == kotlinx.coroutines.channels.i.z()) {
            if (f0() == null) {
                return null;
            }
            throw l0();
        }
        return obj2;
    }

    private final void X() {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X0(Object obj, Object obj2) {
        if (obj2 != kotlinx.coroutines.channels.i.z()) {
            return this;
        }
        throw n0();
    }

    static /* synthetic */ <E> Object Y0(BufferedChannel<E> bufferedChannel, kotlin.coroutines.e<? super E> eVar) {
        o<E> oVar;
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        o<E> oVar2 = (o) f48118i.get(bufferedChannel);
        while (!bufferedChannel.D()) {
            long andIncrement = f48114e.getAndIncrement(bufferedChannel);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j6 = andIncrement / i6;
            int i7 = (int) (andIncrement % i6);
            if (oVar2.f49297c != j6) {
                o<E> b02 = bufferedChannel.b0(j6, oVar2);
                if (b02 == null) {
                    continue;
                } else {
                    oVar = b02;
                }
            } else {
                oVar = oVar2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Object A1 = bufferedChannel2.A1(oVar, i7, andIncrement, null);
            s0Var = kotlinx.coroutines.channels.i.f48209o;
            if (A1 != s0Var) {
                s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                if (A1 != s0Var2) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                    if (A1 == s0Var3) {
                        return bufferedChannel2.e1(oVar, i7, andIncrement, eVar);
                    }
                    oVar.b();
                    return A1;
                }
                if (andIncrement < bufferedChannel2.o0()) {
                    oVar.b();
                }
                bufferedChannel = bufferedChannel2;
                oVar2 = oVar;
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        throw r0.o(bufferedChannel.l0());
    }

    private final void Z() {
        if (B0()) {
            return;
        }
        o<E> oVar = (o) f48119j.get(this);
        while (true) {
            long andIncrement = f48115f.getAndIncrement(this);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j6 = andIncrement / i6;
            if (o0() <= andIncrement) {
                if (oVar.f49297c < j6 && oVar.e() != 0) {
                    I0(j6, oVar);
                }
                r0(this, 0L, 1, null);
                return;
            }
            if (oVar.f49297c != j6) {
                o<E> a02 = a0(j6, oVar, andIncrement);
                if (a02 == null) {
                    continue;
                } else {
                    oVar = a02;
                }
            }
            if (y1(oVar, (int) (andIncrement % i6), andIncrement)) {
                r0(this, 0L, 1, null);
                return;
            }
            r0(this, 0L, 1, null);
        }
    }

    private final <R> R b1(Object obj, Function1<? super E, ? extends R> function1, Function3<? super o<E>, ? super Integer, ? super Long, ? extends R> function3, Function0<? extends R> function0, Function3<? super o<E>, ? super Integer, ? super Long, ? extends R> function32) {
        o oVar;
        s0 s0Var;
        r3 r3Var;
        s0 s0Var2;
        s0 s0Var3;
        o oVar2 = (o) f48118i.get(this);
        while (!D()) {
            long andIncrement = f48114e.getAndIncrement(this);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j6 = andIncrement / i6;
            int i7 = (int) (andIncrement % i6);
            if (oVar2.f49297c != j6) {
                o b02 = b0(j6, oVar2);
                if (b02 == null) {
                    continue;
                } else {
                    oVar = b02;
                }
            } else {
                oVar = oVar2;
            }
            Object obj2 = obj;
            s0 s0Var4 = (Object) A1(oVar, i7, andIncrement, obj2);
            oVar2 = oVar;
            s0Var = kotlinx.coroutines.channels.i.f48209o;
            if (s0Var4 != s0Var) {
                s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                if (s0Var4 != s0Var2) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                    if (s0Var4 == s0Var3) {
                        return function32.invoke(oVar2, Integer.valueOf(i7), Long.valueOf(andIncrement));
                    }
                    oVar2.b();
                    return function1.invoke(s0Var4);
                }
                if (andIncrement < o0()) {
                    oVar2.b();
                }
                obj = obj2;
            } else {
                if (obj2 instanceof r3) {
                    r3Var = (r3) obj2;
                } else {
                    r3Var = null;
                }
                if (r3Var != null) {
                    S0(r3Var, oVar2, i7);
                }
                return function3.invoke(oVar2, Integer.valueOf(i7), Long.valueOf(andIncrement));
            }
        }
        return function0.invoke();
    }

    private final Object d0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    private final void d1(o<E> oVar, int i6, long j6, r3 r3Var, Function1<? super E, n1> function1, Function0<n1> function0) {
        s0 s0Var;
        s0 s0Var2;
        o oVar2;
        s0 s0Var3;
        r3 r3Var2;
        s0 s0Var4;
        s0 s0Var5;
        s0 s0Var6 = (Object) A1(oVar, i6, j6, r3Var);
        BufferedChannel<E> bufferedChannel = this;
        s0Var = kotlinx.coroutines.channels.i.f48209o;
        if (s0Var6 != s0Var) {
            s0Var2 = kotlinx.coroutines.channels.i.f48211q;
            if (s0Var6 == s0Var2) {
                if (j6 < o0()) {
                    oVar.b();
                }
                o oVar3 = (o) f48118i.get(this);
                while (!D()) {
                    long andIncrement = f48114e.getAndIncrement(this);
                    int i7 = kotlinx.coroutines.channels.i.f48196b;
                    long j7 = andIncrement / i7;
                    int i8 = (int) (andIncrement % i7);
                    if (oVar3.f49297c != j7) {
                        o b02 = b0(j7, oVar3);
                        if (b02 == null) {
                            continue;
                        } else {
                            oVar2 = b02;
                        }
                    } else {
                        oVar2 = oVar3;
                    }
                    BufferedChannel<E> bufferedChannel2 = bufferedChannel;
                    s0 s0Var7 = (Object) bufferedChannel2.A1(oVar2, i8, andIncrement, r3Var);
                    oVar3 = oVar2;
                    s0Var3 = kotlinx.coroutines.channels.i.f48209o;
                    if (s0Var7 != s0Var3) {
                        s0Var4 = kotlinx.coroutines.channels.i.f48211q;
                        if (s0Var7 != s0Var4) {
                            s0Var5 = kotlinx.coroutines.channels.i.f48210p;
                            if (s0Var7 != s0Var5) {
                                oVar3.b();
                                function1.invoke(s0Var7);
                                return;
                            }
                            throw new IllegalStateException("unexpected");
                        }
                        if (andIncrement < o0()) {
                            oVar3.b();
                        }
                        bufferedChannel = bufferedChannel2;
                    } else {
                        if (androidx.activity.k.a(r3Var)) {
                            r3Var2 = r3Var;
                        } else {
                            r3Var2 = null;
                        }
                        if (r3Var2 != null) {
                            S0(r3Var2, oVar3, i8);
                        }
                        n1 n1Var = n1.f44123a;
                        return;
                    }
                }
                function0.invoke();
                return;
            }
            oVar.b();
            function1.invoke(s0Var6);
            return;
        }
        S0(r3Var, oVar, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e1(o<E> oVar, int i6, long j6, kotlin.coroutines.e<? super E> eVar) {
        s0 s0Var;
        s0 s0Var2;
        Function1<E, n1> function1;
        kotlin.coroutines.i context;
        o oVar2;
        s0 s0Var3;
        s0 s0Var4;
        s0 s0Var5;
        kotlinx.coroutines.q b6 = kotlinx.coroutines.s.b(kotlin.coroutines.intrinsics.a.e(eVar));
        try {
            Object A1 = A1(oVar, i6, j6, b6);
            s0Var = kotlinx.coroutines.channels.i.f48209o;
            if (A1 != s0Var) {
                s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                Function1<Throwable, n1> function12 = null;
                function12 = null;
                kotlinx.coroutines.q qVar = null;
                if (A1 == s0Var2) {
                    if (j6 < o0()) {
                        oVar.b();
                    }
                    o oVar3 = (o) f48118i.get(this);
                    while (true) {
                        if (D()) {
                            L0(b6);
                            break;
                        }
                        long andIncrement = f48114e.getAndIncrement(this);
                        int i7 = kotlinx.coroutines.channels.i.f48196b;
                        long j7 = andIncrement / i7;
                        int i8 = (int) (andIncrement % i7);
                        if (oVar3.f49297c != j7) {
                            o b02 = b0(j7, oVar3);
                            if (b02 != null) {
                                oVar2 = b02;
                            }
                        } else {
                            oVar2 = oVar3;
                        }
                        A1 = A1(oVar2, i8, andIncrement, b6);
                        o oVar4 = oVar2;
                        s0Var3 = kotlinx.coroutines.channels.i.f48209o;
                        if (A1 != s0Var3) {
                            s0Var4 = kotlinx.coroutines.channels.i.f48211q;
                            if (A1 != s0Var4) {
                                s0Var5 = kotlinx.coroutines.channels.i.f48210p;
                                if (A1 != s0Var5) {
                                    oVar4.b();
                                    function1 = this.f48123b;
                                    if (function1 != null) {
                                        context = b6.getContext();
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else {
                                if (andIncrement < o0()) {
                                    oVar4.b();
                                }
                                oVar3 = oVar4;
                            }
                        } else {
                            if (androidx.activity.k.a(b6)) {
                                qVar = b6;
                            }
                            if (qVar != null) {
                                S0(qVar, oVar4, i8);
                            }
                        }
                    }
                } else {
                    oVar.b();
                    function1 = this.f48123b;
                    if (function1 != null) {
                        context = b6.getContext();
                        function12 = j0.a(function1, A1, context);
                    }
                    b6.o(A1, function12);
                }
            } else {
                S0(b6, oVar, i6);
            }
            Object x5 = b6.x();
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            return x5;
        } catch (Throwable th) {
            b6.N();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(kotlinx.coroutines.selects.m<?> mVar, Object obj) {
        o oVar;
        s0 s0Var;
        r3 r3Var;
        s0 s0Var2;
        s0 s0Var3;
        o oVar2 = (o) f48118i.get(this);
        while (!D()) {
            long andIncrement = f48114e.getAndIncrement(this);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j6 = andIncrement / i6;
            int i7 = (int) (andIncrement % i6);
            if (oVar2.f49297c != j6) {
                o b02 = b0(j6, oVar2);
                if (b02 == null) {
                    continue;
                } else {
                    oVar = b02;
                }
            } else {
                oVar = oVar2;
            }
            kotlinx.coroutines.selects.m<?> mVar2 = mVar;
            Object A1 = A1(oVar, i7, andIncrement, mVar2);
            oVar2 = oVar;
            s0Var = kotlinx.coroutines.channels.i.f48209o;
            if (A1 != s0Var) {
                s0Var2 = kotlinx.coroutines.channels.i.f48211q;
                if (A1 != s0Var2) {
                    s0Var3 = kotlinx.coroutines.channels.i.f48210p;
                    if (A1 != s0Var3) {
                        oVar2.b();
                        mVar2.f(A1);
                        return;
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (andIncrement < o0()) {
                    oVar2.b();
                }
                mVar = mVar2;
            } else {
                if (mVar2 instanceof r3) {
                    r3Var = (r3) mVar2;
                } else {
                    r3Var = null;
                }
                if (r3Var != null) {
                    S0(r3Var, oVar2, i7);
                    return;
                }
                return;
            }
        }
        M0(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable l0() {
        Throwable f02 = f0();
        if (f02 == null) {
            return new ClosedReceiveChannelException(p.f48247a);
        }
        return f02;
    }

    static /* synthetic */ <E> Object l1(BufferedChannel<E> bufferedChannel, E e6, kotlin.coroutines.e<? super n1> eVar) {
        o<E> oVar;
        o<E> oVar2 = (o) f48117h.get(bufferedChannel);
        while (true) {
            long andIncrement = f48113d.getAndIncrement(bufferedChannel);
            long j6 = andIncrement & 1152921504606846975L;
            boolean y02 = bufferedChannel.y0(andIncrement);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j7 = j6 / i6;
            int i7 = (int) (j6 % i6);
            if (oVar2.f49297c != j7) {
                o<E> c02 = bufferedChannel.c0(j7, oVar2);
                if (c02 == null) {
                    if (y02) {
                        Object O0 = bufferedChannel.O0(e6, eVar);
                        if (O0 == kotlin.coroutines.intrinsics.a.l()) {
                            return O0;
                        }
                    }
                } else {
                    oVar = c02;
                }
            } else {
                oVar = oVar2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            E e7 = e6;
            int C1 = bufferedChannel2.C1(oVar, i7, e7, j6, null, y02);
            if (C1 != 0) {
                if (C1 == 1) {
                    break;
                }
                if (C1 != 2) {
                    if (C1 != 3) {
                        if (C1 != 4) {
                            if (C1 == 5) {
                                oVar.b();
                            }
                            bufferedChannel = bufferedChannel2;
                            oVar2 = oVar;
                            e6 = e7;
                        } else {
                            if (j6 < bufferedChannel2.m0()) {
                                oVar.b();
                            }
                            Object O02 = bufferedChannel2.O0(e7, eVar);
                            if (O02 == kotlin.coroutines.intrinsics.a.l()) {
                                return O02;
                            }
                        }
                    } else {
                        Object r12 = bufferedChannel2.r1(oVar, i7, e7, j6, eVar);
                        if (r12 == kotlin.coroutines.intrinsics.a.l()) {
                            return r12;
                        }
                    }
                } else if (y02) {
                    oVar.r();
                    Object O03 = bufferedChannel2.O0(e7, eVar);
                    if (O03 == kotlin.coroutines.intrinsics.a.l()) {
                        return O03;
                    }
                }
            } else {
                oVar.b();
                break;
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0100 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r1(kotlinx.coroutines.channels.o<E> r17, int r18, E r19, long r20, kotlin.coroutines.e<? super kotlin.n1> r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.r1(kotlinx.coroutines.channels.o, int, java.lang.Object, long, kotlin.coroutines.e):java.lang.Object");
    }

    private final boolean s1(long j6) {
        if (y0(j6)) {
            return false;
        }
        return !L(j6 & 1152921504606846975L);
    }

    private final boolean t0(o<E> oVar, int i6, long j6) {
        Object y5;
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        s0 s0Var4;
        s0 s0Var5;
        s0 s0Var6;
        s0 s0Var7;
        do {
            y5 = oVar.y(i6);
            if (y5 != null) {
                s0Var2 = kotlinx.coroutines.channels.i.f48201g;
                if (y5 != s0Var2) {
                    if (y5 != kotlinx.coroutines.channels.i.f48200f) {
                        s0Var3 = kotlinx.coroutines.channels.i.f48206l;
                        if (y5 != s0Var3 && y5 != kotlinx.coroutines.channels.i.z()) {
                            s0Var4 = kotlinx.coroutines.channels.i.f48205k;
                            if (y5 != s0Var4) {
                                s0Var5 = kotlinx.coroutines.channels.i.f48204j;
                                if (y5 != s0Var5) {
                                    s0Var6 = kotlinx.coroutines.channels.i.f48203i;
                                    if (y5 != s0Var6) {
                                        s0Var7 = kotlinx.coroutines.channels.i.f48202h;
                                        if (y5 == s0Var7 || j6 != m0()) {
                                            return false;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return true;
                }
            }
            s0Var = kotlinx.coroutines.channels.i.f48204j;
        } while (!oVar.t(i6, y5, s0Var));
        Z();
        return false;
    }

    private final void x1(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object obj) {
        while (true) {
            long j6 = atomicLongFieldUpdater.get(obj);
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            Object obj2 = obj;
            if (atomicLongFieldUpdater2.compareAndSet(obj2, j6, function1.invoke(Long.valueOf(j6)).longValue())) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            obj = obj2;
        }
    }

    private final boolean y1(o<E> oVar, int i6, long j6) {
        s0 s0Var;
        s0 s0Var2;
        Object y5 = oVar.y(i6);
        if ((y5 instanceof r3) && j6 >= f48114e.get(this)) {
            s0Var = kotlinx.coroutines.channels.i.f48203i;
            if (oVar.t(i6, y5, s0Var)) {
                if (!w1(y5, oVar, i6)) {
                    s0Var2 = kotlinx.coroutines.channels.i.f48206l;
                    oVar.C(i6, s0Var2);
                    oVar.z(i6, false);
                    return false;
                }
                oVar.C(i6, kotlinx.coroutines.channels.i.f48200f);
                return true;
            }
        }
        return z1(oVar, i6, j6);
    }

    private final boolean z1(o<E> oVar, int i6, long j6) {
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        s0 s0Var4;
        s0 s0Var5;
        s0 s0Var6;
        s0 s0Var7;
        s0 s0Var8;
        while (true) {
            Object y5 = oVar.y(i6);
            if (!(y5 instanceof r3)) {
                s0Var3 = kotlinx.coroutines.channels.i.f48206l;
                if (y5 == s0Var3) {
                    return false;
                }
                if (y5 == null) {
                    s0Var4 = kotlinx.coroutines.channels.i.f48201g;
                    if (oVar.t(i6, y5, s0Var4)) {
                        return true;
                    }
                } else if (y5 != kotlinx.coroutines.channels.i.f48200f) {
                    s0Var5 = kotlinx.coroutines.channels.i.f48204j;
                    if (y5 == s0Var5) {
                        break;
                    }
                    s0Var6 = kotlinx.coroutines.channels.i.f48205k;
                    if (y5 == s0Var6) {
                        break;
                    }
                    s0Var7 = kotlinx.coroutines.channels.i.f48207m;
                    if (y5 != s0Var7 && y5 != kotlinx.coroutines.channels.i.z()) {
                        s0Var8 = kotlinx.coroutines.channels.i.f48202h;
                        if (y5 != s0Var8) {
                            throw new IllegalStateException(("Unexpected cell state: " + y5).toString());
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (j6 >= f48114e.get(this)) {
                s0Var = kotlinx.coroutines.channels.i.f48203i;
                if (oVar.t(i6, y5, s0Var)) {
                    if (!w1(y5, oVar, i6)) {
                        s0Var2 = kotlinx.coroutines.channels.i.f48206l;
                        oVar.C(i6, s0Var2);
                        oVar.z(i6, false);
                        return false;
                    }
                    oVar.C(i6, kotlinx.coroutines.channels.i.f48200f);
                    return true;
                }
            } else if (oVar.t(i6, y5, new e0((r3) y5))) {
                return true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P() {
        boolean z5;
        s0 s0Var;
        s0 s0Var2;
        boolean g6;
        boolean g7;
        s0 s0Var3;
        s0 s0Var4;
        boolean g8;
        boolean z6;
        boolean z7;
        o oVar;
        o oVar2;
        if (B0()) {
            Object obj = f48119j.get(this);
            oVar2 = kotlinx.coroutines.channels.i.f48195a;
            if (obj != oVar2) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((o) f48118i.get(this)).f49297c > ((o) f48119j.get(this)).f49297c) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        List Q = f0.Q(f48118i.get(this), f48117h.get(this), f48119j.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : Q) {
            o oVar3 = (o) obj2;
            oVar = kotlinx.coroutines.channels.i.f48195a;
            if (oVar3 != oVar) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j6 = ((o) next).f49297c;
                do {
                    Object next2 = it.next();
                    long j7 = ((o) next2).f49297c;
                    if (j6 > j7) {
                        next = next2;
                        j6 = j7;
                    }
                } while (it.hasNext());
            }
            o oVar4 = (o) next;
            if (oVar4.g() == 0) {
                while (oVar4.e() != 0) {
                    S e6 = oVar4.e();
                    g0.m(e6);
                    if (((o) e6).g() != 0) {
                        S e7 = oVar4.e();
                        g0.m(e7);
                        if (((o) e7).g() != oVar4) {
                            throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                        }
                    }
                    int i6 = kotlinx.coroutines.channels.i.f48196b;
                    int i7 = 0;
                    for (int i8 = 0; i8 < i6; i8++) {
                        Object y5 = oVar4.y(i8);
                        if (!g0.g(y5, kotlinx.coroutines.channels.i.f48200f) && !(y5 instanceof r3)) {
                            s0Var = kotlinx.coroutines.channels.i.f48207m;
                            if (!g0.g(y5, s0Var)) {
                                s0Var2 = kotlinx.coroutines.channels.i.f48206l;
                                g6 = g0.g(y5, s0Var2);
                            } else {
                                g6 = true;
                            }
                            if (g6) {
                                g7 = true;
                            } else {
                                g7 = g0.g(y5, kotlinx.coroutines.channels.i.z());
                            }
                            if (!g7) {
                                s0Var3 = kotlinx.coroutines.channels.i.f48204j;
                                if (!g0.g(y5, s0Var3)) {
                                    s0Var4 = kotlinx.coroutines.channels.i.f48205k;
                                    g8 = g0.g(y5, s0Var4);
                                } else {
                                    g8 = true;
                                }
                                if (g8) {
                                    if (oVar4.x(i8) == null) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (!z6) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                } else {
                                    throw new IllegalStateException(("Unexpected segment cell state: " + y5 + ".\nChannel state: " + this).toString());
                                }
                            } else {
                                if (oVar4.x(i8) == null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (z7) {
                                    i7++;
                                } else {
                                    throw new IllegalStateException("Check failed.");
                                }
                            }
                        }
                    }
                    if (i7 == kotlinx.coroutines.channels.i.f48196b) {
                        if (oVar4 != f48118i.get(this) && oVar4 != f48117h.get(this) && oVar4 != f48119j.get(this)) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        if (!z5) {
                            throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                        }
                    }
                    S e8 = oVar4.e();
                    g0.m(e8);
                    oVar4 = (o) e8;
                }
                return;
            }
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        throw new NoSuchElementException();
    }

    @Override // kotlinx.coroutines.channels.b0
    @Nullable
    public Object R(@NotNull kotlin.coroutines.e<? super E> eVar) {
        return Y0(this, eVar);
    }

    @Override // kotlinx.coroutines.channels.c0
    @Nullable
    public Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return l1(this, e6, eVar);
    }

    @Override // kotlinx.coroutines.channels.b0
    public final boolean a(@Nullable Throwable th) {
        return M(th);
    }

    @Override // kotlinx.coroutines.channels.b0
    public final void b(@Nullable CancellationException cancellationException) {
        M(cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void g1(@NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
        o oVar;
        r3 r3Var;
        o oVar2 = (o) f48117h.get(this);
        while (true) {
            long andIncrement = f48113d.getAndIncrement(this);
            long j6 = andIncrement & 1152921504606846975L;
            boolean y02 = y0(andIncrement);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j7 = j6 / i6;
            int i7 = (int) (j6 % i6);
            if (oVar2.f49297c != j7) {
                o c02 = c0(j7, oVar2);
                if (c02 == null) {
                    if (y02) {
                        N0(obj, mVar);
                        return;
                    }
                } else {
                    oVar = c02;
                }
            } else {
                oVar = oVar2;
            }
            kotlinx.coroutines.selects.m<?> mVar2 = mVar;
            Object obj2 = obj;
            int C1 = C1(oVar, i7, obj2, j6, mVar2, y02);
            oVar2 = oVar;
            if (C1 != 0) {
                if (C1 != 1) {
                    if (C1 != 2) {
                        if (C1 != 3) {
                            if (C1 != 4) {
                                if (C1 == 5) {
                                    oVar2.b();
                                }
                                obj = obj2;
                                mVar = mVar2;
                            } else {
                                if (j6 < m0()) {
                                    oVar2.b();
                                }
                                N0(obj2, mVar2);
                                return;
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else {
                        if (y02) {
                            oVar2.r();
                            N0(obj2, mVar2);
                            return;
                        }
                        if (mVar2 instanceof r3) {
                            r3Var = (r3) mVar2;
                        } else {
                            r3Var = null;
                        }
                        if (r3Var != null) {
                            T0(r3Var, oVar2, i7);
                            return;
                        }
                        return;
                    }
                } else {
                    mVar2.f(n1.f44123a);
                    return;
                }
            } else {
                oVar2.b();
                mVar2.f(n1.f44123a);
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.b0
    public boolean isEmpty() {
        if (D() || p0()) {
            return false;
        }
        return !D();
    }

    @Nullable
    public Object m1(E e6, @NotNull kotlin.coroutines.e<? super Boolean> eVar) {
        return n1(this, e6, eVar);
    }

    @NotNull
    protected final Throwable n0() {
        Throwable f02 = f0();
        if (f02 == null) {
            return new ClosedSendChannelException(p.f48247a);
        }
        return f02;
    }

    protected final <R> R o1(E e6, @Nullable Object obj, @NotNull Function0<? extends R> function0, @NotNull Function2<? super o<E>, ? super Integer, ? extends R> function2, @NotNull Function0<? extends R> function02, @NotNull Function4<? super o<E>, ? super Integer, ? super E, ? super Long, ? extends R> function4) {
        BufferedChannel<E> bufferedChannel;
        E e7;
        Object obj2;
        r3 r3Var;
        o oVar = (o) f48117h.get(this);
        while (true) {
            long andIncrement = f48113d.getAndIncrement(this);
            long j6 = 1152921504606846975L & andIncrement;
            boolean y02 = y0(andIncrement);
            int i6 = kotlinx.coroutines.channels.i.f48196b;
            long j7 = j6 / i6;
            int i7 = (int) (j6 % i6);
            if (oVar.f49297c != j7) {
                o c02 = c0(j7, oVar);
                if (c02 == null) {
                    if (y02) {
                        return function02.invoke();
                    }
                } else {
                    oVar = c02;
                    bufferedChannel = this;
                    obj2 = obj;
                    e7 = e6;
                }
            } else {
                bufferedChannel = this;
                e7 = e6;
                obj2 = obj;
            }
            int C1 = bufferedChannel.C1(oVar, i7, e7, j6, obj2, y02);
            if (C1 != 0) {
                if (C1 != 1) {
                    if (C1 != 2) {
                        if (C1 != 3) {
                            if (C1 != 4) {
                                if (C1 == 5) {
                                    oVar.b();
                                }
                            } else {
                                if (j6 < m0()) {
                                    oVar.b();
                                }
                                return function02.invoke();
                            }
                        } else {
                            return function4.invoke(oVar, Integer.valueOf(i7), e6, Long.valueOf(j6));
                        }
                    } else {
                        if (y02) {
                            oVar.r();
                            return function02.invoke();
                        }
                        if (obj instanceof r3) {
                            r3Var = (r3) obj;
                        } else {
                            r3Var = null;
                        }
                        if (r3Var != null) {
                            T0(r3Var, oVar, i7);
                        }
                        return function2.invoke(oVar, Integer.valueOf(i7));
                    }
                } else {
                    return function0.invoke();
                }
            } else {
                oVar.b();
                return function0.invoke();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.c0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e6) {
        return j.a.c(this, e6);
    }

    @Override // kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return (E) j.a.d(this);
    }

    @Override // kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    public Object w(@NotNull kotlin.coroutines.e<? super E> eVar) {
        return j.a.e(this, eVar);
    }

    @Override // kotlinx.coroutines.channels.b0
    @Nullable
    public Object x(@NotNull kotlin.coroutines.e<? super n<? extends E>> eVar) {
        return Z0(this, eVar);
    }

    public /* synthetic */ BufferedChannel(int i6, Function1 function1, int i7, kotlin.jvm.internal.v vVar) {
        this(i6, (i7 & 2) != 0 ? null : function1);
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void A0() {
    }

    public static /* synthetic */ void g0() {
    }

    public static /* synthetic */ void h0() {
    }

    public static /* synthetic */ void i0() {
    }

    public static /* synthetic */ void j0() {
    }

    private static /* synthetic */ void k0() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void v0() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void x0() {
    }

    protected void J0() {
    }

    protected void Q0() {
    }

    protected void R0() {
    }
}
