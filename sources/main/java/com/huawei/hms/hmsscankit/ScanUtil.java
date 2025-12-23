package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.ml.scan.HmsScanFrameOptions;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.c5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ScanUtil {
    public static final int CAMERA_INIT_ERROR = -1000;
    static final String CONTEXT_METHOD = "initializeModule";
    static final String CONTEXT_PATH = "com.huawei.hms.feature.DynamicModuleInitializer";
    static final String CREATOR_PATH = "com.huawei.hms.scankit.Creator";
    public static final int ERROR_ABNORMAL_RESTART = 3;
    public static final int ERROR_INVALID_PARAM = 4;
    public static final int ERROR_NO_CAMERA_PERMISSION = 1;
    public static final int ERROR_NO_READ_PERMISSION = 2;
    private static final int LITE_VERSION = 10320300;
    private static final int MAX_BITMAP_SIZE = 52428800;
    static final String MODULE_SCANKIT = "huawei_module_scankit";
    static final String MODULE_SCANKIT_LOCAL = "huawei_module_scankit_local";
    private static final int NEW_VERSION = 21002300;
    public static final String RESULT = "SCAN_RESULT";
    public static final String RESULT_CODE = "SCAN_RESULT_CODE";
    public static final int SCAN_NO_DETECTED = 4096;
    public static final int SUCCESS = 0;
    private static final int WR_VERSION = 201000300;

    private static HmsScanResult checkHmsScan(HmsScan[] hmsScanArr, HmsScanFrameOptions hmsScanFrameOptions) {
        return hmsScanArr.length == 0 ? new HmsScanResult(4096, null) : (hmsScanArr[0].getOriginalValue() != "" || hmsScanArr[0].getZoomValue() <= 1.0d) ? hmsScanArr[0].getOriginalValue() != "" ? new HmsScanResult(0, hmsScanArr) : new HmsScanResult(4096, hmsScanArr) : new HmsScanResult(4098, hmsScanArr);
    }

    private static boolean checkVersion(int i6, int i7) {
        if (i6 == LITE_VERSION && (i7 < NEW_VERSION || i7 == WR_VERSION)) {
            return true;
        }
        if (i6 != LITE_VERSION) {
            return i6 < NEW_VERSION || i7 == WR_VERSION || i7 < NEW_VERSION;
        }
        return false;
    }

    public static HmsScanResult decode(Context context, HmsScanFrame hmsScanFrame, HmsScanFrameOptions hmsScanFrameOptions) {
        if (hmsScanFrame == null || (hmsScanFrame.getYuvImage() == null && hmsScanFrame.getBitmap() == null)) {
            return new HmsScanResult(4, new HmsScan[0]);
        }
        o4.d("Scankit", "frame height " + hmsScanFrame.getHeight() + " width " + hmsScanFrame.getWidth());
        if (hmsScanFrame.getHeight() * hmsScanFrame.getHeight() > 52428800 || hmsScanFrame.getHeight() * hmsScanFrame.getHeight() == 0) {
            o4.e("ScanUtil", "input image is invalid:" + hmsScanFrame.getWidth() + " " + hmsScanFrame.getHeight());
            return new HmsScanResult(4, new HmsScan[0]);
        }
        try {
            if (g.f33755d == Integer.MIN_VALUE) {
                g.f33755d = g.a(context);
            }
            if (g.f33756e == Integer.MIN_VALUE) {
                g.f33756e = DynamicModule.getRemoteVersion(StubApp.getOrigApplicationContext(context.getApplicationContext()), MODULE_SCANKIT);
            }
        } catch (Exception unused) {
            o4.b("Scankit", "get remote version failed");
        }
        if (hmsScanFrameOptions != null && hmsScanFrameOptions.isMultiMode()) {
            HmsScan[] a6 = b.a(context, hmsScanFrame, new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(hmsScanFrameOptions.getType(), new int[0]).setPhotoMode(hmsScanFrameOptions.isPhotoMode()).setParseResult(hmsScanFrameOptions.isParseResult()).create());
            return a6.length == 0 ? new HmsScanResult(4096, a6) : (a6.length == 1 && a6[0].getZoomValue() > 1.0d && TextUtils.isEmpty(a6[0].getOriginalValue())) ? new HmsScanResult(4098, a6) : (a6.length < 1 || TextUtils.isEmpty(a6[0].getOriginalValue())) ? new HmsScanResult(4096, a6) : new HmsScanResult(0, a6);
        }
        HmsScanAnalyzerOptions create = hmsScanFrameOptions == null ? new HmsScanAnalyzerOptions.Creator().create() : new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(hmsScanFrameOptions.getType(), new int[0]).setPhotoMode(hmsScanFrameOptions.isPhotoMode()).setParseResult(hmsScanFrameOptions.isParseResult()).create();
        if (hmsScanFrame.getBitmap() != null) {
            return checkHmsScan(f.a(context, hmsScanFrame.getBitmap(), create), hmsScanFrameOptions);
        }
        if (hmsScanFrame.getYuvImage() == null) {
            return new HmsScanResult(4, new HmsScan[0]);
        }
        int i6 = g.f33755d;
        int i7 = g.f33756e;
        return checkVersion(g.f33755d, g.f33756e) ? f.a(context, hmsScanFrame, create) : f.a(context, hmsScanFrame.getYuvImage().getYuvData(), hmsScanFrame.getYuvImage().getWidth(), hmsScanFrame.getYuvImage().getHeight(), create);
    }

    public static boolean isScanAvailable(Context context) {
        return true;
    }

    public static Bitmap buildBitmap(String str, int i6, int i7, int i8, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        return new c5().a(str, i6, i7, i8, hmsBuildBitmapOption);
    }

    public static Bitmap compressBitmap(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        dealBitmapFactoryOption(context, options);
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0038: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:57), block:B:32:0x0037 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[Catch: Exception -> 0x0077, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0077, blocks: (B:25:0x005a, B:23:0x0067, B:14:0x0073), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap compressBitmapForAndroid29(android.content.Context r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "_id"
            java.lang.String r1 = "Exception"
            java.lang.String r2 = "exception"
            r3 = 0
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61 java.lang.NullPointerException -> L6b
            android.net.Uri r5 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61 java.lang.NullPointerException -> L6b
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61 java.lang.NullPointerException -> L6b
            java.lang.String r7 = "_data=?"
            java.lang.String[] r8 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61 java.lang.NullPointerException -> L6b
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61 java.lang.NullPointerException -> L6b
            if (r4 == 0) goto L3a
            boolean r6 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            if (r6 == 0) goto L3a
            int r11 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            int r11 = r4.getInt(r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            android.net.Uri r11 = android.net.Uri.withAppendedPath(r5, r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
        L34:
            r3 = r11
            goto L58
        L36:
            r0 = move-exception
            r10 = r0
            r3 = r4
            goto L8d
        L3a:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            r0.<init>(r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            if (r0 == 0) goto L58
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            r0.<init>()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            java.lang.String r6 = "_data"
            r0.put(r6, r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            android.content.ContentResolver r11 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            android.net.Uri r11 = r11.insert(r5, r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            goto L34
        L58:
            if (r4 == 0) goto L7a
            r4.close()     // Catch: java.lang.Exception -> L77
            goto L7a
        L5e:
            r0 = move-exception
            r10 = r0
            goto L8d
        L61:
            r4 = r3
        L62:
            com.huawei.hms.scankit.p.o4.b(r2, r1)     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L7a
            r4.close()     // Catch: java.lang.Exception -> L77
            goto L7a
        L6b:
            r4 = r3
        L6c:
            java.lang.String r11 = "NullPointerException"
            com.huawei.hms.scankit.p.o4.b(r2, r11)     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L7a
            r4.close()     // Catch: java.lang.Exception -> L77
            goto L7a
        L77:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
        L7a:
            android.graphics.BitmapFactory$Options r11 = new android.graphics.BitmapFactory$Options
            r11.<init>()
            r0 = 1
            r11.inJustDecodeBounds = r0
            getBitmapFromUri(r10, r3, r11)
            dealBitmapFactoryOption(r10, r11)
            android.graphics.Bitmap r10 = getBitmapFromUri(r10, r3, r11)
            return r10
        L8d:
            if (r3 == 0) goto L96
            r3.close()     // Catch: java.lang.Exception -> L93
            goto L96
        L93:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
        L96:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.compressBitmapForAndroid29(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void dealBitmapFactoryOption(android.content.Context r10, android.graphics.BitmapFactory.Options r11) {
        /*
            java.lang.String r0 = "exception"
            int r1 = r11.outWidth
            int r2 = r11.outHeight
            if (r1 == 0) goto L66
            if (r2 != 0) goto Lb
            goto L66
        Lb:
            if (r1 <= r2) goto Le
            r1 = r2
        Le:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L38
            java.lang.String r2 = "activity"
            java.lang.Object r10 = r10.getSystemService(r2)     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            android.app.ActivityManager r10 = (android.app.ActivityManager) r10     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            r2.<init>()     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            r10.getMemoryInfo(r2)     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            r6 = 4652218415073722368(0x4090000000000000, double:1024.0)
            r8 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r6 = java.lang.Math.pow(r6, r8)     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            long r2 = r2.totalMem     // Catch: java.lang.Exception -> L3c java.lang.NullPointerException -> L42
            double r2 = (double) r2
            double r2 = r2 / r6
            r6 = 4617878467915022336(0x4016000000000000, double:5.5)
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 >= 0) goto L3a
        L38:
            r10 = 1
            goto L48
        L3a:
            r10 = 0
            goto L48
        L3c:
            java.lang.String r10 = "Exception"
            com.huawei.hms.scankit.p.o4.b(r0, r10)
            goto L38
        L42:
            java.lang.String r10 = "NullPointerException"
            com.huawei.hms.scankit.p.o4.b(r0, r10)
            goto L38
        L48:
            if (r10 == 0) goto L4d
            r10 = 1200(0x4b0, float:1.682E-42)
            goto L4f
        L4d:
            r10 = 3000(0xbb8, float:4.204E-42)
        L4f:
            if (r1 <= r10) goto L59
            float r0 = (float) r1
            float r10 = (float) r10
            float r0 = r0 / r10
            int r10 = java.lang.Math.round(r0)
            goto L5a
        L59:
            r10 = 1
        L5a:
            r11.inSampleSize = r10
            r11.inJustDecodeBounds = r4
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            r11.inPreferredConfig = r10
            r11.inPurgeable = r5
            r11.inInputShareable = r5
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.dealBitmapFactoryOption(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }

    public static HmsScan[] decodeWithBitmap(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        if (bitmap != null && bitmap.getWidth() * bitmap.getHeight() <= 52428800) {
            return f.a(context, bitmap, hmsScanAnalyzerOptions);
        }
        if (bitmap != null) {
            o4.e("ScanUtil", "input image is too large:" + bitmap.getWidth());
        }
        return new HmsScan[0];
    }

    private static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            o4.a("ScanBitmap", "uri == null");
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, t.f36150k);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (FileNotFoundException unused) {
            o4.b("exception", "FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            o4.b("exception", "IOException");
            return null;
        } catch (Exception unused3) {
            o4.b("exception", "Exception");
            return null;
        }
    }

    public static boolean selfPermissionGranted(Context context, int i6, String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (i6 >= 23) {
            if (w7.a(str) == null) {
                return true;
            }
            checkSelfPermission = context.checkSelfPermission(str);
            if (checkSelfPermission != 0) {
                return false;
            }
        } else if (w7.a(context, str) != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int startScan(android.app.Activity r5, int r6, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r7) {
        /*
            java.lang.String r0 = "exception"
            java.lang.String r1 = "startScan before"
            java.lang.String r2 = "ScanUtil"
            com.huawei.hms.scankit.p.o4.d(r2, r1)
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            java.lang.String r3 = r5.getPackageName()     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            r4 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            int r0 = r1.targetSdkVersion     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            goto L29
        L1c:
            java.lang.String r1 = "RuntimeException"
            com.huawei.hms.scankit.p.o4.b(r0, r1)
            goto L27
        L22:
            java.lang.String r1 = "NameNotFoundException"
            com.huawei.hms.scankit.p.o4.b(r0, r1)
        L27:
            r0 = 28
        L29:
            java.lang.String r1 = "android.permission.CAMERA"
            boolean r0 = selfPermissionGranted(r5, r0, r1)
            boolean r1 = com.huawei.hms.scankit.p.w7.f34994c
            if (r1 != 0) goto L3a
            java.lang.String r5 = "startScan failed"
            com.huawei.hms.scankit.p.o4.d(r2, r5)
            r5 = 3
            return r5
        L3a:
            if (r0 != 0) goto L45
            if (r7 == 0) goto L43
            boolean r0 = r7.showGuide
            if (r0 == 0) goto L43
            goto L45
        L43:
            r5 = 1
            return r5
        L45:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.huawei.hms.hmsscankit.ScanKitActivity> r1 = com.huawei.hms.hmsscankit.ScanKitActivity.class
            r0.<init>(r5, r1)
            if (r7 == 0) goto L6a
            int r1 = r7.mode
            java.lang.String r3 = "ScanFormatValue"
            r0.putExtra(r3, r1)
            int r1 = r7.viewType
            java.lang.String r3 = "ScanViewValue"
            r0.putExtra(r3, r1)
            boolean r1 = r7.errorCheck
            java.lang.String r3 = "ScanErrorCheck"
            r0.putExtra(r3, r1)
            boolean r7 = r7.showGuide
            java.lang.String r1 = "ScanGuide"
            r0.putExtra(r1, r7)
        L6a:
            java.lang.String r7 = "startScan success"
            com.huawei.hms.scankit.p.o4.d(r2, r7)
            r7 = 0
            com.huawei.hms.scankit.p.w7.f34994c = r7
            r5.startActivityForResult(r0, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.startScan(android.app.Activity, int, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions):int");
    }

    public static HmsScan[] detectForHmsDector(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return b.a(context, mLFrame, hmsScanAnalyzerOptions);
    }
}
