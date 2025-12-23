package io.netty.handler.codec.memcache;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;
import io.netty.handler.codec.memcache.MemcacheMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractMemcacheObjectAggregator<H extends MemcacheMessage> extends MessageAggregator<MemcacheObject, H, MemcacheContent, FullMemcacheMessage> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentLengthInvalid(H h6, int i6) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public Object newContinueResponse(H h6, int i6, ChannelPipeline channelPipeline) {
        return null;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean closeAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean ignoreContentAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isAggregated(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof FullMemcacheMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof MemcacheContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(MemcacheContent memcacheContent) throws Exception {
        return memcacheContent instanceof LastMemcacheContent;
    }

    protected AbstractMemcacheObjectAggregator(int i6) {
        super(i6);
    }
}
