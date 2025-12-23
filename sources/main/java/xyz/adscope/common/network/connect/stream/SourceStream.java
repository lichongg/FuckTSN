package xyz.adscope.common.network.connect.stream;

import java.io.InputStream;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SourceStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final Connection f56588a;

    /* renamed from: b, reason: collision with root package name */
    private final InputStream f56589b;

    @Override // java.io.InputStream
    public synchronized void mark(int i6) {
        this.f56589b.mark(i6);
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f56589b.read();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f56589b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f56589b);
        IOUtils.closeQuietly(this.f56588a);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f56589b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.f56589b.read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f56589b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return this.f56589b.skip(j6);
    }

    public SourceStream(Connection connection, InputStream inputStream) {
        this.f56588a = connection;
        this.f56589b = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) {
        return this.f56589b.read(bArr, i6, i7);
    }
}
