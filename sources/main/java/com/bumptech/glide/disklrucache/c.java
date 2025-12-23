package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class c implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private static final byte f14777f = 13;

    /* renamed from: g, reason: collision with root package name */
    private static final byte f14778g = 10;

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f14779a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f14780b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f14781c;

    /* renamed from: d, reason: collision with root package name */
    private int f14782d;

    /* renamed from: e, reason: collision with root package name */
    private int f14783e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ByteArrayOutputStream {
        a(int i6) {
            super(i6);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i6 = ((ByteArrayOutputStream) this).count;
            if (i6 > 0 && ((ByteArrayOutputStream) this).buf[i6 - 1] == 13) {
                i6--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i6, c.this.f14780b.name());
            } catch (UnsupportedEncodingException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public c(InputStream inputStream, int i6, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f14785a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f14779a = inputStream;
        this.f14780b = charset;
        this.f14781c = new byte[i6];
    }

    private void b() throws IOException {
        InputStream inputStream = this.f14779a;
        byte[] bArr = this.f14781c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f14782d = 0;
        this.f14783e = read;
    }

    public boolean c() {
        return this.f14783e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f14779a) {
            try {
                if (this.f14781c != null) {
                    this.f14781c = null;
                    this.f14779a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String d() throws IOException {
        int i6;
        byte[] bArr;
        int i7;
        synchronized (this.f14779a) {
            try {
                if (this.f14781c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f14782d >= this.f14783e) {
                    b();
                }
                for (int i8 = this.f14782d; i8 != this.f14783e; i8++) {
                    byte[] bArr2 = this.f14781c;
                    if (bArr2[i8] == 10) {
                        int i9 = this.f14782d;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.f14780b.name());
                                this.f14782d = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.f14780b.name());
                        this.f14782d = i8 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f14783e - this.f14782d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f14781c;
                    int i10 = this.f14782d;
                    aVar.write(bArr3, i10, this.f14783e - i10);
                    this.f14783e = -1;
                    b();
                    i6 = this.f14782d;
                    while (i6 != this.f14783e) {
                        bArr = this.f14781c;
                        if (bArr[i6] == 10) {
                            break loop1;
                        }
                        i6++;
                    }
                }
                int i11 = this.f14782d;
                if (i6 != i11) {
                    aVar.write(bArr, i11, i6 - i11);
                }
                this.f14782d = i6 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
