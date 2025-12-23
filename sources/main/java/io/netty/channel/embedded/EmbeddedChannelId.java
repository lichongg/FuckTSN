package io.netty.channel.embedded;

import io.netty.channel.ChannelId;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class EmbeddedChannelId implements ChannelId {
    static final ChannelId INSTANCE = new EmbeddedChannelId();
    private static final long serialVersionUID = -251711922203466130L;

    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (channelId instanceof EmbeddedChannelId) {
            return 0;
        }
        return asLongText().compareTo(channelId.asLongText());
    }

    public boolean equals(Object obj) {
        return obj instanceof EmbeddedChannelId;
    }

    public String toString() {
        return "embedded";
    }

    private EmbeddedChannelId() {
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        return toString();
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        return toString();
    }
}
