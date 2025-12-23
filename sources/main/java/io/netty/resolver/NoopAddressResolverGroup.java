package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NoopAddressResolverGroup extends AddressResolverGroup<SocketAddress> {
    public static final NoopAddressResolverGroup INSTANCE = new NoopAddressResolverGroup();

    @Override // io.netty.resolver.AddressResolverGroup
    protected AddressResolver<SocketAddress> newResolver(EventExecutor eventExecutor) throws Exception {
        return new NoopAddressResolver(eventExecutor);
    }

    private NoopAddressResolverGroup() {
    }
}
