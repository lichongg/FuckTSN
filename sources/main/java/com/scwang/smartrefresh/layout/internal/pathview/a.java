package com.scwang.smartrefresh.layout.internal.pathview;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37447a = "PathParser";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        char f37450a;

        /* renamed from: b, reason: collision with root package name */
        float[] f37451b;

        b(char c6, float[] fArr) {
            this.f37450a = c6;
            this.f37451b = fArr;
        }

        private static void b(Path path, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14) {
            double d15 = d8;
            int ceil = (int) Math.ceil(Math.abs((d14 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d12);
            double sin = Math.sin(d12);
            double cos2 = Math.cos(d13);
            double sin2 = Math.sin(d13);
            double d16 = -d15;
            double d17 = d16 * cos;
            double d18 = d9 * sin;
            double d19 = (d17 * sin2) - (d18 * cos2);
            double d20 = d16 * sin;
            double d21 = d9 * cos;
            double d22 = (sin2 * d20) + (cos2 * d21);
            double d23 = d14 / ceil;
            double d24 = d13;
            double d25 = d22;
            double d26 = d19;
            int i6 = 0;
            double d27 = d10;
            double d28 = d11;
            while (i6 < ceil) {
                double d29 = d24 + d23;
                double sin3 = Math.sin(d29);
                double cos3 = Math.cos(d29);
                double d30 = (d6 + ((d15 * cos) * cos3)) - (d18 * sin3);
                int i7 = i6;
                double d31 = d7 + (d8 * sin * cos3) + (d21 * sin3);
                double d32 = (d17 * sin3) - (d18 * cos3);
                double d33 = (sin3 * d20) + (cos3 * d21);
                double d34 = d29 - d24;
                double tan = Math.tan(d34 / 2.0d);
                double sin4 = (Math.sin(d34) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d35 = d27 + (d26 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d35, (float) (d28 + (d25 * sin4)), (float) (d30 - (sin4 * d32)), (float) (d31 - (sin4 * d33)), (float) d30, (float) d31);
                sin = sin;
                d23 = d23;
                d27 = d30;
                d20 = d20;
                d24 = d29;
                d25 = d33;
                cos = cos;
                d15 = d8;
                d28 = d31;
                i6 = i7 + 1;
                ceil = ceil;
                d26 = d32;
            }
        }

        private static void c(Path path, float f6, float f7, float f8, float f9, float f10, float f11, float f12, boolean z5, boolean z6) {
            double d6;
            double d7;
            double radians = Math.toRadians(f12);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d8 = f6;
            double d9 = f7;
            double d10 = f10;
            double d11 = ((d8 * cos) + (d9 * sin)) / d10;
            double d12 = f11;
            double d13 = (((-f6) * sin) + (d9 * cos)) / d12;
            double d14 = f9;
            double d15 = ((f8 * cos) + (d14 * sin)) / d10;
            double d16 = (((-f8) * sin) + (d14 * cos)) / d12;
            double d17 = d11 - d15;
            double d18 = d13 - d16;
            double d19 = (d11 + d15) / 2.0d;
            double d20 = (d13 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 == 0.0d) {
                return;
            }
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < 0.0d) {
                float sqrt = (float) (Math.sqrt(d21) / 1.99999d);
                c(path, f6, f7, f8, f9, f10 * sqrt, sqrt * f11, f12, z5, z6);
                return;
            }
            double sqrt2 = Math.sqrt(d22);
            double d23 = d17 * sqrt2;
            double d24 = sqrt2 * d18;
            if (z5 == z6) {
                d6 = d19 - d24;
                d7 = d20 + d23;
            } else {
                d6 = d19 + d24;
                d7 = d20 - d23;
            }
            double atan2 = Math.atan2(d13 - d7, d11 - d6);
            double atan22 = Math.atan2(d16 - d7, d15 - d6) - atan2;
            if (z6 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d25 = d6 * d10;
            double d26 = d7 * d12;
            b(path, (d25 * cos) - (d26 * sin), (d25 * sin) + (d26 * cos), d10, d12, d8, d9, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c6 = 'm';
            for (int i6 = 0; i6 < bVarArr.length; i6++) {
                b bVar = bVarArr[i6];
                a(path, fArr, c6, bVar.f37450a, bVar.f37451b);
                c6 = bVarArr[i6].f37450a;
            }
        }

        public void d(b bVar, b bVar2, float f6) {
            int i6 = 0;
            while (true) {
                float[] fArr = bVar.f37451b;
                if (i6 >= fArr.length) {
                    return;
                }
                this.f37451b[i6] = (fArr[i6] * (1.0f - f6)) + (bVar2.f37451b[i6] * f6);
                i6++;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c6, char c7, float[] fArr2) {
            int i6;
            int i7;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            Path path2 = path;
            float f19 = fArr[0];
            float f20 = fArr[1];
            float f21 = fArr[2];
            float f22 = fArr[3];
            float f23 = fArr[4];
            float f24 = fArr[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i6 = 7;
                    break;
                case 'C':
                case 'c':
                    i6 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i6 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i6 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i6 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f23, f24);
                    f19 = f23;
                    f21 = f19;
                    f20 = f24;
                    f22 = f20;
                    i6 = 2;
                    break;
            }
            float f25 = f19;
            float f26 = f20;
            float f27 = f23;
            float f28 = f24;
            int i8 = 0;
            char c8 = c6;
            while (i8 < fArr2.length) {
                if (c7 == 'A') {
                    i7 = i8;
                    int i9 = i7 + 5;
                    int i10 = i7 + 6;
                    c(path, f25, f26, fArr2[i9], fArr2[i10], fArr2[i7], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f, fArr2[i7 + 4] != 0.0f);
                    f21 = fArr2[i9];
                    f25 = f21;
                    f22 = fArr2[i10];
                    f26 = f22;
                } else if (c7 == 'C') {
                    i7 = i8;
                    int i11 = i7 + 2;
                    int i12 = i7 + 3;
                    int i13 = i7 + 4;
                    int i14 = i7 + 5;
                    path2.cubicTo(fArr2[i7], fArr2[i7 + 1], fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                    float f29 = fArr2[i13];
                    float f30 = fArr2[i14];
                    float f31 = fArr2[i11];
                    float f32 = fArr2[i12];
                    f25 = f29;
                    f26 = f30;
                    f22 = f32;
                    f21 = f31;
                } else if (c7 != 'H') {
                    if (c7 != 'Q') {
                        if (c7 == 'V') {
                            i7 = i8;
                            path2.lineTo(f25, fArr2[i7]);
                            f8 = fArr2[i7];
                        } else if (c7 != 'a') {
                            if (c7 == 'c') {
                                int i15 = i8 + 2;
                                int i16 = i8 + 3;
                                int i17 = i8 + 4;
                                int i18 = i8 + 5;
                                path2.rCubicTo(fArr2[i8], fArr2[i8 + 1], fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                                float f33 = fArr2[i15] + f25;
                                float f34 = fArr2[i16] + f26;
                                f25 += fArr2[i17];
                                f26 += fArr2[i18];
                                f21 = f33;
                                f22 = f34;
                            } else if (c7 != 'h') {
                                if (c7 != 'q') {
                                    if (c7 != 'v') {
                                        if (c7 != 'L') {
                                            if (c7 == 'M') {
                                                f13 = fArr2[i8];
                                                f14 = fArr2[i8 + 1];
                                                if (i8 > 0) {
                                                    path2.lineTo(f13, f14);
                                                } else {
                                                    path2.moveTo(f13, f14);
                                                    f25 = f13;
                                                    f27 = f25;
                                                    f26 = f14;
                                                }
                                            } else if (c7 == 'S') {
                                                if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                    f25 = (f25 * 2.0f) - f21;
                                                    f26 = (f26 * 2.0f) - f22;
                                                }
                                                float f35 = f25;
                                                float f36 = f26;
                                                int i19 = i8 + 1;
                                                int i20 = i8 + 2;
                                                int i21 = i8 + 3;
                                                path2.cubicTo(f35, f36, fArr2[i8], fArr2[i19], fArr2[i20], fArr2[i21]);
                                                f6 = fArr2[i8];
                                                f7 = fArr2[i19];
                                                f25 = fArr2[i20];
                                                f26 = fArr2[i21];
                                                i7 = i8;
                                            } else if (c7 == 'T') {
                                                if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                    f25 = (f25 * 2.0f) - f21;
                                                    f26 = (f26 * 2.0f) - f22;
                                                }
                                                int i22 = i8 + 1;
                                                path2.quadTo(f25, f26, fArr2[i8], fArr2[i22]);
                                                float f37 = fArr2[i8];
                                                f8 = fArr2[i22];
                                                f21 = f25;
                                                f22 = f26;
                                                i7 = i8;
                                                f25 = f37;
                                            } else if (c7 == 'l') {
                                                int i23 = i8 + 1;
                                                path2.rLineTo(fArr2[i8], fArr2[i23]);
                                                f25 += fArr2[i8];
                                                f12 = fArr2[i23];
                                            } else if (c7 == 'm') {
                                                float f38 = fArr2[i8];
                                                f25 += f38;
                                                float f39 = fArr2[i8 + 1];
                                                f26 += f39;
                                                if (i8 > 0) {
                                                    path2.rLineTo(f38, f39);
                                                } else {
                                                    path2.rMoveTo(f38, f39);
                                                    f27 = f25;
                                                }
                                            } else if (c7 == 's') {
                                                if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                    f15 = f26 - f22;
                                                    f16 = f25 - f21;
                                                } else {
                                                    f16 = 0.0f;
                                                    f15 = 0.0f;
                                                }
                                                int i24 = i8 + 1;
                                                int i25 = i8 + 2;
                                                int i26 = i8 + 3;
                                                path2.rCubicTo(f16, f15, fArr2[i8], fArr2[i24], fArr2[i25], fArr2[i26]);
                                                f9 = fArr2[i8] + f25;
                                                f10 = fArr2[i24] + f26;
                                                f25 += fArr2[i25];
                                                f11 = fArr2[i26];
                                            } else if (c7 == 't') {
                                                if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                    f17 = f25 - f21;
                                                    f18 = f26 - f22;
                                                } else {
                                                    f18 = 0.0f;
                                                    f17 = 0.0f;
                                                }
                                                int i27 = i8 + 1;
                                                path2.rQuadTo(f17, f18, fArr2[i8], fArr2[i27]);
                                                float f40 = f17 + f25;
                                                float f41 = f18 + f26;
                                                f25 += fArr2[i8];
                                                f26 += fArr2[i27];
                                                f22 = f41;
                                                f21 = f40;
                                            }
                                            f28 = f26;
                                        } else {
                                            int i28 = i8 + 1;
                                            path2.lineTo(fArr2[i8], fArr2[i28]);
                                            f13 = fArr2[i8];
                                            f14 = fArr2[i28];
                                        }
                                        f25 = f13;
                                        f26 = f14;
                                    } else {
                                        path2.rLineTo(0.0f, fArr2[i8]);
                                        f12 = fArr2[i8];
                                    }
                                    f26 += f12;
                                } else {
                                    int i29 = i8 + 1;
                                    int i30 = i8 + 2;
                                    int i31 = i8 + 3;
                                    path2.rQuadTo(fArr2[i8], fArr2[i29], fArr2[i30], fArr2[i31]);
                                    f9 = fArr2[i8] + f25;
                                    f10 = fArr2[i29] + f26;
                                    f25 += fArr2[i30];
                                    f11 = fArr2[i31];
                                }
                                f26 += f11;
                                f21 = f9;
                                f22 = f10;
                            } else {
                                path2.rLineTo(fArr2[i8], 0.0f);
                                f25 += fArr2[i8];
                            }
                            i7 = i8;
                        } else {
                            int i32 = i8 + 5;
                            int i33 = i8 + 6;
                            float f42 = f26;
                            i7 = i8;
                            float f43 = f25;
                            c(path, f43, f42, fArr2[i32] + f25, fArr2[i33] + f26, fArr2[i8], fArr2[i8 + 1], fArr2[i8 + 2], fArr2[i8 + 3] != 0.0f, fArr2[i8 + 4] != 0.0f);
                            f25 = f43 + fArr2[i32];
                            f26 = f42 + fArr2[i33];
                            f21 = f25;
                            f22 = f26;
                        }
                        f26 = f8;
                    } else {
                        i7 = i8;
                        int i34 = i7 + 1;
                        int i35 = i7 + 2;
                        int i36 = i7 + 3;
                        path2.quadTo(fArr2[i7], fArr2[i34], fArr2[i35], fArr2[i36]);
                        f6 = fArr2[i7];
                        f7 = fArr2[i34];
                        f25 = fArr2[i35];
                        f26 = fArr2[i36];
                    }
                    f21 = f6;
                    f22 = f7;
                } else {
                    i7 = i8;
                    path2.lineTo(fArr2[i7], f26);
                    f25 = fArr2[i7];
                }
                i8 = i7 + i6;
                path2 = path;
                c8 = c7;
            }
            fArr[0] = f25;
            fArr[1] = f26;
            fArr[2] = f21;
            fArr[3] = f22;
            fArr[4] = f27;
            fArr[5] = f28;
        }

        b(b bVar) {
            this.f37450a = bVar.f37450a;
            float[] fArr = bVar.f37451b;
            this.f37451b = a.c(fArr, 0, fArr.length);
        }
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i6 = 0; i6 < bVarArr.length; i6++) {
            b bVar = bVarArr[i6];
            char c6 = bVar.f37450a;
            b bVar2 = bVarArr2[i6];
            if (c6 != bVar2.f37450a || bVar.f37451b.length != bVar2.f37451b.length) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[LOOP:0: B:2:0x0007->B:14:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(java.lang.String r8, int r9, com.scwang.smartrefresh.layout.internal.pathview.a.C0728a r10) {
        /*
            r0 = 0
            r10.f37449b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L36
        L27:
            r10.f37449b = r7
        L29:
            r2 = 0
            r4 = 1
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f37449b = r7
            goto L29
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.f37448a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.internal.pathview.a.g(java.lang.String, int, com.scwang.smartrefresh.layout.internal.pathview.a$a):void");
    }

    private static float[] h(String str) {
        int i6 = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            C0728a c0728a = new C0728a();
            int length = str.length();
            int i7 = 0;
            while (i6 < length) {
                g(str, i6, c0728a);
                int i8 = c0728a.f37448a;
                if (i6 < i8) {
                    fArr[i7] = Float.parseFloat(str.substring(i6, i8));
                    i7++;
                }
                i6 = c0728a.f37449b ? i8 : i8 + 1;
            }
            return c(fArr, 0, i7);
        } catch (NumberFormatException e6) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e6);
        }
    }

    private static void l(float f6, float f7, b[] bVarArr) {
        for (b bVar : bVarArr) {
            k(f6, f7, bVar.f37450a, bVar.f37451b);
        }
    }

    public static void m(b[] bVarArr, b[] bVarArr2) {
        for (int i6 = 0; i6 < bVarArr2.length; i6++) {
            bVarArr[i6].f37450a = bVarArr2[i6].f37450a;
            int i7 = 0;
            while (true) {
                float[] fArr = bVarArr2[i6].f37451b;
                if (i7 < fArr.length) {
                    bVarArr[i6].f37451b[i7] = fArr[i7];
                    i7++;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.scwang.smartrefresh.layout.internal.pathview.a$a, reason: collision with other inner class name */
    private static class C0728a {

        /* renamed from: a, reason: collision with root package name */
        int f37448a;

        /* renamed from: b, reason: collision with root package name */
        boolean f37449b;

        C0728a() {
        }
    }

    private static void a(ArrayList<b> arrayList, char c6, float[] fArr) {
        arrayList.add(new b(c6, fArr));
    }

    static float[] c(float[] fArr, int i6, int i7) {
        if (i6 > i7) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i6 < 0 || i6 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = i7 - i6;
        int min = Math.min(i8, length - i6);
        float[] fArr2 = new float[i8];
        System.arraycopy(fArr, i6, fArr2, 0, min);
        return fArr2;
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        int i7 = 0;
        while (i6 < str.length()) {
            int i8 = i(str, i6);
            String trim = str.substring(i7, i8).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i7 = i8;
            i6 = i8 + 1;
        }
        if (i6 - i7 == 1 && i7 < str.length()) {
            a(arrayList, str.charAt(i7), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d6 = d(str);
        if (d6 == null) {
            return null;
        }
        try {
            b.e(d6, path);
            return path;
        } catch (RuntimeException e6) {
            throw new RuntimeException("Error in parsing " + str, e6);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i6 = 0; i6 < bVarArr.length; i6++) {
            bVarArr2[i6] = new b(bVarArr[i6]);
        }
        return bVarArr2;
    }

    public static List<Path> j(float f6, float f7, List<Path> list, List<String> list2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f6, f7);
        ArrayList arrayList = new ArrayList();
        for (Path path : list) {
            Path path2 = new Path();
            path.transform(matrix, path2);
            arrayList.add(path2);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(float r19, float r20, char r21, float[] r22) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.internal.pathview.a.k(float, float, char, float[]):void");
    }

    a() {
    }

    private static int i(String str, int i6) {
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i6++;
        }
        return i6;
    }
}
