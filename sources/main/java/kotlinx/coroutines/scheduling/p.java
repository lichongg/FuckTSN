package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49518b = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49519c = AtomicIntegerFieldUpdater.newUpdater(p.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49520d = AtomicIntegerFieldUpdater.newUpdater(p.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49521e = AtomicIntegerFieldUpdater.newUpdater(p.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray<j> f49522a = new AtomicReferenceArray<>(128);

    @Volatile
    private volatile int blockingTasksInBuffer;

    @Volatile
    private volatile int consumerIndex;

    @Volatile
    @Nullable
    private volatile Object lastScheduledTask;

    @Volatile
    private volatile int producerIndex;

    @Nullable
    public final j i() {
        return m(true);
    }

    @Nullable
    public final j k() {
        return m(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long p(int i6, @NotNull Ref.ObjectRef<j> objectRef) {
        T j6 = i6 == 3 ? j() : n(i6);
        if (j6 == 0) {
            return q(i6, objectRef);
        }
        objectRef.element = j6;
        return -1L;
    }

    public static /* synthetic */ j b(p pVar, j jVar, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return pVar.a(jVar, z5);
    }

    private final void d(j jVar) {
        if (jVar == null || jVar.f49504b.q() != 1) {
            return;
        }
        f49521e.decrementAndGet(this);
    }

    private final int e() {
        return f49519c.get(this) - f49520d.get(this);
    }

    private final j j() {
        j andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49520d;
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 - f49519c.get(this) == 0) {
                return null;
            }
            int i7 = i6 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 + 1) && (andSet = this.f49522a.getAndSet(i7, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final j m(boolean z5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        j jVar;
        do {
            atomicReferenceFieldUpdater = f49518b;
            jVar = (j) atomicReferenceFieldUpdater.get(this);
            if (jVar != null) {
                if ((jVar.f49504b.q() == 1) == z5) {
                }
            }
            int i6 = f49520d.get(this);
            int i7 = f49519c.get(this);
            while (i6 != i7) {
                if (z5 && f49521e.get(this) == 0) {
                    return null;
                }
                i7--;
                j o5 = o(i7, z5);
                if (o5 != null) {
                    return o5;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, jVar, null));
        return jVar;
    }

    private final j n(int i6) {
        int i7 = f49520d.get(this);
        int i8 = f49519c.get(this);
        boolean z5 = i6 == 1;
        while (i7 != i8) {
            if (z5 && f49521e.get(this) == 0) {
                return null;
            }
            int i9 = i7 + 1;
            j o5 = o(i7, z5);
            if (o5 != null) {
                return o5;
            }
            i7 = i9;
        }
        return null;
    }

    private final j o(int i6, boolean z5) {
        int i7 = i6 & 127;
        j jVar = this.f49522a.get(i7);
        if (jVar != null) {
            if ((jVar.f49504b.q() == 1) == z5 && com.google.common.util.concurrent.b.a(this.f49522a, i7, jVar, null)) {
                if (z5) {
                    f49521e.decrementAndGet(this);
                }
                return jVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.j] */
    private final long q(int i6, Ref.ObjectRef<j> objectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r12;
        do {
            atomicReferenceFieldUpdater = f49518b;
            r12 = (j) atomicReferenceFieldUpdater.get(this);
            if (r12 == 0) {
                return -2L;
            }
            if (((r12.f49504b.q() != 1 ? 2 : 1) & i6) == 0) {
                return -2L;
            }
            long a6 = n.f49512f.a() - r12.f49503a;
            long j6 = n.f49508b;
            if (a6 < j6) {
                return j6 - a6;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, r12, null));
        objectRef.element = r12;
        return -1L;
    }

    @Nullable
    public final j a(@NotNull j jVar, boolean z5) {
        if (z5) {
            return c(jVar);
        }
        j jVar2 = (j) f49518b.getAndSet(this, jVar);
        if (jVar2 == null) {
            return null;
        }
        return c(jVar2);
    }

    public final int f() {
        return f49518b.get(this) != null ? e() + 1 : e();
    }

    public final void g(@NotNull e eVar) {
        j jVar = (j) f49518b.getAndSet(this, null);
        if (jVar != null) {
            eVar.a(jVar);
        }
        while (l(eVar)) {
        }
    }

    @Nullable
    public final j h() {
        j jVar = (j) f49518b.getAndSet(this, null);
        return jVar == null ? j() : jVar;
    }

    private final j c(j jVar) {
        if (e() == 127) {
            return jVar;
        }
        if (jVar.f49504b.q() == 1) {
            f49521e.incrementAndGet(this);
        }
        int i6 = f49519c.get(this) & 127;
        while (this.f49522a.get(i6) != null) {
            Thread.yield();
        }
        this.f49522a.lazySet(i6, jVar);
        f49519c.incrementAndGet(this);
        return null;
    }

    private final boolean l(e eVar) {
        j j6 = j();
        if (j6 == null) {
            return false;
        }
        eVar.a(j6);
        return true;
    }
}
