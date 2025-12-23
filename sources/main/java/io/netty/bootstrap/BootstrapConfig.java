package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.resolver.AddressResolverGroup;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class BootstrapConfig extends AbstractBootstrapConfig<Bootstrap, Channel> {
    public SocketAddress remoteAddress() {
        return ((Bootstrap) this.bootstrap).remoteAddress();
    }

    public AddressResolverGroup<?> resolver() {
        return ((Bootstrap) this.bootstrap).resolver();
    }

    @Override // io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", resolver: ");
        sb.append(resolver());
        SocketAddress remoteAddress = remoteAddress();
        if (remoteAddress != null) {
            sb.append(", remoteAddress: ");
            sb.append(remoteAddress);
        }
        sb.append(')');
        return sb.toString();
    }

    BootstrapConfig(Bootstrap bootstrap) {
        super(bootstrap);
    }
}
