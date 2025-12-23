package io.netty.handler.codec.socksx.v5;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Socks5InitialRequest extends Socks5Message {
    List<Socks5AuthMethod> authMethods();
}
