package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class z<E> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49332a = AtomicReferenceFieldUpdater.newUpdater(z.class, Object.class, "_cur");

    @Volatile
    @Nullable
    private volatile Object _cur;

    public final boolean a(@NotNull E e6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49332a;
        while (true) {
            a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
            int a6 = a0Var.a(e6);
            if (a6 == 0) {
                return true;
            }
            if (a6 == 1) {
                androidx.concurrent.futures.a.a(f49332a, this, a0Var, a0Var.m());
            } else if (a6 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49332a;
        while (true) {
            a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
            if (a0Var.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(f49332a, this, a0Var, a0Var.m());
            }
        }
    }

    public final int c() {
        return ((a0) f49332a.get(this)).f();
    }

    public final boolean d() {
        return ((a0) f49332a.get(this)).g();
    }

    public final boolean e() {
        return ((a0) f49332a.get(this)).h();
    }

    @NotNull
    public final <R> List<R> g(@NotNull Function1<? super E, ? extends R> function1) {
        return ((a0) f49332a.get(this)).k(function1);
    }

    @Nullable
    public final E h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49332a;
        while (true) {
            a0 a0Var = (a0) atomicReferenceFieldUpdater.get(this);
            E e6 = (E) a0Var.n();
            if (e6 != a0.f49231t) {
                return e6;
            }
            androidx.concurrent.futures.a.a(f49332a, this, a0Var, a0Var.m());
        }
    }

    public z(boolean z5) {
        this._cur = new a0(8, z5);
    }

    private final void f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }
}
