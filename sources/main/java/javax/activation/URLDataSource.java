package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class URLDataSource implements DataSource {
    private URL url;
    private URLConnection url_conn = null;

    @Override // javax.activation.DataSource
    public String getContentType() {
        try {
            if (this.url_conn == null) {
                this.url_conn = this.url.openConnection();
            }
        } catch (IOException unused) {
        }
        URLConnection uRLConnection = this.url_conn;
        String contentType = uRLConnection != null ? uRLConnection.getContentType() : null;
        return contentType == null ? "application/octet-stream" : contentType;
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        return this.url.openStream();
    }

    @Override // javax.activation.DataSource
    public String getName() {
        return this.url.getFile();
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        URLConnection openConnection = this.url.openConnection();
        this.url_conn = openConnection;
        if (openConnection == null) {
            return null;
        }
        openConnection.setDoOutput(true);
        return this.url_conn.getOutputStream();
    }

    public URL getURL() {
        return this.url;
    }

    public URLDataSource(URL url) {
        this.url = url;
    }
}
