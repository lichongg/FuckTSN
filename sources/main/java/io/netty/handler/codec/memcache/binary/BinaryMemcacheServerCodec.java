package io.netty.handler.codec.memcache.binary;

import io.netty.channel.CombinedChannelDuplexHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BinaryMemcacheServerCodec extends CombinedChannelDuplexHandler<BinaryMemcacheRequestDecoder, BinaryMemcacheResponseEncoder> {
    public BinaryMemcacheServerCodec() {
        this(8192);
    }

    public BinaryMemcacheServerCodec(int i6) {
        super(new BinaryMemcacheRequestDecoder(i6), new BinaryMemcacheResponseEncoder());
    }
}
