package io.netty.handler.codec.socks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SocksResponse extends SocksMessage {
    private final SocksResponseType responseType;

    protected SocksResponse(SocksResponseType socksResponseType) {
        super(SocksMessageType.RESPONSE);
        if (socksResponseType == null) {
            throw new NullPointerException("responseType");
        }
        this.responseType = socksResponseType;
    }

    public SocksResponseType responseType() {
        return this.responseType;
    }
}
