package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.n1;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.g;
import retrofit2.http.Streaming;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class a extends g.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f51999a = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: retrofit2.a$a, reason: collision with other inner class name */
    static final class C1007a implements g<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        static final C1007a f52000a = new C1007a();

        C1007a() {
        }

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return f0.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements g<RequestBody, RequestBody> {

        /* renamed from: a, reason: collision with root package name */
        static final b f52001a = new b();

        b() {
        }

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements g<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        static final c f52002a = new c();

        c() {
        }

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d implements g<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f52003a = new d();

        d() {
        }

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e implements g<ResponseBody, n1> {

        /* renamed from: a, reason: collision with root package name */
        static final e f52004a = new e();

        e() {
        }

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n1 convert(ResponseBody responseBody) {
            responseBody.close();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f implements g<ResponseBody, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final f f52005a = new f();

        f() {
        }

        @Override // retrofit2.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.g.a
    @Nullable
    public g<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, d0 d0Var) {
        if (RequestBody.class.isAssignableFrom(f0.h(type))) {
            return b.f52001a;
        }
        return null;
    }

    @Override // retrofit2.g.a
    @Nullable
    public g<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, d0 d0Var) {
        if (type == ResponseBody.class) {
            return f0.l(annotationArr, Streaming.class) ? c.f52002a : C1007a.f52000a;
        }
        if (type == Void.class) {
            return f.f52005a;
        }
        if (!this.f51999a || type != n1.class) {
            return null;
        }
        try {
            return e.f52004a;
        } catch (NoClassDefFoundError unused) {
            this.f51999a = false;
            return null;
        }
    }

    a() {
    }
}
