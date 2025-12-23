package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c1<T> extends kotlinx.coroutines.internal.o0<T> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f48110e = AtomicIntegerFieldUpdater.newUpdater(c1.class, "_decision");

    @Volatile
    @JvmField
    private volatile int _decision;

    @NotNull
    public static final AtomicIntegerFieldUpdater B1() {
        return f48110e;
    }

    private final boolean D1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f48110e;
        do {
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f48110e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean E1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f48110e;
        do {
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f48110e.compareAndSet(this, 0, 1));
        return true;
    }

    public c1(@NotNull kotlin.coroutines.i iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        super(iVar, eVar);
    }

    private final void C1(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    @Nullable
    public final Object A1() {
        if (E1()) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        Object h6 = m2.h(H0());
        if (!(h6 instanceof d0)) {
            return h6;
        }
        throw ((d0) h6).f48476a;
    }

    @Override // kotlinx.coroutines.internal.o0, kotlinx.coroutines.l2
    protected void e0(@Nullable Object obj) {
        v1(obj);
    }

    @Override // kotlinx.coroutines.internal.o0, kotlinx.coroutines.a
    protected void v1(@Nullable Object obj) {
        if (D1()) {
            return;
        }
        kotlinx.coroutines.internal.m.e(kotlin.coroutines.intrinsics.a.e(this.f49294d), i0.a(obj, this.f49294d), null, 2, null);
    }
}
