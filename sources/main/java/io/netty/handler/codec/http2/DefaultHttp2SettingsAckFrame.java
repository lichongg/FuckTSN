package io.netty.handler.codec.http2;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DefaultHttp2SettingsAckFrame implements Http2SettingsAckFrame {
    @Override // io.netty.handler.codec.http2.Http2SettingsAckFrame, io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "SETTINGS(ACK)";
    }

    DefaultHttp2SettingsAckFrame() {
    }

    public String toString() {
        return StringUtil.simpleClassName(this);
    }
}
