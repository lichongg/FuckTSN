package com.hw.videoprocessor.jssrc;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f35439a = 512;

    private void G(int i6, int[] iArr, double[] dArr, int i7) {
        iArr[1] = i6;
        if (i6 > 1) {
            int i8 = i6 >> 1;
            double d6 = i8;
            double d7 = 0.7853981633974483d / d6;
            double cos = Math.cos(d6 * d7);
            dArr[i7] = cos;
            dArr[i7 + i8] = cos * 0.5d;
            for (int i9 = 1; i9 < i8; i9++) {
                double d8 = i9 * d7;
                dArr[i7 + i9] = Math.cos(d8) * 0.5d;
                dArr[(i7 + i6) - i9] = Math.sin(d8) * 0.5d;
            }
        }
    }

    private final void a(int i6, int[] iArr, int i7, double[] dArr) {
        int i8;
        iArr[i7] = 0;
        int i9 = i6;
        int i10 = 1;
        while (true) {
            i8 = i10 << 3;
            if (i8 >= i9) {
                break;
            }
            i9 >>= 1;
            for (int i11 = 0; i11 < i10; i11++) {
                iArr[i7 + i10 + i11] = iArr[i7 + i11] + i9;
            }
            i10 <<= 1;
        }
        int i12 = i10 * 2;
        if (i8 != i9) {
            for (int i13 = 1; i13 < i10; i13++) {
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = (i14 * 2) + iArr[i7 + i13];
                    int i16 = (i13 * 2) + iArr[i7 + i14];
                    double d6 = dArr[i15];
                    int i17 = i15 + 1;
                    double d7 = dArr[i17];
                    double d8 = dArr[i16];
                    int i18 = i16 + 1;
                    double d9 = dArr[i18];
                    dArr[i15] = d8;
                    dArr[i17] = d9;
                    dArr[i16] = d6;
                    dArr[i18] = d7;
                    int i19 = i15 + i12;
                    int i20 = i16 + i12;
                    double d10 = dArr[i19];
                    int i21 = i19 + 1;
                    double d11 = dArr[i21];
                    double d12 = dArr[i20];
                    int i22 = i20 + 1;
                    double d13 = dArr[i22];
                    dArr[i19] = d12;
                    dArr[i21] = d13;
                    dArr[i20] = d10;
                    dArr[i22] = d11;
                }
            }
            return;
        }
        for (int i23 = 0; i23 < i10; i23++) {
            for (int i24 = 0; i24 < i23; i24++) {
                int i25 = (i24 * 2) + iArr[i7 + i23];
                int i26 = (i23 * 2) + iArr[i7 + i24];
                double d14 = dArr[i25];
                int i27 = i25 + 1;
                double d15 = dArr[i27];
                double d16 = dArr[i26];
                int i28 = i26 + 1;
                double d17 = dArr[i28];
                dArr[i25] = d16;
                dArr[i27] = d17;
                dArr[i26] = d14;
                dArr[i28] = d15;
                int i29 = i25 + i12;
                int i30 = i10 * 4;
                int i31 = i26 + i30;
                double d18 = dArr[i29];
                int i32 = i29 + 1;
                double d19 = dArr[i32];
                double d20 = dArr[i31];
                int i33 = i31 + 1;
                double d21 = dArr[i33];
                dArr[i29] = d20;
                dArr[i32] = d21;
                dArr[i31] = d18;
                dArr[i33] = d19;
                int i34 = i29 + i12;
                int i35 = i31 - i12;
                double d22 = dArr[i34];
                int i36 = i34 + 1;
                double d23 = dArr[i36];
                double d24 = dArr[i35];
                int i37 = i35 + 1;
                double d25 = dArr[i37];
                dArr[i34] = d24;
                dArr[i36] = d25;
                dArr[i35] = d22;
                dArr[i37] = d23;
                int i38 = i34 + i12;
                int i39 = i35 + i30;
                double d26 = dArr[i38];
                int i40 = i38 + 1;
                double d27 = dArr[i40];
                double d28 = dArr[i39];
                int i41 = i39 + 1;
                double d29 = dArr[i41];
                dArr[i38] = d28;
                dArr[i40] = d29;
                dArr[i39] = d26;
                dArr[i41] = d27;
            }
            int i42 = (i23 * 2) + i12 + iArr[i7 + i23];
            int i43 = i42 + i12;
            double d30 = dArr[i42];
            int i44 = i42 + 1;
            double d31 = dArr[i44];
            double d32 = dArr[i43];
            int i45 = i43 + 1;
            double d33 = dArr[i45];
            dArr[i42] = d32;
            dArr[i44] = d33;
            dArr[i43] = d30;
            dArr[i45] = d31;
        }
    }

    private void b(double[] dArr) {
        double d6 = dArr[2];
        double d7 = dArr[3];
        double d8 = dArr[6];
        double d9 = dArr[7];
        double d10 = dArr[8];
        double d11 = dArr[9];
        double d12 = dArr[12];
        double d13 = dArr[13];
        dArr[2] = d10;
        dArr[3] = d11;
        dArr[6] = d12;
        dArr[7] = d13;
        dArr[8] = d6;
        dArr[9] = d7;
        dArr[12] = d8;
        dArr[13] = d9;
    }

    private void c(double[] dArr) {
        double d6 = dArr[2];
        double d7 = dArr[3];
        double d8 = dArr[4];
        double d9 = dArr[5];
        double d10 = dArr[6];
        double d11 = dArr[7];
        double d12 = dArr[8];
        double d13 = dArr[9];
        double d14 = dArr[10];
        double d15 = dArr[11];
        double d16 = dArr[12];
        double d17 = dArr[13];
        double d18 = dArr[14];
        double d19 = dArr[15];
        dArr[2] = d18;
        dArr[3] = d19;
        dArr[4] = d10;
        dArr[5] = d11;
        dArr[6] = d14;
        dArr[7] = d15;
        dArr[8] = d6;
        dArr[9] = d7;
        dArr[10] = d16;
        dArr[11] = d17;
        dArr[12] = d8;
        dArr[13] = d9;
        dArr[14] = d12;
        dArr[15] = d13;
    }

    private void d(double[] dArr) {
        double d6 = dArr[2];
        double d7 = dArr[3];
        double d8 = dArr[4];
        double d9 = dArr[5];
        double d10 = dArr[6];
        double d11 = dArr[7];
        double d12 = dArr[8];
        double d13 = dArr[9];
        double d14 = dArr[10];
        double d15 = dArr[11];
        double d16 = dArr[14];
        double d17 = dArr[15];
        double d18 = dArr[16];
        double d19 = dArr[17];
        double d20 = dArr[20];
        double d21 = dArr[21];
        double d22 = dArr[22];
        double d23 = dArr[23];
        double d24 = dArr[24];
        double d25 = dArr[25];
        double d26 = dArr[26];
        double d27 = dArr[27];
        double d28 = dArr[28];
        double d29 = dArr[29];
        dArr[2] = d18;
        dArr[3] = d19;
        dArr[4] = d12;
        dArr[5] = d13;
        dArr[6] = d24;
        dArr[7] = d25;
        dArr[8] = d8;
        dArr[9] = d9;
        dArr[10] = d20;
        dArr[11] = d21;
        dArr[14] = d28;
        dArr[15] = d29;
        dArr[16] = d6;
        dArr[17] = d7;
        dArr[20] = d14;
        dArr[21] = d15;
        dArr[22] = d26;
        dArr[23] = d27;
        dArr[24] = d10;
        dArr[25] = d11;
        dArr[26] = d22;
        dArr[27] = d23;
        dArr[28] = d16;
        dArr[29] = d17;
    }

    private void e(double[] dArr) {
        double d6 = dArr[2];
        double d7 = dArr[3];
        double d8 = dArr[4];
        double d9 = dArr[5];
        double d10 = dArr[6];
        double d11 = dArr[7];
        double d12 = dArr[8];
        double d13 = dArr[9];
        double d14 = dArr[10];
        double d15 = dArr[11];
        double d16 = dArr[12];
        double d17 = dArr[13];
        double d18 = dArr[14];
        double d19 = dArr[15];
        double d20 = dArr[16];
        double d21 = dArr[17];
        double d22 = dArr[18];
        double d23 = dArr[19];
        double d24 = dArr[20];
        double d25 = dArr[21];
        double d26 = dArr[22];
        double d27 = dArr[23];
        double d28 = dArr[24];
        double d29 = dArr[25];
        double d30 = dArr[26];
        double d31 = dArr[27];
        double d32 = dArr[28];
        double d33 = dArr[29];
        double d34 = dArr[30];
        double d35 = dArr[31];
        dArr[2] = d34;
        dArr[3] = d35;
        dArr[4] = d18;
        dArr[5] = d19;
        dArr[6] = d26;
        dArr[7] = d27;
        dArr[8] = d10;
        dArr[9] = d11;
        dArr[10] = d30;
        dArr[11] = d31;
        dArr[12] = d14;
        dArr[13] = d15;
        dArr[14] = d22;
        dArr[15] = d23;
        dArr[16] = d6;
        dArr[17] = d7;
        dArr[18] = d32;
        dArr[19] = d33;
        dArr[20] = d16;
        dArr[21] = d17;
        dArr[22] = d24;
        dArr[23] = d25;
        dArr[24] = d8;
        dArr[25] = d9;
        dArr[26] = d28;
        dArr[27] = d29;
        dArr[28] = d12;
        dArr[29] = d13;
        dArr[30] = d20;
        dArr[31] = d21;
    }

    private final void f(int i6, int[] iArr, int i7, double[] dArr) {
        int i8;
        iArr[i7] = 0;
        int i9 = i6;
        int i10 = 1;
        while (true) {
            i8 = i10 << 3;
            if (i8 >= i9) {
                break;
            }
            i9 >>= 1;
            for (int i11 = 0; i11 < i10; i11++) {
                iArr[i7 + i10 + i11] = iArr[i7 + i11] + i9;
            }
            i10 <<= 1;
        }
        int i12 = i10 * 2;
        if (i8 != i9) {
            dArr[1] = -dArr[1];
            int i13 = i12 + 1;
            dArr[i13] = -dArr[i13];
            for (int i14 = 1; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i14; i15++) {
                    int i16 = (i15 * 2) + iArr[i7 + i14];
                    int i17 = (i14 * 2) + iArr[i7 + i15];
                    double d6 = dArr[i16];
                    int i18 = i16 + 1;
                    double d7 = -dArr[i18];
                    double d8 = dArr[i17];
                    int i19 = i17 + 1;
                    double d9 = -dArr[i19];
                    dArr[i16] = d8;
                    dArr[i18] = d9;
                    dArr[i17] = d6;
                    dArr[i19] = d7;
                    int i20 = i16 + i12;
                    int i21 = i17 + i12;
                    double d10 = dArr[i20];
                    int i22 = i20 + 1;
                    double d11 = -dArr[i22];
                    double d12 = dArr[i21];
                    int i23 = i21 + 1;
                    double d13 = -dArr[i23];
                    dArr[i20] = d12;
                    dArr[i22] = d13;
                    dArr[i21] = d10;
                    dArr[i23] = d11;
                }
                int i24 = (i14 * 2) + iArr[i7 + i14];
                int i25 = i24 + 1;
                dArr[i25] = -dArr[i25];
                int i26 = i24 + i12 + 1;
                dArr[i26] = -dArr[i26];
            }
            return;
        }
        for (int i27 = 0; i27 < i10; i27++) {
            for (int i28 = 0; i28 < i27; i28++) {
                int i29 = (i28 * 2) + iArr[i7 + i27];
                int i30 = (i27 * 2) + iArr[i7 + i28];
                double d14 = dArr[i29];
                int i31 = i29 + 1;
                double d15 = -dArr[i31];
                double d16 = dArr[i30];
                int i32 = i30 + 1;
                double d17 = -dArr[i32];
                dArr[i29] = d16;
                dArr[i31] = d17;
                dArr[i30] = d14;
                dArr[i32] = d15;
                int i33 = i29 + i12;
                int i34 = i10 * 4;
                int i35 = i30 + i34;
                double d18 = dArr[i33];
                int i36 = i33 + 1;
                double d19 = -dArr[i36];
                double d20 = dArr[i35];
                int i37 = i35 + 1;
                double d21 = -dArr[i37];
                dArr[i33] = d20;
                dArr[i36] = d21;
                dArr[i35] = d18;
                dArr[i37] = d19;
                int i38 = i33 + i12;
                int i39 = i35 - i12;
                double d22 = dArr[i38];
                int i40 = i38 + 1;
                double d23 = -dArr[i40];
                double d24 = dArr[i39];
                int i41 = i39 + 1;
                double d25 = -dArr[i41];
                dArr[i38] = d24;
                dArr[i40] = d25;
                dArr[i39] = d22;
                dArr[i41] = d23;
                int i42 = i38 + i12;
                int i43 = i39 + i34;
                double d26 = dArr[i42];
                int i44 = i42 + 1;
                double d27 = -dArr[i44];
                double d28 = dArr[i43];
                int i45 = i43 + 1;
                double d29 = -dArr[i45];
                dArr[i42] = d28;
                dArr[i44] = d29;
                dArr[i43] = d26;
                dArr[i45] = d27;
            }
            int i46 = (i27 * 2) + iArr[i7 + i27];
            int i47 = i46 + 1;
            dArr[i47] = -dArr[i47];
            int i48 = i46 + i12;
            int i49 = i48 + i12;
            double d30 = dArr[i48];
            int i50 = i48 + 1;
            double d31 = -dArr[i50];
            double d32 = dArr[i49];
            int i51 = i49 + 1;
            double d33 = -dArr[i51];
            dArr[i48] = d32;
            dArr[i50] = d33;
            dArr[i49] = d30;
            dArr[i51] = d31;
            int i52 = i49 + i12 + 1;
            dArr[i52] = -dArr[i52];
        }
    }

    private void h(double[] dArr) {
        double d6 = dArr[0];
        double d7 = dArr[4];
        double d8 = d6 + d7;
        double d9 = dArr[1];
        double d10 = dArr[5];
        double d11 = d9 + d10;
        double d12 = d6 - d7;
        double d13 = d9 - d10;
        double d14 = dArr[2];
        double d15 = dArr[6];
        double d16 = d14 + d15;
        double d17 = dArr[3];
        double d18 = dArr[7];
        double d19 = d17 + d18;
        double d20 = d14 - d15;
        double d21 = d17 - d18;
        dArr[0] = d8 + d16;
        dArr[1] = d11 + d19;
        dArr[4] = d8 - d16;
        dArr[5] = d11 - d19;
        dArr[2] = d12 + d21;
        dArr[3] = d13 - d20;
        dArr[6] = d12 - d21;
        dArr[7] = d13 + d20;
    }

    private void m(double[] dArr) {
        double d6 = dArr[0];
        double d7 = dArr[4];
        double d8 = d6 + d7;
        double d9 = dArr[1];
        double d10 = dArr[5];
        double d11 = d9 + d10;
        double d12 = d6 - d7;
        double d13 = d9 - d10;
        double d14 = dArr[2];
        double d15 = dArr[6];
        double d16 = d14 + d15;
        double d17 = dArr[3];
        double d18 = dArr[7];
        double d19 = d17 + d18;
        double d20 = d14 - d15;
        double d21 = d17 - d18;
        dArr[0] = d8 + d16;
        dArr[1] = d11 + d19;
        dArr[4] = d8 - d16;
        dArr[5] = d11 - d19;
        dArr[2] = d12 - d21;
        dArr[3] = d13 + d20;
        dArr[6] = d12 + d21;
        dArr[7] = d13 - d20;
    }

    private void z(double[] dArr) {
        double d6 = dArr[0];
        double d7 = dArr[2];
        double d8 = dArr[1];
        double d9 = dArr[3];
        dArr[0] = d6 + d7;
        dArr[1] = d8 + d9;
        dArr[2] = d6 - d7;
        dArr[3] = d8 - d9;
    }

    public void g(int i6, int i7, double[] dArr, int[] iArr, double[] dArr2) {
        int i8 = iArr[0];
        if (i6 > (i8 << 2)) {
            i8 = i6 >> 2;
            H(i8, iArr, dArr2);
        }
        int i9 = i8;
        if (i7 >= 0) {
            s(i6, dArr, iArr, 2, i9, dArr2);
        } else {
            j(i6, dArr, iArr, 2, i9, dArr2);
        }
    }

    private void A(int i6, double[] dArr, int i7, double[] dArr2, int i8) {
        int i9 = i6 >> 1;
        int i10 = i7 / i6;
        int i11 = 0;
        for (int i12 = 1; i12 < i9; i12++) {
            int i13 = i6 - i12;
            i11 += i10;
            double d6 = dArr2[i8 + i11];
            double d7 = dArr2[(i8 + i7) - i11];
            double d8 = d6 - d7;
            double d9 = d6 + d7;
            double d10 = dArr[i12];
            double d11 = dArr[i13];
            dArr[i12] = (d8 * d10) + (d9 * d11);
            dArr[i13] = (d9 * d10) - (d8 * d11);
        }
        dArr[i9] = dArr[i9] * dArr2[i8];
    }

    private void F(int i6, double[] dArr, int i7, double[] dArr2, int i8) {
        int i9 = i6 >> 1;
        int i10 = i7 / i6;
        int i11 = 0;
        for (int i12 = 1; i12 < i9; i12++) {
            int i13 = i6 - i12;
            i11 += i10;
            double d6 = dArr2[i8 + i11];
            double d7 = dArr2[(i8 + i7) - i11];
            double d8 = d6 - d7;
            double d9 = d6 + d7;
            double d10 = dArr[i13];
            double d11 = dArr[i12];
            dArr[i13] = (d8 * d10) + (d9 * d11);
            dArr[i12] = (d9 * d10) - (d8 * d11);
        }
        dArr[i9] = dArr[i9] * dArr2[i8];
    }

    private void H(int i6, int[] iArr, double[] dArr) {
        int i7 = 0;
        iArr[0] = i6;
        iArr[1] = 1;
        if (i6 > 2) {
            int i8 = i6 >> 1;
            double d6 = i8;
            double d7 = 0.7853981633974483d / d6;
            double cos = Math.cos(d6 * d7);
            dArr[0] = 1.0d;
            dArr[1] = cos;
            if (i8 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d7);
                dArr[3] = 0.5d / Math.cos(6.0d * d7);
            }
            for (int i9 = 4; i9 < i8; i9 += 4) {
                double d8 = i9;
                double d9 = d7 * d8;
                dArr[i9] = Math.cos(d9);
                dArr[i9 + 1] = Math.sin(d9);
                double d10 = 3.0d * d7 * d8;
                dArr[i9 + 2] = Math.cos(d10);
                dArr[i9 + 3] = Math.sin(d10);
            }
            while (i8 > 2) {
                int i10 = i7 + i8;
                i8 >>= 1;
                dArr[i10] = 1.0d;
                dArr[i10 + 1] = cos;
                if (i8 >= 4) {
                    double d11 = dArr[i7 + 4];
                    double d12 = dArr[i7 + 6];
                    dArr[i10 + 2] = 0.5d / d11;
                    dArr[i10 + 3] = 0.5d / d12;
                }
                for (int i11 = 4; i11 < i8; i11 += 4) {
                    int i12 = (i11 * 2) + i7;
                    double d13 = dArr[i12];
                    double d14 = dArr[i12 + 1];
                    double d15 = dArr[i12 + 2];
                    double d16 = dArr[i12 + 3];
                    int i13 = i10 + i11;
                    dArr[i13] = d13;
                    dArr[i13 + 1] = d14;
                    dArr[i13 + 2] = d15;
                    dArr[i13 + 3] = d16;
                }
                i7 = i10;
            }
        }
    }

    private void J(int i6, double[] dArr, int i7, double[] dArr2, int i8) {
        int i9 = i6 >> 1;
        int i10 = (i7 * 2) / i9;
        int i11 = 0;
        for (int i12 = 2; i12 < i9; i12 += 2) {
            int i13 = i6 - i12;
            i11 += i10;
            double d6 = 0.5d - dArr2[(i8 + i7) - i11];
            double d7 = dArr2[i8 + i11];
            double d8 = dArr[i12];
            double d9 = d8 - dArr[i13];
            int i14 = i12 + 1;
            int i15 = i13 + 1;
            double d10 = dArr[i14] + dArr[i15];
            double d11 = (d6 * d9) + (d7 * d10);
            double d12 = (d6 * d10) - (d7 * d9);
            dArr[i12] = d8 - d11;
            dArr[i14] = dArr[i14] - d12;
            dArr[i13] = dArr[i13] + d11;
            dArr[i15] = dArr[i15] - d12;
        }
    }

    private void K(int i6, double[] dArr, int i7, double[] dArr2, int i8) {
        int i9 = i6 >> 1;
        int i10 = (i7 * 2) / i9;
        int i11 = 0;
        for (int i12 = 2; i12 < i9; i12 += 2) {
            int i13 = i6 - i12;
            i11 += i10;
            double d6 = 0.5d - dArr2[(i8 + i7) - i11];
            double d7 = dArr2[i8 + i11];
            double d8 = dArr[i12];
            double d9 = d8 - dArr[i13];
            int i14 = i12 + 1;
            int i15 = i13 + 1;
            double d10 = dArr[i14] + dArr[i15];
            double d11 = (d6 * d9) - (d7 * d10);
            double d12 = (d6 * d10) + (d7 * d9);
            dArr[i12] = d8 - d11;
            dArr[i14] = dArr[i14] - d12;
            dArr[i13] = dArr[i13] + d11;
            dArr[i15] = dArr[i15] - d12;
        }
    }

    private final void i(int i6, double[] dArr, double[] dArr2, int i7) {
        int i8 = i6 >> 3;
        int i9 = i8 * 2;
        int i10 = i9 + i9;
        int i11 = i10 + i9;
        int i12 = 0;
        double d6 = dArr[0];
        double d7 = dArr[i10];
        double d8 = d6 + d7;
        double d9 = dArr[1];
        int i13 = i10 + 1;
        double d10 = dArr[i13];
        double d11 = (-d9) - d10;
        double d12 = d6 - d7;
        double d13 = (-d9) + d10;
        double d14 = dArr[i9];
        double d15 = dArr[i11];
        double d16 = d14 + d15;
        int i14 = i9 + 1;
        double d17 = dArr[i14];
        int i15 = i11 + 1;
        double d18 = dArr[i15];
        double d19 = d17 + d18;
        double d20 = d14 - d15;
        double d21 = d17 - d18;
        dArr[0] = d8 + d16;
        dArr[1] = d11 - d19;
        dArr[i9] = d8 - d16;
        dArr[i14] = d11 + d19;
        dArr[i10] = d12 + d21;
        dArr[i13] = d13 + d20;
        dArr[i11] = d12 - d21;
        dArr[i15] = d13 - d20;
        double d22 = dArr2[i7 + 1];
        double d23 = dArr2[i7 + 2];
        double d24 = dArr2[i7 + 3];
        int i16 = 2;
        double d25 = 1.0d;
        double d26 = 0.0d;
        double d27 = 0.0d;
        double d28 = 1.0d;
        while (true) {
            int i17 = i8;
            int i18 = i17 - 2;
            if (i16 >= i18) {
                int i19 = i9;
                double d29 = d23;
                double d30 = d29 * (d25 + d22);
                double d31 = d29 * (d26 + d22);
                double d32 = (d28 - d22) * d24;
                double d33 = d24 * (d27 - d22);
                int i20 = i17 + i19;
                int i21 = i20 + i19;
                int i22 = i21 + i19;
                double d34 = dArr[i18];
                int i23 = i21 - 2;
                double d35 = dArr[i23];
                double d36 = d34 + d35;
                int i24 = i17 - 1;
                double d37 = dArr[i24];
                int i25 = i21 - 1;
                double d38 = dArr[i25];
                double d39 = (-d37) - d38;
                double d40 = d34 - d35;
                double d41 = (-d37) + d38;
                int i26 = i20 - 2;
                double d42 = dArr[i26];
                int i27 = i22 - 2;
                double d43 = dArr[i27];
                double d44 = d42 + d43;
                int i28 = i20 - 1;
                double d45 = dArr[i28];
                int i29 = i22 - 1;
                double d46 = dArr[i29];
                double d47 = d45 + d46;
                double d48 = d42 - d43;
                double d49 = d45 - d46;
                dArr[i18] = d36 + d44;
                dArr[i24] = d39 - d47;
                dArr[i26] = d36 - d44;
                dArr[i28] = d39 + d47;
                double d50 = d40 + d49;
                double d51 = d41 + d48;
                dArr[i23] = (d30 * d50) - (d31 * d51);
                dArr[i25] = (d30 * d51) + (d50 * d31);
                double d52 = d40 - d49;
                double d53 = d41 - d48;
                dArr[i27] = (d32 * d52) + (d33 * d53);
                dArr[i29] = (d53 * d32) - (d52 * d33);
                double d54 = dArr[i17];
                double d55 = dArr[i21];
                double d56 = d54 + d55;
                int i30 = i17 + 1;
                double d57 = dArr[i30];
                int i31 = i21 + 1;
                double d58 = dArr[i31];
                double d59 = (-d57) - d58;
                double d60 = d54 - d55;
                double d61 = (-d57) + d58;
                double d62 = dArr[i20];
                double d63 = dArr[i22];
                double d64 = d62 + d63;
                int i32 = i20 + 1;
                double d65 = dArr[i32];
                int i33 = i22 + 1;
                double d66 = dArr[i33];
                double d67 = d65 + d66;
                double d68 = d62 - d63;
                double d69 = d65 - d66;
                dArr[i17] = d56 + d64;
                dArr[i30] = d59 - d67;
                dArr[i20] = d56 - d64;
                dArr[i32] = d59 + d67;
                double d70 = d60 + d69;
                double d71 = d61 + d68;
                dArr[i21] = (d70 - d71) * d22;
                dArr[i31] = (d71 + d70) * d22;
                double d72 = d60 - d69;
                double d73 = d61 - d68;
                double d74 = -d22;
                dArr[i22] = (d72 + d73) * d74;
                dArr[i33] = d74 * (d73 - d72);
                int i34 = i17 + 2;
                double d75 = dArr[i34];
                int i35 = i21 + 2;
                double d76 = dArr[i35];
                double d77 = d75 + d76;
                int i36 = i17 + 3;
                double d78 = dArr[i36];
                int i37 = i21 + 3;
                double d79 = dArr[i37];
                double d80 = (-d78) - d79;
                double d81 = d75 - d76;
                double d82 = (-d78) + d79;
                int i38 = i20 + 2;
                double d83 = dArr[i38];
                int i39 = i22 + 2;
                double d84 = dArr[i39];
                double d85 = d83 + d84;
                int i40 = i20 + 3;
                double d86 = dArr[i40];
                int i41 = i22 + 3;
                double d87 = dArr[i41];
                double d88 = d86 + d87;
                double d89 = d83 - d84;
                double d90 = d86 - d87;
                dArr[i34] = d77 + d85;
                dArr[i36] = d80 - d88;
                dArr[i38] = d77 - d85;
                dArr[i40] = d80 + d88;
                double d91 = d81 + d90;
                double d92 = d82 + d89;
                dArr[i35] = (d31 * d91) - (d30 * d92);
                dArr[i37] = (d31 * d92) + (d91 * d30);
                double d93 = d81 - d90;
                double d94 = d82 - d89;
                dArr[i39] = (d33 * d93) + (d32 * d94);
                dArr[i41] = (d33 * d94) - (d32 * d93);
                return;
            }
            int i42 = i12 + 4;
            int i43 = i7 + i42;
            double d95 = dArr2[i43];
            double d96 = (d25 + d95) * d23;
            double d97 = dArr2[i43 + 1];
            double d98 = (d26 + d97) * d23;
            double d99 = dArr2[i43 + 2];
            double d100 = (d28 + d99) * d24;
            int i44 = i9;
            double d101 = dArr2[i43 + 3];
            double d102 = (d27 - d101) * d24;
            double d103 = -d101;
            int i45 = i16 + i44;
            int i46 = i45 + i44;
            int i47 = i46 + i44;
            double d104 = dArr[i16];
            double d105 = dArr[i46];
            double d106 = d104 + d105;
            int i48 = i16 + 1;
            double d107 = dArr[i48];
            double d108 = d23;
            int i49 = i46 + 1;
            double d109 = dArr[i49];
            double d110 = (-d107) - d109;
            double d111 = d104 - d105;
            double d112 = (-d107) + d109;
            int i50 = i16 + 2;
            double d113 = dArr[i50];
            int i51 = i46 + 2;
            double d114 = dArr[i51];
            double d115 = d113 + d114;
            int i52 = i16 + 3;
            double d116 = dArr[i52];
            int i53 = i46 + 3;
            double d117 = dArr[i53];
            double d118 = (-d116) - d117;
            double d119 = d113 - d114;
            double d120 = (-d116) + d117;
            double d121 = dArr[i45];
            double d122 = dArr[i47];
            double d123 = d121 + d122;
            int i54 = i45 + 1;
            double d124 = dArr[i54];
            int i55 = i47 + 1;
            double d125 = dArr[i55];
            double d126 = d124 + d125;
            double d127 = d121 - d122;
            double d128 = d124 - d125;
            int i56 = i45 + 2;
            double d129 = dArr[i56];
            int i57 = i47 + 2;
            double d130 = dArr[i57];
            double d131 = d129 + d130;
            int i58 = i45 + 3;
            double d132 = dArr[i58];
            int i59 = i47 + 3;
            double d133 = dArr[i59];
            double d134 = d132 + d133;
            double d135 = d129 - d130;
            double d136 = d132 - d133;
            dArr[i16] = d106 + d123;
            dArr[i48] = d110 - d126;
            dArr[i50] = d115 + d131;
            dArr[i52] = d118 - d134;
            dArr[i45] = d106 - d123;
            dArr[i54] = d110 + d126;
            dArr[i56] = d115 - d131;
            dArr[i58] = d118 + d134;
            double d137 = d111 + d128;
            double d138 = d112 + d127;
            dArr[i46] = (d96 * d137) - (d98 * d138);
            dArr[i49] = (d138 * d96) + (d137 * d98);
            double d139 = d119 + d136;
            double d140 = d120 + d135;
            dArr[i51] = (d95 * d139) - (d97 * d140);
            dArr[i53] = (d140 * d95) + (d139 * d97);
            double d141 = d111 - d128;
            double d142 = d112 - d127;
            dArr[i47] = (d100 * d141) + (d102 * d142);
            dArr[i55] = (d142 * d100) - (d141 * d102);
            double d143 = d119 - d136;
            double d144 = d120 - d135;
            dArr[i57] = (d99 * d143) + (d103 * d144);
            dArr[i59] = (d144 * d99) - (d103 * d143);
            int i60 = i44 - i16;
            int i61 = i60 + i44;
            int i62 = i61 + i44;
            int i63 = i62 + i44;
            double d145 = dArr[i60];
            double d146 = dArr[i62];
            double d147 = d145 + d146;
            int i64 = i60 + 1;
            double d148 = dArr[i64];
            int i65 = i62 + 1;
            double d149 = dArr[i65];
            double d150 = (-d148) - d149;
            double d151 = d145 - d146;
            double d152 = (-d148) + d149;
            int i66 = i60 - 2;
            double d153 = dArr[i66];
            int i67 = i62 - 2;
            double d154 = dArr[i67];
            double d155 = d153 + d154;
            int i68 = i60 - 1;
            double d156 = dArr[i68];
            int i69 = i62 - 1;
            double d157 = dArr[i69];
            double d158 = (-d156) - d157;
            double d159 = d153 - d154;
            double d160 = (-d156) + d157;
            double d161 = dArr[i61];
            double d162 = dArr[i63];
            double d163 = d161 + d162;
            int i70 = i61 + 1;
            double d164 = dArr[i70];
            int i71 = i63 + 1;
            double d165 = dArr[i71];
            double d166 = d164 + d165;
            double d167 = d161 - d162;
            double d168 = d164 - d165;
            int i72 = i61 - 2;
            double d169 = dArr[i72];
            int i73 = i63 - 2;
            double d170 = dArr[i73];
            double d171 = d169 + d170;
            int i74 = i61 - 1;
            double d172 = dArr[i74];
            int i75 = i63 - 1;
            double d173 = dArr[i75];
            double d174 = d172 + d173;
            double d175 = d169 - d170;
            double d176 = d172 - d173;
            dArr[i60] = d147 + d163;
            dArr[i64] = d150 - d166;
            dArr[i66] = d155 + d171;
            dArr[i68] = d158 - d174;
            dArr[i61] = d147 - d163;
            dArr[i70] = d150 + d166;
            dArr[i72] = d155 - d171;
            dArr[i74] = d158 + d174;
            double d177 = d151 + d168;
            double d178 = d152 + d167;
            dArr[i62] = (d98 * d177) - (d96 * d178);
            dArr[i65] = (d98 * d178) + (d96 * d177);
            double d179 = d159 + d176;
            double d180 = d160 + d175;
            dArr[i67] = (d97 * d179) - (d95 * d180);
            dArr[i69] = (d180 * d97) + (d179 * d95);
            double d181 = d151 - d168;
            double d182 = d152 - d167;
            dArr[i63] = (d102 * d181) + (d100 * d182);
            dArr[i71] = (d102 * d182) - (d100 * d181);
            double d183 = d159 - d176;
            double d184 = d160 - d175;
            dArr[i73] = (d103 * d183) + (d99 * d184);
            dArr[i75] = (d184 * d103) - (d183 * d99);
            i16 += 4;
            i8 = i17;
            i12 = i42;
            d25 = d95;
            d26 = d97;
            d28 = d99;
            i9 = i44;
            d27 = d103;
            d23 = d108;
        }
    }

    private void j(int i6, double[] dArr, int[] iArr, int i7, int i8, double[] dArr2) {
        if (i6 > 32) {
            int i9 = i6 >> 2;
            i(i6, dArr, dArr2, i8 - i9);
            if (i6 > 512) {
                x(i9, dArr, 0, i8, dArr2);
                y(i9, dArr, i9, i8, dArr2);
                x(i9, dArr, i9 * 2, i8, dArr2);
                x(i9, dArr, i9 * 3, i8, dArr2);
            } else if (i9 > 32) {
                k(i6, dArr, 0, i8, dArr2);
            } else {
                t(i6, dArr, 0, i8, dArr2);
            }
            f(i6, iArr, i7, dArr);
            return;
        }
        if (i6 > 8) {
            if (i6 == 32) {
                p(dArr, 0, dArr2, i8 - 8);
                e(dArr);
                return;
            } else {
                n(dArr, 0, dArr2, 0);
                c(dArr);
                return;
            }
        }
        if (i6 == 8) {
            h(dArr);
        } else if (i6 == 4) {
            z(dArr);
        }
    }

    private void k(int i6, double[] dArr, int i7, int i8, double[] dArr2) {
        int i9 = i6 >> 2;
        while (i9 > 128) {
            for (int i10 = i9; i10 < i6; i10 <<= 2) {
                int i11 = i10 - i9;
                while (i11 < i6) {
                    int i12 = i8 - (i9 >> 1);
                    double[] dArr3 = dArr;
                    double[] dArr4 = dArr2;
                    v(i9, dArr3, i7 + i11, dArr4, i12);
                    w(i9, dArr3, i7 + i10 + i11, dArr4, i8 - i9);
                    v(i9, dArr3, (i10 * 2) + i7 + i11, dArr4, i12);
                    i11 += i10 * 4;
                    dArr = dArr3;
                    dArr2 = dArr4;
                }
            }
            double[] dArr5 = dArr;
            v(i9, dArr5, (i7 + i6) - i9, dArr2, i8 - (i9 >> 1));
            i9 >>= 2;
            dArr = dArr5;
        }
        double[] dArr6 = dArr;
        double[] dArr7 = dArr2;
        for (int i13 = i9; i13 < i6; i13 <<= 2) {
            int i14 = i13 - i9;
            while (i14 < i6) {
                int i15 = i7 + i14;
                int i16 = i8 - (i9 >> 1);
                v(i9, dArr6, i15, dArr7, i16);
                double[] dArr8 = dArr7;
                int i17 = i8;
                t(i9, dArr6, i15, i17, dArr8);
                int i18 = i7 + i13 + i14;
                w(i9, dArr6, i18, dArr8, i17 - i9);
                u(i9, dArr6, i18, i17, dArr8);
                int i19 = (i13 * 2) + i7 + i14;
                v(i9, dArr6, i19, dArr8, i16);
                t(i9, dArr6, i19, i17, dArr8);
                dArr7 = dArr8;
                i14 += i13 * 4;
                i8 = i17;
            }
        }
        int i20 = i8;
        int i21 = (i7 + i6) - i9;
        v(i9, dArr6, i21, dArr7, i20 - (i9 >> 1));
        t(i9, dArr6, i21, i20, dArr7);
    }

    private void l(int i6, double[] dArr, int i7, int i8, double[] dArr2) {
        int i9 = i6 >> 1;
        int i10 = i6 >> 2;
        while (i10 > 128) {
            int i11 = i10;
            while (i11 < i9) {
                int i12 = i11 - i10;
                while (i12 < i9) {
                    int i13 = i8 - (i10 >> 1);
                    double[] dArr3 = dArr;
                    double[] dArr4 = dArr2;
                    v(i10, dArr3, i7 + i12, dArr4, i13);
                    v(i10, dArr3, i7 + i9 + i12, dArr4, i13);
                    i12 += i11 * 2;
                    dArr = dArr3;
                }
                double[] dArr5 = dArr;
                double[] dArr6 = dArr2;
                for (int i14 = (i11 * 2) - i10; i14 < i9; i14 += i11 * 4) {
                    int i15 = i8 - i10;
                    w(i10, dArr5, i7 + i14, dArr6, i15);
                    w(i10, dArr5, i7 + i9 + i14, dArr6, i15);
                }
                i11 <<= 2;
                dArr = dArr5;
                dArr2 = dArr6;
            }
            i10 >>= 2;
        }
        double[] dArr7 = dArr;
        double[] dArr8 = dArr2;
        int i16 = i10;
        while (i16 < i9) {
            int i17 = i16 - i10;
            while (i17 < i9) {
                int i18 = i7 + i17;
                int i19 = i8 - (i10 >> 1);
                v(i10, dArr7, i18, dArr8, i19);
                double[] dArr9 = dArr8;
                int i20 = i8;
                t(i10, dArr7, i18, i20, dArr9);
                int i21 = i7 + i9 + i17;
                v(i10, dArr7, i21, dArr9, i19);
                t(i10, dArr7, i21, i20, dArr9);
                dArr8 = dArr9;
                i17 += i16 * 2;
                i8 = i20;
            }
            int i22 = i8;
            int i23 = (i16 * 2) - i10;
            while (i23 < i9) {
                int i24 = i7 + i23;
                int i25 = i22 - i10;
                w(i10, dArr7, i24, dArr8, i25);
                double[] dArr10 = dArr8;
                u(i10, dArr7, i24, i22, dArr10);
                int i26 = i7 + i9 + i23;
                w(i10, dArr7, i26, dArr10, i25);
                u(i10, dArr7, i26, i22, dArr10);
                i23 += i16 * 4;
                dArr8 = dArr10;
            }
            i16 <<= 2;
            i8 = i22;
            dArr8 = dArr8;
        }
    }

    private void n(double[] dArr, int i6, double[] dArr2, int i7) {
        double d6 = dArr2[i7 + 1];
        double d7 = dArr[i6];
        int i8 = i6 + 8;
        double d8 = dArr[i8];
        double d9 = d7 + d8;
        int i9 = i6 + 1;
        double d10 = dArr[i9];
        int i10 = i6 + 9;
        double d11 = dArr[i10];
        double d12 = d10 + d11;
        double d13 = d7 - d8;
        double d14 = d10 - d11;
        int i11 = i6 + 4;
        double d15 = dArr[i11];
        int i12 = i6 + 12;
        double d16 = dArr[i12];
        double d17 = d15 + d16;
        int i13 = i6 + 5;
        double d18 = dArr[i13];
        int i14 = i6 + 13;
        double d19 = dArr[i14];
        double d20 = d18 + d19;
        double d21 = d15 - d16;
        double d22 = d18 - d19;
        double d23 = d9 + d17;
        double d24 = d12 + d20;
        double d25 = d9 - d17;
        double d26 = d12 - d20;
        double d27 = d13 - d22;
        double d28 = d14 + d21;
        double d29 = d13 + d22;
        double d30 = d14 - d21;
        int i15 = i6 + 2;
        double d31 = dArr[i15];
        int i16 = i6 + 10;
        double d32 = dArr[i16];
        double d33 = d31 + d32;
        int i17 = i6 + 3;
        double d34 = dArr[i17];
        int i18 = i6 + 11;
        double d35 = dArr[i18];
        double d36 = d34 + d35;
        double d37 = d31 - d32;
        double d38 = d34 - d35;
        int i19 = i6 + 6;
        double d39 = dArr[i19];
        int i20 = i6 + 14;
        double d40 = dArr[i20];
        double d41 = d39 + d40;
        int i21 = i6 + 7;
        double d42 = dArr[i21];
        int i22 = i6 + 15;
        double d43 = dArr[i22];
        double d44 = d42 + d43;
        double d45 = d39 - d40;
        double d46 = d42 - d43;
        double d47 = d33 + d41;
        double d48 = d36 + d44;
        double d49 = d33 - d41;
        double d50 = d36 - d44;
        double d51 = d37 - d46;
        double d52 = d38 + d45;
        double d53 = d37 + d46;
        double d54 = d38 - d45;
        double d55 = (d51 - d52) * d6;
        double d56 = (d51 + d52) * d6;
        double d57 = (d53 - d54) * d6;
        double d58 = d6 * (d53 + d54);
        dArr[i8] = d27 + d55;
        dArr[i10] = d28 + d56;
        dArr[i16] = d27 - d55;
        dArr[i18] = d28 - d56;
        dArr[i12] = d29 - d58;
        dArr[i14] = d30 + d57;
        dArr[i20] = d29 + d58;
        dArr[i22] = d30 - d57;
        dArr[i6] = d23 + d47;
        dArr[i9] = d24 + d48;
        dArr[i15] = d23 - d47;
        dArr[i17] = d24 - d48;
        dArr[i11] = d25 - d50;
        dArr[i13] = d26 + d49;
        dArr[i19] = d25 + d50;
        dArr[i21] = d26 - d49;
    }

    private void o(double[] dArr, int i6, double[] dArr2, int i7) {
        double d6 = dArr2[i7 + 1];
        double d7 = dArr2[i7 + 4];
        double d8 = dArr2[i7 + 5];
        double d9 = dArr[i6];
        int i8 = i6 + 9;
        double d10 = dArr[i8];
        double d11 = d9 - d10;
        int i9 = i6 + 1;
        double d12 = dArr[i9];
        int i10 = i6 + 8;
        double d13 = dArr[i10];
        double d14 = d12 + d13;
        double d15 = d9 + d10;
        double d16 = d12 - d13;
        int i11 = i6 + 4;
        double d17 = dArr[i11];
        int i12 = i6 + 13;
        double d18 = dArr[i12];
        double d19 = d17 - d18;
        int i13 = i6 + 5;
        double d20 = dArr[i13];
        int i14 = i6 + 12;
        double d21 = dArr[i14];
        double d22 = d20 + d21;
        double d23 = (d19 - d22) * d6;
        double d24 = (d22 + d19) * d6;
        double d25 = d17 + d18;
        double d26 = d20 - d21;
        double d27 = (d25 - d26) * d6;
        double d28 = d6 * (d26 + d25);
        int i15 = i6 + 2;
        double d29 = dArr[i15];
        int i16 = i6 + 11;
        double d30 = dArr[i16];
        double d31 = d29 - d30;
        int i17 = i6 + 3;
        double d32 = dArr[i17];
        int i18 = i6 + 10;
        double d33 = dArr[i18];
        double d34 = d32 + d33;
        double d35 = (d7 * d31) - (d8 * d34);
        double d36 = (d34 * d7) + (d31 * d8);
        double d37 = d29 + d30;
        double d38 = d32 - d33;
        double d39 = (d8 * d37) - (d7 * d38);
        double d40 = (d38 * d8) + (d37 * d7);
        int i19 = i6 + 6;
        double d41 = dArr[i19];
        int i20 = i6 + 15;
        double d42 = dArr[i20];
        double d43 = d41 - d42;
        int i21 = i6 + 7;
        double d44 = dArr[i21];
        int i22 = i6 + 14;
        double d45 = dArr[i22];
        double d46 = d44 + d45;
        double d47 = (d8 * d43) - (d7 * d46);
        double d48 = (d46 * d8) + (d43 * d7);
        double d49 = d41 + d42;
        double d50 = d44 - d45;
        double d51 = (d7 * d49) - (d8 * d50);
        double d52 = (d7 * d50) + (d8 * d49);
        double d53 = d11 + d23;
        double d54 = d14 + d24;
        double d55 = d35 + d47;
        double d56 = d36 + d48;
        dArr[i6] = d53 + d55;
        dArr[i9] = d54 + d56;
        dArr[i15] = d53 - d55;
        dArr[i17] = d54 - d56;
        double d57 = d11 - d23;
        double d58 = d14 - d24;
        double d59 = d35 - d47;
        double d60 = d36 - d48;
        dArr[i11] = d57 - d60;
        dArr[i13] = d58 + d59;
        dArr[i19] = d57 + d60;
        dArr[i21] = d58 - d59;
        double d61 = d15 - d28;
        double d62 = d16 + d27;
        double d63 = d39 - d51;
        double d64 = d40 - d52;
        dArr[i10] = d61 + d63;
        dArr[i8] = d62 + d64;
        dArr[i18] = d61 - d63;
        dArr[i16] = d62 - d64;
        double d65 = d15 + d28;
        double d66 = d16 - d27;
        double d67 = d39 + d51;
        double d68 = d40 + d52;
        dArr[i14] = d65 - d68;
        dArr[i12] = d66 + d67;
        dArr[i22] = d65 + d68;
        dArr[i20] = d66 - d67;
    }

    private void p(double[] dArr, int i6, double[] dArr2, int i7) {
        double d6 = dArr2[i7 + 1];
        double d7 = dArr2[i7 + 2];
        double d8 = d6 * d7;
        double d9 = d7 + d8;
        double d10 = dArr[i6];
        int i8 = i6 + 16;
        double d11 = dArr[i8];
        double d12 = d10 + d11;
        int i9 = i6 + 1;
        double d13 = dArr[i9];
        int i10 = i6 + 17;
        double d14 = dArr[i10];
        double d15 = d13 + d14;
        double d16 = d10 - d11;
        double d17 = d13 - d14;
        int i11 = i6 + 8;
        double d18 = dArr[i11];
        int i12 = i6 + 24;
        double d19 = dArr[i12];
        double d20 = d18 + d19;
        int i13 = i6 + 9;
        double d21 = dArr[i13];
        int i14 = i6 + 25;
        double d22 = dArr[i14];
        double d23 = d21 + d22;
        double d24 = d18 - d19;
        double d25 = d21 - d22;
        double d26 = d12 + d20;
        double d27 = d15 + d23;
        double d28 = d12 - d20;
        double d29 = d15 - d23;
        double d30 = d16 - d25;
        double d31 = d17 + d24;
        double d32 = d16 + d25;
        double d33 = d17 - d24;
        int i15 = i6 + 2;
        double d34 = dArr[i15];
        int i16 = i6 + 18;
        double d35 = dArr[i16];
        double d36 = d34 + d35;
        int i17 = i6 + 3;
        double d37 = dArr[i17];
        int i18 = i6 + 19;
        double d38 = dArr[i18];
        double d39 = d37 + d38;
        double d40 = d34 - d35;
        double d41 = d37 - d38;
        int i19 = i6 + 10;
        double d42 = dArr[i19];
        int i20 = i6 + 26;
        double d43 = dArr[i20];
        double d44 = d42 + d43;
        int i21 = i6 + 11;
        double d45 = dArr[i21];
        int i22 = i6 + 27;
        double d46 = dArr[i22];
        double d47 = d45 + d46;
        double d48 = d42 - d43;
        double d49 = d45 - d46;
        double d50 = d36 + d44;
        double d51 = d39 + d47;
        double d52 = d36 - d44;
        double d53 = d39 - d47;
        double d54 = d40 - d49;
        double d55 = d41 + d48;
        double d56 = (d9 * d54) - (d8 * d55);
        double d57 = (d55 * d9) + (d54 * d8);
        double d58 = d40 + d49;
        double d59 = d41 - d48;
        double d60 = (d8 * d58) - (d9 * d59);
        double d61 = (d59 * d8) + (d58 * d9);
        int i23 = i6 + 4;
        double d62 = dArr[i23];
        int i24 = i6 + 20;
        double d63 = dArr[i24];
        double d64 = d62 + d63;
        int i25 = i6 + 5;
        double d65 = dArr[i25];
        int i26 = i6 + 21;
        double d66 = dArr[i26];
        double d67 = d65 + d66;
        double d68 = d62 - d63;
        double d69 = d65 - d66;
        int i27 = i6 + 12;
        double d70 = dArr[i27];
        int i28 = i6 + 28;
        double d71 = dArr[i28];
        double d72 = d70 + d71;
        int i29 = i6 + 13;
        double d73 = dArr[i29];
        int i30 = i6 + 29;
        double d74 = dArr[i30];
        double d75 = d73 + d74;
        double d76 = d70 - d71;
        double d77 = d73 - d74;
        double d78 = d64 + d72;
        double d79 = d67 + d75;
        double d80 = d64 - d72;
        double d81 = d67 - d75;
        double d82 = d68 - d77;
        double d83 = d69 + d76;
        double d84 = (d82 - d83) * d6;
        double d85 = (d83 + d82) * d6;
        double d86 = d68 + d77;
        double d87 = d69 - d76;
        double d88 = (d86 + d87) * d6;
        double d89 = (d87 - d86) * d6;
        int i31 = i6 + 6;
        double d90 = dArr[i31];
        int i32 = i6 + 22;
        double d91 = dArr[i32];
        double d92 = d90 + d91;
        int i33 = i6 + 7;
        double d93 = dArr[i33];
        int i34 = i6 + 23;
        double d94 = dArr[i34];
        double d95 = d93 + d94;
        double d96 = d90 - d91;
        double d97 = d93 - d94;
        int i35 = i6 + 14;
        double d98 = dArr[i35];
        int i36 = i6 + 30;
        double d99 = dArr[i36];
        double d100 = d98 + d99;
        int i37 = i6 + 15;
        double d101 = dArr[i37];
        int i38 = i6 + 31;
        double d102 = dArr[i38];
        double d103 = d101 + d102;
        double d104 = d98 - d99;
        double d105 = d101 - d102;
        double d106 = d92 + d100;
        double d107 = d95 + d103;
        double d108 = d92 - d100;
        double d109 = d95 - d103;
        double d110 = d96 - d105;
        double d111 = d97 + d104;
        double d112 = (d8 * d110) - (d9 * d111);
        double d113 = (d111 * d8) + (d110 * d9);
        double d114 = d96 + d105;
        double d115 = d97 - d104;
        double d116 = (d9 * d114) - (d8 * d115);
        double d117 = (d9 * d115) + (d8 * d114);
        double d118 = d32 - d88;
        double d119 = d33 - d89;
        double d120 = d32 + d88;
        double d121 = d33 + d89;
        double d122 = d60 - d116;
        double d123 = d61 - d117;
        double d124 = d60 + d116;
        double d125 = d61 + d117;
        dArr[i12] = d118 + d122;
        dArr[i14] = d119 + d123;
        dArr[i20] = d118 - d122;
        dArr[i22] = d119 - d123;
        dArr[i28] = d120 - d125;
        dArr[i30] = d121 + d124;
        dArr[i36] = d120 + d125;
        dArr[i38] = d121 - d124;
        double d126 = d30 + d84;
        double d127 = d31 + d85;
        double d128 = d30 - d84;
        double d129 = d31 - d85;
        double d130 = d56 + d112;
        double d131 = d57 + d113;
        double d132 = d56 - d112;
        double d133 = d57 - d113;
        dArr[i8] = d126 + d130;
        dArr[i10] = d127 + d131;
        dArr[i16] = d126 - d130;
        dArr[i18] = d127 - d131;
        dArr[i24] = d128 - d133;
        dArr[i26] = d129 + d132;
        dArr[i32] = d128 + d133;
        dArr[i34] = d129 - d132;
        double d134 = d52 - d109;
        double d135 = d53 + d108;
        double d136 = (d134 - d135) * d6;
        double d137 = (d135 + d134) * d6;
        double d138 = d52 + d109;
        double d139 = d53 - d108;
        double d140 = (d138 - d139) * d6;
        double d141 = d6 * (d139 + d138);
        double d142 = d28 - d81;
        double d143 = d29 + d80;
        double d144 = d28 + d81;
        double d145 = d29 - d80;
        dArr[i11] = d142 + d136;
        dArr[i13] = d143 + d137;
        dArr[i19] = d142 - d136;
        dArr[i21] = d143 - d137;
        dArr[i27] = d144 - d141;
        dArr[i29] = d145 + d140;
        dArr[i35] = d144 + d141;
        dArr[i37] = d145 - d140;
        double d146 = d26 + d78;
        double d147 = d27 + d79;
        double d148 = d26 - d78;
        double d149 = d27 - d79;
        double d150 = d50 + d106;
        double d151 = d51 + d107;
        double d152 = d50 - d106;
        double d153 = d51 - d107;
        dArr[i6] = d146 + d150;
        dArr[i9] = d147 + d151;
        dArr[i15] = d146 - d150;
        dArr[i17] = d147 - d151;
        dArr[i23] = d148 - d153;
        dArr[i25] = d149 + d152;
        dArr[i31] = d148 + d153;
        dArr[i33] = d149 - d152;
    }

    private void q(double[] dArr, int i6, double[] dArr2, int i7) {
        double d6 = dArr2[i7 + 1];
        double d7 = dArr2[i7 + 4];
        double d8 = dArr2[i7 + 5];
        double d9 = dArr2[i7 + 6];
        double d10 = dArr2[i7 + 7];
        double d11 = dArr2[i7 + 8];
        double d12 = dArr2[i7 + 9];
        double d13 = dArr[i6];
        int i8 = i6 + 17;
        double d14 = dArr[i8];
        double d15 = d13 - d14;
        int i9 = i6 + 1;
        double d16 = dArr[i9];
        int i10 = i6 + 16;
        double d17 = dArr[i10];
        double d18 = d16 + d17;
        int i11 = i6 + 8;
        double d19 = dArr[i11];
        int i12 = i6 + 25;
        double d20 = dArr[i12];
        double d21 = d19 - d20;
        int i13 = i6 + 9;
        double d22 = dArr[i13];
        int i14 = i6 + 24;
        double d23 = dArr[i14];
        double d24 = d22 + d23;
        double d25 = (d21 - d24) * d6;
        double d26 = (d24 + d21) * d6;
        double d27 = d15 + d25;
        double d28 = d18 + d26;
        double d29 = d15 - d25;
        double d30 = d18 - d26;
        double d31 = d13 + d14;
        double d32 = d16 - d17;
        double d33 = d19 + d20;
        double d34 = d22 - d23;
        double d35 = (d33 - d34) * d6;
        double d36 = (d34 + d33) * d6;
        double d37 = d31 - d36;
        double d38 = d32 + d35;
        double d39 = d31 + d36;
        double d40 = d32 - d35;
        int i15 = i6 + 2;
        double d41 = dArr[i15];
        int i16 = i6 + 19;
        double d42 = dArr[i16];
        double d43 = d41 - d42;
        int i17 = i6 + 3;
        double d44 = dArr[i17];
        int i18 = i6 + 18;
        double d45 = dArr[i18];
        double d46 = d44 + d45;
        double d47 = (d7 * d43) - (d8 * d46);
        double d48 = (d46 * d7) + (d43 * d8);
        int i19 = i6 + 10;
        double d49 = dArr[i19];
        int i20 = i6 + 27;
        double d50 = dArr[i20];
        double d51 = d49 - d50;
        int i21 = i6 + 11;
        double d52 = dArr[i21];
        int i22 = i6 + 26;
        double d53 = dArr[i22];
        double d54 = d52 + d53;
        double d55 = (d10 * d51) - (d9 * d54);
        double d56 = (d54 * d10) + (d51 * d9);
        double d57 = d47 + d55;
        double d58 = d48 + d56;
        double d59 = d47 - d55;
        double d60 = d48 - d56;
        double d61 = d41 + d42;
        double d62 = d44 - d45;
        double d63 = (d9 * d61) - (d10 * d62);
        double d64 = (d62 * d9) + (d61 * d10);
        double d65 = d49 + d50;
        double d66 = d52 - d53;
        double d67 = (d7 * d65) + (d8 * d66);
        double d68 = (d66 * d7) - (d65 * d8);
        double d69 = d63 - d67;
        double d70 = d64 - d68;
        double d71 = d63 + d67;
        double d72 = d64 + d68;
        int i23 = i6 + 4;
        double d73 = dArr[i23];
        int i24 = i6 + 21;
        double d74 = dArr[i24];
        double d75 = d73 - d74;
        int i25 = i6 + 5;
        double d76 = dArr[i25];
        int i26 = i6 + 20;
        double d77 = dArr[i26];
        double d78 = d76 + d77;
        double d79 = (d11 * d75) - (d12 * d78);
        double d80 = (d78 * d11) + (d75 * d12);
        int i27 = i6 + 12;
        double d81 = dArr[i27];
        int i28 = i6 + 29;
        double d82 = dArr[i28];
        double d83 = d81 - d82;
        int i29 = i6 + 13;
        double d84 = dArr[i29];
        int i30 = i6 + 28;
        double d85 = dArr[i30];
        double d86 = d84 + d85;
        double d87 = (d12 * d83) - (d11 * d86);
        double d88 = (d86 * d12) + (d83 * d11);
        double d89 = d79 + d87;
        double d90 = d80 + d88;
        double d91 = d79 - d87;
        double d92 = d80 - d88;
        double d93 = d73 + d74;
        double d94 = d76 - d77;
        double d95 = (d12 * d93) - (d11 * d94);
        double d96 = (d94 * d12) + (d93 * d11);
        double d97 = d81 + d82;
        double d98 = d84 - d85;
        double d99 = (d11 * d97) - (d12 * d98);
        double d100 = (d11 * d98) + (d12 * d97);
        double d101 = d95 - d99;
        double d102 = d96 - d100;
        double d103 = d95 + d99;
        double d104 = d96 + d100;
        int i31 = i6 + 6;
        double d105 = dArr[i31];
        int i32 = i6 + 23;
        double d106 = dArr[i32];
        double d107 = d105 - d106;
        int i33 = i6 + 7;
        double d108 = dArr[i33];
        int i34 = i6 + 22;
        double d109 = dArr[i34];
        double d110 = d108 + d109;
        double d111 = (d9 * d107) - (d10 * d110);
        double d112 = (d110 * d9) + (d107 * d10);
        int i35 = i6 + 14;
        double d113 = dArr[i35];
        int i36 = i6 + 31;
        double d114 = dArr[i36];
        double d115 = d113 - d114;
        int i37 = i6 + 15;
        double d116 = dArr[i37];
        int i38 = i6 + 30;
        double d117 = dArr[i38];
        double d118 = d116 + d117;
        double d119 = (d8 * d115) - (d7 * d118);
        double d120 = (d118 * d8) + (d115 * d7);
        double d121 = d111 + d119;
        double d122 = d112 + d120;
        double d123 = d111 - d119;
        double d124 = d112 - d120;
        double d125 = d105 + d106;
        double d126 = d108 - d109;
        double d127 = (d8 * d125) + (d7 * d126);
        double d128 = (d8 * d126) - (d7 * d125);
        double d129 = d113 + d114;
        double d130 = d116 - d117;
        double d131 = (d10 * d129) - (d9 * d130);
        double d132 = (d10 * d130) + (d9 * d129);
        double d133 = d127 + d131;
        double d134 = d128 + d132;
        double d135 = d127 - d131;
        double d136 = d128 - d132;
        double d137 = d27 + d89;
        double d138 = d28 + d90;
        double d139 = d57 + d121;
        double d140 = d58 + d122;
        dArr[i6] = d137 + d139;
        dArr[i9] = d138 + d140;
        dArr[i15] = d137 - d139;
        dArr[i17] = d138 - d140;
        double d141 = d27 - d89;
        double d142 = d28 - d90;
        double d143 = d57 - d121;
        double d144 = d58 - d122;
        dArr[i23] = d141 - d144;
        dArr[i25] = d142 + d143;
        dArr[i31] = d141 + d144;
        dArr[i33] = d142 - d143;
        double d145 = d29 - d92;
        double d146 = d30 + d91;
        double d147 = d59 - d124;
        double d148 = d60 + d123;
        double d149 = (d147 - d148) * d6;
        double d150 = (d148 + d147) * d6;
        dArr[i11] = d145 + d149;
        dArr[i13] = d146 + d150;
        dArr[i19] = d145 - d149;
        dArr[i21] = d146 - d150;
        double d151 = d29 + d92;
        double d152 = d30 - d91;
        double d153 = d59 + d124;
        double d154 = d60 - d123;
        double d155 = (d153 - d154) * d6;
        double d156 = (d154 + d153) * d6;
        dArr[i27] = d151 - d156;
        dArr[i29] = d152 + d155;
        dArr[i35] = d151 + d156;
        dArr[i37] = d152 - d155;
        double d157 = d37 + d101;
        double d158 = d38 + d102;
        double d159 = d69 - d133;
        double d160 = d70 - d134;
        dArr[i10] = d157 + d159;
        dArr[i8] = d158 + d160;
        dArr[i18] = d157 - d159;
        dArr[i16] = d158 - d160;
        double d161 = d37 - d101;
        double d162 = d38 - d102;
        double d163 = d69 + d133;
        double d164 = d70 + d134;
        dArr[i26] = d161 - d164;
        dArr[i24] = d162 + d163;
        dArr[i34] = d161 + d164;
        dArr[i32] = d162 - d163;
        double d165 = d39 - d104;
        double d166 = d40 + d103;
        double d167 = d71 + d136;
        double d168 = d72 - d135;
        double d169 = (d167 - d168) * d6;
        double d170 = (d168 + d167) * d6;
        dArr[i14] = d165 + d169;
        dArr[i12] = d166 + d170;
        dArr[i22] = d165 - d169;
        dArr[i20] = d166 - d170;
        double d171 = d39 + d104;
        double d172 = d40 - d103;
        double d173 = d71 - d136;
        double d174 = d72 + d135;
        double d175 = (d173 - d174) * d6;
        double d176 = d6 * (d174 + d173);
        dArr[i30] = d171 - d176;
        dArr[i28] = d172 + d175;
        dArr[i38] = d171 + d176;
        dArr[i36] = d172 - d175;
    }

    private void r(int i6, double[] dArr, double[] dArr2, int i7) {
        int i8 = i6 >> 3;
        int i9 = i8 * 2;
        int i10 = i9 + i9;
        int i11 = i10 + i9;
        int i12 = 0;
        double d6 = dArr[0];
        double d7 = dArr[i10];
        double d8 = d6 + d7;
        double d9 = dArr[1];
        int i13 = i10 + 1;
        double d10 = dArr[i13];
        double d11 = d9 + d10;
        double d12 = d6 - d7;
        double d13 = d9 - d10;
        double d14 = dArr[i9];
        double d15 = dArr[i11];
        double d16 = d14 + d15;
        int i14 = i9 + 1;
        double d17 = dArr[i14];
        int i15 = i11 + 1;
        double d18 = dArr[i15];
        double d19 = d17 + d18;
        double d20 = d14 - d15;
        double d21 = d17 - d18;
        dArr[0] = d8 + d16;
        dArr[1] = d11 + d19;
        dArr[i9] = d8 - d16;
        dArr[i14] = d11 - d19;
        dArr[i10] = d12 - d21;
        dArr[i13] = d13 + d20;
        dArr[i11] = d12 + d21;
        dArr[i15] = d13 - d20;
        double d22 = dArr2[i7 + 1];
        double d23 = dArr2[i7 + 2];
        double d24 = dArr2[i7 + 3];
        int i16 = 2;
        double d25 = 1.0d;
        double d26 = 0.0d;
        double d27 = 0.0d;
        double d28 = 1.0d;
        while (true) {
            int i17 = i8;
            int i18 = i17 - 2;
            if (i16 >= i18) {
                int i19 = i9;
                double d29 = (d25 + d22) * d23;
                double d30 = d23 * (d26 + d22);
                double d31 = (d28 - d22) * d24;
                double d32 = d24 * (d27 - d22);
                int i20 = i17 + i19;
                int i21 = i20 + i19;
                int i22 = i21 + i19;
                double d33 = dArr[i18];
                int i23 = i21 - 2;
                double d34 = dArr[i23];
                double d35 = d33 + d34;
                int i24 = i17 - 1;
                double d36 = dArr[i24];
                int i25 = i21 - 1;
                double d37 = dArr[i25];
                double d38 = d36 + d37;
                double d39 = d33 - d34;
                double d40 = d36 - d37;
                int i26 = i20 - 2;
                double d41 = dArr[i26];
                int i27 = i22 - 2;
                double d42 = dArr[i27];
                double d43 = d41 + d42;
                int i28 = i20 - 1;
                double d44 = dArr[i28];
                int i29 = i22 - 1;
                double d45 = dArr[i29];
                double d46 = d44 + d45;
                double d47 = d41 - d42;
                double d48 = d44 - d45;
                dArr[i18] = d35 + d43;
                dArr[i24] = d38 + d46;
                dArr[i26] = d35 - d43;
                dArr[i28] = d38 - d46;
                double d49 = d39 - d48;
                double d50 = d40 + d47;
                dArr[i23] = (d29 * d49) - (d30 * d50);
                dArr[i25] = (d50 * d29) + (d49 * d30);
                double d51 = d39 + d48;
                double d52 = d40 - d47;
                dArr[i27] = (d31 * d51) + (d32 * d52);
                dArr[i29] = (d52 * d31) - (d51 * d32);
                double d53 = dArr[i17];
                double d54 = dArr[i21];
                double d55 = d53 + d54;
                int i30 = i17 + 1;
                double d56 = dArr[i30];
                int i31 = i21 + 1;
                double d57 = dArr[i31];
                double d58 = d56 + d57;
                double d59 = d53 - d54;
                double d60 = d56 - d57;
                double d61 = dArr[i20];
                double d62 = dArr[i22];
                double d63 = d61 + d62;
                int i32 = i20 + 1;
                double d64 = dArr[i32];
                int i33 = i22 + 1;
                double d65 = dArr[i33];
                double d66 = d64 + d65;
                double d67 = d61 - d62;
                double d68 = d64 - d65;
                dArr[i17] = d55 + d63;
                dArr[i30] = d58 + d66;
                dArr[i20] = d55 - d63;
                dArr[i32] = d58 - d66;
                double d69 = d59 - d68;
                double d70 = d60 + d67;
                dArr[i21] = (d69 - d70) * d22;
                dArr[i31] = (d70 + d69) * d22;
                double d71 = d59 + d68;
                double d72 = d60 - d67;
                double d73 = -d22;
                dArr[i22] = (d71 + d72) * d73;
                dArr[i33] = d73 * (d72 - d71);
                int i34 = i17 + 2;
                double d74 = dArr[i34];
                int i35 = i21 + 2;
                double d75 = dArr[i35];
                double d76 = d74 + d75;
                int i36 = i17 + 3;
                double d77 = dArr[i36];
                int i37 = i21 + 3;
                double d78 = dArr[i37];
                double d79 = d77 + d78;
                double d80 = d74 - d75;
                double d81 = d77 - d78;
                int i38 = i20 + 2;
                double d82 = dArr[i38];
                int i39 = i22 + 2;
                double d83 = dArr[i39];
                double d84 = d82 + d83;
                int i40 = i20 + 3;
                double d85 = dArr[i40];
                int i41 = i22 + 3;
                double d86 = dArr[i41];
                double d87 = d85 + d86;
                double d88 = d82 - d83;
                double d89 = d85 - d86;
                dArr[i34] = d76 + d84;
                dArr[i36] = d79 + d87;
                dArr[i38] = d76 - d84;
                dArr[i40] = d79 - d87;
                double d90 = d80 - d89;
                double d91 = d81 + d88;
                dArr[i35] = (d30 * d90) - (d29 * d91);
                dArr[i37] = (d30 * d91) + (d29 * d90);
                double d92 = d80 + d89;
                double d93 = d81 - d88;
                dArr[i39] = (d32 * d92) + (d31 * d93);
                dArr[i41] = (d32 * d93) - (d31 * d92);
                return;
            }
            i12 += 4;
            int i42 = i7 + i12;
            double d94 = dArr2[i42];
            double d95 = (d25 + d94) * d23;
            double d96 = dArr2[i42 + 1];
            double d97 = (d26 + d96) * d23;
            double d98 = dArr2[i42 + 2];
            double d99 = (d28 + d98) * d24;
            int i43 = i9;
            double d100 = dArr2[i42 + 3];
            double d101 = (d27 - d100) * d24;
            double d102 = -d100;
            int i44 = i16 + i43;
            int i45 = i44 + i43;
            int i46 = i45 + i43;
            double d103 = dArr[i16];
            double d104 = dArr[i45];
            double d105 = d103 + d104;
            int i47 = i16 + 1;
            double d106 = dArr[i47];
            int i48 = i45 + 1;
            double d107 = dArr[i48];
            double d108 = d106 + d107;
            double d109 = d103 - d104;
            double d110 = d106 - d107;
            int i49 = i16 + 2;
            double d111 = dArr[i49];
            int i50 = i45 + 2;
            double d112 = dArr[i50];
            double d113 = d111 + d112;
            int i51 = i16 + 3;
            double d114 = dArr[i51];
            int i52 = i45 + 3;
            double d115 = dArr[i52];
            double d116 = d114 + d115;
            double d117 = d111 - d112;
            double d118 = d114 - d115;
            double d119 = dArr[i44];
            double d120 = dArr[i46];
            double d121 = d119 + d120;
            int i53 = i44 + 1;
            double d122 = dArr[i53];
            int i54 = i46 + 1;
            double d123 = dArr[i54];
            double d124 = d122 + d123;
            double d125 = d119 - d120;
            double d126 = d122 - d123;
            int i55 = i44 + 2;
            double d127 = dArr[i55];
            int i56 = i46 + 2;
            double d128 = dArr[i56];
            double d129 = d127 + d128;
            int i57 = i44 + 3;
            double d130 = dArr[i57];
            int i58 = i46 + 3;
            double d131 = dArr[i58];
            double d132 = d130 + d131;
            double d133 = d127 - d128;
            double d134 = d130 - d131;
            dArr[i16] = d105 + d121;
            dArr[i47] = d108 + d124;
            dArr[i49] = d113 + d129;
            dArr[i51] = d116 + d132;
            dArr[i44] = d105 - d121;
            dArr[i53] = d108 - d124;
            dArr[i55] = d113 - d129;
            dArr[i57] = d116 - d132;
            double d135 = d109 - d126;
            double d136 = d110 + d125;
            dArr[i45] = (d95 * d135) - (d97 * d136);
            dArr[i48] = (d136 * d95) + (d135 * d97);
            double d137 = d117 - d134;
            double d138 = d118 + d133;
            dArr[i50] = (d94 * d137) - (d96 * d138);
            dArr[i52] = (d138 * d94) + (d137 * d96);
            double d139 = d109 + d126;
            double d140 = d110 - d125;
            dArr[i46] = (d99 * d139) + (d101 * d140);
            dArr[i54] = (d140 * d99) - (d139 * d101);
            double d141 = d117 + d134;
            double d142 = d118 - d133;
            dArr[i56] = (d98 * d141) + (d102 * d142);
            dArr[i58] = (d142 * d98) - (d141 * d102);
            int i59 = i43 - i16;
            int i60 = i59 + i43;
            int i61 = i60 + i43;
            int i62 = i61 + i43;
            double d143 = dArr[i59];
            double d144 = dArr[i61];
            double d145 = d143 + d144;
            int i63 = i59 + 1;
            double d146 = dArr[i63];
            int i64 = i61 + 1;
            double d147 = dArr[i64];
            double d148 = d146 + d147;
            double d149 = d143 - d144;
            double d150 = d146 - d147;
            int i65 = i59 - 2;
            double d151 = dArr[i65];
            int i66 = i61 - 2;
            double d152 = dArr[i66];
            double d153 = d151 + d152;
            int i67 = i59 - 1;
            double d154 = dArr[i67];
            int i68 = i61 - 1;
            double d155 = dArr[i68];
            double d156 = d154 + d155;
            double d157 = d151 - d152;
            double d158 = d154 - d155;
            double d159 = dArr[i60];
            double d160 = dArr[i62];
            double d161 = d159 + d160;
            int i69 = i60 + 1;
            double d162 = dArr[i69];
            int i70 = i62 + 1;
            double d163 = dArr[i70];
            double d164 = d162 + d163;
            double d165 = d159 - d160;
            double d166 = d162 - d163;
            int i71 = i60 - 2;
            double d167 = dArr[i71];
            int i72 = i62 - 2;
            double d168 = dArr[i72];
            double d169 = d167 + d168;
            int i73 = i60 - 1;
            double d170 = dArr[i73];
            int i74 = i62 - 1;
            double d171 = dArr[i74];
            double d172 = d170 + d171;
            double d173 = d167 - d168;
            double d174 = d170 - d171;
            dArr[i59] = d145 + d161;
            dArr[i63] = d148 + d164;
            dArr[i65] = d153 + d169;
            dArr[i67] = d156 + d172;
            dArr[i60] = d145 - d161;
            dArr[i69] = d148 - d164;
            dArr[i71] = d153 - d169;
            dArr[i73] = d156 - d172;
            double d175 = d149 - d166;
            double d176 = d150 + d165;
            dArr[i61] = (d97 * d175) - (d95 * d176);
            dArr[i64] = (d97 * d176) + (d95 * d175);
            double d177 = d157 - d174;
            double d178 = d158 + d173;
            dArr[i66] = (d96 * d177) - (d94 * d178);
            dArr[i68] = (d178 * d96) + (d177 * d94);
            double d179 = d149 + d166;
            double d180 = d150 - d165;
            dArr[i62] = (d101 * d179) + (d99 * d180);
            dArr[i70] = (d101 * d180) - (d99 * d179);
            double d181 = d157 + d174;
            double d182 = d158 - d173;
            dArr[i72] = (d102 * d181) + (d98 * d182);
            dArr[i74] = (d182 * d102) - (d181 * d98);
            i16 += 4;
            d27 = d102;
            d25 = d94;
            d26 = d96;
            d28 = d98;
            i9 = i43;
            i8 = i17;
        }
    }

    private void s(int i6, double[] dArr, int[] iArr, int i7, int i8, double[] dArr2) {
        if (i6 > 32) {
            int i9 = i6 >> 2;
            r(i6, dArr, dArr2, i8 - i9);
            if (i6 > 512) {
                x(i9, dArr, 0, i8, dArr2);
                y(i9, dArr, i9, i8, dArr2);
                x(i9, dArr, i9 * 2, i8, dArr2);
                x(i9, dArr, i9 * 3, i8, dArr2);
            } else if (i9 > 32) {
                k(i6, dArr, 0, i8, dArr2);
            } else {
                t(i6, dArr, 0, i8, dArr2);
            }
            a(i6, iArr, i7, dArr);
            return;
        }
        if (i6 > 8) {
            if (i6 == 32) {
                p(dArr, 0, dArr2, i8 - 8);
                d(dArr);
                return;
            } else {
                n(dArr, 0, dArr2, 0);
                b(dArr);
                return;
            }
        }
        if (i6 == 8) {
            m(dArr);
        } else if (i6 == 4) {
            z(dArr);
        }
    }

    private void t(int i6, double[] dArr, int i7, int i8, double[] dArr2) {
        if (i6 == 128) {
            int i9 = i8 - 8;
            p(dArr, i7, dArr2, i9);
            q(dArr, i7 + 32, dArr2, i8 - 32);
            p(dArr, i7 + 64, dArr2, i9);
            p(dArr, i7 + 96, dArr2, i9);
            return;
        }
        int i10 = i8 - 16;
        n(dArr, i7, dArr2, i10);
        o(dArr, i7 + 16, dArr2, i10);
        n(dArr, i7 + 32, dArr2, i10);
        n(dArr, i7 + 48, dArr2, i10);
    }

    private void u(int i6, double[] dArr, int i7, int i8, double[] dArr2) {
        if (i6 != 128) {
            int i9 = i8 - 16;
            n(dArr, i7, dArr2, i9);
            o(dArr, i7 + 16, dArr2, i9);
            n(dArr, i7 + 32, dArr2, i9);
            o(dArr, i7 + 48, dArr2, i9);
            return;
        }
        int i10 = i8 - 8;
        p(dArr, i7, dArr2, i10);
        int i11 = i8 - 32;
        q(dArr, i7 + 32, dArr2, i11);
        p(dArr, i7 + 64, dArr2, i10);
        q(dArr, i7 + 96, dArr2, i11);
    }

    private final void v(int i6, double[] dArr, int i7, double[] dArr2, int i8) {
        int i9 = i6 >> 3;
        int i10 = i9 * 2;
        int i11 = i10 + i10;
        int i12 = i11 + i10;
        double d6 = dArr[i7];
        int i13 = i7 + i11;
        double d7 = dArr[i13];
        double d8 = d6 + d7;
        int i14 = i7 + 1;
        double d9 = dArr[i14];
        int i15 = i13 + 1;
        double d10 = dArr[i15];
        double d11 = d9 + d10;
        double d12 = d6 - d7;
        double d13 = d9 - d10;
        int i16 = i7 + i10;
        double d14 = dArr[i16];
        int i17 = i7 + i12;
        double d15 = dArr[i17];
        double d16 = d14 + d15;
        int i18 = i16 + 1;
        double d17 = dArr[i18];
        int i19 = i17 + 1;
        double d18 = dArr[i19];
        double d19 = d17 + d18;
        double d20 = d14 - d15;
        double d21 = d17 - d18;
        dArr[i7] = d8 + d16;
        dArr[i14] = d11 + d19;
        dArr[i16] = d8 - d16;
        dArr[i18] = d11 - d19;
        dArr[i13] = d12 - d21;
        dArr[i15] = d13 + d20;
        dArr[i17] = d12 + d21;
        dArr[i19] = d13 - d20;
        double d22 = dArr2[i8 + 1];
        int i20 = 0;
        for (int i21 = 2; i21 < i9; i21 += 2) {
            i20 += 4;
            int i22 = i8 + i20;
            double d23 = dArr2[i22];
            double d24 = dArr2[i22 + 1];
            double d25 = dArr2[i22 + 2];
            double d26 = -dArr2[i22 + 3];
            int i23 = i21 + i10;
            int i24 = i23 + i10;
            int i25 = i24 + i10;
            int i26 = i7 + i21;
            double d27 = dArr[i26];
            int i27 = i7 + i24;
            double d28 = dArr[i27];
            double d29 = d27 + d28;
            int i28 = i26 + 1;
            double d30 = dArr[i28];
            int i29 = i27 + 1;
            double d31 = dArr[i29];
            double d32 = d30 + d31;
            double d33 = d27 - d28;
            double d34 = d30 - d31;
            int i30 = i7 + i23;
            double d35 = dArr[i30];
            int i31 = i7 + i25;
            double d36 = dArr[i31];
            double d37 = d35 + d36;
            int i32 = i30 + 1;
            double d38 = dArr[i32];
            int i33 = i31 + 1;
            double d39 = dArr[i33];
            double d40 = d38 + d39;
            double d41 = d35 - d36;
            double d42 = d38 - d39;
            dArr[i26] = d29 + d37;
            dArr[i28] = d32 + d40;
            dArr[i30] = d29 - d37;
            dArr[i32] = d32 - d40;
            double d43 = d33 - d42;
            double d44 = d34 + d41;
            dArr[i27] = (d23 * d43) - (d24 * d44);
            dArr[i29] = (d44 * d23) + (d43 * d24);
            double d45 = d33 + d42;
            double d46 = d34 - d41;
            dArr[i31] = (d25 * d45) + (d26 * d46);
            dArr[i33] = (d46 * d25) - (d45 * d26);
            int i34 = i10 - i21;
            int i35 = i34 + i10;
            int i36 = i35 + i10;
            int i37 = i36 + i10;
            int i38 = i7 + i34;
            double d47 = dArr[i38];
            int i39 = i7 + i36;
            double d48 = dArr[i39];
            double d49 = d47 + d48;
            int i40 = i38 + 1;
            double d50 = dArr[i40];
            int i41 = i39 + 1;
            double d51 = dArr[i41];
            double d52 = d50 + d51;
            double d53 = d47 - d48;
            double d54 = d50 - d51;
            int i42 = i7 + i35;
            double d55 = dArr[i42];
            int i43 = i7 + i37;
            double d56 = dArr[i43];
            double d57 = d55 + d56;
            int i44 = i42 + 1;
            double d58 = dArr[i44];
            int i45 = i43 + 1;
            double d59 = dArr[i45];
            double d60 = d58 + d59;
            double d61 = d55 - d56;
            double d62 = d58 - d59;
            dArr[i38] = d49 + d57;
            dArr[i40] = d52 + d60;
            dArr[i42] = d49 - d57;
            dArr[i44] = d52 - d60;
            double d63 = d53 - d62;
            double d64 = d54 + d61;
            dArr[i39] = (d24 * d63) - (d23 * d64);
            dArr[i41] = (d24 * d64) + (d23 * d63);
            double d65 = d53 + d62;
            double d66 = d54 - d61;
            dArr[i43] = (d26 * d65) + (d25 * d66);
            dArr[i45] = (d26 * d66) - (d25 * d65);
        }
        int i46 = i9 + i10;
        int i47 = i46 + i10;
        int i48 = i10 + i47;
        int i49 = i7 + i9;
        double d67 = dArr[i49];
        int i50 = i7 + i47;
        double d68 = dArr[i50];
        double d69 = d67 + d68;
        int i51 = i49 + 1;
        double d70 = dArr[i51];
        int i52 = i50 + 1;
        double d71 = dArr[i52];
        double d72 = d70 + d71;
        double d73 = d67 - d68;
        double d74 = d70 - d71;
        int i53 = i7 + i46;
        double d75 = dArr[i53];
        int i54 = i7 + i48;
        double d76 = dArr[i54];
        double d77 = d75 + d76;
        int i55 = i53 + 1;
        double d78 = dArr[i55];
        int i56 = i54 + 1;
        double d79 = dArr[i56];
        double d80 = d78 + d79;
        double d81 = d75 - d76;
        double d82 = d78 - d79;
        dArr[i49] = d69 + d77;
        dArr[i51] = d72 + d80;
        dArr[i53] = d69 - d77;
        dArr[i55] = d72 - d80;
        double d83 = d73 - d82;
        double d84 = d74 + d81;
        dArr[i50] = (d83 - d84) * d22;
        dArr[i52] = (d84 + d83) * d22;
        double d85 = d73 + d82;
        double d86 = d74 - d81;
        double d87 = -d22;
        dArr[i54] = (d85 + d86) * d87;
        dArr[i56] = d87 * (d86 - d85);
    }

    private final void w(int i6, double[] dArr, int i7, double[] dArr2, int i8) {
        int i9 = i6 >> 3;
        int i10 = i9 * 2;
        double d6 = dArr2[i8 + 1];
        int i11 = i10 + i10;
        int i12 = i11 + i10;
        double d7 = dArr[i7];
        int i13 = i7 + i11;
        int i14 = i13 + 1;
        double d8 = dArr[i14];
        double d9 = d7 - d8;
        int i15 = i7 + 1;
        double d10 = dArr[i15];
        double d11 = dArr[i13];
        double d12 = d10 + d11;
        double d13 = d7 + d8;
        double d14 = d10 - d11;
        int i16 = i7 + i10;
        double d15 = dArr[i16];
        int i17 = i7 + i12;
        int i18 = i17 + 1;
        double d16 = dArr[i18];
        double d17 = d15 - d16;
        int i19 = i16 + 1;
        double d18 = dArr[i19];
        double d19 = dArr[i17];
        double d20 = d18 + d19;
        double d21 = d15 + d16;
        double d22 = d18 - d19;
        double d23 = (d17 - d20) * d6;
        double d24 = (d20 + d17) * d6;
        dArr[i7] = d9 + d23;
        dArr[i15] = d12 + d24;
        dArr[i16] = d9 - d23;
        dArr[i19] = d12 - d24;
        double d25 = (d21 - d22) * d6;
        double d26 = d6 * (d22 + d21);
        dArr[i13] = d13 - d26;
        dArr[i14] = d14 + d25;
        dArr[i17] = d13 + d26;
        dArr[i18] = d14 - d25;
        int i20 = i9 * 4;
        int i21 = 2;
        int i22 = 0;
        while (i21 < i9) {
            i22 += 4;
            int i23 = i8 + i22;
            double d27 = dArr2[i23];
            double d28 = dArr2[i23 + 1];
            double d29 = dArr2[i23 + 2];
            double d30 = -dArr2[i23 + 3];
            i20 -= 4;
            int i24 = i8 + i20;
            double d31 = dArr2[i24];
            double d32 = dArr2[i24 + 1];
            double d33 = dArr2[i24 + 2];
            int i25 = i9;
            int i26 = i10;
            double d34 = -dArr2[i24 + 3];
            int i27 = i21 + i26;
            int i28 = i27 + i26;
            int i29 = i28 + i26;
            int i30 = i7 + i21;
            double d35 = dArr[i30];
            int i31 = i7 + i28;
            int i32 = i31 + 1;
            double d36 = dArr[i32];
            double d37 = d35 - d36;
            int i33 = i30 + 1;
            double d38 = dArr[i33];
            double d39 = dArr[i31];
            double d40 = d38 + d39;
            double d41 = d35 + d36;
            double d42 = d38 - d39;
            int i34 = i7 + i27;
            double d43 = dArr[i34];
            int i35 = i7 + i29;
            int i36 = i35 + 1;
            double d44 = dArr[i36];
            double d45 = d43 - d44;
            int i37 = i34 + 1;
            double d46 = dArr[i37];
            double d47 = dArr[i35];
            double d48 = d46 + d47;
            double d49 = d43 + d44;
            double d50 = d46 - d47;
            double d51 = (d27 * d37) - (d28 * d40);
            double d52 = (d40 * d27) + (d37 * d28);
            double d53 = (d32 * d45) - (d31 * d48);
            double d54 = (d48 * d32) + (d45 * d31);
            dArr[i30] = d51 + d53;
            dArr[i33] = d52 + d54;
            dArr[i34] = d51 - d53;
            dArr[i37] = d52 - d54;
            double d55 = (d29 * d41) + (d30 * d42);
            double d56 = (d42 * d29) - (d41 * d30);
            double d57 = (d34 * d49) + (d33 * d50);
            double d58 = (d50 * d34) - (d49 * d33);
            dArr[i31] = d55 + d57;
            dArr[i32] = d56 + d58;
            dArr[i35] = d55 - d57;
            dArr[i36] = d56 - d58;
            int i38 = i26 - i21;
            int i39 = i38 + i26;
            int i40 = i39 + i26;
            int i41 = i40 + i26;
            int i42 = i7 + i38;
            double d59 = dArr[i42];
            int i43 = i7 + i40;
            int i44 = i43 + 1;
            double d60 = dArr[i44];
            double d61 = d59 - d60;
            int i45 = i42 + 1;
            double d62 = dArr[i45];
            double d63 = dArr[i43];
            double d64 = d62 + d63;
            double d65 = d59 + d60;
            double d66 = d62 - d63;
            int i46 = i7 + i39;
            double d67 = dArr[i46];
            int i47 = i7 + i41;
            int i48 = i47 + 1;
            double d68 = dArr[i48];
            double d69 = d67 - d68;
            int i49 = i46 + 1;
            double d70 = dArr[i49];
            double d71 = dArr[i47];
            double d72 = d70 + d71;
            double d73 = d67 + d68;
            double d74 = d70 - d71;
            double d75 = (d31 * d61) - (d32 * d64);
            double d76 = (d31 * d64) + (d32 * d61);
            double d77 = (d28 * d69) - (d27 * d72);
            double d78 = (d28 * d72) + (d27 * d69);
            dArr[i42] = d75 + d77;
            dArr[i45] = d76 + d78;
            dArr[i46] = d75 - d77;
            dArr[i49] = d76 - d78;
            double d79 = (d33 * d65) + (d34 * d66);
            double d80 = (d33 * d66) - (d34 * d65);
            double d81 = (d30 * d73) + (d29 * d74);
            double d82 = (d30 * d74) - (d29 * d73);
            dArr[i43] = d79 + d81;
            dArr[i44] = d80 + d82;
            dArr[i47] = d79 - d81;
            dArr[i48] = d80 - d82;
            i21 += 2;
            i9 = i25;
            i10 = i26;
        }
        int i50 = i9;
        int i51 = i10;
        int i52 = i8 + i51;
        double d83 = dArr2[i52];
        double d84 = dArr2[i52 + 1];
        int i53 = i50 + i51;
        int i54 = i53 + i51;
        int i55 = i54 + i51;
        int i56 = i7 + i50;
        double d85 = dArr[i56];
        int i57 = i7 + i54;
        int i58 = i57 + 1;
        double d86 = dArr[i58];
        double d87 = d85 - d86;
        int i59 = i56 + 1;
        double d88 = dArr[i59];
        double d89 = dArr[i57];
        double d90 = d88 + d89;
        double d91 = d85 + d86;
        double d92 = d88 - d89;
        int i60 = i7 + i53;
        double d93 = dArr[i60];
        int i61 = i7 + i55;
        int i62 = i61 + 1;
        double d94 = dArr[i62];
        double d95 = d93 - d94;
        int i63 = i60 + 1;
        double d96 = dArr[i63];
        double d97 = dArr[i61];
        double d98 = d96 + d97;
        double d99 = d93 + d94;
        double d100 = d96 - d97;
        double d101 = (d83 * d87) - (d84 * d90);
        double d102 = (d90 * d83) + (d87 * d84);
        double d103 = (d84 * d95) - (d83 * d98);
        double d104 = (d98 * d84) + (d95 * d83);
        dArr[i56] = d101 + d103;
        dArr[i59] = d102 + d104;
        dArr[i60] = d101 - d103;
        dArr[i63] = d102 - d104;
        double d105 = (d84 * d91) - (d83 * d92);
        double d106 = (d92 * d84) + (d91 * d83);
        double d107 = (d83 * d99) - (d84 * d100);
        double d108 = (d83 * d100) + (d84 * d99);
        dArr[i57] = d105 - d107;
        dArr[i58] = d106 - d108;
        dArr[i61] = d105 + d107;
        dArr[i62] = d106 + d108;
    }

    private void x(int i6, double[] dArr, int i7, int i8, double[] dArr2) {
        int i9 = i6 >> 2;
        int i10 = i9 * 2;
        v(i6, dArr, i7, dArr2, i8 - i10);
        if (i6 <= 512) {
            k(i6, dArr, i7, i8, dArr2);
            return;
        }
        x(i9, dArr, i7, i8, dArr2);
        y(i9, dArr, i7 + i9, i8, dArr2);
        x(i9, dArr, i7 + i10, i8, dArr2);
        x(i9, dArr, i7 + (i9 * 3), i8, dArr2);
    }

    private void y(int i6, double[] dArr, int i7, int i8, double[] dArr2) {
        int i9 = i6 >> 2;
        w(i6, dArr, i7, dArr2, i8 - i6);
        if (i6 <= 512) {
            l(i6, dArr, i7, i8, dArr2);
            return;
        }
        x(i9, dArr, i7, i8, dArr2);
        y(i9, dArr, i7 + i9, i8, dArr2);
        x(i9, dArr, i7 + (i9 * 2), i8, dArr2);
        y(i9, dArr, i7 + (i9 * 3), i8, dArr2);
    }

    public void B(int i6, int i7, double[] dArr, int[] iArr, double[] dArr2) {
        int i8;
        c cVar;
        int i9;
        double[] dArr3;
        double[] dArr4;
        int i10;
        int i11 = iArr[0];
        if (i6 > (i11 << 2)) {
            i11 = i6 >> 2;
            H(i11, iArr, dArr2);
        }
        int i12 = i11;
        int i13 = iArr[1];
        if (i6 > i13) {
            G(i6, iArr, dArr2, i12);
            i8 = i6;
        } else {
            i8 = i13;
        }
        if (i7 < 0) {
            double d6 = dArr[i6 - 1];
            for (int i14 = i6 - 2; i14 >= 2; i14 -= 2) {
                int i15 = i14 - 1;
                dArr[i14 + 1] = dArr[i14] - dArr[i15];
                dArr[i14] = dArr[i14] + dArr[i15];
            }
            double d7 = dArr[0];
            dArr[1] = d7 - d6;
            dArr[0] = d7 + d6;
            if (i6 > 4) {
                dArr3 = dArr;
                J(i6, dArr3, i8, dArr2, i12);
                i10 = i8;
                cVar = this;
                i9 = i6;
                cVar.j(i9, dArr3, iArr, 2, i12, dArr2);
            } else {
                i10 = i8;
                if (i6 == 4) {
                    cVar = this;
                    dArr3 = dArr;
                    cVar.j(i6, dArr3, iArr, 2, i12, dArr2);
                    i9 = i6;
                } else {
                    cVar = this;
                    i9 = i6;
                    dArr3 = dArr;
                }
            }
            dArr4 = dArr2;
            i8 = i10;
        } else {
            cVar = this;
            i9 = i6;
            dArr3 = dArr;
            dArr4 = dArr2;
        }
        cVar.A(i9, dArr3, i8, dArr4, i12);
        int i16 = i8;
        if (i7 >= 0) {
            if (i9 > 4) {
                s(i9, dArr, iArr, 2, i12, dArr2);
                K(i9, dArr, i16, dArr2, i12);
            } else if (i9 == 4) {
                s(i9, dArr, iArr, 2, i12, dArr2);
            }
            double d8 = dArr[0];
            double d9 = dArr[1];
            double d10 = d8 - d9;
            dArr[0] = d8 + d9;
            for (int i17 = 2; i17 < i9; i17 += 2) {
                int i18 = i17 + 1;
                dArr[i17 - 1] = dArr[i17] - dArr[i18];
                dArr[i17] = dArr[i17] + dArr[i18];
            }
            dArr[i9 - 1] = d10;
        }
    }

    public void C(int i6, int i7, double[] dArr, int[] iArr, double[] dArr2) {
        int i8;
        c cVar;
        int i9;
        double[] dArr3;
        double[] dArr4;
        int i10;
        int i11 = iArr[0];
        if (i6 > (i11 << 2)) {
            i11 = i6 >> 2;
            H(i11, iArr, dArr2);
        }
        int i12 = i11;
        int i13 = iArr[1];
        if (i6 > i13) {
            G(i6, iArr, dArr2, i12);
            i8 = i6;
        } else {
            i8 = i13;
        }
        if (i7 < 0) {
            double d6 = dArr[i6 - 1];
            for (int i14 = i6 - 2; i14 >= 2; i14 -= 2) {
                int i15 = i14 - 1;
                dArr[i14 + 1] = (-dArr[i14]) - dArr[i15];
                dArr[i14] = dArr[i14] - dArr[i15];
            }
            double d7 = dArr[0];
            dArr[1] = d7 + d6;
            dArr[0] = d7 - d6;
            if (i6 > 4) {
                dArr3 = dArr;
                J(i6, dArr3, i8, dArr2, i12);
                i10 = i8;
                cVar = this;
                i9 = i6;
                cVar.j(i9, dArr3, iArr, 2, i12, dArr2);
            } else {
                i10 = i8;
                if (i6 == 4) {
                    cVar = this;
                    dArr3 = dArr;
                    cVar.j(i6, dArr3, iArr, 2, i12, dArr2);
                    i9 = i6;
                } else {
                    cVar = this;
                    i9 = i6;
                    dArr3 = dArr;
                }
            }
            dArr4 = dArr2;
            i8 = i10;
        } else {
            cVar = this;
            i9 = i6;
            dArr3 = dArr;
            dArr4 = dArr2;
        }
        cVar.F(i9, dArr3, i8, dArr4, i12);
        int i16 = i8;
        if (i7 >= 0) {
            if (i9 > 4) {
                s(i9, dArr, iArr, 2, i12, dArr2);
                K(i9, dArr, i16, dArr2, i12);
            } else if (i9 == 4) {
                s(i9, dArr, iArr, 2, i12, dArr2);
            }
            double d8 = dArr[0];
            double d9 = dArr[1];
            double d10 = d8 - d9;
            dArr[0] = d8 + d9;
            for (int i17 = 2; i17 < i9; i17 += 2) {
                int i18 = i17 + 1;
                dArr[i17 - 1] = (-dArr[i17]) - dArr[i18];
                dArr[i17] = dArr[i17] - dArr[i18];
            }
            dArr[i9 - 1] = -d10;
        }
    }

    public void D(int i6, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        int i7 = iArr[0];
        if (i6 > (i7 << 3)) {
            i7 = i6 >> 3;
            H(i7, iArr, dArr3);
        }
        int i8 = i7;
        int i9 = iArr[1];
        if (i6 > (i9 << 1)) {
            i9 = i6 >> 1;
            G(i9, iArr, dArr3, i8);
        }
        int i10 = i9;
        int i11 = i6 >> 1;
        double d6 = dArr[i11];
        double d7 = dArr[0];
        double d8 = dArr[i6];
        double d9 = d7 + d8;
        dArr[0] = d7 - d8;
        dArr2[0] = d9 - d6;
        dArr2[i11] = d9 + d6;
        if (i6 <= 2) {
            dArr[1] = dArr[0];
            dArr[2] = dArr2[0];
            dArr[0] = dArr2[1];
            return;
        }
        int i12 = i6 >> 2;
        for (int i13 = 1; i13 < i12; i13++) {
            int i14 = i11 - i13;
            double d10 = dArr[i13];
            double d11 = dArr[i6 - i13];
            double d12 = d10 - d11;
            double d13 = d10 + d11;
            double d14 = dArr[i14];
            double d15 = dArr[i6 - i14];
            double d16 = d14 - d15;
            double d17 = d14 + d15;
            dArr[i13] = d12;
            dArr[i14] = d16;
            dArr2[i13] = d13 - d17;
            dArr2[i14] = d13 + d17;
        }
        int i15 = i6 - i12;
        dArr2[i12] = dArr[i12] + dArr[i15];
        dArr[i12] = dArr[i12] - dArr[i15];
        A(i11, dArr, i10, dArr3, i8);
        if (i11 > 4) {
            s(i11, dArr, iArr, 2, i8, dArr3);
            K(i11, dArr, i10, dArr3, i8);
        } else if (i11 == 4) {
            s(i11, dArr, iArr, 2, i8, dArr3);
        }
        dArr[i6 - 1] = dArr[0] - dArr[1];
        dArr[1] = dArr[0] + dArr[1];
        for (int i16 = i11 - 2; i16 >= 2; i16 -= 2) {
            int i17 = i16 * 2;
            int i18 = i16 + 1;
            dArr[i17 + 1] = dArr[i16] + dArr[i18];
            dArr[i17 - 1] = dArr[i16] - dArr[i18];
        }
        int i19 = i12;
        int i20 = 2;
        while (i19 >= 2) {
            A(i19, dArr2, i10, dArr3, i8);
            if (i19 > 4) {
                s(i19, dArr2, iArr, 2, i8, dArr3);
                K(i19, dArr2, i10, dArr3, i8);
            } else if (i19 == 4) {
                s(i19, dArr2, iArr, 2, i8, dArr3);
            }
            dArr[i6 - i20] = dArr2[0] - dArr2[1];
            dArr[i20] = dArr2[0] + dArr2[1];
            int i21 = 0;
            for (int i22 = 2; i22 < i19; i22 += 2) {
                i21 += i20 << 2;
                int i23 = i22 + 1;
                dArr[i21 - i20] = dArr2[i22] - dArr2[i23];
                dArr[i21 + i20] = dArr2[i22] + dArr2[i23];
            }
            i20 <<= 1;
            int i24 = i19 >> 1;
            for (int i25 = 0; i25 < i24; i25++) {
                int i26 = i19 - i25;
                int i27 = i19 + i26;
                int i28 = i19 + i25;
                dArr2[i25] = dArr2[i27] - dArr2[i28];
                dArr2[i26] = dArr2[i27] + dArr2[i28];
            }
            dArr2[i24] = dArr2[i19 + i24];
            i19 = i24;
        }
        dArr[i20] = dArr2[0];
        dArr[i6] = dArr2[2] - dArr2[1];
        dArr[0] = dArr2[2] + dArr2[1];
    }

    public void E(int i6, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        int i7 = iArr[0];
        if (i6 > (i7 << 3)) {
            i7 = i6 >> 3;
            H(i7, iArr, dArr3);
        }
        int i8 = i7;
        int i9 = iArr[1];
        if (i6 > (i9 << 1)) {
            i9 = i6 >> 1;
            G(i9, iArr, dArr3, i8);
        }
        int i10 = i9;
        if (i6 > 2) {
            int i11 = i6 >> 1;
            int i12 = i6 >> 2;
            for (int i13 = 1; i13 < i12; i13++) {
                int i14 = i11 - i13;
                double d6 = dArr[i13];
                double d7 = dArr[i6 - i13];
                double d8 = d6 + d7;
                double d9 = d6 - d7;
                double d10 = dArr[i14];
                double d11 = dArr[i6 - i14];
                double d12 = d10 + d11;
                double d13 = d10 - d11;
                dArr[i13] = d8;
                dArr[i14] = d12;
                dArr2[i13] = d9 + d13;
                dArr2[i14] = d9 - d13;
            }
            int i15 = i6 - i12;
            dArr2[0] = dArr[i12] - dArr[i15];
            dArr[i12] = dArr[i12] + dArr[i15];
            dArr[0] = dArr[i11];
            F(i11, dArr, i10, dArr3, i8);
            if (i11 > 4) {
                s(i11, dArr, iArr, 2, i8, dArr3);
                K(i11, dArr, i10, dArr3, i8);
            } else if (i11 == 4) {
                s(i11, dArr, iArr, 2, i8, dArr3);
            }
            dArr[i6 - 1] = dArr[1] - dArr[0];
            dArr[1] = dArr[0] + dArr[1];
            for (int i16 = i11 - 2; i16 >= 2; i16 -= 2) {
                int i17 = i16 * 2;
                int i18 = i16 + 1;
                dArr[i17 + 1] = dArr[i16] - dArr[i18];
                dArr[i17 - 1] = (-dArr[i16]) - dArr[i18];
            }
            int i19 = i12;
            int i20 = 2;
            while (i19 >= 2) {
                F(i19, dArr2, i10, dArr3, i8);
                if (i19 > 4) {
                    s(i19, dArr2, iArr, 2, i8, dArr3);
                    K(i19, dArr2, i10, dArr3, i8);
                } else if (i19 == 4) {
                    s(i19, dArr2, iArr, 2, i8, dArr3);
                }
                dArr[i6 - i20] = dArr2[1] - dArr2[0];
                dArr[i20] = dArr2[0] + dArr2[1];
                int i21 = 0;
                for (int i22 = 2; i22 < i19; i22 += 2) {
                    i21 += i20 << 2;
                    int i23 = i22 + 1;
                    dArr[i21 - i20] = (-dArr2[i22]) - dArr2[i23];
                    dArr[i21 + i20] = dArr2[i22] - dArr2[i23];
                }
                i20 <<= 1;
                int i24 = i19 >> 1;
                for (int i25 = 1; i25 < i24; i25++) {
                    int i26 = i19 - i25;
                    int i27 = i19 + i26;
                    int i28 = i19 + i25;
                    dArr2[i25] = dArr2[i27] + dArr2[i28];
                    dArr2[i26] = dArr2[i27] - dArr2[i28];
                }
                dArr2[0] = dArr2[i19 + i24];
                i19 = i24;
            }
            dArr[i20] = dArr2[0];
        }
        dArr[0] = 0.0d;
    }

    public void I(int i6, int i7, double[] dArr, int[] iArr, double[] dArr2) {
        int i8 = iArr[0];
        if (i6 > (i8 << 2)) {
            i8 = i6 >> 2;
            H(i8, iArr, dArr2);
        }
        int i9 = i8;
        int i10 = iArr[1];
        if (i6 > (i10 << 2)) {
            i10 = i6 >> 2;
            G(i10, iArr, dArr2, i9);
        }
        int i11 = i10;
        if (i7 >= 0) {
            if (i6 > 4) {
                s(i6, dArr, iArr, 2, i9, dArr2);
                K(i6, dArr, i11, dArr2, i9);
            } else if (i6 == 4) {
                s(i6, dArr, iArr, 2, i9, dArr2);
            }
            double d6 = dArr[0];
            double d7 = dArr[1];
            dArr[0] = d6 + d7;
            dArr[1] = d6 - d7;
            return;
        }
        double d8 = dArr[0];
        double d9 = (d8 - dArr[1]) * 0.5d;
        dArr[1] = d9;
        dArr[0] = d8 - d9;
        if (i6 > 4) {
            J(i6, dArr, i11, dArr2, i9);
            j(i6, dArr, iArr, 2, i9, dArr2);
        } else if (i6 == 4) {
            j(i6, dArr, iArr, 2, i9, dArr2);
        }
    }
}
