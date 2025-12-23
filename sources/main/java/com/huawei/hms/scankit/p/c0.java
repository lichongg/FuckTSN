package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f34061a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34062b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34063c;

    public byte a(int i6, int i7) {
        if (w7.a(this.f34061a, i7) && w7.a(this.f34061a[i7], i6)) {
            return this.f34061a[i7][i6];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int b() {
        return this.f34063c;
    }

    public int c() {
        return this.f34062b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f34062b * 2 * this.f34063c) + 2);
        for (int i6 = 0; i6 < this.f34063c; i6++) {
            byte[] bArr = this.f34061a[i6];
            for (int i7 = 0; i7 < this.f34062b; i7++) {
                byte b6 = bArr[i7];
                if (b6 == 0) {
                    sb.append(" 0");
                } else if (b6 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public c0(int i6, int i7) {
        this.f34061a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i7, i6);
        this.f34062b = i6;
        this.f34063c = i7;
    }

    public byte[][] a() {
        return this.f34061a;
    }

    public void a(int i6, int i7, int i8) {
        if (w7.a(this.f34061a, i7) && w7.a(this.f34061a[i7], i6)) {
            this.f34061a[i7][i6] = (byte) i8;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void a(int i6, int i7, boolean z5) {
        if (w7.a(this.f34061a, i7) && w7.a(this.f34061a[i7], i6)) {
            this.f34061a[i7][i6] = z5 ? (byte) 1 : (byte) 0;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void a(byte b6) {
        for (byte[] bArr : this.f34061a) {
            Arrays.fill(bArr, b6);
        }
    }
}
