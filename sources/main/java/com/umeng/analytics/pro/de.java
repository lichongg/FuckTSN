package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class de {
    public abstract int a(byte[] bArr, int i6, int i7) throws df;

    public void a(int i6) {
    }

    public abstract boolean a();

    public abstract void b() throws df;

    public void b(byte[] bArr) throws df {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i6, int i7) throws df;

    public abstract void c();

    public void d() throws df {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public int d(byte[] bArr, int i6, int i7) throws df {
        int i8 = 0;
        while (i8 < i7) {
            int a6 = a(bArr, i6 + i8, i7 - i8);
            if (a6 <= 0) {
                throw new df("Cannot read. Remote side has closed. Tried to read " + i7 + " bytes, but only got " + i8 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i8 += a6;
        }
        return i8;
    }

    public boolean i() {
        return a();
    }
}
