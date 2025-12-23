package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;

    /* renamed from: z, reason: collision with root package name */
    private final Inflater f43066z;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        Inflater inflater = new Inflater();
        this.f43066z = inflater;
        if (zlibWrapper == null) {
            throw new NullPointerException("wrapper");
        }
        int init = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
        if (init != 0) {
            ZlibUtil.fail(inflater, "initialization failure", init);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c5, code lost:
    
        r7.finished = true;
        r7.f43066z.inflateEnd();
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JZlibDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JZlibDecoder(byte[] bArr) {
        Inflater inflater = new Inflater();
        this.f43066z = inflater;
        if (bArr != null) {
            this.dictionary = bArr;
            int inflateInit = inflater.inflateInit(JZlib.W_ZLIB);
            if (inflateInit != 0) {
                ZlibUtil.fail(inflater, "initialization failure", inflateInit);
                return;
            }
            return;
        }
        throw new NullPointerException("dictionary");
    }
}
