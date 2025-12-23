package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.CharBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class CookieDecoder {
    private final InternalLogger logger = InternalLoggerFactory.getInstance(getClass());
    private final boolean strict;

    protected DefaultCookie initCookie(String str, int i6, int i7, int i8, int i9) {
        int firstInvalidCookieValueOctet;
        int firstInvalidCookieNameOctet;
        if (i6 == -1 || i6 == i7) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        }
        if (i8 == -1) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        }
        CharBuffer wrap = CharBuffer.wrap(str, i8, i9);
        CharSequence unwrapValue = CookieUtil.unwrapValue(wrap);
        if (unwrapValue == null) {
            this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", wrap);
            return null;
        }
        String substring = str.substring(i6, i7);
        if (this.strict && (firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(substring)) >= 0) {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", substring, Character.valueOf(substring.charAt(firstInvalidCookieNameOctet)));
            }
            return null;
        }
        boolean z5 = unwrapValue.length() != i9 - i8;
        if (!this.strict || (firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue)) < 0) {
            DefaultCookie defaultCookie = new DefaultCookie(substring, unwrapValue.toString());
            defaultCookie.setWrap(z5);
            return defaultCookie;
        }
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", unwrapValue, Character.valueOf(unwrapValue.charAt(firstInvalidCookieValueOctet)));
        }
        return null;
    }

    protected CookieDecoder(boolean z5) {
        this.strict = z5;
    }
}
