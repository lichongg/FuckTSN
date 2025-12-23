package io.netty.handler.codec.spdy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdyStreamStatus implements Comparable<SpdyStreamStatus> {
    private final int code;
    private final String statusPhrase;
    public static final SpdyStreamStatus PROTOCOL_ERROR = new SpdyStreamStatus(1, "PROTOCOL_ERROR");
    public static final SpdyStreamStatus INVALID_STREAM = new SpdyStreamStatus(2, "INVALID_STREAM");
    public static final SpdyStreamStatus REFUSED_STREAM = new SpdyStreamStatus(3, "REFUSED_STREAM");
    public static final SpdyStreamStatus UNSUPPORTED_VERSION = new SpdyStreamStatus(4, "UNSUPPORTED_VERSION");
    public static final SpdyStreamStatus CANCEL = new SpdyStreamStatus(5, "CANCEL");
    public static final SpdyStreamStatus INTERNAL_ERROR = new SpdyStreamStatus(6, "INTERNAL_ERROR");
    public static final SpdyStreamStatus FLOW_CONTROL_ERROR = new SpdyStreamStatus(7, "FLOW_CONTROL_ERROR");
    public static final SpdyStreamStatus STREAM_IN_USE = new SpdyStreamStatus(8, "STREAM_IN_USE");
    public static final SpdyStreamStatus STREAM_ALREADY_CLOSED = new SpdyStreamStatus(9, "STREAM_ALREADY_CLOSED");
    public static final SpdyStreamStatus INVALID_CREDENTIALS = new SpdyStreamStatus(10, "INVALID_CREDENTIALS");
    public static final SpdyStreamStatus FRAME_TOO_LARGE = new SpdyStreamStatus(11, "FRAME_TOO_LARGE");

    public static SpdyStreamStatus valueOf(int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("0 is not a valid status code for a RST_STREAM");
        }
        switch (i6) {
            case 1:
                return PROTOCOL_ERROR;
            case 2:
                return INVALID_STREAM;
            case 3:
                return REFUSED_STREAM;
            case 4:
                return UNSUPPORTED_VERSION;
            case 5:
                return CANCEL;
            case 6:
                return INTERNAL_ERROR;
            case 7:
                return FLOW_CONTROL_ERROR;
            case 8:
                return STREAM_IN_USE;
            case 9:
                return STREAM_ALREADY_CLOSED;
            case 10:
                return INVALID_CREDENTIALS;
            case 11:
                return FRAME_TOO_LARGE;
            default:
                return new SpdyStreamStatus(i6, "UNKNOWN (" + i6 + ')');
        }
    }

    public int code() {
        return this.code;
    }

    @Override // java.lang.Comparable
    public int compareTo(SpdyStreamStatus spdyStreamStatus) {
        return code() - spdyStreamStatus.code();
    }

    public boolean equals(Object obj) {
        return (obj instanceof SpdyStreamStatus) && code() == ((SpdyStreamStatus) obj).code();
    }

    public String statusPhrase() {
        return this.statusPhrase;
    }

    public SpdyStreamStatus(int i6, String str) {
        if (i6 != 0) {
            if (str != null) {
                this.code = i6;
                this.statusPhrase = str;
                return;
            }
            throw new NullPointerException("statusPhrase");
        }
        throw new IllegalArgumentException("0 is not a valid status code for a RST_STREAM");
    }

    public int hashCode() {
        return code();
    }

    public String toString() {
        return statusPhrase();
    }
}
