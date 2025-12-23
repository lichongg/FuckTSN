package xyz.adscope.common.network;

import android.text.TextUtils;
import java.io.OutputStream;
import java.nio.charset.Charset;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StringBody extends BaseContent<StringBody> implements RequestBody {

    /* renamed from: b, reason: collision with root package name */
    private final String f56539b;

    /* renamed from: c, reason: collision with root package name */
    private final Charset f56540c;

    /* renamed from: d, reason: collision with root package name */
    private final String f56541d;

    public StringBody(String str) {
        this(str, Kalle.getConfig().getCharset());
    }

    public StringBody(String str, Charset charset) {
        this(str, charset, "application/octet-stream");
    }

    @Override // xyz.adscope.common.network.BaseContent
    protected void a(OutputStream outputStream) {
        IOUtils.write(outputStream, this.f56539b, this.f56540c);
    }

    @Override // xyz.adscope.common.network.Content
    public long contentLength() {
        if (TextUtils.isEmpty(this.f56539b)) {
            return 0L;
        }
        return IOUtils.toByteArray(this.f56539b, this.f56540c).length;
    }

    @Override // xyz.adscope.common.network.Content
    public String contentType() {
        return this.f56541d + "; charset=" + this.f56540c.name();
    }

    public String toString() {
        return this.f56539b;
    }

    public StringBody(String str, String str2) {
        this(str, Kalle.getConfig().getCharset(), str2);
    }

    public StringBody(String str, Charset charset, String str2) {
        this.f56539b = str;
        this.f56540c = charset;
        this.f56541d = str2;
    }
}
