package org.apache.commons.net.telnet;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class l extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final e f51174a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f51175b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f51176c = false;

    @Override // java.io.OutputStream
    public void write(int i6) throws IOException {
        synchronized (this.f51174a) {
            int i7 = i6 & 255;
            try {
                if (this.f51174a.o0(0)) {
                    if (this.f51176c) {
                        this.f51174a.q0(10);
                        if (i7 == 10) {
                            this.f51176c = false;
                            return;
                        }
                    }
                    if (i7 == 10) {
                        if (!this.f51176c) {
                            this.f51174a.q0(13);
                        }
                        this.f51174a.q0(i7);
                        this.f51176c = false;
                    } else if (i7 == 13) {
                        this.f51174a.q0(13);
                        this.f51176c = true;
                    } else if (i7 != 255) {
                        this.f51174a.q0(i7);
                        this.f51176c = false;
                    } else {
                        this.f51174a.q0(255);
                        this.f51174a.q0(255);
                        this.f51176c = false;
                    }
                } else if (i7 == 255) {
                    this.f51174a.q0(i7);
                    this.f51174a.q0(255);
                } else {
                    this.f51174a.q0(i7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f51174a.R0();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f51174a.S0();
    }

    l(e eVar) {
        this.f51174a = eVar;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        synchronized (this.f51174a) {
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    int i9 = i6 + 1;
                    try {
                        write(bArr[i6]);
                        i6 = i9;
                        i7 = i8;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                throw th;
            }
        }
    }
}
