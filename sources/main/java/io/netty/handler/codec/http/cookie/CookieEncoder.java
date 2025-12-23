package io.netty.handler.codec.http.cookie;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class CookieEncoder {
    protected final boolean strict;

    protected void validateCookie(String str, String str2) {
        if (this.strict) {
            int firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (firstInvalidCookieNameOctet >= 0) {
                throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(firstInvalidCookieNameOctet));
            }
            CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
            if (unwrapValue == null) {
                throw new IllegalArgumentException("Cookie value wrapping quotes are not balanced: " + str2);
            }
            int firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue);
            if (firstInvalidCookieValueOctet < 0) {
                return;
            }
            throw new IllegalArgumentException("Cookie value contains an invalid char: " + unwrapValue.charAt(firstInvalidCookieValueOctet));
        }
    }

    protected CookieEncoder(boolean z5) {
        this.strict = z5;
    }
}
