package xyz.adscope.common.network.simple;

import java.lang.reflect.Type;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Call;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class UrlWorker<S, F> extends BasicWorker<SimpleUrlRequest, S, F> {

    /* renamed from: g, reason: collision with root package name */
    private Call f56711g;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.network.simple.BasicWorker
    public Response a(SimpleUrlRequest simpleUrlRequest) {
        Call call = new Call(simpleUrlRequest);
        this.f56711g = call;
        return call.execute();
    }

    @Override // xyz.adscope.common.network.simple.BasicWorker
    public void cancel() {
        Call call = this.f56711g;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.f56711g.asyncCancel();
    }

    UrlWorker(SimpleUrlRequest simpleUrlRequest, Type type, Type type2) {
        super(simpleUrlRequest, type, type2);
    }
}
