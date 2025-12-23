package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i extends FilterInputStream {

    /* renamed from: b, reason: collision with root package name */
    private static final int f16336b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private static final int f16337c = -1;

    /* renamed from: a, reason: collision with root package name */
    private int f16338a;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i6) {
        super.mark(i6);
        this.f16338a = i6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f16338a = Integer.MIN_VALUE;
    }

    private long a(long j6) {
        int i6 = this.f16338a;
        if (i6 == 0) {
            return -1L;
        }
        return (i6 == Integer.MIN_VALUE || j6 <= ((long) i6)) ? j6 : i6;
    }

    private void b(long j6) {
        int i6 = this.f16338a;
        if (i6 == Integer.MIN_VALUE || j6 == -1) {
            return;
        }
        this.f16338a = (int) (i6 - j6);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i6 = this.f16338a;
        return i6 == Integer.MIN_VALUE ? super.available() : Math.min(i6, super.available());
    }

    public i(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f16338a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        long a6 = a(j6);
        if (a6 == -1) {
            return 0L;
        }
        long skip = super.skip(a6);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i6, int i7) throws IOException {
        int a6 = (int) a(i7);
        if (a6 == -1) {
            return -1;
        }
        int read = super.read(bArr, i6, a6);
        b(read);
        return read;
    }
}
