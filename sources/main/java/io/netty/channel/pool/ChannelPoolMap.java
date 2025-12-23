package io.netty.channel.pool;

import io.netty.channel.pool.ChannelPool;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ChannelPoolMap<K, P extends ChannelPool> {
    boolean contains(K k6);

    P get(K k6);
}
