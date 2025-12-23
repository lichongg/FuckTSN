package xyz.adscope.common.network;

import java.util.List;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Url;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UrlRequest extends Request {

    /* renamed from: i, reason: collision with root package name */
    private final Url f56560i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.UrlRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Api<T extends Api<T>> extends Request.Api<T> {

        /* renamed from: i, reason: collision with root package name */
        private Url.Builder f56561i;

        @Override // xyz.adscope.common.network.Request.Api
        public T clearParams() {
            this.f56561i.clearQuery();
            return this;
        }

        public T params(Params params) {
            this.f56561i.addQuery(params);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T removeParam(String str) {
            this.f56561i.removeQuery(str);
            return this;
        }

        public T setParams(Params params) {
            this.f56561i.setQuery(params);
            return this;
        }

        protected Api(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            Url.Builder builder = url.builder();
            this.f56561i = builder;
            builder.addQuery(Kalle.getConfig().getParams());
        }

        @Override // xyz.adscope.common.network.Request.Api
        public /* bridge */ /* synthetic */ Request.Api param(String str, List list) {
            return param(str, (List<String>) list);
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(int i6) {
            this.f56561i.addPath(i6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(long j6) {
            this.f56561i.addPath(j6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, int i6) {
            this.f56561i.addQuery(str, i6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(boolean z5) {
            this.f56561i.addPath(z5);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, long j6) {
            this.f56561i.addQuery(str, j6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(char c6) {
            this.f56561i.addPath(c6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, boolean z5) {
            this.f56561i.addQuery(str, z5);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(double d6) {
            this.f56561i.addPath(d6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, char c6) {
            this.f56561i.addQuery(str, c6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(float f6) {
            this.f56561i.addPath(f6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, double d6) {
            this.f56561i.addQuery(str, d6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(String str) {
            this.f56561i.addPath(str);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, float f6) {
            this.f56561i.addQuery(str, f6);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, short s5) {
            this.f56561i.addQuery(str, s5);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, String str2) {
            this.f56561i.addQuery(str, str2);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, List<String> list) {
            this.f56561i.addQuery(str, list);
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

        public UrlRequest build() {
            return new UrlRequest(this);
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
        throw new AssertionError("It should not be called.");
    }

    @Override // xyz.adscope.common.network.Request
    public Params copyParams() {
        return this.f56560i.getParams();
    }

    @Override // xyz.adscope.common.network.Request
    public Url url() {
        return this.f56560i;
    }

    protected UrlRequest(Api api) {
        super(api);
        this.f56560i = api.f56561i.build();
    }

    @Deprecated
    public static Builder newBuilder(Url.Builder builder, RequestMethod requestMethod) {
        return newBuilder(builder.build(), requestMethod);
    }
}
