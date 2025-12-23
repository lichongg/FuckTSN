package io.netty.handler.codec.spdy;

import io.netty.channel.CombinedChannelDuplexHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SpdyHttpCodec extends CombinedChannelDuplexHandler<SpdyHttpDecoder, SpdyHttpEncoder> {
    public SpdyHttpCodec(SpdyVersion spdyVersion, int i6) {
        super(new SpdyHttpDecoder(spdyVersion, i6), new SpdyHttpEncoder(spdyVersion));
    }

    public SpdyHttpCodec(SpdyVersion spdyVersion, int i6, boolean z5) {
        super(new SpdyHttpDecoder(spdyVersion, i6, z5), new SpdyHttpEncoder(spdyVersion));
    }
}
