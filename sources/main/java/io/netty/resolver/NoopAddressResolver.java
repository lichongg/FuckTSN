package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NoopAddressResolver extends AbstractAddressResolver<SocketAddress> {
    @Override // io.netty.resolver.AbstractAddressResolver
    protected boolean doIsResolved(SocketAddress socketAddress) {
        return true;
    }

    public NoopAddressResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    protected void doResolve(SocketAddress socketAddress, Promise<SocketAddress> promise) throws Exception {
        promise.setSuccess(socketAddress);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    protected void doResolveAll(SocketAddress socketAddress, Promise<List<SocketAddress>> promise) throws Exception {
        promise.setSuccess(Collections.singletonList(socketAddress));
    }
}
