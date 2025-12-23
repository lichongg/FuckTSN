package io.netty.handler.codec.http;

import java.util.BitSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
final class CookieUtil {
    private static final BitSet VALID_COOKIE_NAME_OCTETS;
    private static final BitSet VALID_COOKIE_VALUE_OCTETS;

    static int firstInvalidOctet(CharSequence charSequence, BitSet bitSet) {
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (!bitSet.get(charSequence.charAt(i6))) {
                return i6;
            }
        }
        return -1;
    }

    static int firstInvalidCookieNameOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_NAME_OCTETS);
    }

    static int firstInvalidCookieValueOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_VALUE_OCTETS);
    }

    private static BitSet validCookieNameOctets(BitSet bitSet) {
        BitSet bitSet2 = new BitSet(8);
        bitSet2.or(bitSet);
        bitSet2.set(40, false);
        bitSet2.set(41, false);
        bitSet2.set(60, false);
        bitSet2.set(62, false);
        bitSet2.set(64, false);
        bitSet2.set(58, false);
        bitSet2.set(47, false);
        bitSet2.set(91, false);
        bitSet2.set(93, false);
        bitSet2.set(63, false);
        bitSet2.set(61, false);
        bitSet2.set(123, false);
        bitSet2.set(125, false);
        bitSet2.set(32, false);
        bitSet2.set(9, false);
        return bitSet2;
    }

    private static BitSet validCookieValueOctets() {
        BitSet bitSet = new BitSet(8);
        for (int i6 = 35; i6 < 127; i6++) {
            bitSet.set(i6);
        }
        bitSet.set(34, false);
        bitSet.set(44, false);
        bitSet.set(59, false);
        bitSet.set(92, false);
        return bitSet;
    }

    static {
        BitSet validCookieValueOctets = validCookieValueOctets();
        VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets;
        VALID_COOKIE_NAME_OCTETS = validCookieNameOctets(validCookieValueOctets);
    }

    private CookieUtil() {
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
}
