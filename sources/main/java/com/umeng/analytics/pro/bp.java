package com.umeng.analytics.pro;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bp {

    /* renamed from: a, reason: collision with root package name */
    private short[] f41049a;

    /* renamed from: b, reason: collision with root package name */
    private int f41050b = -1;

    public short a() {
        short[] sArr = this.f41049a;
        int i6 = this.f41050b;
        this.f41050b = i6 - 1;
        return sArr[i6];
    }

    public void c() {
        this.f41050b = -1;
    }

    private void d() {
        short[] sArr = this.f41049a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f41049a = sArr2;
    }

    public void a(short s5) {
        if (this.f41049a.length == this.f41050b + 1) {
            d();
        }
        short[] sArr = this.f41049a;
        int i6 = this.f41050b + 1;
        this.f41050b = i6;
        sArr[i6] = s5;
    }

    public short b() {
        return this.f41049a[this.f41050b];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i6 = 0; i6 < this.f41049a.length; i6++) {
            if (i6 != 0) {
                sb.append(" ");
            }
            if (i6 == this.f41050b) {
                sb.append(">>");
            }
            sb.append((int) this.f41049a[i6]);
            if (i6 == this.f41050b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public bp(int i6) {
        this.f41049a = new short[i6];
    }
}
