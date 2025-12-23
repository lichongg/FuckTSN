package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.BufferedSocket;
import okhttp3.internal.http2.FlowControlListener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 -UtilCommon.kt\nokhttp3/internal/_UtilCommonKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1042:1\n63#2:1043\n63#2:1044\n63#2:1045\n38#2:1046\n63#2:1047\n63#2:1049\n63#2:1050\n63#2:1051\n34#2:1052\n63#2:1053\n63#2:1054\n34#2:1055\n63#2:1056\n63#2:1057\n49#2,4:1058\n63#2:1067\n63#2:1087\n63#2:1088\n63#2:1089\n63#2:1090\n63#2:1091\n63#2:1092\n63#2:1095\n63#2:1101\n63#2:1107\n63#2:1111\n1#3:1048\n228#4,5:1062\n228#4,5:1071\n228#4,5:1077\n228#4,5:1082\n228#4,2:1093\n230#4,3:1096\n228#4,2:1099\n230#4,3:1102\n228#4,2:1105\n230#4,3:1108\n37#5,2:1068\n13805#6:1070\n13806#6:1076\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n174#1:1043\n176#1:1044\n179#1:1045\n183#1:1046\n190#1:1047\n242#1:1049\n243#1:1050\n313#1:1051\n321#1:1052\n394#1:1053\n405#1:1054\n407#1:1055\n424#1:1056\n426#1:1057\n452#1:1058,4\n459#1:1067\n519#1:1087\n520#1:1088\n531#1:1089\n557#1:1090\n914#1:1091\n152#1:1092\n926#1:1095\n944#1:1101\n971#1:1107\n985#1:1111\n454#1:1062,5\n467#1:1071,5\n473#1:1077,5\n478#1:1082,5\n923#1:1093,2\n923#1:1096,3\n941#1:1099,2\n941#1:1102,3\n967#1:1105,2\n967#1:1108,3\n461#1:1068,2\n466#1:1070\n466#1:1076\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Http2Connection implements Closeable, Lockable {
    public static final int AWAIT_PING = 3;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;

    @NotNull
    private final String connectionName;

    @NotNull
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;

    @NotNull
    private final FlowControlListener flowControlListener;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;

    @NotNull
    private final Listener listener;
    private int nextStreamId;

    @NotNull
    private final Settings okHttpSettings;

    @NotNull
    private Settings peerSettings;

    @NotNull
    private final PushObserver pushObserver;

    @NotNull
    private final TaskQueue pushQueue;

    @NotNull
    private final WindowCounter readBytes;

    @NotNull
    private final ReaderRunnable readerRunnable;

    @NotNull
    private final TaskQueue settingsListenerQueue;

    @NotNull
    private final BufferedSocket socket;

    @NotNull
    private final Map<Integer, Http2Stream> streams;

    @NotNull
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;

    @NotNull
    private final Http2Writer writer;

    @NotNull
    private final TaskQueue writerQueue;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private boolean client;
        public String connectionName;

        @NotNull
        private FlowControlListener flowControlListener;

        @NotNull
        private Listener listener;
        private int pingIntervalMillis;

        @NotNull
        private PushObserver pushObserver;
        public BufferedSocket socket;

        @NotNull
        private final TaskRunner taskRunner;

        public Builder(boolean z5, @NotNull TaskRunner taskRunner) {
            g0.p(taskRunner, "taskRunner");
            this.client = z5;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.flowControlListener = FlowControlListener.None.INSTANCE;
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        @NotNull
        public final Builder flowControlListener(@NotNull FlowControlListener flowControlListener) {
            g0.p(flowControlListener, "flowControlListener");
            this.flowControlListener = flowControlListener;
            return this;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            g0.S("connectionName");
            return null;
        }

        @NotNull
        public final FlowControlListener getFlowControlListener$okhttp() {
            return this.flowControlListener;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        @NotNull
        public final BufferedSocket getSocket$okhttp() {
            BufferedSocket bufferedSocket = this.socket;
            if (bufferedSocket != null) {
                return bufferedSocket;
            }
            g0.S("socket");
            return null;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener) {
            g0.p(listener, "listener");
            this.listener = listener;
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int i6) {
            this.pingIntervalMillis = i6;
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver) {
            g0.p(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z5) {
            this.client = z5;
        }

        public final void setConnectionName$okhttp(@NotNull String str) {
            g0.p(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setFlowControlListener$okhttp(@NotNull FlowControlListener flowControlListener) {
            g0.p(flowControlListener, "<set-?>");
            this.flowControlListener = flowControlListener;
        }

        public final void setListener$okhttp(@NotNull Listener listener) {
            g0.p(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i6) {
            this.pingIntervalMillis = i6;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver) {
            g0.p(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSocket$okhttp(@NotNull BufferedSocket bufferedSocket) {
            g0.p(bufferedSocket, "<set-?>");
            this.socket = bufferedSocket;
        }

        @NotNull
        public final Builder socket(@NotNull BufferedSocket socket, @NotNull String peerName) throws IOException {
            String str;
            g0.p(socket, "socket");
            g0.p(peerName, "peerName");
            setSocket$okhttp(socket);
            if (this.client) {
                str = _UtilJvmKt.okHttpName + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            setConnectionName$okhttp(str);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Listener {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream stream) throws IOException {
                g0.p(stream, "stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }
        }

        public abstract void onStream(@NotNull Http2Stream http2Stream) throws IOException;

        public void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
            g0.p(connection, "connection");
            g0.p(settings, "settings");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n+ 2 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 -UtilCommon.kt\nokhttp3/internal/_UtilCommonKt\n*L\n1#1,1042:1\n63#2:1043\n63#2:1044\n63#2:1045\n63#2:1048\n63#2:1049\n38#2:1050\n63#2:1051\n63#2:1054\n38#2:1055\n63#2:1056\n37#3,2:1046\n37#3,2:1052\n228#4,5:1057\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n678#1:1043\n757#1:1044\n758#1:1045\n792#1:1048\n809#1:1049\n819#1:1050\n845#1:1051\n864#1:1054\n866#1:1055\n871#1:1056\n775#1:1046,2\n846#1:1052,2\n703#1:1057,5\n*E\n"})
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<n1> {

        @NotNull
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 ping$lambda$1(Http2Connection http2Connection, int i6, int i7) {
            http2Connection.writePing(true, i6, i7);
            return n1.f44123a;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ n1 invoke() {
            invoke2();
            return n1.f44123a;
        }

        public ReaderRunnable(@NotNull Http2Connection http2Connection, Http2Reader reader) {
            g0.p(reader, "reader");
            this.this$0 = http2Connection;
            this.reader = reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i6, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int i7, long j6) {
            g0.p(origin, "origin");
            g0.p(protocol, "protocol");
            g0.p(host, "host");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4, types: [T, okhttp3.internal.http2.Settings] */
        public final void applyAndAckSettings(boolean z5, @NotNull Settings settings) {
            ?? r02;
            long initialWindowSize;
            int i6;
            Http2Stream[] http2StreamArr;
            Http2Stream[] http2StreamArr2;
            Settings settings2 = settings;
            g0.p(settings2, "settings");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Http2Writer writer = this.this$0.getWriter();
            final Http2Connection http2Connection = this.this$0;
            synchronized (writer) {
                synchronized (http2Connection) {
                    try {
                        Settings peerSettings = http2Connection.getPeerSettings();
                        if (z5) {
                            r02 = settings2;
                        } else {
                            Settings settings3 = new Settings();
                            settings3.merge(peerSettings);
                            settings3.merge(settings2);
                            r02 = settings3;
                        }
                        objectRef.element = r02;
                        initialWindowSize = r02.getInitialWindowSize() - peerSettings.getInitialWindowSize();
                        if (initialWindowSize != 0 && !http2Connection.getStreams$okhttp().isEmpty()) {
                            http2StreamArr = (Http2Stream[]) http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                            http2StreamArr2 = http2StreamArr;
                            http2Connection.setPeerSettings((Settings) objectRef.element);
                            TaskQueue.execute$default(http2Connection.settingsListenerQueue, http2Connection.getConnectionName$okhttp() + " onSettings", 0L, false, new Function0() { // from class: okhttp3.internal.http2.l
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    n1 applyAndAckSettings$lambda$0$0$1;
                                    applyAndAckSettings$lambda$0$0$1 = Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$0$0$1(Http2Connection.this, objectRef);
                                    return applyAndAckSettings$lambda$0$0$1;
                                }
                            }, 6, null);
                            n1 n1Var = n1.f44123a;
                        }
                        http2StreamArr = null;
                        http2StreamArr2 = http2StreamArr;
                        http2Connection.setPeerSettings((Settings) objectRef.element);
                        TaskQueue.execute$default(http2Connection.settingsListenerQueue, http2Connection.getConnectionName$okhttp() + " onSettings", 0L, false, new Function0() { // from class: okhttp3.internal.http2.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                n1 applyAndAckSettings$lambda$0$0$1;
                                applyAndAckSettings$lambda$0$0$1 = Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$0$0$1(Http2Connection.this, objectRef);
                                return applyAndAckSettings$lambda$0$0$1;
                            }
                        }, 6, null);
                        n1 n1Var2 = n1.f44123a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) objectRef.element);
                } catch (IOException e6) {
                    http2Connection.failConnection(e6);
                }
                n1 n1Var3 = n1.f44123a;
            }
            if (http2StreamArr2 != null) {
                for (Http2Stream http2Stream : http2StreamArr2) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                        n1 n1Var4 = n1.f44123a;
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z5, int i6, @NotNull BufferedSource source, int i7) throws IOException {
            g0.p(source, "source");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushDataLater$okhttp(i6, source, i7, z5);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i6);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i6, ErrorCode.PROTOCOL_ERROR);
                long j6 = i7;
                this.this$0.updateConnectionFlowControl$okhttp(j6);
                source.skip(j6);
                return;
            }
            stream.receiveData(source, i7);
            if (z5) {
                stream.receiveHeaders(Headers.EMPTY, true);
            }
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i6, @NotNull ErrorCode errorCode, @NotNull ByteString debugData) {
            int i7;
            Object[] array;
            g0.p(errorCode, "errorCode");
            g0.p(debugData, "debugData");
            debugData.size();
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
                n1 n1Var = n1.f44123a;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.getId() > i6 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z5, int i6, int i7, @NotNull List<Header> headerBlock) {
            g0.p(headerBlock, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushHeadersLater$okhttp(i6, headerBlock, z5);
                return;
            }
            final Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i6);
                if (stream != null) {
                    n1 n1Var = n1.f44123a;
                    stream.receiveHeaders(_UtilJvmKt.toHeaders(headerBlock), z5);
                    return;
                }
                if (http2Connection.isShutdown) {
                    return;
                }
                if (i6 <= http2Connection.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i6 % 2 == http2Connection.getNextStreamId$okhttp() % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i6, http2Connection, false, z5, _UtilJvmKt.toHeaders(headerBlock));
                http2Connection.setLastGoodStreamId$okhttp(i6);
                http2Connection.getStreams$okhttp().put(Integer.valueOf(i6), http2Stream);
                TaskQueue.execute$default(http2Connection.taskRunner.newQueue(), http2Connection.getConnectionName$okhttp() + '[' + i6 + "] onStream", 0L, false, new Function0() { // from class: okhttp3.internal.http2.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 headers$lambda$0$0;
                        headers$lambda$0$0 = Http2Connection.ReaderRunnable.headers$lambda$0$0(Http2Connection.this, http2Stream);
                        return headers$lambda$0$0;
                    }
                }, 6, null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e6 = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException e7) {
                    e6 = e7;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    this.this$0.close$okhttp(errorCode, errorCode3, e6);
                    _UtilCommonKt.closeQuietly(this.reader);
                    throw th;
                }
                try {
                    this.this$0.close$okhttp(errorCode2, ErrorCode.CANCEL, null);
                    errorCode = errorCode2;
                } catch (IOException e8) {
                    e6 = e8;
                    ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection http2Connection = this.this$0;
                    http2Connection.close$okhttp(errorCode4, errorCode4, e6);
                    errorCode = http2Connection;
                    errorCode3 = this.reader;
                    _UtilCommonKt.closeQuietly(errorCode3);
                }
                errorCode3 = this.reader;
                _UtilCommonKt.closeQuietly(errorCode3);
            } catch (Throwable th2) {
                th = th2;
                this.this$0.close$okhttp(errorCode, errorCode3, e6);
                _UtilCommonKt.closeQuietly(this.reader);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z5, final int i6, final int i7) {
            if (!z5) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                String str = this.this$0.getConnectionName$okhttp() + " ping";
                final Http2Connection http2Connection = this.this$0;
                TaskQueue.execute$default(taskQueue, str, 0L, false, new Function0() { // from class: okhttp3.internal.http2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 ping$lambda$1;
                        ping$lambda$1 = Http2Connection.ReaderRunnable.ping$lambda$1(Http2Connection.this, i6, i7);
                        return ping$lambda$1;
                    }
                }, 6, null);
                return;
            }
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection2) {
                try {
                    if (i6 == 1) {
                        http2Connection2.intervalPongsReceived++;
                    } else if (i6 != 2) {
                        if (i6 == 3) {
                            http2Connection2.awaitPongsReceived++;
                            g0.n(http2Connection2, "null cannot be cast to non-null type java.lang.Object");
                            http2Connection2.notifyAll();
                        }
                        n1 n1Var = n1.f44123a;
                    } else {
                        http2Connection2.degradedPongsReceived++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i6, int i7, @NotNull List<Header> requestHeaders) {
            g0.p(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i7, requestHeaders);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i6, @NotNull ErrorCode errorCode) {
            g0.p(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i6)) {
                this.this$0.pushResetLater$okhttp(i6, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i6);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z5, @NotNull final Settings settings) {
            g0.p(settings, "settings");
            TaskQueue.execute$default(this.this$0.writerQueue, this.this$0.getConnectionName$okhttp() + " applyAndAckSettings", 0L, false, new Function0() { // from class: okhttp3.internal.http2.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 n1Var;
                    n1Var = Http2Connection.ReaderRunnable.settings$lambda$0(Http2Connection.ReaderRunnable.this, z5, settings);
                    return n1Var;
                }
            }, 6, null);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i6, long j6) {
            if (i6 == 0) {
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j6;
                    g0.n(http2Connection, "null cannot be cast to non-null type java.lang.Object");
                    http2Connection.notifyAll();
                    n1 n1Var = n1.f44123a;
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(i6);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j6);
                    n1 n1Var2 = n1.f44123a;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final n1 applyAndAckSettings$lambda$0$0$1(Http2Connection http2Connection, Ref.ObjectRef objectRef) {
            http2Connection.getListener$okhttp().onSettings(http2Connection, (Settings) objectRef.element);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 headers$lambda$0$0(Http2Connection http2Connection, Http2Stream http2Stream) {
            try {
                http2Connection.getListener$okhttp().onStream(http2Stream);
            } catch (IOException e6) {
                Platform.Companion.get().log("Http2Connection.Listener failure for " + http2Connection.getConnectionName$okhttp(), 4, e6);
                try {
                    http2Stream.close(ErrorCode.PROTOCOL_ERROR, e6);
                } catch (IOException unused) {
                }
            }
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 settings$lambda$0(ReaderRunnable readerRunnable, boolean z5, Settings settings) {
            readerRunnable.applyAndAckSettings(z5, settings);
            return n1.f44123a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i6, int i7, int i8, boolean z5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _init_$lambda$0(Http2Connection http2Connection, long j6) {
        boolean z5;
        synchronized (http2Connection) {
            long j7 = http2Connection.intervalPongsReceived;
            long j8 = http2Connection.intervalPingsSent;
            if (j7 < j8) {
                z5 = true;
            } else {
                http2Connection.intervalPingsSent = j8 + 1;
                z5 = false;
            }
        }
        if (z5) {
            http2Connection.failConnection(null);
            return -1L;
        }
        http2Connection.writePing(false, 1, 0);
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 sendDegradedPingLater$lambda$1(Http2Connection http2Connection) {
        http2Connection.writePing(false, 2, 0);
        return n1.f44123a;
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z5, int i6, Object obj) throws IOException {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        http2Connection.start(z5);
    }

    public final void awaitPong() throws InterruptedException {
        synchronized (this) {
            while (this.awaitPongsReceived < this.awaitPingsSent) {
                try {
                    g0.n(this, "null cannot be cast to non-null type java.lang.Object");
                    wait();
                } catch (Throwable th) {
                    throw th;
                }
            }
            n1 n1Var = n1.f44123a;
        }
    }

    @Nullable
    public final Http2Stream getStream(int i6) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = this.streams.get(Integer.valueOf(i6));
        }
        return http2Stream;
    }

    public final boolean isHealthy(long j6) {
        synchronized (this) {
            if (this.isShutdown) {
                return false;
            }
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                if (j6 >= this.degradedPongDeadlineNs) {
                    return false;
                }
            }
            return true;
        }
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> requestHeaders, boolean z5) throws IOException {
        g0.p(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, z5);
    }

    public final int openStreamCount() {
        int size;
        synchronized (this) {
            size = this.streams.size();
        }
        return size;
    }

    @Nullable
    public final Http2Stream removeStream$okhttp(int i6) {
        Http2Stream remove;
        synchronized (this) {
            remove = this.streams.remove(Integer.valueOf(i6));
            g0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
        return remove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j6 = this.degradedPongsReceived;
            long j7 = this.degradedPingsSent;
            if (j6 < j7) {
                return;
            }
            this.degradedPingsSent = j7 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
            n1 n1Var = n1.f44123a;
            TaskQueue.execute$default(this.writerQueue, this.connectionName + " ping", 0L, false, new Function0() { // from class: okhttp3.internal.http2.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 sendDegradedPingLater$lambda$1;
                    sendDegradedPingLater$lambda$1 = Http2Connection.sendDegradedPingLater$lambda$1(Http2Connection.this);
                    return sendDegradedPingLater$lambda$1;
                }
            }, 6, null);
        }
    }

    @JvmOverloads
    public final void start() throws IOException {
        start$default(this, false, 1, null);
    }

    public final void updateConnectionFlowControl$okhttp(long j6) {
        synchronized (this) {
            try {
                WindowCounter.update$default(this.readBytes, j6, 0L, 2, null);
                long unacknowledged = this.readBytes.getUnacknowledged();
                if (unacknowledged >= this.okHttpSettings.getInitialWindowSize() / 2) {
                    writeWindowUpdateLater$okhttp(0, unacknowledged);
                    WindowCounter.update$default(this.readBytes, 0L, unacknowledged, 1, null);
                }
                this.flowControlListener.receivingConnectionWindowChanged(this.readBytes);
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.writer.maxDataLength());
        r6 = r3;
        r8.writeBytesTotal += r6;
        r4 = kotlin.n1.f44123a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeData(int r9, boolean r10, @org.jetbrains.annotations.Nullable okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L71
            monitor-enter(r8)
        L12:
            long r3 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            long r5 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L39
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.streams     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            if (r3 == 0) goto L31
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.g0.n(r8, r3)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            r8.wait()     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            goto L12
        L2f:
            r9 = move-exception
            goto L6f
        L31:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            throw r9     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
        L39:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch: java.lang.Throwable -> L2f
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L2f
            okhttp3.internal.http2.Http2Writer r3 = r8.writer     // Catch: java.lang.Throwable -> L2f
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L2f
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L2f
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2f
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L2f
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L2f
            kotlin.n1 r4 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L5d
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L5d
            r5 = 1
            goto L5e
        L5d:
            r5 = 0
        L5e:
            r4.data(r5, r9, r11, r3)
            goto Ld
        L62:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2f
            r9.interrupt()     // Catch: java.lang.Throwable -> L2f
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2f
            r9.<init>()     // Catch: java.lang.Throwable -> L2f
            throw r9     // Catch: java.lang.Throwable -> L2f
        L6f:
            monitor-exit(r8)
            throw r9
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public final void writePing(boolean z5, int i6, int i7) {
        try {
            this.writer.ping(z5, i6, i7);
        } catch (IOException e6) {
            failConnection(e6);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(4, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(@NotNull Builder builder) {
        g0.p(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        this.flowControlListener = builder.getFlowControlListener$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(4, 16777216);
        }
        this.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.readBytes = new WindowCounter(0);
        this.writeBytesMaximum = this.peerSettings.getInitialWindowSize();
        BufferedSocket socket$okhttp = builder.getSocket$okhttp();
        this.socket = socket$okhttp;
        this.writer = new Http2Writer(socket$okhttp.getSink(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(socket$okhttp.getSource(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            newQueue.schedule(connectionName$okhttp + " ping", nanos, new Function0() { // from class: okhttp3.internal.http2.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    long _init_$lambda$0;
                    _init_$lambda$0 = Http2Connection._init_$lambda$0(Http2Connection.this, nanos);
                    return Long.valueOf(_init_$lambda$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:15:0x0027, B:17:0x002c, B:19:0x0034, B:23:0x0047, B:25:0x004d, B:26:0x0056, B:43:0x0082, B:44:0x0087), top: B:11:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:27:0x0058, B:29:0x005b, B:35:0x0064, B:37:0x0068, B:38:0x0076, B:39:0x007d, B:47:0x0088, B:48:0x0089), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:27:0x0058, B:29:0x005b, B:35:0x0064, B:37:0x0068, B:38:0x0076, B:39:0x007d, B:47:0x0088, B:48:0x0089), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.internal.http2.Http2Stream newStream(int r10, java.util.List<okhttp3.internal.http2.Header> r11, boolean r12) throws java.io.IOException {
        /*
            r9 = this;
            r3 = r12 ^ 1
            okhttp3.internal.http2.Http2Writer r6 = r9.writer
            monitor-enter(r6)
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L8a
            int r0 = r9.nextStreamId     // Catch: java.lang.Throwable -> L7e
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L18
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L13
            r9.shutdown(r0)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L88
        L18:
            boolean r0 = r9.isShutdown     // Catch: java.lang.Throwable -> L7e
            if (r0 != 0) goto L81
            int r1 = r9.nextStreamId     // Catch: java.lang.Throwable -> L7e
            int r0 = r1 + 2
            r9.nextStreamId = r0     // Catch: java.lang.Throwable -> L7e
            okhttp3.internal.http2.Http2Stream r0 = new okhttp3.internal.http2.Http2Stream     // Catch: java.lang.Throwable -> L7e
            r5 = 0
            r4 = 0
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L43
            if (r12 == 0) goto L46
            long r4 = r2.writeBytesTotal     // Catch: java.lang.Throwable -> L43
            long r7 = r2.writeBytesMaximum     // Catch: java.lang.Throwable -> L43
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 >= 0) goto L46
            long r4 = r0.getWriteBytesTotal()     // Catch: java.lang.Throwable -> L43
            long r7 = r0.getWriteBytesMaximum()     // Catch: java.lang.Throwable -> L43
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 < 0) goto L41
            goto L46
        L41:
            r12 = 0
            goto L47
        L43:
            r0 = move-exception
        L44:
            r10 = r0
            goto L88
        L46:
            r12 = 1
        L47:
            boolean r4 = r0.isOpen()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L56
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r4 = r2.streams     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L43
            r4.put(r5, r0)     // Catch: java.lang.Throwable -> L43
        L56:
            kotlin.n1 r4 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L43
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L61
            if (r10 != 0) goto L64
            okhttp3.internal.http2.Http2Writer r10 = r2.writer     // Catch: java.lang.Throwable -> L61
            r10.headers(r3, r1, r11)     // Catch: java.lang.Throwable -> L61
            goto L6d
        L61:
            r0 = move-exception
        L62:
            r10 = r0
            goto L8d
        L64:
            boolean r3 = r2.client     // Catch: java.lang.Throwable -> L61
            if (r3 != 0) goto L76
            okhttp3.internal.http2.Http2Writer r3 = r2.writer     // Catch: java.lang.Throwable -> L61
            r3.pushPromise(r10, r1, r11)     // Catch: java.lang.Throwable -> L61
        L6d:
            monitor-exit(r6)
            if (r12 == 0) goto L75
            okhttp3.internal.http2.Http2Writer r10 = r2.writer
            r10.flush()
        L75:
            return r0
        L76:
            java.lang.String r10 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L61
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L61
            throw r11     // Catch: java.lang.Throwable -> L61
        L7e:
            r0 = move-exception
            r2 = r9
            goto L44
        L81:
            r2 = r9
            okhttp3.internal.http2.ConnectionShutdownException r10 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L43
            r10.<init>()     // Catch: java.lang.Throwable -> L43
            throw r10     // Catch: java.lang.Throwable -> L43
        L88:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L61
            throw r10     // Catch: java.lang.Throwable -> L61
        L8a:
            r0 = move-exception
            r2 = r9
            goto L62
        L8d:
            monitor-exit(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 pushDataLater$lambda$0(Http2Connection http2Connection, int i6, Buffer buffer, int i7, boolean z5) {
        try {
            boolean onData = http2Connection.pushObserver.onData(i6, buffer, i7, z5);
            if (onData) {
                http2Connection.writer.rstStream(i6, ErrorCode.CANCEL);
            }
            if (onData || z5) {
                synchronized (http2Connection) {
                    http2Connection.currentPushRequests.remove(Integer.valueOf(i6));
                    n1 n1Var = n1.f44123a;
                }
            }
        } catch (IOException unused) {
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 pushHeadersLater$lambda$0(Http2Connection http2Connection, int i6, List list, boolean z5) {
        boolean onHeaders = http2Connection.pushObserver.onHeaders(i6, list, z5);
        if (onHeaders) {
            try {
                http2Connection.writer.rstStream(i6, ErrorCode.CANCEL);
            } catch (IOException unused) {
            }
        }
        if (onHeaders || z5) {
            synchronized (http2Connection) {
                http2Connection.currentPushRequests.remove(Integer.valueOf(i6));
                n1 n1Var = n1.f44123a;
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 pushRequestLater$lambda$1(Http2Connection http2Connection, int i6, List list) {
        if (http2Connection.pushObserver.onRequest(i6, list)) {
            try {
                http2Connection.writer.rstStream(i6, ErrorCode.CANCEL);
                synchronized (http2Connection) {
                    http2Connection.currentPushRequests.remove(Integer.valueOf(i6));
                    n1 n1Var = n1.f44123a;
                }
            } catch (IOException unused) {
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 pushResetLater$lambda$0(Http2Connection http2Connection, int i6, ErrorCode errorCode) {
        n1 n1Var;
        http2Connection.pushObserver.onReset(i6, errorCode);
        synchronized (http2Connection) {
            http2Connection.currentPushRequests.remove(Integer.valueOf(i6));
            n1Var = n1.f44123a;
        }
        return n1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 writeWindowUpdateLater$lambda$0(Http2Connection http2Connection, int i6, long j6) {
        try {
            http2Connection.writer.windowUpdate(i6, j6);
        } catch (IOException e6) {
            http2Connection.failConnection(e6);
        }
        return n1.f44123a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@NotNull ErrorCode connectionCode, @NotNull ErrorCode streamCode, @Nullable IOException iOException) {
        int i6;
        Object[] objArr;
        g0.p(connectionCode, "connectionCode");
        g0.p(streamCode, "streamCode");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    objArr = null;
                } else {
                    objArr = this.streams.values().toArray(new Http2Stream[0]);
                    this.streams.clear();
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) objArr;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.cancel();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    @NotNull
    public final FlowControlListener getFlowControlListener$okhttp() {
        return this.flowControlListener;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    @NotNull
    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @NotNull
    public final BufferedSocket getSocket$okhttp() {
        return this.socket;
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final void pushDataLater$okhttp(final int i6, @NotNull BufferedSource source, final int i7, final boolean z5) throws IOException {
        g0.p(source, "source");
        final Buffer buffer = new Buffer();
        long j6 = i7;
        source.require(j6);
        source.read(buffer, j6);
        TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i6 + "] onData", 0L, false, new Function0() { // from class: okhttp3.internal.http2.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 pushDataLater$lambda$0;
                pushDataLater$lambda$0 = Http2Connection.pushDataLater$lambda$0(Http2Connection.this, i6, buffer, i7, z5);
                return pushDataLater$lambda$0;
            }
        }, 6, null);
    }

    public final void pushHeadersLater$okhttp(final int i6, @NotNull final List<Header> requestHeaders, final boolean z5) {
        g0.p(requestHeaders, "requestHeaders");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i6 + "] onHeaders", 0L, false, new Function0() { // from class: okhttp3.internal.http2.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 pushHeadersLater$lambda$0;
                pushHeadersLater$lambda$0 = Http2Connection.pushHeadersLater$lambda$0(Http2Connection.this, i6, requestHeaders, z5);
                return pushHeadersLater$lambda$0;
            }
        }, 6, null);
    }

    public final void pushRequestLater$okhttp(final int i6, @NotNull final List<Header> requestHeaders) {
        g0.p(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i6))) {
                writeSynResetLater$okhttp(i6, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i6));
            TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i6 + "] onRequest", 0L, false, new Function0() { // from class: okhttp3.internal.http2.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 pushRequestLater$lambda$1;
                    pushRequestLater$lambda$1 = Http2Connection.pushRequestLater$lambda$1(Http2Connection.this, i6, requestHeaders);
                    return pushRequestLater$lambda$1;
                }
            }, 6, null);
        }
    }

    public final void pushResetLater$okhttp(final int i6, @NotNull final ErrorCode errorCode) {
        g0.p(errorCode, "errorCode");
        TaskQueue.execute$default(this.pushQueue, this.connectionName + '[' + i6 + "] onReset", 0L, false, new Function0() { // from class: okhttp3.internal.http2.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 pushResetLater$lambda$0;
                pushResetLater$lambda$0 = Http2Connection.pushResetLater$lambda$0(Http2Connection.this, i6, errorCode);
                return pushResetLater$lambda$0;
            }
        }, 6, null);
    }

    @NotNull
    public final Http2Stream pushStream(int i6, @NotNull List<Header> requestHeaders, boolean z5) throws IOException {
        g0.p(requestHeaders, "requestHeaders");
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i6, requestHeaders, z5);
    }

    public final boolean pushedStream$okhttp(int i6) {
        return i6 != 0 && (i6 & 1) == 0;
    }

    public final void setLastGoodStreamId$okhttp(int i6) {
        this.lastGoodStreamId = i6;
    }

    public final void setNextStreamId$okhttp(int i6) {
        this.nextStreamId = i6;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        g0.p(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(@NotNull Settings settings) throws IOException {
        g0.p(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                n1 n1Var = n1.f44123a;
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(@NotNull ErrorCode statusCode) throws IOException {
        g0.p(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i6 = this.lastGoodStreamId;
                n1 n1Var = n1.f44123a;
                this.writer.goAway(i6, statusCode, _UtilCommonKt.EMPTY_BYTE_ARRAY);
            }
        }
    }

    @JvmOverloads
    public final void start(boolean z5) throws IOException {
        if (z5) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r9 - 65535);
            }
        }
        TaskQueue.execute$default(this.taskRunner.newQueue(), this.connectionName, 0L, false, this.readerRunnable, 6, null);
    }

    public final void writeHeaders$okhttp(int i6, boolean z5, @NotNull List<Header> alternating) throws IOException {
        g0.p(alternating, "alternating");
        this.writer.headers(z5, i6, alternating);
    }

    public final void writeSynReset$okhttp(int i6, @NotNull ErrorCode statusCode) throws IOException {
        g0.p(statusCode, "statusCode");
        this.writer.rstStream(i6, statusCode);
    }

    public final void writeSynResetLater$okhttp(final int i6, @NotNull final ErrorCode errorCode) {
        g0.p(errorCode, "errorCode");
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + i6 + "] writeSynReset", 0L, false, new Function0() { // from class: okhttp3.internal.http2.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 writeSynResetLater$lambda$0;
                writeSynResetLater$lambda$0 = Http2Connection.writeSynResetLater$lambda$0(Http2Connection.this, i6, errorCode);
                return writeSynResetLater$lambda$0;
            }
        }, 6, null);
    }

    public final void writeWindowUpdateLater$okhttp(final int i6, final long j6) {
        TaskQueue.execute$default(this.writerQueue, this.connectionName + '[' + i6 + "] windowUpdate", 0L, false, new Function0() { // from class: okhttp3.internal.http2.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 writeWindowUpdateLater$lambda$0;
                writeWindowUpdateLater$lambda$0 = Http2Connection.writeWindowUpdateLater$lambda$0(Http2Connection.this, i6, j6);
                return writeWindowUpdateLater$lambda$0;
            }
        }, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 writeSynResetLater$lambda$0(Http2Connection http2Connection, int i6, ErrorCode errorCode) {
        try {
            http2Connection.writeSynReset$okhttp(i6, errorCode);
        } catch (IOException e6) {
            http2Connection.failConnection(e6);
        }
        return n1.f44123a;
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }
}
