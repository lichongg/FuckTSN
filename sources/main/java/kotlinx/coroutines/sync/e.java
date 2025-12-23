package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.internal.q0;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r3;
import kotlinx.coroutines.s;
import kotlinx.coroutines.selects.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 5 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n205#1,10:411\n205#1,10:421\n1#2:398\n332#3,12:399\n72#4,3:431\n46#4,8:434\n72#4,3:445\n46#4,8:448\n375#5:442\n375#5:443\n367#5:444\n378#5:456\n367#5:457\n375#5:458\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreImpl\n*L\n197#1:411,10\n221#1:421,10\n187#1:399,12\n289#1:431,3\n289#1:434,8\n322#1:445,3\n322#1:448,8\n293#1:442\n299#1:443\n313#1:444\n328#1:456\n334#1:457\n337#1:458\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class e implements d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49628c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f49629d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49630e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f49631f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49632g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits");

    @Volatile
    private volatile int _availablePermits;

    /* renamed from: a, reason: collision with root package name */
    private final int f49633a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<Throwable, n1> f49634b;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    @Nullable
    private volatile Object head;

    @Volatile
    @Nullable
    private volatile Object tail;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function2<Long, g, g> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49635a = new a();

        a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ g invoke(Long l6, g gVar) {
            return c(l6.longValue(), gVar);
        }

        @NotNull
        public final g c(long j6, @Nullable g gVar) {
            g j7;
            j7 = f.j(j6, gVar);
            return j7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Throwable, n1> {
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        b() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            e.this.release();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class c extends FunctionReferenceImpl implements Function2<Long, g, g> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f49637a = new c();

        c() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ g invoke(Long l6, g gVar) {
            return c(l6.longValue(), gVar);
        }

        @NotNull
        public final g c(long j6, @Nullable g gVar) {
            g j7;
            j7 = f.j(j6, gVar);
            return j7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(r3 r3Var) {
        int i6;
        Object g6;
        int i7;
        s0 s0Var;
        s0 s0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49630e;
        g gVar = (g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f49631f.getAndIncrement(this);
        a aVar = a.f49635a;
        i6 = f.f49643f;
        long j6 = andIncrement / i6;
        loop0: while (true) {
            g6 = kotlinx.coroutines.internal.f.g(gVar, j6, aVar);
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
        g gVar2 = (g) q0.f(g6);
        i7 = f.f49643f;
        int i8 = (int) (andIncrement % i7);
        if (com.google.common.util.concurrent.b.a(gVar2.v(), i8, null, r3Var)) {
            r3Var.b(gVar2, i8);
            return true;
        }
        s0Var = f.f49639b;
        s0Var2 = f.f49640c;
        if (!com.google.common.util.concurrent.b.a(gVar2.v(), i8, s0Var, s0Var2)) {
            return false;
        }
        if (r3Var instanceof p) {
            g0.n(r3Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((p) r3Var).o(n1.f44123a, this.f49634b);
        } else {
            if (!(r3Var instanceof m)) {
                throw new IllegalStateException(("unexpected: " + r3Var).toString());
            }
            ((m) r3Var).f(n1.f44123a);
        }
        return true;
    }

    private final void k() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        int i7;
        do {
            atomicIntegerFieldUpdater = f49632g;
            i6 = atomicIntegerFieldUpdater.get(this);
            i7 = this.f49633a;
            if (i6 <= i7) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, i7));
    }

    private final int l() {
        int andDecrement;
        do {
            andDecrement = f49632g.getAndDecrement(this);
        } while (andDecrement > this.f49633a);
        return andDecrement;
    }

    private final boolean n(Object obj) {
        if (!(obj instanceof p)) {
            if (obj instanceof m) {
                return ((m) obj).j(this, n1.f44123a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        p pVar = (p) obj;
        Object O = pVar.O(n1.f44123a, null, this.f49634b);
        if (O == null) {
            return false;
        }
        pVar.B(O);
        return true;
    }

    private final boolean o() {
        int i6;
        Object g6;
        int i7;
        s0 s0Var;
        s0 s0Var2;
        int i8;
        s0 s0Var3;
        s0 s0Var4;
        s0 s0Var5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49628c;
        g gVar = (g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f49629d.getAndIncrement(this);
        i6 = f.f49643f;
        long j6 = andIncrement / i6;
        c cVar = c.f49637a;
        loop0: while (true) {
            g6 = kotlinx.coroutines.internal.f.g(gVar, j6, cVar);
            if (q0.h(g6)) {
                break;
            }
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
        }
        g gVar2 = (g) q0.f(g6);
        gVar2.b();
        if (gVar2.f49297c > j6) {
            return false;
        }
        i7 = f.f49643f;
        int i9 = (int) (andIncrement % i7);
        s0Var = f.f49639b;
        Object andSet = gVar2.v().getAndSet(i9, s0Var);
        if (andSet != null) {
            s0Var2 = f.f49642e;
            if (andSet == s0Var2) {
                return false;
            }
            return n(andSet);
        }
        i8 = f.f49638a;
        for (int i10 = 0; i10 < i8; i10++) {
            Object obj = gVar2.v().get(i9);
            s0Var5 = f.f49640c;
            if (obj == s0Var5) {
                return true;
            }
        }
        s0Var3 = f.f49639b;
        s0Var4 = f.f49641d;
        return !com.google.common.util.concurrent.b.a(gVar2.v(), i9, s0Var3, s0Var4);
    }

    @Override // kotlinx.coroutines.sync.d
    public boolean a() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49632g;
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 > this.f49633a) {
                k();
            } else {
                if (i6 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 - 1)) {
                    return true;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.d
    public int b() {
        return Math.max(f49632g.get(this), 0);
    }

    @Override // kotlinx.coroutines.sync.d
    public void release() {
        do {
            int andIncrement = f49632g.getAndIncrement(this);
            if (andIncrement >= this.f49633a) {
                k();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f49633a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!o());
    }

    public e(int i6, int i7) {
        this.f49633a = i6;
        if (i6 > 0) {
            if (i7 >= 0 && i7 <= i6) {
                g gVar = new g(0L, null, 2);
                this.head = gVar;
                this.tail = gVar;
                this._availablePermits = i6 - i7;
                this.f49634b = new b();
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i6).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i6).toString());
    }

    private final <W> void f(W w5, Function1<? super W, Boolean> function1, Function1<? super W, n1> function12) {
        while (l() <= 0) {
            if (function1.invoke(w5).booleanValue()) {
                return;
            }
        }
        function12.invoke(w5);
    }

    static /* synthetic */ Object h(e eVar, kotlin.coroutines.e<? super n1> eVar2) {
        if (eVar.l() > 0) {
            return n1.f44123a;
        }
        Object i6 = eVar.i(eVar2);
        if (i6 == kotlin.coroutines.intrinsics.a.l()) {
            return i6;
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(kotlin.coroutines.e<? super n1> eVar) {
        q b6 = s.b(kotlin.coroutines.intrinsics.a.e(eVar));
        try {
            if (!j(b6)) {
                g(b6);
            }
            Object x5 = b6.x();
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                return x5;
            }
            return n1.f44123a;
        } catch (Throwable th) {
            b6.N();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.sync.d
    @Nullable
    public Object c(@NotNull kotlin.coroutines.e<? super n1> eVar) {
        return h(this, eVar);
    }

    protected final void g(@NotNull p<? super n1> pVar) {
        while (l() <= 0) {
            g0.n(pVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (j((r3) pVar)) {
                return;
            }
        }
        pVar.o(n1.f44123a, this.f49634b);
    }

    protected final void m(@NotNull m<?> mVar, @Nullable Object obj) {
        while (l() <= 0) {
            g0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (j((r3) mVar)) {
                return;
            }
        }
        mVar.f(n1.f44123a);
    }
}
