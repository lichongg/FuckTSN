package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class m3 {

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f34551c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{AVMDLDataLoader.KeyIsCacheDirListsStr, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    private final c3 f34552a;

    /* renamed from: b, reason: collision with root package name */
    private final byte f34553b;

    static m3 a(int i6, int i7) {
        m3 b6 = b(i6, i7);
        return b6 != null ? b6 : b(i6 ^ 21522, i7 ^ 21522);
    }

    private static m3 b(int i6, int i7) {
        int c6;
        int i8 = Integer.MAX_VALUE;
        int i9 = 0;
        for (int[] iArr : f34551c) {
            int i10 = iArr[0];
            if (i10 == i6 || i10 == i7) {
                return new m3(iArr[1]);
            }
            int c7 = c(i6, i10);
            if (c7 < i8) {
                i9 = iArr[1];
                i8 = c7;
            }
            if (i7 != i6 && (c6 = c(i7, i10)) < i8) {
                i9 = iArr[1];
                i8 = c6;
            }
        }
        if (i8 <= 3) {
            return new m3(i9);
        }
        return null;
    }

    static int c(int i6, int i7) {
        return Integer.bitCount(i6 ^ i7);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m3)) {
            return false;
        }
        m3 m3Var = (m3) obj;
        return this.f34552a == m3Var.f34552a && this.f34553b == m3Var.f34553b;
    }

    public int hashCode() {
        return (this.f34552a.ordinal() << 3) | this.f34553b;
    }

    private m3(int i6) {
        this.f34552a = c3.a((i6 >> 3) & 3);
        this.f34553b = (byte) (i6 & 7);
    }

    c3 a() {
        return this.f34552a;
    }

    byte b() {
        return this.f34553b;
    }
}
