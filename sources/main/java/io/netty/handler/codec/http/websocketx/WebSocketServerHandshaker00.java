package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.internal.logging.InternalLogger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketServerHandshaker00 extends WebSocketServerHandshaker {
    private static final Pattern BEGINNING_DIGIT = Pattern.compile("[^0-9]");
    private static final Pattern BEGINNING_SPACE = Pattern.compile("[^ ]");

    public WebSocketServerHandshaker00(String str, String str2, int i6) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i6).build());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(decoderConfig());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return channel.writeAndFlush(closeWebSocketFrame, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        String str;
        HttpHeaders headers = fullHttpRequest.headers();
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        AsciiString asciiString2 = HttpHeaderValues.UPGRADE;
        boolean z5 = true;
        if (headers.containsValue(asciiString, asciiString2, true)) {
            AsciiString asciiString3 = HttpHeaderValues.WEBSOCKET;
            HttpHeaders headers2 = fullHttpRequest.headers();
            AsciiString asciiString4 = HttpHeaderNames.UPGRADE;
            if (asciiString3.contentEqualsIgnoreCase(headers2.get(asciiString4))) {
                HttpHeaders headers3 = fullHttpRequest.headers();
                AsciiString asciiString5 = HttpHeaderNames.SEC_WEBSOCKET_KEY1;
                if (!headers3.contains(asciiString5) || !fullHttpRequest.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2)) {
                    z5 = false;
                }
                String str2 = fullHttpRequest.headers().get(HttpHeaderNames.ORIGIN);
                if (str2 == null && !z5) {
                    throw new WebSocketHandshakeException("Missing origin header, got only " + fullHttpRequest.headers().names());
                }
                HttpVersion httpVersion = HttpVersion.HTTP_1_1;
                if (z5) {
                    str = "WebSocket Protocol Handshake";
                } else {
                    str = "Web Socket Protocol Handshake";
                }
                DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(httpVersion, new HttpResponseStatus(101, str), fullHttpRequest.content().alloc().buffer(0));
                if (httpHeaders != null) {
                    defaultFullHttpResponse.headers().add(httpHeaders);
                }
                defaultFullHttpResponse.headers().add(asciiString4, asciiString3);
                defaultFullHttpResponse.headers().add(asciiString, asciiString2);
                if (z5) {
                    defaultFullHttpResponse.headers().add(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN, str2);
                    defaultFullHttpResponse.headers().add(HttpHeaderNames.SEC_WEBSOCKET_LOCATION, uri());
                    HttpHeaders headers4 = fullHttpRequest.headers();
                    AsciiString asciiString6 = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
                    String str3 = headers4.get(asciiString6);
                    if (str3 != null) {
                        String selectSubprotocol = selectSubprotocol(str3);
                        if (selectSubprotocol == null) {
                            InternalLogger internalLogger = WebSocketServerHandshaker.logger;
                            if (internalLogger.isDebugEnabled()) {
                                internalLogger.debug("Requested subprotocol(s) not supported: {}", str3);
                            }
                        } else {
                            defaultFullHttpResponse.headers().add(asciiString6, selectSubprotocol);
                        }
                    }
                    String str4 = fullHttpRequest.headers().get(asciiString5);
                    String str5 = fullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY2);
                    Pattern pattern = BEGINNING_DIGIT;
                    long parseLong = Long.parseLong(pattern.matcher(str4).replaceAll(""));
                    Pattern pattern2 = BEGINNING_SPACE;
                    int parseLong2 = (int) (Long.parseLong(pattern.matcher(str5).replaceAll("")) / pattern2.matcher(str5).replaceAll("").length());
                    long readLong = fullHttpRequest.content().readLong();
                    ByteBuf index = Unpooled.wrappedBuffer(new byte[16]).setIndex(0, 0);
                    index.writeInt((int) (parseLong / pattern2.matcher(str4).replaceAll("").length()));
                    index.writeInt(parseLong2);
                    index.writeLong(readLong);
                    defaultFullHttpResponse.content().writeBytes(WebSocketUtil.md5(index.array()));
                    return defaultFullHttpResponse;
                }
                defaultFullHttpResponse.headers().add(HttpHeaderNames.WEBSOCKET_ORIGIN, str2);
                defaultFullHttpResponse.headers().add(HttpHeaderNames.WEBSOCKET_LOCATION, uri());
                HttpHeaders headers5 = fullHttpRequest.headers();
                AsciiString asciiString7 = HttpHeaderNames.WEBSOCKET_PROTOCOL;
                String str6 = headers5.get(asciiString7);
                if (str6 != null) {
                    defaultFullHttpResponse.headers().add(asciiString7, selectSubprotocol(str6));
                }
                return defaultFullHttpResponse;
            }
        }
        throw new WebSocketHandshakeException("not a WebSocket handshake request: missing upgrade");
    }

    public WebSocketServerHandshaker00(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(WebSocketVersion.V00, str, str2, webSocketDecoderConfig);
    }
}
