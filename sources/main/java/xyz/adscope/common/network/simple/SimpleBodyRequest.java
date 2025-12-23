package xyz.adscope.common.network.simple;

import android.text.TextUtils;
import java.lang.reflect.Type;
import xyz.adscope.common.network.BodyRequest;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.simple.cache.CacheMode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SimpleBodyRequest extends BodyRequest implements SimpleRequest {

    /* renamed from: l, reason: collision with root package name */
    private final CacheMode f56689l;

    /* renamed from: m, reason: collision with root package name */
    private final String f56690m;

    /* renamed from: n, reason: collision with root package name */
    private final Converter f56691n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.simple.SimpleBodyRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Api extends BodyRequest.Api<Api> {

        /* renamed from: l, reason: collision with root package name */
        private CacheMode f56692l;

        /* renamed from: m, reason: collision with root package name */
        private String f56693m;

        /* renamed from: n, reason: collision with root package name */
        private Converter f56694n;

        /* synthetic */ Api(Url url, RequestMethod requestMethod, AnonymousClass1 anonymousClass1) {
            this(url, requestMethod);
        }

        public <S, F> SimpleResponse<S, F> perform(Type type, Type type2) {
            return RequestManager.getInstance().perform(new SimpleBodyRequest(this, null), type, type2);
        }

        private Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api cacheKey(String str) {
            this.f56693m = str;
            return this;
        }

        public Api cacheMode(CacheMode cacheMode) {
            this.f56692l = cacheMode;
            return this;
        }

        public Api converter(Converter converter) {
            this.f56694n = converter;
            return this;
        }

        public <S, F> Canceller perform(Callback<S, F> callback) {
            return RequestManager.getInstance().perform(new SimpleBodyRequest(this, null), callback);
        }
    }

    /* synthetic */ SimpleBodyRequest(Api api, AnonymousClass1 anonymousClass1) {
        this(api);
    }

    private SimpleBodyRequest(Api api) {
        super(api);
        this.f56689l = api.f56692l == null ? CacheMode.HTTP : api.f56692l;
        this.f56690m = TextUtils.isEmpty(api.f56693m) ? url().toString() : api.f56693m;
        this.f56691n = api.f56694n;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod, null);
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public String cacheKey() {
        return this.f56690m;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public CacheMode cacheMode() {
        return this.f56689l;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public Converter converter() {
        return this.f56691n;
    }
}
