package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i5 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f34408a = {new int[]{1, 1, 1, 1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0, 0, 1, 0}, new int[]{1, 0, 1, 1, 1, 0, 1, 0}, new int[]{1, 0, 1, 1, 1, 0, 1, 0}, new int[]{1, 0, 1, 1, 1, 0, 1, 0}, new int[]{1, 0, 0, 0, 0, 0, 1, 0}, new int[]{1, 1, 1, 1, 1, 1, 1, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 0}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f34409b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    public static s a(s sVar, s sVar2, int i6, double[][] dArr) {
        int i7;
        if (i6 == 21) {
            int i8 = 0;
            for (int i9 = 0; i9 < i6; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    if (i10 >= 8 || i9 >= 8) {
                        int i11 = i6 - 8;
                        if (i10 < i11 || i9 >= 8) {
                            if (i10 >= 8 || i9 < i11) {
                                double[] a6 = a((float) dArr[0][i8], (float) dArr[1][i8]);
                                if (sVar2.b(Math.round((float) a6[0]), Math.round((float) a6[1]))) {
                                    sVar.c(i10, i9);
                                }
                                i8++;
                            } else if (f34408a[i10][(i6 - 1) - i9] == 1) {
                                sVar.c(i10, i9);
                            }
                        } else if (f34408a[i9][(i6 - 1) - i10] == 1) {
                            sVar.c(i10, i9);
                        }
                    } else if (f34408a[i9][i10] == 1) {
                        sVar.c(i10, i9);
                    }
                }
            }
        } else {
            int i12 = 0;
            for (int i13 = 0; i13 < i6; i13++) {
                for (int i14 = 0; i14 < i6; i14++) {
                    if (i14 >= 8 || i13 >= 8) {
                        int i15 = i6 - 8;
                        if (i14 < i15 || i13 >= 8) {
                            if (i14 >= 8 || i13 < i15) {
                                int i16 = i6 - 9;
                                if (i14 < i16 || i14 >= i6 - 4 || i13 < i16 || i13 >= i7) {
                                    double[] a7 = a((float) dArr[0][i12], (float) dArr[1][i12]);
                                    if (sVar2.b(Math.round((float) a7[0]), Math.round((float) a7[1]))) {
                                        sVar.c(i14, i13);
                                    }
                                    i12++;
                                } else {
                                    int i17 = -i16;
                                    if (f34409b[i17 + i13][i17 + i14] == 1) {
                                        sVar.c(i14, i13);
                                    }
                                }
                            } else if (f34408a[i14][(i6 - 1) - i13] == 1) {
                                sVar.c(i14, i13);
                            }
                        } else if (f34408a[i13][(i6 - 1) - i14] == 1) {
                            sVar.c(i14, i13);
                        }
                    } else if (f34408a[i13][i14] == 1) {
                        sVar.c(i14, i13);
                    }
                }
            }
        }
        return sVar;
    }

    public static double[][] a(double d6, double[] dArr, String str) {
        int a6 = a(str);
        String[] split = str.split(";");
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 2, a6);
        int i6 = 0;
        for (int i7 = 0; i7 < split.length; i7++) {
            double[] a7 = a(split[i7].split(","));
            for (int i8 = 0; i8 < a7.length; i8++) {
                int i9 = i7 / 2;
                dArr2[0][i6] = d6 - (dArr[i9] * Math.cos(a7[i8]));
                dArr2[1][i6] = d6 - (dArr[i9] * Math.sin(a7[i8]));
                i6++;
            }
        }
        return dArr2;
    }

    private static double[] a(float f6, float f7) {
        double[] dArr = {0.0d, 0.0d};
        dArr[0] = f6;
        dArr[1] = f7;
        return dArr;
    }

    public static StringBuffer a(double[] dArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (double d6 : dArr) {
            stringBuffer.append(d6);
            stringBuffer.append(",");
        }
        stringBuffer.append(";");
        return stringBuffer;
    }

    private static double[] a(String[] strArr) {
        int length = strArr.length;
        double[] dArr = new double[length];
        for (int i6 = 0; i6 < length; i6++) {
            dArr[i6] = Double.valueOf(strArr[i6]).doubleValue();
        }
        return dArr;
    }

    private static int a(String str) {
        int i6 = 0;
        for (String str2 : str.split(";")) {
            i6 += str2.split(",").length;
        }
        return i6;
    }
}
