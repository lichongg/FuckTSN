package okhttp3;

import java.nio.charset.Charset;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Credentials {

    @NotNull
    public static final Credentials INSTANCE = new Credentials();

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String basic(@NotNull String username, @NotNull String password) {
        g0.p(username, "username");
        g0.p(password, "password");
        return basic$default(username, password, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String basic(@NotNull String username, @NotNull String password, @NotNull Charset charset) {
        g0.p(username, "username");
        g0.p(password, "password");
        g0.p(charset, "charset");
        return "Basic " + ByteString.Companion.encodeString(username + ':' + password, charset).base64();
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            charset = kotlin.text.e.f47856g;
        }
        return basic(str, str2, charset);
    }

    private Credentials() {
    }
}
