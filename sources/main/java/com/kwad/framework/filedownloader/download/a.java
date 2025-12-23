package com.kwad.framework.filedownloader.download;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    final long anh;
    final long ani;
    final long anj;
    final long contentLength;

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("range[%d, %d) current offset[%d]", Long.valueOf(this.anh), Long.valueOf(this.anj), Long.valueOf(this.ani));
    }

    a(long j6, long j7, long j8, long j9) {
        this.anh = j6;
        this.ani = j7;
        this.anj = j8;
        this.contentLength = j9;
    }
}
