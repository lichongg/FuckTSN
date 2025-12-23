package io.netty.handler.codec.compression;

import com.google.common.base.Ascii;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JdkZlibEncoder extends ZlibEncoder {
    private static final byte[] gzipHeader = {Ascii.US, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private final CRC32 crc;
    private volatile ChannelHandlerContext ctx;
    private final Deflater deflater;
    private volatile boolean finished;
    private final ZlibWrapper wrapper;
    private boolean writeHeader;

    public JdkZlibEncoder() {
        this(6);
    }

    @Override // io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.compression.JdkZlibEncoder$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public JdkZlibEncoder(int i6) {
        this(ZlibWrapper.ZLIB, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer();
        if (this.writeHeader && this.wrapper == ZlibWrapper.GZIP) {
            this.writeHeader = false;
            heapBuffer.writeBytes(gzipHeader);
        }
        this.deflater.finish();
        while (!this.deflater.finished()) {
            deflate(heapBuffer);
            if (!heapBuffer.isWritable()) {
                channelHandlerContext.write(heapBuffer);
                heapBuffer = channelHandlerContext.alloc().heapBuffer();
            }
        }
        if (this.wrapper == ZlibWrapper.GZIP) {
            int value = (int) this.crc.getValue();
            int totalIn = this.deflater.getTotalIn();
            heapBuffer.writeByte(value);
            heapBuffer.writeByte(value >>> 8);
            heapBuffer.writeByte(value >>> 16);
            heapBuffer.writeByte(value >>> 24);
            heapBuffer.writeByte(totalIn);
            heapBuffer.writeByte(totalIn >>> 8);
            heapBuffer.writeByte(totalIn >>> 16);
            heapBuffer.writeByte(totalIn >>> 24);
        }
        this.deflater.end();
        return channelHandlerContext.writeAndFlush(heapBuffer, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public final ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z5) throws Exception {
        int ceil = (int) Math.ceil(byteBuf.readableBytes() * 1.001d);
        int i6 = ceil + 12;
        if (this.writeHeader) {
            int i7 = AnonymousClass4.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[this.wrapper.ordinal()];
            if (i7 == 1) {
                i6 += gzipHeader.length;
            } else if (i7 == 2) {
                i6 = ceil + 14;
            }
        }
        return channelHandlerContext.alloc().heapBuffer(i6);
    }

    @Override // io.netty.handler.codec.compression.ZlibEncoder
    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext ctx = ctx();
        EventExecutor executor = ctx.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx, channelPromise);
        }
        final ChannelPromise newPromise = ctx.newPromise();
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                JdkZlibEncoder jdkZlibEncoder = JdkZlibEncoder.this;
                jdkZlibEncoder.finishEncode(jdkZlibEncoder.ctx(), newPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(channelPromise));
            }
        });
        return newPromise;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        byte[] bArr;
        int i6;
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return;
        }
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i6 = byteBuf.arrayOffset() + byteBuf.readerIndex();
            byteBuf.skipBytes(readableBytes);
        } else {
            bArr = new byte[readableBytes];
            byteBuf.readBytes(bArr);
            i6 = 0;
        }
        if (this.writeHeader) {
            this.writeHeader = false;
            if (this.wrapper == ZlibWrapper.GZIP) {
                byteBuf2.writeBytes(gzipHeader);
            }
        }
        if (this.wrapper == ZlibWrapper.GZIP) {
            this.crc.update(bArr, i6, readableBytes);
        }
        this.deflater.setInput(bArr, i6, readableBytes);
        while (true) {
            deflate(byteBuf2);
            if (this.deflater.needsInput()) {
                return;
            }
            if (!byteBuf2.isWritable()) {
                byteBuf2.ensureWritable(byteBuf2.writerIndex());
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.handler.codec.compression.ZlibEncoder
    public boolean isClosed() {
        return this.finished;
    }

    public JdkZlibEncoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 6);
    }

    private void deflate(ByteBuf byteBuf) {
        int deflate;
        do {
            int writerIndex = byteBuf.writerIndex();
            deflate = this.deflater.deflate(byteBuf.array(), byteBuf.arrayOffset() + writerIndex, byteBuf.writableBytes(), 2);
            byteBuf.writerIndex(writerIndex + deflate);
        } while (deflate > 0);
    }

    public JdkZlibEncoder(ZlibWrapper zlibWrapper, int i6) {
        this.crc = new CRC32();
        this.writeHeader = true;
        if (i6 < 0 || i6 > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
        }
        if (zlibWrapper != null) {
            ZlibWrapper zlibWrapper2 = ZlibWrapper.ZLIB_OR_NONE;
            if (zlibWrapper != zlibWrapper2) {
                this.wrapper = zlibWrapper;
                this.deflater = new Deflater(i6, zlibWrapper != ZlibWrapper.ZLIB);
                return;
            } else {
                throw new IllegalArgumentException("wrapper '" + zlibWrapper2 + "' is not allowed for compression.");
            }
        }
        throw new NullPointerException("wrapper");
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
        ChannelFuture finishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        finishEncode.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (finishEncode.isDone()) {
            return;
        }
        channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.JdkZlibEncoder.3
            @Override // java.lang.Runnable
            public void run() {
                channelHandlerContext.close(channelPromise);
            }
        }, 10L, TimeUnit.SECONDS);
    }

    public JdkZlibEncoder(byte[] bArr) {
        this(6, bArr);
    }

    public JdkZlibEncoder(int i6, byte[] bArr) {
        this.crc = new CRC32();
        this.writeHeader = true;
        if (i6 < 0 || i6 > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
        }
        if (bArr != null) {
            this.wrapper = ZlibWrapper.ZLIB;
            Deflater deflater = new Deflater(i6);
            this.deflater = deflater;
            deflater.setDictionary(bArr);
            return;
        }
        throw new NullPointerException("dictionary");
    }
}
