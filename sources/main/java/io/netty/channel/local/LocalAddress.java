package io.netty.channel.local;

import io.netty.channel.Channel;
import java.net.SocketAddress;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;
    private final String id;
    private final String strVal;

    LocalAddress(Channel channel) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("local:E");
        sb.append(Long.toHexString((channel.hashCode() & 4294967295L) | IjkMediaMeta.AV_CH_WIDE_RIGHT));
        sb.setCharAt(7, ':');
        this.id = sb.substring(6);
        this.strVal = sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.id.compareTo(localAddress.id);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.id.equals(((LocalAddress) obj).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String id() {
        return this.id;
    }

    public String toString() {
        return this.strVal;
    }

    public LocalAddress(String str) {
        if (str != null) {
            String lowerCase = str.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                this.id = lowerCase;
                this.strVal = "local:" + lowerCase;
                return;
            }
            throw new IllegalArgumentException("empty id");
        }
        throw new NullPointerException("id");
    }
}
