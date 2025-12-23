package io.netty.handler.codec.http.websocketx.extensions;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WebSocketExtensionData {
    private final String name;
    private final Map<String, String> parameters;

    public String name() {
        return this.name;
    }

    public Map<String, String> parameters() {
        return this.parameters;
    }

    public WebSocketExtensionData(String str, Map<String, String> map) {
        if (str != null) {
            if (map != null) {
                this.name = str;
                this.parameters = Collections.unmodifiableMap(map);
                return;
            }
            throw new NullPointerException("parameters");
        }
        throw new NullPointerException(CommonNetImpl.NAME);
    }
}
