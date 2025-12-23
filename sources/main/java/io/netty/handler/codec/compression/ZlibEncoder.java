package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class ZlibEncoder extends MessageToByteEncoder<ByteBuf> {
    protected ZlibEncoder() {
        super(false);
    }

    public abstract ChannelFuture close();

    public abstract ChannelFuture close(ChannelPromise channelPromise);

    public abstract boolean isClosed();
}
