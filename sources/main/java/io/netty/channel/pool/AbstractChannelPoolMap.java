package io.netty.channel.pool;

import io.netty.channel.pool.ChannelPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractChannelPoolMap<K, P extends ChannelPool> implements ChannelPoolMap<K, P>, Iterable<Map.Entry<K, P>>, Closeable {
    private final ConcurrentMap<K, P> map = PlatformDependent.newConcurrentHashMap();

    protected abstract P newPool(K k6);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Iterator<K> it = this.map.keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final boolean contains(K k6) {
        return this.map.containsKey(ObjectUtil.checkNotNull(k6, "key"));
    }

    @Override // io.netty.channel.pool.ChannelPoolMap
    public final P get(K k6) {
        P putIfAbsent;
        P p5 = this.map.get(ObjectUtil.checkNotNull(k6, "key"));
        if (p5 != null || (putIfAbsent = this.map.putIfAbsent(k6, (p5 = newPool(k6)))) == null) {
            return p5;
        }
        p5.close();
        return putIfAbsent;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, P>> iterator() {
        return new ReadOnlyIterator(this.map.entrySet().iterator());
    }

    public final boolean remove(K k6) {
        P remove = this.map.remove(ObjectUtil.checkNotNull(k6, "key"));
        if (remove == null) {
            return false;
        }
        remove.close();
        return true;
    }

    public final int size() {
        return this.map.size();
    }
}
