package xyz.adscope.common.network.connect.http;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Call {

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f56573e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    private final Request f56574a;

    /* renamed from: b, reason: collision with root package name */
    private ConnectInterceptor f56575b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f56576c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f56577d;

    public void asyncCancel() {
        f56573e.execute(new Runnable() { // from class: xyz.adscope.common.network.connect.http.Call.1
            @Override // java.lang.Runnable
            public void run() {
                Call.this.cancel();
            }
        });
    }

    public void cancel() {
        if (this.f56577d) {
            return;
        }
        this.f56577d = true;
        ConnectInterceptor connectInterceptor = this.f56575b;
        if (connectInterceptor != null) {
            connectInterceptor.cancel();
        }
    }

    public Response execute() {
        if (this.f56577d) {
            throw new CancellationException("The request has been cancelled.");
        }
        this.f56576c = true;
        ArrayList arrayList = new ArrayList(Kalle.getConfig().getInterceptor());
        ConnectInterceptor connectInterceptor = new ConnectInterceptor();
        this.f56575b = connectInterceptor;
        arrayList.add(connectInterceptor);
        try {
            return new AppChain(arrayList, 0, this.f56574a, this).proceed(this.f56574a);
        } catch (Exception e6) {
            if (this.f56577d) {
                throw new CancellationException("The request has been cancelled.");
            }
            throw e6;
        }
    }

    public boolean isCanceled() {
        return this.f56577d;
    }

    public boolean isExecuted() {
        return this.f56576c;
    }

    public Call(Request request) {
        this.f56574a = request;
    }
}
