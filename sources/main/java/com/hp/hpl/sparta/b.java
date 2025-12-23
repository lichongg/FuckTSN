package com.hp.hpl.sparta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f32783a;

    /* renamed from: b, reason: collision with root package name */
    private int f32784b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f32785c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32786d = true;

    void e() {
        this.f32786d = false;
    }

    void f() {
        this.f32786d = true;
    }

    private void c(int i6) {
        if (this.f32786d) {
            int[] iArr = this.f32783a;
            int i7 = this.f32784b;
            iArr[i7] = i6;
            this.f32784b = (i7 + 1) % iArr.length;
            this.f32785c++;
        }
    }

    void b(int i6) {
        c(i6 + 65536);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f32783a.length * 11) / 10);
        int i6 = this.f32785c;
        int[] iArr = this.f32783a;
        int length = i6 < iArr.length ? iArr.length - i6 : 0;
        while (true) {
            int[] iArr2 = this.f32783a;
            if (length >= iArr2.length) {
                return stringBuffer.toString();
            }
            int i7 = iArr2[(this.f32784b + length) % iArr2.length];
            if (i7 < 65536) {
                stringBuffer.append((char) i7);
            } else {
                stringBuffer.append(Integer.toString(i7 - 65536));
            }
            length++;
        }
    }

    b(int i6) {
        this.f32783a = new int[i6];
    }

    void a(char c6) {
        c(c6);
    }

    void d(String str) {
        for (char c6 : str.toCharArray()) {
            a(c6);
        }
    }
}
