package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class a0 {

    /* renamed from: m, reason: collision with root package name */
    private static final String f52007m = " \"<>^`{}|\\?#";

    /* renamed from: a, reason: collision with root package name */
    private final String f52009a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpUrl f52010b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private String f52011c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private HttpUrl.Builder f52012d;

    /* renamed from: e, reason: collision with root package name */
    private final Request.Builder f52013e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    private final Headers.Builder f52014f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private MediaType f52015g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f52016h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private MultipartBody.Builder f52017i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private FormBody.Builder f52018j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private RequestBody f52019k;

    /* renamed from: l, reason: collision with root package name */
    private static final char[] f52006l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f52008n = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        private final RequestBody f52020a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaType f52021b;

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f52020a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f52021b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f52020a.writeTo(bufferedSink);
        }

        a(RequestBody requestBody, MediaType mediaType) {
            this.f52020a = requestBody;
            this.f52021b = mediaType;
        }
    }

    private static void j(Buffer buffer, String str, int i6, int i7, boolean z5) {
        Buffer buffer2 = null;
        while (i6 < i7) {
            int codePointAt = str.codePointAt(i6);
            if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || f52007m.indexOf(codePointAt) != -1 || (!z5 && (codePointAt == 47 || codePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = f52006l;
                        buffer.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i6 += Character.charCount(codePointAt);
        }
    }

    void a(String str, String str2, boolean z5) {
        if (z5) {
            this.f52018j.addEncoded(str, str2);
        } else {
            this.f52018j.add(str, str2);
        }
    }

    void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f52014f.add(str, str2);
            return;
        }
        try {
            this.f52015g = MediaType.get(str2);
        } catch (IllegalArgumentException e6) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e6);
        }
    }

    void c(Headers headers) {
        this.f52014f.addAll(headers);
    }

    void d(Headers headers, RequestBody requestBody) {
        this.f52017i.addPart(headers, requestBody);
    }

    void e(MultipartBody.Part part) {
        this.f52017i.addPart(part);
    }

    void f(String str, String str2, boolean z5) {
        if (this.f52011c == null) {
            throw new AssertionError();
        }
        String i6 = i(str2, z5);
        String replace = this.f52011c.replace("{" + str + "}", i6);
        if (!f52008n.matcher(replace).matches()) {
            this.f52011c = replace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void g(String str, @Nullable String str2, boolean z5) {
        String str3 = this.f52011c;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.f52010b.newBuilder(str3);
            this.f52012d = newBuilder;
            if (newBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f52010b + ", Relative: " + this.f52011c);
            }
            this.f52011c = null;
        }
        if (z5) {
            this.f52012d.addEncodedQueryParameter(str, str2);
        } else {
            this.f52012d.addQueryParameter(str, str2);
        }
    }

    <T> void h(Class<T> cls, @Nullable T t5) {
        this.f52013e.tag((Class<? super Class<T>>) cls, (Class<T>) t5);
    }

    Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f52012d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.f52010b.resolve(this.f52011c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f52010b + ", Relative: " + this.f52011c);
            }
        }
        RequestBody requestBody = this.f52019k;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.f52018j;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f52017i;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.f52016h) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f52015g;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new a(requestBody, mediaType);
            } else {
                this.f52014f.add("Content-Type", mediaType.toString());
            }
        }
        return this.f52013e.url(resolve).headers(this.f52014f.build()).method(this.f52009a, requestBody);
    }

    void l(RequestBody requestBody) {
        this.f52019k = requestBody;
    }

    a0(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z5, boolean z6, boolean z7) {
        this.f52009a = str;
        this.f52010b = httpUrl;
        this.f52011c = str2;
        this.f52015g = mediaType;
        this.f52016h = z5;
        if (headers != null) {
            this.f52014f = headers.newBuilder();
        } else {
            this.f52014f = new Headers.Builder();
        }
        if (z6) {
            this.f52018j = new FormBody.Builder();
        } else if (z7) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f52017i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String i(String str, boolean z5) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            int codePointAt = str.codePointAt(i6);
            if (codePointAt >= 32 && codePointAt < 127 && f52007m.indexOf(codePointAt) == -1 && (z5 || (codePointAt != 47 && codePointAt != 37))) {
                i6 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i6);
                j(buffer, str, i6, length, z5);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    void m(Object obj) {
        this.f52011c = obj.toString();
    }
}
