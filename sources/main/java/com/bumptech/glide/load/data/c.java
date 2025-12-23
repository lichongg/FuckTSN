package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final OutputStream f14927a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f14928b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.b f14929c;

    /* renamed from: d, reason: collision with root package name */
    private int f14930d;

    public c(@NonNull OutputStream outputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @Override // java.io.OutputStream
    public void write(int i6) throws IOException {
        byte[] bArr = this.f14928b;
        int i7 = this.f14930d;
        this.f14930d = i7 + 1;
        bArr[i7] = (byte) i6;
        b();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, int i6) {
        this.f14927a = outputStream;
        this.f14929c = bVar;
        this.f14928b = (byte[]) bVar.c(i6, byte[].class);
    }

    private void a() throws IOException {
        int i6 = this.f14930d;
        if (i6 > 0) {
            this.f14927a.write(this.f14928b, 0, i6);
            this.f14930d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f14930d == this.f14928b.length) {
            a();
        }
    }

    private void release() {
        byte[] bArr = this.f14928b;
        if (bArr != null) {
            this.f14929c.put(bArr);
            this.f14928b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f14927a.close();
            release();
        } catch (Throwable th) {
            this.f14927a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f14927a.flush();
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i6, int i7) throws IOException {
        int i8 = 0;
        do {
            int i9 = i7 - i8;
            int i10 = i6 + i8;
            int i11 = this.f14930d;
            if (i11 == 0 && i9 >= this.f14928b.length) {
                this.f14927a.write(bArr, i10, i9);
                return;
            }
            int min = Math.min(i9, this.f14928b.length - i11);
            System.arraycopy(bArr, i10, this.f14928b, this.f14930d, min);
            this.f14930d += min;
            i8 += min;
            b();
        } while (i8 < i7);
    }
}
