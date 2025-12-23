package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class InetNameResolver extends SimpleNameResolver<InetAddress> {
    private volatile AddressResolver<InetSocketAddress> addressResolver;

    public AddressResolver<InetSocketAddress> asAddressResolver() {
        AddressResolver<InetSocketAddress> addressResolver;
        AddressResolver<InetSocketAddress> addressResolver2 = this.addressResolver;
        if (addressResolver2 != null) {
            return addressResolver2;
        }
        synchronized (this) {
            try {
                addressResolver = this.addressResolver;
                if (addressResolver == null) {
                    addressResolver = new InetSocketAddressResolver(executor(), this);
                    this.addressResolver = addressResolver;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return addressResolver;
    }

    protected InetNameResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }
}
