package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class c2 extends f2 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f48111f = AtomicIntegerFieldUpdater.newUpdater(c2.class, "_invoked");

    @Volatile
    private volatile int _invoked;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Function1<Throwable, kotlin.n1> f48112e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        if (f48111f.compareAndSet(this, 0, 1)) {
            this.f48112e.invoke(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c2(@NotNull Function1<? super Throwable, kotlin.n1> function1) {
        this.f48112e = function1;
    }
}
