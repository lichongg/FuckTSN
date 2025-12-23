package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface Interceptor {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Chain {
        @NotNull
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        @NotNull
        Response proceed(@NotNull Request request) throws IOException;

        int readTimeoutMillis();

        @NotNull
        Request request();

        @NotNull
        Chain withConnectTimeout(int i6, @NotNull TimeUnit timeUnit);

        @NotNull
        Chain withReadTimeout(int i6, @NotNull TimeUnit timeUnit);

        @NotNull
        Chain withWriteTimeout(int i6, @NotNull TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public final Interceptor invoke(@NotNull final Function1<? super Chain, Response> block) {
            g0.p(block, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain it) {
                    g0.p(it, "it");
                    return block.invoke(it);
                }
            };
        }

        private Companion() {
        }
    }

    @NotNull
    Response intercept(@NotNull Chain chain) throws IOException;
}
