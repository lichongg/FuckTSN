package io.netty.handler.ssl;

import javax.net.ssl.SSLParameters;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Java7SslParametersUtils {
    private Java7SslParametersUtils() {
    }

    static void setAlgorithmConstraints(SSLParameters sSLParameters, Object obj) {
        sSLParameters.setAlgorithmConstraints(a.a(obj));
    }
}
