package org.apache.commons.net.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class j extends FilterInputStream {

    /* renamed from: b, reason: collision with root package name */
    private static final int f50856b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f50857c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f50858d = 2;

    /* renamed from: a, reason: collision with root package name */
    private int f50859a;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f50859a == 2) {
            this.f50859a = 0;
            return 10;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != 10) {
            if (read == 13) {
                this.f50859a = 1;
                return 13;
            }
        } else if (this.f50859a != 1) {
            this.f50859a = 2;
            return 13;
        }
        this.f50859a = 0;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int available = ((FilterInputStream) this).in.available();
        return this.f50859a == 2 ? available + 1 : available;
    }

    public j(InputStream inputStream) {
        super(inputStream);
        this.f50859a = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8;
        if (i7 < 1) {
            return 0;
        }
        int available = available();
        if (i7 > available) {
            i7 = available;
        }
        int i9 = i7 >= 1 ? i7 : 1;
        int read = read();
        if (read == -1) {
            return -1;
        }
        int i10 = i6;
        while (true) {
            i8 = i10 + 1;
            bArr[i10] = (byte) read;
            i9--;
            if (i9 <= 0 || (read = read()) == -1) {
                break;
            }
            i10 = i8;
        }
        return i8 - i6;
    }
}
