package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class l3 implements Function1<Throwable, kotlin.n1> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49376d = AtomicIntegerFieldUpdater.newUpdater(l3.class, "_state");

    @Volatile
    private volatile int _state;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final e2 f49377a;

    /* renamed from: b, reason: collision with root package name */
    private final Thread f49378b = Thread.currentThread();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private j1 f49379c;

    private final Void b(int i6) {
        throw new IllegalStateException(("Illegal state " + i6).toString());
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49376d;
        while (true) {
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i6);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f49376d.compareAndSet(this, i6, 1)) {
                j1 j1Var = this.f49379c;
                if (j1Var != null) {
                    j1Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void c(@Nullable Throwable th) {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f49376d;
        do {
            i6 = atomicIntegerFieldUpdater2.get(this);
            if (i6 != 0) {
                if (i6 == 1 || i6 == 2 || i6 == 3) {
                    return;
                }
                b(i6);
                throw new KotlinNothingValueException();
            }
            atomicIntegerFieldUpdater = f49376d;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, 2));
        this.f49378b.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void f() {
        int i6;
        this.f49379c = this.f49377a.G(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49376d;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 == 2 || i6 == 3) {
                    return;
                }
                b(i6);
                throw new KotlinNothingValueException();
            }
        } while (!f49376d.compareAndSet(this, i6, 0));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        c(th);
        return kotlin.n1.f44123a;
    }

    public l3(@NotNull e2 e2Var) {
        this.f49377a = e2Var;
    }

    private final void d(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }
}
