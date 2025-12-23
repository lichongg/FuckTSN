package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.eclipse.jetty.npn.NextProtoNego;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class JettyNpnSslEngine extends JdkSslEngine {
    private static boolean available;

    private static void updateAvailability() {
        if (available) {
            return;
        }
        try {
            Class.forName("sun.security.ssl.NextProtoNegoExtension", true, null);
            available = true;
        } catch (Exception unused) {
        }
    }

    JettyNpnSslEngine(SSLEngine sSLEngine, final JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z5) {
        super(sSLEngine);
        ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
        if (z5) {
            final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolSelectionListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols()), "protocolListener");
            NextProtoNego.put(sSLEngine, new NextProtoNego.ServerProvider() { // from class: io.netty.handler.ssl.JettyNpnSslEngine.1
                public void protocolSelected(String str) {
                    try {
                        protocolSelectionListener.selected(str);
                    } catch (Throwable th) {
                        PlatformDependent.throwException(th);
                    }
                }

                public List<String> protocols() {
                    return jdkApplicationProtocolNegotiator.protocols();
                }

                public void unsupported() {
                    protocolSelectionListener.unsupported();
                }
            });
        } else {
            final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())), "protocolSelector");
            NextProtoNego.put(sSLEngine, new NextProtoNego.ClientProvider() { // from class: io.netty.handler.ssl.JettyNpnSslEngine.2
                public boolean supports() {
                    return true;
                }

                public String selectProtocol(List<String> list) {
                    try {
                        return protocolSelector.select(list);
                    } catch (Throwable th) {
                        PlatformDependent.throwException(th);
                        return null;
                    }
                }

                public void unsupported() {
                    protocolSelector.unsupported();
                }
            });
        }
    }

    static boolean isAvailable() {
        updateAvailability();
        return available;
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        NextProtoNego.remove(getWrappedEngine());
        super.closeInbound();
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeOutbound() {
        NextProtoNego.remove(getWrappedEngine());
        super.closeOutbound();
    }
}
