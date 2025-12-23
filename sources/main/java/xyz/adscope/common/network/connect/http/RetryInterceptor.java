package xyz.adscope.common.network.connect.http;

import java.io.IOException;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.Interceptor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RetryInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private int f56586a;

    public RetryInterceptor(int i6) {
        this.f56586a = i6;
    }

    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (IOException e6) {
            int i6 = this.f56586a;
            if (i6 > 0) {
                this.f56586a = i6 - 1;
                return intercept(chain);
            }
            throw e6;
        }
    }
}
