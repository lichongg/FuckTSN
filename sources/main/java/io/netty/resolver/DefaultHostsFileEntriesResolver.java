package io.netty.resolver;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private final Map<String, Inet4Address> inet4Entries;
    private final Map<String, Inet6Address> inet6Entries;

    public DefaultHostsFileEntriesResolver() {
        this(parseEntries());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.resolver.DefaultHostsFileEntriesResolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] iArr = new int[ResolvedAddressTypes.values().length];
            $SwitchMap$io$netty$resolver$ResolvedAddressTypes = iArr;
            try {
                iArr[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    DefaultHostsFileEntriesResolver(HostsFileEntries hostsFileEntries) {
        this.inet4Entries = hostsFileEntries.inet4Entries();
        this.inet6Entries = hostsFileEntries.inet6Entries();
    }

    String normalize(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }

    private static HostsFileEntries parseEntries() {
        if (PlatformDependent.isWindows()) {
            return HostsFileParser.parseSilently(Charset.defaultCharset(), CharsetUtil.UTF_16, CharsetUtil.UTF_8);
        }
        return HostsFileParser.parseSilently();
    }

    @Override // io.netty.resolver.HostsFileEntriesResolver
    public InetAddress address(String str, ResolvedAddressTypes resolvedAddressTypes) {
        String normalize = normalize(str);
        int i6 = AnonymousClass1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 == 4) {
                        Inet6Address inet6Address = this.inet6Entries.get(normalize);
                        if (inet6Address != null) {
                            return inet6Address;
                        }
                        return this.inet4Entries.get(normalize);
                    }
                    throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
                }
                Inet4Address inet4Address = this.inet4Entries.get(normalize);
                if (inet4Address != null) {
                    return inet4Address;
                }
                return this.inet6Entries.get(normalize);
            }
            return this.inet6Entries.get(normalize);
        }
        return this.inet4Entries.get(normalize);
    }
}
