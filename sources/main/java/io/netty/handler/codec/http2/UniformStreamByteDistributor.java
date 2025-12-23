package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UniformStreamByteDistributor implements StreamByteDistributor {
    private final Http2Connection.PropertyKey stateKey;
    private long totalStreamableBytes;
    private final Deque<State> queue = new ArrayDeque(4);
    private int minAllocationChunk = 1024;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean enqueued;
        final Http2Stream stream;
        int streamableBytes;
        boolean windowNegative;
        boolean writing;

        /* JADX WARN: Multi-variable type inference failed */
        void write(int i6, StreamByteDistributor.Writer writer) throws Http2Exception {
            this.writing = true;
            try {
                writer.write(this.stream, i6);
            } finally {
            }
        }

        State(Http2Stream http2Stream) {
            this.stream = http2Stream;
        }

        void addToQueue() {
            if (this.enqueued) {
                return;
            }
            this.enqueued = true;
            UniformStreamByteDistributor.this.queue.addLast(this);
        }

        void removeFromQueue() {
            if (this.enqueued) {
                this.enqueued = false;
                UniformStreamByteDistributor.this.queue.remove(this);
            }
        }

        void updateStreamableBytes(int i6, boolean z5, int i7) {
            int i8 = i6 - this.streamableBytes;
            if (i8 != 0) {
                this.streamableBytes = i6;
                UniformStreamByteDistributor.this.totalStreamableBytes += i8;
            }
            this.windowNegative = i7 < 0;
            if (z5) {
                if (i7 > 0 || (i7 == 0 && !this.writing)) {
                    addToQueue();
                }
            }
        }

        void close() {
            removeFromQueue();
            updateStreamableBytes(0, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) ((Http2Stream) ObjectUtil.checkNotNull(http2Stream, "stream")).getProperty(this.stateKey);
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public boolean distribute(int i6, StreamByteDistributor.Writer writer) throws Http2Exception {
        int size = this.queue.size();
        if (size == 0) {
            return this.totalStreamableBytes > 0;
        }
        int max = Math.max(this.minAllocationChunk, i6 / size);
        State pollFirst = this.queue.pollFirst();
        while (true) {
            pollFirst.enqueued = false;
            if (!pollFirst.windowNegative) {
                if (i6 == 0 && pollFirst.streamableBytes > 0) {
                    this.queue.addFirst(pollFirst);
                    pollFirst.enqueued = true;
                    break;
                }
                int min = Math.min(max, Math.min(i6, pollFirst.streamableBytes));
                i6 -= min;
                pollFirst.write(min, writer);
            }
            pollFirst = this.queue.pollFirst();
            if (pollFirst == null) {
                break;
            }
        }
        return this.totalStreamableBytes > 0;
    }

    public void minAllocationChunk(int i6) {
        ObjectUtil.checkPositive(i6, "minAllocationChunk");
        this.minAllocationChunk = i6;
    }

    public UniformStreamByteDistributor(Http2Connection http2Connection) {
        Http2Connection.PropertyKey newKey = http2Connection.newKey();
        this.stateKey = newKey;
        Http2Stream connectionStream = http2Connection.connectionStream();
        connectionStream.setProperty(newKey, new State(connectionStream));
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.UniformStreamByteDistributor.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(UniformStreamByteDistributor.this.stateKey, UniformStreamByteDistributor.this.new State(http2Stream));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                UniformStreamByteDistributor.this.state(http2Stream).close();
            }
        });
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame(), streamState.windowSize());
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateDependencyTree(int i6, int i7, short s5, boolean z5) {
    }
}
