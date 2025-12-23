package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.ObjectUtil;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ClientCookieDecoder extends CookieDecoder {
    public static final ClientCookieDecoder STRICT = new ClientCookieDecoder(true);
    public static final ClientCookieDecoder LAX = new ClientCookieDecoder(false);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CookieBuilder {
        private final DefaultCookie cookie;
        private String domain;
        private int expiresEnd;
        private int expiresStart;
        private final String header;
        private boolean httpOnly;
        private long maxAge = Long.MIN_VALUE;
        private String path;
        private boolean secure;

        private static boolean isValueDefined(int i6, int i7) {
            return (i6 == -1 || i6 == i7) ? false : true;
        }

        void appendAttribute(int i6, int i7, int i8, int i9) {
            int i10 = i7 - i6;
            if (i10 == 4) {
                parse4(i6, i8, i9);
                return;
            }
            if (i10 == 6) {
                parse6(i6, i8, i9);
            } else if (i10 == 7) {
                parse7(i6, i8, i9);
            } else if (i10 == 8) {
                parse8(i6);
            }
        }

        private long mergeMaxAgeAndExpires() {
            Date parseHttpDate;
            long j6 = this.maxAge;
            if (j6 != Long.MIN_VALUE) {
                return j6;
            }
            if (!isValueDefined(this.expiresStart, this.expiresEnd) || (parseHttpDate = DateFormatter.parseHttpDate(this.header, this.expiresStart, this.expiresEnd)) == null) {
                return Long.MIN_VALUE;
            }
            long time = parseHttpDate.getTime() - System.currentTimeMillis();
            return (time / 1000) + (time % 1000 != 0 ? 1 : 0);
        }

        private void parse4(int i6, int i7, int i8) {
            if (this.header.regionMatches(true, i6, CookieHeaderNames.PATH, 0, 4)) {
                this.path = computeValue(i7, i8);
            }
        }

        private void parse6(int i6, int i7, int i8) {
            if (this.header.regionMatches(true, i6, CookieHeaderNames.DOMAIN, 0, 5)) {
                this.domain = computeValue(i7, i8);
            } else if (this.header.regionMatches(true, i6, CookieHeaderNames.SECURE, 0, 5)) {
                this.secure = true;
            }
        }

        private void parse7(int i6, int i7, int i8) {
            if (this.header.regionMatches(true, i6, "Expires", 0, 7)) {
                this.expiresStart = i7;
                this.expiresEnd = i8;
            } else if (this.header.regionMatches(true, i6, CookieHeaderNames.MAX_AGE, 0, 7)) {
                setMaxAge(computeValue(i7, i8));
            }
        }

        private void parse8(int i6) {
            if (this.header.regionMatches(true, i6, CookieHeaderNames.HTTPONLY, 0, 8)) {
                this.httpOnly = true;
            }
        }

        Cookie cookie() {
            this.cookie.setDomain(this.domain);
            this.cookie.setPath(this.path);
            this.cookie.setMaxAge(mergeMaxAgeAndExpires());
            this.cookie.setSecure(this.secure);
            this.cookie.setHttpOnly(this.httpOnly);
            return this.cookie;
        }

        CookieBuilder(DefaultCookie defaultCookie, String str) {
            this.cookie = defaultCookie;
            this.header = str;
        }

        private String computeValue(int i6, int i7) {
            if (isValueDefined(i6, i7)) {
                return this.header.substring(i6, i7);
            }
            return null;
        }

        private void setMaxAge(String str) {
            try {
                this.maxAge = Math.max(Long.parseLong(str), 0L);
            } catch (NumberFormatException unused) {
            }
        }
    }

    public Cookie decode(String str) {
        int i6;
        int i7;
        int i8;
        int i9;
        String str2;
        int length = ((String) ObjectUtil.checkNotNull(str, "header")).length();
        if (length == 0) {
            return null;
        }
        CookieBuilder cookieBuilder = null;
        int i10 = 0;
        while (i10 != length) {
            char charAt = str.charAt(i10);
            if (charAt == ',') {
                break;
            }
            if (charAt == '\t' || charAt == '\n' || charAt == 11 || charAt == '\f' || charAt == '\r' || charAt == ' ' || charAt == ';') {
                i10++;
                str = str;
            } else {
                int i11 = i10;
                while (true) {
                    char charAt2 = str.charAt(i11);
                    i6 = -1;
                    if (charAt2 == ';') {
                        i7 = i11;
                        i8 = i7;
                        break;
                    }
                    if (charAt2 == '=') {
                        int i12 = i11 + 1;
                        if (i12 == length) {
                            i7 = i11;
                            i8 = i12;
                            i9 = 0;
                            i6 = 0;
                        } else {
                            int indexOf = str.indexOf(59, i12);
                            if (indexOf <= 0) {
                                indexOf = length;
                            }
                            i8 = indexOf;
                            i9 = i12;
                            i7 = i11;
                            i6 = i8;
                        }
                    } else {
                        i11++;
                        if (i11 == length) {
                            i7 = length;
                            i8 = i11;
                            break;
                        }
                        i10 = i10;
                        str = str;
                    }
                }
                i9 = -1;
                if (i6 > 0 && str.charAt(i6 - 1) == ',') {
                    i6--;
                }
                if (cookieBuilder == null) {
                    String str3 = str;
                    DefaultCookie initCookie = initCookie(str3, i10, i7, i9, i6);
                    str2 = str3;
                    if (initCookie == null) {
                        return null;
                    }
                    cookieBuilder = new CookieBuilder(initCookie, str2);
                } else {
                    int i13 = i10;
                    str2 = str;
                    cookieBuilder.appendAttribute(i13, i7, i9, i6);
                }
                str = str2;
                i10 = i8;
            }
        }
        if (cookieBuilder != null) {
            return cookieBuilder.cookie();
        }
        return null;
    }

    private ClientCookieDecoder(boolean z5) {
        super(z5);
    }
}
