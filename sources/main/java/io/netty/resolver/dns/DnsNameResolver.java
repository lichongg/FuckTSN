package io.netty.resolver.dns;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.TcpDnsQueryEncoder;
import io.netty.handler.codec.dns.TcpDnsResponseDecoder;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DnsNameResolver extends InetNameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final DatagramDnsResponseDecoder DATAGRAM_DECODER;
    private static final DatagramDnsQueryEncoder DATAGRAM_ENCODER;
    private static final int DEFAULT_NDOTS;
    static final ResolvedAddressTypes DEFAULT_RESOLVE_ADDRESS_TYPES;
    static final String[] DEFAULT_SEARCH_DOMAINS;
    private static final InternetProtocolFamily[] IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final String LOCALHOST = "localhost";
    private static final InetAddress LOCALHOST_ADDRESS;
    private static final TcpDnsQueryEncoder TCP_ENCODER;
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    final Channel ch;
    final Future<Channel> channelFuture;
    private final DnsCnameCache cnameCache;
    private final boolean completeOncePreferredResolved;
    private final boolean decodeIdn;
    private final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory;
    private final DnsServerAddressStreamProvider dnsServerAddressStreamProvider;
    private final HostsFileEntriesResolver hostsFileEntriesResolver;
    private final int maxPayloadSize;
    private final int maxQueriesPerResolve;
    private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream;
    private final Comparator<InetSocketAddress> nameServerComparator;
    private final int ndots;
    private final boolean optResourceEnabled;
    private final InternetProtocolFamily preferredAddressType;
    final DnsQueryContextManager queryContextManager;
    private final long queryTimeoutMillis;
    private final boolean recursionDesired;
    private final DnsCache resolveCache;
    private final DnsRecordType[] resolveRecordTypes;
    private final ResolvedAddressTypes resolvedAddressTypes;
    private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
    private final String[] searchDomains;
    private final ChannelFactory<? extends SocketChannel> socketChannelFactory;
    private final boolean supportsAAAARecords;
    private final boolean supportsARecords;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DnsNameResolver.class);
    private static final DnsRecord[] EMPTY_ADDITIONALS = new DnsRecord[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class AddressedEnvelopeAdapter implements AddressedEnvelope<DnsResponse, InetSocketAddress> {
        private final InetSocketAddress recipient;
        private final DnsResponse response;
        private final InetSocketAddress sender;

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.response.release();
        }

        AddressedEnvelopeAdapter(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, DnsResponse dnsResponse) {
            this.sender = inetSocketAddress;
            this.recipient = inetSocketAddress2;
            this.response = dnsResponse;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public DnsResponse content() {
            return this.response;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddressedEnvelope)) {
                return false;
            }
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if (sender() == null) {
                if (addressedEnvelope.sender() != null) {
                    return false;
                }
            } else if (!sender().equals(addressedEnvelope.sender())) {
                return false;
            }
            if (recipient() == null) {
                if (addressedEnvelope.recipient() != null) {
                    return false;
                }
            } else if (!recipient().equals(addressedEnvelope.recipient())) {
                return false;
            }
            return this.response.equals(obj);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode();
            if (sender() != null) {
                hashCode = (hashCode * 31) + sender().hashCode();
            }
            return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public InetSocketAddress recipient() {
            return this.recipient;
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.response.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i6) {
            return this.response.release(i6);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public InetSocketAddress sender() {
            return this.sender;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain() {
            this.response.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch() {
            this.response.touch();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain(int i6) {
            this.response.retain(i6);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch(Object obj) {
            this.response.touch(obj);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class DnsResponseHandler extends ChannelInboundHandlerAdapter {
        private final Promise<Channel> channelActivePromise;

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            try {
                final DatagramDnsResponse datagramDnsResponse = (DatagramDnsResponse) obj;
                final int id = datagramDnsResponse.id();
                if (DnsNameResolver.logger.isDebugEnabled()) {
                    DnsNameResolver.logger.debug("{} RECEIVED: UDP [{}: {}], {}", DnsNameResolver.this.ch, Integer.valueOf(id), datagramDnsResponse.sender(), datagramDnsResponse);
                }
                final DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id);
                if (dnsQueryContext == null) {
                    DnsNameResolver.logger.warn("{} Received a DNS response with an unknown ID: {}", DnsNameResolver.this.ch, Integer.valueOf(id));
                    ReferenceCountUtil.safeRelease(obj);
                    return;
                }
                if (!datagramDnsResponse.isTruncated() || DnsNameResolver.this.socketChannelFactory == null) {
                    dnsQueryContext.finish(datagramDnsResponse);
                } else {
                    datagramDnsResponse.retain();
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.option(ChannelOption.SO_REUSEADDR, Boolean.TRUE).group(DnsNameResolver.this.executor()).channelFactory(DnsNameResolver.this.socketChannelFactory).handler(new ChannelInitializer<Channel>() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1
                        @Override // io.netty.channel.ChannelInitializer
                        protected void initChannel(Channel channel) {
                            channel.pipeline().addLast(DnsNameResolver.TCP_ENCODER);
                            channel.pipeline().addLast(new TcpDnsResponseDecoder());
                            channel.pipeline().addLast(new ChannelInboundHandlerAdapter() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1.1
                                private boolean finish;

                                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
                                public void exceptionCaught(ChannelHandlerContext channelHandlerContext2, Throwable th) {
                                    if (this.finish) {
                                        return;
                                    }
                                    if (DnsNameResolver.logger.isDebugEnabled()) {
                                        DnsNameResolver.logger.debug("{} Error during processing response: TCP [{}: {}]", channelHandlerContext2.channel(), Integer.valueOf(id), channelHandlerContext2.channel().remoteAddress(), th);
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    dnsQueryContext.finish(datagramDnsResponse);
                                }

                                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                                public void channelRead(ChannelHandlerContext channelHandlerContext2, Object obj2) {
                                    try {
                                        Channel channel2 = channelHandlerContext2.channel();
                                        DnsResponse dnsResponse = (DnsResponse) obj2;
                                        int id2 = dnsResponse.id();
                                        if (DnsNameResolver.logger.isDebugEnabled()) {
                                            DnsNameResolver.logger.debug("{} RECEIVED: TCP [{}: {}], {}", channel2, Integer.valueOf(id2), channel2.remoteAddress(), dnsResponse);
                                        }
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        DnsQueryContext dnsQueryContext2 = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id2);
                                        if (dnsQueryContext2 == null) {
                                            DnsNameResolver.logger.warn("{} Received a DNS response with an unknown ID: {}", channel2, Integer.valueOf(id2));
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            dnsQueryContext.finish(datagramDnsResponse);
                                            ReferenceCountUtil.release(obj2);
                                            return;
                                        }
                                        datagramDnsResponse.release();
                                        dnsQueryContext2.finish(DnsNameResolver.this.new AddressedEnvelopeAdapter((InetSocketAddress) channelHandlerContext2.channel().remoteAddress(), (InetSocketAddress) channelHandlerContext2.channel().localAddress(), dnsResponse));
                                        this.finish = true;
                                        ReferenceCountUtil.release(obj2);
                                    } catch (Throwable th) {
                                        ReferenceCountUtil.release(obj2);
                                        throw th;
                                    }
                                }
                            });
                        }
                    });
                    bootstrap.connect(datagramDnsResponse.sender()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (!channelFuture.isSuccess()) {
                                if (DnsNameResolver.logger.isDebugEnabled()) {
                                    DnsNameResolver.logger.debug("{} Unable to fallback to TCP [{}]", Integer.valueOf(id), channelFuture.cause());
                                }
                                dnsQueryContext.finish(datagramDnsResponse);
                            } else {
                                final Channel channel = channelFuture.channel();
                                Promise newPromise = channel.eventLoop().newPromise();
                                new TcpDnsQueryContext(DnsNameResolver.this, channel, (InetSocketAddress) channel.remoteAddress(), dnsQueryContext.question(), DnsNameResolver.EMPTY_ADDITIONALS, newPromise).query(true, channelFuture.channel().newPromise());
                                newPromise.addListener((GenericFutureListener) new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.2.1
                                    @Override // io.netty.util.concurrent.GenericFutureListener
                                    public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                                        channel.close();
                                        if (future.isSuccess()) {
                                            dnsQueryContext.finish(future.getNow());
                                        } else {
                                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                            dnsQueryContext.finish(datagramDnsResponse);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                ReferenceCountUtil.safeRelease(obj);
            } catch (Throwable th) {
                ReferenceCountUtil.safeRelease(obj);
                throw th;
            }
        }

        DnsResponseHandler(Promise<Channel> promise) {
            this.channelActivePromise = promise;
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelActive(channelHandlerContext);
            this.channelActivePromise.setSuccess(channelHandlerContext.channel());
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            DnsNameResolver.logger.warn("{} Unexpected exception: ", channelHandlerContext.channel(), th);
        }
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, DnsCache dnsCache2, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j6, ResolvedAddressTypes resolvedAddressTypes, boolean z5, int i6, boolean z6, int i7, boolean z7, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i8, boolean z8) {
        this(eventLoop, channelFactory, dnsCache, new AuthoritativeDnsServerCacheAdapter(dnsCache2), dnsQueryLifecycleObserverFactory, j6, resolvedAddressTypes, z5, i6, z6, i7, z7, hostsFileEntriesResolver, dnsServerAddressStreamProvider, strArr, i8, z8);
    }

    static InternetProtocolFamily preferredAddressType(ResolvedAddressTypes resolvedAddressTypes) {
        int i6 = AnonymousClass6.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes.ordinal()];
        if (i6 == 1 || i6 == 2) {
            return InternetProtocolFamily.IPv4;
        }
        if (i6 == 3 || i6 == 4) {
            return InternetProtocolFamily.IPv6;
        }
        throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<InetAddress> promise) throws Exception {
        doResolve(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<InetAddress>> promise) throws Exception {
        doResolveAll(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion) {
        return query(nextNameServerAddress(), dnsQuestion);
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable) {
        return resolve(str, iterable, executor().newPromise());
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable) {
        return resolveAll(str, iterable, executor().newPromise());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.resolver.dns.DnsNameResolver$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] iArr = new int[ResolvedAddressTypes.values().length];
            $SwitchMap$io$netty$resolver$ResolvedAddressTypes = iArr;
            try {
                iArr[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        String[] strArr;
        DnsRecordType dnsRecordType = DnsRecordType.A;
        int i6 = 1;
        IPV4_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType};
        InternetProtocolFamily internetProtocolFamily = InternetProtocolFamily.IPv4;
        IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily};
        DnsRecordType dnsRecordType2 = DnsRecordType.AAAA;
        IPV4_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType, dnsRecordType2};
        InternetProtocolFamily internetProtocolFamily2 = InternetProtocolFamily.IPv6;
        IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily, internetProtocolFamily2};
        IPV6_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2};
        IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2};
        IPV6_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2, dnsRecordType};
        IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2, internetProtocolFamily};
        if (NetUtil.isIpV4StackPreferred() || !anyInterfaceSupportsIpV6()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_ONLY;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        } else if (NetUtil.isIpV6AddressesPreferred()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV6_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
        } else {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        }
        try {
            strArr = (String[]) (PlatformDependent.isWindows() ? getSearchDomainsHack() : UnixResolverDnsServerAddressStreamProvider.parseEtcResolverSearchDomains()).toArray(new String[0]);
        } catch (Exception unused) {
            strArr = EmptyArrays.EMPTY_STRINGS;
        }
        DEFAULT_SEARCH_DOMAINS = strArr;
        try {
            i6 = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverFirstNdots();
        } catch (Exception unused2) {
        }
        DEFAULT_NDOTS = i6;
        DATAGRAM_DECODER = new DatagramDnsResponseDecoder();
        DATAGRAM_ENCODER = new DatagramDnsQueryEncoder();
        TCP_ENCODER = new TcpDnsQueryEncoder();
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j6, ResolvedAddressTypes resolvedAddressTypes, boolean z5, int i6, boolean z6, int i7, boolean z7, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i8, boolean z8) {
        this(eventLoop, channelFactory, null, dnsCache, NoopDnsCnameCache.INSTANCE, authoritativeDnsServerCache, dnsQueryLifecycleObserverFactory, j6, resolvedAddressTypes, z5, i6, z6, i7, z7, hostsFileEntriesResolver, dnsServerAddressStreamProvider, strArr, i8, z8, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllUncached0(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache, boolean z5) {
        new DnsAddressResolveContext(this, str, dnsRecordArr, this.dnsServerAddressStreamProvider.nameServerAddressStream(str), dnsCache, this.authoritativeDnsServerCache, z5).resolve(promise);
    }

    private static List<String> getSearchDomainsHack() throws Exception {
        Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
        return (List) cls.getMethod("searchlist", null).invoke(cls.getMethod("open", null).invoke(null, null), null);
    }

    public static boolean isTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverTimeoutException);
    }

    public static boolean isTransportOrTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverException);
    }

    private InetSocketAddress nextNameServerAddress() {
        return this.nameServerAddrStream.get().next();
    }

    private InetAddress resolveHostsFileEntry(String str) {
        HostsFileEntriesResolver hostsFileEntriesResolver = this.hostsFileEntriesResolver;
        if (hostsFileEntriesResolver == null) {
            return null;
        }
        InetAddress address = hostsFileEntriesResolver.address(str, this.resolvedAddressTypes);
        return (address == null && PlatformDependent.isWindows() && LOCALHOST.equalsIgnoreCase(str)) ? LOCALHOST_ADDRESS : address;
    }

    private static DnsRecord[] toArray(Iterable<DnsRecord> iterable, boolean z5) {
        ObjectUtil.checkNotNull(iterable, "additionals");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            Iterator<DnsRecord> it = iterable.iterator();
            while (it.hasNext()) {
                validateAdditional(it.next(), z5);
            }
            return (DnsRecord[]) collection.toArray(new DnsRecord[collection.size()]);
        }
        Iterator<DnsRecord> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return EMPTY_ADDITIONALS;
        }
        ArrayList arrayList = new ArrayList();
        do {
            DnsRecord next = it2.next();
            validateAdditional(next, z5);
            arrayList.add(next);
        } while (it2.hasNext());
        return (DnsRecord[]) arrayList.toArray(new DnsRecord[arrayList.size()]);
    }

    private static void validateAdditional(DnsRecord dnsRecord, boolean z5) {
        ObjectUtil.checkNotNull(dnsRecord, "record");
        if (z5 && (dnsRecord instanceof DnsRawRecord)) {
            throw new IllegalArgumentException("DnsRawRecord implementations not allowed: " + dnsRecord);
        }
    }

    public AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    @Override // io.netty.resolver.SimpleNameResolver, io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.ch.isOpen()) {
            this.ch.close();
        }
    }

    DnsCnameCache cnameCache() {
        return this.cnameCache;
    }

    final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory() {
        return this.dnsQueryLifecycleObserverFactory;
    }

    protected void doResolve(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(loopbackAddress());
            return;
        }
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(InetAddress.getByAddress(createByteArrayFromIpAddressString));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(resolveHostsFileEntry);
        } else {
            if (doResolveCached(hostname, dnsRecordArr, promise, dnsCache)) {
                return;
            }
            doResolveUncached(hostname, dnsRecordArr, promise, dnsCache, true);
        }
    }

    protected void doResolveAll(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(Collections.singletonList(loopbackAddress()));
            return;
        }
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(Collections.singletonList(InetAddress.getByAddress(createByteArrayFromIpAddressString)));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(Collections.singletonList(resolveHostsFileEntry));
        } else {
            if (doResolveAllCached(hostname, dnsRecordArr, promise, dnsCache, this.resolvedInternetProtocolFamilies)) {
                return;
            }
            doResolveAllUncached(hostname, dnsRecordArr, promise, dnsCache, this.completeOncePreferredResolved);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.SimpleNameResolver
    public EventLoop executor() {
        return (EventLoop) super.executor();
    }

    final void flushQueries() {
        this.ch.flush();
    }

    public HostsFileEntriesResolver hostsFileEntriesResolver() {
        return this.hostsFileEntriesResolver;
    }

    final boolean isDecodeIdn() {
        return this.decodeIdn;
    }

    public boolean isOptResourceEnabled() {
        return this.optResourceEnabled;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    public int maxPayloadSize() {
        return this.maxPayloadSize;
    }

    public int maxQueriesPerResolve() {
        return this.maxQueriesPerResolve;
    }

    final int ndots() {
        return this.ndots;
    }

    final DnsServerAddressStream newNameServerAddressStream(String str) {
        return this.dnsServerAddressStreamProvider.nameServerAddressStream(str);
    }

    InetSocketAddress newRedirectServerAddress(InetAddress inetAddress) {
        return new InetSocketAddress(inetAddress, 53);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query(nextNameServerAddress(), dnsQuestion, iterable);
    }

    final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, boolean z5, ChannelPromise channelPromise, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast = cast((Promise) ObjectUtil.checkNotNull(promise, "promise"));
        try {
            new DatagramDnsQueryContext(this, inetSocketAddress, dnsQuestion, dnsRecordArr, cast).query(z5, channelPromise);
            return cast;
        } catch (Exception e6) {
            return cast.setFailure(e6);
        }
    }

    public long queryTimeoutMillis() {
        return this.queryTimeoutMillis;
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable, Promise<InetAddress> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e6) {
            return promise.setFailure(e6);
        }
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable, Promise<List<InetAddress>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e6) {
            return promise.setFailure(e6);
        }
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    final DnsRecordType[] resolveRecordTypes() {
        return this.resolveRecordTypes;
    }

    public ResolvedAddressTypes resolvedAddressTypes() {
        return this.resolvedAddressTypes;
    }

    InternetProtocolFamily[] resolvedInternetProtocolFamiliesUnsafe() {
        return this.resolvedInternetProtocolFamilies;
    }

    final String[] searchDomains() {
        return this.searchDomains;
    }

    final boolean supportsAAAARecords() {
        return this.supportsAAAARecords;
    }

    final boolean supportsARecords() {
        return this.supportsARecords;
    }

    DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, ChannelFactory<? extends SocketChannel> channelFactory2, final DnsCache dnsCache, final DnsCnameCache dnsCnameCache, final AuthoritativeDnsServerCache authoritativeDnsServerCache, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j6, ResolvedAddressTypes resolvedAddressTypes, boolean z5, int i6, boolean z6, int i7, boolean z7, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i8, boolean z8, boolean z9) {
        super(eventLoop);
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2;
        this.queryContextManager = new DnsQueryContextManager();
        this.nameServerAddrStream = new FastThreadLocal<DnsServerAddressStream>() { // from class: io.netty.resolver.dns.DnsNameResolver.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DnsServerAddressStream initialValue() {
                return DnsNameResolver.this.dnsServerAddressStreamProvider.nameServerAddressStream("");
            }
        };
        this.queryTimeoutMillis = ObjectUtil.checkPositive(j6, "queryTimeoutMillis");
        ResolvedAddressTypes resolvedAddressTypes2 = resolvedAddressTypes != null ? resolvedAddressTypes : DEFAULT_RESOLVE_ADDRESS_TYPES;
        this.resolvedAddressTypes = resolvedAddressTypes2;
        this.recursionDesired = z5;
        this.maxQueriesPerResolve = ObjectUtil.checkPositive(i6, "maxQueriesPerResolve");
        this.maxPayloadSize = ObjectUtil.checkPositive(i7, "maxPayloadSize");
        this.optResourceEnabled = z7;
        this.hostsFileEntriesResolver = (HostsFileEntriesResolver) ObjectUtil.checkNotNull(hostsFileEntriesResolver, "hostsFileEntriesResolver");
        this.dnsServerAddressStreamProvider = (DnsServerAddressStreamProvider) ObjectUtil.checkNotNull(dnsServerAddressStreamProvider, "dnsServerAddressStreamProvider");
        this.resolveCache = (DnsCache) ObjectUtil.checkNotNull(dnsCache, "resolveCache");
        this.cnameCache = (DnsCnameCache) ObjectUtil.checkNotNull(dnsCnameCache, "cnameCache");
        if (z6) {
            dnsQueryLifecycleObserverFactory2 = dnsQueryLifecycleObserverFactory instanceof NoopDnsQueryLifecycleObserverFactory ? new TraceDnsQueryLifeCycleObserverFactory() : new BiDnsQueryLifecycleObserverFactory(new TraceDnsQueryLifeCycleObserverFactory(), dnsQueryLifecycleObserverFactory);
        } else {
            dnsQueryLifecycleObserverFactory2 = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "dnsQueryLifecycleObserverFactory");
        }
        this.dnsQueryLifecycleObserverFactory = dnsQueryLifecycleObserverFactory2;
        this.searchDomains = strArr != null ? (String[]) strArr.clone() : DEFAULT_SEARCH_DOMAINS;
        this.ndots = i8 >= 0 ? i8 : DEFAULT_NDOTS;
        this.decodeIdn = z8;
        this.completeOncePreferredResolved = z9;
        this.socketChannelFactory = channelFactory2;
        int i9 = AnonymousClass6.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes2.ordinal()];
        if (i9 == 1) {
            this.supportsAAAARecords = false;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i9 == 2) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i9 == 3) {
            this.supportsAAAARecords = true;
            this.supportsARecords = false;
            this.resolveRecordTypes = IPV6_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i9 == 4) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
        InternetProtocolFamily preferredAddressType = preferredAddressType(resolvedAddressTypes2);
        this.preferredAddressType = preferredAddressType;
        this.authoritativeDnsServerCache = (AuthoritativeDnsServerCache) ObjectUtil.checkNotNull(authoritativeDnsServerCache, "authoritativeDnsServerCache");
        this.nameServerComparator = new NameServerComparator(preferredAddressType.addressType());
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(executor());
        bootstrap.channelFactory((ChannelFactory) channelFactory);
        bootstrap.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, Boolean.TRUE);
        final DnsResponseHandler dnsResponseHandler = new DnsResponseHandler(executor().newPromise());
        bootstrap.handler(new ChannelInitializer<DatagramChannel>() { // from class: io.netty.resolver.dns.DnsNameResolver.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(DatagramChannel datagramChannel) {
                datagramChannel.pipeline().addLast(DnsNameResolver.DATAGRAM_ENCODER, DnsNameResolver.DATAGRAM_DECODER, dnsResponseHandler);
            }
        });
        this.channelFuture = dnsResponseHandler.channelActivePromise;
        ChannelFuture register = bootstrap.register();
        Throwable cause = register.cause();
        if (cause != null) {
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new IllegalStateException("Unable to create / register Channel", cause);
            }
            throw ((RuntimeException) cause);
        }
        Channel channel = register.channel();
        this.ch = channel;
        channel.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(i7));
        channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                dnsCache.clear();
                dnsCnameCache.clear();
                authoritativeDnsServerCache.clear();
            }
        });
    }

    private static boolean anyInterfaceSupportsIpV6() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (inetAddresses.nextElement() instanceof Inet6Address) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SocketException e6) {
            logger.debug("Unable to detect if any interface supports IPv6, assuming IPv4-only", (Throwable) e6);
            return false;
        }
    }

    static boolean doResolveAllCached(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache, InternetProtocolFamily[] internetProtocolFamilyArr) {
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = list.get(0).cause();
        if (cause == null) {
            int size = list.size();
            ArrayList arrayList = null;
            for (InternetProtocolFamily internetProtocolFamily : internetProtocolFamilyArr) {
                for (int i6 = 0; i6 < size; i6++) {
                    DnsCacheEntry dnsCacheEntry = list.get(i6);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(size);
                        }
                        arrayList.add(dnsCacheEntry.address());
                    }
                }
            }
            if (arrayList == null) {
                return false;
            }
            trySuccess(promise, arrayList);
            return true;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveAllUncached(final String str, final DnsRecord[] dnsRecordArr, final Promise<List<InetAddress>> promise, final DnsCache dnsCache, final boolean z5) {
        EventLoop executor = executor();
        if (executor.inEventLoop()) {
            doResolveAllUncached0(str, dnsRecordArr, promise, dnsCache, z5);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.resolver.dns.DnsNameResolver.5
                @Override // java.lang.Runnable
                public void run() {
                    DnsNameResolver.this.doResolveAllUncached0(str, dnsRecordArr, promise, dnsCache, z5);
                }
            });
        }
    }

    private boolean doResolveCached(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) {
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = list.get(0).cause();
        if (cause == null) {
            int size = list.size();
            for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                for (int i6 = 0; i6 < size; i6++) {
                    DnsCacheEntry dnsCacheEntry = list.get(i6);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        trySuccess(promise, dnsCacheEntry.address());
                        return true;
                    }
                }
            }
            return false;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveUncached(String str, DnsRecord[] dnsRecordArr, final Promise<InetAddress> promise, DnsCache dnsCache, boolean z5) {
        Promise<List<InetAddress>> newPromise = executor().newPromise();
        doResolveAllUncached(str, dnsRecordArr, newPromise, dnsCache, true);
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<InetAddress>>>) new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolver.4
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (!future.isSuccess()) {
                    DnsNameResolver.tryFailure(promise, future.cause());
                } else {
                    DnsNameResolver.trySuccess(promise, future.getNow().get(0));
                }
            }
        });
    }

    private static String hostname(String str) {
        String ascii = IDN.toASCII(str);
        if (StringUtil.endsWith(str, '.') && !StringUtil.endsWith(ascii, '.')) {
            return ascii + ".";
        }
        return ascii;
    }

    private InetAddress loopbackAddress() {
        return preferredAddressType().localhost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tryFailure(Promise<?> promise, Throwable th) {
        if (!promise.tryFailure(th)) {
            logger.trace("Failed to notify failure to a promise: {}", promise, th);
        }
    }

    static <T> void trySuccess(Promise<T> promise, T t5) {
        if (!promise.trySuccess(t5)) {
            logger.trace("Failed to notify success ({}) to a promise: {}", t5, promise);
        }
    }

    protected DnsServerAddressStream newRedirectDnsServerStream(String str, List<InetSocketAddress> list) {
        DnsServerAddressStream dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        if (dnsServerAddressStream != null && dnsServerAddressStream.size() != 0) {
            return dnsServerAddressStream;
        }
        Collections.sort(list, this.nameServerComparator);
        return new SequentialDnsServerAddressStream(list, 0);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query(nextNameServerAddress(), dnsQuestion, Collections.EMPTY_LIST, promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    final InternetProtocolFamily preferredAddressType() {
        return this.preferredAddressType;
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion) {
        return resolveAll(dnsQuestion, EMPTY_ADDITIONALS, executor().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return resolveAll(dnsQuestion, iterable, executor().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<List<DnsRecord>> promise) {
        return resolveAll(dnsQuestion, toArray(iterable, true), promise);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.util.concurrent.Future<java.util.List<io.netty.handler.codec.dns.DnsRecord>> resolveAll(io.netty.handler.codec.dns.DnsQuestion r8, io.netty.handler.codec.dns.DnsRecord[] r9, io.netty.util.concurrent.Promise<java.util.List<io.netty.handler.codec.dns.DnsRecord>> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "question"
            io.netty.util.internal.ObjectUtil.checkNotNull(r8, r0)
            java.lang.String r0 = "promise"
            io.netty.util.internal.ObjectUtil.checkNotNull(r10, r0)
            io.netty.handler.codec.dns.DnsRecordType r3 = r8.type()
            java.lang.String r2 = r8.name()
            io.netty.handler.codec.dns.DnsRecordType r0 = io.netty.handler.codec.dns.DnsRecordType.A
            if (r3 == r0) goto L1a
            io.netty.handler.codec.dns.DnsRecordType r1 = io.netty.handler.codec.dns.DnsRecordType.AAAA
            if (r3 != r1) goto L55
        L1a:
            java.net.InetAddress r1 = r7.resolveHostsFileEntry(r2)
            if (r1 == 0) goto L55
            boolean r4 = r1 instanceof java.net.Inet4Address
            if (r4 == 0) goto L30
            if (r3 != r0) goto L41
            byte[] r0 = r1.getAddress()
            io.netty.buffer.ByteBuf r0 = io.netty.buffer.Unpooled.wrappedBuffer(r0)
        L2e:
            r6 = r0
            goto L43
        L30:
            boolean r0 = r1 instanceof java.net.Inet6Address
            if (r0 == 0) goto L41
            io.netty.handler.codec.dns.DnsRecordType r0 = io.netty.handler.codec.dns.DnsRecordType.AAAA
            if (r3 != r0) goto L41
            byte[] r0 = r1.getAddress()
            io.netty.buffer.ByteBuf r0 = io.netty.buffer.Unpooled.wrappedBuffer(r0)
            goto L2e
        L41:
            r0 = 0
            goto L2e
        L43:
            if (r6 == 0) goto L55
            io.netty.handler.codec.dns.DefaultDnsRawRecord r1 = new io.netty.handler.codec.dns.DefaultDnsRawRecord
            r4 = 86400(0x15180, double:4.26873E-319)
            r1.<init>(r2, r3, r4, r6)
            java.util.List r8 = java.util.Collections.singletonList(r1)
            trySuccess(r10, r8)
            return r10
        L55:
            io.netty.resolver.dns.DnsServerAddressStreamProvider r0 = r7.dnsServerAddressStreamProvider
            io.netty.resolver.dns.DnsServerAddressStream r0 = r0.nameServerAddressStream(r2)
            io.netty.resolver.dns.DnsRecordResolveContext r1 = new io.netty.resolver.dns.DnsRecordResolveContext
            r1.<init>(r7, r8, r9, r0)
            r1.resolve(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsNameResolver.resolveAll(io.netty.handler.codec.dns.DnsQuestion, io.netty.handler.codec.dns.DnsRecord[], io.netty.util.concurrent.Promise):io.netty.util.concurrent.Future");
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), promise);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> promise) {
        return promise;
    }
}
