package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private final Checksum checksum;
    private int chunkLength;
    private int currentChecksum;
    private State currentState;
    private boolean hasChecksum;
    private boolean isCompressed;
    private int originalLength;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder() {
        this(false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FastLzFrameDecoder(boolean z5) {
        this(z5 ? new Adler32() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0091 A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:2:0x0000, B:8:0x0017, B:11:0x0023, B:12:0x0028, B:13:0x0088, B:15:0x0091, B:17:0x0099, B:48:0x0146, B:49:0x0149, B:51:0x00b1, B:54:0x0054, B:57:0x005f, B:60:0x0066, B:65:0x006c, B:66:0x0072, B:68:0x007e, B:69:0x0082, B:73:0x0029, B:77:0x0030, B:79:0x0039, B:82:0x0044, B:85:0x004e, B:88:0x014a, B:89:0x0151, B:20:0x00b6, B:22:0x00ba, B:24:0x00c0, B:26:0x00d7, B:29:0x00fb, B:32:0x0103, B:35:0x0113, B:36:0x012e, B:38:0x0131, B:39:0x013c, B:41:0x00de, B:42:0x00f7, B:43:0x00d0, B:44:0x00f8), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r12, io.netty.buffer.ByteBuf r13, java.util.List<java.lang.Object> r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public FastLzFrameDecoder(Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.checksum = checksum;
    }
}
