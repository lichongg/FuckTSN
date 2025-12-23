package io.netty.handler.address;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class DynamicAddressConnectHandler extends ChannelOutboundHandlerAdapter {
    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public final void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        try {
            channelHandlerContext.connect(remoteAddress(socketAddress, socketAddress2), localAddress(socketAddress, socketAddress2), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.address.DynamicAddressConnectHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        channelFuture.channel().pipeline().remove(DynamicAddressConnectHandler.this);
                    }
                }
            });
        } catch (Exception e6) {
            channelPromise.setFailure((Throwable) e6);
        }
    }

    protected SocketAddress localAddress(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        return socketAddress2;
    }

    protected SocketAddress remoteAddress(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        return socketAddress;
    }
}
