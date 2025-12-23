package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g<N extends g<N>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49263a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49264b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    @Nullable
    private volatile Object _prev;

    public abstract boolean h();

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return f49263a.get(this);
    }

    public final void b() {
        f49264b.lazySet(this, null);
    }

    @Nullable
    public final N g() {
        return (N) f49264b.get(this);
    }

    public final boolean j() {
        return androidx.concurrent.futures.a.a(f49263a, this, null, f.f49257b);
    }

    public final boolean m(@NotNull N n6) {
        return androidx.concurrent.futures.a.a(f49263a, this, null, n6);
    }

    public g(@Nullable N n6) {
        this._prev = n6;
    }

    private final N c() {
        N g6 = g();
        while (g6 != null && g6.h()) {
            g6 = (N) f49264b.get(g6);
        }
        return g6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.g] */
    private final N d() {
        ?? e6;
        N e7 = e();
        kotlin.jvm.internal.g0.m(e7);
        while (e7.h() && (e6 = e7.e()) != 0) {
            e7 = e6;
        }
        return e7;
    }

    private final void n(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
    }

    @Nullable
    public final N e() {
        Object f6 = f();
        if (f6 == f.f49257b) {
            return null;
        }
        return (N) f6;
    }

    public final boolean i() {
        if (e() == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final N k(@NotNull Function0 function0) {
        Object f6 = f();
        if (f6 != f.f49257b) {
            return (N) f6;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    public final void l() {
        Object obj;
        N n6;
        if (i()) {
            return;
        }
        while (true) {
            N c6 = c();
            N d6 = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49264b;
            do {
                obj = atomicReferenceFieldUpdater.get(d6);
                if (((g) obj) == null) {
                    n6 = null;
                } else {
                    n6 = c6;
                }
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, d6, obj, n6));
            if (c6 != null) {
                f49263a.set(c6, d6);
            }
            if (!d6.h() || d6.i()) {
                if (c6 == null || !c6.h()) {
                    return;
                }
            }
        }
    }
}
