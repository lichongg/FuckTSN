package com.bumptech.glide.util;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("POOL")
    private static final Queue<d> f16323c = l.f(0);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f16324a;

    /* renamed from: b, reason: collision with root package name */
    private IOException f16325b;

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f16324a.read();
        } catch (IOException e6) {
            this.f16325b = e6;
            throw e6;
        }
    }

    public void release() {
        this.f16325b = null;
        this.f16324a = null;
        Queue<d> queue = f16323c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f16324a.reset();
    }

    static void a() {
        synchronized (f16323c) {
            while (true) {
                try {
                    Queue<d> queue = f16323c;
                    if (!queue.isEmpty()) {
                        queue.remove();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @NonNull
    public static d c(@NonNull InputStream inputStream) {
        d poll;
        Queue<d> queue = f16323c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.d(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f16324a.available();
    }

    @Nullable
    public IOException b() {
        return this.f16325b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f16324a.close();
    }

    void d(@NonNull InputStream inputStream) {
        this.f16324a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i6) {
        this.f16324a.mark(i6);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f16324a.markSupported();
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        try {
            return this.f16324a.skip(j6);
        } catch (IOException e6) {
            this.f16325b = e6;
            throw e6;
        }
    }

    d() {
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f16324a.read(bArr);
        } catch (IOException e6) {
            this.f16325b = e6;
            throw e6;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        try {
            return this.f16324a.read(bArr, i6, i7);
        } catch (IOException e6) {
            this.f16325b = e6;
            throw e6;
        }
    }
}
