package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface AddressedEnvelope<M, A extends SocketAddress> extends ReferenceCounted {
    M content();

    A recipient();

    @Override // io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> retain();

    @Override // io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> retain(int i6);

    A sender();

    @Override // io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> touch();

    @Override // io.netty.util.ReferenceCounted
    AddressedEnvelope<M, A> touch(Object obj);
}
