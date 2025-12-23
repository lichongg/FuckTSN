package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Call;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UrlWorker extends BasicWorker<UrlDownload> {

    /* renamed from: f, reason: collision with root package name */
    private Call f56656f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.network.download.BasicWorker
    public Response a(UrlDownload urlDownload) {
        Call call = new Call(urlDownload);
        this.f56656f = call;
        return call.execute();
    }

    @Override // xyz.adscope.common.network.download.BasicWorker
    public void cancel() {
        Call call = this.f56656f;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.f56656f.asyncCancel();
    }

    UrlWorker(UrlDownload urlDownload) {
        super(urlDownload);
    }
}
