package com.bykv.vk.component.ttvideo.player;

import java.io.Closeable;
import java.io.IOException;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public interface IMediaDataSource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @Keep
    void close() throws IOException;

    @Keep
    long getSize() throws IOException;

    @Keep
    int readAt(long j6, byte[] bArr, int i6, int i7) throws IOException;
}
