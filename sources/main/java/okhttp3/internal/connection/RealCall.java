package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.d;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Tags;
import okhttp3.internal.TagsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,612:1\n1#2:613\n63#3:614\n63#3:615\n63#3:616\n55#3,4:617\n63#3:621\n63#3:622\n49#3,4:623\n49#3,4:627\n63#3:631\n55#3,4:632\n63#3:643\n63#3:644\n360#4,7:636\n*S KotlinDebug\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall\n*L\n257#1:614\n292#1:615\n303#1:616\n313#1:617,4\n340#1:621\n373#1:622\n401#1:623,4\n405#1:627,4\n407#1:631\n438#1:632,4\n479#1:643\n495#1:644\n441#1:636,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RealCall implements Call, Cloneable, Lockable {

    @Nullable
    private Object callStackTrace;
    private volatile boolean canceled;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private RealConnection connection;

    @NotNull
    private final RealConnectionPool connectionPool;

    @NotNull
    private final EventListener eventListener;

    @Nullable
    private volatile Exchange exchange;

    @Nullable
    private ExchangeFinder exchangeFinder;

    @NotNull
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;

    @Nullable
    private Exchange interceptorScopedExchange;

    @NotNull
    private final Request originalRequest;

    @NotNull
    private final CopyOnWriteArrayList<RoutePlanner.Plan> plansToCancel;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private boolean socketSinkOpen;
    private boolean socketSourceOpen;

    @NotNull
    private final AtomicReference<Tags> tags;

    @NotNull
    private final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRealCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall$AsyncCall\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,612:1\n227#2,9:613\n*S KotlinDebug\n*F\n+ 1 RealCall.kt\nokhttp3/internal/connection/RealCall$AsyncCall\n*L\n570#1:613,9\n*E\n"})
    public final class AsyncCall implements Runnable {

        @NotNull
        private volatile AtomicInteger callsPerHost;

        @NotNull
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(@NotNull RealCall realCall, Callback responseCallback) {
            g0.p(responseCallback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public static /* synthetic */ void failRejected$okhttp$default(AsyncCall asyncCall, RejectedExecutionException rejectedExecutionException, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                rejectedExecutionException = null;
            }
            asyncCall.failRejected$okhttp(rejectedExecutionException);
        }

        public final void executeOn(@NotNull ExecutorService executorService) {
            g0.p(executorService, "executorService");
            _UtilJvmKt.assertLockNotHeld(this.this$0.getClient().dispatcher());
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e6) {
                    failRejected$okhttp(e6);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        public final void failRejected$okhttp(@Nullable RejectedExecutionException rejectedExecutionException) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
            interruptedIOException.initCause(rejectedExecutionException);
            this.this$0.noMoreExchanges$okhttp(interruptedIOException);
            this.responseCallback.onFailure(this.this$0, interruptedIOException);
        }

        @NotNull
        public final RealCall getCall() {
            return this.this$0;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        @NotNull
        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall other) {
            g0.p(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            boolean z5;
            IOException e6;
            OkHttpClient client;
            String str = "OkHttp " + this.this$0.redactedUrl$okhttp();
            RealCall realCall = this.this$0;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                realCall.timeout.enter();
                try {
                    try {
                        z5 = true;
                    } catch (IOException e7) {
                        e6 = e7;
                        z5 = false;
                    } catch (Throwable th2) {
                        th = th2;
                        z5 = false;
                    }
                    try {
                        this.responseCallback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                        client = realCall.getClient();
                    } catch (IOException e8) {
                        e6 = e8;
                        if (z5) {
                            Platform.Companion.get().log("Callback failure for " + realCall.toLoggableString(), 4, e6);
                        } else {
                            this.responseCallback.onFailure(realCall, e6);
                        }
                        client = realCall.getClient();
                        client.dispatcher().finished$okhttp(this);
                    } catch (Throwable th3) {
                        th = th3;
                        realCall.cancel();
                        if (!z5) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.initCause(th);
                            this.responseCallback.onFailure(realCall, iOException);
                        }
                        if (!(th instanceof InterruptedException)) {
                            throw th;
                        }
                        Thread.currentThread().interrupt();
                        client = realCall.getClient();
                        client.dispatcher().finished$okhttp(this);
                    }
                    client.dispatcher().finished$okhttp(this);
                } catch (Throwable th4) {
                    realCall.getClient().dispatcher().finished$okhttp(this);
                    throw th4;
                }
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CallReference extends WeakReference<RealCall> {

        @Nullable
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(@NotNull RealCall referent, @Nullable Object obj) {
            super(referent);
            g0.p(referent, "referent");
            this.callStackTrace = obj;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z5) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            n1 n1Var = n1.f44123a;
        }
        if (z5 && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException iOException) {
        boolean z5;
        synchronized (this) {
            try {
                z5 = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen && !this.socketSinkOpen && !this.socketSourceOpen) {
                        z5 = true;
                    }
                }
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z5 ? callDone(iOException) : iOException;
    }

    @Override // okhttp3.Call
    @Nullable
    public <T> T tag(@NotNull d<T> type) {
        g0.p(type, "type");
        return (T) l3.a.e(type).cast(this.tags.get().get(type));
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(@NotNull OkHttpClient client, @NotNull Request originalRequest, boolean z5) {
        g0.p(client, "client");
        g0.p(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z5;
        this.connectionPool = client.connectionPool().getDelegate$okhttp();
        this.eventListener = client.eventListenerFactory().create(this);
        ?? r5 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        r5.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r5;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList<>();
        this.tags = new AtomicReference<>(originalRequest.getTags$okhttp());
    }

    private final IOException callDone(IOException iOException) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z5 = _UtilJvmKt.assertionsEnabled;
        if (z5 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z5 && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
                realConnection.getConnectionListener$okhttp().connectionReleased(realConnection, this);
                if (releaseConnectionNoEvents$okhttp != null) {
                    realConnection.getConnectionListener$okhttp().connectionClosed(realConnection);
                }
            } else if (releaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException timeoutExit = timeoutExit(iOException);
        if (iOException == null) {
            this.eventListener.callEnd(this);
            return timeoutExit;
        }
        EventListener eventListener = this.eventListener;
        g0.m(timeoutExit);
        eventListener.callFailed(this, timeoutExit);
        return timeoutExit;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public static /* synthetic */ IOException messageDone$okhttp$default(RealCall realCall, Exchange exchange, boolean z5, boolean z6, boolean z7, boolean z8, IOException iOException, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            z6 = false;
        }
        if ((i6 & 8) != 0) {
            z7 = false;
        }
        if ((i6 & 16) != 0) {
            z8 = false;
        }
        return realCall.messageDone$okhttp(exchange, z5, z6, z7, z8, iOException);
    }

    private final IOException timeoutExit(IOException iOException) {
        if (this.timeoutEarlyExit || !exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection connection) {
        g0.p(connection, "connection");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(connection)) {
            if (this.connection != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        Iterator<RoutePlanner.Plan> it = this.plansToCancel.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().mo289cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    @NotNull
    public Call clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public void enqueue(@NotNull Callback responseCallback) {
        g0.p(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    public final void enterNetworkInterceptorExchange(@NotNull Request request, boolean z5, @NotNull RealInterceptorChain chain) {
        g0.p(request, "request");
        g0.p(chain, "chain");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
            n1 n1Var = n1.f44123a;
        }
        if (z5) {
            RealRoutePlanner realRoutePlanner = new RealRoutePlanner(this.client.getTaskRunner$okhttp(), this.connectionPool, this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), this.client.pingIntervalMillis(), this.client.retryOnConnectionFailure(), this.client.fastFallback(), this.client.address(request.url()), this.client.getRouteDatabase$okhttp(), this, request);
            this.exchangeFinder = this.client.fastFallback() ? new FastFallbackExchangeFinder(realRoutePlanner, this.client.getTaskRunner$okhttp()) : new SequentialExchangeFinder(realRoutePlanner);
        }
    }

    @Override // okhttp3.Call
    @NotNull
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @NotNull
    public final CopyOnWriteArrayList<RoutePlanner.Plan> getPlansToCancel$okhttp() {
        return this.plansToCancel;
    }

    @NotNull
    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        ArrayList arrayList = new ArrayList();
        f0.s0(arrayList, this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.cache()));
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            f0.s0(arrayList, this.client.networkInterceptors());
        }
        arrayList.add(CallServerInterceptor.INSTANCE);
        boolean z5 = false;
        try {
            try {
                Response proceed = new RealInterceptorChain(this, arrayList, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
                if (isCanceled()) {
                    _UtilCommonKt.closeQuietly(proceed);
                    throw new IOException("Canceled");
                }
                noMoreExchanges$okhttp(null);
                return proceed;
            } catch (IOException e6) {
                z5 = true;
                IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e6);
                g0.n(noMoreExchanges$okhttp, "null cannot be cast to non-null type kotlin.Throwable");
                throw noMoreExchanges$okhttp;
            }
        } catch (Throwable th) {
            if (!z5) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain chain) {
        g0.p(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.responseBodyOpen || this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
            n1 n1Var = n1.f44123a;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        g0.m(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find().newCodec$okhttp(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:54:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:31:0x005c, B:7:0x001c, B:47:0x0022, B:50:0x0028), top: B:53:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:54:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:31:0x005c, B:7:0x001c, B:47:0x0022, B:50:0x0028), top: B:53:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:54:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:31:0x005c, B:7:0x001c, B:47:0x0022, B:50:0x0028), top: B:53:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:54:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:31:0x005c, B:7:0x001c, B:47:0x0022, B:50:0x0028), top: B:53:0x0013 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.IOException messageDone$okhttp(@org.jetbrains.annotations.NotNull okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, boolean r6, boolean r7, @org.jetbrains.annotations.Nullable java.io.IOException r8) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.g0.p(r3, r0)
            okhttp3.internal.connection.Exchange r0 = r2.exchange
            boolean r3 = kotlin.jvm.internal.g0.g(r3, r0)
            if (r3 != 0) goto Lf
            goto L72
        Lf:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L1a
            boolean r0 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L2c
            goto L1a
        L18:
            r3 = move-exception
            goto L73
        L1a:
            if (r5 == 0) goto L20
            boolean r0 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L2c
        L20:
            if (r7 == 0) goto L26
            boolean r0 = r2.socketSinkOpen     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L2c
        L26:
            if (r6 == 0) goto L5b
            boolean r0 = r2.socketSourceOpen     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L5b
        L2c:
            if (r4 == 0) goto L30
            r2.requestBodyOpen = r3     // Catch: java.lang.Throwable -> L18
        L30:
            if (r5 == 0) goto L34
            r2.responseBodyOpen = r3     // Catch: java.lang.Throwable -> L18
        L34:
            if (r7 == 0) goto L38
            r2.socketSinkOpen = r3     // Catch: java.lang.Throwable -> L18
        L38:
            if (r6 == 0) goto L3c
            r2.socketSourceOpen = r3     // Catch: java.lang.Throwable -> L18
        L3c:
            boolean r4 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L18
            r5 = 1
            if (r4 != 0) goto L4f
            boolean r4 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4f
            boolean r4 = r2.socketSinkOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4f
            boolean r4 = r2.socketSourceOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4f
            r4 = 1
            goto L50
        L4f:
            r4 = 0
        L50:
            if (r4 == 0) goto L57
            boolean r6 = r2.expectMoreExchanges     // Catch: java.lang.Throwable -> L18
            if (r6 != 0) goto L57
            r3 = 1
        L57:
            r1 = r4
            r4 = r3
            r3 = r1
            goto L5c
        L5b:
            r4 = 0
        L5c:
            kotlin.n1 r5 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L18
            monitor-exit(r2)
            if (r3 == 0) goto L6b
            r3 = 0
            r2.exchange = r3
            okhttp3.internal.connection.RealConnection r3 = r2.connection
            if (r3 == 0) goto L6b
            r3.incrementSuccessCount$okhttp()
        L6b:
            if (r4 == 0) goto L72
            java.io.IOException r3 = r2.callDone(r8)
            return r3
        L72:
            return r8
        L73:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        g0.m(realConnection);
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (g0.g(it.next().get(), this)) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        calls.remove(i6);
        this.connection = null;
        if (calls.isEmpty()) {
            realConnection.setIdleAtNs(System.nanoTime());
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    @Override // okhttp3.Call
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        Exchange exchange = this.exchange;
        if (exchange == null || !exchange.getHasFailure$okhttp()) {
            return false;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        g0.m(exchangeFinder);
        RoutePlanner routePlanner = exchangeFinder.getRoutePlanner();
        Exchange exchange2 = this.exchange;
        return routePlanner.hasNext(exchange2 != null ? exchange2.getConnection$okhttp() : null);
    }

    @Override // okhttp3.Call
    @Nullable
    public <T> T tag(@NotNull Class<? extends T> type) {
        g0.p(type, "type");
        return (T) tag(l3.a.i(type));
    }

    @Override // okhttp3.Call
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    public final void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        exit();
    }

    @Override // okhttp3.Call
    @NotNull
    public <T> T tag(@NotNull d<T> type, @NotNull Function0<? extends T> computeIfAbsent) {
        g0.p(type, "type");
        g0.p(computeIfAbsent, "computeIfAbsent");
        return (T) TagsKt.computeIfAbsent(this.tags, type, computeIfAbsent);
    }

    public final void upgradeToSocket() {
        timeoutEarlyExit();
        synchronized (this) {
            if (this.exchange != null) {
                if (!this.socketSinkOpen && !this.socketSourceOpen) {
                    if (!this.requestBodyOpen) {
                        if (this.responseBodyOpen) {
                            this.responseBodyOpen = false;
                            this.socketSinkOpen = true;
                            this.socketSourceOpen = true;
                            n1 n1Var = n1.f44123a;
                        } else {
                            throw new IllegalStateException("Check failed.");
                        }
                    } else {
                        throw new IllegalStateException("Check failed.");
                    }
                } else {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }
    }

    @Override // okhttp3.Call
    @NotNull
    public <T> T tag(@NotNull Class<T> type, @NotNull Function0<? extends T> computeIfAbsent) {
        g0.p(type, "type");
        g0.p(computeIfAbsent, "computeIfAbsent");
        return (T) TagsKt.computeIfAbsent(this.tags, l3.a.i(type), computeIfAbsent);
    }
}
