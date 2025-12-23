package okhttp3.internal.connection;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g0;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;

    @NotNull
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos;

    @NotNull
    private final RoutePlanner routePlanner;

    @NotNull
    private final TaskRunner taskRunner;

    @NotNull
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0002, B:5:0x000a, B:11:0x0020, B:13:0x002a, B:20:0x0054, B:23:0x005d, B:25:0x0063, B:27:0x0070, B:28:0x0078, B:31:0x007e, B:34:0x008a, B:36:0x0090, B:39:0x0096, B:40:0x009a, B:42:0x009e, B:43:0x009f, B:46:0x00a5, B:54:0x0049, B:56:0x00b2, B:57:0x00b9), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:3:0x0002, B:5:0x000a, B:11:0x0020, B:13:0x002a, B:20:0x0054, B:23:0x005d, B:25:0x0063, B:27:0x0070, B:28:0x0078, B:31:0x007e, B:34:0x008a, B:36:0x0090, B:39:0x0096, B:40:0x009a, B:42:0x009e, B:43:0x009f, B:46:0x00a5, B:54:0x0049, B:56:0x00b2, B:57:0x00b9), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0002 A[SYNTHETIC] */
    @Override // okhttp3.internal.connection.ExchangeFinder
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RealConnection find() {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r2 = r9.tcpConnectsInFlight     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L20
            okhttp3.internal.connection.RoutePlanner r2 = r9.getRoutePlanner()     // Catch: java.lang.Throwable -> L1d
            r3 = 1
            boolean r2 = okhttp3.internal.connection.c.a(r2, r0, r3, r0)     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L16
            goto L20
        L16:
            r9.cancelInFlightConnects()
            kotlin.jvm.internal.g0.m(r1)
            throw r1
        L1d:
            r0 = move-exception
            goto Lba
        L20:
            okhttp3.internal.connection.RoutePlanner r2 = r9.getRoutePlanner()     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.isCanceled()     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto Lb2
            okhttp3.internal.concurrent.TaskRunner r2 = r9.taskRunner     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.concurrent.TaskRunner$Backend r2 = r2.getBackend()     // Catch: java.lang.Throwable -> L1d
            long r2 = r2.nanoTime()     // Catch: java.lang.Throwable -> L1d
            long r4 = r9.nextTcpConnectAtNanos     // Catch: java.lang.Throwable -> L1d
            long r4 = r4 - r2
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r6 = r9.tcpConnectsInFlight     // Catch: java.lang.Throwable -> L1d
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r6 != 0) goto L49
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L46
            goto L49
        L46:
            r5 = r4
            r4 = r0
            goto L52
        L49:
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r9.launchTcpConnect()     // Catch: java.lang.Throwable -> L1d
            long r5 = r9.connectDelayNanos     // Catch: java.lang.Throwable -> L1d
            long r2 = r2 + r5
            r9.nextTcpConnectAtNanos = r2     // Catch: java.lang.Throwable -> L1d
        L52:
            if (r4 != 0) goto L5d
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r9.awaitTcpConnect(r5, r2)     // Catch: java.lang.Throwable -> L1d
            if (r4 != 0) goto L5d
            goto L2
        L5d:
            boolean r2 = r4.isSuccess()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L8a
            r9.cancelInFlightConnects()     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.isReady()     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L78
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r2.mo294connectTlsEtc()     // Catch: java.lang.Throwable -> L1d
        L78:
            boolean r2 = r4.isSuccess()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L8a
            okhttp3.internal.connection.RoutePlanner$Plan r0 = r4.getPlan()     // Catch: java.lang.Throwable -> L1d
            okhttp3.internal.connection.RealConnection r0 = r0.mo290handleSuccess()     // Catch: java.lang.Throwable -> L1d
            r9.cancelInFlightConnects()
            return r0
        L8a:
            java.lang.Throwable r2 = r4.getThrowable()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L9f
            boolean r3 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L1d
            if (r3 == 0) goto L9e
            if (r1 != 0) goto L9a
            java.io.IOException r2 = (java.io.IOException) r2     // Catch: java.lang.Throwable -> L1d
            r1 = r2
            goto L9f
        L9a:
            kotlin.l.a(r1, r2)     // Catch: java.lang.Throwable -> L1d
            goto L9f
        L9e:
            throw r2     // Catch: java.lang.Throwable -> L1d
        L9f:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getNextPlan()     // Catch: java.lang.Throwable -> L1d
            if (r2 == 0) goto L2
            okhttp3.internal.connection.RoutePlanner r3 = r9.getRoutePlanner()     // Catch: java.lang.Throwable -> L1d
            kotlin.collections.m r3 = r3.getDeferredPlans()     // Catch: java.lang.Throwable -> L1d
            r3.addFirst(r2)     // Catch: java.lang.Throwable -> L1d
            goto L2
        Lb2:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L1d
            throw r0     // Catch: java.lang.Throwable -> L1d
        Lba:
            r9.cancelInFlightConnects()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.FastFallbackExchangeFinder.find():okhttp3.internal.connection.RealConnection");
    }

    public FastFallbackExchangeFinder(@NotNull RoutePlanner routePlanner, @NotNull TaskRunner taskRunner) {
        g0.p(routePlanner, "routePlanner");
        g0.p(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long j6, TimeUnit timeUnit) {
        RoutePlanner.ConnectResult poll;
        if (this.tcpConnectsInFlight.isEmpty() || (poll = this.connectResults.poll(j6, timeUnit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(poll.getPlan());
        return poll;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.mo289cancel();
            RoutePlanner.Plan mo291retry = next.mo291retry();
            if (mo291retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(mo291retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        final RoutePlanner.Plan failedPlan;
        if (c.a(getRoutePlanner(), null, 1, null)) {
            try {
                failedPlan = getRoutePlanner().plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            if (failedPlan.isReady()) {
                return new RoutePlanner.ConnectResult(failedPlan, null, null, 6, null);
            }
            if (failedPlan instanceof FailedPlan) {
                return ((FailedPlan) failedPlan).getResult();
            }
            this.tcpConnectsInFlight.add(failedPlan);
            final String str = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
            TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(str) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder$launchTcpConnect$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    RoutePlanner.ConnectResult connectResult;
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    BlockingQueue blockingQueue;
                    try {
                        connectResult = failedPlan.mo293connectTcp();
                    } catch (Throwable th2) {
                        connectResult = new RoutePlanner.ConnectResult(failedPlan, null, th2, 2, null);
                    }
                    copyOnWriteArrayList = this.tcpConnectsInFlight;
                    if (!copyOnWriteArrayList.contains(failedPlan)) {
                        return -1L;
                    }
                    blockingQueue = this.connectResults;
                    blockingQueue.put(connectResult);
                    return -1L;
                }
            }, 0L, 2, null);
        }
        return null;
    }
}
