package com.bytedance.sdk.openadsdk.az;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    public static int ae = 1;
    protected static int cw = 1;

    /* renamed from: g, reason: collision with root package name */
    public static int f27740g = 4;

    /* renamed from: j, reason: collision with root package name */
    protected static String f27741j = "images";

    /* renamed from: m, reason: collision with root package name */
    public static int f27742m = 0;
    public static int oq = 8;
    public static int qv = 16;

    /* renamed from: r, reason: collision with root package name */
    protected static int f27743r = 30;
    public static int tl = 2;
    protected static long up = 15360;
    public static int vl = 32;
    protected static String xt;

    protected static boolean j(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    protected static Bitmap xt(String str) {
        byte[] decode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    @RequiresApi(api = 23)
    public static boolean xt(Context context, String str) {
        int checkSelfPermission;
        checkSelfPermission = context.checkSelfPermission(str);
        return checkSelfPermission == 0;
    }

    protected static File j() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + f27741j);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            xt = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    protected static File j(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + "_" + calendar.get(13) + "_" + calendar.get(14)) + "_" + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    protected static File j(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File j6 = j(str);
            if (j6 != null && j6.exists()) {
                byte[] decode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(j6);
                try {
                    fileOutputStream.write(decode, 0, decode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                        return j6;
                    } catch (IOException e6) {
                        vl.j(e6);
                        return j6;
                    }
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            vl.j(e7);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e8) {
                            vl.j(e8);
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean j(Context context, int i6) {
        boolean j6;
        boolean j7;
        if (f27742m == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                j6 = j(context, "android.permission.READ_MEDIA_IMAGES");
                j7 = true;
            } else {
                j6 = j(context, com.kuaishou.weapon.p0.g.f36049i);
                j7 = j(context, com.kuaishou.weapon.p0.g.f36050j);
            }
            boolean j8 = j(context, "android.permission.CAMERA");
            boolean j9 = j(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (j6 && j7) {
                f27742m |= ae;
            }
            if (j8 && packageManager.hasSystemFeature("android.hardware.camera")) {
                f27742m |= tl;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                f27742m |= f27740g;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                f27742m |= oq;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                f27742m |= qv;
            }
            if (j9 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                f27742m |= vl;
            }
        }
        return (f27742m & i6) != 0;
    }

    @RequiresApi(api = 23)
    public static boolean j(Context context) {
        int checkSelfPermission;
        boolean z5;
        int checkSelfPermission2;
        boolean z6;
        int checkSelfPermission3;
        if (Build.VERSION.SDK_INT >= 33) {
            checkSelfPermission3 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES");
            z5 = checkSelfPermission3 == 0;
        } else {
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36049i);
            z5 = checkSelfPermission == 0;
            checkSelfPermission2 = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36050j);
            if (checkSelfPermission2 != 0) {
                z6 = false;
                return !z6 && z5;
            }
        }
        z6 = true;
        if (z6) {
        }
    }
}
