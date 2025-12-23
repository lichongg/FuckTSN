package androidx.room;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class TransactionElement implements i.b {

    @NotNull
    public static final Key Key = new Key(null);

    @NotNull
    private final AtomicInteger referenceCount;

    @NotNull
    private final kotlin.coroutines.f transactionDispatcher;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Key implements i.c<TransactionElement> {
        public /* synthetic */ Key(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Key() {
        }
    }

    public TransactionElement(@NotNull kotlin.coroutines.f transactionDispatcher) {
        g0.p(transactionDispatcher, "transactionDispatcher");
        this.transactionDispatcher = transactionDispatcher;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // kotlin.coroutines.i.b
    @NotNull
    public i.c<TransactionElement> getKey() {
        return Key;
    }

    @NotNull
    public final kotlin.coroutines.f getTransactionDispatcher$room_runtime_release() {
        return this.transactionDispatcher;
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    public <R> R fold(R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
        return (R) i.b.a.a(this, r5, function2);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> cVar) {
        return (E) i.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i minusKey(@NotNull i.c<?> cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i plus(@NotNull kotlin.coroutines.i iVar) {
        return i.b.a.d(this, iVar);
    }
}
