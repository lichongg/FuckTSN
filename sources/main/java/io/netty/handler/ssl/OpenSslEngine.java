package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    OpenSslEngine(OpenSslContext openSslContext, ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5) {
        super(openSslContext, byteBufAllocator, str, i6, z5, false);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
