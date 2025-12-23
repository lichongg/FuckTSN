package com.bytedance.sdk.openadsdk.az;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.umeng.analytics.pro.bi;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {

    /* renamed from: j, reason: collision with root package name */
    public static j f27694j;

    /* renamed from: m, reason: collision with root package name */
    private static SensorManager f27695m;
    protected static final float[] xt = new float[3];
    protected static final float[] cw = new float[3];

    /* renamed from: r, reason: collision with root package name */
    protected static final float[] f27696r = new float[9];
    protected static final float[] up = new float[3];

    private static int j(int i6) {
        if (i6 == 0 || i6 == 1 || i6 == 2 || i6 == 3) {
            return i6;
        }
        return 2;
    }

    public static void cw(Context context, SensorEventListener sensorEventListener, int i6) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (j()) {
                return;
            }
            j jVar = f27694j;
            if (jVar == null || !jVar.cw()) {
                SensorManager j6 = j(context);
                j6.registerListener(sensorEventListener, j6.getDefaultSensor(10), j(i6));
            }
        } catch (Throwable th) {
            ae.j("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void j(j jVar) {
        f27694j = jVar;
    }

    public static void r(Context context, SensorEventListener sensorEventListener, int i6) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (j()) {
                return;
            }
            j jVar = f27694j;
            if (jVar == null || !jVar.cw()) {
                SensorManager j6 = j(context);
                j6.registerListener(sensorEventListener, j6.getDefaultSensor(1), j(i6));
                j6.registerListener(sensorEventListener, j6.getDefaultSensor(2), j(i6));
            }
        } catch (Throwable th) {
            ae.j("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void xt(Context context, SensorEventListener sensorEventListener, int i6) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (j()) {
                return;
            }
            j jVar = f27694j;
            if (jVar == null || !jVar.cw()) {
                SensorManager j6 = j(context);
                j6.registerListener(sensorEventListener, j6.getDefaultSensor(4), j(i6));
            }
        } catch (Throwable th) {
            ae.j("SensorHub", "startListenGyroscope error", th);
        }
    }

    private static SensorManager j(Context context) {
        if (f27695m == null) {
            synchronized (oq.class) {
                try {
                    if (f27695m == null) {
                        f27695m = (SensorManager) context.getSystemService(bi.ac);
                    }
                } finally {
                }
            }
        }
        return f27695m;
    }

    private static boolean j() {
        j jVar = f27694j;
        return jVar == null || !jVar.xt();
    }

    public static void j(Context context, SensorEventListener sensorEventListener, int i6) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (j()) {
                return;
            }
            j jVar = f27694j;
            if (jVar == null || !jVar.cw()) {
                SensorManager j6 = j(context);
                j6.registerListener(sensorEventListener, j6.getDefaultSensor(1), j(i6));
            }
        } catch (Throwable th) {
            ae.j("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void j(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            j(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            ae.j("SensorHub", "stopListen error", th);
        }
    }

    public static void j(Context context, long j6) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j6);
    }
}
