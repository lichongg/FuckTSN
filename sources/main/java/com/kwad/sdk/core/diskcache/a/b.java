package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements Closeable {
    private final Charset aDe;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private b(InputStream inputStream, int i6, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream;
        this.aDe = charset;
        this.buf = new byte[8192];
    }

    private void GO() {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String readLine() {
        int i6;
        byte[] bArr;
        int i7;
        synchronized (this.in) {
            try {
                if (this.buf == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.pos >= this.end) {
                    GO();
                }
                for (int i8 = this.pos; i8 != this.end; i8++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i8] == 10) {
                        int i9 = this.pos;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.aDe.name());
                                this.pos = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.aDe.name());
                        this.pos = i8 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i10 = ((ByteArrayOutputStream) this).count;
                        if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                            i10--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.aDe.name());
                        } catch (UnsupportedEncodingException e6) {
                            throw new AssertionError(e6);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i10 = this.pos;
                    byteArrayOutputStream.write(bArr3, i10, this.end - i10);
                    this.end = -1;
                    GO();
                    i6 = this.pos;
                    while (i6 != this.end) {
                        bArr = this.buf;
                        if (bArr[i6] == 10) {
                            break loop1;
                        }
                        i6++;
                    }
                }
                int i11 = this.pos;
                if (i6 != i11) {
                    byteArrayOutputStream.write(bArr, i11, i6 - i11);
                }
                this.pos = i6 + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
