package io.netty.handler.ssl;

import javax.net.ssl.SSLException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NotSslRecordException extends SSLException {
    private static final long serialVersionUID = -4316784434770656841L;

    public NotSslRecordException() {
        super("");
    }

    public NotSslRecordException(String str) {
        super(str);
    }

    public NotSslRecordException(Throwable th) {
        super(th);
    }

    public NotSslRecordException(String str, Throwable th) {
        super(str, th);
    }
}
