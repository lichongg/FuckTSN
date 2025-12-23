package com.kwad.sdk.core.network.idc;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DomainException extends Exception {
    private final Pattern CONNECT_ERR_PATTERN;
    private final int httpCode;

    public DomainException(int i6) {
        this(i6, null);
    }

    public DomainException(Throwable th) {
        this(-1, th);
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public DomainException(int i6, Throwable th) {
        super(th);
        this.CONNECT_ERR_PATTERN = Pattern.compile(".*(ECONN(RESET|REFUSED|ABORTED)|ETIMEDOUT|ENETUNREACH|EHOSTUNREACH).*", 2);
        this.httpCode = i6;
    }

    private Exception getInternal() {
        Throwable cause = getCause();
        if (cause instanceof Exception) {
            return (Exception) cause;
        }
        return null;
    }

    boolean isConnectException() {
        String message;
        Exception internal = getInternal();
        if (internal == null) {
            return false;
        }
        if (!(internal instanceof SocketTimeoutException) && !(internal instanceof ConnectTimeoutException) && !(internal instanceof SocketException) && !(internal instanceof UnknownHostException)) {
            if (!internal.getClass().getSimpleName().equalsIgnoreCase("ErrnoException") || (message = internal.getMessage()) == null) {
                return false;
            }
            return this.CONNECT_ERR_PATTERN.matcher(message).find();
        }
        return true;
    }
}
