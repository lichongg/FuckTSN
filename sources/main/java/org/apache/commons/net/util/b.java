package org.apache.commons.net.util;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {
    public static Charset a(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    public static Charset b(String str, String str2) {
        return str == null ? Charset.forName(str2) : Charset.forName(str);
    }
}
