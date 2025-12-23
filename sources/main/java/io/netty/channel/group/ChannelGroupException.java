package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ChannelGroupException extends ChannelException implements Iterable<Map.Entry<Channel, Throwable>> {
    private static final long serialVersionUID = -4093064295562629453L;
    private final Collection<Map.Entry<Channel, Throwable>> failed;

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Channel, Throwable>> iterator() {
        return this.failed.iterator();
    }

    public ChannelGroupException(Collection<Map.Entry<Channel, Throwable>> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                this.failed = Collections.unmodifiableCollection(collection);
                return;
            }
            throw new IllegalArgumentException("causes must be non empty");
        }
        throw new NullPointerException("causes");
    }
}
