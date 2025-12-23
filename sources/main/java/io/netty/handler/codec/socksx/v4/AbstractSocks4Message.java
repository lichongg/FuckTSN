package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractSocks4Message extends AbstractSocksMessage implements Socks4Message {
    @Override // io.netty.handler.codec.socksx.SocksMessage
    public final SocksVersion version() {
        return SocksVersion.SOCKS4a;
    }
}
