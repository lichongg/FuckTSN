package okhttp3;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,381:1\n1761#2,3:382\n*S KotlinDebug\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody\n*L\n52#1:382,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MultipartBody extends RequestBody {

    @JvmField
    @NotNull
    public static final MediaType ALTERNATIVE;

    @NotNull
    private static final byte[] COLONSPACE;

    @NotNull
    private static final byte[] CRLF;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final byte[] DASHDASH;

    @JvmField
    @NotNull
    public static final MediaType DIGEST;

    @JvmField
    @NotNull
    public static final MediaType FORM;

    @JvmField
    @NotNull
    public static final MediaType MIXED;

    @JvmField
    @NotNull
    public static final MediaType PARALLEL;

    @NotNull
    private final ByteString boundaryByteString;
    private long contentLength;

    @NotNull
    private final MediaType contentType;

    @NotNull
    private final List<Part> parts;

    @NotNull
    private final MediaType type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
    public static final class Builder {

        @NotNull
        private final ByteString boundary;

        @NotNull
        private final List<Part> parts;

        @NotNull
        private MediaType type;

        @JvmOverloads
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        @NotNull
        public final Builder addPart(@NotNull RequestBody body) {
            g0.p(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        @JvmOverloads
        public Builder(@NotNull String boundary) {
            g0.p(boundary, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        @NotNull
        public final Builder addFormDataPart(@NotNull String name, @Nullable String str, @NotNull RequestBody body) {
            g0.p(name, "name");
            g0.p(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        @NotNull
        public final Builder addPart(@Nullable Headers headers, @NotNull RequestBody body) {
            g0.p(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        @NotNull
        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, _UtilJvmKt.toImmutableList(this.parts));
        }

        @NotNull
        public final Builder setType(@NotNull MediaType type) {
            g0.p(type, "type");
            if (g0.g(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        @NotNull
        public final Builder addPart(@NotNull Part part) {
            g0.p(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Builder(java.lang.String r1, int r2, kotlin.jvm.internal.v r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L11
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "toString(...)"
                kotlin.jvm.internal.g0.o(r1, r2)
            L11:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.Builder.<init>(java.lang.String, int, kotlin.jvm.internal.v):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        public final void appendQuotedString$okhttp(@NotNull StringBuilder sb, @NotNull String key) {
            g0.p(sb, "<this>");
            g0.p(key, "key");
            sb.append('\"');
            int length = key.length();
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = key.charAt(i6);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt != '\"') {
                    sb.append(charAt);
                } else {
                    sb.append("%22");
                }
            }
            sb.append('\"');
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Part {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final RequestBody body;

        @Nullable
        private final Headers headers;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nMultipartBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartBody.kt\nokhttp3/MultipartBody$Part$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Part create(@NotNull RequestBody body) {
                g0.p(body, "body");
                return create(null, body);
            }

            @JvmStatic
            @NotNull
            public final Part createFormData(@NotNull String name, @NotNull String value) {
                g0.p(name, "name");
                g0.p(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Part create(@Nullable Headers headers, @NotNull RequestBody body) {
                g0.p(body, "body");
                v vVar = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, body, vVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            @JvmStatic
            @NotNull
            public final Part createFormData(@NotNull String name, @Nullable String str, @NotNull RequestBody body) {
                g0.p(name, "name");
                g0.p(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str);
                }
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), body);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, v vVar) {
            this(headers, requestBody);
        }

        @JvmStatic
        @NotNull
        public static final Part create(@Nullable Headers headers, @NotNull RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        @JvmStatic
        @NotNull
        public static final Part createFormData(@NotNull String str, @NotNull String str2) {
            return Companion.createFormData(str, str2);
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        @JvmStatic
        @NotNull
        public static final Part create(@NotNull RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        @JvmStatic
        @NotNull
        public static final Part createFormData(@NotNull String str, @Nullable String str2, @NotNull RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
        @JvmName(name = "-deprecated_body")
        @NotNull
        /* renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m230deprecated_body() {
            return this.body;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
        @JvmName(name = "-deprecated_headers")
        @Nullable
        /* renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m231deprecated_headers() {
            return this.headers;
        }

        @JvmName(name = "body")
        @NotNull
        public final RequestBody body() {
            return this.body;
        }

        @JvmName(name = "headers")
        @Nullable
        public final Headers headers() {
            return this.headers;
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{HttpConstants.COLON, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(@NotNull ByteString boundaryByteString, @NotNull MediaType type, @NotNull List<Part> parts) {
        g0.p(boundaryByteString, "boundaryByteString");
        g0.p(type, "type");
        g0.p(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z5) throws IOException {
        Buffer buffer;
        if (z5) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.parts.size();
        long j6 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Part part = this.parts.get(i6);
            Headers headers = part.headers();
            RequestBody body = part.body();
            g0.m(bufferedSink);
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundaryByteString);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    bufferedSink.writeUtf8(headers.name(i7)).write(COLONSPACE).writeUtf8(headers.value(i7)).write(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength == -1 && z5) {
                g0.m(buffer);
                buffer.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink.write(bArr);
            if (z5) {
                j6 += contentLength;
            } else {
                body.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        g0.m(bufferedSink);
        byte[] bArr2 = DASHDASH;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.boundaryByteString);
        bufferedSink.write(bArr2);
        bufferedSink.write(CRLF);
        if (!z5) {
            return j6;
        }
        g0.m(buffer);
        long size3 = j6 + buffer.size();
        buffer.clear();
        return size3;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "parts", imports = {}))
    @JvmName(name = "-deprecated_parts")
    @NotNull
    /* renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m227deprecated_parts() {
        return this.parts;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    @JvmName(name = "-deprecated_type")
    @NotNull
    /* renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m229deprecated_type() {
        return this.type;
    }

    @JvmName(name = HttpHeaders.Values.BOUNDARY)
    @NotNull
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j6 = this.contentLength;
        if (j6 != -1) {
            return j6;
        }
        long writeOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        List<Part> list = this.parts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Part) it.next()).body().isOneShot()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Part part(int i6) {
        return this.parts.get(i6);
    }

    @JvmName(name = "parts")
    @NotNull
    public final List<Part> parts() {
        return this.parts;
    }

    @JvmName(name = "size")
    public final int size() {
        return this.parts.size();
    }

    @JvmName(name = "type")
    @NotNull
    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        g0.p(sink, "sink");
        writeOrCountBytes(sink, false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = HttpHeaders.Values.BOUNDARY, imports = {}))
    @JvmName(name = "-deprecated_boundary")
    @NotNull
    /* renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m226deprecated_boundary() {
        return boundary();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m228deprecated_size() {
        return size();
    }
}
