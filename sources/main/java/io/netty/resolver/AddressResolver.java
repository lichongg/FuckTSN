package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface AddressResolver<T extends SocketAddress> extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isResolved(SocketAddress socketAddress);

    boolean isSupported(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress);

    Future<T> resolve(SocketAddress socketAddress, Promise<T> promise);

    Future<List<T>> resolveAll(SocketAddress socketAddress);

    Future<List<T>> resolveAll(SocketAddress socketAddress, Promise<List<T>> promise);
}
