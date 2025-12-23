package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(26)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Api26Impl {

    @NotNull
    public static final Api26Impl INSTANCE = new Api26Impl();

    public final long toMillis(@NotNull Duration timeout) {
        g0.p(timeout, "timeout");
        return timeout.toMillis();
    }

    private Api26Impl() {
    }
}
