package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.BitSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class CookieUtil {
    private static final BitSet VALID_COOKIE_NAME_OCTETS = validCookieNameOctets();
    private static final BitSet VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets();
    private static final BitSet VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS = validCookieAttributeValueOctets();

    static void add(StringBuilder sb, String str, long j6) {
        sb.append(str);
        sb.append('=');
        sb.append(j6);
        sb.append(';');
        sb.append(' ');
    }

    static int firstInvalidOctet(CharSequence charSequence, BitSet bitSet) {
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (!bitSet.get(charSequence.charAt(i6))) {
                return i6;
            }
        }
        return -1;
    }

    static String validateAttributeValue(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String trim = str2.trim();
        if (trim.isEmpty()) {
            return null;
        }
        int firstInvalidOctet = firstInvalidOctet(trim, VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS);
        if (firstInvalidOctet == -1) {
            return trim;
        }
        throw new IllegalArgumentException(str + " contains the prohibited characters: " + trim.charAt(firstInvalidOctet));
    }

    static void addQuoted(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str);
        sb.append('=');
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(';');
        sb.append(' ');
    }

    static int firstInvalidCookieNameOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_NAME_OCTETS);
    }

    static int firstInvalidCookieValueOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_VALUE_OCTETS);
    }

    private static BitSet validCookieAttributeValueOctets() {
        BitSet bitSet = new BitSet();
        for (int i6 = 32; i6 < 127; i6++) {
            bitSet.set(i6);
        }
        bitSet.set(59, false);
        return bitSet;
    }

    private static BitSet validCookieNameOctets() {
        BitSet bitSet = new BitSet();
        for (int i6 = 32; i6 < 127; i6++) {
            bitSet.set(i6);
        }
        int[] iArr = {40, 41, 60, 62, 64, 44, 59, 58, 92, 34, 47, 91, 93, 63, 61, 123, 125, 32, 9};
        for (int i7 = 0; i7 < 19; i7++) {
            bitSet.set(iArr[i7], false);
        }
        return bitSet;
    }

    private static BitSet validCookieValueOctets() {
        BitSet bitSet = new BitSet();
        bitSet.set(33);
        for (int i6 = 35; i6 <= 43; i6++) {
            bitSet.set(i6);
        }
        for (int i7 = 45; i7 <= 58; i7++) {
            bitSet.set(i7);
        }
        for (int i8 = 60; i8 <= 91; i8++) {
            bitSet.set(i8);
        }
        for (int i9 = 93; i9 <= 126; i9++) {
            bitSet.set(i9);
        }
        return bitSet;
    }

    private CookieUtil() {
    }

    static StringBuilder stringBuilder() {
        return InternalThreadLocalMap.get().stringBuilder();
    }

    static String stripTrailingSeparator(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    static String stripTrailingSeparatorOrNull(StringBuilder sb) {
        if (sb.length() == 0) {
            return null;
        }
        return stripTrailingSeparator(sb);
    }

    static CharSequence unwrapValue(CharSequence charSequence) {
        int length = charSequence.length();
        if (length > 0 && charSequence.charAt(0) == '\"') {
            if (length >= 2) {
                int i6 = length - 1;
                if (charSequence.charAt(i6) == '\"') {
                    if (length == 2) {
                        return "";
                    }
                    return charSequence.subSequence(1, i6);
                }
            }
            return null;
        }
        return charSequence;
    }

    static void add(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append('=');
        sb.append(str2);
        sb.append(';');
        sb.append(' ');
    }

    static void add(StringBuilder sb, String str) {
        sb.append(str);
        sb.append(';');
        sb.append(' ');
    }
}
