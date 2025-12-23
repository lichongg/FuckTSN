package okio.internal;

import java.util.logging.Logger;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class _JavaIoKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError assertionError) {
        g0.p(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? u.l3(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }
}
