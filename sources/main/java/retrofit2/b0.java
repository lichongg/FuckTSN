package retrofit2;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;
import retrofit2.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final Method f52050a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpUrl f52051b;

    /* renamed from: c, reason: collision with root package name */
    final String f52052c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f52053d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final Headers f52054e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final MediaType f52055f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f52056g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f52057h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f52058i;

    /* renamed from: j, reason: collision with root package name */
    private final r<?>[] f52059j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f52060k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final d0 f52064a;

        /* renamed from: b, reason: collision with root package name */
        final Method f52065b;

        /* renamed from: c, reason: collision with root package name */
        final Annotation[] f52066c;

        /* renamed from: d, reason: collision with root package name */
        final Annotation[][] f52067d;

        /* renamed from: e, reason: collision with root package name */
        final Type[] f52068e;

        /* renamed from: f, reason: collision with root package name */
        boolean f52069f;

        /* renamed from: g, reason: collision with root package name */
        boolean f52070g;

        /* renamed from: h, reason: collision with root package name */
        boolean f52071h;

        /* renamed from: i, reason: collision with root package name */
        boolean f52072i;

        /* renamed from: j, reason: collision with root package name */
        boolean f52073j;

        /* renamed from: k, reason: collision with root package name */
        boolean f52074k;

        /* renamed from: l, reason: collision with root package name */
        boolean f52075l;

        /* renamed from: m, reason: collision with root package name */
        boolean f52076m;

        /* renamed from: n, reason: collision with root package name */
        @Nullable
        String f52077n;

        /* renamed from: o, reason: collision with root package name */
        boolean f52078o;

        /* renamed from: p, reason: collision with root package name */
        boolean f52079p;

        /* renamed from: q, reason: collision with root package name */
        boolean f52080q;

        /* renamed from: r, reason: collision with root package name */
        @Nullable
        String f52081r;

        /* renamed from: s, reason: collision with root package name */
        @Nullable
        Headers f52082s;

        /* renamed from: t, reason: collision with root package name */
        @Nullable
        MediaType f52083t;

        /* renamed from: u, reason: collision with root package name */
        @Nullable
        Set<String> f52084u;

        /* renamed from: v, reason: collision with root package name */
        @Nullable
        r<?>[] f52085v;

        /* renamed from: w, reason: collision with root package name */
        boolean f52086w;

        /* renamed from: y, reason: collision with root package name */
        private static final Pattern f52062y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: x, reason: collision with root package name */
        private static final String f52061x = "[a-zA-Z][a-zA-Z0-9_-]*";

        /* renamed from: z, reason: collision with root package name */
        private static final Pattern f52063z = Pattern.compile(f52061x);

        @Nullable
        private r<?> f(int i6, Type type, @Nullable Annotation[] annotationArr, boolean z5) {
            r<?> rVar;
            if (annotationArr != null) {
                rVar = null;
                for (Annotation annotation : annotationArr) {
                    r<?> g6 = g(i6, type, annotationArr, annotation);
                    if (g6 != null) {
                        if (rVar != null) {
                            throw f0.o(this.f52065b, i6, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        rVar = g6;
                    }
                }
            } else {
                rVar = null;
            }
            if (rVar != null) {
                return rVar;
            }
            if (z5) {
                try {
                    if (f0.h(type) == kotlin.coroutines.e.class) {
                        this.f52086w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw f0.o(this.f52065b, i6, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private r<?> g(int i6, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                j(i6, type);
                if (this.f52076m) {
                    throw f0.o(this.f52065b, i6, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f52072i) {
                    throw f0.o(this.f52065b, i6, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f52073j) {
                    throw f0.o(this.f52065b, i6, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f52074k) {
                    throw f0.o(this.f52065b, i6, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f52075l) {
                    throw f0.o(this.f52065b, i6, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f52081r != null) {
                    throw f0.o(this.f52065b, i6, "@Url cannot be used with @%s URL", this.f52077n);
                }
                this.f52076m = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new r.p(this.f52065b, i6);
                }
                throw f0.o(this.f52065b, i6, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                j(i6, type);
                if (this.f52073j) {
                    throw f0.o(this.f52065b, i6, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f52074k) {
                    throw f0.o(this.f52065b, i6, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f52075l) {
                    throw f0.o(this.f52065b, i6, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f52076m) {
                    throw f0.o(this.f52065b, i6, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f52081r == null) {
                    throw f0.o(this.f52065b, i6, "@Path can only be used with relative url on @%s", this.f52077n);
                }
                this.f52072i = true;
                Path path = (Path) annotation;
                String value = path.value();
                i(i6, value);
                return new r.k(this.f52065b, i6, value, this.f52064a.o(type, annotationArr), path.encoded());
            }
            if (annotation instanceof Query) {
                j(i6, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class<?> h6 = f0.h(type);
                this.f52073j = true;
                if (!Iterable.class.isAssignableFrom(h6)) {
                    return h6.isArray() ? new r.l(value2, this.f52064a.o(a(h6.getComponentType()), annotationArr), encoded).b() : new r.l(value2, this.f52064a.o(type, annotationArr), encoded);
                }
                if (type instanceof ParameterizedType) {
                    return new r.l(value2, this.f52064a.o(f0.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                }
                throw f0.o(this.f52065b, i6, h6.getSimpleName() + " must include generic type (e.g., " + h6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryName) {
                j(i6, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> h7 = f0.h(type);
                this.f52074k = true;
                if (!Iterable.class.isAssignableFrom(h7)) {
                    return h7.isArray() ? new r.n(this.f52064a.o(a(h7.getComponentType()), annotationArr), encoded2).b() : new r.n(this.f52064a.o(type, annotationArr), encoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new r.n(this.f52064a.o(f0.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                }
                throw f0.o(this.f52065b, i6, h7.getSimpleName() + " must include generic type (e.g., " + h7.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryMap) {
                j(i6, type);
                Class<?> h8 = f0.h(type);
                this.f52075l = true;
                if (!Map.class.isAssignableFrom(h8)) {
                    throw f0.o(this.f52065b, i6, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type i7 = f0.i(type, h8, Map.class);
                if (!(i7 instanceof ParameterizedType)) {
                    throw f0.o(this.f52065b, i6, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) i7;
                Type g6 = f0.g(0, parameterizedType);
                if (String.class == g6) {
                    return new r.m(this.f52065b, i6, this.f52064a.o(f0.g(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw f0.o(this.f52065b, i6, "@QueryMap keys must be of type String: " + g6, new Object[0]);
            }
            if (annotation instanceof Header) {
                j(i6, type);
                String value3 = ((Header) annotation).value();
                Class<?> h9 = f0.h(type);
                if (!Iterable.class.isAssignableFrom(h9)) {
                    return h9.isArray() ? new r.f(value3, this.f52064a.o(a(h9.getComponentType()), annotationArr)).b() : new r.f(value3, this.f52064a.o(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new r.f(value3, this.f52064a.o(f0.g(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw f0.o(this.f52065b, i6, h9.getSimpleName() + " must include generic type (e.g., " + h9.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new r.h(this.f52065b, i6);
                }
                j(i6, type);
                Class<?> h10 = f0.h(type);
                if (!Map.class.isAssignableFrom(h10)) {
                    throw f0.o(this.f52065b, i6, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type i8 = f0.i(type, h10, Map.class);
                if (!(i8 instanceof ParameterizedType)) {
                    throw f0.o(this.f52065b, i6, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) i8;
                Type g7 = f0.g(0, parameterizedType2);
                if (String.class == g7) {
                    return new r.g(this.f52065b, i6, this.f52064a.o(f0.g(1, parameterizedType2), annotationArr));
                }
                throw f0.o(this.f52065b, i6, "@HeaderMap keys must be of type String: " + g7, new Object[0]);
            }
            if (annotation instanceof Field) {
                j(i6, type);
                if (!this.f52079p) {
                    throw f0.o(this.f52065b, i6, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String value4 = field.value();
                boolean encoded3 = field.encoded();
                this.f52069f = true;
                Class<?> h11 = f0.h(type);
                if (!Iterable.class.isAssignableFrom(h11)) {
                    return h11.isArray() ? new r.d(value4, this.f52064a.o(a(h11.getComponentType()), annotationArr), encoded3).b() : new r.d(value4, this.f52064a.o(type, annotationArr), encoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new r.d(value4, this.f52064a.o(f0.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                }
                throw f0.o(this.f52065b, i6, h11.getSimpleName() + " must include generic type (e.g., " + h11.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                j(i6, type);
                if (!this.f52079p) {
                    throw f0.o(this.f52065b, i6, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> h12 = f0.h(type);
                if (!Map.class.isAssignableFrom(h12)) {
                    throw f0.o(this.f52065b, i6, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type i9 = f0.i(type, h12, Map.class);
                if (!(i9 instanceof ParameterizedType)) {
                    throw f0.o(this.f52065b, i6, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) i9;
                Type g8 = f0.g(0, parameterizedType3);
                if (String.class == g8) {
                    g o5 = this.f52064a.o(f0.g(1, parameterizedType3), annotationArr);
                    this.f52069f = true;
                    return new r.e(this.f52065b, i6, o5, ((FieldMap) annotation).encoded());
                }
                throw f0.o(this.f52065b, i6, "@FieldMap keys must be of type String: " + g8, new Object[0]);
            }
            if (annotation instanceof Part) {
                j(i6, type);
                if (!this.f52080q) {
                    throw f0.o(this.f52065b, i6, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.f52070g = true;
                String value5 = part.value();
                Class<?> h13 = f0.h(type);
                if (value5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(h13)) {
                        if (h13.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(h13.getComponentType())) {
                                return r.o.f52223a.b();
                            }
                            throw f0.o(this.f52065b, i6, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(h13)) {
                            return r.o.f52223a;
                        }
                        throw f0.o(this.f52065b, i6, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (MultipartBody.Part.class.isAssignableFrom(f0.h(f0.g(0, (ParameterizedType) type)))) {
                            return r.o.f52223a.c();
                        }
                        throw f0.o(this.f52065b, i6, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw f0.o(this.f52065b, i6, h13.getSimpleName() + " must include generic type (e.g., " + h13.getSimpleName() + "<String>)", new Object[0]);
                }
                Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + "\"", HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, part.encoding());
                if (!Iterable.class.isAssignableFrom(h13)) {
                    if (!h13.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(h13)) {
                            throw f0.o(this.f52065b, i6, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new r.i(this.f52065b, i6, of, this.f52064a.m(type, annotationArr, this.f52066c));
                    }
                    Class<?> a6 = a(h13.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(a6)) {
                        throw f0.o(this.f52065b, i6, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new r.i(this.f52065b, i6, of, this.f52064a.m(a6, annotationArr, this.f52066c)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type g9 = f0.g(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(f0.h(g9))) {
                        throw f0.o(this.f52065b, i6, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new r.i(this.f52065b, i6, of, this.f52064a.m(g9, annotationArr, this.f52066c)).c();
                }
                throw f0.o(this.f52065b, i6, h13.getSimpleName() + " must include generic type (e.g., " + h13.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof PartMap) {
                j(i6, type);
                if (!this.f52080q) {
                    throw f0.o(this.f52065b, i6, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f52070g = true;
                Class<?> h14 = f0.h(type);
                if (!Map.class.isAssignableFrom(h14)) {
                    throw f0.o(this.f52065b, i6, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type i10 = f0.i(type, h14, Map.class);
                if (!(i10 instanceof ParameterizedType)) {
                    throw f0.o(this.f52065b, i6, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) i10;
                Type g10 = f0.g(0, parameterizedType4);
                if (String.class == g10) {
                    Type g11 = f0.g(1, parameterizedType4);
                    if (MultipartBody.Part.class.isAssignableFrom(f0.h(g11))) {
                        throw f0.o(this.f52065b, i6, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new r.j(this.f52065b, i6, this.f52064a.m(g11, annotationArr, this.f52066c), ((PartMap) annotation).encoding());
                }
                throw f0.o(this.f52065b, i6, "@PartMap keys must be of type String: " + g10, new Object[0]);
            }
            if (annotation instanceof Body) {
                j(i6, type);
                if (this.f52079p || this.f52080q) {
                    throw f0.o(this.f52065b, i6, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f52071h) {
                    throw f0.o(this.f52065b, i6, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    g m6 = this.f52064a.m(type, annotationArr, this.f52066c);
                    this.f52071h = true;
                    return new r.c(this.f52065b, i6, m6);
                } catch (RuntimeException e6) {
                    throw f0.p(this.f52065b, e6, i6, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof Tag)) {
                return null;
            }
            j(i6, type);
            Class<?> h15 = f0.h(type);
            for (int i11 = i6 - 1; i11 >= 0; i11--) {
                r<?> rVar = this.f52085v[i11];
                if ((rVar instanceof r.q) && ((r.q) rVar).f52226a.equals(h15)) {
                    throw f0.o(this.f52065b, i6, "@Tag type " + h15.getName() + " is duplicate of parameter #" + (i11 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new r.q(h15);
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw f0.m(this.f52065b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.f52083t = MediaType.get(trim);
                    } catch (IllegalArgumentException e6) {
                        throw f0.n(this.f52065b, e6, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z5) {
            String str3 = this.f52077n;
            if (str3 != null) {
                throw f0.m(this.f52065b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f52077n = str;
            this.f52078o = z5;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (f52062y.matcher(substring).find()) {
                    throw f0.m(this.f52065b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.f52081r = str2;
            this.f52084u = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof DELETE) {
                d("DELETE", ((DELETE) annotation).value(), false);
                return;
            }
            if (annotation instanceof GET) {
                d("GET", ((GET) annotation).value(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                d("HEAD", ((HEAD) annotation).value(), false);
                return;
            }
            if (annotation instanceof PATCH) {
                d("PATCH", ((PATCH) annotation).value(), true);
                return;
            }
            if (annotation instanceof POST) {
                d("POST", ((POST) annotation).value(), true);
                return;
            }
            if (annotation instanceof PUT) {
                d("PUT", ((PUT) annotation).value(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                d("OPTIONS", ((OPTIONS) annotation).value(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                d(http.method(), http.path(), http.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                String[] value = ((retrofit2.http.Headers) annotation).value();
                if (value.length == 0) {
                    throw f0.m(this.f52065b, "@Headers annotation is empty.", new Object[0]);
                }
                this.f52082s = c(value);
                return;
            }
            if (annotation instanceof Multipart) {
                if (this.f52079p) {
                    throw f0.m(this.f52065b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f52080q = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.f52080q) {
                    throw f0.m(this.f52065b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f52079p = true;
            }
        }

        static Set<String> h(String str) {
            Matcher matcher = f52062y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i6, String str) {
            if (!f52063z.matcher(str).matches()) {
                throw f0.o(this.f52065b, i6, "@Path parameter name must match %s. Found: %s", f52062y.pattern(), str);
            }
            if (!this.f52084u.contains(str)) {
                throw f0.o(this.f52065b, i6, "URL \"%s\" does not contain \"{%s}\".", this.f52081r, str);
            }
        }

        b0 b() {
            for (Annotation annotation : this.f52066c) {
                e(annotation);
            }
            if (this.f52077n == null) {
                throw f0.m(this.f52065b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f52078o) {
                if (this.f52080q) {
                    throw f0.m(this.f52065b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f52079p) {
                    throw f0.m(this.f52065b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f52067d.length;
            this.f52085v = new r[length];
            int i6 = length - 1;
            int i7 = 0;
            while (true) {
                boolean z5 = true;
                if (i7 >= length) {
                    break;
                }
                r<?>[] rVarArr = this.f52085v;
                Type type = this.f52068e[i7];
                Annotation[] annotationArr = this.f52067d[i7];
                if (i7 != i6) {
                    z5 = false;
                }
                rVarArr[i7] = f(i7, type, annotationArr, z5);
                i7++;
            }
            if (this.f52081r == null && !this.f52076m) {
                throw f0.m(this.f52065b, "Missing either @%s URL or @Url parameter.", this.f52077n);
            }
            boolean z6 = this.f52079p;
            if (!z6 && !this.f52080q && !this.f52078o && this.f52071h) {
                throw f0.m(this.f52065b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z6 && !this.f52069f) {
                throw f0.m(this.f52065b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f52080q || this.f52070g) {
                return new b0(this);
            }
            throw f0.m(this.f52065b, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        a(d0 d0Var, Method method) {
            this.f52064a = d0Var;
            this.f52065b = method;
            this.f52066c = method.getAnnotations();
            this.f52068e = method.getGenericParameterTypes();
            this.f52067d = method.getParameterAnnotations();
        }

        private void j(int i6, Type type) {
            if (!f0.j(type)) {
            } else {
                throw f0.o(this.f52065b, i6, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    static b0 b(d0 d0Var, Method method) {
        return new a(d0Var, method).b();
    }

    Request a(Object[] objArr) throws IOException {
        r<?>[] rVarArr = this.f52059j;
        int length = objArr.length;
        if (length != rVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + rVarArr.length + ")");
        }
        a0 a0Var = new a0(this.f52052c, this.f52051b, this.f52053d, this.f52054e, this.f52055f, this.f52056g, this.f52057h, this.f52058i);
        if (this.f52060k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i6 = 0; i6 < length; i6++) {
            arrayList.add(objArr[i6]);
            rVarArr[i6].a(a0Var, objArr[i6]);
        }
        return a0Var.k().tag((Class<? super Class>) l.class, (Class) new l(this.f52050a, arrayList)).build();
    }

    b0(a aVar) {
        this.f52050a = aVar.f52065b;
        this.f52051b = aVar.f52064a.f52099c;
        this.f52052c = aVar.f52077n;
        this.f52053d = aVar.f52081r;
        this.f52054e = aVar.f52082s;
        this.f52055f = aVar.f52083t;
        this.f52056g = aVar.f52078o;
        this.f52057h = aVar.f52079p;
        this.f52058i = aVar.f52080q;
        this.f52059j = aVar.f52085v;
        this.f52060k = aVar.f52086w;
    }
}
