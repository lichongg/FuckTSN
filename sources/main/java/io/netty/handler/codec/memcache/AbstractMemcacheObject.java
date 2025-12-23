package io.netty.handler.codec.memcache;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.AbstractReferenceCounted;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractMemcacheObject extends AbstractReferenceCounted implements MemcacheObject {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        if (decoderResult == null) {
            throw new NullPointerException("DecoderResult should not be null.");
        }
        this.decoderResult = decoderResult;
    }

    protected AbstractMemcacheObject() {
    }
}
