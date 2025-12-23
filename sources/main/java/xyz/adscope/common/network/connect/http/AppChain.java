package xyz.adscope.common.network.connect.http;

import java.util.List;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.Interceptor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class AppChain implements Chain {

    /* renamed from: a, reason: collision with root package name */
    private final List<Interceptor> f56569a;

    /* renamed from: b, reason: collision with root package name */
    private final int f56570b;

    /* renamed from: c, reason: collision with root package name */
    private final Request f56571c;

    /* renamed from: d, reason: collision with root package name */
    private Call f56572d;

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Call call() {
        return this.f56572d;
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Call newCall() {
        return this.f56572d;
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Response proceed(Request request) {
        return this.f56569a.get(this.f56570b).intercept(new AppChain(this.f56569a, this.f56570b + 1, request, this.f56572d));
    }

    @Override // xyz.adscope.common.network.connect.http.Chain
    public Request request() {
        return this.f56571c;
    }

    AppChain(List<Interceptor> list, int i6, Request request, Call call) {
        this.f56569a = list;
        this.f56570b = i6;
        this.f56571c = request;
        this.f56572d = call;
    }
}
