package okhttp3.internal.connection;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Socket;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface BufferedSocket extends Socket {
    @Override // okio.Socket
    @NotNull
    BufferedSink getSink();

    @Override // okio.Socket
    @NotNull
    BufferedSource getSource();
}
