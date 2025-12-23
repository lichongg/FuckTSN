package com.bytedance.sdk.component.xt.j.j.xt;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends InputStream {

    /* renamed from: j, reason: collision with root package name */
    InputStream f27292j;
    HttpURLConnection xt;

    @Override // java.io.InputStream
    public synchronized void mark(int i6) {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            inputStream.mark(i6);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            inputStream.close();
            this.f27292j = null;
        }
        HttpURLConnection httpURLConnection = this.xt;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.xt = null;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            return inputStream.skip(j6);
        }
        return 0L;
    }

    public up(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.f27292j = inputStream;
        this.xt = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        InputStream inputStream = this.f27292j;
        if (inputStream != null) {
            return inputStream.read(bArr, i6, i7);
        }
        return 0;
    }
}
