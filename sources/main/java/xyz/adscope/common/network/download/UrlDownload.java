package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.UrlRequest;
import xyz.adscope.common.network.download.Download;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UrlDownload extends UrlRequest implements Download {

    /* renamed from: j, reason: collision with root package name */
    private final String f56648j;

    /* renamed from: k, reason: collision with root package name */
    private final String f56649k;

    /* renamed from: l, reason: collision with root package name */
    private final Download.ProgressBar f56650l;

    /* renamed from: m, reason: collision with root package name */
    private final Download.Policy f56651m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.download.UrlDownload$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Api extends UrlRequest.Api<Api> {

        /* renamed from: j, reason: collision with root package name */
        private String f56652j;

        /* renamed from: k, reason: collision with root package name */
        private String f56653k;

        /* renamed from: l, reason: collision with root package name */
        private Download.ProgressBar f56654l;

        /* renamed from: m, reason: collision with root package name */
        private Download.Policy f56655m;

        /* synthetic */ Api(Url url, RequestMethod requestMethod, AnonymousClass1 anonymousClass1) {
            this(url, requestMethod);
        }

        public String perform() {
            return new UrlWorker(new UrlDownload(this, null)).call();
        }

        private Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api directory(String str) {
            this.f56652j = str;
            return this;
        }

        public Api fileName(String str) {
            this.f56653k = str;
            return this;
        }

        public Api onProgress(Download.ProgressBar progressBar) {
            this.f56654l = progressBar;
            return this;
        }

        public Canceller perform(Callback callback) {
            return DownloadManager.getInstance().perform(new UrlDownload(this, null), callback);
        }

        public Api policy(Download.Policy policy) {
            this.f56655m = policy;
            return this;
        }
    }

    /* synthetic */ UrlDownload(Api api, AnonymousClass1 anonymousClass1) {
        this(api);
    }

    private UrlDownload(Api api) {
        super(api);
        this.f56648j = api.f56652j;
        this.f56649k = api.f56653k;
        this.f56650l = api.f56654l == null ? Download.ProgressBar.DEFAULT : api.f56654l;
        this.f56651m = api.f56655m == null ? Download.Policy.DEFAULT : api.f56655m;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod, null);
    }

    @Override // xyz.adscope.common.network.download.Download
    public String directory() {
        return this.f56648j;
    }

    @Override // xyz.adscope.common.network.download.Download
    public String fileName() {
        return this.f56649k;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.Policy policy() {
        return this.f56651m;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.ProgressBar progressBar() {
        return this.f56650l;
    }
}
