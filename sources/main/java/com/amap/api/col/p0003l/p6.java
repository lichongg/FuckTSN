package com.amap.api.col.p0003l;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p6 implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f6917f = Charset.forName("US-ASCII");

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f6918a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f6919b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f6920c;

    /* renamed from: d, reason: collision with root package name */
    private int f6921d;

    /* renamed from: e, reason: collision with root package name */
    private int f6922e;

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
                return new String(((ByteArrayOutputStream) this).buf, 0, i6, p6.this.f6919b.name());
            } catch (UnsupportedEncodingException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    public p6(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private p6(InputStream inputStream, Charset charset, byte b6) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(f6917f)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f6918a = inputStream;
        this.f6919b = charset;
        this.f6920c = new byte[8192];
    }

    private void c() throws IOException {
        InputStream inputStream = this.f6918a;
        byte[] bArr = this.f6920c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f6921d = 0;
        this.f6922e = read;
    }

    public final String a() throws IOException {
        int i6;
        byte[] bArr;
        int i7;
        synchronized (this.f6918a) {
            try {
                if (this.f6920c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f6921d >= this.f6922e) {
                    c();
                }
                for (int i8 = this.f6921d; i8 != this.f6922e; i8++) {
                    byte[] bArr2 = this.f6920c;
                    if (bArr2[i8] == 10) {
                        int i9 = this.f6921d;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.f6919b.name());
                                this.f6921d = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.f6919b.name());
                        this.f6921d = i8 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f6922e - this.f6921d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f6920c;
                    int i10 = this.f6921d;
                    aVar.write(bArr3, i10, this.f6922e - i10);
                    this.f6922e = -1;
                    c();
                    i6 = this.f6921d;
                    while (i6 != this.f6922e) {
                        bArr = this.f6920c;
                        if (bArr[i6] == 10) {
                            break loop1;
                        }
                        i6++;
                    }
                }
                int i11 = this.f6921d;
                if (i6 != i11) {
                    aVar.write(bArr, i11, i6 - i11);
                }
                this.f6921d = i6 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f6918a) {
            try {
                if (this.f6920c != null) {
                    this.f6920c = null;
                    this.f6918a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
