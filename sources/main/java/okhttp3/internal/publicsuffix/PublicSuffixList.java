package okhttp3.internal.publicsuffix;

import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface PublicSuffixList {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    void ensureLoaded();

    @NotNull
    ByteString getBytes();

    @NotNull
    ByteString getExceptionBytes();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
