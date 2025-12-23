package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultAddressResolverGroup extends AddressResolverGroup<InetSocketAddress> {
    public static final DefaultAddressResolverGroup INSTANCE = new DefaultAddressResolverGroup();

    @Override // io.netty.resolver.AddressResolverGroup
    protected AddressResolver<InetSocketAddress> newResolver(EventExecutor eventExecutor) throws Exception {
        return new DefaultNameResolver(eventExecutor).asAddressResolver();
    }

    private DefaultAddressResolverGroup() {
    }
}
