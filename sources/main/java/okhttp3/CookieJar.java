package okhttp3;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface CookieJar {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    @NotNull
    List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl);

    void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            @NotNull
            public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
                g0.p(url, "url");
                return f0.J();
            }

            @Override // okhttp3.CookieJar
            public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
                g0.p(url, "url");
                g0.p(cookies, "cookies");
            }
        }

        private Companion() {
        }
    }
}
