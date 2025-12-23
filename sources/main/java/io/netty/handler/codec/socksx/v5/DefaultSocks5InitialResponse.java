package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSocks5InitialResponse extends AbstractSocks5Message implements Socks5InitialResponse {
    private final Socks5AuthMethod authMethod;

    @Override // io.netty.handler.codec.socksx.v5.Socks5InitialResponse
    public Socks5AuthMethod authMethod() {
        return this.authMethod;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb.append("(authMethod: ");
        } else {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", authMethod: ");
        }
        sb.append(authMethod());
        sb.append(')');
        return sb.toString();
    }

    public DefaultSocks5InitialResponse(Socks5AuthMethod socks5AuthMethod) {
        if (socks5AuthMethod != null) {
            this.authMethod = socks5AuthMethod;
            return;
        }
        throw new NullPointerException("authMethod");
    }
}
