package okio.internal;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g0;
import okio.AsyncTimeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {

    @NotNull
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket) {
        g0.p(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    @NotNull
    protected IOException newTimeoutException(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.socket.close();
        } catch (AssertionError e6) {
            if (!_JavaIoKt.isAndroidGetsocknameError(e6)) {
                throw e6;
            }
            logger2 = _JavaIoKt.logger;
            logger2.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e6);
        } catch (Exception e7) {
            logger = _JavaIoKt.logger;
            logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e7);
        }
    }
}
