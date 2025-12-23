package io.netty.handler.proxy;

import java.net.ConnectException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ProxyConnectException extends ConnectException {
    private static final long serialVersionUID = 5211364632246265538L;

    public ProxyConnectException() {
    }

    public ProxyConnectException(String str) {
        super(str);
    }

    public ProxyConnectException(Throwable th) {
        initCause(th);
    }

    public ProxyConnectException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
