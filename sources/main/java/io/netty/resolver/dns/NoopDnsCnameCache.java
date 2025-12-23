package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NoopDnsCnameCache implements DnsCnameCache {
    public static final NoopDnsCnameCache INSTANCE = new NoopDnsCnameCache();

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void clear() {
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public String get(String str) {
        return null;
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public boolean clear(String str) {
        return false;
    }

    private NoopDnsCnameCache() {
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void cache(String str, String str2, long j6, EventLoop eventLoop) {
    }
}
