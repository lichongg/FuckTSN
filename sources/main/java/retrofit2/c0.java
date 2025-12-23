package retrofit2;

import com.baidu.mobads.sdk.internal.ca;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class c0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Response f52087a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final T f52088b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final ResponseBody f52089c;

    public static <T> c0<T> c(int i6, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i6 >= 400) {
            return d(responseBody, new Response.Builder().body(new n.c(responseBody.contentType(), responseBody.contentLength())).code(i6).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i6);
    }

    public static <T> c0<T> d(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new c0<>(response, null, responseBody);
    }

    public static <T> c0<T> j(int i6, @Nullable T t5) {
        if (i6 >= 200 && i6 < 300) {
            return m(t5, new Response.Builder().code(i6).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i6);
    }

    public static <T> c0<T> k(@Nullable T t5) {
        return m(t5, new Response.Builder().code(200).message(ca.f10845k).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> c0<T> l(@Nullable T t5, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        return m(t5, new Response.Builder().code(200).message(ca.f10845k).protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> c0<T> m(@Nullable T t5, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new c0<>(response, t5, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f52088b;
    }

    public int b() {
        return this.f52087a.code();
    }

    @Nullable
    public ResponseBody e() {
        return this.f52089c;
    }

    public Headers f() {
        return this.f52087a.headers();
    }

    public boolean g() {
        return this.f52087a.isSuccessful();
    }

    public String h() {
        return this.f52087a.message();
    }

    public Response i() {
        return this.f52087a;
    }

    public String toString() {
        return this.f52087a.toString();
    }

    private c0(Response response, @Nullable T t5, @Nullable ResponseBody responseBody) {
        this.f52087a = response;
        this.f52088b = t5;
        this.f52089c = responseBody;
    }
}
