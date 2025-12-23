package xyz.adscope.common.network.util;

import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LengthOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f56729a = new AtomicLong(0);

    public void write(long j6) {
        this.f56729a.addAndGet(j6);
    }

    public long getLength() {
        return this.f56729a.get();
    }

    @Override // java.io.OutputStream
    public void write(int i6) {
        this.f56729a.addAndGet(1L);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f56729a.addAndGet(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        this.f56729a.addAndGet(i7);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
