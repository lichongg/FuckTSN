package io.netty.channel.group;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelId;
import io.netty.channel.ServerChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultChannelGroup extends AbstractSet<Channel> implements ChannelGroup {
    private static final AtomicInteger nextId = new AtomicInteger();
    private volatile boolean closed;
    private final EventExecutor executor;
    private final String name;
    private final ConcurrentMap<ChannelId, Channel> nonServerChannels;
    private final ChannelFutureListener remover;
    private final ConcurrentMap<ChannelId, Channel> serverChannels;
    private final boolean stayClosed;
    private final VoidChannelGroupFuture voidFuture;

    public DefaultChannelGroup(EventExecutor eventExecutor) {
        this(eventExecutor, false);
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close() {
        return close(ChannelMatchers.all());
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture deregister() {
        return deregister(ChannelMatchers.all());
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture disconnect() {
        return disconnect(ChannelMatchers.all());
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroup flush() {
        return flush(ChannelMatchers.all());
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture flushAndWrite(Object obj) {
        return writeAndFlush(obj);
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture newCloseFuture() {
        return newCloseFuture(ChannelMatchers.all());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return arrayList.toArray();
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object obj) {
        return write(obj, ChannelMatchers.all());
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, ChannelMatchers.all());
    }

    public DefaultChannelGroup(String str, EventExecutor eventExecutor) {
        this(str, eventExecutor, false);
    }

    private static Object safeDuplicate(Object obj) {
        return obj instanceof ByteBuf ? ((ByteBuf) obj).retainedDuplicate() : obj instanceof ByteBufHolder ? ((ByteBufHolder) obj).retainedDuplicate() : ReferenceCountUtil.retain(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Channel channel) {
        boolean z5 = (channel instanceof ServerChannel ? this.serverChannels : this.nonServerChannels).putIfAbsent(channel.id(), channel) == null;
        if (z5) {
            channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) this.remover);
        }
        if (this.stayClosed && this.closed) {
            channel.close();
        }
        return z5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.nonServerChannels.clear();
        this.serverChannels.clear();
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture close(ChannelMatcher channelMatcher) {
        if (channelMatcher == null) {
            throw new NullPointerException("matcher");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        if (this.stayClosed) {
            this.closed = true;
        }
        for (Channel channel : this.serverChannels.values()) {
            if (channelMatcher.matches(channel)) {
                linkedHashMap.put(channel, channel.close());
            }
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(channel2)) {
                linkedHashMap.put(channel2, channel2.close());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap, this.executor);
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelGroup channelGroup) {
        int compareTo = name().compareTo(channelGroup.name());
        return compareTo != 0 ? compareTo : System.identityHashCode(this) - System.identityHashCode(channelGroup);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof ServerChannel) {
            return this.serverChannels.containsValue(obj);
        }
        if (obj instanceof Channel) {
            return this.nonServerChannels.containsValue(obj);
        }
        return false;
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture deregister(ChannelMatcher channelMatcher) {
        if (channelMatcher == null) {
            throw new NullPointerException("matcher");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            if (channelMatcher.matches(channel)) {
                linkedHashMap.put(channel, channel.deregister());
            }
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(channel2)) {
                linkedHashMap.put(channel2, channel2.deregister());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap, this.executor);
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture disconnect(ChannelMatcher channelMatcher) {
        if (channelMatcher == null) {
            throw new NullPointerException("matcher");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            if (channelMatcher.matches(channel)) {
                linkedHashMap.put(channel, channel.disconnect());
            }
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(channel2)) {
                linkedHashMap.put(channel2, channel2.disconnect());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap, this.executor);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.channel.group.ChannelGroup
    public Channel find(ChannelId channelId) {
        Channel channel = this.nonServerChannels.get(channelId);
        return channel != null ? channel : this.serverChannels.get(channelId);
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroup flush(ChannelMatcher channelMatcher) {
        for (Channel channel : this.nonServerChannels.values()) {
            if (channelMatcher.matches(channel)) {
                channel.flush();
            }
        }
        return this;
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture flushAndWrite(Object obj, ChannelMatcher channelMatcher) {
        return writeAndFlush(obj, channelMatcher);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.nonServerChannels.isEmpty() && this.serverChannels.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Channel> iterator() {
        return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
    }

    @Override // io.netty.channel.group.ChannelGroup
    public String name() {
        return this.name;
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture newCloseFuture(ChannelMatcher channelMatcher) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(size());
        for (Channel channel : this.serverChannels.values()) {
            if (channelMatcher.matches(channel)) {
                linkedHashMap.put(channel, channel.closeFuture());
            }
        }
        for (Channel channel2 : this.nonServerChannels.values()) {
            if (channelMatcher.matches(channel2)) {
                linkedHashMap.put(channel2, channel2.closeFuture());
            }
        }
        return new DefaultChannelGroupFuture(this, linkedHashMap, this.executor);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Channel channel;
        if (obj instanceof ChannelId) {
            channel = this.nonServerChannels.remove(obj);
            if (channel == null) {
                channel = this.serverChannels.remove(obj);
            }
        } else if (obj instanceof Channel) {
            Channel channel2 = (Channel) obj;
            channel = channel2 instanceof ServerChannel ? this.serverChannels.remove(channel2.id()) : this.nonServerChannels.remove(channel2.id());
        } else {
            channel = null;
        }
        if (channel == null) {
            return false;
        }
        channel.closeFuture().removeListener((GenericFutureListener<? extends Future<? super Void>>) this.remover);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.nonServerChannels.size() + this.serverChannels.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return StringUtil.simpleClassName(this) + "(name: " + name() + ", size: " + size() + ')';
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher) {
        return write(obj, channelMatcher, false);
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher) {
        return writeAndFlush(obj, channelMatcher, false);
    }

    public DefaultChannelGroup(EventExecutor eventExecutor, boolean z5) {
        this("group-0x" + Integer.toHexString(nextId.incrementAndGet()), eventExecutor, z5);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher, boolean z5) {
        ChannelGroupFuture defaultChannelGroupFuture;
        if (obj == null) {
            throw new NullPointerException(CrashHianalyticsData.MESSAGE);
        }
        if (channelMatcher != null) {
            if (z5) {
                for (Channel channel : this.nonServerChannels.values()) {
                    if (channelMatcher.matches(channel)) {
                        channel.write(safeDuplicate(obj), channel.voidPromise());
                    }
                }
                defaultChannelGroupFuture = this.voidFuture;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap(size());
                for (Channel channel2 : this.nonServerChannels.values()) {
                    if (channelMatcher.matches(channel2)) {
                        linkedHashMap.put(channel2, channel2.write(safeDuplicate(obj)));
                    }
                }
                defaultChannelGroupFuture = new DefaultChannelGroupFuture(this, linkedHashMap, this.executor);
            }
            ReferenceCountUtil.release(obj);
            return defaultChannelGroupFuture;
        }
        throw new NullPointerException("matcher");
    }

    @Override // io.netty.channel.group.ChannelGroup
    public ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher, boolean z5) {
        ChannelGroupFuture defaultChannelGroupFuture;
        if (obj != null) {
            if (z5) {
                for (Channel channel : this.nonServerChannels.values()) {
                    if (channelMatcher.matches(channel)) {
                        channel.writeAndFlush(safeDuplicate(obj), channel.voidPromise());
                    }
                }
                defaultChannelGroupFuture = this.voidFuture;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap(size());
                for (Channel channel2 : this.nonServerChannels.values()) {
                    if (channelMatcher.matches(channel2)) {
                        linkedHashMap.put(channel2, channel2.writeAndFlush(safeDuplicate(obj)));
                    }
                }
                defaultChannelGroupFuture = new DefaultChannelGroupFuture(this, linkedHashMap, this.executor);
            }
            ReferenceCountUtil.release(obj);
            return defaultChannelGroupFuture;
        }
        throw new NullPointerException(CrashHianalyticsData.MESSAGE);
    }

    public DefaultChannelGroup(String str, EventExecutor eventExecutor, boolean z5) {
        this.serverChannels = PlatformDependent.newConcurrentHashMap();
        this.nonServerChannels = PlatformDependent.newConcurrentHashMap();
        this.remover = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroup.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                DefaultChannelGroup.this.remove(channelFuture.channel());
            }
        };
        this.voidFuture = new VoidChannelGroupFuture(this);
        if (str != null) {
            this.name = str;
            this.executor = eventExecutor;
            this.stayClosed = z5;
            return;
        }
        throw new NullPointerException(CommonNetImpl.NAME);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ArrayList arrayList = new ArrayList(size());
        arrayList.addAll(this.serverChannels.values());
        arrayList.addAll(this.nonServerChannels.values());
        return (T[]) arrayList.toArray(tArr);
    }
}
