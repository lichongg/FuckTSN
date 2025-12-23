package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class al {
    public static boolean a(Context context) {
        try {
            String[] strArr = {"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/no-silent.jpg", "/storage/emulated/0/DCIM/Camera1/disable.jpg", "/storage/emulated/0/DCIM/Camera1/no_toast.jpg"};
            for (int i6 = 0; i6 < 5; i6++) {
                if (new File(strArr[i6]).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] strArr = {"/system/lib/.aa", "/sdcard/my/34.png", "/sdcard/my/do_not_change.txt", "/sdcard/my/34.mp4", "/sdcard/my/44.mp4", "/sdcard/QQ=99932701/", "/sdcard/QQ=99932701/Dict.txt"};
            int i6 = 0;
            for (int i7 = 0; i7 < 7; i7++) {
                if (new File(strArr[i7]).exists()) {
                    i6 |= 1 << i7;
                }
            }
            if (i6 > 0) {
                jSONObject.put("files", i6);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static int c() {
        String[] strArr = {"/system/lib.aa", "/system/lib/ccc"};
        int i6 = 0;
        for (int i7 = 0; i7 < 2; i7++) {
            try {
                if (new File(strArr[i7]).exists()) {
                    i6 |= 1 << i7;
                }
            } catch (Exception unused) {
            }
        }
        return i6;
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] strArr = {"persist.sys.virtual_camera_flag", "persist.sys.camera_type", "persist.sys.camera_rotation"};
            int i6 = 0;
            for (int i7 = 0; i7 < 3; i7++) {
                String a6 = aa.a().a(strArr[i7]);
                if (!TextUtils.isEmpty(a6)) {
                    String str = strArr[i7];
                    jSONObject.put(str.substring(str.lastIndexOf(46) + 1), a6);
                }
            }
            try {
                Class.forName("android.hardware.mockcamera.MockCamera");
                jSONObject.put("MockCamera", 1);
            } catch (ClassNotFoundException unused) {
            }
            String[] strArr2 = {"/sdcard/.imei.txt", "/sdcard/key.txt", "/sdcard/video/1.mp4", "/sdcard/video/test.txt", "/sdcard/video/.aa", "/sdcard/video/.new", "/sdcard/video/.old"};
            for (int i8 = 2; i8 < 7; i8++) {
                if (new File(strArr2[i8]).exists()) {
                    i6 |= 1 << i8;
                }
            }
            if (i6 > 0) {
                jSONObject.put("files", i6);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static JSONObject b(Context context) {
        String[] strArr = {"/sdcard/my/44.mp4", "/system/lib/lic"};
        String[] strArr2 = {"com.yky"};
        JSONObject jSONObject = new JSONObject();
        try {
            int a6 = bp.a(strArr);
            if (a6 > 0) {
                jSONObject.put("f", a6);
            }
            PackageManager packageManager = context.getPackageManager();
            for (int i6 = 0; i6 <= 0; i6++) {
                try {
                    packageManager.getApplicationInfo(strArr2[0], 0);
                    jSONObject.put(strArr2[0], 1);
                } catch (PackageManager.NameNotFoundException | JSONException unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }
}
