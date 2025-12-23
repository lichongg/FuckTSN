package okhttp3.internal;

import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import kotlin.ranges.t;
import kotlin.text.Regex;
import kotlin.text.u;
import okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import okhttp3.internal.idn.Punycode;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class _HostnamesCommonKt {

    @NotNull
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private static final boolean isMappedIpv4Address(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (bArr[i6] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    public static final boolean canParseAsIpAddress(@NotNull String str) {
        g0.p(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    @NotNull
    public static final byte[] canonicalizeInetAddress(@NotNull byte[] address) {
        g0.p(address, "address");
        return isMappedIpv4Address(address) ? n.ru(address, t.W1(12, 16)) : address;
    }

    public static final boolean containsInvalidHostnameAsciiCodes(@NotNull String str) {
        g0.p(str, "<this>");
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (g0.t(charAt, 31) <= 0 || g0.t(charAt, 127) >= 0 || u.G3(" #%/:?@[\\]", charAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsInvalidLabelLengths(@NotNull String str) {
        g0.p(str, "<this>");
        int length = str.length();
        if (1 <= length && length < 254) {
            int i6 = 0;
            while (true) {
                String str2 = str;
                int G3 = u.G3(str2, '.', i6, false, 4, null);
                int length2 = G3 == -1 ? str2.length() - i6 : G3 - i6;
                if (1 > length2 || length2 >= 64) {
                    break;
                }
                if (G3 == -1 || G3 == str2.length() - 1) {
                    break;
                }
                i6 = G3 + 1;
                str = str2;
            }
            return false;
        }
        return true;
    }

    public static final boolean decodeIpv4Suffix(@NotNull String input, int i6, int i7, @NotNull byte[] address, int i8) {
        g0.p(input, "input");
        g0.p(address, "address");
        int i9 = i8;
        while (i6 < i7) {
            if (i9 == address.length) {
                return false;
            }
            if (i9 != i8) {
                if (input.charAt(i6) != '.') {
                    return false;
                }
                i6++;
            }
            int i10 = i6;
            int i11 = 0;
            while (i10 < i7) {
                char charAt = input.charAt(i10);
                if (g0.t(charAt, 48) < 0 || g0.t(charAt, 57) > 0) {
                    break;
                }
                if ((i11 == 0 && i6 != i10) || (i11 = ((i11 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i10++;
            }
            if (i10 - i6 == 0) {
                return false;
            }
            address[i9] = (byte) i11;
            i9++;
            i6 = i10;
        }
        return i9 == i8 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0095, code lost:
    
        if (r11 == 16) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
    
        if (r12 != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
    
        kotlin.collections.n.v0(r8, r8, 16 - (r11 - r12), r12, r11);
        kotlin.collections.n.G1(r8, (byte) 0, r12, (16 - r11) + r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
    
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] decodeIpv6(@org.jetbrains.annotations.NotNull java.lang.String r16, int r17, int r18) {
        /*
            r0 = r16
            r6 = r18
            java.lang.String r1 = "input"
            kotlin.jvm.internal.g0.p(r0, r1)
            r7 = 16
            byte[] r8 = new byte[r7]
            r9 = 0
            r10 = -1
            r2 = r17
            r11 = 0
            r12 = -1
            r13 = -1
        L14:
            r14 = 0
            if (r2 >= r6) goto L95
            if (r11 != r7) goto L1a
            return r14
        L1a:
            int r15 = r2 + 2
            if (r15 > r6) goto L38
            r4 = 4
            r5 = 0
            java.lang.String r1 = "::"
            r3 = 0
            boolean r1 = kotlin.text.u.G2(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L38
            if (r12 == r10) goto L2c
            return r14
        L2c:
            int r11 = r11 + 2
            if (r15 != r6) goto L33
            r12 = r11
            goto L95
        L33:
            r0 = r16
            r12 = r11
            r13 = r15
            goto L67
        L38:
            if (r11 == 0) goto L49
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r3 = 0
            r0 = r16
            boolean r1 = kotlin.text.u.G2(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L4d
            int r2 = r2 + 1
        L49:
            r0 = r16
            r13 = r2
            goto L67
        L4d:
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r3 = 0
            r0 = r16
            boolean r1 = kotlin.text.u.G2(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L66
            int r1 = r11 + (-2)
            boolean r0 = decodeIpv4Suffix(r0, r13, r6, r8, r1)
            if (r0 != 0) goto L63
            return r14
        L63:
            int r11 = r11 + 2
            goto L95
        L66:
            return r14
        L67:
            r2 = r13
            r1 = 0
        L69:
            if (r2 >= r6) goto L7b
            char r3 = r0.charAt(r2)
            int r3 = okhttp3.internal._UtilCommonKt.parseHexDigit(r3)
            if (r3 == r10) goto L7b
            int r1 = r1 << 4
            int r1 = r1 + r3
            int r2 = r2 + 1
            goto L69
        L7b:
            int r3 = r2 - r13
            if (r3 == 0) goto L94
            r4 = 4
            if (r3 <= r4) goto L83
            goto L94
        L83:
            int r3 = r11 + 1
            int r4 = r1 >>> 8
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r8[r11] = r4
            int r11 = r11 + 2
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r8[r3] = r1
            goto L14
        L94:
            return r14
        L95:
            if (r11 == r7) goto La6
            if (r12 != r10) goto L9a
            return r14
        L9a:
            int r0 = r11 - r12
            int r0 = 16 - r0
            kotlin.collections.n.v0(r8, r8, r0, r12, r11)
            int r7 = r7 - r11
            int r7 = r7 + r12
            kotlin.collections.n.G1(r8, r9, r12, r7)
        La6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesCommonKt.decodeIpv6(java.lang.String, int, int):byte[]");
    }

    @Nullable
    public static final String idnToAscii(@NotNull String host) {
        g0.p(host, "host");
        Buffer writeUtf8 = new Buffer().writeUtf8(host);
        Buffer buffer = new Buffer();
        while (!writeUtf8.exhausted()) {
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(writeUtf8.readUtf8CodePoint(), buffer)) {
                return null;
            }
        }
        writeUtf8.writeUtf8(_NormalizeJvmKt.normalizeNfc(buffer.readUtf8()));
        Punycode punycode = Punycode.INSTANCE;
        String decode = punycode.decode(writeUtf8.readUtf8());
        if (decode != null && g0.g(decode, _NormalizeJvmKt.normalizeNfc(decode))) {
            return punycode.encode(decode);
        }
        return null;
    }

    @NotNull
    public static final String inet4AddressToAscii(@NotNull byte[] address) {
        g0.p(address, "address");
        if (address.length == 4) {
            return new Buffer().writeDecimalLong(_UtilCommonKt.and(address[0], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[1], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[2], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[3], 255)).readUtf8();
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @NotNull
    public static final String inet6AddressToAscii(@NotNull byte[] address) {
        g0.p(address, "address");
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < address.length) {
            int i10 = i8;
            while (i10 < 16 && address[i10] == 0 && address[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i8;
            if (i11 > i9 && i11 >= 4) {
                i6 = i8;
                i9 = i11;
            }
            i8 = i10 + 2;
        }
        Buffer buffer = new Buffer();
        while (i7 < address.length) {
            if (i7 == i6) {
                buffer.writeByte(58);
                i7 += i9;
                if (i7 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i7 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((_UtilCommonKt.and(address[i7], 255) << 8) | _UtilCommonKt.and(address[i7 + 1], 255));
                i7 += 2;
            }
        }
        return buffer.readUtf8();
    }

    @Nullable
    public static final String toCanonicalHost(@NotNull String str) {
        g0.p(str, "<this>");
        if (!u.l3(str, ":", false, 2, null)) {
            String idnToAscii = idnToAscii(str);
            if (idnToAscii == null || idnToAscii.length() == 0 || containsInvalidHostnameAsciiCodes(idnToAscii) || containsInvalidLabelLengths(idnToAscii)) {
                return null;
            }
            return idnToAscii;
        }
        byte[] decodeIpv6 = (u.H2(str, "[", false, 2, null) && u.Z1(str, "]", false, 2, null)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (decodeIpv6 == null) {
            return null;
        }
        byte[] canonicalizeInetAddress = canonicalizeInetAddress(decodeIpv6);
        if (canonicalizeInetAddress.length == 16) {
            return inet6AddressToAscii(canonicalizeInetAddress);
        }
        if (canonicalizeInetAddress.length == 4) {
            return inet4AddressToAscii(canonicalizeInetAddress);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
