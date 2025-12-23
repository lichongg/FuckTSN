package xyz.adscope.common.network.connect;

import android.text.TextUtils;
import java.io.InputStream;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.ResponseBody;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StreamBody implements ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    private String f56567a;

    /* renamed from: b, reason: collision with root package name */
    private InputStream f56568b;

    @Override // xyz.adscope.common.network.ResponseBody
    public byte[] byteArray() {
        return IOUtils.toByteArray(this.f56568b);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f56568b.close();
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public InputStream stream() {
        return this.f56568b;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public String string() {
        String parseSubValue = Headers.parseSubValue(this.f56567a, "charset", null);
        return TextUtils.isEmpty(parseSubValue) ? IOUtils.toString(this.f56568b) : IOUtils.toString(this.f56568b, parseSubValue);
    }

    public StreamBody(String str, InputStream inputStream) {
        this.f56567a = str;
        this.f56568b = inputStream;
    }
}
