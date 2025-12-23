package io.netty.handler.ssl;

import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslDefaultApplicationProtocolNegotiator implements OpenSslApplicationProtocolNegotiator {
    private final ApplicationProtocolConfig config;

    @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.Protocol protocol() {
        return this.config.protocol();
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return this.config.supportedProtocols();
    }

    @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.config.selectedListenerFailureBehavior();
    }

    @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
        return this.config.selectorFailureBehavior();
    }

    public OpenSslDefaultApplicationProtocolNegotiator(ApplicationProtocolConfig applicationProtocolConfig) {
        this.config = (ApplicationProtocolConfig) ObjectUtil.checkNotNull(applicationProtocolConfig, "config");
    }
}
