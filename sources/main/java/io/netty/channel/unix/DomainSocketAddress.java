package io.netty.channel.unix;

import java.io.File;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DomainSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -6934618000832236893L;
    private final String socketPath;

    public DomainSocketAddress(String str) {
        if (str == null) {
            throw new NullPointerException("socketPath");
        }
        this.socketPath = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DomainSocketAddress) {
            return ((DomainSocketAddress) obj).socketPath.equals(this.socketPath);
        }
        return false;
    }

    public int hashCode() {
        return this.socketPath.hashCode();
    }

    public String path() {
        return this.socketPath;
    }

    public String toString() {
        return path();
    }

    public DomainSocketAddress(File file) {
        this(file.getPath());
    }
}
