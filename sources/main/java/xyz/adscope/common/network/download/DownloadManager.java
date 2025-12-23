package xyz.adscope.common.network.download;

import java.util.concurrent.Executor;
import xyz.adscope.common.network.CancelerManager;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.Kalle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DownloadManager {

    /* renamed from: c, reason: collision with root package name */
    private static DownloadManager f56632c;

    /* renamed from: a, reason: collision with root package name */
    private final Executor f56633a = Kalle.getConfig().getWorkExecutor();

    /* renamed from: b, reason: collision with root package name */
    private final CancelerManager f56634b = new CancelerManager();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AsyncCallback implements Callback {

        /* renamed from: a, reason: collision with root package name */
        private final Callback f56639a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f56640b = Kalle.getConfig().getMainExecutor();

        @Override // xyz.adscope.common.network.download.Callback
        public void onCancel() {
            if (this.f56639a == null) {
                return;
            }
            this.f56640b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56639a.onCancel();
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onEnd() {
            if (this.f56639a == null) {
                return;
            }
            this.f56640b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56639a.onEnd();
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onException(final Exception exc) {
            if (this.f56639a == null) {
                return;
            }
            this.f56640b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56639a.onException(exc);
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onFinish(final String str) {
            if (this.f56639a == null) {
                return;
            }
            this.f56640b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56639a.onFinish(str);
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onStart() {
            if (this.f56639a == null) {
                return;
            }
            this.f56640b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56639a.onStart();
                }
            });
        }

        AsyncCallback(Callback callback) {
            this.f56639a = callback;
        }
    }

    public Canceller perform(final UrlDownload urlDownload, Callback callback) {
        Work work = new Work(new UrlWorker(urlDownload), new AsyncCallback(callback) { // from class: xyz.adscope.common.network.download.DownloadManager.1
            @Override // xyz.adscope.common.network.download.DownloadManager.AsyncCallback, xyz.adscope.common.network.download.Callback
            public void onEnd() {
                super.onEnd();
                DownloadManager.this.f56634b.removeCancel(urlDownload);
            }
        });
        this.f56634b.addCancel(urlDownload, work);
        this.f56633a.execute(work);
        return work;
    }

    public static DownloadManager getInstance() {
        if (f56632c == null) {
            synchronized (DownloadManager.class) {
                try {
                    if (f56632c == null) {
                        f56632c = new DownloadManager();
                    }
                } finally {
                }
            }
        }
        return f56632c;
    }

    public void cancel(Object obj) {
        this.f56634b.cancel(obj);
    }

    private DownloadManager() {
    }

    public String perform(UrlDownload urlDownload) {
        return new UrlWorker(urlDownload).call();
    }

    public Canceller perform(final BodyDownload bodyDownload, Callback callback) {
        Work work = new Work(new BodyWorker(bodyDownload), new AsyncCallback(callback) { // from class: xyz.adscope.common.network.download.DownloadManager.2
            @Override // xyz.adscope.common.network.download.DownloadManager.AsyncCallback, xyz.adscope.common.network.download.Callback
            public void onEnd() {
                super.onEnd();
                DownloadManager.this.f56634b.removeCancel(bodyDownload);
            }
        });
        this.f56634b.addCancel(bodyDownload, work);
        this.f56633a.execute(work);
        return work;
    }

    public String perform(BodyDownload bodyDownload) {
        return new BodyWorker(bodyDownload).call();
    }
}
