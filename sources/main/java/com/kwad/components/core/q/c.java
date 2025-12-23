package com.kwad.components.core.q;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends InputStream {
    private InputStream XR;
    private int XS;
    private volatile float XU;
    private volatile long XV;
    private int XO = -1;
    private int XP = 10000;
    private long XQ = -1;
    private long XT = -1;
    private int XW = 20480;

    private void sD() {
        this.XO = 0;
        this.XQ = System.currentTimeMillis();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i6) {
        this.XR.mark(i6);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.XR.reset();
    }

    private static long g(long j6, long j7) {
        if (j6 <= 0) {
            return 0L;
        }
        if (j7 <= 0) {
            return -1L;
        }
        return j6 / j7;
    }

    private void sE() {
        if (this.XO < this.XP) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = currentTimeMillis - this.XQ;
        float f6 = this.XO / this.XU;
        this.XV = g(this.XS, currentTimeMillis - this.XT);
        float f7 = j6;
        if (f6 > f7) {
            N((long) (f6 - f7));
        }
        sD();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.XR.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.XR.close();
        b.a(this);
        this.XT = -1L;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.XR.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.XT <= 0) {
            this.XT = System.currentTimeMillis();
        }
        this.XS++;
        if (!b.XM || !b.XL) {
            return this.XR.read();
        }
        if (this.XO < 0) {
            sD();
        }
        int read = this.XR.read();
        this.XO++;
        sE();
        return read;
    }

    public final long sC() {
        return this.XV;
    }

    @Override // java.io.InputStream
    public final long skip(long j6) {
        return this.XR.skip(j6);
    }

    c(@NonNull InputStream inputStream, int i6) {
        i6 = i6 < 20480 ? 20480 : i6;
        this.XR = inputStream;
        this.XU = i6 / 1000.0f;
    }

    @WorkerThread
    private static void N(long j6) {
        try {
            Thread.sleep(j6);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
    }
}
