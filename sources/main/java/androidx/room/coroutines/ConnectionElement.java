package androidx.room.coroutines;

import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class ConnectionElement implements i.b {

    @NotNull
    public static final Key Key = new Key(null);

    @NotNull
    private final PooledConnectionImpl connectionWrapper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Key implements i.c<ConnectionElement> {
        public /* synthetic */ Key(v vVar) {
            this();
        }

        private Key() {
        }
    }

    public ConnectionElement(@NotNull PooledConnectionImpl connectionWrapper) {
        g0.p(connectionWrapper, "connectionWrapper");
        this.connectionWrapper = connectionWrapper;
    }

    @NotNull
    public final PooledConnectionImpl getConnectionWrapper() {
        return this.connectionWrapper;
    }

    @Override // kotlin.coroutines.i.b
    @NotNull
    public i.c<ConnectionElement> getKey() {
        return Key;
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
    public i minusKey(@NotNull i.c<?> cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.i
    @NotNull
    public i plus(@NotNull i iVar) {
        return i.b.a.d(this, iVar);
    }
}
