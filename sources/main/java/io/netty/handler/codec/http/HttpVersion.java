package io.netty.handler.codec.http;

import com.baidu.mobads.sdk.internal.a;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpVersion implements Comparable<HttpVersion> {
    private static final String HTTP_1_0_STRING = "HTTP/1.0";
    private static final String HTTP_1_1_STRING = "HTTP/1.1";
    private final byte[] bytes;
    private final boolean keepAliveDefault;
    private final int majorVersion;
    private final int minorVersion;
    private final String protocolName;
    private final String text;
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
    public static final HttpVersion HTTP_1_0 = new HttpVersion("HTTP", 1, 0, false, true);
    public static final HttpVersion HTTP_1_1 = new HttpVersion("HTTP", 1, 1, true, true);

    public HttpVersion(String str, boolean z5) {
        if (str == null) {
            throw new NullPointerException(a.f10501b);
        }
        String upperCase = str.trim().toUpperCase();
        if (upperCase.isEmpty()) {
            throw new IllegalArgumentException("empty text");
        }
        Matcher matcher = VERSION_PATTERN.matcher(upperCase);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid version format: " + upperCase);
        }
        String group = matcher.group(1);
        this.protocolName = group;
        int parseInt = Integer.parseInt(matcher.group(2));
        this.majorVersion = parseInt;
        int parseInt2 = Integer.parseInt(matcher.group(3));
        this.minorVersion = parseInt2;
        this.text = group + '/' + parseInt + '.' + parseInt2;
        this.keepAliveDefault = z5;
        this.bytes = null;
    }

    public static HttpVersion valueOf(String str) {
        if (str == null) {
            throw new NullPointerException(a.f10501b);
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            throw new IllegalArgumentException("text is empty (possibly HTTP/0.9)");
        }
        HttpVersion version0 = version0(trim);
        return version0 == null ? new HttpVersion(trim, true) : version0;
    }

    private static HttpVersion version0(String str) {
        if (HTTP_1_1_STRING.equals(str)) {
            return HTTP_1_1;
        }
        if (HTTP_1_0_STRING.equals(str)) {
            return HTTP_1_0;
        }
        return null;
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpVersion httpVersion) {
        int compareTo = protocolName().compareTo(httpVersion.protocolName());
        if (compareTo != 0) {
            return compareTo;
        }
        int majorVersion = majorVersion() - httpVersion.majorVersion();
        return majorVersion != 0 ? majorVersion : minorVersion() - httpVersion.minorVersion();
    }

    void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            byteBuf.writeCharSequence(this.text, CharsetUtil.US_ASCII);
        } else {
            byteBuf.writeBytes(bArr);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpVersion)) {
            return false;
        }
        HttpVersion httpVersion = (HttpVersion) obj;
        return minorVersion() == httpVersion.minorVersion() && majorVersion() == httpVersion.majorVersion() && protocolName().equals(httpVersion.protocolName());
    }

    public boolean isKeepAliveDefault() {
        return this.keepAliveDefault;
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public String protocolName() {
        return this.protocolName;
    }

    public String text() {
        return this.text;
    }

    public int hashCode() {
        return (((protocolName().hashCode() * 31) + majorVersion()) * 31) + minorVersion();
    }

    public String toString() {
        return text();
    }

    public HttpVersion(String str, int i6, int i7, boolean z5) {
        this(str, i6, i7, z5, false);
    }

    private HttpVersion(String str, int i6, int i7, boolean z5, boolean z6) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (!upperCase.isEmpty()) {
                for (int i8 = 0; i8 < upperCase.length(); i8++) {
                    if (Character.isISOControl(upperCase.charAt(i8)) || Character.isWhitespace(upperCase.charAt(i8))) {
                        throw new IllegalArgumentException("invalid character in protocolName");
                    }
                }
                ObjectUtil.checkPositiveOrZero(i6, "majorVersion");
                ObjectUtil.checkPositiveOrZero(i7, "minorVersion");
                this.protocolName = upperCase;
                this.majorVersion = i6;
                this.minorVersion = i7;
                String str2 = upperCase + '/' + i6 + '.' + i7;
                this.text = str2;
                this.keepAliveDefault = z5;
                if (z6) {
                    this.bytes = str2.getBytes(CharsetUtil.US_ASCII);
                    return;
                } else {
                    this.bytes = null;
                    return;
                }
            }
            throw new IllegalArgumentException("empty protocolName");
        }
        throw new NullPointerException("protocolName");
    }
}
