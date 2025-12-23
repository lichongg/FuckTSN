package io.netty.handler.codec.http;

import com.bytedance.pangle.provider.ContentProviderManager;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QueryStringDecoder {
    private static final int DEFAULT_MAX_PARAMS = 1024;
    private final Charset charset;
    private final int maxParams;
    private Map<String, List<String>> params;
    private String path;
    private int pathEndIdx;
    private final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private static boolean addParam(String str, int i6, int i7, int i8, Map<String, List<String>> map, Charset charset) {
        if (i6 >= i8) {
            return false;
        }
        if (i7 <= i6) {
            i7 = i8 + 1;
        }
        String decodeComponent = decodeComponent(str, i6, i7 - 1, charset, false);
        String decodeComponent2 = decodeComponent(str, i7, i8, charset, false);
        List<String> list = map.get(decodeComponent);
        if (list == null) {
            list = new ArrayList<>(1);
            map.put(decodeComponent, list);
        }
        list.add(decodeComponent2);
        return true;
    }

    public static String decodeComponent(String str) {
        return decodeComponent(str, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(String str, boolean z5) {
        this(str, HttpConstants.DEFAULT_CHARSET, z5);
    }

    public static String decodeComponent(String str, Charset charset) {
        return str == null ? "" : decodeComponent(str, 0, str.length(), charset, false);
    }

    private int pathEndIdx() {
        if (this.pathEndIdx == -1) {
            this.pathEndIdx = findPathEndIndex(this.uri);
        }
        return this.pathEndIdx;
    }

    public Map<String, List<String>> parameters() {
        if (this.params == null) {
            this.params = decodeParams(this.uri, pathEndIdx(), this.charset, this.maxParams);
        }
        return this.params;
    }

    public String path() {
        if (this.path == null) {
            this.path = decodeComponent(this.uri, 0, pathEndIdx(), this.charset, true);
        }
        return this.path;
    }

    public String rawPath() {
        return this.uri.substring(0, pathEndIdx());
    }

    public String uri() {
        return this.uri;
    }

    public QueryStringDecoder(String str, Charset charset) {
        this(str, charset, true);
    }

    private static Map<String, List<String>> decodeParams(String str, int i6, Charset charset, int i7) {
        String str2;
        Charset charset2;
        int length = str.length();
        if (i6 >= length) {
            return Collections.EMPTY_MAP;
        }
        if (str.charAt(i6) == '?') {
            i6++;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i8 = i6;
        int i9 = i8;
        int i10 = -1;
        while (i9 < length) {
            char charAt = str.charAt(i9);
            if (charAt == '#') {
                break;
            }
            if (charAt != '&' && charAt != ';') {
                if (charAt == '=') {
                    if (i8 == i9) {
                        str2 = str;
                        i8 = i9 + 1;
                    } else if (i10 < i8) {
                        str2 = str;
                        i10 = i9 + 1;
                    }
                    charset2 = charset;
                }
                str2 = str;
                charset2 = charset;
            } else {
                str2 = str;
                charset2 = charset;
                if (addParam(str2, i8, i10, i9, linkedHashMap, charset2) && i7 - 1 == 0) {
                    return linkedHashMap;
                }
                i8 = i9 + 1;
            }
            i9++;
            str = str2;
            charset = charset2;
        }
        addParam(str, i8, i10, i9, linkedHashMap, charset);
        return linkedHashMap;
    }

    private static int findPathEndIndex(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '?' || charAt == '#') {
                return i6;
            }
        }
        return length;
    }

    public String rawQuery() {
        int pathEndIdx = pathEndIdx() + 1;
        if (pathEndIdx < this.uri.length()) {
            return this.uri.substring(pathEndIdx);
        }
        return "";
    }

    public String toString() {
        return uri();
    }

    public QueryStringDecoder(String str, Charset charset, boolean z5) {
        this(str, charset, z5, 1024);
    }

    private static String decodeComponent(String str, int i6, int i7, Charset charset, boolean z5) {
        int i8 = i7 - i6;
        if (i8 <= 0) {
            return "";
        }
        int i9 = i6;
        while (true) {
            if (i9 >= i7) {
                i9 = -1;
                break;
            }
            char charAt = str.charAt(i9);
            if (charAt == '%' || (charAt == '+' && !z5)) {
                break;
            }
            i9++;
        }
        if (i9 == -1) {
            return str.substring(i6, i7);
        }
        CharsetDecoder decoder = CharsetUtil.decoder(charset);
        int i10 = (i7 - i9) / 3;
        ByteBuffer allocate = ByteBuffer.allocate(i10);
        CharBuffer allocate2 = CharBuffer.allocate(i10);
        StringBuilder sb = new StringBuilder(i8);
        sb.append((CharSequence) str, i6, i9);
        while (i9 < i7) {
            char charAt2 = str.charAt(i9);
            if (charAt2 != '%') {
                if (charAt2 == '+' && !z5) {
                    charAt2 = ' ';
                }
                sb.append(charAt2);
            } else {
                allocate.clear();
                while (true) {
                    int i11 = i9 + 3;
                    if (i11 <= i7) {
                        allocate.put(StringUtil.decodeHexByte(str, i9 + 1));
                        if (i11 >= i7 || str.charAt(i11) != '%') {
                            break;
                        }
                        i9 = i11;
                    } else {
                        throw new IllegalArgumentException("unterminated escape sequence at index " + i9 + " of: " + str);
                    }
                }
                i9 += 2;
                allocate.flip();
                allocate2.clear();
                CoderResult decode = decoder.reset().decode(allocate, allocate2, true);
                try {
                    if (!decode.isUnderflow()) {
                        decode.throwException();
                    }
                    CoderResult flush = decoder.flush(allocate2);
                    if (!flush.isUnderflow()) {
                        flush.throwException();
                    }
                    sb.append(allocate2.flip());
                } catch (CharacterCodingException e6) {
                    throw new IllegalStateException(e6);
                }
            }
            i9++;
        }
        return sb.toString();
    }

    public QueryStringDecoder(String str, Charset charset, boolean z5, int i6) {
        this.uri = (String) ObjectUtil.checkNotNull(str, ContentProviderManager.PROVIDER_URI);
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.maxParams = ObjectUtil.checkPositive(i6, "maxParams");
        this.pathEndIdx = z5 ? -1 : 0;
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri, Charset charset) {
        this(uri, charset, 1024);
    }

    public QueryStringDecoder(URI uri, Charset charset, int i6) {
        String str;
        String rawPath = uri.getRawPath();
        rawPath = rawPath == null ? "" : rawPath;
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null) {
            str = rawPath;
        } else {
            str = rawPath + '?' + rawQuery;
        }
        this.uri = str;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.maxParams = ObjectUtil.checkPositive(i6, "maxParams");
        this.pathEndIdx = rawPath.length();
    }
}
