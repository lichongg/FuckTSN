package xyz.adscope.common.network.util;

import java.io.OutputStream;
import xyz.adscope.common.network.Content;
import xyz.adscope.common.network.ProgressBar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ProgressOutputStream<T extends Content> extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private OutputStream f56732a;

    /* renamed from: b, reason: collision with root package name */
    private T f56733b;

    /* renamed from: c, reason: collision with root package name */
    private ProgressBar<T> f56734c;

    /* renamed from: d, reason: collision with root package name */
    private long f56735d;

    /* renamed from: e, reason: collision with root package name */
    private long f56736e;

    /* renamed from: f, reason: collision with root package name */
    private int f56737f;

    @Override // java.io.OutputStream
    public void write(int i6) {
        this.f56732a.write(i6);
        this.f56736e++;
        a();
    }

    private void a() {
        int i6;
        long j6 = this.f56735d;
        if (j6 <= 0 || (i6 = (int) ((this.f56736e * 100) / j6)) <= this.f56737f || i6 % 2 != 0) {
            return;
        }
        this.f56737f = i6;
        this.f56734c.progress(this.f56733b, i6);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f56732a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f56732a.flush();
    }

    public ProgressOutputStream(OutputStream outputStream, T t5, ProgressBar<T> progressBar) {
        this.f56732a = outputStream;
        this.f56733b = t5;
        this.f56734c = progressBar;
        this.f56735d = t5.contentLength();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f56732a.write(bArr);
        this.f56736e += bArr.length;
        a();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        this.f56732a.write(bArr, i6, i7);
        this.f56736e += i7;
        a();
    }
}
