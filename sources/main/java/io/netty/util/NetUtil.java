package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0175, code lost:
    
        if ((r6 - r9) <= 3) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0193, code lost:
    
        if (r27.charAt(0) == ':') goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01a6, code lost:
    
        if (r7 <= 2) goto L130;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] getIPv6ByName(java.lang.CharSequence r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i6, int i7, int i8) {
        boolean z5 = i8 + i7 >= 14;
        return i6 <= 12 && i6 >= 2 && (!z5 || i7 < 12) && isValidIPv4MappedSeparators(bArr[i6 + (-1)], bArr[i6 + (-2)], z5) && PlatformDependent.isZero(bArr, 0, i6 + (-3));
    }

    public static boolean isValidIpV4Address(CharSequence charSequence) {
        return isValidIpV4Address(charSequence, 0, charSequence.length());
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i6, int i7) {
        char charAt;
        char charAt2;
        int i8 = i7 - i6;
        if (i8 >= 1 && i8 <= 3 && (charAt = charSequence.charAt(i6)) >= '0') {
            if (i8 == 3) {
                char charAt3 = charSequence.charAt(i6 + 1);
                return charAt3 >= '0' && (charAt2 = charSequence.charAt(i6 + 2)) >= '0' && ((charAt <= '1' && charAt3 <= '9' && charAt2 <= '9') || (charAt == '2' && charAt3 <= '5' && (charAt2 <= '5' || (charAt3 < '5' && charAt2 <= '9'))));
            }
            if (charAt <= '9' && (i8 == 1 || isValidNumericChar(charSequence.charAt(i6 + 1)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder newSocketAddressStringBuilder;
        String valueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            newSocketAddressStringBuilder = newSocketAddressStringBuilder(getHostname(inetSocketAddress), valueOf, !isValidIpV6Address(r2));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            newSocketAddressStringBuilder = newSocketAddressStringBuilder(toAddressString(address), valueOf, address instanceof Inet4Address);
        }
        newSocketAddressStringBuilder.append(':');
        newSocketAddressStringBuilder.append(valueOf);
        return newSocketAddressStringBuilder.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0138, code lost:
    
        if (r10 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d9, code lost:
    
        r10 = r8.nextElement();
        r6 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010f  */
    /* JADX WARN: Type inference failed for: r0v5, types: [io.netty.util.internal.logging.InternalLogger] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.net.InetAddress] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.net.Inet6Address] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.net.InetAddress] */
    static {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.<clinit>():void");
    }

    public static String bytesToIpAddress(byte[] bArr, int i6, int i7) {
        if (i7 != 4) {
            if (i7 == 16) {
                return toAddressString(bArr, i6, false);
            }
            throw new IllegalArgumentException("length: " + i7 + " (expected: 4 or 16)");
        }
        StringBuilder sb = new StringBuilder(15);
        sb.append(bArr[i6] & 255);
        sb.append('.');
        sb.append(bArr[i6 + 1] & 255);
        sb.append('.');
        sb.append(bArr[i6 + 2] & 255);
        sb.append('.');
        sb.append(bArr[i6 + 3] & 255);
        return sb.toString();
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z5) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z5);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e6) {
            throw new RuntimeException(e6);
        }
    }

    private static boolean inRangeEndExclusive(int i6, int i7, int i8) {
        return i6 >= i7 && i6 < i8;
    }

    public static String intToIpAddress(int i6) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i6 >> 24) & 255);
        sb.append('.');
        sb.append((i6 >> 16) & 255);
        sb.append('.');
        sb.append((i6 >> 8) & 255);
        sb.append('.');
        sb.append(i6 & 255);
        return sb.toString();
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return true;
        }
        if (c6 < 'A' || c6 > 'F') {
            return c6 >= 'a' && c6 <= 'f';
        }
        return true;
    }

    private static boolean isValidIPv4MappedChar(char c6) {
        return c6 == 'f' || c6 == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b6, byte b7, boolean z5) {
        if (b6 != b7) {
            return false;
        }
        if (b6 != 0) {
            return !z5 && b7 == -1;
        }
        return true;
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence, int i6, int i7) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i8 = i7 - i6;
        return i8 <= 15 && i8 >= 7 && (indexOf = AsciiString.indexOf(charSequence, '.', i6 + 1)) > 0 && isValidIpV4Word(charSequence, i6, indexOf) && (indexOf2 = AsciiString.indexOf(charSequence, '.', indexOf + 2)) > 0 && isValidIpV4Word(charSequence, indexOf + 1, indexOf2) && (indexOf3 = AsciiString.indexOf(charSequence, '.', indexOf2 + 2)) > 0 && isValidIpV4Word(charSequence, indexOf2 + 1, indexOf3) && isValidIpV4Word(charSequence, indexOf3 + 1, i7);
    }

    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i6;
        int i7;
        int length = charSequence.length();
        int i8 = 2;
        if (length < 2) {
            return false;
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '[') {
            length--;
            if (charSequence.charAt(length) != ']') {
                return false;
            }
            charAt = charSequence.charAt(1);
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (charAt != ':') {
            i8 = 0;
            i7 = -1;
        } else {
            if (charSequence.charAt(i6 + 1) != ':') {
                return false;
            }
            int i9 = i6;
            i6 += 2;
            i7 = i9;
        }
        int i10 = i6;
        int i11 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char charAt2 = charSequence.charAt(i10);
            if (!isValidHexChar(charAt2)) {
                if (charAt2 == '%') {
                    length = i10;
                    break;
                }
                if (charAt2 == '.') {
                    if ((i7 < 0 && i8 != 6) || ((i8 == 7 && i7 >= i6) || i8 > 7)) {
                        return false;
                    }
                    int i12 = i10 - i11;
                    int i13 = i12 - 2;
                    if (isValidIPv4MappedChar(charSequence.charAt(i13))) {
                        if (!isValidIPv4MappedChar(charSequence.charAt(i12 - 3)) || !isValidIPv4MappedChar(charSequence.charAt(i12 - 4)) || !isValidIPv4MappedChar(charSequence.charAt(i12 - 5))) {
                            return false;
                        }
                        i13 = i12 - 7;
                    }
                    while (i13 >= i6) {
                        char charAt3 = charSequence.charAt(i13);
                        if (charAt3 != '0' && charAt3 != ':') {
                            return false;
                        }
                        i13--;
                    }
                    int indexOf = AsciiString.indexOf(charSequence, '%', i12 + 7);
                    if (indexOf >= 0) {
                        length = indexOf;
                    }
                    return isValidIpV4Address(charSequence, i12, length);
                }
                if (charAt2 != ':' || i8 > 7) {
                    return false;
                }
                int i14 = i10 - 1;
                if (charSequence.charAt(i14) != ':') {
                    i11 = 0;
                } else {
                    if (i7 >= 0) {
                        return false;
                    }
                    i7 = i14;
                }
                i8++;
            } else {
                if (i11 >= 4) {
                    return false;
                }
                i11++;
            }
            i10++;
        }
        return i7 < 0 ? i8 == 7 && i11 > 0 : i7 + 2 == length || (i11 > 0 && (i8 < 8 || i7 <= i6));
    }

    private static boolean isValidNumericChar(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process start = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine.startsWith(str)) {
                    int length = readLine.length();
                    do {
                        length--;
                        if (length > str.length()) {
                        }
                    } while (Character.isDigit(readLine.charAt(length)));
                    Integer valueOf = Integer.valueOf(readLine.substring(length + 1));
                    start.destroy();
                    return valueOf;
                }
                start.destroy();
                return null;
            } finally {
                bufferedReader.close();
            }
        } catch (Throwable th) {
            if (start != null) {
                start.destroy();
            }
            throw th;
        }
    }

    public static String toAddressString(InetAddress inetAddress, boolean z5) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            return toAddressString(inetAddress.getAddress(), 0, z5);
        }
        throw new IllegalArgumentException("Unhandled type: " + inetAddress);
    }

    static byte[] validIpV4ToBytes(String str) {
        int indexOf = str.indexOf(46, 1);
        byte ipv4WordToByte = ipv4WordToByte(str, 0, indexOf);
        int i6 = indexOf + 1;
        int indexOf2 = str.indexOf(46, indexOf + 2);
        byte ipv4WordToByte2 = ipv4WordToByte(str, i6, indexOf2);
        int indexOf3 = str.indexOf(46, indexOf2 + 2);
        return new byte[]{ipv4WordToByte, ipv4WordToByte2, ipv4WordToByte(str, indexOf2 + 1, indexOf3), ipv4WordToByte(str, indexOf3 + 1, str.length())};
    }

    private NetUtil() {
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (isValidIpV6Address(str)) {
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length() - 1);
            }
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return getIPv6ByName(str, true);
        }
        return null;
    }

    private static int decimalDigit(String str, int i6) {
        return str.charAt(i6) - '0';
    }

    public static String getHostname(InetSocketAddress inetSocketAddress) {
        if (PlatformDependent.javaVersion() >= 7) {
            return inetSocketAddress.getHostString();
        }
        return inetSocketAddress.getHostName();
    }

    private static byte ipv4WordToByte(String str, int i6, int i7) {
        int decimalDigit = decimalDigit(str, i6);
        int i8 = i6 + 1;
        if (i8 == i7) {
            return (byte) decimalDigit;
        }
        int decimalDigit2 = (decimalDigit * 10) + decimalDigit(str, i8);
        int i9 = i6 + 2;
        if (i9 == i7) {
            return (byte) decimalDigit2;
        }
        return (byte) ((decimalDigit2 * 10) + decimalDigit(str, i9));
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i6, int i7) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i6, i7);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i6, i7);
        }
        return isValidIpV4Address0(charSequence, i6, i7);
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z5) {
        int length = str.length();
        if (z5) {
            StringBuilder sb = new StringBuilder(length + 1 + str2.length());
            sb.append(str);
            return sb;
        }
        StringBuilder sb2 = new StringBuilder(length + 3 + str2.length());
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb2.append(str);
            return sb2;
        }
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        return sb2;
    }

    private static boolean isValidIpV4Address(String str, int i6, int i7) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i8 = i7 - i6;
        return i8 <= 15 && i8 >= 7 && (indexOf = str.indexOf(46, i6 + 1)) > 0 && isValidIpV4Word(str, i6, indexOf) && (indexOf2 = str.indexOf(46, indexOf + 2)) > 0 && isValidIpV4Word(str, indexOf + 1, indexOf2) && (indexOf3 = str.indexOf(46, indexOf2 + 2)) > 0 && isValidIpV4Word(str, indexOf2 + 1, indexOf3) && isValidIpV4Word(str, indexOf3 + 1, i7);
    }

    private static String toAddressString(byte[] bArr, int i6, boolean z5) {
        int i7;
        int i8;
        int[] iArr = new int[8];
        int i9 = i6 + 8;
        while (true) {
            i7 = 1;
            if (i6 >= i9) {
                break;
            }
            int i10 = i6 << 1;
            iArr[i6] = (bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8);
            i6++;
        }
        int i11 = -1;
        boolean z6 = false;
        int i12 = 0;
        int i13 = -1;
        int i14 = 0;
        int i15 = -1;
        while (i12 < 8) {
            if (iArr[i12] == 0) {
                if (i13 < 0) {
                    i13 = i12;
                }
            } else if (i13 >= 0) {
                int i16 = i12 - i13;
                if (i16 > i14) {
                    i14 = i16;
                } else {
                    i13 = i15;
                }
                i15 = i13;
                i13 = -1;
            }
            i12++;
        }
        if (i13 < 0 || (i8 = i12 - i13) <= i14) {
            i13 = i15;
        } else {
            i14 = i8;
        }
        if (i14 == 1) {
            i14 = 0;
        } else {
            i11 = i13;
        }
        int i17 = i14 + i11;
        StringBuilder sb = new StringBuilder(39);
        if (i17 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i7 < 8) {
                sb.append(':');
                sb.append(Integer.toHexString(iArr[i7]));
                i7++;
            }
        } else {
            if (inRangeEndExclusive(0, i11, i17)) {
                sb.append("::");
                if (z5 && i17 == 5 && iArr[5] == 65535) {
                    z6 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i7 < 8) {
                if (!inRangeEndExclusive(i7, i11, i17)) {
                    if (!inRangeEndExclusive(i7 - 1, i11, i17)) {
                        if (z6 && i7 != 6) {
                            sb.append('.');
                        } else {
                            sb.append(':');
                        }
                    }
                    if (z6 && i7 > 5) {
                        sb.append(iArr[i7] >> 8);
                        sb.append('.');
                        sb.append(iArr[i7] & 255);
                    } else {
                        sb.append(Integer.toHexString(iArr[i7]));
                    }
                } else if (!inRangeEndExclusive(i7 - 1, i11, i17)) {
                    sb.append("::");
                }
                i7++;
            }
        }
        return sb.toString();
    }

    public static String toSocketAddressString(String str, int i6) {
        String valueOf = String.valueOf(i6);
        StringBuilder newSocketAddressStringBuilder = newSocketAddressStringBuilder(str, valueOf, !isValidIpV6Address(str));
        newSocketAddressStringBuilder.append(':');
        newSocketAddressStringBuilder.append(valueOf);
        return newSocketAddressStringBuilder.toString();
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i6, int i7) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i8 = i7 - i6;
        return i8 <= 15 && i8 >= 7 && (indexOf = asciiString.indexOf('.', i6 + 1)) > 0 && isValidIpV4Word(asciiString, i6, indexOf) && (indexOf2 = asciiString.indexOf('.', indexOf + 2)) > 0 && isValidIpV4Word(asciiString, indexOf + 1, indexOf2) && (indexOf3 = asciiString.indexOf('.', indexOf2 + 2)) > 0 && isValidIpV4Word(asciiString, indexOf2 + 1, indexOf3) && isValidIpV4Word(asciiString, indexOf3 + 1, i7);
    }
}
