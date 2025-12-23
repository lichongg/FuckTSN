package okhttp3.internal.ws;

import com.tencent.connect.common.Constants;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.text.u;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.BufferedSocket;
import okhttp3.internal.connection.BufferedSocketKt;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.ByteString;
import okio.Sink;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealWebSocket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealWebSocket.kt\nokhttp3/internal/ws/RealWebSocket\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,703:1\n1#2:704\n55#3,4:705\n*S KotlinDebug\n*F\n+ 1 RealWebSocket.kt\nokhttp3/internal/ws/RealWebSocket\n*L\n499#1:705,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback, Lockable {
    public static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;

    @Nullable
    private Call call;
    private boolean enqueuedClose;

    @Nullable
    private WebSocketExtensions extensions;
    private boolean failed;

    @NotNull
    private final String key;

    @NotNull
    private final WebSocketListener listener;

    @NotNull
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;

    @Nullable
    private String name;

    @NotNull
    private final Request originalRequest;
    private final long pingIntervalMillis;

    @NotNull
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;

    @NotNull
    private final Random random;

    @Nullable
    private WebSocketReader reader;
    private int receivedCloseCode;

    @Nullable
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;

    @Nullable
    private Socket socket;

    @NotNull
    private TaskQueue taskQueue;
    private final long webSocketCloseTimeout;

    @Nullable
    private WebSocketWriter writer;

    @Nullable
    private Task writerTask;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final List<Protocol> ONLY_HTTP1 = f0.l(Protocol.HTTP_1_1);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;

        @Nullable
        private final ByteString reason;

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }

        public Close(int i6, @Nullable ByteString byteString, long j6) {
            this.code = i6;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Message {

        @NotNull
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i6, @NotNull ByteString data) {
            g0.p(data, "data");
            this.formatOpcode = i6;
            this.data = data;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e6) {
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e6, null, true, 2, null);
                return -1L;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i6, @Nullable String str) {
        return close(i6, str, this.webSocketCloseTimeout);
    }

    public final void finishReader() {
        int i6;
        String str;
        WebSocketReader webSocketReader;
        boolean z5;
        synchronized (this) {
            try {
                i6 = this.receivedCloseCode;
                str = this.receivedCloseReason;
                webSocketReader = this.reader;
                this.reader = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    final WebSocketWriter webSocketWriter = this.writer;
                    if (webSocketWriter != null) {
                        this.writer = null;
                        TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new Function0() { // from class: okhttp3.internal.ws.b
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                n1 finishReader$lambda$0$0;
                                finishReader$lambda$0$0 = RealWebSocket.finishReader$lambda$0$0(WebSocketWriter.this);
                                return finishReader$lambda$0$0;
                            }
                        }, 2, null);
                    }
                    this.taskQueue.shutdown();
                }
                z5 = (this.failed || this.writer != null || this.receivedCloseCode == -1) ? false : true;
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            WebSocketListener webSocketListener = this.listener;
            g0.m(str);
            webSocketListener.onClosed(this, i6, str);
        }
        if (webSocketReader != null) {
            _UtilCommonKt.closeQuietly(webSocketReader);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) throws IOException {
        g0.p(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull ByteString payload) {
        try {
            g0.p(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull ByteString payload) {
        g0.p(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(@NotNull ByteString payload) {
        try {
            g0.p(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            g0.m(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e6) {
            failWebSocket$default(this, e6, null, false, 6, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String text) {
        g0.p(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                int i6 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                n1 n1Var = n1.f44123a;
                if (i6 == -1) {
                    try {
                        webSocketWriter.writePing(ByteString.EMPTY);
                        return;
                    } catch (IOException e6) {
                        failWebSocket$default(this, e6, null, true, 2, null);
                        return;
                    }
                }
                failWebSocket$default(this, new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i6 - 1) + " successful ping/pongs)"), null, true, 2, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request originalRequest, @NotNull WebSocketListener listener, @NotNull Random random, long j6, @Nullable WebSocketExtensions webSocketExtensions, long j7, long j8) {
        g0.p(taskRunner, "taskRunner");
        g0.p(originalRequest, "originalRequest");
        g0.p(listener, "listener");
        g0.p(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j6;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j7;
        this.webSocketCloseTimeout = j8;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!g0.g("GET", originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        n1 n1Var = n1.f44123a;
        this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
    }

    public static /* synthetic */ void failWebSocket$default(RealWebSocket realWebSocket, Exception exc, Response response, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            response = null;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        realWebSocket.failWebSocket(exc, response, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 failWebSocket$lambda$0$0(Ref.ObjectRef objectRef) {
        _UtilCommonKt.closeQuietly((Closeable) objectRef.element);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        Integer num = webSocketExtensions.serverMaxWindowBits;
        if (num == null) {
            return true;
        }
        int intValue = num.intValue();
        return 8 <= intValue && intValue < 16;
    }

    private final void runWriter() {
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        g0.m(call);
        call.cancel();
    }

    @NotNull
    public final Socket checkUpgradeSuccess$okhttp(@NotNull Response response) throws IOException {
        g0.p(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String header$default = Response.header$default(response, "Connection", null, 2, null);
        if (!u.a2("Upgrade", header$default, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
        }
        String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!u.a2("websocket", header$default2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
        }
        String header$default3 = Response.header$default(response, HttpHeaders.Names.SEC_WEBSOCKET_ACCEPT, null, 2, null);
        String base64 = ByteString.Companion.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (g0.g(base64, header$default3)) {
            Socket socket = response.socket();
            if (socket != null) {
                return socket;
            }
            throw new ProtocolException("Web Socket socket missing: bad interceptor?");
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
    }

    public final synchronized boolean close(int i6, @Nullable String str, long j6) {
        ByteString byteString;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i6);
            if (str != null) {
                byteString = ByteString.Companion.encodeUtf8(str);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            } else {
                byteString = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i6, byteString, j6));
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final void connect(@NotNull OkHttpClient client) {
        g0.p(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket$default(this, new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null, false, 6, null);
            return;
        }
        OkHttpClient build = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header(HttpHeaders.Names.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.Names.SEC_WEBSOCKET_VERSION, Constants.VIA_REPORT_TYPE_JOININ_GROUP).header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        g0.m(realCall);
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e6) {
                g0.p(call, "call");
                g0.p(e6, "e");
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e6, null, false, 6, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Source source;
                Sink sink;
                boolean isValid;
                ArrayDeque arrayDeque;
                g0.p(call, "call");
                g0.p(response, "response");
                try {
                    Socket checkUpgradeSuccess$okhttp = RealWebSocket.this.checkUpgradeSuccess$okhttp(response);
                    WebSocketExtensions parse = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = parse;
                    isValid = RealWebSocket.this.isValid(parse);
                    if (!isValid) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            arrayDeque = realWebSocket.messageAndCloseQueue;
                            arrayDeque.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    RealWebSocket.this.initReaderAndWriter(_UtilJvmKt.okHttpName + " WebSocket " + build2.url().redact(), BufferedSocketKt.asBufferedSocket(checkUpgradeSuccess$okhttp), true);
                    RealWebSocket.this.loopReader(response);
                } catch (IOException e6) {
                    RealWebSocket.failWebSocket$default(RealWebSocket.this, e6, response, false, 4, null);
                    _UtilCommonKt.closeQuietly(response);
                    Socket socket = response.socket();
                    if (socket != null && (sink = socket.getSink()) != null) {
                        _UtilCommonKt.closeQuietly(sink);
                    }
                    Socket socket2 = response.socket();
                    if (socket2 == null || (source = socket2.getSource()) == null) {
                        return;
                    }
                    _UtilCommonKt.closeQuietly(source);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, okhttp3.internal.ws.WebSocketWriter] */
    public final void failWebSocket(@NotNull Exception e6, @Nullable Response response, boolean z5) {
        WebSocketWriter webSocketWriter;
        g0.p(e6, "e");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                Socket socket = this.socket;
                ?? r02 = this.writer;
                objectRef.element = r02;
                this.writer = null;
                if (!z5 && r02 != 0) {
                    TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new Function0() { // from class: okhttp3.internal.ws.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            n1 failWebSocket$lambda$0$0;
                            failWebSocket$lambda$0$0 = RealWebSocket.failWebSocket$lambda$0$0(Ref.ObjectRef.this);
                            return failWebSocket$lambda$0$0;
                        }
                    }, 2, null);
                }
                this.taskQueue.shutdown();
                n1 n1Var = n1.f44123a;
                try {
                    this.listener.onFailure(this, e6, response);
                    if (socket != null) {
                        socket.cancel();
                    }
                    if (!z5 || (webSocketWriter = (WebSocketWriter) objectRef.element) == null) {
                        return;
                    }
                    _UtilCommonKt.closeQuietly(webSocketWriter);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final Call getCall$okhttp() {
        return this.call;
    }

    @NotNull
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull String name, @NotNull BufferedSocket socket, boolean z5) {
        g0.p(name, "name");
        g0.p(socket, "socket");
        WebSocketExtensions webSocketExtensions = this.extensions;
        g0.m(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = name;
                this.socket = socket;
                this.writer = new WebSocketWriter(z5, socket.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(z5), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j6 = this.pingIntervalMillis;
                if (j6 != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j6);
                    this.taskQueue.schedule(name + " ping", nanos, new Function0() { // from class: okhttp3.internal.ws.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            long initReaderAndWriter$lambda$0$0;
                            initReaderAndWriter$lambda$0$0 = RealWebSocket.initReaderAndWriter$lambda$0$0(RealWebSocket.this, nanos);
                            return Long.valueOf(initReaderAndWriter$lambda$0$0);
                        }
                    });
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(z5, socket.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!z5));
    }

    public final void loopReader(@NotNull Response response) throws IOException {
        g0.p(response, "response");
        try {
            try {
                this.listener.onOpen(this, response);
                while (this.receivedCloseCode == -1) {
                    WebSocketReader webSocketReader = this.reader;
                    g0.m(webSocketReader);
                    webSocketReader.processNextFrame();
                }
            } catch (Exception e6) {
                failWebSocket$default(this, e6, null, false, 6, null);
                finishReader();
            }
        } finally {
            finishReader();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i6, @NotNull String reason) {
        g0.p(reason, "reason");
        if (i6 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i6;
            this.receivedCloseReason = reason;
            n1 n1Var = n1.f44123a;
        }
        this.listener.onClosing(this, i6, reason);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString bytes) throws IOException {
        g0.p(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString bytes) {
        g0.p(bytes, "bytes");
        return send(bytes, 2);
    }

    public final void setCall$okhttp(@Nullable Call call) {
        this.call = call;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #2 {all -> 0x008b, blocks: (B:27:0x0082, B:31:0x008d, B:33:0x0091, B:34:0x00a5, B:37:0x00b6, B:41:0x00b9, B:42:0x00ba, B:43:0x00bb, B:45:0x00bf, B:47:0x00d4, B:48:0x00e2, B:49:0x00e7, B:36:0x00a6), top: B:25:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:27:0x0082, B:31:0x008d, B:33:0x0091, B:34:0x00a5, B:37:0x00b6, B:41:0x00b9, B:42:0x00ba, B:43:0x00bb, B:45:0x00bf, B:47:0x00d4, B:48:0x00e2, B:49:0x00e7, B:36:0x00a6), top: B:25:0x0080 }] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 finishReader$lambda$0$0(WebSocketWriter webSocketWriter) {
        _UtilCommonKt.closeQuietly(webSocketWriter);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initReaderAndWriter$lambda$0$0(RealWebSocket realWebSocket, long j6) {
        realWebSocket.writePingFrame$okhttp();
        return j6;
    }

    private final synchronized boolean send(ByteString byteString, int i6) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i6, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 writeOneFrame$lambda$0$0(RealWebSocket realWebSocket) {
        realWebSocket.cancel();
        return n1.f44123a;
    }
}
