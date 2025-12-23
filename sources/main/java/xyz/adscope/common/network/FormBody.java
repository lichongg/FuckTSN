package xyz.adscope.common.network;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.commons.net.g;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.util.IOUtils;
import xyz.adscope.common.network.util.LengthOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FormBody extends BaseContent<FormBody> implements RequestBody {

    /* renamed from: b, reason: collision with root package name */
    private final Charset f56469b;

    /* renamed from: c, reason: collision with root package name */
    private final String f56470c;

    /* renamed from: d, reason: collision with root package name */
    private final Params f56471d;

    /* renamed from: e, reason: collision with root package name */
    private String f56472e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.FormBody$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Charset f56473a;

        /* renamed from: b, reason: collision with root package name */
        private String f56474b;

        /* renamed from: c, reason: collision with root package name */
        private Params.Builder f56475c;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder param(String str, int i6) {
            this.f56475c.add(str, i6);
            return this;
        }

        private Builder() {
            this.f56475c = Params.newBuilder();
        }

        public Builder binaries(String str, List<Binary> list) {
            this.f56475c.binaries(str, list);
            return this;
        }

        public Builder binary(String str, Binary binary) {
            this.f56475c.binary(str, binary);
            return this;
        }

        public FormBody build() {
            return new FormBody(this, null);
        }

        public Builder charset(Charset charset) {
            this.f56473a = charset;
            return this;
        }

        public Builder clearParams() {
            this.f56475c.clear();
            return this;
        }

        public Builder contentType(String str) {
            this.f56474b = str;
            return this;
        }

        public Builder file(String str, File file) {
            this.f56475c.file(str, file);
            return this;
        }

        public Builder files(String str, List<File> list) {
            this.f56475c.files(str, list);
            return this;
        }

        public Builder param(String str, long j6) {
            this.f56475c.add(str, j6);
            return this;
        }

        public Builder params(Params params) {
            this.f56475c.add(params);
            return this;
        }

        public Builder removeParam(String str) {
            this.f56475c.remove(str);
            return this;
        }

        public Builder param(String str, boolean z5) {
            this.f56475c.add(str, z5);
            return this;
        }

        public Builder param(String str, char c6) {
            this.f56475c.add(str, c6);
            return this;
        }

        public Builder param(String str, double d6) {
            this.f56475c.add(str, d6);
            return this;
        }

        public Builder param(String str, float f6) {
            this.f56475c.add(str, f6);
            return this;
        }

        public Builder param(String str, short s5) {
            this.f56475c.add(str, s5);
            return this;
        }

        public Builder param(String str, CharSequence charSequence) {
            this.f56475c.add(str, charSequence);
            return this;
        }

        public Builder param(String str, String str2) {
            this.f56475c.add(str, str2);
            return this;
        }

        public Builder param(String str, List<String> list) {
            this.f56475c.add(str, list);
            return this;
        }
    }

    /* synthetic */ FormBody(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @Override // xyz.adscope.common.network.BaseContent
    protected void a(OutputStream outputStream) {
        for (String str : this.f56471d.keySet()) {
            for (Object obj : this.f56471d.get(str)) {
                if (obj instanceof String) {
                    a(outputStream, str, (String) obj);
                } else if (obj instanceof Binary) {
                    a(outputStream, str, (Binary) obj);
                }
            }
        }
        IOUtils.write(outputStream, g.f50795q, this.f56469b);
        IOUtils.write(outputStream, "--" + this.f56472e + "--\r\n", this.f56469b);
    }

    private FormBody(Builder builder) {
        this.f56469b = builder.f56473a == null ? Kalle.getConfig().getCharset() : builder.f56473a;
        this.f56470c = TextUtils.isEmpty(builder.f56474b) ? "multipart/form-data" : builder.f56474b;
        this.f56471d = builder.f56475c.build();
        this.f56472e = a();
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        LengthOutputStream lengthOutputStream = new LengthOutputStream();
        try {
            a(lengthOutputStream);
        } catch (IOException unused) {
        }
        return lengthOutputStream.getLength();
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        return this.f56470c + "; boundary=" + this.f56472e;
    }

    public Params copyParams() {
        return this.f56471d;
    }

    private void a(OutputStream outputStream, String str, String str2) {
        IOUtils.write(outputStream, "--" + this.f56472e + g.f50795q, this.f56469b);
        IOUtils.write(outputStream, "Content-Disposition: form-data; name=\"" + str + "\"", this.f56469b);
        IOUtils.write(outputStream, "\r\n\r\n", this.f56469b);
        IOUtils.write(outputStream, str2, this.f56469b);
        IOUtils.write(outputStream, g.f50795q, this.f56469b);
    }

    private void a(OutputStream outputStream, String str, Binary binary) {
        IOUtils.write(outputStream, "--" + this.f56472e + g.f50795q, this.f56469b);
        IOUtils.write(outputStream, "Content-Disposition: form-data; name=\"" + str + "\"", this.f56469b);
        IOUtils.write(outputStream, "; filename=\"" + binary.name() + "\"", this.f56469b);
        IOUtils.write(outputStream, g.f50795q, this.f56469b);
        IOUtils.write(outputStream, "Content-Type: " + binary.contentType() + "\r\n\r\n", this.f56469b);
        if (outputStream instanceof LengthOutputStream) {
            ((LengthOutputStream) outputStream).write(binary.contentLength());
        } else {
            binary.writeTo(outputStream);
        }
        IOUtils.write(outputStream, g.f50795q, this.f56469b);
    }

    private static String a() {
        StringBuilder sb = new StringBuilder("-------FormBoundary");
        for (int i6 = 1; i6 < 12; i6++) {
            long currentTimeMillis = System.currentTimeMillis() + i6;
            long j6 = currentTimeMillis % 3;
            if (j6 == 0) {
                sb.append(((char) currentTimeMillis) % '\t');
            } else if (j6 == 1) {
                sb.append((char) ((currentTimeMillis % 26) + 65));
            } else {
                sb.append((char) ((currentTimeMillis % 26) + 97));
            }
        }
        return sb.toString();
    }
}
