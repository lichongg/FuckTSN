package xyz.adscope.common.network.simple;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.simple.SimpleRequest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class Work<T extends SimpleRequest, S, F> extends FutureTask<SimpleResponse<S, F>> implements Canceller {

    /* renamed from: a, reason: collision with root package name */
    private BasicWorker<T, S, F> f56712a;

    /* renamed from: b, reason: collision with root package name */
    private final Callback<S, F> f56713b;

    @Override // xyz.adscope.common.network.Canceller
    public void cancel() {
        cancel(true);
        this.f56712a.cancel();
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.f56713b.onResponse(get());
        } catch (CancellationException unused) {
            this.f56713b.onCancel();
        } catch (ExecutionException e6) {
            Throwable cause = e6.getCause();
            if (isCancelled()) {
                this.f56713b.onCancel();
            } else if (cause == null || !(cause instanceof Exception)) {
                this.f56713b.onException(new Exception(cause));
            } else {
                this.f56713b.onException((Exception) cause);
            }
        } catch (Exception e7) {
            if (isCancelled()) {
                this.f56713b.onCancel();
            } else {
                this.f56713b.onException(e7);
            }
        }
        this.f56713b.onEnd();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f56713b.onStart();
        super.run();
    }

    Work(BasicWorker<T, S, F> basicWorker, Callback<S, F> callback) {
        super(basicWorker);
        this.f56712a = basicWorker;
        this.f56713b = callback;
    }
}
