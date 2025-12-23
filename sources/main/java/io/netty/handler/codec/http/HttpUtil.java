package io.netty.handler.codec.http;

import com.huawei.hms.framework.common.ContainerUtils;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HttpUtil {
    private static final AsciiString CHARSET_EQUALS = AsciiString.of(((Object) HttpHeaderValues.CHARSET) + ContainerUtils.KEY_VALUE_DELIMITER);
    private static final AsciiString SEMICOLON = AsciiString.cached(";");

    public static Charset getCharset(HttpMessage httpMessage) {
        return getCharset(httpMessage, CharsetUtil.ISO_8859_1);
    }

    public static CharSequence getCharsetAsSequence(HttpMessage httpMessage) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
        if (str != null) {
            return getCharsetAsSequence(str);
        }
        return null;
    }

    public static long getContentLength(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        String str = headers.get(asciiString);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = getWebSocketContentLength(httpMessage);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }
        throw new NumberFormatException("header not found: " + ((Object) asciiString));
    }

    public static CharSequence getMimeType(HttpMessage httpMessage) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
        if (str != null) {
            return getMimeType(str);
        }
        return null;
    }

    public static void setKeepAlive(HttpMessage httpMessage, boolean z5) {
        setKeepAlive(httpMessage.headers(), httpMessage.protocolVersion(), z5);
    }

    public static Charset getCharset(CharSequence charSequence) {
        return charSequence != null ? getCharset(charSequence, CharsetUtil.ISO_8859_1) : CharsetUtil.ISO_8859_1;
    }

    public static boolean isAsteriskForm(URI uri) {
        return "*".equals(uri.getPath()) && uri.getScheme() == null && uri.getSchemeSpecificPart() == null && uri.getHost() == null && uri.getAuthority() == null && uri.getQuery() == null && uri.getFragment() == null;
    }

    private static boolean isExpectHeaderValid(HttpMessage httpMessage) {
        return (httpMessage instanceof HttpRequest) && httpMessage.protocolVersion().compareTo(HttpVersion.HTTP_1_1) >= 0;
    }

    public static void set100ContinueExpected(HttpMessage httpMessage, boolean z5) {
        if (z5) {
            httpMessage.headers().set(HttpHeaderNames.EXPECT, HttpHeaderValues.CONTINUE);
        } else {
            httpMessage.headers().remove(HttpHeaderNames.EXPECT);
        }
    }

    public static void setKeepAlive(HttpHeaders httpHeaders, HttpVersion httpVersion, boolean z5) {
        if (httpVersion.isKeepAliveDefault()) {
            if (z5) {
                httpHeaders.remove(HttpHeaderNames.CONNECTION);
                return;
            } else {
                httpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
                return;
            }
        }
        if (z5) {
            httpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        } else {
            httpHeaders.remove(HttpHeaderNames.CONNECTION);
        }
    }

    public static void setTransferEncodingChunked(HttpMessage httpMessage, boolean z5) {
        if (z5) {
            httpMessage.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            return;
        }
        List<String> all = httpMessage.headers().getAll(HttpHeaderNames.TRANSFER_ENCODING);
        if (all.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(all);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase((CharSequence) it.next())) {
                it.remove();
            }
        }
        if (arrayList.isEmpty()) {
            httpMessage.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
        } else {
            httpMessage.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Iterable<?>) arrayList);
        }
    }

    private HttpUtil() {
    }

    public static String formatHostnameForHttp(InetSocketAddress inetSocketAddress) {
        String hostname = NetUtil.getHostname(inetSocketAddress);
        if (NetUtil.isValidIpV6Address(hostname)) {
            if (!inetSocketAddress.isUnresolved()) {
                hostname = NetUtil.toAddressString(inetSocketAddress.getAddress());
            }
            return '[' + hostname + ']';
        }
        return hostname;
    }

    public static CharSequence getCharsetAsSequence(CharSequence charSequence) {
        int length;
        if (charSequence != null) {
            AsciiString asciiString = CHARSET_EQUALS;
            int indexOfIgnoreCaseAscii = AsciiString.indexOfIgnoreCaseAscii(charSequence, asciiString, 0);
            if (indexOfIgnoreCaseAscii == -1 || (length = indexOfIgnoreCaseAscii + asciiString.length()) >= charSequence.length()) {
                return null;
            }
            CharSequence subSequence = charSequence.subSequence(length, charSequence.length());
            int indexOfIgnoreCaseAscii2 = AsciiString.indexOfIgnoreCaseAscii(subSequence, SEMICOLON, 0);
            return indexOfIgnoreCaseAscii2 == -1 ? subSequence : subSequence.subSequence(0, indexOfIgnoreCaseAscii2);
        }
        throw new NullPointerException("contentTypeValue");
    }

    @Deprecated
    public static CharSequence getCharsetAsString(HttpMessage httpMessage) {
        return getCharsetAsSequence(httpMessage);
    }

    public static CharSequence getMimeType(CharSequence charSequence) {
        if (charSequence != null) {
            int indexOfIgnoreCaseAscii = AsciiString.indexOfIgnoreCaseAscii(charSequence, SEMICOLON, 0);
            if (indexOfIgnoreCaseAscii != -1) {
                return charSequence.subSequence(0, indexOfIgnoreCaseAscii);
            }
            if (charSequence.length() > 0) {
                return charSequence;
            }
            return null;
        }
        throw new NullPointerException("contentTypeValue");
    }

    private static int getWebSocketContentLength(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        if (httpMessage instanceof HttpRequest) {
            if (HttpMethod.GET.equals(((HttpRequest) httpMessage).method()) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY1) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2)) {
                return 8;
            }
            return -1;
        }
        if ((httpMessage instanceof HttpResponse) && ((HttpResponse) httpMessage).status().code() == 101 && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_LOCATION)) {
            return 16;
        }
        return -1;
    }

    public static boolean is100ContinueExpected(HttpMessage httpMessage) {
        if (isExpectHeaderValid(httpMessage) && httpMessage.headers().contains((CharSequence) HttpHeaderNames.EXPECT, (CharSequence) HttpHeaderValues.CONTINUE, true)) {
            return true;
        }
        return false;
    }

    public static boolean isContentLengthSet(HttpMessage httpMessage) {
        return httpMessage.headers().contains(HttpHeaderNames.CONTENT_LENGTH);
    }

    public static boolean isKeepAlive(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        if (!headers.containsValue(asciiString, HttpHeaderValues.CLOSE, true)) {
            if (httpMessage.protocolVersion().isKeepAliveDefault() || httpMessage.headers().containsValue(asciiString, HttpHeaderValues.KEEP_ALIVE, true)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isOriginForm(URI uri) {
        if (uri.getScheme() == null && uri.getSchemeSpecificPart() == null && uri.getHost() == null && uri.getAuthority() == null) {
            return true;
        }
        return false;
    }

    public static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        return httpMessage.headers().contains((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (CharSequence) HttpHeaderValues.CHUNKED, true);
    }

    static boolean isUnsupportedExpectation(HttpMessage httpMessage) {
        String str;
        if (!isExpectHeaderValid(httpMessage) || (str = httpMessage.headers().get(HttpHeaderNames.EXPECT)) == null || HttpHeaderValues.CONTINUE.toString().equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void setContentLength(HttpMessage httpMessage, long j6) {
        httpMessage.headers().set(HttpHeaderNames.CONTENT_LENGTH, Long.valueOf(j6));
    }

    public static Charset getCharset(HttpMessage httpMessage, Charset charset) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_TYPE);
        return str != null ? getCharset(str, charset) : charset;
    }

    public static long getContentLength(HttpMessage httpMessage, long j6) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_LENGTH);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = getWebSocketContentLength(httpMessage);
        return webSocketContentLength >= 0 ? webSocketContentLength : j6;
    }

    public static Charset getCharset(CharSequence charSequence, Charset charset) {
        CharSequence charsetAsSequence;
        if (charSequence != null && (charsetAsSequence = getCharsetAsSequence(charSequence)) != null) {
            try {
                return Charset.forName(charsetAsSequence.toString());
            } catch (UnsupportedCharsetException unused) {
            }
        }
        return charset;
    }

    public static int getContentLength(HttpMessage httpMessage, int i6) {
        return (int) Math.min(2147483647L, getContentLength(httpMessage, i6));
    }
}
