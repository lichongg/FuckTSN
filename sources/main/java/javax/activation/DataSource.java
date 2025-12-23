package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface DataSource {
    String getContentType();

    InputStream getInputStream() throws IOException;

    String getName();

    OutputStream getOutputStream() throws IOException;
}
