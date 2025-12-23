package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ServerCookieDecoder extends CookieDecoder {
    private static final String RFC2965_DOMAIN = "$Domain";
    private static final String RFC2965_PATH = "$Path";
    private static final String RFC2965_PORT = "$Port";
    private static final String RFC2965_VERSION = "$Version";
    public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);
    public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);

    public Set<Cookie> decode(String str) {
        boolean z5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int length = ((String) ObjectUtil.checkNotNull(str, "header")).length();
        if (length == 0) {
            return Collections.EMPTY_SET;
        }
        TreeSet treeSet = new TreeSet();
        String str2 = str;
        if (str2.regionMatches(true, 0, RFC2965_VERSION, 0, 8)) {
            i6 = str2.indexOf(59) + 1;
            z5 = true;
        } else {
            z5 = false;
            i6 = 0;
        }
        while (i6 != length) {
            char charAt = str2.charAt(i6);
            if (charAt == '\t' || charAt == '\n' || charAt == 11 || charAt == '\f' || charAt == '\r' || charAt == ' ' || charAt == ',' || charAt == ';') {
                i6++;
            } else {
                int i11 = i6;
                while (true) {
                    char charAt2 = str2.charAt(i11);
                    i7 = -1;
                    if (charAt2 == ';') {
                        i8 = i11;
                        i9 = i8;
                        break;
                    }
                    if (charAt2 == '=') {
                        i7 = i11 + 1;
                        if (i7 == length) {
                            i8 = i11;
                            i9 = i7;
                            i7 = 0;
                            i10 = 0;
                        } else {
                            int indexOf = str2.indexOf(59, i7);
                            if (indexOf <= 0) {
                                indexOf = length;
                            }
                            i10 = indexOf;
                            i9 = i10;
                            i8 = i11;
                        }
                    } else {
                        i11++;
                        if (i11 == length) {
                            i8 = length;
                            i9 = i11;
                            break;
                        }
                    }
                }
                i10 = -1;
                if (!z5 || (!str2.regionMatches(i6, RFC2965_PATH, 0, 5) && !str2.regionMatches(i6, RFC2965_DOMAIN, 0, 7) && !str2.regionMatches(i6, RFC2965_PORT, 0, 5))) {
                    String str3 = str2;
                    DefaultCookie initCookie = initCookie(str3, i6, i8, i7, i10);
                    str2 = str3;
                    if (initCookie != null) {
                        treeSet.add(initCookie);
                    }
                }
                i6 = i9;
            }
        }
        return treeSet;
    }

    private ServerCookieDecoder(boolean z5) {
        super(z5);
    }
}
