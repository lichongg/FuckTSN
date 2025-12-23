package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Lz4FrameDecoder extends ByteToMessageDecoder {
    private int blockType;
    private ByteBufChecksum checksum;
    private int compressedLength;
    private int currentChecksum;
    private State currentState;
    private int decompressedLength;
    private LZ4FastDecompressor decompressor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        INIT_BLOCK,
        DECOMPRESS_DATA,
        FINISHED,
        CORRUPTED
    }

    public Lz4FrameDecoder() {
        this(false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Lz4FrameDecoder(boolean z5) {
        this(LZ4Factory.fastestInstance(), z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0146 A[Catch: Exception -> 0x0021, TRY_ENTER, TryCatch #6 {Exception -> 0x0021, blocks: (B:2:0x0000, B:9:0x001b, B:10:0x0020, B:12:0x0024, B:14:0x00bb, B:16:0x00ca, B:38:0x0146, B:39:0x0149, B:56:0x002c, B:60:0x0036, B:62:0x0043, B:65:0x005b, B:70:0x0076, B:71:0x008f, B:77:0x0090, B:81:0x009e, B:83:0x00a7, B:84:0x00ae, B:85:0x00af, B:86:0x014a, B:87:0x0163, B:88:0x0164, B:89:0x017d, B:90:0x017e, B:91:0x0185), top: B:1:0x0000 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r13, io.netty.buffer.ByteBuf r14, java.util.List<java.lang.Object> r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Lz4FrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public boolean isClosed() {
        return this.currentState == State.FINISHED;
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, boolean z5) {
        this(lZ4Factory, z5 ? new Lz4XXHash32(-1756908916) : null);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        if (lZ4Factory != null) {
            this.decompressor = lZ4Factory.fastDecompressor();
            this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
            return;
        }
        throw new NullPointerException("factory");
    }
}
