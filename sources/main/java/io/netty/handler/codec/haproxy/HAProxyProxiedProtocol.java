package io.netty.handler.codec.haproxy;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TCP4' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HAProxyProxiedProtocol {
    private static final /* synthetic */ HAProxyProxiedProtocol[] $VALUES;
    public static final HAProxyProxiedProtocol TCP4;
    public static final HAProxyProxiedProtocol TCP6;
    public static final HAProxyProxiedProtocol UDP4;
    public static final HAProxyProxiedProtocol UDP6;
    public static final HAProxyProxiedProtocol UNIX_DGRAM;
    public static final HAProxyProxiedProtocol UNIX_STREAM;
    public static final HAProxyProxiedProtocol UNKNOWN;
    private final AddressFamily addressFamily;
    private final byte byteValue;
    private final TransportProtocol transportProtocol;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AddressFamily {
        AF_UNSPEC((byte) 0),
        AF_IPv4((byte) 16),
        AF_IPv6((byte) 32),
        AF_UNIX((byte) 48);

        private static final byte FAMILY_MASK = -16;
        private final byte byteValue;

        public static AddressFamily valueOf(byte b6) {
            int i6 = b6 & FAMILY_MASK;
            byte b7 = (byte) i6;
            if (b7 == 0) {
                return AF_UNSPEC;
            }
            if (b7 == 16) {
                return AF_IPv4;
            }
            if (b7 == 32) {
                return AF_IPv6;
            }
            if (b7 == 48) {
                return AF_UNIX;
            }
            throw new IllegalArgumentException("unknown address family: " + i6);
        }

        public byte byteValue() {
            return this.byteValue;
        }

        AddressFamily(byte b6) {
            this.byteValue = b6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum TransportProtocol {
        UNSPEC((byte) 0),
        STREAM((byte) 1),
        DGRAM((byte) 2);

        private static final byte TRANSPORT_MASK = 15;
        private final byte transportByte;

        public static TransportProtocol valueOf(byte b6) {
            int i6 = b6 & 15;
            byte b7 = (byte) i6;
            if (b7 == 0) {
                return UNSPEC;
            }
            if (b7 == 1) {
                return STREAM;
            }
            if (b7 == 2) {
                return DGRAM;
            }
            throw new IllegalArgumentException("unknown transport protocol: " + i6);
        }

        public byte byteValue() {
            return this.transportByte;
        }

        TransportProtocol(byte b6) {
            this.transportByte = b6;
        }
    }

    public static HAProxyProxiedProtocol valueOf(String str) {
        return (HAProxyProxiedProtocol) Enum.valueOf(HAProxyProxiedProtocol.class, str);
    }

    static {
        HAProxyProxiedProtocol hAProxyProxiedProtocol = new HAProxyProxiedProtocol("UNKNOWN", 0, (byte) 0, AddressFamily.AF_UNSPEC, TransportProtocol.UNSPEC);
        UNKNOWN = hAProxyProxiedProtocol;
        AddressFamily addressFamily = AddressFamily.AF_IPv4;
        TransportProtocol transportProtocol = TransportProtocol.STREAM;
        HAProxyProxiedProtocol hAProxyProxiedProtocol2 = new HAProxyProxiedProtocol("TCP4", 1, (byte) 17, addressFamily, transportProtocol);
        TCP4 = hAProxyProxiedProtocol2;
        AddressFamily addressFamily2 = AddressFamily.AF_IPv6;
        HAProxyProxiedProtocol hAProxyProxiedProtocol3 = new HAProxyProxiedProtocol("TCP6", 2, BinaryMemcacheOpcodes.SASL_AUTH, addressFamily2, transportProtocol);
        TCP6 = hAProxyProxiedProtocol3;
        TransportProtocol transportProtocol2 = TransportProtocol.DGRAM;
        HAProxyProxiedProtocol hAProxyProxiedProtocol4 = new HAProxyProxiedProtocol("UDP4", 3, (byte) 18, addressFamily, transportProtocol2);
        UDP4 = hAProxyProxiedProtocol4;
        HAProxyProxiedProtocol hAProxyProxiedProtocol5 = new HAProxyProxiedProtocol("UDP6", 4, (byte) 34, addressFamily2, transportProtocol2);
        UDP6 = hAProxyProxiedProtocol5;
        AddressFamily addressFamily3 = AddressFamily.AF_UNIX;
        HAProxyProxiedProtocol hAProxyProxiedProtocol6 = new HAProxyProxiedProtocol("UNIX_STREAM", 5, (byte) 49, addressFamily3, transportProtocol);
        UNIX_STREAM = hAProxyProxiedProtocol6;
        HAProxyProxiedProtocol hAProxyProxiedProtocol7 = new HAProxyProxiedProtocol("UNIX_DGRAM", 6, (byte) 50, addressFamily3, transportProtocol2);
        UNIX_DGRAM = hAProxyProxiedProtocol7;
        $VALUES = new HAProxyProxiedProtocol[]{hAProxyProxiedProtocol, hAProxyProxiedProtocol2, hAProxyProxiedProtocol3, hAProxyProxiedProtocol4, hAProxyProxiedProtocol5, hAProxyProxiedProtocol6, hAProxyProxiedProtocol7};
    }

    public static HAProxyProxiedProtocol valueOf(byte b6) {
        if (b6 == 0) {
            return UNKNOWN;
        }
        if (b6 == 17) {
            return TCP4;
        }
        if (b6 == 18) {
            return UDP4;
        }
        if (b6 == 33) {
            return TCP6;
        }
        if (b6 == 34) {
            return UDP6;
        }
        if (b6 == 49) {
            return UNIX_STREAM;
        }
        if (b6 == 50) {
            return UNIX_DGRAM;
        }
        throw new IllegalArgumentException("unknown transport protocol + address family: " + (b6 & 255));
    }

    public static HAProxyProxiedProtocol[] values() {
        return (HAProxyProxiedProtocol[]) $VALUES.clone();
    }

    public AddressFamily addressFamily() {
        return this.addressFamily;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public TransportProtocol transportProtocol() {
        return this.transportProtocol;
    }

    private HAProxyProxiedProtocol(String str, int i6, byte b6, AddressFamily addressFamily, TransportProtocol transportProtocol) {
        this.byteValue = b6;
        this.addressFamily = addressFamily;
        this.transportProtocol = transportProtocol;
    }
}
