package xyz.adscope.common.network.simple;

import android.text.TextUtils;
import java.lang.reflect.Type;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.UrlRequest;
import xyz.adscope.common.network.simple.cache.CacheMode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SimpleUrlRequest extends UrlRequest implements SimpleRequest {

    /* renamed from: j, reason: collision with root package name */
    private final CacheMode f56705j;

    /* renamed from: k, reason: collision with root package name */
    private final String f56706k;

    /* renamed from: l, reason: collision with root package name */
    private final Converter f56707l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.simple.SimpleUrlRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Api extends UrlRequest.Api<Api> {

        /* renamed from: j, reason: collision with root package name */
        private CacheMode f56708j;

        /* renamed from: k, reason: collision with root package name */
        private String f56709k;

        /* renamed from: l, reason: collision with root package name */
        private Converter f56710l;

        /* synthetic */ Api(Url url, RequestMethod requestMethod, AnonymousClass1 anonymousClass1) {
            this(url, requestMethod);
        }

        public <S, F> SimpleResponse<S, F> perform(Type type, Type type2) {
            return RequestManager.getInstance().perform(new SimpleUrlRequest(this, null), type, type2);
        }

        private Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api cacheKey(String str) {
            this.f56709k = str;
            return this;
        }

        public Api cacheMode(CacheMode cacheMode) {
            this.f56708j = cacheMode;
            return this;
        }

        public Api converter(Converter converter) {
            this.f56710l = converter;
            return this;
        }

        public <S, F> Canceller perform(Callback<S, F> callback) {
            return RequestManager.getInstance().perform(new SimpleUrlRequest(this, null), callback);
        }
    }

    /* synthetic */ SimpleUrlRequest(Api api, AnonymousClass1 anonymousClass1) {
        this(api);
    }

    private SimpleUrlRequest(Api api) {
        super(api);
        this.f56705j = api.f56708j == null ? CacheMode.HTTP : api.f56708j;
        this.f56706k = TextUtils.isEmpty(api.f56709k) ? url().toString() : api.f56709k;
        this.f56707l = api.f56710l;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod, null);
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public String cacheKey() {
        return this.f56706k;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public CacheMode cacheMode() {
        return this.f56705j;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public Converter converter() {
        return this.f56707l;
    }
}
