package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class l2 implements e2, x, u2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49351a = AtomicReferenceFieldUpdater.newUpdater(l2.class, Object.class, "_state");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49352b = AtomicReferenceFieldUpdater.newUpdater(l2.class, Object.class, "_parentHandle");

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    private static final class a<T> extends q<T> {

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        private final l2 f49353i;

        public a(@NotNull kotlin.coroutines.e<? super T> eVar, @NotNull l2 l2Var) {
            super(eVar, 1);
            this.f49353i = l2Var;
        }

        @Override // kotlinx.coroutines.q
        @NotNull
        protected String L() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.q
        @NotNull
        public Throwable v(@NotNull e2 e2Var) {
            Throwable e6;
            Object H0 = this.f49353i.H0();
            return (!(H0 instanceof c) || (e6 = ((c) H0).e()) == null) ? H0 instanceof d0 ? ((d0) H0).f48476a : e2Var.H() : e6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends k2 {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final l2 f49354e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final c f49355f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final w f49356g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private final Object f49357h;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
            z(th);
            return kotlin.n1.f44123a;
        }

        @Override // kotlinx.coroutines.f0
        public void z(@Nullable Throwable th) {
            this.f49354e.p0(this.f49355f, this.f49356g, this.f49357h);
        }

        public b(@NotNull l2 l2Var, @NotNull c cVar, @NotNull w wVar, @Nullable Object obj) {
            this.f49354e = l2Var;
            this.f49355f = cVar;
            this.f49356g = wVar;
            this.f49357h = obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    private static final class c implements y1 {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final AtomicIntegerFieldUpdater f49358b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private static final AtomicReferenceFieldUpdater f49359c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private static final AtomicReferenceFieldUpdater f49360d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");

        @Volatile
        @Nullable
        private volatile Object _exceptionsHolder;

        @Volatile
        private volatile int _isCompleting;

        @Volatile
        @Nullable
        private volatile Object _rootCause;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final q2 f49361a;

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return f49360d.get(this);
        }

        private final void k(Object obj) {
            f49360d.set(this, obj);
        }

        @Override // kotlinx.coroutines.y1
        @NotNull
        public q2 a() {
            return this.f49361a;
        }

        @Nullable
        public final Throwable e() {
            return (Throwable) f49359c.get(this);
        }

        public final boolean g() {
            return f49358b.get(this) != 0;
        }

        public final void j(boolean z5) {
            f49358b.set(this, z5 ? 1 : 0);
        }

        public final void l(@Nullable Throwable th) {
            f49359c.set(this, th);
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }

        public c(@NotNull q2 q2Var, boolean z5, @Nullable Throwable th) {
            this.f49361a = q2Var;
            this._isCompleting = z5 ? 1 : 0;
            this._rootCause = th;
        }

        public final void b(@NotNull Throwable th) {
            Throwable e6 = e();
            if (e6 == null) {
                l(th);
                return;
            }
            if (th != e6) {
                Object d6 = d();
                if (d6 == null) {
                    k(th);
                    return;
                }
                if (d6 instanceof Throwable) {
                    if (th == d6) {
                        return;
                    }
                    ArrayList<Throwable> c6 = c();
                    c6.add(d6);
                    c6.add(th);
                    k(c6);
                    return;
                }
                if (d6 instanceof ArrayList) {
                    ((ArrayList) d6).add(th);
                    return;
                }
                throw new IllegalStateException(("State is " + d6).toString());
            }
        }

        public final boolean f() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        public final boolean h() {
            kotlinx.coroutines.internal.s0 s0Var;
            Object d6 = d();
            s0Var = m2.f49390h;
            if (d6 == s0Var) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.s0 s0Var;
            Object d6 = d();
            if (d6 == null) {
                arrayList = c();
            } else if (d6 instanceof Throwable) {
                ArrayList<Throwable> c6 = c();
                c6.add(d6);
                arrayList = c6;
            } else if (d6 instanceof ArrayList) {
                arrayList = (ArrayList) d6;
            } else {
                throw new IllegalStateException(("State is " + d6).toString());
            }
            Throwable e6 = e();
            if (e6 != null) {
                arrayList.add(0, e6);
            }
            if (th != null && !kotlin.jvm.internal.g0.g(th, e6)) {
                arrayList.add(th);
            }
            s0Var = m2.f49390h;
            k(s0Var);
            return arrayList;
        }

        @Override // kotlinx.coroutines.y1
        public boolean isActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d extends k2 {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final kotlinx.coroutines.selects.m<?> f49362e;

        public d(@NotNull kotlinx.coroutines.selects.m<?> mVar) {
            this.f49362e = mVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
            z(th);
            return kotlin.n1.f44123a;
        }

        @Override // kotlinx.coroutines.f0
        public void z(@Nullable Throwable th) {
            Object H0 = l2.this.H0();
            if (!(H0 instanceof d0)) {
                H0 = m2.h(H0);
            }
            this.f49362e.j(l2.this, H0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class e extends k2 {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final kotlinx.coroutines.selects.m<?> f49364e;

        public e(@NotNull kotlinx.coroutines.selects.m<?> mVar) {
            this.f49364e = mVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
            z(th);
            return kotlin.n1.f44123a;
        }

        @Override // kotlinx.coroutines.f0
        public void z(@Nullable Throwable th) {
            this.f49364e.j(l2.this, kotlin.n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,367:1\n526#2:368\n*E\n"})
    public static final class f extends y.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l2 f49366d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f49367e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(kotlinx.coroutines.internal.y yVar, l2 l2Var, Object obj) {
            super(yVar);
            this.f49366d = l2Var;
            this.f49367e = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        @Nullable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(@NotNull kotlinx.coroutines.internal.y yVar) {
            if (this.f49366d.H0() == this.f49367e) {
                return null;
            }
            return kotlinx.coroutines.internal.x.a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {956, 958}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n958#1:1455,6\n*E\n"})
    static final class g extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super e2>, kotlin.coroutines.e<? super kotlin.n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f49368a;

        /* renamed from: b, reason: collision with root package name */
        Object f49369b;

        /* renamed from: c, reason: collision with root package name */
        int f49370c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f49371d;

        g(kotlin.coroutines.e<? super g> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<kotlin.n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            g gVar = l2.this.new g(eVar);
            gVar.f49371d = obj;
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlin.sequences.o<? super e2> oVar, @Nullable kotlin.coroutines.e<? super kotlin.n1> eVar) {
            return ((g) create(oVar, eVar)).invokeSuspend(kotlin.n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x007e, code lost:
        
            if (r4.c(r6, r5) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0080, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        
            if (r6.c(r1, r5) == r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0069  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x006b -> B:6:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007e -> B:6:0x0081). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r5.f49370c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r5.f49369b
                kotlinx.coroutines.internal.y r1 = (kotlinx.coroutines.internal.y) r1
                java.lang.Object r3 = r5.f49368a
                kotlinx.coroutines.internal.w r3 = (kotlinx.coroutines.internal.w) r3
                java.lang.Object r4 = r5.f49371d
                kotlin.sequences.o r4 = (kotlin.sequences.o) r4
                kotlin.g0.n(r6)
                goto L81
            L1e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L26:
                kotlin.g0.n(r6)
                goto L86
            L2a:
                kotlin.g0.n(r6)
                java.lang.Object r6 = r5.f49371d
                kotlin.sequences.o r6 = (kotlin.sequences.o) r6
                kotlinx.coroutines.l2 r1 = kotlinx.coroutines.l2.this
                java.lang.Object r1 = r1.H0()
                boolean r4 = r1 instanceof kotlinx.coroutines.w
                if (r4 == 0) goto L48
                kotlinx.coroutines.w r1 = (kotlinx.coroutines.w) r1
                kotlinx.coroutines.x r1 = r1.f49673e
                r5.f49370c = r3
                java.lang.Object r6 = r6.c(r1, r5)
                if (r6 != r0) goto L86
                goto L80
            L48:
                boolean r3 = r1 instanceof kotlinx.coroutines.y1
                if (r3 == 0) goto L86
                kotlinx.coroutines.y1 r1 = (kotlinx.coroutines.y1) r1
                kotlinx.coroutines.q2 r1 = r1.a()
                if (r1 == 0) goto L86
                java.lang.Object r3 = r1.n()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                kotlin.jvm.internal.g0.n(r3, r4)
                kotlinx.coroutines.internal.y r3 = (kotlinx.coroutines.internal.y) r3
                r4 = r3
                r3 = r1
                r1 = r4
                r4 = r6
            L63:
                boolean r6 = kotlin.jvm.internal.g0.g(r1, r3)
                if (r6 != 0) goto L86
                boolean r6 = r1 instanceof kotlinx.coroutines.w
                if (r6 == 0) goto L81
                r6 = r1
                kotlinx.coroutines.w r6 = (kotlinx.coroutines.w) r6
                kotlinx.coroutines.x r6 = r6.f49673e
                r5.f49371d = r4
                r5.f49368a = r3
                r5.f49369b = r1
                r5.f49370c = r2
                java.lang.Object r6 = r4.c(r6, r5)
                if (r6 != r0) goto L81
            L80:
                return r0
            L81:
                kotlinx.coroutines.internal.y r1 = r1.o()
                goto L63
            L86:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.l2.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class h extends FunctionReferenceImpl implements Function3<l2, kotlinx.coroutines.selects.m<?>, Object, kotlin.n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final h f49373a = new h();

        h() {
            super(3, l2.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(l2 l2Var, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(l2Var, mVar, obj);
            return kotlin.n1.f44123a;
        }

        public final void c(@NotNull l2 l2Var, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            l2Var.c1(mVar, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class i extends FunctionReferenceImpl implements Function3<l2, Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final i f49374a = new i();

        i() {
            super(3, l2.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l2 l2Var, @Nullable Object obj, @Nullable Object obj2) {
            return l2Var.b1(obj, obj2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class j extends FunctionReferenceImpl implements Function3<l2, kotlinx.coroutines.selects.m<?>, Object, kotlin.n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final j f49375a = new j();

        j() {
            super(3, l2.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(l2 l2Var, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(l2Var, mVar, obj);
            return kotlin.n1.f44123a;
        }

        public final void c(@NotNull l2 l2Var, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            l2Var.i1(mVar, obj);
        }
    }

    private final Object S0(Object obj) {
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        kotlinx.coroutines.internal.s0 s0Var3;
        kotlinx.coroutines.internal.s0 s0Var4;
        kotlinx.coroutines.internal.s0 s0Var5;
        kotlinx.coroutines.internal.s0 s0Var6;
        Throwable th = null;
        while (true) {
            Object H0 = H0();
            if (H0 instanceof c) {
                synchronized (H0) {
                    if (((c) H0).h()) {
                        s0Var2 = m2.f49386d;
                        return s0Var2;
                    }
                    boolean f6 = ((c) H0).f();
                    if (obj != null || !f6) {
                        if (th == null) {
                            th = q0(obj);
                        }
                        ((c) H0).b(th);
                    }
                    Throwable e6 = f6 ? null : ((c) H0).e();
                    if (e6 != null) {
                        Y0(((c) H0).a(), e6);
                    }
                    s0Var = m2.f49383a;
                    return s0Var;
                }
            }
            if (!(H0 instanceof y1)) {
                s0Var3 = m2.f49386d;
                return s0Var3;
            }
            if (th == null) {
                th = q0(obj);
            }
            y1 y1Var = (y1) H0;
            if (!y1Var.isActive()) {
                Object s12 = s1(H0, new d0(th, false, 2, null));
                s0Var5 = m2.f49383a;
                if (s12 == s0Var5) {
                    throw new IllegalStateException(("Cannot happen in " + H0).toString());
                }
                s0Var6 = m2.f49385c;
                if (s12 != s0Var6) {
                    return s12;
                }
            } else if (r1(y1Var, th)) {
                s0Var4 = m2.f49383a;
                return s0Var4;
            }
        }
    }

    private final k2 V0(Function1<? super Throwable, kotlin.n1> function1, boolean z5) {
        k2 k2Var;
        if (z5) {
            k2Var = function1 instanceof f2 ? (f2) function1 : null;
            if (k2Var == null) {
                k2Var = new c2(function1);
            }
        } else {
            k2Var = function1 instanceof k2 ? (k2) function1 : null;
            if (k2Var == null) {
                k2Var = new d2(function1);
            }
        }
        k2Var.B(this);
        return k2Var;
    }

    public boolean A0() {
        return true;
    }

    public boolean D0() {
        return false;
    }

    protected boolean I0(@NotNull Throwable th) {
        return false;
    }

    protected boolean N0() {
        return false;
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean a(Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = o1(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(m0(), null, this);
        }
        j0(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final j1 k(@NotNull Function1<? super Throwable, kotlin.n1> function1) {
        return G(false, true, function1);
    }

    private final boolean L0(y1 y1Var) {
        return (y1Var instanceof c) && ((c) y1Var).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object P0(kotlin.coroutines.e<? super kotlin.n1> eVar) {
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        s.a(qVar, k(new w2(qVar)));
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b1(Object obj, Object obj2) {
        if (obj2 instanceof d0) {
            throw ((d0) obj2).f48476a;
        }
        return obj2;
    }

    private final boolean c0(Object obj, q2 q2Var, k2 k2Var) {
        int x5;
        f fVar = new f(k2Var, this, obj);
        do {
            x5 = q2Var.p().x(k2Var, q2Var, fVar);
            if (x5 == 1) {
                return true;
            }
        } while (x5 != 2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g0(kotlin.coroutines.e<Object> eVar) {
        a aVar = new a(kotlin.coroutines.intrinsics.a.e(eVar), this);
        aVar.Q();
        s.a(aVar, k(new v2(aVar)));
        Object x5 = aVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.x1] */
    private final void g1(m1 m1Var) {
        q2 q2Var = new q2();
        if (!m1Var.isActive()) {
            q2Var = new x1(q2Var);
        }
        androidx.concurrent.futures.a.a(f49351a, this, m1Var, q2Var);
    }

    private final void h1(k2 k2Var) {
        k2Var.j(new q2());
        androidx.concurrent.futures.a.a(f49351a, this, k2Var, k2Var.o());
    }

    private final int l1(Object obj) {
        m1 m1Var;
        if (!(obj instanceof m1)) {
            if (!(obj instanceof x1)) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f49351a, this, obj, ((x1) obj).a())) {
                return -1;
            }
            f1();
            return 1;
        }
        if (((m1) obj).isActive()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49351a;
        m1Var = m2.f49392j;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, m1Var)) {
            return -1;
        }
        f1();
        return 1;
    }

    private final String m1(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof y1 ? ((y1) obj).isActive() ? "Active" : "New" : obj instanceof d0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException o1(l2 l2Var, Throwable th, String str, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i6 & 1) != 0) {
            str = null;
        }
        return l2Var.n1(th, str);
    }

    private final Throwable q0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(m0(), null, this) : th;
        }
        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((u2) obj).K();
    }

    private final boolean q1(y1 y1Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(f49351a, this, y1Var, m2.g(obj))) {
            return false;
        }
        d1(null);
        e1(obj);
        o0(y1Var, obj);
        return true;
    }

    public static /* synthetic */ JobCancellationException s0(l2 l2Var, String str, Throwable th, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i6 & 1) != 0) {
            str = null;
        }
        if ((i6 & 2) != 0) {
            th = null;
        }
        if (str == null) {
            str = l2Var.m0();
        }
        return new JobCancellationException(str, th, l2Var);
    }

    private final Object s1(Object obj, Object obj2) {
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        if (!(obj instanceof y1)) {
            s0Var2 = m2.f49383a;
            return s0Var2;
        }
        if ((!(obj instanceof m1) && !(obj instanceof k2)) || (obj instanceof w) || (obj2 instanceof d0)) {
            return t1((y1) obj, obj2);
        }
        if (q1((y1) obj, obj2)) {
            return obj2;
        }
        s0Var = m2.f49385c;
        return s0Var;
    }

    private final Object t0(c cVar, Object obj) {
        boolean f6;
        Throwable z02;
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        Throwable th = d0Var != null ? d0Var.f48476a : null;
        synchronized (cVar) {
            f6 = cVar.f();
            List<Throwable> i6 = cVar.i(th);
            z02 = z0(cVar, i6);
            if (z02 != null) {
                d0(z02, i6);
            }
        }
        if (z02 != null && z02 != th) {
            obj = new d0(z02, false, 2, null);
        }
        if (z02 != null && (l0(z02) || I0(z02))) {
            kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((d0) obj).b();
        }
        if (!f6) {
            d1(z02);
        }
        e1(obj);
        androidx.concurrent.futures.a.a(f49351a, this, cVar, m2.g(obj));
        o0(cVar, obj);
        return obj;
    }

    private final w u0(y1 y1Var) {
        w wVar = y1Var instanceof w ? (w) y1Var : null;
        if (wVar != null) {
            return wVar;
        }
        q2 a6 = y1Var.a();
        if (a6 != null) {
            return X0(a6);
        }
        return null;
    }

    private final boolean u1(c cVar, w wVar, Object obj) {
        while (e2.a.g(wVar.f49673e, false, false, new b(this, cVar, wVar, obj), 1, null) == s2.f49445a) {
            wVar = X0(wVar);
            if (wVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Throwable y0(Object obj) {
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        if (d0Var != null) {
            return d0Var.f48476a;
        }
        return null;
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final v A(@NotNull x xVar) {
        j1 g6 = e2.a.g(this, true, false, new w(xVar), 2, null);
        kotlin.jvm.internal.g0.n(g6, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (v) g6;
    }

    @NotNull
    protected final kotlinx.coroutines.selects.g<?> B0() {
        h hVar = h.f49373a;
        kotlin.jvm.internal.g0.n(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) kotlin.jvm.internal.u0.q(hVar, 3);
        i iVar = i.f49374a;
        kotlin.jvm.internal.g0.n(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.h(this, function3, (Function3) kotlin.jvm.internal.u0.q(iVar, 3), null, 8, null);
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final kotlin.sequences.m<e2> E() {
        return kotlin.sequences.p.b(new g(null));
    }

    @Nullable
    public final v G0() {
        return (v) f49352b.get(this);
    }

    @Nullable
    public final Object H0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49351a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.k0)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.k0) obj).b(this);
        }
    }

    protected final void K0(@Nullable e2 e2Var) {
        if (e2Var == null) {
            k1(s2.f49445a);
            return;
        }
        e2Var.start();
        v A = e2Var.A(this);
        k1(A);
        if (isCompleted()) {
            A.dispose();
            k1(s2.f49445a);
        }
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    public void b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(m0(), null, this);
        }
        j0(cancellationException);
    }

    @Override // kotlin.coroutines.i.b
    @NotNull
    public final i.c<?> getKey() {
        return e2.f48569s0;
    }

    public final void k1(@Nullable v vVar) {
        f49352b.set(this, vVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String m0() {
        return "Job was cancelled";
    }

    public boolean n0(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return i0(th) && A0();
    }

    @NotNull
    protected final CancellationException n1(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = m0();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String p1() {
        return W0() + '{' + m1(H0()) + '}';
    }

    @NotNull
    public final JobCancellationException r0(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = m0();
        }
        return new JobCancellationException(str, th, this);
    }

    @NotNull
    public String toString() {
        return p1() + '@' + u0.b(this);
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final kotlinx.coroutines.selects.e y() {
        j jVar = j.f49375a;
        kotlin.jvm.internal.g0.n(jVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.f(this, (Function3) kotlin.jvm.internal.u0.q(jVar, 3), null, 4, null);
    }

    public l2(boolean z5) {
        this._state = z5 ? m2.f49392j : m2.f49391i;
    }

    private final q2 F0(y1 y1Var) {
        q2 a6 = y1Var.a();
        if (a6 == null) {
            if (y1Var instanceof m1) {
                return new q2();
            }
            if (y1Var instanceof k2) {
                h1((k2) y1Var);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + y1Var).toString());
        }
        return a6;
    }

    private final boolean O0() {
        Object H0;
        do {
            H0 = H0();
            if (!(H0 instanceof y1)) {
                return false;
            }
        } while (l1(H0) < 0);
        return true;
    }

    private final void Q0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final Void R0(Function1<Object, kotlin.n1> function1) {
        while (true) {
            function1.invoke(H0());
        }
    }

    private final w X0(kotlinx.coroutines.internal.y yVar) {
        while (yVar.q()) {
            yVar = yVar.p();
        }
        while (true) {
            yVar = yVar.o();
            if (!yVar.q()) {
                if (yVar instanceof w) {
                    return (w) yVar;
                }
                if (yVar instanceof q2) {
                    return null;
                }
            }
        }
    }

    private final void Y0(q2 q2Var, Throwable th) {
        d1(th);
        Object n6 = q2Var.n();
        kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (kotlinx.coroutines.internal.y yVar = (kotlinx.coroutines.internal.y) n6; !kotlin.jvm.internal.g0.g(yVar, q2Var); yVar = yVar.o()) {
            if (yVar instanceof f2) {
                k2 k2Var = (k2) yVar;
                try {
                    k2Var.z(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.l.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + k2Var + " for " + this, th2);
                        kotlin.n1 n1Var = kotlin.n1.f44123a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            J0(completionHandlerException);
        }
        l0(th);
    }

    private final void Z0(q2 q2Var, Throwable th) {
        Object n6 = q2Var.n();
        kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (kotlinx.coroutines.internal.y yVar = (kotlinx.coroutines.internal.y) n6; !kotlin.jvm.internal.g0.g(yVar, q2Var); yVar = yVar.o()) {
            if (yVar instanceof k2) {
                k2 k2Var = (k2) yVar;
                try {
                    k2Var.z(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.l.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + k2Var + " for " + this, th2);
                        kotlin.n1 n1Var = kotlin.n1.f44123a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            J0(completionHandlerException);
        }
    }

    private final /* synthetic */ <T extends k2> void a1(q2 q2Var, Throwable th) {
        Object n6 = q2Var.n();
        kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (kotlinx.coroutines.internal.y yVar = (kotlinx.coroutines.internal.y) n6; !kotlin.jvm.internal.g0.g(yVar, q2Var); yVar = yVar.o()) {
            kotlin.jvm.internal.g0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (androidx.activity.k.a(yVar)) {
                k2 k2Var = (k2) yVar;
                try {
                    k2Var.z(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.l.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + k2Var + " for " + this, th2);
                        kotlin.n1 n1Var = kotlin.n1.f44123a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            J0(completionHandlerException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(kotlinx.coroutines.selects.m<?> mVar, Object obj) {
        Object H0;
        do {
            H0 = H0();
            if (!(H0 instanceof y1)) {
                if (!(H0 instanceof d0)) {
                    H0 = m2.h(H0);
                }
                mVar.f(H0);
                return;
            }
        } while (l1(H0) < 0);
        mVar.h(k(new d(mVar)));
    }

    private final void d0(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            for (Throwable th2 : list) {
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    kotlin.l.a(th, th2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(kotlinx.coroutines.selects.m<?> mVar, Object obj) {
        if (!O0()) {
            mVar.f(kotlin.n1.f44123a);
        } else {
            mVar.h(k(new e(mVar)));
        }
    }

    private final Object k0(Object obj) {
        kotlinx.coroutines.internal.s0 s0Var;
        Object s12;
        kotlinx.coroutines.internal.s0 s0Var2;
        do {
            Object H0 = H0();
            if (!(H0 instanceof y1) || ((H0 instanceof c) && ((c) H0).g())) {
                s0Var = m2.f49383a;
                return s0Var;
            }
            s12 = s1(H0, new d0(q0(obj), false, 2, null));
            s0Var2 = m2.f49385c;
        } while (s12 == s0Var2);
        return s12;
    }

    private final boolean l0(Throwable th) {
        if (N0()) {
            return true;
        }
        boolean z5 = th instanceof CancellationException;
        v G0 = G0();
        if (G0 != null && G0 != s2.f49445a) {
            if (G0.b(th) || z5) {
                return true;
            }
            return false;
        }
        return z5;
    }

    private final void o0(y1 y1Var, Object obj) {
        d0 d0Var;
        v G0 = G0();
        if (G0 != null) {
            G0.dispose();
            k1(s2.f49445a);
        }
        Throwable th = null;
        if (obj instanceof d0) {
            d0Var = (d0) obj;
        } else {
            d0Var = null;
        }
        if (d0Var != null) {
            th = d0Var.f48476a;
        }
        if (y1Var instanceof k2) {
            try {
                ((k2) y1Var).z(th);
                return;
            } catch (Throwable th2) {
                J0(new CompletionHandlerException("Exception in completion handler " + y1Var + " for " + this, th2));
                return;
            }
        }
        q2 a6 = y1Var.a();
        if (a6 != null) {
            Z0(a6, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(c cVar, w wVar, Object obj) {
        w X0 = X0(wVar);
        if (X0 != null && u1(cVar, X0, obj)) {
            return;
        }
        e0(t0(cVar, obj));
    }

    private final boolean r1(y1 y1Var, Throwable th) {
        q2 F0 = F0(y1Var);
        if (F0 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f49351a, this, y1Var, new c(F0, false, th))) {
            return false;
        }
        Y0(F0, th);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object t1(y1 y1Var, Object obj) {
        c cVar;
        d0 d0Var;
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        kotlinx.coroutines.internal.s0 s0Var3;
        q2 F0 = F0(y1Var);
        if (F0 == null) {
            s0Var3 = m2.f49385c;
            return s0Var3;
        }
        ?? r22 = 0;
        if (y1Var instanceof c) {
            cVar = (c) y1Var;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            cVar = new c(F0, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (cVar) {
            if (cVar.g()) {
                s0Var2 = m2.f49383a;
                return s0Var2;
            }
            cVar.j(true);
            if (cVar != y1Var && !androidx.concurrent.futures.a.a(f49351a, this, y1Var, cVar)) {
                s0Var = m2.f49385c;
                return s0Var;
            }
            boolean f6 = cVar.f();
            if (obj instanceof d0) {
                d0Var = (d0) obj;
            } else {
                d0Var = null;
            }
            if (d0Var != null) {
                cVar.b(d0Var.f48476a);
            }
            Throwable e6 = cVar.e();
            if (!f6) {
                r22 = e6;
            }
            objectRef.element = r22;
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            if (r22 != 0) {
                Y0(F0, r22);
            }
            w u02 = u0(y1Var);
            if (u02 != null && u1(cVar, u02, obj)) {
                return m2.f49384b;
            }
            return t0(cVar, obj);
        }
    }

    private final Throwable z0(c cVar, List<? extends Throwable> list) {
        Object obj;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (!cVar.f()) {
                return null;
            }
            return new JobCancellationException(m0(), null, this);
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    @Nullable
    public final Throwable F() {
        Object H0 = H0();
        if (!(H0 instanceof y1)) {
            return y0(H0);
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final j1 G(boolean z5, boolean z6, @NotNull Function1<? super Throwable, kotlin.n1> function1) {
        d0 d0Var;
        k2 V0 = V0(function1, z5);
        while (true) {
            Object H0 = H0();
            if (H0 instanceof m1) {
                m1 m1Var = (m1) H0;
                if (m1Var.isActive()) {
                    if (androidx.concurrent.futures.a.a(f49351a, this, H0, V0)) {
                        break;
                    }
                } else {
                    g1(m1Var);
                }
            } else {
                Throwable th = null;
                if (H0 instanceof y1) {
                    q2 a6 = ((y1) H0).a();
                    if (a6 == null) {
                        kotlin.jvm.internal.g0.n(H0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        h1((k2) H0);
                    } else {
                        j1 j1Var = s2.f49445a;
                        if (z5 && (H0 instanceof c)) {
                            synchronized (H0) {
                                try {
                                    th = ((c) H0).e();
                                    if (th != null) {
                                        if ((function1 instanceof w) && !((c) H0).g()) {
                                        }
                                        kotlin.n1 n1Var = kotlin.n1.f44123a;
                                    }
                                    if (c0(H0, a6, V0)) {
                                        if (th == null) {
                                            return V0;
                                        }
                                        j1Var = V0;
                                        kotlin.n1 n1Var2 = kotlin.n1.f44123a;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z6) {
                                function1.invoke(th);
                            }
                            return j1Var;
                        }
                        if (c0(H0, a6, V0)) {
                            break;
                        }
                    }
                } else {
                    if (z6) {
                        if (H0 instanceof d0) {
                            d0Var = (d0) H0;
                        } else {
                            d0Var = null;
                        }
                        if (d0Var != null) {
                            th = d0Var.f48476a;
                        }
                        function1.invoke(th);
                    }
                    return s2.f49445a;
                }
            }
        }
        return V0;
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public final CancellationException H() {
        Object H0 = H0();
        if (H0 instanceof c) {
            Throwable e6 = ((c) H0).e();
            if (e6 != null) {
                CancellationException n12 = n1(e6, u0.a(this) + " is cancelling");
                if (n12 != null) {
                    return n12;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(H0 instanceof y1)) {
            if (H0 instanceof d0) {
                return o1(this, ((d0) H0).f48476a, null, 1, null);
            }
            return new JobCancellationException(u0.a(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.u2
    @NotNull
    public CancellationException K() {
        CancellationException cancellationException;
        Object H0 = H0();
        CancellationException cancellationException2 = null;
        if (H0 instanceof c) {
            cancellationException = ((c) H0).e();
        } else if (H0 instanceof d0) {
            cancellationException = ((d0) H0).f48476a;
        } else if (!(H0 instanceof y1)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + H0).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is " + m1(H0), cancellationException, this);
        }
        return cancellationException2;
    }

    @Override // kotlinx.coroutines.e2
    @Nullable
    public final Object M(@NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        if (!O0()) {
            h2.z(eVar.getContext());
            return kotlin.n1.f44123a;
        }
        Object P0 = P0(eVar);
        if (P0 == kotlin.coroutines.intrinsics.a.l()) {
            return P0;
        }
        return kotlin.n1.f44123a;
    }

    public final boolean M0() {
        return H0() instanceof d0;
    }

    public final boolean T0(@Nullable Object obj) {
        Object s12;
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        do {
            s12 = s1(H0(), obj);
            s0Var = m2.f49383a;
            if (s12 == s0Var) {
                return false;
            }
            if (s12 != m2.f49384b) {
                s0Var2 = m2.f49385c;
            } else {
                return true;
            }
        } while (s12 == s0Var2);
        e0(s12);
        return true;
    }

    @Nullable
    public final Object U0(@Nullable Object obj) {
        Object s12;
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        do {
            s12 = s1(H0(), obj);
            s0Var = m2.f49383a;
            if (s12 != s0Var) {
                s0Var2 = m2.f49385c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, y0(obj));
            }
        } while (s12 == s0Var2);
        return s12;
    }

    @NotNull
    public String W0() {
        return u0.a(this);
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    @Nullable
    protected final Object f0(@NotNull kotlin.coroutines.e<Object> eVar) {
        Object H0;
        do {
            H0 = H0();
            if (!(H0 instanceof y1)) {
                if (!(H0 instanceof d0)) {
                    return m2.h(H0);
                }
                throw ((d0) H0).f48476a;
            }
        } while (l1(H0) < 0);
        return g0(eVar);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    public <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
        return (R) e2.a.d(this, r5, function2);
    }

    @Override // kotlinx.coroutines.x
    public final void g(@NotNull u2 u2Var) {
        i0(u2Var);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> cVar) {
        return (E) e2.a.e(this, cVar);
    }

    @Override // kotlinx.coroutines.e2
    @Nullable
    public e2 getParent() {
        v G0 = G0();
        if (G0 != null) {
            return G0.getParent();
        }
        return null;
    }

    public final boolean h0(@Nullable Throwable th) {
        return i0(th);
    }

    public final boolean i0(@Nullable Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.s0 s0Var;
        kotlinx.coroutines.internal.s0 s0Var2;
        kotlinx.coroutines.internal.s0 s0Var3;
        obj2 = m2.f49383a;
        if (!D0() || (obj2 = k0(obj)) != m2.f49384b) {
            s0Var = m2.f49383a;
            if (obj2 == s0Var) {
                obj2 = S0(obj);
            }
            s0Var2 = m2.f49383a;
            if (obj2 != s0Var2 && obj2 != m2.f49384b) {
                s0Var3 = m2.f49386d;
                if (obj2 == s0Var3) {
                    return false;
                }
                e0(obj2);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isActive() {
        Object H0 = H0();
        if ((H0 instanceof y1) && ((y1) H0).isActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.e2
    public final boolean isCancelled() {
        Object H0 = H0();
        if (!(H0 instanceof d0)) {
            if (!(H0 instanceof c) || !((c) H0).f()) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // kotlinx.coroutines.e2
    public final boolean isCompleted() {
        return !(H0() instanceof y1);
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public e2 j(@NotNull e2 e2Var) {
        return e2.a.j(this, e2Var);
    }

    public void j0(@NotNull Throwable th) {
        i0(th);
    }

    public final void j1(@NotNull k2 k2Var) {
        Object H0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        m1 m1Var;
        do {
            H0 = H0();
            if (H0 instanceof k2) {
                if (H0 == k2Var) {
                    atomicReferenceFieldUpdater = f49351a;
                    m1Var = m2.f49392j;
                } else {
                    return;
                }
            } else {
                if ((H0 instanceof y1) && ((y1) H0).a() != null) {
                    k2Var.u();
                    return;
                }
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, H0, m1Var));
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i minusKey(@NotNull i.c<?> cVar) {
        return e2.a.h(this, cVar);
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i plus(@NotNull kotlin.coroutines.i iVar) {
        return e2.a.i(this, iVar);
    }

    @Override // kotlinx.coroutines.e2
    public final boolean start() {
        int l12;
        do {
            l12 = l1(H0());
            if (l12 == 0) {
                return false;
            }
        } while (l12 != 1);
        return true;
    }

    @Nullable
    public final Object v0() {
        Object H0 = H0();
        if (!(H0 instanceof y1)) {
            if (!(H0 instanceof d0)) {
                return m2.h(H0);
            }
            throw ((d0) H0).f48476a;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    @Nullable
    protected final Throwable w0() {
        Object H0 = H0();
        if (H0 instanceof c) {
            Throwable e6 = ((c) H0).e();
            if (e6 != null) {
                return e6;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(H0 instanceof y1)) {
            if (H0 instanceof d0) {
                return ((d0) H0).f48476a;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    protected final boolean x0() {
        Object H0 = H0();
        if ((H0 instanceof d0) && ((d0) H0).a()) {
            return true;
        }
        return false;
    }

    protected static /* synthetic */ void C0() {
    }

    public static /* synthetic */ void E0() {
    }

    protected void f1() {
    }

    public void J0(@NotNull Throwable th) {
        throw th;
    }

    protected void d1(@Nullable Throwable th) {
    }

    protected void e0(@Nullable Object obj) {
    }

    protected void e1(@Nullable Object obj) {
    }
}
