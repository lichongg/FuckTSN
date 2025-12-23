package xyz.adscope.common.network.connect.stream;

import java.io.InputStream;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NullStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final Connection f56587a;

    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f56587a);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return 0;
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return 0L;
    }

    public NullStream(Connection connection) {
        this.f56587a = connection;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) {
        return 0;
    }

    @Override // java.io.InputStream
    public void reset() {
    }

    @Override // java.io.InputStream
    public void mark(int i6) {
    }
}
