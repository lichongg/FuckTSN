package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface v extends j1 {
    @InternalCoroutinesApi
    boolean b(@NotNull Throwable th);

    @Nullable
    e2 getParent();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @InternalCoroutinesApi
        public static /* synthetic */ void a() {
        }
    }
}
