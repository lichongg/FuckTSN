package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final int f14934c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f14935d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f14936e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f14937f;

    /* renamed from: a, reason: collision with root package name */
    private final byte f14938a;

    /* renamed from: b, reason: collision with root package name */
    private int f14939b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i6;
        int i7 = this.f14939b;
        int read = (i7 < 2 || i7 > (i6 = f14937f)) ? super.read() : i7 == i6 ? this.f14938a : f14935d[i7 - 2] & 255;
        if (read != -1) {
            this.f14939b++;
        }
        return read;
    }

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f14935d = bArr;
        int length = bArr.length;
        f14936e = length;
        f14937f = length + 2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public g(InputStream inputStream, int i6) {
        super(inputStream);
        if (i6 >= -1 && i6 <= 8) {
            this.f14938a = (byte) i6;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i6);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        long skip = super.skip(j6);
        if (skip > 0) {
            this.f14939b = (int) (this.f14939b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        int i9 = this.f14939b;
        int i10 = f14937f;
        if (i9 > i10) {
            i8 = super.read(bArr, i6, i7);
        } else if (i9 == i10) {
            bArr[i6] = this.f14938a;
            i8 = 1;
        } else if (i9 < 2) {
            i8 = super.read(bArr, i6, 2 - i9);
        } else {
            int min = Math.min(i10 - i9, i7);
            System.arraycopy(f14935d, this.f14939b - 2, bArr, i6, min);
            i8 = min;
        }
        if (i8 > 0) {
            this.f14939b += i8;
        }
        return i8;
    }
}
