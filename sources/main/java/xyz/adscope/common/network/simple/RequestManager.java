package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import xyz.adscope.common.network.CancelerManager;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.Kalle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RequestManager {

    /* renamed from: c, reason: collision with root package name */
    private static RequestManager f56673c;

    /* renamed from: a, reason: collision with root package name */
    private final Executor f56674a = Kalle.getConfig().getWorkExecutor();

    /* renamed from: b, reason: collision with root package name */
    private final CancelerManager f56675b = new CancelerManager();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AsyncCallback<S, F> extends Callback<S, F> {

        /* renamed from: a, reason: collision with root package name */
        private final Callback<S, F> f56680a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f56681b = Kalle.getConfig().getMainExecutor();

        @Override // xyz.adscope.common.network.simple.Callback
        public Type getFailed() {
            return this.f56680a.getFailed();
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public Type getSucceed() {
            return this.f56680a.getSucceed();
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onCancel() {
            if (this.f56680a == null) {
                return;
            }
            this.f56681b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56680a.onCancel();
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onEnd() {
            if (this.f56680a == null) {
                return;
            }
            this.f56681b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56680a.onEnd();
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onException(final Exception exc) {
            if (this.f56680a == null) {
                return;
            }
            this.f56681b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56680a.onException(exc);
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onResponse(final SimpleResponse<S, F> simpleResponse) {
            if (this.f56680a == null) {
                return;
            }
            this.f56681b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56680a.onResponse(simpleResponse);
                }
            });
        }

        @Override // xyz.adscope.common.network.simple.Callback
        public void onStart() {
            if (this.f56680a == null) {
                return;
            }
            this.f56681b.execute(new Runnable() { // from class: xyz.adscope.common.network.simple.RequestManager.AsyncCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f56680a.onStart();
                }
            });
        }

        AsyncCallback(Callback<S, F> callback) {
            this.f56680a = callback;
        }
    }

    public <S, F> Canceller perform(final SimpleUrlRequest simpleUrlRequest, Callback<S, F> callback) {
        Work work = new Work(new UrlWorker(simpleUrlRequest, callback.getSucceed(), callback.getFailed()), new AsyncCallback<S, F>(callback) { // from class: xyz.adscope.common.network.simple.RequestManager.1
            @Override // xyz.adscope.common.network.simple.RequestManager.AsyncCallback, xyz.adscope.common.network.simple.Callback
            public void onEnd() {
                super.onEnd();
                RequestManager.this.f56675b.removeCancel(simpleUrlRequest);
            }
        });
        this.f56675b.addCancel(simpleUrlRequest, work);
        this.f56674a.execute(work);
        return work;
    }

    public static RequestManager getInstance() {
        if (f56673c == null) {
            synchronized (RequestManager.class) {
                try {
                    if (f56673c == null) {
                        f56673c = new RequestManager();
                    }
                } finally {
                }
            }
        }
        return f56673c;
    }

    public void cancel(Object obj) {
        this.f56675b.cancel(obj);
    }

    private RequestManager() {
    }

    public <S, F> SimpleResponse<S, F> perform(SimpleUrlRequest simpleUrlRequest, Type type, Type type2) {
        return new UrlWorker(simpleUrlRequest, type, type2).call();
    }

    public <S, F> Canceller perform(final SimpleBodyRequest simpleBodyRequest, Callback<S, F> callback) {
        Work work = new Work(new BodyWorker(simpleBodyRequest, callback.getSucceed(), callback.getFailed()), new AsyncCallback<S, F>(callback) { // from class: xyz.adscope.common.network.simple.RequestManager.2
            @Override // xyz.adscope.common.network.simple.RequestManager.AsyncCallback, xyz.adscope.common.network.simple.Callback
            public void onEnd() {
                super.onEnd();
                RequestManager.this.f56675b.removeCancel(simpleBodyRequest);
            }
        });
        this.f56675b.addCancel(simpleBodyRequest, work);
        this.f56674a.execute(work);
        return work;
    }

    public <S, F> SimpleResponse<S, F> perform(SimpleBodyRequest simpleBodyRequest, Type type, Type type2) {
        return new BodyWorker(simpleBodyRequest, type, type2).call();
    }
}
