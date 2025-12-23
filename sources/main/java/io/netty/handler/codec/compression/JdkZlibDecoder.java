package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JdkZlibDecoder extends ZlibDecoder {
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final ByteBufChecksum crc;
    private boolean decideZlibOrNone;
    private final boolean decompressConcatenated;
    private final byte[] dictionary;
    private volatile boolean finished;
    private int flags;
    private GzipState gzipState;
    private Inflater inflater;
    private int xlen;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum GzipState {
        HEADER_START,
        HEADER_END,
        FLG_READ,
        XLEN_READ,
        SKIP_FNAME,
        SKIP_COMMENT,
        PROCESS_FHCRC,
        FOOTER_START
    }

    public JdkZlibDecoder() {
        this(ZlibWrapper.ZLIB, null, false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.JdkZlibDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[GzipState.values().length];
            $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState = iArr;
            try {
                iArr[GzipState.FOOTER_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.FLG_READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.XLEN_READ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_FNAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_COMMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.PROCESS_FHCRC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr2;
            try {
                iArr2[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public JdkZlibDecoder(byte[] bArr) {
        this(ZlibWrapper.ZLIB, bArr, false);
    }

    private static boolean looksLikeZlib(short s5) {
        return (s5 & 30720) == 30720 && s5 % 31 == 0;
    }

    private boolean readGZIPHeader(ByteBuf byteBuf) {
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[this.gzipState.ordinal()]) {
            case 2:
                if (byteBuf.readableBytes() < 10) {
                    return false;
                }
                byte readByte = byteBuf.readByte();
                byte readByte2 = byteBuf.readByte();
                if (readByte != 31) {
                    throw new DecompressionException("Input is not in the GZIP format");
                }
                this.crc.update(readByte);
                this.crc.update(readByte2);
                short readUnsignedByte = byteBuf.readUnsignedByte();
                if (readUnsignedByte != 8) {
                    throw new DecompressionException("Unsupported compression method " + ((int) readUnsignedByte) + " in the GZIP header");
                }
                this.crc.update(readUnsignedByte);
                short readUnsignedByte2 = byteBuf.readUnsignedByte();
                this.flags = readUnsignedByte2;
                this.crc.update(readUnsignedByte2);
                if ((this.flags & FRESERVED) != 0) {
                    throw new DecompressionException("Reserved flags are set in the GZIP header");
                }
                this.crc.update(byteBuf, byteBuf.readerIndex(), 4);
                byteBuf.skipBytes(4);
                this.crc.update(byteBuf.readUnsignedByte());
                this.crc.update(byteBuf.readUnsignedByte());
                this.gzipState = GzipState.FLG_READ;
            case 3:
                if ((this.flags & 4) != 0) {
                    if (byteBuf.readableBytes() < 2) {
                        return false;
                    }
                    short readUnsignedByte3 = byteBuf.readUnsignedByte();
                    short readUnsignedByte4 = byteBuf.readUnsignedByte();
                    this.crc.update(readUnsignedByte3);
                    this.crc.update(readUnsignedByte4);
                    this.xlen = (readUnsignedByte3 << 8) | readUnsignedByte4 | this.xlen;
                }
                this.gzipState = GzipState.XLEN_READ;
            case 4:
                if (this.xlen != -1) {
                    if (byteBuf.readableBytes() < this.xlen) {
                        return false;
                    }
                    this.crc.update(byteBuf, byteBuf.readerIndex(), this.xlen);
                    byteBuf.skipBytes(this.xlen);
                }
                this.gzipState = GzipState.SKIP_FNAME;
            case 5:
                if ((this.flags & 8) != 0) {
                    if (!byteBuf.isReadable()) {
                        return false;
                    }
                    do {
                        short readUnsignedByte5 = byteBuf.readUnsignedByte();
                        this.crc.update(readUnsignedByte5);
                        if (readUnsignedByte5 == 0) {
                        }
                    } while (byteBuf.isReadable());
                }
                this.gzipState = GzipState.SKIP_COMMENT;
            case 6:
                if ((this.flags & 16) != 0) {
                    if (!byteBuf.isReadable()) {
                        return false;
                    }
                    do {
                        short readUnsignedByte6 = byteBuf.readUnsignedByte();
                        this.crc.update(readUnsignedByte6);
                        if (readUnsignedByte6 == 0) {
                        }
                    } while (byteBuf.isReadable());
                }
                this.gzipState = GzipState.PROCESS_FHCRC;
            case 7:
                if ((this.flags & 2) != 0) {
                    if (byteBuf.readableBytes() < 4) {
                        return false;
                    }
                    verifyCrc(byteBuf);
                }
                this.crc.reset();
                this.gzipState = GzipState.HEADER_END;
                return true;
            case 8:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void verifyCrc(ByteBuf byteBuf) {
        long j6 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            j6 |= byteBuf.readUnsignedByte() << (i6 * 8);
        }
        long value = this.crc.getValue();
        if (j6 == value) {
            return;
        }
        throw new DecompressionException("CRC value mismatch. Expected: " + j6 + ", Got: " + value);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return;
        }
        boolean z5 = false;
        if (this.decideZlibOrNone) {
            if (readableBytes < 2) {
                return;
            }
            this.inflater = new Inflater(!looksLikeZlib(byteBuf.getShort(byteBuf.readerIndex())));
            this.decideZlibOrNone = false;
        }
        if (this.crc != null) {
            if (AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[this.gzipState.ordinal()] == 1) {
                if (readGZIPFooter(byteBuf)) {
                    this.finished = true;
                    return;
                }
                return;
            } else if (this.gzipState != GzipState.HEADER_END && !readGZIPHeader(byteBuf)) {
                return;
            } else {
                readableBytes = byteBuf.readableBytes();
            }
        }
        if (byteBuf.hasArray()) {
            this.inflater.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), readableBytes);
        } else {
            byte[] bArr = new byte[readableBytes];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            this.inflater.setInput(bArr);
        }
        ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(this.inflater.getRemaining() << 1);
        while (true) {
            try {
                try {
                    if (this.inflater.needsInput()) {
                        break;
                    }
                    byte[] array = heapBuffer.array();
                    int writerIndex = heapBuffer.writerIndex();
                    int arrayOffset = heapBuffer.arrayOffset() + writerIndex;
                    int inflate = this.inflater.inflate(array, arrayOffset, heapBuffer.writableBytes());
                    if (inflate > 0) {
                        heapBuffer.writerIndex(writerIndex + inflate);
                        ByteBufChecksum byteBufChecksum = this.crc;
                        if (byteBufChecksum != null) {
                            byteBufChecksum.update(array, arrayOffset, inflate);
                        }
                    } else if (this.inflater.needsDictionary()) {
                        byte[] bArr2 = this.dictionary;
                        if (bArr2 == null) {
                            throw new DecompressionException("decompression failure, unable to set dictionary as non was specified");
                        }
                        this.inflater.setDictionary(bArr2);
                    }
                    if (!this.inflater.finished()) {
                        heapBuffer.ensureWritable(this.inflater.getRemaining() << 1);
                    } else if (this.crc == null) {
                        this.finished = true;
                    } else {
                        z5 = true;
                    }
                } catch (DataFormatException e6) {
                    throw new DecompressionException("decompression failure", e6);
                }
            } catch (Throwable th) {
                if (heapBuffer.isReadable()) {
                    list.add(heapBuffer);
                } else {
                    heapBuffer.release();
                }
                throw th;
            }
        }
        byteBuf.skipBytes(readableBytes - this.inflater.getRemaining());
        if (z5) {
            this.gzipState = GzipState.FOOTER_START;
            if (readGZIPFooter(byteBuf)) {
                this.finished = !this.decompressConcatenated;
                if (!this.finished) {
                    this.inflater.reset();
                    this.crc.reset();
                    this.gzipState = GzipState.HEADER_START;
                }
            }
        }
        if (heapBuffer.isReadable()) {
            list.add(heapBuffer);
        } else {
            heapBuffer.release();
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, null, false);
    }

    private boolean readGZIPFooter(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 8) {
            return false;
        }
        verifyCrc(byteBuf);
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 |= byteBuf.readUnsignedByte() << (i7 * 8);
        }
        int totalOut = this.inflater.getTotalOut();
        if (i6 == totalOut) {
            return true;
        }
        throw new DecompressionException("Number of bytes mismatch. Expected: " + i6 + ", Got: " + totalOut);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved0(channelHandlerContext);
        Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
        }
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, boolean z5) {
        this(zlibWrapper, null, z5);
    }

    public JdkZlibDecoder(boolean z5) {
        this(ZlibWrapper.GZIP, null, z5);
    }

    private JdkZlibDecoder(ZlibWrapper zlibWrapper, byte[] bArr, boolean z5) {
        this.gzipState = GzipState.HEADER_START;
        this.flags = -1;
        this.xlen = -1;
        if (zlibWrapper != null) {
            this.decompressConcatenated = z5;
            int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
            if (i6 == 1) {
                this.inflater = new Inflater(true);
                this.crc = ByteBufChecksum.wrapChecksum(new CRC32());
            } else if (i6 == 2) {
                this.inflater = new Inflater(true);
                this.crc = null;
            } else if (i6 == 3) {
                this.inflater = new Inflater();
                this.crc = null;
            } else if (i6 == 4) {
                this.decideZlibOrNone = true;
                this.crc = null;
            } else {
                throw new IllegalArgumentException("Only GZIP or ZLIB is supported, but you used " + zlibWrapper);
            }
            this.dictionary = bArr;
            return;
        }
        throw new NullPointerException("wrapper");
    }
}
