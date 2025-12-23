package okhttp3.internal;

import kotlin.jvm.internal.g0;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class NativeImageTestsAccessorsKt {
    @NotNull
    public static final Cache buildCache(@NotNull Path file, long j6, @NotNull FileSystem fileSystem) {
        g0.p(file, "file");
        g0.p(fileSystem, "fileSystem");
        return new Cache(fileSystem, file, j6);
    }

    public static final void finishedAccessor(@NotNull Dispatcher dispatcher, @NotNull RealCall.AsyncCall call) {
        g0.p(dispatcher, "<this>");
        g0.p(call, "call");
        dispatcher.finished$okhttp(call);
    }

    @NotNull
    public static final RealConnection getConnectionAccessor(@NotNull Exchange exchange) {
        g0.p(exchange, "<this>");
        return exchange.getConnection$okhttp();
    }

    @Nullable
    public static final Exchange getExchangeAccessor(@NotNull Response response) {
        g0.p(response, "<this>");
        return response.exchange();
    }

    public static final long getIdleAtNsAccessor(@NotNull RealConnection realConnection) {
        g0.p(realConnection, "<this>");
        return realConnection.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(@NotNull RealConnection realConnection, long j6) {
        g0.p(realConnection, "<this>");
        realConnection.setIdleAtNs(j6);
    }
}
