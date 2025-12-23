package io.netty.handler.codec.haproxy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.haproxy.HAProxyProxiedProtocol;
import io.netty.handler.codec.haproxy.HAProxyTLV;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HAProxyMessage extends AbstractReferenceCounted {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ResourceLeakDetector<HAProxyMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HAProxyMessage.class);
    private final HAProxyCommand command;
    private final String destinationAddress;
    private final int destinationPort;
    private final ResourceLeakTracker<HAProxyMessage> leak;
    private final HAProxyProtocolVersion protocolVersion;
    private final HAProxyProxiedProtocol proxiedProtocol;
    private final String sourceAddress;
    private final int sourcePort;
    private final List<HAProxyTLV> tlvs;

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, String str3, String str4) {
        this(hAProxyProtocolVersion, hAProxyCommand, hAProxyProxiedProtocol, str, str2, portStringToInt(str3), portStringToInt(str4));
    }

    static HAProxyMessage decodeHeader(ByteBuf byteBuf) {
        String ipBytesToString;
        String ipBytesToString2;
        int readUnsignedShort;
        int readUnsignedShort2;
        if (byteBuf == null) {
            throw new NullPointerException("header");
        }
        int i6 = 16;
        if (byteBuf.readableBytes() < 16) {
            throw new HAProxyProtocolException("incomplete header: " + byteBuf.readableBytes() + " bytes (expected: 16+ bytes)");
        }
        byteBuf.skipBytes(12);
        byte readByte = byteBuf.readByte();
        try {
            HAProxyProtocolVersion valueOf = HAProxyProtocolVersion.valueOf(readByte);
            HAProxyProtocolVersion hAProxyProtocolVersion = HAProxyProtocolVersion.V2;
            if (valueOf != hAProxyProtocolVersion) {
                throw new HAProxyProtocolException("version 1 unsupported: 0x" + Integer.toHexString(readByte));
            }
            try {
                HAProxyCommand valueOf2 = HAProxyCommand.valueOf(readByte);
                HAProxyCommand hAProxyCommand = HAProxyCommand.LOCAL;
                if (valueOf2 == hAProxyCommand) {
                    return unknownMsg(hAProxyProtocolVersion, hAProxyCommand);
                }
                try {
                    HAProxyProxiedProtocol valueOf3 = HAProxyProxiedProtocol.valueOf(byteBuf.readByte());
                    if (valueOf3 == HAProxyProxiedProtocol.UNKNOWN) {
                        return unknownMsg(hAProxyProtocolVersion, HAProxyCommand.PROXY);
                    }
                    int readUnsignedShort3 = byteBuf.readUnsignedShort();
                    HAProxyProxiedProtocol.AddressFamily addressFamily = valueOf3.addressFamily();
                    if (addressFamily != HAProxyProxiedProtocol.AddressFamily.AF_UNIX) {
                        if (addressFamily == HAProxyProxiedProtocol.AddressFamily.AF_IPv4) {
                            if (readUnsignedShort3 < 12 || byteBuf.readableBytes() < 12) {
                                throw new HAProxyProtocolException("incomplete IPv4 address information: " + Math.min(readUnsignedShort3, byteBuf.readableBytes()) + " bytes (expected: 12+ bytes)");
                            }
                            i6 = 4;
                        } else {
                            if (addressFamily != HAProxyProxiedProtocol.AddressFamily.AF_IPv6) {
                                throw new HAProxyProtocolException("unable to parse address information (unknown address family: " + addressFamily + ')');
                            }
                            if (readUnsignedShort3 < 36 || byteBuf.readableBytes() < 36) {
                                throw new HAProxyProtocolException("incomplete IPv6 address information: " + Math.min(readUnsignedShort3, byteBuf.readableBytes()) + " bytes (expected: 36+ bytes)");
                            }
                        }
                        ipBytesToString = ipBytesToString(byteBuf, i6);
                        ipBytesToString2 = ipBytesToString(byteBuf, i6);
                        readUnsignedShort = byteBuf.readUnsignedShort();
                        readUnsignedShort2 = byteBuf.readUnsignedShort();
                    } else {
                        if (readUnsignedShort3 < 216 || byteBuf.readableBytes() < 216) {
                            throw new HAProxyProtocolException("incomplete UNIX socket address information: " + Math.min(readUnsignedShort3, byteBuf.readableBytes()) + " bytes (expected: 216+ bytes)");
                        }
                        int readerIndex = byteBuf.readerIndex();
                        ByteProcessor byteProcessor = ByteProcessor.FIND_NUL;
                        int forEachByte = byteBuf.forEachByte(readerIndex, 108, byteProcessor);
                        int i7 = forEachByte == -1 ? 108 : forEachByte - readerIndex;
                        Charset charset = CharsetUtil.US_ASCII;
                        ipBytesToString = byteBuf.toString(readerIndex, i7, charset);
                        int i8 = readerIndex + 108;
                        int forEachByte2 = byteBuf.forEachByte(i8, 108, byteProcessor);
                        ipBytesToString2 = byteBuf.toString(i8, forEachByte2 != -1 ? forEachByte2 - i8 : 108, charset);
                        byteBuf.readerIndex(readerIndex + MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF);
                        readUnsignedShort = 0;
                        readUnsignedShort2 = 0;
                    }
                    return new HAProxyMessage(valueOf, valueOf2, valueOf3, ipBytesToString, ipBytesToString2, readUnsignedShort, readUnsignedShort2, readTlvs(byteBuf));
                } catch (IllegalArgumentException e6) {
                    throw new HAProxyProtocolException(e6);
                }
            } catch (IllegalArgumentException e7) {
                throw new HAProxyProtocolException(e7);
            }
        } catch (IllegalArgumentException e8) {
            throw new HAProxyProtocolException(e8);
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public boolean release() {
        tryRecord();
        return super.release();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.haproxy.HAProxyMessage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type;

        static {
            int[] iArr = new int[HAProxyProxiedProtocol.AddressFamily.values().length];
            $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily = iArr;
            try {
                iArr[HAProxyProxiedProtocol.AddressFamily.AF_UNSPEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_UNIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_IPv4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[HAProxyProxiedProtocol.AddressFamily.AF_IPv6.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[HAProxyTLV.Type.values().length];
            $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type = iArr2;
            try {
                iArr2[HAProxyTLV.Type.PP2_TYPE_SSL.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[HAProxyTLV.Type.PP2_TYPE_ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[HAProxyTLV.Type.PP2_TYPE_AUTHORITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[HAProxyTLV.Type.PP2_TYPE_SSL_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[HAProxyTLV.Type.PP2_TYPE_SSL_CN.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[HAProxyTLV.Type.PP2_TYPE_NETNS.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[HAProxyTLV.Type.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static void checkAddress(String str, HAProxyProxiedProtocol.AddressFamily addressFamily) {
        if (addressFamily == null) {
            throw new NullPointerException("addrFamily");
        }
        int[] iArr = AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily;
        int i6 = iArr[addressFamily.ordinal()];
        if (i6 == 1) {
            if (str == null) {
                return;
            }
            throw new HAProxyProtocolException("unable to validate an AF_UNSPEC address: " + str);
        }
        if (i6 != 2) {
            if (str == null) {
                throw new NullPointerException("address");
            }
            int i7 = iArr[addressFamily.ordinal()];
            if (i7 == 3) {
                if (NetUtil.isValidIpV4Address(str)) {
                    return;
                }
                throw new HAProxyProtocolException("invalid IPv4 address: " + str);
            }
            if (i7 != 4) {
                throw new Error();
            }
            if (NetUtil.isValidIpV6Address(str)) {
                return;
            }
            throw new HAProxyProtocolException("invalid IPv6 address: " + str);
        }
    }

    private static void checkPort(int i6) {
        if (i6 < 0 || i6 > 65535) {
            throw new HAProxyProtocolException("invalid port: " + i6 + " (expected: 1 ~ 65535)");
        }
    }

    private static String ipBytesToString(ByteBuf byteBuf, int i6) {
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        if (i6 == 4) {
            while (i7 < 4) {
                sb.append(byteBuf.readByte() & 255);
                sb.append('.');
                i7++;
            }
        } else {
            while (i7 < 8) {
                sb.append(Integer.toHexString(byteBuf.readUnsignedShort()));
                sb.append(':');
                i7++;
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static int portStringToInt(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt > 0 && parseInt <= 65535) {
                return parseInt;
            }
            throw new HAProxyProtocolException("invalid port: " + str + " (expected: 1 ~ 65535)");
        } catch (NumberFormatException e6) {
            throw new HAProxyProtocolException("invalid port: " + str, e6);
        }
    }

    private void tryRecord() {
        ResourceLeakTracker<HAProxyMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
    }

    private static HAProxyMessage unknownMsg(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand) {
        return new HAProxyMessage(hAProxyProtocolVersion, hAProxyCommand, HAProxyProxiedProtocol.UNKNOWN, (String) null, (String) null, 0, 0);
    }

    public HAProxyCommand command() {
        return this.command;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        try {
            Iterator<HAProxyTLV> it = this.tlvs.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        } finally {
            ResourceLeakTracker<HAProxyMessage> resourceLeakTracker = this.leak;
            if (resourceLeakTracker != null) {
                resourceLeakTracker.close(this);
            }
        }
    }

    public String destinationAddress() {
        return this.destinationAddress;
    }

    public int destinationPort() {
        return this.destinationPort;
    }

    public HAProxyProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public HAProxyProxiedProtocol proxiedProtocol() {
        return this.proxiedProtocol;
    }

    public String sourceAddress() {
        return this.sourceAddress;
    }

    public int sourcePort() {
        return this.sourcePort;
    }

    public List<HAProxyTLV> tlvs() {
        return this.tlvs;
    }

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, int i6, int i7) {
        this(hAProxyProtocolVersion, hAProxyCommand, hAProxyProxiedProtocol, str, str2, i6, i7, Collections.EMPTY_LIST);
    }

    private static HAProxyTLV readNextTLV(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 4) {
            return null;
        }
        byte readByte = byteBuf.readByte();
        HAProxyTLV.Type typeForByteValue = HAProxyTLV.Type.typeForByteValue(readByte);
        int readUnsignedShort = byteBuf.readUnsignedShort();
        switch (AnonymousClass1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[typeForByteValue.ordinal()]) {
            case 1:
                ByteBuf retainedSlice = byteBuf.retainedSlice(byteBuf.readerIndex(), readUnsignedShort);
                ByteBuf readSlice = byteBuf.readSlice(readUnsignedShort);
                byte readByte2 = readSlice.readByte();
                int readInt = readSlice.readInt();
                if (readSlice.readableBytes() < 4) {
                    break;
                } else {
                    ArrayList arrayList = new ArrayList(4);
                    do {
                        HAProxyTLV readNextTLV = readNextTLV(readSlice);
                        if (readNextTLV != null) {
                            arrayList.add(readNextTLV);
                        }
                        break;
                    } while (readSlice.readableBytes() >= 4);
                }
        }
        return null;
    }

    private static List<HAProxyTLV> readTlvs(ByteBuf byteBuf) {
        HAProxyTLV readNextTLV = readNextTLV(byteBuf);
        if (readNextTLV == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(4);
        do {
            arrayList.add(readNextTLV);
            if (readNextTLV instanceof HAProxySSLTLV) {
                arrayList.addAll(((HAProxySSLTLV) readNextTLV).encapsulatedTLVs());
            }
            readNextTLV = readNextTLV(byteBuf);
        } while (readNextTLV != null);
        return arrayList;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public boolean release(int i6) {
        tryRecord();
        return super.release(i6);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HAProxyMessage retain() {
        tryRecord();
        return (HAProxyMessage) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HAProxyMessage touch() {
        tryRecord();
        return (HAProxyMessage) super.touch();
    }

    private HAProxyMessage(HAProxyProtocolVersion hAProxyProtocolVersion, HAProxyCommand hAProxyCommand, HAProxyProxiedProtocol hAProxyProxiedProtocol, String str, String str2, int i6, int i7, List<HAProxyTLV> list) {
        if (hAProxyProxiedProtocol != null) {
            HAProxyProxiedProtocol.AddressFamily addressFamily = hAProxyProxiedProtocol.addressFamily();
            checkAddress(str, addressFamily);
            checkAddress(str2, addressFamily);
            checkPort(i6);
            checkPort(i7);
            this.protocolVersion = hAProxyProtocolVersion;
            this.command = hAProxyCommand;
            this.proxiedProtocol = hAProxyProxiedProtocol;
            this.sourceAddress = str;
            this.destinationAddress = str2;
            this.sourcePort = i6;
            this.destinationPort = i7;
            this.tlvs = Collections.unmodifiableList(list);
            this.leak = leakDetector.track(this);
            return;
        }
        throw new NullPointerException("proxiedProtocol");
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HAProxyMessage retain(int i6) {
        tryRecord();
        return (HAProxyMessage) super.retain(i6);
    }

    @Override // io.netty.util.ReferenceCounted
    public HAProxyMessage touch(Object obj) {
        ResourceLeakTracker<HAProxyMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }

    static HAProxyMessage decodeHeader(String str) {
        if (str != null) {
            String[] split = str.split(" ");
            int length = split.length;
            if (length >= 2) {
                if ("PROXY".equals(split[0])) {
                    try {
                        HAProxyProxiedProtocol valueOf = HAProxyProxiedProtocol.valueOf(split[1]);
                        if (valueOf != HAProxyProxiedProtocol.TCP4 && valueOf != HAProxyProxiedProtocol.TCP6 && valueOf != HAProxyProxiedProtocol.UNKNOWN) {
                            throw new HAProxyProtocolException("unsupported v1 proxied protocol: " + split[1]);
                        }
                        if (valueOf == HAProxyProxiedProtocol.UNKNOWN) {
                            return unknownMsg(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY);
                        }
                        if (length == 6) {
                            return new HAProxyMessage(HAProxyProtocolVersion.V1, HAProxyCommand.PROXY, valueOf, split[2], split[3], split[4], split[5]);
                        }
                        throw new HAProxyProtocolException("invalid TCP4/6 header: " + str + " (expected: 6 parts)");
                    } catch (IllegalArgumentException e6) {
                        throw new HAProxyProtocolException(e6);
                    }
                }
                throw new HAProxyProtocolException("unknown identifier: " + split[0]);
            }
            throw new HAProxyProtocolException("invalid header: " + str + " (expected: 'PROXY' and proxied protocol values)");
        }
        throw new HAProxyProtocolException("header");
    }
}
