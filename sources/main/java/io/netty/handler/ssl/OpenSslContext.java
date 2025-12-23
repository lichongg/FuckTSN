package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.security.cert.Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class OpenSslContext extends ReferenceCountedOpenSslContext {
    OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j6, long j7, int i6, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j6, j7, i6, certificateArr, clientAuth, strArr, z5, z6, false);
    }

    OpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j6, long j7, int i6, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z5, boolean z6) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j6, j7, i6, certificateArr, clientAuth, strArr, z5, z6, false);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    final SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5) {
        return new OpenSslEngine(this, byteBufAllocator, str, i6, z5);
    }

    protected final void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
