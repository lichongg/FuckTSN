package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpResponseEncoder extends HttpObjectEncoder<HttpResponse> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpResponse httpResponse) throws Exception {
        httpResponse.protocolVersion().encode(byteBuf);
        byteBuf.writeByte(32);
        httpResponse.status().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
        HttpResponseStatus status = httpResponse.status();
        if (status.codeClass() != HttpStatusClass.INFORMATIONAL) {
            return status.code() == HttpResponseStatus.NO_CONTENT.code() || status.code() == HttpResponseStatus.NOT_MODIFIED.code() || status.code() == HttpResponseStatus.RESET_CONTENT.code();
        }
        if (status.code() == HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z5) {
        if (z5) {
            HttpResponseStatus status = httpResponse.status();
            if (status.codeClass() == HttpStatusClass.INFORMATIONAL || status.code() == HttpResponseStatus.NO_CONTENT.code()) {
                httpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else if (status.code() == HttpResponseStatus.RESET_CONTENT.code()) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
                httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, 0);
            }
        }
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (super.acceptOutboundMessage(obj) && !(obj instanceof HttpRequest)) {
            return true;
        }
        return false;
    }
}
