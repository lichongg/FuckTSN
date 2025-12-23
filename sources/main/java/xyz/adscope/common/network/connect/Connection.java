package xyz.adscope.common.network.connect;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface Connection extends Closeable {
    void disconnect();

    int getCode();

    Map<String, List<String>> getHeaders();

    InputStream getInputStream();

    String getLocationUrl();

    OutputStream getOutputStream();
}
