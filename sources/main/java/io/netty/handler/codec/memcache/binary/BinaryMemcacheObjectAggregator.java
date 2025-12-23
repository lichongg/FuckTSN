package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectAggregator;
import io.netty.handler.codec.memcache.FullMemcacheMessage;
import io.netty.handler.codec.memcache.MemcacheObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BinaryMemcacheObjectAggregator extends AbstractMemcacheObjectAggregator<BinaryMemcacheMessage> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public FullMemcacheMessage beginAggregation(BinaryMemcacheMessage binaryMemcacheMessage, ByteBuf byteBuf) throws Exception {
        if (binaryMemcacheMessage instanceof BinaryMemcacheRequest) {
            return toFullRequest((BinaryMemcacheRequest) binaryMemcacheMessage, byteBuf);
        }
        if (binaryMemcacheMessage instanceof BinaryMemcacheResponse) {
            return toFullResponse((BinaryMemcacheResponse) binaryMemcacheMessage, byteBuf);
        }
        throw new Error();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(MemcacheObject memcacheObject) throws Exception {
        return memcacheObject instanceof BinaryMemcacheMessage;
    }

    public BinaryMemcacheObjectAggregator(int i6) {
        super(i6);
    }

    private static FullBinaryMemcacheRequest toFullRequest(BinaryMemcacheRequest binaryMemcacheRequest, ByteBuf byteBuf) {
        ByteBuf retain;
        ByteBuf byteBuf2 = null;
        if (binaryMemcacheRequest.key() == null) {
            retain = null;
        } else {
            retain = binaryMemcacheRequest.key().retain();
        }
        if (binaryMemcacheRequest.extras() != null) {
            byteBuf2 = binaryMemcacheRequest.extras().retain();
        }
        DefaultFullBinaryMemcacheRequest defaultFullBinaryMemcacheRequest = new DefaultFullBinaryMemcacheRequest(retain, byteBuf2, byteBuf);
        defaultFullBinaryMemcacheRequest.setMagic(binaryMemcacheRequest.magic());
        defaultFullBinaryMemcacheRequest.setOpcode(binaryMemcacheRequest.opcode());
        defaultFullBinaryMemcacheRequest.setKeyLength(binaryMemcacheRequest.keyLength());
        defaultFullBinaryMemcacheRequest.setExtrasLength(binaryMemcacheRequest.extrasLength());
        defaultFullBinaryMemcacheRequest.setDataType(binaryMemcacheRequest.dataType());
        defaultFullBinaryMemcacheRequest.setTotalBodyLength(binaryMemcacheRequest.totalBodyLength());
        defaultFullBinaryMemcacheRequest.setOpaque(binaryMemcacheRequest.opaque());
        defaultFullBinaryMemcacheRequest.setCas(binaryMemcacheRequest.cas());
        defaultFullBinaryMemcacheRequest.setReserved(binaryMemcacheRequest.reserved());
        return defaultFullBinaryMemcacheRequest;
    }

    private static FullBinaryMemcacheResponse toFullResponse(BinaryMemcacheResponse binaryMemcacheResponse, ByteBuf byteBuf) {
        ByteBuf retain;
        ByteBuf byteBuf2 = null;
        if (binaryMemcacheResponse.key() == null) {
            retain = null;
        } else {
            retain = binaryMemcacheResponse.key().retain();
        }
        if (binaryMemcacheResponse.extras() != null) {
            byteBuf2 = binaryMemcacheResponse.extras().retain();
        }
        DefaultFullBinaryMemcacheResponse defaultFullBinaryMemcacheResponse = new DefaultFullBinaryMemcacheResponse(retain, byteBuf2, byteBuf);
        defaultFullBinaryMemcacheResponse.setMagic(binaryMemcacheResponse.magic());
        defaultFullBinaryMemcacheResponse.setOpcode(binaryMemcacheResponse.opcode());
        defaultFullBinaryMemcacheResponse.setKeyLength(binaryMemcacheResponse.keyLength());
        defaultFullBinaryMemcacheResponse.setExtrasLength(binaryMemcacheResponse.extrasLength());
        defaultFullBinaryMemcacheResponse.setDataType(binaryMemcacheResponse.dataType());
        defaultFullBinaryMemcacheResponse.setTotalBodyLength(binaryMemcacheResponse.totalBodyLength());
        defaultFullBinaryMemcacheResponse.setOpaque(binaryMemcacheResponse.opaque());
        defaultFullBinaryMemcacheResponse.setCas(binaryMemcacheResponse.cas());
        defaultFullBinaryMemcacheResponse.setStatus(binaryMemcacheResponse.status());
        return defaultFullBinaryMemcacheResponse;
    }
}
