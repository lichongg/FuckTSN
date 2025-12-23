package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final String f16316c = "ContentLengthStream";

    /* renamed from: d, reason: collision with root package name */
    private static final int f16317d = -1;

    /* renamed from: a, reason: collision with root package name */
    private final long f16318a;

    /* renamed from: b, reason: collision with root package name */
    private int f16319b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f16318a - this.f16319b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    private int a(int i6) throws IOException {
        if (i6 >= 0) {
            this.f16319b += i6;
            return i6;
        }
        if (this.f16318a - this.f16319b <= 0) {
            return i6;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.f16318a + ", but read: " + this.f16319b);
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, long j6) {
        return new b(inputStream, j6);
    }

    private b(@NonNull InputStream inputStream, long j6) {
        super(inputStream);
        this.f16318a = j6;
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, @Nullable String str) {
        return b(inputStream, d(str));
    }

    private static int d(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                Log.isLoggable(f16316c, 3);
                return -1;
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i6, int i7) throws IOException {
        return a(super.read(bArr, i6, i7));
    }
}
