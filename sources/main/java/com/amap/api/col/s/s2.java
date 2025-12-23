package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s2 implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f8438f = Charset.forName("US-ASCII");

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f8439a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f8440b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f8441c;

    /* renamed from: d, reason: collision with root package name */
    private int f8442d;

    /* renamed from: e, reason: collision with root package name */
    private int f8443e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends ByteArrayOutputStream {
        a(int i6) {
            super(i6);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i6 = ((ByteArrayOutputStream) this).count;
            if (i6 > 0 && ((ByteArrayOutputStream) this).buf[i6 - 1] == 13) {
                i6--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i6, s2.this.f8440b.name());
            } catch (UnsupportedEncodingException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    public s2(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private s2(InputStream inputStream, Charset charset, byte b6) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(f8438f)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f8439a = inputStream;
        this.f8440b = charset;
        this.f8441c = new byte[8192];
    }

    private void c() throws IOException {
        InputStream inputStream = this.f8439a;
        byte[] bArr = this.f8441c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f8442d = 0;
        this.f8443e = read;
    }

    public final String a() throws IOException {
        int i6;
        byte[] bArr;
        int i7;
        synchronized (this.f8439a) {
            try {
                if (this.f8441c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f8442d >= this.f8443e) {
                    c();
                }
                for (int i8 = this.f8442d; i8 != this.f8443e; i8++) {
                    byte[] bArr2 = this.f8441c;
                    if (bArr2[i8] == 10) {
                        int i9 = this.f8442d;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.f8440b.name());
                                this.f8442d = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.f8440b.name());
                        this.f8442d = i8 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f8443e - this.f8442d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f8441c;
                    int i10 = this.f8442d;
                    aVar.write(bArr3, i10, this.f8443e - i10);
                    this.f8443e = -1;
                    c();
                    i6 = this.f8442d;
                    while (i6 != this.f8443e) {
                        bArr = this.f8441c;
                        if (bArr[i6] == 10) {
                            break loop1;
                        }
                        i6++;
                    }
                }
                int i11 = this.f8442d;
                if (i6 != i11) {
                    aVar.write(bArr, i11, i6 - i11);
                }
                this.f8442d = i6 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f8439a) {
            try {
                if (this.f8441c != null) {
                    this.f8441c = null;
                    this.f8439a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
