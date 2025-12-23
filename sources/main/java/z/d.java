package z;

import cn.jpush.android.local.JPushConstants;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.http.interceptor.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d implements Interceptor {
    private final String a(String str) {
        c0.b bVar = c0.b.f1042a;
        BaseApp c6 = BaseApp.c();
        g0.o(c6, "getApp(...)");
        return bVar.l(c6, str);
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        g0.p(chain, "chain");
        Request request = chain.request();
        l lVar = (l) request.tag(l.class);
        Method b6 = lVar != null ? lVar.b() : null;
        Test test = b6 != null ? (Test) b6.getAnnotation(Test.class) : null;
        if (test == null) {
            return chain.proceed(request);
        }
        String a6 = a(test.demo());
        HttpUrl url = request.url();
        Set<String> queryParameterNames = url.queryParameterNames();
        if (!u.H2(a6, JPushConstants.HTTP_PRE, false, 2, null) && !u.H2(a6, JPushConstants.HTTPS_PRE, false, 2, null)) {
            a6 = com.bxkj.base.v2.data.b.f16998d.a().M() + a6;
        }
        HttpUrl parse = HttpUrl.Companion.parse(a6);
        HttpUrl.Builder newBuilder = parse != null ? parse.newBuilder() : null;
        if (newBuilder == null) {
            return chain.proceed(request.newBuilder().url(a6).build());
        }
        for (String str : queryParameterNames) {
            Iterator<String> it = url.queryParameterValues(str).iterator();
            while (it.hasNext()) {
                newBuilder.addQueryParameter(str, it.next());
            }
        }
        return chain.proceed(request.newBuilder().url(newBuilder.build()).build());
    }
}
