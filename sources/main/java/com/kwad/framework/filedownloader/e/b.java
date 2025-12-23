package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    private final BufferedOutputStream apy;
    private final RandomAccessFile apz;
    private final FileDescriptor fd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.apy.close();
        this.apz.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j6) {
        this.apz.seek(j6);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j6) {
        this.apz.setLength(j6);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i6, int i7) {
        this.apy.write(bArr, 0, i7);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void zw() {
        this.apy.flush();
        this.fd.sync();
    }

    b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.apz = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.apy = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }
}
