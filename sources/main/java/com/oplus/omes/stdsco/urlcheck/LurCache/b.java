package com.oplus.omes.stdsco.urlcheck.LurCache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class b implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private static final byte f36446f = 13;

    /* renamed from: g, reason: collision with root package name */
    private static final byte f36447g = 10;

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f36448a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f36449b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f36450c;

    /* renamed from: d, reason: collision with root package name */
    private int f36451d;

    /* renamed from: e, reason: collision with root package name */
    private int f36452e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends ByteArrayOutputStream {
        a(int x02) {
            super(x02);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i6 = ((ByteArrayOutputStream) this).count;
            if (i6 > 0 && ((ByteArrayOutputStream) this).buf[i6 - 1] == 13) {
                i6--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i6, b.this.f36449b.name());
            } catch (UnsupportedEncodingException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    public b(InputStream in, Charset charset) {
        this(in, 8192, charset);
    }

    public b(InputStream in, int capacity, Charset charset) {
        if (in == null || charset == null) {
            throw null;
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f36454a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f36448a = in;
        this.f36449b = charset;
        this.f36450c = new byte[capacity];
    }

    private void b() throws IOException {
        InputStream inputStream = this.f36448a;
        byte[] bArr = this.f36450c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f36451d = 0;
        this.f36452e = read;
    }

    public boolean c() {
        return this.f36452e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f36448a) {
            try {
                if (this.f36450c != null) {
                    this.f36450c = null;
                    this.f36448a.close();
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
        synchronized (this.f36448a) {
            try {
                if (this.f36450c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f36451d >= this.f36452e) {
                    b();
                }
                for (int i8 = this.f36451d; i8 != this.f36452e; i8++) {
                    byte[] bArr2 = this.f36450c;
                    if (bArr2[i8] == 10) {
                        int i9 = this.f36451d;
                        if (i8 != i9) {
                            i7 = i8 - 1;
                            if (bArr2[i7] == 13) {
                                String str = new String(bArr2, i9, i7 - i9, this.f36449b.name());
                                this.f36451d = i8 + 1;
                                return str;
                            }
                        }
                        i7 = i8;
                        String str2 = new String(bArr2, i9, i7 - i9, this.f36449b.name());
                        this.f36451d = i8 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f36452e - this.f36451d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f36450c;
                    int i10 = this.f36451d;
                    aVar.write(bArr3, i10, this.f36452e - i10);
                    this.f36452e = -1;
                    b();
                    i6 = this.f36451d;
                    while (i6 != this.f36452e) {
                        bArr = this.f36450c;
                        if (bArr[i6] == 10) {
                            break loop1;
                        }
                        i6++;
                    }
                }
                int i11 = this.f36451d;
                if (i6 != i11) {
                    aVar.write(bArr, i11, i6 - i11);
                }
                this.f36451d = i6 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
