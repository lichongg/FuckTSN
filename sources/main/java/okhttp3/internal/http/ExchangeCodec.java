package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RealCall;
import okio.Sink;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface ExchangeCodec {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Carrier {
        /* renamed from: cancel */
        void mo289cancel();

        @NotNull
        Route getRoute();

        void noNewExchanges();

        void trackFailure(@NotNull RealCall realCall, @Nullable IOException iOException);
    }

    void cancel();

    @NotNull
    Sink createRequestBody(@NotNull Request request, long j6) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    @NotNull
    Carrier getCarrier();

    @NotNull
    Socket getSocket();

    boolean isResponseComplete();

    @NotNull
    Source openResponseBodySource(@NotNull Response response) throws IOException;

    @Nullable
    Headers peekTrailers() throws IOException;

    @Nullable
    Response.Builder readResponseHeaders(boolean z5) throws IOException;

    long reportedContentLength(@NotNull Response response) throws IOException;

    void writeRequestHeaders(@NotNull Request request) throws IOException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }
}
