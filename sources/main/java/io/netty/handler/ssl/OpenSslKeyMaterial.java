package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
interface OpenSslKeyMaterial extends ReferenceCounted {
    X509Certificate[] certificateChain();

    long certificateChainAddress();

    long privateKeyAddress();

    @Override // io.netty.util.ReferenceCounted
    boolean release();

    @Override // io.netty.util.ReferenceCounted
    boolean release(int i6);

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain();

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial retain(int i6);

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch();

    @Override // io.netty.util.ReferenceCounted
    OpenSslKeyMaterial touch(Object obj);
}
