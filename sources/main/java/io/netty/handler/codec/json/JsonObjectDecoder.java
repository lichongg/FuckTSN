package io.netty.handler.codec.json;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JsonObjectDecoder extends ByteToMessageDecoder {
    private static final int ST_CORRUPTED = -1;
    private static final int ST_DECODING_ARRAY_STREAM = 2;
    private static final int ST_DECODING_NORMAL = 1;
    private static final int ST_INIT = 0;
    private int idx;
    private boolean insideString;
    private int lastReaderIndex;
    private final int maxObjectLength;
    private int openBraces;
    private int state;
    private final boolean streamArrayElements;

    public JsonObjectDecoder() {
        this(1048576);
    }

    private void initDecoding(byte b6) {
        this.openBraces = 1;
        if (b6 == 91 && this.streamArrayElements) {
            this.state = 2;
        } else {
            this.state = 1;
        }
    }

    private void reset() {
        this.insideString = false;
        this.state = 0;
        this.openBraces = 0;
    }

    public JsonObjectDecoder(int i6) {
        this(i6, false);
    }

    private void decodeByte(byte b6, ByteBuf byteBuf, int i6) {
        if ((b6 == 123 || b6 == 91) && !this.insideString) {
            this.openBraces++;
            return;
        }
        if ((b6 == 125 || b6 == 93) && !this.insideString) {
            this.openBraces--;
            return;
        }
        if (b6 == 34) {
            if (!this.insideString) {
                this.insideString = true;
                return;
            }
            int i7 = 0;
            for (int i8 = i6 - 1; i8 >= 0 && byteBuf.getByte(i8) == 92; i8--) {
                i7++;
            }
            if (i7 % 2 == 0) {
                this.insideString = false;
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6;
        if (this.state == -1) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        if (this.idx > byteBuf.readerIndex() && this.lastReaderIndex != byteBuf.readerIndex()) {
            this.idx = byteBuf.readerIndex() + (this.idx - this.lastReaderIndex);
        }
        int i7 = this.idx;
        int writerIndex = byteBuf.writerIndex();
        if (writerIndex > this.maxObjectLength) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            reset();
            throw new TooLongFrameException("object length exceeds " + this.maxObjectLength + ": " + writerIndex + " bytes discarded");
        }
        while (i7 < writerIndex) {
            byte b6 = byteBuf.getByte(i7);
            int i8 = this.state;
            if (i8 == 1) {
                decodeByte(b6, byteBuf, i7);
                if (this.openBraces == 0) {
                    int i9 = i7 + 1;
                    ByteBuf extractObject = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i9 - byteBuf.readerIndex());
                    if (extractObject != null) {
                        list.add(extractObject);
                    }
                    byteBuf.readerIndex(i9);
                    reset();
                }
            } else if (i8 == 2) {
                decodeByte(b6, byteBuf, i7);
                if (!this.insideString && (((i6 = this.openBraces) == 1 && b6 == 44) || (i6 == 0 && b6 == 93))) {
                    for (int readerIndex = byteBuf.readerIndex(); Character.isWhitespace(byteBuf.getByte(readerIndex)); readerIndex++) {
                        byteBuf.skipBytes(1);
                    }
                    int i10 = i7 - 1;
                    while (i10 >= byteBuf.readerIndex() && Character.isWhitespace(byteBuf.getByte(i10))) {
                        i10--;
                    }
                    ByteBuf extractObject2 = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), (i10 + 1) - byteBuf.readerIndex());
                    if (extractObject2 != null) {
                        list.add(extractObject2);
                    }
                    byteBuf.readerIndex(i7 + 1);
                    if (b6 == 93) {
                        reset();
                    }
                }
            } else if (b6 == 123 || b6 == 91) {
                initDecoding(b6);
                if (this.state == 2) {
                    byteBuf.skipBytes(1);
                }
            } else {
                if (!Character.isWhitespace(b6)) {
                    this.state = -1;
                    throw new CorruptedFrameException("invalid JSON received at byte position " + i7 + ": " + ByteBufUtil.hexDump(byteBuf));
                }
                byteBuf.skipBytes(1);
            }
            i7++;
        }
        if (byteBuf.readableBytes() == 0) {
            this.idx = 0;
        } else {
            this.idx = i7;
        }
        this.lastReaderIndex = byteBuf.readerIndex();
    }

    public JsonObjectDecoder(boolean z5) {
        this(1048576, z5);
    }

    protected ByteBuf extractObject(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i6, int i7) {
        return byteBuf.retainedSlice(i6, i7);
    }

    public JsonObjectDecoder(int i6, boolean z5) {
        if (i6 >= 1) {
            this.maxObjectLength = i6;
            this.streamArrayElements = z5;
            return;
        }
        throw new IllegalArgumentException("maxObjectLength must be a positive int");
    }
}
