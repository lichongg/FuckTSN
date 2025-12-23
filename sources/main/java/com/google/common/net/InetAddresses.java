package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.j1;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class InetAddresses {
    private static final int IPV4_PART_COUNT = 4;
    private static final int IPV6_PART_COUNT = 8;
    private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(4);
    private static final Splitter IPV6_SPLITTER = Splitter.on(':').limit(10);
    private static final Inet4Address LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
    private static final Inet4Address ANY4 = (Inet4Address) forString("0.0.0.0");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public Inet4Address getClient() {
            return this.client;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getPort() {
            return this.port;
        }

        public Inet4Address getServer() {
            return this.server;
        }

        public TeredoInfo(@NullableDecl Inet4Address inet4Address, @NullableDecl Inet4Address inet4Address2, int i6, int i7) {
            boolean z5;
            boolean z6 = false;
            if (i6 >= 0 && i6 <= 65535) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "port '%s' is out of range (0 <= port <= 0xffff)", i6);
            if (i7 >= 0 && i7 <= 65535) {
                z6 = true;
            }
            Preconditions.checkArgument(z6, "flags '%s' is out of range (0 <= flags <= 0xffff)", i7);
            this.server = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = i6;
            this.flags = i7;
        }
    }

    private static void compressLongestRunOfZeroes(int[] iArr) {
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < iArr.length + 1; i9++) {
            if (i9 >= iArr.length || iArr[i9] != 0) {
                if (i8 >= 0) {
                    int i10 = i9 - i8;
                    if (i10 > i6) {
                        i7 = i8;
                        i6 = i10;
                    }
                    i8 = -1;
                }
            } else if (i8 < 0) {
                i8 = i9;
            }
        }
        if (i6 >= 2) {
            Arrays.fill(iArr, i7, i6 + i7, -1);
        }
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i6 = 0; i6 < bArr.length; i6++) {
            bArr2[i6] = bArr[(bArr.length - i6) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    private static Inet4Address getInet4Address(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) bytesToInetAddress(bArr);
    }

    @NullableDecl
    private static byte[] ipStringToBytes(String str) {
        boolean z5 = false;
        boolean z6 = false;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '.') {
                z6 = true;
            } else if (charAt == ':') {
                if (z6) {
                    return null;
                }
                z5 = true;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
        }
        if (!z5) {
            if (z6) {
                return textToNumericFormatV4(str);
            }
            return null;
        }
        if (z6 && (str = convertDottedQuadToHex(str)) == null) {
            return null;
        }
        return textToNumericFormatV6(str);
    }

    @NullableDecl
    private static byte[] textToNumericFormatV4(String str) {
        int i6;
        byte[] bArr = new byte[4];
        try {
            Iterator<String> it = IPV4_SPLITTER.split(str).iterator();
            i6 = 0;
            while (it.hasNext()) {
                int i7 = i6 + 1;
                bArr[i6] = parseOctet(it.next());
                i6 = i7;
            }
        } catch (NumberFormatException unused) {
        }
        if (i6 == 4) {
            return bArr;
        }
        return null;
    }

    @NullableDecl
    private static String convertDottedQuadToHex(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] textToNumericFormatV4 = textToNumericFormatV4(str.substring(lastIndexOf));
        if (textToNumericFormatV4 == null) {
            return null;
        }
        return substring + Integer.toHexString(((textToNumericFormatV4[0] & 255) << 8) | (textToNumericFormatV4[1] & 255)) + ":" + Integer.toHexString((textToNumericFormatV4[3] & 255) | ((textToNumericFormatV4[2] & 255) << 8));
    }

    private static IllegalArgumentException formatIllegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z5;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i6 = 0;
        while (true) {
            if (i6 >= 15) {
                z5 = true;
                break;
            }
            if (address[i6] != 0) {
                z5 = false;
                break;
            }
            i6++;
        }
        if (z5 && address[15] == 1) {
            return LOOPBACK4;
        }
        if (z5 && address[15] == 0) {
            return ANY4;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int asInt = Hashing.murmur3_32().hashLong(hasEmbeddedIPv4ClientAddress(inet6Address) ? getEmbeddedIPv4ClientAddress(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        if (asInt == -1) {
            asInt = -2;
        }
        return getInet4Address(Ints.toByteArray(asInt));
    }

    private static String hextetsToIPv6String(int[] iArr) {
        StringBuilder sb = new StringBuilder(39);
        int i6 = 0;
        boolean z5 = false;
        while (i6 < iArr.length) {
            boolean z6 = iArr[i6] >= 0;
            if (z6) {
                if (z5) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i6]));
            } else if (i6 == 0 || z5) {
                sb.append("::");
            }
            i6++;
            z5 = z6;
        }
        return sb.toString();
    }

    private static short parseHextet(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt <= 65535) {
            return (short) parseInt;
        }
        throw new NumberFormatException();
    }

    @NullableDecl
    private static byte[] textToNumericFormatV6(String str) {
        int size;
        int i6;
        List<String> splitToList = IPV6_SPLITTER.splitToList(str);
        if (splitToList.size() < 3 || splitToList.size() > 9) {
            return null;
        }
        int i7 = -1;
        for (int i8 = 1; i8 < splitToList.size() - 1; i8++) {
            if (splitToList.get(i8).length() == 0) {
                if (i7 >= 0) {
                    return null;
                }
                i7 = i8;
            }
        }
        if (i7 >= 0) {
            int size2 = splitToList.size() - i7;
            i6 = size2 - 1;
            if (splitToList.get(0).length() == 0) {
                size = i7 - 1;
                if (size != 0) {
                    return null;
                }
            } else {
                size = i7;
            }
            if (((String) Iterables.getLast(splitToList)).length() == 0 && size2 - 2 != 0) {
                return null;
            }
        } else {
            size = splitToList.size();
            i6 = 0;
        }
        int i9 = 8 - (size + i6);
        if (i7 < 0 ? i9 != 0 : i9 < 1) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(16);
        for (int i10 = 0; i10 < size; i10++) {
            try {
                allocate.putShort(parseHextet(splitToList.get(i10)));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        for (int i11 = 0; i11 < i9; i11++) {
            allocate.putShort((short) 0);
        }
        while (i6 > 0) {
            allocate.putShort(parseHextet(splitToList.get(splitToList.size() - i6)));
            i6--;
        }
        return allocate.array();
    }

    public static String toUriString(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return toAddrString(inetAddress);
        }
        return "[" + toAddrString(inetAddress) + "]";
    }

    private InetAddresses() {
    }

    private static InetAddress bytesToInetAddress(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e6) {
            throw new AssertionError(e6);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        boolean z5;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        if (length >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return bytesToInetAddress(address);
    }

    public static InetAddress forString(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes != null) {
            return bytesToInetAddress(ipStringToBytes);
        }
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress forUriStringNoThrow = forUriStringNoThrow(str);
        if (forUriStringNoThrow != null) {
            return forUriStringNoThrow;
        }
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", str);
    }

    @NullableDecl
    private static InetAddress forUriStringNoThrow(String str) {
        int i6;
        Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i6 = 16;
        } else {
            i6 = 4;
        }
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes != null && ipStringToBytes.length == i6) {
            return bytesToInetAddress(ipStringToBytes);
        }
        return null;
    }

    public static Inet4Address fromInteger(int i6) {
        return getInet4Address(Ints.toByteArray(i6));
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        int readShort = ByteStreams.newDataInput(address, 8).readShort() & j1.f43986d;
        int i6 = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i7 = 0; i7 < copyOfRange.length; i7++) {
            copyOfRange[i7] = (byte) (~copyOfRange[i7]);
        }
        return new TeredoInfo(inet4Address, getInet4Address(copyOfRange), i6, readShort);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (!isCompatIPv4Address(inet6Address) && !is6to4Address(inet6Address) && !isTeredoAddress(inet6Address)) {
            return false;
        }
        return true;
    }

    public static InetAddress increment(InetAddress inetAddress) {
        boolean z5;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            z5 = false;
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        if (length >= 0) {
            z5 = true;
        }
        Preconditions.checkArgument(z5, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return bytesToInetAddress(address);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] != 32 || address[1] != 2) {
            return false;
        }
        return true;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        byte b6;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b6 = address[15]) == 0 || b6 == 1)) {
            return false;
        }
        return true;
    }

    public static boolean isInetAddress(String str) {
        if (ipStringToBytes(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) != 3 || address[9] != 0 || address[10] != 94 || address[11] != -2) {
            return false;
        }
        return true;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != 16) {
            return false;
        }
        int i6 = 0;
        while (true) {
            if (i6 < 10) {
                if (ipStringToBytes[i6] != 0) {
                    return false;
                }
                i6++;
            } else {
                for (int i7 = 10; i7 < 12; i7++) {
                    if (ipStringToBytes[i7] != -1) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        for (byte b6 : inetAddress.getAddress()) {
            if (b6 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] != 32 || address[1] != 1 || address[2] != 0 || address[3] != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUriInetAddress(String str) {
        if (forUriStringNoThrow(str) != null) {
            return true;
        }
        return false;
    }

    private static byte parseOctet(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt <= 255 && (!str.startsWith("0") || str.length() <= 1)) {
            return (byte) parseInt;
        }
        throw new NumberFormatException();
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i6 = 0; i6 < 8; i6++) {
            int i7 = i6 * 2;
            iArr[i6] = Ints.fromBytes((byte) 0, (byte) 0, address[i7], address[i7 + 1]);
        }
        compressLongestRunOfZeroes(iArr);
        return hextetsToIPv6String(iArr);
    }
}
