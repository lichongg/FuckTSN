package okhttp3.internal.url;

import java.nio.charset.Charset;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.e;
import kotlin.text.u;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class _UrlKt {

    @NotNull
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    @NotNull
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    public static final void writeCanonicalized(@NotNull Buffer buffer, @NotNull String input, int i6, int i7, @NotNull String encodeSet, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable Charset charset) {
        g0.p(buffer, "<this>");
        g0.p(input, "input");
        g0.p(encodeSet, "encodeSet");
        Buffer buffer2 = null;
        while (i6 < i7) {
            int codePointAt = input.codePointAt(i6);
            if (z5 && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                n1 n1Var = n1.f44123a;
            } else {
                String str = Marker.ANY_NON_NULL_MARKER;
                if (codePointAt == 32 && encodeSet == FORM_ENCODE_SET) {
                    buffer.writeUtf8(Marker.ANY_NON_NULL_MARKER);
                } else if (codePointAt == 43 && z7) {
                    if (!z5) {
                        str = "%2B";
                    }
                    buffer.writeUtf8(str);
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z8) || u.k3(encodeSet, (char) codePointAt, false, 2, null) || (codePointAt == 37 && (!z5 || (z6 && !isPercentEncoded(input, i6, i7)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || g0.g(charset, e.f47851b)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(input, i6, Character.charCount(codePointAt) + i6, charset);
                    }
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                    n1 n1Var2 = n1.f44123a;
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i6 += Character.charCount(codePointAt);
        }
    }

    @NotNull
    public static final String canonicalize(@NotNull String str, int i6, int i7, @NotNull String encodeSet, boolean z5, boolean z6, boolean z7, boolean z8) {
        g0.p(str, "<this>");
        g0.p(encodeSet, "encodeSet");
        return canonicalizeWithCharset$default(str, i6, i7, encodeSet, z5, z6, z7, z8, null, 128, null);
    }

    public static /* synthetic */ String canonicalize$default(String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 8) != 0) {
            z5 = false;
        }
        if ((i8 & 16) != 0) {
            z6 = false;
        }
        if ((i8 & 32) != 0) {
            z7 = false;
        }
        if ((i8 & 64) != 0) {
            z8 = false;
        }
        return canonicalize(str, i6, i7, str2, z5, z6, z7, z8);
    }

    @NotNull
    public static final String canonicalizeWithCharset(@NotNull String str, int i6, int i7, @NotNull String encodeSet, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable Charset charset) {
        g0.p(str, "<this>");
        g0.p(encodeSet, "encodeSet");
        int i8 = i6;
        while (i8 < i7) {
            int codePointAt = str.codePointAt(i8);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z8) || u.k3(encodeSet, (char) codePointAt, false, 2, null) || ((codePointAt == 37 && (!z5 || (z6 && !isPercentEncoded(str, i8, i7)))) || (codePointAt == 43 && z7)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i6, i8);
                writeCanonicalized(buffer, str, i8, i7, encodeSet, z5, z6, z7, z8, charset);
                return buffer.readUtf8();
            }
            i8 += Character.charCount(codePointAt);
        }
        String substring = str.substring(i6, i7);
        g0.o(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String canonicalizeWithCharset$default(String str, int i6, int i7, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 8) != 0) {
            z5 = false;
        }
        if ((i8 & 16) != 0) {
            z6 = false;
        }
        if ((i8 & 32) != 0) {
            z7 = false;
        }
        if ((i8 & 64) != 0) {
            z8 = false;
        }
        if ((i8 & 128) != 0) {
            charset = null;
        }
        return canonicalizeWithCharset(str, i6, i7, str2, z5, z6, z7, z8, charset);
    }

    @NotNull
    public static final char[] getHEX_DIGITS() {
        return HEX_DIGITS;
    }

    public static final boolean isPercentEncoded(@NotNull String str, int i6, int i7) {
        g0.p(str, "<this>");
        int i8 = i6 + 2;
        return i8 < i7 && str.charAt(i6) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(i6 + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(i8)) != -1;
    }

    @NotNull
    public static final String percentDecode(@NotNull String str, int i6, int i7, boolean z5) {
        g0.p(str, "<this>");
        for (int i8 = i6; i8 < i7; i8++) {
            char charAt = str.charAt(i8);
            if (charAt == '%' || (charAt == '+' && z5)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i6, i8);
                writePercentDecoded(buffer, str, i8, i7, z5);
                return buffer.readUtf8();
            }
        }
        String substring = str.substring(i6, i7);
        g0.o(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String percentDecode$default(String str, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = str.length();
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        return percentDecode(str, i6, i7, z5);
    }

    public static final void writePercentDecoded(@NotNull Buffer buffer, @NotNull String encoded, int i6, int i7, boolean z5) {
        int i8;
        g0.p(buffer, "<this>");
        g0.p(encoded, "encoded");
        while (i6 < i7) {
            int codePointAt = encoded.codePointAt(i6);
            if (codePointAt != 37 || (i8 = i6 + 2) >= i7) {
                if (codePointAt == 43 && z5) {
                    buffer.writeByte(32);
                    i6++;
                }
                buffer.writeUtf8CodePoint(codePointAt);
                i6 += Character.charCount(codePointAt);
            } else {
                int parseHexDigit = _UtilCommonKt.parseHexDigit(encoded.charAt(i6 + 1));
                int parseHexDigit2 = _UtilCommonKt.parseHexDigit(encoded.charAt(i8));
                if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                    buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                    i6 = Character.charCount(codePointAt) + i8;
                }
                buffer.writeUtf8CodePoint(codePointAt);
                i6 += Character.charCount(codePointAt);
            }
        }
    }
}
