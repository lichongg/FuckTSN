package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final byte[] a(Base64 base64, CharSequence source, int i6, int i7) {
        g0.p(base64, "<this>");
        g0.p(source, "source");
        if (!(source instanceof String)) {
            return base64.f(source, i6, i7);
        }
        String str = (String) source;
        base64.i(str.length(), i6, i7);
        String substring = str.substring(i6, i7);
        g0.o(substring, "substring(...)");
        Charset charset = kotlin.text.e.f47856g;
        g0.n(substring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = substring.getBytes(charset);
        g0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final int b(Base64 base64, byte[] source, byte[] destination, int i6, int i7, int i8) {
        g0.p(base64, "<this>");
        g0.p(source, "source");
        g0.p(destination, "destination");
        return base64.x(source, destination, i6, i7, i8);
    }

    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final byte[] c(Base64 base64, byte[] source, int i6, int i7) {
        g0.p(base64, "<this>");
        g0.p(source, "source");
        return base64.D(source, i6, i7);
    }

    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final String d(Base64 base64, byte[] source, int i6, int i7) {
        g0.p(base64, "<this>");
        g0.p(source, "source");
        return new String(base64.D(source, i6, i7), kotlin.text.e.f47856g);
    }
}
