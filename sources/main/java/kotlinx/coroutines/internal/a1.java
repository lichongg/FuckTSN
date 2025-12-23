package kotlinx.coroutines.internal;

import kotlin.PublishedApi;
import kotlin.coroutines.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a1 implements i.c<z0<?>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ThreadLocal<?> f49240a;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a1) && kotlin.jvm.internal.g0.g(this.f49240a, ((a1) obj).f49240a);
    }

    private final ThreadLocal<?> a() {
        return this.f49240a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a1 c(a1 a1Var, ThreadLocal threadLocal, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            threadLocal = a1Var.f49240a;
        }
        return a1Var.b(threadLocal);
    }

    @NotNull
    public final a1 b(@NotNull ThreadLocal<?> threadLocal) {
        return new a1(threadLocal);
    }

    public int hashCode() {
        return this.f49240a.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f49240a + ')';
    }

    public a1(@NotNull ThreadLocal<?> threadLocal) {
        this.f49240a = threadLocal;
    }
}
