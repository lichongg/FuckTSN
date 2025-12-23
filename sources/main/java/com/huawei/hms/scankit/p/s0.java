package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s0 extends h5 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i6, i7, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                char charAt = str.charAt(i7);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 1;
            while (i8 < length) {
                int a6 = a(str, i8, i10);
                int i12 = 100;
                if (a6 == i10) {
                    switch (str.charAt(i8)) {
                        case 241:
                            i12 = 102;
                            i8++;
                            break;
                        case 242:
                            i12 = 97;
                            i8++;
                            break;
                        case 243:
                            i12 = 96;
                            i8++;
                            break;
                        case 244:
                            i8++;
                            break;
                        default:
                            if (i10 == 100) {
                                i12 = str.charAt(i8) - ' ';
                            } else {
                                try {
                                    i12 = Integer.parseInt(str.substring(i8, i8 + 2));
                                    i8++;
                                } catch (NumberFormatException unused) {
                                    throw new IllegalArgumentException("contents substring can not format integer");
                                }
                            }
                            i8++;
                            break;
                    }
                } else {
                    i12 = i10 == 0 ? a6 == 100 ? 104 : 105 : a6;
                    i10 = a6;
                }
                arrayList.add(r0.f34727a[i12]);
                i9 += i12 * i11;
                if (i8 != 0) {
                    i11++;
                }
            }
            int[][] iArr = r0.f34727a;
            arrayList.add(iArr[i9 % 103]);
            arrayList.add(iArr[106]);
            int i13 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i14 : iArr2) {
                    i13 += i14;
                }
            }
            boolean[] zArr = new boolean[i13];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i6 += h5.a(zArr, i6, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    private static a a(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        if (i6 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i6);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i7 = i6 + 1;
        if (i7 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i7);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return a.TWO_DIGITS;
        }
        return a.ONE_DIGIT;
    }

    private static int a(CharSequence charSequence, int i6, int i7) {
        a aVar;
        a a6;
        a a7;
        a a8 = a(charSequence, i6);
        a aVar2 = a.UNCODABLE;
        if (a8 != aVar2 && a8 != (aVar = a.ONE_DIGIT)) {
            if (i7 == 99) {
                return 99;
            }
            if (i7 == 100) {
                a aVar3 = a.FNC_1;
                if (a8 == aVar3 || (a6 = a(charSequence, i6 + 2)) == aVar2 || a6 == aVar) {
                    return 100;
                }
                if (a6 == aVar3) {
                    return a(charSequence, i6 + 3) == a.TWO_DIGITS ? 99 : 100;
                }
                int i8 = i6 + 4;
                while (true) {
                    a7 = a(charSequence, i8);
                    if (a7 != a.TWO_DIGITS) {
                        break;
                    }
                    i8 += 2;
                }
                return a7 == a.ONE_DIGIT ? 100 : 99;
            }
            if (a8 == a.FNC_1) {
                a8 = a(charSequence, i6 + 1);
            }
            if (a8 == a.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }
}
