package z;

import com.bxkj.base.v2.common.ext.c0;
import com.bxkj.base.v2.common.ext.g;
import com.bxkj.base.v2.common.ext.h;
import com.bxkj.base.v2.common.utils.i;
import com.huawei.hms.framework.common.ContainerUtils;
import com.orhanobut.logger.j;
import com.snail.antifake.deviceid.e;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHttpLogInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpLogInterceptor.kt\ncom/bxkj/base/v2/http/interceptor/HttpLogInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,137:1\n1878#2,3:138\n216#3,2:141\n216#3,2:143\n*S KotlinDebug\n*F\n+ 1 HttpLogInterceptor.kt\ncom/bxkj/base/v2/http/interceptor/HttpLogInterceptor\n*L\n33#1:138,3\n103#1:141,2\n114#1:143,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final StringBuilder f56785a = new StringBuilder();

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        g0.p(chain, "chain");
        try {
            this.f56785a.setLength(0);
            Request request = chain.request();
            this.f56785a.append("请求地址：");
            this.f56785a.append(request.url());
            this.f56785a.append(e.f37542d);
            this.f56785a.append("请求头：\u3000");
            int i6 = 0;
            for (Pair<? extends String, ? extends String> pair : request.headers()) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    f0.b0();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                if (i6 > 0) {
                    this.f56785a.append(e.f37542d);
                    this.f56785a.append("\u3000\u3000\u3000\u3000\u3000");
                }
                this.f56785a.append(pair2.getFirst());
                this.f56785a.append(":");
                this.f56785a.append(pair2.getSecond());
                i6 = i7;
            }
            this.f56785a.append(e.f37542d);
            Response proceed = chain.proceed(request.newBuilder().build());
            if (g0.g("POST", request.method())) {
                this.f56785a.append("请求参数：");
                a(request);
                this.f56785a.append(e.f37542d);
                this.f56785a.append("请求大小：");
                StringBuilder sb = this.f56785a;
                RequestBody body = request.body();
                sb.append(body != null ? g.a(body.contentLength()) : null);
                j.d(this.f56785a.toString(), new Object[0]);
                this.f56785a.setLength(0);
                this.f56785a.append("响应地址：");
                this.f56785a.append(proceed.request().url());
                this.f56785a.append(e.f37542d);
                this.f56785a.append("响应参数：");
                a(proceed.request());
                this.f56785a.append(e.f37542d);
            }
            this.f56785a.append("响应耗时：");
            this.f56785a.append(g.c(proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis()));
            this.f56785a.append(e.f37542d);
            String string = proceed.body().string();
            Response build = proceed.newBuilder().body(ResponseBody.Companion.create(proceed.body().contentType(), string)).build();
            this.f56785a.append("响应大小：");
            StringBuilder sb2 = this.f56785a;
            RequestBody body2 = request.body();
            sb2.append(body2 != null ? g.a(body2.contentLength()) : null);
            this.f56785a.append(e.f37542d);
            this.f56785a.append("响应数据：");
            this.f56785a.append(e.f37542d);
            this.f56785a.append(c0.b(i.a(string)));
            j.d(this.f56785a.toString(), new Object[0]);
            return build;
        } catch (Exception e6) {
            e6.printStackTrace();
            return chain.proceed(chain.request());
        }
    }

    private final void a(Request request) {
        String str;
        RequestBody body;
        MediaType contentType;
        MediaType contentType2;
        Pair<Map<String, String>, Map<String, String>> a6;
        if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            g0.m(formBody);
            int size = formBody.size();
            for (int i6 = 0; i6 < size; i6++) {
                String encodedName = formBody.encodedName(i6);
                String value = formBody.value(i6);
                if (this.f56785a.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) != -1) {
                    this.f56785a.append(e.f37542d);
                    this.f56785a.append("\u3000\u3000\u3000\u3000\u3000");
                }
                this.f56785a.append(encodedName);
                this.f56785a.append(ContainerUtils.KEY_VALUE_DELIMITER);
                this.f56785a.append(value);
            }
            return;
        }
        if (request.body() instanceof MultipartBody) {
            MultipartBody multipartBody = (MultipartBody) request.body();
            if (multipartBody != null && (a6 = h.a(multipartBody)) != null) {
                Map<String, String> component1 = a6.component1();
                Map<String, String> component2 = a6.component2();
                for (Map.Entry<String, String> entry : component1.entrySet()) {
                    String key = entry.getKey();
                    String value2 = entry.getValue();
                    if (this.f56785a.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) != -1) {
                        this.f56785a.append(e.f37542d);
                        this.f56785a.append("\u3000\u3000\u3000\u3000\u3000");
                    }
                    this.f56785a.append(key);
                    this.f56785a.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    this.f56785a.append(value2);
                }
                for (Map.Entry<String, String> entry2 : component2.entrySet()) {
                    String key2 = entry2.getKey();
                    String value3 = entry2.getValue();
                    if (this.f56785a.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) != -1) {
                        this.f56785a.append(e.f37542d);
                        this.f56785a.append("\u3000\u3000\u3000\u3000\u3000");
                    }
                    this.f56785a.append(key2);
                    this.f56785a.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    this.f56785a.append(value3);
                }
                return;
            }
            return;
        }
        RequestBody body2 = request.body();
        String str2 = null;
        if (body2 != null && (contentType2 = body2.contentType()) != null) {
            str = contentType2.type();
        } else {
            str = null;
        }
        if (g0.g(str, "application")) {
            RequestBody body3 = request.body();
            if (body3 != null && (contentType = body3.contentType()) != null) {
                str2 = contentType.subtype();
            }
            if (g0.g(str2, "json") && (body = request.body()) != null) {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                this.f56785a.append(c0.b(buffer.readUtf8()));
            }
        }
    }
}
