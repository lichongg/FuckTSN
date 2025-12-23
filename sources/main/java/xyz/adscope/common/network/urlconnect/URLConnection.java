package xyz.adscope.common.network.urlconnect;

import android.text.TextUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.connect.stream.NullStream;
import xyz.adscope.common.network.connect.stream.SourceStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class URLConnection implements Connection {

    /* renamed from: a, reason: collision with root package name */
    private HttpURLConnection f56727a;

    /* renamed from: b, reason: collision with root package name */
    private String f56728b = "Location";

    private static boolean a(int i6) {
        if (i6 <= 100 || i6 == 204 || i6 == 205) {
            return false;
        }
        return i6 < 300 || i6 >= 400;
    }

    private static InputStream a(String str, InputStream inputStream) {
        return (TextUtils.isEmpty(str) || !str.contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HttpURLConnection httpURLConnection = this.f56727a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public void disconnect() {
        HttpURLConnection httpURLConnection = this.f56727a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public int getCode() {
        return this.f56727a.getResponseCode();
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public Map<String, List<String>> getHeaders() {
        return this.f56727a.getHeaderFields();
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public InputStream getInputStream() {
        int responseCode = this.f56727a.getResponseCode();
        return !a(this.f56727a.getRequestMethod(), responseCode) ? new NullStream(this) : responseCode >= 400 ? a(this.f56727a.getContentEncoding(), new SourceStream(this, this.f56727a.getErrorStream())) : a(this.f56727a.getContentEncoding(), new SourceStream(this, this.f56727a.getInputStream()));
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public String getLocationUrl() {
        return this.f56727a.getHeaderField(this.f56728b);
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public OutputStream getOutputStream() {
        return this.f56727a.getOutputStream();
    }

    public URLConnection(HttpURLConnection httpURLConnection) {
        this.f56727a = httpURLConnection;
    }

    private static boolean a(String str, int i6) {
        return !"HEAD".equalsIgnoreCase(str) && a(i6);
    }
}
