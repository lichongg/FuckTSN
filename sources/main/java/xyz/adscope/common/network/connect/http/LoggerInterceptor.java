package xyz.adscope.common.network.connect.http;

import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestBody;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.StringBody;
import xyz.adscope.common.network.UrlBody;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LoggerInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final String f56584a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f56585b;

    public LoggerInterceptor(String str, boolean z5) {
        this.f56584a = str;
        this.f56585b = z5;
    }

    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        Request request = chain.request();
        if (this.f56585b) {
            Response proceed = chain.proceed(request);
            String url = request.url().toString();
            StringBuilder sb = new StringBuilder(String.format(" \nPrint Request: %1$s.", url));
            sb.append(String.format("\nMethod: %1$s.", request.method().name()));
            for (Map.Entry<String, List<String>> entry : request.headers().entrySet()) {
                sb.append(String.format("\n%1$s: %2$s.", entry.getKey(), TextUtils.join(";", entry.getValue())));
            }
            if (request.method().allowBody()) {
                RequestBody body = request.body();
                if ((body instanceof StringBody) || (body instanceof UrlBody)) {
                    sb.append(String.format(" \nRequest Body: %1$s.", body.toString()));
                }
            }
            sb.append(String.format(" \nPrint Response: %1$s.", url));
            sb.append(String.format(Locale.getDefault(), "\nCode: %1$d", Integer.valueOf(proceed.code())));
            for (Map.Entry<String, List<String>> entry2 : proceed.headers().entrySet()) {
                sb.append(String.format("\n%1$s: %2$s.", entry2.getKey(), TextUtils.join(";", entry2.getValue())));
            }
            LogUtil.i(this.f56584a, sb.toString());
            return proceed;
        }
        return chain.proceed(request);
    }
}
