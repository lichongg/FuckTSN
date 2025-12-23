package io.netty.resolver.dns;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UnixResolverDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    static final int DEFAULT_NDOTS = 1;
    private static final String DOMAIN_ROW_LABEL = "domain";
    private static final String ETC_RESOLVER_DIR = "/etc/resolver";
    private static final String ETC_RESOLV_CONF_FILE = "/etc/resolv.conf";
    private static final String NAMESERVER_ROW_LABEL = "nameserver";
    private static final String NDOTS_LABEL = "ndots:";
    private static final String OPTIONS_ROW_LABEL = "options";
    private static final String PORT_ROW_LABEL = "port";
    private static final String SEARCH_ROW_LABEL = "search";
    private static final String SORTLIST_ROW_LABEL = "sortlist";
    private final DnsServerAddresses defaultNameServerAddresses;
    private final Map<String, DnsServerAddresses> domainToNameServerStreamMap;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) UnixResolverDnsServerAddressStreamProvider.class);
    private static final Pattern SEARCH_DOMAIN_PATTERN = Pattern.compile("\\s+");

    public UnixResolverDnsServerAddressStreamProvider(File file, File... fileArr) throws IOException {
        Map<? extends String, ? extends DnsServerAddresses> parse = parse((File) ObjectUtil.checkNotNull(file, "etcResolvConf"));
        boolean z5 = (fileArr == null || fileArr.length == 0) ? false : true;
        Map<String, DnsServerAddresses> parse2 = z5 ? parse(fileArr) : parse;
        this.domainToNameServerStreamMap = parse2;
        DnsServerAddresses dnsServerAddresses = parse.get(file.getName());
        if (dnsServerAddresses == null) {
            Collection<? extends DnsServerAddresses> values = parse.values();
            if (values.isEmpty()) {
                throw new IllegalArgumentException(file + " didn't provide any name servers");
            }
            this.defaultNameServerAddresses = values.iterator().next();
        } else {
            this.defaultNameServerAddresses = dnsServerAddresses;
        }
        if (z5) {
            parse2.putAll(parse);
        }
    }

    static int parseEtcResolverFirstNdots() throws IOException {
        return parseEtcResolverFirstNdots(new File(ETC_RESOLV_CONF_FILE));
    }

    static List<String> parseEtcResolverSearchDomains() throws IOException {
        return parseEtcResolverSearchDomains(new File(ETC_RESOLV_CONF_FILE));
    }

    private static void putIfAbsent(Map<String, DnsServerAddresses> map, String str, List<InetSocketAddress> list) {
        putIfAbsent(map, str, DnsServerAddresses.sequential(list));
    }

    private boolean mayOverrideNameServers() {
        return (this.domainToNameServerStreamMap.isEmpty() && this.defaultNameServerAddresses.stream().next() == null) ? false : true;
    }

    private static Map<String, DnsServerAddresses> parse(File... fileArr) throws IOException {
        BufferedReader bufferedReader;
        char charAt;
        HashMap hashMap = new HashMap(fileArr.length << 1);
        int length = fileArr.length;
        int i6 = 0;
        int i7 = 0;
        while (i7 < length) {
            File file = fileArr[i7];
            if (file.isFile()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader2 = null;
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    ArrayList arrayList = new ArrayList(2);
                    String name = file.getName();
                    int i8 = 53;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String trim = readLine.trim();
                            if (!trim.isEmpty() && (charAt = trim.charAt(i6)) != '#' && charAt != ';') {
                                if (trim.startsWith(NAMESERVER_ROW_LABEL)) {
                                    int indexOfNonWhiteSpace = StringUtil.indexOfNonWhiteSpace(trim, 10);
                                    if (indexOfNonWhiteSpace < 0) {
                                        throw new IllegalArgumentException("error parsing label nameserver in file " + file + ". value: " + trim);
                                    }
                                    String substring = trim.substring(indexOfNonWhiteSpace);
                                    if (!NetUtil.isValidIpV4Address(substring) && !NetUtil.isValidIpV6Address(substring)) {
                                        int lastIndexOf = substring.lastIndexOf(46);
                                        int i9 = lastIndexOf + 1;
                                        if (i9 >= substring.length()) {
                                            throw new IllegalArgumentException("error parsing label nameserver in file " + file + ". invalid IP value: " + trim);
                                        }
                                        int parseInt = Integer.parseInt(substring.substring(i9));
                                        substring = substring.substring(0, lastIndexOf);
                                        i8 = parseInt;
                                    }
                                    arrayList.add(SocketUtils.socketAddress(substring, i8));
                                } else {
                                    if (trim.startsWith(DOMAIN_ROW_LABEL)) {
                                        int indexOfNonWhiteSpace2 = StringUtil.indexOfNonWhiteSpace(trim, 6);
                                        if (indexOfNonWhiteSpace2 < 0) {
                                            throw new IllegalArgumentException("error parsing label domain in file " + file + " value: " + trim);
                                        }
                                        String substring2 = trim.substring(indexOfNonWhiteSpace2);
                                        if (!arrayList.isEmpty()) {
                                            putIfAbsent(hashMap, substring2, arrayList);
                                        }
                                        arrayList = new ArrayList(2);
                                        name = substring2;
                                    } else if (trim.startsWith("port")) {
                                        int indexOfNonWhiteSpace3 = StringUtil.indexOfNonWhiteSpace(trim, 4);
                                        if (indexOfNonWhiteSpace3 < 0) {
                                            throw new IllegalArgumentException("error parsing label port in file " + file + " value: " + trim);
                                        }
                                        i8 = Integer.parseInt(trim.substring(indexOfNonWhiteSpace3));
                                    } else if (trim.startsWith(SORTLIST_ROW_LABEL)) {
                                        logger.info("row type {} not supported. ignoring line: {}", SORTLIST_ROW_LABEL, trim);
                                    }
                                    i6 = 0;
                                }
                            }
                            i6 = 0;
                        } else {
                            if (!arrayList.isEmpty()) {
                                putIfAbsent(hashMap, name, arrayList);
                            }
                            bufferedReader.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        fileReader.close();
                    } else {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            }
            i7++;
            i6 = 0;
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        r2 = r5.indexOf(io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.NDOTS_LABEL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r2 < 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        r2 = r2 + 6;
        r3 = r5.indexOf(32, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r3 >= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r3 = r5.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        r5 = java.lang.Integer.parseInt(r5.substring(r2, r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int parseEtcResolverFirstNdots(java.io.File r5) throws java.io.IOException {
        /*
            java.io.FileReader r0 = new java.io.FileReader
            r0.<init>(r5)
            r5 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L43
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L43
        Lb:
            java.lang.String r5 = r1.readLine()     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L3e
            java.lang.String r2 = "options"
            boolean r2 = r5.startsWith(r2)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto Lb
            java.lang.String r2 = "ndots:"
            int r2 = r5.indexOf(r2)     // Catch: java.lang.Throwable -> L30
            if (r2 < 0) goto L3e
            int r2 = r2 + 6
            r3 = 32
            int r3 = r5.indexOf(r3, r2)     // Catch: java.lang.Throwable -> L30
            if (r3 >= 0) goto L32
            int r3 = r5.length()     // Catch: java.lang.Throwable -> L30
            goto L32
        L30:
            r5 = move-exception
            goto L47
        L32:
            java.lang.String r5 = r5.substring(r2, r3)     // Catch: java.lang.Throwable -> L30
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> L30
            r1.close()
            return r5
        L3e:
            r1.close()
            r5 = 1
            return r5
        L43:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L47:
            if (r1 != 0) goto L4d
            r0.close()
            goto L50
        L4d:
            r1.close()
        L50:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.parseEtcResolverFirstNdots(java.io.File):int");
    }

    static List<String> parseEtcResolverSearchDomains(File file) throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        int indexOfNonWhiteSpace;
        ArrayList arrayList = new ArrayList();
        FileReader fileReader = new FileReader(file);
        String str = null;
        try {
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (str == null && readLine.startsWith(DOMAIN_ROW_LABEL)) {
                        int indexOfNonWhiteSpace2 = StringUtil.indexOfNonWhiteSpace(readLine, 6);
                        if (indexOfNonWhiteSpace2 >= 0) {
                            str = readLine.substring(indexOfNonWhiteSpace2);
                        }
                    } else if (readLine.startsWith(SEARCH_ROW_LABEL) && (indexOfNonWhiteSpace = StringUtil.indexOfNonWhiteSpace(readLine, 6)) >= 0) {
                        Collections.addAll(arrayList, SEARCH_DOMAIN_PATTERN.split(readLine.substring(indexOfNonWhiteSpace)));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader == null) {
                        fileReader.close();
                        throw th;
                    }
                    bufferedReader.close();
                    throw th;
                }
            }
            bufferedReader.close();
            return (str == null || !arrayList.isEmpty()) ? arrayList : Collections.singletonList(str);
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    static DnsServerAddressStreamProvider parseSilently() {
        try {
            UnixResolverDnsServerAddressStreamProvider unixResolverDnsServerAddressStreamProvider = new UnixResolverDnsServerAddressStreamProvider(ETC_RESOLV_CONF_FILE, ETC_RESOLVER_DIR);
            return unixResolverDnsServerAddressStreamProvider.mayOverrideNameServers() ? unixResolverDnsServerAddressStreamProvider : DefaultDnsServerAddressStreamProvider.INSTANCE;
        } catch (Exception e6) {
            logger.debug("failed to parse {} and/or {}", ETC_RESOLV_CONF_FILE, ETC_RESOLVER_DIR, e6);
            return DefaultDnsServerAddressStreamProvider.INSTANCE;
        }
    }

    private static void putIfAbsent(Map<String, DnsServerAddresses> map, String str, DnsServerAddresses dnsServerAddresses) {
        DnsServerAddresses put = map.put(str, dnsServerAddresses);
        if (put != null) {
            map.put(str, put);
            logger.debug("Domain name {} already maps to addresses {} so new addresses {} will be discarded", str, put, dnsServerAddresses);
        }
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public DnsServerAddressStream nameServerAddressStream(String str) {
        while (true) {
            int indexOf = str.indexOf(46, 1);
            if (indexOf < 0 || indexOf == str.length() - 1) {
                break;
            }
            DnsServerAddresses dnsServerAddresses = this.domainToNameServerStreamMap.get(str);
            if (dnsServerAddresses != null) {
                return dnsServerAddresses.stream();
            }
            str = str.substring(indexOf + 1);
        }
        return this.defaultNameServerAddresses.stream();
    }

    public UnixResolverDnsServerAddressStreamProvider(String str, String str2) throws IOException {
        this(str == null ? null : new File(str), str2 != null ? new File(str2).listFiles() : null);
    }
}
