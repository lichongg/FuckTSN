package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class r4 {
    static int a(c0 c0Var) {
        return a(c0Var, true) + a(c0Var, false);
    }

    private static boolean a(byte[] bArr, int i6, int i7) {
        int min = Math.min(i7, bArr.length);
        for (int max = Math.max(i6, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    static int b(c0 c0Var) {
        byte[][] a6 = c0Var.a();
        int c6 = c0Var.c();
        int b6 = c0Var.b();
        int i6 = 0;
        for (int i7 = 0; i7 < b6 - 1; i7++) {
            byte[] bArr = a6[i7];
            int i8 = 0;
            while (i8 < c6 - 1) {
                byte b7 = bArr[i8];
                int i9 = i8 + 1;
                if (b7 == bArr[i9]) {
                    byte[] bArr2 = a6[i7 + 1];
                    if (b7 == bArr2[i8] && b7 == bArr2[i9]) {
                        i6++;
                    }
                }
                i8 = i9;
            }
        }
        return i6 * 3;
    }

    static int c(c0 c0Var) {
        byte[][] a6 = c0Var.a();
        int c6 = c0Var.c();
        int b6 = c0Var.b();
        int i6 = 0;
        for (int i7 = 0; i7 < b6; i7++) {
            for (int i8 = 0; i8 < c6; i8++) {
                byte[] bArr = a6[i7];
                int i9 = i8 + 6;
                if (i9 < c6 && bArr[i8] == 1 && bArr[i8 + 1] == 0 && bArr[i8 + 2] == 1 && bArr[i8 + 3] == 1 && bArr[i8 + 4] == 1 && bArr[i8 + 5] == 0 && bArr[i9] == 1 && (a(bArr, i8 - 4, i8) || a(bArr, i8 + 7, i8 + 11))) {
                    i6++;
                }
                int i10 = i7 + 6;
                if (i10 < b6 && a6[i7][i8] == 1 && a6[i7 + 1][i8] == 0 && a6[i7 + 2][i8] == 1 && a6[i7 + 3][i8] == 1 && a6[i7 + 4][i8] == 1 && a6[i7 + 5][i8] == 0 && a6[i10][i8] == 1 && (a(a6, i8, i7 - 4, i7) || a(a6, i8, i7 + 7, i7 + 11))) {
                    i6++;
                }
            }
        }
        return i6 * 40;
    }

    static int d(c0 c0Var) {
        byte[][] a6 = c0Var.a();
        int c6 = c0Var.c();
        int b6 = c0Var.b();
        int i6 = 0;
        for (int i7 = 0; i7 < b6; i7++) {
            byte[] bArr = a6[i7];
            for (int i8 = 0; i8 < c6; i8++) {
                if (bArr[i8] == 1) {
                    i6++;
                }
            }
        }
        int b7 = c0Var.b() * c0Var.c();
        return ((Math.abs((i6 * 2) - b7) * 10) / b7) * 10;
    }

    private static boolean a(byte[][] bArr, int i6, int i7, int i8) {
        int min = Math.min(i8, bArr.length);
        for (int max = Math.max(i7, 0); max < min; max++) {
            if (max < bArr.length && i6 < bArr[0].length && bArr[max][i6] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L39;
                case 1: goto L3a;
                case 2: goto L41;
                case 3: goto L3d;
                case 4: goto L35;
                case 5: goto L2d;
                case 6: goto L25;
                case 7: goto L1b;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L1b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
        L23:
            r1 = r1 & r0
            goto L43
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L23
        L2d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L43
        L35:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L39:
            int r3 = r3 + r2
        L3a:
            r1 = r3 & 1
            goto L43
        L3d:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L43
        L41:
            int r1 = r2 % 3
        L43:
            if (r1 != 0) goto L46
            return r0
        L46:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r4.a(int, int, int):boolean");
    }

    private static int a(c0 c0Var, boolean z5) {
        int b6 = z5 ? c0Var.b() : c0Var.c();
        int c6 = z5 ? c0Var.c() : c0Var.b();
        byte[][] a6 = c0Var.a();
        int i6 = 0;
        for (int i7 = 0; i7 < b6; i7++) {
            byte b7 = -1;
            int i8 = 0;
            for (int i9 = 0; i9 < c6; i9++) {
                byte b8 = z5 ? a6[i7][i9] : a6[i9][i7];
                if (b8 == b7) {
                    i8++;
                } else {
                    if (i8 >= 5) {
                        i6 += i8 - 2;
                    }
                    b7 = b8;
                    i8 = 1;
                }
            }
            if (i8 >= 5) {
                i6 += i8 - 2;
            }
        }
        return i6;
    }
}
