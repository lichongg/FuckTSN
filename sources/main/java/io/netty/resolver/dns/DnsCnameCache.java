package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DnsCnameCache {
    void cache(String str, String str2, long j6, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    String get(String str);
}
