package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class k7 {
    public static byte[] a(p pVar, Map<l1, Object> map, s6 s6Var, int[] iArr, double[] dArr) throws a {
        if (pVar == null) {
            return null;
        }
        Collection collection = map != null ? (Collection) map.get(l1.f34505c) : null;
        if ((collection != null && !collection.contains(BarcodeFormat.QR_CODE) && !collection.contains(BarcodeFormat.PDF_417)) || s6Var == null || s6Var.k() != null) {
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        if (collection != null) {
            collection.clear();
            l1 l1Var = l1.f34505c;
            map.remove(l1Var);
            collection.add(s6Var.c());
            map.put(l1Var, collection);
        } else if (map != null) {
            l1 l1Var2 = l1.f34505c;
            map.remove(l1Var2);
            Vector vector = new Vector();
            vector.add(s6Var.c());
            map.put(l1Var2, vector);
        }
        float f6 = 3.0f / r3.f34738i;
        if (f6 < 1.0f) {
            f6 = 1.0f;
        }
        dArr[5] = f6;
        return a(pVar, s6Var.j(), dArr, iArr);
    }

    private static byte[] a(p pVar, u6[] u6VarArr, double[] dArr, int[] iArr) throws a {
        if (u6VarArr == null) {
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        int e6 = pVar.e();
        int i6 = e6;
        int c6 = pVar.c();
        int i7 = 0;
        int i8 = 0;
        for (u6 u6Var : u6VarArr) {
            if (u6Var != null) {
                if (((int) u6Var.b()) < i6) {
                    i6 = (int) u6Var.b();
                }
                if (((int) u6Var.c()) < c6) {
                    c6 = (int) u6Var.c();
                }
                if (((int) u6Var.b()) > i7) {
                    i7 = (int) u6Var.b();
                }
                if (((int) u6Var.c()) > i8) {
                    i8 = (int) u6Var.c();
                }
            }
        }
        return a(u6VarArr, pVar, iArr, Math.max(i7 - i6, i8 - c6), dArr);
    }

    private static byte[] a(u6[] u6VarArr, p pVar, int[] iArr, float f6, double[] dArr) throws a {
        float b6 = u6VarArr[0].b();
        float b7 = u6VarArr[1].b();
        float b8 = u6VarArr[2].b();
        float c6 = u6VarArr[0].c();
        float c7 = u6VarArr[1].c();
        float c8 = u6VarArr[2].c();
        if (b6 >= 0.0f && b7 >= 0.0f && b8 >= 0.0f && c6 >= 0.0f && c7 >= 0.0f && c8 >= 0.0f && b6 <= pVar.e() && b7 <= pVar.e() && b8 <= pVar.e() && c6 <= pVar.c() && c7 <= pVar.c() && c8 <= pVar.c()) {
            int i6 = ((int) (c6 + c8)) / 2;
            int i7 = (int) ((((int) (b6 + b8)) / 2) - f6);
            if (i7 < 0) {
                i7 = 0;
            }
            int i8 = (int) (i6 - f6);
            if (i8 < 0) {
                i8 = 0;
            }
            int i9 = ((int) f6) * 2;
            int e6 = i7 + i9 <= pVar.e() ? i9 : pVar.e() - i7;
            if (i8 + i9 > pVar.c()) {
                i9 = pVar.c() - i8;
            }
            p a6 = pVar.a(i7, i8, e6, i9);
            double degrees = dArr[0] + Math.toDegrees(a(u6VarArr[0], u6VarArr[1])) + 90.0d;
            dArr[0] = degrees;
            dArr[1] = i7;
            dArr[2] = i8;
            double d6 = e6;
            dArr[3] = d6;
            double d7 = i9;
            dArr[4] = d7;
            double radians = Math.toRadians(degrees);
            int abs = (int) (((Math.abs(Math.sin(radians)) * d6) + (Math.abs(Math.cos(radians)) * d7)) * dArr[5]);
            int abs2 = (int) (((d7 * Math.abs(Math.sin(radians))) + (d6 * Math.abs(Math.cos(radians)))) * dArr[5]);
            iArr[0] = abs2;
            iArr[1] = abs;
            byte[] imageRotate = LoadOpencvJNIUtil.imageRotate(a6.d(), a6.c(), a6.e(), abs, abs2, (float) dArr[0], dArr[5]);
            if (imageRotate != null) {
                return imageRotate;
            }
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        iArr[0] = pVar.e();
        iArr[1] = pVar.c();
        throw a.a();
    }

    public static double a(u6 u6Var, u6 u6Var2) {
        return Math.atan2(u6Var2.c() - u6Var.c(), u6Var2.b() - u6Var.b());
    }

    public static u6[] a(u6[] u6VarArr, int i6, int i7, double[] dArr) {
        double d6;
        double d7;
        u6[] u6VarArr2 = u6VarArr;
        if (u6VarArr2 == null) {
            return null;
        }
        double d8 = dArr[3];
        double d9 = 0.0d;
        int i8 = d8 != 0.0d ? (int) d8 : i6;
        double d10 = dArr[4];
        int i9 = d10 != 0.0d ? (int) d10 : i7;
        double d11 = dArr[5];
        u6[] u6VarArr3 = new u6[u6VarArr2.length];
        int i10 = 0;
        double radians = Math.toRadians(dArr[0]);
        double cos = Math.cos(radians) * d11;
        double sin = Math.sin(radians) * d11;
        double d12 = i9;
        double d13 = i8;
        double abs = (((Math.abs(sin) - sin) * d12) + ((Math.abs(cos) - cos) * d13)) / 2.0d;
        double d14 = -sin;
        double abs2 = ((d12 * (Math.abs(cos) - cos)) + ((Math.abs(sin) + sin) * d13)) / 2.0d;
        while (i10 < u6VarArr2.length) {
            if (u6VarArr2[i10] != null) {
                d7 = d9;
                d6 = d14;
                double b6 = (((r3.b() - abs) * cos) + ((abs2 - r3.c()) * sin)) / ((cos * cos) - (sin * d6));
                u6VarArr3[i10] = new u6(Math.round(b6) + ((int) dArr[1]), Math.round(sin == d7 ? (r3.c() - abs2) / cos : ((r3.b() - abs) - (cos * b6)) / sin) + ((int) dArr[2]));
            } else {
                d6 = d14;
                d7 = d9;
                u6VarArr3[i10] = null;
            }
            i10++;
            u6VarArr2 = u6VarArr;
            d9 = d7;
            d14 = d6;
        }
        return u6VarArr3;
    }
}
