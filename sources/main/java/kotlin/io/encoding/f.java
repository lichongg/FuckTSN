package kotlin.io.encoding;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class f {
    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @NotNull
    public static final InputStream a(@NotNull InputStream inputStream, @NotNull Base64 base64) {
        g0.p(inputStream, "<this>");
        g0.p(base64, "base64");
        return new c(inputStream, base64);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @NotNull
    public static final OutputStream b(@NotNull OutputStream outputStream, @NotNull Base64 base64) {
        g0.p(outputStream, "<this>");
        g0.p(base64, "base64");
        return new d(outputStream, base64);
    }
}
