package io.netty.handler.codec.http2;

import io.netty.channel.ChannelId;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Http2StreamChannelId implements ChannelId {
    private static final long serialVersionUID = -6642338822166867585L;
    private final int id;
    private final ChannelId parentId;

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        return this.parentId.asLongText() + '/' + this.id;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        return this.parentId.asShortText() + '/' + this.id;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (!(channelId instanceof Http2StreamChannelId)) {
            return this.parentId.compareTo(channelId);
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) channelId;
        int compareTo = this.parentId.compareTo(http2StreamChannelId.parentId);
        return compareTo == 0 ? this.id - http2StreamChannelId.id : compareTo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2StreamChannelId)) {
            return false;
        }
        Http2StreamChannelId http2StreamChannelId = (Http2StreamChannelId) obj;
        return this.id == http2StreamChannelId.id && this.parentId.equals(http2StreamChannelId.parentId);
    }

    public int hashCode() {
        return (this.id * 31) + this.parentId.hashCode();
    }

    Http2StreamChannelId(ChannelId channelId, int i6) {
        this.parentId = channelId;
        this.id = i6;
    }

    public String toString() {
        return asShortText();
    }
}
