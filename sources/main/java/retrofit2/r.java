package retrofit2;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class r<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends r<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                r.this.a(a0Var, it.next());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends r<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i6 = 0; i6 < length; i6++) {
                r.this.a(a0Var, Array.get(obj, i6));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f52187a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.g<T, String> f52188b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f52189c;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) throws IOException {
            String convert;
            if (t5 == null || (convert = this.f52188b.convert(t5)) == null) {
                return;
            }
            a0Var.a(this.f52187a, convert, this.f52189c);
        }

        d(String str, retrofit2.g<T, String> gVar, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.f52187a = str;
            this.f52188b = gVar;
            this.f52189c = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f52194a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.g<T, String> f52195b;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) throws IOException {
            String convert;
            if (t5 == null || (convert = this.f52195b.convert(t5)) == null) {
                return;
            }
            a0Var.b(this.f52194a, convert);
        }

        f(String str, retrofit2.g<T, String> gVar) {
            Objects.requireNonNull(str, "name == null");
            this.f52194a = str;
            this.f52195b = gVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class h extends r<Headers> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52199a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52200b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable Headers headers) {
            if (headers == null) {
                throw f0.o(this.f52199a, this.f52200b, "Headers parameter must not be null.", new Object[0]);
            }
            a0Var.c(headers);
        }

        h(Method method, int i6) {
            this.f52199a = method;
            this.f52200b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52201a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52202b;

        /* renamed from: c, reason: collision with root package name */
        private final Headers f52203c;

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.g<T, RequestBody> f52204d;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) {
            if (t5 == null) {
                return;
            }
            try {
                a0Var.d(this.f52203c, this.f52204d.convert(t5));
            } catch (IOException e6) {
                throw f0.o(this.f52201a, this.f52202b, "Unable to convert " + t5 + " to RequestBody", e6);
            }
        }

        i(Method method, int i6, Headers headers, retrofit2.g<T, RequestBody> gVar) {
            this.f52201a = method;
            this.f52202b = i6;
            this.f52203c = headers;
            this.f52204d = gVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class k<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52209a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52210b;

        /* renamed from: c, reason: collision with root package name */
        private final String f52211c;

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.g<T, String> f52212d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f52213e;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) throws IOException {
            if (t5 != null) {
                a0Var.f(this.f52211c, this.f52212d.convert(t5), this.f52213e);
                return;
            }
            throw f0.o(this.f52209a, this.f52210b, "Path parameter \"" + this.f52211c + "\" value must not be null.", new Object[0]);
        }

        k(Method method, int i6, String str, retrofit2.g<T, String> gVar, boolean z5) {
            this.f52209a = method;
            this.f52210b = i6;
            Objects.requireNonNull(str, "name == null");
            this.f52211c = str;
            this.f52212d = gVar;
            this.f52213e = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class l<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f52214a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.g<T, String> f52215b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f52216c;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) throws IOException {
            String convert;
            if (t5 == null || (convert = this.f52215b.convert(t5)) == null) {
                return;
            }
            a0Var.g(this.f52214a, convert, this.f52216c);
        }

        l(String str, retrofit2.g<T, String> gVar, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.f52214a = str;
            this.f52215b = gVar;
            this.f52216c = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class n<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final retrofit2.g<T, String> f52221a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f52222b;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) throws IOException {
            if (t5 == null) {
                return;
            }
            a0Var.g(this.f52221a.convert(t5), null, this.f52222b);
        }

        n(retrofit2.g<T, String> gVar, boolean z5) {
            this.f52221a = gVar;
            this.f52222b = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class o extends r<MultipartBody.Part> {

        /* renamed from: a, reason: collision with root package name */
        static final o f52223a = new o();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable MultipartBody.Part part) {
            if (part != null) {
                a0Var.e(part);
            }
        }

        private o() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class p extends r<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52224a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52225b;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable Object obj) {
            if (obj == null) {
                throw f0.o(this.f52224a, this.f52225b, "@Url parameter is null.", new Object[0]);
            }
            a0Var.m(obj);
        }

        p(Method method, int i6) {
            this.f52224a = method;
            this.f52225b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class q<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        final Class<T> f52226a;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) {
            a0Var.h(this.f52226a, t5);
        }

        q(Class<T> cls) {
            this.f52226a = cls;
        }
    }

    abstract void a(a0 a0Var, @Nullable T t5) throws IOException;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52184a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52185b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.g<T, RequestBody> f52186c;

        @Override // retrofit2.r
        void a(a0 a0Var, @Nullable T t5) {
            if (t5 == null) {
                throw f0.o(this.f52184a, this.f52185b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                a0Var.l(this.f52186c.convert(t5));
            } catch (IOException e6) {
                throw f0.p(this.f52184a, e6, this.f52185b, "Unable to convert " + t5 + " to RequestBody", new Object[0]);
            }
        }

        c(Method method, int i6, retrofit2.g<T, RequestBody> gVar) {
            this.f52184a = method;
            this.f52185b = i6;
            this.f52186c = gVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> extends r<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52190a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52191b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.g<T, String> f52192c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f52193d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw f0.o(this.f52190a, this.f52191b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw f0.o(this.f52190a, this.f52191b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw f0.o(this.f52190a, this.f52191b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.f52192c.convert(value);
                if (convert == null) {
                    throw f0.o(this.f52190a, this.f52191b, "Field map value '" + value + "' converted to null by " + this.f52192c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                a0Var.a(key, convert, this.f52193d);
            }
        }

        e(Method method, int i6, retrofit2.g<T, String> gVar, boolean z5) {
            this.f52190a = method;
            this.f52191b = i6;
            this.f52192c = gVar;
            this.f52193d = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g<T> extends r<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52196a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52197b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.g<T, String> f52198c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw f0.o(this.f52196a, this.f52197b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw f0.o(this.f52196a, this.f52197b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw f0.o(this.f52196a, this.f52197b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                a0Var.b(key, this.f52198c.convert(value));
            }
        }

        g(Method method, int i6, retrofit2.g<T, String> gVar) {
            this.f52196a = method;
            this.f52197b = i6;
            this.f52198c = gVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class j<T> extends r<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52205a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52206b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.g<T, RequestBody> f52207c;

        /* renamed from: d, reason: collision with root package name */
        private final String f52208d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw f0.o(this.f52205a, this.f52206b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw f0.o(this.f52205a, this.f52206b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw f0.o(this.f52205a, this.f52206b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                a0Var.d(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, this.f52208d), this.f52207c.convert(value));
            }
        }

        j(Method method, int i6, retrofit2.g<T, RequestBody> gVar, String str) {
            this.f52205a = method;
            this.f52206b = i6;
            this.f52207c = gVar;
            this.f52208d = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class m<T> extends r<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f52217a;

        /* renamed from: b, reason: collision with root package name */
        private final int f52218b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.g<T, String> f52219c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f52220d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.r
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(a0 a0Var, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw f0.o(this.f52217a, this.f52218b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw f0.o(this.f52217a, this.f52218b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw f0.o(this.f52217a, this.f52218b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.f52219c.convert(value);
                if (convert == null) {
                    throw f0.o(this.f52217a, this.f52218b, "Query map value '" + value + "' converted to null by " + this.f52219c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                a0Var.g(key, convert, this.f52220d);
            }
        }

        m(Method method, int i6, retrofit2.g<T, String> gVar, boolean z5) {
            this.f52217a = method;
            this.f52218b = i6;
            this.f52219c = gVar;
            this.f52220d = z5;
        }
    }

    final r<Object> b() {
        return new b();
    }

    final r<Iterable<T>> c() {
        return new a();
    }

    r() {
    }
}
