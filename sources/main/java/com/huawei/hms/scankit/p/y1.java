package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class y1 {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f35028a;

    /* renamed from: b, reason: collision with root package name */
    private final int f35029b;

    /* renamed from: c, reason: collision with root package name */
    private final int f35030c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f35031d;

    private boolean b(int i6, int i7) {
        return this.f35031d[(i7 * this.f35030c) + i6] >= 0;
    }

    public final boolean a(int i6, int i7) {
        return this.f35031d[(i7 * this.f35030c) + i6] == 1;
    }

    private void a(int i6, int i7, boolean z5) {
        this.f35031d[(i7 * this.f35030c) + i6] = z5 ? (byte) 1 : (byte) 0;
    }

    private void b(int i6) {
        a(this.f35029b - 3, 0, i6, 1);
        a(this.f35029b - 2, 0, i6, 2);
        a(this.f35029b - 1, 0, i6, 3);
        a(0, this.f35030c - 4, i6, 4);
        a(0, this.f35030c - 3, i6, 5);
        a(0, this.f35030c - 2, i6, 6);
        a(0, this.f35030c - 1, i6, 7);
        a(1, this.f35030c - 1, i6, 8);
    }

    private void c(int i6) {
        a(this.f35029b - 3, 0, i6, 1);
        a(this.f35029b - 2, 0, i6, 2);
        a(this.f35029b - 1, 0, i6, 3);
        a(0, this.f35030c - 2, i6, 4);
        a(0, this.f35030c - 1, i6, 5);
        a(1, this.f35030c - 1, i6, 6);
        a(2, this.f35030c - 1, i6, 7);
        a(3, this.f35030c - 1, i6, 8);
    }

    private void d(int i6) {
        a(this.f35029b - 1, 0, i6, 1);
        a(this.f35029b - 1, this.f35030c - 1, i6, 2);
        a(0, this.f35030c - 3, i6, 3);
        a(0, this.f35030c - 2, i6, 4);
        a(0, this.f35030c - 1, i6, 5);
        a(1, this.f35030c - 3, i6, 6);
        a(1, this.f35030c - 2, i6, 7);
        a(1, this.f35030c - 1, i6, 8);
    }

    public y1(CharSequence charSequence, int i6, int i7) {
        this.f35028a = charSequence;
        this.f35030c = i6;
        this.f35029b = i7;
        byte[] bArr = new byte[i6 * i7];
        this.f35031d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final void a() {
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 4;
        while (true) {
            if (i10 == this.f35029b && i8 == 0) {
                a(i9);
                i9++;
            }
            if (i10 == this.f35029b - 2 && i8 == 0 && this.f35030c % 4 != 0) {
                b(i9);
                i9++;
            }
            if (i10 == this.f35029b - 2 && i8 == 0 && this.f35030c % 8 == 4) {
                c(i9);
                i9++;
            }
            if (i10 == this.f35029b + 4 && i8 == 2 && this.f35030c % 8 == 0) {
                d(i9);
                i9++;
            }
            while (true) {
                if (i10 < this.f35029b && i8 >= 0 && !b(i8, i10)) {
                    a(i10, i8, i9);
                    i9++;
                }
                int i11 = i10 - 2;
                int i12 = i8 + 2;
                if (i11 < 0 || i12 >= this.f35030c) {
                    break;
                }
                i10 = i11;
                i8 = i12;
            }
            int i13 = i10 - 1;
            int i14 = i8 + 5;
            while (true) {
                if (i13 >= 0 && i14 < this.f35030c && !b(i14, i13)) {
                    a(i13, i14, i9);
                    i9++;
                }
                int i15 = i13 + 2;
                int i16 = i14 - 2;
                i6 = this.f35029b;
                if (i15 >= i6 || i16 < 0) {
                    break;
                }
                i13 = i15;
                i14 = i16;
            }
            i10 = i13 + 5;
            i8 = i14 - 1;
            if (i10 >= i6 && i8 >= (i7 = this.f35030c)) {
                break;
            }
        }
        if (b(i7 - 1, i6 - 1)) {
            return;
        }
        a(this.f35030c - 1, this.f35029b - 1, true);
        a(this.f35030c - 2, this.f35029b - 2, true);
    }

    private void a(int i6, int i7, int i8, int i9) {
        if (i6 < 0) {
            int i10 = this.f35029b;
            i6 += i10;
            i7 += 4 - ((i10 + 4) % 8);
        }
        if (i7 < 0) {
            int i11 = this.f35030c;
            i7 += i11;
            i6 += 4 - ((i11 + 4) % 8);
        }
        a(i7, i6, (this.f35028a.charAt(i8) & (1 << (8 - i9))) != 0);
    }

    private void a(int i6, int i7, int i8) {
        int i9 = i6 - 2;
        int i10 = i7 - 2;
        a(i9, i10, i8, 1);
        int i11 = i7 - 1;
        a(i9, i11, i8, 2);
        int i12 = i6 - 1;
        a(i12, i10, i8, 3);
        a(i12, i11, i8, 4);
        a(i12, i7, i8, 5);
        a(i6, i10, i8, 6);
        a(i6, i11, i8, 7);
        a(i6, i7, i8, 8);
    }

    private void a(int i6) {
        a(this.f35029b - 1, 0, i6, 1);
        a(this.f35029b - 1, 1, i6, 2);
        a(this.f35029b - 1, 2, i6, 3);
        a(0, this.f35030c - 2, i6, 4);
        a(0, this.f35030c - 1, i6, 5);
        a(1, this.f35030c - 1, i6, 6);
        a(2, this.f35030c - 1, i6, 7);
        a(3, this.f35030c - 1, i6, 8);
    }
}
