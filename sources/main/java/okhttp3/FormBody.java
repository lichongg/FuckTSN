package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.url._UrlKt;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FormBody extends RequestBody {

    @NotNull
    private final List<String> encodedNames;

    @NotNull
    private final List<String> encodedValues;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        @Nullable
        private final Charset charset;

        @NotNull
        private final List<String> names;

        @NotNull
        private final List<String> values;

        @JvmOverloads
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @JvmOverloads
        public Builder(@Nullable Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            this.names.add(_UrlKt.canonicalizeWithCharset$default(name, 0, 0, _UrlKt.FORM_ENCODE_SET, false, false, false, false, this.charset, 91, null));
            this.values.add(_UrlKt.canonicalizeWithCharset$default(value, 0, 0, _UrlKt.FORM_ENCODE_SET, false, false, false, false, this.charset, 91, null));
            return this;
        }

        @NotNull
        public final Builder addEncoded(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            this.names.add(_UrlKt.canonicalizeWithCharset$default(name, 0, 0, _UrlKt.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(_UrlKt.canonicalizeWithCharset$default(value, 0, 0, _UrlKt.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        @NotNull
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public /* synthetic */ Builder(Charset charset, int i6, v vVar) {
            this((i6 & 1) != 0 ? null : charset);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    public FormBody(@NotNull List<String> encodedNames, @NotNull List<String> encodedValues) {
        g0.p(encodedNames, "encodedNames");
        g0.p(encodedValues, "encodedValues");
        this.encodedNames = _UtilJvmKt.toImmutableList(encodedNames);
        this.encodedValues = _UtilJvmKt.toImmutableList(encodedValues);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z5) {
        Buffer buffer;
        if (z5) {
            buffer = new Buffer();
        } else {
            g0.m(bufferedSink);
            buffer = bufferedSink.getBuffer();
        }
        int size = this.encodedNames.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i6));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i6));
        }
        if (!z5) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // okhttp3.RequestBody
    @NotNull
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @NotNull
    public final String encodedName(int i6) {
        return this.encodedNames.get(i6);
    }

    @NotNull
    public final String encodedValue(int i6) {
        return this.encodedValues.get(i6);
    }

    @JvmName(name = "size")
    public final int size() {
        return this.encodedNames.size();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) throws IOException {
        g0.p(sink, "sink");
        writeOrCountBytes(sink, false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m188deprecated_size() {
        return size();
    }

    @NotNull
    public final String name(int i6) {
        return _UrlKt.percentDecode$default(encodedName(i6), 0, 0, true, 3, null);
    }

    @NotNull
    public final String value(int i6) {
        return _UrlKt.percentDecode$default(encodedValue(i6), 0, 0, true, 3, null);
    }
}
