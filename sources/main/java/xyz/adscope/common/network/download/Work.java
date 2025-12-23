package xyz.adscope.common.network.download;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.download.Download;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Work<T extends Download> extends FutureTask<String> implements Canceller {

    /* renamed from: a, reason: collision with root package name */
    private BasicWorker<T> f56657a;

    /* renamed from: b, reason: collision with root package name */
    private final Callback f56658b;

    @Override // xyz.adscope.common.network.Canceller
    public void cancel() {
        cancel(true);
        this.f56657a.cancel();
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.f56658b.onFinish(get());
        } catch (CancellationException unused) {
            this.f56658b.onCancel();
        } catch (ExecutionException e6) {
            Throwable cause = e6.getCause();
            if (isCancelled()) {
                this.f56658b.onCancel();
            } else if (cause == null || !(cause instanceof Exception)) {
                this.f56658b.onException(new Exception(cause));
            } else {
                this.f56658b.onException((Exception) cause);
            }
        } catch (Exception e7) {
            if (isCancelled()) {
                this.f56658b.onCancel();
            } else {
                this.f56658b.onException(e7);
            }
        }
        this.f56658b.onEnd();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f56658b.onStart();
        super.run();
    }

    Work(BasicWorker<T> basicWorker, Callback callback) {
        super(basicWorker);
        this.f56657a = basicWorker;
        this.f56658b = callback;
    }
}
