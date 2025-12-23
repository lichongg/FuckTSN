package okhttp3.internal;

import java.text.Normalizer;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class _NormalizeJvmKt {
    @NotNull
    public static final String normalizeNfc(@NotNull String string) {
        g0.p(string, "string");
        String normalize = Normalizer.normalize(string, Normalizer.Form.NFC);
        g0.o(normalize, "normalize(...)");
        return normalize;
    }
}
