package com.bytedance.sdk.component.m.cw.j.j;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
class cw implements Closeable {
    private byte[] cw;

    /* renamed from: j, reason: collision with root package name */
    private final InputStream f26550j;

    /* renamed from: r, reason: collision with root package name */
    private int f26551r;
    private int up;
    private final Charset xt;

    public cw(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public cw(InputStream inputStream, int i6, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(r.f26567j)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f26550j = inputStream;
        this.xt = charset;
        this.cw = new byte[i6];
    }

    private void cw() throws IOException {
        InputStream inputStream = this.f26550j;
        byte[] bArr = this.cw;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f26551r = 0;
        this.up = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f26550j) {
            try {
                if (this.cw != null) {
                    this.cw = null;
                    this.f26550j.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String j() throws IOException {
        int i6;
        byte[] bArr;
        int i7;
        synchronized (this.f26550j) {
            try {
                if (this.cw == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f26551r >= this.up) {
                    cw();
                }
                for (int i8 = this.f26551r; i8 != this.up; i8++) {
                    byte[] bArr2 = this.cw;
                    if (bArr2[i8] == 10) {
                        int i9 = this.f26551r;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.xt.name());
                                this.f26551r = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.xt.name());
                        this.f26551r = i8 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.up - this.f26551r) + 80) { // from class: com.bytedance.sdk.component.m.cw.j.j.cw.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i10 = ((ByteArrayOutputStream) this).count;
                        if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                            i10--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i10, cw.this.xt.name());
                        } catch (UnsupportedEncodingException e6) {
                            throw new AssertionError(e6);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.cw;
                    int i10 = this.f26551r;
                    byteArrayOutputStream.write(bArr3, i10, this.up - i10);
                    this.up = -1;
                    cw();
                    i6 = this.f26551r;
                    while (i6 != this.up) {
                        bArr = this.cw;
                        if (bArr[i6] == 10) {
                            break loop1;
                        }
                        i6++;
                    }
                }
                int i11 = this.f26551r;
                if (i6 != i11) {
                    byteArrayOutputStream.write(bArr, i11, i6 - i11);
                }
                this.f26551r = i6 + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean xt() {
        return this.up == -1;
    }
}
