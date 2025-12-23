package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n3 {
    public static List<List<BarcodeFormat>> a(int i6) {
        int i7 = i6 <= 0 ? HmsScanBase.ALL_SCAN_TYPE : i6;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        if (i7 > 0) {
            BarcodeFormat[] barcodeFormatArr = {BarcodeFormat.CODE_128, BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODABAR, BarcodeFormat.DATA_MATRIX, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.ITF, BarcodeFormat.QR_CODE, BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.PDF_417, BarcodeFormat.AZTEC, BarcodeFormat.HARMONY_CODE, BarcodeFormat.WXCODE};
            int[] iArr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
            if ((i7 & iArr[8]) != 0) {
                arrayList.add(barcodeFormatArr[8]);
            }
            if ((iArr[11] & i7) != 0) {
                arrayList3.add(barcodeFormatArr[11]);
            }
            int i8 = 0;
            for (int i9 = 15; i8 < i9; i9 = 15) {
                if ((i7 & iArr[i8]) != 0 && i8 != 8 && i8 != 11) {
                    if (i8 == 4) {
                        arrayList5.add(barcodeFormatArr[i8]);
                    } else if (i8 == 12) {
                        arrayList4.add(barcodeFormatArr[i8]);
                    } else if (i8 == 13) {
                        arrayList6.add(barcodeFormatArr[i8]);
                    } else if (i8 == 14) {
                        arrayList7.add(barcodeFormatArr[i8]);
                    } else {
                        arrayList2.add(barcodeFormatArr[i8]);
                    }
                }
                i8++;
            }
        }
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(arrayList);
        arrayList8.add(arrayList2);
        arrayList8.add(arrayList3);
        arrayList8.add(arrayList5);
        arrayList8.add(arrayList4);
        arrayList8.add(arrayList6);
        arrayList8.add(arrayList7);
        return arrayList8;
    }
}
