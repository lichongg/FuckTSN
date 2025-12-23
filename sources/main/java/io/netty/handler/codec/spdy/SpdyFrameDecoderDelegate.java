package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SpdyFrameDecoderDelegate {
    void readDataFrame(int i6, boolean z5, ByteBuf byteBuf);

    void readFrameError(String str);

    void readGoAwayFrame(int i6, int i7);

    void readHeaderBlock(ByteBuf byteBuf);

    void readHeaderBlockEnd();

    void readHeadersFrame(int i6, boolean z5);

    void readPingFrame(int i6);

    void readRstStreamFrame(int i6, int i7);

    void readSetting(int i6, int i7, boolean z5, boolean z6);

    void readSettingsEnd();

    void readSettingsFrame(boolean z5);

    void readSynReplyFrame(int i6, boolean z5);

    void readSynStreamFrame(int i6, int i7, byte b6, boolean z5, boolean z6);

    void readWindowUpdateFrame(int i6, int i7);
}
