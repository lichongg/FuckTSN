package com.kwad.sdk.core.imageloader.core.assist;

import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ContentLengthInputStream extends InputStream {
    private final int length;
    private final InputStream stream;

    @Override // java.io.InputStream
    public int read() {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i6) {
        this.stream.mark(i6);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.stream.read(bArr);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return this.stream.skip(j6);
    }

    public ContentLengthInputStream(InputStream inputStream, int i6) {
        this.stream = inputStream;
        this.length = i6;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) {
        return this.stream.read(bArr, i6, i7);
    }
}
