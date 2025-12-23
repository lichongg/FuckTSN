package xyz.adscope.common.network;

import android.text.TextUtils;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UrlBody extends BaseContent<StringBody> implements RequestBody {

    /* renamed from: b, reason: collision with root package name */
    private final Params f56554b;

    /* renamed from: c, reason: collision with root package name */
    private final Charset f56555c;

    /* renamed from: d, reason: collision with root package name */
    private final String f56556d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.UrlBody$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Charset f56557a;

        /* renamed from: b, reason: collision with root package name */
        private String f56558b;

        /* renamed from: c, reason: collision with root package name */
        private Params.Builder f56559c;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder param(String str, int i6) {
            this.f56559c.add(str, i6);
            return this;
        }

        private Builder() {
            this.f56559c = Params.newBuilder();
        }

        public UrlBody build() {
            return new UrlBody(this, null);
        }

        public Builder charset(Charset charset) {
            this.f56557a = charset;
            return this;
        }

        public Builder clearParams() {
            this.f56559c.clear();
            return this;
        }

        public Builder contentType(String str) {
            this.f56558b = str;
            return this;
        }

        public Builder param(String str, long j6) {
            this.f56559c.add(str, j6);
            return this;
        }

        public Builder params(Params params) {
            this.f56559c.add(params);
            return this;
        }

        public Builder removeParam(String str) {
            this.f56559c.remove(str);
            return this;
        }

        public Builder param(String str, boolean z5) {
            this.f56559c.add(str, z5);
            return this;
        }

        public Builder param(String str, char c6) {
            this.f56559c.add(str, c6);
            return this;
        }

        public Builder param(String str, double d6) {
            this.f56559c.add(str, d6);
            return this;
        }

        public Builder param(String str, float f6) {
            this.f56559c.add(str, f6);
            return this;
        }

        public Builder param(String str, short s5) {
            this.f56559c.add(str, s5);
            return this;
        }

        public Builder param(String str, CharSequence charSequence) {
            this.f56559c.add(str, charSequence);
            return this;
        }

        public Builder param(String str, String str2) {
            this.f56559c.add(str, str2);
            return this;
        }

        public Builder param(String str, List<String> list) {
            this.f56559c.add(str, list);
            return this;
        }
    }

    /* synthetic */ UrlBody(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return toString(false);
    }

    private UrlBody(Builder builder) {
        this.f56554b = builder.f56559c.build();
        this.f56555c = builder.f56557a == null ? Kalle.getConfig().getCharset() : builder.f56557a;
        this.f56556d = TextUtils.isEmpty(builder.f56558b) ? "application/x-www-form-urlencoded" : builder.f56558b;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Override // xyz.adscope.common.network.BaseContent
    protected void a(OutputStream outputStream) {
        IOUtils.write(outputStream, this.f56554b.toString(true), this.f56555c);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        return IOUtils.toByteArray(this.f56554b.toString(true), this.f56555c).length;
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        return this.f56556d + "; charset=" + this.f56555c.name();
    }

    public Params copyParams() {
        return this.f56554b;
    }

    public String toString(boolean z5) {
        return this.f56554b.toString(z5);
    }
}
