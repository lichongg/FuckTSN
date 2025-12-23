package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class StreamBufferingEncoder extends DecoratingHttp2ConnectionEncoder {
    private boolean closed;
    private int maxConcurrentStreams;
    private final TreeMap<Integer, PendingStream> pendingStreams;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class DataFrame extends Frame {
        final ByteBuf data;
        final boolean endOfStream;
        final int padding;

        DataFrame(ByteBuf byteBuf, int i6, boolean z5, ChannelPromise channelPromise) {
            super(channelPromise);
            this.data = byteBuf;
            this.padding = i6;
            this.endOfStream = z5;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void send(ChannelHandlerContext channelHandlerContext, int i6) {
            StreamBufferingEncoder.this.writeData(channelHandlerContext, i6, this.data, this.padding, this.endOfStream, this.promise);
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void release(Throwable th) {
            super.release(th);
            ReferenceCountUtil.safeRelease(this.data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class Frame {
        final ChannelPromise promise;

        abstract void send(ChannelHandlerContext channelHandlerContext, int i6);

        void release(Throwable th) {
            if (th == null) {
                this.promise.setSuccess();
            } else {
                this.promise.setFailure(th);
            }
        }

        Frame(ChannelPromise channelPromise) {
            this.promise = channelPromise;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HeadersFrame extends Frame {
        final boolean endOfStream;
        final boolean exclusive;
        final Http2Headers headers;
        final int padding;
        final int streamDependency;
        final short weight;

        HeadersFrame(Http2Headers http2Headers, int i6, short s5, boolean z5, int i7, boolean z6, ChannelPromise channelPromise) {
            super(channelPromise);
            this.headers = http2Headers;
            this.streamDependency = i6;
            this.weight = s5;
            this.exclusive = z5;
            this.padding = i7;
            this.endOfStream = z6;
        }

        @Override // io.netty.handler.codec.http2.StreamBufferingEncoder.Frame
        void send(ChannelHandlerContext channelHandlerContext, int i6) {
            StreamBufferingEncoder.this.writeHeaders(channelHandlerContext, i6, this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Http2ChannelClosedException extends Http2Exception {
        private static final long serialVersionUID = 4768543442094476971L;

        public Http2ChannelClosedException() {
            super(Http2Error.REFUSED_STREAM, "Connection closed");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Http2GoAwayException extends Http2Exception {
        private static final long serialVersionUID = 1326785622777291198L;
        private final byte[] debugData;
        private final long errorCode;
        private final int lastStreamId;

        public Http2GoAwayException(int i6, long j6, byte[] bArr) {
            super(Http2Error.STREAM_CLOSED);
            this.lastStreamId = i6;
            this.errorCode = j6;
            this.debugData = bArr;
        }

        public byte[] debugData() {
            return this.debugData;
        }

        public long errorCode() {
            return this.errorCode;
        }

        public int lastStreamId() {
            return this.lastStreamId;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PendingStream {
        final ChannelHandlerContext ctx;
        final Queue<Frame> frames = new ArrayDeque(2);
        final int streamId;

        void close(Throwable th) {
            Iterator<Frame> it = this.frames.iterator();
            while (it.hasNext()) {
                it.next().release(th);
            }
        }

        void sendFrames() {
            Iterator<Frame> it = this.frames.iterator();
            while (it.hasNext()) {
                it.next().send(this.ctx, this.streamId);
            }
        }

        PendingStream(ChannelHandlerContext channelHandlerContext, int i6) {
            this.ctx = channelHandlerContext;
            this.streamId = i6;
        }
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        this(http2ConnectionEncoder, 100);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5, ChannelPromise channelPromise) {
        return writeHeaders(channelHandlerContext, i6, http2Headers, 0, (short) 16, false, i7, z5, channelPromise);
    }

    public StreamBufferingEncoder(Http2ConnectionEncoder http2ConnectionEncoder, int i6) {
        super(http2ConnectionEncoder);
        this.pendingStreams = new TreeMap<>();
        this.maxConcurrentStreams = i6;
        connection().addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.StreamBufferingEncoder.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onGoAwayReceived(int i7, long j6, ByteBuf byteBuf) {
                StreamBufferingEncoder.this.cancelGoAwayStreams(i7, j6, byteBuf);
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                StreamBufferingEncoder.this.tryCreatePendingStreams();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelGoAwayStreams(int i6, long j6, ByteBuf byteBuf) {
        Iterator<PendingStream> it = this.pendingStreams.values().iterator();
        Http2GoAwayException http2GoAwayException = new Http2GoAwayException(i6, j6, ByteBufUtil.getBytes(byteBuf));
        while (it.hasNext()) {
            PendingStream next = it.next();
            if (next.streamId > i6) {
                it.remove();
                next.close(http2GoAwayException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryCreatePendingStreams() {
        while (!this.pendingStreams.isEmpty() && canCreateStream()) {
            PendingStream value = this.pendingStreams.pollFirstEntry().getValue();
            try {
                value.sendFrames();
            } catch (Throwable th) {
                value.close(th);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (!this.closed) {
                this.closed = true;
                Http2ChannelClosedException http2ChannelClosedException = new Http2ChannelClosedException();
                while (!this.pendingStreams.isEmpty()) {
                    this.pendingStreams.pollFirstEntry().getValue().close(http2ChannelClosedException);
                }
            }
        } finally {
            super.close();
        }
    }

    public int numBufferedStreams() {
        return this.pendingStreams.size();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6, ChannelPromise channelPromise) {
        if (this.closed) {
            return channelPromise.setFailure((Throwable) new Http2ChannelClosedException());
        }
        if (isExistingStream(i6) || connection().goAwayReceived()) {
            return super.writeHeaders(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6, channelPromise);
        }
        if (canCreateStream()) {
            return super.writeHeaders(channelHandlerContext, i6, http2Headers, i7, s5, z5, i8, z6, channelPromise);
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i6));
        if (pendingStream == null) {
            pendingStream = new PendingStream(channelHandlerContext, i6);
            this.pendingStreams.put(Integer.valueOf(i6), pendingStream);
        }
        pendingStream.frames.add(new HeadersFrame(http2Headers, i7, s5, z5, i8, z6, channelPromise));
        return channelPromise;
    }

    private boolean canCreateStream() {
        if (connection().local().numActiveStreams() < this.maxConcurrentStreams) {
            return true;
        }
        return false;
    }

    private boolean isExistingStream(int i6) {
        if (i6 <= connection().local().lastStreamCreated()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder, io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        super.remoteSettings(http2Settings);
        this.maxConcurrentStreams = connection().local().maxActiveStreams();
        tryCreatePendingStreams();
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
    public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5, ChannelPromise channelPromise) {
        if (isExistingStream(i6)) {
            return super.writeData(channelHandlerContext, i6, byteBuf, i7, z5, channelPromise);
        }
        PendingStream pendingStream = this.pendingStreams.get(Integer.valueOf(i6));
        if (pendingStream != null) {
            pendingStream.frames.add(new DataFrame(byteBuf, i7, z5, channelPromise));
            return channelPromise;
        }
        ReferenceCountUtil.safeRelease(byteBuf);
        channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i6)));
        return channelPromise;
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i6, long j6, ChannelPromise channelPromise) {
        if (isExistingStream(i6)) {
            return super.writeRstStream(channelHandlerContext, i6, j6, channelPromise);
        }
        PendingStream remove = this.pendingStreams.remove(Integer.valueOf(i6));
        if (remove != null) {
            remove.close(null);
            channelPromise.setSuccess();
            return channelPromise;
        }
        channelPromise.setFailure((Throwable) Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", Integer.valueOf(i6)));
        return channelPromise;
    }
}
