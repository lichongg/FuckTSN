package io.netty.resolver;

import androidx.exifinterface.media.ExifInterface;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractAddressResolver<T extends SocketAddress> implements AddressResolver<T> {
    private final EventExecutor executor;
    private final TypeParameterMatcher matcher;

    protected AbstractAddressResolver(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
        this.matcher = TypeParameterMatcher.find(this, AbstractAddressResolver.class, ExifInterface.GPS_DIRECTION_TRUE);
    }

    protected abstract boolean doIsResolved(T t5);

    protected abstract void doResolve(T t5, Promise<T> promise) throws Exception;

    protected abstract void doResolveAll(T t5, Promise<List<T>> promise) throws Exception;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<T> resolve(SocketAddress socketAddress) {
        if (!isSupported((SocketAddress) ObjectUtil.checkNotNull(socketAddress, "address"))) {
            return executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return this.executor.newSucceededFuture(socketAddress);
        }
        try {
            Promise<T> newPromise = executor().newPromise();
            doResolve(socketAddress, newPromise);
            return newPromise;
        } catch (Exception e6) {
            return executor().newFailedFuture(e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<List<T>> resolveAll(SocketAddress socketAddress) {
        if (!isSupported((SocketAddress) ObjectUtil.checkNotNull(socketAddress, "address"))) {
            return executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return this.executor.newSucceededFuture(Collections.singletonList(socketAddress));
        }
        try {
            Promise<List<T>> newPromise = executor().newPromise();
            doResolveAll(socketAddress, newPromise);
            return newPromise;
        } catch (Exception e6) {
            return executor().newFailedFuture(e6);
        }
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.resolver.AddressResolver
    public boolean isSupported(SocketAddress socketAddress) {
        return this.matcher.match(socketAddress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final boolean isResolved(SocketAddress socketAddress) {
        if (isSupported(socketAddress)) {
            return doIsResolved(socketAddress);
        }
        throw new UnsupportedAddressTypeException();
    }

    protected AbstractAddressResolver(EventExecutor eventExecutor, Class<? extends T> cls) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
        this.matcher = TypeParameterMatcher.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<T> resolve(SocketAddress socketAddress, Promise<T> promise) {
        ObjectUtil.checkNotNull(socketAddress, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isSupported(socketAddress)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return promise.setSuccess(socketAddress);
        }
        try {
            doResolve(socketAddress, promise);
            return promise;
        } catch (Exception e6) {
            return promise.setFailure(e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.resolver.AddressResolver
    public final Future<List<T>> resolveAll(SocketAddress socketAddress, Promise<List<T>> promise) {
        ObjectUtil.checkNotNull(socketAddress, "address");
        ObjectUtil.checkNotNull(promise, "promise");
        if (!isSupported(socketAddress)) {
            return promise.setFailure(new UnsupportedAddressTypeException());
        }
        if (isResolved(socketAddress)) {
            return promise.setSuccess(Collections.singletonList(socketAddress));
        }
        try {
            doResolveAll(socketAddress, promise);
            return promise;
        } catch (Exception e6) {
            return promise.setFailure(e6);
        }
    }

    @Override // io.netty.resolver.AddressResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
