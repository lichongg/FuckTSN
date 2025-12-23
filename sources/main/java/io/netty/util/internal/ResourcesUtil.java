package io.netty.util.internal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ResourcesUtil {
    public static File getFile(Class cls, String str) {
        try {
            return new File(URLDecoder.decode(cls.getResource(str).getFile(), "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return new File(cls.getResource(str).getFile());
        }
    }

    private ResourcesUtil() {
    }
}
