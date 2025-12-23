package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface JdkApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class AllocatorAwareSslEngineWrapperFactory implements SslEngineWrapperFactory {
        abstract SSLEngine wrapSslEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z5);

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
        public final SSLEngine wrapSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z5) {
            return wrapSslEngine(sSLEngine, ByteBufAllocator.DEFAULT, jdkApplicationProtocolNegotiator, z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ProtocolSelectionListener {
        void selected(String str) throws Exception;

        void unsupported();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ProtocolSelectionListenerFactory {
        ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ProtocolSelector {
        String select(List<String> list) throws Exception;

        void unsupported();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ProtocolSelectorFactory {
        ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface SslEngineWrapperFactory {
        SSLEngine wrapSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z5);
    }

    ProtocolSelectionListenerFactory protocolListenerFactory();

    ProtocolSelectorFactory protocolSelectorFactory();

    SslEngineWrapperFactory wrapperFactory();
}
