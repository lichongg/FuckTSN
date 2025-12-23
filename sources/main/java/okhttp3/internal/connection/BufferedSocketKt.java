package okhttp3.internal.connection;

import java.net.Socket;
import kotlin.jvm.internal.g0;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BufferedSocketKt {
    @NotNull
    public static final BufferedSocket asBufferedSocket(@NotNull Socket socket) {
        g0.p(socket, "<this>");
        return asBufferedSocket(Okio.socket(socket));
    }

    @NotNull
    public static final BufferedSocket asBufferedSocket(@NotNull final okio.Socket socket) {
        g0.p(socket, "<this>");
        return new BufferedSocket(socket) { // from class: okhttp3.internal.connection.BufferedSocketKt$asBufferedSocket$1
            private final okio.Socket delegate;
            private final BufferedSink sink;
            private final BufferedSource source;

            @Override // okio.Socket
            public void cancel() {
                this.delegate.cancel();
            }

            @Override // okio.Socket
            public BufferedSink getSink() {
                return this.sink;
            }

            @Override // okio.Socket
            public BufferedSource getSource() {
                return this.source;
            }

            {
                this.delegate = socket;
                this.source = Okio.buffer(socket.getSource());
                this.sink = Okio.buffer(socket.getSink());
            }
        };
    }
}
