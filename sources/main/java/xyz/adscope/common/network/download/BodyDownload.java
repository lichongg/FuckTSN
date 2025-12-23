package xyz.adscope.common.network.download;

import xyz.adscope.common.network.BodyRequest;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.download.Download;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BodyDownload extends BodyRequest implements Download {

    /* renamed from: l, reason: collision with root package name */
    private final String f56623l;

    /* renamed from: m, reason: collision with root package name */
    private final String f56624m;

    /* renamed from: n, reason: collision with root package name */
    private final Download.ProgressBar f56625n;

    /* renamed from: o, reason: collision with root package name */
    private final Download.Policy f56626o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.download.BodyDownload$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Api extends BodyRequest.Api<Api> {

        /* renamed from: l, reason: collision with root package name */
        private String f56627l;

        /* renamed from: m, reason: collision with root package name */
        private String f56628m;

        /* renamed from: n, reason: collision with root package name */
        private Download.ProgressBar f56629n;

        /* renamed from: o, reason: collision with root package name */
        private Download.Policy f56630o;

        /* synthetic */ Api(Url url, RequestMethod requestMethod, AnonymousClass1 anonymousClass1) {
            this(url, requestMethod);
        }

        public String perform() {
            return new BodyWorker(new BodyDownload(this, null)).call();
        }

        private Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api directory(String str) {
            this.f56627l = str;
            return this;
        }

        public Api fileName(String str) {
            this.f56628m = str;
            return this;
        }

        public Api onProgress(Download.ProgressBar progressBar) {
            this.f56629n = progressBar;
            return this;
        }

        public Canceller perform(Callback callback) {
            return DownloadManager.getInstance().perform(new BodyDownload(this, null), callback);
        }

        public Api policy(Download.Policy policy) {
            this.f56630o = policy;
            return this;
        }
    }

    /* synthetic */ BodyDownload(Api api, AnonymousClass1 anonymousClass1) {
        this(api);
    }

    private BodyDownload(Api api) {
        super(api);
        this.f56623l = api.f56627l;
        this.f56624m = api.f56628m;
        this.f56625n = api.f56629n == null ? Download.ProgressBar.DEFAULT : api.f56629n;
        this.f56626o = api.f56630o == null ? Download.Policy.DEFAULT : api.f56630o;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod, null);
    }

    @Override // xyz.adscope.common.network.download.Download
    public String directory() {
        return this.f56623l;
    }

    @Override // xyz.adscope.common.network.download.Download
    public String fileName() {
        return this.f56624m;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.Policy policy() {
        return this.f56626o;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.ProgressBar progressBar() {
        return this.f56625n;
    }
}
