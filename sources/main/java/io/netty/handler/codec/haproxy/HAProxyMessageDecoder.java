package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ProtocolDetectionResult;
import io.netty.util.CharsetUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HAProxyMessageDecoder extends ByteToMessageDecoder {
    private static final byte[] BINARY_PREFIX;
    private static final int BINARY_PREFIX_LENGTH;
    private static final int V1_MAX_LENGTH = 108;
    private static final int V2_MAX_LENGTH = 65551;
    private static final int V2_MAX_TLV = 65319;
    private static final int V2_MIN_LENGTH = 232;
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private boolean finished;
    private HeaderExtractor headerExtractor;
    private final int v2MaxHeaderSize;
    private int version;
    private static final byte[] TEXT_PREFIX = {80, 82, 79, 88, 89};
    private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V1 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V1);
    private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V2 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class HeaderExtractor {
        private final int maxHeaderSize;

        protected abstract int delimiterLength(ByteBuf byteBuf, int i6);

        protected abstract int findEndOfHeader(ByteBuf byteBuf);

        protected HeaderExtractor(int i6) {
            this.maxHeaderSize = i6;
        }

        public ByteBuf extract(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
            int findEndOfHeader = findEndOfHeader(byteBuf);
            if (!HAProxyMessageDecoder.this.discarding) {
                if (findEndOfHeader >= 0) {
                    int readerIndex = findEndOfHeader - byteBuf.readerIndex();
                    if (readerIndex > this.maxHeaderSize) {
                        byteBuf.readerIndex(findEndOfHeader + delimiterLength(byteBuf, findEndOfHeader));
                        HAProxyMessageDecoder.this.failOverLimit(channelHandlerContext, readerIndex);
                        return null;
                    }
                    ByteBuf readSlice = byteBuf.readSlice(readerIndex);
                    byteBuf.skipBytes(delimiterLength(byteBuf, findEndOfHeader));
                    return readSlice;
                }
                int readableBytes = byteBuf.readableBytes();
                if (readableBytes > this.maxHeaderSize) {
                    HAProxyMessageDecoder.this.discardedBytes = readableBytes;
                    byteBuf.skipBytes(readableBytes);
                    HAProxyMessageDecoder.this.discarding = true;
                    if (HAProxyMessageDecoder.this.failFast) {
                        HAProxyMessageDecoder.this.failOverLimit(channelHandlerContext, "over " + HAProxyMessageDecoder.this.discardedBytes);
                    }
                }
                return null;
            }
            if (findEndOfHeader >= 0) {
                int readerIndex2 = (HAProxyMessageDecoder.this.discardedBytes + findEndOfHeader) - byteBuf.readerIndex();
                byteBuf.readerIndex(findEndOfHeader + delimiterLength(byteBuf, findEndOfHeader));
                HAProxyMessageDecoder.this.discardedBytes = 0;
                HAProxyMessageDecoder.this.discarding = false;
                if (!HAProxyMessageDecoder.this.failFast) {
                    HAProxyMessageDecoder.this.failOverLimit(channelHandlerContext, "over " + readerIndex2);
                }
            } else {
                HAProxyMessageDecoder.this.discardedBytes += byteBuf.readableBytes();
                byteBuf.skipBytes(byteBuf.readableBytes());
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class LineHeaderExtractor extends HeaderExtractor {
        LineHeaderExtractor(int i6) {
            super(i6);
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int delimiterLength(ByteBuf byteBuf, int i6) {
            if (byteBuf.getByte(i6) == 13) {
                return 2;
            }
            return 1;
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int findEndOfHeader(ByteBuf byteBuf) {
            return HAProxyMessageDecoder.findEndOfLine(byteBuf);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class StructHeaderExtractor extends HeaderExtractor {
        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int delimiterLength(ByteBuf byteBuf, int i6) {
            return 0;
        }

        StructHeaderExtractor(int i6) {
            super(i6);
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int findEndOfHeader(ByteBuf byteBuf) {
            return HAProxyMessageDecoder.findEndOfHeader(byteBuf);
        }
    }

    public HAProxyMessageDecoder() {
        this(true);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str, Exception exc) {
        this.finished = true;
        channelHandlerContext.close();
        if (str != null && exc != null) {
            throw new HAProxyProtocolException(str, exc);
        }
        if (str != null) {
            throw new HAProxyProtocolException(str);
        }
        if (exc == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failOverLimit(ChannelHandlerContext channelHandlerContext, int i6) {
        failOverLimit(channelHandlerContext, String.valueOf(i6));
    }

    private static boolean match(byte[] bArr, ByteBuf byteBuf, int i6) {
        for (int i7 = 0; i7 < bArr.length; i7++) {
            if (byteBuf.getByte(i6 + i7) != bArr[i7]) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public boolean isSingleDecode() {
        return true;
    }

    static {
        byte[] bArr = {13, 10, 13, 10, 0, 13, 10, 81, 85, 73, 84, 10};
        BINARY_PREFIX = bArr;
        BINARY_PREFIX_LENGTH = bArr.length;
    }

    public HAProxyMessageDecoder(boolean z5) {
        this.version = -1;
        this.v2MaxHeaderSize = V2_MAX_LENGTH;
        this.failFast = z5;
    }

    private ByteBuf decodeLine(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.headerExtractor == null) {
            this.headerExtractor = new LineHeaderExtractor(108);
        }
        return this.headerExtractor.extract(channelHandlerContext, byteBuf);
    }

    private ByteBuf decodeStruct(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.headerExtractor == null) {
            this.headerExtractor = new StructHeaderExtractor(this.v2MaxHeaderSize);
        }
        return this.headerExtractor.extract(channelHandlerContext, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failOverLimit(ChannelHandlerContext channelHandlerContext, String str) {
        fail(channelHandlerContext, "header length (" + str + ") exceeds the allowed maximum (" + (this.version == 1 ? 108 : this.v2MaxHeaderSize) + ')', null);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.version == -1) {
            int findVersion = findVersion(byteBuf);
            this.version = findVersion;
            if (findVersion == -1) {
                return;
            }
        }
        ByteBuf decodeLine = this.version == 1 ? decodeLine(channelHandlerContext, byteBuf) : decodeStruct(channelHandlerContext, byteBuf);
        if (decodeLine != null) {
            this.finished = true;
            try {
                if (this.version == 1) {
                    list.add(HAProxyMessage.decodeHeader(decodeLine.toString(CharsetUtil.US_ASCII)));
                } else {
                    list.add(HAProxyMessage.decodeHeader(decodeLine));
                }
            } catch (HAProxyProtocolException e6) {
                fail(channelHandlerContext, null, e6);
            }
        }
    }

    public static ProtocolDetectionResult<HAProxyProtocolVersion> detectProtocol(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 12) {
            return ProtocolDetectionResult.needsMoreData();
        }
        int readerIndex = byteBuf.readerIndex();
        if (match(BINARY_PREFIX, byteBuf, readerIndex)) {
            return DETECTION_RESULT_V2;
        }
        if (match(TEXT_PREFIX, byteBuf, readerIndex)) {
            return DETECTION_RESULT_V1;
        }
        return ProtocolDetectionResult.invalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int findEndOfHeader(ByteBuf byteBuf) {
        int unsignedShort;
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes < 16 || readableBytes < (unsignedShort = byteBuf.getUnsignedShort(byteBuf.readerIndex() + 14) + 16)) {
            return -1;
        }
        return unsignedShort;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int findEndOfLine(ByteBuf byteBuf) {
        int writerIndex = byteBuf.writerIndex();
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < writerIndex; readerIndex++) {
            if (byteBuf.getByte(readerIndex) == 13 && readerIndex < writerIndex - 1 && byteBuf.getByte(readerIndex + 1) == 10) {
                return readerIndex;
            }
        }
        return -1;
    }

    private static int findVersion(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 13) {
            return -1;
        }
        int readerIndex = byteBuf.readerIndex();
        if (match(BINARY_PREFIX, byteBuf, readerIndex)) {
            return byteBuf.getByte(readerIndex + BINARY_PREFIX_LENGTH);
        }
        return 1;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        super.channelRead(channelHandlerContext, obj);
        if (this.finished) {
            channelHandlerContext.pipeline().remove(this);
        }
    }

    public HAProxyMessageDecoder(int i6) {
        this(i6, true);
    }

    public HAProxyMessageDecoder(int i6, boolean z5) {
        this.version = -1;
        if (i6 < 1) {
            this.v2MaxHeaderSize = V2_MIN_LENGTH;
        } else if (i6 > V2_MAX_TLV) {
            this.v2MaxHeaderSize = V2_MAX_LENGTH;
        } else {
            int i7 = i6 + V2_MIN_LENGTH;
            if (i7 > V2_MAX_LENGTH) {
                this.v2MaxHeaderSize = V2_MAX_LENGTH;
            } else {
                this.v2MaxHeaderSize = i7;
            }
        }
        this.failFast = z5;
    }
}
