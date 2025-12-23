package com.huawei.hms.scankit.p;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class w7 {

    /* renamed from: a, reason: collision with root package name */
    private static String f34992a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f34993b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f34994c = true;

    public static boolean a(int[][] iArr, int i6) {
        return i6 >= 0 && i6 < iArr.length;
    }

    public static int b(int i6) {
        if (i6 == 8191) {
            return HmsScanBase.ALL_SCAN_TYPE;
        }
        if (i6 == HmsScanBase.QRCODE_SCAN_TYPE) {
            return 256;
        }
        if (i6 == HmsScanBase.AZTEC_SCAN_TYPE) {
            return 4096;
        }
        if (i6 == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
            return 16;
        }
        if (i6 == HmsScanBase.PDF417_SCAN_TYPE) {
            return 2048;
        }
        if (i6 == HmsScanBase.CODE39_SCAN_TYPE) {
            return 2;
        }
        if (i6 == HmsScanBase.CODE93_SCAN_TYPE) {
            return 4;
        }
        if (i6 == HmsScanBase.CODE128_SCAN_TYPE) {
            return 1;
        }
        if (i6 == HmsScanBase.EAN13_SCAN_TYPE) {
            return 32;
        }
        if (i6 == HmsScanBase.EAN8_SCAN_TYPE) {
            return 64;
        }
        if (i6 == HmsScanBase.ITF14_SCAN_TYPE) {
            return 128;
        }
        if (i6 == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
            return 512;
        }
        if (i6 == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return 1024;
        }
        if (i6 == HmsScanBase.CODABAR_SCAN_TYPE) {
            return 8;
        }
        if (i6 == HmsScanBase.WX_SCAN_TYPE) {
            return 16384;
        }
        if (i6 == HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE) {
            return 8192;
        }
        return i6;
    }

    public static boolean c(Context context) {
        if (b(context) && TextUtils.isEmpty(f34993b)) {
            f34993b = context.getSharedPreferences("scanExt", 0).getString("scanExt", "unSet");
        }
        return "forbid".equals(f34993b);
    }

    public static int d(Context context) {
        int identifier;
        if (context.getResources() == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS)) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean e() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty(com.acse.ottn.l3.f4736f, "sys.hw_multiwin_for_camera", "android.os.SystemProperties", "UNKNOWN"));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT < 24 || !(context instanceof Activity)) {
            return false;
        }
        isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
        return isInMultiWindowMode;
    }

    public static boolean g(Context context) {
        try {
            return com.huawei.hms.feature.dynamic.f.e.f33257e.equalsIgnoreCase(SystemPropUtils.getProperty(com.acse.ottn.l3.f4736f, "ro.hw.country", "android.os.SystemProperties", "UNKNOWN"));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean a(int[] iArr, int i6) {
        return i6 >= 0 && i6 < iArr.length;
    }

    public static boolean f() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals("samsung");
    }

    public static boolean h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 5.5d;
    }

    public static boolean i(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 8.0d && ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels) > 1.3f;
    }

    public static boolean j(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
    }

    public static boolean a(byte[] bArr, int i6) {
        return i6 >= 0 && i6 < bArr.length;
    }

    public static boolean k(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), a(), 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean a(byte[][] bArr, int i6) {
        return i6 >= 0 && i6 < bArr.length;
    }

    public static boolean d() {
        return "ar".equals(Locale.getDefault().getLanguage()) || "ur".equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()) || "fa".equals(Locale.getDefault().getLanguage());
    }

    public static boolean e(Context context) {
        String configuration = context.getResources().getConfiguration().toString();
        return configuration.contains("hwMultiwindow-magic") || configuration.contains("hw-magic-windows");
    }

    public static boolean a(String[] strArr, int i6) {
        return i6 >= 0 && i6 < strArr.length;
    }

    public static boolean c(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public static boolean a(float[] fArr, int i6) {
        return i6 >= 0 && i6 < fArr.length;
    }

    public static boolean c() {
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("honor");
    }

    public static HmsScan[] a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null && hmsScanArr.length != 0) {
            for (HmsScan hmsScan : hmsScanArr) {
                if (hmsScan != null) {
                    hmsScan.scanType = b(hmsScan.scanType);
                }
            }
        }
        return hmsScanArr;
    }

    public static int a(int i6) {
        if (i6 <= 0) {
            return HmsScanBase.ALL_SCAN_TYPE;
        }
        if (((i6 - 1) & i6) == 0) {
            return i6;
        }
        int i7 = HmsScanBase.AZTEC_SCAN_TYPE;
        int b6 = (i6 & i7) != 0 ? b(i7) : 0;
        int i8 = HmsScanBase.CODABAR_SCAN_TYPE;
        if ((i6 & i8) != 0) {
            b6 |= b(i8);
        }
        int i9 = HmsScanBase.CODE39_SCAN_TYPE;
        if ((i6 & i9) != 0) {
            b6 |= b(i9);
        }
        int i10 = HmsScanBase.CODE93_SCAN_TYPE;
        if ((i6 & i10) != 0) {
            b6 |= b(i10);
        }
        int i11 = HmsScanBase.CODE128_SCAN_TYPE;
        if ((i6 & i11) != 0) {
            b6 |= b(i11);
        }
        int i12 = HmsScanBase.DATAMATRIX_SCAN_TYPE;
        if ((i6 & i12) != 0) {
            b6 |= b(i12);
        }
        int i13 = HmsScanBase.EAN8_SCAN_TYPE;
        if ((i6 & i13) != 0) {
            b6 |= b(i13);
        }
        int i14 = HmsScanBase.EAN13_SCAN_TYPE;
        if ((i6 & i14) != 0) {
            b6 |= b(i14);
        }
        int i15 = HmsScanBase.QRCODE_SCAN_TYPE;
        if ((i6 & i15) != 0) {
            b6 |= b(i15);
        }
        int i16 = HmsScanBase.ITF14_SCAN_TYPE;
        if ((i6 & i16) != 0) {
            b6 |= b(i16);
        }
        int i17 = HmsScanBase.PDF417_SCAN_TYPE;
        if ((i6 & i17) != 0) {
            b6 |= b(i17);
        }
        int i18 = HmsScanBase.UPCCODE_A_SCAN_TYPE;
        if ((i6 & i18) != 0) {
            b6 |= b(i18);
        }
        int i19 = HmsScanBase.UPCCODE_E_SCAN_TYPE;
        if ((i6 & i19) != 0) {
            b6 |= b(i19);
        }
        int i20 = HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE;
        if ((i6 & i20) != 0) {
            b6 |= b(i20);
        }
        int i21 = HmsScanBase.WX_SCAN_TYPE;
        return (i6 & i21) != 0 ? b(i21) | b6 : b6;
    }

    public static boolean b() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty(com.acse.ottn.l3.f4736f, "sys.multiwin_for_camera", "android.os.SystemProperties", "UNKNOWN"));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean b(Activity activity) {
        return a(activity) == 102;
    }

    public static boolean b(Context context) {
        if (TextUtils.isEmpty(f34992a)) {
            try {
                f34992a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("scanExt", "unSet");
            } catch (PackageManager.NameNotFoundException | Exception unused) {
            }
        }
        return "readUri".equals(f34992a);
    }

    private static String b(Context context, Intent intent) {
        Uri data = new Intent(intent).getData();
        if (DocumentsContract.isDocumentUri(context, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            }
            if ("com.android.providers.downloads.documents".equals(data.getAuthority())) {
                try {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), (String) null);
                } catch (NumberFormatException unused) {
                    o4.b("ScankitUtils", "NumberFormatException in withAppendedId");
                    return null;
                } catch (Exception unused2) {
                    o4.b("ScankitUtils", "Exception in withAppendedId");
                    return null;
                }
            }
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            return a(context, data, (String) null);
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int i6, int i7) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        return a(bitmap, i6 / bitmap.getWidth(), i7 / bitmap.getHeight());
    }

    public static Bitmap a(Bitmap bitmap, float f6, float f7) {
        if (f6 <= 0.0f || f7 <= 0.0f) {
            return null;
        }
        float f8 = 1.0f / f6;
        float f9 = 1.0f / f7;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i6 = (int) (width * f6);
        int i7 = (int) (height * f7);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i6 * i7];
        for (int i8 = 0; i8 < i7; i8++) {
            for (int i9 = 0; i9 < i6; i9++) {
                iArr2[(i8 * i6) + i9] = iArr[(((int) (i8 * f9)) * width) + ((int) (i9 * f8))];
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, i6, 0, 0, i6, i7);
        return createBitmap;
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == -1 ? -1 : 0;
    }

    public static String a(String str) {
        String permissionToOp;
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        permissionToOp = AppOpsManager.permissionToOp(str);
        return permissionToOp;
    }

    private static String a() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        }
        return (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase("OPPO")) ? "navigation_gesture_on" : "navigationbar_is_min";
    }

    public static ResolveInfo a(Intent intent, String str, Activity activity) {
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.isEmpty()) {
            return null;
        }
        return queryIntentActivities.get(0);
    }

    public static boolean a(String str, Activity activity) {
        PackageInfo packageInfo;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            o4.d("Utils", "NameNotFoundException Exception");
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        int i6 = packageInfo.applicationInfo.flags;
        return ((i6 & 1) == 1) || ((i6 & 128) == 1);
    }

    public static int a(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActivityManagerEx");
            Method declaredMethod = cls.getDeclaredMethod("getActivityWindowMode", Activity.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, activity);
            if (invoke == null) {
                return -1;
            }
            return Integer.valueOf(String.valueOf(invoke)).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NumberFormatException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f6) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f6, width / 2, height / 2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!createBitmap.equals(bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i6) {
        if (i6 == 0) {
            return a(bitmap, 90.0f);
        }
        if (i6 != 2) {
            return i6 != 3 ? bitmap : a(bitmap, 180.0f);
        }
        return a(bitmap, 270.0f);
    }

    public static Bitmap a(Context context, Intent intent) {
        Bitmap a6;
        Bitmap compressBitmap;
        if (!b(context)) {
            String b6 = b(context, intent);
            if (TextUtils.isEmpty(b6)) {
                return null;
            }
            if (Build.VERSION.SDK_INT > 28 && context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion > 28) {
                o4.a("ScanBitmap", "compressBitmap above android 29");
                compressBitmap = ScanUtil.compressBitmapForAndroid29(context, b6);
            } else {
                o4.a("ScanBitmap", "compressBitmap below android 29");
                compressBitmap = ScanUtil.compressBitmap(context, b6);
            }
            if (compressBitmap != null) {
                return compressBitmap;
            }
            o4.a("ScanBitmap", "compressBitmap above android 29");
            return ScanUtil.compressBitmapForAndroid29(context, b6);
        }
        Uri data = intent.getData();
        if (data == null || (a6 = a(context, data)) == null) {
            return null;
        }
        return a6;
    }

    private static String a(Context context, Uri uri, String str) {
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, null, null);
            if (query != null) {
                r8 = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
                query.close();
            }
            return r8;
        } catch (IllegalStateException unused) {
            o4.b("ScankitUtils", "IllegalStateException in getImagePath");
            return null;
        } catch (Exception unused2) {
            o4.b("ScankitUtils", "Exception in getImagePath");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "IOException in getImagePath"
            java.lang.String r1 = "ScankitUtils"
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3 = 1
            r2.inJustDecodeBounds = r3
            android.content.Context r3 = r7.getApplicationContext()
            android.content.Context r3 = com.stub.StubApp.getOrigApplicationContext(r3)
            android.content.ContentResolver r3 = r3.getContentResolver()
            r4 = 0
            java.io.InputStream r8 = r3.openInputStream(r8)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            if (r8 == 0) goto L3b
            byte[] r3 = a(r8)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L44
            int r5 = r3.length     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L44
            r6 = 0
            android.graphics.BitmapFactory.decodeByteArray(r3, r6, r5, r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L44
            a(r7, r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L44
            int r7 = r3.length     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L44
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r3, r6, r7, r2)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L44
            r8.close()     // Catch: java.io.IOException -> L34
            return r7
        L34:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
            return r7
        L38:
            r7 = move-exception
            r4 = r8
            goto L53
        L3b:
            if (r8 == 0) goto L52
            r8.close()     // Catch: java.io.IOException -> L4f
            goto L52
        L41:
            r7 = move-exception
            goto L53
        L43:
            r8 = r4
        L44:
            java.lang.String r7 = "compressBitmapFromUri IOException"
            com.huawei.hms.scankit.p.o4.b(r1, r7)     // Catch: java.lang.Throwable -> L38
            if (r8 == 0) goto L52
            r8.close()     // Catch: java.io.IOException -> L4f
            goto L52
        L4f:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L52:
            return r4
        L53:
            if (r4 == 0) goto L5c
            r4.close()     // Catch: java.io.IOException -> L59
            goto L5c
        L59:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L5c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.content.Context, android.net.Uri):android.graphics.Bitmap");
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r10, android.graphics.BitmapFactory.Options r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }

    public static boolean a(Context context) {
        return b(context) || context.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0;
    }
}
