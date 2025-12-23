package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.net.ssl.X509KeyManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class OpenSslCachingKeyMaterialProvider extends OpenSslKeyMaterialProvider {
    private final ConcurrentMap<String, OpenSslKeyMaterial> cache;

    @Override // io.netty.handler.ssl.OpenSslKeyMaterialProvider
    OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator, String str) throws Exception {
        OpenSslKeyMaterial openSslKeyMaterial = this.cache.get(str);
        if (openSslKeyMaterial == null) {
            openSslKeyMaterial = super.chooseKeyMaterial(byteBufAllocator, str);
            if (openSslKeyMaterial == null) {
                return null;
            }
            OpenSslKeyMaterial putIfAbsent = this.cache.putIfAbsent(str, openSslKeyMaterial);
            if (putIfAbsent != null) {
                openSslKeyMaterial.release();
                openSslKeyMaterial = putIfAbsent;
            }
        }
        return openSslKeyMaterial.retain();
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterialProvider
    void destroy() {
        do {
            Iterator<OpenSslKeyMaterial> it = this.cache.values().iterator();
            while (it.hasNext()) {
                it.next().release();
                it.remove();
            }
        } while (!this.cache.isEmpty());
    }

    OpenSslCachingKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        super(x509KeyManager, str);
        this.cache = new ConcurrentHashMap();
    }
}
