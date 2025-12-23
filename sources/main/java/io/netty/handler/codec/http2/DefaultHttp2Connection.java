package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.UnaryPromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2Connection implements Http2Connection {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2Connection.class);
    final ActiveStreams activeStreams;
    Promise<Void> closePromise;
    final ConnectionStream connectionStream;
    final List<Http2Connection.Listener> listeners;
    final DefaultEndpoint<Http2LocalFlowController> localEndpoint;
    final PropertyKeyRegistry propertyKeyRegistry;
    final DefaultEndpoint<Http2RemoteFlowController> remoteEndpoint;
    final IntObjectMap<Http2Stream> streamMap;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ActiveStreams {
        private final List<Http2Connection.Listener> listeners;
        private int pendingIterations;
        private final Queue<Event> pendingEvents = new ArrayDeque(4);
        private final Set<Http2Stream> streams = new LinkedHashSet();

        ActiveStreams(List<Http2Connection.Listener> list) {
            this.listeners = list;
        }

        void addToActiveStreams(DefaultStream defaultStream) {
            if (this.streams.add(defaultStream)) {
                defaultStream.createdBy().numActiveStreams++;
                for (int i6 = 0; i6 < this.listeners.size(); i6++) {
                    try {
                        this.listeners.get(i6).onStreamActive(defaultStream);
                    } catch (Throwable th) {
                        DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamActive.", th);
                    }
                }
            }
        }

        boolean allowModifications() {
            return this.pendingIterations == 0;
        }

        void decrementPendingIterations() {
            this.pendingIterations--;
            if (!allowModifications()) {
                return;
            }
            while (true) {
                Event poll = this.pendingEvents.poll();
                if (poll == null) {
                    return;
                }
                try {
                    poll.process();
                } catch (Throwable th) {
                    DefaultHttp2Connection.logger.error("Caught Throwable while processing pending ActiveStreams$Event.", th);
                }
            }
        }

        void incrementPendingIterations() {
            this.pendingIterations++;
        }

        void removeFromActiveStreams(DefaultStream defaultStream, Iterator<?> it) {
            if (this.streams.remove(defaultStream)) {
                DefaultEndpoint<? extends Http2FlowController> createdBy = defaultStream.createdBy();
                createdBy.numActiveStreams--;
                DefaultHttp2Connection.this.notifyClosed(defaultStream);
            }
            DefaultHttp2Connection.this.removeStream(defaultStream, it);
        }

        public int size() {
            return this.streams.size();
        }

        public void activate(final DefaultStream defaultStream) {
            if (allowModifications()) {
                addToActiveStreams(defaultStream);
            } else {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.1
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.addToActiveStreams(defaultStream);
                    }
                });
            }
        }

        public void deactivate(final DefaultStream defaultStream, final Iterator<?> it) {
            if (!allowModifications() && it == null) {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.2
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.removeFromActiveStreams(defaultStream, it);
                    }
                });
            } else {
                removeFromActiveStreams(defaultStream, it);
            }
        }

        public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
            incrementPendingIterations();
            try {
                for (Http2Stream http2Stream : this.streams) {
                    if (!http2StreamVisitor.visit(http2Stream)) {
                        return http2Stream;
                    }
                }
                decrementPendingIterations();
                return null;
            } finally {
                decrementPendingIterations();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ConnectionStream extends DefaultStream {
        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream
        DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return null;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return false;
        }

        ConnectionStream() {
            super(0, Http2Stream.State.IDLE);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersSent(boolean z5) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isPushPromiseSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z5) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream pushPromiseSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class DefaultEndpoint<F extends Http2FlowController> implements Http2Connection.Endpoint<F> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private F flowController;
        private int lastStreamKnownByPeer = -1;
        private int maxActiveStreams;
        private final int maxReservedStreams;
        private int maxStreams;
        private int nextReservationStreamId;
        private int nextStreamIdToCreate;
        int numActiveStreams;
        int numStreams;
        private boolean pushToAllowed;
        private final boolean server;

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void allowPushTo(boolean z5) {
            if (z5 && this.server) {
                throw new IllegalArgumentException("Servers do not allow push");
            }
            this.pushToAllowed = z5;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public F flowController() {
            return this.flowController;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isValidStreamId(int i6) {
            if (i6 > 0) {
                if (this.server == ((i6 & 1) == 0)) {
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamKnownByPeer() {
            return this.lastStreamKnownByPeer;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int maxActiveStreams() {
            return this.maxActiveStreams;
        }

        DefaultEndpoint(boolean z5, int i6) {
            this.pushToAllowed = true;
            this.server = z5;
            if (z5) {
                this.nextStreamIdToCreate = 2;
                this.nextReservationStreamId = 0;
            } else {
                this.nextStreamIdToCreate = 1;
                this.nextReservationStreamId = 1;
            }
            this.pushToAllowed = true ^ z5;
            this.maxActiveStreams = Integer.MAX_VALUE;
            this.maxReservedStreams = ObjectUtil.checkPositiveOrZero(i6, "maxReservedStreams");
            updateMaxStreams();
        }

        private void addStream(DefaultStream defaultStream) {
            DefaultHttp2Connection.this.streamMap.put(defaultStream.id(), (int) defaultStream);
            for (int i6 = 0; i6 < DefaultHttp2Connection.this.listeners.size(); i6++) {
                try {
                    DefaultHttp2Connection.this.listeners.get(i6).onStreamAdded(defaultStream);
                } catch (Throwable th) {
                    DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamAdded.", th);
                }
            }
        }

        private void checkNewStreamAllowed(int i6, Http2Stream.State state) throws Http2Exception {
            int i7 = this.lastStreamKnownByPeer;
            if (i7 >= 0 && i6 > i7) {
                throw Http2Exception.streamError(i6, Http2Error.REFUSED_STREAM, "Cannot create stream %d greater than Last-Stream-ID %d from GOAWAY.", Integer.valueOf(i6), Integer.valueOf(this.lastStreamKnownByPeer));
            }
            if (!isValidStreamId(i6)) {
                if (i6 < 0) {
                    throw new Http2NoMoreStreamIdsException();
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Request stream %d is not correct for %s connection", Integer.valueOf(i6), this.server ? "server" : "client");
            }
            int i8 = this.nextStreamIdToCreate;
            if (i6 < i8) {
                throw Http2Exception.closedStreamError(Http2Error.PROTOCOL_ERROR, "Request stream %d is behind the next expected stream %d", Integer.valueOf(i6), Integer.valueOf(this.nextStreamIdToCreate));
            }
            if (i8 <= 0) {
                throw Http2Exception.connectionError(Http2Error.REFUSED_STREAM, "Stream IDs are exhausted for this endpoint.", new Object[0]);
            }
            boolean z5 = state == Http2Stream.State.RESERVED_LOCAL || state == Http2Stream.State.RESERVED_REMOTE;
            if ((!z5 && !canOpenStream()) || (z5 && this.numStreams >= this.maxStreams)) {
                throw Http2Exception.streamError(i6, Http2Error.REFUSED_STREAM, "Maximum active streams violated for this endpoint.", new Object[0]);
            }
            if (DefaultHttp2Connection.this.isClosed()) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Attempted to create stream id %d after connection was closed", Integer.valueOf(i6));
            }
        }

        private void incrementExpectedStreamId(int i6) {
            int i7 = this.nextReservationStreamId;
            if (i6 > i7 && i7 >= 0) {
                this.nextReservationStreamId = i6;
            }
            this.nextStreamIdToCreate = i6 + 2;
            this.numStreams++;
        }

        private boolean isLocal() {
            return this == DefaultHttp2Connection.this.localEndpoint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lastStreamKnownByPeer(int i6) {
            this.lastStreamKnownByPeer = i6;
        }

        private void updateMaxStreams() {
            this.maxStreams = (int) Math.min(2147483647L, this.maxActiveStreams + this.maxReservedStreams);
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean canOpenStream() {
            return this.numActiveStreams < this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream createStream(int i6, boolean z5) throws Http2Exception {
            Http2Stream.State activeState = DefaultHttp2Connection.activeState(i6, Http2Stream.State.IDLE, isLocal(), z5);
            checkNewStreamAllowed(i6, activeState);
            DefaultStream defaultStream = DefaultHttp2Connection.this.new DefaultStream(i6, activeState);
            incrementExpectedStreamId(i6);
            addStream(defaultStream);
            defaultStream.activate();
            return defaultStream;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean created(Http2Stream http2Stream) {
            return (http2Stream instanceof DefaultStream) && ((DefaultStream) http2Stream).createdBy() == this;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void flowController(F f6) {
            this.flowController = (F) ObjectUtil.checkNotNull(f6, "flowController");
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int incrementAndGetNextStreamId() {
            int i6 = this.nextReservationStreamId;
            if (i6 < 0) {
                return i6;
            }
            int i7 = i6 + 2;
            this.nextReservationStreamId = i7;
            return i7;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isServer() {
            return this.server;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamCreated() {
            int i6 = this.nextStreamIdToCreate;
            if (i6 > 1) {
                return i6 - 2;
            }
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void maxActiveStreams(int i6) {
            this.maxActiveStreams = i6;
            updateMaxStreams();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int numActiveStreams() {
            return this.numActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream reservePushStream(int i6, Http2Stream http2Stream) throws Http2Exception {
            if (http2Stream == null) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Parent stream missing", new Object[0]);
            }
            if (!isLocal() ? http2Stream.state().remoteSideOpen() : http2Stream.state().localSideOpen()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d is not open for sending push promise", Integer.valueOf(http2Stream.id()));
            }
            if (!opposite().allowPushTo()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server push not allowed to opposite endpoint", new Object[0]);
            }
            Http2Stream.State state = isLocal() ? Http2Stream.State.RESERVED_LOCAL : Http2Stream.State.RESERVED_REMOTE;
            checkNewStreamAllowed(i6, state);
            DefaultStream defaultStream = DefaultHttp2Connection.this.new DefaultStream(i6, state);
            incrementExpectedStreamId(i6);
            addStream(defaultStream);
            return defaultStream;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean mayHaveCreatedStream(int i6) {
            if (isValidStreamId(i6) && i6 <= lastStreamCreated()) {
                return true;
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public Http2Connection.Endpoint<? extends Http2FlowController> opposite() {
            if (isLocal()) {
                return DefaultHttp2Connection.this.remoteEndpoint;
            }
            return DefaultHttp2Connection.this.localEndpoint;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean allowPushTo() {
            return this.pushToAllowed;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class DefaultPropertyKey implements Http2Connection.PropertyKey {
        final int index;

        DefaultPropertyKey(int i6) {
            this.index = i6;
        }

        DefaultPropertyKey verifyConnection(Http2Connection http2Connection) {
            if (http2Connection == DefaultHttp2Connection.this) {
                return this;
            }
            throw new IllegalArgumentException("Using a key that was not created by this connection");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class DefaultStream implements Http2Stream {
        private static final byte META_STATE_RECV_HEADERS = 16;
        private static final byte META_STATE_RECV_TRAILERS = 32;
        private static final byte META_STATE_SENT_HEADERS = 2;
        private static final byte META_STATE_SENT_PUSHPROMISE = 8;
        private static final byte META_STATE_SENT_RST = 1;
        private static final byte META_STATE_SENT_TRAILERS = 4;
        private final int id;
        private byte metaState;
        private final PropertyMap properties = new PropertyMap();
        private Http2Stream.State state;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class PropertyMap {
            Object[] values;

            private PropertyMap() {
                this.values = EmptyArrays.EMPTY_OBJECTS;
            }

            <V> V add(DefaultPropertyKey defaultPropertyKey, V v5) {
                resizeIfNecessary(defaultPropertyKey.index);
                Object[] objArr = this.values;
                int i6 = defaultPropertyKey.index;
                V v6 = (V) objArr[i6];
                objArr[i6] = v5;
                return v6;
            }

            <V> V get(DefaultPropertyKey defaultPropertyKey) {
                int i6 = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i6 >= objArr.length) {
                    return null;
                }
                return (V) objArr[i6];
            }

            <V> V remove(DefaultPropertyKey defaultPropertyKey) {
                int i6 = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i6 >= objArr.length) {
                    return null;
                }
                V v5 = (V) objArr[i6];
                objArr[i6] = null;
                return v5;
            }

            void resizeIfNecessary(int i6) {
                Object[] objArr = this.values;
                if (i6 >= objArr.length) {
                    this.values = Arrays.copyOf(objArr, DefaultHttp2Connection.this.propertyKeyRegistry.size());
                }
            }
        }

        Http2Stream close(Iterator<?> it) {
            Http2Stream.State state = this.state;
            Http2Stream.State state2 = Http2Stream.State.CLOSED;
            if (state == state2) {
                return this;
            }
            this.state = state2;
            DefaultEndpoint<? extends Http2FlowController> createdBy = createdBy();
            createdBy.numStreams--;
            DefaultHttp2Connection.this.activeStreams.deactivate(this, it);
            return this;
        }

        DefaultStream(int i6, Http2Stream.State state) {
            this.id = i6;
            this.state = state;
        }

        void activate() {
            Http2Stream.State state = this.state;
            if (state == Http2Stream.State.HALF_CLOSED_LOCAL) {
                headersSent(false);
            } else if (state == Http2Stream.State.HALF_CLOSED_REMOTE) {
                headersReceived(false);
            }
            DefaultHttp2Connection.this.activeStreams.activate(this);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            int i6 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i6 != 4) {
                if (i6 != 5) {
                    close();
                }
                return this;
            }
            this.state = Http2Stream.State.HALF_CLOSED_LOCAL;
            DefaultHttp2Connection.this.notifyHalfClosed(this);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            int i6 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i6 != 4) {
                if (i6 != 6) {
                    close();
                }
                return this;
            }
            this.state = Http2Stream.State.HALF_CLOSED_REMOTE;
            DefaultHttp2Connection.this.notifyHalfClosed(this);
            return this;
        }

        DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.id) ? DefaultHttp2Connection.this.localEndpoint : DefaultHttp2Connection.this.remoteEndpoint;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V getProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.get(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersReceived(boolean z5) {
            if (!z5) {
                this.metaState = (byte) (this.metaState | (isHeadersReceived() ? (byte) 32 : (byte) 16));
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersSent(boolean z5) {
            if (!z5) {
                this.metaState = (byte) (this.metaState | (isHeadersSent() ? (byte) 4 : (byte) 2));
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final int id() {
            return this.id;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersReceived() {
            return (this.metaState & 16) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersSent() {
            return (this.metaState & 2) != 0;
        }

        final boolean isLocal() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.id);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isPushPromiseSent() {
            return (this.metaState & 8) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return (this.metaState & 1) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isTrailersReceived() {
            return (this.metaState & 32) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isTrailersSent() {
            return (this.metaState & 4) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z5) throws Http2Exception {
            this.state = DefaultHttp2Connection.activeState(this.id, this.state, isLocal(), z5);
            if (!createdBy().canOpenStream()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Maximum active streams violated for this endpoint.", new Object[0]);
            }
            activate();
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream pushPromiseSent() {
            this.metaState = (byte) (this.metaState | 8);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V removeProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.remove(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            this.metaState = (byte) (this.metaState | 1);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v5) {
            return (V) this.properties.add(DefaultHttp2Connection.this.verifyKey(propertyKey), v5);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final Http2Stream.State state() {
            return this.state;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            return close(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Event {
        void process();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PropertyKeyRegistry {
        final List<DefaultPropertyKey> keys;

        private PropertyKeyRegistry() {
            this.keys = new ArrayList(4);
        }

        DefaultPropertyKey newKey() {
            DefaultPropertyKey defaultPropertyKey = DefaultHttp2Connection.this.new DefaultPropertyKey(this.keys.size());
            this.keys.add(defaultPropertyKey);
            return defaultPropertyKey;
        }

        int size() {
            return this.keys.size();
        }
    }

    public DefaultHttp2Connection(boolean z5) {
        this(z5, 100);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwayReceived() {
        return ((DefaultEndpoint) this.localEndpoint).lastStreamKnownByPeer >= 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwaySent() {
        return ((DefaultEndpoint) this.remoteEndpoint).lastStreamKnownByPeer >= 0;
    }

    void notifyClosed(Http2Stream http2Stream) {
        for (int i6 = 0; i6 < this.listeners.size(); i6++) {
            try {
                this.listeners.get(i6).onStreamClosed(http2Stream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamClosed.", th);
            }
        }
    }

    void notifyHalfClosed(Http2Stream http2Stream) {
        for (int i6 = 0; i6 < this.listeners.size(); i6++) {
            try {
                this.listeners.get(i6).onStreamHalfClosed(http2Stream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2Connection$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public DefaultHttp2Connection(boolean z5, int i6) {
        IntObjectHashMap intObjectHashMap = new IntObjectHashMap();
        this.streamMap = intObjectHashMap;
        this.propertyKeyRegistry = new PropertyKeyRegistry();
        ConnectionStream connectionStream = new ConnectionStream();
        this.connectionStream = connectionStream;
        ArrayList arrayList = new ArrayList(4);
        this.listeners = arrayList;
        this.activeStreams = new ActiveStreams(arrayList);
        this.localEndpoint = new DefaultEndpoint<>(z5, z5 ? Integer.MAX_VALUE : i6);
        this.remoteEndpoint = new DefaultEndpoint<>(!z5, i6);
        intObjectHashMap.put(connectionStream.id(), (int) connectionStream);
    }

    static Http2Stream.State activeState(int i6, Http2Stream.State state, boolean z5, boolean z6) throws Http2Exception {
        int i7 = AnonymousClass2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[state.ordinal()];
        if (i7 == 1) {
            return z6 ? z5 ? Http2Stream.State.HALF_CLOSED_LOCAL : Http2Stream.State.HALF_CLOSED_REMOTE : Http2Stream.State.OPEN;
        }
        if (i7 == 2) {
            return Http2Stream.State.HALF_CLOSED_REMOTE;
        }
        if (i7 == 3) {
            return Http2Stream.State.HALF_CLOSED_LOCAL;
        }
        throw Http2Exception.streamError(i6, Http2Error.PROTOCOL_ERROR, "Attempting to open a stream in an invalid state: " + state, new Object[0]);
    }

    private void closeStreamsGreaterThanLastKnownStreamId(final int i6, final DefaultEndpoint<?> defaultEndpoint) throws Http2Exception {
        forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.1
            @Override // io.netty.handler.codec.http2.Http2StreamVisitor
            public boolean visit(Http2Stream http2Stream) {
                if (http2Stream.id() > i6 && defaultEndpoint.isValidStreamId(http2Stream.id())) {
                    http2Stream.close();
                    return true;
                }
                return true;
            }
        });
    }

    private boolean isStreamMapEmpty() {
        return this.streamMap.size() == 1;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void addListener(Http2Connection.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Future<Void> close(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        Promise<Void> promise2 = this.closePromise;
        if (promise2 == null) {
            this.closePromise = promise;
        } else if (promise2 != promise) {
            if ((promise instanceof ChannelPromise) && ((ChannelPromise) promise2).isVoid()) {
                this.closePromise = promise;
            } else {
                this.closePromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new UnaryPromiseNotifier(promise));
            }
        }
        if (isStreamMapEmpty()) {
            promise.trySuccess(null);
            return promise;
        }
        Iterator<IntObjectMap.PrimitiveEntry<Http2Stream>> it = this.streamMap.entries().iterator();
        if (this.activeStreams.allowModifications()) {
            this.activeStreams.incrementPendingIterations();
            while (it.hasNext()) {
                try {
                    DefaultStream defaultStream = (DefaultStream) it.next().value();
                    if (defaultStream.id() != 0) {
                        defaultStream.close(it);
                    }
                } finally {
                    this.activeStreams.decrementPendingIterations();
                }
            }
        } else {
            while (it.hasNext()) {
                Http2Stream value = it.next().value();
                if (value.id() != 0) {
                    value.close();
                }
            }
        }
        return this.closePromise;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream connectionStream() {
        return this.connectionStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
        return this.activeStreams.forEachActiveStream(http2StreamVisitor);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void goAwayReceived(int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
        if (this.localEndpoint.lastStreamKnownByPeer() >= 0 && this.localEndpoint.lastStreamKnownByPeer() < i6) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "lastStreamId MUST NOT increase. Current value: %d new value: %d", Integer.valueOf(this.localEndpoint.lastStreamKnownByPeer()), Integer.valueOf(i6));
        }
        this.localEndpoint.lastStreamKnownByPeer(i6);
        for (int i7 = 0; i7 < this.listeners.size(); i7++) {
            try {
                this.listeners.get(i7).onGoAwayReceived(i6, j6, byteBuf);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onGoAwayReceived.", th);
            }
        }
        closeStreamsGreaterThanLastKnownStreamId(i6, this.localEndpoint);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwaySent(int i6, long j6, ByteBuf byteBuf) throws Http2Exception {
        if (this.remoteEndpoint.lastStreamKnownByPeer() >= 0) {
            if (i6 == this.remoteEndpoint.lastStreamKnownByPeer()) {
                return false;
            }
            if (i6 > this.remoteEndpoint.lastStreamKnownByPeer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Last stream identifier must not increase between sending multiple GOAWAY frames (was '%d', is '%d').", Integer.valueOf(this.remoteEndpoint.lastStreamKnownByPeer()), Integer.valueOf(i6));
            }
        }
        this.remoteEndpoint.lastStreamKnownByPeer(i6);
        for (int i7 = 0; i7 < this.listeners.size(); i7++) {
            try {
                this.listeners.get(i7).onGoAwaySent(i6, j6, byteBuf);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onGoAwaySent.", th);
            }
        }
        closeStreamsGreaterThanLastKnownStreamId(i6, this.remoteEndpoint);
        return true;
    }

    final boolean isClosed() {
        return this.closePromise != null;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean isServer() {
        return this.localEndpoint.isServer();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2LocalFlowController> local() {
        return this.localEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.PropertyKey newKey() {
        return this.propertyKeyRegistry.newKey();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public int numActiveStreams() {
        return this.activeStreams.size();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2RemoteFlowController> remote() {
        return this.remoteEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void removeListener(Http2Connection.Listener listener) {
        this.listeners.remove(listener);
    }

    void removeStream(DefaultStream defaultStream, Iterator<?> it) {
        if (it != null) {
            it.remove();
        } else if (this.streamMap.remove(defaultStream.id()) == null) {
            return;
        }
        for (int i6 = 0; i6 < this.listeners.size(); i6++) {
            try {
                this.listeners.get(i6).onStreamRemoved(defaultStream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamRemoved.", th);
            }
        }
        if (this.closePromise == null || !isStreamMapEmpty()) {
            return;
        }
        this.closePromise.trySuccess(null);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream stream(int i6) {
        return this.streamMap.get(i6);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean streamMayHaveExisted(int i6) {
        return this.remoteEndpoint.mayHaveCreatedStream(i6) || this.localEndpoint.mayHaveCreatedStream(i6);
    }

    final DefaultPropertyKey verifyKey(Http2Connection.PropertyKey propertyKey) {
        return ((DefaultPropertyKey) ObjectUtil.checkNotNull((DefaultPropertyKey) propertyKey, "key")).verifyConnection(this);
    }
}
