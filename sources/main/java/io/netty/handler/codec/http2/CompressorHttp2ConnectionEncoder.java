package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.util.AsciiString;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CompressorHttp2ConnectionEncoder extends DecoratingHttp2ConnectionEncoder {
    public static final int DEFAULT_COMPRESSION_LEVEL = 6;
    public static final int DEFAULT_MEM_LEVEL = 8;
    public static final int DEFAULT_WINDOW_BITS = 15;
    private final int compressionLevel;
    private final int memLevel;
    private final Http2Connection.PropertyKey propertyKey;
    private final int windowBits;

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, 6, 15, 8);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise) {
        try {
            EmbeddedChannel newCompressor = newCompressor(channelHandlerContext, http2Headers, z5);
            ChannelFuture writeHeaders = super.writeHeaders(channelHandlerContext, i6, http2Headers, i7, z5, channelPromise);
            try {
                bindCompressorToStream(newCompressor, i6);
                return writeHeaders;
            } catch (Throwable th) {
                th = th;
                channelPromise.tryFailure(th);
                return channelPromise;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public CompressorHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i6, int i7, int i8) {
        super(http2ConnectionEncoder);
        if (i6 < 0 || i6 > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
        }
        if (i7 < 9 || i7 > 15) {
            throw new IllegalArgumentException("windowBits: " + i7 + " (expected: 9-15)");
        }
        if (i8 < 1 || i8 > 9) {
            throw new IllegalArgumentException("memLevel: " + i8 + " (expected: 1-9)");
        }
        this.compressionLevel = i6;
        this.windowBits = i7;
        this.memLevel = i8;
        this.propertyKey = connection().newKey();
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamRemoved(Http2Stream http2Stream) {
                EmbeddedChannel embeddedChannel = (EmbeddedChannel) http2Stream.getProperty(CompressorHttp2ConnectionEncoder.this.propertyKey);
                if (embeddedChannel != null) {
                    CompressorHttp2ConnectionEncoder.this.cleanup(http2Stream, embeddedChannel);
                }
            }
        });
    }

    private void bindCompressorToStream(EmbeddedChannel embeddedChannel, int i6) {
        Http2Stream stream;
        if (embeddedChannel == null || (stream = connection().stream(i6)) == null) {
            return;
        }
        stream.setProperty(this.propertyKey, embeddedChannel);
    }

    private EmbeddedChannel newCompressionChannel(ChannelHandlerContext channelHandlerContext, ZlibWrapper zlibWrapper) {
        return new EmbeddedChannel(channelHandlerContext.channel().id(), channelHandlerContext.channel().metadata().hasDisconnect(), channelHandlerContext.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapper, this.compressionLevel, this.windowBits, this.memLevel));
    }

    private EmbeddedChannel newCompressor(ChannelHandlerContext channelHandlerContext, Http2Headers http2Headers, boolean z5) throws Http2Exception {
        if (z5) {
            return null;
        }
        AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
        CharSequence charSequence = http2Headers.get(asciiString);
        if (charSequence == null) {
            charSequence = HttpHeaderValues.IDENTITY;
        }
        EmbeddedChannel newContentCompressor = newContentCompressor(channelHandlerContext, charSequence);
        if (newContentCompressor != null) {
            CharSequence targetContentEncoding = getTargetContentEncoding(charSequence);
            if (HttpHeaderValues.IDENTITY.contentEqualsIgnoreCase(targetContentEncoding)) {
                http2Headers.remove(asciiString);
            } else {
                http2Headers.set((Http2Headers) asciiString, (AsciiString) targetContentEncoding);
            }
            http2Headers.remove(HttpHeaderNames.CONTENT_LENGTH);
        }
        return newContentCompressor;
    }

    protected EmbeddedChannel newContentCompressor(ChannelHandlerContext channelHandlerContext, CharSequence charSequence) throws Http2Exception {
        if (HttpHeaderValues.GZIP.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.GZIP);
        }
        if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(charSequence) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(charSequence)) {
            return newCompressionChannel(channelHandlerContext, ZlibWrapper.ZLIB);
        }
        return null;
    }

    private static ByteBuf nextReadableBuf(EmbeddedChannel embeddedChannel) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) embeddedChannel.readOutbound();
            if (byteBuf == null) {
                return null;
            }
            if (!byteBuf.isReadable()) {
                byteBuf.release();
            } else {
                return byteBuf;
            }
        }
    }

    void cleanup(Http2Stream http2Stream, EmbeddedChannel embeddedChannel) {
        if (embeddedChannel.finish()) {
            while (true) {
                ByteBuf byteBuf = (ByteBuf) embeddedChannel.readOutbound();
                if (byteBuf == null) {
                    break;
                } else {
                    byteBuf.release();
                }
            }
        }
        http2Stream.removeProperty(this.propertyKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture writeData(io.netty.channel.ChannelHandlerContext r15, int r16, io.netty.buffer.ByteBuf r17, int r18, boolean r19, io.netty.channel.ChannelPromise r20) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.CompressorHttp2ConnectionEncoder.writeData(io.netty.channel.ChannelHandlerContext, int, io.netty.buffer.ByteBuf, int, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise) {
        try {
            EmbeddedChannel newCompressor = newCompressor(channelHandlerContext, http2Headers, z6);
            ChannelFuture writeHeaders = super.writeHeaders(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6, channelPromise);
            try {
                bindCompressorToStream(newCompressor, i6);
                return writeHeaders;
            } catch (Throwable th) {
                th = th;
                channelPromise.tryFailure(th);
                return channelPromise;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected CharSequence getTargetContentEncoding(CharSequence charSequence) throws Http2Exception {
        return charSequence;
    }
}
