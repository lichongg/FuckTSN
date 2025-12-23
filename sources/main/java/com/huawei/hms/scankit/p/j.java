package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final l[] f34413a;

    /* renamed from: b, reason: collision with root package name */
    private int f34414b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34415c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34416d;

    l a() {
        int i6 = this.f34414b;
        if (i6 >= 0) {
            l[] lVarArr = this.f34413a;
            if (i6 < lVarArr.length) {
                return lVarArr[i6];
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    void b() {
        this.f34414b++;
    }

    j(int i6, int i7) {
        this.f34413a = new l[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            this.f34413a[i8] = new l(((i7 + 4) * 17) + 1);
        }
        this.f34416d = i7 * 17;
        this.f34415c = i6;
        this.f34414b = -1;
    }

    public byte[][] a(int i6, int i7) {
        int i8 = this.f34415c * i7;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i8, this.f34416d * i6);
        for (int i9 = 0; i9 < i8; i9++) {
            bArr[(i8 - i9) - 1] = this.f34413a[i9 / i7].a(i6);
        }
        return bArr;
    }
}
