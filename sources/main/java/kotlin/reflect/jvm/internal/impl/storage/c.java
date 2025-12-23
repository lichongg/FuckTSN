package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Runnable f47087c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Function1<InterruptedException, n1> f47088d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Lock lock, @NotNull Runnable checkCancelled, @NotNull Function1<? super InterruptedException, n1> interruptedExceptionHandler) {
        super(lock);
        g0.p(lock, "lock");
        g0.p(checkCancelled, "checkCancelled");
        g0.p(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.f47087c = checkCancelled;
        this.f47088d = interruptedExceptionHandler;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.d, kotlin.reflect.jvm.internal.impl.storage.k
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f47087c.run();
            } catch (InterruptedException e6) {
                this.f47088d.invoke(e6);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Runnable checkCancelled, @NotNull Function1<? super InterruptedException, n1> interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        g0.p(checkCancelled, "checkCancelled");
        g0.p(interruptedExceptionHandler, "interruptedExceptionHandler");
    }
}
