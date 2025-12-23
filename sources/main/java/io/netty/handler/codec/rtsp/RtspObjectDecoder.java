package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectDecoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class RtspObjectDecoder extends HttpObjectDecoder {
    protected RtspObjectDecoder() {
        this(4096, 8192, 8192);
    }

    protected RtspObjectDecoder(int i6, int i7, int i8) {
        super(i6, i7, i8 * 2, false);
    }

    protected RtspObjectDecoder(int i6, int i7, int i8, boolean z5) {
        super(i6, i7, i8 * 2, false, z5);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        boolean isContentAlwaysEmpty = super.isContentAlwaysEmpty(httpMessage);
        if (isContentAlwaysEmpty || !httpMessage.headers().contains(RtspHeaderNames.CONTENT_LENGTH)) {
            return true;
        }
        return isContentAlwaysEmpty;
    }
}
