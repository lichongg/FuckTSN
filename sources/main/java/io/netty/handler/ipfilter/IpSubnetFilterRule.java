package io.netty.handler.ipfilter;

import io.netty.util.internal.SocketUtils;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class IpSubnetFilterRule implements IpFilterRule {
    private final IpFilterRule filterRule;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.ipfilter.IpSubnetFilterRule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Ip4SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int networkAddress;
        private final IpFilterRuleType ruleType;
        private final int subnetMask;

        /* synthetic */ Ip4SubnetFilterRule(Inet4Address inet4Address, int i6, IpFilterRuleType ipFilterRuleType, AnonymousClass1 anonymousClass1) {
            this(inet4Address, i6, ipFilterRuleType);
        }

        private Ip4SubnetFilterRule(Inet4Address inet4Address, int i6, IpFilterRuleType ipFilterRuleType) {
            if (i6 < 0 || i6 > 32) {
                throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", Integer.valueOf(i6)));
            }
            int prefixToSubnetMask = prefixToSubnetMask(i6);
            this.subnetMask = prefixToSubnetMask;
            this.networkAddress = ipToInt(inet4Address) & prefixToSubnetMask;
            this.ruleType = ipFilterRuleType;
        }

        private static int prefixToSubnetMask(int i6) {
            return (int) ((-1) << (32 - i6));
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private static int ipToInt(Inet4Address inet4Address) {
            byte[] address = inet4Address.getAddress();
            return (address[3] & 255) | ((address[0] & 255) << 24) | ((address[1] & 255) << 16) | ((address[2] & 255) << 8);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            if (!(address instanceof Inet4Address) || (ipToInt((Inet4Address) address) & this.subnetMask) != this.networkAddress) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Ip6SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
        private final BigInteger networkAddress;
        private final IpFilterRuleType ruleType;
        private final BigInteger subnetMask;

        /* synthetic */ Ip6SubnetFilterRule(Inet6Address inet6Address, int i6, IpFilterRuleType ipFilterRuleType, AnonymousClass1 anonymousClass1) {
            this(inet6Address, i6, ipFilterRuleType);
        }

        private Ip6SubnetFilterRule(Inet6Address inet6Address, int i6, IpFilterRuleType ipFilterRuleType) {
            if (i6 < 0 || i6 > 128) {
                throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", Integer.valueOf(i6)));
            }
            BigInteger prefixToSubnetMask = prefixToSubnetMask(i6);
            this.subnetMask = prefixToSubnetMask;
            this.networkAddress = ipToInt(inet6Address).and(prefixToSubnetMask);
            this.ruleType = ipFilterRuleType;
        }

        private static BigInteger prefixToSubnetMask(int i6) {
            return MINUS_ONE.shiftLeft(128 - i6);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private static BigInteger ipToInt(Inet6Address inet6Address) {
            return new BigInteger(inet6Address.getAddress());
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet6Address) {
                return ipToInt((Inet6Address) address).and(this.subnetMask).equals(this.networkAddress);
            }
            return false;
        }
    }

    public IpSubnetFilterRule(String str, int i6, IpFilterRuleType ipFilterRuleType) {
        try {
            this.filterRule = selectFilterRule(SocketUtils.addressByName(str), i6, ipFilterRuleType);
        } catch (UnknownHostException e6) {
            throw new IllegalArgumentException("ipAddress", e6);
        }
    }

    private static IpFilterRule selectFilterRule(InetAddress inetAddress, int i6, IpFilterRuleType ipFilterRuleType) {
        if (inetAddress == null) {
            throw new NullPointerException("ipAddress");
        }
        if (ipFilterRuleType == null) {
            throw new NullPointerException("ruleType");
        }
        AnonymousClass1 anonymousClass1 = null;
        if (inetAddress instanceof Inet4Address) {
            return new Ip4SubnetFilterRule((Inet4Address) inetAddress, i6, ipFilterRuleType, anonymousClass1);
        }
        if (inetAddress instanceof Inet6Address) {
            return new Ip6SubnetFilterRule((Inet6Address) inetAddress, i6, ipFilterRuleType, anonymousClass1);
        }
        throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public boolean matches(InetSocketAddress inetSocketAddress) {
        return this.filterRule.matches(inetSocketAddress);
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    public IpSubnetFilterRule(InetAddress inetAddress, int i6, IpFilterRuleType ipFilterRuleType) {
        this.filterRule = selectFilterRule(inetAddress, i6, ipFilterRuleType);
    }
}
