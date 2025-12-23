package io.netty.handler.ssl;

import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class OpenSslNpnApplicationProtocolNegotiator implements OpenSslApplicationProtocolNegotiator {
    private final List<String> protocols;

    public OpenSslNpnApplicationProtocolNegotiator(Iterable<String> iterable) {
        this.protocols = (List) ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(iterable), "protocols");
    }

    @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.Protocol protocol() {
        return ApplicationProtocolConfig.Protocol.NPN;
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return this.protocols;
    }

    @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
    }

    @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
        return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
    }

    public OpenSslNpnApplicationProtocolNegotiator(String... strArr) {
        this.protocols = (List) ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(strArr), "protocols");
    }
}
