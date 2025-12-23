package io.netty.handler.codec.protobuf;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class ProtobufDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final boolean HAS_PARSER;
    private final ExtensionRegistryLite extensionRegistry;
    private final MessageLite prototype;

    public ProtobufDecoder(MessageLite messageLite) {
        this(messageLite, (ExtensionRegistry) null);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    static {
        boolean z5;
        try {
            MessageLite.class.getDeclaredMethod("getParserForType", null);
            z5 = true;
        } catch (Throwable unused) {
            z5 = false;
        }
        HAS_PARSER = z5;
    }

    public ProtobufDecoder(MessageLite messageLite, ExtensionRegistry extensionRegistry) {
        this(messageLite, (ExtensionRegistryLite) extensionRegistry);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6;
        byte[] bytes;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bytes = byteBuf.array();
            i6 = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            i6 = 0;
            bytes = ByteBufUtil.getBytes(byteBuf, byteBuf.readerIndex(), readableBytes, false);
        }
        if (this.extensionRegistry == null) {
            if (HAS_PARSER) {
                list.add(this.prototype.getParserForType().parseFrom(bytes, i6, readableBytes));
                return;
            } else {
                list.add(this.prototype.newBuilderForType().mergeFrom(bytes, i6, readableBytes).build());
                return;
            }
        }
        if (HAS_PARSER) {
            list.add(this.prototype.getParserForType().parseFrom(bytes, i6, readableBytes, this.extensionRegistry));
        } else {
            list.add(this.prototype.newBuilderForType().mergeFrom(bytes, i6, readableBytes, this.extensionRegistry).build());
        }
    }

    public ProtobufDecoder(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite) {
        if (messageLite != null) {
            this.prototype = messageLite.getDefaultInstanceForType();
            this.extensionRegistry = extensionRegistryLite;
            return;
        }
        throw new NullPointerException("prototype");
    }
}
