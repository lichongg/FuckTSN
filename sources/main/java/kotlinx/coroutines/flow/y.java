package kotlinx.coroutines.flow;

import cn.jpush.android.api.InAppSlotParams;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.j1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class y<T> extends kotlinx.coroutines.flow.internal.a<a0> implements s<T>, kotlinx.coroutines.flow.c<T>, kotlinx.coroutines.flow.internal.p<T> {

    /* renamed from: e, reason: collision with root package name */
    private final int f49173e;

    /* renamed from: f, reason: collision with root package name */
    private final int f49174f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final BufferOverflow f49175g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Object[] f49176h;

    /* renamed from: i, reason: collision with root package name */
    private long f49177i;

    /* renamed from: j, reason: collision with root package name */
    private long f49178j;

    /* renamed from: k, reason: collision with root package name */
    private int f49179k;

    /* renamed from: l, reason: collision with root package name */
    private int f49180l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements j1 {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @NotNull
        public final y<?> f49181a;

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        public long f49182b;

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Object f49183c;

        /* renamed from: d, reason: collision with root package name */
        @JvmField
        @NotNull
        public final kotlin.coroutines.e<n1> f49184d;

        @Override // kotlinx.coroutines.j1
        public void dispose() {
            this.f49181a.B(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull y<?> yVar, long j6, @Nullable Object obj, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f49181a = yVar;
            this.f49182b = j6;
            this.f49183c = obj;
            this.f49184d = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300}, m = "collect$suspendImpl", n = {"$this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "$this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "$this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class c<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49186a;

        /* renamed from: b, reason: collision with root package name */
        Object f49187b;

        /* renamed from: c, reason: collision with root package name */
        Object f49188c;

        /* renamed from: d, reason: collision with root package name */
        Object f49189d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f49190e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ y<T> f49191f;

        /* renamed from: g, reason: collision with root package name */
        int f49192g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(y<T> yVar, kotlin.coroutines.e<? super c> eVar) {
            super(eVar);
            this.f49191f = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49190e = obj;
            this.f49192g |= Integer.MIN_VALUE;
            return y.D(this.f49191f, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(a aVar) {
        Object f6;
        synchronized (this) {
            if (aVar.f49182b < N()) {
                return;
            }
            Object[] objArr = this.f49176h;
            kotlin.jvm.internal.g0.m(objArr);
            f6 = z.f(objArr, aVar.f49182b);
            if (f6 != aVar) {
                return;
            }
            z.g(objArr, aVar.f49182b, z.f49193a);
            C();
            n1 n1Var = n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.Object[]] */
    public final kotlin.coroutines.e<n1>[] L(kotlin.coroutines.e<n1>[] eVarArr) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        a0 a0Var;
        kotlin.coroutines.e<? super n1> eVar;
        int length = eVarArr.length;
        if (((kotlinx.coroutines.flow.internal.a) this).f48904b != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).f48903a) != null) {
            int length2 = cVarArr.length;
            int i6 = 0;
            eVarArr = eVarArr;
            while (i6 < length2) {
                kotlinx.coroutines.flow.internal.c cVar = cVarArr[i6];
                if (cVar != null && (eVar = (a0Var = (a0) cVar).f48841b) != null && X(a0Var) >= 0) {
                    int length3 = eVarArr.length;
                    eVarArr = eVarArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(eVarArr, Math.max(2, eVarArr.length * 2));
                        kotlin.jvm.internal.g0.o(copyOf, "copyOf(this, newSize)");
                        eVarArr = copyOf;
                    }
                    eVarArr[length] = eVar;
                    a0Var.f48841b = null;
                    length++;
                }
                i6++;
                eVarArr = eVarArr;
            }
        }
        return eVarArr;
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> a() {
        Object f6;
        synchronized (this) {
            int S = S();
            if (S == 0) {
                return kotlin.collections.f0.J();
            }
            ArrayList arrayList = new ArrayList(S);
            Object[] objArr = this.f49176h;
            kotlin.jvm.internal.g0.m(objArr);
            for (int i6 = 0; i6 < S; i6++) {
                f6 = z.f(objArr, this.f49177i + i6);
                arrayList.add(f6);
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.s
    public void b() {
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                Z(M(), this.f49178j, M(), R());
                n1 n1Var = n1.f44123a;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49185a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49185a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A(a0 a0Var, kotlin.coroutines.e<? super n1> eVar) {
        n1 n1Var;
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        synchronized (this) {
            try {
                if (X(a0Var) < 0) {
                    a0Var.f48841b = qVar;
                } else {
                    Result.a aVar = Result.Companion;
                    qVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
                }
                n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : n1Var;
    }

    private final void C() {
        Object f6;
        if (this.f49174f != 0 || this.f49180l > 1) {
            Object[] objArr = this.f49176h;
            kotlin.jvm.internal.g0.m(objArr);
            while (this.f49180l > 0) {
                f6 = z.f(objArr, (N() + T()) - 1);
                if (f6 != z.f49193a) {
                    return;
                }
                this.f49180l--;
                z.g(objArr, N() + T(), null);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|(3:(7:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(2:16|(3:28|29|(2:31|32)(2:33|27))(4:18|(1:20)|21|(1:23)(2:26|27)))|24)(4:44|45|46|47)|37|38)(5:53|54|55|(1:57)|60)|48|49|15|(3:16|(0)(0)|27)|24))|63|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)|24) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        if (((kotlinx.coroutines.flow.l0) r9).a(r0) == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ <T> java.lang.Object D(kotlinx.coroutines.flow.y<T> r8, kotlinx.coroutines.flow.j<? super T> r9, kotlin.coroutines.e<?> r10) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.y.D(kotlinx.coroutines.flow.y, kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }

    private final void H() {
        Object[] objArr = this.f49176h;
        kotlin.jvm.internal.g0.m(objArr);
        z.g(objArr, N(), null);
        this.f49179k--;
        long N = N() + 1;
        if (this.f49177i < N) {
            this.f49177i = N;
        }
        if (this.f49178j < N) {
            E(N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J(T t5, kotlin.coroutines.e<? super n1> eVar) {
        Throwable th;
        kotlin.coroutines.e<n1>[] L;
        a aVar;
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        kotlin.coroutines.e<n1>[] eVarArr = kotlinx.coroutines.flow.internal.b.f48907a;
        synchronized (this) {
            try {
                if (V(t5)) {
                    try {
                        Result.a aVar2 = Result.Companion;
                        qVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
                        L = L(eVarArr);
                        aVar = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        aVar = new a(this, N() + T(), t5, qVar);
                        K(aVar);
                        this.f49180l++;
                        if (this.f49174f == 0) {
                            eVarArr = L(eVarArr);
                        }
                        L = eVarArr;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (aVar != null) {
                    kotlinx.coroutines.s.a(qVar, aVar);
                }
                for (kotlin.coroutines.e<n1> eVar2 : L) {
                    if (eVar2 != null) {
                        Result.a aVar3 = Result.Companion;
                        eVar2.resumeWith(Result.m130constructorimpl(n1.f44123a));
                    }
                }
                Object x5 = qVar.x();
                if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                    kotlin.coroutines.jvm.internal.e.c(eVar);
                }
                return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : n1.f44123a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N() {
        return Math.min(this.f49178j, this.f49177i);
    }

    private final Object Q(long j6) {
        Object f6;
        Object[] objArr = this.f49176h;
        kotlin.jvm.internal.g0.m(objArr);
        f6 = z.f(objArr, j6);
        return f6 instanceof a ? ((a) f6).f49183c : f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T() {
        return this.f49179k + this.f49180l;
    }

    private final Object[] U(Object[] objArr, int i6, int i7) {
        Object f6;
        if (i7 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i7];
        this.f49176h = objArr2;
        if (objArr != null) {
            long N = N();
            for (int i8 = 0; i8 < i6; i8++) {
                long j6 = i8 + N;
                f6 = z.f(objArr, j6);
                z.g(objArr2, j6, f6);
            }
        }
        return objArr2;
    }

    private final boolean W(T t5) {
        if (this.f49173e == 0) {
            return true;
        }
        K(t5);
        int i6 = this.f49179k + 1;
        this.f49179k = i6;
        if (i6 > this.f49173e) {
            H();
        }
        this.f49178j = N() + this.f49179k;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long X(a0 a0Var) {
        long j6 = a0Var.f48840a;
        if (j6 >= M() && (this.f49174f > 0 || j6 > N() || this.f49180l == 0)) {
            return -1L;
        }
        return j6;
    }

    private final Object Y(a0 a0Var) {
        Object obj;
        kotlin.coroutines.e<n1>[] eVarArr = kotlinx.coroutines.flow.internal.b.f48907a;
        synchronized (this) {
            try {
                long X = X(a0Var);
                if (X < 0) {
                    obj = z.f49193a;
                } else {
                    long j6 = a0Var.f48840a;
                    Object Q = Q(X);
                    a0Var.f48840a = X + 1;
                    eVarArr = a0(j6);
                    obj = Q;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (kotlin.coroutines.e<n1> eVar : eVarArr) {
            if (eVar != null) {
                Result.a aVar = Result.Companion;
                eVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public a0 i() {
        return new a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public a0[] j(int i6) {
        return new a0[i6];
    }

    protected final T O() {
        Object f6;
        Object[] objArr = this.f49176h;
        kotlin.jvm.internal.g0.m(objArr);
        f6 = z.f(objArr, (this.f49177i + S()) - 1);
        return (T) f6;
    }

    @NotNull
    public final kotlin.coroutines.e<n1>[] a0(long j6) {
        long j7;
        long j8;
        long j9;
        Object f6;
        Object f7;
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (j6 > this.f49178j) {
            return kotlinx.coroutines.flow.internal.b.f48907a;
        }
        long N = N();
        long j10 = this.f49179k + N;
        if (this.f49174f == 0 && this.f49180l > 0) {
            j10++;
        }
        if (((kotlinx.coroutines.flow.internal.a) this).f48904b != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).f48903a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    long j11 = ((a0) cVar).f48840a;
                    if (j11 >= 0 && j11 < j10) {
                        j10 = j11;
                    }
                }
            }
        }
        if (j10 <= this.f49178j) {
            return kotlinx.coroutines.flow.internal.b.f48907a;
        }
        long M = M();
        int min = m() > 0 ? Math.min(this.f49180l, this.f49174f - ((int) (M - j10))) : this.f49180l;
        kotlin.coroutines.e<n1>[] eVarArr = kotlinx.coroutines.flow.internal.b.f48907a;
        long j12 = this.f49180l + M;
        if (min > 0) {
            eVarArr = new kotlin.coroutines.e[min];
            Object[] objArr = this.f49176h;
            kotlin.jvm.internal.g0.m(objArr);
            j9 = 1;
            long j13 = M;
            int i6 = 0;
            while (true) {
                if (M >= j12) {
                    j7 = N;
                    j8 = j10;
                    M = j13;
                    break;
                }
                f7 = z.f(objArr, M);
                j7 = N;
                s0 s0Var = z.f49193a;
                if (f7 != s0Var) {
                    kotlin.jvm.internal.g0.n(f7, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) f7;
                    int i7 = i6 + 1;
                    j8 = j10;
                    eVarArr[i6] = aVar.f49184d;
                    z.g(objArr, M, s0Var);
                    z.g(objArr, j13, aVar.f49183c);
                    long j14 = j13 + 1;
                    if (i7 >= min) {
                        M = j14;
                        break;
                    }
                    i6 = i7;
                    j13 = j14;
                } else {
                    j8 = j10;
                }
                M++;
                N = j7;
                j10 = j8;
            }
        } else {
            j7 = N;
            j8 = j10;
            j9 = 1;
        }
        kotlin.coroutines.e<n1>[] eVarArr2 = eVarArr;
        int i8 = (int) (M - j7);
        long j15 = m() == 0 ? M : j8;
        long max = Math.max(this.f49177i, M - Math.min(this.f49173e, i8));
        if (this.f49174f == 0 && max < j12) {
            Object[] objArr2 = this.f49176h;
            kotlin.jvm.internal.g0.m(objArr2);
            f6 = z.f(objArr2, max);
            if (kotlin.jvm.internal.g0.g(f6, z.f49193a)) {
                M += j9;
                max += j9;
            }
        }
        Z(max, j15, M, j12);
        C();
        return !(eVarArr2.length == 0) ? L(eVarArr2) : eVarArr2;
    }

    public final long b0() {
        long j6 = this.f49177i;
        if (j6 < this.f49178j) {
            this.f49178j = j6;
        }
        return j6;
    }

    @Override // kotlinx.coroutines.flow.s
    public boolean c(T t5) {
        int i6;
        boolean z5;
        kotlin.coroutines.e<n1>[] eVarArr = kotlinx.coroutines.flow.internal.b.f48907a;
        synchronized (this) {
            if (V(t5)) {
                eVarArr = L(eVarArr);
                z5 = true;
            } else {
                z5 = false;
            }
        }
        for (kotlin.coroutines.e<n1> eVar : eVarArr) {
            if (eVar != null) {
                Result.a aVar = Result.Companion;
                eVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
            }
        }
        return z5;
    }

    public y(int i6, int i7, @NotNull BufferOverflow bufferOverflow) {
        this.f49173e = i6;
        this.f49174f = i7;
        this.f49175g = bufferOverflow;
    }

    private final void E(long j6) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (((kotlinx.coroutines.flow.internal.a) this).f48904b != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).f48903a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    a0 a0Var = (a0) cVar;
                    long j7 = a0Var.f48840a;
                    if (j7 >= 0 && j7 < j6) {
                        a0Var.f48840a = j6;
                    }
                }
            }
        }
        this.f49178j = j6;
    }

    static /* synthetic */ <T> Object I(y<T> yVar, T t5, kotlin.coroutines.e<? super n1> eVar) {
        if (yVar.c(t5)) {
            return n1.f44123a;
        }
        Object J = yVar.J(t5, eVar);
        if (J == kotlin.coroutines.intrinsics.a.l()) {
            return J;
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(Object obj) {
        int T = T();
        Object[] objArr = this.f49176h;
        if (objArr == null) {
            objArr = U(null, 0, 2);
        } else if (T >= objArr.length) {
            objArr = U(objArr, T, objArr.length * 2);
        }
        z.g(objArr, N() + T, obj);
    }

    private final long M() {
        return N() + this.f49179k;
    }

    private final long R() {
        return N() + this.f49179k + this.f49180l;
    }

    private final int S() {
        return (int) ((N() + this.f49179k) - this.f49177i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V(T t5) {
        if (m() == 0) {
            return W(t5);
        }
        if (this.f49179k >= this.f49174f && this.f49178j <= this.f49177i) {
            int i6 = b.f49185a[this.f49175g.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        K(t5);
        int i7 = this.f49179k + 1;
        this.f49179k = i7;
        if (i7 > this.f49174f) {
            H();
        }
        if (S() > this.f49173e) {
            Z(this.f49177i + 1, this.f49178j, M(), R());
        }
        return true;
    }

    private final void Z(long j6, long j7, long j8, long j9) {
        long min = Math.min(j7, j6);
        for (long N = N(); N < min; N++) {
            Object[] objArr = this.f49176h;
            kotlin.jvm.internal.g0.m(objArr);
            z.g(objArr, N, null);
        }
        this.f49177i = j6;
        this.f49178j = j7;
        this.f49179k = (int) (j8 - min);
        this.f49180l = (int) (j9 - j8);
    }

    @Override // kotlinx.coroutines.flow.x, kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<?> eVar) {
        return D(this, jVar, eVar);
    }

    @Override // kotlinx.coroutines.flow.internal.p
    @NotNull
    public i<T> e(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return z.e(this, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.s, kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return I(this, t5, eVar);
    }

    protected static /* synthetic */ void P() {
    }
}
