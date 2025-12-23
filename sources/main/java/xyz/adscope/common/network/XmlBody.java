package xyz.adscope.common.network;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class XmlBody extends StringBody {
    public XmlBody(String str) {
        this(str, Kalle.getConfig().getCharset());
    }

    public XmlBody(String str, Charset charset) {
        super(str, charset, Headers.VALUE_APPLICATION_XML);
    }
}
