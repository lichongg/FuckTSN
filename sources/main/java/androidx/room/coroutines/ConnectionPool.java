package androidx.room.coroutines;

import androidx.room.Transactor;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface ConnectionPool extends AutoCloseable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class RollbackException extends Throwable {

        @Nullable
        private final Object result;

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        public RollbackException(@Nullable Object obj) {
            this.result = obj;
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    @Nullable
    <R> Object useConnection(boolean z5, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar);
}
