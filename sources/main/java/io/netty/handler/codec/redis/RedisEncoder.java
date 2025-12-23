package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class RedisEncoder extends MessageToMessageEncoder<RedisMessage> {
    private final RedisMessagePool messagePool;

    public RedisEncoder() {
        this(FixedRedisMessagePool.INSTANCE);
    }

    private void writeArrayHeader(ByteBufAllocator byteBufAllocator, ArrayHeaderRedisMessage arrayHeaderRedisMessage, List<Object> list) {
        writeArrayHeader(byteBufAllocator, arrayHeaderRedisMessage.isNull(), arrayHeaderRedisMessage.length(), list);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List list) throws Exception {
        encode2(channelHandlerContext, redisMessage, (List<Object>) list);
    }

    public RedisEncoder(RedisMessagePool redisMessagePool) {
        this.messagePool = (RedisMessagePool) ObjectUtil.checkNotNull(redisMessagePool, "messagePool");
    }

    private byte[] numberToBytes(long j6) {
        byte[] byteBufOfInteger = this.messagePool.getByteBufOfInteger(j6);
        return byteBufOfInteger != null ? byteBufOfInteger : RedisCodecUtil.longToAsciiBytes(j6);
    }

    private void writeArrayHeader(ByteBufAllocator byteBufAllocator, boolean z5, long j6, List<Object> list) {
        if (z5) {
            ByteBuf ioBuffer = byteBufAllocator.ioBuffer(5);
            RedisMessageType.ARRAY_HEADER.writeTo(ioBuffer);
            ioBuffer.writeShort(RedisConstants.NULL_SHORT);
            ioBuffer.writeShort(RedisConstants.EOL_SHORT);
            list.add(ioBuffer);
            return;
        }
        ByteBuf ioBuffer2 = byteBufAllocator.ioBuffer(23);
        RedisMessageType.ARRAY_HEADER.writeTo(ioBuffer2);
        ioBuffer2.writeBytes(numberToBytes(j6));
        ioBuffer2.writeShort(RedisConstants.EOL_SHORT);
        list.add(ioBuffer2);
    }

    private static void writeErrorMessage(ByteBufAllocator byteBufAllocator, ErrorRedisMessage errorRedisMessage, List<Object> list) {
        writeString(byteBufAllocator, RedisMessageType.ERROR, errorRedisMessage.content(), list);
    }

    private static void writeInlineCommandMessage(ByteBufAllocator byteBufAllocator, InlineCommandRedisMessage inlineCommandRedisMessage, List<Object> list) {
        writeString(byteBufAllocator, RedisMessageType.INLINE_COMMAND, inlineCommandRedisMessage.content(), list);
    }

    private void writeIntegerMessage(ByteBufAllocator byteBufAllocator, IntegerRedisMessage integerRedisMessage, List<Object> list) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(23);
        RedisMessageType.INTEGER.writeTo(ioBuffer);
        ioBuffer.writeBytes(numberToBytes(integerRedisMessage.value()));
        ioBuffer.writeShort(RedisConstants.EOL_SHORT);
        list.add(ioBuffer);
    }

    private void writeRedisMessage(ByteBufAllocator byteBufAllocator, RedisMessage redisMessage, List<Object> list) {
        if (redisMessage instanceof InlineCommandRedisMessage) {
            writeInlineCommandMessage(byteBufAllocator, (InlineCommandRedisMessage) redisMessage, list);
            return;
        }
        if (redisMessage instanceof SimpleStringRedisMessage) {
            writeSimpleStringMessage(byteBufAllocator, (SimpleStringRedisMessage) redisMessage, list);
            return;
        }
        if (redisMessage instanceof ErrorRedisMessage) {
            writeErrorMessage(byteBufAllocator, (ErrorRedisMessage) redisMessage, list);
            return;
        }
        if (redisMessage instanceof IntegerRedisMessage) {
            writeIntegerMessage(byteBufAllocator, (IntegerRedisMessage) redisMessage, list);
            return;
        }
        if (redisMessage instanceof FullBulkStringRedisMessage) {
            writeFullBulkStringMessage(byteBufAllocator, (FullBulkStringRedisMessage) redisMessage, list);
            return;
        }
        if (redisMessage instanceof BulkStringRedisContent) {
            writeBulkStringContent(byteBufAllocator, (BulkStringRedisContent) redisMessage, list);
            return;
        }
        if (redisMessage instanceof BulkStringHeaderRedisMessage) {
            writeBulkStringHeader(byteBufAllocator, (BulkStringHeaderRedisMessage) redisMessage, list);
            return;
        }
        if (redisMessage instanceof ArrayHeaderRedisMessage) {
            writeArrayHeader(byteBufAllocator, (ArrayHeaderRedisMessage) redisMessage, list);
        } else {
            if (redisMessage instanceof ArrayRedisMessage) {
                writeArrayMessage(byteBufAllocator, (ArrayRedisMessage) redisMessage, list);
                return;
            }
            throw new CodecException("unknown message type: " + redisMessage);
        }
    }

    private static void writeSimpleStringMessage(ByteBufAllocator byteBufAllocator, SimpleStringRedisMessage simpleStringRedisMessage, List<Object> list) {
        writeString(byteBufAllocator, RedisMessageType.SIMPLE_STRING, simpleStringRedisMessage.content(), list);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List<Object> list) throws Exception {
        try {
            writeRedisMessage(channelHandlerContext.alloc(), redisMessage, list);
        } catch (CodecException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new CodecException(e7);
        }
    }

    private void writeArrayMessage(ByteBufAllocator byteBufAllocator, ArrayRedisMessage arrayRedisMessage, List<Object> list) {
        if (arrayRedisMessage.isNull()) {
            writeArrayHeader(byteBufAllocator, arrayRedisMessage.isNull(), -1L, list);
            return;
        }
        writeArrayHeader(byteBufAllocator, arrayRedisMessage.isNull(), arrayRedisMessage.children().size(), list);
        Iterator<RedisMessage> it = arrayRedisMessage.children().iterator();
        while (it.hasNext()) {
            writeRedisMessage(byteBufAllocator, it.next(), list);
        }
    }

    private static void writeBulkStringContent(ByteBufAllocator byteBufAllocator, BulkStringRedisContent bulkStringRedisContent, List<Object> list) {
        list.add(bulkStringRedisContent.content().retain());
        if (bulkStringRedisContent instanceof LastBulkStringRedisContent) {
            list.add(byteBufAllocator.ioBuffer(2).writeShort(RedisConstants.EOL_SHORT));
        }
    }

    private void writeBulkStringHeader(ByteBufAllocator byteBufAllocator, BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, List<Object> list) {
        int i6;
        if (bulkStringHeaderRedisMessage.isNull()) {
            i6 = 2;
        } else {
            i6 = 22;
        }
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(i6 + 1);
        RedisMessageType.BULK_STRING.writeTo(ioBuffer);
        if (bulkStringHeaderRedisMessage.isNull()) {
            ioBuffer.writeShort(RedisConstants.NULL_SHORT);
        } else {
            ioBuffer.writeBytes(numberToBytes(bulkStringHeaderRedisMessage.bulkStringLength()));
            ioBuffer.writeShort(RedisConstants.EOL_SHORT);
        }
        list.add(ioBuffer);
    }

    private void writeFullBulkStringMessage(ByteBufAllocator byteBufAllocator, FullBulkStringRedisMessage fullBulkStringRedisMessage, List<Object> list) {
        if (fullBulkStringRedisMessage.isNull()) {
            ByteBuf ioBuffer = byteBufAllocator.ioBuffer(5);
            RedisMessageType.BULK_STRING.writeTo(ioBuffer);
            ioBuffer.writeShort(RedisConstants.NULL_SHORT);
            ioBuffer.writeShort(RedisConstants.EOL_SHORT);
            list.add(ioBuffer);
            return;
        }
        ByteBuf ioBuffer2 = byteBufAllocator.ioBuffer(23);
        RedisMessageType.BULK_STRING.writeTo(ioBuffer2);
        ioBuffer2.writeBytes(numberToBytes(fullBulkStringRedisMessage.content().readableBytes()));
        short s5 = RedisConstants.EOL_SHORT;
        ioBuffer2.writeShort(s5);
        list.add(ioBuffer2);
        list.add(fullBulkStringRedisMessage.content().retain());
        list.add(byteBufAllocator.ioBuffer(2).writeShort(s5));
    }

    private static void writeString(ByteBufAllocator byteBufAllocator, RedisMessageType redisMessageType, String str, List<Object> list) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(redisMessageType.length() + ByteBufUtil.utf8MaxBytes(str) + 2);
        redisMessageType.writeTo(ioBuffer);
        ByteBufUtil.writeUtf8(ioBuffer, str);
        ioBuffer.writeShort(RedisConstants.EOL_SHORT);
        list.add(ioBuffer);
    }
}
