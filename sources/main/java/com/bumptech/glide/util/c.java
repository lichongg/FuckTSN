package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public class c extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final Queue<c> f16320c = l.f(0);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f16321a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f16322b;

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f16321a.read(bArr);
        } catch (IOException e6) {
            this.f16322b = e6;
            return -1;
        }
    }

    public void release() {
        this.f16322b = null;
        this.f16321a = null;
        Queue<c> queue = f16320c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f16321a.reset();
    }

    static void a() {
        while (true) {
            Queue<c> queue = f16320c;
            if (queue.isEmpty()) {
                return;
            } else {
                queue.remove();
            }
        }
    }

    @NonNull
    public static c c(@NonNull InputStream inputStream) {
        c poll;
        Queue<c> queue = f16320c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.d(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f16321a.available();
    }

    @Nullable
    public IOException b() {
        return this.f16322b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f16321a.close();
    }

    void d(@NonNull InputStream inputStream) {
        this.f16321a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i6) {
        this.f16321a.mark(i6);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f16321a.markSupported();
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        try {
            return this.f16321a.skip(j6);
        } catch (IOException e6) {
            this.f16322b = e6;
            return 0L;
        }
    }

    c() {
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) {
        try {
            return this.f16321a.read(bArr, i6, i7);
        } catch (IOException e6) {
            this.f16322b = e6;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f16321a.read();
        } catch (IOException e6) {
            this.f16322b = e6;
            return -1;
        }
    }
}
