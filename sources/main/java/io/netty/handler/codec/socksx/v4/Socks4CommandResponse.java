package io.netty.handler.codec.socksx.v4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Socks4CommandResponse extends Socks4Message {
    String dstAddr();

    int dstPort();

    Socks4CommandStatus status();
}
