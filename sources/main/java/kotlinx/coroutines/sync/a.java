package kotlinx.coroutines.sync;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.n1;
import kotlinx.coroutines.selects.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlinx.coroutines.sync.a$a, reason: collision with other inner class name */
    public static final class C0957a {
        public static /* synthetic */ Object b(a aVar, Object obj, kotlin.coroutines.e eVar, int i6, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i6 & 1) != 0) {
                obj = null;
            }
            return aVar.lock(obj, eVar);
        }

        public static /* synthetic */ boolean c(a aVar, Object obj, int i6, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i6 & 1) != 0) {
                obj = null;
            }
            return aVar.tryLock(obj);
        }

        public static /* synthetic */ void d(a aVar, Object obj, int i6, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i6 & 1) != 0) {
                obj = null;
            }
            aVar.unlock(obj);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static /* synthetic */ void a() {
        }
    }

    @NotNull
    i<Object, a> getOnLock();

    boolean holdsLock(@NotNull Object obj);

    boolean isLocked();

    @Nullable
    Object lock(@Nullable Object obj, @NotNull kotlin.coroutines.e<? super n1> eVar);

    boolean tryLock(@Nullable Object obj);

    void unlock(@Nullable Object obj);
}
