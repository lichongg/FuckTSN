package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelPromise;
import io.netty.util.internal.PlatformDependent;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SpdySession {
    private final AtomicInteger receiveWindowSize;
    private final AtomicInteger sendWindowSize;
    private final AtomicInteger activeLocalStreams = new AtomicInteger();
    private final AtomicInteger activeRemoteStreams = new AtomicInteger();
    private final Map<Integer, StreamState> activeStreams = PlatformDependent.newConcurrentHashMap();
    private final StreamComparator streamComparator = new StreamComparator();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class PendingWrite {
        final ChannelPromise promise;
        final SpdyDataFrame spdyDataFrame;

        void fail(Throwable th) {
            this.spdyDataFrame.release();
            this.promise.setFailure(th);
        }

        PendingWrite(SpdyDataFrame spdyDataFrame, ChannelPromise channelPromise) {
            this.spdyDataFrame = spdyDataFrame;
            this.promise = channelPromise;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class StreamComparator implements Comparator<Integer> {
        StreamComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            int priority = ((StreamState) SpdySession.this.activeStreams.get(num)).getPriority() - ((StreamState) SpdySession.this.activeStreams.get(num2)).getPriority();
            return priority != 0 ? priority : num.intValue() - num2.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class StreamState {
        private boolean localSideClosed;
        private final Queue<PendingWrite> pendingWriteQueue = new ConcurrentLinkedQueue();
        private final byte priority;
        private final AtomicInteger receiveWindowSize;
        private int receiveWindowSizeLowerBound;
        private boolean receivedReply;
        private boolean remoteSideClosed;
        private final AtomicInteger sendWindowSize;

        void closeLocalSide() {
            this.localSideClosed = true;
        }

        void closeRemoteSide() {
            this.remoteSideClosed = true;
        }

        void receivedReply() {
            this.receivedReply = true;
        }

        void clearPendingWrites(Throwable th) {
            while (true) {
                PendingWrite poll = this.pendingWriteQueue.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.fail(th);
                }
            }
        }

        PendingWrite getPendingWrite() {
            return this.pendingWriteQueue.peek();
        }

        byte getPriority() {
            return this.priority;
        }

        int getReceiveWindowSizeLowerBound() {
            return this.receiveWindowSizeLowerBound;
        }

        int getSendWindowSize() {
            return this.sendWindowSize.get();
        }

        boolean hasReceivedReply() {
            return this.receivedReply;
        }

        boolean isLocalSideClosed() {
            return this.localSideClosed;
        }

        boolean isRemoteSideClosed() {
            return this.remoteSideClosed;
        }

        boolean putPendingWrite(PendingWrite pendingWrite) {
            return this.pendingWriteQueue.offer(pendingWrite);
        }

        PendingWrite removePendingWrite() {
            return this.pendingWriteQueue.poll();
        }

        void setReceiveWindowSizeLowerBound(int i6) {
            this.receiveWindowSizeLowerBound = i6;
        }

        int updateReceiveWindowSize(int i6) {
            return this.receiveWindowSize.addAndGet(i6);
        }

        int updateSendWindowSize(int i6) {
            return this.sendWindowSize.addAndGet(i6);
        }

        StreamState(byte b6, boolean z5, boolean z6, int i6, int i7) {
            this.priority = b6;
            this.remoteSideClosed = z5;
            this.localSideClosed = z6;
            this.sendWindowSize = new AtomicInteger(i6);
            this.receiveWindowSize = new AtomicInteger(i7);
        }
    }

    PendingWrite getPendingWrite(int i6) {
        PendingWrite pendingWrite;
        if (i6 != 0) {
            StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
            if (streamState != null) {
                return streamState.getPendingWrite();
            }
            return null;
        }
        Iterator<Map.Entry<Integer, StreamState>> it = activeStreams().entrySet().iterator();
        while (it.hasNext()) {
            StreamState value = it.next().getValue();
            if (value.getSendWindowSize() > 0 && (pendingWrite = value.getPendingWrite()) != null) {
                return pendingWrite;
            }
        }
        return null;
    }

    int getReceiveWindowSizeLowerBound(int i6) {
        StreamState streamState;
        if (i6 == 0 || (streamState = this.activeStreams.get(Integer.valueOf(i6))) == null) {
            return 0;
        }
        return streamState.getReceiveWindowSizeLowerBound();
    }

    private StreamState removeActiveStream(int i6, boolean z5) {
        StreamState remove = this.activeStreams.remove(Integer.valueOf(i6));
        if (remove != null) {
            if (z5) {
                this.activeRemoteStreams.decrementAndGet();
                return remove;
            }
            this.activeLocalStreams.decrementAndGet();
        }
        return remove;
    }

    void acceptStream(int i6, byte b6, boolean z5, boolean z6, int i7, int i8, boolean z7) {
        if (!(z5 && z6) && this.activeStreams.put(Integer.valueOf(i6), new StreamState(b6, z5, z6, i7, i8)) == null) {
            if (z7) {
                this.activeRemoteStreams.incrementAndGet();
            } else {
                this.activeLocalStreams.incrementAndGet();
            }
        }
    }

    Map<Integer, StreamState> activeStreams() {
        TreeMap treeMap = new TreeMap(this.streamComparator);
        treeMap.putAll(this.activeStreams);
        return treeMap;
    }

    void closeLocalSide(int i6, boolean z5) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState != null) {
            streamState.closeLocalSide();
            if (streamState.isRemoteSideClosed()) {
                removeActiveStream(i6, z5);
            }
        }
    }

    void closeRemoteSide(int i6, boolean z5) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState != null) {
            streamState.closeRemoteSide();
            if (streamState.isLocalSideClosed()) {
                removeActiveStream(i6, z5);
            }
        }
    }

    int getSendWindowSize(int i6) {
        if (i6 == 0) {
            return this.sendWindowSize.get();
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState != null) {
            return streamState.getSendWindowSize();
        }
        return -1;
    }

    boolean hasReceivedReply(int i6) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        return streamState != null && streamState.hasReceivedReply();
    }

    boolean isActiveStream(int i6) {
        return this.activeStreams.containsKey(Integer.valueOf(i6));
    }

    boolean isLocalSideClosed(int i6) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        return streamState == null || streamState.isLocalSideClosed();
    }

    boolean isRemoteSideClosed(int i6) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        return streamState == null || streamState.isRemoteSideClosed();
    }

    boolean noActiveStreams() {
        return this.activeStreams.isEmpty();
    }

    int numActiveStreams(boolean z5) {
        return z5 ? this.activeRemoteStreams.get() : this.activeLocalStreams.get();
    }

    boolean putPendingWrite(int i6, PendingWrite pendingWrite) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        return streamState != null && streamState.putPendingWrite(pendingWrite);
    }

    void receivedReply(int i6) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState != null) {
            streamState.receivedReply();
        }
    }

    PendingWrite removePendingWrite(int i6) {
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState != null) {
            return streamState.removePendingWrite();
        }
        return null;
    }

    void updateAllReceiveWindowSizes(int i6) {
        for (StreamState streamState : this.activeStreams.values()) {
            streamState.updateReceiveWindowSize(i6);
            if (i6 < 0) {
                streamState.setReceiveWindowSizeLowerBound(i6);
            }
        }
    }

    void updateAllSendWindowSizes(int i6) {
        Iterator<StreamState> it = this.activeStreams.values().iterator();
        while (it.hasNext()) {
            it.next().updateSendWindowSize(i6);
        }
    }

    int updateReceiveWindowSize(int i6, int i7) {
        if (i6 == 0) {
            return this.receiveWindowSize.addAndGet(i7);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState == null) {
            return -1;
        }
        if (i7 > 0) {
            streamState.setReceiveWindowSizeLowerBound(0);
        }
        return streamState.updateReceiveWindowSize(i7);
    }

    int updateSendWindowSize(int i6, int i7) {
        if (i6 == 0) {
            return this.sendWindowSize.addAndGet(i7);
        }
        StreamState streamState = this.activeStreams.get(Integer.valueOf(i6));
        if (streamState != null) {
            return streamState.updateSendWindowSize(i7);
        }
        return -1;
    }

    SpdySession(int i6, int i7) {
        this.sendWindowSize = new AtomicInteger(i6);
        this.receiveWindowSize = new AtomicInteger(i7);
    }

    void removeStream(int i6, Throwable th, boolean z5) {
        StreamState removeActiveStream = removeActiveStream(i6, z5);
        if (removeActiveStream != null) {
            removeActiveStream.clearPendingWrites(th);
        }
    }
}
