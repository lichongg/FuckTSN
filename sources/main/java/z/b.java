package z;

import com.bxkj.base.v2.http.interceptor.DynamicTimeout;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        g0.p(chain, "chain");
        Request request = chain.request();
        l lVar = (l) request.tag(l.class);
        Method b6 = lVar != null ? lVar.b() : null;
        DynamicTimeout dynamicTimeout = b6 != null ? (DynamicTimeout) b6.getAnnotation(DynamicTimeout.class) : null;
        if (dynamicTimeout == null || dynamicTimeout.timeout() <= 0) {
            return chain.proceed(request);
        }
        int timeout = dynamicTimeout.timeout();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return chain.withConnectTimeout(timeout, timeUnit).withReadTimeout(dynamicTimeout.timeout(), timeUnit).withWriteTimeout(dynamicTimeout.timeout(), timeUnit).proceed(request);
    }
}
