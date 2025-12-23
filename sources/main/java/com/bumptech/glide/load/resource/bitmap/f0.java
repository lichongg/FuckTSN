package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f0 extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f15603a;

    /* renamed from: b, reason: collision with root package name */
    private int f15604b;

    /* renamed from: c, reason: collision with root package name */
    private int f15605c;

    /* renamed from: d, reason: collision with root package name */
    private int f15606d;

    /* renamed from: e, reason: collision with root package name */
    private int f15607e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15608f;

    public f0(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(inputStream, bVar, 65536);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f15603a == null || inputStream == null) {
            throw c();
        }
        return (this.f15604b - this.f15607e) + inputStream.available();
    }

    public synchronized void b() {
        this.f15605c = this.f15603a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i6) {
        this.f15605c = Math.max(this.f15605c, i6);
        this.f15606d = this.f15607e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f15603a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw c();
        }
        if (this.f15607e >= this.f15604b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f15603a && (bArr = this.f15603a) == null) {
            throw c();
        }
        int i6 = this.f15604b;
        int i7 = this.f15607e;
        if (i6 - i7 <= 0) {
            return -1;
        }
        this.f15607e = i7 + 1;
        return bArr[i7] & 255;
    }

    public synchronized void release() {
        if (this.f15603a != null) {
            this.f15608f.put(this.f15603a);
            this.f15603a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f15603a == null) {
            throw new IOException("Stream is closed");
        }
        int i6 = this.f15606d;
        if (-1 == i6) {
            throw new a("Mark has been invalidated, pos: " + this.f15607e + " markLimit: " + this.f15605c);
        }
        this.f15607e = i6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j6) throws IOException {
        if (j6 < 1) {
            return 0L;
        }
        byte[] bArr = this.f15603a;
        if (bArr == null) {
            throw c();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw c();
        }
        int i6 = this.f15604b;
        int i7 = this.f15607e;
        if (i6 - i7 >= j6) {
            this.f15607e = (int) (i7 + j6);
            return j6;
        }
        long j7 = i6 - i7;
        this.f15607e = i6;
        if (this.f15606d == -1 || j6 > this.f15605c) {
            long skip = inputStream.skip(j6 - j7);
            if (skip > 0) {
                this.f15606d = -1;
            }
            return j7 + skip;
        }
        if (a(inputStream, bArr) == -1) {
            return j7;
        }
        int i8 = this.f15604b;
        int i9 = this.f15607e;
        if (i8 - i9 >= j6 - j7) {
            this.f15607e = (int) ((i9 + j6) - j7);
            return j6;
        }
        long j8 = (j7 + i8) - i9;
        this.f15607e = i8;
        return j8;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    @VisibleForTesting
    f0(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar, int i6) {
        super(inputStream);
        this.f15606d = -1;
        this.f15608f = bVar;
        this.f15603a = (byte[]) bVar.c(i6, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i6 = this.f15606d;
        if (i6 != -1) {
            int i7 = this.f15607e - i6;
            int i8 = this.f15605c;
            if (i7 < i8) {
                if (i6 == 0 && i8 > bArr.length && this.f15604b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i8) {
                        i8 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f15608f.c(i8, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f15603a = bArr2;
                    this.f15608f.put(bArr);
                    bArr = bArr2;
                } else if (i6 > 0) {
                    System.arraycopy(bArr, i6, bArr, 0, bArr.length - i6);
                }
                int i9 = this.f15607e - this.f15606d;
                this.f15607e = i9;
                this.f15606d = 0;
                this.f15604b = 0;
                int read = inputStream.read(bArr, i9, bArr.length - i9);
                int i10 = this.f15607e;
                if (read > 0) {
                    i10 += read;
                }
                this.f15604b = i10;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f15606d = -1;
            this.f15607e = 0;
            this.f15604b = read2;
        }
        return read2;
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f15603a != null) {
            this.f15608f.put(this.f15603a);
            this.f15603a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        int i9;
        byte[] bArr2 = this.f15603a;
        if (bArr2 == null) {
            throw c();
        }
        if (i7 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i10 = this.f15607e;
            int i11 = this.f15604b;
            if (i10 < i11) {
                int i12 = i11 - i10 >= i7 ? i7 : i11 - i10;
                System.arraycopy(bArr2, i10, bArr, i6, i12);
                this.f15607e += i12;
                if (i12 == i7 || inputStream.available() == 0) {
                    return i12;
                }
                i6 += i12;
                i8 = i7 - i12;
            } else {
                i8 = i7;
            }
            while (true) {
                if (this.f15606d == -1 && i8 >= bArr2.length) {
                    i9 = inputStream.read(bArr, i6, i8);
                    if (i9 == -1) {
                        return i8 != i7 ? i7 - i8 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i8 != i7 ? i7 - i8 : -1;
                    }
                    if (bArr2 != this.f15603a && (bArr2 = this.f15603a) == null) {
                        throw c();
                    }
                    int i13 = this.f15604b;
                    int i14 = this.f15607e;
                    i9 = i13 - i14 >= i8 ? i8 : i13 - i14;
                    System.arraycopy(bArr2, i14, bArr, i6, i9);
                    this.f15607e += i9;
                }
                i8 -= i9;
                if (i8 == 0) {
                    return i7;
                }
                if (inputStream.available() == 0) {
                    return i7 - i8;
                }
                i6 += i9;
            }
        } else {
            throw c();
        }
    }
}
