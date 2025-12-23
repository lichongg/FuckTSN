package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SocksRequest extends SocksMessage {
    private final SocksRequestType requestType;

    protected SocksRequest(SocksRequestType socksRequestType) {
        super(SocksMessageType.REQUEST);
        if (socksRequestType == null) {
            throw new NullPointerException("requestType");
        }
        this.requestType = socksRequestType;
    }

    public SocksRequestType requestType() {
        return this.requestType;
    }
}
