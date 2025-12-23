package com.kwad.framework.filedownloader.e;

import java.io.Closeable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface a extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j6);

    void setLength(long j6);

    void write(byte[] bArr, int i6, int i7);

    void zw();
}
