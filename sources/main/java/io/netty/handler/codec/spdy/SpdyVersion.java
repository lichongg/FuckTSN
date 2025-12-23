package io.netty.handler.codec.spdy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum SpdyVersion {
    SPDY_3_1(3, 1);

    private final int minorVersion;
    private final int version;

    int getMinorVersion() {
        return this.minorVersion;
    }

    int getVersion() {
        return this.version;
    }

    SpdyVersion(int i6, int i7) {
        this.version = i6;
        this.minorVersion = i7;
    }
}
