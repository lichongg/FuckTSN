package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f26707j;

    private static void xt(Context context) {
        boolean z5;
        Intent registerReceiver;
        double d6 = -0.1d;
        try {
            registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (registerReceiver != null) {
            z5 = registerReceiver.getBooleanExtra("present", false);
            try {
                d6 = registerReceiver.getIntExtra("temperature", -1) / 10.0d;
            } catch (Throwable unused2) {
            }
            m.j(1006, new Object[]{Boolean.valueOf(z5), Double.valueOf(d6)});
        }
        z5 = true;
        m.j(1006, new Object[]{Boolean.valueOf(z5), Double.valueOf(d6)});
    }

    private static void cw(Context context) {
        int i6;
        int i7;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                i6 = 0;
                i7 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int intValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (intValue == 0) {
                        i6++;
                    } else if (intValue == 1) {
                        i7++;
                    }
                }
            } catch (Throwable unused) {
                i6 = -1;
                i7 = -1;
            }
        } else {
            i6 = -2;
            i7 = -2;
        }
        m.j(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i6), Integer.valueOf(i7)});
    }

    public static void j(Context context) {
        if (f26707j || context == null) {
            return;
        }
        xt(context);
        cw(context);
        r(context);
        up(context);
        f26707j = true;
    }

    private static void up(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        m.j(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }

    private static void r(Context context) {
        boolean z5;
        int i6;
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null && ((i6 = configuration.touchscreen) == 1 || i6 == 0)) {
            z5 = false;
        } else {
            z5 = true;
        }
        m.j(1008, new Object[]{Boolean.valueOf(z5)});
    }
}
