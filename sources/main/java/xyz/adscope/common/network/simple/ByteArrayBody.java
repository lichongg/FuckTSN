package xyz.adscope.common.network.simple;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.ResponseBody;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ByteArrayBody implements ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    private String f56671a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f56672b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f56672b = null;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public byte[] byteArray() {
        return this.f56672b;
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public InputStream stream() {
        return new ByteArrayInputStream(this.f56672b);
    }

    @Override // xyz.adscope.common.network.ResponseBody
    public String string() {
        String parseSubValue = Headers.parseSubValue(this.f56671a, "charset", null);
        return TextUtils.isEmpty(parseSubValue) ? IOUtils.toString(this.f56672b) : IOUtils.toString(this.f56672b, parseSubValue);
    }

    public ByteArrayBody(String str, byte[] bArr) {
        this.f56671a = str;
        this.f56672b = bArr;
    }
}
