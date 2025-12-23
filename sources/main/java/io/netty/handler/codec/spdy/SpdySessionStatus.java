package io.netty.handler.codec.spdy;

import com.baidu.mobads.sdk.internal.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdySessionStatus implements Comparable<SpdySessionStatus> {
    private final int code;
    private final String statusPhrase;
    public static final SpdySessionStatus OK = new SpdySessionStatus(0, ca.f10845k);
    public static final SpdySessionStatus PROTOCOL_ERROR = new SpdySessionStatus(1, "PROTOCOL_ERROR");
    public static final SpdySessionStatus INTERNAL_ERROR = new SpdySessionStatus(2, "INTERNAL_ERROR");

    public static SpdySessionStatus valueOf(int i6) {
        if (i6 == 0) {
            return OK;
        }
        if (i6 == 1) {
            return PROTOCOL_ERROR;
        }
        if (i6 == 2) {
            return INTERNAL_ERROR;
        }
        return new SpdySessionStatus(i6, "UNKNOWN (" + i6 + ')');
    }

    public int code() {
        return this.code;
    }

    @Override // java.lang.Comparable
    public int compareTo(SpdySessionStatus spdySessionStatus) {
        return code() - spdySessionStatus.code();
    }

    public boolean equals(Object obj) {
        return (obj instanceof SpdySessionStatus) && code() == ((SpdySessionStatus) obj).code();
    }

    public String statusPhrase() {
        return this.statusPhrase;
    }

    public SpdySessionStatus(int i6, String str) {
        if (str != null) {
            this.code = i6;
            this.statusPhrase = str;
            return;
        }
        throw new NullPointerException("statusPhrase");
    }

    public int hashCode() {
        return code();
    }

    public String toString() {
        return statusPhrase();
    }
}
