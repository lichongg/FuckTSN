package io.netty.util.internal;

import io.netty.util.NetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MacAddressUtil {
    private static final int EUI48_MAC_ADDRESS_LENGTH = 6;
    private static final int EUI64_MAC_ADDRESS_LENGTH = 8;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) MacAddressUtil.class);

    static int compareAddresses(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr2.length >= 6) {
            for (byte b6 : bArr2) {
                if (b6 != 0 && b6 != 1) {
                    byte b7 = bArr2[0];
                    if ((b7 & 1) != 0) {
                        return 1;
                    }
                    return (b7 & 2) == 0 ? (bArr.length == 0 || (bArr[0] & 2) != 0) ? -1 : 0 : (bArr.length == 0 || (bArr[0] & 2) != 0) ? 0 : 1;
                }
            }
        }
        return 1;
    }

    public static byte[] bestAvailableMac() {
        int compareAddresses;
        byte[] bArr = EmptyArrays.EMPTY_BYTES;
        InetAddress inetAddress = NetUtil.LOCALHOST4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> addressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(nextElement);
                    if (addressesFromNetworkInterface.hasMoreElements()) {
                        InetAddress nextElement2 = addressesFromNetworkInterface.nextElement();
                        if (!nextElement2.isLoopbackAddress()) {
                            linkedHashMap.put(nextElement, nextElement2);
                        }
                    }
                }
            }
        } catch (SocketException e6) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e6);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            NetworkInterface networkInterface = (NetworkInterface) entry.getKey();
            InetAddress inetAddress2 = (InetAddress) entry.getValue();
            if (!networkInterface.isVirtual()) {
                try {
                    byte[] hardwareAddressFromNetworkInterface = SocketUtils.hardwareAddressFromNetworkInterface(networkInterface);
                    int compareAddresses2 = compareAddresses(bArr, hardwareAddressFromNetworkInterface);
                    if (compareAddresses2 < 0 || (compareAddresses2 == 0 && ((compareAddresses = compareAddresses(inetAddress, inetAddress2)) < 0 || (compareAddresses == 0 && bArr.length < hardwareAddressFromNetworkInterface.length)))) {
                        inetAddress = inetAddress2;
                        bArr = hardwareAddressFromNetworkInterface;
                    }
                } catch (SocketException e7) {
                    logger.debug("Failed to get the hardware address of a network interface: {}", networkInterface, e7);
                }
            }
        }
        if (bArr == EmptyArrays.EMPTY_BYTES) {
            return null;
        }
        if (bArr.length != 6) {
            return Arrays.copyOf(bArr, 8);
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 3);
        bArr2[3] = -1;
        bArr2[4] = -2;
        System.arraycopy(bArr, 3, bArr2, 5, 3);
        return bArr2;
    }

    public static String formatAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder(24);
        for (byte b6 : bArr) {
            sb.append(String.format("%02x:", Integer.valueOf(b6 & 255)));
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static void validateMacSeparator(char c6) {
        if (c6 == ':' || c6 == '-') {
            return;
        }
        throw new IllegalArgumentException("unsupported separator: " + c6 + " (expected: [:-])");
    }

    private MacAddressUtil() {
    }

    public static byte[] defaultMachineId() {
        byte[] bestAvailableMac = bestAvailableMac();
        if (bestAvailableMac == null) {
            byte[] bArr = new byte[8];
            PlatformDependent.threadLocalRandom().nextBytes(bArr);
            logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", formatAddress(bArr));
            return bArr;
        }
        return bestAvailableMac;
    }

    public static byte[] parseMAC(String str) {
        char charAt;
        byte[] bArr;
        int length = str.length();
        if (length != 17) {
            if (length == 23) {
                charAt = str.charAt(2);
                validateMacSeparator(charAt);
                bArr = new byte[8];
            } else {
                throw new IllegalArgumentException("value is not supported [MAC-48, EUI-48, EUI-64]");
            }
        } else {
            charAt = str.charAt(2);
            validateMacSeparator(charAt);
            bArr = new byte[6];
        }
        int length2 = bArr.length - 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length2) {
            int i8 = i7 + 2;
            bArr[i6] = StringUtil.decodeHexByte(str, i7);
            if (str.charAt(i8) == charAt) {
                i6++;
                i7 += 3;
            } else {
                throw new IllegalArgumentException("expected separator '" + charAt + " but got '" + str.charAt(i8) + "' at index: " + i8);
            }
        }
        bArr[length2] = StringUtil.decodeHexByte(str, i7);
        return bArr;
    }

    private static int scoreAddress(InetAddress inetAddress) {
        if (!inetAddress.isAnyLocalAddress() && !inetAddress.isLoopbackAddress()) {
            if (inetAddress.isMulticastAddress()) {
                return 1;
            }
            if (inetAddress.isLinkLocalAddress()) {
                return 2;
            }
            if (inetAddress.isSiteLocalAddress()) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private static int compareAddresses(InetAddress inetAddress, InetAddress inetAddress2) {
        return scoreAddress(inetAddress) - scoreAddress(inetAddress2);
    }
}
