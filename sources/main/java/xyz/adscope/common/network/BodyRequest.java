package xyz.adscope.common.network;

import java.io.File;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Url;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BodyRequest extends Request {

    /* renamed from: i, reason: collision with root package name */
    private final Url f56460i;

    /* renamed from: j, reason: collision with root package name */
    private final RequestBody f56461j;

    /* renamed from: k, reason: collision with root package name */
    private final Params f56462k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.BodyRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Api<T extends Api<T>> extends Request.Api<T> {

        /* renamed from: i, reason: collision with root package name */
        private Url.Builder f56463i;

        /* renamed from: j, reason: collision with root package name */
        private Params.Builder f56464j;

        /* renamed from: k, reason: collision with root package name */
        private RequestBody f56465k;

        public T params(Params params) {
            this.f56464j.add(params);
            return this;
        }

        public T urlParam(String str, int i6) {
            this.f56463i.addQuery(str, i6);
            return this;
        }

        public T binaries(String str, List<Binary> list) {
            this.f56464j.binaries(str, list);
            return this;
        }

        public T binary(String str, Binary binary) {
            this.f56464j.binary(str, binary);
            return this;
        }

        public T body(RequestBody requestBody) {
            this.f56465k = requestBody;
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T clearParams() {
            this.f56464j.clear();
            return this;
        }

        public T file(String str, File file) {
            this.f56464j.file(str, file);
            return this;
        }

        public T files(String str, List<File> list) {
            this.f56464j.files(str, list);
            return this;
        }

        public T params(Map<String, String> map) {
            this.f56464j.add(map);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T removeParam(String str) {
            this.f56464j.remove(str);
            return this;
        }

        public T setParams(Params params) {
            this.f56464j.set(params);
            return this;
        }

        public T setUrlParam(Params params) {
            this.f56463i.setQuery(params);
            return this;
        }

        public T urlParam(String str, long j6) {
            this.f56463i.addQuery(str, j6);
            return this;
        }

        protected Api(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            this.f56463i = url.builder();
            Params.Builder newBuilder = Params.newBuilder();
            this.f56464j = newBuilder;
            newBuilder.add(Kalle.getConfig().getParams());
        }

        public T urlParam(String str, boolean z5) {
            this.f56463i.addQuery(str, z5);
            return this;
        }

        public T urlParam(String str, char c6) {
            this.f56463i.addQuery(str, c6);
            return this;
        }

        public T urlParam(String str, double d6) {
            this.f56463i.addQuery(str, d6);
            return this;
        }

        public T urlParam(String str, float f6) {
            this.f56463i.addQuery(str, f6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public /* bridge */ /* synthetic */ Request.Api param(String str, List list) {
            return param(str, (List<String>) list);
        }

        public T urlParam(String str, short s5) {
            this.f56463i.addQuery(str, s5);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(int i6) {
            this.f56463i.addPath(i6);
            return this;
        }

        public T urlParam(String str, String str2) {
            this.f56463i.addQuery(str, str2);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(long j6) {
            this.f56463i.addPath(j6);
            return this;
        }

        public T urlParam(String str, List<String> list) {
            this.f56463i.addQuery(str, list);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, int i6) {
            return param(str, Integer.toString(i6));
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(boolean z5) {
            this.f56463i.addPath(z5);
            return this;
        }

        public T urlParam(Params params) {
            this.f56463i.addQuery(params);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, long j6) {
            this.f56464j.add(str, j6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(char c6) {
            this.f56463i.addPath(c6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, boolean z5) {
            this.f56464j.add(str, z5);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(double d6) {
            this.f56463i.addPath(d6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, char c6) {
            this.f56464j.add(str, c6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(float f6) {
            this.f56463i.addPath(f6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, double d6) {
            this.f56464j.add(str, d6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(String str) {
            this.f56463i.addPath(str);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, float f6) {
            this.f56464j.add(str, f6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, short s5) {
            this.f56464j.add(str, s5);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, String str2) {
            this.f56464j.add(str, str2);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, List<String> list) {
            this.f56464j.add(str, list);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder extends Api<Builder> {
        /* synthetic */ Builder(Url url, RequestMethod requestMethod, AnonymousClass1 anonymousClass1) {
            this(url, requestMethod);
        }

        private Builder(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public BodyRequest build() {
            return new BodyRequest(this);
        }
    }

    public static Builder newBuilder(String str, RequestMethod requestMethod) {
        return newBuilder(Url.newBuilder(str).build(), requestMethod);
    }

    public static Builder newBuilder(Url url, RequestMethod requestMethod) {
        return new Builder(url, requestMethod, null);
    }

    @Override // xyz.adscope.common.network.Request
    public RequestBody body() {
        return this.f56461j;
    }

    @Override // xyz.adscope.common.network.Request
    public Params copyParams() {
        return this.f56462k;
    }

    @Override // xyz.adscope.common.network.Request
    public Url url() {
        return this.f56460i;
    }

    protected BodyRequest(Api api) {
        super(api);
        RequestBody requestBody;
        this.f56460i = api.f56463i.build();
        Params build = api.f56464j.build();
        this.f56462k = build;
        if (api.f56465k != null) {
            requestBody = api.f56465k;
        } else if (build.hasBinary()) {
            requestBody = build.toFormBody();
        } else {
            requestBody = build.toUrlBody();
        }
        this.f56461j = requestBody;
    }

    @Deprecated
    public static Builder newBuilder(Url.Builder builder, RequestMethod requestMethod) {
        return newBuilder(builder.build(), requestMethod);
    }
}
