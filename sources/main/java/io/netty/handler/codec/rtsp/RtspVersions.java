package io.netty.handler.codec.rtsp;

import com.baidu.mobads.sdk.internal.a;
import io.netty.handler.codec.http.HttpVersion;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RtspVersions {
    public static final HttpVersion RTSP_1_0 = new HttpVersion("RTSP", 1, 0, true);

    public static HttpVersion valueOf(String str) {
        if (str == null) {
            throw new NullPointerException(a.f10501b);
        }
        String upperCase = str.trim().toUpperCase();
        return "RTSP/1.0".equals(upperCase) ? RTSP_1_0 : new HttpVersion(upperCase, true);
    }

    private RtspVersions() {
    }
}
