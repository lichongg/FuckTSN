package io.netty.handler.codec.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpServerUpgradeHandler extends HttpObjectAggregator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean handlingUpgrade;
    private final SourceCodec sourceCodec;
    private final UpgradeCodecFactory upgradeCodecFactory;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface SourceCodec {
        void upgradeFrom(ChannelHandlerContext channelHandlerContext);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface UpgradeCodec {
        boolean prepareUpgradeResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders);

        Collection<CharSequence> requiredUpgradeHeaders();

        void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface UpgradeCodecFactory {
        UpgradeCodec newUpgradeCodec(CharSequence charSequence);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class UpgradeEvent implements ReferenceCounted {
        private final CharSequence protocol;
        private final FullHttpRequest upgradeRequest;

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.upgradeRequest.release();
        }

        public CharSequence protocol() {
            return this.protocol;
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.upgradeRequest.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i6) {
            return this.upgradeRequest.release(i6);
        }

        public String toString() {
            return "UpgradeEvent [protocol=" + ((Object) this.protocol) + ", upgradeRequest=" + this.upgradeRequest + ']';
        }

        public FullHttpRequest upgradeRequest() {
            return this.upgradeRequest;
        }

        UpgradeEvent(CharSequence charSequence, FullHttpRequest fullHttpRequest) {
            this.protocol = charSequence;
            this.upgradeRequest = fullHttpRequest;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent retain() {
            this.upgradeRequest.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent touch() {
            this.upgradeRequest.touch();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent retain(int i6) {
            this.upgradeRequest.retain(i6);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent touch(Object obj) {
            this.upgradeRequest.touch(obj);
            return this;
        }
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory) {
        this(sourceCodec, upgradeCodecFactory, 0);
    }

    @Override // io.netty.handler.codec.MessageAggregator, io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, Object obj, List list) throws Exception {
        decode(channelHandlerContext, (HttpObject) obj, (List<Object>) list);
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory, int i6) {
        super(i6);
        this.sourceCodec = (SourceCodec) ObjectUtil.checkNotNull(sourceCodec, "sourceCodec");
        this.upgradeCodecFactory = (UpgradeCodecFactory) ObjectUtil.checkNotNull(upgradeCodecFactory, "upgradeCodecFactory");
    }

    private static FullHttpResponse createUpgradeResponse(CharSequence charSequence) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, Unpooled.EMPTY_BUFFER, false);
        defaultFullHttpResponse.headers().add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE);
        defaultFullHttpResponse.headers().add(HttpHeaderNames.UPGRADE, charSequence);
        return defaultFullHttpResponse;
    }

    private static boolean isUpgradeRequest(HttpObject httpObject) {
        return (httpObject instanceof HttpRequest) && ((HttpRequest) httpObject).headers().get(HttpHeaderNames.UPGRADE) != null;
    }

    private static List<CharSequence> splitHeader(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        ArrayList arrayList = new ArrayList(4);
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            char charAt = charSequence.charAt(i6);
            if (!Character.isWhitespace(charAt)) {
                if (charAt == ',') {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(charAt);
                }
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    protected void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        FullHttpRequest fullHttpRequest;
        boolean isUpgradeRequest = this.handlingUpgrade | isUpgradeRequest(httpObject);
        this.handlingUpgrade = isUpgradeRequest;
        if (!isUpgradeRequest) {
            ReferenceCountUtil.retain(httpObject);
            list.add(httpObject);
            return;
        }
        if (httpObject instanceof FullHttpRequest) {
            fullHttpRequest = (FullHttpRequest) httpObject;
            ReferenceCountUtil.retain(httpObject);
            list.add(httpObject);
        } else {
            super.decode(channelHandlerContext, (ChannelHandlerContext) httpObject, list);
            if (list.isEmpty()) {
                return;
            }
            this.handlingUpgrade = false;
            fullHttpRequest = (FullHttpRequest) list.get(0);
        }
        if (upgrade(channelHandlerContext, fullHttpRequest)) {
            list.clear();
        }
    }

    private boolean upgrade(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        CharSequence charSequence;
        UpgradeCodec upgradeCodec;
        List<String> all;
        List<CharSequence> splitHeader = splitHeader(fullHttpRequest.headers().get(HttpHeaderNames.UPGRADE));
        int size = splitHeader.size();
        int i6 = 0;
        while (true) {
            if (i6 < size) {
                charSequence = splitHeader.get(i6);
                upgradeCodec = this.upgradeCodecFactory.newUpgradeCodec(charSequence);
                if (upgradeCodec != null) {
                    break;
                }
                i6++;
            } else {
                charSequence = null;
                upgradeCodec = null;
                break;
            }
        }
        if (upgradeCodec == null || (all = fullHttpRequest.headers().getAll(HttpHeaderNames.CONNECTION)) == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(all.size() * 10);
        Iterator<String> it = all.iterator();
        while (it.hasNext()) {
            sb.append((CharSequence) it.next());
            sb.append(StringUtil.COMMA);
        }
        sb.setLength(sb.length() - 1);
        Collection<CharSequence> requiredUpgradeHeaders = upgradeCodec.requiredUpgradeHeaders();
        List<CharSequence> splitHeader2 = splitHeader(sb);
        if (!AsciiString.containsContentEqualsIgnoreCase(splitHeader2, HttpHeaderNames.UPGRADE) || !AsciiString.containsAllContentEqualsIgnoreCase(splitHeader2, requiredUpgradeHeaders)) {
            return false;
        }
        Iterator<CharSequence> it2 = requiredUpgradeHeaders.iterator();
        while (it2.hasNext()) {
            if (!fullHttpRequest.headers().contains(it2.next())) {
                return false;
            }
        }
        FullHttpResponse createUpgradeResponse = createUpgradeResponse(charSequence);
        if (!upgradeCodec.prepareUpgradeResponse(channelHandlerContext, fullHttpRequest, createUpgradeResponse.headers())) {
            return false;
        }
        UpgradeEvent upgradeEvent = new UpgradeEvent(charSequence, fullHttpRequest);
        try {
            ChannelFuture writeAndFlush = channelHandlerContext.writeAndFlush(createUpgradeResponse);
            this.sourceCodec.upgradeFrom(channelHandlerContext);
            upgradeCodec.upgradeTo(channelHandlerContext, fullHttpRequest);
            channelHandlerContext.pipeline().remove(this);
            channelHandlerContext.fireUserEventTriggered(upgradeEvent.retain());
            writeAndFlush.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return true;
        } finally {
            upgradeEvent.release();
        }
    }
}
