package io.netty.handler.codec.rtsp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectEncoder;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class RtspEncoder extends HttpObjectEncoder<HttpMessage> {
    private static final int CRLF_SHORT = 3338;

    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    protected void encodeInitialLine(ByteBuf byteBuf, HttpMessage httpMessage) throws Exception {
        if (httpMessage instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) httpMessage;
            ByteBufUtil.copy(httpRequest.method().asciiName(), byteBuf);
            byteBuf.writeByte(32);
            byteBuf.writeCharSequence(httpRequest.uri(), CharsetUtil.UTF_8);
            byteBuf.writeByte(32);
            byteBuf.writeCharSequence(httpRequest.protocolVersion().toString(), CharsetUtil.US_ASCII);
            ByteBufUtil.writeShortBE(byteBuf, CRLF_SHORT);
            return;
        }
        if (!(httpMessage instanceof HttpResponse)) {
            throw new UnsupportedMessageTypeException("Unsupported type " + StringUtil.simpleClassName(httpMessage));
        }
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        String httpVersion = httpResponse.protocolVersion().toString();
        Charset charset = CharsetUtil.US_ASCII;
        byteBuf.writeCharSequence(httpVersion, charset);
        byteBuf.writeByte(32);
        ByteBufUtil.copy(httpResponse.status().codeAsText(), byteBuf);
        byteBuf.writeByte(32);
        byteBuf.writeCharSequence(httpResponse.status().reasonPhrase(), charset);
        ByteBufUtil.writeShortBE(byteBuf, CRLF_SHORT);
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (super.acceptOutboundMessage(obj)) {
            if ((obj instanceof HttpRequest) || (obj instanceof HttpResponse)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
