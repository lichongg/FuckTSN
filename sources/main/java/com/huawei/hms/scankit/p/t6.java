package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.util.SparseArray;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class t6 {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<Integer> f34836a;

    public static int a(BarcodeFormat barcodeFormat) {
        if (barcodeFormat == null) {
            return HmsScanBase.FORMAT_UNKNOWN;
        }
        Integer num = f34836a.get(barcodeFormat.ordinal());
        return num == null ? HmsScanBase.FORMAT_UNKNOWN : num.intValue();
    }

    protected static String b(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z5 = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z5 || charAt != '\\') {
                sb.append(charAt);
                z5 = false;
            } else {
                z5 = true;
            }
            indexOf++;
        }
        return sb.toString();
    }

    public abstract HmsScan b(s6 s6Var);

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f34836a = sparseArray;
        sparseArray.put(BarcodeFormat.AZTEC.ordinal(), Integer.valueOf(HmsScanBase.AZTEC_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODABAR.ordinal(), Integer.valueOf(HmsScanBase.CODABAR_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_39.ordinal(), Integer.valueOf(HmsScanBase.CODE39_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_93.ordinal(), Integer.valueOf(HmsScanBase.CODE93_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_128.ordinal(), Integer.valueOf(HmsScanBase.CODE128_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.DATA_MATRIX.ordinal(), Integer.valueOf(HmsScanBase.DATAMATRIX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_8.ordinal(), Integer.valueOf(HmsScanBase.EAN8_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_13.ordinal(), Integer.valueOf(HmsScanBase.EAN13_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.ITF.ordinal(), Integer.valueOf(HmsScanBase.ITF14_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.PDF_417.ordinal(), Integer.valueOf(HmsScanBase.PDF417_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.QR_CODE.ordinal(), Integer.valueOf(HmsScanBase.QRCODE_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_A.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_A_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_E.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_E_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.WXCODE.ordinal(), Integer.valueOf(HmsScanBase.WX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.HARMONY_CODE.ordinal(), Integer.valueOf(HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE));
    }

    public static Point[] a(u6[] u6VarArr) {
        if (u6VarArr != null && u6VarArr.length > 0) {
            Point[] pointArr = new Point[u6VarArr.length];
            for (int i6 = 0; i6 < u6VarArr.length; i6++) {
                if (u6VarArr[i6] != null) {
                    pointArr[i6] = new Point((int) u6VarArr[i6].b(), (int) u6VarArr[i6].c());
                }
            }
            return pointArr;
        }
        return new Point[0];
    }

    protected static String a(s6 s6Var) {
        String k6 = s6Var.k();
        if (k6 == null) {
            return "";
        }
        return k6.startsWith("\ufeff") ? k6.substring(1) : k6;
    }

    protected static String a(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < str.length() ? str.substring(0, length) : str;
    }
}
