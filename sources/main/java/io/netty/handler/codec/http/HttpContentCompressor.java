package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.handler.codec.http.HttpContentEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpContentCompressor extends HttpContentEncoder {
    private final int compressionLevel;
    private final int contentSizeThreshold;
    private ChannelHandlerContext ctx;
    private final int memLevel;
    private final int windowBits;

    public HttpContentCompressor() {
        this(6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.HttpContentCompressor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HttpContentCompressor(int i6) {
        this(i6, 15, 8, 0);
    }

    @Override // io.netty.handler.codec.http.HttpContentEncoder
    protected HttpContentEncoder.Result beginEncode(HttpResponse httpResponse, String str) throws Exception {
        ZlibWrapper determineWrapper;
        String str2;
        if ((this.contentSizeThreshold > 0 && (httpResponse instanceof HttpContent) && ((HttpContent) httpResponse).content().readableBytes() < this.contentSizeThreshold) || httpResponse.headers().get(HttpHeaderNames.CONTENT_ENCODING) != null || (determineWrapper = determineWrapper(str)) == null) {
            return null;
        }
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[determineWrapper.ordinal()];
        if (i6 == 1) {
            str2 = "gzip";
        } else {
            if (i6 != 2) {
                throw new Error();
            }
            str2 = "deflate";
        }
        return new HttpContentEncoder.Result(str2, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibEncoder(determineWrapper, this.compressionLevel, this.windowBits, this.memLevel)));
    }

    protected ZlibWrapper determineWrapper(String str) {
        String[] split = str.split(",");
        int length = split.length;
        int i6 = 0;
        float f6 = -1.0f;
        float f7 = -1.0f;
        float f8 = -1.0f;
        while (true) {
            float f9 = 0.0f;
            if (i6 >= length) {
                break;
            }
            String str2 = split[i6];
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                try {
                    f9 = Float.parseFloat(str2.substring(indexOf + 1));
                } catch (NumberFormatException unused) {
                }
            } else {
                f9 = 1.0f;
            }
            if (str2.contains("*")) {
                f8 = f9;
            } else if (str2.contains("gzip") && f9 > f6) {
                f6 = f9;
            } else if (str2.contains("deflate") && f9 > f7) {
                f7 = f9;
            }
            i6++;
        }
        if (f6 > 0.0f || f7 > 0.0f) {
            return f6 >= f7 ? ZlibWrapper.GZIP : ZlibWrapper.ZLIB;
        }
        if (f8 <= 0.0f) {
            return null;
        }
        if (f6 == -1.0f) {
            return ZlibWrapper.GZIP;
        }
        if (f7 == -1.0f) {
            return ZlibWrapper.ZLIB;
        }
        return null;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public HttpContentCompressor(int i6, int i7, int i8) {
        this(i6, i7, i8, 0);
    }

    public HttpContentCompressor(int i6, int i7, int i8, int i9) {
        if (i6 < 0 || i6 > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
        }
        if (i7 < 9 || i7 > 15) {
            throw new IllegalArgumentException("windowBits: " + i7 + " (expected: 9-15)");
        }
        if (i8 < 1 || i8 > 9) {
            throw new IllegalArgumentException("memLevel: " + i8 + " (expected: 1-9)");
        }
        if (i9 >= 0) {
            this.compressionLevel = i6;
            this.windowBits = i7;
            this.memLevel = i8;
            this.contentSizeThreshold = i9;
            return;
        }
        throw new IllegalArgumentException("contentSizeThreshold: " + i9 + " (expected: non negative number)");
    }
}
