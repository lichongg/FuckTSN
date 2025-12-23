package com.bytedance.pangle.res.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class oq extends FilterInputStream {
    protected void j(int i6) throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i6) {
        ((FilterInputStream) this).in.mark(i6);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            int read = ((FilterInputStream) this).in.read();
            j(read != -1 ? 1 : -1);
            return read;
        } catch (IOException e6) {
            j(e6);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e6) {
            j(e6);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
        } catch (IOException e6) {
            j(e6);
        }
    }

    protected void j(IOException iOException) throws IOException {
        throw iOException;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        try {
            return ((FilterInputStream) this).in.skip(j6);
        } catch (IOException e6) {
            j(e6);
            return 0L;
        }
    }

    public oq(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e6) {
            j(e6);
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int read = ((FilterInputStream) this).in.read(bArr);
            j(read);
            return read;
        } catch (IOException e6) {
            j(e6);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        try {
            int read = ((FilterInputStream) this).in.read(bArr, i6, i7);
            j(read);
            return read;
        } catch (IOException e6) {
            j(e6);
            return -1;
        }
    }
}
