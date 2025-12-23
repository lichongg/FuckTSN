package io.netty.handler.ssl;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
interface OpenSslSession extends SSLSession {
    void handshakeFinished() throws SSLException;

    void tryExpandApplicationBufferSize(int i6);
}
