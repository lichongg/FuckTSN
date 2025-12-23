package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AddressResolverGroup<T extends SocketAddress> implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AddressResolverGroup.class);
    private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();

    protected abstract AddressResolver<T> newResolver(EventExecutor eventExecutor) throws Exception;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i6;
        AddressResolver[] addressResolverArr;
        synchronized (this.resolvers) {
            addressResolverArr = (AddressResolver[]) this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
        }
        for (AddressResolver addressResolver : addressResolverArr) {
            try {
                addressResolver.close();
            } catch (Throwable th) {
                logger.warn("Failed to close a resolver:", th);
            }
        }
    }

    public AddressResolver<T> getResolver(final EventExecutor eventExecutor) {
        final AddressResolver<T> addressResolver;
        if (eventExecutor == null) {
            throw new NullPointerException("executor");
        }
        if (eventExecutor.isShuttingDown()) {
            throw new IllegalStateException("executor not accepting a task");
        }
        synchronized (this.resolvers) {
            try {
                addressResolver = this.resolvers.get(eventExecutor);
                if (addressResolver == null) {
                    try {
                        addressResolver = newResolver(eventExecutor);
                        this.resolvers.put(eventExecutor, addressResolver);
                        eventExecutor.terminationFuture().addListener(new FutureListener<Object>() { // from class: io.netty.resolver.AddressResolverGroup.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(Future<Object> future) throws Exception {
                                synchronized (AddressResolverGroup.this.resolvers) {
                                    AddressResolverGroup.this.resolvers.remove(eventExecutor);
                                }
                                addressResolver.close();
                            }
                        });
                    } catch (Exception e6) {
                        throw new IllegalStateException("failed to create a new resolver", e6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return addressResolver;
    }

    protected AddressResolverGroup() {
    }
}
