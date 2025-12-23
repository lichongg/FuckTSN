package okhttp3;

import java.io.IOException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface Authenticator {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final Authenticator NONE = new Companion.AuthenticatorNone();

    @JvmField
    @NotNull
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, null);

    @Nullable
    Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            @Nullable
            public Request authenticate(@Nullable Route route, @NotNull Response response) {
                g0.p(response, "response");
                return null;
            }
        }

        private Companion() {
        }
    }
}
