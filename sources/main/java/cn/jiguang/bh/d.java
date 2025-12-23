package cn.jiguang.bh;

import java.security.SecureRandom;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static SecureRandom f2165d = new SecureRandom();

    /* renamed from: a, reason: collision with root package name */
    private int f2166a;

    /* renamed from: b, reason: collision with root package name */
    private int f2167b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f2168c;

    public d() {
        this.f2167b = 256;
        d();
    }

    public int a() {
        int i6;
        int i7 = this.f2166a;
        if (i7 >= 0) {
            return i7;
        }
        synchronized (this) {
            try {
                if (this.f2166a < 0) {
                    this.f2166a = f2165d.nextInt(65535);
                }
                i6 = this.f2166a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i6;
    }

    public int b() {
        return this.f2167b & 15;
    }

    int c() {
        return this.f2167b;
    }

    String d(int i6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + a());
        stringBuffer.append(com.snail.antifake.deviceid.e.f37542d);
        stringBuffer.append("; ");
        for (int i7 = 0; i7 < 4; i7++) {
            stringBuffer.append(n.a(i7) + ": " + c(i7) + " ");
        }
        return stringBuffer.toString();
    }

    public d(int i6) {
        this.f2167b = 256;
        d();
        a(i6);
    }

    private void d() {
        this.f2168c = new int[4];
        this.f2167b = 256;
        this.f2166a = -1;
    }

    public void a(int i6) {
        if (i6 >= 0 && i6 <= 65535) {
            this.f2166a = i6;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i6 + " is out of range");
    }

    void b(int i6) {
        int[] iArr = this.f2168c;
        int i7 = iArr[i6];
        if (i7 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i6] = i7 + 1;
    }

    public int c(int i6) {
        return this.f2168c[i6];
    }

    public Object clone() {
        d dVar = new d();
        dVar.f2166a = this.f2166a;
        dVar.f2167b = this.f2167b;
        int[] iArr = this.f2168c;
        System.arraycopy(iArr, 0, dVar.f2168c, 0, iArr.length);
        return dVar;
    }

    d(b bVar) {
        this(bVar.g());
        this.f2167b = bVar.g();
        int i6 = 0;
        while (true) {
            int[] iArr = this.f2168c;
            if (i6 >= iArr.length) {
                return;
            }
            iArr[i6] = bVar.g();
            i6++;
        }
    }

    void a(c cVar) {
        cVar.c(a());
        cVar.c(this.f2167b);
        int i6 = 0;
        while (true) {
            int[] iArr = this.f2168c;
            if (i6 >= iArr.length) {
                return;
            }
            cVar.c(iArr[i6]);
            i6++;
        }
    }

    public String toString() {
        return d(b());
    }
}
