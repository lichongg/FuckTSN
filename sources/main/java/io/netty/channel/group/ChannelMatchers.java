package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ServerChannel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ChannelMatchers {
    private static final ChannelMatcher ALL_MATCHER = new ChannelMatcher() { // from class: io.netty.channel.group.ChannelMatchers.1
        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return true;
        }
    };
    private static final ChannelMatcher SERVER_CHANNEL_MATCHER = isInstanceOf(ServerChannel.class);
    private static final ChannelMatcher NON_SERVER_CHANNEL_MATCHER = isNotInstanceOf(ServerChannel.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ClassMatcher implements ChannelMatcher {
        private final Class<? extends Channel> clazz;

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return this.clazz.isInstance(channel);
        }

        ClassMatcher(Class<? extends Channel> cls) {
            this.clazz = cls;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CompositeMatcher implements ChannelMatcher {
        private final ChannelMatcher[] matchers;

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            for (ChannelMatcher channelMatcher : this.matchers) {
                if (!channelMatcher.matches(channel)) {
                    return false;
                }
            }
            return true;
        }

        CompositeMatcher(ChannelMatcher... channelMatcherArr) {
            this.matchers = channelMatcherArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InstanceMatcher implements ChannelMatcher {
        private final Channel channel;

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return this.channel == channel;
        }

        InstanceMatcher(Channel channel) {
            this.channel = channel;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InvertMatcher implements ChannelMatcher {
        private final ChannelMatcher matcher;

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return !this.matcher.matches(channel);
        }

        InvertMatcher(ChannelMatcher channelMatcher) {
            this.matcher = channelMatcher;
        }
    }

    public static ChannelMatcher compose(ChannelMatcher... channelMatcherArr) {
        if (channelMatcherArr.length >= 1) {
            return channelMatcherArr.length == 1 ? channelMatcherArr[0] : new CompositeMatcher(channelMatcherArr);
        }
        throw new IllegalArgumentException("matchers must at least contain one element");
    }

    public static ChannelMatcher all() {
        return ALL_MATCHER;
    }

    public static ChannelMatcher invert(ChannelMatcher channelMatcher) {
        return new InvertMatcher(channelMatcher);
    }

    public static ChannelMatcher is(Channel channel) {
        return new InstanceMatcher(channel);
    }

    public static ChannelMatcher isInstanceOf(Class<? extends Channel> cls) {
        return new ClassMatcher(cls);
    }

    public static ChannelMatcher isNonServerChannel() {
        return NON_SERVER_CHANNEL_MATCHER;
    }

    public static ChannelMatcher isServerChannel() {
        return SERVER_CHANNEL_MATCHER;
    }

    private ChannelMatchers() {
    }

    public static ChannelMatcher isNot(Channel channel) {
        return invert(is(channel));
    }

    public static ChannelMatcher isNotInstanceOf(Class<? extends Channel> cls) {
        return invert(isInstanceOf(cls));
    }
}
