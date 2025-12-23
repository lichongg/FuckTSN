package com.scwang.smartrefresh.header.storehouse;

import android.util.SparseArray;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<float[]> f37199a = new SparseArray<>();

    static {
        float[][] fArr = {new float[]{24.0f, 0.0f, 1.0f, 22.0f, 1.0f, 22.0f, 1.0f, 72.0f, 24.0f, 0.0f, 47.0f, 22.0f, 47.0f, 22.0f, 47.0f, 72.0f, 1.0f, 48.0f, 47.0f, 48.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 37.0f, 0.0f, 37.0f, 0.0f, 47.0f, 11.0f, 47.0f, 11.0f, 47.0f, 26.0f, 47.0f, 26.0f, 38.0f, 36.0f, 38.0f, 36.0f, 0.0f, 36.0f, 38.0f, 36.0f, 47.0f, 46.0f, 47.0f, 46.0f, 47.0f, 61.0f, 47.0f, 61.0f, 38.0f, 71.0f, 37.0f, 72.0f, 0.0f, 72.0f}, new float[]{47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 24.0f, 0.0f, 24.0f, 0.0f, 47.0f, 22.0f, 47.0f, 22.0f, 47.0f, 48.0f, 47.0f, 48.0f, 23.0f, 72.0f, 23.0f, 72.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 0.0f, 36.0f, 37.0f, 36.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 0.0f, 36.0f, 37.0f, 36.0f}, new float[]{47.0f, 23.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 48.0f, 47.0f, 48.0f, 24.0f, 48.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 24.0f, 0.0f, 24.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{47.0f, 0.0f, 47.0f, 72.0f, 47.0f, 72.0f, 24.0f, 72.0f, 24.0f, 72.0f, 0.0f, 48.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 47.0f, 0.0f, 3.0f, 33.0f, 3.0f, 38.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 24.0f, 23.0f, 24.0f, 23.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 23.0f, 72.0f, 23.0f, 72.0f, 47.0f, 48.0f, 47.0f, 48.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f, 24.0f, 28.0f, 47.0f, 71.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f, 0.0f, 37.0f, 47.0f, 72.0f}, new float[]{47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 36.0f, 47.0f, 72.0f, 47.0f, 72.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 24.0f, 0.0f, 24.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 24.0f, 72.0f, 24.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 24.0f, 49.0f, 24.0f, 49.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 47.0f, 72.0f, 47.0f, 0.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 24.0f, 23.0f, 47.0f, 0.0f, 24.0f, 23.0f, 24.0f, 23.0f, 24.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}};
        float[][] fArr2 = {new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f}, new float[]{24.0f, 0.0f, 24.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f, 0.0f, 36.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 72.0f, 47.0f, 72.0f, 0.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 36.0f, 47.0f, 72.0f, 47.0f, 72.0f, 0.0f, 72.0f, 0.0f, 0.0f, 47.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 36.0f, 47.0f, 36.0f, 0.0f, 36.0f}, new float[]{0.0f, 0.0f, 47.0f, 0.0f, 47.0f, 0.0f, 47.0f, 72.0f}, new float[]{0.0f, 0.0f, 0.0f, 72.0f, 0.0f, 72.0f, 47.0f, 72.0f, 47.0f, 72.0f, 47.0f, 0.0f, 47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 36.0f, 47.0f, 36.0f}, new float[]{47.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 36.0f, 0.0f, 36.0f, 47.0f, 36.0f, 47.0f, 0.0f, 47.0f, 72.0f}};
        for (int i6 = 0; i6 < 26; i6++) {
            f37199a.append(i6 + 65, fArr[i6]);
        }
        for (int i7 = 0; i7 < 26; i7++) {
            f37199a.append(i7 + 97, fArr[i7]);
        }
        for (int i8 = 0; i8 < 10; i8++) {
            f37199a.append(i8 + 48, fArr2[i8]);
        }
        a(' ', new float[0]);
        a('-', new float[]{0.0f, 36.0f, 47.0f, 36.0f});
        a('.', new float[]{24.0f, 60.0f, 24.0f, 72.0f});
    }

    public static void a(char c6, float[] fArr) {
        f37199a.append(c6, fArr);
    }

    public static ArrayList<float[]> b(String str) {
        return c(str, 1.0f, 14);
    }

    public static ArrayList<float[]> c(String str, float f6, int i6) {
        ArrayList<float[]> arrayList = new ArrayList<>();
        float f7 = 0.0f;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char charAt = str.charAt(i7);
            SparseArray<float[]> sparseArray = f37199a;
            if (sparseArray.indexOfKey(charAt) != -1) {
                float[] fArr = sparseArray.get(charAt);
                int length = fArr.length / 4;
                for (int i8 = 0; i8 < length; i8++) {
                    float[] fArr2 = new float[4];
                    for (int i9 = 0; i9 < 4; i9++) {
                        float f8 = fArr[(i8 * 4) + i9];
                        if (i9 % 2 == 0) {
                            fArr2[i9] = (f8 + f7) * f6;
                        } else {
                            fArr2[i9] = f8 * f6;
                        }
                    }
                    arrayList.add(fArr2);
                }
                f7 += i6 + 57;
            }
        }
        return arrayList;
    }
}
