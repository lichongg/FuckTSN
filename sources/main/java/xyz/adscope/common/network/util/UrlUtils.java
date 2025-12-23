package xyz.adscope.common.network.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UrlUtils {
    public static String urlDecode(String str, String str2) {
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String urlEncode(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String urlDecode(String str, Charset charset) {
        return urlDecode(str, charset.name());
    }

    public static String urlEncode(String str, Charset charset) {
        return urlEncode(str, charset.name());
    }
}
