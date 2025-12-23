package io.netty.util;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Map;
import org.apache.commons.net.ftp.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CharsetUtil {
    private static final Charset[] CHARSETS;
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;

    public static CharsetDecoder decoder(Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2) {
        ObjectUtil.checkNotNull(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction2);
        return newDecoder;
    }

    public static CharsetEncoder encoder(Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2) {
        ObjectUtil.checkNotNull(charset, "charset");
        CharsetEncoder newEncoder = charset.newEncoder();
        newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction2);
        return newEncoder;
    }

    static {
        Charset forName = Charset.forName("UTF-16");
        UTF_16 = forName;
        Charset forName2 = Charset.forName("UTF-16BE");
        UTF_16BE = forName2;
        Charset forName3 = Charset.forName("UTF-16LE");
        UTF_16LE = forName3;
        Charset forName4 = Charset.forName("UTF-8");
        UTF_8 = forName4;
        Charset forName5 = Charset.forName(b.T);
        ISO_8859_1 = forName5;
        Charset forName6 = Charset.forName("US-ASCII");
        US_ASCII = forName6;
        CHARSETS = new Charset[]{forName, forName2, forName3, forName4, forName5, forName6};
    }

    public static Charset[] values() {
        return CHARSETS;
    }

    private CharsetUtil() {
    }

    @Deprecated
    public static CharsetDecoder getDecoder(Charset charset) {
        return decoder(charset);
    }

    @Deprecated
    public static CharsetEncoder getEncoder(Charset charset) {
        return encoder(charset);
    }

    public static CharsetDecoder decoder(Charset charset, CodingErrorAction codingErrorAction) {
        return decoder(charset, codingErrorAction, codingErrorAction);
    }

    public static CharsetEncoder encoder(Charset charset, CodingErrorAction codingErrorAction) {
        return encoder(charset, codingErrorAction, codingErrorAction);
    }

    public static CharsetDecoder decoder(Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        Map<Charset, CharsetDecoder> charsetDecoderCache = InternalThreadLocalMap.get().charsetDecoderCache();
        CharsetDecoder charsetDecoder = charsetDecoderCache.get(charset);
        if (charsetDecoder != null) {
            CharsetDecoder reset = charsetDecoder.reset();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            reset.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
            return charsetDecoder;
        }
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPLACE;
        CharsetDecoder decoder = decoder(charset, codingErrorAction2, codingErrorAction2);
        charsetDecoderCache.put(charset, decoder);
        return decoder;
    }

    public static CharsetEncoder encoder(Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        Map<Charset, CharsetEncoder> charsetEncoderCache = InternalThreadLocalMap.get().charsetEncoderCache();
        CharsetEncoder charsetEncoder = charsetEncoderCache.get(charset);
        if (charsetEncoder != null) {
            CharsetEncoder reset = charsetEncoder.reset();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            reset.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
            return charsetEncoder;
        }
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPLACE;
        CharsetEncoder encoder = encoder(charset, codingErrorAction2, codingErrorAction2);
        charsetEncoderCache.put(charset, encoder);
        return encoder;
    }
}
