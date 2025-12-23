package com.ss.android.socialbase.downloader.ae;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ae implements Closeable {
    private RandomAccessFile cw;

    /* renamed from: j, reason: collision with root package name */
    private BufferedOutputStream f38572j;
    private FileDescriptor xt;

    public void j(byte[] bArr, int i6, int i7) throws IOException {
        this.f38572j.write(bArr, i6, i7);
    }

    public void xt() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f38572j;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.ss.android.socialbase.downloader.az.m.j(this.cw, this.f38572j);
    }

    public void cw() throws IOException {
        FileDescriptor fileDescriptor = this.xt;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void j() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f38572j;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.xt;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public ae(File file, int i6) throws com.ss.android.socialbase.downloader.up.j {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.cw = randomAccessFile;
            this.xt = randomAccessFile.getFD();
            if (i6 > 0) {
                if (i6 < 8192) {
                    i6 = 8192;
                } else if (i6 > 131072) {
                    i6 = 131072;
                }
                this.f38572j = new BufferedOutputStream(new FileOutputStream(this.cw.getFD()), i6);
                return;
            }
            this.f38572j = new BufferedOutputStream(new FileOutputStream(this.cw.getFD()));
        } catch (IOException e6) {
            throw new com.ss.android.socialbase.downloader.up.j(1039, e6);
        }
    }

    public void xt(long j6) throws IOException {
        this.cw.setLength(j6);
    }

    public void j(long j6) throws IOException {
        this.cw.seek(j6);
    }
}
