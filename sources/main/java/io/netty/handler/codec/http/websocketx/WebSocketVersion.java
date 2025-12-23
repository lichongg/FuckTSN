package io.netty.handler.codec.http.websocketx;

import com.tencent.connect.common.Constants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum WebSocketVersion {
    UNKNOWN,
    V00,
    V07,
    V08,
    V13;

    public String toHttpHeaderValue() {
        if (this == V00) {
            return "0";
        }
        if (this == V07) {
            return "7";
        }
        if (this == V08) {
            return "8";
        }
        if (this == V13) {
            return Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        }
        throw new IllegalStateException("Unknown web socket version: " + this);
    }
}
