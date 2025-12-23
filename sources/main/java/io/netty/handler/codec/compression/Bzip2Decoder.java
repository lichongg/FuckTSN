package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Bzip2Decoder extends ByteToMessageDecoder {
    private int blockCRC;
    private Bzip2BlockDecompressor blockDecompressor;
    private int blockSize;
    private Bzip2HuffmanStageDecoder huffmanStageDecoder;
    private int streamCRC;
    private State currentState = State.INIT;
    private final Bzip2BitReader reader = new Bzip2BitReader();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        INIT,
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        RECEIVE_HUFFMAN_USED_MAP,
        RECEIVE_HUFFMAN_USED_BITMAPS,
        RECEIVE_SELECTORS_NUMBER,
        RECEIVE_SELECTORS,
        RECEIVE_HUFFMAN_LENGTH,
        DECODE_HUFFMAN_DATA,
        EOF
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.Bzip2Decoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_USED_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_USED_BITMAPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_SELECTORS_NUMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_SELECTORS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_LENGTH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.DECODE_HUFFMAN_DATA.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.EOF.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01b5, code lost:
    
        r4[r9][r10] = (byte) r6;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x024d, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("incorrect selectors number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x025d, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("incorrect huffman groups number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0265, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("bad block header");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x026d, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("block size is invalid");
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0190  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r17, io.netty.buffer.ByteBuf r18, java.util.List<java.lang.Object> r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2Decoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public boolean isClosed() {
        return this.currentState == State.EOF;
    }
}
