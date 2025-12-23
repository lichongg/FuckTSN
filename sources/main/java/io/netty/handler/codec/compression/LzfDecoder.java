package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.handler.codec.ByteToMessageDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LzfDecoder extends ByteToMessageDecoder {
    private static final short MAGIC_NUMBER = 23126;
    private int chunkLength;
    private State currentState;
    private ChunkDecoder decoder;
    private boolean isCompressed;
    private int originalLength;
    private BufferRecycler recycler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder() {
        this(false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.LzfDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.INIT_ORIGINAL_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LzfDecoder(boolean z5) {
        this.currentState = State.INIT_BLOCK;
        this.decoder = z5 ? ChunkDecoderFactory.safeInstance() : ChunkDecoderFactory.optimalInstance();
        this.recycler = BufferRecycler.instance();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0091 A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:2:0x0000, B:8:0x0017, B:11:0x0023, B:12:0x0028, B:13:0x0088, B:15:0x0091, B:17:0x0097, B:19:0x00a1, B:20:0x00b8, B:24:0x00e3, B:26:0x00e9, B:27:0x00fe, B:31:0x00f0, B:32:0x00f4, B:33:0x00ad, B:35:0x00f7, B:37:0x0077, B:41:0x007e, B:42:0x0029, B:46:0x0031, B:48:0x0039, B:51:0x0041, B:52:0x006e, B:56:0x0048, B:57:0x0067, B:58:0x0068, B:59:0x0103, B:60:0x010a, B:23:0x00ce), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r12, io.netty.buffer.ByteBuf r13, java.util.List<java.lang.Object> r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.LzfDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
