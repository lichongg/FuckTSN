package com.tencent.open.a;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class e implements com.tencent.open.a.a {

    /* renamed from: a, reason: collision with root package name */
    private OkHttpClient f40502a;

    private void a(OkHttpClient.Builder builder) {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Interceptor {

        /* renamed from: a, reason: collision with root package name */
        private final String f40503a;

        public a(String str) {
            this.f40503a = str;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.f40503a).build());
        }
    }

    private void a(String str) {
        String userAgent = Version.userAgent();
        if (userAgent == null || !userAgent.startsWith("okhttp/3")) {
            throw new NoClassDefFoundError();
        }
        a aVar = new a(str);
        OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder addInterceptor = connectionSpecs.connectTimeout(15000L, timeUnit).readTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, timeUnit).writeTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, timeUnit).cache(null).addInterceptor(aVar);
        a(addInterceptor);
        this.f40502a = addInterceptor.build();
    }

    public e(String str) throws NoClassDefFoundError {
        a(str);
    }

    @Override // com.tencent.open.a.a
    public void a(long j6, long j7) {
        if (j6 <= 0 || j7 <= 0) {
            return;
        }
        if (this.f40502a.connectTimeoutMillis() == j6 && this.f40502a.readTimeoutMillis() == j7) {
            return;
        }
        SLog.i("OkHttpServiceImpl", "setTimeout changed.");
        OkHttpClient.Builder newBuilder = this.f40502a.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f40502a = newBuilder.connectTimeout(j6, timeUnit).readTimeout(j7, timeUnit).writeTimeout(j7, timeUnit).build();
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("OkHttpServiceImpl", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + ContainerUtils.FIELD_DELIMITER;
            }
            str = str + str2;
        }
        return new d(this.f40502a.newCall(new Request.Builder().url(str).get().build()).execute(), str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("OkHttpServiceImpl", "post data");
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    builder.add(str2, str3);
                }
            }
        }
        FormBody build = builder.build();
        return new d(this.f40502a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("OkHttpServiceImpl", "post data, has byte data");
            MultipartBody.Builder builder = new MultipartBody.Builder();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        builder.addFormDataPart(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    builder.addFormDataPart(str4, str4, RequestBody.create(MediaType.get("content/unknown"), bArr));
                    SLog.w("OkHttpServiceImpl", "post byte data.");
                }
            }
            MultipartBody build = builder.build();
            return new d(this.f40502a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
        }
        return a(str, map);
    }
}
