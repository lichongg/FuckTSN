package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dispatcher.kt\nokhttp3/Dispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,299:1\n1#2:300\n1563#3:301\n1634#3,3:302\n1563#3:306\n1634#3,3:307\n242#4:305\n242#4:310\n*S KotlinDebug\n*F\n+ 1 Dispatcher.kt\nokhttp3/Dispatcher\n*L\n279#1:301\n279#1:302,3\n283#1:306\n283#1:307,3\n279#1:305\n283#1:310\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Dispatcher {

    @Nullable
    private ExecutorService executorServiceOrNull;

    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;

    @NotNull
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;

    @NotNull
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;

    @NotNull
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    public final synchronized void cancelAll() {
        try {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            g0.o(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().getCall().cancel();
            }
            Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
            g0.o(it2, "iterator(...)");
            while (it2.hasNext()) {
                it2.next().getCall().cancel();
            }
            Iterator<RealCall> it3 = this.runningSyncCalls.iterator();
            g0.o(it3, "iterator(...)");
            while (it3.hasNext()) {
                it3.next().cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean executed$okhttp(@NotNull RealCall call) {
        g0.p(call, "call");
        return this.runningSyncCalls.add(call);
    }

    @JvmName(name = "executorService")
    @NotNull
    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        try {
            if (this.executorServiceOrNull == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _UtilJvmKt.threadFactory(_UtilJvmKt.okHttpName + " Dispatcher", false));
            }
            executorService = this.executorServiceOrNull;
            g0.m(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall call) {
        g0.p(call, "call");
        promoteAndExecute$default(this, null, null, call, 3, null);
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @NotNull
    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
            ArrayList arrayList = new ArrayList(f0.d0(arrayDeque, 10));
            Iterator<T> it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
            g0.o(unmodifiableList, "unmodifiableList(...)");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    @NotNull
    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        try {
            ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
            ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
            ArrayList arrayList = new ArrayList(f0.d0(arrayDeque2, 10));
            Iterator<T> it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getCall());
            }
            unmodifiableList = Collections.unmodifiableList(f0.I4(arrayDeque, arrayList));
            g0.o(unmodifiableList, "unmodifiableList(...)");
        } catch (Throwable th) {
            throw th;
        }
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i6) {
        if (i6 < 1) {
            throw new IllegalArgumentException(("max < 1: " + i6).toString());
        }
        synchronized (this) {
            this.maxRequests = i6;
            n1 n1Var = n1.f44123a;
        }
        promoteAndExecute$default(this, null, null, null, 7, null);
    }

    public final void setMaxRequestsPerHost(int i6) {
        if (i6 < 1) {
            throw new IllegalArgumentException(("max < 1: " + i6).toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = i6;
            n1 n1Var = n1.f44123a;
        }
        promoteAndExecute$default(this, null, null, null, 7, null);
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (g0.g(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        g0.o(it2, "iterator(...)");
        while (it2.hasNext()) {
            RealCall.AsyncCall next2 = it2.next();
            if (g0.g(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    static /* synthetic */ void promoteAndExecute$default(Dispatcher dispatcher, RealCall.AsyncCall asyncCall, RealCall realCall, RealCall.AsyncCall asyncCall2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            asyncCall = null;
        }
        if ((i6 & 2) != 0) {
            realCall = null;
        }
        if ((i6 & 4) != 0) {
            asyncCall2 = null;
        }
        dispatcher.promoteAndExecute(asyncCall, realCall, asyncCall2);
    }

    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall call) {
        g0.p(call, "call");
        promoteAndExecute$default(this, call, null, null, 6, null);
    }

    public final void finished$okhttp(@NotNull RealCall call) {
        g0.p(call, "call");
        promoteAndExecute$default(this, null, call, null, 5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void promoteAndExecute(RealCall.AsyncCall asyncCall, RealCall realCall, RealCall.AsyncCall asyncCall2) {
        final Runnable runnable;
        Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$Effects;
        RealCall.AsyncCall findExistingCallWithHost;
        _UtilJvmKt.assertLockNotHeld(this);
        boolean isShutdown = executorService().isShutdown();
        synchronized (this) {
            if (realCall != null) {
                try {
                    if (!this.runningSyncCalls.remove(realCall)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (asyncCall2 != null) {
                asyncCall2.getCallsPerHost().decrementAndGet();
                if (!this.runningAsyncCalls.remove(asyncCall2)) {
                    throw new IllegalStateException("Call wasn't in-flight!");
                }
            }
            if (asyncCall != null) {
                this.readyAsyncCalls.add(asyncCall);
                if (!asyncCall.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.getHost())) != null) {
                    asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
                }
            }
            if ((realCall != null || asyncCall2 != null) && ((isShutdown || this.runningAsyncCalls.isEmpty()) && this.runningSyncCalls.isEmpty())) {
                runnable = this.idleCallback;
            } else {
                runnable = null;
            }
            if (isShutdown) {
                final List a6 = f0.a6(this.readyAsyncCalls);
                this.readyAsyncCalls.clear();
                dispatcher$promoteAndExecute$Effects = new Object(a6, runnable) { // from class: okhttp3.Dispatcher$promoteAndExecute$Effects
                    private final List<RealCall.AsyncCall> callsToExecute;
                    private final Runnable idleCallbackToRun;

                    {
                        g0.p(a6, "callsToExecute");
                        this.callsToExecute = a6;
                        this.idleCallbackToRun = runnable;
                    }

                    public final List<RealCall.AsyncCall> getCallsToExecute() {
                        return this.callsToExecute;
                    }

                    public final Runnable getIdleCallbackToRun() {
                        return this.idleCallbackToRun;
                    }
                };
            } else {
                final ArrayList arrayList = new ArrayList();
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                g0.o(it, "iterator(...)");
                while (it.hasNext()) {
                    RealCall.AsyncCall next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    }
                    if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        next.getCallsPerHost().incrementAndGet();
                        g0.m(next);
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                dispatcher$promoteAndExecute$Effects = new Object(arrayList, runnable) { // from class: okhttp3.Dispatcher$promoteAndExecute$Effects
                    private final List<RealCall.AsyncCall> callsToExecute;
                    private final Runnable idleCallbackToRun;

                    {
                        g0.p(arrayList, "callsToExecute");
                        this.callsToExecute = arrayList;
                        this.idleCallbackToRun = runnable;
                    }

                    public final List<RealCall.AsyncCall> getCallsToExecute() {
                        return this.callsToExecute;
                    }

                    public final Runnable getIdleCallbackToRun() {
                        return this.idleCallbackToRun;
                    }
                };
            }
        }
        int size = dispatcher$promoteAndExecute$Effects.getCallsToExecute().size();
        boolean z5 = true;
        for (int i6 = 0; i6 < size; i6++) {
            RealCall.AsyncCall asyncCall3 = dispatcher$promoteAndExecute$Effects.getCallsToExecute().get(i6);
            if (asyncCall3 == asyncCall) {
                z5 = false;
            } else {
                asyncCall3.getCall().getEventListener$okhttp().dispatcherQueueEnd(asyncCall3.getCall(), this);
            }
            if (isShutdown) {
                RealCall.AsyncCall.failRejected$okhttp$default(asyncCall3, null, 1, null);
            } else {
                asyncCall3.executeOn(executorService());
            }
        }
        if (z5 && asyncCall != null) {
            asyncCall.getCall().getEventListener$okhttp().dispatcherQueueStart(asyncCall.getCall(), this);
        }
        Runnable idleCallbackToRun = dispatcher$promoteAndExecute$Effects.getIdleCallbackToRun();
        if (idleCallbackToRun != null) {
            idleCallbackToRun.run();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "executorService", imports = {}))
    @JvmName(name = "-deprecated_executorService")
    @NotNull
    /* renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m187deprecated_executorService() {
        return executorService();
    }

    public Dispatcher(@Nullable ExecutorService executorService) {
        this();
        this.executorServiceOrNull = executorService;
    }
}
