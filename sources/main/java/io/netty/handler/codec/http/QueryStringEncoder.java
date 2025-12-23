package io.netty.handler.codec.http;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.ObjectUtil;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QueryStringEncoder {
    private final String charsetName;
    private boolean hasParams;
    private final StringBuilder uriBuilder;

    public QueryStringEncoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringEncoder(String str, Charset charset) {
        this.uriBuilder = new StringBuilder(str);
        this.charsetName = charset.name();
    }

    public void addParam(String str, String str2) {
        ObjectUtil.checkNotNull(str, CommonNetImpl.NAME);
        if (this.hasParams) {
            this.uriBuilder.append(v0.f47960d);
        } else {
            this.uriBuilder.append('?');
            this.hasParams = true;
        }
        appendComponent(str, this.charsetName, this.uriBuilder);
        if (str2 != null) {
            this.uriBuilder.append('=');
            appendComponent(str2, this.charsetName, this.uriBuilder);
        }
    }

    public String toString() {
        return this.uriBuilder.toString();
    }

    public URI toUri() throws URISyntaxException {
        return new URI(toString());
    }

    private static void appendComponent(String str, String str2, StringBuilder sb) {
        try {
            String encode = URLEncoder.encode(str, str2);
            int indexOf = encode.indexOf(43);
            if (indexOf == -1) {
                sb.append(encode);
                return;
            }
            sb.append((CharSequence) encode, 0, indexOf);
            sb.append("%20");
            int length = encode.length();
            while (true) {
                indexOf++;
                if (indexOf < length) {
                    char charAt = encode.charAt(indexOf);
                    if (charAt != '+') {
                        sb.append(charAt);
                    } else {
                        sb.append("%20");
                    }
                } else {
                    return;
                }
            }
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(str2);
        }
    }
}
