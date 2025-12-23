package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum Http2Error {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    private static final Http2Error[] INT_TO_ENUM_MAP;
    private final long code;

    static {
        Http2Error[] values = values();
        Http2Error[] http2ErrorArr = new Http2Error[values.length];
        for (Http2Error http2Error : values) {
            http2ErrorArr[(int) http2Error.code()] = http2Error;
        }
        INT_TO_ENUM_MAP = http2ErrorArr;
    }

    public static Http2Error valueOf(long j6) {
        Http2Error[] http2ErrorArr = INT_TO_ENUM_MAP;
        if (j6 >= http2ErrorArr.length || j6 < 0) {
            return null;
        }
        return http2ErrorArr[(int) j6];
    }

    public long code() {
        return this.code;
    }

    Http2Error(long j6) {
        this.code = j6;
    }
}
