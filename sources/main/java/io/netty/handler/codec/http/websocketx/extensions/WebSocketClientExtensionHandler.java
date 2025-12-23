package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketClientExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketClientExtensionHandshaker> extensionHandshakers;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpResponse.headers())) {
                String asString = httpResponse.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                if (asString != null) {
                    List<WebSocketExtensionData> extractExtensions = WebSocketExtensionUtil.extractExtensions(asString);
                    ArrayList<WebSocketClientExtension> arrayList = new ArrayList(extractExtensions.size());
                    int i6 = 0;
                    for (WebSocketExtensionData webSocketExtensionData : extractExtensions) {
                        Iterator<WebSocketClientExtensionHandshaker> it = this.extensionHandshakers.iterator();
                        WebSocketClientExtension webSocketClientExtension = null;
                        while (webSocketClientExtension == null && it.hasNext()) {
                            webSocketClientExtension = it.next().handshakeExtension(webSocketExtensionData);
                        }
                        if (webSocketClientExtension == null || (webSocketClientExtension.rsv() & i6) != 0) {
                            throw new CodecException("invalid WebSocket Extension handshake for \"" + asString + '\"');
                        }
                        i6 |= webSocketClientExtension.rsv();
                        arrayList.add(webSocketClientExtension);
                    }
                    for (WebSocketClientExtension webSocketClientExtension2 : arrayList) {
                        WebSocketExtensionDecoder newExtensionDecoder = webSocketClientExtension2.newExtensionDecoder();
                        WebSocketExtensionEncoder newExtensionEncoder = webSocketClientExtension2.newExtensionEncoder();
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionDecoder.getClass().getName(), newExtensionDecoder);
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), newExtensionEncoder.getClass().getName(), newExtensionEncoder);
                    }
                }
                channelHandlerContext.pipeline().remove(channelHandlerContext.name());
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers())) {
                String asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                Iterator<WebSocketClientExtensionHandshaker> it = this.extensionHandshakers.iterator();
                while (it.hasNext()) {
                    WebSocketExtensionData newRequestData = it.next().newRequestData();
                    asString = WebSocketExtensionUtil.appendExtension(asString, newRequestData.name(), newRequestData.parameters());
                }
                httpRequest.headers().set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, asString);
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }

    public WebSocketClientExtensionHandler(WebSocketClientExtensionHandshaker... webSocketClientExtensionHandshakerArr) {
        if (webSocketClientExtensionHandshakerArr != null) {
            if (webSocketClientExtensionHandshakerArr.length != 0) {
                this.extensionHandshakers = Arrays.asList(webSocketClientExtensionHandshakerArr);
                return;
            }
            throw new IllegalArgumentException("extensionHandshakers must contains at least one handshaker");
        }
        throw new NullPointerException("extensionHandshakers");
    }
}
