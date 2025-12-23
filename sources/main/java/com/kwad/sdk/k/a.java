package com.kwad.sdk.k;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e6) {
            if (e6 instanceof IOException) {
                throw e6;
            }
            throw new IOException(e6);
        }
    }
}
