package com.sun.mail.imap;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class l extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f39371a = 0;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f39372b = new byte[8192];

    /* renamed from: c, reason: collision with root package name */
    private int f39373c;

    @Override // java.io.OutputStream
    public void write(int i6) {
        int i7 = this.f39371a;
        int i8 = i7 + 1;
        byte[] bArr = this.f39372b;
        if (bArr != null) {
            int i9 = this.f39373c;
            if (i8 > i9 && i9 >= 0) {
                this.f39372b = null;
            } else if (i8 > bArr.length) {
                byte[] bArr2 = new byte[Math.max(bArr.length << 1, i8)];
                System.arraycopy(this.f39372b, 0, bArr2, 0, this.f39371a);
                this.f39372b = bArr2;
                bArr2[this.f39371a] = (byte) i6;
            } else {
                bArr[i7] = (byte) i6;
            }
        }
        this.f39371a = i8;
    }

    public byte[] a() {
        return this.f39372b;
    }

    public int b() {
        return this.f39371a;
    }

    public l(int i6) {
        this.f39373c = i6;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) {
        int i8;
        if (i6 < 0 || i6 > bArr.length || i7 < 0 || (i8 = i6 + i7) > bArr.length || i8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i7 == 0) {
            return;
        }
        int i9 = this.f39371a;
        int i10 = i9 + i7;
        byte[] bArr2 = this.f39372b;
        if (bArr2 != null) {
            int i11 = this.f39373c;
            if (i10 > i11 && i11 >= 0) {
                this.f39372b = null;
            } else if (i10 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i10)];
                System.arraycopy(this.f39372b, 0, bArr3, 0, this.f39371a);
                this.f39372b = bArr3;
                System.arraycopy(bArr, i6, bArr3, this.f39371a, i7);
            } else {
                System.arraycopy(bArr, i6, bArr2, i9, i7);
            }
        }
        this.f39371a = i10;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
