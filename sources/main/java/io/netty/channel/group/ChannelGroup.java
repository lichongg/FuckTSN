package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ChannelGroup extends Set<Channel>, Comparable<ChannelGroup> {
    ChannelGroupFuture close();

    ChannelGroupFuture close(ChannelMatcher channelMatcher);

    @Deprecated
    ChannelGroupFuture deregister();

    @Deprecated
    ChannelGroupFuture deregister(ChannelMatcher channelMatcher);

    ChannelGroupFuture disconnect();

    ChannelGroupFuture disconnect(ChannelMatcher channelMatcher);

    Channel find(ChannelId channelId);

    ChannelGroup flush();

    ChannelGroup flush(ChannelMatcher channelMatcher);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object obj);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object obj, ChannelMatcher channelMatcher);

    String name();

    ChannelGroupFuture newCloseFuture();

    ChannelGroupFuture newCloseFuture(ChannelMatcher channelMatcher);

    ChannelGroupFuture write(Object obj);

    ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher, boolean z5);

    ChannelGroupFuture writeAndFlush(Object obj);

    ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher, boolean z5);
}
