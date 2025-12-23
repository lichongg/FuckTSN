package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k4 extends h5 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f34495a = {1, 1, 1, 1};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f34496b = {3, 1, 1};

    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int a6 = h5.a(zArr, 0, f34495a, true);
            for (int i6 = 0; i6 < length; i6 += 2) {
                int digit = Character.digit(str.charAt(i6), 10);
                int digit2 = Character.digit(str.charAt(i6 + 1), 10);
                int[] iArr = new int[10];
                for (int i7 = 0; i7 < 5; i7++) {
                    int i8 = i7 * 2;
                    int[][] iArr2 = j4.f34450f;
                    iArr[i8] = iArr2[digit][i7];
                    iArr[i8 + 1] = iArr2[digit2][i7];
                }
                a6 += h5.a(zArr, a6, iArr, true);
            }
            h5.a(zArr, a6, f34496b, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
