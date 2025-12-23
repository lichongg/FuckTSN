package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d implements k {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Lock f47089b;

    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d(@NotNull Lock lock) {
        g0.p(lock, "lock");
        this.f47089b = lock;
    }

    @NotNull
    protected final Lock a() {
        return this.f47089b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.k
    public void lock() {
        this.f47089b.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.k
    public void unlock() {
        this.f47089b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i6, v vVar) {
        this((i6 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
