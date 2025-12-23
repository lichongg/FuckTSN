package io.netty.handler.proxy;

import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ProxyConnectionEvent {
    private final String authScheme;
    private final SocketAddress destinationAddress;
    private final String protocol;
    private final SocketAddress proxyAddress;
    private String strVal;

    public String authScheme() {
        return this.authScheme;
    }

    public <T extends SocketAddress> T destinationAddress() {
        return (T) this.destinationAddress;
    }

    public String protocol() {
        return this.protocol;
    }

    public <T extends SocketAddress> T proxyAddress() {
        return (T) this.proxyAddress;
    }

    public String toString() {
        String str = this.strVal;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(this.protocol);
        sb.append(", ");
        sb.append(this.authScheme);
        sb.append(", ");
        sb.append(this.proxyAddress);
        sb.append(" => ");
        sb.append(this.destinationAddress);
        sb.append(')');
        String sb2 = sb.toString();
        this.strVal = sb2;
        return sb2;
    }

    public ProxyConnectionEvent(String str, String str2, SocketAddress socketAddress, SocketAddress socketAddress2) {
        if (str != null) {
            if (str2 != null) {
                if (socketAddress != null) {
                    if (socketAddress2 != null) {
                        this.protocol = str;
                        this.authScheme = str2;
                        this.proxyAddress = socketAddress;
                        this.destinationAddress = socketAddress2;
                        return;
                    }
                    throw new NullPointerException("destinationAddress");
                }
                throw new NullPointerException("proxyAddress");
            }
            throw new NullPointerException("authScheme");
        }
        throw new NullPointerException("protocol");
    }
}
