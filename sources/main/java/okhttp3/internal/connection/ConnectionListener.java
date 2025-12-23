package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class ConnectionListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ConnectionListener NONE = new ConnectionListener() { // from class: okhttp3.internal.connection.ConnectionListener$Companion$NONE$1
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ConnectionListener getNONE() {
            return ConnectionListener.NONE;
        }
    }

    public void connectEnd(@NotNull Connection connection, @NotNull Route route, @NotNull Call call) {
        g0.p(connection, "connection");
        g0.p(route, "route");
        g0.p(call, "call");
    }

    public void connectFailed(@NotNull Route route, @NotNull Call call, @NotNull IOException failure) {
        g0.p(route, "route");
        g0.p(call, "call");
        g0.p(failure, "failure");
    }

    public void connectStart(@NotNull Route route, @NotNull Call call) {
        g0.p(route, "route");
        g0.p(call, "call");
    }

    public void connectionAcquired(@NotNull Connection connection, @NotNull Call call) {
        g0.p(connection, "connection");
        g0.p(call, "call");
    }

    public void connectionClosed(@NotNull Connection connection) {
        g0.p(connection, "connection");
    }

    public void connectionReleased(@NotNull Connection connection, @NotNull Call call) {
        g0.p(connection, "connection");
        g0.p(call, "call");
    }

    public void noNewExchanges(@NotNull Connection connection) {
        g0.p(connection, "connection");
    }
}
