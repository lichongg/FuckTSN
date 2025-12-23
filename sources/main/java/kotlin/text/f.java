package kotlin.text;

import java.nio.charset.Charset;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "CharsetsKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {
    @InlineOnly
    private static final Charset a(String charsetName) {
        kotlin.jvm.internal.g0.p(charsetName, "charsetName");
        Charset forName = Charset.forName(charsetName);
        kotlin.jvm.internal.g0.o(forName, "forName(...)");
        return forName;
    }
}
