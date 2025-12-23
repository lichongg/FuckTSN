package xyz.adscope.common.network;

import java.io.OutputStream;
import java.util.concurrent.Executor;
import xyz.adscope.common.network.Content;
import xyz.adscope.common.network.util.ProgressOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class BaseContent<T extends Content> implements Content {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar<T> f56454a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AsyncProgressBar<T extends Content> implements ProgressBar<T> {

        /* renamed from: a, reason: collision with root package name */
        private final ProgressBar<T> f56455a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f56456b = Kalle.getConfig().getMainExecutor();

        @Override // xyz.adscope.common.network.ProgressBar
        public void progress(final T t5, final int i6) {
            this.f56456b.execute(new Runnable() { // from class: xyz.adscope.common.network.BaseContent.AsyncProgressBar.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncProgressBar.this.f56455a.progress(t5, i6);
                }
            });
        }

        public AsyncProgressBar(ProgressBar<T> progressBar) {
            this.f56455a = progressBar;
        }
    }

    protected abstract void a(OutputStream outputStream);

    public void onProgress(ProgressBar<T> progressBar) {
        this.f56454a = new AsyncProgressBar(progressBar);
    }

    @Override // xyz.adscope.common.network.Content
    public final void writeTo(OutputStream outputStream) {
        if (this.f56454a != null) {
            a(new ProgressOutputStream(outputStream, this, this.f56454a));
        } else {
            a(outputStream);
        }
    }
}
