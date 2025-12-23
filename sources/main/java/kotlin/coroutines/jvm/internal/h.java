package kotlin.coroutines.jvm.internal;

import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class h implements kotlin.coroutines.e<n1> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Result<n1> f43778a;

    public final void b() {
        synchronized (this) {
            while (true) {
                try {
                    Result<n1> result = this.f43778a;
                    if (result == null) {
                        g0.n(this, "null cannot be cast to non-null type java.lang.Object");
                        wait();
                    } else {
                        kotlin.g0.n(result.m139unboximpl());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        synchronized (this) {
            this.f43778a = Result.m129boximpl(obj);
            g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            n1 n1Var = n1.f44123a;
        }
    }

    @Nullable
    public final Result<n1> c() {
        return this.f43778a;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final void setResult(@Nullable Result<n1> result) {
        this.f43778a = result;
    }
}
