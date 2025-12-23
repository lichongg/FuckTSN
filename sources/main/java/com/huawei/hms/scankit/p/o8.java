package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class o8 {
    public static float a(int i6, int i7, u6[] u6VarArr) {
        float abs;
        float abs2;
        float f6 = 1.0f;
        if (u6VarArr.length < 3) {
            return 1.0f;
        }
        int i8 = 0;
        for (u6 u6Var : u6VarArr) {
            if (u6Var.d()) {
                i8++;
            }
        }
        if (r3.f34730a && !r3.f34731b && i8 < 2) {
            return 1.0f;
        }
        float b6 = u6VarArr[0].b();
        float b7 = u6VarArr[1].b();
        float b8 = u6VarArr[2].b();
        float c6 = u6VarArr[0].c();
        float c7 = u6VarArr[1].c();
        float c8 = u6VarArr[2].c();
        u6 a6 = a(b6, c6, b7, c7, b8, c8);
        float b9 = a6.b();
        float c9 = a6.c();
        float max = Math.max(Math.max(Math.max(b6, b7), b8), b9);
        float min = Math.min(Math.min(Math.min(b6, b7), b8), b9);
        float max2 = Math.max(Math.max(Math.max(c6, c7), c8), c9);
        float min2 = Math.min(Math.min(Math.min(c6, c7), c8), c9);
        int min3 = (int) (Math.min(i7, i6) * 0.85f);
        int i9 = (i6 - min3) / 2;
        int i10 = (i7 - min3) / 2;
        Rect rect = new Rect(i9, i10, min3 + i9, min3 + i10);
        if (min < rect.left && min2 < rect.top && max > rect.right && max2 > rect.bottom) {
            return 1.0f;
        }
        float abs3 = Math.abs(min2 - rect.top);
        float abs4 = Math.abs(min - rect.left);
        float abs5 = Math.abs(max - rect.right);
        float abs6 = Math.abs(max2 - rect.bottom);
        float f7 = (rect.left + rect.right) / 2.0f;
        float f8 = (rect.top + rect.bottom) / 2.0f;
        float min4 = Math.min(Math.min(Math.min(abs4, abs5), abs3), abs6);
        if (0.01f > Math.abs(abs4 - min4)) {
            abs = Math.abs(f7 - rect.left) * 1.0f;
            abs2 = Math.abs(f7 - min);
        } else if (0.01f > Math.abs(abs5 - min4)) {
            abs = Math.abs(f7 - rect.right) * 1.0f;
            abs2 = Math.abs(f7 - max);
        } else {
            if (0.01f <= Math.abs(abs3 - min4)) {
                if (0.01f > Math.abs(abs6 - min4)) {
                    abs = Math.abs(f8 - rect.bottom) * 1.0f;
                    abs2 = Math.abs(f8 - max2);
                }
                return Math.min(f6, 2.0f) * 0.9f;
            }
            abs = Math.abs(f8 - rect.top) * 1.0f;
            abs2 = Math.abs(f8 - min2);
        }
        f6 = abs / abs2;
        return Math.min(f6, 2.0f) * 0.9f;
    }

    public static float b(int i6, int i7, u6[] u6VarArr) {
        float abs;
        float abs2;
        float f6 = 1.0f;
        if (u6VarArr.length < 3) {
            return 1.0f;
        }
        float b6 = u6VarArr[0].b();
        float b7 = u6VarArr[1].b();
        float b8 = u6VarArr[2].b();
        float c6 = u6VarArr[0].c();
        float c7 = u6VarArr[1].c();
        float c8 = u6VarArr[2].c();
        float max = Math.max(Math.max(b6, b7), b8);
        float min = Math.min(Math.min(b6, b7), b8);
        float max2 = Math.max(Math.max(c6, c7), c8);
        float min2 = Math.min(Math.min(c6, c7), c8);
        int min3 = (int) (Math.min(i7, i6) * 0.1f);
        Rect rect = new Rect(min3, min3, i6 - min3, i7 - min3);
        if (min < rect.left && min2 < rect.top && max > rect.right && max2 > rect.bottom) {
            return 1.0f;
        }
        float abs3 = Math.abs(max - rect.right);
        float abs4 = Math.abs(max2 - rect.bottom);
        float abs5 = Math.abs(min2 - rect.top);
        float abs6 = Math.abs(min - rect.left);
        float f7 = (rect.left + rect.right) / 2.0f;
        float f8 = (rect.top + rect.bottom) / 2.0f;
        float min4 = Math.min(Math.min(Math.min(abs6, abs3), abs5), abs4);
        if (0.01f > Math.abs(abs6 - min4)) {
            abs = Math.abs(f7 - rect.left);
            abs2 = Math.abs(f7 - min);
        } else if (0.01f > Math.abs(abs3 - min4)) {
            abs = Math.abs(f7 - rect.right);
            abs2 = Math.abs(f7 - max);
        } else {
            if (0.01f <= Math.abs(abs5 - min4)) {
                if (0.01f > Math.abs(abs4 - min4)) {
                    abs = Math.abs(f8 - rect.bottom);
                    abs2 = Math.abs(f8 - max2);
                }
                return Math.min(f6, 2.0f) * 0.9f;
            }
            abs = Math.abs(f8 - rect.top);
            abs2 = Math.abs(f8 - min2);
        }
        f6 = abs / abs2;
        return Math.min(f6, 2.0f) * 0.9f;
    }

    private static u6 a(float f6, float f7, float f8, float f9, float f10, float f11) {
        return new u6((f6 + f10) - f8, (f7 + f11) - f9);
    }
}
