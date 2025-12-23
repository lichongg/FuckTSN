package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.n1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class c<T> extends kotlinx.coroutines.a<T> implements BiFunction<T, Throwable, n1> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final CompletableFuture<T> f49194d;

    public c(@NotNull kotlin.coroutines.i iVar, @NotNull CompletableFuture<T> completableFuture) {
        super(iVar, true, true);
        this.f49194d = completableFuture;
    }

    public void A1(@Nullable T t5, @Nullable Throwable th) {
        e2.a.b(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ n1 apply(Object obj, Throwable th) {
        A1(obj, th);
        return n1.f44123a;
    }

    @Override // kotlinx.coroutines.a
    protected void x1(@NotNull Throwable th, boolean z5) {
        this.f49194d.completeExceptionally(th);
    }

    @Override // kotlinx.coroutines.a
    protected void y1(T t5) {
        this.f49194d.complete(t5);
    }
}
