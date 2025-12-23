package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class c5 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i6, int i7, Map<u2, ?> map) throws WriterException {
        l8 r2Var;
        switch (a.f34087a[barcodeFormat.ordinal()]) {
            case 1:
                r2Var = new r2();
                break;
            case 2:
                r2Var = new t7();
                break;
            case 3:
                r2Var = new p2();
                break;
            case 4:
                r2Var = new m7();
                break;
            case 5:
                r2Var = new k6();
                break;
            case 6:
                r2Var = new u0();
                break;
            case 7:
                r2Var = new w0();
                break;
            case 8:
                r2Var = new s0();
                break;
            case 9:
                r2Var = new k4();
                break;
            case 10:
                r2Var = new u5();
                break;
            case 11:
                r2Var = new q0();
                break;
            case 12:
                r2Var = new j1();
                break;
            case 13:
                r2Var = new i();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return r2Var.a(str, barcodeFormat, i6, i7, map);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34087a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f34087a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34087a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34087a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34087a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34087a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34087a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34087a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34087a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34087a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34087a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34087a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f34087a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f34087a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x01d4: MOVE (r8 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:181:0x01d4 */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0241 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0242 A[Catch: OutOfMemoryError -> 0x01d3, Exception -> 0x0260, IllegalArgumentException -> 0x0263, TryCatch #10 {OutOfMemoryError -> 0x01d3, blocks: (B:70:0x01c0, B:72:0x01eb, B:83:0x01d8, B:85:0x01e0, B:87:0x01e6, B:90:0x01f0, B:92:0x01f5, B:127:0x023b, B:130:0x0242, B:134:0x0254, B:136:0x025a, B:138:0x026b, B:139:0x0266, B:142:0x026e, B:144:0x0271), top: B:44:0x0128 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130 A[Catch: OutOfMemoryError -> 0x0220, Exception -> 0x0225, IllegalArgumentException -> 0x022b, TRY_LEAVE, TryCatch #20 {OutOfMemoryError -> 0x0220, blocks: (B:43:0x0126, B:48:0x012c, B:50:0x0130, B:55:0x014e), top: B:42:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r29, int r30, int r31, int r32, com.huawei.hms.ml.scan.HmsBuildBitmapOption r33) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.c5.a(java.lang.String, int, int, int, com.huawei.hms.ml.scan.HmsBuildBitmapOption):android.graphics.Bitmap");
    }
}
