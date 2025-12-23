package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsRecordDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class DnsResolveContext<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final DnsRecord[] additionals;
    private int allowedQueries;
    private boolean completeEarly;
    private final int dnsClass;
    private final DnsRecordType[] expectedTypes;
    private List<T> finalResult;
    private final String hostname;
    private final int maxAllowedQueries;
    private final DnsServerAddressStream nameServerAddrs;
    final DnsNameResolver parent;
    private final Set<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
    private boolean triedCNAME;
    private static final RuntimeException NXDOMAIN_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No answer found and NXDOMAIN response code returned"), DnsResolveContext.class, "onResponse(..)");
    private static final RuntimeException CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching CNAME record found"), DnsResolveContext.class, "onResponseCNAME(..)");
    private static final RuntimeException NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching record type found"), DnsResolveContext.class, "onResponseAorAAAA(..)");
    private static final RuntimeException UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("Response type was unrecognized"), DnsResolveContext.class, "onResponse(..)");
    private static final RuntimeException NAME_SERVERS_EXHAUSTED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No name servers returned an answer"), DnsResolveContext.class, "tryToFinishResolve(..)");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AuthoritativeNameServer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private InetSocketAddress address;
        private final String domainName;
        private final int dots;
        final boolean isCopy = false;
        AuthoritativeNameServer next;
        final String nsName;
        private long ttl;

        AuthoritativeNameServer(int i6, long j6, String str, String str2) {
            this.dots = i6;
            this.ttl = j6;
            this.nsName = str2;
            this.domainName = str;
        }

        void update(InetSocketAddress inetSocketAddress, long j6) {
            this.address = inetSocketAddress;
            this.ttl = Math.min(this.ttl, j6);
        }

        boolean isRootServer() {
            return this.dots == 1;
        }

        void update(InetSocketAddress inetSocketAddress) {
            update(inetSocketAddress, Long.MAX_VALUE);
        }

        AuthoritativeNameServer(AuthoritativeNameServer authoritativeNameServer) {
            this.dots = authoritativeNameServer.dots;
            this.ttl = authoritativeNameServer.ttl;
            this.nsName = authoritativeNameServer.nsName;
            this.domainName = authoritativeNameServer.domainName;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AuthoritativeNameServerList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private AuthoritativeNameServer head;
        private int nameServerCount;
        private final String questionName;

        private static void cacheUnresolved(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            authoritativeNameServer.address = InetSocketAddress.createUnresolved(authoritativeNameServer.nsName, 53);
            cache(authoritativeNameServer, authoritativeDnsServerCache, eventLoop);
        }

        List<InetSocketAddress> addressList() {
            ArrayList arrayList = new ArrayList(this.nameServerCount);
            for (AuthoritativeNameServer authoritativeNameServer = this.head; authoritativeNameServer != null; authoritativeNameServer = authoritativeNameServer.next) {
                if (authoritativeNameServer.address != null) {
                    arrayList.add(authoritativeNameServer.address);
                }
            }
            return arrayList;
        }

        void handleWithAdditional(DnsNameResolver dnsNameResolver, DnsRecord dnsRecord, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            AuthoritativeNameServer authoritativeNameServer = this.head;
            String name = dnsRecord.name();
            InetAddress decodeAddress = DnsAddressDecoder.decodeAddress(dnsRecord, name, dnsNameResolver.isDecodeIdn());
            if (decodeAddress == null) {
                return;
            }
            while (authoritativeNameServer != null) {
                if (authoritativeNameServer.nsName.equalsIgnoreCase(name)) {
                    if (authoritativeNameServer.address != null) {
                        while (true) {
                            AuthoritativeNameServer authoritativeNameServer2 = authoritativeNameServer.next;
                            if (authoritativeNameServer2 == null || !authoritativeNameServer2.isCopy) {
                                break;
                            } else {
                                authoritativeNameServer = authoritativeNameServer2;
                            }
                        }
                        AuthoritativeNameServer authoritativeNameServer3 = new AuthoritativeNameServer(authoritativeNameServer);
                        authoritativeNameServer3.next = authoritativeNameServer.next;
                        authoritativeNameServer.next = authoritativeNameServer3;
                        this.nameServerCount++;
                        authoritativeNameServer = authoritativeNameServer3;
                    }
                    authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(decodeAddress), dnsRecord.timeToLive());
                    cache(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                    return;
                }
                authoritativeNameServer = authoritativeNameServer.next;
            }
        }

        void handleWithoutAdditionals(DnsNameResolver dnsNameResolver, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            InetAddress address;
            AuthoritativeNameServer authoritativeNameServer = this.head;
            while (authoritativeNameServer != null) {
                if (authoritativeNameServer.address == null) {
                    cacheUnresolved(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                    List<? extends DnsCacheEntry> list = dnsCache.get(authoritativeNameServer.nsName, null);
                    if (list != null && !list.isEmpty() && (address = list.get(0).address()) != null) {
                        authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(address));
                        int i6 = 1;
                        while (i6 < list.size()) {
                            InetAddress address2 = list.get(i6).address();
                            AuthoritativeNameServer authoritativeNameServer2 = new AuthoritativeNameServer(authoritativeNameServer);
                            authoritativeNameServer2.next = authoritativeNameServer.next;
                            authoritativeNameServer.next = authoritativeNameServer2;
                            authoritativeNameServer2.update(dnsNameResolver.newRedirectServerAddress(address2));
                            this.nameServerCount++;
                            i6++;
                            authoritativeNameServer = authoritativeNameServer2;
                        }
                    }
                }
                authoritativeNameServer = authoritativeNameServer.next;
            }
        }

        boolean isEmpty() {
            return this.nameServerCount == 0;
        }

        AuthoritativeNameServerList(String str) {
            this.questionName = str.toLowerCase(Locale.US);
        }

        private static void cache(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            if (!authoritativeNameServer.isRootServer()) {
                authoritativeDnsServerCache.cache(authoritativeNameServer.domainName, authoritativeNameServer.address, authoritativeNameServer.ttl, eventLoop);
            }
        }

        void add(DnsRecord dnsRecord) {
            String decodeDomainName;
            if (dnsRecord.type() == DnsRecordType.NS && (dnsRecord instanceof DnsRawRecord) && this.questionName.length() >= dnsRecord.name().length()) {
                String lowerCase = dnsRecord.name().toLowerCase(Locale.US);
                int length = lowerCase.length() - 1;
                int length2 = this.questionName.length() - 1;
                int i6 = 0;
                while (length >= 0) {
                    char charAt = lowerCase.charAt(length);
                    if (this.questionName.charAt(length2) == charAt) {
                        if (charAt == '.') {
                            i6++;
                        }
                        length--;
                        length2--;
                    } else {
                        return;
                    }
                }
                AuthoritativeNameServer authoritativeNameServer = this.head;
                if ((authoritativeNameServer == null || authoritativeNameServer.dots <= i6) && (decodeDomainName = DnsResolveContext.decodeDomainName(((ByteBufHolder) dnsRecord).content())) != null) {
                    AuthoritativeNameServer authoritativeNameServer2 = this.head;
                    if (authoritativeNameServer2 != null && authoritativeNameServer2.dots >= i6) {
                        if (this.head.dots == i6) {
                            AuthoritativeNameServer authoritativeNameServer3 = this.head;
                            while (true) {
                                AuthoritativeNameServer authoritativeNameServer4 = authoritativeNameServer3.next;
                                if (authoritativeNameServer4 != null) {
                                    authoritativeNameServer3 = authoritativeNameServer4;
                                } else {
                                    authoritativeNameServer3.next = new AuthoritativeNameServer(i6, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                                    this.nameServerCount++;
                                    return;
                                }
                            }
                        }
                    } else {
                        this.nameServerCount = 1;
                        this.head = new AuthoritativeNameServer(i6, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class CombinedDnsServerAddressStream implements DnsServerAddressStream {
        private final DnsServerAddressStream originalStream;
        private final InetSocketAddress replaced;
        private Iterator<InetAddress> resolved;
        private final List<InetAddress> resolvedAddresses;

        CombinedDnsServerAddressStream(InetSocketAddress inetSocketAddress, List<InetAddress> list, DnsServerAddressStream dnsServerAddressStream) {
            this.replaced = inetSocketAddress;
            this.resolvedAddresses = list;
            this.originalStream = dnsServerAddressStream;
            this.resolved = list.iterator();
        }

        private InetSocketAddress nextResolved0() {
            return DnsResolveContext.this.parent.newRedirectServerAddress(this.resolved.next());
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public DnsServerAddressStream duplicate() {
            return new CombinedDnsServerAddressStream(this.replaced, this.resolvedAddresses, this.originalStream.duplicate());
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            if (this.resolved.hasNext()) {
                return nextResolved0();
            }
            InetSocketAddress next = this.originalStream.next();
            if (!next.equals(this.replaced)) {
                return next;
            }
            this.resolved = this.resolvedAddresses.iterator();
            return nextResolved0();
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public int size() {
            return (this.originalStream.size() + this.resolvedAddresses.size()) - 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DnsAddressStreamList extends AbstractList<InetSocketAddress> {
        private List<InetSocketAddress> addresses;
        private final DnsServerAddressStream duplicate;

        @Override // java.util.AbstractList, java.util.List
        public InetSocketAddress get(int i6) {
            if (this.addresses == null) {
                DnsServerAddressStream duplicate = this.duplicate.duplicate();
                this.addresses = new ArrayList(size());
                for (int i7 = 0; i7 < duplicate.size(); i7++) {
                    this.addresses.add(duplicate.next());
                }
            }
            return this.addresses.get(i6);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<InetSocketAddress> iterator() {
            return new Iterator<InetSocketAddress>() { // from class: io.netty.resolver.dns.DnsResolveContext.DnsAddressStreamList.1

                /* renamed from: i, reason: collision with root package name */
                private int f43086i;
                private final DnsServerAddressStream stream;

                {
                    this.stream = DnsAddressStreamList.this.duplicate.duplicate();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f43086i < this.stream.size();
                }

                @Override // java.util.Iterator
                public InetSocketAddress next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f43086i++;
                    return this.stream.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.duplicate.size();
        }

        DnsAddressStreamList(DnsServerAddressStream dnsServerAddressStream) {
            this.duplicate = dnsServerAddressStream.duplicate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DnsResolveContextException extends RuntimeException {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private DnsResolveContextException(String str) {
            super(str);
        }

        @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
        private DnsResolveContextException(String str, boolean z5) {
            super(str, null, false, true);
        }

        static DnsResolveContextException newStatic(String str) {
            if (PlatformDependent.javaVersion() >= 7) {
                return new DnsResolveContextException(str, true);
            }
            return new DnsResolveContextException(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SearchDomainUnknownHostException extends UnknownHostException {
        private static final long serialVersionUID = -8573510133644997085L;

        SearchDomainUnknownHostException(Throwable th, String str) {
            super("Search domain query failed. Original hostname: '" + str + "' " + th.getMessage());
            setStackTrace(th.getStackTrace());
            initCause(th.getCause());
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    private void followCname(DnsQuestion dnsQuestion, String str, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        HashSet hashSet = null;
        while (true) {
            String str2 = cnameCache().get(hostnameWithDot(str));
            if (str2 == null) {
                break;
            }
            if (hashSet == null) {
                hashSet = new HashSet(2);
            }
            if (!hashSet.add(str)) {
                break;
            } else {
                str = str2;
            }
        }
        DnsServerAddressStream nameServers = getNameServers(str);
        try {
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(str, dnsQuestion.type(), this.dnsClass);
            query(nameServers, 0, defaultDnsQuestion, dnsQueryLifecycleObserver.queryCNAMEd(defaultDnsQuestion), true, promise, null);
        } catch (Throwable th) {
            dnsQueryLifecycleObserver.queryFailed(th);
            PlatformDependent.throwException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        r1.query(r2, r1.expectedTypes[r0], r9, false, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r1 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void internalResolve(java.lang.String r9, io.netty.util.concurrent.Promise<java.util.List<T>> r10) {
        /*
            r8 = this;
        L0:
            r2 = r9
            io.netty.resolver.dns.DnsCnameCache r9 = r8.cnameCache()
            java.lang.String r0 = hostnameWithDot(r2)
            java.lang.String r9 = r9.get(r0)
            if (r9 != 0) goto L4f
            io.netty.resolver.dns.DnsServerAddressStream r9 = r8.getNameServers(r2)     // Catch: java.lang.Throwable -> L3a
            io.netty.handler.codec.dns.DnsRecordType[] r0 = r8.expectedTypes     // Catch: java.lang.Throwable -> L3a
            int r0 = r0.length     // Catch: java.lang.Throwable -> L3a
            int r0 = r0 + (-1)
            r1 = 0
            r7 = 0
        L1a:
            if (r7 >= r0) goto L3d
            io.netty.handler.codec.dns.DnsRecordType[] r1 = r8.expectedTypes     // Catch: java.lang.Throwable -> L3a
            r3 = r1[r7]     // Catch: java.lang.Throwable -> L3a
            io.netty.resolver.dns.DnsServerAddressStream r4 = r9.duplicate()     // Catch: java.lang.Throwable -> L3a
            r5 = 0
            r1 = r8
            r6 = r10
            boolean r10 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L37
            if (r10 != 0) goto L33
        L2d:
            io.netty.resolver.dns.DnsNameResolver r9 = r1.parent
            r9.flushQueries()
            return
        L33:
            int r7 = r7 + 1
            r10 = r6
            goto L1a
        L37:
            r0 = move-exception
        L38:
            r9 = r0
            goto L49
        L3a:
            r0 = move-exception
            r1 = r8
            goto L38
        L3d:
            r1 = r8
            r6 = r10
            io.netty.handler.codec.dns.DnsRecordType[] r10 = r1.expectedTypes     // Catch: java.lang.Throwable -> L37
            r3 = r10[r0]     // Catch: java.lang.Throwable -> L37
            r5 = 0
            r4 = r9
            r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L37
            goto L2d
        L49:
            io.netty.resolver.dns.DnsNameResolver r10 = r1.parent
            r10.flushQueries()
            throw r9
        L4f:
            r1 = r8
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsResolveContext.internalResolve(java.lang.String, io.netty.util.concurrent.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponse(DnsServerAddressStream dnsServerAddressStream, int i6, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        try {
            DnsResponse content = addressedEnvelope.content();
            DnsResponseCode code = content.code();
            if (code != DnsResponseCode.NOERROR) {
                if (code != DnsResponseCode.NXDOMAIN) {
                    query(dnsServerAddressStream, i6 + 1, dnsQuestion, dnsQueryLifecycleObserver.queryNoAnswer(code), true, promise, null);
                } else {
                    dnsQueryLifecycleObserver.queryFailed(NXDOMAIN_QUERY_FAILED_EXCEPTION);
                    if (!content.isAuthoritativeAnswer()) {
                        query(dnsServerAddressStream, i6 + 1, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, null);
                    }
                }
                return;
            }
            if (handleRedirect(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise)) {
                return;
            }
            DnsRecordType type = dnsQuestion.type();
            if (type == DnsRecordType.CNAME) {
                onResponseCNAME(dnsQuestion, buildAliasMap(addressedEnvelope.content(), cnameCache(), this.parent.executor()), dnsQueryLifecycleObserver, promise);
                return;
            }
            for (DnsRecordType dnsRecordType : this.expectedTypes) {
                if (type == dnsRecordType) {
                    onExpectedResponse(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise);
                    return;
                }
            }
            dnsQueryLifecycleObserver.queryFailed(UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION);
        } finally {
            ReferenceCountUtil.safeRelease(addressedEnvelope);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void query(final DnsServerAddressStream dnsServerAddressStream, final int i6, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, boolean z5, final Promise<List<T>> promise, Throwable th) {
        if (this.completeEarly || i6 >= dnsServerAddressStream.size() || this.allowedQueries == 0 || promise.isCancelled()) {
            tryToFinishResolve(dnsServerAddressStream, i6, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
            return;
        }
        this.allowedQueries--;
        InetSocketAddress next = dnsServerAddressStream.next();
        if (next.isUnresolved()) {
            queryUnresolvedNameserver(next, dnsServerAddressStream, i6, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
            return;
        }
        ChannelPromise newPromise = this.parent.ch.newPromise();
        Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0 = this.parent.query0(next, dnsQuestion, this.additionals, z5, newPromise, this.parent.ch.eventLoop().newPromise());
        this.queriesInProgress.add(query0);
        dnsQueryLifecycleObserver.queryWritten(next, newPromise);
        query0.addListener(new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsResolveContext.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                DnsResolveContext.this.queriesInProgress.remove(future);
                if (promise.isDone() || future.isCancelled()) {
                    dnsQueryLifecycleObserver.queryCancelled(DnsResolveContext.this.allowedQueries);
                    AddressedEnvelope<DnsResponse, InetSocketAddress> now = future.getNow();
                    if (now != null) {
                        now.release();
                        return;
                    }
                    return;
                }
                Throwable cause = future.cause();
                try {
                    if (cause == null) {
                        DnsResolveContext.this.onResponse(dnsServerAddressStream, i6, dnsQuestion, future.getNow(), dnsQueryLifecycleObserver, promise);
                    } else {
                        dnsQueryLifecycleObserver.queryFailed(cause);
                        DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                        DnsServerAddressStream dnsServerAddressStream2 = dnsServerAddressStream;
                        int i7 = i6 + 1;
                        DnsQuestion dnsQuestion2 = dnsQuestion;
                        try {
                            dnsResolveContext.query(dnsServerAddressStream2, i7, dnsQuestion2, dnsResolveContext.newDnsQueryLifecycleObserver(dnsQuestion2), true, promise, cause);
                            cause = cause;
                        } catch (Throwable th2) {
                            th = th2;
                            cause = cause;
                            Throwable th3 = th;
                            DnsResolveContext.this.tryToFinishResolve(dnsServerAddressStream, i6, dnsQuestion, NoopDnsQueryLifecycleObserver.INSTANCE, promise, cause);
                            throw th3;
                        }
                    }
                    DnsResolveContext.this.tryToFinishResolve(dnsServerAddressStream, i6, dnsQuestion, NoopDnsQueryLifecycleObserver.INSTANCE, promise, cause);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        });
    }

    abstract void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, T t5);

    abstract void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException);

    abstract T convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop);

    abstract List<T> filterResults(List<T> list);

    abstract boolean isCompleteEarly(T t5);

    abstract boolean isDuplicateAllowed();

    abstract DnsResolveContext<T> newResolverContext(DnsNameResolver dnsNameResolver, String str, int i6, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream);

    private static Map<String, String> buildAliasMap(DnsResponse dnsResponse, DnsCnameCache dnsCnameCache, EventLoop eventLoop) {
        DnsCnameCache dnsCnameCache2;
        EventLoop eventLoop2;
        String decodeDomainName;
        int count = dnsResponse.count(DnsSection.ANSWER);
        HashMap hashMap = null;
        int i6 = 0;
        while (i6 < count) {
            DnsRecord recordAt = dnsResponse.recordAt(DnsSection.ANSWER, i6);
            if (recordAt.type() == DnsRecordType.CNAME && (recordAt instanceof DnsRawRecord) && (decodeDomainName = decodeDomainName(((ByteBufHolder) recordAt).content())) != null) {
                if (hashMap == null) {
                    hashMap = new HashMap(Math.min(8, count));
                }
                String name = recordAt.name();
                Locale locale = Locale.US;
                String lowerCase = name.toLowerCase(locale);
                String lowerCase2 = decodeDomainName.toLowerCase(locale);
                String hostnameWithDot = hostnameWithDot(lowerCase);
                String hostnameWithDot2 = hostnameWithDot(lowerCase2);
                if (!hostnameWithDot.equalsIgnoreCase(hostnameWithDot2)) {
                    dnsCnameCache2 = dnsCnameCache;
                    eventLoop2 = eventLoop;
                    dnsCnameCache2.cache(hostnameWithDot, hostnameWithDot2, recordAt.timeToLive(), eventLoop2);
                    hashMap.put(lowerCase, lowerCase2);
                    i6++;
                    dnsCnameCache = dnsCnameCache2;
                    eventLoop = eventLoop2;
                }
            }
            dnsCnameCache2 = dnsCnameCache;
            eventLoop2 = eventLoop;
            i6++;
            dnsCnameCache = dnsCnameCache2;
            eventLoop = eventLoop2;
        }
        return hashMap != null ? hashMap : Collections.EMPTY_MAP;
    }

    private static AuthoritativeNameServerList extractAuthoritativeNameServers(String str, DnsResponse dnsResponse) {
        int count = dnsResponse.count(DnsSection.AUTHORITY);
        if (count == 0) {
            return null;
        }
        AuthoritativeNameServerList authoritativeNameServerList = new AuthoritativeNameServerList(str);
        for (int i6 = 0; i6 < count; i6++) {
            authoritativeNameServerList.add(dnsResponse.recordAt(DnsSection.AUTHORITY, i6));
        }
        if (authoritativeNameServerList.isEmpty()) {
            return null;
        }
        return authoritativeNameServerList;
    }

    private void finishResolve(Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && !this.queriesInProgress.isEmpty()) {
            Iterator<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> it = this.queriesInProgress.iterator();
            while (it.hasNext()) {
                Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> next = it.next();
                it.remove();
                next.cancel(false);
            }
        }
        if (this.finalResult != null) {
            if (promise.isDone()) {
                return;
            }
            DnsNameResolver.trySuccess(promise, filterResults(this.finalResult));
            return;
        }
        int i6 = this.maxAllowedQueries - this.allowedQueries;
        StringBuilder sb = new StringBuilder(64);
        sb.append("failed to resolve '");
        sb.append(this.hostname);
        sb.append('\'');
        if (i6 > 1) {
            if (i6 < this.maxAllowedQueries) {
                sb.append(" after ");
                sb.append(i6);
                sb.append(" queries ");
            } else {
                sb.append(". Exceeded max queries per resolve ");
                sb.append(this.maxAllowedQueries);
                sb.append(' ');
            }
        }
        UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
        if (th == null) {
            cache(this.hostname, this.additionals, unknownHostException);
        } else {
            unknownHostException.initCause(th);
        }
        promise.tryFailure(unknownHostException);
    }

    private boolean hasNDots() {
        int i6 = 0;
        for (int length = this.hostname.length() - 1; length >= 0; length--) {
            if (this.hostname.charAt(length) == '.' && (i6 = i6 + 1) >= this.parent.ndots()) {
                return true;
            }
        }
        return false;
    }

    private static String hostnameWithDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return this.parent.dnsQueryLifecycleObserverFactory().newDnsQueryLifecycleObserver(dnsQuestion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToFinishResolve(DnsServerAddressStream dnsServerAddressStream, int i6, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && !this.queriesInProgress.isEmpty()) {
            dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
            return;
        }
        if (this.finalResult != null) {
            dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
        } else {
            if (i6 < dnsServerAddressStream.size()) {
                if (dnsQueryLifecycleObserver == NoopDnsQueryLifecycleObserver.INSTANCE) {
                    query(dnsServerAddressStream, i6 + 1, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, th);
                    return;
                } else {
                    query(dnsServerAddressStream, i6 + 1, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                    return;
                }
            }
            dnsQueryLifecycleObserver.queryFailed(NAME_SERVERS_EXHAUSTED_EXCEPTION);
            if (th == null && !this.triedCNAME) {
                this.triedCNAME = true;
                String str = this.hostname;
                query(str, DnsRecordType.CNAME, getNameServers(str), true, promise);
                return;
            }
        }
        finishResolve(promise, th);
    }

    AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.parent.authoritativeDnsServerCache();
    }

    DnsCnameCache cnameCache() {
        return this.parent.cnameCache();
    }

    void doSearchDomainQuery(String str, Promise<List<T>> promise) {
        newResolverContext(this.parent, str, this.dnsClass, this.expectedTypes, this.additionals, this.nameServerAddrs).internalResolve(str, promise);
    }

    void resolve(Promise<List<T>> promise) {
        String str;
        String[] searchDomains = this.parent.searchDomains();
        if (searchDomains.length == 0 || this.parent.ndots() == 0 || StringUtil.endsWith(this.hostname, '.')) {
            internalResolve(this.hostname, promise);
            return;
        }
        boolean hasNDots = hasNDots();
        if (hasNDots) {
            str = this.hostname;
        } else {
            str = this.hostname + '.' + searchDomains[0];
        }
        int i6 = !hasNDots ? 1 : 0;
        Promise<List<T>> newPromise = this.parent.executor().newPromise();
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<T>>>) new FutureListener<List<T>>(i6, promise, searchDomains, hasNDots) { // from class: io.netty.resolver.dns.DnsResolveContext.1
            private int searchDomainIdx;
            final /* synthetic */ int val$initialSearchDomainIdx;
            final /* synthetic */ Promise val$promise;
            final /* synthetic */ String[] val$searchDomains;
            final /* synthetic */ boolean val$startWithoutSearchDomain;

            {
                this.val$initialSearchDomainIdx = i6;
                this.val$promise = promise;
                this.val$searchDomains = searchDomains;
                this.val$startWithoutSearchDomain = hasNDots;
                this.searchDomainIdx = i6;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<T>> future) {
                Throwable cause = future.cause();
                if (cause == null) {
                    this.val$promise.trySuccess(future.getNow());
                    return;
                }
                if (DnsNameResolver.isTransportOrTimeoutError(cause)) {
                    this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname));
                    return;
                }
                if (this.searchDomainIdx < this.val$searchDomains.length) {
                    Promise<List<T>> newPromise2 = DnsResolveContext.this.parent.executor().newPromise();
                    newPromise2.addListener((GenericFutureListener<? extends Future<? super List<T>>>) this);
                    DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(DnsResolveContext.this.hostname);
                    sb.append('.');
                    String[] strArr = this.val$searchDomains;
                    int i7 = this.searchDomainIdx;
                    this.searchDomainIdx = i7 + 1;
                    sb.append(strArr[i7]);
                    dnsResolveContext.doSearchDomainQuery(sb.toString(), newPromise2);
                    return;
                }
                if (!this.val$startWithoutSearchDomain) {
                    DnsResolveContext dnsResolveContext2 = DnsResolveContext.this;
                    dnsResolveContext2.internalResolve(dnsResolveContext2.hostname, this.val$promise);
                } else {
                    this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname));
                }
            }
        });
        doSearchDomainQuery(str, newPromise);
    }

    DnsCache resolveCache() {
        return this.parent.resolveCache();
    }

    DnsResolveContext(DnsNameResolver dnsNameResolver, String str, int i6, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        this.parent = dnsNameResolver;
        this.hostname = str;
        this.dnsClass = i6;
        this.expectedTypes = dnsRecordTypeArr;
        this.additionals = dnsRecordArr;
        this.nameServerAddrs = (DnsServerAddressStream) ObjectUtil.checkNotNull(dnsServerAddressStream, "nameServerAddrs");
        int maxQueriesPerResolve = dnsNameResolver.maxQueriesPerResolve();
        this.maxAllowedQueries = maxQueriesPerResolve;
        this.allowedQueries = maxQueriesPerResolve;
    }

    static String decodeDomainName(ByteBuf byteBuf) {
        byteBuf.markReaderIndex();
        try {
            String decodeName = DefaultDnsRecordDecoder.decodeName(byteBuf);
            byteBuf.resetReaderIndex();
            return decodeName;
        } catch (CorruptedFrameException unused) {
            byteBuf.resetReaderIndex();
            return null;
        } catch (Throwable th) {
            byteBuf.resetReaderIndex();
            throw th;
        }
    }

    private DnsServerAddressStream getNameServers(String str) {
        DnsServerAddressStream nameServersFromCache = getNameServersFromCache(str);
        if (nameServersFromCache == null) {
            return this.nameServerAddrs.duplicate();
        }
        return nameServersFromCache;
    }

    private DnsServerAddressStream getNameServersFromCache(String str) {
        DnsServerAddressStream dnsServerAddressStream;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (str.charAt(length - 1) != '.') {
            str = str + ".";
        }
        int indexOf = str.indexOf(46);
        if (indexOf == str.length() - 1) {
            return null;
        }
        do {
            str = str.substring(indexOf + 1);
            indexOf = str.indexOf(46);
            if (indexOf <= 0 || indexOf == str.length() - 1) {
                return null;
            }
            dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        } while (dnsServerAddressStream == null);
        return dnsServerAddressStream;
    }

    private boolean handleRedirect(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        AuthoritativeNameServerList extractAuthoritativeNameServers;
        DnsResponse content = addressedEnvelope.content();
        if (content.count(DnsSection.ANSWER) == 0 && (extractAuthoritativeNameServers = extractAuthoritativeNameServers(dnsQuestion.name(), content)) != null) {
            int count = content.count(DnsSection.ADDITIONAL);
            AuthoritativeDnsServerCache authoritativeDnsServerCache = authoritativeDnsServerCache();
            for (int i6 = 0; i6 < count; i6++) {
                DnsRecord recordAt = content.recordAt(DnsSection.ADDITIONAL, i6);
                if ((recordAt.type() != DnsRecordType.A || this.parent.supportsARecords()) && (recordAt.type() != DnsRecordType.AAAA || this.parent.supportsAAAARecords())) {
                    extractAuthoritativeNameServers.handleWithAdditional(this.parent, recordAt, authoritativeDnsServerCache);
                }
            }
            extractAuthoritativeNameServers.handleWithoutAdditionals(this.parent, resolveCache(), authoritativeDnsServerCache);
            DnsServerAddressStream newRedirectDnsServerStream = this.parent.newRedirectDnsServerStream(dnsQuestion.name(), extractAuthoritativeNameServers.addressList());
            if (newRedirectDnsServerStream != null) {
                query(newRedirectDnsServerStream, 0, dnsQuestion, dnsQueryLifecycleObserver.queryRedirected(new DnsAddressStreamList(newRedirectDnsServerStream)), true, promise, null);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion r15, io.netty.channel.AddressedEnvelope<io.netty.handler.codec.dns.DnsResponse, java.net.InetSocketAddress> r16, io.netty.resolver.dns.DnsQueryLifecycleObserver r17, io.netty.util.concurrent.Promise<java.util.List<T>> r18) {
        /*
            r14 = this;
            java.lang.Object r0 = r16.content()
            io.netty.handler.codec.dns.DnsResponse r0 = (io.netty.handler.codec.dns.DnsResponse) r0
            io.netty.resolver.dns.DnsCnameCache r1 = r14.cnameCache()
            io.netty.resolver.dns.DnsNameResolver r2 = r14.parent
            io.netty.channel.EventLoop r2 = r2.executor()
            java.util.Map r1 = buildAliasMap(r0, r1, r2)
            io.netty.handler.codec.dns.DnsSection r2 = io.netty.handler.codec.dns.DnsSection.ANSWER
            int r2 = r0.count(r2)
            boolean r3 = r14.completeEarly
            r4 = 0
            r5 = 0
            r6 = 0
        L1f:
            r7 = 1
            if (r5 >= r2) goto Lba
            io.netty.handler.codec.dns.DnsSection r8 = io.netty.handler.codec.dns.DnsSection.ANSWER
            io.netty.handler.codec.dns.DnsRecord r8 = r0.recordAt(r8, r5)
            io.netty.handler.codec.dns.DnsRecordType r9 = r8.type()
            io.netty.handler.codec.dns.DnsRecordType[] r10 = r14.expectedTypes
            int r11 = r10.length
            r12 = 0
        L30:
            if (r12 >= r11) goto Lb6
            r13 = r10[r12]
            if (r9 != r13) goto Lb2
            java.lang.String r9 = r15.name()
            java.util.Locale r10 = java.util.Locale.US
            java.lang.String r9 = r9.toLowerCase(r10)
            java.lang.String r11 = r8.name()
            java.lang.String r10 = r11.toLowerCase(r10)
            boolean r11 = r10.equals(r9)
            if (r11 != 0) goto L65
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>(r1)
        L53:
            java.lang.Object r9 = r11.remove(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r12 = r10.equals(r9)
            if (r12 == 0) goto L60
            goto L62
        L60:
            if (r9 != 0) goto L53
        L62:
            if (r9 != 0) goto L65
            goto Lb6
        L65:
            java.lang.String r9 = r14.hostname
            io.netty.handler.codec.dns.DnsRecord[] r10 = r14.additionals
            io.netty.resolver.dns.DnsNameResolver r11 = r14.parent
            io.netty.channel.EventLoop r11 = r11.executor()
            java.lang.Object r9 = r14.convertRecord(r8, r9, r10, r11)
            if (r9 != 0) goto L76
            goto Lb6
        L76:
            if (r3 != 0) goto L7c
            boolean r3 = r14.isCompleteEarly(r9)
        L7c:
            java.util.List<T> r6 = r14.finalResult
            if (r6 != 0) goto L8d
            java.util.ArrayList r6 = new java.util.ArrayList
            r10 = 8
            r6.<init>(r10)
            r14.finalResult = r6
            r6.add(r9)
            goto La3
        L8d:
            boolean r6 = r14.isDuplicateAllowed()
            if (r6 != 0) goto L9e
            java.util.List<T> r6 = r14.finalResult
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L9c
            goto L9e
        L9c:
            r6 = 1
            goto La4
        L9e:
            java.util.List<T> r6 = r14.finalResult
            r6.add(r9)
        La3:
            r6 = 0
        La4:
            java.lang.String r10 = r14.hostname
            io.netty.handler.codec.dns.DnsRecord[] r11 = r14.additionals
            r14.cache(r10, r11, r8, r9)
            if (r6 == 0) goto Lb0
            io.netty.util.ReferenceCountUtil.release(r9)
        Lb0:
            r6 = 1
            goto Lb6
        Lb2:
            int r12 = r12 + 1
            goto L30
        Lb6:
            int r5 = r5 + 1
            goto L1f
        Lba:
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto Ld2
            if (r6 == 0) goto Lca
            if (r3 == 0) goto Lc6
            r14.completeEarly = r7
        Lc6:
            r17.querySucceed()
            return
        Lca:
            java.lang.RuntimeException r15 = io.netty.resolver.dns.DnsResolveContext.NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION
            r0 = r17
            r0.queryFailed(r15)
            return
        Ld2:
            r0 = r17
            r0.querySucceed()
            io.netty.resolver.dns.DnsQueryLifecycleObserver r0 = r14.newDnsQueryLifecycleObserver(r15)
            r2 = r18
            r14.onResponseCNAME(r15, r1, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsResolveContext.onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion, io.netty.channel.AddressedEnvelope, io.netty.resolver.dns.DnsQueryLifecycleObserver, io.netty.util.concurrent.Promise):void");
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, Map<String, String> map, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        String remove;
        String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
        boolean z5 = false;
        while (!map.isEmpty() && (remove = map.remove(lowerCase)) != null) {
            z5 = true;
            lowerCase = remove;
        }
        if (z5) {
            followCname(dnsQuestion, lowerCase, dnsQueryLifecycleObserver, promise);
        } else {
            dnsQueryLifecycleObserver.queryFailed(CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION);
        }
    }

    private void queryUnresolvedNameserver(final InetSocketAddress inetSocketAddress, final DnsServerAddressStream dnsServerAddressStream, final int i6, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, final Promise<List<T>> promise, final Throwable th) {
        String hostName;
        if (PlatformDependent.javaVersion() >= 7) {
            hostName = inetSocketAddress.getHostString();
        } else {
            hostName = inetSocketAddress.getHostName();
        }
        String str = hostName;
        final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> newSucceededFuture = this.parent.executor().newSucceededFuture(null);
        this.queriesInProgress.add(newSucceededFuture);
        Promise<List<T>> newPromise = this.parent.executor().newPromise();
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<T>>>) new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.dns.DnsResolveContext.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                DnsResolveContext.this.queriesInProgress.remove(newSucceededFuture);
                if (!future.isSuccess()) {
                    DnsResolveContext.this.query(dnsServerAddressStream, i6 + 1, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                    return;
                }
                DnsResolveContext.this.query(new CombinedDnsServerAddressStream(inetSocketAddress, future.getNow(), dnsServerAddressStream), i6, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
            }
        });
        if (!DnsNameResolver.doResolveAllCached(str, this.additionals, newPromise, resolveCache(), this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            final AuthoritativeDnsServerCache authoritativeDnsServerCache = authoritativeDnsServerCache();
            DnsNameResolver dnsNameResolver = this.parent;
            new DnsAddressResolveContext(dnsNameResolver, str, this.additionals, dnsNameResolver.newNameServerAddressStream(str), resolveCache(), new AuthoritativeDnsServerCache() { // from class: io.netty.resolver.dns.DnsResolveContext.4
                @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
                public void clear() {
                    authoritativeDnsServerCache.clear();
                }

                @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
                public DnsServerAddressStream get(String str2) {
                    return null;
                }

                @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
                public void cache(String str2, InetSocketAddress inetSocketAddress2, long j6, EventLoop eventLoop) {
                    authoritativeDnsServerCache.cache(str2, inetSocketAddress2, j6, eventLoop);
                }

                @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
                public boolean clear(String str2) {
                    return authoritativeDnsServerCache.clear(str2);
                }
            }, false).resolve(newPromise);
        }
    }

    private boolean query(String str, DnsRecordType dnsRecordType, DnsServerAddressStream dnsServerAddressStream, boolean z5, Promise<List<T>> promise) {
        try {
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(str, dnsRecordType, this.dnsClass);
            query(dnsServerAddressStream, 0, defaultDnsQuestion, newDnsQueryLifecycleObserver(defaultDnsQuestion), z5, promise, null);
            return true;
        } catch (Throwable th) {
            promise.tryFailure(new IllegalArgumentException("Unable to create DNS Question for: [" + str + ", " + dnsRecordType + ']', th));
            return false;
        }
    }
}
